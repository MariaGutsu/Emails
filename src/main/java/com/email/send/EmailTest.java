package com.email.send;

import lombok.Data;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;


import com.codeborne.selenide.Configuration;

import org.testng.Assert;

import static com.codeborne.selenide.Selenide.open;

@Data
public class EmailTest {

        @Test
        public void sendEmail() throws IOException {
            ObjectMapper mapper = new ObjectMapper();

            String content = new String(Files.readAllBytes(Paths.get("src\\main\\resources\\emaildata.json")));
            List<EmailData> emailData = new ObjectMapper()
                    .readValue(content, new TypeReference<List<EmailData>>() {
                    });

            PageObject pageObject = new PageObject();

            open("https://mail.ru/?from=logout");

        pageObject.login(pageObject,emailData);

        Configuration.timeout = 10000;

        pageObject.writeMessage(pageObject,emailData);

        Assert.assertTrue(pageObject.sentNotification.isDisplayed());

        pageObject.logOut();

    }
}

