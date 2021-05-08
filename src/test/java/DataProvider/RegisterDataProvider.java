package DataProvider;

import Pojo.Usuario;
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

        List<Usuario> usuarioData = new Gson().fromJson(usersDataSet, new TypeToken<List<Usuario>>(){}.getType());
        Object[][] returnValue = new Object[usuarioData.size()][1];

        int index = 0;

        for(Object[] each: returnValue)  {
            each[0] = usuarioData.get(index++);
        }
        return returnValue;
    }
}
