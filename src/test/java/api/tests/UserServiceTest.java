package api.tests;

import api.services.UserService;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class UserServiceTest {
    private UserService userService;

    @BeforeMethod
    public void setup() {
        userService = new UserService();
    }

    @Test
    public void getUserById() {
        Response response = userService.getUserById(2);
        assertNotNull(response.jsonPath().get("data"));
        assertEquals(response.jsonPath().getInt("data.id"), 2);
        assertEquals(response.jsonPath().getString("data.first_name"), "Janet");
    }
}
