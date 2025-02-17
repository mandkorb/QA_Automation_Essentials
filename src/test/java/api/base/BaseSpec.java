package api.base;

import config.Configuration;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

public class BaseSpec {
    private static final String BASE_URL = Configuration.getProperty("reqres.url");
    private static final String API_PATH = Configuration.getProperty("reqres.api.path");
    public static RequestSpecification requestSpec;
    public static ResponseSpecification successResponseSpec;
    public static ResponseSpecification notFoundResponseSpec;
    public static ResponseSpecification badRequestResponseSpec;

    public BaseSpec() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setBasePath(API_PATH)
                .setContentType(ContentType.JSON)
                .build();

        successResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(5L), TimeUnit.SECONDS)
                .build();

        notFoundResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(404)
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(5L), TimeUnit.SECONDS)
                .build();

        badRequestResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(400)
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(5L), TimeUnit.SECONDS)
                .build();
    }
}
