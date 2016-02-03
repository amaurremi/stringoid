package org.a.a.a.a.a;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class a {
    private static ResourceBundle a = null;

    public static String a(String paramString) {
        if (a == null) {
            return paramString;
        }
        try {
            String str = a.getString(paramString);
            return str;
        } catch (MissingResourceException localMissingResourceException) {
        }
        return "Missing message: " + paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/a/a/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */