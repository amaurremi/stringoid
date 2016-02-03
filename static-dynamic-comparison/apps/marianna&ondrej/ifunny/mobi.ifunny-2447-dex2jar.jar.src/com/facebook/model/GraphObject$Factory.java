package com.facebook.model;

import com.facebook.FacebookGraphObjectException;
import com.facebook.internal.Utility;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public final class GraphObject$Factory {
    private static final SimpleDateFormat[] dateFormats = {new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US), new SimpleDateFormat("yyyy-MM-dd", Locale.US)};
    private static final HashSet<Class<?>> verifiedGraphObjectClasses = new HashSet();

    static <U> U coerceValueToExpectedType(Object paramObject, Class<U> paramClass, ParameterizedType paramParameterizedType) {
        Object localObject;
        if (paramObject == null) {
            if (Boolean.TYPE.equals(paramClass)) {
                localObject = Boolean.valueOf(false);
            }
        }
        Class localClass;
        do {
            do {
                return (U) localObject;
                if (Character.TYPE.equals(paramClass)) {
                    return Character.valueOf('\000');
                }
                if (paramClass.isPrimitive()) {
                    return Integer.valueOf(0);
                }
                return null;
                localClass = paramObject.getClass();
                localObject = paramObject;
            } while (paramClass.isAssignableFrom(localClass));
            localObject = paramObject;
        } while (paramClass.isPrimitive());
        if (GraphObject.class.isAssignableFrom(paramClass)) {
            if (JSONObject.class.isAssignableFrom(localClass)) {
                return createGraphObjectProxy(paramClass, (JSONObject) paramObject);
            }
            if (GraphObject.class.isAssignableFrom(localClass)) {
                return ((GraphObject) paramObject).cast(paramClass);
            }
            throw new FacebookGraphObjectException("Can't create GraphObject from " + localClass.getName());
        }
        if ((Iterable.class.equals(paramClass)) || (Collection.class.equals(paramClass)) || (List.class.equals(paramClass)) || (GraphObjectList.class.equals(paramClass))) {
            if (paramParameterizedType == null) {
                throw new FacebookGraphObjectException("can't infer generic type of: " + paramClass.toString());
            }
            paramClass = paramParameterizedType.getActualTypeArguments();
            if ((paramClass == null) || (paramClass.length != 1) || (!(paramClass[0] instanceof Class))) {
                throw new FacebookGraphObjectException("Expect collection properties to be of a type with exactly one generic parameter.");
            }
            paramClass = (Class) paramClass[0];
            if (JSONArray.class.isAssignableFrom(localClass)) {
                return createList((JSONArray) paramObject, paramClass);
            }
            throw new FacebookGraphObjectException("Can't create Collection from " + localClass.getName());
        }
        if (String.class.equals(paramClass)) {
            if ((Double.class.isAssignableFrom(localClass)) || (Float.class.isAssignableFrom(localClass))) {
                return String.format("%f", new Object[]{paramObject});
            }
            if (Number.class.isAssignableFrom(localClass)) {
                return String.format("%d", new Object[]{paramObject});
            }
        } else if ((Date.class.equals(paramClass)) && (String.class.isAssignableFrom(localClass))) {
            paramParameterizedType = dateFormats;
            int j = paramParameterizedType.length;
            int i = 0;
            while (i < j) {
                localObject = paramParameterizedType[i];
                try {
                    localObject = ((SimpleDateFormat) localObject).parse((String) paramObject);
                    if (localObject != null) {
                        return (U) localObject;
                    }
                } catch (ParseException localParseException) {
                    i += 1;
                }
            }
        }
        throw new FacebookGraphObjectException("Can't convert type" + localClass.getName() + " to " + paramClass.getName());
    }

    static String convertCamelCaseToLowercaseWithUnderscores(String paramString) {
        return paramString.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase(Locale.US);
    }

    public static GraphObject create() {
        return create(GraphObject.class);
    }

    public static <T extends GraphObject> T create(Class<T> paramClass) {
        return createGraphObjectProxy(paramClass, new JSONObject());
    }

    public static GraphObject create(JSONObject paramJSONObject) {
        return create(paramJSONObject, GraphObject.class);
    }

    public static <T extends GraphObject> T create(JSONObject paramJSONObject, Class<T> paramClass) {
        return createGraphObjectProxy(paramClass, paramJSONObject);
    }

    private static <T extends GraphObject> T createGraphObjectProxy(Class<T> paramClass, JSONObject paramJSONObject) {
        verifyCanProxyClass(paramClass);
        paramJSONObject = new GraphObject.Factory.GraphObjectProxy(paramJSONObject, paramClass);
        return (GraphObject) Proxy.newProxyInstance(GraphObject.class.getClassLoader(), new Class[]{paramClass}, paramJSONObject);
    }

    private static Map<String, Object> createGraphObjectProxyForMap(JSONObject paramJSONObject) {
        paramJSONObject = new GraphObject.Factory.GraphObjectProxy(paramJSONObject, Map.class);
        return (Map) Proxy.newProxyInstance(GraphObject.class.getClassLoader(), new Class[]{Map.class}, paramJSONObject);
    }

    public static <T> GraphObjectList<T> createList(Class<T> paramClass) {
        return createList(new JSONArray(), paramClass);
    }

    public static <T> GraphObjectList<T> createList(JSONArray paramJSONArray, Class<T> paramClass) {
        return new GraphObject.Factory.GraphObjectListImpl(paramJSONArray, paramClass);
    }

    private static Object getUnderlyingJSONObject(Object paramObject) {
        if (paramObject == null) {
            localObject1 = null;
        }
        Object localObject2;
        do {
            return localObject1;
            localObject2 = paramObject.getClass();
            if (GraphObject.class.isAssignableFrom((Class) localObject2)) {
                return ((GraphObject) paramObject).getInnerJSONObject();
            }
            if (GraphObjectList.class.isAssignableFrom((Class) localObject2)) {
                return ((GraphObjectList) paramObject).getInnerJSONArray();
            }
            localObject1 = paramObject;
        } while (!Iterable.class.isAssignableFrom((Class) localObject2));
        Object localObject1 = new JSONArray();
        paramObject = ((Iterable) paramObject).iterator();
        while (((Iterator) paramObject).hasNext()) {
            localObject2 = ((Iterator) paramObject).next();
            if (GraphObject.class.isAssignableFrom(localObject2.getClass())) {
                ((JSONArray) localObject1).put(((GraphObject) localObject2).getInnerJSONObject());
            } else {
                ((JSONArray) localObject1).put(localObject2);
            }
        }
        return localObject1;
    }

    private static <T extends GraphObject> boolean hasClassBeenVerified(Class<T> paramClass) {
        try {
            boolean bool = verifiedGraphObjectClasses.contains(paramClass);
            return bool;
        } finally {
            paramClass =finally;
            throw paramClass;
        }
    }

    public static boolean hasSameId(GraphObject paramGraphObject1, GraphObject paramGraphObject2) {
        if ((paramGraphObject1 == null) || (paramGraphObject2 == null) || (!paramGraphObject1.asMap().containsKey("id")) || (!paramGraphObject2.asMap().containsKey("id"))) {
        }
        do {
            return false;
            if (paramGraphObject1.equals(paramGraphObject2)) {
                return true;
            }
            paramGraphObject1 = paramGraphObject1.getProperty("id");
            paramGraphObject2 = paramGraphObject2.getProperty("id");
        }
        while ((paramGraphObject1 == null) || (paramGraphObject2 == null) || (!(paramGraphObject1 instanceof String)) || (!(paramGraphObject2 instanceof String)));
        return paramGraphObject1.equals(paramGraphObject2);
    }

    private static <T extends GraphObject> void recordClassHasBeenVerified(Class<T> paramClass) {
        try {
            verifiedGraphObjectClasses.add(paramClass);
            return;
        } finally {
            paramClass =finally;
            throw paramClass;
        }
    }

    private static <T extends GraphObject> void verifyCanProxyClass(Class<T> paramClass) {
        if (hasClassBeenVerified(paramClass)) {
            return;
        }
        if (!paramClass.isInterface()) {
            throw new FacebookGraphObjectException("Factory can only wrap interfaces, not class: " + paramClass.getName());
        }
        Method[] arrayOfMethod = paramClass.getMethods();
        int j = arrayOfMethod.length;
        int i = 0;
        if (i < j) {
            Method localMethod = arrayOfMethod[i];
            String str = localMethod.getName();
            int k = localMethod.getParameterTypes().length;
            Class localClass = localMethod.getReturnType();
            boolean bool = localMethod.isAnnotationPresent(PropertyName.class);
            if (localMethod.getDeclaringClass().isAssignableFrom(GraphObject.class)) {
            }
            for (; ; ) {
                i += 1;
                break;
                if ((k == 1) && (localClass == Void.TYPE)) {
                    if (bool) {
                        if (!Utility.isNullOrEmpty(((PropertyName) localMethod.getAnnotation(PropertyName.class)).value())) {
                            continue;
                        }
                    }
                }
                label257:
                do {
                    do {
                        do {
                            do {
                                throw new FacebookGraphObjectException("Factory can't proxy method: " + localMethod.toString());
                            } while ((!str.startsWith("set")) || (str.length() <= 3));
                            break;
                        } while ((k != 0) || (localClass == Void.TYPE));
                        if (!bool) {
                            break label257;
                        }
                    }
                    while (Utility.isNullOrEmpty(((PropertyName) localMethod.getAnnotation(PropertyName.class)).value()));
                    break;
                } while ((!str.startsWith("get")) || (str.length() <= 3));
            }
        }
        recordClassHasBeenVerified(paramClass);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/model/GraphObject$Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */