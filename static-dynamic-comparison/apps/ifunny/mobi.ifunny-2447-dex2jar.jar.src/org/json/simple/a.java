package org.json.simple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
        extends ArrayList
        implements List, b {
    private static final long serialVersionUID = 3957988303675231981L;

    public static String a(List paramList) {
        if (paramList == null) {
            return "null";
        }
        int i = 1;
        StringBuffer localStringBuffer = new StringBuffer();
        paramList = paramList.iterator();
        localStringBuffer.append('[');
        while (paramList.hasNext()) {
            if (i != 0) {
                i = 0;
            }
            Object localObject;
            for (; ; ) {
                localObject = paramList.next();
                if (localObject != null) {
                    break label77;
                }
                localStringBuffer.append("null");
                break;
                localStringBuffer.append(',');
            }
            label77:
            localStringBuffer.append(d.a(localObject));
        }
        localStringBuffer.append(']');
        return localStringBuffer.toString();
    }

    public String a() {
        return a(this);
    }

    public String toString() {
        return a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/json/simple/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */