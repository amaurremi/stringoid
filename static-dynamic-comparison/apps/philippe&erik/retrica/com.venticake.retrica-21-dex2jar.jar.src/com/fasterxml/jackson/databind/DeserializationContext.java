package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.ContextualKeyDeserializer;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.deser.DeserializerCache;
import com.fasterxml.jackson.databind.deser.DeserializerFactory;
import com.fasterxml.jackson.databind.deser.impl.ReadableObjectId;
import com.fasterxml.jackson.databind.deser.impl.TypeWrappedDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.ObjectIdInfo;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.LinkedNode;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public abstract class DeserializationContext
  implements Serializable
{
  protected transient ArrayBuilders _arrayBuilders;
  protected final DeserializerCache _cache;
  protected final DeserializationConfig _config;
  protected transient DateFormat _dateFormat;
  protected final DeserializerFactory _factory;
  protected final int _featureFlags;
  protected final InjectableValues _injectableValues;
  protected transient ObjectBuffer _objectBuffer;
  protected transient JsonParser _parser;
  protected final Class<?> _view;
  
  protected DeserializationContext(DeserializationContext paramDeserializationContext, DeserializationConfig paramDeserializationConfig, JsonParser paramJsonParser, InjectableValues paramInjectableValues)
  {
    this._cache = paramDeserializationContext._cache;
    this._factory = paramDeserializationContext._factory;
    this._config = paramDeserializationConfig;
    this._featureFlags = paramDeserializationConfig.getDeserializationFeatures();
    this._view = paramDeserializationConfig.getActiveView();
    this._parser = paramJsonParser;
    this._injectableValues = paramInjectableValues;
  }
  
  protected DeserializationContext(DeserializerFactory paramDeserializerFactory, DeserializerCache paramDeserializerCache)
  {
    if (paramDeserializerFactory == null) {
      throw new IllegalArgumentException("Can not pass null DeserializerFactory");
    }
    this._factory = paramDeserializerFactory;
    paramDeserializerFactory = paramDeserializerCache;
    if (paramDeserializerCache == null) {
      paramDeserializerFactory = new DeserializerCache();
    }
    this._cache = paramDeserializerFactory;
    this._featureFlags = 0;
    this._config = null;
    this._injectableValues = null;
    this._view = null;
  }
  
  protected String _calcName(Class<?> paramClass)
  {
    if (paramClass.isArray()) {
      return _calcName(paramClass.getComponentType()) + "[]";
    }
    return paramClass.getName();
  }
  
  protected String _desc(String paramString)
  {
    String str = paramString;
    if (paramString.length() > 500) {
      str = paramString.substring(0, 500) + "]...[" + paramString.substring(paramString.length() - 500);
    }
    return str;
  }
  
  protected String _valueDesc()
  {
    try
    {
      String str = _desc(this._parser.getText());
      return str;
    }
    catch (Exception localException) {}
    return "[N/A]";
  }
  
  public final boolean canOverrideAccessModifiers()
  {
    return this._config.canOverrideAccessModifiers();
  }
  
  public Calendar constructCalendar(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance(getTimeZone());
    localCalendar.setTime(paramDate);
    return localCalendar;
  }
  
  public final JavaType constructType(Class<?> paramClass)
  {
    return this._config.constructType(paramClass);
  }
  
  public abstract JsonDeserializer<Object> deserializerInstance(Annotated paramAnnotated, Object paramObject);
  
  public JsonMappingException endOfInputException(Class<?> paramClass)
  {
    return JsonMappingException.from(this._parser, "Unexpected end-of-input when trying to deserialize a " + paramClass.getName());
  }
  
  public Class<?> findClass(String paramString)
  {
    return ClassUtil.findClass(paramString);
  }
  
  public final JsonDeserializer<Object> findContextualValueDeserializer(JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    JsonDeserializer localJsonDeserializer = this._cache.findValueDeserializer(this, this._factory, paramJavaType);
    paramJavaType = localJsonDeserializer;
    if (localJsonDeserializer != null)
    {
      paramJavaType = localJsonDeserializer;
      if ((localJsonDeserializer instanceof ContextualDeserializer)) {
        paramJavaType = ((ContextualDeserializer)localJsonDeserializer).createContextual(this, paramBeanProperty);
      }
    }
    return paramJavaType;
  }
  
  public final Object findInjectableValue(Object paramObject1, BeanProperty paramBeanProperty, Object paramObject2)
  {
    if (this._injectableValues == null) {
      throw new IllegalStateException("No 'injectableValues' configured, can not inject value with id [" + paramObject1 + "]");
    }
    return this._injectableValues.findInjectableValue(paramObject1, this, paramBeanProperty, paramObject2);
  }
  
  public final KeyDeserializer findKeyDeserializer(JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    KeyDeserializer localKeyDeserializer = this._cache.findKeyDeserializer(this, this._factory, paramJavaType);
    paramJavaType = localKeyDeserializer;
    if ((localKeyDeserializer instanceof ContextualKeyDeserializer)) {
      paramJavaType = ((ContextualKeyDeserializer)localKeyDeserializer).createContextual(this, paramBeanProperty);
    }
    return paramJavaType;
  }
  
  public abstract ReadableObjectId findObjectId(Object paramObject, ObjectIdGenerator<?> paramObjectIdGenerator);
  
  public final JsonDeserializer<Object> findRootValueDeserializer(JavaType paramJavaType)
  {
    Object localObject2 = this._cache.findValueDeserializer(this, this._factory, paramJavaType);
    if (localObject2 == null) {
      paramJavaType = null;
    }
    Object localObject1;
    do
    {
      return paramJavaType;
      localObject1 = localObject2;
      if ((localObject2 instanceof ContextualDeserializer)) {
        localObject1 = ((ContextualDeserializer)localObject2).createContextual(this, null);
      }
      localObject2 = this._factory.findTypeDeserializer(this._config, paramJavaType);
      paramJavaType = (JavaType)localObject1;
    } while (localObject2 == null);
    return new TypeWrappedDeserializer(((TypeDeserializer)localObject2).forProperty(null), (JsonDeserializer)localObject1);
  }
  
  public final Class<?> getActiveView()
  {
    return this._view;
  }
  
  public final AnnotationIntrospector getAnnotationIntrospector()
  {
    return this._config.getAnnotationIntrospector();
  }
  
  public final ArrayBuilders getArrayBuilders()
  {
    if (this._arrayBuilders == null) {
      this._arrayBuilders = new ArrayBuilders();
    }
    return this._arrayBuilders;
  }
  
  public final Base64Variant getBase64Variant()
  {
    return this._config.getBase64Variant();
  }
  
  public DeserializationConfig getConfig()
  {
    return this._config;
  }
  
  protected DateFormat getDateFormat()
  {
    if (this._dateFormat != null) {
      return this._dateFormat;
    }
    DateFormat localDateFormat = (DateFormat)this._config.getDateFormat().clone();
    this._dateFormat = localDateFormat;
    return localDateFormat;
  }
  
  public Locale getLocale()
  {
    return this._config.getLocale();
  }
  
  public final JsonNodeFactory getNodeFactory()
  {
    return this._config.getNodeFactory();
  }
  
  public final JsonParser getParser()
  {
    return this._parser;
  }
  
  public TimeZone getTimeZone()
  {
    return this._config.getTimeZone();
  }
  
  public final TypeFactory getTypeFactory()
  {
    return this._config.getTypeFactory();
  }
  
  public boolean handleUnknownProperty(JsonParser paramJsonParser, JsonDeserializer<?> paramJsonDeserializer, Object paramObject, String paramString)
  {
    LinkedNode localLinkedNode = this._config.getProblemHandlers();
    if (localLinkedNode != null) {
      while (localLinkedNode != null)
      {
        if (((DeserializationProblemHandler)localLinkedNode.value()).handleUnknownProperty(this, paramJsonParser, paramJsonDeserializer, paramObject, paramString)) {
          return true;
        }
        localLinkedNode = localLinkedNode.next();
      }
    }
    return false;
  }
  
  public JsonMappingException instantiationException(Class<?> paramClass, String paramString)
  {
    return JsonMappingException.from(this._parser, "Can not construct instance of " + paramClass.getName() + ", problem: " + paramString);
  }
  
  public JsonMappingException instantiationException(Class<?> paramClass, Throwable paramThrowable)
  {
    return JsonMappingException.from(this._parser, "Can not construct instance of " + paramClass.getName() + ", problem: " + paramThrowable.getMessage(), paramThrowable);
  }
  
  public final boolean isEnabled(DeserializationFeature paramDeserializationFeature)
  {
    return (this._featureFlags & paramDeserializationFeature.getMask()) != 0;
  }
  
  public final boolean isEnabled(MapperFeature paramMapperFeature)
  {
    return this._config.isEnabled(paramMapperFeature);
  }
  
  public abstract KeyDeserializer keyDeserializerInstance(Annotated paramAnnotated, Object paramObject);
  
  public final ObjectBuffer leaseObjectBuffer()
  {
    ObjectBuffer localObjectBuffer = this._objectBuffer;
    if (localObjectBuffer == null) {
      return new ObjectBuffer();
    }
    this._objectBuffer = null;
    return localObjectBuffer;
  }
  
  public JsonMappingException mappingException(Class<?> paramClass)
  {
    return mappingException(paramClass, this._parser.getCurrentToken());
  }
  
  public JsonMappingException mappingException(Class<?> paramClass, JsonToken paramJsonToken)
  {
    paramClass = _calcName(paramClass);
    return JsonMappingException.from(this._parser, "Can not deserialize instance of " + paramClass + " out of " + paramJsonToken + " token");
  }
  
  public JsonMappingException mappingException(String paramString)
  {
    return JsonMappingException.from(getParser(), paramString);
  }
  
  public abstract ObjectIdGenerator<?> objectIdGeneratorInstance(Annotated paramAnnotated, ObjectIdInfo paramObjectIdInfo);
  
  public Date parseDate(String paramString)
  {
    try
    {
      Date localDate = getDateFormat().parse(paramString);
      return localDate;
    }
    catch (ParseException localParseException)
    {
      throw new IllegalArgumentException("Failed to parse Date value '" + paramString + "': " + localParseException.getMessage());
    }
  }
  
  public void reportUnknownProperty(Object paramObject, String paramString, JsonDeserializer<?> paramJsonDeserializer)
  {
    if (!isEnabled(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)) {
      return;
    }
    if (paramJsonDeserializer == null) {}
    for (paramJsonDeserializer = null;; paramJsonDeserializer = paramJsonDeserializer.getKnownPropertyNames()) {
      throw UnrecognizedPropertyException.from(this._parser, paramObject, paramString, paramJsonDeserializer);
    }
  }
  
  public final void returnObjectBuffer(ObjectBuffer paramObjectBuffer)
  {
    if ((this._objectBuffer == null) || (paramObjectBuffer.initialCapacity() >= this._objectBuffer.initialCapacity())) {
      this._objectBuffer = paramObjectBuffer;
    }
  }
  
  public JsonMappingException unknownTypeException(JavaType paramJavaType, String paramString)
  {
    return JsonMappingException.from(this._parser, "Could not resolve type id '" + paramString + "' into a subtype of " + paramJavaType);
  }
  
  public JsonMappingException weirdKeyException(Class<?> paramClass, String paramString1, String paramString2)
  {
    return InvalidFormatException.from(this._parser, "Can not construct Map key of type " + paramClass.getName() + " from String \"" + _desc(paramString1) + "\": " + paramString2, paramString1, paramClass);
  }
  
  public JsonMappingException weirdNumberException(Number paramNumber, Class<?> paramClass, String paramString)
  {
    return InvalidFormatException.from(this._parser, "Can not construct instance of " + paramClass.getName() + " from number value (" + _valueDesc() + "): " + paramString, null, paramClass);
  }
  
  public JsonMappingException weirdStringException(String paramString1, Class<?> paramClass, String paramString2)
  {
    return InvalidFormatException.from(this._parser, "Can not construct instance of " + paramClass.getName() + " from String value '" + _valueDesc() + "': " + paramString2, paramString1, paramClass);
  }
  
  public JsonMappingException wrongTokenException(JsonParser paramJsonParser, JsonToken paramJsonToken, String paramString)
  {
    return JsonMappingException.from(paramJsonParser, "Unexpected token (" + paramJsonParser.getCurrentToken() + "), expected " + paramJsonToken + ": " + paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/DeserializationContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */