
import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;

public class Driver {
    public static class PeopleMapper extends Mapper<LongWritable,
            Text, IntWritable, Text> {
        private HashMap<String, Integer> salaryMaps = new HashMap<String, Integer>();
        private void readSalaryFile(URI uri) throws IOException{
            List<String> lines = FileUtils.readLines(new File(uri));
            for (String line : lines) {
                String[] recordFields = line.split(",");
                if (!recordFields[0].equals("job")) {
                    String job = recordFields[0];
                    int salary = Integer.parseInt(recordFields[1]);
                    salaryMaps.put(job, salary);
                }
            }
        }

        public void setup(Context context) throws IOException{
            URI[] uris = context.getCacheFiles();
            readSalaryFile(uris[0]);
        }

        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] recordFields = value.toString().split(",");
            if (!recordFields[0].equals("id")) {
                int id = Integer.parseInt(recordFields[0]);
                String first_name = recordFields[1];
                String last_name = recordFields[2];
                int age = Integer.parseInt(recordFields[3]);
                String street = recordFields[4];
                String city = recordFields[5];
                String state = recordFields[6];
                int zip = Integer.parseInt(recordFields[7]);
                String job = recordFields[8];

                PeopleRecord record = new PeopleRecord(id, first_name, last_name, age, street, city, state, zip, job, salaryMaps.get(job));
                context.write(new IntWritable(id), new Text(record.toString()));
            }
        }
    }
    public static class JoinRecuder extends Reducer
            <IntWritable, Text, NullWritable, Text> {
        StringBuilder output = new StringBuilder();

        public void setup(Reducer.Context context) throws IOException{
            output.append("id,first_name,last_name,age,street,city,state,zip,job,salary\n");
        }

        public void reduce(IntWritable key, Iterable<Text> values,
                           Context context) throws IOException, InterruptedException{
            for (Text v : values) {
                output.append(v.toString()).append("\n");
            }
        }
        public void cleanup(Reducer.Context context) throws IOException, InterruptedException {
            context.write(NullWritable.get(), new Text(output.toString()));
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf, "Join_during_Map");
        job.setJarByClass(Driver.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        job.setMapOutputKeyClass(IntWritable.class);
        job.setMapOutputValueClass(Text.class);

        job.setMapperClass(PeopleMapper.class);
        FileSystem fs = FileSystem.get(conf);

        FileInputFormat.addInputPath(job, new Path(args[1]));
        job.addCacheFile(new File(args[0]).toURI());
        job.setReducerClass(JoinRecuder.class);
        job.setNumReduceTasks(1);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Text.class);

        if (fs.exists(new Path(args[2]))) {
            fs.delete(new Path(args[2]), true);
        }
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}

