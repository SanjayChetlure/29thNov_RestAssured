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


public class ex4_pathParameter
{
   // @Test
    public void TC1_withoutPathParameter()
    {
        given()
                .when()
                .get(" https://api.zippopotam.us/AR/1601")
            .then()
                .statusCode(200)
                .log().all();
    }


   // @Test
    public void TC2_withPathParameter() {
        given()
                .pathParam("path1", "AR")
                .pathParam("path2", "1601")
            .when()
                .get("https://api.zippopotam.us/{path1}/{path2}")
            .then()
                .statusCode(200)
                .log().all();
    }


   // @Test
    public void TC3_withPathParameter() {
        given()
                .pathParams("path1", "AR","path2","1601")
            .when()
                .get("https://api.zippopotam.us/{path1}/{path2}")
            .then()
                .statusCode(200)
                .log().all();
    }
}