package com.lps.so;

import mockit.Expectations;
import mockit.Mocked;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 *
 */
public class HelperTest {

    @Test
    public void testSend() throws IOException {

        final String serviceUrl = "http://google.com/";

        new Expectations(){
            @Mocked HttpClient client ;
            @Mocked GetMethod method;
            {
                HttpClient httpClient= new HttpClient() ;
                HttpMethod method = new GetMethod(withEqual(serviceUrl));
                try {
                    httpClient.executeMethod(method);
                } catch (IOException e) {
                    // not going to happen
                }
                result = 200;
            }
        };
        Assert.assertEquals(200, Helper.message(serviceUrl));
    }
}

