package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.databind.util.NameTransformer;

public class BeanAsArraySerializer
  extends BeanSerializerBase
{
  protected final BeanSerializerBase _defaultSerializer;
  
  public BeanAsArraySerializer(BeanSerializerBase paramBeanSerializerBase)
  {
    super(paramBeanSerializerBase, (ObjectIdWriter)null);
    this._defaultSerializer = paramBeanSerializerBase;
  }
  
  protected BeanAsArraySerializer(BeanSerializerBase paramBeanSerializerBase, String[] paramArrayOfString)
  {
    super(paramBeanSerializerBase, paramArrayOfString);
    this._defaultSerializer = paramBeanSerializerBase;
  }
  
  protected BeanSerializerBase asArraySerializer()
  {
    return this;
  }
  
  public boolean isUnwrappingSerializer()
  {
    return false;
  }
  
  public String toString()
  {
    return "BeanAsArraySerializer for " + handledType().getName();
  }
  
  public JsonSerializer<Object> unwrappingSerializer(NameTransformer paramNameTransformer)
  {
    return this._defaultSerializer.unwrappingSerializer(paramNameTransformer);
  }
  
  protected BeanAsArraySerializer withIgnorals(String[] paramArrayOfString)
  {
    return new BeanAsArraySerializer(this, paramArrayOfString);
  }
  
  public BeanSerializerBase withObjectIdWriter(ObjectIdWriter paramObjectIdWriter)
  {
    return this._defaultSerializer.withObjectIdWriter(paramObjectIdWriter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/impl/BeanAsArraySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */