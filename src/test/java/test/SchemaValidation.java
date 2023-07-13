package test;
import static io.restassured.RestAssured.given;
import java.io.File;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;


public class SchemaValidation extends BaseTest {

	
	@Test
	public void ValidateSchema() {
		RestAssured.baseURI = "https://api.coinlore.net/";
		given().when().get("api/tickers/").then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(System.getProperty("user.dir")+"/schema.json")));
	   }
		
	
}
