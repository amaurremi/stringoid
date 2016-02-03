package com.google.android.gms.a;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class l
        implements a {
    private final TreeSet<String> a = new TreeSet();

    public l(Context paramContext, Collection<String> paramCollection) {
        a(paramContext, paramCollection);
    }

    public String a(String paramString, Throwable paramThrowable) {
        return a(a(paramThrowable), b(a(paramThrowable)), paramString);
    }

    protected String a(Throwable paramThrowable, StackTraceElement paramStackTraceElement, String paramString) {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramThrowable.getClass().getSimpleName());
        if (paramStackTraceElement != null) {
            String[] arrayOfString = paramStackTraceElement.getClassName().split("\\.");
            String str = "unknown";
            paramThrowable = str;
            if (arrayOfString != null) {
                paramThrowable = str;
                if (arrayOfString.length > 0) {
                    paramThrowable = arrayOfString[(arrayOfString.length - 1)];
                }
            }
            localStringBuilder.append(String.format(" (@%s:%s:%s)", new Object[]{paramThrowable, paramStackTraceElement.getMethodName(), Integer.valueOf(paramStackTraceElement.getLineNumber())}));
        }
        if (paramString != null) {
            localStringBuilder.append(String.format(" {%s}", new Object[]{paramString}));
        }
        return localStringBuilder.toString();
    }

    protected Throwable a(Throwable paramThrowable) {
        while (paramThrowable.getCause() != null) {
            paramThrowable = paramThrowable.getCause();
        }
        return paramThrowable;
    }

    public void a(Context paramContext, Collection<String> paramCollection) {
        this.a.clear();
        Object localObject = new HashSet();
        if (paramCollection != null) {
            ((Set) localObject).addAll(paramCollection);
        }
        int i;
        if (paramContext != null) {
            try {
                paramCollection = paramContext.getApplicationContext().getPackageName();
                this.a.add(paramCollection);
                paramContext = paramContext.getApplicationContext().getPackageManager().getPackageInfo(paramCollection, 15).activities;
                if (paramContext != null) {
                    int j = paramContext.length;
                    i = 0;
                    while (i < j) {
                        ((Set) localObject).add(paramContext[i].packageName);
                        i += 1;
                    }
                }
                paramContext = ((Set) localObject).iterator();
            } catch (PackageManager.NameNotFoundException paramContext) {
                bt.b("No package found");
            }
        }
        if (paramContext.hasNext()) {
            paramCollection = (String) paramContext.next();
            localObject = this.a.iterator();
            for (i = 1; ; i = 0) {
                if (((Iterator) localObject).hasNext()) {
                    String str = (String) ((Iterator) localObject).next();
                    if (paramCollection.startsWith(str)) {
                        continue;
                    }
                    if (str.startsWith(paramCollection)) {
                        this.a.remove(str);
                    }
                }
                if (i == 0) {
                    break;
                }
                this.a.add(paramCollection);
                break;
            }
        }
    }

    protected StackTraceElement b(Throwable paramThrowable) {
        paramThrowable = paramThrowable.getStackTrace();
        if ((paramThrowable == null) || (paramThrowable.length == 0)) {
            return null;
        }
        int j = paramThrowable.length;
        int i = 0;
        while (i < j) {
            StackTraceElement localStackTraceElement = paramThrowable[i];
            String str = localStackTraceElement.getClassName();
            Iterator localIterator = this.a.iterator();
            while (localIterator.hasNext()) {
                if (str.startsWith((String) localIterator.next())) {
                    return localStackTraceElement;
                }
            }
            i += 1;
        }
        return paramThrowable[0];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */