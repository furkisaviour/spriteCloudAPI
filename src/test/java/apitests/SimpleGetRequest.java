package apitests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class SimpleGetRequest {

    String url = "https://petstore.swagger.io/v2/swagger.json";

     @Test
     public void test1(){

         Response response = RestAssured.get(url);

         System.out.println(response.getStatusCode());

         response.prettyPrint();

     }

     @Test
     public void test2(){

         Response response = given().accept(ContentType.JSON)
                 .when().get(url);

         Assert.assertEquals(response.statusCode(),200);

         System.out.println(response.contentType());

         Assert.assertEquals(response.contentType(),"application/json");

     }

     @Test
     public void test3(){
         given().accept(ContentType.JSON)
                 .when().get(url).then()
                 .assertThat().statusCode(200)
                 .and().contentType("application/json");

     }

     @Test
     public void test4(){
        Response response = given().accept(ContentType.JSON)
                .when().get(url);

        Assert.assertTrue(response.body().asString().contains("cat"));
     }
}
