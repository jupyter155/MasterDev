package src.main.java;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import java.util.List;

public class Serialize {
    public static void main(String args[]) throws IOException {

        Person person = new Person();
        PeopleList peopleList = new PeopleList();
        List<Person> people = new ArrayList<>();

        person.setFirstName(" Minh ");
        person.setLastName("Nguyen ");
        person.setEmail("abc@gmail.com");
        person.setAction(Suit.DIAMONDS);
        person.setGender(Gender.MALE);
        people.add(person);
        peopleList.setPeople(people);
        peopleList.setVersion(1);

        //Instantiate DatumWriter class
        DatumWriter<PeopleList> empDatumWriter = new SpecificDatumWriter<PeopleList>(PeopleList.class);
        DataFileWriter<PeopleList> empFileWriter = new DataFileWriter<PeopleList>(empDatumWriter);
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        empFileWriter.create(peopleList.getSchema(), new File(s + "/src/main/java/src/main/java/emp.avro"));
        System.out.println(s);

        empFileWriter.append(peopleList);

        empFileWriter.close();

        System.out.println("data successfully serialized");
    }
}
