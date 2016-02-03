package com.mopub.common.util;

public class Numbers {
    public static Double parseDouble(Object paramObject) {
        if ((paramObject instanceof Number)) {
            return Double.valueOf(((Number) paramObject).doubleValue());
        }
        if ((paramObject instanceof String)) {
            try {
                Double localDouble = Double.valueOf((String) paramObject);
                return localDouble;
            } catch (NumberFormatException localNumberFormatException) {
                throw new ClassCastException("Unable to parse " + paramObject + " as double.");
            }
        }
        throw new ClassCastException("Unable to parse " + paramObject + " as double.");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/util/Numbers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */