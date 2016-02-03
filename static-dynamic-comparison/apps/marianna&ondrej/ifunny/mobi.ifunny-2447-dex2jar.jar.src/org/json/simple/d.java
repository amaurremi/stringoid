package org.json.simple;

import java.util.List;
import java.util.Map;

public class d {
    public static String a(Object paramObject) {
        if (paramObject == null) {
            return "null";
        }
        if ((paramObject instanceof String)) {
            return "\"" + a((String) paramObject) + "\"";
        }
        if ((paramObject instanceof Double)) {
            if ((((Double) paramObject).isInfinite()) || (((Double) paramObject).isNaN())) {
                return "null";
            }
            return paramObject.toString();
        }
        if ((paramObject instanceof Float)) {
            if ((((Float) paramObject).isInfinite()) || (((Float) paramObject).isNaN())) {
                return "null";
            }
            return paramObject.toString();
        }
        if ((paramObject instanceof Number)) {
            return paramObject.toString();
        }
        if ((paramObject instanceof Boolean)) {
            return paramObject.toString();
        }
        if ((paramObject instanceof b)) {
            return ((b) paramObject).a();
        }
        if ((paramObject instanceof Map)) {
            return c.a((Map) paramObject);
        }
        if ((paramObject instanceof List)) {
            return a.a((List) paramObject);
        }
        return paramObject.toString();
    }

    public static String a(String paramString) {
        if (paramString == null) {
            return null;
        }
        StringBuffer localStringBuffer = new StringBuffer();
        a(paramString, localStringBuffer);
        return localStringBuffer.toString();
    }

    static void a(String paramString, StringBuffer paramStringBuffer) {
        int i = 0;
        if (i < paramString.length()) {
            char c = paramString.charAt(i);
            String str;
            int j;
            switch (c) {
                default:
                    if (((c >= 0) && (c <= '\037')) || ((c >= '') && (c <= '')) || ((c >= ' ') && (c <= '⃿'))) {
                        str = Integer.toHexString(c);
                        paramStringBuffer.append("\\u");
                        j = 0;
                    }
                    break;
                case '"':
                    while (j < 4 - str.length()) {
                        paramStringBuffer.append('0');
                        j += 1;
                        continue;
                        paramStringBuffer.append("\\\"");
                    }
            }
            for (; ; ) {
                i += 1;
                break;
                paramStringBuffer.append("\\\\");
                continue;
                paramStringBuffer.append("\\b");
                continue;
                paramStringBuffer.append("\\f");
                continue;
                paramStringBuffer.append("\\n");
                continue;
                paramStringBuffer.append("\\r");
                continue;
                paramStringBuffer.append("\\t");
                continue;
                paramStringBuffer.append("\\/");
                continue;
                paramStringBuffer.append(str.toUpperCase());
                continue;
                paramStringBuffer.append(c);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/json/simple/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */