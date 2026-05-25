package P5_JSON_Schema_Validation;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class Sample1
{

    @Test
    public void jsonSchemaValidation()
    {
            given()
            .when()
                .get("http://localhost:3000/store")
            .then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("StoreSchema.json"));
    }



}
