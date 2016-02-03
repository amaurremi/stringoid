package org.codehaus.jackson.map.util;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializableWithType;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;

public class JSONPObject
  implements JsonSerializableWithType
{
  protected final String _function;
  protected final JavaType _serializationType;
  protected final Object _value;
  
  public JSONPObject(String paramString, Object paramObject)
  {
    this(paramString, paramObject, (JavaType)null);
  }
  
  @Deprecated
  public JSONPObject(String paramString, Object paramObject, Class paramClass)
  {
    this._function = paramString;
    this._value = paramObject;
    if (paramClass == null) {}
    for (paramString = null;; paramString = TypeFactory.defaultInstance().constructType(paramClass))
    {
      this._serializationType = paramString;
      return;
    }
  }
  
  public JSONPObject(String paramString, Object paramObject, JavaType paramJavaType)
  {
    this._function = paramString;
    this._value = paramObject;
    this._serializationType = paramJavaType;
  }
  
  public String getFunction()
  {
    return this._function;
  }
  
  public JavaType getSerializationType()
  {
    return this._serializationType;
  }
  
  public Object getValue()
  {
    return this._value;
  }
  
  public void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    paramJsonGenerator.writeRaw(this._function);
    paramJsonGenerator.writeRaw('(');
    if (this._value == null) {
      paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
    }
    for (;;)
    {
      paramJsonGenerator.writeRaw(')');
      return;
      if (this._serializationType != null) {
        paramSerializerProvider.findTypedValueSerializer(this._serializationType, true, null).serialize(this._value, paramJsonGenerator, paramSerializerProvider);
      } else {
        paramSerializerProvider.findTypedValueSerializer(this._value.getClass(), true, null).serialize(this._value, paramJsonGenerator, paramSerializerProvider);
      }
    }
  }
  
  public void serializeWithType(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
  {
    serialize(paramJsonGenerator, paramSerializerProvider);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/util/JSONPObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */