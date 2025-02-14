package api.tests;

import api.responses.UserResponse;
import api.responses.UsersListResponse;
import api.services.UserService;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UserServiceTest {
    private UserService userService;
    private static final int PAGE_WITH_USERS_LIST = 2;
    private static final String EXPECTED_DOMAIN = "@reqres.in";
    private static final int USER_ID = 2;
    private static final String USER_FIRST_NAME = "Janet";

    @BeforeClass
    public void setup() {
        userService = new UserService();
    }

    @Test
    public void returnUserDataWhenUserExists2() {
        UserResponse user = userService.getUserById(USER_ID, true);
        assertEquals(user.getData().getId(), USER_ID);
        assertEquals(user.getData().getFirst_name(), USER_FIRST_NAME);
    }

    @Test
    public void returnEmptyResponseWhenUserDoesNotExist() {
        UserResponse user = userService.getUserById(23, false);
        assertTrue(user.isEmpty());
    }

    @Test
    public void returnUsersListDataWhenUsersExist() {
        UsersListResponse usersList = userService.getUsersList(PAGE_WITH_USERS_LIST);

        assertNotNull(usersList.getData());
        assertFalse(usersList.getData().isEmpty());
        assertEquals(usersList.getPage(), PAGE_WITH_USERS_LIST);

        assertTrue(usersList.areUserEmailsEndWithDomain(EXPECTED_DOMAIN));
        assertTrue(usersList.areAvatarsContainUserId());
    }
}
