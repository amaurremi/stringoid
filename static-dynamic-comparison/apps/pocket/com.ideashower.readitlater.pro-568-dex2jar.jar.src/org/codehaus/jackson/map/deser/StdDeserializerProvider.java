package org.codehaus.jackson.map.deser;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.io.SerializedString;
import org.codehaus.jackson.map.AbstractTypeResolver;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.ContextualDeserializer;
import org.codehaus.jackson.map.ContextualKeyDeserializer;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializerFactory;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.Deserializers;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.map.KeyDeserializers;
import org.codehaus.jackson.map.ResolvableDeserializer;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.type.ArrayType;
import org.codehaus.jackson.map.type.CollectionLikeType;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.MapLikeType;
import org.codehaus.jackson.map.type.MapType;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.map.util.RootNameLookup;
import org.codehaus.jackson.type.JavaType;

public class StdDeserializerProvider
  extends DeserializerProvider
{
  protected final ConcurrentHashMap _cachedDeserializers = new ConcurrentHashMap(64, 0.75F, 2);
  protected DeserializerFactory _factory;
  protected final HashMap _incompleteDeserializers = new HashMap(8);
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
  
  protected JsonDeserializer _createAndCache2(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
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
  
  protected JsonDeserializer _createAndCacheValueDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    int i;
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
    try
    {
      paramDeserializationConfig = _createAndCache2(paramDeserializationConfig, paramJavaType, paramBeanProperty);
      if ((i == 0) && (this._incompleteDeserializers.size() > 0)) {
        this._incompleteDeserializers.clear();
      }
      return paramDeserializationConfig;
    }
    finally
    {
      paramDeserializationConfig = finally;
      if ((i == 0) && (this._incompleteDeserializers.size() > 0)) {
        this._incompleteDeserializers.clear();
      }
      throw paramDeserializationConfig;
    }
  }
  
  protected JsonDeserializer _createDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
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
  
  protected JsonDeserializer _findCachedDeserializer(JavaType paramJavaType)
  {
    if (paramJavaType == null) {
      throw new IllegalArgumentException();
    }
    return (JsonDeserializer)this._cachedDeserializers.get(paramJavaType);
  }
  
  protected KeyDeserializer _handleUnknownKeyDeserializer(JavaType paramJavaType)
  {
    throw new JsonMappingException("Can not find a (Map) Key deserializer for type " + paramJavaType);
  }
  
  protected JsonDeserializer _handleUnknownValueDeserializer(JavaType paramJavaType)
  {
    if (!ClassUtil.isConcrete(paramJavaType.getRawClass())) {
      throw new JsonMappingException("Can not find a Value deserializer for abstract type " + paramJavaType);
    }
    throw new JsonMappingException("Can not find a Value deserializer for type " + paramJavaType);
  }
  
  protected void _resolveDeserializer(DeserializationConfig paramDeserializationConfig, ResolvableDeserializer paramResolvableDeserializer)
  {
    paramResolvableDeserializer.resolve(paramDeserializationConfig, this);
  }
  
  public int cachedDeserializersCount()
  {
    return this._cachedDeserializers.size();
  }
  
  public SerializedString findExpectedRootName(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
  {
    return this._rootNames.findRootName(paramJavaType, paramDeserializationConfig);
  }
  
  public KeyDeserializer findKeyDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
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
  
  public JsonDeserializer findTypedValueDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    JsonDeserializer localJsonDeserializer = findValueDeserializer(paramDeserializationConfig, paramJavaType, paramBeanProperty);
    paramDeserializationConfig = this._factory.findTypeDeserializer(paramDeserializationConfig, paramJavaType, paramBeanProperty);
    if (paramDeserializationConfig != null) {
      return new StdDeserializerProvider.WrappedDeserializer(paramDeserializationConfig, localJsonDeserializer);
    }
    return localJsonDeserializer;
  }
  
  public JsonDeserializer findValueDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    Object localObject = _findCachedDeserializer(paramJavaType);
    if (localObject != null)
    {
      paramJavaType = (JavaType)localObject;
      if ((localObject instanceof ContextualDeserializer)) {
        paramJavaType = ((ContextualDeserializer)localObject).createContextual(paramDeserializationConfig, paramBeanProperty);
      }
    }
    do
    {
      return paramJavaType;
      JsonDeserializer localJsonDeserializer = _createAndCacheValueDeserializer(paramDeserializationConfig, paramJavaType, paramBeanProperty);
      localObject = localJsonDeserializer;
      if (localJsonDeserializer == null) {
        localObject = _handleUnknownValueDeserializer(paramJavaType);
      }
      paramJavaType = (JavaType)localObject;
    } while (!(localObject instanceof ContextualDeserializer));
    return ((ContextualDeserializer)localObject).createContextual(paramDeserializationConfig, paramBeanProperty);
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/StdDeserializerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */