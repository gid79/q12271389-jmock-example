package com.lps.so;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;

/**
 *
 */
public class Helper {

    public static int message(final String serviceUrl) throws IOException {

        HttpClient httpclient = new HttpClient();
        HttpMethod httpmethod = new GetMethod(serviceUrl);

        // the below is the line that iam trying to mock
        int code = httpclient.executeMethod(httpmethod);

        return code;
    }
}
