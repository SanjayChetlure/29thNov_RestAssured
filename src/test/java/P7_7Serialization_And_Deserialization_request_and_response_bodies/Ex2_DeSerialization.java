package P7_7Serialization_And_Deserialization_request_and_response_bodies;

import P2_DifferentWaysToCreatePostRequestBody.StudentPOJO;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import static io.restassured.RestAssured.given;

public class Ex2_DeSerialization
{

    ObjectMapper mapper=new ObjectMapper();

    @Test(priority = 2)
    public void DeSerialization() throws StreamWriteException, DatabindException, IOException
    {
        Response resp = given()
                .contentType("application/json")
                .when()
                .get("http://localhost:3000/students/1");

        StudentPOJO sp = mapper.readValue(resp.body().asString(), StudentPOJO.class);   //de-serialization  convert json -> java object

        System.out.println(sp.getId());
        System.out.println(sp.getName());
        System.out.println(sp.getLocation());
        System.out.println(sp.getPhone());
        System.out.println(sp.getCourses()[0]);
        System.out.println(sp.getCourses()[1]);

        Assert.assertEquals(sp.getName(),"john");
    }


}
