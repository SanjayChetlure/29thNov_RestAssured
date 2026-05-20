package P2_DifferentWaysToCreatePostRequestBody;

import org.testng.annotations.Test;

import java.io.File;
import java.util.LinkedHashMap;
import static io.restassured.RestAssured.given;

public class Ex3_ExternalJSONFile
{
    @Test
    public void addStudentDetails()
    {
        File file=new File("./data.json");


        given()
                .contentType("application/json")
                .body(file)
        .when()
                .post("http://localhost:3000/students")
        .then()
                .statusCode(201)
                .log().all();
    }
}
