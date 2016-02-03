package org.codehaus.jackson.map;

import java.text.DateFormat;
import java.util.HashMap;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.annotate.JsonSerialize.Typing;
import org.codehaus.jackson.map.introspect.Annotated;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.jsontype.SubtypeResolver;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

public class SerializationConfig
  extends MapperConfig.Impl
{
  protected FilterProvider _filterProvider;
  protected JsonSerialize.Inclusion _serializationInclusion = null;
  protected Class _serializationView;
  
  public SerializationConfig(ClassIntrospector paramClassIntrospector, AnnotationIntrospector paramAnnotationIntrospector, VisibilityChecker paramVisibilityChecker, SubtypeResolver paramSubtypeResolver, PropertyNamingStrategy paramPropertyNamingStrategy, TypeFactory paramTypeFactory, HandlerInstantiator paramHandlerInstantiator)
  {
    super(paramClassIntrospector, paramAnnotationIntrospector, paramVisibilityChecker, paramSubtypeResolver, paramPropertyNamingStrategy, paramTypeFactory, paramHandlerInstantiator, collectFeatureDefaults(SerializationConfig.Feature.class));
    this._filterProvider = null;
  }
  
  protected SerializationConfig(SerializationConfig paramSerializationConfig)
  {
    this(paramSerializationConfig, paramSerializationConfig._base);
  }
  
  protected SerializationConfig(SerializationConfig paramSerializationConfig, int paramInt)
  {
    super(paramSerializationConfig, paramInt);
    this._serializationInclusion = paramSerializationConfig._serializationInclusion;
    this._serializationView = paramSerializationConfig._serializationView;
    this._filterProvider = paramSerializationConfig._filterProvider;
  }
  
  protected SerializationConfig(SerializationConfig paramSerializationConfig, Class paramClass)
  {
    super(paramSerializationConfig);
    this._serializationInclusion = paramSerializationConfig._serializationInclusion;
    this._serializationView = paramClass;
    this._filterProvider = paramSerializationConfig._filterProvider;
  }
  
  protected SerializationConfig(SerializationConfig paramSerializationConfig, HashMap paramHashMap, SubtypeResolver paramSubtypeResolver)
  {
    this(paramSerializationConfig, paramSerializationConfig._base);
    this._mixInAnnotations = paramHashMap;
    this._subtypeResolver = paramSubtypeResolver;
  }
  
  protected SerializationConfig(SerializationConfig paramSerializationConfig, MapperConfig.Base paramBase)
  {
    super(paramSerializationConfig, paramBase, paramSerializationConfig._subtypeResolver);
    this._serializationInclusion = paramSerializationConfig._serializationInclusion;
    this._serializationView = paramSerializationConfig._serializationView;
    this._filterProvider = paramSerializationConfig._filterProvider;
  }
  
  protected SerializationConfig(SerializationConfig paramSerializationConfig, JsonSerialize.Inclusion paramInclusion)
  {
    super(paramSerializationConfig);
    this._serializationInclusion = paramInclusion;
    if (paramInclusion == JsonSerialize.Inclusion.NON_NULL) {}
    for (this._featureFlags &= (SerializationConfig.Feature.WRITE_NULL_PROPERTIES.getMask() ^ 0xFFFFFFFF);; this._featureFlags |= SerializationConfig.Feature.WRITE_NULL_PROPERTIES.getMask())
    {
      this._serializationView = paramSerializationConfig._serializationView;
      this._filterProvider = paramSerializationConfig._filterProvider;
      return;
    }
  }
  
  protected SerializationConfig(SerializationConfig paramSerializationConfig, FilterProvider paramFilterProvider)
  {
    super(paramSerializationConfig);
    this._serializationInclusion = paramSerializationConfig._serializationInclusion;
    this._serializationView = paramSerializationConfig._serializationView;
    this._filterProvider = paramFilterProvider;
  }
  
  public boolean canOverrideAccessModifiers()
  {
    return isEnabled(SerializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS);
  }
  
  public SerializationConfig createUnshared(SubtypeResolver paramSubtypeResolver)
  {
    HashMap localHashMap = this._mixInAnnotations;
    this._mixInAnnotationsShared = true;
    return new SerializationConfig(this, localHashMap, paramSubtypeResolver);
  }
  
  @Deprecated
  public void disable(SerializationConfig.Feature paramFeature)
  {
    super.disable(paramFeature);
  }
  
  @Deprecated
  public void enable(SerializationConfig.Feature paramFeature)
  {
    super.enable(paramFeature);
  }
  
  @Deprecated
  public void fromAnnotations(Class paramClass)
  {
    Object localObject = getAnnotationIntrospector();
    paramClass = AnnotatedClass.construct(paramClass, (AnnotationIntrospector)localObject, null);
    this._base = this._base.withVisibilityChecker(((AnnotationIntrospector)localObject).findAutoDetectVisibility(paramClass, getDefaultVisibilityChecker()));
    JsonSerialize.Inclusion localInclusion = ((AnnotationIntrospector)localObject).findSerializationInclusion(paramClass, null);
    if (localInclusion != this._serializationInclusion) {
      setSerializationInclusion(localInclusion);
    }
    paramClass = ((AnnotationIntrospector)localObject).findSerializationTyping(paramClass);
    if (paramClass != null)
    {
      localObject = SerializationConfig.Feature.USE_STATIC_TYPING;
      if (paramClass != JsonSerialize.Typing.STATIC) {
        break label85;
      }
    }
    label85:
    for (boolean bool = true;; bool = false)
    {
      set((SerializationConfig.Feature)localObject, bool);
      return;
    }
  }
  
  public AnnotationIntrospector getAnnotationIntrospector()
  {
    if (isEnabled(SerializationConfig.Feature.USE_ANNOTATIONS)) {
      return super.getAnnotationIntrospector();
    }
    return AnnotationIntrospector.nopInstance();
  }
  
  public VisibilityChecker getDefaultVisibilityChecker()
  {
    Object localObject2 = super.getDefaultVisibilityChecker();
    Object localObject1 = localObject2;
    if (!isEnabled(SerializationConfig.Feature.AUTO_DETECT_GETTERS)) {
      localObject1 = ((VisibilityChecker)localObject2).withGetterVisibility(JsonAutoDetect.Visibility.NONE);
    }
    localObject2 = localObject1;
    if (!isEnabled(SerializationConfig.Feature.AUTO_DETECT_IS_GETTERS)) {
      localObject2 = ((VisibilityChecker)localObject1).withIsGetterVisibility(JsonAutoDetect.Visibility.NONE);
    }
    localObject1 = localObject2;
    if (!isEnabled(SerializationConfig.Feature.AUTO_DETECT_FIELDS)) {
      localObject1 = ((VisibilityChecker)localObject2).withFieldVisibility(JsonAutoDetect.Visibility.NONE);
    }
    return (VisibilityChecker)localObject1;
  }
  
  public FilterProvider getFilterProvider()
  {
    return this._filterProvider;
  }
  
  public JsonSerialize.Inclusion getSerializationInclusion()
  {
    if (this._serializationInclusion != null) {
      return this._serializationInclusion;
    }
    if (isEnabled(SerializationConfig.Feature.WRITE_NULL_PROPERTIES)) {
      return JsonSerialize.Inclusion.ALWAYS;
    }
    return JsonSerialize.Inclusion.NON_NULL;
  }
  
  public Class getSerializationView()
  {
    return this._serializationView;
  }
  
  public BeanDescription introspect(JavaType paramJavaType)
  {
    return getClassIntrospector().forSerialization(this, paramJavaType, this);
  }
  
  public BeanDescription introspectClassAnnotations(JavaType paramJavaType)
  {
    return getClassIntrospector().forClassAnnotations(this, paramJavaType, this);
  }
  
  public BeanDescription introspectDirectClassAnnotations(JavaType paramJavaType)
  {
    return getClassIntrospector().forDirectClassAnnotations(this, paramJavaType, this);
  }
  
  public boolean isAnnotationProcessingEnabled()
  {
    return isEnabled(SerializationConfig.Feature.USE_ANNOTATIONS);
  }
  
  public boolean isEnabled(SerializationConfig.Feature paramFeature)
  {
    return (this._featureFlags & paramFeature.getMask()) != 0;
  }
  
  public JsonSerializer serializerInstance(Annotated paramAnnotated, Class paramClass)
  {
    HandlerInstantiator localHandlerInstantiator = getHandlerInstantiator();
    if (localHandlerInstantiator != null)
    {
      paramAnnotated = localHandlerInstantiator.serializerInstance(this, paramAnnotated, paramClass);
      if (paramAnnotated != null) {
        return paramAnnotated;
      }
    }
    return (JsonSerializer)ClassUtil.createInstance(paramClass, canOverrideAccessModifiers());
  }
  
  @Deprecated
  public void set(SerializationConfig.Feature paramFeature, boolean paramBoolean)
  {
    super.set(paramFeature, paramBoolean);
  }
  
  @Deprecated
  public final void setDateFormat(DateFormat paramDateFormat)
  {
    super.setDateFormat(paramDateFormat);
    SerializationConfig.Feature localFeature = SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS;
    if (paramDateFormat == null) {}
    for (boolean bool = true;; bool = false)
    {
      set(localFeature, bool);
      return;
    }
  }
  
  @Deprecated
  public void setSerializationInclusion(JsonSerialize.Inclusion paramInclusion)
  {
    this._serializationInclusion = paramInclusion;
    if (paramInclusion == JsonSerialize.Inclusion.NON_NULL)
    {
      disable(SerializationConfig.Feature.WRITE_NULL_PROPERTIES);
      return;
    }
    enable(SerializationConfig.Feature.WRITE_NULL_PROPERTIES);
  }
  
  @Deprecated
  public void setSerializationView(Class paramClass)
  {
    this._serializationView = paramClass;
  }
  
  public boolean shouldSortPropertiesAlphabetically()
  {
    return isEnabled(SerializationConfig.Feature.SORT_PROPERTIES_ALPHABETICALLY);
  }
  
  public String toString()
  {
    return "[SerializationConfig: flags=0x" + Integer.toHexString(this._featureFlags) + "]";
  }
  
  public SerializationConfig with(SerializationConfig.Feature... paramVarArgs)
  {
    int j = this._featureFlags;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j |= paramVarArgs[i].getMask();
      i += 1;
    }
    return new SerializationConfig(this, j);
  }
  
  public SerializationConfig withAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    return new SerializationConfig(this, this._base.withAnnotationIntrospector(paramAnnotationIntrospector));
  }
  
  public SerializationConfig withAppendedAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    return new SerializationConfig(this, this._base.withAppendedAnnotationIntrospector(paramAnnotationIntrospector));
  }
  
  public SerializationConfig withClassIntrospector(ClassIntrospector paramClassIntrospector)
  {
    return new SerializationConfig(this, this._base.withClassIntrospector(paramClassIntrospector));
  }
  
  public SerializationConfig withDateFormat(DateFormat paramDateFormat)
  {
    SerializationConfig localSerializationConfig = new SerializationConfig(this, this._base.withDateFormat(paramDateFormat));
    if (paramDateFormat == null) {
      return localSerializationConfig.with(new SerializationConfig.Feature[] { SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS });
    }
    return localSerializationConfig.without(new SerializationConfig.Feature[] { SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS });
  }
  
  public SerializationConfig withFilters(FilterProvider paramFilterProvider)
  {
    return new SerializationConfig(this, paramFilterProvider);
  }
  
  public SerializationConfig withHandlerInstantiator(HandlerInstantiator paramHandlerInstantiator)
  {
    return new SerializationConfig(this, this._base.withHandlerInstantiator(paramHandlerInstantiator));
  }
  
  public SerializationConfig withInsertedAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    return new SerializationConfig(this, this._base.withInsertedAnnotationIntrospector(paramAnnotationIntrospector));
  }
  
  public SerializationConfig withPropertyNamingStrategy(PropertyNamingStrategy paramPropertyNamingStrategy)
  {
    return new SerializationConfig(this, this._base.withPropertyNamingStrategy(paramPropertyNamingStrategy));
  }
  
  public SerializationConfig withSerializationInclusion(JsonSerialize.Inclusion paramInclusion)
  {
    return new SerializationConfig(this, paramInclusion);
  }
  
  public SerializationConfig withSubtypeResolver(SubtypeResolver paramSubtypeResolver)
  {
    SerializationConfig localSerializationConfig = new SerializationConfig(this);
    localSerializationConfig._subtypeResolver = paramSubtypeResolver;
    return localSerializationConfig;
  }
  
  public SerializationConfig withTypeFactory(TypeFactory paramTypeFactory)
  {
    return new SerializationConfig(this, this._base.withTypeFactory(paramTypeFactory));
  }
  
  public SerializationConfig withTypeResolverBuilder(TypeResolverBuilder paramTypeResolverBuilder)
  {
    return new SerializationConfig(this, this._base.withTypeResolverBuilder(paramTypeResolverBuilder));
  }
  
  public SerializationConfig withView(Class paramClass)
  {
    return new SerializationConfig(this, paramClass);
  }
  
  public SerializationConfig withVisibility(JsonMethod paramJsonMethod, JsonAutoDetect.Visibility paramVisibility)
  {
    return new SerializationConfig(this, this._base.withVisibility(paramJsonMethod, paramVisibility));
  }
  
  public SerializationConfig withVisibilityChecker(VisibilityChecker paramVisibilityChecker)
  {
    return new SerializationConfig(this, this._base.withVisibilityChecker(paramVisibilityChecker));
  }
  
  public SerializationConfig without(SerializationConfig.Feature... paramVarArgs)
  {
    int j = this._featureFlags;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j &= (paramVarArgs[i].getMask() ^ 0xFFFFFFFF);
      i += 1;
    }
    return new SerializationConfig(this, j);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/SerializationConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */