package apitests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class SimplePetRequests {

    String url = "https://petstore.swagger.io/v2";

    @Test
    public void testWithIdUrl(){

        Response response = when().get(url+"/pet/650");

        Assert.assertEquals(response.getStatusCode(),200);

        Assert.assertEquals(response.contentType(),"application/json");

        Assert.assertTrue(response.body().asString().contains("cat"));

    }

    @Test
    public void testBasics(){

        Response response = when().get(url + "/swagger.json");

        System.out.println(response.statusCode());

        Assert.assertEquals(response.contentType(),"application/json");

        Assert.assertTrue(response.headers().hasHeaderWithName("Connection"));

        System.out.println(response.header("Date"));

        System.out.println(response.header("Server"));
    }
}
