package P2_DifferentWaysToCreatePostRequestBody;

import org.testng.annotations.Test;
import java.util.LinkedHashMap;
import static io.restassured.RestAssured.given;

public class Ex1_Hashmap
{
    @Test
    public void addStudentDetails()
    {
        LinkedHashMap map=new LinkedHashMap();
        map.put("id","3");
        map.put("name","Pallavi");
        map.put("location","Mumbai");
        map.put("phone","333");

        String [] s1={"Selenium","python"};
        map.put("courses",s1);


        given()
                .contentType("application/json")
                .body(map)
        .when()
                .post("http://localhost:3000/students")
        .then()
                .statusCode(201)
                .log().all();
    }
}
