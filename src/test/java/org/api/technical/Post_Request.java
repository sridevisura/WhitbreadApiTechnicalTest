package org.api.technical;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Post_Request {
    @Test(dataProvider="CustomerData")
    public void addNewEmployees(String email,String password,String firstName,String lastName,String title) {
        RestAssured.baseURI = "https://ipw5pjxxsh.execute-api.eu-west-1.amazonaws.com/api/hotel/customer";
        RequestSpecification httpRequest = RestAssured.given ();
        //here we created data whihc we can send with POstrequest
        JSONObject requestParams = new JSONObject ( );
        requestParams.put ( "email", email );
        requestParams.put ( "password", password );
        requestParams.put ( "firstName", firstName );
        requestParams.put("lastName",lastName);
        requestParams.put("title",title);
        httpRequest.header ( "Content-Type", "application/json" );
        //add the Json to the body request
        httpRequest.body ( requestParams.toJSONString ( ) );
        //post REQUEST
        Response response = httpRequest.request ( Method.POST);
        //Capturing the respose body to perform validations
        String responseBody = response.getBody ( ).asString ( );
        System.out.println ("response body:" +responseBody);
       Assert.assertEquals ( responseBody.contains ( "customerId"), true );
       int statusCode = response.getStatusCode ( );
        Assert.assertEquals ( statusCode, 200 );
    }
    @DataProvider(name="CustomerData")
    public Object[][] getCustData(){
        String[][] custData={{"dyt@gmail.com","a2q4y4Qu","David","Allen","Mr"}};
        return (custData);

    }
}
