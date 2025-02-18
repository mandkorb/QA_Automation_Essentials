package api.booker.base;

import api.booker.utils.Auth;
import config.Configuration;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

public class BaseSpec {
    private final String baseUrl = Configuration.getProperty("booker.url");
    protected final String username = Configuration.getProperty("booker.username");
    protected final String password = Configuration.getProperty("booker.password");
    protected final RequestSpecification requestSpec;
    protected final RequestSpecification requestAuthSpec;
    protected final ResponseSpecification successResponseSpec;

    public BaseSpec() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType(ContentType.JSON)
                .build();

        requestAuthSpec = new RequestSpecBuilder()
                .addRequestSpecification(requestSpec)
                .addHeader("Authorization", "Bearer " + Auth.getToken())
                .build();

        successResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(5L), TimeUnit.SECONDS)
                .build();
    }
}
