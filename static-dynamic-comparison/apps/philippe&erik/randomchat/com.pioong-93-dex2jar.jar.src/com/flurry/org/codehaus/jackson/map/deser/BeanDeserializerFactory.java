package com.flurry.org.codehaus.jackson.map.deser;

import com.flurry.org.codehaus.jackson.JsonNode;
import com.flurry.org.codehaus.jackson.map.AbstractTypeResolver;
import com.flurry.org.codehaus.jackson.map.AnnotationIntrospector;
import com.flurry.org.codehaus.jackson.map.AnnotationIntrospector.ReferenceProperty;
import com.flurry.org.codehaus.jackson.map.BeanDescription;
import com.flurry.org.codehaus.jackson.map.BeanProperty;
import com.flurry.org.codehaus.jackson.map.BeanProperty.Std;
import com.flurry.org.codehaus.jackson.map.BeanPropertyDefinition;
import com.flurry.org.codehaus.jackson.map.DeserializationConfig;
import com.flurry.org.codehaus.jackson.map.DeserializationConfig.Feature;
import com.flurry.org.codehaus.jackson.map.DeserializerFactory;
import com.flurry.org.codehaus.jackson.map.DeserializerFactory.Config;
import com.flurry.org.codehaus.jackson.map.DeserializerProvider;
import com.flurry.org.codehaus.jackson.map.Deserializers;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import com.flurry.org.codehaus.jackson.map.KeyDeserializer;
import com.flurry.org.codehaus.jackson.map.KeyDeserializers;
import com.flurry.org.codehaus.jackson.map.TypeDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.impl.CreatorCollector;
import com.flurry.org.codehaus.jackson.map.deser.impl.CreatorProperty;
import com.flurry.org.codehaus.jackson.map.deser.std.StdKeyDeserializers;
import com.flurry.org.codehaus.jackson.map.deser.std.ThrowableDeserializer;
import com.flurry.org.codehaus.jackson.map.introspect.Annotated;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedClass;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedField;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedMember;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedMethod;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedParameter;
import com.flurry.org.codehaus.jackson.map.introspect.BasicBeanDescription;
import com.flurry.org.codehaus.jackson.map.introspect.VisibilityChecker;
import com.flurry.org.codehaus.jackson.map.type.ArrayType;
import com.flurry.org.codehaus.jackson.map.type.CollectionLikeType;
import com.flurry.org.codehaus.jackson.map.type.CollectionType;
import com.flurry.org.codehaus.jackson.map.type.MapLikeType;
import com.flurry.org.codehaus.jackson.map.type.MapType;
import com.flurry.org.codehaus.jackson.map.type.TypeBindings;
import com.flurry.org.codehaus.jackson.map.type.TypeFactory;
import com.flurry.org.codehaus.jackson.map.util.ArrayBuilders;
import com.flurry.org.codehaus.jackson.map.util.ClassUtil;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BeanDeserializerFactory
  extends BasicDeserializerFactory
{
  private static final Class<?>[] INIT_CAUSE_PARAMS = { Throwable.class };
  public static final BeanDeserializerFactory instance = new BeanDeserializerFactory(null);
  protected final DeserializerFactory.Config _factoryConfig;
  
  @Deprecated
  public BeanDeserializerFactory()
  {
    this(null);
  }
  
  public BeanDeserializerFactory(DeserializerFactory.Config paramConfig)
  {
    Object localObject = paramConfig;
    if (paramConfig == null) {
      localObject = new ConfigImpl();
    }
    this._factoryConfig = ((DeserializerFactory.Config)localObject);
  }
  
  private KeyDeserializer _createEnumKeyDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    Object localObject = (BasicBeanDescription)paramDeserializationConfig.introspect(paramJavaType);
    paramJavaType = paramJavaType.getRawClass();
    paramBeanProperty = constructEnumResolver(paramJavaType, paramDeserializationConfig);
    localObject = ((BasicBeanDescription)localObject).getFactoryMethods().iterator();
    while (((Iterator)localObject).hasNext())
    {
      AnnotatedMethod localAnnotatedMethod = (AnnotatedMethod)((Iterator)localObject).next();
      if (paramDeserializationConfig.getAnnotationIntrospector().hasCreatorAnnotation(localAnnotatedMethod))
      {
        if ((localAnnotatedMethod.getParameterCount() == 1) && (localAnnotatedMethod.getRawType().isAssignableFrom(paramJavaType)))
        {
          if (localAnnotatedMethod.getParameterType(0) != String.class) {
            throw new IllegalArgumentException("Parameter #0 type for factory method (" + localAnnotatedMethod + ") not suitable, must be java.lang.String");
          }
          if (paramDeserializationConfig.canOverrideAccessModifiers()) {
            ClassUtil.checkAndFixAccess(localAnnotatedMethod.getMember());
          }
          return StdKeyDeserializers.constructEnumKeyDeserializer(paramBeanProperty, localAnnotatedMethod);
        }
        throw new IllegalArgumentException("Unsuitable method (" + localAnnotatedMethod + ") decorated with @JsonCreator (for Enum type " + paramJavaType.getName() + ")");
      }
    }
    return StdKeyDeserializers.constructEnumKeyDeserializer(paramBeanProperty);
  }
  
  protected void _addDeserializerConstructors(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, VisibilityChecker<?> paramVisibilityChecker, AnnotationIntrospector paramAnnotationIntrospector, CreatorCollector paramCreatorCollector)
    throws JsonMappingException
  {
    Iterator localIterator = paramBasicBeanDescription.getConstructors().iterator();
    while (localIterator.hasNext())
    {
      AnnotatedConstructor localAnnotatedConstructor = (AnnotatedConstructor)localIterator.next();
      int i1 = localAnnotatedConstructor.getParameterCount();
      if (i1 >= 1)
      {
        boolean bool1 = paramAnnotationIntrospector.hasCreatorAnnotation(localAnnotatedConstructor);
        boolean bool2 = paramVisibilityChecker.isCreatorVisible(localAnnotatedConstructor);
        if (i1 == 1)
        {
          _handleSingleArgumentConstructor(paramDeserializationConfig, paramBasicBeanDescription, paramVisibilityChecker, paramAnnotationIntrospector, paramCreatorCollector, localAnnotatedConstructor, bool1, bool2);
        }
        else if ((bool1) || (bool2))
        {
          Object localObject1 = null;
          int i = 0;
          int k = 0;
          CreatorProperty[] arrayOfCreatorProperty = new CreatorProperty[i1];
          int j = 0;
          if (j < i1)
          {
            AnnotatedParameter localAnnotatedParameter = localAnnotatedConstructor.getParameter(j);
            Object localObject2;
            label145:
            Object localObject3;
            int n;
            int m;
            if (localAnnotatedParameter == null)
            {
              localObject2 = null;
              localObject3 = paramAnnotationIntrospector.findInjectableValueId(localAnnotatedParameter);
              if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
                break label233;
              }
              n = i + 1;
              arrayOfCreatorProperty[j] = constructCreatorProperty(paramDeserializationConfig, paramBasicBeanDescription, (String)localObject2, j, localAnnotatedParameter, localObject3);
              localObject2 = localObject1;
              m = k;
            }
            for (;;)
            {
              j += 1;
              k = m;
              i = n;
              localObject1 = localObject2;
              break;
              localObject2 = paramAnnotationIntrospector.findPropertyNameForParam(localAnnotatedParameter);
              break label145;
              label233:
              if (localObject3 != null)
              {
                m = k + 1;
                arrayOfCreatorProperty[j] = constructCreatorProperty(paramDeserializationConfig, paramBasicBeanDescription, (String)localObject2, j, localAnnotatedParameter, localObject3);
                n = i;
                localObject2 = localObject1;
              }
              else
              {
                m = k;
                n = i;
                localObject2 = localObject1;
                if (localObject1 == null)
                {
                  localObject2 = localAnnotatedParameter;
                  m = k;
                  n = i;
                }
              }
            }
          }
          if ((bool1) || (i > 0) || (k > 0))
          {
            if (i + k == i1) {
              paramCreatorCollector.addPropertyCreator(localAnnotatedConstructor, arrayOfCreatorProperty);
            }
          }
          else
          {
            if (0 == 0) {
              continue;
            }
            paramCreatorCollector.addPropertyCreator(localAnnotatedConstructor, arrayOfCreatorProperty);
            continue;
          }
          if ((i == 0) && (k + 1 == i1)) {
            throw new IllegalArgumentException("Delegated constructor with Injectables not yet supported (see [JACKSON-712]) for " + localAnnotatedConstructor);
          }
          throw new IllegalArgumentException("Argument #" + ((AnnotatedParameter)localObject1).getIndex() + " of constructor " + localAnnotatedConstructor + " has no property name annotation; must have name when multiple-paramater constructor annotated as Creator");
        }
      }
    }
  }
  
  protected void _addDeserializerFactoryMethods(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, VisibilityChecker<?> paramVisibilityChecker, AnnotationIntrospector paramAnnotationIntrospector, CreatorCollector paramCreatorCollector)
    throws JsonMappingException
  {
    Iterator localIterator = paramBasicBeanDescription.getFactoryMethods().iterator();
    while (localIterator.hasNext())
    {
      AnnotatedMethod localAnnotatedMethod = (AnnotatedMethod)localIterator.next();
      int j = localAnnotatedMethod.getParameterCount();
      if (j >= 1)
      {
        boolean bool = paramAnnotationIntrospector.hasCreatorAnnotation(localAnnotatedMethod);
        Object localObject2;
        if (j == 1)
        {
          localObject1 = localAnnotatedMethod.getParameter(0);
          localObject2 = paramAnnotationIntrospector.findPropertyNameForParam((AnnotatedParameter)localObject1);
          if ((paramAnnotationIntrospector.findInjectableValueId((AnnotatedMember)localObject1) == null) && ((localObject2 == null) || (((String)localObject2).length() == 0))) {
            _handleSingleArgumentFactory(paramDeserializationConfig, paramBasicBeanDescription, paramVisibilityChecker, paramAnnotationIntrospector, paramCreatorCollector, localAnnotatedMethod, bool);
          }
        }
        else
        {
          if (!paramAnnotationIntrospector.hasCreatorAnnotation(localAnnotatedMethod)) {
            continue;
          }
        }
        Object localObject1 = new CreatorProperty[j];
        int i = 0;
        while (i < j)
        {
          localObject2 = localAnnotatedMethod.getParameter(i);
          String str = paramAnnotationIntrospector.findPropertyNameForParam((AnnotatedParameter)localObject2);
          Object localObject3 = paramAnnotationIntrospector.findInjectableValueId((AnnotatedMember)localObject2);
          if (((str == null) || (str.length() == 0)) && (localObject3 == null)) {
            throw new IllegalArgumentException("Argument #" + i + " of factory method " + localAnnotatedMethod + " has no property name annotation; must have when multiple-paramater static method annotated as Creator");
          }
          localObject1[i] = constructCreatorProperty(paramDeserializationConfig, paramBasicBeanDescription, str, i, (AnnotatedParameter)localObject2, localObject3);
          i += 1;
        }
        paramCreatorCollector.addPropertyCreator(localAnnotatedMethod, (CreatorProperty[])localObject1);
      }
    }
  }
  
  protected JsonDeserializer<?> _findCustomArrayDeserializer(ArrayType paramArrayType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BeanProperty paramBeanProperty, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
    throws JsonMappingException
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    while (localIterator.hasNext())
    {
      JsonDeserializer localJsonDeserializer = ((Deserializers)localIterator.next()).findArrayDeserializer(paramArrayType, paramDeserializationConfig, paramDeserializerProvider, paramBeanProperty, paramTypeDeserializer, paramJsonDeserializer);
      if (localJsonDeserializer != null) {
        return localJsonDeserializer;
      }
    }
    return null;
  }
  
  protected JsonDeserializer<Object> _findCustomBeanDeserializer(JavaType paramJavaType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    while (localIterator.hasNext())
    {
      JsonDeserializer localJsonDeserializer = ((Deserializers)localIterator.next()).findBeanDeserializer(paramJavaType, paramDeserializationConfig, paramDeserializerProvider, paramBasicBeanDescription, paramBeanProperty);
      if (localJsonDeserializer != null) {
        return localJsonDeserializer;
      }
    }
    return null;
  }
  
  protected JsonDeserializer<?> _findCustomCollectionDeserializer(CollectionType paramCollectionType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
    throws JsonMappingException
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    while (localIterator.hasNext())
    {
      JsonDeserializer localJsonDeserializer = ((Deserializers)localIterator.next()).findCollectionDeserializer(paramCollectionType, paramDeserializationConfig, paramDeserializerProvider, paramBasicBeanDescription, paramBeanProperty, paramTypeDeserializer, paramJsonDeserializer);
      if (localJsonDeserializer != null) {
        return localJsonDeserializer;
      }
    }
    return null;
  }
  
  protected JsonDeserializer<?> _findCustomCollectionLikeDeserializer(CollectionLikeType paramCollectionLikeType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
    throws JsonMappingException
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    while (localIterator.hasNext())
    {
      JsonDeserializer localJsonDeserializer = ((Deserializers)localIterator.next()).findCollectionLikeDeserializer(paramCollectionLikeType, paramDeserializationConfig, paramDeserializerProvider, paramBasicBeanDescription, paramBeanProperty, paramTypeDeserializer, paramJsonDeserializer);
      if (localJsonDeserializer != null) {
        return localJsonDeserializer;
      }
    }
    return null;
  }
  
  protected JsonDeserializer<?> _findCustomEnumDeserializer(Class<?> paramClass, DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    while (localIterator.hasNext())
    {
      JsonDeserializer localJsonDeserializer = ((Deserializers)localIterator.next()).findEnumDeserializer(paramClass, paramDeserializationConfig, paramBasicBeanDescription, paramBeanProperty);
      if (localJsonDeserializer != null) {
        return localJsonDeserializer;
      }
    }
    return null;
  }
  
  protected JsonDeserializer<?> _findCustomMapDeserializer(MapType paramMapType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, KeyDeserializer paramKeyDeserializer, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
    throws JsonMappingException
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    while (localIterator.hasNext())
    {
      JsonDeserializer localJsonDeserializer = ((Deserializers)localIterator.next()).findMapDeserializer(paramMapType, paramDeserializationConfig, paramDeserializerProvider, paramBasicBeanDescription, paramBeanProperty, paramKeyDeserializer, paramTypeDeserializer, paramJsonDeserializer);
      if (localJsonDeserializer != null) {
        return localJsonDeserializer;
      }
    }
    return null;
  }
  
  protected JsonDeserializer<?> _findCustomMapLikeDeserializer(MapLikeType paramMapLikeType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, KeyDeserializer paramKeyDeserializer, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
    throws JsonMappingException
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    while (localIterator.hasNext())
    {
      JsonDeserializer localJsonDeserializer = ((Deserializers)localIterator.next()).findMapLikeDeserializer(paramMapLikeType, paramDeserializationConfig, paramDeserializerProvider, paramBasicBeanDescription, paramBeanProperty, paramKeyDeserializer, paramTypeDeserializer, paramJsonDeserializer);
      if (localJsonDeserializer != null) {
        return localJsonDeserializer;
      }
    }
    return null;
  }
  
  protected JsonDeserializer<?> _findCustomTreeNodeDeserializer(Class<? extends JsonNode> paramClass, DeserializationConfig paramDeserializationConfig, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    while (localIterator.hasNext())
    {
      JsonDeserializer localJsonDeserializer = ((Deserializers)localIterator.next()).findTreeNodeDeserializer(paramClass, paramDeserializationConfig, paramBeanProperty);
      if (localJsonDeserializer != null) {
        return localJsonDeserializer;
      }
    }
    return null;
  }
  
  protected boolean _handleSingleArgumentConstructor(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, VisibilityChecker<?> paramVisibilityChecker, AnnotationIntrospector paramAnnotationIntrospector, CreatorCollector paramCreatorCollector, AnnotatedConstructor paramAnnotatedConstructor, boolean paramBoolean1, boolean paramBoolean2)
    throws JsonMappingException
  {
    paramVisibilityChecker = paramAnnotatedConstructor.getParameter(0);
    String str = paramAnnotationIntrospector.findPropertyNameForParam(paramVisibilityChecker);
    paramAnnotationIntrospector = paramAnnotationIntrospector.findInjectableValueId(paramVisibilityChecker);
    if ((paramAnnotationIntrospector != null) || ((str != null) && (str.length() > 0)))
    {
      paramCreatorCollector.addPropertyCreator(paramAnnotatedConstructor, new CreatorProperty[] { constructCreatorProperty(paramDeserializationConfig, paramBasicBeanDescription, str, 0, paramVisibilityChecker, paramAnnotationIntrospector) });
      return true;
    }
    paramDeserializationConfig = paramAnnotatedConstructor.getParameterClass(0);
    if (paramDeserializationConfig == String.class)
    {
      if ((paramBoolean1) || (paramBoolean2)) {
        paramCreatorCollector.addStringCreator(paramAnnotatedConstructor);
      }
      return true;
    }
    if ((paramDeserializationConfig == Integer.TYPE) || (paramDeserializationConfig == Integer.class))
    {
      if ((paramBoolean1) || (paramBoolean2)) {
        paramCreatorCollector.addIntCreator(paramAnnotatedConstructor);
      }
      return true;
    }
    if ((paramDeserializationConfig == Long.TYPE) || (paramDeserializationConfig == Long.class))
    {
      if ((paramBoolean1) || (paramBoolean2)) {
        paramCreatorCollector.addLongCreator(paramAnnotatedConstructor);
      }
      return true;
    }
    if ((paramDeserializationConfig == Double.TYPE) || (paramDeserializationConfig == Double.class))
    {
      if ((paramBoolean1) || (paramBoolean2)) {
        paramCreatorCollector.addDoubleCreator(paramAnnotatedConstructor);
      }
      return true;
    }
    if (paramBoolean1)
    {
      paramCreatorCollector.addDelegatingCreator(paramAnnotatedConstructor);
      return true;
    }
    return false;
  }
  
  protected boolean _handleSingleArgumentFactory(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, VisibilityChecker<?> paramVisibilityChecker, AnnotationIntrospector paramAnnotationIntrospector, CreatorCollector paramCreatorCollector, AnnotatedMethod paramAnnotatedMethod, boolean paramBoolean)
    throws JsonMappingException
  {
    paramDeserializationConfig = paramAnnotatedMethod.getParameterClass(0);
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
      paramCreatorCollector.addDelegatingCreator(paramAnnotatedMethod);
      return true;
    }
    return false;
  }
  
  protected JavaType _mapAbstractType2(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
    throws JsonMappingException
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
  
  protected void addBeanProps(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, BeanDeserializerBuilder paramBeanDeserializerBuilder)
    throws JsonMappingException
  {
    Object localObject3 = paramBasicBeanDescription.findProperties();
    Object localObject1 = paramDeserializationConfig.getAnnotationIntrospector();
    Object localObject2 = ((AnnotationIntrospector)localObject1).findIgnoreUnknownProperties(paramBasicBeanDescription.getClassInfo());
    if (localObject2 != null) {
      paramBeanDeserializerBuilder.setIgnoreUnknownProperties(((Boolean)localObject2).booleanValue());
    }
    localObject2 = ArrayBuilders.arrayToSet(((AnnotationIntrospector)localObject1).findPropertiesToIgnore(paramBasicBeanDescription.getClassInfo()));
    localObject1 = ((Set)localObject2).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramBeanDeserializerBuilder.addIgnorable((String)((Iterator)localObject1).next());
    }
    Object localObject4 = paramBasicBeanDescription.findAnySetter();
    if (localObject4 == null) {}
    for (localObject1 = paramBasicBeanDescription.getIgnoredPropertyNames(); localObject1 != null; localObject1 = paramBasicBeanDescription.getIgnoredPropertyNamesForDeser())
    {
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramBeanDeserializerBuilder.addIgnorable((String)((Iterator)localObject1).next());
      }
    }
    localObject1 = new HashMap();
    Object localObject5 = ((List)localObject3).iterator();
    while (((Iterator)localObject5).hasNext())
    {
      Object localObject7 = (BeanPropertyDefinition)((Iterator)localObject5).next();
      Object localObject6 = ((BeanPropertyDefinition)localObject7).getName();
      if (!((Set)localObject2).contains(localObject6)) {
        if (((BeanPropertyDefinition)localObject7).hasConstructorParameter())
        {
          paramBeanDeserializerBuilder.addCreatorProperty((BeanPropertyDefinition)localObject7);
        }
        else if (((BeanPropertyDefinition)localObject7).hasSetter())
        {
          localObject7 = ((BeanPropertyDefinition)localObject7).getSetter();
          if (isIgnorableType(paramDeserializationConfig, paramBasicBeanDescription, ((AnnotatedMethod)localObject7).getParameterClass(0), (Map)localObject1))
          {
            paramBeanDeserializerBuilder.addIgnorable((String)localObject6);
          }
          else
          {
            localObject6 = constructSettableProperty(paramDeserializationConfig, paramBasicBeanDescription, (String)localObject6, (AnnotatedMethod)localObject7);
            if (localObject6 != null) {
              paramBeanDeserializerBuilder.addProperty((SettableBeanProperty)localObject6);
            }
          }
        }
        else if (((BeanPropertyDefinition)localObject7).hasField())
        {
          localObject7 = ((BeanPropertyDefinition)localObject7).getField();
          if (isIgnorableType(paramDeserializationConfig, paramBasicBeanDescription, ((AnnotatedField)localObject7).getRawType(), (Map)localObject1))
          {
            paramBeanDeserializerBuilder.addIgnorable((String)localObject6);
          }
          else
          {
            localObject6 = constructSettableProperty(paramDeserializationConfig, paramBasicBeanDescription, (String)localObject6, (AnnotatedField)localObject7);
            if (localObject6 != null) {
              paramBeanDeserializerBuilder.addProperty((SettableBeanProperty)localObject6);
            }
          }
        }
      }
    }
    if (localObject4 != null) {
      paramBeanDeserializerBuilder.setAnySetter(constructAnySetter(paramDeserializationConfig, paramBasicBeanDescription, (AnnotatedMethod)localObject4));
    }
    if (paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.USE_GETTERS_AS_SETTERS))
    {
      localObject1 = ((List)localObject3).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (BeanPropertyDefinition)((Iterator)localObject1).next();
        if (((BeanPropertyDefinition)localObject4).hasGetter())
        {
          localObject3 = ((BeanPropertyDefinition)localObject4).getName();
          if ((!paramBeanDeserializerBuilder.hasProperty((String)localObject3)) && (!((Set)localObject2).contains(localObject3)))
          {
            localObject4 = ((BeanPropertyDefinition)localObject4).getGetter();
            localObject5 = ((AnnotatedMethod)localObject4).getRawType();
            if (((Collection.class.isAssignableFrom((Class)localObject5)) || (Map.class.isAssignableFrom((Class)localObject5))) && (!((Set)localObject2).contains(localObject3)) && (!paramBeanDeserializerBuilder.hasProperty((String)localObject3))) {
              paramBeanDeserializerBuilder.addProperty(constructSetterlessProperty(paramDeserializationConfig, paramBasicBeanDescription, (String)localObject3, (AnnotatedMethod)localObject4));
            }
          }
        }
      }
    }
  }
  
  protected void addInjectables(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, BeanDeserializerBuilder paramBeanDeserializerBuilder)
    throws JsonMappingException
  {
    Object localObject = paramBasicBeanDescription.findInjectables();
    if (localObject != null)
    {
      boolean bool = paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS);
      paramDeserializationConfig = ((Map)localObject).entrySet().iterator();
      while (paramDeserializationConfig.hasNext())
      {
        localObject = (Map.Entry)paramDeserializationConfig.next();
        AnnotatedMember localAnnotatedMember = (AnnotatedMember)((Map.Entry)localObject).getValue();
        if (bool) {
          localAnnotatedMember.fixAccess();
        }
        paramBeanDeserializerBuilder.addInjectable(localAnnotatedMember.getName(), paramBasicBeanDescription.resolveType(localAnnotatedMember.getGenericType()), paramBasicBeanDescription.getClassAnnotations(), localAnnotatedMember, ((Map.Entry)localObject).getKey());
      }
    }
  }
  
  protected void addReferenceProperties(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, BeanDeserializerBuilder paramBeanDeserializerBuilder)
    throws JsonMappingException
  {
    Object localObject1 = paramBasicBeanDescription.findBackReferenceProperties();
    if (localObject1 != null)
    {
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (AnnotatedMember)((Map.Entry)localObject2).getValue();
        if ((localObject2 instanceof AnnotatedMethod)) {
          paramBeanDeserializerBuilder.addBackReferenceProperty(str, constructSettableProperty(paramDeserializationConfig, paramBasicBeanDescription, ((AnnotatedMember)localObject2).getName(), (AnnotatedMethod)localObject2));
        } else {
          paramBeanDeserializerBuilder.addBackReferenceProperty(str, constructSettableProperty(paramDeserializationConfig, paramBasicBeanDescription, ((AnnotatedMember)localObject2).getName(), (AnnotatedField)localObject2));
        }
      }
    }
  }
  
  public JsonDeserializer<Object> buildBeanDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    Object localObject = findValueInstantiator(paramDeserializationConfig, paramBasicBeanDescription);
    if ((paramJavaType.isAbstract()) && (!((ValueInstantiator)localObject).canInstantiate())) {
      paramJavaType = new AbstractDeserializer(paramJavaType);
    }
    do
    {
      return paramJavaType;
      paramJavaType = constructBeanDeserializerBuilder(paramBasicBeanDescription);
      paramJavaType.setValueInstantiator((ValueInstantiator)localObject);
      addBeanProps(paramDeserializationConfig, paramBasicBeanDescription, paramJavaType);
      addReferenceProperties(paramDeserializationConfig, paramBasicBeanDescription, paramJavaType);
      addInjectables(paramDeserializationConfig, paramBasicBeanDescription, paramJavaType);
      localObject = paramJavaType;
      if (this._factoryConfig.hasDeserializerModifiers())
      {
        Iterator localIterator = this._factoryConfig.deserializerModifiers().iterator();
        for (;;)
        {
          localObject = paramJavaType;
          if (!localIterator.hasNext()) {
            break;
          }
          paramJavaType = ((BeanDeserializerModifier)localIterator.next()).updateBuilder(paramDeserializationConfig, paramBasicBeanDescription, paramJavaType);
        }
      }
      paramBeanProperty = ((BeanDeserializerBuilder)localObject).build(paramBeanProperty);
      paramJavaType = paramBeanProperty;
    } while (!this._factoryConfig.hasDeserializerModifiers());
    localObject = this._factoryConfig.deserializerModifiers().iterator();
    for (;;)
    {
      paramJavaType = paramBeanProperty;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramBeanProperty = ((BeanDeserializerModifier)((Iterator)localObject).next()).modifyDeserializer(paramDeserializationConfig, paramBasicBeanDescription, paramBeanProperty);
    }
  }
  
  public JsonDeserializer<Object> buildThrowableDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    paramJavaType = constructBeanDeserializerBuilder(paramBasicBeanDescription);
    paramJavaType.setValueInstantiator(findValueInstantiator(paramDeserializationConfig, paramBasicBeanDescription));
    addBeanProps(paramDeserializationConfig, paramBasicBeanDescription, paramJavaType);
    Object localObject = paramBasicBeanDescription.findMethod("initCause", INIT_CAUSE_PARAMS);
    if (localObject != null)
    {
      localObject = constructSettableProperty(paramDeserializationConfig, paramBasicBeanDescription, "cause", (AnnotatedMethod)localObject);
      if (localObject != null) {
        paramJavaType.addOrReplaceProperty((SettableBeanProperty)localObject, true);
      }
    }
    paramJavaType.addIgnorable("localizedMessage");
    paramJavaType.addIgnorable("message");
    localObject = paramJavaType;
    if (this._factoryConfig.hasDeserializerModifiers())
    {
      Iterator localIterator = this._factoryConfig.deserializerModifiers().iterator();
      for (;;)
      {
        localObject = paramJavaType;
        if (!localIterator.hasNext()) {
          break;
        }
        paramJavaType = ((BeanDeserializerModifier)localIterator.next()).updateBuilder(paramDeserializationConfig, paramBasicBeanDescription, paramJavaType);
      }
    }
    paramBeanProperty = ((BeanDeserializerBuilder)localObject).build(paramBeanProperty);
    paramJavaType = paramBeanProperty;
    if ((paramBeanProperty instanceof BeanDeserializer)) {
      paramJavaType = new ThrowableDeserializer((BeanDeserializer)paramBeanProperty);
    }
    paramBeanProperty = paramJavaType;
    if (this._factoryConfig.hasDeserializerModifiers())
    {
      localObject = this._factoryConfig.deserializerModifiers().iterator();
      for (;;)
      {
        paramBeanProperty = paramJavaType;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramJavaType = ((BeanDeserializerModifier)((Iterator)localObject).next()).modifyDeserializer(paramDeserializationConfig, paramBasicBeanDescription, paramJavaType);
      }
    }
    return paramBeanProperty;
  }
  
  protected SettableAnyProperty constructAnySetter(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, AnnotatedMethod paramAnnotatedMethod)
    throws JsonMappingException
  {
    if (paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
      paramAnnotatedMethod.fixAccess();
    }
    Object localObject = paramBasicBeanDescription.bindingsForBeanType().resolveType(paramAnnotatedMethod.getParameterType(1));
    BeanProperty.Std localStd = new BeanProperty.Std(paramAnnotatedMethod.getName(), (JavaType)localObject, paramBasicBeanDescription.getClassAnnotations(), paramAnnotatedMethod);
    paramBasicBeanDescription = resolveType(paramDeserializationConfig, paramBasicBeanDescription, (JavaType)localObject, paramAnnotatedMethod, localStd);
    localObject = findDeserializerFromAnnotation(paramDeserializationConfig, paramAnnotatedMethod, localStd);
    if (localObject != null) {
      return new SettableAnyProperty(localStd, paramAnnotatedMethod, paramBasicBeanDescription, (JsonDeserializer)localObject);
    }
    return new SettableAnyProperty(localStd, paramAnnotatedMethod, modifyTypeByAnnotation(paramDeserializationConfig, paramAnnotatedMethod, paramBasicBeanDescription, localStd.getName()), null);
  }
  
  protected BeanDeserializerBuilder constructBeanDeserializerBuilder(BasicBeanDescription paramBasicBeanDescription)
  {
    return new BeanDeserializerBuilder(paramBasicBeanDescription);
  }
  
  protected CreatorProperty constructCreatorProperty(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, String paramString, int paramInt, AnnotatedParameter paramAnnotatedParameter, Object paramObject)
    throws JsonMappingException
  {
    Object localObject4 = paramDeserializationConfig.getTypeFactory().constructType(paramAnnotatedParameter.getParameterType(), paramBasicBeanDescription.bindingsForBeanType());
    Object localObject2 = new BeanProperty.Std(paramString, (JavaType)localObject4, paramBasicBeanDescription.getClassAnnotations(), paramAnnotatedParameter);
    Object localObject3 = resolveType(paramDeserializationConfig, paramBasicBeanDescription, (JavaType)localObject4, paramAnnotatedParameter, (BeanProperty)localObject2);
    Object localObject1 = localObject2;
    if (localObject3 != localObject4) {
      localObject1 = ((BeanProperty.Std)localObject2).withType((JavaType)localObject3);
    }
    localObject4 = findDeserializerFromAnnotation(paramDeserializationConfig, paramAnnotatedParameter, (BeanProperty)localObject1);
    JavaType localJavaType = modifyTypeByAnnotation(paramDeserializationConfig, paramAnnotatedParameter, (JavaType)localObject3, paramString);
    localObject3 = (TypeDeserializer)localJavaType.getTypeHandler();
    localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = findTypeDeserializer(paramDeserializationConfig, localJavaType, (BeanProperty)localObject1);
    }
    paramBasicBeanDescription = new CreatorProperty(paramString, localJavaType, (TypeDeserializer)localObject2, paramBasicBeanDescription.getClassAnnotations(), paramAnnotatedParameter, paramInt, paramObject);
    paramDeserializationConfig = paramBasicBeanDescription;
    if (localObject4 != null) {
      paramDeserializationConfig = paramBasicBeanDescription.withValueDeserializer((JsonDeserializer)localObject4);
    }
    return paramDeserializationConfig;
  }
  
  protected ValueInstantiator constructDefaultValueInstantiator(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription)
    throws JsonMappingException
  {
    boolean bool = paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS);
    CreatorCollector localCreatorCollector = new CreatorCollector(paramBasicBeanDescription, bool);
    AnnotationIntrospector localAnnotationIntrospector = paramDeserializationConfig.getAnnotationIntrospector();
    if (paramBasicBeanDescription.getType().isConcrete())
    {
      localObject = paramBasicBeanDescription.findDefaultConstructor();
      if (localObject != null)
      {
        if (bool) {
          ClassUtil.checkAndFixAccess(((AnnotatedConstructor)localObject).getAnnotated());
        }
        localCreatorCollector.setDefaultConstructor((AnnotatedConstructor)localObject);
      }
    }
    Object localObject = paramDeserializationConfig.getDefaultVisibilityChecker();
    localObject = paramDeserializationConfig.getAnnotationIntrospector().findAutoDetectVisibility(paramBasicBeanDescription.getClassInfo(), (VisibilityChecker)localObject);
    _addDeserializerFactoryMethods(paramDeserializationConfig, paramBasicBeanDescription, (VisibilityChecker)localObject, localAnnotationIntrospector, localCreatorCollector);
    _addDeserializerConstructors(paramDeserializationConfig, paramBasicBeanDescription, (VisibilityChecker)localObject, localAnnotationIntrospector, localCreatorCollector);
    return localCreatorCollector.constructValueInstantiator(paramDeserializationConfig);
  }
  
  protected SettableBeanProperty constructSettableProperty(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, String paramString, AnnotatedField paramAnnotatedField)
    throws JsonMappingException
  {
    if (paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
      paramAnnotatedField.fixAccess();
    }
    JavaType localJavaType2 = paramBasicBeanDescription.bindingsForBeanType().resolveType(paramAnnotatedField.getGenericType());
    Object localObject2 = new BeanProperty.Std(paramString, localJavaType2, paramBasicBeanDescription.getClassAnnotations(), paramAnnotatedField);
    JavaType localJavaType1 = resolveType(paramDeserializationConfig, paramBasicBeanDescription, localJavaType2, paramAnnotatedField, (BeanProperty)localObject2);
    Object localObject1 = localObject2;
    if (localJavaType1 != localJavaType2) {
      localObject1 = ((BeanProperty.Std)localObject2).withType(localJavaType1);
    }
    localObject1 = findDeserializerFromAnnotation(paramDeserializationConfig, paramAnnotatedField, (BeanProperty)localObject1);
    localObject2 = modifyTypeByAnnotation(paramDeserializationConfig, paramAnnotatedField, localJavaType1, paramString);
    paramString = new SettableBeanProperty.FieldProperty(paramString, (JavaType)localObject2, (TypeDeserializer)((JavaType)localObject2).getTypeHandler(), paramBasicBeanDescription.getClassAnnotations(), paramAnnotatedField);
    paramBasicBeanDescription = paramString;
    if (localObject1 != null) {
      paramBasicBeanDescription = paramString.withValueDeserializer((JsonDeserializer)localObject1);
    }
    paramDeserializationConfig = paramDeserializationConfig.getAnnotationIntrospector().findReferenceType(paramAnnotatedField);
    if ((paramDeserializationConfig != null) && (paramDeserializationConfig.isManagedReference())) {
      paramBasicBeanDescription.setManagedReferenceName(paramDeserializationConfig.getName());
    }
    return paramBasicBeanDescription;
  }
  
  protected SettableBeanProperty constructSettableProperty(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, String paramString, AnnotatedMethod paramAnnotatedMethod)
    throws JsonMappingException
  {
    if (paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
      paramAnnotatedMethod.fixAccess();
    }
    JavaType localJavaType2 = paramBasicBeanDescription.bindingsForBeanType().resolveType(paramAnnotatedMethod.getParameterType(0));
    Object localObject2 = new BeanProperty.Std(paramString, localJavaType2, paramBasicBeanDescription.getClassAnnotations(), paramAnnotatedMethod);
    JavaType localJavaType1 = resolveType(paramDeserializationConfig, paramBasicBeanDescription, localJavaType2, paramAnnotatedMethod, (BeanProperty)localObject2);
    Object localObject1 = localObject2;
    if (localJavaType1 != localJavaType2) {
      localObject1 = ((BeanProperty.Std)localObject2).withType(localJavaType1);
    }
    localObject1 = findDeserializerFromAnnotation(paramDeserializationConfig, paramAnnotatedMethod, (BeanProperty)localObject1);
    localObject2 = modifyTypeByAnnotation(paramDeserializationConfig, paramAnnotatedMethod, localJavaType1, paramString);
    paramString = new SettableBeanProperty.MethodProperty(paramString, (JavaType)localObject2, (TypeDeserializer)((JavaType)localObject2).getTypeHandler(), paramBasicBeanDescription.getClassAnnotations(), paramAnnotatedMethod);
    paramBasicBeanDescription = paramString;
    if (localObject1 != null) {
      paramBasicBeanDescription = paramString.withValueDeserializer((JsonDeserializer)localObject1);
    }
    paramDeserializationConfig = paramDeserializationConfig.getAnnotationIntrospector().findReferenceType(paramAnnotatedMethod);
    if ((paramDeserializationConfig != null) && (paramDeserializationConfig.isManagedReference())) {
      paramBasicBeanDescription.setManagedReferenceName(paramDeserializationConfig.getName());
    }
    return paramBasicBeanDescription;
  }
  
  protected SettableBeanProperty constructSetterlessProperty(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, String paramString, AnnotatedMethod paramAnnotatedMethod)
    throws JsonMappingException
  {
    if (paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
      paramAnnotatedMethod.fixAccess();
    }
    JavaType localJavaType = paramAnnotatedMethod.getType(paramBasicBeanDescription.bindingsForBeanType());
    JsonDeserializer localJsonDeserializer = findDeserializerFromAnnotation(paramDeserializationConfig, paramAnnotatedMethod, new BeanProperty.Std(paramString, localJavaType, paramBasicBeanDescription.getClassAnnotations(), paramAnnotatedMethod));
    paramDeserializationConfig = modifyTypeByAnnotation(paramDeserializationConfig, paramAnnotatedMethod, localJavaType, paramString);
    paramBasicBeanDescription = new SettableBeanProperty.SetterlessProperty(paramString, paramDeserializationConfig, (TypeDeserializer)paramDeserializationConfig.getTypeHandler(), paramBasicBeanDescription.getClassAnnotations(), paramAnnotatedMethod);
    paramDeserializationConfig = paramBasicBeanDescription;
    if (localJsonDeserializer != null) {
      paramDeserializationConfig = paramBasicBeanDescription.withValueDeserializer(localJsonDeserializer);
    }
    return paramDeserializationConfig;
  }
  
  public JsonDeserializer<Object> createBeanDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    Object localObject = paramJavaType;
    if (paramJavaType.isAbstract()) {
      localObject = mapAbstractType(paramDeserializationConfig, paramJavaType);
    }
    BasicBeanDescription localBasicBeanDescription = (BasicBeanDescription)paramDeserializationConfig.introspect((JavaType)localObject);
    paramJavaType = findDeserializerFromAnnotation(paramDeserializationConfig, localBasicBeanDescription.getClassInfo(), paramBeanProperty);
    if (paramJavaType != null) {
      return paramJavaType;
    }
    JavaType localJavaType = modifyTypeByAnnotation(paramDeserializationConfig, localBasicBeanDescription.getClassInfo(), (JavaType)localObject, null);
    paramJavaType = (JavaType)localObject;
    if (localJavaType.getRawClass() != ((JavaType)localObject).getRawClass())
    {
      paramJavaType = localJavaType;
      localBasicBeanDescription = (BasicBeanDescription)paramDeserializationConfig.introspect(paramJavaType);
    }
    localObject = _findCustomBeanDeserializer(paramJavaType, paramDeserializationConfig, paramDeserializerProvider, localBasicBeanDescription, paramBeanProperty);
    if (localObject != null) {
      return (JsonDeserializer<Object>)localObject;
    }
    if (paramJavaType.isThrowable()) {
      return buildThrowableDeserializer(paramDeserializationConfig, paramJavaType, localBasicBeanDescription, paramBeanProperty);
    }
    if (paramJavaType.isAbstract())
    {
      localObject = materializeAbstractType(paramDeserializationConfig, localBasicBeanDescription);
      if (localObject != null) {
        return buildBeanDeserializer(paramDeserializationConfig, (JavaType)localObject, (BasicBeanDescription)paramDeserializationConfig.introspect((JavaType)localObject), paramBeanProperty);
      }
    }
    paramDeserializerProvider = findStdBeanDeserializer(paramDeserializationConfig, paramDeserializerProvider, paramJavaType, paramBeanProperty);
    if (paramDeserializerProvider != null) {
      return paramDeserializerProvider;
    }
    if (!isPotentialBeanType(paramJavaType.getRawClass())) {
      return null;
    }
    return buildBeanDeserializer(paramDeserializationConfig, paramJavaType, localBasicBeanDescription, paramBeanProperty);
  }
  
  public KeyDeserializer createKeyDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    Object localObject2;
    Object localObject1;
    if (this._factoryConfig.hasKeyDeserializers())
    {
      localObject2 = (BasicBeanDescription)paramDeserializationConfig.introspectClassAnnotations(paramJavaType.getRawClass());
      Iterator localIterator = this._factoryConfig.keyDeserializers().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = ((KeyDeserializers)localIterator.next()).findKeyDeserializer(paramJavaType, paramDeserializationConfig, (BeanDescription)localObject2, paramBeanProperty);
      } while (localObject1 == null);
    }
    do
    {
      return (KeyDeserializer)localObject1;
      localObject1 = paramJavaType.getRawClass();
      if ((localObject1 == String.class) || (localObject1 == Object.class)) {
        return StdKeyDeserializers.constructStringKeyDeserializer(paramDeserializationConfig, paramJavaType);
      }
      localObject2 = (KeyDeserializer)_keyDeserializers.get(paramJavaType);
      localObject1 = localObject2;
    } while (localObject2 != null);
    if (paramJavaType.isEnumType()) {
      return _createEnumKeyDeserializer(paramDeserializationConfig, paramJavaType, paramBeanProperty);
    }
    return StdKeyDeserializers.findStringBasedKeyDeserializer(paramDeserializationConfig, paramJavaType);
  }
  
  public ValueInstantiator findValueInstantiator(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription)
    throws JsonMappingException
  {
    Object localObject1 = paramBasicBeanDescription.getClassInfo();
    Object localObject2 = paramDeserializationConfig.getAnnotationIntrospector().findValueInstantiator((AnnotatedClass)localObject1);
    if (localObject2 != null) {
      if ((localObject2 instanceof ValueInstantiator)) {
        localObject1 = (ValueInstantiator)localObject2;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!this._factoryConfig.hasValueInstantiators()) {
        break;
      }
      Iterator localIterator = this._factoryConfig.valueInstantiators().iterator();
      ValueInstantiators localValueInstantiators;
      do
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localValueInstantiators = (ValueInstantiators)localIterator.next();
        localObject2 = localValueInstantiators.findValueInstantiator(paramDeserializationConfig, paramBasicBeanDescription, (ValueInstantiator)localObject1);
        localObject1 = localObject2;
      } while (localObject2 != null);
      throw new JsonMappingException("Broken registered ValueInstantiators (of type " + localValueInstantiators.getClass().getName() + "): returned null ValueInstantiator");
      if (!(localObject2 instanceof Class)) {
        throw new IllegalStateException("Invalid value instantiator returned for type " + paramBasicBeanDescription + ": neither a Class nor ValueInstantiator");
      }
      localObject2 = (Class)localObject2;
      if (!ValueInstantiator.class.isAssignableFrom((Class)localObject2)) {
        throw new IllegalStateException("Invalid instantiator Class<?> returned for type " + paramBasicBeanDescription + ": " + ((Class)localObject2).getName() + " not a ValueInstantiator");
      }
      localObject1 = paramDeserializationConfig.valueInstantiatorInstance((Annotated)localObject1, (Class)localObject2);
      continue;
      localObject1 = constructDefaultValueInstantiator(paramDeserializationConfig, paramBasicBeanDescription);
    }
    return (ValueInstantiator)localObject2;
  }
  
  public final DeserializerFactory.Config getConfig()
  {
    return this._factoryConfig;
  }
  
  protected boolean isIgnorableType(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, Class<?> paramClass, Map<Class<?>, Boolean> paramMap)
  {
    paramMap = (Boolean)paramMap.get(paramClass);
    paramBasicBeanDescription = paramMap;
    if (paramMap == null)
    {
      paramBasicBeanDescription = (BasicBeanDescription)paramDeserializationConfig.introspectClassAnnotations(paramClass);
      paramDeserializationConfig = paramDeserializationConfig.getAnnotationIntrospector().isIgnorableType(paramBasicBeanDescription.getClassInfo());
      paramBasicBeanDescription = paramDeserializationConfig;
      if (paramDeserializationConfig == null) {
        paramBasicBeanDescription = Boolean.FALSE;
      }
    }
    return paramBasicBeanDescription.booleanValue();
  }
  
  protected boolean isPotentialBeanType(Class<?> paramClass)
  {
    String str = ClassUtil.canBeABeanType(paramClass);
    if (str != null) {
      throw new IllegalArgumentException("Can not deserialize Class " + paramClass.getName() + " (of type " + str + ") as a Bean");
    }
    if (ClassUtil.isProxyType(paramClass)) {
      throw new IllegalArgumentException("Can not deserialize Proxy class " + paramClass.getName() + " as a Bean");
    }
    str = ClassUtil.isLocalType(paramClass, true);
    if (str != null) {
      throw new IllegalArgumentException("Can not deserialize Class " + paramClass.getName() + " (of type " + str + ") as a Bean");
    }
    return true;
  }
  
  public JavaType mapAbstractType(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
    throws JsonMappingException
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
  
  protected JavaType materializeAbstractType(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription)
    throws JsonMappingException
  {
    paramBasicBeanDescription = paramBasicBeanDescription.getType();
    Iterator localIterator = this._factoryConfig.abstractTypeResolvers().iterator();
    while (localIterator.hasNext())
    {
      JavaType localJavaType = ((AbstractTypeResolver)localIterator.next()).resolveAbstractType(paramDeserializationConfig, paramBasicBeanDescription);
      if (localJavaType != null) {
        return localJavaType;
      }
    }
    return null;
  }
  
  public DeserializerFactory withConfig(DeserializerFactory.Config paramConfig)
  {
    if (this._factoryConfig == paramConfig) {
      return this;
    }
    if (getClass() != BeanDeserializerFactory.class) {
      throw new IllegalStateException("Subtype of BeanDeserializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalDeserializers': can not instantiate subtype with " + "additional deserializer definitions");
    }
    return new BeanDeserializerFactory(paramConfig);
  }
  
  public static class ConfigImpl
    extends DeserializerFactory.Config
  {
    protected static final AbstractTypeResolver[] NO_ABSTRACT_TYPE_RESOLVERS = new AbstractTypeResolver[0];
    protected static final KeyDeserializers[] NO_KEY_DESERIALIZERS = new KeyDeserializers[0];
    protected static final BeanDeserializerModifier[] NO_MODIFIERS = new BeanDeserializerModifier[0];
    protected static final ValueInstantiators[] NO_VALUE_INSTANTIATORS = new ValueInstantiators[0];
    protected final AbstractTypeResolver[] _abstractTypeResolvers;
    protected final Deserializers[] _additionalDeserializers;
    protected final KeyDeserializers[] _additionalKeyDeserializers;
    protected final BeanDeserializerModifier[] _modifiers;
    protected final ValueInstantiators[] _valueInstantiators;
    
    public ConfigImpl()
    {
      this(null, null, null, null, null);
    }
    
    protected ConfigImpl(Deserializers[] paramArrayOfDeserializers, KeyDeserializers[] paramArrayOfKeyDeserializers, BeanDeserializerModifier[] paramArrayOfBeanDeserializerModifier, AbstractTypeResolver[] paramArrayOfAbstractTypeResolver, ValueInstantiators[] paramArrayOfValueInstantiators)
    {
      Deserializers[] arrayOfDeserializers = paramArrayOfDeserializers;
      if (paramArrayOfDeserializers == null) {
        arrayOfDeserializers = BeanDeserializerFactory.NO_DESERIALIZERS;
      }
      this._additionalDeserializers = arrayOfDeserializers;
      paramArrayOfDeserializers = paramArrayOfKeyDeserializers;
      if (paramArrayOfKeyDeserializers == null) {
        paramArrayOfDeserializers = NO_KEY_DESERIALIZERS;
      }
      this._additionalKeyDeserializers = paramArrayOfDeserializers;
      paramArrayOfDeserializers = paramArrayOfBeanDeserializerModifier;
      if (paramArrayOfBeanDeserializerModifier == null) {
        paramArrayOfDeserializers = NO_MODIFIERS;
      }
      this._modifiers = paramArrayOfDeserializers;
      paramArrayOfDeserializers = paramArrayOfAbstractTypeResolver;
      if (paramArrayOfAbstractTypeResolver == null) {
        paramArrayOfDeserializers = NO_ABSTRACT_TYPE_RESOLVERS;
      }
      this._abstractTypeResolvers = paramArrayOfDeserializers;
      paramArrayOfDeserializers = paramArrayOfValueInstantiators;
      if (paramArrayOfValueInstantiators == null) {
        paramArrayOfDeserializers = NO_VALUE_INSTANTIATORS;
      }
      this._valueInstantiators = paramArrayOfDeserializers;
    }
    
    public Iterable<AbstractTypeResolver> abstractTypeResolvers()
    {
      return ArrayBuilders.arrayAsIterable(this._abstractTypeResolvers);
    }
    
    public Iterable<BeanDeserializerModifier> deserializerModifiers()
    {
      return ArrayBuilders.arrayAsIterable(this._modifiers);
    }
    
    public Iterable<Deserializers> deserializers()
    {
      return ArrayBuilders.arrayAsIterable(this._additionalDeserializers);
    }
    
    public boolean hasAbstractTypeResolvers()
    {
      return this._abstractTypeResolvers.length > 0;
    }
    
    public boolean hasDeserializerModifiers()
    {
      return this._modifiers.length > 0;
    }
    
    public boolean hasDeserializers()
    {
      return this._additionalDeserializers.length > 0;
    }
    
    public boolean hasKeyDeserializers()
    {
      return this._additionalKeyDeserializers.length > 0;
    }
    
    public boolean hasValueInstantiators()
    {
      return this._valueInstantiators.length > 0;
    }
    
    public Iterable<KeyDeserializers> keyDeserializers()
    {
      return ArrayBuilders.arrayAsIterable(this._additionalKeyDeserializers);
    }
    
    public Iterable<ValueInstantiators> valueInstantiators()
    {
      return ArrayBuilders.arrayAsIterable(this._valueInstantiators);
    }
    
    public DeserializerFactory.Config withAbstractTypeResolver(AbstractTypeResolver paramAbstractTypeResolver)
    {
      if (paramAbstractTypeResolver == null) {
        throw new IllegalArgumentException("Can not pass null resolver");
      }
      paramAbstractTypeResolver = (AbstractTypeResolver[])ArrayBuilders.insertInListNoDup(this._abstractTypeResolvers, paramAbstractTypeResolver);
      return new ConfigImpl(this._additionalDeserializers, this._additionalKeyDeserializers, this._modifiers, paramAbstractTypeResolver, this._valueInstantiators);
    }
    
    public DeserializerFactory.Config withAdditionalDeserializers(Deserializers paramDeserializers)
    {
      if (paramDeserializers == null) {
        throw new IllegalArgumentException("Can not pass null Deserializers");
      }
      return new ConfigImpl((Deserializers[])ArrayBuilders.insertInListNoDup(this._additionalDeserializers, paramDeserializers), this._additionalKeyDeserializers, this._modifiers, this._abstractTypeResolvers, this._valueInstantiators);
    }
    
    public DeserializerFactory.Config withAdditionalKeyDeserializers(KeyDeserializers paramKeyDeserializers)
    {
      if (paramKeyDeserializers == null) {
        throw new IllegalArgumentException("Can not pass null KeyDeserializers");
      }
      paramKeyDeserializers = (KeyDeserializers[])ArrayBuilders.insertInListNoDup(this._additionalKeyDeserializers, paramKeyDeserializers);
      return new ConfigImpl(this._additionalDeserializers, paramKeyDeserializers, this._modifiers, this._abstractTypeResolvers, this._valueInstantiators);
    }
    
    public DeserializerFactory.Config withDeserializerModifier(BeanDeserializerModifier paramBeanDeserializerModifier)
    {
      if (paramBeanDeserializerModifier == null) {
        throw new IllegalArgumentException("Can not pass null modifier");
      }
      paramBeanDeserializerModifier = (BeanDeserializerModifier[])ArrayBuilders.insertInListNoDup(this._modifiers, paramBeanDeserializerModifier);
      return new ConfigImpl(this._additionalDeserializers, this._additionalKeyDeserializers, paramBeanDeserializerModifier, this._abstractTypeResolvers, this._valueInstantiators);
    }
    
    public DeserializerFactory.Config withValueInstantiators(ValueInstantiators paramValueInstantiators)
    {
      if (paramValueInstantiators == null) {
        throw new IllegalArgumentException("Can not pass null resolver");
      }
      paramValueInstantiators = (ValueInstantiators[])ArrayBuilders.insertInListNoDup(this._valueInstantiators, paramValueInstantiators);
      return new ConfigImpl(this._additionalDeserializers, this._additionalKeyDeserializers, this._modifiers, this._abstractTypeResolvers, paramValueInstantiators);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/BeanDeserializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */