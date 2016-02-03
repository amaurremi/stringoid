package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.reflect.Constructor;

public final class InnerClassProperty
  extends SettableBeanProperty
{
  protected final Constructor<?> _creator;
  protected final SettableBeanProperty _delegate;
  
  public InnerClassProperty(SettableBeanProperty paramSettableBeanProperty, Constructor<?> paramConstructor)
  {
    super(paramSettableBeanProperty);
    this._delegate = paramSettableBeanProperty;
    this._creator = paramConstructor;
  }
  
  protected InnerClassProperty(InnerClassProperty paramInnerClassProperty, JsonDeserializer<?> paramJsonDeserializer)
  {
    super(paramInnerClassProperty, paramJsonDeserializer);
    this._delegate = paramInnerClassProperty._delegate.withValueDeserializer(paramJsonDeserializer);
    this._creator = paramInnerClassProperty._creator;
  }
  
  protected InnerClassProperty(InnerClassProperty paramInnerClassProperty, String paramString)
  {
    super(paramInnerClassProperty, paramString);
    this._delegate = paramInnerClassProperty._delegate.withName(paramString);
    this._creator = paramInnerClassProperty._creator;
  }
  
  public void deserializeAndSet(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {
      if (this._nullProvider == null) {
        paramJsonParser = (JsonParser)localObject2;
      }
    }
    for (;;)
    {
      set(paramObject, paramJsonParser);
      return;
      paramJsonParser = this._nullProvider.nullValue(paramDeserializationContext);
      continue;
      if (this._valueTypeDeserializer != null) {
        paramJsonParser = this._valueDeserializer.deserializeWithType(paramJsonParser, paramDeserializationContext, this._valueTypeDeserializer);
      }
      try
      {
        localObject2 = this._creator.newInstance(new Object[] { paramObject });
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ClassUtil.unwrapAndThrowAsIAE(localException, "Failed to instantiate class " + this._creator.getDeclaringClass().getName() + ", problem: " + localException.getMessage());
        }
      }
      this._valueDeserializer.deserialize(paramJsonParser, paramDeserializationContext, localObject1);
      paramJsonParser = (JsonParser)localObject1;
    }
  }
  
  public Object deserializeSetAndReturn(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
  {
    return setAndReturn(paramObject, deserialize(paramJsonParser, paramDeserializationContext));
  }
  
  public AnnotatedMember getMember()
  {
    return this._delegate.getMember();
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    this._delegate.set(paramObject1, paramObject2);
  }
  
  public Object setAndReturn(Object paramObject1, Object paramObject2)
  {
    return this._delegate.setAndReturn(paramObject1, paramObject2);
  }
  
  public InnerClassProperty withName(String paramString)
  {
    return new InnerClassProperty(this, paramString);
  }
  
  public InnerClassProperty withValueDeserializer(JsonDeserializer<?> paramJsonDeserializer)
  {
    return new InnerClassProperty(this, paramJsonDeserializer);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/impl/InnerClassProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */