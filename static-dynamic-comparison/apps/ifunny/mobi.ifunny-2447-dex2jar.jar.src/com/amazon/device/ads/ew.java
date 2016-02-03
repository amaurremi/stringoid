package com.amazon.device.ads;

import java.util.ArrayList;
import java.util.Map;

abstract class ew {
    protected Map<String, String> a;
    protected fy b;

    ew(Map<String, String> paramMap, fy paramfy) {
        this.a = paramMap;
        this.b = paramfy;
    }

    protected int a(String paramString) {
        paramString = (String) this.a.get(paramString);
        if (paramString == null) {
            return -1;
        }
        try {
            int i = Integer.parseInt(paramString, 10);
            return i;
        } catch (NumberFormatException paramString) {
        }
        return -1;
    }

    abstract void a();

    protected String b(String paramString) {
        return (String) this.a.get(paramString);
    }

    protected boolean c(String paramString) {
        return "true".equals(this.a.get(paramString));
    }

    protected Integer[] d(String paramString) {
        paramString = (String) this.a.get(paramString);
        if (paramString == null) {
            return null;
        }
        paramString = paramString.split(",");
        ArrayList localArrayList = new ArrayList();
        int j = paramString.length;
        int i = 0;
        for (; ; ) {
            if (i < j) {
                String str = paramString[i];
                try {
                    localArrayList.add(Integer.valueOf(Integer.parseInt(str, 10)));
                    i += 1;
                } catch (NumberFormatException localNumberFormatException) {
                    for (; ; ) {
                        localArrayList.add(Integer.valueOf(-1));
                    }
                }
            }
        }
        return (Integer[]) localArrayList.toArray(new Integer[localArrayList.size()]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/ew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */