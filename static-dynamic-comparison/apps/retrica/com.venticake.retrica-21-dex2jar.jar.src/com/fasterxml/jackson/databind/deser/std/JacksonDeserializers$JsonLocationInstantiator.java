package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.CreatorProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;

public class JacksonDeserializers$JsonLocationInstantiator
  extends ValueInstantiator
{
  private static final int _int(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    return ((Number)paramObject).intValue();
  }
  
  private static final long _long(Object paramObject)
  {
    if (paramObject == null) {
      return 0L;
    }
    return ((Number)paramObject).longValue();
  }
  
  public boolean canCreateFromObjectWith()
  {
    return true;
  }
  
  public Object createFromObjectWith(DeserializationContext paramDeserializationContext, Object[] paramArrayOfObject)
  {
    return new JsonLocation(paramArrayOfObject[0], _long(paramArrayOfObject[1]), _long(paramArrayOfObject[2]), _int(paramArrayOfObject[3]), _int(paramArrayOfObject[4]));
  }
  
  public CreatorProperty[] getFromObjectArguments(DeserializationConfig paramDeserializationConfig)
  {
    JavaType localJavaType1 = paramDeserializationConfig.constructType(Integer.TYPE);
    JavaType localJavaType2 = paramDeserializationConfig.constructType(Long.TYPE);
    return new CreatorProperty[] { new CreatorProperty("sourceRef", paramDeserializationConfig.constructType(Object.class), null, null, null, 0, null), new CreatorProperty("byteOffset", localJavaType2, null, null, null, 1, null), new CreatorProperty("charOffset", localJavaType2, null, null, null, 2, null), new CreatorProperty("lineNr", localJavaType1, null, null, null, 3, null), new CreatorProperty("columnNr", localJavaType1, null, null, null, 4, null) };
  }
  
  public String getValueTypeDesc()
  {
    return JsonLocation.class.getName();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/JacksonDeserializers$JsonLocationInstantiator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */