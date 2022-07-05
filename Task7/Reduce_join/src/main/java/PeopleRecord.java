import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class PeopleRecord implements Writable {
    public Text id = new Text();
    public Text first_name = new Text();
    public Text last_name = new Text();
    public Text age = new Text();
    public Text street = new Text();
    public Text city = new Text();
    public Text state = new Text();
    public Text zip = new Text();

    public PeopleRecord(){}

    public PeopleRecord(String id, String first_name, String last_name, String age, String street, String city, String state, String zip) {
        this.id.set(id);
        this.first_name.set(first_name);
        this.last_name.set(last_name);
        this.age.set(age);
        this.street.set(street);
        this.city.set(city);
        this.state.set(state);
        this.zip.set(zip);
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
    }
}
