package com.flurry.org.codehaus.jackson.map.introspect;

import com.flurry.org.codehaus.jackson.annotate.JacksonAnnotation;
import com.flurry.org.codehaus.jackson.annotate.JsonAnyGetter;
import com.flurry.org.codehaus.jackson.annotate.JsonAnySetter;
import com.flurry.org.codehaus.jackson.annotate.JsonAutoDetect;
import com.flurry.org.codehaus.jackson.annotate.JsonBackReference;
import com.flurry.org.codehaus.jackson.annotate.JsonCreator;
import com.flurry.org.codehaus.jackson.annotate.JsonGetter;
import com.flurry.org.codehaus.jackson.annotate.JsonIgnore;
import com.flurry.org.codehaus.jackson.annotate.JsonIgnoreProperties;
import com.flurry.org.codehaus.jackson.annotate.JsonIgnoreType;
import com.flurry.org.codehaus.jackson.annotate.JsonManagedReference;
import com.flurry.org.codehaus.jackson.annotate.JsonProperty;
import com.flurry.org.codehaus.jackson.annotate.JsonPropertyOrder;
import com.flurry.org.codehaus.jackson.annotate.JsonRawValue;
import com.flurry.org.codehaus.jackson.annotate.JsonSetter;
import com.flurry.org.codehaus.jackson.annotate.JsonSubTypes;
import com.flurry.org.codehaus.jackson.annotate.JsonSubTypes.Type;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.As;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.Id;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo.None;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeName;
import com.flurry.org.codehaus.jackson.annotate.JsonUnwrapped;
import com.flurry.org.codehaus.jackson.annotate.JsonValue;
import com.flurry.org.codehaus.jackson.annotate.JsonWriteNullProperties;
import com.flurry.org.codehaus.jackson.map.AnnotationIntrospector;
import com.flurry.org.codehaus.jackson.map.AnnotationIntrospector.ReferenceProperty;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer.None;
import com.flurry.org.codehaus.jackson.map.JsonSerializer;
import com.flurry.org.codehaus.jackson.map.JsonSerializer.None;
import com.flurry.org.codehaus.jackson.map.KeyDeserializer;
import com.flurry.org.codehaus.jackson.map.KeyDeserializer.None;
import com.flurry.org.codehaus.jackson.map.MapperConfig;
import com.flurry.org.codehaus.jackson.map.annotate.JacksonInject;
import com.flurry.org.codehaus.jackson.map.annotate.JsonCachable;
import com.flurry.org.codehaus.jackson.map.annotate.JsonDeserialize;
import com.flurry.org.codehaus.jackson.map.annotate.JsonFilter;
import com.flurry.org.codehaus.jackson.map.annotate.JsonRootName;
import com.flurry.org.codehaus.jackson.map.annotate.JsonSerialize;
import com.flurry.org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import com.flurry.org.codehaus.jackson.map.annotate.JsonSerialize.Typing;
import com.flurry.org.codehaus.jackson.map.annotate.JsonTypeIdResolver;
import com.flurry.org.codehaus.jackson.map.annotate.JsonTypeResolver;
import com.flurry.org.codehaus.jackson.map.annotate.JsonValueInstantiator;
import com.flurry.org.codehaus.jackson.map.annotate.JsonView;
import com.flurry.org.codehaus.jackson.map.annotate.NoClass;
import com.flurry.org.codehaus.jackson.map.jsontype.NamedType;
import com.flurry.org.codehaus.jackson.map.jsontype.TypeIdResolver;
import com.flurry.org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import com.flurry.org.codehaus.jackson.map.jsontype.impl.StdTypeResolverBuilder;
import com.flurry.org.codehaus.jackson.map.ser.std.RawSerializer;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class JacksonAnnotationIntrospector
  extends AnnotationIntrospector
{
  protected StdTypeResolverBuilder _constructNoTypeResolverBuilder()
  {
    return StdTypeResolverBuilder.noTypeInfoBuilder();
  }
  
  protected StdTypeResolverBuilder _constructStdTypeResolverBuilder()
  {
    return new StdTypeResolverBuilder();
  }
  
  protected TypeResolverBuilder<?> _findTypeResolver(MapperConfig<?> paramMapperConfig, Annotated paramAnnotated, JavaType paramJavaType)
  {
    JsonTypeInfo localJsonTypeInfo = (JsonTypeInfo)paramAnnotated.getAnnotation(JsonTypeInfo.class);
    Object localObject = (JsonTypeResolver)paramAnnotated.getAnnotation(JsonTypeResolver.class);
    label50:
    JsonTypeIdResolver localJsonTypeIdResolver;
    if (localObject != null)
    {
      if (localJsonTypeInfo == null)
      {
        paramMapperConfig = null;
        return paramMapperConfig;
      }
      localObject = paramMapperConfig.typeResolverBuilderInstance(paramAnnotated, ((JsonTypeResolver)localObject).value());
      localJsonTypeIdResolver = (JsonTypeIdResolver)paramAnnotated.getAnnotation(JsonTypeIdResolver.class);
      if (localJsonTypeIdResolver != null) {
        break label205;
      }
    }
    label205:
    for (paramMapperConfig = null;; paramMapperConfig = paramMapperConfig.typeIdResolverInstance(paramAnnotated, localJsonTypeIdResolver.value()))
    {
      if (paramMapperConfig != null) {
        paramMapperConfig.init(paramJavaType);
      }
      localObject = ((TypeResolverBuilder)localObject).init(localJsonTypeInfo.use(), paramMapperConfig);
      paramJavaType = localJsonTypeInfo.include();
      paramMapperConfig = paramJavaType;
      if (paramJavaType == JsonTypeInfo.As.EXTERNAL_PROPERTY)
      {
        paramMapperConfig = paramJavaType;
        if ((paramAnnotated instanceof AnnotatedClass)) {
          paramMapperConfig = JsonTypeInfo.As.PROPERTY;
        }
      }
      paramAnnotated = ((TypeResolverBuilder)localObject).inclusion(paramMapperConfig).typeProperty(localJsonTypeInfo.property());
      paramJavaType = localJsonTypeInfo.defaultImpl();
      paramMapperConfig = paramAnnotated;
      if (paramJavaType == JsonTypeInfo.None.class) {
        break;
      }
      return paramAnnotated.defaultImpl(paramJavaType);
      if (localJsonTypeInfo == null) {
        return null;
      }
      if (localJsonTypeInfo.use() == JsonTypeInfo.Id.NONE) {
        return _constructNoTypeResolverBuilder();
      }
      localObject = _constructStdTypeResolverBuilder();
      break label50;
    }
  }
  
  protected boolean _isIgnorable(Annotated paramAnnotated)
  {
    paramAnnotated = (JsonIgnore)paramAnnotated.getAnnotation(JsonIgnore.class);
    return (paramAnnotated != null) && (paramAnnotated.value());
  }
  
  public VisibilityChecker<?> findAutoDetectVisibility(AnnotatedClass paramAnnotatedClass, VisibilityChecker<?> paramVisibilityChecker)
  {
    paramAnnotatedClass = (JsonAutoDetect)paramAnnotatedClass.getAnnotation(JsonAutoDetect.class);
    if (paramAnnotatedClass == null) {
      return paramVisibilityChecker;
    }
    return paramVisibilityChecker.with(paramAnnotatedClass);
  }
  
  public Boolean findCachability(AnnotatedClass paramAnnotatedClass)
  {
    paramAnnotatedClass = (JsonCachable)paramAnnotatedClass.getAnnotation(JsonCachable.class);
    if (paramAnnotatedClass == null) {
      return null;
    }
    if (paramAnnotatedClass.value()) {
      return Boolean.TRUE;
    }
    return Boolean.FALSE;
  }
  
  public Class<? extends JsonDeserializer<?>> findContentDeserializer(Annotated paramAnnotated)
  {
    paramAnnotated = (JsonDeserialize)paramAnnotated.getAnnotation(JsonDeserialize.class);
    if (paramAnnotated != null)
    {
      paramAnnotated = paramAnnotated.contentUsing();
      if (paramAnnotated != JsonDeserializer.None.class) {
        return paramAnnotated;
      }
    }
    return null;
  }
  
  public Class<? extends JsonSerializer<?>> findContentSerializer(Annotated paramAnnotated)
  {
    paramAnnotated = (JsonSerialize)paramAnnotated.getAnnotation(JsonSerialize.class);
    if (paramAnnotated != null)
    {
      paramAnnotated = paramAnnotated.contentUsing();
      if (paramAnnotated != JsonSerializer.None.class) {
        return paramAnnotated;
      }
    }
    return null;
  }
  
  public String findDeserializablePropertyName(AnnotatedField paramAnnotatedField)
  {
    JsonProperty localJsonProperty = (JsonProperty)paramAnnotatedField.getAnnotation(JsonProperty.class);
    if (localJsonProperty != null) {
      return localJsonProperty.value();
    }
    if ((paramAnnotatedField.hasAnnotation(JsonDeserialize.class)) || (paramAnnotatedField.hasAnnotation(JsonView.class)) || (paramAnnotatedField.hasAnnotation(JsonBackReference.class)) || (paramAnnotatedField.hasAnnotation(JsonManagedReference.class))) {
      return "";
    }
    return null;
  }
  
  public Class<?> findDeserializationContentType(Annotated paramAnnotated, JavaType paramJavaType, String paramString)
  {
    paramAnnotated = (JsonDeserialize)paramAnnotated.getAnnotation(JsonDeserialize.class);
    if (paramAnnotated != null)
    {
      paramAnnotated = paramAnnotated.contentAs();
      if (paramAnnotated != NoClass.class) {
        return paramAnnotated;
      }
    }
    return null;
  }
  
  public Class<?> findDeserializationKeyType(Annotated paramAnnotated, JavaType paramJavaType, String paramString)
  {
    paramAnnotated = (JsonDeserialize)paramAnnotated.getAnnotation(JsonDeserialize.class);
    if (paramAnnotated != null)
    {
      paramAnnotated = paramAnnotated.keyAs();
      if (paramAnnotated != NoClass.class) {
        return paramAnnotated;
      }
    }
    return null;
  }
  
  public Class<?> findDeserializationType(Annotated paramAnnotated, JavaType paramJavaType, String paramString)
  {
    paramAnnotated = (JsonDeserialize)paramAnnotated.getAnnotation(JsonDeserialize.class);
    if (paramAnnotated != null)
    {
      paramAnnotated = paramAnnotated.as();
      if (paramAnnotated != NoClass.class) {
        return paramAnnotated;
      }
    }
    return null;
  }
  
  public Class<? extends JsonDeserializer<?>> findDeserializer(Annotated paramAnnotated)
  {
    paramAnnotated = (JsonDeserialize)paramAnnotated.getAnnotation(JsonDeserialize.class);
    if (paramAnnotated != null)
    {
      paramAnnotated = paramAnnotated.using();
      if (paramAnnotated != JsonDeserializer.None.class) {
        return paramAnnotated;
      }
    }
    return null;
  }
  
  public String findEnumValue(Enum<?> paramEnum)
  {
    return paramEnum.name();
  }
  
  public Object findFilterId(AnnotatedClass paramAnnotatedClass)
  {
    paramAnnotatedClass = (JsonFilter)paramAnnotatedClass.getAnnotation(JsonFilter.class);
    if (paramAnnotatedClass != null)
    {
      paramAnnotatedClass = paramAnnotatedClass.value();
      if (paramAnnotatedClass.length() > 0) {
        return paramAnnotatedClass;
      }
    }
    return null;
  }
  
  public String findGettablePropertyName(AnnotatedMethod paramAnnotatedMethod)
  {
    Object localObject = (JsonProperty)paramAnnotatedMethod.getAnnotation(JsonProperty.class);
    if (localObject != null) {
      return ((JsonProperty)localObject).value();
    }
    localObject = (JsonGetter)paramAnnotatedMethod.getAnnotation(JsonGetter.class);
    if (localObject != null) {
      return ((JsonGetter)localObject).value();
    }
    if ((paramAnnotatedMethod.hasAnnotation(JsonSerialize.class)) || (paramAnnotatedMethod.hasAnnotation(JsonView.class))) {
      return "";
    }
    return null;
  }
  
  public Boolean findIgnoreUnknownProperties(AnnotatedClass paramAnnotatedClass)
  {
    paramAnnotatedClass = (JsonIgnoreProperties)paramAnnotatedClass.getAnnotation(JsonIgnoreProperties.class);
    if (paramAnnotatedClass == null) {
      return null;
    }
    return Boolean.valueOf(paramAnnotatedClass.ignoreUnknown());
  }
  
  public Object findInjectableValueId(AnnotatedMember paramAnnotatedMember)
  {
    Object localObject = (JacksonInject)paramAnnotatedMember.getAnnotation(JacksonInject.class);
    if (localObject == null) {
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = ((JacksonInject)localObject).value();
      localObject = str;
    } while (str.length() != 0);
    if (!(paramAnnotatedMember instanceof AnnotatedMethod)) {
      return paramAnnotatedMember.getRawType().getName();
    }
    localObject = (AnnotatedMethod)paramAnnotatedMember;
    if (((AnnotatedMethod)localObject).getParameterCount() == 0) {
      return paramAnnotatedMember.getRawType().getName();
    }
    return ((AnnotatedMethod)localObject).getParameterClass(0).getName();
  }
  
  public Class<? extends KeyDeserializer> findKeyDeserializer(Annotated paramAnnotated)
  {
    paramAnnotated = (JsonDeserialize)paramAnnotated.getAnnotation(JsonDeserialize.class);
    if (paramAnnotated != null)
    {
      paramAnnotated = paramAnnotated.keyUsing();
      if (paramAnnotated != KeyDeserializer.None.class) {
        return paramAnnotated;
      }
    }
    return null;
  }
  
  public Class<? extends JsonSerializer<?>> findKeySerializer(Annotated paramAnnotated)
  {
    paramAnnotated = (JsonSerialize)paramAnnotated.getAnnotation(JsonSerialize.class);
    if (paramAnnotated != null)
    {
      paramAnnotated = paramAnnotated.keyUsing();
      if (paramAnnotated != JsonSerializer.None.class) {
        return paramAnnotated;
      }
    }
    return null;
  }
  
  public String[] findPropertiesToIgnore(AnnotatedClass paramAnnotatedClass)
  {
    paramAnnotatedClass = (JsonIgnoreProperties)paramAnnotatedClass.getAnnotation(JsonIgnoreProperties.class);
    if (paramAnnotatedClass == null) {
      return null;
    }
    return paramAnnotatedClass.value();
  }
  
  public TypeResolverBuilder<?> findPropertyContentTypeResolver(MapperConfig<?> paramMapperConfig, AnnotatedMember paramAnnotatedMember, JavaType paramJavaType)
  {
    if (!paramJavaType.isContainerType()) {
      throw new IllegalArgumentException("Must call method with a container type (got " + paramJavaType + ")");
    }
    return _findTypeResolver(paramMapperConfig, paramAnnotatedMember, paramJavaType);
  }
  
  public String findPropertyNameForParam(AnnotatedParameter paramAnnotatedParameter)
  {
    if (paramAnnotatedParameter != null)
    {
      paramAnnotatedParameter = (JsonProperty)paramAnnotatedParameter.getAnnotation(JsonProperty.class);
      if (paramAnnotatedParameter != null) {
        return paramAnnotatedParameter.value();
      }
    }
    return null;
  }
  
  public TypeResolverBuilder<?> findPropertyTypeResolver(MapperConfig<?> paramMapperConfig, AnnotatedMember paramAnnotatedMember, JavaType paramJavaType)
  {
    if (paramJavaType.isContainerType()) {
      return null;
    }
    return _findTypeResolver(paramMapperConfig, paramAnnotatedMember, paramJavaType);
  }
  
  public AnnotationIntrospector.ReferenceProperty findReferenceType(AnnotatedMember paramAnnotatedMember)
  {
    JsonManagedReference localJsonManagedReference = (JsonManagedReference)paramAnnotatedMember.getAnnotation(JsonManagedReference.class);
    if (localJsonManagedReference != null) {
      return AnnotationIntrospector.ReferenceProperty.managed(localJsonManagedReference.value());
    }
    paramAnnotatedMember = (JsonBackReference)paramAnnotatedMember.getAnnotation(JsonBackReference.class);
    if (paramAnnotatedMember != null) {
      return AnnotationIntrospector.ReferenceProperty.back(paramAnnotatedMember.value());
    }
    return null;
  }
  
  public String findRootName(AnnotatedClass paramAnnotatedClass)
  {
    paramAnnotatedClass = (JsonRootName)paramAnnotatedClass.getAnnotation(JsonRootName.class);
    if (paramAnnotatedClass == null) {
      return null;
    }
    return paramAnnotatedClass.value();
  }
  
  public String findSerializablePropertyName(AnnotatedField paramAnnotatedField)
  {
    JsonProperty localJsonProperty = (JsonProperty)paramAnnotatedField.getAnnotation(JsonProperty.class);
    if (localJsonProperty != null) {
      return localJsonProperty.value();
    }
    if ((paramAnnotatedField.hasAnnotation(JsonSerialize.class)) || (paramAnnotatedField.hasAnnotation(JsonView.class))) {
      return "";
    }
    return null;
  }
  
  public Class<?> findSerializationContentType(Annotated paramAnnotated, JavaType paramJavaType)
  {
    paramAnnotated = (JsonSerialize)paramAnnotated.getAnnotation(JsonSerialize.class);
    if (paramAnnotated != null)
    {
      paramAnnotated = paramAnnotated.contentAs();
      if (paramAnnotated != NoClass.class) {
        return paramAnnotated;
      }
    }
    return null;
  }
  
  public JsonSerialize.Inclusion findSerializationInclusion(Annotated paramAnnotated, JsonSerialize.Inclusion paramInclusion)
  {
    JsonSerialize localJsonSerialize = (JsonSerialize)paramAnnotated.getAnnotation(JsonSerialize.class);
    if (localJsonSerialize != null) {
      return localJsonSerialize.include();
    }
    paramAnnotated = (JsonWriteNullProperties)paramAnnotated.getAnnotation(JsonWriteNullProperties.class);
    if (paramAnnotated != null)
    {
      if (paramAnnotated.value()) {
        return JsonSerialize.Inclusion.ALWAYS;
      }
      return JsonSerialize.Inclusion.NON_NULL;
    }
    return paramInclusion;
  }
  
  public Class<?> findSerializationKeyType(Annotated paramAnnotated, JavaType paramJavaType)
  {
    paramAnnotated = (JsonSerialize)paramAnnotated.getAnnotation(JsonSerialize.class);
    if (paramAnnotated != null)
    {
      paramAnnotated = paramAnnotated.keyAs();
      if (paramAnnotated != NoClass.class) {
        return paramAnnotated;
      }
    }
    return null;
  }
  
  public String[] findSerializationPropertyOrder(AnnotatedClass paramAnnotatedClass)
  {
    paramAnnotatedClass = (JsonPropertyOrder)paramAnnotatedClass.getAnnotation(JsonPropertyOrder.class);
    if (paramAnnotatedClass == null) {
      return null;
    }
    return paramAnnotatedClass.value();
  }
  
  public Boolean findSerializationSortAlphabetically(AnnotatedClass paramAnnotatedClass)
  {
    paramAnnotatedClass = (JsonPropertyOrder)paramAnnotatedClass.getAnnotation(JsonPropertyOrder.class);
    if (paramAnnotatedClass == null) {
      return null;
    }
    return Boolean.valueOf(paramAnnotatedClass.alphabetic());
  }
  
  public Class<?> findSerializationType(Annotated paramAnnotated)
  {
    paramAnnotated = (JsonSerialize)paramAnnotated.getAnnotation(JsonSerialize.class);
    if (paramAnnotated != null)
    {
      paramAnnotated = paramAnnotated.as();
      if (paramAnnotated != NoClass.class) {
        return paramAnnotated;
      }
    }
    return null;
  }
  
  public JsonSerialize.Typing findSerializationTyping(Annotated paramAnnotated)
  {
    paramAnnotated = (JsonSerialize)paramAnnotated.getAnnotation(JsonSerialize.class);
    if (paramAnnotated == null) {
      return null;
    }
    return paramAnnotated.typing();
  }
  
  public Class<?>[] findSerializationViews(Annotated paramAnnotated)
  {
    paramAnnotated = (JsonView)paramAnnotated.getAnnotation(JsonView.class);
    if (paramAnnotated == null) {
      return null;
    }
    return paramAnnotated.value();
  }
  
  public Object findSerializer(Annotated paramAnnotated)
  {
    Object localObject = (JsonSerialize)paramAnnotated.getAnnotation(JsonSerialize.class);
    if (localObject != null)
    {
      localObject = ((JsonSerialize)localObject).using();
      if (localObject != JsonSerializer.None.class) {
        return localObject;
      }
    }
    localObject = (JsonRawValue)paramAnnotated.getAnnotation(JsonRawValue.class);
    if ((localObject != null) && (((JsonRawValue)localObject).value())) {
      return new RawSerializer(paramAnnotated.getRawType());
    }
    return null;
  }
  
  public String findSettablePropertyName(AnnotatedMethod paramAnnotatedMethod)
  {
    Object localObject = (JsonProperty)paramAnnotatedMethod.getAnnotation(JsonProperty.class);
    if (localObject != null) {
      return ((JsonProperty)localObject).value();
    }
    localObject = (JsonSetter)paramAnnotatedMethod.getAnnotation(JsonSetter.class);
    if (localObject != null) {
      return ((JsonSetter)localObject).value();
    }
    if ((paramAnnotatedMethod.hasAnnotation(JsonDeserialize.class)) || (paramAnnotatedMethod.hasAnnotation(JsonView.class)) || (paramAnnotatedMethod.hasAnnotation(JsonBackReference.class)) || (paramAnnotatedMethod.hasAnnotation(JsonManagedReference.class))) {
      return "";
    }
    return null;
  }
  
  public List<NamedType> findSubtypes(Annotated paramAnnotated)
  {
    paramAnnotated = (JsonSubTypes)paramAnnotated.getAnnotation(JsonSubTypes.class);
    if (paramAnnotated == null)
    {
      paramAnnotated = null;
      return paramAnnotated;
    }
    JsonSubTypes.Type[] arrayOfType = paramAnnotated.value();
    ArrayList localArrayList = new ArrayList(arrayOfType.length);
    int j = arrayOfType.length;
    int i = 0;
    for (;;)
    {
      paramAnnotated = localArrayList;
      if (i >= j) {
        break;
      }
      paramAnnotated = arrayOfType[i];
      localArrayList.add(new NamedType(paramAnnotated.value(), paramAnnotated.name()));
      i += 1;
    }
  }
  
  public String findTypeName(AnnotatedClass paramAnnotatedClass)
  {
    paramAnnotatedClass = (JsonTypeName)paramAnnotatedClass.getAnnotation(JsonTypeName.class);
    if (paramAnnotatedClass == null) {
      return null;
    }
    return paramAnnotatedClass.value();
  }
  
  public TypeResolverBuilder<?> findTypeResolver(MapperConfig<?> paramMapperConfig, AnnotatedClass paramAnnotatedClass, JavaType paramJavaType)
  {
    return _findTypeResolver(paramMapperConfig, paramAnnotatedClass, paramJavaType);
  }
  
  public Object findValueInstantiator(AnnotatedClass paramAnnotatedClass)
  {
    paramAnnotatedClass = (JsonValueInstantiator)paramAnnotatedClass.getAnnotation(JsonValueInstantiator.class);
    if (paramAnnotatedClass == null) {
      return null;
    }
    return paramAnnotatedClass.value();
  }
  
  public boolean hasAnyGetterAnnotation(AnnotatedMethod paramAnnotatedMethod)
  {
    return paramAnnotatedMethod.hasAnnotation(JsonAnyGetter.class);
  }
  
  public boolean hasAnySetterAnnotation(AnnotatedMethod paramAnnotatedMethod)
  {
    return paramAnnotatedMethod.hasAnnotation(JsonAnySetter.class);
  }
  
  public boolean hasAsValueAnnotation(AnnotatedMethod paramAnnotatedMethod)
  {
    paramAnnotatedMethod = (JsonValue)paramAnnotatedMethod.getAnnotation(JsonValue.class);
    return (paramAnnotatedMethod != null) && (paramAnnotatedMethod.value());
  }
  
  public boolean hasCreatorAnnotation(Annotated paramAnnotated)
  {
    return paramAnnotated.hasAnnotation(JsonCreator.class);
  }
  
  public boolean hasIgnoreMarker(AnnotatedMember paramAnnotatedMember)
  {
    return _isIgnorable(paramAnnotatedMember);
  }
  
  public boolean isHandled(Annotation paramAnnotation)
  {
    return paramAnnotation.annotationType().getAnnotation(JacksonAnnotation.class) != null;
  }
  
  public boolean isIgnorableConstructor(AnnotatedConstructor paramAnnotatedConstructor)
  {
    return _isIgnorable(paramAnnotatedConstructor);
  }
  
  public boolean isIgnorableField(AnnotatedField paramAnnotatedField)
  {
    return _isIgnorable(paramAnnotatedField);
  }
  
  public boolean isIgnorableMethod(AnnotatedMethod paramAnnotatedMethod)
  {
    return _isIgnorable(paramAnnotatedMethod);
  }
  
  public Boolean isIgnorableType(AnnotatedClass paramAnnotatedClass)
  {
    paramAnnotatedClass = (JsonIgnoreType)paramAnnotatedClass.getAnnotation(JsonIgnoreType.class);
    if (paramAnnotatedClass == null) {
      return null;
    }
    return Boolean.valueOf(paramAnnotatedClass.value());
  }
  
  public Boolean shouldUnwrapProperty(AnnotatedMember paramAnnotatedMember)
  {
    paramAnnotatedMember = (JsonUnwrapped)paramAnnotatedMember.getAnnotation(JsonUnwrapped.class);
    if ((paramAnnotatedMember != null) && (paramAnnotatedMember.enabled())) {
      return Boolean.TRUE;
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/introspect/JacksonAnnotationIntrospector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */