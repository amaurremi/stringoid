package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.InternCache;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonDeserializer<*>;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.impl.NullProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.ViewMatcher;
import java.io.IOException;
import java.io.Serializable;

public abstract class SettableBeanProperty
  implements BeanProperty, Serializable
{
  protected final transient Annotations _contextAnnotations;
  protected String _managedReferenceName;
  protected NullProvider _nullProvider;
  protected final String _propName;
  protected int _propertyIndex = -1;
  protected final JavaType _type;
  protected JsonDeserializer<Object> _valueDeserializer;
  protected TypeDeserializer _valueTypeDeserializer;
  protected ViewMatcher _viewMatcher;
  
  protected SettableBeanProperty(SettableBeanProperty paramSettableBeanProperty)
  {
    this._propName = paramSettableBeanProperty._propName;
    this._type = paramSettableBeanProperty._type;
    this._contextAnnotations = paramSettableBeanProperty._contextAnnotations;
    this._valueDeserializer = paramSettableBeanProperty._valueDeserializer;
    this._valueTypeDeserializer = paramSettableBeanProperty._valueTypeDeserializer;
    this._nullProvider = paramSettableBeanProperty._nullProvider;
    this._managedReferenceName = paramSettableBeanProperty._managedReferenceName;
    this._propertyIndex = paramSettableBeanProperty._propertyIndex;
    this._viewMatcher = paramSettableBeanProperty._viewMatcher;
  }
  
  protected SettableBeanProperty(SettableBeanProperty paramSettableBeanProperty, JsonDeserializer<?> paramJsonDeserializer)
  {
    this._propName = paramSettableBeanProperty._propName;
    this._type = paramSettableBeanProperty._type;
    this._contextAnnotations = paramSettableBeanProperty._contextAnnotations;
    this._valueTypeDeserializer = paramSettableBeanProperty._valueTypeDeserializer;
    this._managedReferenceName = paramSettableBeanProperty._managedReferenceName;
    this._propertyIndex = paramSettableBeanProperty._propertyIndex;
    this._valueDeserializer = paramJsonDeserializer;
    if (paramJsonDeserializer == null)
    {
      this._nullProvider = null;
      this._viewMatcher = paramSettableBeanProperty._viewMatcher;
      return;
    }
    paramJsonDeserializer = paramJsonDeserializer.getNullValue();
    if (paramJsonDeserializer == null) {}
    for (paramJsonDeserializer = (JsonDeserializer<?>)localObject;; paramJsonDeserializer = new NullProvider(this._type, paramJsonDeserializer))
    {
      this._nullProvider = paramJsonDeserializer;
      break;
    }
  }
  
  protected SettableBeanProperty(SettableBeanProperty paramSettableBeanProperty, String paramString)
  {
    this._propName = paramString;
    this._type = paramSettableBeanProperty._type;
    this._contextAnnotations = paramSettableBeanProperty._contextAnnotations;
    this._valueDeserializer = paramSettableBeanProperty._valueDeserializer;
    this._valueTypeDeserializer = paramSettableBeanProperty._valueTypeDeserializer;
    this._nullProvider = paramSettableBeanProperty._nullProvider;
    this._managedReferenceName = paramSettableBeanProperty._managedReferenceName;
    this._propertyIndex = paramSettableBeanProperty._propertyIndex;
    this._viewMatcher = paramSettableBeanProperty._viewMatcher;
  }
  
  protected SettableBeanProperty(BeanPropertyDefinition paramBeanPropertyDefinition, JavaType paramJavaType, TypeDeserializer paramTypeDeserializer, Annotations paramAnnotations)
  {
    this(paramBeanPropertyDefinition.getName(), paramJavaType, paramTypeDeserializer, paramAnnotations);
  }
  
  protected SettableBeanProperty(String paramString, JavaType paramJavaType, TypeDeserializer paramTypeDeserializer, Annotations paramAnnotations)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (this._propName = "";; this._propName = InternCache.instance.intern(paramString))
    {
      this._type = paramJavaType;
      this._contextAnnotations = paramAnnotations;
      this._viewMatcher = null;
      paramString = paramTypeDeserializer;
      if (paramTypeDeserializer != null) {
        paramString = paramTypeDeserializer.forProperty(this);
      }
      this._valueTypeDeserializer = paramString;
      return;
    }
  }
  
  protected IOException _throwAsIOE(Exception paramException)
  {
    if ((paramException instanceof IOException)) {
      throw ((IOException)paramException);
    }
    Object localObject = paramException;
    if ((paramException instanceof RuntimeException)) {
      throw ((RuntimeException)paramException);
    }
    while (((Throwable)localObject).getCause() != null) {
      localObject = ((Throwable)localObject).getCause();
    }
    throw new JsonMappingException(((Throwable)localObject).getMessage(), null, (Throwable)localObject);
  }
  
  protected void _throwAsIOE(Exception paramException, Object paramObject)
  {
    if ((paramException instanceof IllegalArgumentException))
    {
      StringBuilder localStringBuilder;
      if (paramObject == null)
      {
        paramObject = "[NULL]";
        localStringBuilder = new StringBuilder("Problem deserializing property '").append(getName());
        localStringBuilder.append("' (expected type: ").append(getType());
        localStringBuilder.append("; actual type: ").append((String)paramObject).append(")");
        paramObject = paramException.getMessage();
        if (paramObject == null) {
          break label106;
        }
        localStringBuilder.append(", problem: ").append((String)paramObject);
      }
      for (;;)
      {
        throw new JsonMappingException(localStringBuilder.toString(), null, paramException);
        paramObject = paramObject.getClass().getName();
        break;
        label106:
        localStringBuilder.append(" (no error message provided)");
      }
    }
    _throwAsIOE(paramException);
  }
  
  public void assignIndex(int paramInt)
  {
    if (this._propertyIndex != -1) {
      throw new IllegalStateException("Property '" + getName() + "' already had index (" + this._propertyIndex + "), trying to assign " + paramInt);
    }
    this._propertyIndex = paramInt;
  }
  
  public final Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_NULL)
    {
      if (this._nullProvider == null) {
        return null;
      }
      return this._nullProvider.nullValue(paramDeserializationContext);
    }
    if (this._valueTypeDeserializer != null) {
      return this._valueDeserializer.deserializeWithType(paramJsonParser, paramDeserializationContext, this._valueTypeDeserializer);
    }
    return this._valueDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
  }
  
  public abstract void deserializeAndSet(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject);
  
  public abstract Object deserializeSetAndReturn(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject);
  
  public int getCreatorIndex()
  {
    return -1;
  }
  
  public Object getInjectableValueId()
  {
    return null;
  }
  
  public String getManagedReferenceName()
  {
    return this._managedReferenceName;
  }
  
  public abstract AnnotatedMember getMember();
  
  public final String getName()
  {
    return this._propName;
  }
  
  public JavaType getType()
  {
    return this._type;
  }
  
  public JsonDeserializer<Object> getValueDeserializer()
  {
    return this._valueDeserializer;
  }
  
  public TypeDeserializer getValueTypeDeserializer()
  {
    return this._valueTypeDeserializer;
  }
  
  public boolean hasValueDeserializer()
  {
    return this._valueDeserializer != null;
  }
  
  public boolean hasValueTypeDeserializer()
  {
    return this._valueTypeDeserializer != null;
  }
  
  public boolean hasViews()
  {
    return this._viewMatcher != null;
  }
  
  public abstract void set(Object paramObject1, Object paramObject2);
  
  public abstract Object setAndReturn(Object paramObject1, Object paramObject2);
  
  public void setManagedReferenceName(String paramString)
  {
    this._managedReferenceName = paramString;
  }
  
  public void setViews(Class<?>[] paramArrayOfClass)
  {
    if (paramArrayOfClass == null)
    {
      this._viewMatcher = null;
      return;
    }
    this._viewMatcher = ViewMatcher.construct(paramArrayOfClass);
  }
  
  public String toString()
  {
    return "[property '" + getName() + "']";
  }
  
  public boolean visibleInView(Class<?> paramClass)
  {
    return (this._viewMatcher == null) || (this._viewMatcher.isVisibleForView(paramClass));
  }
  
  public abstract SettableBeanProperty withName(String paramString);
  
  public abstract SettableBeanProperty withValueDeserializer(JsonDeserializer<?> paramJsonDeserializer);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/SettableBeanProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */