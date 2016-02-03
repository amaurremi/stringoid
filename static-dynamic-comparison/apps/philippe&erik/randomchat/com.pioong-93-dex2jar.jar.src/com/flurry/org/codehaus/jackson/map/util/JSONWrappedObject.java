package com.flurry.org.codehaus.jackson.map.util;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.map.JsonSerializableWithType;
import com.flurry.org.codehaus.jackson.map.JsonSerializer;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import com.flurry.org.codehaus.jackson.map.TypeSerializer;
import com.flurry.org.codehaus.jackson.map.type.TypeFactory;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.io.IOException;

public class JSONWrappedObject
  implements JsonSerializableWithType
{
  protected final String _prefix;
  protected final JavaType _serializationType;
  protected final String _suffix;
  protected final Object _value;
  
  public JSONWrappedObject(String paramString1, String paramString2, Object paramObject)
  {
    this(paramString1, paramString2, paramObject, (JavaType)null);
  }
  
  public JSONWrappedObject(String paramString1, String paramString2, Object paramObject, JavaType paramJavaType)
  {
    this._prefix = paramString1;
    this._suffix = paramString2;
    this._value = paramObject;
    this._serializationType = paramJavaType;
  }
  
  @Deprecated
  public JSONWrappedObject(String paramString1, String paramString2, Object paramObject, Class<?> paramClass)
  {
    this._prefix = paramString1;
    this._suffix = paramString2;
    this._value = paramObject;
    if (paramClass == null) {}
    for (paramString1 = null;; paramString1 = TypeFactory.defaultInstance().constructType(paramClass))
    {
      this._serializationType = paramString1;
      return;
    }
  }
  
  public String getPrefix()
  {
    return this._prefix;
  }
  
  public JavaType getSerializationType()
  {
    return this._serializationType;
  }
  
  public String getSuffix()
  {
    return this._suffix;
  }
  
  public Object getValue()
  {
    return this._value;
  }
  
  public void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException
  {
    if (this._prefix != null) {
      paramJsonGenerator.writeRaw(this._prefix);
    }
    if (this._value == null) {
      paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
    }
    for (;;)
    {
      if (this._suffix != null) {
        paramJsonGenerator.writeRaw(this._suffix);
      }
      return;
      if (this._serializationType != null) {
        paramSerializerProvider.findTypedValueSerializer(this._serializationType, true, null).serialize(this._value, paramJsonGenerator, paramSerializerProvider);
      } else {
        paramSerializerProvider.findTypedValueSerializer(this._value.getClass(), true, null).serialize(this._value, paramJsonGenerator, paramSerializerProvider);
      }
    }
  }
  
  public void serializeWithType(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException, JsonProcessingException
  {
    serialize(paramJsonGenerator, paramSerializerProvider);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/util/JSONWrappedObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */