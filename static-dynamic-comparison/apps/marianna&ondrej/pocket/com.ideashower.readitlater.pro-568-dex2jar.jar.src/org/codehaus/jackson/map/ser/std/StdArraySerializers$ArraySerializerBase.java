package org.codehaus.jackson.map.ser.std;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;

public abstract class StdArraySerializers$ArraySerializerBase
  extends ContainerSerializerBase
{
  protected final BeanProperty _property;
  protected final TypeSerializer _valueTypeSerializer;
  
  protected StdArraySerializers$ArraySerializerBase(Class paramClass, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty)
  {
    super(paramClass);
    this._valueTypeSerializer = paramTypeSerializer;
    this._property = paramBeanProperty;
  }
  
  public final void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    paramJsonGenerator.writeStartArray();
    serializeContents(paramObject, paramJsonGenerator, paramSerializerProvider);
    paramJsonGenerator.writeEndArray();
  }
  
  protected abstract void serializeContents(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider);
  
  public final void serializeWithType(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
  {
    paramTypeSerializer.writeTypePrefixForArray(paramObject, paramJsonGenerator);
    serializeContents(paramObject, paramJsonGenerator, paramSerializerProvider);
    paramTypeSerializer.writeTypeSuffixForArray(paramObject, paramJsonGenerator);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/std/StdArraySerializers$ArraySerializerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */