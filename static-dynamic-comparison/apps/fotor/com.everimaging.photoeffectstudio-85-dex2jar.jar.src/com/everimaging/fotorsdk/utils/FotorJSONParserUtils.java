package com.everimaging.fotorsdk.utils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FotorJSONParserUtils {
    private static JSONArray getJsonArray(JSONObject paramJSONObject, String paramString) {
        JSONArray localJSONArray2 = paramJSONObject.optJSONArray(paramString.substring(0, 1).toLowerCase() + paramString.substring(1));
        JSONArray localJSONArray1 = localJSONArray2;
        if (localJSONArray2 == null) {
            localJSONArray1 = paramJSONObject.optJSONArray(paramString.substring(0, 1).toUpperCase() + paramString.substring(1));
        }
        return localJSONArray1;
    }

    private static JSONObject getJsonObject(JSONObject paramJSONObject, String paramString) {
        JSONObject localJSONObject2 = paramJSONObject.optJSONObject(paramString.substring(0, 1).toLowerCase() + paramString.substring(1));
        JSONObject localJSONObject1 = localJSONObject2;
        if (localJSONObject2 == null) {
            localJSONObject1 = paramJSONObject.optJSONObject(paramString.substring(0, 1).toUpperCase() + paramString.substring(1));
        }
        return localJSONObject1;
    }

    private static <T> T getNewInstance(Class<T> paramClass)
            throws JSONException {
        if (paramClass == null) {
            return null;
        }
        if (paramClass.isInterface()) {
            if (paramClass.equals(List.class)) {
                return new ArrayList();
            }
            if (paramClass.equals(Map.class)) {
                return new HashMap();
            }
            if (paramClass.equals(Set.class)) {
                return new HashSet();
            }
            throw new JSONException("unknown interface : " + paramClass);
        }
        try {
            Object localObject = paramClass.newInstance();
            return (T) localObject;
        } catch (Exception localException) {
            throw new JSONException("unkown class : " + paramClass);
        }
    }

    private static Object getSingleObject(JSONObject paramJSONObject, String paramString) {
        Object localObject2 = paramJSONObject.opt(paramString.substring(0, 1).toLowerCase() + paramString.substring(1));
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = paramJSONObject.opt(paramString.substring(0, 1).toUpperCase() + paramString.substring(1));
        }
        return localObject1;
    }

    private static boolean isArray(Class<?> paramClass) {
        return (paramClass != null) && (paramClass.isArray());
    }

    public static boolean isBoolean(Class<?> paramClass) {
        return (paramClass != null) && ((Boolean.TYPE.isAssignableFrom(paramClass)) || (Boolean.class.isAssignableFrom(paramClass)));
    }

    private static boolean isCollection(Class<?> paramClass) {
        return (paramClass != null) && (Collection.class.isAssignableFrom(paramClass));
    }

    public static boolean isList(Class<?> paramClass) {
        return (paramClass != null) && (List.class.isAssignableFrom(paramClass));
    }

    private static boolean isMap(Class<?> paramClass) {
        return (paramClass != null) && (Map.class.isAssignableFrom(paramClass));
    }

    private static boolean isNull(Object paramObject) {
        if ((paramObject instanceof JSONObject)) {
            return JSONObject.NULL.equals(paramObject);
        }
        return paramObject == null;
    }

    public static boolean isNumber(Class<?> paramClass) {
        return (paramClass != null) && ((Byte.TYPE.isAssignableFrom(paramClass)) || (Short.TYPE.isAssignableFrom(paramClass)) || (Integer.TYPE.isAssignableFrom(paramClass)) || (Long.TYPE.isAssignableFrom(paramClass)) || (Float.TYPE.isAssignableFrom(paramClass)) || (Double.TYPE.isAssignableFrom(paramClass)) || (Number.class.isAssignableFrom(paramClass)));
    }

    private static boolean isObject(Class<?> paramClass) {
        return (paramClass != null) && (!isSingle(paramClass)) && (!isArray(paramClass)) && (!isCollection(paramClass)) && (!isMap(paramClass));
    }

    private static boolean isSingle(Class<?> paramClass) {
        return (isBoolean(paramClass)) || (isNumber(paramClass)) || (isString(paramClass));
    }

    public static boolean isString(Class<?> paramClass) {
        return (paramClass != null) && ((String.class.isAssignableFrom(paramClass)) || (Character.TYPE.isAssignableFrom(paramClass)) || (Character.class.isAssignableFrom(paramClass)));
    }

    public static boolean methodExists(Method[] paramArrayOfMethod, String paramString) {
        boolean bool2 = false;
        int j = paramArrayOfMethod.length;
        int i = 0;
        for (; ; ) {
            boolean bool1 = bool2;
            if (i < j) {
                if (paramString.equals(paramArrayOfMethod[i].getName())) {
                    bool1 = true;
                }
            } else {
                return bool1;
            }
            i += 1;
        }
    }

    public static <T> T[] parseArray(JSONArray paramJSONArray, Class<T> paramClass) {
        Object localObject;
        if ((paramClass == null) || (isNull(paramJSONArray))) {
            localObject = null;
            return (T[]) localObject;
        }
        int j = paramJSONArray.length();
        Object[] arrayOfObject = (Object[]) Array.newInstance(paramClass, j);
        int i = 0;
        for (; ; ) {
            localObject = arrayOfObject;
            if (i >= j) {
                break;
            }
            try {
                arrayOfObject[i] = parseJSONObject(paramJSONArray.getJSONObject(i), paramClass);
                i += 1;
            } catch (JSONException localJSONException) {
                for (; ; ) {
                    localJSONException.printStackTrace();
                }
            }
        }
    }

    public static <T> Collection<T> parseCollection(String paramString, Class<?> paramClass, Class<T> paramClass1)
            throws JSONException {
        if ((paramString == null) || (paramString.length() <= 0) || (paramClass == null) || (paramClass1 == null)) {
        }
        for (; ; ) {
            return null;
            try {
                int i = paramString.indexOf("[");
                if (-1 == i) {
                    break;
                }
                paramClass = paramString.substring(i);
            } catch (JSONException paramString) {
                for (; ; ) {
                    paramString.printStackTrace();
                    paramString = null;
                    continue;
                    paramClass = null;
                }
            }
            if (paramClass != null) {
            }
            for (paramString = new JSONArray(paramClass); isNull(paramString); paramString = new JSONArray(paramString)) {
                return null;
            }
        }
    }

    public static <T> Collection<T> parseCollection(JSONArray paramJSONArray, Class<?> paramClass, Class<T> paramClass1)
            throws JSONException {
        if ((paramClass == null) || (paramClass1 == null) || (isNull(paramJSONArray))) {
            paramClass = null;
            return paramClass;
        }
        Collection localCollection = (Collection) getNewInstance(paramClass);
        int i = 0;
        for (; ; ) {
            paramClass = localCollection;
            if (i >= paramJSONArray.length()) {
                break;
            }
            try {
                localCollection.add(parseJSONObject(paramJSONArray.getJSONObject(i), paramClass1));
                i += 1;
            } catch (JSONException paramClass) {
                for (; ; ) {
                    paramClass.printStackTrace();
                }
            }
        }
    }

    private static String parseFieldName(String paramString) {
        return paramString.substring(1, 2).toLowerCase() + paramString.substring(2);
    }

    private static String parseFullMethodName(String paramString1, String paramString2) {
        if ((paramString1 == null) || ("".equals(paramString1))) {
            return null;
        }
        return paramString2 + paramString1.substring(1);
    }

    public static <T> T parseJSONObject(String paramString, Class<T> paramClass)
            throws JSONException {
        if ((paramClass == null) || (paramString == null) || (paramString.length() == 0)) {
        }
        do {
            return null;
            paramString = new JSONObject(paramString);
        } while (isNull(paramString));
        return (T) parseJSONObject(paramString, paramClass);
    }

    public static <T> T parseJSONObject(JSONObject paramJSONObject, Class<T> paramClass)
            throws JSONException {
        int i = 0;
        if ((isNull(paramJSONObject)) || (paramClass == null)) {
        }
        Object localObject;
        do {
            return null;
            localObject = getNewInstance(paramClass);
        } while (localObject == null);
        if (isMap(paramClass)) {
            setMapField(localObject, paramJSONObject);
            return (T) localObject;
        }
        Method[] arrayOfMethod = paramClass.getDeclaredMethods();
        Field[] arrayOfField = paramClass.getDeclaredFields();
        int j = arrayOfField.length;
        label58:
        Field localField;
        String str;
        if (i < j) {
            localField = arrayOfField[i];
            str = parseFullMethodName(localField.getName(), "set");
            if (methodExists(arrayOfMethod, str)) {
                break label98;
            }
        }
        for (; ; ) {
            i += 1;
            break label58;
            break;
            try {
                label98:
                setField(localObject, paramClass.getMethod(str, new Class[]{localField.getType()}), localField, paramJSONObject);
            } catch (Exception localException) {
                localException.printStackTrace();
            }
        }
    }

    private static void setField(Object paramObject, Method paramMethod, Field paramField, JSONObject paramJSONObject) {
        if ((paramObject == null) || (paramMethod == null) || (paramField == null) || (isNull(paramJSONObject))) {
        }
        String str;
        Class localClass;
        for (; ; ) {
            return;
            str = parseFieldName(paramField.getName());
            localClass = paramField.getType();
            try {
                if (isArray(localClass)) {
                    paramField = localClass.getComponentType();
                    paramJSONObject = getJsonArray(paramJSONObject, str);
                    if (isNull(paramJSONObject)) {
                        continue;
                    }
                    paramField = parseArray(paramJSONObject, paramField);
                    setFieldValue(paramObject, paramMethod, localClass.getSimpleName(), paramField);
                }
            } catch (Exception paramObject) {
                ((Exception) paramObject).printStackTrace();
                return;
            }
        }
        if (isCollection(localClass)) {
            paramField = paramField.getGenericType();
            if (!(paramField instanceof ParameterizedType)) {
                break label302;
            }
            paramField = ((ParameterizedType) paramField).getActualTypeArguments();
            if ((paramField == null) || (paramField.length <= 0)) {
                break label302;
            }
        }
        label302:
        for (paramField = (Class) paramField[0]; ; paramField = null) {
            paramJSONObject = getJsonArray(paramJSONObject, str);
            if (isNull(paramJSONObject)) {
                break;
            }
            paramField = parseCollection(paramJSONObject, localClass, paramField);
            setFieldValue(paramObject, paramMethod, localClass.getSimpleName(), paramField);
            return;
            if (isSingle(localClass)) {
                paramField = getSingleObject(paramJSONObject, str);
                if (paramField == null) {
                    break;
                }
                setFieldValue(paramObject, paramMethod, localClass.getSimpleName(), paramField);
                return;
            }
            if (isObject(localClass)) {
                paramField = getJsonObject(paramJSONObject, str);
                if (isNull(paramField)) {
                    break;
                }
                paramField = parseJSONObject(paramField, localClass);
                setFieldValue(paramObject, paramMethod, localClass.getSimpleName(), paramField);
                return;
            }
            if (isList(localClass)) {
                paramMethod = getJsonObject(paramJSONObject, str);
                if (isNull(paramMethod)) {
                    break;
                }
                paramField.set(paramObject, parseJSONObject(paramMethod, localClass));
                return;
            }
            throw new Exception("Unknown clazz type!" + localClass);
        }
    }

    public static void setFieldValue(Object paramObject1, Method paramMethod, String paramString, Object paramObject2) {
        if (paramObject2 != null) {
            try {
                if ("".equals(paramObject2)) {
                    return;
                }
                if ("String".equals(paramString)) {
                    paramMethod.invoke(paramObject1, new Object[]{paramObject2.toString()});
                    return;
                }
                if ("Date".equals(paramString)) {
                    paramMethod.invoke(paramObject1, new Object[]{new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(paramObject2.toString())});
                    return;
                }
            } catch (Exception paramObject1) {
                ((Exception) paramObject1).printStackTrace();
                return;
            }
            if (("Integer".equals(paramString)) || ("int".equals(paramString))) {
                paramMethod.invoke(paramObject1, new Object[]{Integer.valueOf(Integer.parseInt(paramObject2.toString()))});
                return;
            }
            if ("Long".equalsIgnoreCase(paramString)) {
                paramMethod.invoke(paramObject1, new Object[]{Long.valueOf(Long.parseLong(paramObject2.toString()))});
                return;
            }
            if ("Double".equalsIgnoreCase(paramString)) {
                paramMethod.invoke(paramObject1, new Object[]{Double.valueOf(Double.parseDouble(paramObject2.toString()))});
                return;
            }
            if ("Boolean".equalsIgnoreCase(paramString)) {
                paramMethod.invoke(paramObject1, new Object[]{Boolean.valueOf(Boolean.parseBoolean(paramObject2.toString()))});
                return;
            }
            paramMethod.invoke(paramObject1, new Object[]{paramObject2});
        }
    }

    private static void setMapField(Object paramObject, JSONObject paramJSONObject) {
        if ((paramObject == null) || (isNull(paramJSONObject))) {
        }
        for (; ; ) {
            return;
            try {
                Iterator localIterator = paramJSONObject.keys();
                paramObject = (Map) paramObject;
                while (localIterator.hasNext()) {
                    String str = (String) localIterator.next();
                    ((Map) paramObject).put(str, paramJSONObject.get(str));
                }
                return;
            } catch (JSONException paramObject) {
                ((JSONException) paramObject).printStackTrace();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/utils/FotorJSONParserUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */