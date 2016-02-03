package org.apache.commons.lang.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.lang.ArrayUtils;

public class ReflectionToStringBuilder
        extends ToStringBuilder {
    private boolean appendStatics = false;
    private boolean appendTransients = false;
    private String[] excludeFieldNames;
    private Class upToClass = null;

    public ReflectionToStringBuilder(Object paramObject) {
        super(paramObject);
    }

    public ReflectionToStringBuilder(Object paramObject, ToStringStyle paramToStringStyle) {
        super(paramObject, paramToStringStyle);
    }

    public ReflectionToStringBuilder(Object paramObject, ToStringStyle paramToStringStyle, StringBuffer paramStringBuffer) {
        super(paramObject, paramToStringStyle, paramStringBuffer);
    }

    public ReflectionToStringBuilder(Object paramObject, ToStringStyle paramToStringStyle, StringBuffer paramStringBuffer, Class paramClass, boolean paramBoolean) {
        super(paramObject, paramToStringStyle, paramStringBuffer);
        setUpToClass(paramClass);
        setAppendTransients(paramBoolean);
    }

    public ReflectionToStringBuilder(Object paramObject, ToStringStyle paramToStringStyle, StringBuffer paramStringBuffer, Class paramClass, boolean paramBoolean1, boolean paramBoolean2) {
        super(paramObject, paramToStringStyle, paramStringBuffer);
        setUpToClass(paramClass);
        setAppendTransients(paramBoolean1);
        setAppendStatics(paramBoolean2);
    }

    static String[] toNoNullStringArray(Collection paramCollection) {
        if (paramCollection == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        return toNoNullStringArray(paramCollection.toArray());
    }

    static String[] toNoNullStringArray(Object[] paramArrayOfObject) {
        ArrayList localArrayList = new ArrayList(paramArrayOfObject.length);
        int i = 0;
        while (i < paramArrayOfObject.length) {
            Object localObject = paramArrayOfObject[i];
            if (localObject != null) {
                localArrayList.add(localObject.toString());
            }
            i += 1;
        }
        return (String[]) localArrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    public static String toString(Object paramObject) {
        return toString(paramObject, null, false, false, null);
    }

    public static String toString(Object paramObject, ToStringStyle paramToStringStyle) {
        return toString(paramObject, paramToStringStyle, false, false, null);
    }

    public static String toString(Object paramObject, ToStringStyle paramToStringStyle, boolean paramBoolean) {
        return toString(paramObject, paramToStringStyle, paramBoolean, false, null);
    }

    public static String toString(Object paramObject, ToStringStyle paramToStringStyle, boolean paramBoolean, Class paramClass) {
        return new ReflectionToStringBuilder(paramObject, paramToStringStyle, null, paramClass, paramBoolean).toString();
    }

    public static String toString(Object paramObject, ToStringStyle paramToStringStyle, boolean paramBoolean1, boolean paramBoolean2) {
        return toString(paramObject, paramToStringStyle, paramBoolean1, paramBoolean2, null);
    }

    public static String toString(Object paramObject, ToStringStyle paramToStringStyle, boolean paramBoolean1, boolean paramBoolean2, Class paramClass) {
        return new ReflectionToStringBuilder(paramObject, paramToStringStyle, null, paramClass, paramBoolean1, paramBoolean2).toString();
    }

    public static String toStringExclude(Object paramObject, String paramString) {
        return toStringExclude(paramObject, new String[]{paramString});
    }

    public static String toStringExclude(Object paramObject, Collection paramCollection) {
        return toStringExclude(paramObject, toNoNullStringArray(paramCollection));
    }

    public static String toStringExclude(Object paramObject, String[] paramArrayOfString) {
        return new ReflectionToStringBuilder(paramObject).setExcludeFieldNames(paramArrayOfString).toString();
    }

    protected boolean accept(Field paramField) {
        if (paramField.getName().indexOf('$') != -1) {
        }
        while (((Modifier.isTransient(paramField.getModifiers())) && (!isAppendTransients())) || ((Modifier.isStatic(paramField.getModifiers())) && (!isAppendStatics())) || ((getExcludeFieldNames() != null) && (Arrays.binarySearch(getExcludeFieldNames(), paramField.getName()) >= 0))) {
            return false;
        }
        return true;
    }

    protected void appendFieldsIn(Class paramClass) {
        if (paramClass.isArray()) {
            reflectionAppendArray(getObject());
            return;
        }
        paramClass = paramClass.getDeclaredFields();
        AccessibleObject.setAccessible(paramClass, true);
        int i = 0;
        while (i < paramClass.length) {
            Field localField = paramClass[i];
            String str = localField.getName();
            if (accept(localField)) {
            }
            try {
                append(str, getValue(localField));
                i += 1;
            } catch (IllegalAccessException paramClass) {
                throw new InternalError("Unexpected IllegalAccessException: " + paramClass.getMessage());
            }
        }
    }

    public String[] getExcludeFieldNames() {
        return this.excludeFieldNames;
    }

    public Class getUpToClass() {
        return this.upToClass;
    }

    protected Object getValue(Field paramField)
            throws IllegalArgumentException, IllegalAccessException {
        return paramField.get(getObject());
    }

    public boolean isAppendStatics() {
        return this.appendStatics;
    }

    public boolean isAppendTransients() {
        return this.appendTransients;
    }

    public ToStringBuilder reflectionAppendArray(Object paramObject) {
        getStyle().reflectionAppendArrayDetail(getStringBuffer(), null, paramObject);
        return this;
    }

    public void setAppendStatics(boolean paramBoolean) {
        this.appendStatics = paramBoolean;
    }

    public void setAppendTransients(boolean paramBoolean) {
        this.appendTransients = paramBoolean;
    }

    public ReflectionToStringBuilder setExcludeFieldNames(String[] paramArrayOfString) {
        if (paramArrayOfString == null) {
            this.excludeFieldNames = null;
            return this;
        }
        this.excludeFieldNames = toNoNullStringArray(paramArrayOfString);
        Arrays.sort(this.excludeFieldNames);
        return this;
    }

    public void setUpToClass(Class paramClass) {
        if (paramClass != null) {
            Object localObject = getObject();
            if ((localObject != null) && (!paramClass.isInstance(localObject))) {
                throw new IllegalArgumentException("Specified class is not a superclass of the object");
            }
        }
        this.upToClass = paramClass;
    }

    public String toString() {
        if (getObject() == null) {
            return getStyle().getNullText();
        }
        Class localClass = getObject().getClass();
        appendFieldsIn(localClass);
        while ((localClass.getSuperclass() != null) && (localClass != getUpToClass())) {
            localClass = localClass.getSuperclass();
            appendFieldsIn(localClass);
        }
        return super.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/builder/ReflectionToStringBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */