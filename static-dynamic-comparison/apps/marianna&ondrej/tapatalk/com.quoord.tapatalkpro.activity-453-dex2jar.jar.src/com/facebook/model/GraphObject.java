package com.facebook.model;

import com.facebook.FacebookGraphObjectException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract interface GraphObject {
    public abstract Map<String, Object> asMap();

    public abstract <T extends GraphObject> T cast(Class<T> paramClass);

    public abstract JSONObject getInnerJSONObject();

    public abstract Object getProperty(String paramString);

    public abstract void removeProperty(String paramString);

    public abstract void setProperty(String paramString, Object paramObject);

    public static final class Factory {
        private static final SimpleDateFormat[] dateFormats = {new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US), new SimpleDateFormat("yyyy-MM-dd", Locale.US)};
        private static final HashSet<Class<?>> verifiedGraphObjectClasses = new HashSet();

        static <U> U coerceValueToExpectedType(Object paramObject, Class<U> paramClass, ParameterizedType paramParameterizedType) {
            if (paramObject == null) {
                return null;
            }
            Class localClass = paramObject.getClass();
            if (paramClass.isAssignableFrom(localClass)) {
                return (U) paramObject;
            }
            if (paramClass.isPrimitive()) {
                return (U) paramObject;
            }
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
            int j;
            int i;
            if (String.class.equals(paramClass)) {
                if ((Double.class.isAssignableFrom(localClass)) || (Float.class.isAssignableFrom(localClass))) {
                    return String.format("%f", new Object[]{paramObject});
                }
                if (Number.class.isAssignableFrom(localClass)) {
                    return String.format("%d", new Object[]{paramObject});
                }
            } else if ((Date.class.equals(paramClass)) && (String.class.isAssignableFrom(localClass))) {
                paramParameterizedType = dateFormats;
                j = paramParameterizedType.length;
                i = 0;
            }
            for (; ; ) {
                if (i >= j) {
                    throw new FacebookGraphObjectException("Can't convert type" + localClass.getName() + " to " + paramClass.getName());
                }
                Date localDate = paramParameterizedType[i];
                try {
                    localDate = localDate.parse((String) paramObject);
                    if (localDate != null) {
                        return localDate;
                    }
                } catch (ParseException localParseException) {
                    i += 1;
                }
            }
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
            paramJSONObject = new GraphObjectProxy(paramJSONObject, paramClass);
            return (GraphObject) Proxy.newProxyInstance(GraphObject.class.getClassLoader(), new Class[]{paramClass}, paramJSONObject);
        }

        private static Map<String, Object> createGraphObjectProxyForMap(JSONObject paramJSONObject) {
            paramJSONObject = new GraphObjectProxy(paramJSONObject, Map.class);
            return (Map) Proxy.newProxyInstance(GraphObject.class.getClassLoader(), new Class[]{Map.class}, paramJSONObject);
        }

        public static <T> GraphObjectList<T> createList(Class<T> paramClass) {
            return createList(new JSONArray(), paramClass);
        }

        public static <T> GraphObjectList<T> createList(JSONArray paramJSONArray, Class<T> paramClass) {
            return new GraphObjectListImpl(paramJSONArray, paramClass);
        }

        private static Object getUnderlyingJSONObject(Object paramObject) {
            Class localClass = paramObject.getClass();
            Object localObject;
            if (GraphObject.class.isAssignableFrom(localClass)) {
                localObject = ((GraphObject) paramObject).getInnerJSONObject();
            }
            do {
                return localObject;
                localObject = paramObject;
            } while (!GraphObjectList.class.isAssignableFrom(localClass));
            return ((GraphObjectList) paramObject).getInnerJSONArray();
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
            if (i >= j) {
                recordClassHasBeenVerified(paramClass);
                return;
            }
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
                label256:
                do {
                    do {
                        do {
                            do {
                                throw new FacebookGraphObjectException("Factory can't proxy method: " + localMethod.toString());
                            } while ((!str.startsWith("set")) || (str.length() <= 3));
                            break;
                        } while ((k != 0) || (localClass == Void.TYPE));
                        if (!bool) {
                            break label256;
                        }
                    }
                    while (Utility.isNullOrEmpty(((PropertyName) localMethod.getAnnotation(PropertyName.class)).value()));
                    break;
                } while ((!str.startsWith("get")) || (str.length() <= 3));
            }
        }

        private static final class GraphObjectListImpl<T>
                extends AbstractList<T>
                implements GraphObjectList<T> {
            private final Class<?> itemType;
            private final JSONArray state;

            public GraphObjectListImpl(JSONArray paramJSONArray, Class<?> paramClass) {
                Validate.notNull(paramJSONArray, "state");
                Validate.notNull(paramClass, "itemType");
                this.state = paramJSONArray;
                this.itemType = paramClass;
            }

            private void checkIndex(int paramInt) {
                if ((paramInt < 0) || (paramInt >= this.state.length())) {
                    throw new IndexOutOfBoundsException();
                }
            }

            private void put(int paramInt, T paramT) {
                paramT = GraphObject.Factory.getUnderlyingJSONObject(paramT);
                try {
                    this.state.put(paramInt, paramT);
                    return;
                } catch (JSONException paramT) {
                    throw new IllegalArgumentException(paramT);
                }
            }

            public void add(int paramInt, T paramT) {
                if (paramInt < 0) {
                    throw new IndexOutOfBoundsException();
                }
                if (paramInt < size()) {
                    throw new UnsupportedOperationException("Only adding items at the end of the list is supported.");
                }
                put(paramInt, paramT);
            }

            public final <U extends GraphObject> GraphObjectList<U> castToListOf(Class<U> paramClass) {
                if (GraphObject.class.isAssignableFrom(this.itemType)) {
                    if (paramClass.isAssignableFrom(this.itemType)) {
                        return this;
                    }
                    return GraphObject.Factory.createList(this.state, paramClass);
                }
                throw new FacebookGraphObjectException("Can't cast GraphObjectCollection of non-GraphObject type " + this.itemType);
            }

            public void clear() {
                throw new UnsupportedOperationException();
            }

            public boolean equals(Object paramObject) {
                if (this == paramObject) {
                    return true;
                }
                if (getClass() != paramObject.getClass()) {
                    return false;
                }
                paramObject = (GraphObjectListImpl) paramObject;
                return this.state.equals(((GraphObjectListImpl) paramObject).state);
            }

            public T get(int paramInt) {
                checkIndex(paramInt);
                return (T) GraphObject.Factory.coerceValueToExpectedType(this.state.opt(paramInt), this.itemType, null);
            }

            public final JSONArray getInnerJSONArray() {
                return this.state;
            }

            public int hashCode() {
                return this.state.hashCode();
            }

            public boolean remove(Object paramObject) {
                throw new UnsupportedOperationException();
            }

            public boolean removeAll(Collection<?> paramCollection) {
                throw new UnsupportedOperationException();
            }

            public boolean retainAll(Collection<?> paramCollection) {
                throw new UnsupportedOperationException();
            }

            public T set(int paramInt, T paramT) {
                checkIndex(paramInt);
                Object localObject = get(paramInt);
                put(paramInt, paramT);
                return (T) localObject;
            }

            public int size() {
                return this.state.length();
            }

            public String toString() {
                return String.format("GraphObjectList{itemType=%s, state=%s}", new Object[]{this.itemType.getSimpleName(), this.state});
            }
        }

        private static final class GraphObjectProxy
                extends GraphObject.Factory.ProxyBase<JSONObject> {
            private static final String CASTTOMAP_METHOD = "asMap";
            private static final String CAST_METHOD = "cast";
            private static final String CLEAR_METHOD = "clear";
            private static final String CONTAINSKEY_METHOD = "containsKey";
            private static final String CONTAINSVALUE_METHOD = "containsValue";
            private static final String ENTRYSET_METHOD = "entrySet";
            private static final String GETINNERJSONOBJECT_METHOD = "getInnerJSONObject";
            private static final String GETPROPERTY_METHOD = "getProperty";
            private static final String GET_METHOD = "get";
            private static final String ISEMPTY_METHOD = "isEmpty";
            private static final String KEYSET_METHOD = "keySet";
            private static final String PUTALL_METHOD = "putAll";
            private static final String PUT_METHOD = "put";
            private static final String REMOVEPROPERTY_METHOD = "removeProperty";
            private static final String REMOVE_METHOD = "remove";
            private static final String SETPROPERTY_METHOD = "setProperty";
            private static final String SIZE_METHOD = "size";
            private static final String VALUES_METHOD = "values";
            private final Class<?> graphObjectClass;

            public GraphObjectProxy(JSONObject paramJSONObject, Class<?> paramClass) {
                super();
                this.graphObjectClass = paramClass;
            }

            private final Object proxyGraphObjectGettersAndSetters(Method paramMethod, Object[] paramArrayOfObject)
                    throws JSONException {
                Object localObject1 = paramMethod.getName();
                int i = paramMethod.getParameterTypes().length;
                Object localObject2 = (PropertyName) paramMethod.getAnnotation(PropertyName.class);
                if (localObject2 != null) {
                }
                for (localObject1 = ((PropertyName) localObject2).value(); i == 0; localObject1 = GraphObject.Factory.convertCamelCaseToLowercaseWithUnderscores(((String) localObject1).substring(3))) {
                    paramArrayOfObject = ((JSONObject) this.state).opt((String) localObject1);
                    localObject1 = paramMethod.getReturnType();
                    localObject2 = paramMethod.getGenericReturnType();
                    paramMethod = null;
                    if ((localObject2 instanceof ParameterizedType)) {
                        paramMethod = (ParameterizedType) localObject2;
                    }
                    return GraphObject.Factory.coerceValueToExpectedType(paramArrayOfObject, (Class) localObject1, paramMethod);
                }
                if (i == 1) {
                    paramArrayOfObject = paramArrayOfObject[0];
                    if (GraphObject.class.isAssignableFrom(paramArrayOfObject.getClass())) {
                        paramMethod = ((GraphObject) paramArrayOfObject).getInnerJSONObject();
                    }
                    for (; ; ) {
                        ((JSONObject) this.state).putOpt((String) localObject1, paramMethod);
                        return null;
                        if (GraphObjectList.class.isAssignableFrom(paramArrayOfObject.getClass())) {
                            paramMethod = ((GraphObjectList) paramArrayOfObject).getInnerJSONArray();
                        } else {
                            paramMethod = paramArrayOfObject;
                            if (Iterable.class.isAssignableFrom(paramArrayOfObject.getClass())) {
                                paramMethod = new JSONArray();
                                paramArrayOfObject = ((Iterable) paramArrayOfObject).iterator();
                                while (paramArrayOfObject.hasNext()) {
                                    localObject2 = paramArrayOfObject.next();
                                    if (GraphObject.class.isAssignableFrom(localObject2.getClass())) {
                                        paramMethod.put(((GraphObject) localObject2).getInnerJSONObject());
                                    } else {
                                        paramMethod.put(localObject2);
                                    }
                                }
                            }
                        }
                    }
                }
                return throwUnexpectedMethodSignature(paramMethod);
            }

            private final Object proxyGraphObjectMethods(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) {
                String str = paramMethod.getName();
                if (str.equals("cast")) {
                    paramMethod = (Class) paramArrayOfObject[0];
                    if ((paramMethod != null) && (paramMethod.isAssignableFrom(this.graphObjectClass))) {
                        return paramObject;
                    }
                    return GraphObject.Factory.createGraphObjectProxy(paramMethod, (JSONObject) this.state);
                }
                if (str.equals("getInnerJSONObject")) {
                    return ((GraphObjectProxy) Proxy.getInvocationHandler(paramObject)).state;
                }
                if (str.equals("asMap")) {
                    return GraphObject.Factory.createGraphObjectProxyForMap((JSONObject) this.state);
                }
                if (str.equals("getProperty")) {
                    return ((JSONObject) this.state).opt((String) paramArrayOfObject[0]);
                }
                if (str.equals("setProperty")) {
                    return setJSONProperty(paramArrayOfObject);
                }
                if (str.equals("removeProperty")) {
                    ((JSONObject) this.state).remove((String) paramArrayOfObject[0]);
                    return null;
                }
                return throwUnexpectedMethodSignature(paramMethod);
            }

            private final Object proxyMapMethods(Method paramMethod, Object[] paramArrayOfObject) {
                String str = paramMethod.getName();
                if (str.equals("clear")) {
                    JsonUtil.jsonObjectClear((JSONObject) this.state);
                    return null;
                }
                if (str.equals("containsKey")) {
                    return Boolean.valueOf(((JSONObject) this.state).has((String) paramArrayOfObject[0]));
                }
                if (str.equals("containsValue")) {
                    return Boolean.valueOf(JsonUtil.jsonObjectContainsValue((JSONObject) this.state, paramArrayOfObject[0]));
                }
                if (str.equals("entrySet")) {
                    return JsonUtil.jsonObjectEntrySet((JSONObject) this.state);
                }
                if (str.equals("get")) {
                    return ((JSONObject) this.state).opt((String) paramArrayOfObject[0]);
                }
                if (str.equals("isEmpty")) {
                    if (((JSONObject) this.state).length() == 0) {
                        return Boolean.valueOf(true);
                    }
                    return Boolean.valueOf(false);
                }
                if (str.equals("keySet")) {
                    return JsonUtil.jsonObjectKeySet((JSONObject) this.state);
                }
                if (str.equals("put")) {
                    return setJSONProperty(paramArrayOfObject);
                }
                if (str.equals("putAll")) {
                    paramMethod = null;
                    if ((paramArrayOfObject[0] instanceof Map)) {
                        paramMethod = (Map) paramArrayOfObject[0];
                    }
                    for (; ; ) {
                        JsonUtil.jsonObjectPutAll((JSONObject) this.state, paramMethod);
                        return null;
                        if ((paramArrayOfObject[0] instanceof GraphObject)) {
                            paramMethod = ((GraphObject) paramArrayOfObject[0]).asMap();
                        }
                    }
                }
                if (str.equals("remove")) {
                    ((JSONObject) this.state).remove((String) paramArrayOfObject[0]);
                    return null;
                }
                if (str.equals("size")) {
                    return Integer.valueOf(((JSONObject) this.state).length());
                }
                if (str.equals("values")) {
                    return JsonUtil.jsonObjectValues((JSONObject) this.state);
                }
                return throwUnexpectedMethodSignature(paramMethod);
            }

            private Object setJSONProperty(Object[] paramArrayOfObject) {
                String str = (String) paramArrayOfObject[0];
                paramArrayOfObject = GraphObject.Factory.getUnderlyingJSONObject(paramArrayOfObject[1]);
                try {
                    ((JSONObject) this.state).putOpt(str, paramArrayOfObject);
                    return null;
                } catch (JSONException paramArrayOfObject) {
                    throw new IllegalArgumentException(paramArrayOfObject);
                }
            }

            public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
                    throws Throwable {
                Class localClass = paramMethod.getDeclaringClass();
                if (localClass == Object.class) {
                    return proxyObjectMethods(paramObject, paramMethod, paramArrayOfObject);
                }
                if (localClass == Map.class) {
                    return proxyMapMethods(paramMethod, paramArrayOfObject);
                }
                if (localClass == GraphObject.class) {
                    return proxyGraphObjectMethods(paramObject, paramMethod, paramArrayOfObject);
                }
                if (GraphObject.class.isAssignableFrom(localClass)) {
                    return proxyGraphObjectGettersAndSetters(paramMethod, paramArrayOfObject);
                }
                return throwUnexpectedMethodSignature(paramMethod);
            }

            public String toString() {
                return String.format("GraphObject{graphObjectClass=%s, state=%s}", new Object[]{this.graphObjectClass.getSimpleName(), this.state});
            }
        }

        private static abstract class ProxyBase<STATE>
                implements InvocationHandler {
            private static final String EQUALS_METHOD = "equals";
            private static final String TOSTRING_METHOD = "toString";
            protected final STATE state;

            protected ProxyBase(STATE paramSTATE) {
                this.state = paramSTATE;
            }

            protected final Object proxyObjectMethods(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
                    throws Throwable {
                paramObject = paramMethod.getName();
                if (((String) paramObject).equals("equals")) {
                    paramObject = paramArrayOfObject[0];
                    if (paramObject == null) {
                        return Boolean.valueOf(false);
                    }
                    paramObject = Proxy.getInvocationHandler(paramObject);
                    if (!(paramObject instanceof GraphObject.Factory.GraphObjectProxy)) {
                        return Boolean.valueOf(false);
                    }
                    paramObject = (GraphObject.Factory.GraphObjectProxy) paramObject;
                    return Boolean.valueOf(this.state.equals(((GraphObject.Factory.GraphObjectProxy) paramObject).state));
                }
                if (((String) paramObject).equals("toString")) {
                    return toString();
                }
                return paramMethod.invoke(this.state, paramArrayOfObject);
            }

            protected final Object throwUnexpectedMethodSignature(Method paramMethod) {
                throw new FacebookGraphObjectException(getClass().getName() + " got an unexpected method signature: " + paramMethod.toString());
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/facebook/model/GraphObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */