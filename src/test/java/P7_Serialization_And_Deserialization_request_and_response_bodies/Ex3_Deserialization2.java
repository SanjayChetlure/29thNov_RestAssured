package P7_Serialization_And_Deserialization_request_and_response_bodies;

import P2_DifferentWaysToCreatePostRequestBody.StudentPOJO;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Ex3_Deserialization2
{

    ObjectMapper mapper=new ObjectMapper();

    //Multiple data
    @Test
    public void MapResponseToPojoClass() throws StreamWriteException, DatabindException, IOException
    {
        Response resp = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/students");

        String responseBody = resp.body().asString();

        List<StudentPOJO> students = mapper.readValue(responseBody, new TypeReference<List<StudentPOJO>>() {});

        Assert.assertEquals(students.get(1).getId(), "2");
        Assert.assertEquals(students.get(2).getName(), "Pallavi");
    }


}
