package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import java.util.Calendar;
import java.util.Date;

public class StdKeySerializers
{
  protected static final JsonSerializer<Object> DEFAULT_KEY_SERIALIZER = new StdKeySerializer();
  protected static final JsonSerializer<Object> DEFAULT_STRING_SERIALIZER = new StdKeySerializers.StringKeySerializer();
  
  public static JsonSerializer<Object> getStdKeySerializer(JavaType paramJavaType)
  {
    if (paramJavaType == null) {
      return DEFAULT_KEY_SERIALIZER;
    }
    paramJavaType = paramJavaType.getRawClass();
    if (paramJavaType == String.class) {
      return DEFAULT_STRING_SERIALIZER;
    }
    if (paramJavaType == Object.class) {
      return DEFAULT_KEY_SERIALIZER;
    }
    if (Date.class.isAssignableFrom(paramJavaType)) {
      return StdKeySerializers.DateKeySerializer.instance;
    }
    if (Calendar.class.isAssignableFrom(paramJavaType)) {
      return StdKeySerializers.CalendarKeySerializer.instance;
    }
    return DEFAULT_KEY_SERIALIZER;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/StdKeySerializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */