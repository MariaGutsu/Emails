package com.email.send;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import lombok.Data;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$;

@Data
public class PageObject {
    SelenideElement userNameField = $x("//input[@data-testid='login-input']");
    SelenideElement domainList = $x("//select[@name='domain']");
    SelenideElement selectDomain = $x("//option[@value='@inbox.ru']");
    SelenideElement passwordField = $x("//button[@data-testid='enter-password']");
    SelenideElement loginButton = $x("//input[@data-testid='password-input']");

    SelenideElement writeMessageButton = $x("//a[@class='compose-button compose-button_white compose-button_base compose-button_compact compose-button_with-dropdown js-shortcut']");
    SelenideElement recipientField = $x("//div[@class='container--ItIg4']//input[@class='container--H9L5q size_s_compressed--2c-eV']");
    SelenideElement emailSubjectField = $x("//input[@name='Subject']");
    SelenideElement emailBodyInput = $x("//div[contains(@role,'textbox')]");
    SelenideElement sendMessageButton = $x("//span[@class='button2 button2_base button2_primary button2_compact button2_hover-support js-shortcut']");

    SelenideElement userIconButton = $(By.xpath("//div[contains(@class,'user-account__pic')]//img[contains(@class,'user-pic__image')]"));
    SelenideElement logOutButton = $(By.xpath("//a[contains(@class,'legouser__menu-item_action_exit')]"));

    SelenideElement sentNotification = $x("//a[contains(@class,'layer__link')]");

    public void login(PageObject pageObject, List<EmailData> emailData) {
        pageObject.userNameField.setValue(emailData.get(0).userName);
        pageObject.domainList.click();
        pageObject.selectDomain.click();
        pageObject.passwordField.click();
        pageObject.loginButton.setValue(emailData.get(0).password).pressEnter();
    }

    public void writeMessage(PageObject pageObject, List<EmailData> emailData) {
        pageObject.writeMessageButton.click();
        pageObject.recipientField.setValue(emailData.get(0).userName + emailData.get(0).domain);
        pageObject.emailSubjectField.setValue(emailData.get(0).subject);
        pageObject.emailBodyInput.setValue(emailData.get(0).message);
        pageObject.sendMessageButton.click();
    }

    public void logOut() {
        userIconButton.click();
        logOutButton.click();
    }
}

