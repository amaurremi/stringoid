package org.codehaus.jackson.map.introspect;

import java.lang.annotation.Annotation;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.annotate.JsonSerialize.Typing;
import org.codehaus.jackson.type.JavaType;

public class NopAnnotationIntrospector
  extends AnnotationIntrospector
{
  public static final NopAnnotationIntrospector instance = new NopAnnotationIntrospector();
  
  public Class findContentDeserializer(Annotated paramAnnotated)
  {
    return null;
  }
  
  public String findDeserializablePropertyName(AnnotatedField paramAnnotatedField)
  {
    return null;
  }
  
  public Class findDeserializationContentType(Annotated paramAnnotated, JavaType paramJavaType, String paramString)
  {
    return null;
  }
  
  public Class findDeserializationKeyType(Annotated paramAnnotated, JavaType paramJavaType, String paramString)
  {
    return null;
  }
  
  public Class findDeserializationType(Annotated paramAnnotated, JavaType paramJavaType, String paramString)
  {
    return null;
  }
  
  public Object findDeserializer(Annotated paramAnnotated)
  {
    return null;
  }
  
  public String findEnumValue(Enum paramEnum)
  {
    return null;
  }
  
  public String findGettablePropertyName(AnnotatedMethod paramAnnotatedMethod)
  {
    return null;
  }
  
  public Boolean findIgnoreUnknownProperties(AnnotatedClass paramAnnotatedClass)
  {
    return null;
  }
  
  public Class findKeyDeserializer(Annotated paramAnnotated)
  {
    return null;
  }
  
  public String[] findPropertiesToIgnore(AnnotatedClass paramAnnotatedClass)
  {
    return null;
  }
  
  public String findPropertyNameForParam(AnnotatedParameter paramAnnotatedParameter)
  {
    return null;
  }
  
  public String findRootName(AnnotatedClass paramAnnotatedClass)
  {
    return null;
  }
  
  public String findSerializablePropertyName(AnnotatedField paramAnnotatedField)
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
  
  public Class findSerializationType(Annotated paramAnnotated)
  {
    return null;
  }
  
  public JsonSerialize.Typing findSerializationTyping(Annotated paramAnnotated)
  {
    return null;
  }
  
  public Class[] findSerializationViews(Annotated paramAnnotated)
  {
    return null;
  }
  
  public Object findSerializer(Annotated paramAnnotated)
  {
    return null;
  }
  
  public String findSettablePropertyName(AnnotatedMethod paramAnnotatedMethod)
  {
    return null;
  }
  
  public boolean hasAsValueAnnotation(AnnotatedMethod paramAnnotatedMethod)
  {
    return false;
  }
  
  public boolean hasIgnoreMarker(AnnotatedMember paramAnnotatedMember)
  {
    return false;
  }
  
  public boolean isHandled(Annotation paramAnnotation)
  {
    return false;
  }
  
  public boolean isIgnorableConstructor(AnnotatedConstructor paramAnnotatedConstructor)
  {
    return false;
  }
  
  public boolean isIgnorableField(AnnotatedField paramAnnotatedField)
  {
    return false;
  }
  
  public boolean isIgnorableMethod(AnnotatedMethod paramAnnotatedMethod)
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/introspect/NopAnnotationIntrospector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */