package DataProvider;

import Pojo.Product;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CurrencyDataProvider {

    @DataProvider(name = "getCurrencyDataFromJson")
    public Object[][] getCurrencyDataFromJson() throws FileNotFoundException {
        JsonElement jsonData = JsonParser.parseReader( new FileReader("src/test/java/DataFiles/CurrencyData.json"));
        JsonElement productDataSet = jsonData.getAsJsonObject().get("dataset");

        List<Product> searchProductData = new Gson().fromJson(productDataSet, new TypeToken<List<Product>>(){}.getType());
        Object[][] returnValue = new Object[searchProductData.size()][1];

        int index = 0;

        for(Object[] each: returnValue)  {
            each[0] = searchProductData.get(index++);
        }
        return returnValue;
    }
}
