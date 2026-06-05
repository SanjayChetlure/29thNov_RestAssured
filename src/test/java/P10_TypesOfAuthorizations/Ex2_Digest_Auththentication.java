package P10_TypesOfAuthorizations;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class Ex2_Digest_Auththentication
{
    @Test
    public void DigestAuth()
    {
        given()
                .auth().digest("postman", "password")
        .when()
                .get("https://postman-echo.com/digest-auth")
        .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();
    }

}