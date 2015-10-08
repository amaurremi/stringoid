package com.ibm.stringoid;

import java.net.URLEncoder;

public class Example {

    /**
     * Actual result:
     * "http://domain.com?" + [ ] + "key2=val2"
     *
     * Note that the String.format analysis will not return anything because the formatted string
     * does not have a URL prefix.
     *
     * Desired result:
     * "http://domain.com?" + "key" + "=" + "val," + "key2=val2"
     */
    void wrongStringFormat() {
        String query = String.format("%s=%s,", "key", "val");
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append("http://domain.com?");
        urlBuilder.append(query);
        urlBuilder.append("key2=val2");
    }

    /**
     * Actual result:
     * "http://domain.com?" + [ ]
     *
     * Desired result:
     * "http://domain.com?" + "key=val"
     */
    void wrongStringBuilderToString() {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("key=val");
        String url = "http://domain.com?" + queryBuilder.toString();
    }

    /**
     * Actual result:
     * "http://domain.com?" + [ ]
     *
     * Desired result:
     * "http://domain.com?" + "key=val"
     */
    void wrongInterProc() {
        String url = "http://domain.com?" + getQuery();
    }

    String getQuery() {
        return "key=val";
    }
    
    /**
     * Actual result:
     * "http://domain.com?key=" + [ ]
     *
     * Desired result:
     * "http://domain.com?key=val"
     */
    void knownFunctions() {
        String url = "http://domain.com?key=" + URLEncoder.encode("val");
    }
}
