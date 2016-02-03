package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import java.io.Serializable;
import java.util.HashMap;

public abstract class TypeDeserializerBase
  extends TypeDeserializer
  implements Serializable
{
  protected final JavaType _baseType;
  protected final JavaType _defaultImpl;
  protected JsonDeserializer<Object> _defaultImplDeserializer;
  protected final HashMap<String, JsonDeserializer<Object>> _deserializers;
  protected final TypeIdResolver _idResolver;
  protected final BeanProperty _property;
  protected final boolean _typeIdVisible;
  protected final String _typePropertyName;
  
  protected TypeDeserializerBase(JavaType paramJavaType, TypeIdResolver paramTypeIdResolver, String paramString, boolean paramBoolean, Class<?> paramClass)
  {
    this._baseType = paramJavaType;
    this._idResolver = paramTypeIdResolver;
    this._typePropertyName = paramString;
    this._typeIdVisible = paramBoolean;
    this._deserializers = new HashMap();
    if (paramClass == null) {}
    for (this._defaultImpl = null;; this._defaultImpl = paramJavaType.forcedNarrowBy(paramClass))
    {
      this._property = null;
      return;
    }
  }
  
  protected TypeDeserializerBase(TypeDeserializerBase paramTypeDeserializerBase, BeanProperty paramBeanProperty)
  {
    this._baseType = paramTypeDeserializerBase._baseType;
    this._idResolver = paramTypeDeserializerBase._idResolver;
    this._typePropertyName = paramTypeDeserializerBase._typePropertyName;
    this._typeIdVisible = paramTypeDeserializerBase._typeIdVisible;
    this._deserializers = paramTypeDeserializerBase._deserializers;
    this._defaultImpl = paramTypeDeserializerBase._defaultImpl;
    this._defaultImplDeserializer = paramTypeDeserializerBase._defaultImplDeserializer;
    this._property = paramBeanProperty;
  }
  
  protected final JsonDeserializer<Object> _findDefaultImplDeserializer(DeserializationContext paramDeserializationContext)
  {
    if (this._defaultImpl == null) {
      return null;
    }
    synchronized (this._defaultImpl)
    {
      if (this._defaultImplDeserializer == null) {
        this._defaultImplDeserializer = paramDeserializationContext.findContextualValueDeserializer(this._defaultImpl, this._property);
      }
      paramDeserializationContext = this._defaultImplDeserializer;
      return paramDeserializationContext;
    }
  }
  
  protected final JsonDeserializer<Object> _findDeserializer(DeserializationContext paramDeserializationContext, String paramString)
  {
    Object localObject2;
    Object localObject1;
    synchronized (this._deserializers)
    {
      localObject2 = (JsonDeserializer)this._deserializers.get(paramString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this._idResolver.typeFromId(paramString);
        if (localObject2 != null) {
          break label93;
        }
        if (this._defaultImpl == null) {
          throw paramDeserializationContext.unknownTypeException(this._baseType, paramString);
        }
      }
    }
    for (paramDeserializationContext = _findDefaultImplDeserializer(paramDeserializationContext);; paramDeserializationContext = paramDeserializationContext.findContextualValueDeserializer((JavaType)localObject1, this._property))
    {
      this._deserializers.put(paramString, paramDeserializationContext);
      localObject1 = paramDeserializationContext;
      return (JsonDeserializer<Object>)localObject1;
      label93:
      localObject1 = localObject2;
      if (this._baseType != null)
      {
        localObject1 = localObject2;
        if (this._baseType.getClass() == localObject2.getClass()) {
          localObject1 = this._baseType.narrowBy(((JavaType)localObject2).getRawClass());
        }
      }
    }
  }
  
  public String baseTypeName()
  {
    return this._baseType.getRawClass().getName();
  }
  
  public Class<?> getDefaultImpl()
  {
    if (this._defaultImpl == null) {
      return null;
    }
    return this._defaultImpl.getRawClass();
  }
  
  public final String getPropertyName()
  {
    return this._typePropertyName;
  }
  
  public TypeIdResolver getTypeIdResolver()
  {
    return this._idResolver;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[').append(getClass().getName());
    localStringBuilder.append("; base-type:").append(this._baseType);
    localStringBuilder.append("; id-resolver: ").append(this._idResolver);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/jsontype/impl/TypeDeserializerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */