package test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseTest {

	public String GetJSON() {

		RestAssured.baseURI = "https://api.coinlore.net/";
		String response = given().when().get("api/tickers/").then().log().all().assertThat().statusCode(200).extract().response()
				.asString();

		return response;

	}

	

	public void CreateJsonFileofResponse(String responseBody) {
		try (FileWriter file = new FileWriter("response.json")) {
			file.write(responseBody);
			System.out.println("JSON file created successfully.");
		} catch (IOException e) {
			System.out.println("An error occurred while creating the JSON file: " + e.getMessage());
		}
	}

	public void CreateJsonFile(JSONObject resultObject) {
		try (FileWriter file = new FileWriter("assetPriceChange_24Hr.json")) {
			file.write(resultObject.toString());
			System.out.println("JSON document saved successfully.");
		} catch (IOException e) {
			System.out.println("An error occurred while saving the JSON document: " + e.getMessage());
		}
	}
}
