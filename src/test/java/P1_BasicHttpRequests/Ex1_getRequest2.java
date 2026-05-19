package P1_BasicHttpRequests;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Ex1_getRequest2
{
    @Test
    public void TC1()
    {
        given()
                .contentType("application/json")
        .when()
                .get("http://localhost:3000/students/2")
        .then()
                .log().all()
                .statusCode(200)
                .body("name",equalTo("KIM"))
                .body("location",equalTo("US"))
                .body("courses[0]",equalTo("Python"));
    }


    @Test(enabled = false)
    public void TC2()
    {
        given()
                .contentType("application/json")
        .when()
                .get("http://localhost:3000/students/7")
        .then()
                .log().all()
                .statusCode(404);
    }
}
