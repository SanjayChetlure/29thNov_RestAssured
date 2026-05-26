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


public class ex2_ReusableRequestResponseSpecification {
    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    @BeforeClass
    public void beforeClass() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.zippopotam.us").setContentType(ContentType.JSON).build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();

    }

    @Test
    public void TC1_verifyPalcesNames() {
        given()
                .spec(requestSpec)
        .when()
                .get("us/90210")
        .then()
                .body("places[0].'place name'", equalTo("Beverly Hills"))
                .spec(responseSpec);
    }

    @Test
    public void TC2_verifyState() {
        given()
                .spec(requestSpec)
        .when()
                .get("AR/1601")
        .then()
                .body("places[0].'state'", equalTo("BUENOS AIRES"))
                .spec(responseSpec);
    }
}