package org.codehaus.jackson.map.ser;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

final class FilteredBeanPropertyWriter$SingleView
  extends BeanPropertyWriter
{
  protected final BeanPropertyWriter _delegate;
  protected final Class _view;
  
  protected FilteredBeanPropertyWriter$SingleView(BeanPropertyWriter paramBeanPropertyWriter, Class paramClass)
  {
    super(paramBeanPropertyWriter);
    this._delegate = paramBeanPropertyWriter;
    this._view = paramClass;
  }
  
  public void serializeAsField(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    Class localClass = paramSerializerProvider.getSerializationView();
    if ((localClass == null) || (this._view.isAssignableFrom(localClass))) {
      this._delegate.serializeAsField(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
  }
  
  public BeanPropertyWriter withSerializer(JsonSerializer paramJsonSerializer)
  {
    return new SingleView(this._delegate.withSerializer(paramJsonSerializer), this._view);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/FilteredBeanPropertyWriter$SingleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */