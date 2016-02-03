package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeInfo.None;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.None;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonDeserializer.None;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.JsonSerializer.None;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer.None;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Typing;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import com.fasterxml.jackson.databind.annotation.JsonValueInstantiator;
import com.fasterxml.jackson.databind.annotation.NoClass;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfig<*>;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.ser.std.RawSerializer;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

public class JacksonAnnotationIntrospector
  extends AnnotationIntrospector
  implements Serializable
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
    Object localObject2 = null;
    JsonTypeInfo localJsonTypeInfo = (JsonTypeInfo)paramAnnotated.getAnnotation(JsonTypeInfo.class);
    Object localObject1 = (JsonTypeResolver)paramAnnotated.getAnnotation(JsonTypeResolver.class);
    JsonTypeIdResolver localJsonTypeIdResolver;
    if (localObject1 != null)
    {
      if (localJsonTypeInfo == null) {
        return null;
      }
      localObject1 = paramMapperConfig.typeResolverBuilderInstance(paramAnnotated, ((JsonTypeResolver)localObject1).value());
      localJsonTypeIdResolver = (JsonTypeIdResolver)paramAnnotated.getAnnotation(JsonTypeIdResolver.class);
      if (localJsonTypeIdResolver != null) {
        break label221;
      }
    }
    label221:
    for (paramMapperConfig = (MapperConfig<?>)localObject2;; paramMapperConfig = paramMapperConfig.typeIdResolverInstance(paramAnnotated, localJsonTypeIdResolver.value()))
    {
      if (paramMapperConfig != null) {
        paramMapperConfig.init(paramJavaType);
      }
      localObject1 = ((TypeResolverBuilder)localObject1).init(localJsonTypeInfo.use(), paramMapperConfig);
      paramJavaType = localJsonTypeInfo.include();
      paramMapperConfig = paramJavaType;
      if (paramJavaType == JsonTypeInfo.As.EXTERNAL_PROPERTY)
      {
        paramMapperConfig = paramJavaType;
        if ((paramAnnotated instanceof AnnotatedClass)) {
          paramMapperConfig = JsonTypeInfo.As.PROPERTY;
        }
      }
      paramAnnotated = ((TypeResolverBuilder)localObject1).inclusion(paramMapperConfig).typeProperty(localJsonTypeInfo.property());
      paramJavaType = localJsonTypeInfo.defaultImpl();
      paramMapperConfig = paramAnnotated;
      if (paramJavaType != JsonTypeInfo.None.class) {
        paramMapperConfig = paramAnnotated.defaultImpl(paramJavaType);
      }
      return paramMapperConfig.typeIdVisibility(localJsonTypeInfo.visible());
      if (localJsonTypeInfo == null) {
        return null;
      }
      if (localJsonTypeInfo.use() == JsonTypeInfo.Id.NONE) {
        return _constructNoTypeResolverBuilder();
      }
      localObject1 = _constructStdTypeResolverBuilder();
      break;
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
  
  public Class<?> findDeserializationContentType(Annotated paramAnnotated, JavaType paramJavaType)
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
  
  public Class<?> findDeserializationKeyType(Annotated paramAnnotated, JavaType paramJavaType)
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
  
  public String findDeserializationName(AnnotatedField paramAnnotatedField)
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
  
  public String findDeserializationName(AnnotatedMethod paramAnnotatedMethod)
  {
    Object localObject = (JsonSetter)paramAnnotatedMethod.getAnnotation(JsonSetter.class);
    if (localObject != null) {
      return ((JsonSetter)localObject).value();
    }
    localObject = (JsonProperty)paramAnnotatedMethod.getAnnotation(JsonProperty.class);
    if (localObject != null) {
      return ((JsonProperty)localObject).value();
    }
    if ((paramAnnotatedMethod.hasAnnotation(JsonDeserialize.class)) || (paramAnnotatedMethod.hasAnnotation(JsonView.class)) || (paramAnnotatedMethod.hasAnnotation(JsonBackReference.class)) || (paramAnnotatedMethod.hasAnnotation(JsonManagedReference.class))) {
      return "";
    }
    return null;
  }
  
  public String findDeserializationName(AnnotatedParameter paramAnnotatedParameter)
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
  
  public Class<?> findDeserializationType(Annotated paramAnnotated, JavaType paramJavaType)
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
  
  public JsonFormat.Value findFormat(Annotated paramAnnotated)
  {
    paramAnnotated = (JsonFormat)paramAnnotated.getAnnotation(JsonFormat.class);
    if (paramAnnotated == null) {
      return null;
    }
    return new JsonFormat.Value(paramAnnotated);
  }
  
  public JsonFormat.Value findFormat(AnnotatedMember paramAnnotatedMember)
  {
    return findFormat(paramAnnotatedMember);
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
    return ((AnnotatedMethod)localObject).getRawParameterType(0).getName();
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
    paramAnnotatedClass = (JsonNaming)paramAnnotatedClass.getAnnotation(JsonNaming.class);
    if (paramAnnotatedClass == null) {
      return null;
    }
    return paramAnnotatedClass.value();
  }
  
  public ObjectIdInfo findObjectIdInfo(Annotated paramAnnotated)
  {
    paramAnnotated = (JsonIdentityInfo)paramAnnotated.getAnnotation(JsonIdentityInfo.class);
    if ((paramAnnotated == null) || (paramAnnotated.generator() == ObjectIdGenerators.None.class)) {
      return null;
    }
    return new ObjectIdInfo(paramAnnotated.property(), paramAnnotated.scope(), paramAnnotated.generator());
  }
  
  public ObjectIdInfo findObjectReferenceInfo(Annotated paramAnnotated, ObjectIdInfo paramObjectIdInfo)
  {
    JsonIdentityReference localJsonIdentityReference = (JsonIdentityReference)paramAnnotated.getAnnotation(JsonIdentityReference.class);
    paramAnnotated = paramObjectIdInfo;
    if (localJsonIdentityReference != null) {
      paramAnnotated = paramObjectIdInfo.withAlwaysAsId(localJsonIdentityReference.alwaysAsId());
    }
    return paramAnnotated;
  }
  
  public Class<?> findPOJOBuilder(AnnotatedClass paramAnnotatedClass)
  {
    paramAnnotatedClass = (JsonDeserialize)paramAnnotatedClass.getAnnotation(JsonDeserialize.class);
    if ((paramAnnotatedClass == null) || (paramAnnotatedClass.builder() == NoClass.class)) {
      return null;
    }
    return paramAnnotatedClass.builder();
  }
  
  public JsonPOJOBuilder.Value findPOJOBuilderConfig(AnnotatedClass paramAnnotatedClass)
  {
    paramAnnotatedClass = (JsonPOJOBuilder)paramAnnotatedClass.getAnnotation(JsonPOJOBuilder.class);
    if (paramAnnotatedClass == null) {
      return null;
    }
    return new JsonPOJOBuilder.Value(paramAnnotatedClass);
  }
  
  public String[] findPropertiesToIgnore(Annotated paramAnnotated)
  {
    paramAnnotated = (JsonIgnoreProperties)paramAnnotated.getAnnotation(JsonIgnoreProperties.class);
    if (paramAnnotated == null) {
      return null;
    }
    return paramAnnotated.value();
  }
  
  public TypeResolverBuilder<?> findPropertyContentTypeResolver(MapperConfig<?> paramMapperConfig, AnnotatedMember paramAnnotatedMember, JavaType paramJavaType)
  {
    if (!paramJavaType.isContainerType()) {
      throw new IllegalArgumentException("Must call method with a container type (got " + paramJavaType + ")");
    }
    return _findTypeResolver(paramMapperConfig, paramAnnotatedMember, paramJavaType);
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
  
  public PropertyName findRootName(AnnotatedClass paramAnnotatedClass)
  {
    paramAnnotatedClass = (JsonRootName)paramAnnotatedClass.getAnnotation(JsonRootName.class);
    if (paramAnnotatedClass == null) {
      return null;
    }
    return new PropertyName(paramAnnotatedClass.value());
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
  
  public JsonInclude.Include findSerializationInclusion(Annotated paramAnnotated, JsonInclude.Include paramInclude)
  {
    Object localObject = (JsonInclude)paramAnnotated.getAnnotation(JsonInclude.class);
    if (localObject != null) {
      paramAnnotated = ((JsonInclude)localObject).value();
    }
    do
    {
      return paramAnnotated;
      localObject = (JsonSerialize)paramAnnotated.getAnnotation(JsonSerialize.class);
      paramAnnotated = paramInclude;
    } while (localObject == null);
    paramAnnotated = ((JsonSerialize)localObject).include();
    switch (1.$SwitchMap$com$fasterxml$jackson$databind$annotation$JsonSerialize$Inclusion[paramAnnotated.ordinal()])
    {
    default: 
      return paramInclude;
    case 1: 
      return JsonInclude.Include.ALWAYS;
    case 2: 
      return JsonInclude.Include.NON_NULL;
    case 3: 
      return JsonInclude.Include.NON_DEFAULT;
    }
    return JsonInclude.Include.NON_EMPTY;
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
  
  public String findSerializationName(AnnotatedField paramAnnotatedField)
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
  
  public String findSerializationName(AnnotatedMethod paramAnnotatedMethod)
  {
    Object localObject = (JsonGetter)paramAnnotatedMethod.getAnnotation(JsonGetter.class);
    if (localObject != null) {
      return ((JsonGetter)localObject).value();
    }
    localObject = (JsonProperty)paramAnnotatedMethod.getAnnotation(JsonProperty.class);
    if (localObject != null) {
      return ((JsonProperty)localObject).value();
    }
    if ((paramAnnotatedMethod.hasAnnotation(JsonSerialize.class)) || (paramAnnotatedMethod.hasAnnotation(JsonView.class))) {
      return "";
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
  
  public NameTransformer findUnwrappingNameTransformer(AnnotatedMember paramAnnotatedMember)
  {
    paramAnnotatedMember = (JsonUnwrapped)paramAnnotatedMember.getAnnotation(JsonUnwrapped.class);
    if ((paramAnnotatedMember == null) || (!paramAnnotatedMember.enabled())) {
      return null;
    }
    return NameTransformer.simpleTransformer(paramAnnotatedMember.prefix(), paramAnnotatedMember.suffix());
  }
  
  public Object findValueInstantiator(AnnotatedClass paramAnnotatedClass)
  {
    paramAnnotatedClass = (JsonValueInstantiator)paramAnnotatedClass.getAnnotation(JsonValueInstantiator.class);
    if (paramAnnotatedClass == null) {
      return null;
    }
    return paramAnnotatedClass.value();
  }
  
  public Class<?>[] findViews(Annotated paramAnnotated)
  {
    paramAnnotated = (JsonView)paramAnnotated.getAnnotation(JsonView.class);
    if (paramAnnotated == null) {
      return null;
    }
    return paramAnnotated.value();
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
  
  public boolean isAnnotationBundle(Annotation paramAnnotation)
  {
    return paramAnnotation.annotationType().getAnnotation(JacksonAnnotationsInside.class) != null;
  }
  
  public Boolean isIgnorableType(AnnotatedClass paramAnnotatedClass)
  {
    paramAnnotatedClass = (JsonIgnoreType)paramAnnotatedClass.getAnnotation(JsonIgnoreType.class);
    if (paramAnnotatedClass == null) {
      return null;
    }
    return Boolean.valueOf(paramAnnotatedClass.value());
  }
  
  public Boolean isTypeId(AnnotatedMember paramAnnotatedMember)
  {
    return Boolean.valueOf(paramAnnotatedMember.hasAnnotation(JsonTypeId.class));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/introspect/JacksonAnnotationIntrospector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */