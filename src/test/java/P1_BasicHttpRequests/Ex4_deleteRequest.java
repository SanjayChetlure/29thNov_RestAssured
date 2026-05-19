package P1_BasicHttpRequests;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class Ex4_deleteRequest
{
    @Test
    public void TC1_delete()
    {
        given()
                .contentType("application/json")
        .when()
                .delete("http://localhost:3000/students/3")
        .then()
                .log().all()
                .statusCode(200);
    }
}
