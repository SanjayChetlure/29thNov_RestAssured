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


public class ex4_queryParameter
{
     //@Test
    public void TC1_withoutPathAndQueryParameter()
    {
        given()
                .when()
                .get("https://dummyjson.com/products/search?q=phone&limit=1")
                .then()
                .statusCode(200)
                .log().body();
    }


     //@Test
    public void TC2_withPathAndQueryParameter() {
        given()
                .pathParam("path1", "products")
                .pathParam("path2", "search")
                .queryParam("q","phone")
                .queryParam("limit","1")
            .when()
                .get("https://dummyjson.com/{path1}/{path2}")
            .then()
                .statusCode(200)
                .log().body();
    }


     @Test
    public void TC3_withPathAndQueryParameter() {
        given()
                .pathParams("path1", "products","path2","search")
                .queryParams("q","phone","limit","2")
            .when()
                .get("https://dummyjson.com/{path1}/{path2}")
            .then()
                .statusCode(200)
                .log().body();
    }
}