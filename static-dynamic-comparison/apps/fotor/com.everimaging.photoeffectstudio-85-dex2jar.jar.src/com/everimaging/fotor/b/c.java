package com.everimaging.fotor.b;

import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public abstract class c
        implements BaseColumns {
    public static final String[] a = {a.class.getName()};

    private static final String a(String paramString, Map<String, String> paramMap) {
        String[] arrayOfString = (String[]) paramMap.keySet().toArray(new String[0]);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("CREATE TABLE ").append(paramString).append("( ");
        int j = arrayOfString.length;
        int i = 0;
        while (i < j) {
            paramString = (String) paramMap.get(arrayOfString[i]);
            localStringBuilder.append(arrayOfString[i]).append(" ");
            localStringBuilder.append(paramString);
            if (i < j - 1) {
                localStringBuilder.append(",");
            }
            i += 1;
        }
        localStringBuilder.append(")");
        return localStringBuilder.toString();
    }

    public static final Class<c>[] d() {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        for (; ; ) {
            if (i < a.length) {
                try {
                    localArrayList.add(Class.forName(a[i]));
                    i += 1;
                } catch (ClassNotFoundException localClassNotFoundException) {
                    for (; ; ) {
                        localClassNotFoundException.printStackTrace();
                    }
                }
            }
        }
        return (Class[]) localArrayList.toArray(new Class[0]);
    }

    public abstract String a();

    protected abstract Map<String, String> b();

    public String c() {
        return a(a(), b());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */