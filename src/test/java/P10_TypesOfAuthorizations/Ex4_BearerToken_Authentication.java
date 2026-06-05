package P10_TypesOfAuthorizations;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Ex4_BearerToken_Authentication
{
    @Test(priority = 4)
    public void AuthEx4_BearerToken()
    {
        String bearerToken="sfmfemgvvrgrgregergrggrgerger";

        //bearerToken="Bearer "+bearerToken;


        given()
                .headers("Authorization", "Bearer "+bearerToken)
        .when()
                .get("https://api.github.com/user/repos")
        .then()
                .statusCode(200)
                .log().all();
    }
}