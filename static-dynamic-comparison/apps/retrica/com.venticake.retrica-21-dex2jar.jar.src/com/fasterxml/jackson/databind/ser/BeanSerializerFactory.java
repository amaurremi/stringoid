package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.BeanProperty.Std;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.impl.FilteredBeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.impl.PropertyBasedObjectIdGenerator;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class BeanSerializerFactory
  extends BasicSerializerFactory
  implements Serializable
{
  public static final BeanSerializerFactory instance = new BeanSerializerFactory(null);
  
  protected BeanSerializerFactory(SerializerFactoryConfig paramSerializerFactoryConfig)
  {
    super(paramSerializerFactoryConfig);
  }
  
  protected BeanPropertyWriter _constructWriter(SerializerProvider paramSerializerProvider, BeanPropertyDefinition paramBeanPropertyDefinition, TypeBindings paramTypeBindings, PropertyBuilder paramPropertyBuilder, boolean paramBoolean, AnnotatedMember paramAnnotatedMember)
  {
    Object localObject = paramBeanPropertyDefinition.getName();
    if (paramSerializerProvider.canOverrideAccessModifiers()) {
      paramAnnotatedMember.fixAccess();
    }
    JavaType localJavaType = paramAnnotatedMember.getType(paramTypeBindings);
    localObject = new BeanProperty.Std((String)localObject, localJavaType, paramPropertyBuilder.getClassAnnotations(), paramAnnotatedMember);
    paramTypeBindings = findSerializerFromAnnotation(paramSerializerProvider, paramAnnotatedMember);
    if ((paramTypeBindings instanceof ResolvableSerializer)) {
      ((ResolvableSerializer)paramTypeBindings).resolve(paramSerializerProvider);
    }
    if ((paramTypeBindings instanceof ContextualSerializer)) {
      paramTypeBindings = ((ContextualSerializer)paramTypeBindings).createContextual(paramSerializerProvider, (BeanProperty)localObject);
    }
    for (;;)
    {
      localObject = null;
      if (ClassUtil.isCollectionMapOrArray(localJavaType.getRawClass())) {
        localObject = findPropertyContentTypeSerializer(localJavaType, paramSerializerProvider.getConfig(), paramAnnotatedMember);
      }
      return paramPropertyBuilder.buildWriter(paramBeanPropertyDefinition, localJavaType, paramTypeBindings, findPropertyTypeSerializer(localJavaType, paramSerializerProvider.getConfig(), paramAnnotatedMember), (TypeSerializer)localObject, paramAnnotatedMember, paramBoolean);
    }
  }
  
  protected JsonSerializer<Object> constructBeanSerializer(SerializerProvider paramSerializerProvider, BeanDescription paramBeanDescription)
  {
    if (paramBeanDescription.getBeanClass() == Object.class) {
      paramSerializerProvider = paramSerializerProvider.getUnknownTypeSerializer(Object.class);
    }
    Object localObject1;
    do
    {
      Object localObject2;
      do
      {
        return paramSerializerProvider;
        SerializationConfig localSerializationConfig = paramSerializerProvider.getConfig();
        localObject2 = constructBeanSerializerBuilder(paramBeanDescription);
        ((BeanSerializerBuilder)localObject2).setConfig(localSerializationConfig);
        Object localObject3 = findBeanProperties(paramSerializerProvider, paramBeanDescription, (BeanSerializerBuilder)localObject2);
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = new ArrayList();
        }
        Iterator localIterator;
        if (this._factoryConfig.hasSerializerModifiers())
        {
          localIterator = this._factoryConfig.serializerModifiers().iterator();
          for (;;)
          {
            localObject3 = localObject1;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject1 = ((BeanSerializerModifier)localIterator.next()).changeProperties(localSerializationConfig, paramBeanDescription, (List)localObject1);
          }
        }
        localObject3 = localObject1;
        localObject1 = filterBeanProperties(localSerializationConfig, paramBeanDescription, (List)localObject3);
        if (this._factoryConfig.hasSerializerModifiers())
        {
          localIterator = this._factoryConfig.serializerModifiers().iterator();
          for (;;)
          {
            localObject3 = localObject1;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject1 = ((BeanSerializerModifier)localIterator.next()).orderProperties(localSerializationConfig, paramBeanDescription, (List)localObject1);
          }
        }
        localObject3 = localObject1;
        ((BeanSerializerBuilder)localObject2).setObjectIdWriter(constructObjectIdHandler(paramSerializerProvider, paramBeanDescription, (List)localObject3));
        ((BeanSerializerBuilder)localObject2).setProperties((List)localObject3);
        ((BeanSerializerBuilder)localObject2).setFilterId(findFilterId(localSerializationConfig, paramBeanDescription));
        paramSerializerProvider = paramBeanDescription.findAnyGetter();
        if (paramSerializerProvider != null)
        {
          if (localSerializationConfig.canOverrideAccessModifiers()) {
            paramSerializerProvider.fixAccess();
          }
          localObject3 = paramSerializerProvider.getType(paramBeanDescription.bindingsForBeanType());
          boolean bool = localSerializationConfig.isEnabled(MapperFeature.USE_STATIC_TYPING);
          localObject1 = ((JavaType)localObject3).getContentType();
          localObject3 = MapSerializer.construct(null, (JavaType)localObject3, bool, createTypeSerializer(localSerializationConfig, (JavaType)localObject1), null, null);
          ((BeanSerializerBuilder)localObject2).setAnyGetter(new AnyGetterWriter(new BeanProperty.Std(paramSerializerProvider.getName(), (JavaType)localObject1, paramBeanDescription.getClassAnnotations(), paramSerializerProvider), paramSerializerProvider, (MapSerializer)localObject3));
        }
        processViews(localSerializationConfig, (BeanSerializerBuilder)localObject2);
        if (this._factoryConfig.hasSerializerModifiers())
        {
          localObject3 = this._factoryConfig.serializerModifiers().iterator();
          for (paramSerializerProvider = (SerializerProvider)localObject2;; paramSerializerProvider = ((BeanSerializerModifier)((Iterator)localObject3).next()).updateBuilder(localSerializationConfig, paramBeanDescription, paramSerializerProvider))
          {
            localObject1 = paramSerializerProvider;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
          }
        }
        localObject1 = localObject2;
        localObject2 = ((BeanSerializerBuilder)localObject1).build();
        paramSerializerProvider = (SerializerProvider)localObject2;
      } while (localObject2 != null);
      paramSerializerProvider = (SerializerProvider)localObject2;
    } while (!paramBeanDescription.hasKnownClassAnnotations());
    return ((BeanSerializerBuilder)localObject1).createDummy();
  }
  
  protected BeanSerializerBuilder constructBeanSerializerBuilder(BeanDescription paramBeanDescription)
  {
    return new BeanSerializerBuilder(paramBeanDescription);
  }
  
  protected BeanPropertyWriter constructFilteredBeanWriter(BeanPropertyWriter paramBeanPropertyWriter, Class<?>[] paramArrayOfClass)
  {
    return FilteredBeanPropertyWriter.constructViewBased(paramBeanPropertyWriter, paramArrayOfClass);
  }
  
  protected ObjectIdWriter constructObjectIdHandler(SerializerProvider paramSerializerProvider, BeanDescription paramBeanDescription, List<BeanPropertyWriter> paramList)
  {
    ObjectIdInfo localObjectIdInfo = paramBeanDescription.getObjectIdInfo();
    if (localObjectIdInfo == null) {
      return null;
    }
    Object localObject = localObjectIdInfo.getGeneratorType();
    if (localObject == ObjectIdGenerators.PropertyGenerator.class)
    {
      paramSerializerProvider = localObjectIdInfo.getPropertyName();
      int j = paramList.size();
      int i = 0;
      for (;;)
      {
        if (i == j) {
          throw new IllegalArgumentException("Invalid Object Id definition for " + paramBeanDescription.getBeanClass().getName() + ": can not find property with name '" + paramSerializerProvider + "'");
        }
        localObject = (BeanPropertyWriter)paramList.get(i);
        if (paramSerializerProvider.equals(((BeanPropertyWriter)localObject).getName()))
        {
          if (i > 0)
          {
            paramList.remove(i);
            paramList.add(0, localObject);
          }
          return ObjectIdWriter.construct(((BeanPropertyWriter)localObject).getType(), null, new PropertyBasedObjectIdGenerator(localObjectIdInfo, (BeanPropertyWriter)localObject), localObjectIdInfo.getAlwaysAsId());
        }
        i += 1;
      }
    }
    paramList = paramSerializerProvider.constructType((Type)localObject);
    paramList = paramSerializerProvider.getTypeFactory().findTypeParameters(paramList, com.fasterxml.jackson.annotation.ObjectIdGenerator.class)[0];
    paramSerializerProvider = paramSerializerProvider.objectIdGeneratorInstance(paramBeanDescription.getClassInfo(), localObjectIdInfo);
    return ObjectIdWriter.construct(paramList, localObjectIdInfo.getPropertyName(), paramSerializerProvider, localObjectIdInfo.getAlwaysAsId());
  }
  
  protected PropertyBuilder constructPropertyBuilder(SerializationConfig paramSerializationConfig, BeanDescription paramBeanDescription)
  {
    return new PropertyBuilder(paramSerializationConfig, paramBeanDescription);
  }
  
  public JsonSerializer<Object> createSerializer(SerializerProvider paramSerializerProvider, JavaType paramJavaType)
  {
    SerializationConfig localSerializationConfig = paramSerializerProvider.getConfig();
    Object localObject1 = localSerializationConfig.introspect(paramJavaType);
    Object localObject2 = findSerializerFromAnnotation(paramSerializerProvider, ((BeanDescription)localObject1).getClassInfo());
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      return (JsonSerializer<Object>)localObject1;
    }
    JavaType localJavaType = modifyTypeByAnnotation(localSerializationConfig, ((BeanDescription)localObject1).getClassInfo(), paramJavaType);
    boolean bool1;
    if (localJavaType == paramJavaType)
    {
      bool1 = false;
      localObject2 = localObject1;
    }
    for (;;)
    {
      JsonSerializer localJsonSerializer = findSerializerByAnnotations(paramSerializerProvider, localJavaType, (BeanDescription)localObject2);
      localObject1 = localJsonSerializer;
      if (localJsonSerializer != null) {
        break;
      }
      boolean bool2;
      if (paramJavaType.isContainerType())
      {
        bool2 = bool1;
        if (!bool1) {
          bool2 = usesStaticTyping(localSerializationConfig, (BeanDescription)localObject2, null);
        }
        paramJavaType = buildContainerSerializer(paramSerializerProvider, localJavaType, (BeanDescription)localObject2, bool2);
        localObject1 = paramJavaType;
        if (paramJavaType != null) {
          break;
        }
        paramJavaType = findSerializerByLookup(localJavaType, localSerializationConfig, (BeanDescription)localObject2, bool2);
        localObject1 = paramJavaType;
        if (paramJavaType != null) {
          break;
        }
        paramJavaType = findSerializerByPrimaryType(paramSerializerProvider, localJavaType, (BeanDescription)localObject2, bool2);
        localObject1 = paramJavaType;
        if (paramJavaType != null) {
          break;
        }
        paramSerializerProvider = findBeanSerializer(paramSerializerProvider, localJavaType, (BeanDescription)localObject2);
        localObject1 = paramSerializerProvider;
        if (paramSerializerProvider != null) {
          break;
        }
        return findSerializerByAddonType(localSerializationConfig, localJavaType, (BeanDescription)localObject2, bool2);
        if (localJavaType.getRawClass() == paramJavaType.getRawClass()) {
          break label275;
        }
        localObject2 = localSerializationConfig.introspect(localJavaType);
        bool1 = true;
        continue;
      }
      paramJavaType = customSerializers().iterator();
      do
      {
        bool2 = bool1;
        if (!paramJavaType.hasNext()) {
          break;
        }
        localObject1 = ((Serializers)paramJavaType.next()).findSerializer(localSerializationConfig, localJavaType, (BeanDescription)localObject2);
      } while (localObject1 == null);
      return (JsonSerializer<Object>)localObject1;
      label275:
      bool1 = true;
      localObject2 = localObject1;
    }
  }
  
  protected Iterable<Serializers> customSerializers()
  {
    return this._factoryConfig.serializers();
  }
  
  protected List<BeanPropertyWriter> filterBeanProperties(SerializationConfig paramSerializationConfig, BeanDescription paramBeanDescription, List<BeanPropertyWriter> paramList)
  {
    paramSerializationConfig = paramSerializationConfig.getAnnotationIntrospector().findPropertiesToIgnore(paramBeanDescription.getClassInfo());
    if ((paramSerializationConfig != null) && (paramSerializationConfig.length > 0))
    {
      paramSerializationConfig = ArrayBuilders.arrayToSet(paramSerializationConfig);
      paramBeanDescription = paramList.iterator();
      while (paramBeanDescription.hasNext()) {
        if (paramSerializationConfig.contains(((BeanPropertyWriter)paramBeanDescription.next()).getName())) {
          paramBeanDescription.remove();
        }
      }
    }
    return paramList;
  }
  
  protected List<BeanPropertyWriter> findBeanProperties(SerializerProvider paramSerializerProvider, BeanDescription paramBeanDescription, BeanSerializerBuilder paramBeanSerializerBuilder)
  {
    Object localObject = paramBeanDescription.findProperties();
    SerializationConfig localSerializationConfig = paramSerializerProvider.getConfig();
    removeIgnorableTypes(localSerializationConfig, paramBeanDescription, (List)localObject);
    if (localSerializationConfig.isEnabled(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS)) {
      removeSetterlessGetters(localSerializationConfig, paramBeanDescription, (List)localObject);
    }
    if (((List)localObject).isEmpty()) {
      return null;
    }
    boolean bool = usesStaticTyping(localSerializationConfig, paramBeanDescription, null);
    PropertyBuilder localPropertyBuilder = constructPropertyBuilder(localSerializationConfig, paramBeanDescription);
    ArrayList localArrayList = new ArrayList(((List)localObject).size());
    paramBeanDescription = paramBeanDescription.bindingsForBeanType();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      BeanPropertyDefinition localBeanPropertyDefinition = (BeanPropertyDefinition)((Iterator)localObject).next();
      AnnotatedMember localAnnotatedMember = localBeanPropertyDefinition.getAccessor();
      if (localBeanPropertyDefinition.isTypeId())
      {
        if (localAnnotatedMember != null)
        {
          if (localSerializationConfig.canOverrideAccessModifiers()) {
            localAnnotatedMember.fixAccess();
          }
          paramBeanSerializerBuilder.setTypeId(localAnnotatedMember);
        }
      }
      else
      {
        AnnotationIntrospector.ReferenceProperty localReferenceProperty = localBeanPropertyDefinition.findReferenceType();
        if ((localReferenceProperty == null) || (!localReferenceProperty.isBackReference())) {
          if ((localAnnotatedMember instanceof AnnotatedMethod)) {
            localArrayList.add(_constructWriter(paramSerializerProvider, localBeanPropertyDefinition, paramBeanDescription, localPropertyBuilder, bool, (AnnotatedMethod)localAnnotatedMember));
          } else {
            localArrayList.add(_constructWriter(paramSerializerProvider, localBeanPropertyDefinition, paramBeanDescription, localPropertyBuilder, bool, (AnnotatedField)localAnnotatedMember));
          }
        }
      }
    }
    return localArrayList;
  }
  
  public JsonSerializer<Object> findBeanSerializer(SerializerProvider paramSerializerProvider, JavaType paramJavaType, BeanDescription paramBeanDescription)
  {
    Object localObject;
    if ((!isPotentialBeanType(paramJavaType.getRawClass())) && (!paramJavaType.isEnumType()))
    {
      localObject = null;
      return (JsonSerializer<Object>)localObject;
    }
    paramJavaType = constructBeanSerializer(paramSerializerProvider, paramBeanDescription);
    if (this._factoryConfig.hasSerializerModifiers())
    {
      Iterator localIterator = this._factoryConfig.serializerModifiers().iterator();
      for (;;)
      {
        localObject = paramJavaType;
        if (!localIterator.hasNext()) {
          break;
        }
        paramJavaType = ((BeanSerializerModifier)localIterator.next()).modifySerializer(paramSerializerProvider.getConfig(), paramBeanDescription, paramJavaType);
      }
    }
    return paramJavaType;
  }
  
  protected Object findFilterId(SerializationConfig paramSerializationConfig, BeanDescription paramBeanDescription)
  {
    return paramSerializationConfig.getAnnotationIntrospector().findFilterId(paramBeanDescription.getClassInfo());
  }
  
  public TypeSerializer findPropertyContentTypeSerializer(JavaType paramJavaType, SerializationConfig paramSerializationConfig, AnnotatedMember paramAnnotatedMember)
  {
    JavaType localJavaType = paramJavaType.getContentType();
    AnnotationIntrospector localAnnotationIntrospector = paramSerializationConfig.getAnnotationIntrospector();
    paramJavaType = localAnnotationIntrospector.findPropertyContentTypeResolver(paramSerializationConfig, paramAnnotatedMember, paramJavaType);
    if (paramJavaType == null) {
      return createTypeSerializer(paramSerializationConfig, localJavaType);
    }
    return paramJavaType.buildTypeSerializer(paramSerializationConfig, localJavaType, paramSerializationConfig.getSubtypeResolver().collectAndResolveSubtypes(paramAnnotatedMember, paramSerializationConfig, localAnnotationIntrospector, localJavaType));
  }
  
  public TypeSerializer findPropertyTypeSerializer(JavaType paramJavaType, SerializationConfig paramSerializationConfig, AnnotatedMember paramAnnotatedMember)
  {
    AnnotationIntrospector localAnnotationIntrospector = paramSerializationConfig.getAnnotationIntrospector();
    TypeResolverBuilder localTypeResolverBuilder = localAnnotationIntrospector.findPropertyTypeResolver(paramSerializationConfig, paramAnnotatedMember, paramJavaType);
    if (localTypeResolverBuilder == null) {
      return createTypeSerializer(paramSerializationConfig, paramJavaType);
    }
    return localTypeResolverBuilder.buildTypeSerializer(paramSerializationConfig, paramJavaType, paramSerializationConfig.getSubtypeResolver().collectAndResolveSubtypes(paramAnnotatedMember, paramSerializationConfig, localAnnotationIntrospector, paramJavaType));
  }
  
  protected boolean isPotentialBeanType(Class<?> paramClass)
  {
    return (ClassUtil.canBeABeanType(paramClass) == null) && (!ClassUtil.isProxyType(paramClass));
  }
  
  protected void processViews(SerializationConfig paramSerializationConfig, BeanSerializerBuilder paramBeanSerializerBuilder)
  {
    List localList = paramBeanSerializerBuilder.getProperties();
    boolean bool = paramSerializationConfig.isEnabled(MapperFeature.DEFAULT_VIEW_INCLUSION);
    int m = localList.size();
    paramSerializationConfig = new BeanPropertyWriter[m];
    int k = 0;
    int i = 0;
    if (k < m)
    {
      BeanPropertyWriter localBeanPropertyWriter = (BeanPropertyWriter)localList.get(k);
      Class[] arrayOfClass = localBeanPropertyWriter.getViews();
      int j;
      if (arrayOfClass == null)
      {
        j = i;
        if (!bool) {
          break label108;
        }
        paramSerializationConfig[k] = localBeanPropertyWriter;
      }
      for (;;)
      {
        k += 1;
        break;
        j = i + 1;
        paramSerializationConfig[k] = constructFilteredBeanWriter(localBeanPropertyWriter, arrayOfClass);
        label108:
        i = j;
      }
    }
    if ((bool) && (i == 0)) {
      return;
    }
    paramBeanSerializerBuilder.setFilteredProperties(paramSerializationConfig);
  }
  
  protected void removeIgnorableTypes(SerializationConfig paramSerializationConfig, BeanDescription paramBeanDescription, List<BeanPropertyDefinition> paramList)
  {
    AnnotationIntrospector localAnnotationIntrospector = paramSerializationConfig.getAnnotationIntrospector();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramBeanDescription = ((BeanPropertyDefinition)localIterator.next()).getAccessor();
      if (paramBeanDescription == null)
      {
        localIterator.remove();
      }
      else
      {
        Class localClass = paramBeanDescription.getRawType();
        paramList = (Boolean)localHashMap.get(localClass);
        paramBeanDescription = paramList;
        if (paramList == null)
        {
          paramList = localAnnotationIntrospector.isIgnorableType(paramSerializationConfig.introspectClassAnnotations(localClass).getClassInfo());
          paramBeanDescription = paramList;
          if (paramList == null) {
            paramBeanDescription = Boolean.FALSE;
          }
          localHashMap.put(localClass, paramBeanDescription);
        }
        if (paramBeanDescription.booleanValue()) {
          localIterator.remove();
        }
      }
    }
  }
  
  protected void removeSetterlessGetters(SerializationConfig paramSerializationConfig, BeanDescription paramBeanDescription, List<BeanPropertyDefinition> paramList)
  {
    paramSerializationConfig = paramList.iterator();
    while (paramSerializationConfig.hasNext())
    {
      paramBeanDescription = (BeanPropertyDefinition)paramSerializationConfig.next();
      if ((!paramBeanDescription.couldDeserialize()) && (!paramBeanDescription.isExplicitlyIncluded())) {
        paramSerializationConfig.remove();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/BeanSerializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */