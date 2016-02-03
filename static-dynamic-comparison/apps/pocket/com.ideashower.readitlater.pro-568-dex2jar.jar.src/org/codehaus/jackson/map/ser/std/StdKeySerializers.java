package org.codehaus.jackson.map.ser.std;

import java.util.Calendar;
import java.util.Date;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.type.JavaType;

public class StdKeySerializers
{
  protected static final JsonSerializer DEFAULT_KEY_SERIALIZER = new StdKeySerializer();
  protected static final JsonSerializer DEFAULT_STRING_SERIALIZER = new StdKeySerializers.StringKeySerializer();
  
  public static JsonSerializer getStdKeySerializer(JavaType paramJavaType)
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/std/StdKeySerializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */