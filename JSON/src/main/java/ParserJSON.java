import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class ParserJSON {
    public static <T> String listToJson(List<Employee> list) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Type listType = new TypeToken<List<T>>(){}.getType();
        return gson.toJson(list, listType);
    }

    public static void convertToJSON(String JSONData, String fileName){
        File jsonFile = new File(fileName);
        try(FileWriter fw = new FileWriter(jsonFile)) {
            jsonFile.createNewFile();
            fw.write(JSONData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readString(String s) {
        return null;
    }
}