package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.util.NameTransformer;

final class FilteredBeanPropertyWriter$MultiView
  extends BeanPropertyWriter
{
  protected final BeanPropertyWriter _delegate;
  protected final Class<?>[] _views;
  
  protected FilteredBeanPropertyWriter$MultiView(BeanPropertyWriter paramBeanPropertyWriter, Class<?>[] paramArrayOfClass)
  {
    super(paramBeanPropertyWriter);
    this._delegate = paramBeanPropertyWriter;
    this._views = paramArrayOfClass;
  }
  
  public void assignNullSerializer(JsonSerializer<Object> paramJsonSerializer)
  {
    this._delegate.assignNullSerializer(paramJsonSerializer);
  }
  
  public void assignSerializer(JsonSerializer<Object> paramJsonSerializer)
  {
    this._delegate.assignSerializer(paramJsonSerializer);
  }
  
  public MultiView rename(NameTransformer paramNameTransformer)
  {
    return new MultiView(this._delegate.rename(paramNameTransformer), this._views);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/impl/FilteredBeanPropertyWriter$MultiView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */