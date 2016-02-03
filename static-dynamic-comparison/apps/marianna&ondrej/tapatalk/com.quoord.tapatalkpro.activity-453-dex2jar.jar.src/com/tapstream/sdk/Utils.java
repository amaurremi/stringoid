package com.tapstream.sdk;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

public class Utils {
    public static String encodeEventPair(String paramString1, String paramString2, Object paramObject, boolean paramBoolean) {
        if ((paramString2 == null) || (paramObject == null)) {
        }
        do {
            do {
                return null;
                if (paramString2.length() > 255) {
                    Logging.log(5, "Tapstream Warning: Event key exceeds 255 characters, this field will not be included in the post (key=%s)", new Object[]{paramString2});
                    return null;
                }
                paramString1 = encodeString(paramString1 + paramString2);
            } while (paramString1 == null);
            paramString2 = stringify(paramObject);
            if ((paramBoolean) && (paramString2.length() > 255)) {
                Logging.log(5, "Tapstream Warning: Event value exceeds 255 characters, this field will not be included in the post (value=%s)", new Object[]{paramObject});
                return null;
            }
            paramString2 = encodeString(paramString2);
        } while (paramString2 == null);
        return paramString1 + "=" + paramString2;
    }

    public static String encodeString(String paramString) {
        try {
            paramString = URLEncoder.encode(paramString, "UTF-8").replace("+", "%20");
            return paramString;
        } catch (UnsupportedEncodingException paramString) {
            paramString.printStackTrace();
        }
        return null;
    }

    public static String stringify(Object paramObject) {
        try {
            double d = ((Double) paramObject).doubleValue();
            if (Math.floor(d) == d) {
                return String.format(Locale.US, "%.0f", new Object[]{Double.valueOf(d)});
            }
        } catch (ClassCastException localClassCastException) {
            return paramObject.toString();
        }
        return paramObject.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/tapstream/sdk/Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */