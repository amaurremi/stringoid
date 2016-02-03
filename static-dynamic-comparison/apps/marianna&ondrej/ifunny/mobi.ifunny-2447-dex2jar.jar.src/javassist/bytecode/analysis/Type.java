package javassist.bytecode.analysis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

public class Type {
    public static final Type BOGUS;
    public static final Type BOOLEAN;
    public static final Type BYTE;
    public static final Type CHAR;
    public static final Type CLONEABLE;
    public static final Type DOUBLE;
    public static final Type FLOAT;
    public static final Type INTEGER;
    public static final Type LONG;
    public static final Type OBJECT;
    public static final Type RETURN_ADDRESS;
    public static final Type SERIALIZABLE;
    public static final Type SHORT;
    public static final Type THROWABLE;
    public static final Type TOP;
    public static final Type UNINIT;
    public static final Type VOID;
    private static final Map prims = new IdentityHashMap();
    private final CtClass clazz;
    private final boolean special;

    static {
        DOUBLE = new Type(CtClass.doubleType);
        BOOLEAN = new Type(CtClass.booleanType);
        LONG = new Type(CtClass.longType);
        CHAR = new Type(CtClass.charType);
        BYTE = new Type(CtClass.byteType);
        SHORT = new Type(CtClass.shortType);
        INTEGER = new Type(CtClass.intType);
        FLOAT = new Type(CtClass.floatType);
        VOID = new Type(CtClass.voidType);
        UNINIT = new Type(null);
        RETURN_ADDRESS = new Type(null, true);
        TOP = new Type(null, true);
        BOGUS = new Type(null, true);
        OBJECT = lookupType("java.lang.Object");
        SERIALIZABLE = lookupType("java.io.Serializable");
        CLONEABLE = lookupType("java.lang.Cloneable");
        THROWABLE = lookupType("java.lang.Throwable");
        prims.put(CtClass.doubleType, DOUBLE);
        prims.put(CtClass.longType, LONG);
        prims.put(CtClass.charType, CHAR);
        prims.put(CtClass.shortType, SHORT);
        prims.put(CtClass.intType, INTEGER);
        prims.put(CtClass.floatType, FLOAT);
        prims.put(CtClass.byteType, BYTE);
        prims.put(CtClass.booleanType, BOOLEAN);
        prims.put(CtClass.voidType, VOID);
    }

    Type(CtClass paramCtClass) {
        this(paramCtClass, false);
    }

    private Type(CtClass paramCtClass, boolean paramBoolean) {
        this.clazz = paramCtClass;
        this.special = paramBoolean;
    }

    private Type createArray(Type paramType, int paramInt) {
        if ((paramType instanceof MultiType)) {
            return new MultiArrayType((MultiType) paramType, paramInt);
        }
        String str = arrayName(paramType.clazz.getName(), paramInt);
        try {
            paramType = get(getClassPool(paramType).get(str));
            return paramType;
        } catch (NotFoundException paramType) {
            throw new RuntimeException(paramType);
        }
    }

    static boolean eq(CtClass paramCtClass1, CtClass paramCtClass2) {
        return (paramCtClass1 == paramCtClass2) || ((paramCtClass1 != null) && (paramCtClass2 != null) && (paramCtClass1.getName().equals(paramCtClass2.getName())));
    }

    private Map findCommonInterfaces(Type paramType) {
        return findCommonInterfaces(getAllInterfaces(paramType.clazz, null), getAllInterfaces(this.clazz, null));
    }

    private static CtClass findCommonSuperClass(CtClass paramCtClass1, CtClass paramCtClass2) {
        Object localObject2 = paramCtClass2;
        Object localObject1 = paramCtClass1;
        if ((eq((CtClass) localObject1, (CtClass) localObject2)) && (((CtClass) localObject1).getSuperclass() != null)) {
            return (CtClass) localObject1;
        }
        CtClass localCtClass1 = ((CtClass) localObject1).getSuperclass();
        CtClass localCtClass2 = ((CtClass) localObject2).getSuperclass();
        if (localCtClass2 == null) {
        }
        for (; ; ) {
            localObject1 = ((CtClass) localObject1).getSuperclass();
            if (localObject1 == null) {
                while (!eq(paramCtClass1, paramCtClass2)) {
                    paramCtClass1 = paramCtClass1.getSuperclass();
                    paramCtClass2 = paramCtClass2.getSuperclass();
                }
                if (localCtClass1 == null) {
                    localObject1 = localObject2;
                    localObject2 = paramCtClass1;
                    paramCtClass1 = paramCtClass2;
                    paramCtClass2 = (CtClass) localObject2;
                    continue;
                }
                localObject2 = localCtClass2;
                localObject1 = localCtClass1;
                break;
            }
            paramCtClass1 = paramCtClass1.getSuperclass();
        }
        return paramCtClass1;
    }

    private Map findExclusiveDeclaredInterfaces(Type paramType, CtClass paramCtClass) {
        paramType = getDeclaredInterfaces(paramType.clazz, null);
        Map localMap = getDeclaredInterfaces(this.clazz, null);
        paramCtClass = getAllInterfaces(paramCtClass, null).keySet().iterator();
        while (paramCtClass.hasNext()) {
            Object localObject = paramCtClass.next();
            paramType.remove(localObject);
            localMap.remove(localObject);
        }
        return findCommonInterfaces(paramType, localMap);
    }

    public static Type get(CtClass paramCtClass) {
        Type localType = (Type) prims.get(paramCtClass);
        if (localType != null) {
            return localType;
        }
        return new Type(paramCtClass);
    }

    private ClassPool getClassPool(Type paramType) {
        paramType = paramType.clazz.getClassPool();
        if (paramType != null) {
            return paramType;
        }
        return ClassPool.getDefault();
    }

    private static Type lookupType(String paramString) {
        try {
            paramString = new Type(ClassPool.getDefault().get(paramString));
            return paramString;
        } catch (NotFoundException paramString) {
            throw new RuntimeException(paramString);
        }
    }

    private Type mergeArray(Type paramType) {
        Type localType1 = getRootComponent(paramType);
        Type localType2 = getRootComponent(this);
        int i = paramType.getDimensions();
        int j = getDimensions();
        if (i == j) {
            paramType = localType2.merge(localType1);
            if (paramType == BOGUS) {
                return OBJECT;
            }
            return createArray(paramType, j);
        }
        if (i < j) {
        }
        for (paramType = localType1; (eq(CLONEABLE.clazz, paramType.clazz)) || (eq(SERIALIZABLE.clazz, paramType.clazz)); paramType = localType2) {
            return createArray(paramType, i);
            i = j;
        }
        return createArray(OBJECT, i);
    }

    private Type mergeClasses(Type paramType) {
        CtClass localCtClass = findCommonSuperClass(this.clazz, paramType.clazz);
        if (localCtClass.getSuperclass() == null) {
            paramType = findCommonInterfaces(paramType);
            if (paramType.size() == 1) {
                return new Type((CtClass) paramType.values().iterator().next());
            }
            if (paramType.size() > 1) {
                return new MultiType(paramType);
            }
            return new Type(localCtClass);
        }
        paramType = findExclusiveDeclaredInterfaces(paramType, localCtClass);
        if (paramType.size() > 0) {
            return new MultiType(paramType, new Type(localCtClass));
        }
        return new Type(localCtClass);
    }

