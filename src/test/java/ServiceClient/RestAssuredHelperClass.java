package ServiceClient;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import Utility.Endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;



public class RestAssuredHelperClass {

	public static Long RESPONSE_TIMEOUT=10000L;
	
	public static Response getResponseURL (String  URL) {
        return given().
        		when().
                get(URL).
                then().
                time(lessThan(RESPONSE_TIMEOUT)).
                extract().
                response();

    }
	
	
	
	public static  Response AuthenticateResponse( String URL ,String username, String Password)
	{
		return    given()
				.auth()
				.preemptive()
				.basic(username, Password)
				.when().get(URL).then().statusCode(200).extract().response();
	}
	
	
	public static Response invalidAuthenticateResponse(String URL ,String username, String Password)
	{
		return    given()
				.auth()
				.preemptive()
				.basic(username, Password)
				.when().get(URL).then().statusCode(401).extract().response();
	}
	
	
	
	
	
	
	
	
	
	
	
}
