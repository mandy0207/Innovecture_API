package test;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class PriceChange_Validation  extends BaseTest{

	
	@Test
	public void PriceChangeValidation_24H() {
		
		String jsonResponse= GetJSON();
		 JSONObject jsonObject = new JSONObject(jsonResponse);
	        JSONArray dataArray = jsonObject.getJSONArray("data");

	        JSONArray resultArray = new JSONArray();

	        for (int i = 0; i < dataArray.length(); i++) {
	            JSONObject arrObject = dataArray.getJSONObject(i);
	            double percentChange24h = Double.parseDouble(arrObject.getString("percent_change_24h"));

	            if (percentChange24h >= -1 && percentChange24h <= 1) {
	                resultArray.put(arrObject);
	            }
	        }

	        JSONObject resultObject = new JSONObject();
	        resultObject.put("data", resultArray);

	        CreateJsonFile(resultObject);
	       
	        
	}
}
