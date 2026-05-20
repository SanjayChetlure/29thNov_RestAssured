package P2_DifferentWaysToCreatePostRequestBody;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Ex2_OrgJSONLibrary
{
    @Test
    public void addStudentDetails()
    {
        JSONObject data=new JSONObject();
        data.put("id","4");
        data.put("name","ramesh");
        data.put("location","Nanded");
        data.put("phone","444");

        String [] s1={"Selenium","python"};
        data.put("courses",s1);


        given()
                .contentType("application/json")
                .body(data.toString())
        .when()
                .post("http://localhost:3000/students")
        .then()
                .statusCode(201)
                .body("id",equalTo("4"))
                .log().all();
    }
}
