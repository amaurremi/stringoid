package org.apache.commons.lang.enums;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;

public abstract class Enum
        implements Comparable, Serializable {
    private static final Map EMPTY_MAP = Collections.unmodifiableMap(new HashMap(0));
    private static Map cEnumClasses = new WeakHashMap();
    static Class class$org$apache$commons$lang$enums$Enum;
    static Class class$org$apache$commons$lang$enums$ValuedEnum;
    private static final long serialVersionUID = -487045951170455942L;
    private final transient int iHashCode;
    private final String iName;
    protected transient String iToString = null;

    protected Enum(String paramString) {
        init(paramString);
        this.iName = paramString;
        this.iHashCode = (getEnumClass().hashCode() + 7 + paramString.hashCode() * 3);
    }

    static Class class$(String paramString) {
        try {
            paramString = Class.forName(paramString);
            return paramString;
        } catch (ClassNotFoundException paramString) {
            throw new NoClassDefFoundError(paramString.getMessage());
        }
    }

    private static Entry createEntry(Class paramClass) {
        Entry localEntry = new Entry();
        label105:
        label112:
        label119:
        for (paramClass = paramClass.getSuperclass(); ; paramClass = paramClass.getSuperclass()) {
            Object localObject;
            if (paramClass != null) {
                if (class$org$apache$commons$lang$enums$Enum != null) {
                    break label105;
                }
                localObject = class$("org.apache.commons.lang.enums.Enum");
                class$org$apache$commons$lang$enums$Enum = (Class) localObject;
                if (paramClass != localObject) {
                    if (class$org$apache$commons$lang$enums$ValuedEnum != null) {
                        break label112;
                    }
                    localObject = class$("org.apache.commons.lang.enums.ValuedEnum");
                    class$org$apache$commons$lang$enums$ValuedEnum = (Class) localObject;
                }
            }
            for (; ; ) {
                if (paramClass != localObject) {
                    localObject = (Entry) cEnumClasses.get(paramClass);
                    if (localObject == null) {
                        break label119;
                    }
                    localEntry.list.addAll(((Entry) localObject).list);
                    localEntry.map.putAll(((Entry) localObject).map);
                }
                return localEntry;
                localObject = class$org$apache$commons$lang$enums$Enum;
                break;
                localObject = class$org$apache$commons$lang$enums$ValuedEnum;
            }
        }
    }

    private static Entry getEntry(Class paramClass) {
        if (paramClass == null) {
            throw new IllegalArgumentException("The Enum Class must not be null");
        }
        if (class$org$apache$commons$lang$enums$Enum == null) {
            localObject = class$("org.apache.commons.lang.enums.Enum");
            class$org$apache$commons$lang$enums$Enum = (Class) localObject;
        }
        while (!((Class) localObject).isAssignableFrom(paramClass)) {
            throw new IllegalArgumentException("The Class must be a subclass of Enum");
            localObject = class$org$apache$commons$lang$enums$Enum;
        }
        Entry localEntry = (Entry) cEnumClasses.get(paramClass);
        Object localObject = localEntry;
        if (localEntry == null) {
        }
        try {
            Class.forName(paramClass.getName(), true, paramClass.getClassLoader());
            localObject = (Entry) cEnumClasses.get(paramClass);
            return (Entry) localObject;
        } catch (Exception paramClass) {
        }
        return localEntry;
    }

    protected static Enum getEnum(Class paramClass, String paramString) {
        paramClass = getEntry(paramClass);
        if (paramClass == null) {
            return null;
        }
        return (Enum) paramClass.map.get(paramString);
    }

    protected static List getEnumList(Class paramClass) {
        paramClass = getEntry(paramClass);
        if (paramClass == null) {
            return Collections.EMPTY_LIST;
        }
        return paramClass.unmodifiableList;
    }

    protected static Map getEnumMap(Class paramClass) {
        paramClass = getEntry(paramClass);
        if (paramClass == null) {
            return EMPTY_MAP;
        }
        return paramClass.unmodifiableMap;
    }

    private String getNameInOtherClassLoader(Object paramObject) {
        try {
            paramObject = (String) paramObject.getClass().getMethod("getName", null).invoke(paramObject, null);
            return (String) paramObject;
        } catch (InvocationTargetException paramObject) {
            throw new IllegalStateException("This should not happen");
        } catch (IllegalAccessException paramObject) {
            for (; ; ) {
            }
        } catch (NoSuchMethodException paramObject) {
            for (; ; ) {
            }
        }
    }

    private void init(String paramString) {
        if (StringUtils.isEmpty(paramString)) {
            throw new IllegalArgumentException("The Enum name must not be empty or null");
        }
        Class localClass2 = getEnumClass();
        if (localClass2 == null) {
            throw new IllegalArgumentException("getEnumClass() must not be null");
        }
        Class localClass1 = getClass();
        int j = 0;
        Object localObject1;
        for (; ; ) {
            int i = j;
            if (localClass1 != null) {
                if (class$org$apache$commons$lang$enums$Enum != null) {
                    break label130;
                }
                localObject1 = class$("org.apache.commons.lang.enums.Enum");
                class$org$apache$commons$lang$enums$Enum = (Class) localObject1;
                i = j;
                if (localClass1 != localObject1) {
                    if (class$org$apache$commons$lang$enums$ValuedEnum != null) {
                        break label138;
                    }
                    localObject1 = class$("org.apache.commons.lang.enums.ValuedEnum");
                    class$org$apache$commons$lang$enums$ValuedEnum = (Class) localObject1;
                }
            }
            for (; ; ) {
                i = j;
                if (localClass1 != localObject1) {
                    if (localClass1 != localClass2) {
                        break label146;
                    }
                    i = 1;
                }
                if (i != 0) {
                    break label156;
                }
                throw new IllegalArgumentException("getEnumClass() must return a superclass of this class");
                label130:
                localObject1 = class$org$apache$commons$lang$enums$Enum;
                break;
                label138:
                localObject1 = class$org$apache$commons$lang$enums$ValuedEnum;
            }
            label146:
            localClass1 = localClass1.getSuperclass();
        }
        label156:
        if (class$org$apache$commons$lang$enums$Enum == null) {
            localClass1 = class$("org.apache.commons.lang.enums.Enum");
            class$org$apache$commons$lang$enums$Enum = localClass1;
        }
        for (; ; ) {
            try {
                Object localObject2 = (Entry) cEnumClasses.get(localClass2);
                localObject1 = localObject2;
                if (localObject2 == null) {
                    localObject1 = createEntry(localClass2);
                    localObject2 = new WeakHashMap();
                    ((Map) localObject2).putAll(cEnumClasses);
                    ((Map) localObject2).put(localClass2, localObject1);
                    cEnumClasses = (Map) localObject2;
                }
                if (!((Entry) localObject1).map.containsKey(paramString)) {
                    break;
                }
                throw new IllegalArgumentException("The Enum name must be unique, '" + paramString + "' has already been added");
            } finally {
            }
            localClass1 = class$org$apache$commons$lang$enums$Enum;
        }
        ((Entry) localObject1).map.put(paramString, this);
        ((Entry) localObject1).list.add(this);
    }

    protected static Iterator iterator(Class paramClass) {
        return getEnumList(paramClass).iterator();
    }

    public int compareTo(Object paramObject) {
        if (paramObject == this) {
            return 0;
        }
        if (paramObject.getClass() != getClass()) {
            if (paramObject.getClass().getName().equals(getClass().getName())) {
                return this.iName.compareTo(getNameInOtherClassLoader(paramObject));
            }
            throw new ClassCastException("Different enum class '" + ClassUtils.getShortClassName(paramObject.getClass()) + "'");
        }
        return this.iName.compareTo(((Enum) paramObject).iName);
    }

    public final boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1;
        if (paramObject == this) {
            bool1 = true;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramObject == null);
            if (paramObject.getClass() == getClass()) {
                return this.iName.equals(((Enum) paramObject).iName);
            }
            bool1 = bool2;
        } while (!paramObject.getClass().getName().equals(getClass().getName()));
        return this.iName.equals(getNameInOtherClassLoader(paramObject));
    }

    public Class getEnumClass() {
        return getClass();
    }

    public final String getName() {
        return this.iName;
    }

    public final int hashCode() {
        return this.iHashCode;
    }

    protected Object readResolve() {
        Entry localEntry = (Entry) cEnumClasses.get(getEnumClass());
        if (localEntry == null) {
            return null;
        }
        return localEntry.map.get(getName());
    }

    public String toString() {
        if (this.iToString == null) {
            String str = ClassUtils.getShortClassName(getEnumClass());
            this.iToString = (str + "[" + getName() + "]");
        }
        return this.iToString;
    }

    private static class Entry {
        final List list = new ArrayList(25);
        final Map map = new HashMap();
        final List unmodifiableList = Collections.unmodifiableList(this.list);
        final Map unmodifiableMap = Collections.unmodifiableMap(this.map);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/org/apache/commons/lang/enums/Enum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */