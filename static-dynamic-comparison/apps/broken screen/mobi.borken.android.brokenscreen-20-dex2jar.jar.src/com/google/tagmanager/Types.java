package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Types
{
  private static Boolean DEFAULT_BOOLEAN = new Boolean(false);
  private static Double DEFAULT_DOUBLE;
  private static Long DEFAULT_INT64;
  private static List<Object> DEFAULT_LIST = new ArrayList(0);
  private static Map<Object, Object> DEFAULT_MAP = new HashMap();
  private static TypedNumber DEFAULT_NUMBER;
  private static final Object DEFAULT_OBJECT = null;
  private static String DEFAULT_STRING;
  private static TypeSystem.Value DEFAULT_VALUE = objectToValue(DEFAULT_STRING);
  
  static
  {
    DEFAULT_INT64 = new Long(0L);
    DEFAULT_DOUBLE = new Double(0.0D);
    DEFAULT_NUMBER = TypedNumber.numberWithInt64(0L);
    DEFAULT_STRING = new String("");
  }
  
  public static TypeSystem.Value functionIdToValue(String paramString)
  {
    TypeSystem.Value localValue = new TypeSystem.Value();
    localValue.type = 5;
    localValue.functionId = paramString;
    return localValue;
  }
  
  public static Boolean getDefaultBoolean()
  {
    return DEFAULT_BOOLEAN;
  }
  
  public static Double getDefaultDouble()
  {
    return DEFAULT_DOUBLE;
  }
  
  public static Long getDefaultInt64()
  {
    return DEFAULT_INT64;
  }
  
  public static List<Object> getDefaultList()
  {
    return DEFAULT_LIST;
  }
  
  public static Map<Object, Object> getDefaultMap()
  {
    return DEFAULT_MAP;
  }
  
  public static TypedNumber getDefaultNumber()
  {
    return DEFAULT_NUMBER;
  }
  
  public static Object getDefaultObject()
  {
    return DEFAULT_OBJECT;
  }
  
  public static String getDefaultString()
  {
    return DEFAULT_STRING;
  }
  
  public static TypeSystem.Value getDefaultValue()
  {
    return DEFAULT_VALUE;
  }
  
  private static double getDouble(Object paramObject)
  {
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).doubleValue();
    }
    Log.e("getDouble received non-Number");
    return 0.0D;
  }
  
  private static long getInt64(Object paramObject)
  {
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).longValue();
    }
    Log.e("getInt64 received non-Number");
    return 0L;
  }
  
  private static boolean isDoubleableNumber(Object paramObject)
  {
    return ((paramObject instanceof Double)) || ((paramObject instanceof Float)) || (((paramObject instanceof TypedNumber)) && (((TypedNumber)paramObject).isDouble()));
  }
  
  private static boolean isInt64ableNumber(Object paramObject)
  {
    return ((paramObject instanceof Byte)) || ((paramObject instanceof Short)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || (((paramObject instanceof TypedNumber)) && (((TypedNumber)paramObject).isInt64()));
  }
  
  public static TypeSystem.Value macroReferenceToValue(String paramString, int... paramVarArgs)
  {
    TypeSystem.Value localValue = new TypeSystem.Value();
    localValue.type = 4;
    localValue.macroReference = paramString;
    localValue.containsReferences = true;
    localValue.escaping = ((int[])paramVarArgs.clone());
    return localValue;
  }
  
  public static Boolean objectToBoolean(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      return (Boolean)paramObject;
    }
    return parseBoolean(objectToString(paramObject));
  }
  
  public static Double objectToDouble(Object paramObject)
  {
    if (isDoubleableNumber(paramObject)) {
      return Double.valueOf(getDouble(paramObject));
    }
    return parseDouble(objectToString(paramObject));
  }
  
  public static Long objectToInt64(Object paramObject)
  {
    if (isInt64ableNumber(paramObject)) {
      return Long.valueOf(getInt64(paramObject));
    }
    return parseInt64(objectToString(paramObject));
  }
  
  public static TypedNumber objectToNumber(Object paramObject)
  {
    if ((paramObject instanceof TypedNumber)) {
      return (TypedNumber)paramObject;
    }
    if (isInt64ableNumber(paramObject)) {
      return TypedNumber.numberWithInt64(getInt64(paramObject));
    }
    if (isDoubleableNumber(paramObject)) {
      return TypedNumber.numberWithDouble(Double.valueOf(getDouble(paramObject)));
    }
    return parseNumber(objectToString(paramObject));
  }
  
  public static String objectToString(Object paramObject)
  {
    if (paramObject == null) {
      return DEFAULT_STRING;
    }
    return paramObject.toString();
  }
  
  public static TypeSystem.Value objectToValue(Object paramObject)
  {
    Object localObject1 = new TypeSystem.Value();
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    if ((paramObject instanceof TypeSystem.Value)) {
      return (TypeSystem.Value)paramObject;
    }
    if ((paramObject instanceof String))
    {
      ((TypeSystem.Value)localObject1).type = 1;
      ((TypeSystem.Value)localObject1).string = ((String)paramObject);
    }
    for (;;)
    {
      ((TypeSystem.Value)localObject1).containsReferences = bool1;
      return (TypeSystem.Value)localObject1;
      Object localObject2;
      Object localObject3;
      if ((paramObject instanceof List))
      {
        ((TypeSystem.Value)localObject1).type = 2;
        localObject2 = (List)paramObject;
        paramObject = new ArrayList(((List)localObject2).size());
        localObject2 = ((List)localObject2).iterator();
        bool1 = bool2;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = objectToValue(((Iterator)localObject2).next());
          if (localObject3 == DEFAULT_VALUE) {
            return DEFAULT_VALUE;
          }
          if ((bool1) || (((TypeSystem.Value)localObject3).containsReferences)) {}
          for (bool1 = true;; bool1 = false)
          {
            ((List)paramObject).add(localObject3);
            break;
          }
        }
        ((TypeSystem.Value)localObject1).listItem = ((TypeSystem.Value[])((List)paramObject).toArray(new TypeSystem.Value[0]));
      }
      else if ((paramObject instanceof Map))
      {
        ((TypeSystem.Value)localObject1).type = 3;
        localObject3 = ((Map)paramObject).entrySet();
        paramObject = new ArrayList(((Set)localObject3).size());
        localObject2 = new ArrayList(((Set)localObject3).size());
        localObject3 = ((Set)localObject3).iterator();
        bool1 = bool3;
        if (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (Map.Entry)((Iterator)localObject3).next();
          TypeSystem.Value localValue = objectToValue(((Map.Entry)localObject4).getKey());
          localObject4 = objectToValue(((Map.Entry)localObject4).getValue());
          if ((localValue == DEFAULT_VALUE) || (localObject4 == DEFAULT_VALUE)) {
            return DEFAULT_VALUE;
          }
          if ((bool1) || (localValue.containsReferences) || (((TypeSystem.Value)localObject4).containsReferences)) {}
          for (bool1 = true;; bool1 = false)
          {
            ((List)paramObject).add(localValue);
            ((List)localObject2).add(localObject4);
            break;
          }
        }
        ((TypeSystem.Value)localObject1).mapKey = ((TypeSystem.Value[])((List)paramObject).toArray(new TypeSystem.Value[0]));
        ((TypeSystem.Value)localObject1).mapValue = ((TypeSystem.Value[])((List)localObject2).toArray(new TypeSystem.Value[0]));
      }
      else if (isDoubleableNumber(paramObject))
      {
        ((TypeSystem.Value)localObject1).type = 1;
        ((TypeSystem.Value)localObject1).string = paramObject.toString();
      }
      else if (isInt64ableNumber(paramObject))
      {
        ((TypeSystem.Value)localObject1).type = 6;
        ((TypeSystem.Value)localObject1).integer = getInt64(paramObject);
      }
      else
      {
        if (!(paramObject instanceof Boolean)) {
          break;
        }
        ((TypeSystem.Value)localObject1).type = 8;
        ((TypeSystem.Value)localObject1).boolean_ = ((Boolean)paramObject).booleanValue();
      }
    }
    localObject1 = new StringBuilder().append("Converting to Value from unknown object type: ");
    if (paramObject == null) {}
    for (paramObject = "null";; paramObject = paramObject.getClass().toString())
    {
      Log.e((String)paramObject);
      return DEFAULT_VALUE;
    }
  }
  
  private static Boolean parseBoolean(String paramString)
  {
    if ("true".equalsIgnoreCase(paramString)) {
      return Boolean.TRUE;
    }
    if ("false".equalsIgnoreCase(paramString)) {
      return Boolean.FALSE;
    }
    return DEFAULT_BOOLEAN;
  }
  
  private static Double parseDouble(String paramString)
  {
    paramString = parseNumber(paramString);
    if (paramString == DEFAULT_NUMBER) {
      return DEFAULT_DOUBLE;
    }
    return Double.valueOf(paramString.doubleValue());
  }
  
  private static Long parseInt64(String paramString)
  {
    paramString = parseNumber(paramString);
    if (paramString == DEFAULT_NUMBER) {
      return DEFAULT_INT64;
    }
    return Long.valueOf(paramString.longValue());
  }
  
  private static TypedNumber parseNumber(String paramString)
  {
    try
    {
      TypedNumber localTypedNumber = TypedNumber.numberWithString(paramString);
      return localTypedNumber;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Log.e("Failed to convert '" + paramString + "' to a number.");
    }
    return DEFAULT_NUMBER;
  }
  
  public static TypeSystem.Value templateToValue(TypeSystem.Value... paramVarArgs)
  {
    TypeSystem.Value localValue = new TypeSystem.Value();
    localValue.type = 7;
    boolean bool = false;
    localValue.templateToken = new TypeSystem.Value[paramVarArgs.length];
    int i = 0;
    if (i < paramVarArgs.length)
    {
      localValue.templateToken[i] = paramVarArgs[i];
      if ((bool) || (paramVarArgs[i].containsReferences)) {}
      for (bool = true;; bool = false)
      {
        i += 1;
        break;
      }
    }
    localValue.containsReferences = bool;
    return localValue;
  }
  
  public static Boolean valueToBoolean(TypeSystem.Value paramValue)
  {
    return objectToBoolean(valueToObject(paramValue));
  }
  
  public static Double valueToDouble(TypeSystem.Value paramValue)
  {
    return objectToDouble(valueToObject(paramValue));
  }
  
  public static Long valueToInt64(TypeSystem.Value paramValue)
  {
    return objectToInt64(valueToObject(paramValue));
  }
  
  public static TypedNumber valueToNumber(TypeSystem.Value paramValue)
  {
    return objectToNumber(valueToObject(paramValue));
  }
  
  public static Object valueToObject(TypeSystem.Value paramValue)
  {
    if (paramValue == null)
    {
      paramValue = DEFAULT_OBJECT;
      return paramValue;
    }
    Object localObject1;
    Object localObject2;
    int j;
    int i;
    switch (paramValue.type)
    {
    default: 
      Log.e("Failed to convert a value of type: " + paramValue.type);
      return DEFAULT_OBJECT;
    case 1: 
      return paramValue.string;
    case 2: 
      localObject1 = new ArrayList(paramValue.listItem.length);
      localObject2 = paramValue.listItem;
      j = localObject2.length;
      i = 0;
      for (;;)
      {
        paramValue = (TypeSystem.Value)localObject1;
        if (i >= j) {
          break;
        }
        paramValue = valueToObject(localObject2[i]);
        if (paramValue == DEFAULT_OBJECT) {
          return DEFAULT_OBJECT;
        }
        ((ArrayList)localObject1).add(paramValue);
        i += 1;
      }
    case 3: 
      if (paramValue.mapKey.length != paramValue.mapValue.length)
      {
        Log.e("Converting an invalid value to object: " + paramValue.toString());
        return DEFAULT_OBJECT;
      }
      localObject1 = new LinkedHashMap(paramValue.mapValue.length);
      i = 0;
      while (i < paramValue.mapKey.length)
      {
        localObject2 = valueToObject(paramValue.mapKey[i]);
        Object localObject3 = valueToObject(paramValue.mapValue[i]);
        if ((localObject2 == DEFAULT_OBJECT) || (localObject3 == DEFAULT_OBJECT)) {
          return DEFAULT_OBJECT;
        }
        ((Map)localObject1).put(localObject2, localObject3);
        i += 1;
      }
      return localObject1;
    case 4: 
      Log.e("Trying to convert a macro reference to object");
      return DEFAULT_OBJECT;
    case 5: 
      Log.e("Trying to convert a function id to object");
      return DEFAULT_OBJECT;
    case 6: 
      return Long.valueOf(paramValue.integer);
    case 7: 
      localObject1 = new StringBuffer();
      paramValue = paramValue.templateToken;
      j = paramValue.length;
      i = 0;
      while (i < j)
      {
        localObject2 = valueToString(paramValue[i]);
        if (localObject2 == DEFAULT_STRING) {
          return DEFAULT_OBJECT;
        }
        ((StringBuffer)localObject1).append((String)localObject2);
        i += 1;
      }
      return ((StringBuffer)localObject1).toString();
    }
    return Boolean.valueOf(paramValue.boolean_);
  }
  
  public static String valueToString(TypeSystem.Value paramValue)
  {
    return objectToString(valueToObject(paramValue));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/Types.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */