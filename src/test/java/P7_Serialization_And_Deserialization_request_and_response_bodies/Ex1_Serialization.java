package P7_Serialization_And_Deserialization_request_and_response_bodies;

import P2_DifferentWaysToCreatePostRequestBody.StudentPOJO;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class Ex1_Serialization
{

    @Test(priority = 1)
    public void serialization() throws StreamWriteException, DatabindException, IOException
    {
        StudentPOJO sp=new StudentPOJO();                 //create Pojo class with constructor parameter
        sp.setId("7");
        sp.setName("abc7");
        sp.setLocation("Pune");
        sp.setPhone("7777");
        String [] courses={"sql","python"};
        sp.setCourses(courses);

        given()
                .contentType("application/json")
                .body(sp)                      //serialization (Java to JSON)
        .when()
                .post("http://localhost:3000/students")
        .then()
                .log().all();
    }

}
