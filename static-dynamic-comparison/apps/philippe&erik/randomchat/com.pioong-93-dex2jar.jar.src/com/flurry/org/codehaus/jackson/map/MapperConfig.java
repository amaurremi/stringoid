package com.flurry.org.codehaus.jackson.map;

import com.flurry.org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import com.flurry.org.codehaus.jackson.annotate.JsonMethod;
import com.flurry.org.codehaus.jackson.map.introspect.Annotated;
import com.flurry.org.codehaus.jackson.map.introspect.VisibilityChecker;
import com.flurry.org.codehaus.jackson.map.jsontype.SubtypeResolver;
import com.flurry.org.codehaus.jackson.map.jsontype.TypeIdResolver;
import com.flurry.org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import com.flurry.org.codehaus.jackson.map.jsontype.impl.StdSubtypeResolver;
import com.flurry.org.codehaus.jackson.map.type.ClassKey;
import com.flurry.org.codehaus.jackson.map.type.TypeBindings;
import com.flurry.org.codehaus.jackson.map.type.TypeFactory;
import com.flurry.org.codehaus.jackson.map.util.ClassUtil;
import com.flurry.org.codehaus.jackson.map.util.StdDateFormat;
import com.flurry.org.codehaus.jackson.type.JavaType;
import com.flurry.org.codehaus.jackson.type.TypeReference;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class MapperConfig<T extends MapperConfig<T>>
  implements ClassIntrospector.MixInResolver
{
  protected static final DateFormat DEFAULT_DATE_FORMAT = StdDateFormat.instance;
  protected Base _base;
  protected HashMap<ClassKey, Class<?>> _mixInAnnotations;
  protected boolean _mixInAnnotationsShared;
  protected SubtypeResolver _subtypeResolver;
  
  protected MapperConfig(ClassIntrospector<? extends BeanDescription> paramClassIntrospector, AnnotationIntrospector paramAnnotationIntrospector, VisibilityChecker<?> paramVisibilityChecker, SubtypeResolver paramSubtypeResolver, PropertyNamingStrategy paramPropertyNamingStrategy, TypeFactory paramTypeFactory, HandlerInstantiator paramHandlerInstantiator)
  {
    this._base = new Base(paramClassIntrospector, paramAnnotationIntrospector, paramVisibilityChecker, paramPropertyNamingStrategy, paramTypeFactory, null, DEFAULT_DATE_FORMAT, paramHandlerInstantiator);
    this._subtypeResolver = paramSubtypeResolver;
    this._mixInAnnotationsShared = true;
  }
  
  protected MapperConfig(MapperConfig<T> paramMapperConfig)
  {
    this(paramMapperConfig, paramMapperConfig._base, paramMapperConfig._subtypeResolver);
  }
  
  protected MapperConfig(MapperConfig<T> paramMapperConfig, Base paramBase, SubtypeResolver paramSubtypeResolver)
  {
    this._base = paramBase;
    this._subtypeResolver = paramSubtypeResolver;
    this._mixInAnnotationsShared = true;
    this._mixInAnnotations = paramMapperConfig._mixInAnnotations;
  }
  
  public final void addMixInAnnotations(Class<?> paramClass1, Class<?> paramClass2)
  {
    if (this._mixInAnnotations == null)
    {
      this._mixInAnnotationsShared = false;
      this._mixInAnnotations = new HashMap();
    }
    for (;;)
    {
      this._mixInAnnotations.put(new ClassKey(paramClass1), paramClass2);
      return;
      if (this._mixInAnnotationsShared)
      {
        this._mixInAnnotationsShared = false;
        this._mixInAnnotations = new HashMap(this._mixInAnnotations);
      }
    }
  }
  
  @Deprecated
  public final void appendAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    this._base = this._base.withAnnotationIntrospector(AnnotationIntrospector.Pair.create(getAnnotationIntrospector(), paramAnnotationIntrospector));
  }
  
  public abstract boolean canOverrideAccessModifiers();
  
  public JavaType constructSpecializedType(JavaType paramJavaType, Class<?> paramClass)
  {
    return getTypeFactory().constructSpecializedType(paramJavaType, paramClass);
  }
  
  public final JavaType constructType(TypeReference<?> paramTypeReference)
  {
    return getTypeFactory().constructType(paramTypeReference.getType(), (TypeBindings)null);
  }
  
  public final JavaType constructType(Class<?> paramClass)
  {
    return getTypeFactory().constructType(paramClass, (TypeBindings)null);
  }
  
  public abstract T createUnshared(SubtypeResolver paramSubtypeResolver);
  
  public final Class<?> findMixInClassFor(Class<?> paramClass)
  {
    if (this._mixInAnnotations == null) {
      return null;
    }
    return (Class)this._mixInAnnotations.get(new ClassKey(paramClass));
  }
  
  @Deprecated
  public abstract void fromAnnotations(Class<?> paramClass);
  
  public AnnotationIntrospector getAnnotationIntrospector()
  {
    return this._base.getAnnotationIntrospector();
  }
  
  public ClassIntrospector<? extends BeanDescription> getClassIntrospector()
  {
    return this._base.getClassIntrospector();
  }
  
  public final DateFormat getDateFormat()
  {
    return this._base.getDateFormat();
  }
  
  public final TypeResolverBuilder<?> getDefaultTyper(JavaType paramJavaType)
  {
    return this._base.getTypeResolverBuilder();
  }
  
  public VisibilityChecker<?> getDefaultVisibilityChecker()
  {
    return this._base.getVisibilityChecker();
  }
  
  public final HandlerInstantiator getHandlerInstantiator()
  {
    return this._base.getHandlerInstantiator();
  }
  
  public final PropertyNamingStrategy getPropertyNamingStrategy()
  {
    return this._base.getPropertyNamingStrategy();
  }
  
  public final SubtypeResolver getSubtypeResolver()
  {
    if (this._subtypeResolver == null) {
      this._subtypeResolver = new StdSubtypeResolver();
    }
    return this._subtypeResolver;
  }
  
  public final TypeFactory getTypeFactory()
  {
    return this._base.getTypeFactory();
  }
  
  @Deprecated
  public final void insertAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    this._base = this._base.withAnnotationIntrospector(AnnotationIntrospector.Pair.create(paramAnnotationIntrospector, getAnnotationIntrospector()));
  }
  
  public abstract <DESC extends BeanDescription> DESC introspectClassAnnotations(JavaType paramJavaType);
  
  public <DESC extends BeanDescription> DESC introspectClassAnnotations(Class<?> paramClass)
  {
    return introspectClassAnnotations(constructType(paramClass));
  }
  
  public abstract <DESC extends BeanDescription> DESC introspectDirectClassAnnotations(JavaType paramJavaType);
  
  public <DESC extends BeanDescription> DESC introspectDirectClassAnnotations(Class<?> paramClass)
  {
    return introspectDirectClassAnnotations(constructType(paramClass));
  }
  
  public abstract boolean isAnnotationProcessingEnabled();
  
  public abstract boolean isEnabled(ConfigFeature paramConfigFeature);
  
  public final int mixInCount()
  {
    if (this._mixInAnnotations == null) {
      return 0;
    }
    return this._mixInAnnotations.size();
  }
  
  @Deprecated
  public final void setAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
  {
    this._base = this._base.withAnnotationIntrospector(paramAnnotationIntrospector);
  }
  
  @Deprecated
  public void setDateFormat(DateFormat paramDateFormat)
  {
    DateFormat localDateFormat = paramDateFormat;
    if (paramDateFormat == null) {
      localDateFormat = DEFAULT_DATE_FORMAT;
    }
    this._base = this._base.withDateFormat(localDateFormat);
  }
  
  public final void setMixInAnnotations(Map<Class<?>, Class<?>> paramMap)
  {
    HashMap localHashMap = null;
    Object localObject = localHashMap;
    if (paramMap != null)
    {
      localObject = localHashMap;
      if (paramMap.size() > 0)
      {
        localHashMap = new HashMap(paramMap.size());
        paramMap = paramMap.entrySet().iterator();
        for (;;)
        {
          localObject = localHashMap;
          if (!paramMap.hasNext()) {
            break;
          }
          localObject = (Map.Entry)paramMap.next();
          localHashMap.put(new ClassKey((Class)((Map.Entry)localObject).getKey()), ((Map.Entry)localObject).getValue());
        }
      }
    }
    this._mixInAnnotationsShared = false;
    this._mixInAnnotations = ((HashMap)localObject);
  }
  
  public abstract boolean shouldSortPropertiesAlphabetically();
  
  public TypeIdResolver typeIdResolverInstance(Annotated paramAnnotated, Class<? extends TypeIdResolver> paramClass)
  {
    HandlerInstantiator localHandlerInstantiator = getHandlerInstantiator();
    if (localHandlerInstantiator != null)
    {
      paramAnnotated = localHandlerInstantiator.typeIdResolverInstance(this, paramAnnotated, paramClass);
      if (paramAnnotated != null) {
        return paramAnnotated;
      }
    }
    return (TypeIdResolver)ClassUtil.createInstance(paramClass, canOverrideAccessModifiers());
  }
  
  public TypeResolverBuilder<?> typeResolverBuilderInstance(Annotated paramAnnotated, Class<? extends TypeResolverBuilder<?>> paramClass)
  {
    HandlerInstantiator localHandlerInstantiator = getHandlerInstantiator();
    if (localHandlerInstantiator != null)
    {
      paramAnnotated = localHandlerInstantiator.typeResolverBuilderInstance(this, paramAnnotated, paramClass);
      if (paramAnnotated != null) {
        return paramAnnotated;
      }
    }
    return (TypeResolverBuilder)ClassUtil.createInstance(paramClass, canOverrideAccessModifiers());
  }
  
  public abstract T withAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector);
  
  public abstract T withAppendedAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector);
  
  public abstract T withClassIntrospector(ClassIntrospector<? extends BeanDescription> paramClassIntrospector);
  
  public abstract T withDateFormat(DateFormat paramDateFormat);
  
  public abstract T withHandlerInstantiator(HandlerInstantiator paramHandlerInstantiator);
  
  public abstract T withInsertedAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector);
  
  public abstract T withPropertyNamingStrategy(PropertyNamingStrategy paramPropertyNamingStrategy);
  
  public abstract T withSubtypeResolver(SubtypeResolver paramSubtypeResolver);
  
  public abstract T withTypeFactory(TypeFactory paramTypeFactory);
  
  public abstract T withTypeResolverBuilder(TypeResolverBuilder<?> paramTypeResolverBuilder);
  
  public abstract T withVisibility(JsonMethod paramJsonMethod, JsonAutoDetect.Visibility paramVisibility);
  
  public abstract T withVisibilityChecker(VisibilityChecker<?> paramVisibilityChecker);
  
  public static class Base
  {
    protected final AnnotationIntrospector _annotationIntrospector;
    protected final ClassIntrospector<? extends BeanDescription> _classIntrospector;
    protected final DateFormat _dateFormat;
    protected final HandlerInstantiator _handlerInstantiator;
    protected final PropertyNamingStrategy _propertyNamingStrategy;
    protected final TypeFactory _typeFactory;
    protected final TypeResolverBuilder<?> _typeResolverBuilder;
    protected final VisibilityChecker<?> _visibilityChecker;
    
    public Base(ClassIntrospector<? extends BeanDescription> paramClassIntrospector, AnnotationIntrospector paramAnnotationIntrospector, VisibilityChecker<?> paramVisibilityChecker, PropertyNamingStrategy paramPropertyNamingStrategy, TypeFactory paramTypeFactory, TypeResolverBuilder<?> paramTypeResolverBuilder, DateFormat paramDateFormat, HandlerInstantiator paramHandlerInstantiator)
    {
      this._classIntrospector = paramClassIntrospector;
      this._annotationIntrospector = paramAnnotationIntrospector;
      this._visibilityChecker = paramVisibilityChecker;
      this._propertyNamingStrategy = paramPropertyNamingStrategy;
      this._typeFactory = paramTypeFactory;
      this._typeResolverBuilder = paramTypeResolverBuilder;
      this._dateFormat = paramDateFormat;
      this._handlerInstantiator = paramHandlerInstantiator;
    }
    
    public AnnotationIntrospector getAnnotationIntrospector()
    {
      return this._annotationIntrospector;
    }
    
    public ClassIntrospector<? extends BeanDescription> getClassIntrospector()
    {
      return this._classIntrospector;
    }
    
    public DateFormat getDateFormat()
    {
      return this._dateFormat;
    }
    
    public HandlerInstantiator getHandlerInstantiator()
    {
      return this._handlerInstantiator;
    }
    
    public PropertyNamingStrategy getPropertyNamingStrategy()
    {
      return this._propertyNamingStrategy;
    }
    
    public TypeFactory getTypeFactory()
    {
      return this._typeFactory;
    }
    
    public TypeResolverBuilder<?> getTypeResolverBuilder()
    {
      return this._typeResolverBuilder;
    }
    
    public VisibilityChecker<?> getVisibilityChecker()
    {
      return this._visibilityChecker;
    }
    
    public Base withAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
    {
      return new Base(this._classIntrospector, paramAnnotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator);
    }
    
    public Base withAppendedAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
    {
      return withAnnotationIntrospector(AnnotationIntrospector.Pair.create(this._annotationIntrospector, paramAnnotationIntrospector));
    }
    
    public Base withClassIntrospector(ClassIntrospector<? extends BeanDescription> paramClassIntrospector)
    {
      return new Base(paramClassIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator);
    }
    
    public Base withDateFormat(DateFormat paramDateFormat)
    {
      return new Base(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, paramDateFormat, this._handlerInstantiator);
    }
    
    public Base withHandlerInstantiator(HandlerInstantiator paramHandlerInstantiator)
    {
      return new Base(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, paramHandlerInstantiator);
    }
    
    public Base withInsertedAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector)
    {
      return withAnnotationIntrospector(AnnotationIntrospector.Pair.create(paramAnnotationIntrospector, this._annotationIntrospector));
    }
    
    public Base withPropertyNamingStrategy(PropertyNamingStrategy paramPropertyNamingStrategy)
    {
      return new Base(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, paramPropertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator);
    }
    
    public Base withTypeFactory(TypeFactory paramTypeFactory)
    {
      return new Base(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, paramTypeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator);
    }
    
    public Base withTypeResolverBuilder(TypeResolverBuilder<?> paramTypeResolverBuilder)
    {
      return new Base(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker, this._propertyNamingStrategy, this._typeFactory, paramTypeResolverBuilder, this._dateFormat, this._handlerInstantiator);
    }
    
    public Base withVisibility(JsonMethod paramJsonMethod, JsonAutoDetect.Visibility paramVisibility)
    {
      return new Base(this._classIntrospector, this._annotationIntrospector, this._visibilityChecker.withVisibility(paramJsonMethod, paramVisibility), this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator);
    }
    
    public Base withVisibilityChecker(VisibilityChecker<?> paramVisibilityChecker)
    {
      return new Base(this._classIntrospector, this._annotationIntrospector, paramVisibilityChecker, this._propertyNamingStrategy, this._typeFactory, this._typeResolverBuilder, this._dateFormat, this._handlerInstantiator);
    }
  }
  
  public static abstract interface ConfigFeature
  {
    public abstract boolean enabledByDefault();
    
    public abstract int getMask();
  }
  
  static abstract class Impl<CFG extends MapperConfig.ConfigFeature, T extends Impl<CFG, T>>
    extends MapperConfig<T>
  {
    protected int _featureFlags;
    
    protected Impl(ClassIntrospector<? extends BeanDescription> paramClassIntrospector, AnnotationIntrospector paramAnnotationIntrospector, VisibilityChecker<?> paramVisibilityChecker, SubtypeResolver paramSubtypeResolver, PropertyNamingStrategy paramPropertyNamingStrategy, TypeFactory paramTypeFactory, HandlerInstantiator paramHandlerInstantiator, int paramInt)
    {
      super(paramAnnotationIntrospector, paramVisibilityChecker, paramSubtypeResolver, paramPropertyNamingStrategy, paramTypeFactory, paramHandlerInstantiator);
      this._featureFlags = paramInt;
    }
    
    protected Impl(Impl<CFG, T> paramImpl)
    {
      super();
      this._featureFlags = paramImpl._featureFlags;
    }
    
    protected Impl(Impl<CFG, T> paramImpl, int paramInt)
    {
      super();
      this._featureFlags = paramInt;
    }
    
    protected Impl(Impl<CFG, T> paramImpl, MapperConfig.Base paramBase, SubtypeResolver paramSubtypeResolver)
    {
      super(paramBase, paramSubtypeResolver);
      this._featureFlags = paramImpl._featureFlags;
    }
    
    static <F extends Enum<F>,  extends MapperConfig.ConfigFeature> int collectFeatureDefaults(Class<F> paramClass)
    {
      int j = 0;
      paramClass = (Enum[])paramClass.getEnumConstants();
      int m = paramClass.length;
      int i = 0;
      while (i < m)
      {
        Object localObject = paramClass[i];
        int k = j;
        if (((MapperConfig.ConfigFeature)localObject).enabledByDefault()) {
          k = j | ((MapperConfig.ConfigFeature)localObject).getMask();
        }
        i += 1;
        j = k;
      }
      return j;
    }
    
    @Deprecated
    public void disable(CFG paramCFG)
    {
      this._featureFlags &= (paramCFG.getMask() ^ 0xFFFFFFFF);
    }
    
    @Deprecated
    public void enable(CFG paramCFG)
    {
      this._featureFlags |= paramCFG.getMask();
    }
    
    public boolean isEnabled(MapperConfig.ConfigFeature paramConfigFeature)
    {
      return (this._featureFlags & paramConfigFeature.getMask()) != 0;
    }
    
    @Deprecated
    public void set(CFG paramCFG, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        enable(paramCFG);
        return;
      }
      disable(paramCFG);
    }
    
    public abstract T with(CFG... paramVarArgs);
    
    public abstract T without(CFG... paramVarArgs);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/MapperConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */