import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        List<Employee> list = ParserCSV.parseCSV(columnMapping, fileName);
        String json = ParserJSON.listToJson(list);
        ParserJSON.convertToJSON(json, "data.Json");

        List<Employee> list2 = ParserXML.parseXML("data.xml");
        String json2 = ParserJSON.listToJson(list2);
        ParserJSON.convertToJSON(json2, "data2.json");

        String json3 = ParserJSON.readString("new_data.json");
    }
}