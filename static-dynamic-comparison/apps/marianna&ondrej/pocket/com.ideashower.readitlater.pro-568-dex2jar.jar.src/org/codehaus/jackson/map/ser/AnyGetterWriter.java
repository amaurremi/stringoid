package org.codehaus.jackson.map.ser;

import java.lang.reflect.Method;
import java.util.Map;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.ser.std.MapSerializer;

public class AnyGetterWriter
{
  protected final Method _anyGetter;
  protected final MapSerializer _serializer;
  
  public AnyGetterWriter(AnnotatedMethod paramAnnotatedMethod, MapSerializer paramMapSerializer)
  {
    this._anyGetter = paramAnnotatedMethod.getAnnotated();
    this._serializer = paramMapSerializer;
  }
  
  public void getAndSerialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    paramObject = this._anyGetter.invoke(paramObject, new Object[0]);
    if (paramObject == null) {
      return;
    }
    if (!(paramObject instanceof Map)) {
      throw new JsonMappingException("Value returned by 'any-getter' (" + this._anyGetter.getName() + "()) not java.util.Map but " + paramObject.getClass().getName());
    }
    this._serializer.serializeFields((Map)paramObject, paramJsonGenerator, paramSerializerProvider);
  }
  
  public void resolve(SerializerProvider paramSerializerProvider)
  {
    this._serializer.resolve(paramSerializerProvider);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/AnyGetterWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */