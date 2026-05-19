package P1_BasicHttpRequests;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import static io.restassured.RestAssured.given;

public class Ex3_PutRequest
{
    @Test
    public void updateDetails()
    {
        LinkedHashMap map=new LinkedHashMap();
        map.put("id","3");
        map.put("name","PALLAVI");
        map.put("location","MUMBAI");
        map.put("phone","3333");

        String [] s1={"SELENIUM","PYTHON"};
        map.put("courses",s1);

        given()
                .contentType("application/json")
                .body(map)
        .when()
                .put("http://localhost:3000/students/3")
        .then()
                .statusCode(200)
                .log().all();



    }
}
