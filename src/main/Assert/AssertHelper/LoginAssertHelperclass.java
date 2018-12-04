package AssertHelper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ServiceClient.RestAssuredHelperClass;
import Utility.Endpoints;
import io.restassured.path.json.JsonPath;

public class LoginAssertHelperclass {
	static String Password;
	static String URL;
	static String Username;

	public static void AssertvalidUsernameAndPasswordSuccess(String Object, String value) {
		JsonPath jsonPathEvaluator = RestAssuredHelperClass
		.AuthenticateResponse(Endpoints.URL, "ToolsQA", "TestPassword").body().jsonPath();
		String Success = jsonPathEvaluator.get(Object);
		Assert.assertEquals(Success, value);

	}
	
	public static void AssertInvalidUsernameAndPasswordSuccess(String Object, String value) {
		JsonPath jsonPathEvaluator = RestAssuredHelperClass
		.invalidAuthenticateResponse(Endpoints.URL, "ToolsQA", "").body().jsonPath();
		String Success = jsonPathEvaluator.get(Object);
		Assert.assertEquals(Success, value);

	}
	

}
