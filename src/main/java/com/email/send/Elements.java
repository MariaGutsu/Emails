package com.email.send;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import static com.codeborne.selenide.Selenide.$x;

@Data
public class Elements {
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

    SelenideElement sentNotification = $x("//a[contains(@class,'layer__link')]");

}
