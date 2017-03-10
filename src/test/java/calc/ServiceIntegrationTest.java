package calc;

import org.junit.Test;
import static org.junit.Assert.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.parsing.Parser;
import static org.hamcrest.Matchers.*;
import org.junit.BeforeClass;

/**
 *
 * @author bearu
 */
public class ServiceIntegrationTest {

    @BeforeClass
    public static void setUpBeforeAll() {

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8084;
        RestAssured.basePath = "/Test1";
        RestAssured.defaultParser = Parser.JSON;

    }

    public ServiceIntegrationTest() {
    }

    @Test
    public void serverIsRunning() {

        given().
                when().get().
                then().
                statusCode(200);

    }

    @Test
    public void serverIsRunningV2() {

        given().when().get("http://localhost:8084/Test1/").then().statusCode(200);

    }

    @Test
    public void addOperation() {

        given().pathParam("n1", 2).pathParam("n2", 2).
                when().get("/api/calculator/add/{n1}/{n2}").
                then().
                statusCode(200).
                body("result", equalTo(4), "operation", equalTo("2 + 2"));

    }

    @Test
    public void addOperationv2() {
        given().
                when().get("/api/calculator/add/2/2").
                then().
                statusCode(200).
                body("result", equalTo(4), "operation", equalTo("2 + 2"));
    }

    @Test
    public void subOperationv2() {

        given().
                when().get("/api/calculator/sub/2/2").
                then().
                statusCode(200).
                body("result", equalTo(0), "operation", equalTo("2 - 2"));

    }

    @Test
    public void mulOperationv2() {

        given().
                when().get("/api/calculator/mul/2/2").
                then().
                statusCode(200).
                body("result", equalTo(4), "operation", equalTo("2 * 2"));

    }

    @Test
    public void divOperationv2() {

        given().
                when().get("/api/calculator/div/2/2").
                then().
                statusCode(200).
                body("result", equalTo(1), "operation", equalTo("2 / 2"));

    }

    @Test
    public void nonExistingRoute() {

        given().
                when().get("/api/calculator/non").
                then().
                statusCode(404);

    }

    @Test
    public void illegalParameters() {

        given().
                when().get("/api/calculator/add/e/a").
                then().
                statusCode(400).
                body("code", equalTo(400), "message", equalTo("Illegal parameters, For input string: \"e\""));

    }
    @Test
    public void divByZero() {

        given().
                when().get("/api/calculator/div/2/0").
                then().
                statusCode(500).
                body("code", equalTo(500), "message", equalTo("/ by zero"));

    }

}
