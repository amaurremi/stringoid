package com.tapstream.sdk;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Hit {
    private String encodedTrackerName;
    private StringBuilder tags = null;
    private String trackerName;

    public Hit(String paramString) {
        this.trackerName = paramString;
        try {
            this.encodedTrackerName = URLEncoder.encode(paramString, "UTF-8").replace("+", "%20");
            return;
        } catch (UnsupportedEncodingException paramString) {
            Logging.log(4, "Tapstream Error: Could not encode hit tracker name, exception=%s", new Object[]{paramString.getMessage()});
        }
    }

    public void addTag(String paramString) {
        if (paramString.length() > 255) {
            Logging.log(5, "Tapstream Warning: Hit tag exceeds 255 characters, it will not be included in the post (tag=%s)", new Object[]{paramString});
            return;
        }
        for (; ; ) {
            try {
                String str = URLEncoder.encode(paramString, "UTF-8").replace("+", "%20");
                if (this.tags == null) {
                    this.tags = new StringBuilder("__ts=");
                    this.tags.append(str);
                    return;
                }
            } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
                Logging.log(4, "Tapstream Error: Could not encode hit tracker tag %s, exception=%s", new Object[]{paramString, localUnsupportedEncodingException.getMessage()});
                return;
            }
            this.tags.append(",");
        }
    }

    public String getEncodedTrackerName() {
        return this.encodedTrackerName;
    }

    public String getPostData() {
        if (this.tags == null) {
            return "";
        }
        return this.tags.toString();
    }

    public String getTrackerName() {
        return this.trackerName;
    }

    public static abstract interface CompletionHandler {
        public abstract void complete(Response paramResponse);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/tapstream/sdk/Hit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */