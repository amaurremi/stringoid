package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.util.NameTransformer;

final class FilteredBeanPropertyWriter$SingleView
  extends BeanPropertyWriter
{
  protected final BeanPropertyWriter _delegate;
  protected final Class<?> _view;
  
  protected FilteredBeanPropertyWriter$SingleView(BeanPropertyWriter paramBeanPropertyWriter, Class<?> paramClass)
  {
    super(paramBeanPropertyWriter);
    this._delegate = paramBeanPropertyWriter;
    this._view = paramClass;
  }
  
  public void assignNullSerializer(JsonSerializer<Object> paramJsonSerializer)
  {
    this._delegate.assignNullSerializer(paramJsonSerializer);
  }
  
  public void assignSerializer(JsonSerializer<Object> paramJsonSerializer)
  {
    this._delegate.assignSerializer(paramJsonSerializer);
  }
  
  public SingleView rename(NameTransformer paramNameTransformer)
  {
    return new SingleView(this._delegate.rename(paramNameTransformer), this._view);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/impl/FilteredBeanPropertyWriter$SingleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */