package Test;



import org.junit.Assert;
import org.junit.Test;

import AssertHelper.LoginAssertHelperclass;
import ServiceClient.RestAssuredHelperClass;
import Utility.Endpoints;
import io.restassured.path.json.JsonPath;

public class LoginModule {

	public static final int RESPONSE_OK = 200;
	public static final int RESPONSE_BADREQUEST=400;

	@Test
public void validLoginResponse()
{
		RestAssuredHelperClass.AuthenticateResponse(Endpoints.URL, "ToolsQA", "TestPassword");
		System.out.println(RestAssuredHelperClass.AuthenticateResponse(Endpoints.URL, "ToolsQA", "TestPassword").body().asString());
		LoginAssertHelperclass.AssertvalidUsernameAndPasswordSuccess("Fault","Operation completed successfully");
		

}
	
	
@Test
public void invalidLoginResponse()
{
	RestAssuredHelperClass.invalidAuthenticateResponse(Endpoints.URL, "ToolsQA", "");
	System.out.println(RestAssuredHelperClass.invalidAuthenticateResponse(Endpoints.URL, "ToolsQA", "").body().asString());
	LoginAssertHelperclass.AssertInvalidUsernameAndPasswordSuccess("fault","Invalid username or password");
	
}
	

}
