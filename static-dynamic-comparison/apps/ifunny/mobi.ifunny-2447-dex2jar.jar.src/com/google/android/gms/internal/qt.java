package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.DataSource;

public class qt {
    private static final ThreadLocal<String> a = new ThreadLocal();

    public static DataSource a(DataSource paramDataSource) {
        if (!paramDataSource.h()) {
        }
        String str;
        do {
            return paramDataSource;
            str = (String) a.get();
        } while ((a()) || (str.equals(paramDataSource.d())));
        return paramDataSource.j();
    }

    public static String a(String paramString) {
        return a(paramString, (String) a.get());
    }

    private static String a(String paramString1, String paramString2) {
        if ((paramString1 == null) || (paramString2 == null)) {
            return paramString1;
        }
        byte[] arrayOfByte = new byte[paramString1.length() + paramString2.length()];
        System.arraycopy(paramString1.getBytes(), 0, arrayOfByte, 0, paramString1.length());
        System.arraycopy(paramString2.getBytes(), 0, arrayOfByte, paramString1.length(), paramString2.length());
        return Integer.toHexString(px.a(arrayOfByte, 0, arrayOfByte.length, 0));
    }

    public static boolean a() {
        String str = (String) a.get();
        return (str == null) || (str.startsWith("com.google"));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/qt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */