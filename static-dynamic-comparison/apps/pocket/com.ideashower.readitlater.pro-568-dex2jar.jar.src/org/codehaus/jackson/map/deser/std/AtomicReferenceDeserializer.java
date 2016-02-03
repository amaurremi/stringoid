package org.codehaus.jackson.map.deser.std;

import java.util.concurrent.atomic.AtomicReference;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.ResolvableDeserializer;
import org.codehaus.jackson.type.JavaType;

public class AtomicReferenceDeserializer
  extends StdScalarDeserializer
  implements ResolvableDeserializer
{
  protected final BeanProperty _property;
  protected final JavaType _referencedType;
  protected JsonDeserializer _valueDeserializer;
  
  public AtomicReferenceDeserializer(JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    super(AtomicReference.class);
    this._referencedType = paramJavaType;
    this._property = paramBeanProperty;
  }
  
  public AtomicReference deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    return new AtomicReference(this._valueDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
  }
  
  public void resolve(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider)
  {
    this._valueDeserializer = paramDeserializerProvider.findValueDeserializer(paramDeserializationConfig, this._referencedType, this._property);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/AtomicReferenceDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */