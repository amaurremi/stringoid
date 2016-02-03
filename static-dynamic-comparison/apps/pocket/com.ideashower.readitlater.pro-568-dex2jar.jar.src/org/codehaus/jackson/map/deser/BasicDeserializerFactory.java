package org.codehaus.jackson.map.deser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.ContextualDeserializer;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializerFactory;
import org.codehaus.jackson.map.DeserializerFactory.Config;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonDeserializer.None;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.map.KeyDeserializer.None;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.deser.std.AtomicReferenceDeserializer;
import org.codehaus.jackson.map.deser.std.CollectionDeserializer;
import org.codehaus.jackson.map.deser.std.EnumDeserializer;
import org.codehaus.jackson.map.deser.std.EnumMapDeserializer;
import org.codehaus.jackson.map.deser.std.EnumSetDeserializer;
import org.codehaus.jackson.map.deser.std.JsonNodeDeserializer;
import org.codehaus.jackson.map.deser.std.MapDeserializer;
import org.codehaus.jackson.map.deser.std.ObjectArrayDeserializer;
import org.codehaus.jackson.map.deser.std.PrimitiveArrayDeserializers;
import org.codehaus.jackson.map.deser.std.StdKeyDeserializers;
import org.codehaus.jackson.map.deser.std.StringCollectionDeserializer;
import org.codehaus.jackson.map.ext.OptionalHandlerFactory;
import org.codehaus.jackson.map.introspect.Annotated;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.jsontype.SubtypeResolver;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.map.type.ArrayType;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.map.type.CollectionLikeType;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.MapLikeType;
import org.codehaus.jackson.map.type.MapType;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.map.util.EnumResolver;
import org.codehaus.jackson.type.JavaType;

public abstract class BasicDeserializerFactory
  extends DeserializerFactory
{
  protected static final HashMap _arrayDeserializers;
  static final HashMap _collectionFallbacks;
  static final HashMap _keyDeserializers;
  static final HashMap _mapFallbacks;
  static final HashMap _simpleDeserializers = ;
  protected OptionalHandlerFactory optionalHandlers = OptionalHandlerFactory.instance;
  
  static
  {
    _keyDeserializers = StdKeyDeserializers.constructAll();
    _mapFallbacks = new HashMap();
    _mapFallbacks.put(Map.class.getName(), LinkedHashMap.class);
    _mapFallbacks.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
    _mapFallbacks.put(SortedMap.class.getName(), TreeMap.class);
    _mapFallbacks.put("java.util.NavigableMap", TreeMap.class);
    try
    {
      Class localClass1 = Class.forName("java.util.ConcurrentNavigableMap");
      Class localClass2 = Class.forName("java.util.ConcurrentSkipListMap");
      _mapFallbacks.put(localClass1.getName(), localClass2);
      _collectionFallbacks = new HashMap();
      _collectionFallbacks.put(Collection.class.getName(), ArrayList.class);
      _collectionFallbacks.put(List.class.getName(), ArrayList.class);
      _collectionFallbacks.put(Set.class.getName(), HashSet.class);
      _collectionFallbacks.put(SortedSet.class.getName(), TreeSet.class);
      _collectionFallbacks.put(Queue.class.getName(), LinkedList.class);
      _collectionFallbacks.put("java.util.Deque", LinkedList.class);
      _collectionFallbacks.put("java.util.NavigableSet", TreeSet.class);
      _arrayDeserializers = PrimitiveArrayDeserializers.getAll();
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
  }
  
  JsonDeserializer _constructDeserializer(DeserializationConfig paramDeserializationConfig, Annotated paramAnnotated, BeanProperty paramBeanProperty, Object paramObject)
  {
    if ((paramObject instanceof JsonDeserializer))
    {
      paramObject = (JsonDeserializer)paramObject;
      paramAnnotated = (Annotated)paramObject;
      if ((paramObject instanceof ContextualDeserializer)) {
        paramAnnotated = ((ContextualDeserializer)paramObject).createContextual(paramDeserializationConfig, paramBeanProperty);
      }
      return paramAnnotated;
    }
    if (!(paramObject instanceof Class)) {
      throw new IllegalStateException("AnnotationIntrospector returned deserializer definition of type " + paramObject.getClass().getName() + "; expected type JsonDeserializer or Class<JsonDeserializer> instead");
    }
    paramObject = (Class)paramObject;
    if (!JsonDeserializer.class.isAssignableFrom((Class)paramObject)) {
      throw new IllegalStateException("AnnotationIntrospector returned Class " + ((Class)paramObject).getName() + "; expected Class<JsonDeserializer>");
    }
    paramObject = paramDeserializationConfig.deserializerInstance(paramAnnotated, (Class)paramObject);
    paramAnnotated = (Annotated)paramObject;
    if ((paramObject instanceof ContextualDeserializer)) {
      paramAnnotated = ((ContextualDeserializer)paramObject).createContextual(paramDeserializationConfig, paramBeanProperty);
    }
    return paramAnnotated;
  }
  
  protected abstract JsonDeserializer _findCustomArrayDeserializer(ArrayType paramArrayType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BeanProperty paramBeanProperty, TypeDeserializer paramTypeDeserializer, JsonDeserializer paramJsonDeserializer);
  
  protected abstract JsonDeserializer _findCustomCollectionDeserializer(CollectionType paramCollectionType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, TypeDeserializer paramTypeDeserializer, JsonDeserializer paramJsonDeserializer);
  
  protected abstract JsonDeserializer _findCustomCollectionLikeDeserializer(CollectionLikeType paramCollectionLikeType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, TypeDeserializer paramTypeDeserializer, JsonDeserializer paramJsonDeserializer);
  
  protected abstract JsonDeserializer _findCustomEnumDeserializer(Class paramClass, DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty);
  
  protected abstract JsonDeserializer _findCustomMapDeserializer(MapType paramMapType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, KeyDeserializer paramKeyDeserializer, TypeDeserializer paramTypeDeserializer, JsonDeserializer paramJsonDeserializer);
  
  protected abstract JsonDeserializer _findCustomMapLikeDeserializer(MapLikeType paramMapLikeType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, KeyDeserializer paramKeyDeserializer, TypeDeserializer paramTypeDeserializer, JsonDeserializer paramJsonDeserializer);
  
  protected abstract JsonDeserializer _findCustomTreeNodeDeserializer(Class paramClass, DeserializationConfig paramDeserializationConfig, BeanProperty paramBeanProperty);
  
  protected EnumResolver constructEnumResolver(Class paramClass, DeserializationConfig paramDeserializationConfig)
  {
    if (paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.READ_ENUMS_USING_TO_STRING)) {
      return EnumResolver.constructUnsafeUsingToString(paramClass);
    }
    return EnumResolver.constructUnsafe(paramClass, paramDeserializationConfig.getAnnotationIntrospector());
  }
  
  public JsonDeserializer createArrayDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, ArrayType paramArrayType, BeanProperty paramBeanProperty)
  {
    JavaType localJavaType = paramArrayType.getContentType();
    JsonDeserializer localJsonDeserializer1 = (JsonDeserializer)localJavaType.getValueHandler();
    Object localObject;
    if (localJsonDeserializer1 == null)
    {
      localObject = (JsonDeserializer)_arrayDeserializers.get(localJavaType);
      if (localObject != null)
      {
        paramDeserializationConfig = _findCustomArrayDeserializer(paramArrayType, paramDeserializationConfig, paramDeserializerProvider, paramBeanProperty, null, null);
        if (paramDeserializationConfig != null) {
          localObject = paramDeserializationConfig;
        }
        return (JsonDeserializer)localObject;
      }
      if (localJavaType.isPrimitive()) {
        throw new IllegalArgumentException("Internal error: primitive type (" + paramArrayType + ") passed, no array deserializer found");
      }
    }
    TypeDeserializer localTypeDeserializer = (TypeDeserializer)localJavaType.getTypeHandler();
    if (localTypeDeserializer == null) {
      localTypeDeserializer = findTypeDeserializer(paramDeserializationConfig, localJavaType, paramBeanProperty);
    }
    for (;;)
    {
      JsonDeserializer localJsonDeserializer2 = _findCustomArrayDeserializer(paramArrayType, paramDeserializationConfig, paramDeserializerProvider, paramBeanProperty, localTypeDeserializer, localJsonDeserializer1);
      localObject = localJsonDeserializer2;
      if (localJsonDeserializer2 != null) {
        break;
      }
      localObject = localJsonDeserializer1;
      if (localJsonDeserializer1 == null) {
        localObject = paramDeserializerProvider.findValueDeserializer(paramDeserializationConfig, localJavaType, paramBeanProperty);
      }
      return new ObjectArrayDeserializer(paramArrayType, (JsonDeserializer)localObject, localTypeDeserializer);
    }
  }
  
  public JsonDeserializer createCollectionDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, CollectionType paramCollectionType, BeanProperty paramBeanProperty)
  {
    paramCollectionType = (CollectionType)mapAbstractType(paramDeserializationConfig, paramCollectionType);
    Class localClass = paramCollectionType.getRawClass();
    BasicBeanDescription localBasicBeanDescription = (BasicBeanDescription)paramDeserializationConfig.introspectForCreation(paramCollectionType);
    Object localObject = findDeserializerFromAnnotation(paramDeserializationConfig, localBasicBeanDescription.getClassInfo(), paramBeanProperty);
    if (localObject != null) {
      return (JsonDeserializer)localObject;
    }
    CollectionType localCollectionType = (CollectionType)modifyTypeByAnnotation(paramDeserializationConfig, localBasicBeanDescription.getClassInfo(), paramCollectionType, null);
    JavaType localJavaType = localCollectionType.getContentType();
    JsonDeserializer localJsonDeserializer1 = (JsonDeserializer)localJavaType.getValueHandler();
    paramCollectionType = (TypeDeserializer)localJavaType.getTypeHandler();
    if (paramCollectionType == null) {
      paramCollectionType = findTypeDeserializer(paramDeserializationConfig, localJavaType, paramBeanProperty);
    }
    for (;;)
    {
      JsonDeserializer localJsonDeserializer2 = _findCustomCollectionDeserializer(localCollectionType, paramDeserializationConfig, paramDeserializerProvider, localBasicBeanDescription, paramBeanProperty, paramCollectionType, localJsonDeserializer1);
      localObject = localJsonDeserializer2;
      if (localJsonDeserializer2 != null) {
        break;
      }
      localObject = localJsonDeserializer1;
      if (localJsonDeserializer1 == null)
      {
        if (EnumSet.class.isAssignableFrom(localClass)) {
          return new EnumSetDeserializer(localJavaType.getRawClass(), createEnumDeserializer(paramDeserializationConfig, paramDeserializerProvider, localJavaType, paramBeanProperty));
        }
        localObject = paramDeserializerProvider.findValueDeserializer(paramDeserializationConfig, localJavaType, paramBeanProperty);
      }
      if (!localCollectionType.isInterface())
      {
        paramDeserializerProvider = localCollectionType;
        paramBeanProperty = localBasicBeanDescription;
        if (!localCollectionType.isAbstract()) {}
      }
      else
      {
        paramDeserializerProvider = (Class)_collectionFallbacks.get(localClass.getName());
        if (paramDeserializerProvider == null) {
          throw new IllegalArgumentException("Can not find a deserializer for non-concrete Collection type " + localCollectionType);
        }
        paramDeserializerProvider = (CollectionType)paramDeserializationConfig.constructSpecializedType(localCollectionType, paramDeserializerProvider);
        paramBeanProperty = (BasicBeanDescription)paramDeserializationConfig.introspectForCreation(paramDeserializerProvider);
      }
      paramDeserializationConfig = findValueInstantiator(paramDeserializationConfig, paramBeanProperty);
      if (localJavaType.getRawClass() == String.class) {
        return new StringCollectionDeserializer(paramDeserializerProvider, (JsonDeserializer)localObject, paramDeserializationConfig);
      }
      return new CollectionDeserializer(paramDeserializerProvider, (JsonDeserializer)localObject, paramCollectionType, paramDeserializationConfig);
    }
  }
  
  public JsonDeserializer createCollectionLikeDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, CollectionLikeType paramCollectionLikeType, BeanProperty paramBeanProperty)
  {
    paramCollectionLikeType = (CollectionLikeType)mapAbstractType(paramDeserializationConfig, paramCollectionLikeType);
    BasicBeanDescription localBasicBeanDescription = (BasicBeanDescription)paramDeserializationConfig.introspectClassAnnotations(paramCollectionLikeType.getRawClass());
    Object localObject = findDeserializerFromAnnotation(paramDeserializationConfig, localBasicBeanDescription.getClassInfo(), paramBeanProperty);
    if (localObject != null) {
      return (JsonDeserializer)localObject;
    }
    localObject = (CollectionLikeType)modifyTypeByAnnotation(paramDeserializationConfig, localBasicBeanDescription.getClassInfo(), paramCollectionLikeType, null);
    JavaType localJavaType = ((CollectionLikeType)localObject).getContentType();
    JsonDeserializer localJsonDeserializer = (JsonDeserializer)localJavaType.getValueHandler();
    paramCollectionLikeType = (TypeDeserializer)localJavaType.getTypeHandler();
    if (paramCollectionLikeType == null) {
      paramCollectionLikeType = findTypeDeserializer(paramDeserializationConfig, localJavaType, paramBeanProperty);
    }
    for (;;)
    {
      return _findCustomCollectionLikeDeserializer((CollectionLikeType)localObject, paramDeserializationConfig, paramDeserializerProvider, localBasicBeanDescription, paramBeanProperty, paramCollectionLikeType, localJsonDeserializer);
    }
  }
  
  public JsonDeserializer createEnumDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    paramDeserializerProvider = (BasicBeanDescription)paramDeserializationConfig.introspectForCreation(paramJavaType);
    JsonDeserializer localJsonDeserializer = findDeserializerFromAnnotation(paramDeserializationConfig, paramDeserializerProvider.getClassInfo(), paramBeanProperty);
    if (localJsonDeserializer != null) {
      return localJsonDeserializer;
    }
    paramJavaType = paramJavaType.getRawClass();
    paramBeanProperty = _findCustomEnumDeserializer(paramJavaType, paramDeserializationConfig, paramDeserializerProvider, paramBeanProperty);
    if (paramBeanProperty != null) {
      return paramBeanProperty;
    }
    paramDeserializerProvider = paramDeserializerProvider.getFactoryMethods().iterator();
    while (paramDeserializerProvider.hasNext())
    {
      paramBeanProperty = (AnnotatedMethod)paramDeserializerProvider.next();
      if (paramDeserializationConfig.getAnnotationIntrospector().hasCreatorAnnotation(paramBeanProperty))
      {
        if ((paramBeanProperty.getParameterCount() == 1) && (paramBeanProperty.getRawType().isAssignableFrom(paramJavaType))) {
          return EnumDeserializer.deserializerForCreator(paramDeserializationConfig, paramJavaType, paramBeanProperty);
        }
        throw new IllegalArgumentException("Unsuitable method (" + paramBeanProperty + ") decorated with @JsonCreator (for Enum type " + paramJavaType.getName() + ")");
      }
    }
    return new EnumDeserializer(constructEnumResolver(paramJavaType, paramDeserializationConfig));
  }
  
  public JsonDeserializer createMapDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, MapType paramMapType, BeanProperty paramBeanProperty)
  {
    paramMapType = (MapType)mapAbstractType(paramDeserializationConfig, paramMapType);
    BasicBeanDescription localBasicBeanDescription = (BasicBeanDescription)paramDeserializationConfig.introspectForCreation(paramMapType);
    Object localObject1 = findDeserializerFromAnnotation(paramDeserializationConfig, localBasicBeanDescription.getClassInfo(), paramBeanProperty);
    if (localObject1 != null) {
      return (JsonDeserializer)localObject1;
    }
    MapType localMapType = (MapType)modifyTypeByAnnotation(paramDeserializationConfig, localBasicBeanDescription.getClassInfo(), paramMapType, null);
    JavaType localJavaType1 = localMapType.getKeyType();
    JavaType localJavaType2 = localMapType.getContentType();
    Object localObject2 = (JsonDeserializer)localJavaType2.getValueHandler();
    paramMapType = (KeyDeserializer)localJavaType1.getValueHandler();
    if (paramMapType == null) {
      paramMapType = paramDeserializerProvider.findKeyDeserializer(paramDeserializationConfig, localJavaType1, paramBeanProperty);
    }
    for (;;)
    {
      TypeDeserializer localTypeDeserializer = (TypeDeserializer)localJavaType2.getTypeHandler();
      if (localTypeDeserializer == null) {
        localTypeDeserializer = findTypeDeserializer(paramDeserializationConfig, localJavaType2, paramBeanProperty);
      }
      for (;;)
      {
        JsonDeserializer localJsonDeserializer = _findCustomMapDeserializer(localMapType, paramDeserializationConfig, paramDeserializerProvider, localBasicBeanDescription, paramBeanProperty, paramMapType, localTypeDeserializer, (JsonDeserializer)localObject2);
        localObject1 = localJsonDeserializer;
        if (localJsonDeserializer != null) {
          break;
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = paramDeserializerProvider.findValueDeserializer(paramDeserializationConfig, localJavaType2, paramBeanProperty);
        }
        localObject2 = localMapType.getRawClass();
        if (EnumMap.class.isAssignableFrom((Class)localObject2))
        {
          paramMapType = localJavaType1.getRawClass();
          if ((paramMapType == null) || (!paramMapType.isEnum())) {
            throw new IllegalArgumentException("Can not construct EnumMap; generic (key) type not available");
          }
          return new EnumMapDeserializer(localJavaType1.getRawClass(), createEnumDeserializer(paramDeserializationConfig, paramDeserializerProvider, localJavaType1, paramBeanProperty), (JsonDeserializer)localObject1);
        }
        if ((localMapType.isInterface()) || (localMapType.isAbstract()))
        {
          paramDeserializerProvider = (Class)_mapFallbacks.get(((Class)localObject2).getName());
          if (paramDeserializerProvider == null) {
            throw new IllegalArgumentException("Can not find a deserializer for non-concrete Map type " + localMapType);
          }
          paramBeanProperty = (MapType)paramDeserializationConfig.constructSpecializedType(localMapType, paramDeserializerProvider);
          paramDeserializerProvider = (BasicBeanDescription)paramDeserializationConfig.introspectForCreation(paramBeanProperty);
        }
        for (;;)
        {
          paramMapType = new MapDeserializer(paramBeanProperty, findValueInstantiator(paramDeserializationConfig, paramDeserializerProvider), paramMapType, (JsonDeserializer)localObject1, localTypeDeserializer);
          paramMapType.setIgnorableProperties(paramDeserializationConfig.getAnnotationIntrospector().findPropertiesToIgnore(paramDeserializerProvider.getClassInfo()));
          return paramMapType;
          paramDeserializerProvider = localBasicBeanDescription;
          paramBeanProperty = localMapType;
        }
      }
    }
  }
  
  public JsonDeserializer createMapLikeDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, MapLikeType paramMapLikeType, BeanProperty paramBeanProperty)
  {
    paramMapLikeType = (MapLikeType)mapAbstractType(paramDeserializationConfig, paramMapLikeType);
    BasicBeanDescription localBasicBeanDescription = (BasicBeanDescription)paramDeserializationConfig.introspectForCreation(paramMapLikeType);
    Object localObject = findDeserializerFromAnnotation(paramDeserializationConfig, localBasicBeanDescription.getClassInfo(), paramBeanProperty);
    if (localObject != null) {
      return (JsonDeserializer)localObject;
    }
    MapLikeType localMapLikeType = (MapLikeType)modifyTypeByAnnotation(paramDeserializationConfig, localBasicBeanDescription.getClassInfo(), paramMapLikeType, null);
    localObject = localMapLikeType.getKeyType();
    JavaType localJavaType = localMapLikeType.getContentType();
    JsonDeserializer localJsonDeserializer = (JsonDeserializer)localJavaType.getValueHandler();
    paramMapLikeType = (KeyDeserializer)((JavaType)localObject).getValueHandler();
    if (paramMapLikeType == null) {
      paramMapLikeType = paramDeserializerProvider.findKeyDeserializer(paramDeserializationConfig, (JavaType)localObject, paramBeanProperty);
    }
    for (;;)
    {
      localObject = (TypeDeserializer)localJavaType.getTypeHandler();
      if (localObject == null) {
        localObject = findTypeDeserializer(paramDeserializationConfig, localJavaType, paramBeanProperty);
      }
      for (;;)
      {
        return _findCustomMapLikeDeserializer(localMapLikeType, paramDeserializationConfig, paramDeserializerProvider, localBasicBeanDescription, paramBeanProperty, paramMapLikeType, (TypeDeserializer)localObject, localJsonDeserializer);
      }
    }
  }
  
  public JsonDeserializer createTreeDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    paramDeserializerProvider = paramJavaType.getRawClass();
    paramDeserializationConfig = _findCustomTreeNodeDeserializer(paramDeserializerProvider, paramDeserializationConfig, paramBeanProperty);
    if (paramDeserializationConfig != null) {
      return paramDeserializationConfig;
    }
    return JsonNodeDeserializer.getDeserializer(paramDeserializerProvider);
  }
  
  protected JsonDeserializer findDeserializerFromAnnotation(DeserializationConfig paramDeserializationConfig, Annotated paramAnnotated, BeanProperty paramBeanProperty)
  {
    Object localObject = paramDeserializationConfig.getAnnotationIntrospector().findDeserializer(paramAnnotated);
    if (localObject != null) {
      return _constructDeserializer(paramDeserializationConfig, paramAnnotated, paramBeanProperty, localObject);
    }
    return null;
  }
  
  public TypeDeserializer findPropertyContentTypeDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, AnnotatedMember paramAnnotatedMember, BeanProperty paramBeanProperty)
  {
    AnnotationIntrospector localAnnotationIntrospector = paramDeserializationConfig.getAnnotationIntrospector();
    TypeResolverBuilder localTypeResolverBuilder = localAnnotationIntrospector.findPropertyContentTypeResolver(paramDeserializationConfig, paramAnnotatedMember, paramJavaType);
    paramJavaType = paramJavaType.getContentType();
    if (localTypeResolverBuilder == null) {
      return findTypeDeserializer(paramDeserializationConfig, paramJavaType, paramBeanProperty);
    }
    return localTypeResolverBuilder.buildTypeDeserializer(paramDeserializationConfig, paramJavaType, paramDeserializationConfig.getSubtypeResolver().collectAndResolveSubtypes(paramAnnotatedMember, paramDeserializationConfig, localAnnotationIntrospector), paramBeanProperty);
  }
  
  public TypeDeserializer findPropertyTypeDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, AnnotatedMember paramAnnotatedMember, BeanProperty paramBeanProperty)
  {
    AnnotationIntrospector localAnnotationIntrospector = paramDeserializationConfig.getAnnotationIntrospector();
    TypeResolverBuilder localTypeResolverBuilder = localAnnotationIntrospector.findPropertyTypeResolver(paramDeserializationConfig, paramAnnotatedMember, paramJavaType);
    if (localTypeResolverBuilder == null) {
      return findTypeDeserializer(paramDeserializationConfig, paramJavaType, paramBeanProperty);
    }
    return localTypeResolverBuilder.buildTypeDeserializer(paramDeserializationConfig, paramJavaType, paramDeserializationConfig.getSubtypeResolver().collectAndResolveSubtypes(paramAnnotatedMember, paramDeserializationConfig, localAnnotationIntrospector), paramBeanProperty);
  }
  
  protected JsonDeserializer findStdBeanDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    Class localClass = paramJavaType.getRawClass();
    JsonDeserializer localJsonDeserializer = (JsonDeserializer)_simpleDeserializers.get(new ClassKey(localClass));
    if (localJsonDeserializer != null) {
      paramDeserializationConfig = localJsonDeserializer;
    }
    do
    {
      return paramDeserializationConfig;
      if (AtomicReference.class.isAssignableFrom(localClass))
      {
        paramDeserializationConfig = paramDeserializationConfig.getTypeFactory().findTypeParameters(paramJavaType, AtomicReference.class);
        if ((paramDeserializationConfig == null) || (paramDeserializationConfig.length < 1)) {}
        for (paramDeserializationConfig = TypeFactory.unknownType();; paramDeserializationConfig = paramDeserializationConfig[0]) {
          return new AtomicReferenceDeserializer(paramDeserializationConfig, paramBeanProperty);
        }
      }
      paramDeserializerProvider = this.optionalHandlers.findDeserializer(paramJavaType, paramDeserializationConfig, paramDeserializerProvider);
      paramDeserializationConfig = paramDeserializerProvider;
    } while (paramDeserializerProvider != null);
    return null;
  }
  
  public TypeDeserializer findTypeDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    Object localObject1 = ((BasicBeanDescription)paramDeserializationConfig.introspectClassAnnotations(paramJavaType.getRawClass())).getClassInfo();
    Object localObject2 = paramDeserializationConfig.getAnnotationIntrospector();
    TypeResolverBuilder localTypeResolverBuilder = ((AnnotationIntrospector)localObject2).findTypeResolver(paramDeserializationConfig, (AnnotatedClass)localObject1, paramJavaType);
    if (localTypeResolverBuilder == null)
    {
      localTypeResolverBuilder = paramDeserializationConfig.getDefaultTyper(paramJavaType);
      if (localTypeResolverBuilder != null) {
        break label151;
      }
      return null;
    }
    label151:
    for (localObject1 = paramDeserializationConfig.getSubtypeResolver().collectAndResolveSubtypes((AnnotatedClass)localObject1, paramDeserializationConfig, (AnnotationIntrospector)localObject2);; localObject1 = null)
    {
      localObject2 = localTypeResolverBuilder;
      if (localTypeResolverBuilder.getDefaultImpl() == null)
      {
        localObject2 = localTypeResolverBuilder;
        if (paramJavaType.isAbstract())
        {
          JavaType localJavaType = mapAbstractType(paramDeserializationConfig, paramJavaType);
          localObject2 = localTypeResolverBuilder;
          if (localJavaType != null)
          {
            localObject2 = localTypeResolverBuilder;
            if (localJavaType.getRawClass() != paramJavaType.getRawClass()) {
              localObject2 = localTypeResolverBuilder.defaultImpl(localJavaType.getRawClass());
            }
          }
        }
      }
      return ((TypeResolverBuilder)localObject2).buildTypeDeserializer(paramDeserializationConfig, paramJavaType, (Collection)localObject1, paramBeanProperty);
    }
  }
  
  public abstract ValueInstantiator findValueInstantiator(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription);
  
  public abstract JavaType mapAbstractType(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType);
  
  /* Error */
  protected JavaType modifyTypeByAnnotation(DeserializationConfig paramDeserializationConfig, Annotated paramAnnotated, JavaType paramJavaType, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 193	org/codehaus/jackson/map/DeserializationConfig:getAnnotationIntrospector	()Lorg/codehaus/jackson/map/AnnotationIntrospector;
    //   4: astore 6
    //   6: aload 6
    //   8: aload_2
    //   9: aload_3
    //   10: aload 4
    //   12: invokevirtual 533	org/codehaus/jackson/map/AnnotationIntrospector:findDeserializationType	(Lorg/codehaus/jackson/map/introspect/Annotated;Lorg/codehaus/jackson/type/JavaType;Ljava/lang/String;)Ljava/lang/Class;
    //   15: astore 7
    //   17: aload 7
    //   19: ifnull +428 -> 447
    //   22: aload_3
    //   23: aload 7
    //   25: invokevirtual 537	org/codehaus/jackson/type/JavaType:narrowBy	(Ljava/lang/Class;)Lorg/codehaus/jackson/type/JavaType;
    //   28: astore 5
    //   30: aload 5
    //   32: astore_3
    //   33: aload_3
    //   34: astore 5
    //   36: aload_3
    //   37: invokevirtual 540	org/codehaus/jackson/type/JavaType:isContainerType	()Z
    //   40: ifeq +287 -> 327
    //   43: aload 6
    //   45: aload_2
    //   46: aload_3
    //   47: invokevirtual 541	org/codehaus/jackson/type/JavaType:getKeyType	()Lorg/codehaus/jackson/type/JavaType;
    //   50: aload 4
    //   52: invokevirtual 544	org/codehaus/jackson/map/AnnotationIntrospector:findDeserializationKeyType	(Lorg/codehaus/jackson/map/introspect/Annotated;Lorg/codehaus/jackson/type/JavaType;Ljava/lang/String;)Ljava/lang/Class;
    //   55: astore 7
    //   57: aload_3
    //   58: astore 5
    //   60: aload 7
    //   62: ifnull +126 -> 188
    //   65: aload_3
    //   66: instanceof 435
    //   69: ifne +108 -> 177
    //   72: new 546	org/codehaus/jackson/map/JsonMappingException
    //   75: dup
    //   76: new 122	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   83: ldc_w 548
    //   86: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_3
    //   90: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   93: ldc_w 550
    //   96: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokespecial 551	org/codehaus/jackson/map/JsonMappingException:<init>	(Ljava/lang/String;)V
    //   105: athrow
    //   106: astore_1
    //   107: new 546	org/codehaus/jackson/map/JsonMappingException
    //   110: dup
    //   111: new 122	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   118: ldc_w 553
    //   121: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_3
    //   125: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   128: ldc_w 555
    //   131: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload 7
    //   136: invokevirtual 44	java/lang/Class:getName	()Ljava/lang/String;
    //   139: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 557
    //   145: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_2
    //   149: invokevirtual 560	org/codehaus/jackson/map/introspect/Annotated:getName	()Ljava/lang/String;
    //   152: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc_w 562
    //   158: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_1
    //   162: invokevirtual 565	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   165: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: aconst_null
    //   172: aload_1
    //   173: invokespecial 568	org/codehaus/jackson/map/JsonMappingException:<init>	(Ljava/lang/String;Lorg/codehaus/jackson/JsonLocation;Ljava/lang/Throwable;)V
    //   176: athrow
    //   177: aload_3
    //   178: checkcast 435	org/codehaus/jackson/map/type/MapLikeType
    //   181: aload 7
    //   183: invokevirtual 571	org/codehaus/jackson/map/type/MapLikeType:narrowKey	(Ljava/lang/Class;)Lorg/codehaus/jackson/type/JavaType;
    //   186: astore 5
    //   188: aload 5
    //   190: invokevirtual 541	org/codehaus/jackson/type/JavaType:getKeyType	()Lorg/codehaus/jackson/type/JavaType;
    //   193: astore_3
    //   194: aload_3
    //   195: ifnull +42 -> 237
    //   198: aload_3
    //   199: invokevirtual 211	org/codehaus/jackson/type/JavaType:getValueHandler	()Ljava/lang/Object;
    //   202: ifnonnull +35 -> 237
    //   205: aload 6
    //   207: aload_2
    //   208: invokevirtual 574	org/codehaus/jackson/map/AnnotationIntrospector:findKeyDeserializer	(Lorg/codehaus/jackson/map/introspect/Annotated;)Ljava/lang/Class;
    //   211: astore 7
    //   213: aload 7
    //   215: ifnull +22 -> 237
    //   218: aload 7
    //   220: ldc_w 576
    //   223: if_acmpeq +14 -> 237
    //   226: aload_3
    //   227: aload_1
    //   228: aload_2
    //   229: aload 7
    //   231: invokevirtual 580	org/codehaus/jackson/map/DeserializationConfig:keyDeserializerInstance	(Lorg/codehaus/jackson/map/introspect/Annotated;Ljava/lang/Class;)Lorg/codehaus/jackson/map/KeyDeserializer;
    //   234: invokevirtual 584	org/codehaus/jackson/type/JavaType:setValueHandler	(Ljava/lang/Object;)V
    //   237: aload 6
    //   239: aload_2
    //   240: aload 5
    //   242: invokevirtual 461	org/codehaus/jackson/type/JavaType:getContentType	()Lorg/codehaus/jackson/type/JavaType;
    //   245: aload 4
    //   247: invokevirtual 587	org/codehaus/jackson/map/AnnotationIntrospector:findDeserializationContentType	(Lorg/codehaus/jackson/map/introspect/Annotated;Lorg/codehaus/jackson/type/JavaType;Ljava/lang/String;)Ljava/lang/Class;
    //   250: astore 4
    //   252: aload 5
    //   254: astore_3
    //   255: aload 4
    //   257: ifnull +11 -> 268
    //   260: aload 5
    //   262: aload 4
    //   264: invokevirtual 590	org/codehaus/jackson/type/JavaType:narrowContentsBy	(Ljava/lang/Class;)Lorg/codehaus/jackson/type/JavaType;
    //   267: astore_3
    //   268: aload_3
    //   269: astore 5
    //   271: aload_3
    //   272: invokevirtual 461	org/codehaus/jackson/type/JavaType:getContentType	()Lorg/codehaus/jackson/type/JavaType;
    //   275: invokevirtual 211	org/codehaus/jackson/type/JavaType:getValueHandler	()Ljava/lang/Object;
    //   278: ifnonnull +49 -> 327
    //   281: aload 6
    //   283: aload_2
    //   284: invokevirtual 593	org/codehaus/jackson/map/AnnotationIntrospector:findContentDeserializer	(Lorg/codehaus/jackson/map/introspect/Annotated;)Ljava/lang/Class;
    //   287: astore 4
    //   289: aload_3
    //   290: astore 5
    //   292: aload 4
    //   294: ifnull +33 -> 327
    //   297: aload_3
    //   298: astore 5
    //   300: aload 4
    //   302: ldc_w 595
    //   305: if_acmpeq +22 -> 327
    //   308: aload_1
    //   309: aload_2
    //   310: aload 4
    //   312: invokevirtual 157	org/codehaus/jackson/map/DeserializationConfig:deserializerInstance	(Lorg/codehaus/jackson/map/introspect/Annotated;Ljava/lang/Class;)Lorg/codehaus/jackson/map/JsonDeserializer;
    //   315: astore_1
    //   316: aload_3
    //   317: invokevirtual 461	org/codehaus/jackson/type/JavaType:getContentType	()Lorg/codehaus/jackson/type/JavaType;
    //   320: aload_1
    //   321: invokevirtual 584	org/codehaus/jackson/type/JavaType:setValueHandler	(Ljava/lang/Object;)V
    //   324: aload_3
    //   325: astore 5
    //   327: aload 5
    //   329: areturn
    //   330: astore_1
    //   331: new 546	org/codehaus/jackson/map/JsonMappingException
    //   334: dup
    //   335: new 122	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   342: ldc_w 597
    //   345: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload_3
    //   349: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   352: ldc_w 599
    //   355: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload 7
    //   360: invokevirtual 44	java/lang/Class:getName	()Ljava/lang/String;
    //   363: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: ldc_w 601
    //   369: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_1
    //   373: invokevirtual 565	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   376: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: aconst_null
    //   383: aload_1
    //   384: invokespecial 568	org/codehaus/jackson/map/JsonMappingException:<init>	(Ljava/lang/String;Lorg/codehaus/jackson/JsonLocation;Ljava/lang/Throwable;)V
    //   387: athrow
    //   388: astore_1
    //   389: new 546	org/codehaus/jackson/map/JsonMappingException
    //   392: dup
    //   393: new 122	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   400: ldc_w 603
    //   403: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload 5
    //   408: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   411: ldc_w 605
    //   414: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload 4
    //   419: invokevirtual 44	java/lang/Class:getName	()Ljava/lang/String;
    //   422: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc_w 601
    //   428: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: aload_1
    //   432: invokevirtual 565	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   435: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: aconst_null
    //   442: aload_1
    //   443: invokespecial 568	org/codehaus/jackson/map/JsonMappingException:<init>	(Ljava/lang/String;Lorg/codehaus/jackson/JsonLocation;Ljava/lang/Throwable;)V
    //   446: athrow
    //   447: goto -414 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	450	0	this	BasicDeserializerFactory
    //   0	450	1	paramDeserializationConfig	DeserializationConfig
    //   0	450	2	paramAnnotated	Annotated
    //   0	450	3	paramJavaType	JavaType
    //   0	450	4	paramString	String
    //   28	379	5	localJavaType	JavaType
    //   4	278	6	localAnnotationIntrospector	AnnotationIntrospector
    //   15	344	7	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   22	30	106	java/lang/IllegalArgumentException
    //   177	188	330	java/lang/IllegalArgumentException
    //   260	268	388	java/lang/IllegalArgumentException
  }
  
  protected JavaType resolveType(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, JavaType paramJavaType, AnnotatedMember paramAnnotatedMember, BeanProperty paramBeanProperty)
  {
    paramBasicBeanDescription = paramJavaType;
    if (paramJavaType.isContainerType())
    {
      paramBasicBeanDescription = paramDeserializationConfig.getAnnotationIntrospector();
      Object localObject = paramJavaType.getKeyType();
      if (localObject != null)
      {
        Class localClass = paramBasicBeanDescription.findKeyDeserializer(paramAnnotatedMember);
        if ((localClass != null) && (localClass != KeyDeserializer.None.class)) {
          ((JavaType)localObject).setValueHandler(paramDeserializationConfig.keyDeserializerInstance(paramAnnotatedMember, localClass));
        }
      }
      paramBasicBeanDescription = paramBasicBeanDescription.findContentDeserializer(paramAnnotatedMember);
      if ((paramBasicBeanDescription != null) && (paramBasicBeanDescription != JsonDeserializer.None.class))
      {
        paramBasicBeanDescription = paramDeserializationConfig.deserializerInstance(paramAnnotatedMember, paramBasicBeanDescription);
        paramJavaType.getContentType().setValueHandler(paramBasicBeanDescription);
      }
      paramBasicBeanDescription = paramJavaType;
      if ((paramAnnotatedMember instanceof AnnotatedMember))
      {
        localObject = findPropertyContentTypeDeserializer(paramDeserializationConfig, paramJavaType, paramAnnotatedMember, paramBeanProperty);
        paramBasicBeanDescription = paramJavaType;
        if (localObject != null) {
          paramBasicBeanDescription = paramJavaType.withContentTypeHandler(localObject);
        }
      }
    }
    if ((paramAnnotatedMember instanceof AnnotatedMember)) {}
    for (paramDeserializationConfig = findPropertyTypeDeserializer(paramDeserializationConfig, paramBasicBeanDescription, paramAnnotatedMember, paramBeanProperty);; paramDeserializationConfig = findTypeDeserializer(paramDeserializationConfig, paramBasicBeanDescription, null))
    {
      paramJavaType = paramBasicBeanDescription;
      if (paramDeserializationConfig != null) {
        paramJavaType = paramBasicBeanDescription.withTypeHandler(paramDeserializationConfig);
      }
      return paramJavaType;
    }
  }
  
  public abstract DeserializerFactory withConfig(DeserializerFactory.Config paramConfig);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/BasicDeserializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */