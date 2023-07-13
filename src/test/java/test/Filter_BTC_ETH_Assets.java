package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class Filter_BTC_ETH_Assets  extends BaseTest{

	
	@Test
	public void FilterAssests() {
		
		String jsonResponse= GetJSON();
		JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray dataArray = jsonObject.getJSONArray("data");
        
        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject arrObject = dataArray.getJSONObject(i);
            String symbol = arrObject.getString("symbol");
            
            if (symbol.equals("BTC") || symbol.equals("ETH")) {
                System.out.println("Message=="+arrObject.toString());
            }
        }
	}
}
