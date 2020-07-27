import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ParserJSON {
    public static <T> String listToJson(List<Employee> list) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Type listType = new TypeToken<List<T>>() {
        }.getType();
        return gson.toJson(list, listType);
    }

    public static void convertToJSON(String JSONData, String fileName) {
        File jsonFile = new File(fileName);
        try (FileWriter fw = new FileWriter(jsonFile)) {
            jsonFile.createNewFile();
            fw.write(JSONData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readString(String fileName) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        return jsonArray.toJSONString();
    }

    public static List<Employee> jsonToList(String jsonData) throws ParseException {
        List<Employee> list = new ArrayList<>();
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        JSONParser parser = new JSONParser();
        JSONArray arr = (JSONArray) parser.parse(jsonData);
        for (int i = 0; i < arr.size(); i++) {
            Employee employee = gson.fromJson(arr.get(i).toString(), Employee.class);
            list.add(employee);
        }
        return list;
    }
}