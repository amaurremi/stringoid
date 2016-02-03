package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.lang.annotation.Annotation;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.util.Annotations;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.util.InternCache;

public abstract class SettableBeanProperty
  implements BeanProperty
{
  protected final Annotations _contextAnnotations;
  protected String _managedReferenceName;
  protected SettableBeanProperty.NullProvider _nullProvider;
  protected final String _propName;
  protected int _propertyIndex = -1;
  protected final JavaType _type;
  protected JsonDeserializer _valueDeserializer;
  protected TypeDeserializer _valueTypeDeserializer;
  
  protected SettableBeanProperty(String paramString, JavaType paramJavaType, TypeDeserializer paramTypeDeserializer, Annotations paramAnnotations)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (this._propName = "";; this._propName = InternCache.instance.intern(paramString))
    {
      this._type = paramJavaType;
      this._contextAnnotations = paramAnnotations;
      this._valueTypeDeserializer = paramTypeDeserializer;
      return;
    }
  }
  
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
  }
  
  protected SettableBeanProperty(SettableBeanProperty paramSettableBeanProperty, JsonDeserializer paramJsonDeserializer)
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
      return;
    }
    paramSettableBeanProperty = paramJsonDeserializer.getNullValue();
    if (paramSettableBeanProperty == null) {}
    for (paramSettableBeanProperty = (SettableBeanProperty)localObject;; paramSettableBeanProperty = new SettableBeanProperty.NullProvider(this._type, paramSettableBeanProperty))
    {
      this._nullProvider = paramSettableBeanProperty;
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
        localStringBuilder = new StringBuilder("Problem deserializing property '").append(getPropertyName());
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
  
  public abstract Annotation getAnnotation(Class paramClass);
  
  public Annotation getContextAnnotation(Class paramClass)
  {
    return this._contextAnnotations.get(paramClass);
  }
  
  protected final Class getDeclaringClass()
  {
    return getMember().getDeclaringClass();
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
  
  public int getPropertyIndex()
  {
    return this._propertyIndex;
  }
  
  @Deprecated
  public String getPropertyName()
  {
    return this._propName;
  }
  
  @Deprecated
  public int getProperytIndex()
  {
    return getPropertyIndex();
  }
  
  public JavaType getType()
  {
    return this._type;
  }
  
  public JsonDeserializer getValueDeserializer()
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
  
  public abstract void set(Object paramObject1, Object paramObject2);
  
  public void setManagedReferenceName(String paramString)
  {
    this._managedReferenceName = paramString;
  }
  
  @Deprecated
  public void setValueDeserializer(JsonDeserializer paramJsonDeserializer)
  {
    if (this._valueDeserializer != null) {
      throw new IllegalStateException("Already had assigned deserializer for property '" + getName() + "' (class " + getDeclaringClass().getName() + ")");
    }
    this._valueDeserializer = paramJsonDeserializer;
    paramJsonDeserializer = this._valueDeserializer.getNullValue();
    if (paramJsonDeserializer == null) {}
    for (paramJsonDeserializer = null;; paramJsonDeserializer = new SettableBeanProperty.NullProvider(this._type, paramJsonDeserializer))
    {
      this._nullProvider = paramJsonDeserializer;
      return;
    }
  }
  
  public String toString()
  {
    return "[property '" + getName() + "']";
  }
  
  public abstract SettableBeanProperty withValueDeserializer(JsonDeserializer paramJsonDeserializer);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/SettableBeanProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */