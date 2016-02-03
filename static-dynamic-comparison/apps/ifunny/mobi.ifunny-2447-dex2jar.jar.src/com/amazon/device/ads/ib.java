package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class ib {
    private final HashMap<String, String> a = new HashMap();
    private String b;

    int a() {
        return this.a.size();
    }

    void a(String paramString) {
        this.b = paramString;
    }

    void a(String paramString1, String paramString2) {
        if (hu.d(paramString1)) {
            throw new IllegalArgumentException("The name must not be null or empty string.");
        }
        if (paramString2 == null) {
            this.a.remove(paramString1);
            return;
        }
        this.a.put(paramString1, paramString2);
    }

    void a(String paramString1, String paramString2, boolean paramBoolean) {
        if (paramBoolean) {
            a(paramString1, paramString2);
        }
    }

    void a(StringBuilder paramStringBuilder) {
        if ((a() == 0) && (hu.c(this.b))) {
        }
        do {
            return;
            paramStringBuilder.append("?");
            Iterator localIterator = this.a.entrySet().iterator();
            int i = 1;
            if (localIterator.hasNext()) {
                Map.Entry localEntry = (Map.Entry) localIterator.next();
                if (i != 0) {
                    i = 0;
                }
                for (; ; ) {
                    paramStringBuilder.append((String) localEntry.getKey());
                    paramStringBuilder.append("=");
                    paramStringBuilder.append((String) localEntry.getValue());
                    break;
                    paramStringBuilder.append("&");
                }
            }
        } while ((this.b == null) || (this.b.equals("")));
        if (a() != 0) {
            paramStringBuilder.append("&");
        }
        paramStringBuilder.append(this.b);
    }

    String b(String paramString1, String paramString2) {
        paramString1 = hu.b(paramString1);
        a(paramString1, hu.b(paramString2));
        return paramString1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/ib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */