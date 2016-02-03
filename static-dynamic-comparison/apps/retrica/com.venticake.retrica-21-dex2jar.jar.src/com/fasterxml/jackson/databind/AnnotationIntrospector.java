package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.lang.annotation.Annotation;
import java.util.List;

public abstract class AnnotationIntrospector
{
  public static AnnotationIntrospector nopInstance()
  {
    return NopAnnotationIntrospector.instance;
  }
  
  public VisibilityChecker<?> findAutoDetectVisibility(AnnotatedClass paramAnnotatedClass, VisibilityChecker<?> paramVisibilityChecker)
  {
    return paramVisibilityChecker;
  }
  
  public Object findContentDeserializer(Annotated paramAnnotated)
  {
    return null;
  }
  
  public Object findContentSerializer(Annotated paramAnnotated)
  {
    return null;
  }
  
  public Class<?> findDeserializationContentType(Annotated paramAnnotated, JavaType paramJavaType)
  {
    return null;
  }
  
  public Class<?> findDeserializationKeyType(Annotated paramAnnotated, JavaType paramJavaType)
  {
    return null;
  }
  
  @Deprecated
  public String findDeserializationName(AnnotatedField paramAnnotatedField)
  {
    return null;
  }
  
  @Deprecated
  public String findDeserializationName(AnnotatedMethod paramAnnotatedMethod)
  {
    return null;
  }
  
  @Deprecated
  public String findDeserializationName(AnnotatedParameter paramAnnotatedParameter)
  {
    return null;
  }
  
  public Class<?> findDeserializationType(Annotated paramAnnotated, JavaType paramJavaType)
  {
    return null;
  }
  
  public Object findDeserializer(Annotated paramAnnotated)
  {
    return null;
  }
  
  public String findEnumValue(Enum<?> paramEnum)
  {
    return paramEnum.name();
  }
  
  public Object findFilterId(AnnotatedClass paramAnnotatedClass)
  {
    return null;
  }
  
  public JsonFormat.Value findFormat(Annotated paramAnnotated)
  {
    if ((paramAnnotated instanceof AnnotatedMember)) {
      return findFormat((AnnotatedMember)paramAnnotated);
    }
    return null;
  }
  
  @Deprecated
  public JsonFormat.Value findFormat(AnnotatedMember paramAnnotatedMember)
  {
    return null;
  }
  
  public Boolean findIgnoreUnknownProperties(AnnotatedClass paramAnnotatedClass)
  {
    return null;
  }
  
  public Object findInjectableValueId(AnnotatedMember paramAnnotatedMember)
  {
    return null;
  }
  
  public Object findKeyDeserializer(Annotated paramAnnotated)
  {
    return null;
  }
  
  public Object findKeySerializer(Annotated paramAnnotated)
  {
    return null;
  }
  
  public PropertyName findNameForDeserialization(Annotated paramAnnotated)
  {
    PropertyName localPropertyName = null;
    if ((paramAnnotated instanceof AnnotatedField)) {
      paramAnnotated = findDeserializationName((AnnotatedField)paramAnnotated);
    }
    for (;;)
    {
      if (paramAnnotated != null)
      {
        if (paramAnnotated.length() != 0) {
          break;
        }
        localPropertyName = PropertyName.USE_DEFAULT;
      }
      return localPropertyName;
      if ((paramAnnotated instanceof AnnotatedMethod)) {
        paramAnnotated = findDeserializationName((AnnotatedMethod)paramAnnotated);
      } else if ((paramAnnotated instanceof AnnotatedParameter)) {
        paramAnnotated = findDeserializationName((AnnotatedParameter)paramAnnotated);
      } else {
        paramAnnotated = null;
      }
    }
    return new PropertyName(paramAnnotated);
  }
  
  public PropertyName findNameForSerialization(Annotated paramAnnotated)
  {
    PropertyName localPropertyName = null;
    if ((paramAnnotated instanceof AnnotatedField)) {
      paramAnnotated = findSerializationName((AnnotatedField)paramAnnotated);
    }
    for (;;)
    {
      if (paramAnnotated != null)
      {
        if (paramAnnotated.length() != 0) {
          break;
        }
        localPropertyName = PropertyName.USE_DEFAULT;
      }
      return localPropertyName;
      if ((paramAnnotated instanceof AnnotatedMethod)) {
        paramAnnotated = findSerializationName((AnnotatedMethod)paramAnnotated);
      } else {
        paramAnnotated = null;
      }
    }
    return new PropertyName(paramAnnotated);
  }
  
  public Object findNamingStrategy(AnnotatedClass paramAnnotatedClass)
  {
    return null;
  }
  
  public ObjectIdInfo findObjectIdInfo(Annotated paramAnnotated)
  {
    return null;
  }
  
  public ObjectIdInfo findObjectReferenceInfo(Annotated paramAnnotated, ObjectIdInfo paramObjectIdInfo)
  {
    return paramObjectIdInfo;
  }
  
  public Class<?> findPOJOBuilder(AnnotatedClass paramAnnotatedClass)
  {
    return null;
  }
  
  public JsonPOJOBuilder.Value findPOJOBuilderConfig(AnnotatedClass paramAnnotatedClass)
  {
    return null;
  }
  
  public String[] findPropertiesToIgnore(Annotated paramAnnotated)
  {
    return null;
  }
  
  public TypeResolverBuilder<?> findPropertyContentTypeResolver(MapperConfig<?> paramMapperConfig, AnnotatedMember paramAnnotatedMember, JavaType paramJavaType)
  {
    return null;
  }
  
  public TypeResolverBuilder<?> findPropertyTypeResolver(MapperConfig<?> paramMapperConfig, AnnotatedMember paramAnnotatedMember, JavaType paramJavaType)
  {
    return null;
  }
  
  public AnnotationIntrospector.ReferenceProperty findReferenceType(AnnotatedMember paramAnnotatedMember)
  {
    return null;
  }
  
  public PropertyName findRootName(AnnotatedClass paramAnnotatedClass)
  {
    return null;
  }
  
  public Class<?> findSerializationContentType(Annotated paramAnnotated, JavaType paramJavaType)
  {
    return null;
  }
  
  public JsonInclude.Include findSerializationInclusion(Annotated paramAnnotated, JsonInclude.Include paramInclude)
  {
    return paramInclude;
  }
  
  public Class<?> findSerializationKeyType(Annotated paramAnnotated, JavaType paramJavaType)
  {
    return null;
  }
  
  @Deprecated
  public String findSerializationName(AnnotatedField paramAnnotatedField)
  {
    return null;
  }
  
  @Deprecated
  public String findSerializationName(AnnotatedMethod paramAnnotatedMethod)
  {
    return null;
  }
  
  public String[] findSerializationPropertyOrder(AnnotatedClass paramAnnotatedClass)
  {
    return null;
  }
  
  public Boolean findSerializationSortAlphabetically(AnnotatedClass paramAnnotatedClass)
  {
    return null;
  }
  
  public Class<?> findSerializationType(Annotated paramAnnotated)
  {
    return null;
  }
  
  public JsonSerialize.Typing findSerializationTyping(Annotated paramAnnotated)
  {
    return null;
  }
  
  public Object findSerializer(Annotated paramAnnotated)
  {
    return null;
  }
  
  public List<NamedType> findSubtypes(Annotated paramAnnotated)
  {
    return null;
  }
  
  public String findTypeName(AnnotatedClass paramAnnotatedClass)
  {
    return null;
  }
  
  public TypeResolverBuilder<?> findTypeResolver(MapperConfig<?> paramMapperConfig, AnnotatedClass paramAnnotatedClass, JavaType paramJavaType)
  {
    return null;
  }
  
  public NameTransformer findUnwrappingNameTransformer(AnnotatedMember paramAnnotatedMember)
  {
    return null;
  }
  
  public Object findValueInstantiator(AnnotatedClass paramAnnotatedClass)
  {
    return null;
  }
  
  public Class<?>[] findViews(Annotated paramAnnotated)
  {
    return null;
  }
  
  public PropertyName findWrapperName(Annotated paramAnnotated)
  {
    return null;
  }
  
  public boolean hasAnyGetterAnnotation(AnnotatedMethod paramAnnotatedMethod)
  {
    return false;
  }
  
  public boolean hasAnySetterAnnotation(AnnotatedMethod paramAnnotatedMethod)
  {
    return false;
  }
  
  public boolean hasAsValueAnnotation(AnnotatedMethod paramAnnotatedMethod)
  {
    return false;
  }
  
  public boolean hasCreatorAnnotation(Annotated paramAnnotated)
  {
    return false;
  }
  
  public boolean hasIgnoreMarker(AnnotatedMember paramAnnotatedMember)
  {
    return false;
  }
  
  public boolean isAnnotationBundle(Annotation paramAnnotation)
  {
    return false;
  }
  
  public Boolean isIgnorableType(AnnotatedClass paramAnnotatedClass)
  {
    return null;
  }
  
  public Boolean isTypeId(AnnotatedMember paramAnnotatedMember)
  {
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/AnnotationIntrospector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */