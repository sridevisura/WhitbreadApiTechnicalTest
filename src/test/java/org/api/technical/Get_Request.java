package org.api.technical;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get_Request {
@Test
    public void getEmail()
{
    String customerId="";

    RestAssured.baseURI="https://ipw5pjxxsh.execute-api.eu-west-1.amazonaws.com/api/hotel/customer/test@gmail.com";

    RequestSpecification httpRequest=RestAssured.given().urlEncodingEnabled(false);
    Response response=httpRequest.request(Method.GET,customerId);
    String responseBody=response.getBody().asString();
    System.out.println("response body is "+ responseBody);
    int statusCode=response.getStatusCode();
    System.out.println("status code is "+statusCode);
    Assert.assertEquals(statusCode,200);
    String statusLine=response.getStatusLine();
    System.out.println("status line is "+statusLine);
    Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
}

}
