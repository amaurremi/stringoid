package com.flurry.org.codehaus.jackson.map.ser.impl;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import com.flurry.org.codehaus.jackson.map.JsonSerializer;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import com.flurry.org.codehaus.jackson.map.ser.BeanPropertyWriter;

public class UnwrappingBeanPropertyWriter
  extends BeanPropertyWriter
{
  public UnwrappingBeanPropertyWriter(BeanPropertyWriter paramBeanPropertyWriter)
  {
    super(paramBeanPropertyWriter);
  }
  
  public UnwrappingBeanPropertyWriter(BeanPropertyWriter paramBeanPropertyWriter, JsonSerializer<Object> paramJsonSerializer)
  {
    super(paramBeanPropertyWriter, paramJsonSerializer);
  }
  
  protected JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap paramPropertySerializerMap, Class<?> paramClass, SerializerProvider paramSerializerProvider)
    throws JsonMappingException
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
    throws Exception
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
  
  public BeanPropertyWriter withSerializer(JsonSerializer<Object> paramJsonSerializer)
  {
    if (getClass() != UnwrappingBeanPropertyWriter.class) {
      throw new IllegalStateException("UnwrappingBeanPropertyWriter sub-class does not override 'withSerializer()'; needs to!");
    }
    Object localObject = paramJsonSerializer;
    if (!paramJsonSerializer.isUnwrappingSerializer()) {
      localObject = paramJsonSerializer.unwrappingSerializer();
    }
    return new UnwrappingBeanPropertyWriter(this, (JsonSerializer)localObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/ser/impl/UnwrappingBeanPropertyWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */