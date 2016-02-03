package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

public abstract class StdSerializer<T>
  extends JsonSerializer<T>
{
  protected final Class<T> _handledType;
  
  protected StdSerializer(JavaType paramJavaType)
  {
    this._handledType = paramJavaType.getRawClass();
  }
  
  protected StdSerializer(Class<T> paramClass)
  {
    this._handledType = paramClass;
  }
  
  protected StdSerializer(Class<?> paramClass, boolean paramBoolean)
  {
    this._handledType = paramClass;
  }
  
  public Class<T> handledType()
  {
    return this._handledType;
  }
  
  protected boolean isDefaultSerializer(JsonSerializer<?> paramJsonSerializer)
  {
    return (paramJsonSerializer != null) && (paramJsonSerializer.getClass().getAnnotation(JacksonStdImpl.class) != null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/StdSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */