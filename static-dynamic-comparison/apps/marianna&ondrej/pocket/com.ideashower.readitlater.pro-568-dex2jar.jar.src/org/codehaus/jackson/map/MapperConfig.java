package org.codehaus.jackson.map;

import java.text.DateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.introspect.Annotated;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.jsontype.SubtypeResolver;
import org.codehaus.jackson.map.jsontype.TypeIdResolver;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.map.jsontype.impl.StdSubtypeResolver;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.map.type.TypeBindings;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.map.util.StdDateFormat;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

public abstract class MapperConfig
  implements ClassIntrospector.MixInResolver
{
  protected static final DateFormat DEFAULT_DATE_FORMAT = StdDateFormat.instance;
  protected MapperConfig.Base _base;
  protected HashMap _mixInAnnotations;
  protected boolean _mixInAnnotationsShared;
  protected SubtypeResolver _subtypeResolver;
  
  protected MapperConfig(ClassIntrospector paramClassIntrospector, AnnotationIntrospector paramAnnotationIntrospector, VisibilityChecker paramVisibilityChecker, SubtypeResolver paramSubtypeResolver, PropertyNamingStrategy paramPropertyNamingStrategy, TypeFactory paramTypeFactory, HandlerInstantiator paramHandlerInstantiator)
  {
    this._base = new MapperConfig.Base(paramClassIntrospector, paramAnnotationIntrospector, paramVisibilityChecker, paramPropertyNamingStrategy, paramTypeFactory, null, DEFAULT_DATE_FORMAT, paramHandlerInstantiator);
    this._subtypeResolver = paramSubtypeResolver;
    this._mixInAnnotationsShared = true;
  }
  
  protected MapperConfig(MapperConfig paramMapperConfig)
  {
    this(paramMapperConfig, paramMapperConfig._base, paramMapperConfig._subtypeResolver);
  }
  
  protected MapperConfig(MapperConfig paramMapperConfig, MapperConfig.Base paramBase, SubtypeResolver paramSubtypeResolver)
  {
    this._base = paramBase;
    this._subtypeResolver = paramSubtypeResolver;
    this._mixInAnnotationsShared = true;
    this._mixInAnnotations = paramMapperConfig._mixInAnnotations;
  }
  
  public final void addMixInAnnotations(Class paramClass1, Class paramClass2)
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
  
  public JavaType constructSpecializedType(JavaType paramJavaType, Class paramClass)
  {
    return getTypeFactory().constructSpecializedType(paramJavaType, paramClass);
  }
  
  public final JavaType constructType(Class paramClass)
  {
    return getTypeFactory().constructType(paramClass, (TypeBindings)null);
  }
  
  public final JavaType constructType(TypeReference paramTypeReference)
  {
    return getTypeFactory().constructType(paramTypeReference.getType(), (TypeBindings)null);
  }
  
  public abstract MapperConfig createUnshared(SubtypeResolver paramSubtypeResolver);
  
  public final Class findMixInClassFor(Class paramClass)
  {
    if (this._mixInAnnotations == null) {
      return null;
    }
    return (Class)this._mixInAnnotations.get(new ClassKey(paramClass));
  }
  
  @Deprecated
  public abstract void fromAnnotations(Class paramClass);
  
  public AnnotationIntrospector getAnnotationIntrospector()
  {
    return this._base.getAnnotationIntrospector();
  }
  
  public ClassIntrospector getClassIntrospector()
  {
    return this._base.getClassIntrospector();
  }
  
  public final DateFormat getDateFormat()
  {
    return this._base.getDateFormat();
  }
  
  public final TypeResolverBuilder getDefaultTyper(JavaType paramJavaType)
  {
    return this._base.getTypeResolverBuilder();
  }
  
  public VisibilityChecker getDefaultVisibilityChecker()
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
  
  public BeanDescription introspectClassAnnotations(Class paramClass)
  {
    return introspectClassAnnotations(constructType(paramClass));
  }
  
  public abstract BeanDescription introspectClassAnnotations(JavaType paramJavaType);
  
  public BeanDescription introspectDirectClassAnnotations(Class paramClass)
  {
    return introspectDirectClassAnnotations(constructType(paramClass));
  }
  
  public abstract BeanDescription introspectDirectClassAnnotations(JavaType paramJavaType);
  
  public abstract boolean isAnnotationProcessingEnabled();
  
  public abstract boolean isEnabled(MapperConfig.ConfigFeature paramConfigFeature);
  
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
  
  public final void setMixInAnnotations(Map paramMap)
  {
    Map.Entry localEntry = null;
    Object localObject = localEntry;
    if (paramMap != null)
    {
      localObject = localEntry;
      if (paramMap.size() > 0)
      {
        localObject = new HashMap(paramMap.size());
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          localEntry = (Map.Entry)paramMap.next();
          ((HashMap)localObject).put(new ClassKey((Class)localEntry.getKey()), localEntry.getValue());
        }
      }
    }
    this._mixInAnnotationsShared = false;
    this._mixInAnnotations = ((HashMap)localObject);
  }
  
  public abstract boolean shouldSortPropertiesAlphabetically();
  
  public TypeIdResolver typeIdResolverInstance(Annotated paramAnnotated, Class paramClass)
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
  
  public TypeResolverBuilder typeResolverBuilderInstance(Annotated paramAnnotated, Class paramClass)
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
  
  public abstract MapperConfig withAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector);
  
  public abstract MapperConfig withAppendedAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector);
  
  public abstract MapperConfig withClassIntrospector(ClassIntrospector paramClassIntrospector);
  
  public abstract MapperConfig withDateFormat(DateFormat paramDateFormat);
  
  public abstract MapperConfig withHandlerInstantiator(HandlerInstantiator paramHandlerInstantiator);
  
  public abstract MapperConfig withInsertedAnnotationIntrospector(AnnotationIntrospector paramAnnotationIntrospector);
  
  public abstract MapperConfig withPropertyNamingStrategy(PropertyNamingStrategy paramPropertyNamingStrategy);
  
  public abstract MapperConfig withSubtypeResolver(SubtypeResolver paramSubtypeResolver);
  
  public abstract MapperConfig withTypeFactory(TypeFactory paramTypeFactory);
  
  public abstract MapperConfig withTypeResolverBuilder(TypeResolverBuilder paramTypeResolverBuilder);
  
  public abstract MapperConfig withVisibility(JsonMethod paramJsonMethod, JsonAutoDetect.Visibility paramVisibility);
  
  public abstract MapperConfig withVisibilityChecker(VisibilityChecker paramVisibilityChecker);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/MapperConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */