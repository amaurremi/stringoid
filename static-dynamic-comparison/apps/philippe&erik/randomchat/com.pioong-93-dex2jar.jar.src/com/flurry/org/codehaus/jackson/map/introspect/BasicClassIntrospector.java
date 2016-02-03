package com.flurry.org.codehaus.jackson.map.introspect;

import com.flurry.org.codehaus.jackson.map.AnnotationIntrospector;
import com.flurry.org.codehaus.jackson.map.ClassIntrospector;
import com.flurry.org.codehaus.jackson.map.ClassIntrospector.MixInResolver;
import com.flurry.org.codehaus.jackson.map.DeserializationConfig;
import com.flurry.org.codehaus.jackson.map.DeserializationConfig.Feature;
import com.flurry.org.codehaus.jackson.map.MapperConfig;
import com.flurry.org.codehaus.jackson.map.SerializationConfig;
import com.flurry.org.codehaus.jackson.map.type.SimpleType;
import com.flurry.org.codehaus.jackson.map.util.ClassUtil;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Map;

public class BasicClassIntrospector
  extends ClassIntrospector<BasicBeanDescription>
{
  protected static final BasicBeanDescription BOOLEAN_DESC;
  @Deprecated
  public static final GetterMethodFilter DEFAULT_GETTER_FILTER;
  @Deprecated
  public static final SetterAndGetterMethodFilter DEFAULT_SETTER_AND_GETTER_FILTER = new SetterAndGetterMethodFilter();
  @Deprecated
  public static final SetterMethodFilter DEFAULT_SETTER_FILTER;
  protected static final BasicBeanDescription INT_DESC;
  protected static final BasicBeanDescription LONG_DESC;
  protected static final MethodFilter MINIMAL_FILTER = new MinimalMethodFilter(null);
  protected static final BasicBeanDescription STRING_DESC;
  public static final BasicClassIntrospector instance = new BasicClassIntrospector();
  
  static
  {
    AnnotatedClass localAnnotatedClass = AnnotatedClass.constructWithoutSuperTypes(String.class, null, null);
    STRING_DESC = BasicBeanDescription.forOtherUse(null, SimpleType.constructUnsafe(String.class), localAnnotatedClass);
    localAnnotatedClass = AnnotatedClass.constructWithoutSuperTypes(Boolean.TYPE, null, null);
    BOOLEAN_DESC = BasicBeanDescription.forOtherUse(null, SimpleType.constructUnsafe(Boolean.TYPE), localAnnotatedClass);
    localAnnotatedClass = AnnotatedClass.constructWithoutSuperTypes(Integer.TYPE, null, null);
    INT_DESC = BasicBeanDescription.forOtherUse(null, SimpleType.constructUnsafe(Integer.TYPE), localAnnotatedClass);
    localAnnotatedClass = AnnotatedClass.constructWithoutSuperTypes(Long.TYPE, null, null);
    LONG_DESC = BasicBeanDescription.forOtherUse(null, SimpleType.constructUnsafe(Long.TYPE), localAnnotatedClass);
    DEFAULT_GETTER_FILTER = new GetterMethodFilter(null);
    DEFAULT_SETTER_FILTER = new SetterMethodFilter();
  }
  
  protected BasicBeanDescription _findCachedDesc(JavaType paramJavaType)
  {
    paramJavaType = paramJavaType.getRawClass();
    if (paramJavaType == String.class) {
      return STRING_DESC;
    }
    if (paramJavaType == Boolean.TYPE) {
      return BOOLEAN_DESC;
    }
    if (paramJavaType == Integer.TYPE) {
      return INT_DESC;
    }
    if (paramJavaType == Long.TYPE) {
      return LONG_DESC;
    }
    return null;
  }
  
  public AnnotatedClass classWithCreators(MapperConfig<?> paramMapperConfig, JavaType paramJavaType, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    boolean bool = paramMapperConfig.isAnnotationProcessingEnabled();
    paramMapperConfig = paramMapperConfig.getAnnotationIntrospector();
    paramJavaType = paramJavaType.getRawClass();
    if (bool) {}
    for (;;)
    {
      paramMapperConfig = AnnotatedClass.construct(paramJavaType, paramMapperConfig, paramMixInResolver);
      paramMapperConfig.resolveMemberMethods(MINIMAL_FILTER);
      paramMapperConfig.resolveCreators(true);
      return paramMapperConfig;
      paramMapperConfig = null;
    }
  }
  
  public POJOPropertiesCollector collectProperties(MapperConfig<?> paramMapperConfig, JavaType paramJavaType, ClassIntrospector.MixInResolver paramMixInResolver, boolean paramBoolean)
  {
    paramMixInResolver = classWithCreators(paramMapperConfig, paramJavaType, paramMixInResolver);
    paramMixInResolver.resolveMemberMethods(MINIMAL_FILTER);
    paramMixInResolver.resolveFields();
    return constructPropertyCollector(paramMapperConfig, paramMixInResolver, paramJavaType, paramBoolean).collect();
  }
  
  protected POJOPropertiesCollector constructPropertyCollector(MapperConfig<?> paramMapperConfig, AnnotatedClass paramAnnotatedClass, JavaType paramJavaType, boolean paramBoolean)
  {
    return new POJOPropertiesCollector(paramMapperConfig, paramBoolean, paramJavaType, paramAnnotatedClass);
  }
  
  public BasicBeanDescription forClassAnnotations(MapperConfig<?> paramMapperConfig, JavaType paramJavaType, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    boolean bool = paramMapperConfig.isAnnotationProcessingEnabled();
    AnnotationIntrospector localAnnotationIntrospector = paramMapperConfig.getAnnotationIntrospector();
    Class localClass = paramJavaType.getRawClass();
    if (bool) {}
    for (;;)
    {
      return BasicBeanDescription.forOtherUse(paramMapperConfig, paramJavaType, AnnotatedClass.construct(localClass, localAnnotationIntrospector, paramMixInResolver));
      localAnnotationIntrospector = null;
    }
  }
  
  public BasicBeanDescription forCreation(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    BasicBeanDescription localBasicBeanDescription2 = _findCachedDesc(paramJavaType);
    BasicBeanDescription localBasicBeanDescription1 = localBasicBeanDescription2;
    if (localBasicBeanDescription2 == null) {
      localBasicBeanDescription1 = BasicBeanDescription.forDeserialization(collectProperties(paramDeserializationConfig, paramJavaType, paramMixInResolver, false));
    }
    return localBasicBeanDescription1;
  }
  
  public BasicBeanDescription forDeserialization(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    BasicBeanDescription localBasicBeanDescription2 = _findCachedDesc(paramJavaType);
    BasicBeanDescription localBasicBeanDescription1 = localBasicBeanDescription2;
    if (localBasicBeanDescription2 == null) {
      localBasicBeanDescription1 = BasicBeanDescription.forDeserialization(collectProperties(paramDeserializationConfig, paramJavaType, paramMixInResolver, false));
    }
    return localBasicBeanDescription1;
  }
  
  public BasicBeanDescription forDirectClassAnnotations(MapperConfig<?> paramMapperConfig, JavaType paramJavaType, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    boolean bool = paramMapperConfig.isAnnotationProcessingEnabled();
    AnnotationIntrospector localAnnotationIntrospector = paramMapperConfig.getAnnotationIntrospector();
    Class localClass = paramJavaType.getRawClass();
    if (bool) {}
    for (;;)
    {
      return BasicBeanDescription.forOtherUse(paramMapperConfig, paramJavaType, AnnotatedClass.constructWithoutSuperTypes(localClass, localAnnotationIntrospector, paramMixInResolver));
      localAnnotationIntrospector = null;
    }
  }
  
  public BasicBeanDescription forSerialization(SerializationConfig paramSerializationConfig, JavaType paramJavaType, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    BasicBeanDescription localBasicBeanDescription2 = _findCachedDesc(paramJavaType);
    BasicBeanDescription localBasicBeanDescription1 = localBasicBeanDescription2;
    if (localBasicBeanDescription2 == null) {
      localBasicBeanDescription1 = BasicBeanDescription.forSerialization(collectProperties(paramSerializationConfig, paramJavaType, paramMixInResolver, true));
    }
    return localBasicBeanDescription1;
  }
  
  @Deprecated
  protected MethodFilter getDeserializationMethodFilter(DeserializationConfig paramDeserializationConfig)
  {
    if (paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.USE_GETTERS_AS_SETTERS)) {
      return DEFAULT_SETTER_AND_GETTER_FILTER;
    }
    return DEFAULT_SETTER_FILTER;
  }
  
  @Deprecated
  protected MethodFilter getSerializationMethodFilter(SerializationConfig paramSerializationConfig)
  {
    return DEFAULT_GETTER_FILTER;
  }
  
  @Deprecated
  public static class GetterMethodFilter
    implements MethodFilter
  {
    public boolean includeMethod(Method paramMethod)
    {
      return ClassUtil.hasGetterSignature(paramMethod);
    }
  }
  
  private static class MinimalMethodFilter
    implements MethodFilter
  {
    public boolean includeMethod(Method paramMethod)
    {
      if (Modifier.isStatic(paramMethod.getModifiers())) {}
      while (paramMethod.getParameterTypes().length > 2) {
        return false;
      }
      return true;
    }
  }
  
  @Deprecated
  public static final class SetterAndGetterMethodFilter
    extends BasicClassIntrospector.SetterMethodFilter
  {
    public boolean includeMethod(Method paramMethod)
    {
      if (super.includeMethod(paramMethod)) {}
      do
      {
        return true;
        if (!ClassUtil.hasGetterSignature(paramMethod)) {
          return false;
        }
        paramMethod = paramMethod.getReturnType();
      } while ((Collection.class.isAssignableFrom(paramMethod)) || (Map.class.isAssignableFrom(paramMethod)));
      return false;
    }
  }
  
  @Deprecated
  public static class SetterMethodFilter
    implements MethodFilter
  {
    public boolean includeMethod(Method paramMethod)
    {
      if (Modifier.isStatic(paramMethod.getModifiers())) {
        return false;
      }
      switch (paramMethod.getParameterTypes().length)
      {
      default: 
        return false;
      case 1: 
        return true;
      }
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/introspect/BasicClassIntrospector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */