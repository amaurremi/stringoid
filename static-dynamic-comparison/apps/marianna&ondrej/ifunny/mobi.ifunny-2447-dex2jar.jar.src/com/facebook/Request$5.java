package com.facebook;

import java.net.URLEncoder;
import java.util.ArrayList;

class Request$5
        implements Request.KeyValueSerializer {
    Request$5(Request paramRequest, ArrayList paramArrayList) {
    }

    public void writeString(String paramString1, String paramString2) {
        this.val$keysAndValues.add(String.format("%s=%s", new Object[]{paramString1, URLEncoder.encode(paramString2, "UTF-8")}));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Request$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */