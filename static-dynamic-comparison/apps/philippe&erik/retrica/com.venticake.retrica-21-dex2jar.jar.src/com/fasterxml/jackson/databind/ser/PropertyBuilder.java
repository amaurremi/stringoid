package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.Comparators;

public class PropertyBuilder
{
  protected final AnnotationIntrospector _annotationIntrospector;
  protected final BeanDescription _beanDesc;
  protected final SerializationConfig _config;
  protected Object _defaultBean;
  protected final JsonInclude.Include _outputProps;
  
  public PropertyBuilder(SerializationConfig paramSerializationConfig, BeanDescription paramBeanDescription)
  {
    this._config = paramSerializationConfig;
    this._beanDesc = paramBeanDescription;
    this._outputProps = paramBeanDescription.findSerializationInclusion(paramSerializationConfig.getSerializationInclusion());
    this._annotationIntrospector = this._config.getAnnotationIntrospector();
  }
  
  protected Object _throwWrapped(Exception paramException, String paramString, Object paramObject)
  {
    while (paramException.getCause() != null) {
      paramException = paramException.getCause();
    }
    if ((paramException instanceof Error)) {
      throw ((Error)paramException);
    }
    if ((paramException instanceof RuntimeException)) {
      throw ((RuntimeException)paramException);
    }
    throw new IllegalArgumentException("Failed to get property '" + paramString + "' of default " + paramObject.getClass().getName() + " instance");
  }
  
  protected BeanPropertyWriter buildWriter(BeanPropertyDefinition paramBeanPropertyDefinition, JavaType paramJavaType, JsonSerializer<?> paramJsonSerializer, TypeSerializer paramTypeSerializer1, TypeSerializer paramTypeSerializer2, AnnotatedMember paramAnnotatedMember, boolean paramBoolean)
  {
    JavaType localJavaType = findSerializationType(paramAnnotatedMember, paramBoolean, paramJavaType);
    Object localObject;
    if (paramTypeSerializer2 != null)
    {
      localObject = localJavaType;
      if (localJavaType == null) {
        localObject = paramJavaType;
      }
      if (((JavaType)localObject).getContentType() == null) {
        throw new IllegalStateException("Problem trying to create BeanPropertyWriter for property '" + paramBeanPropertyDefinition.getName() + "' (of type " + this._beanDesc.getType() + "); serialization type " + localObject + " has no content");
      }
      localJavaType = ((JavaType)localObject).withContentTypeHandler(paramTypeSerializer2);
      localJavaType.getContentType();
    }
    for (;;)
    {
      localObject = null;
      paramBoolean = false;
      boolean bool2 = false;
      JsonInclude.Include localInclude = this._annotationIntrospector.findSerializationInclusion(paramAnnotatedMember, this._outputProps);
      boolean bool1 = bool2;
      paramTypeSerializer2 = (TypeSerializer)localObject;
      if (localInclude != null) {}
      switch (1.$SwitchMap$com$fasterxml$jackson$annotation$JsonInclude$Include[localInclude.ordinal()])
      {
      default: 
        paramTypeSerializer2 = (TypeSerializer)localObject;
        bool1 = bool2;
        paramBoolean = bool1;
      }
      for (;;)
      {
        paramJavaType = new BeanPropertyWriter(paramBeanPropertyDefinition, paramAnnotatedMember, this._beanDesc.getClassAnnotations(), paramJavaType, paramJsonSerializer, paramTypeSerializer1, localJavaType, paramBoolean, paramTypeSerializer2);
        paramJsonSerializer = this._annotationIntrospector.findUnwrappingNameTransformer(paramAnnotatedMember);
        paramBeanPropertyDefinition = paramJavaType;
        if (paramJsonSerializer != null) {
          paramBeanPropertyDefinition = paramJavaType.unwrappingWriter(paramJsonSerializer);
        }
        return paramBeanPropertyDefinition;
        localObject = getDefaultValue(paramBeanPropertyDefinition.getName(), paramAnnotatedMember);
        if (localObject == null)
        {
          paramBoolean = true;
          paramTypeSerializer2 = (TypeSerializer)localObject;
        }
        else
        {
          bool1 = bool2;
          paramTypeSerializer2 = (TypeSerializer)localObject;
          if (!localObject.getClass().isArray()) {
            break;
          }
          paramTypeSerializer2 = Comparators.getArrayComparator(localObject);
          paramBoolean = false;
          continue;
          paramTypeSerializer2 = BeanPropertyWriter.MARKER_FOR_EMPTY;
          paramBoolean = true;
          continue;
          paramBoolean = true;
          bool1 = paramBoolean;
          paramTypeSerializer2 = (TypeSerializer)localObject;
          if (!paramJavaType.isContainerType()) {
            break;
          }
          bool1 = paramBoolean;
          paramTypeSerializer2 = (TypeSerializer)localObject;
          if (this._config.isEnabled(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS)) {
            break;
          }
          paramTypeSerializer2 = BeanPropertyWriter.MARKER_FOR_EMPTY;
        }
      }
    }
  }
  
  protected JavaType findSerializationType(Annotated paramAnnotated, boolean paramBoolean, JavaType paramJavaType)
  {
    boolean bool = true;
    Object localObject = this._annotationIntrospector.findSerializationType(paramAnnotated);
    Class localClass;
    if (localObject != null)
    {
      localClass = paramJavaType.getRawClass();
      if (((Class)localObject).isAssignableFrom(localClass))
      {
        paramJavaType = paramJavaType.widenBy((Class)localObject);
        paramBoolean = true;
      }
    }
    for (;;)
    {
      localObject = BeanSerializerFactory.modifySecondaryTypesByAnnotation(this._config, paramAnnotated, paramJavaType);
      if (localObject != paramJavaType)
      {
        paramJavaType = (JavaType)localObject;
        paramBoolean = true;
      }
      for (;;)
      {
        if (!paramBoolean)
        {
          paramAnnotated = this._annotationIntrospector.findSerializationTyping(paramAnnotated);
          if (paramAnnotated != null) {
            if (paramAnnotated == JsonSerialize.Typing.STATIC) {
              paramBoolean = bool;
            }
          }
        }
        for (;;)
        {
          if (paramBoolean)
          {
            return paramJavaType;
            if (!localClass.isAssignableFrom((Class)localObject)) {
              throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + paramAnnotated.getName() + "': class " + ((Class)localObject).getName() + " not a super-type of (declared) class " + localClass.getName());
            }
            paramJavaType = this._config.constructSpecializedType(paramJavaType, (Class)localObject);
            break;
            paramBoolean = false;
            continue;
          }
          return null;
        }
      }
    }
  }
  
  public Annotations getClassAnnotations()
  {
    return this._beanDesc.getClassAnnotations();
  }
  
  protected Object getDefaultBean()
  {
    if (this._defaultBean == null)
    {
      this._defaultBean = this._beanDesc.instantiateBean(this._config.canOverrideAccessModifiers());
      if (this._defaultBean == null)
      {
        Class localClass = this._beanDesc.getClassInfo().getAnnotated();
        throw new IllegalArgumentException("Class " + localClass.getName() + " has no default constructor; can not instantiate default bean value to support 'properties=JsonSerialize.Inclusion.NON_DEFAULT' annotation");
      }
    }
    return this._defaultBean;
  }
  
  protected Object getDefaultValue(String paramString, AnnotatedMember paramAnnotatedMember)
  {
    Object localObject = getDefaultBean();
    try
    {
      paramAnnotatedMember = paramAnnotatedMember.getValue(localObject);
      return paramAnnotatedMember;
    }
    catch (Exception paramAnnotatedMember) {}
    return _throwWrapped(paramAnnotatedMember, paramString, localObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/PropertyBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */