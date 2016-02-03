package org.apache.commons.lang;

import java.io.Serializable;

public class ObjectUtils {
    public static final Null NULL = new Null();

    public static StringBuffer appendIdentityToString(StringBuffer paramStringBuffer, Object paramObject) {
        if (paramObject == null) {
            return null;
        }
        StringBuffer localStringBuffer = paramStringBuffer;
        if (paramStringBuffer == null) {
            localStringBuffer = new StringBuffer();
        }
        return localStringBuffer.append(paramObject.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(paramObject)));
    }

    public static Object defaultIfNull(Object paramObject1, Object paramObject2) {
        if (paramObject1 != null) {
            return paramObject1;
        }
        return paramObject2;
    }

    public static boolean equals(Object paramObject1, Object paramObject2) {
        if (paramObject1 == paramObject2) {
            return true;
        }
        if ((paramObject1 == null) || (paramObject2 == null)) {
            return false;
        }
        return paramObject1.equals(paramObject2);
    }

    public static int hashCode(Object paramObject) {
        if (paramObject == null) {
            return 0;
        }
        return paramObject.hashCode();
    }

    public static String identityToString(Object paramObject) {
        if (paramObject == null) {
            return null;
        }
        StringBuffer localStringBuffer = new StringBuffer();
        identityToString(localStringBuffer, paramObject);
        return localStringBuffer.toString();
    }

    public static void identityToString(StringBuffer paramStringBuffer, Object paramObject) {
        if (paramObject == null) {
            throw new NullPointerException("Cannot get the toString of a null identity");
        }
        paramStringBuffer.append(paramObject.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(paramObject)));
    }

    public static Object max(Comparable paramComparable1, Comparable paramComparable2) {
        if ((paramComparable1 != null) && (paramComparable2 != null)) {
            if (paramComparable1.compareTo(paramComparable2) < 0) {
            }
        }
        while (paramComparable1 != null) {
            return paramComparable1;
            return paramComparable2;
        }
        return paramComparable2;
    }

    public static Object min(Comparable paramComparable1, Comparable paramComparable2) {
        if ((paramComparable1 != null) && (paramComparable2 != null)) {
            if (paramComparable1.compareTo(paramComparable2) >= 1) {
            }
        }
        while (paramComparable1 != null) {
            return paramComparable1;
            return paramComparable2;
        }
        return paramComparable2;
    }

    public static String toString(Object paramObject) {
        if (paramObject == null) {
            return "";
        }
        return paramObject.toString();
    }

    public static String toString(Object paramObject, String paramString) {
        if (paramObject == null) {
            return paramString;
        }
        return paramObject.toString();
    }

    public static class Null
            implements Serializable {
        private static final long serialVersionUID = 7092611880189329093L;

        private Object readResolve() {
            return ObjectUtils.NULL;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/ObjectUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */