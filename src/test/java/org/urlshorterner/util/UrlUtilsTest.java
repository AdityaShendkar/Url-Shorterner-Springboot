package org.urlshorterner.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UrlUtilsTest {

    private UrlUtils urlUtils = new UrlUtils();

    @Test
    void test_isValid(){
        assertFalse(urlUtils.isValid("helloWorld"));
        assertFalse(urlUtils.isValid("httpHelloWorld"));
        assertTrue(urlUtils.isValid("https://facebook.com"));
        assertTrue(urlUtils.isValid("http://facebook.com"));
        assertFalse(urlUtils.isValid("Htt://"));
        assertFalse(urlUtils.isValid(null));
    }
}
