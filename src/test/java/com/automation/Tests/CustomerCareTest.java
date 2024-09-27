package com.automation.Tests;

import org.junit.Assert;
import org.testng.annotations.Test;

public class CustomerCareTest extends BaseTest{

    @Test
    public void verifyCustomerCareMsg(){

        homePage.userOpenApplication();
        customerCarePage.customerCarePage();
        customerCarePage.topicAndIssueSelection();

        Assert.assertTrue(customerCarePage.verifyGetAssistanceMsg());
    }
}
