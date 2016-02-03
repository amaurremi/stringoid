package com.amazonaws.util.json;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JSONObject
{
  public static final Object NULL = new JSONObject.Null(null);
  private Map map = new HashMap();
  
  public JSONObject() {}
  
  public JSONObject(JSONTokener paramJSONTokener)
  {
    this();
    if (paramJSONTokener.nextClean() != '{') {
      throw paramJSONTokener.syntaxError("A JSONObject text must begin with '{'");
    }
    do
    {
      paramJSONTokener.back();
      String str;
      int i;
      switch (paramJSONTokener.nextClean())
      {
      default: 
        paramJSONTokener.back();
        str = paramJSONTokener.nextValue().toString();
        i = paramJSONTokener.nextClean();
        if (i == 61) {
          if (paramJSONTokener.next() != '>') {
            paramJSONTokener.back();
          }
        }
      case '\000': 
        while (i == 58)
        {
          putOnce(str, paramJSONTokener.nextValue());
          switch (paramJSONTokener.nextClean())
          {
          default: 
            throw paramJSONTokener.syntaxError("Expected a ',' or '}'");
            throw paramJSONTokener.syntaxError("A JSONObject text must end with '}'");
          }
        }
        throw paramJSONTokener.syntaxError("Expected a ':' after a key");
      }
    } while (paramJSONTokener.nextClean() != '}');
  }
  
  public JSONObject(Object paramObject)
  {
    this();
    populateMap(paramObject);
  }
  
  public JSONObject(String paramString)
  {
    this(new JSONTokener(paramString));
  }
  
  public JSONObject(Map paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        this.map.put(localEntry.getKey(), wrap(localEntry.getValue()));
      }
    }
  }
  
  public static String numberToString(Number paramNumber)
  {
    if (paramNumber == null) {
      throw new JSONException("Null pointer");
    }
    testValidity(paramNumber);
    String str = paramNumber.toString();
    paramNumber = str;
    if (str.indexOf('.') > 0)
    {
      paramNumber = str;
      if (str.indexOf('e') < 0)
      {
        paramNumber = str;
        if (str.indexOf('E') < 0)
        {
          while (str.endsWith("0")) {
            str = str.substring(0, str.length() - 1);
          }
          paramNumber = str;
          if (str.endsWith(".")) {
            paramNumber = str.substring(0, str.length() - 1);
          }
        }
      }
    }
    return paramNumber;
  }
  
  private void populateMap(Object paramObject)
  {
    int j = 0;
    Object localObject1 = paramObject.getClass();
    int i;
    Method[] arrayOfMethod;
    label31:
    Object localObject2;
    if (((Class)localObject1).getClassLoader() != null)
    {
      i = 1;
      if (i == 0) {
        break label185;
      }
      arrayOfMethod = ((Class)localObject1).getMethods();
      i = j;
      if (i >= arrayOfMethod.length) {
        break label278;
      }
      localObject2 = arrayOfMethod[i];
    }
    try
    {
      if (!Modifier.isPublic(((Method)localObject2).getModifiers())) {
        break label173;
      }
      str2 = ((Method)localObject2).getName();
      localObject1 = "";
      if (!str2.startsWith("get")) {
        break label208;
      }
      if (str2.equals("getClass")) {
        break label297;
      }
      if (!str2.equals("getDeclaringClass")) {
        break label197;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      String str2;
      for (;;) {}
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;) {}
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        label99:
        continue;
        continue;
        String str1 = "";
      }
    }
    if ((((String)localObject1).length() > 0) && (Character.isUpperCase(((String)localObject1).charAt(0))) && (((Method)localObject2).getParameterTypes().length == 0)) {
      if (((String)localObject1).length() != 1) {
        break label229;
      }
    }
    for (localObject1 = ((String)localObject1).toLowerCase();; localObject1 = ((String)localObject1).substring(0, 1).toLowerCase() + ((String)localObject1).substring(1))
    {
      localObject2 = ((Method)localObject2).invoke(paramObject, (Object[])null);
      this.map.put(localObject1, wrap(localObject2));
      label173:
      i += 1;
      break label31;
      i = 0;
      break;
      label185:
      arrayOfMethod = ((Class)localObject1).getDeclaredMethods();
      i = j;
      break label31;
      label197:
      localObject1 = str2.substring(3);
      break label99;
      label208:
      if (!str2.startsWith("is")) {
        break label99;
      }
      localObject1 = str2.substring(2);
      break label99;
      label229:
      if (Character.isUpperCase(((String)localObject1).charAt(1))) {
        break label294;
      }
    }
    label278:
  }
  
  public static String quote(String paramString)
  {
    int i = 0;
    if ((paramString == null) || (paramString.length() == 0)) {
      return "\"\"";
    }
    int k = paramString.length();
    StringBuffer localStringBuffer = new StringBuffer(k + 4);
    localStringBuffer.append('"');
    int j = 0;
    if (i < k)
    {
      char c = paramString.charAt(i);
      switch (c)
      {
      default: 
        if ((c < ' ') || ((c >= '') && (c < ' ')))
        {
          String str = "000" + Integer.toHexString(c);
          localStringBuffer.append("\\u" + str.substring(str.length() - 4));
        }
        break;
      }
      for (;;)
      {
        i += 1;
        j = c;
        break;
        localStringBuffer.append('\\');
        localStringBuffer.append(c);
        continue;
        if (j == 60) {
          localStringBuffer.append('\\');
        }
        localStringBuffer.append(c);
        continue;
        localStringBuffer.append("\\b");
        continue;
        localStringBuffer.append("\\t");
        continue;
        localStringBuffer.append("\\n");
        continue;
        localStringBuffer.append("\\f");
        continue;
        localStringBuffer.append("\\r");
        continue;
        localStringBuffer.append(c);
      }
    }
    localStringBuffer.append('"');
    return localStringBuffer.toString();
  }
  
  public static Object stringToValue(String paramString)
  {
    if (paramString.equals("")) {}
    int i;
    do
    {
      return paramString;
      if (paramString.equalsIgnoreCase("true")) {
        return Boolean.TRUE;
      }
      if (paramString.equalsIgnoreCase("false")) {
        return Boolean.FALSE;
      }
      if (paramString.equalsIgnoreCase("null")) {
        return NULL;
      }
      i = paramString.charAt(0);
    } while (((i < 48) || (i > 57)) && (i != 46) && (i != 45) && (i != 43));
    if ((i == 48) && (paramString.length() > 2) && ((paramString.charAt(1) == 'x') || (paramString.charAt(1) == 'X'))) {
      try
      {
        Integer localInteger = Integer.valueOf(paramString.substring(2), 16);
        return localInteger;
      }
      catch (Exception localException1) {}
    }
    try
    {
      if ((paramString.indexOf('.') > -1) || (paramString.indexOf('e') > -1) || (paramString.indexOf('E') > -1)) {
        return Double.valueOf(paramString);
      }
      Long localLong = Long.valueOf(paramString);
      if (localLong.longValue() == localLong.intValue())
      {
        i = localLong.intValue();
        return Integer.valueOf(i);
      }
      return localLong;
    }
    catch (Exception localException2) {}
    return paramString;
  }
  
  static void testValidity(Object paramObject)
  {
    if (paramObject != null) {
      if ((paramObject instanceof Double))
      {
        if ((((Double)paramObject).isInfinite()) || (((Double)paramObject).isNaN())) {
          throw new JSONException("JSON does not allow non-finite numbers.");
        }
      }
      else if (((paramObject instanceof Float)) && ((((Float)paramObject).isInfinite()) || (((Float)paramObject).isNaN()))) {
        throw new JSONException("JSON does not allow non-finite numbers.");
      }
    }
  }
  
  static String valueToString(Object paramObject)
  {
    if ((paramObject == null) || (paramObject.equals(NULL))) {
      return "null";
    }
    if ((paramObject instanceof Number)) {
      return numberToString((Number)paramObject);
    }
    if (((paramObject instanceof Boolean)) || ((paramObject instanceof JSONObject)) || ((paramObject instanceof JSONArray))) {
      return paramObject.toString();
    }
    if ((paramObject instanceof Map)) {
      return new JSONObject((Map)paramObject).toString();
    }
    if ((paramObject instanceof Collection)) {
      return new JSONArray((Collection)paramObject).toString();
    }
    if (paramObject.getClass().isArray()) {
      return new JSONArray(paramObject).toString();
    }
    return quote(paramObject.toString());
  }
  
  static Object wrap(Object paramObject)
  {
    if (paramObject == null) {}
    try
    {
      return NULL;
    }
    catch (Exception paramObject)
    {
      localObject = null;
    }
    Object localObject = paramObject;
    if (!(paramObject instanceof JSONObject))
    {
      localObject = paramObject;
      if (!(paramObject instanceof JSONArray))
      {
        localObject = paramObject;
        if (!NULL.equals(paramObject))
        {
          localObject = paramObject;
          if (!(paramObject instanceof String))
          {
            localObject = paramObject;
            if (!(paramObject instanceof Byte))
            {
              localObject = paramObject;
              if (!(paramObject instanceof Character))
              {
                localObject = paramObject;
                if (!(paramObject instanceof Short))
                {
                  localObject = paramObject;
                  if (!(paramObject instanceof Integer))
                  {
                    localObject = paramObject;
                    if (!(paramObject instanceof Long))
                    {
                      localObject = paramObject;
                      if (!(paramObject instanceof Boolean))
                      {
                        localObject = paramObject;
                        if (!(paramObject instanceof Float))
                        {
                          localObject = paramObject;
                          if (!(paramObject instanceof Double))
                          {
                            if ((paramObject instanceof Collection)) {
                              return new JSONArray((Collection)paramObject);
                            }
                            if (paramObject.getClass().isArray()) {
                              return new JSONArray(paramObject);
                            }
                            if ((paramObject instanceof Map)) {
                              return new JSONObject((Map)paramObject);
                            }
                            localObject = paramObject.getClass().getPackage();
                            if (localObject == null) {
                              break label244;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label244:
    for (localObject = ((Package)localObject).getName();; localObject = "")
    {
      if ((((String)localObject).startsWith("java.")) || (((String)localObject).startsWith("javax.")) || (paramObject.getClass().getClassLoader() == null)) {
        return paramObject.toString();
      }
      paramObject = new JSONObject(paramObject);
      return paramObject;
      return localObject;
    }
  }
  
  public Object get(String paramString)
  {
    Object localObject = opt(paramString);
    if (localObject == null) {
      throw new JSONException("JSONObject[" + quote(paramString) + "] not found.");
    }
    return localObject;
  }
  
  public String getString(String paramString)
  {
    return get(paramString).toString();
  }
  
  public boolean has(String paramString)
  {
    return this.map.containsKey(paramString);
  }
  
  public Iterator keys()
  {
    return this.map.keySet().iterator();
  }
  
  public Object opt(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return this.map.get(paramString);
  }
  
  public JSONObject put(String paramString, Object paramObject)
  {
    if (paramString == null) {
      throw new JSONException("Null key.");
    }
    if (paramObject != null)
    {
      testValidity(paramObject);
      this.map.put(paramString, paramObject);
      return this;
    }
    remove(paramString);
    return this;
  }
  
  public JSONObject putOnce(String paramString, Object paramObject)
  {
    if ((paramString != null) && (paramObject != null))
    {
      if (opt(paramString) != null) {
        throw new JSONException("Duplicate key \"" + paramString + "\"");
      }
      put(paramString, paramObject);
    }
    return this;
  }
  
  public Object remove(String paramString)
  {
    return this.map.remove(paramString);
  }
  
  public String toString()
  {
    try
    {
      Object localObject1 = keys();
      StringBuffer localStringBuffer = new StringBuffer("{");
      while (((Iterator)localObject1).hasNext())
      {
        if (localStringBuffer.length() > 1) {
          localStringBuffer.append(',');
        }
        Object localObject2 = ((Iterator)localObject1).next();
        localStringBuffer.append(quote(localObject2.toString()));
        localStringBuffer.append(':');
        localStringBuffer.append(valueToString(this.map.get(localObject2)));
      }
      localStringBuffer.append('}');
      localObject1 = localStringBuffer.toString();
      return (String)localObject1;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/json/JSONObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */