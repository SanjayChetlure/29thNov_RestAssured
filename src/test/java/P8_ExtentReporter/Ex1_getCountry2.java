package P8_ExtentReporter;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class Ex1_getCountry2
{
    @Test
    public void TC1_getCountry2()
    {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.zippopotam.us/BD/1000")
                .then()
                .statusCode(500);
    }
}
