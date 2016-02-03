package org.codehaus.jackson.map.ser;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

final class FilteredBeanPropertyWriter$MultiView
  extends BeanPropertyWriter
{
  protected final BeanPropertyWriter _delegate;
  protected final Class[] _views;
  
  protected FilteredBeanPropertyWriter$MultiView(BeanPropertyWriter paramBeanPropertyWriter, Class[] paramArrayOfClass)
  {
    super(paramBeanPropertyWriter);
    this._delegate = paramBeanPropertyWriter;
    this._views = paramArrayOfClass;
  }
  
  public void serializeAsField(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    Class localClass = paramSerializerProvider.getSerializationView();
    if (localClass != null)
    {
      int i = 0;
      int j = this._views.length;
      for (;;)
      {
        if ((i >= j) || (this._views[i].isAssignableFrom(localClass)))
        {
          if (i != j) {
            break;
          }
          return;
        }
        i += 1;
      }
    }
    this._delegate.serializeAsField(paramObject, paramJsonGenerator, paramSerializerProvider);
  }
  
  public BeanPropertyWriter withSerializer(JsonSerializer paramJsonSerializer)
  {
    return new MultiView(this._delegate.withSerializer(paramJsonSerializer), this._views);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/FilteredBeanPropertyWriter$MultiView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */