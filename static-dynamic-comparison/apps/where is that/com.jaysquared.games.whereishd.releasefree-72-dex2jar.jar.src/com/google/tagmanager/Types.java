package com.google.tagmanager;

import com.google.analytics.midtier.proto.containertag.TypeSystem.Value;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Escaping;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
    return TypeSystem.Value.newBuilder().setType(TypeSystem.Value.Type.FUNCTION_ID).setFunctionId(paramString).build();
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
  
  public static TypeSystem.Value macroReferenceToValue(String paramString, TypeSystem.Value.Escaping... paramVarArgs)
  {
    paramString = TypeSystem.Value.newBuilder().setType(TypeSystem.Value.Type.MACRO_REFERENCE).setMacroReference(paramString).setContainsReferences(true);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramString.addEscaping(paramVarArgs[i]);
      i += 1;
    }
    return paramString.build();
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
    Object localObject1 = TypeSystem.Value.newBuilder();
    int j = 0;
    int k = 0;
    int i = 0;
    if ((paramObject instanceof TypeSystem.Value)) {
      return (TypeSystem.Value)paramObject;
    }
    if ((paramObject instanceof String)) {
      ((TypeSystem.Value.Builder)localObject1).setType(TypeSystem.Value.Type.STRING).setString((String)paramObject);
    }
    for (;;)
    {
      if (i != 0) {
        ((TypeSystem.Value.Builder)localObject1).setContainsReferences(true);
      }
      return ((TypeSystem.Value.Builder)localObject1).build();
      TypeSystem.Value localValue;
      if ((paramObject instanceof List))
      {
        ((TypeSystem.Value.Builder)localObject1).setType(TypeSystem.Value.Type.LIST);
        paramObject = ((List)paramObject).iterator();
        i = j;
        if (((Iterator)paramObject).hasNext())
        {
          localValue = objectToValue(((Iterator)paramObject).next());
          if (localValue == DEFAULT_VALUE) {
            return DEFAULT_VALUE;
          }
          if ((j != 0) || (localValue.getContainsReferences())) {}
          for (j = 1;; j = 0)
          {
            ((TypeSystem.Value.Builder)localObject1).addListItem(localValue);
            break;
          }
        }
      }
      else if ((paramObject instanceof Map))
      {
        ((TypeSystem.Value.Builder)localObject1).setType(TypeSystem.Value.Type.MAP);
        paramObject = ((Map)paramObject).entrySet().iterator();
        j = k;
        i = j;
        if (((Iterator)paramObject).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)paramObject).next();
          localValue = objectToValue(((Map.Entry)localObject2).getKey());
          localObject2 = objectToValue(((Map.Entry)localObject2).getValue());
          if ((localValue == DEFAULT_VALUE) || (localObject2 == DEFAULT_VALUE)) {
            return DEFAULT_VALUE;
          }
          if ((j != 0) || (localValue.getContainsReferences()) || (((TypeSystem.Value)localObject2).getContainsReferences())) {}
          for (j = 1;; j = 0)
          {
            ((TypeSystem.Value.Builder)localObject1).addMapKey(localValue);
            ((TypeSystem.Value.Builder)localObject1).addMapValue((TypeSystem.Value)localObject2);
            break;
          }
        }
      }
      else if (isDoubleableNumber(paramObject))
      {
        ((TypeSystem.Value.Builder)localObject1).setType(TypeSystem.Value.Type.STRING).setString(paramObject.toString());
      }
      else if (isInt64ableNumber(paramObject))
      {
        ((TypeSystem.Value.Builder)localObject1).setType(TypeSystem.Value.Type.INTEGER).setInteger(getInt64(paramObject));
      }
      else
      {
        if (!(paramObject instanceof Boolean)) {
          break;
        }
        ((TypeSystem.Value.Builder)localObject1).setType(TypeSystem.Value.Type.BOOLEAN).setBoolean(((Boolean)paramObject).booleanValue());
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
    TypeSystem.Value.Builder localBuilder = TypeSystem.Value.newBuilder().setType(TypeSystem.Value.Type.TEMPLATE);
    int i = 0;
    int k = paramVarArgs.length;
    int j = 0;
    if (j < k)
    {
      TypeSystem.Value localValue = paramVarArgs[j];
      localBuilder.addTemplateToken(localValue);
      if ((i != 0) || (localValue.getContainsReferences())) {}
      for (i = 1;; i = 0)
      {
        j += 1;
        break;
      }
    }
    if (i != 0) {
      localBuilder.setContainsReferences(true);
    }
    return localBuilder.build();
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
    switch (paramValue.getType())
    {
    default: 
      Log.e("Failed to convert a value of type: " + paramValue.getType());
      return DEFAULT_OBJECT;
    case ???: 
      return paramValue.getString();
    case ???: 
      localObject1 = new ArrayList(paramValue.getListItemCount());
      localObject2 = paramValue.getListItemList().iterator();
      for (;;)
      {
        paramValue = (TypeSystem.Value)localObject1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        paramValue = valueToObject((TypeSystem.Value)((Iterator)localObject2).next());
        if (paramValue == DEFAULT_OBJECT) {
          return DEFAULT_OBJECT;
        }
        ((ArrayList)localObject1).add(paramValue);
      }
    case ???: 
      if (paramValue.getMapKeyCount() != paramValue.getMapValueCount())
      {
        Log.e("Converting an invalid value to object: " + paramValue.toString());
        return DEFAULT_OBJECT;
      }
      localObject1 = new HashMap(paramValue.getMapValueCount());
      int i = 0;
      while (i < paramValue.getMapKeyCount())
      {
        localObject2 = valueToObject(paramValue.getMapKey(i));
        Object localObject3 = valueToObject(paramValue.getMapValue(i));
        if ((localObject2 == DEFAULT_OBJECT) || (localObject3 == DEFAULT_OBJECT)) {
          return DEFAULT_OBJECT;
        }
        ((Map)localObject1).put(localObject2, localObject3);
        i += 1;
      }
      return localObject1;
    case ???: 
      Log.e("Trying to convert a macro reference to object");
      return DEFAULT_OBJECT;
    case ???: 
      Log.e("Trying to convert a function id to object");
      return DEFAULT_OBJECT;
    case ???: 
      return Long.valueOf(paramValue.getInteger());
    case ???: 
      localObject1 = new StringBuffer();
      paramValue = paramValue.getTemplateTokenList().iterator();
      while (paramValue.hasNext())
      {
        localObject2 = valueToString((TypeSystem.Value)paramValue.next());
        if (localObject2 == DEFAULT_STRING) {
          return DEFAULT_OBJECT;
        }
        ((StringBuffer)localObject1).append((String)localObject2);
      }
      return ((StringBuffer)localObject1).toString();
    }
    return Boolean.valueOf(paramValue.getBoolean());
  }
  
  public static String valueToString(TypeSystem.Value paramValue)
  {
    return objectToString(valueToObject(paramValue));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/Types.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */