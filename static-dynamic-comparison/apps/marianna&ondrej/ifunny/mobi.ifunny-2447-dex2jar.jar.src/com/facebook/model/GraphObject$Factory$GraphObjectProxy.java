package com.facebook.model;

import com.facebook.internal.Utility;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

final class GraphObject$Factory$GraphObjectProxy
        extends GraphObject.Factory.ProxyBase<JSONObject> {
    private static final String CASTTOMAP_METHOD = "asMap";
    private static final String CAST_METHOD = "cast";
    private static final String CLEAR_METHOD = "clear";
    private static final String CONTAINSKEY_METHOD = "containsKey";
    private static final String CONTAINSVALUE_METHOD = "containsValue";
    private static final String ENTRYSET_METHOD = "entrySet";
    private static final String GETINNERJSONOBJECT_METHOD = "getInnerJSONObject";
    private static final String GETPROPERTYASLIST_METHOD = "getPropertyAsList";
    private static final String GETPROPERTYAS_METHOD = "getPropertyAs";
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

    public GraphObject$Factory$GraphObjectProxy(JSONObject paramJSONObject, Class<?> paramClass) {
        super(paramJSONObject);
        this.graphObjectClass = paramClass;
    }

    private Object createGraphObjectsFromParameters(CreateGraphObject paramCreateGraphObject, Object paramObject) {
        Object localObject1 = paramObject;
        if (paramCreateGraphObject != null) {
            localObject1 = paramObject;
            if (!Utility.isNullOrEmpty(paramCreateGraphObject.value())) {
                paramCreateGraphObject = paramCreateGraphObject.value();
                if (!List.class.isAssignableFrom(paramObject.getClass())) {
                    break label101;
                }
                localObject1 = GraphObject.Factory.createList(GraphObject.class);
                paramObject = ((List) paramObject).iterator();
                while (((Iterator) paramObject).hasNext()) {
                    Object localObject2 = ((Iterator) paramObject).next();
                    GraphObject localGraphObject = GraphObject.Factory.create();
                    localGraphObject.setProperty(paramCreateGraphObject, localObject2);
                    ((GraphObjectList) localObject1).add(localGraphObject);
                }
            }
        }
        return localObject1;
        label101:
        localObject1 = GraphObject.Factory.create();
        ((GraphObject) localObject1).setProperty(paramCreateGraphObject, paramObject);
        return localObject1;
    }

    private final Object proxyGraphObjectGettersAndSetters(Method paramMethod, Object[] paramArrayOfObject) {
        Object localObject = paramMethod.getName();
        int i = paramMethod.getParameterTypes().length;
        PropertyName localPropertyName = (PropertyName) paramMethod.getAnnotation(PropertyName.class);
        if (localPropertyName != null) {
            localObject = localPropertyName.value();
            if (i != 0) {
                break label99;
            }
            paramArrayOfObject = ((JSONObject) this.state).opt((String) localObject);
            localObject = paramMethod.getReturnType();
            paramMethod = paramMethod.getGenericReturnType();
            if (!(paramMethod instanceof ParameterizedType)) {
                break label146;
            }
        }
        label99:
        label146:
        for (paramMethod = (ParameterizedType) paramMethod; ; paramMethod = null) {
            return GraphObject.Factory.coerceValueToExpectedType(paramArrayOfObject, (Class) localObject, paramMethod);
            localObject = GraphObject.Factory.convertCamelCaseToLowercaseWithUnderscores(((String) localObject).substring(3));
            break;
            if (i == 1) {
                paramMethod = GraphObject.Factory.access$200(createGraphObjectsFromParameters((CreateGraphObject) paramMethod.getAnnotation(CreateGraphObject.class), paramArrayOfObject[0]));
                ((JSONObject) this.state).putOpt((String) localObject, paramMethod);
                return null;
            }
            return throwUnexpectedMethodSignature(paramMethod);
        }
    }

    private final Object proxyGraphObjectMethods(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) {
        String str = paramMethod.getName();
        if (str.equals("cast")) {
            paramMethod = (Class) paramArrayOfObject[0];
            if ((paramMethod != null) && (paramMethod.isAssignableFrom(this.graphObjectClass))) {
                return paramObject;
            }
            return GraphObject.Factory.access$000(paramMethod, (JSONObject) this.state);
        }
        if (str.equals("getInnerJSONObject")) {
            return ((GraphObjectProxy) Proxy.getInvocationHandler(paramObject)).state;
        }
        if (str.equals("asMap")) {
            return GraphObject.Factory.access$100((JSONObject) this.state);
        }
        if (str.equals("getProperty")) {
            return ((JSONObject) this.state).opt((String) paramArrayOfObject[0]);
        }
        if (str.equals("getPropertyAs")) {
            return GraphObject.Factory.coerceValueToExpectedType(((JSONObject) this.state).opt((String) paramArrayOfObject[0]), (Class) paramArrayOfObject[1], null);
        }
        if (str.equals("getPropertyAsList")) {
            return GraphObject.Factory.coerceValueToExpectedType(((JSONObject) this.state).opt((String) paramArrayOfObject[0]), GraphObjectList.class, new GraphObject.Factory.GraphObjectProxy
            .1 (this, (Class) paramArrayOfObject[1]));
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
            }
            for (boolean bool = true; ; bool = false) {
                return Boolean.valueOf(bool);
            }
        }
        if (str.equals("keySet")) {
            return JsonUtil.jsonObjectKeySet((JSONObject) this.state);
        }
        if (str.equals("put")) {
            return setJSONProperty(paramArrayOfObject);
        }
        if (str.equals("putAll")) {
            if ((paramArrayOfObject[0] instanceof Map)) {
            }
            for (paramMethod = (Map) paramArrayOfObject[0]; ; paramMethod = ((GraphObject) paramArrayOfObject[0]).asMap()) {
                JsonUtil.jsonObjectPutAll((JSONObject) this.state, paramMethod);
                return null;
                if (!(paramArrayOfObject[0] instanceof GraphObject)) {
                    break;
                }
            }
            return null;
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
        paramArrayOfObject = GraphObject.Factory.access$200(paramArrayOfObject[1]);
        try {
            ((JSONObject) this.state).putOpt(str, paramArrayOfObject);
            return null;
        } catch (JSONException paramArrayOfObject) {
            throw new IllegalArgumentException(paramArrayOfObject);
        }
    }

    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) {
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/model/GraphObject$Factory$GraphObjectProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */