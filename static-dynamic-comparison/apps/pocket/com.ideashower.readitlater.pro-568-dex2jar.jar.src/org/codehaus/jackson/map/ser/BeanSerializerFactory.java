package org.codehaus.jackson.map.ser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.AnnotationIntrospector.ReferenceProperty;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.BeanProperty.Std;
import org.codehaus.jackson.map.BeanPropertyDefinition;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.SerializerFactory;
import org.codehaus.jackson.map.SerializerFactory.Config;
import org.codehaus.jackson.map.Serializers;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.jsontype.SubtypeResolver;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.map.ser.std.MapSerializer;
import org.codehaus.jackson.map.type.TypeBindings;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

public class BeanSerializerFactory
  extends BasicSerializerFactory
{
  public static final BeanSerializerFactory instance = new BeanSerializerFactory(null);
  protected final SerializerFactory.Config _factoryConfig;
  
  protected BeanSerializerFactory(SerializerFactory.Config paramConfig)
  {
    Object localObject = paramConfig;
    if (paramConfig == null) {
      localObject = new BeanSerializerFactory.ConfigImpl();
    }
    this._factoryConfig = ((SerializerFactory.Config)localObject);
  }
  
  protected BeanPropertyWriter _constructWriter(SerializationConfig paramSerializationConfig, TypeBindings paramTypeBindings, PropertyBuilder paramPropertyBuilder, boolean paramBoolean, String paramString, AnnotatedMember paramAnnotatedMember)
  {
    if (paramSerializationConfig.isEnabled(SerializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
      paramAnnotatedMember.fixAccess();
    }
    JavaType localJavaType = paramAnnotatedMember.getType(paramTypeBindings);
    BeanProperty.Std localStd = new BeanProperty.Std(paramString, localJavaType, paramPropertyBuilder.getClassAnnotations(), paramAnnotatedMember);
    JsonSerializer localJsonSerializer = findSerializerFromAnnotation(paramSerializationConfig, paramAnnotatedMember, localStd);
    paramTypeBindings = null;
    if (ClassUtil.isCollectionMapOrArray(localJavaType.getRawClass())) {
      paramTypeBindings = findPropertyContentTypeSerializer(localJavaType, paramSerializationConfig, paramAnnotatedMember, localStd);
    }
    paramTypeBindings = paramPropertyBuilder.buildWriter(paramString, localJavaType, localJsonSerializer, findPropertyTypeSerializer(localJavaType, paramSerializationConfig, paramAnnotatedMember, localStd), paramTypeBindings, paramAnnotatedMember, paramBoolean);
    paramTypeBindings.setViews(paramSerializationConfig.getAnnotationIntrospector().findSerializationViews(paramAnnotatedMember));
    return paramTypeBindings;
  }
  
  protected JsonSerializer constructBeanSerializer(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty)
  {
    if (paramBasicBeanDescription.getBeanClass() == Object.class) {
      throw new IllegalArgumentException("Can not create bean serializer for Object.class");
    }
    BeanSerializerBuilder localBeanSerializerBuilder = constructBeanSerializerBuilder(paramBasicBeanDescription);
    Object localObject2 = findBeanProperties(paramSerializationConfig, paramBasicBeanDescription);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    Iterator localIterator;
    if (this._factoryConfig.hasSerializerModifiers())
    {
      localIterator = this._factoryConfig.serializerModifiers().iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = ((BeanSerializerModifier)localIterator.next()).changeProperties(paramSerializationConfig, paramBasicBeanDescription, (List)localObject1);
      }
    }
    localObject2 = localObject1;
    localObject1 = sortBeanProperties(paramSerializationConfig, paramBasicBeanDescription, filterBeanProperties(paramSerializationConfig, paramBasicBeanDescription, (List)localObject2));
    if (this._factoryConfig.hasSerializerModifiers())
    {
      localIterator = this._factoryConfig.serializerModifiers().iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = ((BeanSerializerModifier)localIterator.next()).orderProperties(paramSerializationConfig, paramBasicBeanDescription, (List)localObject1);
      }
    }
    localObject2 = localObject1;
    localBeanSerializerBuilder.setProperties((List)localObject2);
    localBeanSerializerBuilder.setFilterId(findFilterId(paramSerializationConfig, paramBasicBeanDescription));
    localObject1 = paramBasicBeanDescription.findAnyGetter();
    if (localObject1 != null)
    {
      if (paramSerializationConfig.isEnabled(SerializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
        ((AnnotatedMethod)localObject1).fixAccess();
      }
      localObject2 = ((AnnotatedMethod)localObject1).getType(paramBasicBeanDescription.bindingsForBeanType());
      localBeanSerializerBuilder.setAnyGetter(new AnyGetterWriter((AnnotatedMethod)localObject1, MapSerializer.construct(null, (JavaType)localObject2, paramSerializationConfig.isEnabled(SerializationConfig.Feature.USE_STATIC_TYPING), createTypeSerializer(paramSerializationConfig, ((JavaType)localObject2).getContentType(), paramBeanProperty), paramBeanProperty, null, null)));
    }
    processViews(paramSerializationConfig, localBeanSerializerBuilder);
    if (this._factoryConfig.hasSerializerModifiers())
    {
      localObject2 = this._factoryConfig.serializerModifiers().iterator();
      for (paramBeanProperty = localBeanSerializerBuilder;; paramBeanProperty = ((BeanSerializerModifier)((Iterator)localObject2).next()).updateBuilder(paramSerializationConfig, paramBasicBeanDescription, paramBeanProperty))
      {
        localObject1 = paramBeanProperty;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
      }
    }
    localObject1 = localBeanSerializerBuilder;
    paramBeanProperty = ((BeanSerializerBuilder)localObject1).build();
    paramSerializationConfig = paramBeanProperty;
    if (paramBeanProperty == null)
    {
      paramSerializationConfig = paramBeanProperty;
      if (paramBasicBeanDescription.hasKnownClassAnnotations()) {
        paramSerializationConfig = ((BeanSerializerBuilder)localObject1).createDummy();
      }
    }
    return paramSerializationConfig;
  }
  
  protected BeanSerializerBuilder constructBeanSerializerBuilder(BasicBeanDescription paramBasicBeanDescription)
  {
    return new BeanSerializerBuilder(paramBasicBeanDescription);
  }
  
  protected BeanPropertyWriter constructFilteredBeanWriter(BeanPropertyWriter paramBeanPropertyWriter, Class[] paramArrayOfClass)
  {
    return FilteredBeanPropertyWriter.constructViewBased(paramBeanPropertyWriter, paramArrayOfClass);
  }
  
  protected PropertyBuilder constructPropertyBuilder(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription)
  {
    return new PropertyBuilder(paramSerializationConfig, paramBasicBeanDescription);
  }
  
  public JsonSerializer createKeySerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    Object localObject = null;
    JsonSerializer localJsonSerializer = null;
    if (!this._factoryConfig.hasKeySerializers()) {
      localObject = localJsonSerializer;
    }
    do
    {
      BasicBeanDescription localBasicBeanDescription;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        return (JsonSerializer)localObject;
        localBasicBeanDescription = (BasicBeanDescription)paramSerializationConfig.introspectClassAnnotations(paramJavaType.getRawClass());
        localIterator = this._factoryConfig.keySerializers().iterator();
      }
      localJsonSerializer = ((Serializers)localIterator.next()).findSerializer(paramSerializationConfig, paramJavaType, localBasicBeanDescription, paramBeanProperty);
      localObject = localJsonSerializer;
    } while (localJsonSerializer == null);
    return localJsonSerializer;
  }
  
  public JsonSerializer createSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    BasicBeanDescription localBasicBeanDescription = (BasicBeanDescription)paramSerializationConfig.introspect(paramJavaType);
    JsonSerializer localJsonSerializer = findSerializerFromAnnotation(paramSerializationConfig, localBasicBeanDescription.getClassInfo(), paramBeanProperty);
    if (localJsonSerializer != null) {
      paramJavaType = localJsonSerializer;
    }
    JavaType localJavaType;
    boolean bool;
    do
    {
      do
      {
        do
        {
          return paramJavaType;
          localJavaType = modifyTypeByAnnotation(paramSerializationConfig, localBasicBeanDescription.getClassInfo(), paramJavaType);
          if (localJavaType != paramJavaType) {}
          for (bool = true; paramJavaType.isContainerType(); bool = false) {
            return buildContainerSerializer(paramSerializationConfig, localJavaType, localBasicBeanDescription, paramBeanProperty, bool);
          }
          paramJavaType = this._factoryConfig.serializers().iterator();
          while (paramJavaType.hasNext())
          {
            localJsonSerializer = ((Serializers)paramJavaType.next()).findSerializer(paramSerializationConfig, localJavaType, localBasicBeanDescription, paramBeanProperty);
            if (localJsonSerializer != null) {
              return localJsonSerializer;
            }
          }
          localJsonSerializer = findSerializerByLookup(localJavaType, paramSerializationConfig, localBasicBeanDescription, paramBeanProperty, bool);
          paramJavaType = localJsonSerializer;
        } while (localJsonSerializer != null);
        localJsonSerializer = findSerializerByPrimaryType(localJavaType, paramSerializationConfig, localBasicBeanDescription, paramBeanProperty, bool);
        paramJavaType = localJsonSerializer;
      } while (localJsonSerializer != null);
      localJsonSerializer = findBeanSerializer(paramSerializationConfig, localJavaType, localBasicBeanDescription, paramBeanProperty);
      paramJavaType = localJsonSerializer;
    } while (localJsonSerializer != null);
    return findSerializerByAddonType(paramSerializationConfig, localJavaType, localBasicBeanDescription, paramBeanProperty, bool);
  }
  
  protected Iterable customSerializers()
  {
    return this._factoryConfig.serializers();
  }
  
  protected List filterBeanProperties(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription, List paramList)
  {
    paramSerializationConfig = paramSerializationConfig.getAnnotationIntrospector().findPropertiesToIgnore(paramBasicBeanDescription.getClassInfo());
    if ((paramSerializationConfig != null) && (paramSerializationConfig.length > 0))
    {
      paramSerializationConfig = ArrayBuilders.arrayToSet(paramSerializationConfig);
      paramBasicBeanDescription = paramList.iterator();
      while (paramBasicBeanDescription.hasNext()) {
        if (paramSerializationConfig.contains(((BeanPropertyWriter)paramBasicBeanDescription.next()).getName())) {
          paramBasicBeanDescription.remove();
        }
      }
    }
    return paramList;
  }
  
  protected List findBeanProperties(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription)
  {
    Object localObject1 = paramBasicBeanDescription.findProperties();
    AnnotationIntrospector localAnnotationIntrospector = paramSerializationConfig.getAnnotationIntrospector();
    removeIgnorableTypes(paramSerializationConfig, paramBasicBeanDescription, (List)localObject1);
    if (paramSerializationConfig.isEnabled(SerializationConfig.Feature.REQUIRE_SETTERS_FOR_GETTERS)) {
      removeSetterlessGetters(paramSerializationConfig, paramBasicBeanDescription, (List)localObject1);
    }
    if (((List)localObject1).isEmpty()) {
      return null;
    }
    boolean bool = usesStaticTyping(paramSerializationConfig, paramBasicBeanDescription, null, null);
    PropertyBuilder localPropertyBuilder = constructPropertyBuilder(paramSerializationConfig, paramBasicBeanDescription);
    ArrayList localArrayList = new ArrayList(((List)localObject1).size());
    paramBasicBeanDescription = paramBasicBeanDescription.bindingsForBeanType();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (BeanPropertyDefinition)((Iterator)localObject1).next();
      AnnotatedMember localAnnotatedMember = ((BeanPropertyDefinition)localObject2).getAccessor();
      AnnotationIntrospector.ReferenceProperty localReferenceProperty = localAnnotationIntrospector.findReferenceType(localAnnotatedMember);
      if ((localReferenceProperty == null) || (!localReferenceProperty.isBackReference()))
      {
        localObject2 = ((BeanPropertyDefinition)localObject2).getName();
        if ((localAnnotatedMember instanceof AnnotatedMethod)) {
          localArrayList.add(_constructWriter(paramSerializationConfig, paramBasicBeanDescription, localPropertyBuilder, bool, (String)localObject2, (AnnotatedMethod)localAnnotatedMember));
        } else {
          localArrayList.add(_constructWriter(paramSerializationConfig, paramBasicBeanDescription, localPropertyBuilder, bool, (String)localObject2, (AnnotatedField)localAnnotatedMember));
        }
      }
    }
    return localArrayList;
  }
  
  public JsonSerializer findBeanSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty)
  {
    if (!isPotentialBeanType(paramJavaType.getRawClass()))
    {
      paramBeanProperty = null;
      return paramBeanProperty;
    }
    paramJavaType = constructBeanSerializer(paramSerializationConfig, paramBasicBeanDescription, paramBeanProperty);
    if (this._factoryConfig.hasSerializerModifiers())
    {
      Iterator localIterator = this._factoryConfig.serializerModifiers().iterator();
      for (;;)
      {
        paramBeanProperty = paramJavaType;
        if (!localIterator.hasNext()) {
          break;
        }
        paramJavaType = ((BeanSerializerModifier)localIterator.next()).modifySerializer(paramSerializationConfig, paramBasicBeanDescription, paramJavaType);
      }
    }
    return paramJavaType;
  }
  
  protected Object findFilterId(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription)
  {
    return paramSerializationConfig.getAnnotationIntrospector().findFilterId(paramBasicBeanDescription.getClassInfo());
  }
  
  public TypeSerializer findPropertyContentTypeSerializer(JavaType paramJavaType, SerializationConfig paramSerializationConfig, AnnotatedMember paramAnnotatedMember, BeanProperty paramBeanProperty)
  {
    JavaType localJavaType = paramJavaType.getContentType();
    AnnotationIntrospector localAnnotationIntrospector = paramSerializationConfig.getAnnotationIntrospector();
    paramJavaType = localAnnotationIntrospector.findPropertyContentTypeResolver(paramSerializationConfig, paramAnnotatedMember, paramJavaType);
    if (paramJavaType == null) {
      return createTypeSerializer(paramSerializationConfig, localJavaType, paramBeanProperty);
    }
    return paramJavaType.buildTypeSerializer(paramSerializationConfig, localJavaType, paramSerializationConfig.getSubtypeResolver().collectAndResolveSubtypes(paramAnnotatedMember, paramSerializationConfig, localAnnotationIntrospector), paramBeanProperty);
  }
  
  public TypeSerializer findPropertyTypeSerializer(JavaType paramJavaType, SerializationConfig paramSerializationConfig, AnnotatedMember paramAnnotatedMember, BeanProperty paramBeanProperty)
  {
    AnnotationIntrospector localAnnotationIntrospector = paramSerializationConfig.getAnnotationIntrospector();
    TypeResolverBuilder localTypeResolverBuilder = localAnnotationIntrospector.findPropertyTypeResolver(paramSerializationConfig, paramAnnotatedMember, paramJavaType);
    if (localTypeResolverBuilder == null) {
      return createTypeSerializer(paramSerializationConfig, paramJavaType, paramBeanProperty);
    }
    return localTypeResolverBuilder.buildTypeSerializer(paramSerializationConfig, paramJavaType, paramSerializationConfig.getSubtypeResolver().collectAndResolveSubtypes(paramAnnotatedMember, paramSerializationConfig, localAnnotationIntrospector), paramBeanProperty);
  }
  
  public SerializerFactory.Config getConfig()
  {
    return this._factoryConfig;
  }
  
  protected boolean isPotentialBeanType(Class paramClass)
  {
    return (ClassUtil.canBeABeanType(paramClass) == null) && (!ClassUtil.isProxyType(paramClass));
  }
  
  protected void processViews(SerializationConfig paramSerializationConfig, BeanSerializerBuilder paramBeanSerializerBuilder)
  {
    List localList = paramBeanSerializerBuilder.getProperties();
    boolean bool = paramSerializationConfig.isEnabled(SerializationConfig.Feature.DEFAULT_VIEW_INCLUSION);
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
  
  protected void removeIgnorableTypes(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription, List paramList)
  {
    AnnotationIntrospector localAnnotationIntrospector = paramSerializationConfig.getAnnotationIntrospector();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramBasicBeanDescription = ((BeanPropertyDefinition)localIterator.next()).getAccessor();
      if (paramBasicBeanDescription == null)
      {
        localIterator.remove();
      }
      else
      {
        Class localClass = paramBasicBeanDescription.getRawType();
        paramList = (Boolean)localHashMap.get(localClass);
        paramBasicBeanDescription = paramList;
        if (paramList == null)
        {
          paramList = localAnnotationIntrospector.isIgnorableType(((BasicBeanDescription)paramSerializationConfig.introspectClassAnnotations(localClass)).getClassInfo());
          paramBasicBeanDescription = paramList;
          if (paramList == null) {
            paramBasicBeanDescription = Boolean.FALSE;
          }
          localHashMap.put(localClass, paramBasicBeanDescription);
        }
        if (paramBasicBeanDescription.booleanValue()) {
          localIterator.remove();
        }
      }
    }
  }
  
  protected void removeSetterlessGetters(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription, List paramList)
  {
    paramSerializationConfig = paramList.iterator();
    while (paramSerializationConfig.hasNext()) {
      if (!((BeanPropertyDefinition)paramSerializationConfig.next()).couldDeserialize()) {
        paramSerializationConfig.remove();
      }
    }
  }
  
  @Deprecated
  protected List sortBeanProperties(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription, List paramList)
  {
    return paramList;
  }
  
  public SerializerFactory withConfig(SerializerFactory.Config paramConfig)
  {
    if (this._factoryConfig == paramConfig) {
      return this;
    }
    if (getClass() != BeanSerializerFactory.class) {
      throw new IllegalStateException("Subtype of BeanSerializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalSerializers': can not instantiate subtype with " + "additional serializer definitions");
    }
    return new BeanSerializerFactory(paramConfig);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/BeanSerializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */