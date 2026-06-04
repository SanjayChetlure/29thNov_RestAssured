package P9_Faker_Library_And_API_Chaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class stu2_GetUser
{
    @Test
    public void TC2_GetUser(ITestContext context)
    {
        //String id=(String)context.getAttribute("student_id");      //only test
        String id=(String) context.getSuite().getAttribute("student_id");   //complete suite

        given()
                .pathParam("id", id)
                .when()
                .get("http://localhost:3000/students/{id}")

                .then()
                .statusCode(200)
                .log().all();
    }
}