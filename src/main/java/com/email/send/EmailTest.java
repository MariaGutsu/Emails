package com.email.send;

import lombok.Data;
import org.testng.annotations.Test;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;

import org.testng.Assert;

@Data
public class EmailTest {
    String userName = "mail_auto";
    String domain = "@inbox.ru";
    String password = "test2021";

    String subject = "Email to myself";
    String message = "Message";

    @Test
    public void SendEmail(){

        open("https://mail.ru/?from=logout");
        Elements locator = new Elements();

        locator.userNameField.setValue(userName);
        locator.domainList.click();
        locator.selectDomain.click();
        locator.passwordField.click();
        locator.loginButton.setValue(password).pressEnter();

        Configuration.timeout = 10000;

        locator.writeMessageButton.click();
        locator.recipientField.setValue(userName+domain);
        locator.emailSubjectField.setValue(subject);
        locator.emailBodyInput.setValue(message);
        locator.sendMessageButton.click();

        Assert.assertTrue(locator.sentNotification.isDisplayed());

    }

}
