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
        JsonElement jsonData = JsonParser.parseReader( new FileReader("src/test/java/dataFiles/RegisterData.json"));
        JsonElement usersDataSet = jsonData.getAsJsonObject().get("dataset");

        List<User> userData = new Gson().fromJson(usersDataSet, new TypeToken<List<User>>(){}.getType());
        Object[][] returnValue = new Object[userData.size()][1];

        int index = 0;

        for(Object[] each: returnValue)  {
            each[0] = userData.get(index++);
        }
        return returnValue;
    }
}
