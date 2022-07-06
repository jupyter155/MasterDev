import com.sun.org.apache.xerces.internal.util.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;

public class Driver {
    public static class PeopleMapper extends Mapper
            <LongWritable, Text, ProductIdKey, JoinGenericWritable> {
        private HashMap<Integer, String> productSubCategories = new HashMap<Integer, String>();

        private void readProductSubcategoriesFile(URI uri) throws IOException{
            List<String> lines = FileUtils.readLines(new File(uri));
            for (String line : lines) {
                String[] recordFields = line.split("\\t");
                int key = Integer.parseInt(recordFields[0]);
                String productSubcategoryName = recordFields[2];
                productSubCategories.put(key, productSubcategoryName);
            }
        }

        public void setup(Mapper.Context context) throws IOException, IOException {
            URI[] uris = context.getCacheFiles();
            readProductSubcategoriesFile(uris[0]);
        }

        public void map(LongWritable key, Text value, Context context) throws IOException,
                InterruptedException{
            String[] recordFields = value.toString().split("\\t");
            int productId = Integer.parseInt(recordFields[0]);
            int productSubcategoryId = recordFields[18].length() > 0 ?
                    Integer.parseInt(recordFields[18]) : 0;

            String productName = recordFields[1];
            String productNumber = recordFields[2];

            String productSubcategoryName = productSubcategoryId > 0 ?
                    productSubCategories.get(productSubcategoryId) : "";

            ProductIdKey recordKey = new ProductIdKey(productId, ProductIdKey.PRODUCT_RECORD);
            ProductRecord record = new ProductRecord
                    (productName, productNumber, productSubcategoryName);
            JoinGenericWritable genericRecord = new JoinGenericWritable(record);
            context.write(recordKey, genericRecord);
        }
        public static class JoinRecuder extends Reducer
                <ProductIdKey, JoinGenericWritable, NullWritable, Text>{
            public void reduce(ProductIdKey key, Iterable<JoinGenericWritable> values,
                               Context context) throws IOException, InterruptedException{
                StringBuilder output = new StringBuilder();
                int sumOrderQty = 0;
                double sumLineTotal = 0.0;

                for (JoinGenericWritable v : values) {
                    Writable record = v.get();
                    if (key.recordType.equals(ProductIdKey.PRODUCT_RECORD)){
                        ProductRecord pRecord = (ProductRecord)record;
                        output.append(Integer.parseInt(key.productId.toString())).append(", ");
                        output.append(pRecord.productName.toString()).append(", ");
                        output.append(pRecord.productNumber.toString()).append(", ");
                        output.append(pRecord.productSubcategoryName.toString()).append(", ");
                    } else {
                        SalesOrderDataRecord record2 = (SalesOrderDataRecord)record;
                        sumOrderQty += Integer.parseInt(record2.orderQty.toString());
                        sumLineTotal += Double.parseDouble(record2.lineTotal.toString());
                    }
                }
                if (sumOrderQty > 0) {
                    context.write(NullWritable.get(), new Text(output.toString() +
                            sumOrderQty + ", " + sumLineTotal));
                }
            }
        }
        public int run(String[] allArgs) throws Exception {
            String[] args = new GenericOptionsParser(getConf(), allArgs).getRemainingArgs();

            Job job = Job.getInstance(getConf());
            job.setJarByClass(Driver.class);

            job.setInputFormatClass(TextInputFormat.class);
            job.setOutputFormatClass(TextOutputFormat.class);

            job.setMapOutputKeyClass(ProductIdKey.class);
            job.setMapOutputValueClass(JoinGenericWritable.class);

            MultipleInputs.addInputPath(job, new Path(args[0]),
                    TextInputFormat.class, SalesOrderDataMapper.class);
            MultipleInputs.addInputPath(job, new Path(args[1]),
                    TextInputFormat.class, ProductMapper.class);

            job.setReducerClass(JoinRecuder.class);

            job.setSortComparatorClass(JoinSortingComparator.class);
            job.setGroupingComparatorClass(JoinGroupingComparator.class);

            job.setOutputKeyClass(NullWritable.class);
            job.setOutputValueClass(Text.class);

            FileOutputFormat.setOutputPath(job, new Path(allArgs[2]));
            boolean status = job.waitForCompletion(true);
            if (status) {
                return 0;
            } else {
                return 1;
            }
        }
        public static void main(String[] args) throws Exception{
            Configuration conf = new Configuration();
            int res = ToolRunner.run(new Driver(), args);
        }
    }

}
