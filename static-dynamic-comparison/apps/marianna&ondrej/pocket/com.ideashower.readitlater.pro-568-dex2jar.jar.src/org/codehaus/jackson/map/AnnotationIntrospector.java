package org.codehaus.jackson.map;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.annotate.JsonSerialize.Typing;
import org.codehaus.jackson.map.introspect.Annotated;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.AnnotatedParameter;
import org.codehaus.jackson.map.introspect.NopAnnotationIntrospector;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.type.JavaType;

public abstract class AnnotationIntrospector
{
  public static AnnotationIntrospector nopInstance()
  {
    return NopAnnotationIntrospector.instance;
  }
  
  public static AnnotationIntrospector pair(AnnotationIntrospector paramAnnotationIntrospector1, AnnotationIntrospector paramAnnotationIntrospector2)
  {
    return new AnnotationIntrospector.Pair(paramAnnotationIntrospector1, paramAnnotationIntrospector2);
  }
  
  public Collection allIntrospectors()
  {
    return Collections.singletonList(this);
  }
  
  public Collection allIntrospectors(Collection paramCollection)
  {
    paramCollection.add(this);
    return paramCollection;
  }
  
  public VisibilityChecker findAutoDetectVisibility(AnnotatedClass paramAnnotatedClass, VisibilityChecker paramVisibilityChecker)
  {
    return paramVisibilityChecker;
  }
  
  public Boolean findCachability(AnnotatedClass paramAnnotatedClass)
  {
    return null;
  }
  
  public abstract Class findContentDeserializer(Annotated paramAnnotated);
  
  public Class findContentSerializer(Annotated paramAnnotated)
  {
    return null;
  }
  
  public abstract String findDeserializablePropertyName(AnnotatedField paramAnnotatedField);
  
  public abstract Class findDeserializationContentType(Annotated paramAnnotated, JavaType paramJavaType, String paramString);
  
  public abstract Class findDeserializationKeyType(Annotated paramAnnotated, JavaType paramJavaType, String paramString);
  
  public abstract Class findDeserializationType(Annotated paramAnnotated, JavaType paramJavaType, String paramString);
  
  public abstract Object findDeserializer(Annotated paramAnnotated);
  
  public abstract String findEnumValue(Enum paramEnum);
  
  public Object findFilterId(AnnotatedClass paramAnnotatedClass)
  {
    return null;
  }
  
  public abstract String findGettablePropertyName(AnnotatedMethod paramAnnotatedMethod);
  
  public abstract Boolean findIgnoreUnknownProperties(AnnotatedClass paramAnnotatedClass);
  
  public Object findInjectableValueId(AnnotatedMember paramAnnotatedMember)
  {
    return null;
  }
  
  public abstract Class findKeyDeserializer(Annotated paramAnnotated);
  
  public Class findKeySerializer(Annotated paramAnnotated)
  {
    return null;
  }
  
  public abstract String[] findPropertiesToIgnore(AnnotatedClass paramAnnotatedClass);
  
  public TypeResolverBuilder findPropertyContentTypeResolver(MapperConfig paramMapperConfig, AnnotatedMember paramAnnotatedMember, JavaType paramJavaType)
  {
    return null;
  }
  
  public abstract String findPropertyNameForParam(AnnotatedParameter paramAnnotatedParameter);
  
  public TypeResolverBuilder findPropertyTypeResolver(MapperConfig paramMapperConfig, AnnotatedMember paramAnnotatedMember, JavaType paramJavaType)
  {
    return null;
  }
  
  public AnnotationIntrospector.ReferenceProperty findReferenceType(AnnotatedMember paramAnnotatedMember)
  {
    return null;
  }
  
  public abstract String findRootName(AnnotatedClass paramAnnotatedClass);
  
  public abstract String findSerializablePropertyName(AnnotatedField paramAnnotatedField);
  
  public Class findSerializationContentType(Annotated paramAnnotated, JavaType paramJavaType)
  {
    return null;
  }
  
  public JsonSerialize.Inclusion findSerializationInclusion(Annotated paramAnnotated, JsonSerialize.Inclusion paramInclusion)
  {
    return paramInclusion;
  }
  
  public Class findSerializationKeyType(Annotated paramAnnotated, JavaType paramJavaType)
  {
    return null;
  }
  
  public abstract String[] findSerializationPropertyOrder(AnnotatedClass paramAnnotatedClass);
  
  public abstract Boolean findSerializationSortAlphabetically(AnnotatedClass paramAnnotatedClass);
  
  public abstract Class findSerializationType(Annotated paramAnnotated);
  
  public abstract JsonSerialize.Typing findSerializationTyping(Annotated paramAnnotated);
  
  public abstract Class[] findSerializationViews(Annotated paramAnnotated);
  
  public abstract Object findSerializer(Annotated paramAnnotated);
  
  public abstract String findSettablePropertyName(AnnotatedMethod paramAnnotatedMethod);
  
  public List findSubtypes(Annotated paramAnnotated)
  {
    return null;
  }
  
  public String findTypeName(AnnotatedClass paramAnnotatedClass)
  {
    return null;
  }
  
  public TypeResolverBuilder findTypeResolver(MapperConfig paramMapperConfig, AnnotatedClass paramAnnotatedClass, JavaType paramJavaType)
  {
    return null;
  }
  
  public Object findValueInstantiator(AnnotatedClass paramAnnotatedClass)
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
  
  public abstract boolean hasAsValueAnnotation(AnnotatedMethod paramAnnotatedMethod);
  
  public boolean hasCreatorAnnotation(Annotated paramAnnotated)
  {
    return false;
  }
  
  public boolean hasIgnoreMarker(AnnotatedMember paramAnnotatedMember)
  {
    if ((paramAnnotatedMember instanceof AnnotatedMethod)) {
      return isIgnorableMethod((AnnotatedMethod)paramAnnotatedMember);
    }
    if ((paramAnnotatedMember instanceof AnnotatedField)) {
      return isIgnorableField((AnnotatedField)paramAnnotatedMember);
    }
    if ((paramAnnotatedMember instanceof AnnotatedConstructor)) {
      return isIgnorableConstructor((AnnotatedConstructor)paramAnnotatedMember);
    }
    return false;
  }
  
  public abstract boolean isHandled(Annotation paramAnnotation);
  
  public abstract boolean isIgnorableConstructor(AnnotatedConstructor paramAnnotatedConstructor);
  
  public abstract boolean isIgnorableField(AnnotatedField paramAnnotatedField);
  
  public abstract boolean isIgnorableMethod(AnnotatedMethod paramAnnotatedMethod);
  
  public Boolean isIgnorableType(AnnotatedClass paramAnnotatedClass)
  {
    return null;
  }
  
  public Boolean shouldUnwrapProperty(AnnotatedMember paramAnnotatedMember)
  {
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/AnnotationIntrospector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */