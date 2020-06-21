package com.restassured;

import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


public class GetCallBDD {

	@Test(priority=1, description = "Get the list of the user")
	public void getListOfUsers()
	{
		
		RestAssured.baseURI="https://reqres.in";
		String Resp=given().
				    when().
				    get("/api/users?page=2").
				    then().
				    assertThat().statusCode(200).and().
				    contentType(ContentType.JSON).and().
				    header("server", "cloudflare").and().
				    header("X-Powered-By", "Express").and().
				    body("page", equalTo(2)).and().
				    body("data[0].id" ,equalTo(7)).and().
				    extract().
				    response().asString();
		            Reporter.log("Response is \t"+Resp);
		
		
		
		
	}
	
}
