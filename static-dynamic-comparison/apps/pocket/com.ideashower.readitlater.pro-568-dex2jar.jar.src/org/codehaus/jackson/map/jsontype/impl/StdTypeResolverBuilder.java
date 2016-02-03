package org.codehaus.jackson.map.jsontype.impl;

import java.util.Collection;
import org.codehaus.jackson.annotate.JsonTypeInfo.As;
import org.codehaus.jackson.annotate.JsonTypeInfo.Id;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.jsontype.TypeIdResolver;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.type.JavaType;

public class StdTypeResolverBuilder
  implements TypeResolverBuilder
{
  protected TypeIdResolver _customIdResolver;
  protected Class _defaultImpl;
  protected JsonTypeInfo.Id _idType;
  protected JsonTypeInfo.As _includeAs;
  protected String _typeProperty;
  
  public static StdTypeResolverBuilder noTypeInfoBuilder()
  {
    return new StdTypeResolverBuilder().init(JsonTypeInfo.Id.NONE, null);
  }
  
  public TypeDeserializer buildTypeDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, Collection paramCollection, BeanProperty paramBeanProperty)
  {
    if (this._idType == JsonTypeInfo.Id.NONE) {
      return null;
    }
    paramDeserializationConfig = idResolver(paramDeserializationConfig, paramJavaType, paramCollection, false, true);
    switch (1.$SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$As[this._includeAs.ordinal()])
    {
    default: 
      throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this._includeAs);
    case 1: 
      return new AsArrayTypeDeserializer(paramJavaType, paramDeserializationConfig, paramBeanProperty, this._defaultImpl);
    case 2: 
      return new AsPropertyTypeDeserializer(paramJavaType, paramDeserializationConfig, paramBeanProperty, this._defaultImpl, this._typeProperty);
    case 3: 
      return new AsWrapperTypeDeserializer(paramJavaType, paramDeserializationConfig, paramBeanProperty, this._defaultImpl);
    }
    return new AsExternalTypeDeserializer(paramJavaType, paramDeserializationConfig, paramBeanProperty, this._defaultImpl, this._typeProperty);
  }
  
  public TypeSerializer buildTypeSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, Collection paramCollection, BeanProperty paramBeanProperty)
  {
    if (this._idType == JsonTypeInfo.Id.NONE) {
      return null;
    }
    paramSerializationConfig = idResolver(paramSerializationConfig, paramJavaType, paramCollection, true, false);
    switch (1.$SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$As[this._includeAs.ordinal()])
    {
    default: 
      throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this._includeAs);
    case 1: 
      return new AsArrayTypeSerializer(paramSerializationConfig, paramBeanProperty);
    case 2: 
      return new AsPropertyTypeSerializer(paramSerializationConfig, paramBeanProperty, this._typeProperty);
    case 3: 
      return new AsWrapperTypeSerializer(paramSerializationConfig, paramBeanProperty);
    }
    return new AsExternalTypeSerializer(paramSerializationConfig, paramBeanProperty, this._typeProperty);
  }
  
  public StdTypeResolverBuilder defaultImpl(Class paramClass)
  {
    this._defaultImpl = paramClass;
    return this;
  }
  
  public Class getDefaultImpl()
  {
    return this._defaultImpl;
  }
  
  public String getTypeProperty()
  {
    return this._typeProperty;
  }
  
  protected TypeIdResolver idResolver(MapperConfig paramMapperConfig, JavaType paramJavaType, Collection paramCollection, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this._customIdResolver != null) {
      return this._customIdResolver;
    }
    if (this._idType == null) {
      throw new IllegalStateException("Can not build, 'init()' not yet called");
    }
    switch (1.$SwitchMap$org$codehaus$jackson$annotate$JsonTypeInfo$Id[this._idType.ordinal()])
    {
    default: 
      throw new IllegalStateException("Do not know how to construct standard type id resolver for idType: " + this._idType);
    case 1: 
      return new ClassNameIdResolver(paramJavaType, paramMapperConfig.getTypeFactory());
    case 2: 
      return new MinimalClassNameIdResolver(paramJavaType, paramMapperConfig.getTypeFactory());
    case 3: 
      return TypeNameIdResolver.construct(paramMapperConfig, paramJavaType, paramCollection, paramBoolean1, paramBoolean2);
    }
    return null;
  }
  
  public StdTypeResolverBuilder inclusion(JsonTypeInfo.As paramAs)
  {
    if (paramAs == null) {
      throw new IllegalArgumentException("includeAs can not be null");
    }
    this._includeAs = paramAs;
    return this;
  }
  
  public StdTypeResolverBuilder init(JsonTypeInfo.Id paramId, TypeIdResolver paramTypeIdResolver)
  {
    if (paramId == null) {
      throw new IllegalArgumentException("idType can not be null");
    }
    this._idType = paramId;
    this._customIdResolver = paramTypeIdResolver;
    this._typeProperty = paramId.getDefaultPropertyName();
    return this;
  }
  
  public StdTypeResolverBuilder typeProperty(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = this._idType.getDefaultPropertyName();
    }
    this._typeProperty = str;
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/jsontype/impl/StdTypeResolverBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */