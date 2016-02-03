package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector.MixInResolver;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

public abstract class MapperConfig<T extends MapperConfig<T>>
  implements ClassIntrospector.MixInResolver, Serializable
{
  protected final BaseSettings _base;
  protected final int _mapperFeatures;
  
  protected MapperConfig(BaseSettings paramBaseSettings, int paramInt)
  {
    this._base = paramBaseSettings;
    this._mapperFeatures = paramInt;
  }
  
  public static <F extends Enum<F>,  extends ConfigFeature> int collectFeatureDefaults(Class<F> paramClass)
  {
    paramClass = (Enum[])paramClass.getEnumConstants();
    int k = paramClass.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      Object localObject = paramClass[j];
      if (!((ConfigFeature)localObject).enabledByDefault()) {
        break label60;
      }
      i = ((ConfigFeature)localObject).getMask() | i;
    }
    label60:
    for (;;)
    {
      j += 1;
      break;
      return i;
    }
  }
  
  public final boolean canOverrideAccessModifiers()
  {
    return isEnabled(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS);
  }
  
  public JavaType constructSpecializedType(JavaType paramJavaType, Class<?> paramClass)
  {
    return getTypeFactory().constructSpecializedType(paramJavaType, paramClass);
  }
  
  public final JavaType constructType(Class<?> paramClass)
  {
    return getTypeFactory().constructType(paramClass, (TypeBindings)null);
  }
  
  public AnnotationIntrospector getAnnotationIntrospector()
  {
    return this._base.getAnnotationIntrospector();
  }
  
  public Base64Variant getBase64Variant()
  {
    return this._base.getBase64Variant();
  }
  
  public ClassIntrospector getClassIntrospector()
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
  
  public final Locale getLocale()
  {
    return this._base.getLocale();
  }
  
  public final PropertyNamingStrategy getPropertyNamingStrategy()
  {
    return this._base.getPropertyNamingStrategy();
  }
  
  public final TimeZone getTimeZone()
  {
    return this._base.getTimeZone();
  }
  
  public final TypeFactory getTypeFactory()
  {
    return this._base.getTypeFactory();
  }
  
  public abstract BeanDescription introspectClassAnnotations(JavaType paramJavaType);
  
  public BeanDescription introspectClassAnnotations(Class<?> paramClass)
  {
    return introspectClassAnnotations(constructType(paramClass));
  }
  
  public final boolean isAnnotationProcessingEnabled()
  {
    return isEnabled(MapperFeature.USE_ANNOTATIONS);
  }
  
  public final boolean isEnabled(MapperFeature paramMapperFeature)
  {
    return (this._mapperFeatures & paramMapperFeature.getMask()) != 0;
  }
  
  public final boolean shouldSortPropertiesAlphabetically()
  {
    return isEnabled(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
  }
  
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/cfg/MapperConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */