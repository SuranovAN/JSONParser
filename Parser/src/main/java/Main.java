import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        List<Employee> list = ParserCSV.parseCSV(columnMapping, fileName);
        String json = ParserJSON.listToJson(list);
        File jsonFile = new File("data.json");
        try(FileWriter fw = new FileWriter(jsonFile)) {
            jsonFile.createNewFile();
            fw.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Employee> list2 = ParserXML.parseXML("data.xml");
        String json2 = ParserJSON.listToJson(list2);
        File jsonFile2 = new File("data2.json");
        try(FileWriter fw = new FileWriter(jsonFile2)) {
            jsonFile.createNewFile();
            fw.write(json2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}