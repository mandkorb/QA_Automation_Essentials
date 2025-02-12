package api.spec;

import config.Configuration;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

public class BaseSpec {

    protected RequestSpecification requestSpec;
    protected ResponseSpecification successResponseSpec;

    public BaseSpec() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(Configuration.getProperty("reqres.url"))
                .setBasePath("/api")
                .setContentType("application/json")
                .build();

        successResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(5L), TimeUnit.SECONDS)
                .build();
    }
}
