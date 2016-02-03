package com.quoord.tools.net;

import android.content.SharedPreferences;

public class PrefsUtil {
    public static final Boolean PROFILEUTIL_DEFUALT_BOOLEAN_VAL = Boolean.valueOf(false);
    public static final float PROFILEUTIL_DEFUALT_FLOAT_VAL = 0.0F;
    public static final int PROFILEUTIL_DEFUALT_INT_VAL = 0;
    public static final long PROFILEUTIL_DEFUALT_LONG_VAL = 0L;
    public static final String PROFILEUTIL_DEFUALT_STRING_VAL = "";
    SharedPreferences pref = null;

    public PrefsUtil(SharedPreferences paramSharedPreferences) {
        this.pref = paramSharedPreferences;
    }

    public Boolean getBoolean(String paramString) {
        return getBoolean(paramString, PROFILEUTIL_DEFUALT_BOOLEAN_VAL);
    }

    public Boolean getBoolean(String paramString, Boolean paramBoolean) {
        try {
            boolean bool = this.pref.getBoolean(paramString, paramBoolean.booleanValue());
            return Boolean.valueOf(bool);
        } catch (Exception paramString) {
        }
        return paramBoolean;
    }

    public float getFloat(String paramString) {
        return getFloat(paramString, 0.0F);
    }

    public float getFloat(String paramString, float paramFloat) {
        try {
            float f = this.pref.getFloat(paramString, paramFloat);
            return f;
        } catch (Exception paramString) {
        }
        return paramFloat;
    }

    public int getInt(String paramString) {
        return getInt(paramString, 0);
    }

    public int getInt(String paramString, int paramInt) {
        try {
            int i = this.pref.getInt(paramString, paramInt);
            return i;
        } catch (Exception paramString) {
        }
        return paramInt;
    }

    public long getLong(String paramString) {
        return getLong(paramString, 0L);
    }

    public long getLong(String paramString, long paramLong) {
        try {
            long l = this.pref.getLong(paramString, paramLong);
            return l;
        } catch (Exception paramString) {
        }
        return paramLong;
    }

    public String getString(String paramString) {
        return getString(paramString, "");
    }

    public String getString(String paramString1, String paramString2) {
        try {
            paramString1 = this.pref.getString(paramString1, paramString2);
            return paramString1;
        } catch (Exception paramString1) {
        }
        return paramString2;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/net/PrefsUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */