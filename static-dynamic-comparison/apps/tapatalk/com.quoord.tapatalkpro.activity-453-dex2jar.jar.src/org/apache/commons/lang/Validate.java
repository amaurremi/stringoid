package org.apache.commons.lang;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class Validate {
    public static void allElementsOfType(Collection paramCollection, Class paramClass) {
        notNull(paramCollection);
        notNull(paramClass);
        int i = 0;
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
            if (!paramClass.isInstance(paramCollection.next())) {
                throw new IllegalArgumentException("The validated collection contains an element not of type " + paramClass.getName() + " at index: " + i);
            }
            i += 1;
        }
    }

    public static void allElementsOfType(Collection paramCollection, Class paramClass, String paramString) {
        notNull(paramCollection);
        notNull(paramClass);
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
            if (!paramClass.isInstance(paramCollection.next())) {
                throw new IllegalArgumentException(paramString);
            }
        }
    }

    public static void isTrue(boolean paramBoolean) {
        if (!paramBoolean) {
            throw new IllegalArgumentException("The validated expression is false");
        }
    }

    public static void isTrue(boolean paramBoolean, String paramString) {
        if (!paramBoolean) {
            throw new IllegalArgumentException(paramString);
        }
    }

    public static void isTrue(boolean paramBoolean, String paramString, double paramDouble) {
        if (!paramBoolean) {
            throw new IllegalArgumentException(paramString + paramDouble);
        }
    }

    public static void isTrue(boolean paramBoolean, String paramString, long paramLong) {
        if (!paramBoolean) {
            throw new IllegalArgumentException(paramString + paramLong);
        }
    }

    public static void isTrue(boolean paramBoolean, String paramString, Object paramObject) {
        if (!paramBoolean) {
            throw new IllegalArgumentException(paramString + paramObject);
        }
    }

    public static void noNullElements(Collection paramCollection) {
        notNull(paramCollection);
        int i = 0;
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
            if (paramCollection.next() == null) {
                throw new IllegalArgumentException("The validated collection contains null element at index: " + i);
            }
            i += 1;
        }
    }

    public static void noNullElements(Collection paramCollection, String paramString) {
        notNull(paramCollection);
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
            if (paramCollection.next() == null) {
                throw new IllegalArgumentException(paramString);
            }
        }
    }

    public static void noNullElements(Object[] paramArrayOfObject) {
        notNull(paramArrayOfObject);
        int i = 0;
        while (i < paramArrayOfObject.length) {
            if (paramArrayOfObject[i] == null) {
                throw new IllegalArgumentException("The validated array contains null element at index: " + i);
            }
            i += 1;
        }
    }

    public static void noNullElements(Object[] paramArrayOfObject, String paramString) {
        notNull(paramArrayOfObject);
        int i = 0;
        while (i < paramArrayOfObject.length) {
            if (paramArrayOfObject[i] == null) {
                throw new IllegalArgumentException(paramString);
            }
            i += 1;
        }
    }

    public static void notEmpty(String paramString) {
        notEmpty(paramString, "The validated string is empty");
    }

    public static void notEmpty(String paramString1, String paramString2) {
        if ((paramString1 == null) || (paramString1.length() == 0)) {
            throw new IllegalArgumentException(paramString2);
        }
    }

    public static void notEmpty(Collection paramCollection) {
        notEmpty(paramCollection, "The validated collection is empty");
    }

    public static void notEmpty(Collection paramCollection, String paramString) {
        if ((paramCollection == null) || (paramCollection.size() == 0)) {
            throw new IllegalArgumentException(paramString);
        }
    }

    public static void notEmpty(Map paramMap) {
        notEmpty(paramMap, "The validated map is empty");
    }

    public static void notEmpty(Map paramMap, String paramString) {
        if ((paramMap == null) || (paramMap.size() == 0)) {
            throw new IllegalArgumentException(paramString);
        }
    }

    public static void notEmpty(Object[] paramArrayOfObject) {
        notEmpty(paramArrayOfObject, "The validated array is empty");
    }

    public static void notEmpty(Object[] paramArrayOfObject, String paramString) {
        if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0)) {
            throw new IllegalArgumentException(paramString);
        }
    }

    public static void notNull(Object paramObject) {
        notNull(paramObject, "The validated object is null");
    }

    public static void notNull(Object paramObject, String paramString) {
        if (paramObject == null) {
            throw new IllegalArgumentException(paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/Validate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */