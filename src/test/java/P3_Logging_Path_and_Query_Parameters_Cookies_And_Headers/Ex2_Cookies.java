package P3_Logging_Path_and_Query_Parameters_Cookies_And_Headers;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class Ex2_Cookies
{

   // @Test
    public void TC1_printCookiesInfo()
    {
        given()
        .when()
                .get("https://google.com/")
        .then()
                .log().cookies();
    }


   // @Test
    public void TC2_verifyValueOfSpecificCookie()
    {
            given()
            .when()
                .get("https://google.com/")
            .then()
                .cookie("AEC","AaJma5ukb4PnSMIJsZx206EuhEvF8WIcwaRpbMwHCm4owiZcG7K4QJcRJJw")
                .log().all();
    }

    //@Test
    public void TC3_getValueOfSpecificCookie()
    {
        Response resp = given()
                        .when()
                            .get("https://google.com/");

        String cookieInfo = resp.getCookie("AEC");
        System.out.println("---Cookie Info----"+cookieInfo);
    }

    @Test
    public void tC4_getAllCookies()
    {
        Response resp = given()
                       .when()
                            .get("https://google.com/");


        Map<String, String> cookies = resp.cookies();
        Set<String> allCookieNames = cookies.keySet();       //get all cookieKeys/cookieNames

        for(String cookieName:allCookieNames)
        {
            System.out.println(cookieName+" : "+cookies.get(cookieName));
        }
    }





}
