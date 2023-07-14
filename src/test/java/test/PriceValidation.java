package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PriceValidation extends BaseTest {

	@Test
	public void BTC_ETH_PriceValidation() {
		

		String jsonResponse= GetJSON();

        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray dataArray = jsonObject.getJSONArray("data");

        boolean testPassed = true; 

        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject arrObject = dataArray.getJSONObject(i);
            String symbol = arrObject.getString("symbol");
            double priceUSD = Double.parseDouble(arrObject.getString("price_usd"));

            if (symbol.equals("BTC") && priceUSD < 30000) {
                testPassed = false;
                break;
            }

            if (symbol.equals("ETH") && priceUSD < 15000) {
                testPassed = false;
                break;
            }
        }
 
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(testPassed, "Test is failed");
        //softAssert.assertAll();


	}
}
