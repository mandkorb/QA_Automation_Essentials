package api.tests;

import api.services.UserService;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UserServiceTest {
    private UserService userService;

    @BeforeClass
    public void setup() {
        userService = new UserService();
    }

    @Test
    public void getUserByIdExpect200() {
        Response response = userService.getExistingUserById(2);
        assertNotNull(response.jsonPath().get("data"));
        assertEquals(response.jsonPath().getInt("data.id"), 2);
        assertEquals(response.jsonPath().getString("data.first_name"), "Janet");
    }

    @Test
    public void getUserByIdExpect404() {
        Response response = userService.getNotExistingUserById(23);
        assertEquals(response.asString(), "{}");
    }
}
