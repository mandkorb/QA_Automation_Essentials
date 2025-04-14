package api.store.base;

import static org.hamcrest.Matchers.lessThan;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.concurrent.TimeUnit;

public class BaseService {
  protected final ObjectMapper objectMapper = new ObjectMapper();
  protected static final RequestSpecification REQUEST_SPECIFICATION = new RequestSpecBuilder()
      .setBaseUri(Constants.BASE_URL)
      .setContentType(ContentType.JSON)
      .build();

  protected static final ResponseSpecification RESPONSE_SPECIFICATION = new ResponseSpecBuilder()
      .expectStatusCode(200)
      .expectContentType(ContentType.JSON)
      .expectResponseTime(lessThan(5L), TimeUnit.SECONDS)
      .build();
}
