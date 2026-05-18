package P1_BasicHttpRequests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Ex1_getRequest
{
    @Test
    public void TC1()
    {
        given()                                             //pre-req
                .contentType("application/json")
        .when()                                             //actions -> http request method
                .get("https://reqres.in/api/test-suite/collections/users/records")
        .then()
                .log().all()
                .statusCode(401);
    }
}
