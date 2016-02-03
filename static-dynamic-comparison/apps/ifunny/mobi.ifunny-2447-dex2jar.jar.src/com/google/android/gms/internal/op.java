package com.google.android.gms.internal;

import android.text.TextUtils;

import java.util.Locale;

public final class op {
    public static String a(Locale paramLocale) {
        StringBuilder localStringBuilder = new StringBuilder(20);
        localStringBuilder.append(paramLocale.getLanguage());
        String str = paramLocale.getCountry();
        if (!TextUtils.isEmpty(str)) {
            localStringBuilder.append('-').append(str);
        }
        paramLocale = paramLocale.getVariant();
        if (!TextUtils.isEmpty(paramLocale)) {
            localStringBuilder.append('-').append(paramLocale);
        }
        return localStringBuilder.toString();
    }

    public static <T> boolean a(T paramT1, T paramT2) {
        return ((paramT1 == null) && (paramT2 == null)) || ((paramT1 != null) && (paramT2 != null) && (paramT1.equals(paramT2)));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/op.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */