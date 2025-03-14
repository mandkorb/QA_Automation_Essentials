package api.reqres.tests;

import api.reqres.models.register.invalid.UserRegisterInvalidRequest;
import api.reqres.models.register.invalid.UserRegisterInvalidResponse;
import api.reqres.models.register.valid.UserRegisterValidRequest;
import api.reqres.models.get_users.UserByIdResponse;
import api.reqres.models.register.valid.UserRegisterValidResponse;
import api.reqres.models.get_users.UsersListResponse;
import api.reqres.services.UserService;
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
    public void returnUserIdAndTokenWhenUserSuccessfulCreated(String email, String password, int idExpected, String tokenExpected) {
        UserRegisterValidRequest user = new UserRegisterValidRequest(email, password);
        UserRegisterValidResponse userRegisterValidResponse = userService.registerUser(user);

        assertNotNull(userRegisterValidResponse);
        assertFalse(userRegisterValidResponse.getToken().isEmpty());
        assertEquals(userRegisterValidResponse.getId(), idExpected);
        assertEquals(userRegisterValidResponse.getToken(), tokenExpected);
    }

    @Test(dataProvider = "invalidRegisterCredentials")
    public void returnErrorMessageWhenUserUnsuccessfulCreated(String email, String errorMessage) {
        UserRegisterInvalidRequest user = new UserRegisterInvalidRequest(email);
        UserRegisterInvalidResponse userRegisterInvalidResponse = userService.attemptInvalidRegistration(user);

        assertNotNull(userRegisterInvalidResponse);
        assertEquals(userRegisterInvalidResponse.getError(), errorMessage);
    }

    @DataProvider(name = "validRegisterCredentials")
    public Object[][] provideValidRegisterCredentials() {
        return new Object[][]{
                {"eve.holt@reqres.in", "pistol", 4, "QpwL5tke4Pnpja7X4"}
        };
    }

    @DataProvider(name = "invalidRegisterCredentials")
    public Object[][] provideInvalidRegisterCredentials() {
        return new Object[][]{
                {"sydney@fife", "Missing password"}
        };
    }
}
