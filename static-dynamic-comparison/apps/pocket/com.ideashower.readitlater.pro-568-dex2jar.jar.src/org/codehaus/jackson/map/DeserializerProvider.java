package org.codehaus.jackson.map;

import org.codehaus.jackson.io.SerializedString;
import org.codehaus.jackson.map.deser.BeanDeserializerModifier;
import org.codehaus.jackson.map.deser.ValueInstantiators;
import org.codehaus.jackson.type.JavaType;

public abstract class DeserializerProvider
{
  public abstract int cachedDeserializersCount();
  
  public abstract SerializedString findExpectedRootName(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType);
  
  public abstract KeyDeserializer findKeyDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty);
  
  public abstract JsonDeserializer findTypedValueDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty);
  
  public abstract JsonDeserializer findValueDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty);
  
  public abstract void flushCachedDeserializers();
  
  public abstract boolean hasValueDeserializerFor(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType);
  
  public abstract JavaType mapAbstractType(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType);
  
  public abstract DeserializerProvider withAbstractTypeResolver(AbstractTypeResolver paramAbstractTypeResolver);
  
  public abstract DeserializerProvider withAdditionalDeserializers(Deserializers paramDeserializers);
  
  public abstract DeserializerProvider withAdditionalKeyDeserializers(KeyDeserializers paramKeyDeserializers);
  
  public abstract DeserializerProvider withDeserializerModifier(BeanDeserializerModifier paramBeanDeserializerModifier);
  
  public abstract DeserializerProvider withFactory(DeserializerFactory paramDeserializerFactory);
  
  public abstract DeserializerProvider withValueInstantiators(ValueInstantiators paramValueInstantiators);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/DeserializerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */