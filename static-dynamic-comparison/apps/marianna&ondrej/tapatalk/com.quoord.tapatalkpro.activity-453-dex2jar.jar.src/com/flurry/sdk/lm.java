package com.flurry.sdk;

import java.io.IOException;

@kb
public class lm
        extends mc<Class<?>> {
    public lm() {
        super(Class.class);
    }

    public Class<?> b(hj paramhj, iz paramiz)
            throws IOException, hk {
        Object localObject = paramhj.e();
        if (localObject == hm.h) {
            localObject = paramhj.k();
            if (((String) localObject).indexOf('.') < 0) {
                if ("int".equals(localObject)) {
                    return Integer.TYPE;
                }
                if ("long".equals(localObject)) {
                    return Long.TYPE;
                }
                if ("float".equals(localObject)) {
                    return Float.TYPE;
                }
                if ("double".equals(localObject)) {
                    return Double.TYPE;
                }
                if ("boolean".equals(localObject)) {
                    return Boolean.TYPE;
                }
                if ("byte".equals(localObject)) {
                    return Byte.TYPE;
                }
                if ("char".equals(localObject)) {
                    return Character.TYPE;
                }
                if ("short".equals(localObject)) {
                    return Short.TYPE;
                }
                if ("void".equals(localObject)) {
                    return Void.TYPE;
                }
            }
            try {
                paramhj = Class.forName(paramhj.k());
                return paramhj;
            } catch (ClassNotFoundException paramhj) {
                throw paramiz.a(this.q, paramhj);
            }
        }
        throw paramiz.a(this.q, (hm) localObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/lm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */