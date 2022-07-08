package apitests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DeleteRequestDemo {

     @BeforeClass
     public void beforeClass(){
        baseURI = "https://petstore.swagger.io/v2";
     }

     @Test
     public void test1(){

         int idToDelete = 450 ;

         given().pathParam("petId",idToDelete)
                 .when().delete("/pet/{petId}")
                 .then().statusCode(200).log().all();

     }

}
