package src.main.java;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;
public class Deserialize {
    public static void main(String args[]) throws IOException{

        //DeSerializing the objects
        DatumReader<PeopleList> empDatumReader = new SpecificDatumReader<PeopleList>(PeopleList.class);
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        //Instantiating DataFileReader
        DataFileReader<PeopleList> dataFileReader = new DataFileReader<PeopleList>(new
                File(s+ "/src/main/java/src/main/java/emp.avro"), empDatumReader);
        PeopleList emp=null;

        while(dataFileReader.hasNext()){

            emp=dataFileReader.next(emp);
            System.out.println(emp);
        }
    }
}
