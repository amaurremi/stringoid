package com.facebook.internal;

import java.util.Collection;
import java.util.Iterator;

public final class Validate {
    public static <T> void containsNoNulls(Collection<T> paramCollection, String paramString) {
        notNull(paramCollection, paramString);
        paramCollection = paramCollection.iterator();
        do {
            if (!paramCollection.hasNext()) {
                return;
            }
        } while ((Object) paramCollection.next() != null);
        throw new NullPointerException("Container '" + paramString + "' cannot contain null values");
    }

    public static <T> void notEmpty(Collection<T> paramCollection, String paramString) {
        if (paramCollection.isEmpty()) {
            throw new IllegalArgumentException("Container '" + paramString + "' cannot be empty");
        }
    }

    public static <T> void notEmptyAndContainsNoNulls(Collection<T> paramCollection, String paramString) {
        containsNoNulls(paramCollection, paramString);
        notEmpty(paramCollection, paramString);
    }

    public static void notNull(Object paramObject, String paramString) {
        if (paramObject == null) {
            throw new NullPointerException("Argument '" + paramString + "' cannot be null");
        }
    }

    public static void notNullOrEmpty(String paramString1, String paramString2) {
        if (Utility.isNullOrEmpty(paramString1)) {
            throw new IllegalArgumentException("Argument '" + paramString2 + "' cannot be null or empty");
        }
    }

    public static void oneOf(Object paramObject, String paramString, Object... paramVarArgs) {
        int j = paramVarArgs.length;
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                throw new IllegalArgumentException("Argument '" + paramString + "' was not one of the allowed values");
            }
            Object localObject = paramVarArgs[i];
            if (localObject != null) {
                if (!localObject.equals(paramObject)) {
                }
            } else {
                while (paramObject == null) {
                    return;
                }
            }
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/internal/Validate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */