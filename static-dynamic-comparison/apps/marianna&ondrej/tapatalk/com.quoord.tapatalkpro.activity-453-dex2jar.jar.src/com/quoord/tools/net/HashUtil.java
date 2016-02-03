package com.quoord.tools.net;

import java.io.UnsupportedEncodingException;

public class HashUtil {
    public static final Boolean HASHUTIL_DEFUALT_BOOLEAN_VAL = Boolean.valueOf(false);
    public static final Integer HASHUTIL_DEFUALT_INTEGER_VAL = Integer.valueOf(0);
    public static final String HASHUTIL_DEFUALT_STRING_VAL = "";

    private static String bytes2String(byte[] paramArrayOfByte, String paramString) {
        if (paramArrayOfByte == null) {
            return paramString;
        }
        try {
            String str = new String(paramArrayOfByte, "UTF-8");
            paramArrayOfByte = str;
        } catch (UnsupportedEncodingException paramString) {
            for (; ; ) {
                paramArrayOfByte = new String(paramArrayOfByte);
            }
        } catch (Exception paramArrayOfByte) {
            for (; ; ) {
                paramArrayOfByte = paramString;
            }
        }
        return paramArrayOfByte;
    }

    public static Boolean getBoolean(Object paramObject) {
        return getBoolean(paramObject, HASHUTIL_DEFUALT_BOOLEAN_VAL);
    }

    public static Boolean getBoolean(Object paramObject, Boolean paramBoolean) {
        boolean bool = true;
        if (paramObject == null) {
            return paramBoolean;
        }
        for (; ; ) {
            try {
                if ((paramObject instanceof Boolean)) {
                    return (Boolean) paramObject;
                }
                if ((paramObject instanceof Integer)) {
                    if (((Integer) paramObject).intValue() == 1) {
                        return Boolean.valueOf(bool);
                    }
                } else {
                    String str = null;
                    if ((paramObject instanceof byte[])) {
                        str = bytes2String((byte[]) paramObject, null);
                    }
                    if ((paramObject instanceof String)) {
                        str = (String) paramObject;
                    }
                    if (str == null) {
                        break;
                    }
                    if ((str.equals("1")) || (str.equalsIgnoreCase("true"))) {
                        return Boolean.valueOf(true);
                    }
                    return Boolean.valueOf(false);
                }
            } catch (Exception paramObject) {
                return paramBoolean;
            }
            bool = false;
        }
    }

    public static Integer getInteger(Object paramObject) {
        return getInteger(paramObject, HASHUTIL_DEFUALT_INTEGER_VAL);
    }

    public static Integer getInteger(Object paramObject, Integer paramInteger) {
        if (paramObject == null) {
            return paramInteger;
        }
        for (; ; ) {
            try {
                if ((paramObject instanceof Integer)) {
                    return (Integer) paramObject;
                }
                if ((paramObject instanceof Boolean)) {
                    if (((Boolean) paramObject).booleanValue()) {
                        i = 1;
                        return Integer.valueOf(i);
                    }
                } else {
                    String str = null;
                    if ((paramObject instanceof byte[])) {
                        str = bytes2String((byte[]) paramObject, null);
                    }
                    if ((paramObject instanceof String)) {
                        str = (String) paramObject;
                    }
                    if (str == null) {
                        break;
                    }
                    try {
                        paramObject = Integer.valueOf(str);
                        return (Integer) paramObject;
                    } catch (NumberFormatException paramObject) {
                        paramObject = paramInteger;
                        continue;
                    }
                }
                int i = 0;
            } catch (Exception paramObject) {
                return paramInteger;
            }
        }
    }

    public static String getString(Object paramObject) {
        return getString(paramObject, "");
    }

    public static String getString(Object paramObject, String paramString) {
        if (paramObject == null) {
        }
        for (; ; ) {
            return paramString;
            try {
                if ((paramObject instanceof String)) {
                    return (String) paramObject;
                }
                if ((paramObject instanceof Boolean)) {
                    return ((Boolean) paramObject).toString();
                }
                if ((paramObject instanceof Integer)) {
                    return ((Integer) paramObject).toString();
                }
                if ((paramObject instanceof byte[])) {
                    paramObject = bytes2String((byte[]) paramObject, paramString);
                    return (String) paramObject;
                }
            } catch (Exception paramObject) {
            }
        }
        return paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tools/net/HashUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */