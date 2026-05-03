package com.test1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class GetClass {

    @Test
    public void getFunction(){
        Response response = RestAssured.get("https://catfact.ninja");
        System.out.println(response.toString());
        System.out.println( response.getStatusLine());
        System.out.println(response.getBody().toString());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());
        int statusCode = response.statusCode();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(statusCode,200,"Status Code for Get API");
        softAssert.assertAll();

    }

    @Test
        public void getUsersPage2() {
            given()
                    .when()
                    .get("https://jsonplaceholder.typicode.com/posts/1")
                    .then()
                    .statusCode(200) // must be 200
                    .body("id", equalTo(1))
                    .log().all();
        }
    }



