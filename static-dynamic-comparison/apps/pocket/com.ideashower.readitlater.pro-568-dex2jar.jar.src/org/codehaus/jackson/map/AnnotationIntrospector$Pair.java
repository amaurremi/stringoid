package org.codehaus.jackson.map;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
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
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.type.JavaType;

public class AnnotationIntrospector$Pair
  extends AnnotationIntrospector
{
  protected final AnnotationIntrospector _primary;
  protected final AnnotationIntrospector _secondary;
  
  public AnnotationIntrospector$Pair(AnnotationIntrospector paramAnnotationIntrospector1, AnnotationIntrospector paramAnnotationIntrospector2)
  {
    this._primary = paramAnnotationIntrospector1;
    this._secondary = paramAnnotationIntrospector2;
  }
  
  public static AnnotationIntrospector create(AnnotationIntrospector paramAnnotationIntrospector1, AnnotationIntrospector paramAnnotationIntrospector2)
  {
    if (paramAnnotationIntrospector1 == null) {
      return paramAnnotationIntrospector2;
    }
    if (paramAnnotationIntrospector2 == null) {
      return paramAnnotationIntrospector1;
    }
    return new Pair(paramAnnotationIntrospector1, paramAnnotationIntrospector2);
  }
  
  public Collection allIntrospectors()
  {
    return allIntrospectors(new ArrayList());
  }
  
  public Collection allIntrospectors(Collection paramCollection)
  {
    this._primary.allIntrospectors(paramCollection);
    this._secondary.allIntrospectors(paramCollection);
    return paramCollection;
  }
  
  public VisibilityChecker findAutoDetectVisibility(AnnotatedClass paramAnnotatedClass, VisibilityChecker paramVisibilityChecker)
  {
    paramVisibilityChecker = this._secondary.findAutoDetectVisibility(paramAnnotatedClass, paramVisibilityChecker);
    return this._primary.findAutoDetectVisibility(paramAnnotatedClass, paramVisibilityChecker);
  }
  
  public Boolean findCachability(AnnotatedClass paramAnnotatedClass)
  {
    Boolean localBoolean2 = this._primary.findCachability(paramAnnotatedClass);
    Boolean localBoolean1 = localBoolean2;
    if (localBoolean2 == null) {
      localBoolean1 = this._secondary.findCachability(paramAnnotatedClass);
    }
    return localBoolean1;
  }
  
  public Class findContentDeserializer(Annotated paramAnnotated)
  {
    Class localClass2 = this._primary.findContentDeserializer(paramAnnotated);
    Class localClass1;
    if (localClass2 != null)
    {
      localClass1 = localClass2;
      if (localClass2 != JsonDeserializer.None.class) {}
    }
    else
    {
      localClass1 = this._secondary.findContentDeserializer(paramAnnotated);
    }
    return localClass1;
  }
  
  public Class findContentSerializer(Annotated paramAnnotated)
  {
    Class localClass2 = this._primary.findContentSerializer(paramAnnotated);
    Class localClass1;
    if (localClass2 != null)
    {
      localClass1 = localClass2;
      if (localClass2 != JsonSerializer.None.class) {}
    }
    else
    {
      localClass1 = this._secondary.findContentSerializer(paramAnnotated);
    }
    return localClass1;
  }
  
  public String findDeserializablePropertyName(AnnotatedField paramAnnotatedField)
  {
    String str2 = this._primary.findDeserializablePropertyName(paramAnnotatedField);
    if (str2 == null) {
      paramAnnotatedField = this._secondary.findDeserializablePropertyName(paramAnnotatedField);
    }
    String str1;
    do
    {
      return paramAnnotatedField;
      if (str2.length() != 0) {
        break;
      }
      str1 = this._secondary.findDeserializablePropertyName(paramAnnotatedField);
      paramAnnotatedField = str1;
    } while (str1 != null);
    return str2;
  }
  
  public Class findDeserializationContentType(Annotated paramAnnotated, JavaType paramJavaType, String paramString)
  {
    Class localClass2 = this._primary.findDeserializationContentType(paramAnnotated, paramJavaType, paramString);
    Class localClass1 = localClass2;
    if (localClass2 == null) {
      localClass1 = this._secondary.findDeserializationContentType(paramAnnotated, paramJavaType, paramString);
    }
    return localClass1;
  }
  
  public Class findDeserializationKeyType(Annotated paramAnnotated, JavaType paramJavaType, String paramString)
  {
    Class localClass2 = this._primary.findDeserializationKeyType(paramAnnotated, paramJavaType, paramString);
    Class localClass1 = localClass2;
    if (localClass2 == null) {
      localClass1 = this._secondary.findDeserializationKeyType(paramAnnotated, paramJavaType, paramString);
    }
    return localClass1;
  }
  
  public Class findDeserializationType(Annotated paramAnnotated, JavaType paramJavaType, String paramString)
  {
    Class localClass2 = this._primary.findDeserializationType(paramAnnotated, paramJavaType, paramString);
    Class localClass1 = localClass2;
    if (localClass2 == null) {
      localClass1 = this._secondary.findDeserializationType(paramAnnotated, paramJavaType, paramString);
    }
    return localClass1;
  }
  
  public Object findDeserializer(Annotated paramAnnotated)
  {
    Object localObject2 = this._primary.findDeserializer(paramAnnotated);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this._secondary.findDeserializer(paramAnnotated);
    }
    return localObject1;
  }
  
  public String findEnumValue(Enum paramEnum)
  {
    String str2 = this._primary.findEnumValue(paramEnum);
    String str1 = str2;
    if (str2 == null) {
      str1 = this._secondary.findEnumValue(paramEnum);
    }
    return str1;
  }
  
  public Object findFilterId(AnnotatedClass paramAnnotatedClass)
  {
    Object localObject2 = this._primary.findFilterId(paramAnnotatedClass);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this._secondary.findFilterId(paramAnnotatedClass);
    }
    return localObject1;
  }
  
  public String findGettablePropertyName(AnnotatedMethod paramAnnotatedMethod)
  {
    String str2 = this._primary.findGettablePropertyName(paramAnnotatedMethod);
    if (str2 == null) {
      paramAnnotatedMethod = this._secondary.findGettablePropertyName(paramAnnotatedMethod);
    }
    String str1;
    do
    {
      return paramAnnotatedMethod;
      if (str2.length() != 0) {
        break;
      }
      str1 = this._secondary.findGettablePropertyName(paramAnnotatedMethod);
      paramAnnotatedMethod = str1;
    } while (str1 != null);
    return str2;
  }
  
  public Boolean findIgnoreUnknownProperties(AnnotatedClass paramAnnotatedClass)
  {
    Boolean localBoolean2 = this._primary.findIgnoreUnknownProperties(paramAnnotatedClass);
    Boolean localBoolean1 = localBoolean2;
    if (localBoolean2 == null) {
      localBoolean1 = this._secondary.findIgnoreUnknownProperties(paramAnnotatedClass);
    }
    return localBoolean1;
  }
  
  public Object findInjectableValueId(AnnotatedMember paramAnnotatedMember)
  {
    Object localObject2 = this._primary.findInjectableValueId(paramAnnotatedMember);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this._secondary.findInjectableValueId(paramAnnotatedMember);
    }
    return localObject1;
  }
  
  public Class findKeyDeserializer(Annotated paramAnnotated)
  {
    Class localClass2 = this._primary.findKeyDeserializer(paramAnnotated);
    Class localClass1;
    if (localClass2 != null)
    {
      localClass1 = localClass2;
      if (localClass2 != KeyDeserializer.None.class) {}
    }
    else
    {
      localClass1 = this._secondary.findKeyDeserializer(paramAnnotated);
    }
    return localClass1;
  }
  
  public Class findKeySerializer(Annotated paramAnnotated)
  {
    Class localClass2 = this._primary.findKeySerializer(paramAnnotated);
    Class localClass1;
    if (localClass2 != null)
    {
      localClass1 = localClass2;
      if (localClass2 != JsonSerializer.None.class) {}
    }
    else
    {
      localClass1 = this._secondary.findKeySerializer(paramAnnotated);
    }
    return localClass1;
  }
  
  public String[] findPropertiesToIgnore(AnnotatedClass paramAnnotatedClass)
  {
    String[] arrayOfString2 = this._primary.findPropertiesToIgnore(paramAnnotatedClass);
    String[] arrayOfString1 = arrayOfString2;
    if (arrayOfString2 == null) {
      arrayOfString1 = this._secondary.findPropertiesToIgnore(paramAnnotatedClass);
    }
    return arrayOfString1;
  }
  
  public TypeResolverBuilder findPropertyContentTypeResolver(MapperConfig paramMapperConfig, AnnotatedMember paramAnnotatedMember, JavaType paramJavaType)
  {
    TypeResolverBuilder localTypeResolverBuilder2 = this._primary.findPropertyContentTypeResolver(paramMapperConfig, paramAnnotatedMember, paramJavaType);
    TypeResolverBuilder localTypeResolverBuilder1 = localTypeResolverBuilder2;
    if (localTypeResolverBuilder2 == null) {
      localTypeResolverBuilder1 = this._secondary.findPropertyContentTypeResolver(paramMapperConfig, paramAnnotatedMember, paramJavaType);
    }
    return localTypeResolverBuilder1;
  }
  
  public String findPropertyNameForParam(AnnotatedParameter paramAnnotatedParameter)
  {
    String str2 = this._primary.findPropertyNameForParam(paramAnnotatedParameter);
    String str1 = str2;
    if (str2 == null) {
      str1 = this._secondary.findPropertyNameForParam(paramAnnotatedParameter);
    }
    return str1;
  }
  
  public TypeResolverBuilder findPropertyTypeResolver(MapperConfig paramMapperConfig, AnnotatedMember paramAnnotatedMember, JavaType paramJavaType)
  {
    TypeResolverBuilder localTypeResolverBuilder2 = this._primary.findPropertyTypeResolver(paramMapperConfig, paramAnnotatedMember, paramJavaType);
    TypeResolverBuilder localTypeResolverBuilder1 = localTypeResolverBuilder2;
    if (localTypeResolverBuilder2 == null) {
      localTypeResolverBuilder1 = this._secondary.findPropertyTypeResolver(paramMapperConfig, paramAnnotatedMember, paramJavaType);
    }
    return localTypeResolverBuilder1;
  }
  
  public AnnotationIntrospector.ReferenceProperty findReferenceType(AnnotatedMember paramAnnotatedMember)
  {
    AnnotationIntrospector.ReferenceProperty localReferenceProperty2 = this._primary.findReferenceType(paramAnnotatedMember);
    AnnotationIntrospector.ReferenceProperty localReferenceProperty1 = localReferenceProperty2;
    if (localReferenceProperty2 == null) {
      localReferenceProperty1 = this._secondary.findReferenceType(paramAnnotatedMember);
    }
    return localReferenceProperty1;
  }
  
  public String findRootName(AnnotatedClass paramAnnotatedClass)
  {
    String str2 = this._primary.findRootName(paramAnnotatedClass);
    String str1;
    if (str2 == null) {
      str1 = this._secondary.findRootName(paramAnnotatedClass);
    }
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (str2.length() > 0);
      paramAnnotatedClass = this._secondary.findRootName(paramAnnotatedClass);
      str1 = str2;
    } while (paramAnnotatedClass == null);
    return paramAnnotatedClass;
  }
  
  public String findSerializablePropertyName(AnnotatedField paramAnnotatedField)
  {
    String str2 = this._primary.findSerializablePropertyName(paramAnnotatedField);
    if (str2 == null) {
      paramAnnotatedField = this._secondary.findSerializablePropertyName(paramAnnotatedField);
    }
    String str1;
    do
    {
      return paramAnnotatedField;
      if (str2.length() != 0) {
        break;
      }
      str1 = this._secondary.findSerializablePropertyName(paramAnnotatedField);
      paramAnnotatedField = str1;
    } while (str1 != null);
    return str2;
  }
  
  public Class findSerializationContentType(Annotated paramAnnotated, JavaType paramJavaType)
  {
    Class localClass2 = this._primary.findSerializationContentType(paramAnnotated, paramJavaType);
    Class localClass1 = localClass2;
    if (localClass2 == null) {
      localClass1 = this._secondary.findSerializationContentType(paramAnnotated, paramJavaType);
    }
    return localClass1;
  }
  
  public JsonSerialize.Inclusion findSerializationInclusion(Annotated paramAnnotated, JsonSerialize.Inclusion paramInclusion)
  {
    paramInclusion = this._secondary.findSerializationInclusion(paramAnnotated, paramInclusion);
    return this._primary.findSerializationInclusion(paramAnnotated, paramInclusion);
  }
  
  public Class findSerializationKeyType(Annotated paramAnnotated, JavaType paramJavaType)
  {
    Class localClass2 = this._primary.findSerializationKeyType(paramAnnotated, paramJavaType);
    Class localClass1 = localClass2;
    if (localClass2 == null) {
      localClass1 = this._secondary.findSerializationKeyType(paramAnnotated, paramJavaType);
    }
    return localClass1;
  }
  
  public String[] findSerializationPropertyOrder(AnnotatedClass paramAnnotatedClass)
  {
    String[] arrayOfString2 = this._primary.findSerializationPropertyOrder(paramAnnotatedClass);
    String[] arrayOfString1 = arrayOfString2;
    if (arrayOfString2 == null) {
      arrayOfString1 = this._secondary.findSerializationPropertyOrder(paramAnnotatedClass);
    }
    return arrayOfString1;
  }
  
  public Boolean findSerializationSortAlphabetically(AnnotatedClass paramAnnotatedClass)
  {
    Boolean localBoolean2 = this._primary.findSerializationSortAlphabetically(paramAnnotatedClass);
    Boolean localBoolean1 = localBoolean2;
    if (localBoolean2 == null) {
      localBoolean1 = this._secondary.findSerializationSortAlphabetically(paramAnnotatedClass);
    }
    return localBoolean1;
  }
  
  public Class findSerializationType(Annotated paramAnnotated)
  {
    Class localClass2 = this._primary.findSerializationType(paramAnnotated);
    Class localClass1 = localClass2;
    if (localClass2 == null) {
      localClass1 = this._secondary.findSerializationType(paramAnnotated);
    }
    return localClass1;
  }
  
  public JsonSerialize.Typing findSerializationTyping(Annotated paramAnnotated)
  {
    JsonSerialize.Typing localTyping2 = this._primary.findSerializationTyping(paramAnnotated);
    JsonSerialize.Typing localTyping1 = localTyping2;
    if (localTyping2 == null) {
      localTyping1 = this._secondary.findSerializationTyping(paramAnnotated);
    }
    return localTyping1;
  }
  
  public Class[] findSerializationViews(Annotated paramAnnotated)
  {
    Class[] arrayOfClass2 = this._primary.findSerializationViews(paramAnnotated);
    Class[] arrayOfClass1 = arrayOfClass2;
    if (arrayOfClass2 == null) {
      arrayOfClass1 = this._secondary.findSerializationViews(paramAnnotated);
    }
    return arrayOfClass1;
  }
  
  public Object findSerializer(Annotated paramAnnotated)
  {
    Object localObject2 = this._primary.findSerializer(paramAnnotated);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this._secondary.findSerializer(paramAnnotated);
    }
    return localObject1;
  }
  
  public String findSettablePropertyName(AnnotatedMethod paramAnnotatedMethod)
  {
    String str2 = this._primary.findSettablePropertyName(paramAnnotatedMethod);
    if (str2 == null) {
      paramAnnotatedMethod = this._secondary.findSettablePropertyName(paramAnnotatedMethod);
    }
    String str1;
    do
    {
      return paramAnnotatedMethod;
      if (str2.length() != 0) {
        break;
      }
      str1 = this._secondary.findSettablePropertyName(paramAnnotatedMethod);
      paramAnnotatedMethod = str1;
    } while (str1 != null);
    return str2;
  }
  
  public List findSubtypes(Annotated paramAnnotated)
  {
    List localList = this._primary.findSubtypes(paramAnnotated);
    paramAnnotated = this._secondary.findSubtypes(paramAnnotated);
    if ((localList == null) || (localList.isEmpty())) {
      return paramAnnotated;
    }
    if ((paramAnnotated == null) || (paramAnnotated.isEmpty())) {
      return localList;
    }
    ArrayList localArrayList = new ArrayList(localList.size() + paramAnnotated.size());
    localArrayList.addAll(localList);
    localArrayList.addAll(paramAnnotated);
    return localArrayList;
  }
  
  public String findTypeName(AnnotatedClass paramAnnotatedClass)
  {
    String str2 = this._primary.findTypeName(paramAnnotatedClass);
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = this._secondary.findTypeName(paramAnnotatedClass);
    }
    return str1;
  }
  
  public TypeResolverBuilder findTypeResolver(MapperConfig paramMapperConfig, AnnotatedClass paramAnnotatedClass, JavaType paramJavaType)
  {
    TypeResolverBuilder localTypeResolverBuilder2 = this._primary.findTypeResolver(paramMapperConfig, paramAnnotatedClass, paramJavaType);
    TypeResolverBuilder localTypeResolverBuilder1 = localTypeResolverBuilder2;
    if (localTypeResolverBuilder2 == null) {
      localTypeResolverBuilder1 = this._secondary.findTypeResolver(paramMapperConfig, paramAnnotatedClass, paramJavaType);
    }
    return localTypeResolverBuilder1;
  }
  
  public Object findValueInstantiator(AnnotatedClass paramAnnotatedClass)
  {
    Object localObject2 = this._primary.findValueInstantiator(paramAnnotatedClass);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this._secondary.findValueInstantiator(paramAnnotatedClass);
    }
    return localObject1;
  }
  
  public boolean hasAnyGetterAnnotation(AnnotatedMethod paramAnnotatedMethod)
  {
    return (this._primary.hasAnyGetterAnnotation(paramAnnotatedMethod)) || (this._secondary.hasAnyGetterAnnotation(paramAnnotatedMethod));
  }
  
  public boolean hasAnySetterAnnotation(AnnotatedMethod paramAnnotatedMethod)
  {
    return (this._primary.hasAnySetterAnnotation(paramAnnotatedMethod)) || (this._secondary.hasAnySetterAnnotation(paramAnnotatedMethod));
  }
  
  public boolean hasAsValueAnnotation(AnnotatedMethod paramAnnotatedMethod)
  {
    return (this._primary.hasAsValueAnnotation(paramAnnotatedMethod)) || (this._secondary.hasAsValueAnnotation(paramAnnotatedMethod));
  }
  
  public boolean hasCreatorAnnotation(Annotated paramAnnotated)
  {
    return (this._primary.hasCreatorAnnotation(paramAnnotated)) || (this._secondary.hasCreatorAnnotation(paramAnnotated));
  }
  
  public boolean hasIgnoreMarker(AnnotatedMember paramAnnotatedMember)
  {
    return (this._primary.hasIgnoreMarker(paramAnnotatedMember)) || (this._secondary.hasIgnoreMarker(paramAnnotatedMember));
  }
  
  public boolean isHandled(Annotation paramAnnotation)
  {
    return (this._primary.isHandled(paramAnnotation)) || (this._secondary.isHandled(paramAnnotation));
  }
  
  public boolean isIgnorableConstructor(AnnotatedConstructor paramAnnotatedConstructor)
  {
    return (this._primary.isIgnorableConstructor(paramAnnotatedConstructor)) || (this._secondary.isIgnorableConstructor(paramAnnotatedConstructor));
  }
  
  public boolean isIgnorableField(AnnotatedField paramAnnotatedField)
  {
    return (this._primary.isIgnorableField(paramAnnotatedField)) || (this._secondary.isIgnorableField(paramAnnotatedField));
  }
  
  public boolean isIgnorableMethod(AnnotatedMethod paramAnnotatedMethod)
  {
    return (this._primary.isIgnorableMethod(paramAnnotatedMethod)) || (this._secondary.isIgnorableMethod(paramAnnotatedMethod));
  }
  
  public Boolean isIgnorableType(AnnotatedClass paramAnnotatedClass)
  {
    Boolean localBoolean2 = this._primary.isIgnorableType(paramAnnotatedClass);
    Boolean localBoolean1 = localBoolean2;
    if (localBoolean2 == null) {
      localBoolean1 = this._secondary.isIgnorableType(paramAnnotatedClass);
    }
    return localBoolean1;
  }
  
  public Boolean shouldUnwrapProperty(AnnotatedMember paramAnnotatedMember)
  {
    Boolean localBoolean2 = this._primary.shouldUnwrapProperty(paramAnnotatedMember);
    Boolean localBoolean1 = localBoolean2;
    if (localBoolean2 == null) {
      localBoolean1 = this._secondary.shouldUnwrapProperty(paramAnnotatedMember);
    }
    return localBoolean1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/AnnotationIntrospector$Pair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */