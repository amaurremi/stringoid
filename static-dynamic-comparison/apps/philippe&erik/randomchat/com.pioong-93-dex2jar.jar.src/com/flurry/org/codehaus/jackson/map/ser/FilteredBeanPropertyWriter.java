package com.flurry.org.codehaus.jackson.map.ser;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.map.JsonSerializer;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;

public abstract class FilteredBeanPropertyWriter
{
  public static BeanPropertyWriter constructViewBased(BeanPropertyWriter paramBeanPropertyWriter, Class<?>[] paramArrayOfClass)
  {
    if (paramArrayOfClass.length == 1) {
      return new SingleView(paramBeanPropertyWriter, paramArrayOfClass[0]);
    }
    return new MultiView(paramBeanPropertyWriter, paramArrayOfClass);
  }
  
  private static final class MultiView
    extends BeanPropertyWriter
  {
    protected final BeanPropertyWriter _delegate;
    protected final Class<?>[] _views;
    
    protected MultiView(BeanPropertyWriter paramBeanPropertyWriter, Class<?>[] paramArrayOfClass)
    {
      super();
      this._delegate = paramBeanPropertyWriter;
      this._views = paramArrayOfClass;
    }
    
    public void serializeAsField(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws Exception
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
    
    public BeanPropertyWriter withSerializer(JsonSerializer<Object> paramJsonSerializer)
    {
      return new MultiView(this._delegate.withSerializer(paramJsonSerializer), this._views);
    }
  }
  
  private static final class SingleView
    extends BeanPropertyWriter
  {
    protected final BeanPropertyWriter _delegate;
    protected final Class<?> _view;
    
    protected SingleView(BeanPropertyWriter paramBeanPropertyWriter, Class<?> paramClass)
    {
      super();
      this._delegate = paramBeanPropertyWriter;
      this._view = paramClass;
    }
    
    public void serializeAsField(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws Exception
    {
      Class localClass = paramSerializerProvider.getSerializationView();
      if ((localClass == null) || (this._view.isAssignableFrom(localClass))) {
        this._delegate.serializeAsField(paramObject, paramJsonGenerator, paramSerializerProvider);
      }
    }
    
    public BeanPropertyWriter withSerializer(JsonSerializer<Object> paramJsonSerializer)
    {
      return new SingleView(this._delegate.withSerializer(paramJsonSerializer), this._view);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/ser/FilteredBeanPropertyWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */