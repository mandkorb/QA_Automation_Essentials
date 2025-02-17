package api.tests;

import api.models.requests.UserRegisterRequest;
import api.models.responses.UserByIdResponse;
import api.models.responses.UserRegisterResponse;
import api.models.responses.UsersListResponse;
import api.services.UserService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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
    public void returnUserDataWhenUserExists() {
        UserByIdResponse user = userService.getUserById(USER_ID, true);
        assertEquals(user.getData().getId(), USER_ID);
        assertEquals(user.getData().getFirst_name(), USER_FIRST_NAME);
    }

    @Test
    public void returnEmptyResponseWhenUserDoesNotExist() {
        UserByIdResponse user = userService.getUserById(23, false);
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

    @Test(dataProvider = "validRegisterCredentials")
    public void returnUserIdAndTokenWhenUserCreated(String email, String password, int idExpected, String tokenExpected) {
        UserRegisterRequest user = new UserRegisterRequest(email, password);
        UserRegisterResponse userRegisterResponse = userService.registerUser(user);

        assertNotNull(userRegisterResponse);
        assertFalse(userRegisterResponse.getToken().isEmpty());
        assertEquals(userRegisterResponse.getId(), idExpected);
        assertEquals(userRegisterResponse.getToken(), tokenExpected);
    }

    @DataProvider(name = "validRegisterCredentials")
    public Object[][] provideValidRegisterCredentials() {
        return new Object[][]{
                {"eve.holt@reqres.in", "pistol", 4, "QpwL5tke4Pnpja7X4"}
        };
    }
}
