package P3_Logging_Path_and_Query_Parameters_Cookies_And_Headers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Ex1_Logging
{
    @Test
    public void TC1()
    {
        given()
                .contentType("application/json")
        .when()
                .get("http://localhost:3000/students")
        .then()
//                 .log().status();
//                .log().body();
//                .log().headers();
//                .log().cookies();
                .log().all();

    }
}
