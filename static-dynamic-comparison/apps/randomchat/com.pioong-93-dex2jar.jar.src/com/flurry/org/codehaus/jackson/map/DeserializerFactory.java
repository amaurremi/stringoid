package com.flurry.org.codehaus.jackson.map;

import com.flurry.org.codehaus.jackson.map.deser.BeanDeserializerModifier;
import com.flurry.org.codehaus.jackson.map.deser.ValueInstantiator;
import com.flurry.org.codehaus.jackson.map.deser.ValueInstantiators;
import com.flurry.org.codehaus.jackson.map.introspect.BasicBeanDescription;
import com.flurry.org.codehaus.jackson.map.type.ArrayType;
import com.flurry.org.codehaus.jackson.map.type.CollectionLikeType;
import com.flurry.org.codehaus.jackson.map.type.CollectionType;
import com.flurry.org.codehaus.jackson.map.type.MapLikeType;
import com.flurry.org.codehaus.jackson.map.type.MapType;
import com.flurry.org.codehaus.jackson.type.JavaType;

public abstract class DeserializerFactory
{
  protected static final Deserializers[] NO_DESERIALIZERS = new Deserializers[0];
  
  public abstract JsonDeserializer<?> createArrayDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, ArrayType paramArrayType, BeanProperty paramBeanProperty)
    throws JsonMappingException;
  
  public abstract JsonDeserializer<Object> createBeanDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException;
  
  public abstract JsonDeserializer<?> createCollectionDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, CollectionType paramCollectionType, BeanProperty paramBeanProperty)
    throws JsonMappingException;
  
  public abstract JsonDeserializer<?> createCollectionLikeDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, CollectionLikeType paramCollectionLikeType, BeanProperty paramBeanProperty)
    throws JsonMappingException;
  
  public abstract JsonDeserializer<?> createEnumDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException;
  
  public KeyDeserializer createKeyDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    return null;
  }
  
  public abstract JsonDeserializer<?> createMapDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, MapType paramMapType, BeanProperty paramBeanProperty)
    throws JsonMappingException;
  
  public abstract JsonDeserializer<?> createMapLikeDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, MapLikeType paramMapLikeType, BeanProperty paramBeanProperty)
    throws JsonMappingException;
  
  public abstract JsonDeserializer<?> createTreeDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException;
  
  public TypeDeserializer findTypeDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    return null;
  }
  
  public abstract ValueInstantiator findValueInstantiator(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription)
    throws JsonMappingException;
  
  public abstract Config getConfig();
  
  public abstract JavaType mapAbstractType(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
    throws JsonMappingException;
  
  public final DeserializerFactory withAbstractTypeResolver(AbstractTypeResolver paramAbstractTypeResolver)
  {
    return withConfig(getConfig().withAbstractTypeResolver(paramAbstractTypeResolver));
  }
  
  public final DeserializerFactory withAdditionalDeserializers(Deserializers paramDeserializers)
  {
    return withConfig(getConfig().withAdditionalDeserializers(paramDeserializers));
  }
  
  public final DeserializerFactory withAdditionalKeyDeserializers(KeyDeserializers paramKeyDeserializers)
  {
    return withConfig(getConfig().withAdditionalKeyDeserializers(paramKeyDeserializers));
  }
  
  public abstract DeserializerFactory withConfig(Config paramConfig);
  
  public final DeserializerFactory withDeserializerModifier(BeanDeserializerModifier paramBeanDeserializerModifier)
  {
    return withConfig(getConfig().withDeserializerModifier(paramBeanDeserializerModifier));
  }
  
  public final DeserializerFactory withValueInstantiators(ValueInstantiators paramValueInstantiators)
  {
    return withConfig(getConfig().withValueInstantiators(paramValueInstantiators));
  }
  
  public static abstract class Config
  {
    public abstract Iterable<AbstractTypeResolver> abstractTypeResolvers();
    
    public abstract Iterable<BeanDeserializerModifier> deserializerModifiers();
    
    public abstract Iterable<Deserializers> deserializers();
    
    public abstract boolean hasAbstractTypeResolvers();
    
    public abstract boolean hasDeserializerModifiers();
    
    public abstract boolean hasDeserializers();
    
    public abstract boolean hasKeyDeserializers();
    
    public abstract boolean hasValueInstantiators();
    
    public abstract Iterable<KeyDeserializers> keyDeserializers();
    
    public abstract Iterable<ValueInstantiators> valueInstantiators();
    
    public abstract Config withAbstractTypeResolver(AbstractTypeResolver paramAbstractTypeResolver);
    
    public abstract Config withAdditionalDeserializers(Deserializers paramDeserializers);
    
    public abstract Config withAdditionalKeyDeserializers(KeyDeserializers paramKeyDeserializers);
    
    public abstract Config withDeserializerModifier(BeanDeserializerModifier paramBeanDeserializerModifier);
    
    public abstract Config withValueInstantiators(ValueInstantiators paramValueInstantiators);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/DeserializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */