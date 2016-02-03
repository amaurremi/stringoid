package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty.Std;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.deser.impl.CreatorCollector;
import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.deser.std.EnumDeserializer;
import com.fasterxml.jackson.databind.deser.std.EnumMapDeserializer;
import com.fasterxml.jackson.databind.deser.std.EnumSetDeserializer;
import com.fasterxml.jackson.databind.deser.std.JacksonDeserializers;
import com.fasterxml.jackson.databind.deser.std.JdkDeserializers;
import com.fasterxml.jackson.databind.deser.std.JsonNodeDeserializer;
import com.fasterxml.jackson.databind.deser.std.MapDeserializer;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import com.fasterxml.jackson.databind.deser.std.ObjectArrayDeserializer;
import com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.databind.deser.std.StringCollectionDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;
import com.fasterxml.jackson.databind.ext.OptionalHandlerFactory;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;
import java.io.Serializable;
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

public abstract class BasicDeserializerFactory
  extends DeserializerFactory
  implements Serializable
{
  protected static final HashMap<JavaType, JsonDeserializer<Object>> _arrayDeserializers;
  static final HashMap<String, Class<? extends Collection>> _collectionFallbacks;
  protected static final HashMap<JavaType, KeyDeserializer> _keyDeserializers;
  static final HashMap<String, Class<? extends Map>> _mapFallbacks;
  protected static final HashMap<ClassKey, JsonDeserializer<Object>> _simpleDeserializers = new HashMap();
  protected final DeserializerFactoryConfig _factoryConfig;
  protected OptionalHandlerFactory optionalHandlers = OptionalHandlerFactory.instance;
  
  static
  {
    _arrayDeserializers = PrimitiveArrayDeserializers.getAll();
    _keyDeserializers = StdKeyDeserializers.constructAll();
    _add(_simpleDeserializers, Object.class, new UntypedObjectDeserializer());
    Object localObject = new StringDeserializer();
    _add(_simpleDeserializers, String.class, (StdDeserializer)localObject);
    _add(_simpleDeserializers, CharSequence.class, (StdDeserializer)localObject);
    _add(_simpleDeserializers, NumberDeserializers.all());
    _add(_simpleDeserializers, DateDeserializers.all());
    _add(_simpleDeserializers, JdkDeserializers.all());
    _add(_simpleDeserializers, JacksonDeserializers.all());
    _mapFallbacks = new HashMap();
    _mapFallbacks.put(Map.class.getName(), LinkedHashMap.class);
    _mapFallbacks.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
    _mapFallbacks.put(SortedMap.class.getName(), TreeMap.class);
    _mapFallbacks.put("java.util.NavigableMap", TreeMap.class);
    try
    {
      localObject = Class.forName("java.util.concurrent.ConcurrentNavigableMap");
      Class localClass = Class.forName("java.util.concurrent.ConcurrentSkipListMap");
      _mapFallbacks.put(((Class)localObject).getName(), localClass);
      _collectionFallbacks = new HashMap();
      _collectionFallbacks.put(Collection.class.getName(), ArrayList.class);
      _collectionFallbacks.put(List.class.getName(), ArrayList.class);
      _collectionFallbacks.put(Set.class.getName(), HashSet.class);
      _collectionFallbacks.put(SortedSet.class.getName(), TreeSet.class);
      _collectionFallbacks.put(Queue.class.getName(), LinkedList.class);
      _collectionFallbacks.put("java.util.Deque", LinkedList.class);
      _collectionFallbacks.put("java.util.NavigableSet", TreeSet.class);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;) {}
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
  }
  
  protected BasicDeserializerFactory(DeserializerFactoryConfig paramDeserializerFactoryConfig)
  {
    this._factoryConfig = paramDeserializerFactoryConfig;
  }
  
  private static void _add(Map<ClassKey, JsonDeserializer<Object>> paramMap, Class<?> paramClass, StdDeserializer<?> paramStdDeserializer)
  {
    paramMap.put(new ClassKey(paramClass), paramStdDeserializer);
  }
  
  private static void _add(Map<ClassKey, JsonDeserializer<Object>> paramMap, StdDeserializer<?>[] paramArrayOfStdDeserializer)
  {
    int j = paramArrayOfStdDeserializer.length;
    int i = 0;
    while (i < j)
    {
      StdDeserializer<?> localStdDeserializer = paramArrayOfStdDeserializer[i];
      _add(paramMap, localStdDeserializer.getValueClass(), localStdDeserializer);
      i += 1;
    }
  }
  
  private KeyDeserializer _createEnumKeyDeserializer(DeserializationContext paramDeserializationContext, JavaType paramJavaType)
  {
    DeserializationConfig localDeserializationConfig = paramDeserializationContext.getConfig();
    Object localObject1 = localDeserializationConfig.introspect(paramJavaType);
    Object localObject2 = findDeserializerFromAnnotation(paramDeserializationContext, ((BeanDescription)localObject1).getClassInfo());
    if (localObject2 != null) {
      return StdKeyDeserializers.constructDelegatingKeyDeserializer(localDeserializationConfig, paramJavaType, (JsonDeserializer)localObject2);
    }
    paramDeserializationContext = paramJavaType.getRawClass();
    if (_findCustomEnumDeserializer(paramDeserializationContext, localDeserializationConfig, (BeanDescription)localObject1) != null) {
      return StdKeyDeserializers.constructDelegatingKeyDeserializer(localDeserializationConfig, paramJavaType, (JsonDeserializer)localObject2);
    }
    paramJavaType = constructEnumResolver(paramDeserializationContext, localDeserializationConfig, ((BeanDescription)localObject1).findJsonValueMethod());
    localObject1 = ((BeanDescription)localObject1).getFactoryMethods().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AnnotatedMethod)((Iterator)localObject1).next();
      if (localDeserializationConfig.getAnnotationIntrospector().hasCreatorAnnotation((Annotated)localObject2))
      {
        if ((((AnnotatedMethod)localObject2).getParameterCount() == 1) && (((AnnotatedMethod)localObject2).getRawReturnType().isAssignableFrom(paramDeserializationContext)))
        {
          if (((AnnotatedMethod)localObject2).getGenericParameterType(0) != String.class) {
            throw new IllegalArgumentException("Parameter #0 type for factory method (" + localObject2 + ") not suitable, must be java.lang.String");
          }
          if (localDeserializationConfig.canOverrideAccessModifiers()) {
            ClassUtil.checkAndFixAccess(((AnnotatedMethod)localObject2).getMember());
          }
          return StdKeyDeserializers.constructEnumKeyDeserializer(paramJavaType, (AnnotatedMethod)localObject2);
        }
        throw new IllegalArgumentException("Unsuitable method (" + localObject2 + ") decorated with @JsonCreator (for Enum type " + paramDeserializationContext.getName() + ")");
      }
    }
    return StdKeyDeserializers.constructEnumKeyDeserializer(paramJavaType);
  }
  
  private ValueInstantiator _findStdValueInstantiator(DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription)
  {
    return JacksonDeserializers.findValueInstantiator(paramDeserializationConfig, paramBeanDescription);
  }
  
  private JavaType _mapAbstractType2(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
  {
    Class localClass = paramJavaType.getRawClass();
    if (this._factoryConfig.hasAbstractTypeResolvers())
    {
      Iterator localIterator = this._factoryConfig.abstractTypeResolvers().iterator();
      while (localIterator.hasNext())
      {
        JavaType localJavaType = ((AbstractTypeResolver)localIterator.next()).findTypeMapping(paramDeserializationConfig, paramJavaType);
        if ((localJavaType != null) && (localJavaType.getRawClass() != localClass)) {
          return localJavaType;
        }
      }
    }
    return null;
  }
  
  protected void _addDeserializerConstructors(DeserializationContext paramDeserializationContext, BeanDescription paramBeanDescription, VisibilityChecker<?> paramVisibilityChecker, AnnotationIntrospector paramAnnotationIntrospector, CreatorCollector paramCreatorCollector)
  {
    Object localObject1 = paramBeanDescription.findDefaultConstructor();
    if ((localObject1 != null) && ((!paramCreatorCollector.hasDefaultCreator()) || (paramAnnotationIntrospector.hasCreatorAnnotation((Annotated)localObject1)))) {
      paramCreatorCollector.setDefaultCreator((AnnotatedWithParams)localObject1);
    }
    Iterator localIterator = paramBeanDescription.getConstructors().iterator();
    while (localIterator.hasNext())
    {
      AnnotatedConstructor localAnnotatedConstructor = (AnnotatedConstructor)localIterator.next();
      int i1 = localAnnotatedConstructor.getParameterCount();
      boolean bool1 = paramAnnotationIntrospector.hasCreatorAnnotation(localAnnotatedConstructor);
      boolean bool2 = paramVisibilityChecker.isCreatorVisible(localAnnotatedConstructor);
      if (i1 == 1)
      {
        _handleSingleArgumentConstructor(paramDeserializationContext, paramBeanDescription, paramVisibilityChecker, paramAnnotationIntrospector, paramCreatorCollector, localAnnotatedConstructor, bool1, bool2);
      }
      else if ((bool1) || (bool2))
      {
        localObject1 = null;
        int j = 0;
        int k = 0;
        CreatorProperty[] arrayOfCreatorProperty = new CreatorProperty[i1];
        int i = 0;
        if (i < i1)
        {
          AnnotatedParameter localAnnotatedParameter = localAnnotatedConstructor.getParameter(i);
          Object localObject2;
          label175:
          label183:
          Object localObject3;
          int n;
          int m;
          if (localAnnotatedParameter == null)
          {
            localObject2 = null;
            if (localObject2 != null) {
              break label271;
            }
            localObject2 = null;
            localObject3 = paramAnnotationIntrospector.findInjectableValueId(localAnnotatedParameter);
            if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
              break label281;
            }
            n = j + 1;
            arrayOfCreatorProperty[i] = constructCreatorProperty(paramDeserializationContext, paramBeanDescription, (String)localObject2, i, localAnnotatedParameter, localObject3);
            localObject2 = localObject1;
            m = k;
          }
          for (;;)
          {
            i += 1;
            localObject1 = localObject2;
            k = m;
            j = n;
            break;
            localObject2 = paramAnnotationIntrospector.findNameForDeserialization(localAnnotatedParameter);
            break label175;
            label271:
            localObject2 = ((PropertyName)localObject2).getSimpleName();
            break label183;
            label281:
            if (localObject3 != null)
            {
              m = k + 1;
              arrayOfCreatorProperty[i] = constructCreatorProperty(paramDeserializationContext, paramBeanDescription, (String)localObject2, i, localAnnotatedParameter, localObject3);
              n = j;
              localObject2 = localObject1;
            }
            else
            {
              m = k;
              n = j;
              localObject2 = localAnnotatedParameter;
              if (localObject1 != null)
              {
                m = k;
                n = j;
                localObject2 = localObject1;
              }
            }
          }
        }
        if ((bool1) || (j > 0) || (k > 0)) {
          if (j + k == i1) {
            paramCreatorCollector.addPropertyCreator(localAnnotatedConstructor, arrayOfCreatorProperty);
          } else if ((j == 0) && (k + 1 == i1)) {
            paramCreatorCollector.addDelegatingCreator(localAnnotatedConstructor, arrayOfCreatorProperty);
          } else {
            throw new IllegalArgumentException("Argument #" + ((AnnotatedParameter)localObject1).getIndex() + " of constructor " + localAnnotatedConstructor + " has no property name annotation; must have name when multiple-paramater constructor annotated as Creator");
          }
        }
      }
    }
  }
  
  protected void _addDeserializerFactoryMethods(DeserializationContext paramDeserializationContext, BeanDescription paramBeanDescription, VisibilityChecker<?> paramVisibilityChecker, AnnotationIntrospector paramAnnotationIntrospector, CreatorCollector paramCreatorCollector)
  {
    DeserializationConfig localDeserializationConfig = paramDeserializationContext.getConfig();
    Iterator localIterator = paramBeanDescription.getFactoryMethods().iterator();
    while (localIterator.hasNext())
    {
      AnnotatedMethod localAnnotatedMethod = (AnnotatedMethod)localIterator.next();
      boolean bool = paramAnnotationIntrospector.hasCreatorAnnotation(localAnnotatedMethod);
      int i1 = localAnnotatedMethod.getParameterCount();
      if (i1 == 0)
      {
        if (bool) {
          paramCreatorCollector.setDefaultCreator(localAnnotatedMethod);
        }
      }
      else
      {
        Object localObject2;
        Object localObject1;
        if (i1 == 1)
        {
          localObject2 = localAnnotatedMethod.getParameter(0);
          if (localObject2 == null)
          {
            localObject1 = null;
            label97:
            if (localObject1 != null) {
              break label160;
            }
          }
          label160:
          for (localObject1 = null;; localObject1 = ((PropertyName)localObject1).getSimpleName())
          {
            if ((paramAnnotationIntrospector.findInjectableValueId((AnnotatedMember)localObject2) != null) || ((localObject1 != null) && (((String)localObject1).length() != 0))) {
              break label180;
            }
            _handleSingleArgumentFactory(localDeserializationConfig, paramBeanDescription, paramVisibilityChecker, paramAnnotationIntrospector, paramCreatorCollector, localAnnotatedMethod, bool);
            break;
            localObject1 = paramAnnotationIntrospector.findNameForDeserialization((Annotated)localObject2);
            break label97;
          }
        }
        if (paramAnnotationIntrospector.hasCreatorAnnotation(localAnnotatedMethod))
        {
          label180:
          localObject1 = null;
          CreatorProperty[] arrayOfCreatorProperty = new CreatorProperty[i1];
          int j = 0;
          int k = 0;
          int i = 0;
          if (i < i1)
          {
            AnnotatedParameter localAnnotatedParameter = localAnnotatedMethod.getParameter(i);
            label223:
            label231:
            Object localObject3;
            int n;
            int m;
            if (localAnnotatedParameter == null)
            {
              localObject2 = null;
              if (localObject2 != null) {
                break label319;
              }
              localObject2 = null;
              localObject3 = paramAnnotationIntrospector.findInjectableValueId(localAnnotatedParameter);
              if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
                break label329;
              }
              n = j + 1;
              arrayOfCreatorProperty[i] = constructCreatorProperty(paramDeserializationContext, paramBeanDescription, (String)localObject2, i, localAnnotatedParameter, localObject3);
              localObject2 = localObject1;
              m = k;
            }
            for (;;)
            {
              i += 1;
              localObject1 = localObject2;
              k = m;
              j = n;
              break;
              localObject2 = paramAnnotationIntrospector.findNameForDeserialization(localAnnotatedParameter);
              break label223;
              label319:
              localObject2 = ((PropertyName)localObject2).getSimpleName();
              break label231;
              label329:
              if (localObject3 != null)
              {
                m = k + 1;
                arrayOfCreatorProperty[i] = constructCreatorProperty(paramDeserializationContext, paramBeanDescription, (String)localObject2, i, localAnnotatedParameter, localObject3);
                n = j;
                localObject2 = localObject1;
              }
              else
              {
                m = k;
                n = j;
                localObject2 = localAnnotatedParameter;
                if (localObject1 != null)
                {
                  m = k;
                  n = j;
                  localObject2 = localObject1;
                }
              }
            }
          }
          if ((bool) || (j > 0) || (k > 0)) {
            if (j + k == i1) {
              paramCreatorCollector.addPropertyCreator(localAnnotatedMethod, arrayOfCreatorProperty);
            } else if ((j == 0) && (k + 1 == i1)) {
              paramCreatorCollector.addDelegatingCreator(localAnnotatedMethod, arrayOfCreatorProperty);
            } else {
              throw new IllegalArgumentException("Argument #" + ((AnnotatedParameter)localObject1).getIndex() + " of factory method " + localAnnotatedMethod + " has no property name annotation; must have name when multiple-paramater constructor annotated as Creator");
            }
          }
        }
      }
    }
  }
  
  protected ValueInstantiator _constructDefaultValueInstantiator(DeserializationContext paramDeserializationContext, BeanDescription paramBeanDescription)
  {
    CreatorCollector localCreatorCollector = new CreatorCollector(paramBeanDescription, paramDeserializationContext.canOverrideAccessModifiers());
    AnnotationIntrospector localAnnotationIntrospector = paramDeserializationContext.getAnnotationIntrospector();
    DeserializationConfig localDeserializationConfig = paramDeserializationContext.getConfig();
    VisibilityChecker localVisibilityChecker = localDeserializationConfig.getDefaultVisibilityChecker();
    localVisibilityChecker = localAnnotationIntrospector.findAutoDetectVisibility(paramBeanDescription.getClassInfo(), localVisibilityChecker);
    _addDeserializerFactoryMethods(paramDeserializationContext, paramBeanDescription, localVisibilityChecker, localAnnotationIntrospector, localCreatorCollector);
    if (paramBeanDescription.getType().isConcrete()) {
      _addDeserializerConstructors(paramDeserializationContext, paramBeanDescription, localVisibilityChecker, localAnnotationIntrospector, localCreatorCollector);
    }
    return localCreatorCollector.constructValueInstantiator(localDeserializationConfig);
  }
  
  protected JsonDeserializer<?> _findCustomArrayDeserializer(ArrayType paramArrayType, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    while (localIterator.hasNext())
    {
      JsonDeserializer localJsonDeserializer = ((Deserializers)localIterator.next()).findArrayDeserializer(paramArrayType, paramDeserializationConfig, paramBeanDescription, paramTypeDeserializer, paramJsonDeserializer);
      if (localJsonDeserializer != null) {
        return localJsonDeserializer;
      }
    }
    return null;
  }
  
  protected JsonDeserializer<?> _findCustomCollectionDeserializer(CollectionType paramCollectionType, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    while (localIterator.hasNext())
    {
      JsonDeserializer localJsonDeserializer = ((Deserializers)localIterator.next()).findCollectionDeserializer(paramCollectionType, paramDeserializationConfig, paramBeanDescription, paramTypeDeserializer, paramJsonDeserializer);
      if (localJsonDeserializer != null) {
        return localJsonDeserializer;
      }
    }
    return null;
  }
  
  protected JsonDeserializer<?> _findCustomCollectionLikeDeserializer(CollectionLikeType paramCollectionLikeType, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    while (localIterator.hasNext())
    {
      JsonDeserializer localJsonDeserializer = ((Deserializers)localIterator.next()).findCollectionLikeDeserializer(paramCollectionLikeType, paramDeserializationConfig, paramBeanDescription, paramTypeDeserializer, paramJsonDeserializer);
      if (localJsonDeserializer != null) {
        return localJsonDeserializer;
      }
    }
    return null;
  }
  
  protected JsonDeserializer<?> _findCustomEnumDeserializer(Class<?> paramClass, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription)
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    while (localIterator.hasNext())
    {
      JsonDeserializer localJsonDeserializer = ((Deserializers)localIterator.next()).findEnumDeserializer(paramClass, paramDeserializationConfig, paramBeanDescription);
      if (localJsonDeserializer != null) {
        return localJsonDeserializer;
      }
    }
    return null;
  }
  
  protected JsonDeserializer<?> _findCustomMapDeserializer(MapType paramMapType, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription, KeyDeserializer paramKeyDeserializer, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    while (localIterator.hasNext())
    {
      JsonDeserializer localJsonDeserializer = ((Deserializers)localIterator.next()).findMapDeserializer(paramMapType, paramDeserializationConfig, paramBeanDescription, paramKeyDeserializer, paramTypeDeserializer, paramJsonDeserializer);
      if (localJsonDeserializer != null) {
        return localJsonDeserializer;
      }
    }
    return null;
  }
  
  protected JsonDeserializer<?> _findCustomMapLikeDeserializer(MapLikeType paramMapLikeType, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription, KeyDeserializer paramKeyDeserializer, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    while (localIterator.hasNext())
    {
      JsonDeserializer localJsonDeserializer = ((Deserializers)localIterator.next()).findMapLikeDeserializer(paramMapLikeType, paramDeserializationConfig, paramBeanDescription, paramKeyDeserializer, paramTypeDeserializer, paramJsonDeserializer);
      if (localJsonDeserializer != null) {
        return localJsonDeserializer;
      }
    }
    return null;
  }
  
  protected JsonDeserializer<?> _findCustomTreeNodeDeserializer(Class<? extends JsonNode> paramClass, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription)
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    while (localIterator.hasNext())
    {
      JsonDeserializer localJsonDeserializer = ((Deserializers)localIterator.next()).findTreeNodeDeserializer(paramClass, paramDeserializationConfig, paramBeanDescription);
      if (localJsonDeserializer != null) {
        return localJsonDeserializer;
      }
    }
    return null;
  }
  
  protected boolean _handleSingleArgumentConstructor(DeserializationContext paramDeserializationContext, BeanDescription paramBeanDescription, VisibilityChecker<?> paramVisibilityChecker, AnnotationIntrospector paramAnnotationIntrospector, CreatorCollector paramCreatorCollector, AnnotatedConstructor paramAnnotatedConstructor, boolean paramBoolean1, boolean paramBoolean2)
  {
    AnnotatedParameter localAnnotatedParameter = paramAnnotatedConstructor.getParameter(0);
    if (localAnnotatedParameter == null)
    {
      paramVisibilityChecker = null;
      if (paramVisibilityChecker != null) {
        break label85;
      }
    }
    label85:
    for (paramVisibilityChecker = null;; paramVisibilityChecker = paramVisibilityChecker.getSimpleName())
    {
      paramAnnotationIntrospector = paramAnnotationIntrospector.findInjectableValueId(localAnnotatedParameter);
      if ((paramAnnotationIntrospector == null) && ((paramVisibilityChecker == null) || (paramVisibilityChecker.length() <= 0))) {
        break label93;
      }
      paramCreatorCollector.addPropertyCreator(paramAnnotatedConstructor, new CreatorProperty[] { constructCreatorProperty(paramDeserializationContext, paramBeanDescription, paramVisibilityChecker, 0, localAnnotatedParameter, paramAnnotationIntrospector) });
      return true;
      paramVisibilityChecker = paramAnnotationIntrospector.findNameForDeserialization(localAnnotatedParameter);
      break;
    }
    label93:
    paramDeserializationContext = paramAnnotatedConstructor.getRawParameterType(0);
    if (paramDeserializationContext == String.class)
    {
      if ((paramBoolean1) || (paramBoolean2)) {
        paramCreatorCollector.addStringCreator(paramAnnotatedConstructor);
      }
      return true;
    }
    if ((paramDeserializationContext == Integer.TYPE) || (paramDeserializationContext == Integer.class))
    {
      if ((paramBoolean1) || (paramBoolean2)) {
        paramCreatorCollector.addIntCreator(paramAnnotatedConstructor);
      }
      return true;
    }
    if ((paramDeserializationContext == Long.TYPE) || (paramDeserializationContext == Long.class))
    {
      if ((paramBoolean1) || (paramBoolean2)) {
        paramCreatorCollector.addLongCreator(paramAnnotatedConstructor);
      }
      return true;
    }
    if ((paramDeserializationContext == Double.TYPE) || (paramDeserializationContext == Double.class))
    {
      if ((paramBoolean1) || (paramBoolean2)) {
        paramCreatorCollector.addDoubleCreator(paramAnnotatedConstructor);
      }
      return true;
    }
    if (paramBoolean1)
    {
      paramCreatorCollector.addDelegatingCreator(paramAnnotatedConstructor, null);
      return true;
    }
    return false;
  }
  
  protected boolean _handleSingleArgumentFactory(DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription, VisibilityChecker<?> paramVisibilityChecker, AnnotationIntrospector paramAnnotationIntrospector, CreatorCollector paramCreatorCollector, AnnotatedMethod paramAnnotatedMethod, boolean paramBoolean)
  {
    paramDeserializationConfig = paramAnnotatedMethod.getRawParameterType(0);
    if (paramDeserializationConfig == String.class) {
      if ((paramBoolean) || (paramVisibilityChecker.isCreatorVisible(paramAnnotatedMethod))) {
        paramCreatorCollector.addStringCreator(paramAnnotatedMethod);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return true;
            if ((paramDeserializationConfig != Integer.TYPE) && (paramDeserializationConfig != Integer.class)) {
              break;
            }
          } while ((!paramBoolean) && (!paramVisibilityChecker.isCreatorVisible(paramAnnotatedMethod)));
          paramCreatorCollector.addIntCreator(paramAnnotatedMethod);
          return true;
          if ((paramDeserializationConfig != Long.TYPE) && (paramDeserializationConfig != Long.class)) {
            break;
          }
        } while ((!paramBoolean) && (!paramVisibilityChecker.isCreatorVisible(paramAnnotatedMethod)));
        paramCreatorCollector.addLongCreator(paramAnnotatedMethod);
        return true;
        if ((paramDeserializationConfig != Double.TYPE) && (paramDeserializationConfig != Double.class)) {
          break;
        }
      } while ((!paramBoolean) && (!paramVisibilityChecker.isCreatorVisible(paramAnnotatedMethod)));
      paramCreatorCollector.addDoubleCreator(paramAnnotatedMethod);
      return true;
      if ((paramDeserializationConfig != Boolean.TYPE) && (paramDeserializationConfig != Boolean.class)) {
        break;
      }
    } while ((!paramBoolean) && (!paramVisibilityChecker.isCreatorVisible(paramAnnotatedMethod)));
    paramCreatorCollector.addBooleanCreator(paramAnnotatedMethod);
    return true;
    if (paramAnnotationIntrospector.hasCreatorAnnotation(paramAnnotatedMethod))
    {
      paramCreatorCollector.addDelegatingCreator(paramAnnotatedMethod, null);
      return true;
    }
    return false;
  }
  
  public ValueInstantiator _valueInstantiatorInstance(DeserializationConfig paramDeserializationConfig, Annotated paramAnnotated, Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    if ((paramObject instanceof ValueInstantiator)) {
      return (ValueInstantiator)paramObject;
    }
    if (!(paramObject instanceof Class)) {
      throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + paramObject.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
    }
    paramObject = (Class)paramObject;
    if (paramObject == NoClass.class) {
      return null;
    }
    if (!ValueInstantiator.class.isAssignableFrom((Class)paramObject)) {
      throw new IllegalStateException("AnnotationIntrospector returned Class " + ((Class)paramObject).getName() + "; expected Class<ValueInstantiator>");
    }
    HandlerInstantiator localHandlerInstantiator = paramDeserializationConfig.getHandlerInstantiator();
    if (localHandlerInstantiator != null) {
      return localHandlerInstantiator.valueInstantiatorInstance(paramDeserializationConfig, paramAnnotated, (Class)paramObject);
    }
    return (ValueInstantiator)ClassUtil.createInstance((Class)paramObject, paramDeserializationConfig.canOverrideAccessModifiers());
  }
  
  protected CreatorProperty constructCreatorProperty(DeserializationContext paramDeserializationContext, BeanDescription paramBeanDescription, String paramString, int paramInt, AnnotatedParameter paramAnnotatedParameter, Object paramObject)
  {
    DeserializationConfig localDeserializationConfig = paramDeserializationContext.getConfig();
    Object localObject = localDeserializationConfig.getTypeFactory().constructType(paramAnnotatedParameter.getParameterType(), paramBeanDescription.bindingsForBeanType());
    BeanProperty.Std localStd = new BeanProperty.Std(paramString, (JavaType)localObject, paramBeanDescription.getClassAnnotations(), paramAnnotatedParameter);
    JavaType localJavaType = resolveType(paramDeserializationContext, paramBeanDescription, (JavaType)localObject, paramAnnotatedParameter);
    if (localJavaType != localObject) {
      localStd.withType(localJavaType);
    }
    localObject = findDeserializerFromAnnotation(paramDeserializationContext, paramAnnotatedParameter);
    localJavaType = modifyTypeByAnnotation(paramDeserializationContext, paramAnnotatedParameter, localJavaType);
    paramDeserializationContext = (TypeDeserializer)localJavaType.getTypeHandler();
    if (paramDeserializationContext == null) {
      paramDeserializationContext = findTypeDeserializer(localDeserializationConfig, localJavaType);
    }
    for (;;)
    {
      paramBeanDescription = new CreatorProperty(paramString, localJavaType, paramDeserializationContext, paramBeanDescription.getClassAnnotations(), paramAnnotatedParameter, paramInt, paramObject);
      paramDeserializationContext = paramBeanDescription;
      if (localObject != null) {
        paramDeserializationContext = paramBeanDescription.withValueDeserializer((JsonDeserializer)localObject);
      }
      return paramDeserializationContext;
    }
  }
  
  protected EnumResolver<?> constructEnumResolver(Class<?> paramClass, DeserializationConfig paramDeserializationConfig, AnnotatedMethod paramAnnotatedMethod)
  {
    if (paramAnnotatedMethod != null)
    {
      paramAnnotatedMethod = paramAnnotatedMethod.getAnnotated();
      if (paramDeserializationConfig.canOverrideAccessModifiers()) {
        ClassUtil.checkAndFixAccess(paramAnnotatedMethod);
      }
      return EnumResolver.constructUnsafeUsingMethod(paramClass, paramAnnotatedMethod);
    }
    if (paramDeserializationConfig.isEnabled(DeserializationFeature.READ_ENUMS_USING_TO_STRING)) {
      return EnumResolver.constructUnsafeUsingToString(paramClass);
    }
    return EnumResolver.constructUnsafe(paramClass, paramDeserializationConfig.getAnnotationIntrospector());
  }
  
  public JsonDeserializer<?> createArrayDeserializer(DeserializationContext paramDeserializationContext, ArrayType paramArrayType, BeanDescription paramBeanDescription)
  {
    JavaType localJavaType = paramArrayType.getContentType();
    JsonDeserializer localJsonDeserializer = (JsonDeserializer)localJavaType.getValueHandler();
    if (localJsonDeserializer == null)
    {
      localObject = (JsonDeserializer)_arrayDeserializers.get(localJavaType);
      if (localObject != null)
      {
        paramArrayType = _findCustomArrayDeserializer(paramArrayType, paramDeserializationContext.getConfig(), paramBeanDescription, null, localJsonDeserializer);
        paramDeserializationContext = (DeserializationContext)localObject;
        if (paramArrayType != null) {
          paramDeserializationContext = paramArrayType;
        }
        return paramDeserializationContext;
      }
      if (localJavaType.isPrimitive()) {
        throw new IllegalArgumentException("Internal error: primitive type (" + paramArrayType + ") passed, no array deserializer found");
      }
    }
    Object localObject = (TypeDeserializer)localJavaType.getTypeHandler();
    if (localObject == null) {
      localObject = findTypeDeserializer(paramDeserializationContext.getConfig(), localJavaType);
    }
    for (;;)
    {
      paramBeanDescription = _findCustomArrayDeserializer(paramArrayType, paramDeserializationContext.getConfig(), paramBeanDescription, (TypeDeserializer)localObject, localJsonDeserializer);
      paramDeserializationContext = paramBeanDescription;
      if (paramBeanDescription != null) {
        break;
      }
      return new ObjectArrayDeserializer(paramArrayType, localJsonDeserializer, (TypeDeserializer)localObject);
    }
  }
  
  public JsonDeserializer<?> createCollectionDeserializer(DeserializationContext paramDeserializationContext, CollectionType paramCollectionType, BeanDescription paramBeanDescription)
  {
    JavaType localJavaType = paramCollectionType.getContentType();
    JsonDeserializer localJsonDeserializer = (JsonDeserializer)localJavaType.getValueHandler();
    TypeDeserializer localTypeDeserializer = (TypeDeserializer)localJavaType.getTypeHandler();
    if (localTypeDeserializer == null) {
      localTypeDeserializer = findTypeDeserializer(paramDeserializationContext.getConfig(), localJavaType);
    }
    for (;;)
    {
      Object localObject = _findCustomCollectionDeserializer(paramCollectionType, paramDeserializationContext.getConfig(), paramBeanDescription, localTypeDeserializer, localJsonDeserializer);
      if (localObject != null) {
        return (JsonDeserializer<?>)localObject;
      }
      Class localClass = paramCollectionType.getRawClass();
      if ((localJsonDeserializer == null) && (EnumSet.class.isAssignableFrom(localClass))) {
        return new EnumSetDeserializer(localJavaType, null);
      }
      if (!paramCollectionType.isInterface())
      {
        localObject = paramCollectionType;
        if (!paramCollectionType.isAbstract()) {}
      }
      else
      {
        paramBeanDescription = (Class)_collectionFallbacks.get(localClass.getName());
        if (paramBeanDescription == null) {
          throw new IllegalArgumentException("Can not find a deserializer for non-concrete Collection type " + paramCollectionType);
        }
        localObject = (CollectionType)paramDeserializationContext.getConfig().constructSpecializedType(paramCollectionType, paramBeanDescription);
        paramBeanDescription = paramDeserializationContext.getConfig().introspectForCreation((JavaType)localObject);
      }
      paramDeserializationContext = findValueInstantiator(paramDeserializationContext, paramBeanDescription);
      if (localJavaType.getRawClass() == String.class) {
        return new StringCollectionDeserializer((JavaType)localObject, localJsonDeserializer, paramDeserializationContext);
      }
      return new CollectionDeserializer((JavaType)localObject, localJsonDeserializer, localTypeDeserializer, paramDeserializationContext);
    }
  }
  
  public JsonDeserializer<?> createCollectionLikeDeserializer(DeserializationContext paramDeserializationContext, CollectionLikeType paramCollectionLikeType, BeanDescription paramBeanDescription)
  {
    JavaType localJavaType = paramCollectionLikeType.getContentType();
    JsonDeserializer localJsonDeserializer = (JsonDeserializer)localJavaType.getValueHandler();
    TypeDeserializer localTypeDeserializer = (TypeDeserializer)localJavaType.getTypeHandler();
    if (localTypeDeserializer == null) {
      localTypeDeserializer = findTypeDeserializer(paramDeserializationContext.getConfig(), localJavaType);
    }
    for (;;)
    {
      return _findCustomCollectionLikeDeserializer(paramCollectionLikeType, paramDeserializationContext.getConfig(), paramBeanDescription, localTypeDeserializer, localJsonDeserializer);
    }
  }
  
  public JsonDeserializer<?> createEnumDeserializer(DeserializationContext paramDeserializationContext, JavaType paramJavaType, BeanDescription paramBeanDescription)
  {
    paramJavaType = paramJavaType.getRawClass();
    Object localObject = _findCustomEnumDeserializer(paramJavaType, paramDeserializationContext.getConfig(), paramBeanDescription);
    if (localObject != null) {
      return (JsonDeserializer<?>)localObject;
    }
    localObject = paramBeanDescription.getFactoryMethods().iterator();
    while (((Iterator)localObject).hasNext())
    {
      AnnotatedMethod localAnnotatedMethod = (AnnotatedMethod)((Iterator)localObject).next();
      if (paramDeserializationContext.getAnnotationIntrospector().hasCreatorAnnotation(localAnnotatedMethod))
      {
        if ((localAnnotatedMethod.getParameterCount() == 1) && (localAnnotatedMethod.getRawReturnType().isAssignableFrom(paramJavaType))) {
          return EnumDeserializer.deserializerForCreator(paramDeserializationContext.getConfig(), paramJavaType, localAnnotatedMethod);
        }
        throw new IllegalArgumentException("Unsuitable method (" + localAnnotatedMethod + ") decorated with @JsonCreator (for Enum type " + paramJavaType.getName() + ")");
      }
    }
    return new EnumDeserializer(constructEnumResolver(paramJavaType, paramDeserializationContext.getConfig(), paramBeanDescription.findJsonValueMethod()));
  }
  
  public KeyDeserializer createKeyDeserializer(DeserializationContext paramDeserializationContext, JavaType paramJavaType)
  {
    DeserializationConfig localDeserializationConfig = paramDeserializationContext.getConfig();
    Object localObject2;
    Object localObject1;
    if (this._factoryConfig.hasKeyDeserializers())
    {
      localObject2 = localDeserializationConfig.introspectClassAnnotations(paramJavaType.getRawClass());
      Iterator localIterator = this._factoryConfig.keyDeserializers().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = ((KeyDeserializers)localIterator.next()).findKeyDeserializer(paramJavaType, localDeserializationConfig, (BeanDescription)localObject2);
      } while (localObject1 == null);
    }
    do
    {
      return (KeyDeserializer)localObject1;
      localObject1 = paramJavaType.getRawClass();
      if ((localObject1 == String.class) || (localObject1 == Object.class)) {
        return StdKeyDeserializers.constructStringKeyDeserializer(localDeserializationConfig, paramJavaType);
      }
      localObject2 = (KeyDeserializer)_keyDeserializers.get(paramJavaType);
      localObject1 = localObject2;
    } while (localObject2 != null);
    if (paramJavaType.isEnumType()) {
      return _createEnumKeyDeserializer(paramDeserializationContext, paramJavaType);
    }
    return StdKeyDeserializers.findStringBasedKeyDeserializer(localDeserializationConfig, paramJavaType);
  }
  
  public JsonDeserializer<?> createMapDeserializer(DeserializationContext paramDeserializationContext, MapType paramMapType, BeanDescription paramBeanDescription)
  {
    DeserializationConfig localDeserializationConfig = paramDeserializationContext.getConfig();
    JavaType localJavaType = paramMapType.getKeyType();
    Object localObject = paramMapType.getContentType();
    JsonDeserializer localJsonDeserializer = (JsonDeserializer)((JavaType)localObject).getValueHandler();
    KeyDeserializer localKeyDeserializer = (KeyDeserializer)localJavaType.getValueHandler();
    TypeDeserializer localTypeDeserializer = (TypeDeserializer)((JavaType)localObject).getTypeHandler();
    if (localTypeDeserializer == null) {
      localTypeDeserializer = findTypeDeserializer(localDeserializationConfig, (JavaType)localObject);
    }
    for (;;)
    {
      localObject = _findCustomMapDeserializer(paramMapType, localDeserializationConfig, paramBeanDescription, localKeyDeserializer, localTypeDeserializer, localJsonDeserializer);
      if (localObject != null) {
        return (JsonDeserializer<?>)localObject;
      }
      localObject = paramMapType.getRawClass();
      if (EnumMap.class.isAssignableFrom((Class)localObject))
      {
        paramDeserializationContext = localJavaType.getRawClass();
        if ((paramDeserializationContext == null) || (!paramDeserializationContext.isEnum())) {
          throw new IllegalArgumentException("Can not construct EnumMap; generic (key) type not available");
        }
        return new EnumMapDeserializer(paramMapType, null, localJsonDeserializer);
      }
      if ((paramMapType.isInterface()) || (paramMapType.isAbstract()))
      {
        paramBeanDescription = (Class)_mapFallbacks.get(((Class)localObject).getName());
        if (paramBeanDescription == null) {
          throw new IllegalArgumentException("Can not find a deserializer for non-concrete Map type " + paramMapType);
        }
        paramMapType = (MapType)localDeserializationConfig.constructSpecializedType(paramMapType, paramBeanDescription);
        paramBeanDescription = localDeserializationConfig.introspectForCreation(paramMapType);
      }
      for (;;)
      {
        paramDeserializationContext = new MapDeserializer(paramMapType, findValueInstantiator(paramDeserializationContext, paramBeanDescription), localKeyDeserializer, localJsonDeserializer, localTypeDeserializer);
        paramDeserializationContext.setIgnorableProperties(localDeserializationConfig.getAnnotationIntrospector().findPropertiesToIgnore(paramBeanDescription.getClassInfo()));
        return paramDeserializationContext;
      }
    }
  }
  
  public JsonDeserializer<?> createMapLikeDeserializer(DeserializationContext paramDeserializationContext, MapLikeType paramMapLikeType, BeanDescription paramBeanDescription)
  {
    Object localObject = paramMapLikeType.getKeyType();
    JavaType localJavaType = paramMapLikeType.getContentType();
    JsonDeserializer localJsonDeserializer = (JsonDeserializer)localJavaType.getValueHandler();
    KeyDeserializer localKeyDeserializer = (KeyDeserializer)((JavaType)localObject).getValueHandler();
    localObject = (TypeDeserializer)localJavaType.getTypeHandler();
    if (localObject == null) {
      localObject = findTypeDeserializer(paramDeserializationContext.getConfig(), localJavaType);
    }
    for (;;)
    {
      return _findCustomMapLikeDeserializer(paramMapLikeType, paramDeserializationContext.getConfig(), paramBeanDescription, localKeyDeserializer, (TypeDeserializer)localObject, localJsonDeserializer);
    }
  }
  
  public JsonDeserializer<?> createTreeDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanDescription paramBeanDescription)
  {
    paramJavaType = paramJavaType.getRawClass();
    paramDeserializationConfig = _findCustomTreeNodeDeserializer(paramJavaType, paramDeserializationConfig, paramBeanDescription);
    if (paramDeserializationConfig != null) {
      return paramDeserializationConfig;
    }
    return JsonNodeDeserializer.getDeserializer(paramJavaType);
  }
  
  protected JsonDeserializer<Object> findDeserializerFromAnnotation(DeserializationContext paramDeserializationContext, Annotated paramAnnotated)
  {
    Object localObject = paramDeserializationContext.getAnnotationIntrospector().findDeserializer(paramAnnotated);
    if (localObject == null) {
      return null;
    }
    return paramDeserializationContext.deserializerInstance(paramAnnotated, localObject);
  }
  
  public TypeDeserializer findPropertyContentTypeDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, AnnotatedMember paramAnnotatedMember)
  {
    AnnotationIntrospector localAnnotationIntrospector = paramDeserializationConfig.getAnnotationIntrospector();
    TypeResolverBuilder localTypeResolverBuilder = localAnnotationIntrospector.findPropertyContentTypeResolver(paramDeserializationConfig, paramAnnotatedMember, paramJavaType);
    paramJavaType = paramJavaType.getContentType();
    if (localTypeResolverBuilder == null) {
      return findTypeDeserializer(paramDeserializationConfig, paramJavaType);
    }
    return localTypeResolverBuilder.buildTypeDeserializer(paramDeserializationConfig, paramJavaType, paramDeserializationConfig.getSubtypeResolver().collectAndResolveSubtypes(paramAnnotatedMember, paramDeserializationConfig, localAnnotationIntrospector, paramJavaType));
  }
  
  public TypeDeserializer findPropertyTypeDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, AnnotatedMember paramAnnotatedMember)
  {
    AnnotationIntrospector localAnnotationIntrospector = paramDeserializationConfig.getAnnotationIntrospector();
    TypeResolverBuilder localTypeResolverBuilder = localAnnotationIntrospector.findPropertyTypeResolver(paramDeserializationConfig, paramAnnotatedMember, paramJavaType);
    if (localTypeResolverBuilder == null) {
      return findTypeDeserializer(paramDeserializationConfig, paramJavaType);
    }
    return localTypeResolverBuilder.buildTypeDeserializer(paramDeserializationConfig, paramJavaType, paramDeserializationConfig.getSubtypeResolver().collectAndResolveSubtypes(paramAnnotatedMember, paramDeserializationConfig, localAnnotationIntrospector, paramJavaType));
  }
  
  public TypeDeserializer findTypeDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
  {
    Collection localCollection = null;
    Object localObject2 = paramDeserializationConfig.introspectClassAnnotations(paramJavaType.getRawClass()).getClassInfo();
    Object localObject3 = paramDeserializationConfig.getAnnotationIntrospector();
    Object localObject1 = ((AnnotationIntrospector)localObject3).findTypeResolver(paramDeserializationConfig, (AnnotatedClass)localObject2, paramJavaType);
    if (localObject1 == null)
    {
      localObject2 = paramDeserializationConfig.getDefaultTyper(paramJavaType);
      localObject1 = localObject2;
      if (localObject2 == null) {
        return null;
      }
    }
    else
    {
      localCollection = paramDeserializationConfig.getSubtypeResolver().collectAndResolveSubtypes((AnnotatedClass)localObject2, paramDeserializationConfig, (AnnotationIntrospector)localObject3);
    }
    localObject2 = localObject1;
    if (((TypeResolverBuilder)localObject1).getDefaultImpl() == null)
    {
      localObject2 = localObject1;
      if (paramJavaType.isAbstract())
      {
        localObject3 = mapAbstractType(paramDeserializationConfig, paramJavaType);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (((JavaType)localObject3).getRawClass() != paramJavaType.getRawClass()) {
            localObject2 = ((TypeResolverBuilder)localObject1).defaultImpl(((JavaType)localObject3).getRawClass());
          }
        }
      }
    }
    return ((TypeResolverBuilder)localObject2).buildTypeDeserializer(paramDeserializationConfig, paramJavaType, localCollection);
  }
  
  public ValueInstantiator findValueInstantiator(DeserializationContext paramDeserializationContext, BeanDescription paramBeanDescription)
  {
    DeserializationConfig localDeserializationConfig = paramDeserializationContext.getConfig();
    Object localObject2 = null;
    Object localObject1 = paramBeanDescription.getClassInfo();
    Object localObject3 = paramDeserializationContext.getAnnotationIntrospector().findValueInstantiator((AnnotatedClass)localObject1);
    if (localObject3 != null) {
      localObject2 = _valueInstantiatorInstance(localDeserializationConfig, (Annotated)localObject1, localObject3);
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = _findStdValueInstantiator(localDeserializationConfig, paramBeanDescription);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = _constructDefaultValueInstantiator(paramDeserializationContext, paramBeanDescription);
      }
    }
    if (this._factoryConfig.hasValueInstantiators())
    {
      localObject2 = this._factoryConfig.valueInstantiators().iterator();
      paramDeserializationContext = (DeserializationContext)localObject1;
      do
      {
        localObject1 = paramDeserializationContext;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (ValueInstantiators)((Iterator)localObject2).next();
        localObject1 = ((ValueInstantiators)localObject3).findValueInstantiator(localDeserializationConfig, paramBeanDescription, paramDeserializationContext);
        paramDeserializationContext = (DeserializationContext)localObject1;
      } while (localObject1 != null);
      throw new JsonMappingException("Broken registered ValueInstantiators (of type " + localObject3.getClass().getName() + "): returned null ValueInstantiator");
    }
    return (ValueInstantiator)localObject1;
  }
  
  public JavaType mapAbstractType(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
  {
    for (;;)
    {
      JavaType localJavaType = _mapAbstractType2(paramDeserializationConfig, paramJavaType);
      if (localJavaType == null) {
        return paramJavaType;
      }
      Class localClass1 = paramJavaType.getRawClass();
      Class localClass2 = localJavaType.getRawClass();
      if ((localClass1 == localClass2) || (!localClass1.isAssignableFrom(localClass2))) {
        throw new IllegalArgumentException("Invalid abstract type resolution from " + paramJavaType + " to " + localJavaType + ": latter is not a subtype of former");
      }
      paramJavaType = localJavaType;
    }
  }
  
  protected <T extends JavaType> T modifyTypeByAnnotation(DeserializationContext paramDeserializationContext, Annotated paramAnnotated, T paramT)
  {
    AnnotationIntrospector localAnnotationIntrospector = paramDeserializationContext.getAnnotationIntrospector();
    Object localObject2 = localAnnotationIntrospector.findDeserializationType(paramAnnotated, paramT);
    if (localObject2 != null) {}
    for (;;)
    {
      Object localObject1;
      try
      {
        localObject1 = paramT.narrowBy((Class)localObject2);
        paramT = (T)localObject1;
        if (!paramT.isContainerType()) {
          break label433;
        }
        localObject2 = localAnnotationIntrospector.findDeserializationKeyType(paramAnnotated, paramT.getKeyType());
        if (localObject2 != null) {
          if (!(paramT instanceof MapLikeType)) {
            throw new JsonMappingException("Illegal key-type annotation: type " + paramT + " is not a Map(-like) type");
          }
        }
      }
      catch (IllegalArgumentException paramDeserializationContext)
      {
        throw new JsonMappingException("Failed to narrow type " + paramT + " with concrete-type annotation (value " + ((Class)localObject2).getName() + "), method '" + paramAnnotated.getName() + "': " + paramDeserializationContext.getMessage(), null, paramDeserializationContext);
      }
      for (;;)
      {
        try
        {
          localObject1 = ((MapLikeType)paramT).narrowKey((Class)localObject2);
          localObject2 = ((JavaType)localObject1).getKeyType();
          paramT = (T)localObject1;
          if (localObject2 != null)
          {
            paramT = (T)localObject1;
            if (((JavaType)localObject2).getValueHandler() == null)
            {
              localObject2 = paramDeserializationContext.keyDeserializerInstance(paramAnnotated, localAnnotationIntrospector.findKeyDeserializer(paramAnnotated));
              paramT = (T)localObject1;
              if (localObject2 != null)
              {
                paramT = ((MapLikeType)localObject1).withKeyValueHandler(localObject2);
                paramT.getKeyType();
              }
            }
          }
          localObject2 = localAnnotationIntrospector.findDeserializationContentType(paramAnnotated, paramT.getContentType());
          localObject1 = paramT;
          if (localObject2 != null) {}
          localObject1 = paramT;
        }
        catch (IllegalArgumentException paramDeserializationContext)
        {
          try
          {
            localObject1 = paramT.narrowContentsBy((Class)localObject2);
            paramT = (T)localObject1;
            if (((JavaType)localObject1).getContentType().getValueHandler() == null)
            {
              paramDeserializationContext = paramDeserializationContext.deserializerInstance(paramAnnotated, localAnnotationIntrospector.findContentDeserializer(paramAnnotated));
              paramT = (T)localObject1;
              if (paramDeserializationContext != null) {
                paramT = ((JavaType)localObject1).withContentValueHandler(paramDeserializationContext);
              }
            }
            return paramT;
          }
          catch (IllegalArgumentException paramDeserializationContext)
          {
            throw new JsonMappingException("Failed to narrow content type " + paramT + " with content-type annotation (" + ((Class)localObject2).getName() + "): " + paramDeserializationContext.getMessage(), null, paramDeserializationContext);
          }
          paramDeserializationContext = paramDeserializationContext;
          throw new JsonMappingException("Failed to narrow key type " + paramT + " with key-type annotation (" + ((Class)localObject2).getName() + "): " + paramDeserializationContext.getMessage(), null, paramDeserializationContext);
        }
      }
      label433:
      return paramT;
    }
  }
  
  protected JavaType resolveType(DeserializationContext paramDeserializationContext, BeanDescription paramBeanDescription, JavaType paramJavaType, AnnotatedMember paramAnnotatedMember)
  {
    paramBeanDescription = paramJavaType;
    if (paramJavaType.isContainerType())
    {
      Object localObject = paramDeserializationContext.getAnnotationIntrospector();
      paramBeanDescription = paramJavaType;
      if (paramJavaType.getKeyType() != null)
      {
        KeyDeserializer localKeyDeserializer = paramDeserializationContext.keyDeserializerInstance(paramAnnotatedMember, ((AnnotationIntrospector)localObject).findKeyDeserializer(paramAnnotatedMember));
        paramBeanDescription = paramJavaType;
        if (localKeyDeserializer != null)
        {
          paramBeanDescription = ((MapLikeType)paramJavaType).withKeyValueHandler(localKeyDeserializer);
          paramBeanDescription.getKeyType();
        }
      }
      localObject = paramDeserializationContext.deserializerInstance(paramAnnotatedMember, ((AnnotationIntrospector)localObject).findContentDeserializer(paramAnnotatedMember));
      paramJavaType = paramBeanDescription;
      if (localObject != null) {
        paramJavaType = paramBeanDescription.withContentValueHandler(localObject);
      }
      paramBeanDescription = paramJavaType;
      if ((paramAnnotatedMember instanceof AnnotatedMember))
      {
        localObject = findPropertyContentTypeDeserializer(paramDeserializationContext.getConfig(), paramJavaType, paramAnnotatedMember);
        paramBeanDescription = paramJavaType;
        if (localObject != null) {
          paramBeanDescription = paramJavaType.withContentTypeHandler(localObject);
        }
      }
    }
    if ((paramAnnotatedMember instanceof AnnotatedMember)) {}
    for (paramDeserializationContext = findPropertyTypeDeserializer(paramDeserializationContext.getConfig(), paramBeanDescription, paramAnnotatedMember);; paramDeserializationContext = findTypeDeserializer(paramDeserializationContext.getConfig(), paramBeanDescription))
    {
      paramJavaType = paramBeanDescription;
      if (paramDeserializationContext != null) {
        paramJavaType = paramBeanDescription.withTypeHandler(paramDeserializationContext);
      }
      return paramJavaType;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/BasicDeserializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */