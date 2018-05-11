package com.ykao.sample.httpclient;

import org.junit.Test;

import static org.junit.Assert.*;

public class HttpClientTest {
    @Test
    public void testGetWithUrlString() {
        HttpClient client = new HttpClient();
        client.getWithUrlString("https://google.com/");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}