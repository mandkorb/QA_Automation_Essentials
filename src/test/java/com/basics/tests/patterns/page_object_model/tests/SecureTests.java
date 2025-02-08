package com.basics.tests.patterns.page_object_model.tests;

import com.basics.tests.patterns.page_object_model.base.BaseTest;
import com.basics.tests.patterns.page_object_model.pages.SecurePage;
import org.testng.annotations.BeforeMethod;

public class SecureTests extends BaseTest {
    private SecurePage securePage;

    @BeforeMethod
    public void openAlertsPage(){
        securePage = new SecurePage(driver);
        securePage.open();
    }


}
