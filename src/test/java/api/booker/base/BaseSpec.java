package api.booker.base;

import config.Configuration;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

public class BaseSpec {
    private static final String BASE_URL = Configuration.getProperty("booker.url");
    protected static final String USERNAME = Configuration.getProperty("booker.username");
    protected static final String PASSWORD = Configuration.getProperty("booker.password");
    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification successResponseSpec;

    public BaseSpec() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .build();

        successResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(5L), TimeUnit.SECONDS)
                .build();
    }
}
