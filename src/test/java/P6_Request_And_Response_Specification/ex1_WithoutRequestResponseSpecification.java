package P6_Request_And_Response_Specification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class ex1_WithoutRequestResponseSpecification {

    @Test
    public void TC1_verifyPalcesNames() {
            given()
                .contentType(ContentType.JSON)
            .when()
                .get("https://api.zippopotam.us/us/90210")
            .then()
                .body("places[0].'place name'", equalTo("Beverly Hills"))
                    .statusCode(200);
    }


    @Test
    public void TC2_verifyState() {
        given()
                .contentType(ContentType.JSON)
        .when()
                .get("https://api.zippopotam.us/AR/1601")
        .then()
                .body("places[0].'state'", equalTo("BUENOS AIRES"))
                .statusCode(200);
    }
}