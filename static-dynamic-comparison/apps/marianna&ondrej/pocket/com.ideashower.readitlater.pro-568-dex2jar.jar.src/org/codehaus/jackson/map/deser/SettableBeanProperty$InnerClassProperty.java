package org.codehaus.jackson.map.deser;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.util.ClassUtil;

public final class SettableBeanProperty$InnerClassProperty
  extends SettableBeanProperty
{
  protected final Constructor _creator;
  protected final SettableBeanProperty _delegate;
  
  protected SettableBeanProperty$InnerClassProperty(InnerClassProperty paramInnerClassProperty, JsonDeserializer paramJsonDeserializer)
  {
    super(paramInnerClassProperty, paramJsonDeserializer);
    this._delegate = paramInnerClassProperty._delegate.withValueDeserializer(paramJsonDeserializer);
    this._creator = paramInnerClassProperty._creator;
  }
  
  public SettableBeanProperty$InnerClassProperty(SettableBeanProperty paramSettableBeanProperty, Constructor paramConstructor)
  {
    super(paramSettableBeanProperty);
    this._delegate = paramSettableBeanProperty;
    this._creator = paramConstructor;
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
  
  public Annotation getAnnotation(Class paramClass)
  {
    return this._delegate.getAnnotation(paramClass);
  }
  
  public AnnotatedMember getMember()
  {
    return this._delegate.getMember();
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    this._delegate.set(paramObject1, paramObject2);
  }
  
  public InnerClassProperty withValueDeserializer(JsonDeserializer paramJsonDeserializer)
  {
    return new InnerClassProperty(this, paramJsonDeserializer);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/SettableBeanProperty$InnerClassProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */