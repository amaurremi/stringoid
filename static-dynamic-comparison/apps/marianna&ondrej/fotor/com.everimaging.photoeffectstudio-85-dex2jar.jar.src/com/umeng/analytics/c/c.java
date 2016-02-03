package com.umeng.analytics.c;

import com.umeng.analytics.d.g;
import com.umeng.analytics.d.h;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class c
        extends g {
    public c() {
        a(System.currentTimeMillis());
        a(h.a);
    }

    public c(String paramString) {
        this();
        a(paramString);
    }

    public c(Throwable paramThrowable) {
        this();
        a(a(paramThrowable));
    }

    private String a(Throwable paramThrowable) {
        Object localObject2 = null;
        if (paramThrowable == null) {
            return null;
        }
        Object localObject1 = localObject2;
        try {
            StringWriter localStringWriter = new StringWriter();
            localObject1 = localObject2;
            PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
            localObject1 = localObject2;
            paramThrowable.printStackTrace(localPrintWriter);
            localObject1 = localObject2;
            for (paramThrowable = paramThrowable.getCause(); paramThrowable != null; paramThrowable = paramThrowable.getCause()) {
                localObject1 = localObject2;
                paramThrowable.printStackTrace(localPrintWriter);
                localObject1 = localObject2;
            }
            localObject1 = localObject2;
            paramThrowable = localStringWriter.toString();
            localObject1 = paramThrowable;
            localPrintWriter.close();
            localObject1 = paramThrowable;
            localStringWriter.close();
            return paramThrowable;
        } catch (Exception paramThrowable) {
            paramThrowable.printStackTrace();
        }
        return (String) localObject1;
    }

    public c a(boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (h localh = h.a; ; localh = h.b) {
            a(localh);
            return this;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */