package com.flurry.org.codehaus.jackson.map.deser;

import com.flurry.org.codehaus.jackson.JsonNode;
import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.io.SerializedString;
import com.flurry.org.codehaus.jackson.map.AbstractTypeResolver;
import com.flurry.org.codehaus.jackson.map.AnnotationIntrospector;
import com.flurry.org.codehaus.jackson.map.BeanProperty;
import com.flurry.org.codehaus.jackson.map.ContextualDeserializer;
import com.flurry.org.codehaus.jackson.map.ContextualKeyDeserializer;
import com.flurry.org.codehaus.jackson.map.DeserializationConfig;
import com.flurry.org.codehaus.jackson.map.DeserializationConfig.Feature;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.DeserializerFactory;
import com.flurry.org.codehaus.jackson.map.DeserializerProvider;
import com.flurry.org.codehaus.jackson.map.Deserializers;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import com.flurry.org.codehaus.jackson.map.KeyDeserializer;
import com.flurry.org.codehaus.jackson.map.KeyDeserializers;
import com.flurry.org.codehaus.jackson.map.ResolvableDeserializer;
import com.flurry.org.codehaus.jackson.map.TypeDeserializer;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedClass;
import com.flurry.org.codehaus.jackson.map.type.ArrayType;
import com.flurry.org.codehaus.jackson.map.type.CollectionLikeType;
import com.flurry.org.codehaus.jackson.map.type.CollectionType;
import com.flurry.org.codehaus.jackson.map.type.MapLikeType;
import com.flurry.org.codehaus.jackson.map.type.MapType;
import com.flurry.org.codehaus.jackson.map.util.ClassUtil;
import com.flurry.org.codehaus.jackson.map.util.RootNameLookup;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class StdDeserializerProvider
  extends DeserializerProvider
{
  protected final ConcurrentHashMap<JavaType, JsonDeserializer<Object>> _cachedDeserializers = new ConcurrentHashMap(64, 0.75F, 2);
  protected DeserializerFactory _factory;
  protected final HashMap<JavaType, JsonDeserializer<Object>> _incompleteDeserializers = new HashMap(8);
  protected final RootNameLookup _rootNames;
  
  public StdDeserializerProvider()
  {
    this(BeanDeserializerFactory.instance);
  }
  
  public StdDeserializerProvider(DeserializerFactory paramDeserializerFactory)
  {
    this._factory = paramDeserializerFactory;
    this._rootNames = new RootNameLookup();
  }
  
  protected JsonDeserializer<Object> _createAndCache2(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    try
    {
      paramBeanProperty = _createDeserializer(paramDeserializationConfig, paramJavaType, paramBeanProperty);
      if (paramBeanProperty == null)
      {
        paramDeserializationConfig = null;
        return paramDeserializationConfig;
      }
    }
    catch (IllegalArgumentException paramDeserializationConfig)
    {
      throw new JsonMappingException(paramDeserializationConfig.getMessage(), null, paramDeserializationConfig);
    }
    boolean bool3 = paramBeanProperty instanceof ResolvableDeserializer;
    if (paramBeanProperty.getClass() == BeanDeserializer.class) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.USE_ANNOTATIONS))
        {
          Object localObject = paramDeserializationConfig.getAnnotationIntrospector();
          localObject = ((AnnotationIntrospector)localObject).findCachability(AnnotatedClass.construct(paramBeanProperty.getClass(), (AnnotationIntrospector)localObject, null));
          bool2 = bool1;
          if (localObject != null) {
            bool2 = ((Boolean)localObject).booleanValue();
          }
        }
      }
      if (bool3)
      {
        this._incompleteDeserializers.put(paramJavaType, paramBeanProperty);
        _resolveDeserializer(paramDeserializationConfig, (ResolvableDeserializer)paramBeanProperty);
        this._incompleteDeserializers.remove(paramJavaType);
      }
      paramDeserializationConfig = paramBeanProperty;
      if (!bool2) {
        break;
      }
      this._cachedDeserializers.put(paramJavaType, paramBeanProperty);
      return paramBeanProperty;
    }
  }
  
  protected JsonDeserializer<Object> _createAndCacheValueDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    synchronized (this._incompleteDeserializers)
    {
      JsonDeserializer localJsonDeserializer = _findCachedDeserializer(paramJavaType);
      if (localJsonDeserializer != null) {
        return localJsonDeserializer;
      }
      i = this._incompleteDeserializers.size();
      if (i > 0)
      {
        localJsonDeserializer = (JsonDeserializer)this._incompleteDeserializers.get(paramJavaType);
        if (localJsonDeserializer != null) {
          return localJsonDeserializer;
        }
      }
    }
  }
  
  protected JsonDeserializer<Object> _createDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    if (paramJavaType.isEnumType()) {
      return this._factory.createEnumDeserializer(paramDeserializationConfig, this, paramJavaType, paramBeanProperty);
    }
    if (paramJavaType.isContainerType())
    {
      if (paramJavaType.isArrayType()) {
        return this._factory.createArrayDeserializer(paramDeserializationConfig, this, (ArrayType)paramJavaType, paramBeanProperty);
      }
      if (paramJavaType.isMapLikeType())
      {
        paramJavaType = (MapLikeType)paramJavaType;
        if (paramJavaType.isTrueMapType()) {
          return this._factory.createMapDeserializer(paramDeserializationConfig, this, (MapType)paramJavaType, paramBeanProperty);
        }
        return this._factory.createMapLikeDeserializer(paramDeserializationConfig, this, paramJavaType, paramBeanProperty);
      }
      if (paramJavaType.isCollectionLikeType())
      {
        paramJavaType = (CollectionLikeType)paramJavaType;
        if (paramJavaType.isTrueCollectionType()) {
          return this._factory.createCollectionDeserializer(paramDeserializationConfig, this, (CollectionType)paramJavaType, paramBeanProperty);
        }
        return this._factory.createCollectionLikeDeserializer(paramDeserializationConfig, this, paramJavaType, paramBeanProperty);
      }
    }
    if (JsonNode.class.isAssignableFrom(paramJavaType.getRawClass())) {
      return this._factory.createTreeDeserializer(paramDeserializationConfig, this, paramJavaType, paramBeanProperty);
    }
    return this._factory.createBeanDeserializer(paramDeserializationConfig, this, paramJavaType, paramBeanProperty);
  }
  
  protected JsonDeserializer<Object> _findCachedDeserializer(JavaType paramJavaType)
  {
    if (paramJavaType == null) {
      throw new IllegalArgumentException();
    }
    return (JsonDeserializer)this._cachedDeserializers.get(paramJavaType);
  }
  
  protected KeyDeserializer _handleUnknownKeyDeserializer(JavaType paramJavaType)
    throws JsonMappingException
  {
    throw new JsonMappingException("Can not find a (Map) Key deserializer for type " + paramJavaType);
  }
  
  protected JsonDeserializer<Object> _handleUnknownValueDeserializer(JavaType paramJavaType)
    throws JsonMappingException
  {
    if (!ClassUtil.isConcrete(paramJavaType.getRawClass())) {
      throw new JsonMappingException("Can not find a Value deserializer for abstract type " + paramJavaType);
    }
    throw new JsonMappingException("Can not find a Value deserializer for type " + paramJavaType);
  }
  
  protected void _resolveDeserializer(DeserializationConfig paramDeserializationConfig, ResolvableDeserializer paramResolvableDeserializer)
    throws JsonMappingException
  {
    paramResolvableDeserializer.resolve(paramDeserializationConfig, this);
  }
  
  public int cachedDeserializersCount()
  {
    return this._cachedDeserializers.size();
  }
  
  public SerializedString findExpectedRootName(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
    throws JsonMappingException
  {
    return this._rootNames.findRootName(paramJavaType, paramDeserializationConfig);
  }
  
  public KeyDeserializer findKeyDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    KeyDeserializer localKeyDeserializer2 = this._factory.createKeyDeserializer(paramDeserializationConfig, paramJavaType, paramBeanProperty);
    KeyDeserializer localKeyDeserializer1 = localKeyDeserializer2;
    if ((localKeyDeserializer2 instanceof ContextualKeyDeserializer)) {
      localKeyDeserializer1 = ((ContextualKeyDeserializer)localKeyDeserializer2).createContextual(paramDeserializationConfig, paramBeanProperty);
    }
    paramDeserializationConfig = localKeyDeserializer1;
    if (localKeyDeserializer1 == null) {
      paramDeserializationConfig = _handleUnknownKeyDeserializer(paramJavaType);
    }
    return paramDeserializationConfig;
  }
  
  public JsonDeserializer<Object> findTypedValueDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    JsonDeserializer localJsonDeserializer = findValueDeserializer(paramDeserializationConfig, paramJavaType, paramBeanProperty);
    paramJavaType = this._factory.findTypeDeserializer(paramDeserializationConfig, paramJavaType, paramBeanProperty);
    paramDeserializationConfig = localJsonDeserializer;
    if (paramJavaType != null) {
      paramDeserializationConfig = new WrappedDeserializer(paramJavaType, localJsonDeserializer);
    }
    return paramDeserializationConfig;
  }
  
  public JsonDeserializer<Object> findValueDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    Object localObject = _findCachedDeserializer(paramJavaType);
    if (localObject != null)
    {
      paramJavaType = (JavaType)localObject;
      if ((localObject instanceof ContextualDeserializer)) {
        paramJavaType = ((ContextualDeserializer)localObject).createContextual(paramDeserializationConfig, paramBeanProperty);
      }
      return paramJavaType;
    }
    JsonDeserializer localJsonDeserializer = _createAndCacheValueDeserializer(paramDeserializationConfig, paramJavaType, paramBeanProperty);
    localObject = localJsonDeserializer;
    if (localJsonDeserializer == null) {
      localObject = _handleUnknownValueDeserializer(paramJavaType);
    }
    paramJavaType = (JavaType)localObject;
    if ((localObject instanceof ContextualDeserializer)) {
      paramJavaType = ((ContextualDeserializer)localObject).createContextual(paramDeserializationConfig, paramBeanProperty);
    }
    return paramJavaType;
  }
  
  public void flushCachedDeserializers()
  {
    this._cachedDeserializers.clear();
  }
  
  public boolean hasValueDeserializerFor(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
  {
    boolean bool = false;
    JsonDeserializer localJsonDeserializer2 = _findCachedDeserializer(paramJavaType);
    JsonDeserializer localJsonDeserializer1 = localJsonDeserializer2;
    if (localJsonDeserializer2 == null) {}
    try
    {
      localJsonDeserializer1 = _createAndCacheValueDeserializer(paramDeserializationConfig, paramJavaType, null);
      if (localJsonDeserializer1 != null) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramDeserializationConfig) {}
    return false;
  }
  
  public JavaType mapAbstractType(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
    throws JsonMappingException
  {
    return this._factory.mapAbstractType(paramDeserializationConfig, paramJavaType);
  }
  
  public DeserializerProvider withAbstractTypeResolver(AbstractTypeResolver paramAbstractTypeResolver)
  {
    return withFactory(this._factory.withAbstractTypeResolver(paramAbstractTypeResolver));
  }
  
  public DeserializerProvider withAdditionalDeserializers(Deserializers paramDeserializers)
  {
    return withFactory(this._factory.withAdditionalDeserializers(paramDeserializers));
  }
  
  public DeserializerProvider withAdditionalKeyDeserializers(KeyDeserializers paramKeyDeserializers)
  {
    return withFactory(this._factory.withAdditionalKeyDeserializers(paramKeyDeserializers));
  }
  
  public DeserializerProvider withDeserializerModifier(BeanDeserializerModifier paramBeanDeserializerModifier)
  {
    return withFactory(this._factory.withDeserializerModifier(paramBeanDeserializerModifier));
  }
  
  public StdDeserializerProvider withFactory(DeserializerFactory paramDeserializerFactory)
  {
    if (getClass() != StdDeserializerProvider.class) {
      throw new IllegalStateException("DeserializerProvider of type " + getClass().getName() + " does not override 'withFactory()' method");
    }
    return new StdDeserializerProvider(paramDeserializerFactory);
  }
  
  public DeserializerProvider withValueInstantiators(ValueInstantiators paramValueInstantiators)
  {
    return withFactory(this._factory.withValueInstantiators(paramValueInstantiators));
  }
  
  protected static final class WrappedDeserializer
    extends JsonDeserializer<Object>
  {
    final JsonDeserializer<Object> _deserializer;
    final TypeDeserializer _typeDeserializer;
    
    public WrappedDeserializer(TypeDeserializer paramTypeDeserializer, JsonDeserializer<Object> paramJsonDeserializer)
    {
      this._typeDeserializer = paramTypeDeserializer;
      this._deserializer = paramJsonDeserializer;
    }
    
    public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      return this._deserializer.deserializeWithType(paramJsonParser, paramDeserializationContext, this._typeDeserializer);
    }
    
    public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
      throws IOException, JsonProcessingException
    {
      throw new IllegalStateException("Type-wrapped deserializer's deserializeWithType should never get called");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/StdDeserializerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */