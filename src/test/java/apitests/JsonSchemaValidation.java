package apitests;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class JsonSchemaValidation {


    @BeforeClass
    public void beforeclass(){
        baseURI= "https://petstore.swagger.io/v2";
    }

    @Test
    public void schemaTest(){
        given()
                .accept(ContentType.JSON)
                .and()
                .pathParam("petId",650).
                when()
                .get("/pet/{petId}")
                .then()
                .statusCode(200)
                .and()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("SinglePetSchema.json"));

    }
}