    String arrayName(String paramString, int paramInt) {
        int i = paramString.length();
        int j = paramInt * 2 + i;
        char[] arrayOfChar = new char[j];
        paramString.getChars(0, i, arrayOfChar, 0);
        paramInt = i;
        while (paramInt < j) {
            i = paramInt + 1;
            arrayOfChar[paramInt] = '[';
            paramInt = i + 1;
            arrayOfChar[i] = ']';
        }
        return new String(arrayOfChar);
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof Type)) {
        }
        while ((paramObject.getClass() != getClass()) || (!eq(this.clazz, ((Type) paramObject).clazz))) {
            return false;
        }
        return true;
    }

    Map findCommonInterfaces(Map paramMap1, Map paramMap2) {
        Object localObject = paramMap2.keySet().iterator();
        while (((Iterator) localObject).hasNext()) {
            if (!paramMap1.containsKey(((Iterator) localObject).next())) {
                ((Iterator) localObject).remove();
            }
        }
        paramMap1 = new ArrayList(paramMap2.values()).iterator();
        while (paramMap1.hasNext()) {
            localObject = (CtClass) paramMap1.next();
            try {
                localObject = ((CtClass) localObject).getInterfaces();
                int i = 0;
                while (i < localObject.length) {
                    paramMap2.remove(localObject[i].getName());
                    i += 1;
                }
                return paramMap2;
            } catch (NotFoundException paramMap1) {
                throw new RuntimeException(paramMap1);
            }
        }
    }

    Map getAllInterfaces(CtClass paramCtClass, Map paramMap) {
        Object localObject1 = paramMap;
        if (paramMap == null) {
            localObject1 = new HashMap();
        }
        paramMap = paramCtClass;
        if (paramCtClass.isInterface()) {
            ((Map) localObject1).put(paramCtClass.getName(), paramCtClass);
            paramMap = paramCtClass;
        }
        try {
            do {
                paramCtClass = paramMap.getInterfaces();
                int i = 0;
                while (i < paramCtClass.length) {
                    Object localObject2 = paramCtClass[i];
                    ((Map) localObject1).put(((CtClass) localObject2).getName(), localObject2);
                    getAllInterfaces((CtClass) localObject2, (Map) localObject1);
                    i += 1;
                }
                paramCtClass = paramMap.getSuperclass();
                paramMap = paramCtClass;
            } while (paramCtClass != null);
            return (Map) localObject1;
        } catch (NotFoundException paramCtClass) {
            throw new RuntimeException(paramCtClass);
        }
    }

    public Type getComponent() {
        Object localObject;
        if ((this.clazz == null) || (!this.clazz.isArray())) {
            localObject = null;
        }
        for (; ; ) {
            return (Type) localObject;
            try {
                CtClass localCtClass = this.clazz.getComponentType();
                Type localType = (Type) prims.get(localCtClass);
                localObject = localType;
                if (localType != null) {
                    continue;
                }
                return new Type(localCtClass);
            } catch (NotFoundException localNotFoundException) {
                throw new RuntimeException(localNotFoundException);
            }
        }
    }

    public CtClass getCtClass() {
        return this.clazz;
    }

    Map getDeclaredInterfaces(CtClass paramCtClass, Map paramMap) {
        localObject = paramMap;
        if (paramMap == null) {
            localObject = new HashMap();
        }
        if (paramCtClass.isInterface()) {
            ((Map) localObject).put(paramCtClass.getName(), paramCtClass);
        }
        try {
            paramCtClass = paramCtClass.getInterfaces();
            int i = 0;
            while (i < paramCtClass.length) {
                paramMap = paramCtClass[i];
                ((Map) localObject).put(paramMap.getName(), paramMap);
                getDeclaredInterfaces(paramMap, (Map) localObject);
                i += 1;
            }
            return (Map) localObject;
        } catch (NotFoundException paramCtClass) {
            throw new RuntimeException(paramCtClass);
        }
    }

    public int getDimensions() {
        int i = 0;
        int k = 0;
        if (!isArray()) {
            return k;
        }
        String str = this.clazz.getName();
        int j = str.length() - 1;
        for (; ; ) {
            k = i;
            if (str.charAt(j) != ']') {
                break;
            }
            j -= 2;
            i += 1;
        }
    }

    Type getRootComponent(Type paramType) {
        while (paramType.isArray()) {
            paramType = paramType.getComponent();
        }
        return paramType;
    }

    public int getSize() {
        if ((this.clazz == CtClass.doubleType) || (this.clazz == CtClass.longType) || (this == TOP)) {
            return 2;
        }
        return 1;
    }

    public boolean isArray() {
        return (this.clazz != null) && (this.clazz.isArray());
    }

    public boolean isAssignableFrom(Type paramType) {
        if (this == paramType) {
        }
        while (((paramType == UNINIT) && (isReference())) || ((this == UNINIT) && (paramType.isReference()))) {
            return true;
        }
        if ((paramType instanceof MultiType)) {
            return ((MultiType) paramType).isAssignableTo(this);
        }
        if ((paramType instanceof MultiArrayType)) {
            return ((MultiArrayType) paramType).isAssignableTo(this);
        }
        if ((this.clazz == null) || (this.clazz.isPrimitive())) {
            return false;
        }
        try {
            boolean bool = paramType.clazz.subtypeOf(this.clazz);
            return bool;
        } catch (Exception paramType) {
            throw new RuntimeException(paramType);
        }
    }

    public boolean isReference() {
        return (!this.special) && ((this.clazz == null) || (!this.clazz.isPrimitive()));
    }

    public boolean isSpecial() {
        return this.special;
    }

    public Type merge(Type paramType) {
        if (paramType == this) {
        }
        while ((paramType == null) || (paramType == UNINIT)) {
            return this;
        }
        if (this == UNINIT) {
            return paramType;
        }
        if ((!paramType.isReference()) || (!isReference())) {
            return BOGUS;
        }
        if ((paramType instanceof MultiType)) {
            return paramType.merge(this);
        }
        if ((paramType.isArray()) && (isArray())) {
            return mergeArray(paramType);
        }
        try {
            paramType = mergeClasses(paramType);
            return paramType;
        } catch (NotFoundException paramType) {
            throw new RuntimeException(paramType);
        }
    }

    boolean popChanged() {
        return false;
    }

    public String toString() {
        if (this == BOGUS) {
            return "BOGUS";
        }
        if (this == UNINIT) {
            return "UNINIT";
        }
        if (this == RETURN_ADDRESS) {
            return "RETURN ADDRESS";
        }
        if (this == TOP) {
            return "TOP";
        }
        if (this.clazz == null) {
            return "null";
        }
        return this.clazz.getName();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/analysis/Type.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */