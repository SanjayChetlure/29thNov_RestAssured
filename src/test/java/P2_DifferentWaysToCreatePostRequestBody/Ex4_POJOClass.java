package P2_DifferentWaysToCreatePostRequestBody;

import org.testng.annotations.Test;

import java.io.File;
import java.util.LinkedHashMap;
import static io.restassured.RestAssured.given;

public class Ex4_POJOClass
{
    @Test
    public void addStudentDetails()
    {
        StudentPOJO studentData=new StudentPOJO();
        studentData.setId("6");
        studentData.setName("Tanvi");
        studentData.setLocation("pune");
        studentData.setPhone("6666");
        String [] courses={"manual", "automation"};
        studentData.setCourses(courses);


        given()
                .contentType("application/json")
                .body(studentData)
        .when()
        .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .log().all();
    }
}
