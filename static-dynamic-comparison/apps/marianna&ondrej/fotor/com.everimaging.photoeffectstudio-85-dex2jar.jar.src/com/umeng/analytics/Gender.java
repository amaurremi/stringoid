package com.umeng.analytics;

import com.umeng.analytics.d.j;

import java.util.Locale;

public enum Gender {
    public int value;

    private Gender(int paramInt) {
        this.value = paramInt;
    }

    public static Gender getGender(int paramInt) {
        switch (paramInt) {
            default:
                return Unknown;
            case 1:
                return Male;
        }
        return Female;
    }

    public static j transGender(Gender paramGender) {
        switch (4. a[paramGender.ordinal()])
        {
            default:
                return j.c;
            case 1:
                return j.a;
        }
        return j.b;
    }

    public int value() {
        return this.value;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/Gender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */