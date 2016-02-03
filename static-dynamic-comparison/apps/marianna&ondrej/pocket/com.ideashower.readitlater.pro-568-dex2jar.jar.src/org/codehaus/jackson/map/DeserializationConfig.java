package org.codehaus.jackson.map;

import java.text.DateFormat;
import java.util.HashMap;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.Base64Variants;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.deser.ValueInstantiator;
import org.codehaus.jackson.map.introspect.Annotated;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.NopAnnotationIntrospector;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.jsontype.SubtypeResolver;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.map.util.LinkedNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.type.JavaType;

public class DeserializationConfig
  extends MapperConfig.Impl
{
  protected final JsonNodeFactory _nodeFactory;
  protected LinkedNode _problemHandlers;
  protected boolean _sortPropertiesAlphabetically;
  
  public DeserializationConfig(ClassIntrospector paramClassIntrospector, AnnotationIntrospector paramAnnotationIntrospector, VisibilityChecker paramVisibilityChecker, SubtypeResolver paramSubtypeResolver, PropertyNamingStrategy paramPropertyNamingStrategy, TypeFactory paramTypeFactory, HandlerInstantiator paramHandlerInstantiator)
  {
    super(paramClassIntrospector, paramAnnotationIntrospector, paramVisibilityChecker, paramSubtypeResolver, paramPropertyNamingStrategy, paramTypeFactory, paramHandlerInstantiator, collectFeatureDefaults(DeserializationConfig.Feature.class));
    this._nodeFactory = JsonNodeFactory.instance;
  }
  
  protected DeserializationConfig(DeserializationConfig paramDeserializationConfig)
  {
    this(paramDeserializationConfig, paramDeserializationConfig._base);
  }
  
  protected DeserializationConfig(DeserializationConfig paramDeserializationConfig, int paramInt)
  {
    super(paramDeserializationConfig, paramInt);
    this._problemHandlers = paramDeserializationConfig._problemHandlers;
    this._nodeFactory = paramDeserializationConfig._nodeFactory;
    this._sortPropertiesAlphabetically = paramDeserializationConfig._sortPropertiesAlphabetically;
  }
  
  private DeserializationConfig(DeserializationConfig paramDeserializationConfig, HashMap paramHashMap, SubtypeResolver paramSubtypeResolver)
  {
    this(paramDeserializationConfig, paramDeserializationConfig._base);
    this._mixInAnnotations = paramHashMap;
    this._subtypeResolver = paramSubtypeResolver;
  }
  
  protected DeserializationConfig(DeserializationConfig paramDeserializationConfig, MapperConfig.Base paramBase)
  {
    super(paramDeserializationConfig, paramBase, paramDeserializationConfig._subtypeResolver);
    this._problemHandlers = paramDeserializationConfig._problemHandlers;
    this._nodeFactory = paramDeserializationConfig._nodeFactory;
    this._sortPropertiesAlphabetically = paramDeserializationConfig._sortPropertiesAlphabetically;
  }
  
  protected DeserializationConfig(DeserializationConfig paramDeserializationConfig, JsonNodeFactory paramJsonNodeFactory)
  {
    super(paramDeserializationConfig);
    this._problemHandlers = paramDeserializationConfig._problemHandlers;
    this._nodeFactory = paramJsonNodeFactory;
    this._sortPropertiesAlphabetically = paramDeserializationConfig._sortPropertiesAlphabetically;
  }
  
  public void addHandler(DeserializationProblemHandler paramDeserializationProblemHandler)
  {
    if (!LinkedNode.contains(this._problemHandlers, paramDeserializationProblemHandler)) {
      this._problemHandlers = new LinkedNode(paramDeserializationProblemHandler, this._problemHandlers);
    }
  }
  
  public boolean canOverrideAccessModifiers()
  {
    return isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS);
  }
  
  public void clearHandlers()
  {
    this._problemHandlers = null;
  }
  
  public DeserializationConfig createUnshared(SubtypeResolver paramSubtypeResolver)
  {
    HashMap localHashMap = this._mixInAnnotations;
    this._mixInAnnotationsShared = true;
    return new DeserializationConfig(this, localHashMap, paramSubtypeResolver);
  }
  
  public JsonDeserializer deserializerInstance(Annotated paramAnnotated, Class paramClass)
  {
    HandlerInstantiator localHandlerInstantiator = getHandlerInstantiator();
    if (localHandlerInstantiator != null)
    {
      paramAnnotated = localHandlerInstantiator.deserializerInstance(this, paramAnnotated, paramClass);
      if (paramAnnotated != null) {
        return paramAnnotated;
      }
    }
    return (JsonDeserializer)ClassUtil.createInstance(paramClass, canOverrideAccessModifiers());
  }
  
  @Deprecated
  public void disable(DeserializationConfig.Feature paramFeature)
  {
    super.disable(paramFeature);
  }
  
  @Deprecated
  public void enable(DeserializationConfig.Feature paramFeature)
  {
    super.enable(paramFeature);
  }
  
  @Deprecated
  public void fromAnnotations(Class paramClass)
  {
    AnnotationIntrospector localAnnotationIntrospector = getAnnotationIntrospector();
    paramClass = AnnotatedClass.construct(paramClass, localAnnotationIntrospector, null);
    VisibilityChecker localVisibilityChecker = getDefaultVisibilityChecker();
    this._base = this._base.withVisibilityChecker(localAnnotationIntrospector.findAutoDetectVisibility(paramClass, localVisibilityChecker));
  }
  
  public AnnotationIntrospector getAnnotationIntrospector()
  {
    if (isEnabled(DeserializationConfig.Feature.USE_ANNOTATIONS)) {
      return super.getAnnotationIntrospector();
    }
    return NopAnnotationIntrospector.instance;
  }
  
  public Base64Variant getBase64Variant()
  {
    return Base64Variants.getDefaultVariant();
  }
  
  public VisibilityChecker getDefaultVisibilityChecker()
  {
    Object localObject2 = super.getDefaultVisibilityChecker();
    Object localObject1 = localObject2;
    if (!isEnabled(DeserializationConfig.Feature.AUTO_DETECT_SETTERS)) {
      localObject1 = ((VisibilityChecker)localObject2).withSetterVisibility(JsonAutoDetect.Visibility.NONE);
    }
    localObject2 = localObject1;
    if (!isEnabled(DeserializationConfig.Feature.AUTO_DETECT_CREATORS)) {
      localObject2 = ((VisibilityChecker)localObject1).withCreatorVisibility(JsonAutoDetect.Visibility.NONE);
    }
    localObject1 = localObject2;
    if (!isEnabled(DeserializationConfig.Feature.AUTO_DETECT_FIELDS)) {
      localObject1 = ((VisibilityChecker)localObject2).withFieldVisibility(JsonAutoDetect.Visibility.NONE);
    }
    return (VisibilityChecker)localObject1;
  }
  
  public final JsonNodeFactory getNodeFactory()
  {
    return this._nodeFactory;
  }
  
  public LinkedNode getProblemHandlers()
  {
    return this._problemHandlers;
  }
  
  public BeanDescription introspect(JavaType paramJavaType)
  {
    return getClassIntrospector().forDeserialization(this, paramJavaType, this);
  }
  
  public BeanDescription introspectClassAnnotations(JavaType paramJavaType)
  {
    return getClassIntrospector().forClassAnnotations(this, paramJavaType, this);
  }
  
  public BeanDescription introspectDirectClassAnnotations(JavaType paramJavaType)
  {
    return getClassIntrospector().forDirectClassAnnotations(this, paramJavaType, this);
  }
  
  public BeanDescription introspectForCreation(JavaType paramJavaType)
  {
    return getClassIntrospector().forCreation(this, paramJavaType, this);
  }
  
  public boolean isAnnotationProcessingEnabled()
  {
    return isEnabled(DeserializationConfig.Feature.USE_ANNOTATIONS);
  }
  
  public boolean isEnabled(DeserializationConfig.Feature paramFeature)
  {
    return (this._featureFlags & paramFeature.getMask()) != 0;
  }
  
  public KeyDeserializer keyDeserializerInstance(Annotated paramAnnotated, Class paramClass)
  {
    HandlerInstantiator localHandlerInstantiator = getHandlerInstantiator();
    if (localHandlerInstantiator != null)
    {
      paramAnnotated = localHandlerInstantiator.keyDeserializerInstance(this, paramAnnotated, paramClass);
      if (paramAnnotated != null) {
        return paramAnnotated;
      }
    }
    return (KeyDeserializer)ClassUtil.createInstance(paramClass, canOverrideAccessModifiers());
  }
  
  protected DeserializationConfig passSerializationFeatures(int paramInt)
  {
    if ((SerializationConfig.Feature.SORT_PROPERTIES_ALPHABETICALLY.getMask() & paramInt) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this._sortPropertiesAlphabetically = bool;
      return this;
    }
  }
  
  @Deprecated
  public void set(DeserializationConfig.Feature paramFeature, boolean paramBoolean)
  {
    super.set(paramFeature, paramBoolean);
  }
  
  public boolean shouldSortPropertiesAlphabetically()
  {
    return this._sortPropertiesAlphabetically;
  }
  
  public ValueInstantiator valueInstantiatorInstance(Annotated paramAnnotated, Class paramClass)
  {
    HandlerInstantiator localHandlerInstantiator = getHandlerInstantiator();
    if (localHandlerInstantiator != null)
    {
      paramAnnotated = localHandlerInstantiator.valueInstantiatorInstance(this, paramAnnotated, paramClass);
      if (paramAnnotated != null) {
        return paramAnnotated;
      }
    }
    return (ValueInstantiator)ClassUtil.createInstance(paramClass, canOverrideAccessModifiers());
  }
  
  public DeserializationConfig with(DeserializationConfig.Feature... paramVarArgs)
  {
    int j = this._featureFlags;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j |= paramVarArgs[i].getMask();
      i += 1;
    }
    return new DeserializationConfig(this, j);
  }
  
  public DeserializationConfig withAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    return new DeserializationConfig(this, this._base.withAnnotationIntrospector(paramAnnotationIntrospector));
  }
  
  public DeserializationConfig withAppendedAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    return new DeserializationConfig(this, this._base.withAppendedAnnotationIntrospector(paramAnnotationIntrospector));
  }
  
  public DeserializationConfig withClassIntrospector(ClassIntrospector paramClassIntrospector)
  {
    return new DeserializationConfig(this, this._base.withClassIntrospector(paramClassIntrospector));
  }
  
  public DeserializationConfig withDateFormat(DateFormat paramDateFormat)
  {
    if (paramDateFormat == this._base.getDateFormat()) {
      return this;
    }
    return new DeserializationConfig(this, this._base.withDateFormat(paramDateFormat));
  }
  
  public DeserializationConfig withHandlerInstantiator(HandlerInstantiator paramHandlerInstantiator)
  {
    if (paramHandlerInstantiator == this._base.getHandlerInstantiator()) {
      return this;
    }
    return new DeserializationConfig(this, this._base.withHandlerInstantiator(paramHandlerInstantiator));
  }
  
  public DeserializationConfig withInsertedAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    return new DeserializationConfig(this, this._base.withInsertedAnnotationIntrospector(paramAnnotationIntrospector));
  }
  
  public DeserializationConfig withNodeFactory(JsonNodeFactory paramJsonNodeFactory)
  {
    return new DeserializationConfig(this, paramJsonNodeFactory);
  }
  
  public DeserializationConfig withPropertyNamingStrategy(PropertyNamingStrategy paramPropertyNamingStrategy)
  {
    return new DeserializationConfig(this, this._base.withPropertyNamingStrategy(paramPropertyNamingStrategy));
  }
  
  public DeserializationConfig withSubtypeResolver(SubtypeResolver paramSubtypeResolver)
  {
    DeserializationConfig localDeserializationConfig = new DeserializationConfig(this);
    localDeserializationConfig._subtypeResolver = paramSubtypeResolver;
    return localDeserializationConfig;
  }
  
  public DeserializationConfig withTypeFactory(TypeFactory paramTypeFactory)
  {
    if (paramTypeFactory == this._base.getTypeFactory()) {
      return this;
    }
    return new DeserializationConfig(this, this._base.withTypeFactory(paramTypeFactory));
  }
  
  public DeserializationConfig withTypeResolverBuilder(TypeResolverBuilder paramTypeResolverBuilder)
  {
    return new DeserializationConfig(this, this._base.withTypeResolverBuilder(paramTypeResolverBuilder));
  }
  
  public DeserializationConfig withVisibility(JsonMethod paramJsonMethod, JsonAutoDetect.Visibility paramVisibility)
  {
    return new DeserializationConfig(this, this._base.withVisibility(paramJsonMethod, paramVisibility));
  }
  
  public DeserializationConfig withVisibilityChecker(VisibilityChecker paramVisibilityChecker)
  {
    return new DeserializationConfig(this, this._base.withVisibilityChecker(paramVisibilityChecker));
  }
  
  public DeserializationConfig without(DeserializationConfig.Feature... paramVarArgs)
  {
    int j = this._featureFlags;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j &= (paramVarArgs[i].getMask() ^ 0xFFFFFFFF);
      i += 1;
    }
    return new DeserializationConfig(this, j);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/DeserializationConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */