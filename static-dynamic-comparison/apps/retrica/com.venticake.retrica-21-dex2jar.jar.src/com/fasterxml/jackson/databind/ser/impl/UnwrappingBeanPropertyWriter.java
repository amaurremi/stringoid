package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.util.NameTransformer;

public class UnwrappingBeanPropertyWriter
  extends BeanPropertyWriter
{
  protected final NameTransformer _nameTransformer;
  
  public UnwrappingBeanPropertyWriter(BeanPropertyWriter paramBeanPropertyWriter, NameTransformer paramNameTransformer)
  {
    super(paramBeanPropertyWriter);
    this._nameTransformer = paramNameTransformer;
  }
  
  private UnwrappingBeanPropertyWriter(UnwrappingBeanPropertyWriter paramUnwrappingBeanPropertyWriter, NameTransformer paramNameTransformer, SerializedString paramSerializedString)
  {
    super(paramUnwrappingBeanPropertyWriter, paramSerializedString);
    this._nameTransformer = paramNameTransformer;
  }
  
  public void assignSerializer(JsonSerializer<Object> paramJsonSerializer)
  {
    super.assignSerializer(paramJsonSerializer);
    if (this._serializer != null)
    {
      paramJsonSerializer = this._nameTransformer;
      if (!this._serializer.isUnwrappingSerializer()) {
        break label55;
      }
      paramJsonSerializer = NameTransformer.chainedTransformer(paramJsonSerializer, ((UnwrappingBeanSerializer)this._serializer)._nameTransformer);
    }
    label55:
    for (;;)
    {
      this._serializer = this._serializer.unwrappingSerializer(paramJsonSerializer);
      return;
    }
  }
  
  public UnwrappingBeanPropertyWriter rename(NameTransformer paramNameTransformer)
  {
    String str = paramNameTransformer.transform(this._name.getValue());
    return new UnwrappingBeanPropertyWriter(this, NameTransformer.chainedTransformer(paramNameTransformer, this._nameTransformer), new SerializedString(str));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/impl/UnwrappingBeanPropertyWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */