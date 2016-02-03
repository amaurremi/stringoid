package org.codehaus.jackson.map.ser;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.annotate.JsonSerialize.Typing;
import org.codehaus.jackson.map.introspect.Annotated;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.util.Annotations;
import org.codehaus.jackson.map.util.Comparators;
import org.codehaus.jackson.type.JavaType;

public class PropertyBuilder
{
  protected final AnnotationIntrospector _annotationIntrospector;
  protected final BasicBeanDescription _beanDesc;
  protected final SerializationConfig _config;
  protected Object _defaultBean;
  protected final JsonSerialize.Inclusion _outputProps;
  
  public PropertyBuilder(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription)
  {
    this._config = paramSerializationConfig;
    this._beanDesc = paramBasicBeanDescription;
    this._outputProps = paramBasicBeanDescription.findSerializationInclusion(paramSerializationConfig.getSerializationInclusion());
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
  
  protected BeanPropertyWriter buildWriter(String paramString, JavaType paramJavaType, JsonSerializer paramJsonSerializer, TypeSerializer paramTypeSerializer1, TypeSerializer paramTypeSerializer2, AnnotatedMember paramAnnotatedMember, boolean paramBoolean)
  {
    Method localMethod;
    if ((paramAnnotatedMember instanceof AnnotatedField)) {
      localMethod = null;
    }
    Object localObject;
    for (Field localField = ((AnnotatedField)paramAnnotatedMember).getAnnotated();; localField = null)
    {
      localJavaType = findSerializationType(paramAnnotatedMember, paramBoolean, paramJavaType);
      if (paramTypeSerializer2 == null) {
        break label397;
      }
      localObject = localJavaType;
      if (localJavaType == null) {
        localObject = paramJavaType;
      }
      if (((JavaType)localObject).getContentType() != null) {
        break;
      }
      throw new IllegalStateException("Problem trying to create BeanPropertyWriter for property '" + paramString + "' (of type " + this._beanDesc.getType() + "); serialization type " + localObject + " has no content");
      localMethod = ((AnnotatedMethod)paramAnnotatedMember).getAnnotated();
    }
    JavaType localJavaType = ((JavaType)localObject).withContentTypeHandler(paramTypeSerializer2);
    localJavaType.getContentType();
    label397:
    for (;;)
    {
      localObject = null;
      paramBoolean = false;
      boolean bool2 = false;
      JsonSerialize.Inclusion localInclusion = this._annotationIntrospector.findSerializationInclusion(paramAnnotatedMember, this._outputProps);
      boolean bool1 = bool2;
      paramTypeSerializer2 = (TypeSerializer)localObject;
      if (localInclusion != null) {}
      switch (1.$SwitchMap$org$codehaus$jackson$map$annotate$JsonSerialize$Inclusion[localInclusion.ordinal()])
      {
      default: 
        paramTypeSerializer2 = (TypeSerializer)localObject;
        bool1 = bool2;
        paramBoolean = bool1;
      }
      for (;;)
      {
        paramJavaType = new BeanPropertyWriter(paramAnnotatedMember, this._beanDesc.getClassAnnotations(), paramString, paramJavaType, paramJsonSerializer, paramTypeSerializer1, localJavaType, localMethod, localField, paramBoolean, paramTypeSerializer2);
        paramJsonSerializer = this._annotationIntrospector.shouldUnwrapProperty(paramAnnotatedMember);
        paramString = paramJavaType;
        if (paramJsonSerializer != null)
        {
          paramString = paramJavaType;
          if (paramJsonSerializer.booleanValue()) {
            paramString = paramJavaType.unwrappingWriter();
          }
        }
        return paramString;
        localObject = getDefaultValue(paramString, localMethod, localField);
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
          paramTypeSerializer2 = getEmptyValueChecker(paramString, paramJavaType);
          paramBoolean = true;
          continue;
          paramBoolean = true;
          bool1 = paramBoolean;
          paramTypeSerializer2 = (TypeSerializer)localObject;
          if (!paramJavaType.isContainerType()) {
            break;
          }
          paramTypeSerializer2 = getContainerValueChecker(paramString, paramJavaType);
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
  
  protected Object getContainerValueChecker(String paramString, JavaType paramJavaType)
  {
    if (!this._config.isEnabled(SerializationConfig.Feature.WRITE_EMPTY_JSON_ARRAYS))
    {
      if (paramJavaType.isArrayType()) {
        return new PropertyBuilder.EmptyArrayChecker();
      }
      if (Collection.class.isAssignableFrom(paramJavaType.getRawClass())) {
        return new PropertyBuilder.EmptyCollectionChecker();
      }
    }
    return null;
  }
  
  protected Object getDefaultBean()
  {
    if (this._defaultBean == null)
    {
      this._defaultBean = this._beanDesc.instantiateBean(this._config.isEnabled(SerializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS));
      if (this._defaultBean == null)
      {
        Class localClass = this._beanDesc.getClassInfo().getAnnotated();
        throw new IllegalArgumentException("Class " + localClass.getName() + " has no default constructor; can not instantiate default bean value to support 'properties=JsonSerialize.Inclusion.NON_DEFAULT' annotation");
      }
    }
    return this._defaultBean;
  }
  
  protected Object getDefaultValue(String paramString, Method paramMethod, Field paramField)
  {
    Object localObject = getDefaultBean();
    if (paramMethod != null) {}
    try
    {
      return paramMethod.invoke(localObject, new Object[0]);
    }
    catch (Exception paramMethod) {}
    paramMethod = paramField.get(localObject);
    return paramMethod;
    return _throwWrapped(paramMethod, paramString, localObject);
  }
  
  protected Object getEmptyValueChecker(String paramString, JavaType paramJavaType)
  {
    paramString = paramJavaType.getRawClass();
    if (paramString == String.class) {
      return new PropertyBuilder.EmptyStringChecker();
    }
    if (paramJavaType.isArrayType()) {
      return new PropertyBuilder.EmptyArrayChecker();
    }
    if (Collection.class.isAssignableFrom(paramString)) {
      return new PropertyBuilder.EmptyCollectionChecker();
    }
    if (Map.class.isAssignableFrom(paramString)) {
      return new PropertyBuilder.EmptyMapChecker();
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/PropertyBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */