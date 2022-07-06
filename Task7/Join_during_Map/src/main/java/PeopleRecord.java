import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PeopleRecord implements Writable {
    public IntWritable id = new IntWritable();
    public Text first_name = new Text();
    public Text last_name = new Text();
    public IntWritable age = new IntWritable();
    public Text street = new Text();
    public Text city = new Text();
    public Text state = new Text();
    public IntWritable zip = new IntWritable();
    public Text job = new Text();
    public IntWritable salary = new IntWritable();
    public PeopleRecord(){}

    public PeopleRecord(int id, String first_name, String last_name, int age, String street, String city, String state, int zip, String job, int salary ) {
        this.id.set(id);
        this.first_name.set(first_name);
        this.last_name.set(last_name);
        this.age.set(age);
        this.street.set(street);
        this.city.set(city);
        this.state.set(state);
        this.zip.set(zip);
        this.job.set(job);
        this.salary.set(salary);
    }


    public void write(DataOutput out) throws IOException {
        this.id.write(out);
        this.first_name.write(out);
        this.last_name.write(out);
        this.age.write(out);
        this.street.write(out);
        this.city.write(out);
        this.state.write(out);
        this.zip.write(out);
        this.job.write(out);
        this.salary.write(out);
    }

    public void readFields(DataInput in) throws IOException {
        this.id.readFields(in);
        this.first_name.readFields(in);
        this.last_name.readFields(in);
        this.age.readFields(in);
        this.street.readFields(in);
        this.city.readFields(in);
        this.state.readFields(in);
        this.zip.readFields(in);
        this.job.readFields(in);
        this.salary.readFields(in);
    }
    public String toString() {
        return id + ", " + first_name + ", " + last_name + ", " + age +", "+ street + ", " + city + ", " + state + ", " + zip +", "+ job+ ", "+ salary;
    }
}
