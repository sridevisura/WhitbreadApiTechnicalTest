package org.api.technical;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Delete_Request {

    @Test
    public void deleteMethodWithoutBDDApproach()
    {
        String customerId = "";
        RequestSpecification request = RestAssured.given();
        request.baseUri("https://ipw5pjxxsh.execute-api.eu-west-1.amazonaws.com/api/hotel/customer/test@gmail.com");
        Response response = request.delete(customerId);
        //  prints response body.
        String responseString = response.asString();
        System.out.println("Response Details : " + responseString);
        ValidatableResponse validatableResponse = response.then();
        // checks if status code is 200
        validatableResponse.statusCode(200);
    }
        }