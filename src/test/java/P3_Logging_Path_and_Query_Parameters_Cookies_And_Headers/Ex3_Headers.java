package P3_Logging_Path_and_Query_Parameters_Cookies_And_Headers;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Ex3_Headers
{
    //@Test
    public void TC1_printHeaders()
    {
        given()
                .contentType("application/json")
        .when()
                .get("http://localhost:3000/students")
        .then()
                .log().headers();
    }

   // @Test
    public void TC2_verifyValueOfSpecificHeader()
    {
        given()
        .when()
                .get("https://google.com/")
        .then()
                .header("Content-Type", "text/html; charset=ISO-8859-1")
                .header("Content-Encoding", "gzip")
                .header("Server", "gws")
                .log().headers();
    }

    //@Test
    public void TC3_getValueOfSpecificHeader()
    {
        Response resp = given()
                        .when()
                            .get("https://google.com/");

        String header = resp.getHeader("Content-Type");
        System.out.println("----Content type----"+header);
    }


    @Test
    public void Tc4_getAllHeadersInfo()
    {
        Response resp = given()
                        .when()
                            .get("https://google.com/");

        Headers allHeader = resp.getHeaders();
        for(Header header:allHeader)
        {
            System.out.println(header.getName()+" : "+header.getValue());
        }
    }


}
