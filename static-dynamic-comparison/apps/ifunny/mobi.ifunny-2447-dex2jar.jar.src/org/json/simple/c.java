package org.json.simple;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class c
        extends HashMap
        implements Map, b {
    private static final long serialVersionUID = -503443796854799292L;

    private static String a(String paramString, Object paramObject, StringBuffer paramStringBuffer) {
        paramStringBuffer.append('"');
        if (paramString == null) {
            paramStringBuffer.append("null");
        }
        for (; ; ) {
            paramStringBuffer.append('"').append(':');
            paramStringBuffer.append(d.a(paramObject));
            return paramStringBuffer.toString();
            d.a(paramString, paramStringBuffer);
        }
    }

    public static String a(Map paramMap) {
        if (paramMap == null) {
            return "null";
        }
        StringBuffer localStringBuffer = new StringBuffer();
        int i = 1;
        paramMap = paramMap.entrySet().iterator();
        localStringBuffer.append('{');
        if (paramMap.hasNext()) {
            if (i != 0) {
                i = 0;
            }
            for (; ; ) {
                Map.Entry localEntry = (Map.Entry) paramMap.next();
                a(String.valueOf(localEntry.getKey()), localEntry.getValue(), localStringBuffer);
                break;
                localStringBuffer.append(',');
            }
        }
        localStringBuffer.append('}');
        return localStringBuffer.toString();
    }

    public String a() {
        return a(this);
    }

    public String toString() {
        return a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/json/simple/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */