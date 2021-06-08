import org.junit.jupiter.api.Test;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;

public class TestRest {

    private final static String BASE_URL = "https://petstore.swagger.io:443/v2";

    @Test
    public void TestGet() {
        when().get(BASE_URL + "/pet/150").then().assertThat().statusCode(404);
    }

    @Test
    public void TestPost() {
        given().contentType("application/json")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"TestCategory\"\n" +
                        "  },\n" +
                        "  \"name\": \"TestName\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"TestTag\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when().post(BASE_URL + "/pet").then().assertThat().statusCode(200);
    }

    @Test
    public void testDelete() {
        when().delete(BASE_URL + "/pet/15");
    }

    @Test
    public void TestPut() {
        given().contentType("application/json")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"TestCategory\"\n" +
                        "  },\n" +
                        "  \"name\": \"TestName\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"TestTag\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when().put(BASE_URL + "/pet").then().assertThat().statusCode(200);
    }
}
