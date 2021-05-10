package DataProvider;

import Pojo.User;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class RegisterDataProvider {

    @DataProvider(name = "getRegistersDataFromJson")
    public Object[][] getRegistersDataFromJson() throws FileNotFoundException {
        JsonElement jsonData = JsonParser.parseReader(new FileReader("src/test/java/dataFiles/RegisterData.json"));
        JsonElement usersDataSet = jsonData.getAsJsonObject().get("dataset");
        List<User> registerData = (List)(new Gson()).fromJson(usersDataSet, (new TypeToken<List<User>>() {
        }).getType());
        Object[][] returnValue = new Object[registerData.size()][1];
        int index = 0;
        Object[][] var6 = returnValue;
        int var7 = returnValue.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            Object[] each = var6[var8];
            each[0] = registerData.get(index++);
        }

        return returnValue;
    }
}
