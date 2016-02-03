package com.quoord.tools.net;

import java.util.HashMap;

public class UrlAnalyseUtil {
    private static String TruncateUrlPage(String paramString) {
        Object localObject = null;
        String str = paramString.trim().toLowerCase();
        String[] arrayOfString = str.split("[?]");
        paramString = (String) localObject;
        if (str.length() > 1) {
            paramString = (String) localObject;
            if (arrayOfString.length > 1) {
                paramString = (String) localObject;
                if (arrayOfString[1] != null) {
                    paramString = arrayOfString[1];
                }
            }
        }
        return paramString;
    }

    public static HashMap<String, String> getParamterMaps(String paramString) {
        HashMap localHashMap = new HashMap();
        paramString = TruncateUrlPage(paramString);
        if (paramString == null) {
            return localHashMap;
        }
        paramString = paramString.split("[&]");
        int j = paramString.length;
        int i = 0;
        label31:
        String[] arrayOfString;
        if (i < j) {
            arrayOfString = paramString[i].split("[=]");
            if (arrayOfString.length <= 1) {
                break label73;
            }
            localHashMap.put(arrayOfString[0], arrayOfString[1]);
        }
        for (; ; ) {
            i += 1;
            break label31;
            break;
            label73:
            if (arrayOfString[0] != "") {
                localHashMap.put(arrayOfString[0], "");
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/net/UrlAnalyseUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */