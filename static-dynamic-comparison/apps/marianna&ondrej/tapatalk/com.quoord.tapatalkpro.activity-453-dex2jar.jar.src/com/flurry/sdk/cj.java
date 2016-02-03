package com.flurry.sdk;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cj {
    public static int a(String paramString) {
        if (paramString != null) {
            paramString = Pattern.compile("<VAST version=\"(.+?)\">").matcher(paramString);
            if ((paramString.find()) && (paramString.groupCount() == 1)) {
                try {
                    int i = Math.round(Float.parseFloat(paramString.group(1)));
                    if ((i >= 1) && (i <= 3)) {
                        return i;
                    }
                    return 0;
                } catch (NumberFormatException paramString) {
                    return 0;
                }
            }
            return 0;
        }
        return 0;
    }

    static cv a(List<cv> paramList) {
        Object localObject = null;
        cv localcv = null;
        if (paramList != null) {
            Iterator localIterator = paramList.iterator();
            paramList = localcv;
            localObject = paramList;
            if (localIterator.hasNext()) {
                localcv = (cv) localIterator.next();
                if ((localcv.b() <= 500) && (localcv.a() != null) && (((localcv.c() != null) && (localcv.c().equalsIgnoreCase("video/mp4"))) || (localcv.a().endsWith("mp4")))) {
                    if (paramList == null) {
                        localObject = localcv;
                    }
                }
                for (; ; ) {
                    paramList = (List<cv>) localObject;
                    break;
                    localObject = localcv;
                    if (paramList.b() >= localcv.b()) {
                        localObject = paramList;
                    }
                }
            }
        }
        return (cv) localObject;
    }

    static int b(String paramString) {
        int j = 0;
        int i = j;
        if (paramString != null) {
            paramString = Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})").matcher(paramString);
            i = j;
            if (paramString.find()) {
                i = j;
                if (paramString.groupCount() != 3) {
                }
            }
        }
        try {
            i = Integer.parseInt(paramString.group(1));
            j = Integer.parseInt(paramString.group(2));
            int k = Integer.parseInt(paramString.group(3));
            i = k + (i * 60 * 60 + j * 60);
            return i;
        } catch (NumberFormatException paramString) {
        }
        return 0;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */