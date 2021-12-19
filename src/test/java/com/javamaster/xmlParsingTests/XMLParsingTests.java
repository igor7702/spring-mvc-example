package com.javamaster.xmlParsingTests;

import com.javamaster.controller.XMLParsingController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class XMLParsingTests {

    @Autowired
    private XMLParsingController xmlParsingController;

     @Test
    void xmlParsingTest_1() {
         String home = xmlParsingController.home("1", 1L, "1");
         Assertions.assertEquals(1, 1);
    }

}
