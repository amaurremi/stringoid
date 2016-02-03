package org.codehaus.jackson.map.ser.impl;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.BeanPropertyWriter;

public class UnwrappingBeanPropertyWriter
  extends BeanPropertyWriter
{
  public UnwrappingBeanPropertyWriter(BeanPropertyWriter paramBeanPropertyWriter)
  {
    super(paramBeanPropertyWriter);
  }
  
  public UnwrappingBeanPropertyWriter(BeanPropertyWriter paramBeanPropertyWriter, JsonSerializer paramJsonSerializer)
  {
    super(paramBeanPropertyWriter, paramJsonSerializer);
  }
  
  protected JsonSerializer _findAndAddDynamic(PropertySerializerMap paramPropertySerializerMap, Class paramClass, SerializerProvider paramSerializerProvider)
  {
    if (this._nonTrivialBaseType != null) {}
    for (paramPropertySerializerMap = paramSerializerProvider.findValueSerializer(paramSerializerProvider.constructSpecializedType(this._nonTrivialBaseType, paramClass), this);; paramPropertySerializerMap = paramSerializerProvider.findValueSerializer(paramClass, this))
    {
      paramSerializerProvider = paramPropertySerializerMap;
      if (!paramPropertySerializerMap.isUnwrappingSerializer()) {
        paramSerializerProvider = paramPropertySerializerMap.unwrappingSerializer();
      }
      this._dynamicSerializers = this._dynamicSerializers.newWith(paramClass, paramSerializerProvider);
      return paramSerializerProvider;
    }
  }
  
  public void serializeAsField(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    Object localObject = get(paramObject);
    if (localObject == null) {}
    do
    {
      return;
      if (localObject == paramObject) {
        _reportSelfReference(paramObject);
      }
    } while ((this._suppressableValue != null) && (this._suppressableValue.equals(localObject)));
    JsonSerializer localJsonSerializer = this._serializer;
    paramObject = localJsonSerializer;
    if (localJsonSerializer == null)
    {
      Class localClass = localObject.getClass();
      PropertySerializerMap localPropertySerializerMap = this._dynamicSerializers;
      localJsonSerializer = localPropertySerializerMap.serializerFor(localClass);
      paramObject = localJsonSerializer;
      if (localJsonSerializer == null) {
        paramObject = _findAndAddDynamic(localPropertySerializerMap, localClass, paramSerializerProvider);
      }
    }
    if (!((JsonSerializer)paramObject).isUnwrappingSerializer()) {
      paramJsonGenerator.writeFieldName(this._name);
    }
    if (this._typeSerializer == null)
    {
      ((JsonSerializer)paramObject).serialize(localObject, paramJsonGenerator, paramSerializerProvider);
      return;
    }
    ((JsonSerializer)paramObject).serializeWithType(localObject, paramJsonGenerator, paramSerializerProvider, this._typeSerializer);
  }
  
  public BeanPropertyWriter withSerializer(JsonSerializer paramJsonSerializer)
  {
    if (getClass() != UnwrappingBeanPropertyWriter.class) {
      throw new IllegalStateException("UnwrappingBeanPropertyWriter sub-class does not override 'withSerializer()'; needs to!");
    }
    JsonSerializer localJsonSerializer = paramJsonSerializer;
    if (!paramJsonSerializer.isUnwrappingSerializer()) {
      localJsonSerializer = paramJsonSerializer.unwrappingSerializer();
    }
    return new UnwrappingBeanPropertyWriter(this, localJsonSerializer);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/impl/UnwrappingBeanPropertyWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */