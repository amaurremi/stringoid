package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import java.util.concurrent.atomic.AtomicReference;

public class JdkDeserializers$AtomicReferenceDeserializer
  extends StdScalarDeserializer<AtomicReference<?>>
  implements ContextualDeserializer
{
  protected final JavaType _referencedType;
  protected final JsonDeserializer<?> _valueDeserializer;
  
  public JdkDeserializers$AtomicReferenceDeserializer(JavaType paramJavaType)
  {
    this(paramJavaType, null);
  }
  
  public JdkDeserializers$AtomicReferenceDeserializer(JavaType paramJavaType, JsonDeserializer<?> paramJsonDeserializer)
  {
    super(AtomicReference.class);
    this._referencedType = paramJavaType;
    this._valueDeserializer = paramJsonDeserializer;
  }
  
  public JsonDeserializer<?> createContextual(DeserializationContext paramDeserializationContext, BeanProperty paramBeanProperty)
  {
    if (this._valueDeserializer != null) {
      return this;
    }
    return new AtomicReferenceDeserializer(this._referencedType, paramDeserializationContext.findContextualValueDeserializer(this._referencedType, paramBeanProperty));
  }
  
  public AtomicReference<?> deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    return new AtomicReference(this._valueDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/JdkDeserializers$AtomicReferenceDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */