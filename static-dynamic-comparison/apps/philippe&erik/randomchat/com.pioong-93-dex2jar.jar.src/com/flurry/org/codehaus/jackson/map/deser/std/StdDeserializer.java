package com.flurry.org.codehaus.jackson.map.deser.std;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonParser.NumberType;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.io.NumberInput;
import com.flurry.org.codehaus.jackson.map.BeanProperty;
import com.flurry.org.codehaus.jackson.map.DeserializationConfig;
import com.flurry.org.codehaus.jackson.map.DeserializationConfig.Feature;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.DeserializerProvider;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import com.flurry.org.codehaus.jackson.map.TypeDeserializer;
import com.flurry.org.codehaus.jackson.map.annotate.JacksonStdImpl;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class StdDeserializer<T>
  extends JsonDeserializer<T>
{
  protected final Class<?> _valueClass;
  
  protected StdDeserializer(JavaType paramJavaType)
  {
    if (paramJavaType == null) {}
    for (paramJavaType = null;; paramJavaType = paramJavaType.getRawClass())
    {
      this._valueClass = paramJavaType;
      return;
    }
  }
  
  protected StdDeserializer(Class<?> paramClass)
  {
    this._valueClass = paramClass;
  }
  
  protected static final double parseDouble(String paramString)
    throws NumberFormatException
  {
    if ("2.2250738585072012e-308".equals(paramString)) {
      return 2.2250738585072014E-308D;
    }
    return Double.parseDouble(paramString);
  }
  
  protected final Boolean _parseBoolean(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.VALUE_TRUE) {
      return Boolean.TRUE;
    }
    if (localJsonToken == JsonToken.VALUE_FALSE) {
      return Boolean.FALSE;
    }
    if (localJsonToken == JsonToken.VALUE_NUMBER_INT)
    {
      if (paramJsonParser.getNumberType() == JsonParser.NumberType.INT)
      {
        if (paramJsonParser.getIntValue() == 0) {
          return Boolean.FALSE;
        }
        return Boolean.TRUE;
      }
      return Boolean.valueOf(_parseBooleanFromNumber(paramJsonParser, paramDeserializationContext));
    }
    if (localJsonToken == JsonToken.VALUE_NULL) {
      return (Boolean)getNullValue();
    }
    if (localJsonToken == JsonToken.VALUE_STRING)
    {
      paramJsonParser = paramJsonParser.getText().trim();
      if ("true".equals(paramJsonParser)) {
        return Boolean.TRUE;
      }
      if ("false".equals(paramJsonParser)) {
        return Boolean.FALSE;
      }
      if (paramJsonParser.length() == 0) {
        return (Boolean)getEmptyValue();
      }
      throw paramDeserializationContext.weirdStringException(this._valueClass, "only \"true\" or \"false\" recognized");
    }
    throw paramDeserializationContext.mappingException(this._valueClass, localJsonToken);
  }
  
  protected final boolean _parseBooleanFromNumber(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (paramJsonParser.getNumberType() == JsonParser.NumberType.LONG)
    {
      if (paramJsonParser.getLongValue() == 0L) {}
      for (paramJsonParser = Boolean.FALSE;; paramJsonParser = Boolean.TRUE) {
        return paramJsonParser.booleanValue();
      }
    }
    paramJsonParser = paramJsonParser.getText();
    if (("0.0".equals(paramJsonParser)) || ("0".equals(paramJsonParser))) {
      return Boolean.FALSE.booleanValue();
    }
    return Boolean.TRUE.booleanValue();
  }
  
  protected final boolean _parseBooleanPrimitive(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.VALUE_TRUE) {}
    label65:
    do
    {
      do
      {
        return true;
        if (localJsonToken == JsonToken.VALUE_FALSE) {
          return false;
        }
        if (localJsonToken == JsonToken.VALUE_NULL) {
          return false;
        }
        if (localJsonToken != JsonToken.VALUE_NUMBER_INT) {
          break label65;
        }
        if (paramJsonParser.getNumberType() != JsonParser.NumberType.INT) {
          break;
        }
      } while (paramJsonParser.getIntValue() != 0);
      return false;
      return _parseBooleanFromNumber(paramJsonParser, paramDeserializationContext);
      if (localJsonToken != JsonToken.VALUE_STRING) {
        break;
      }
      paramJsonParser = paramJsonParser.getText().trim();
    } while ("true".equals(paramJsonParser));
    if (("false".equals(paramJsonParser)) || (paramJsonParser.length() == 0)) {
      return Boolean.FALSE.booleanValue();
    }
    throw paramDeserializationContext.weirdStringException(this._valueClass, "only \"true\" or \"false\" recognized");
    throw paramDeserializationContext.mappingException(this._valueClass, localJsonToken);
  }
  
  protected Byte _parseByte(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {
      return Byte.valueOf(paramJsonParser.getByteValue());
    }
    if (localJsonToken == JsonToken.VALUE_STRING)
    {
      paramJsonParser = paramJsonParser.getText().trim();
      int i;
      try
      {
        if (paramJsonParser.length() == 0) {
          return (Byte)getEmptyValue();
        }
        i = NumberInput.parseInt(paramJsonParser);
        if ((i < -128) || (i > 127)) {
          throw paramDeserializationContext.weirdStringException(this._valueClass, "overflow, value can not be represented as 8-bit value");
        }
      }
      catch (IllegalArgumentException paramJsonParser)
      {
        throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid Byte value");
      }
      return Byte.valueOf((byte)i);
    }
    if (localJsonToken == JsonToken.VALUE_NULL) {
      return (Byte)getNullValue();
    }
    throw paramDeserializationContext.mappingException(this._valueClass, localJsonToken);
  }
  
  protected java.util.Date _parseDate(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.VALUE_NUMBER_INT) {
      return new java.util.Date(paramJsonParser.getLongValue());
    }
    if (localJsonToken == JsonToken.VALUE_NULL) {
      return (java.util.Date)getNullValue();
    }
    if (localJsonToken == JsonToken.VALUE_STRING) {
      try
      {
        paramJsonParser = paramJsonParser.getText().trim();
        if (paramJsonParser.length() == 0) {
          return (java.util.Date)getEmptyValue();
        }
        paramJsonParser = paramDeserializationContext.parseDate(paramJsonParser);
        return paramJsonParser;
      }
      catch (IllegalArgumentException paramJsonParser)
      {
        throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid representation (error: " + paramJsonParser.getMessage() + ")");
      }
    }
    throw paramDeserializationContext.mappingException(this._valueClass, localJsonToken);
  }
  
  protected final Double _parseDouble(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {
      return Double.valueOf(paramJsonParser.getDoubleValue());
    }
    if (localJsonToken == JsonToken.VALUE_STRING)
    {
      paramJsonParser = paramJsonParser.getText().trim();
      if (paramJsonParser.length() == 0) {
        return (Double)getEmptyValue();
      }
      switch (paramJsonParser.charAt(0))
      {
      }
      for (;;)
      {
        try
        {
          double d = parseDouble(paramJsonParser);
          return Double.valueOf(d);
        }
        catch (IllegalArgumentException paramJsonParser)
        {
          throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid Double value");
        }
        if (("Infinity".equals(paramJsonParser)) || ("INF".equals(paramJsonParser)))
        {
          return Double.valueOf(Double.POSITIVE_INFINITY);
          if ("NaN".equals(paramJsonParser))
          {
            return Double.valueOf(NaN.0D);
            if (("-Infinity".equals(paramJsonParser)) || ("-INF".equals(paramJsonParser))) {
              return Double.valueOf(Double.NEGATIVE_INFINITY);
            }
          }
        }
      }
    }
    if (localJsonToken == JsonToken.VALUE_NULL) {
      return (Double)getNullValue();
    }
    throw paramDeserializationContext.mappingException(this._valueClass, localJsonToken);
  }
  
  protected final double _parseDoublePrimitive(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    double d = 0.0D;
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {
      d = paramJsonParser.getDoubleValue();
    }
    do
    {
      do
      {
        return d;
        if (localJsonToken != JsonToken.VALUE_STRING) {
          break;
        }
        paramJsonParser = paramJsonParser.getText().trim();
      } while (paramJsonParser.length() == 0);
      switch (paramJsonParser.charAt(0))
      {
      }
      for (;;)
      {
        try
        {
          d = parseDouble(paramJsonParser);
          return d;
        }
        catch (IllegalArgumentException paramJsonParser)
        {
          throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid double value");
        }
        if (("Infinity".equals(paramJsonParser)) || ("INF".equals(paramJsonParser)))
        {
          return Double.POSITIVE_INFINITY;
          if ("NaN".equals(paramJsonParser))
          {
            return NaN.0D;
            if (("-Infinity".equals(paramJsonParser)) || ("-INF".equals(paramJsonParser))) {
              return Double.NEGATIVE_INFINITY;
            }
          }
        }
      }
    } while (localJsonToken == JsonToken.VALUE_NULL);
    throw paramDeserializationContext.mappingException(this._valueClass, localJsonToken);
  }
  
  protected final Float _parseFloat(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {
      return Float.valueOf(paramJsonParser.getFloatValue());
    }
    if (localJsonToken == JsonToken.VALUE_STRING)
    {
      paramJsonParser = paramJsonParser.getText().trim();
      if (paramJsonParser.length() == 0) {
        return (Float)getEmptyValue();
      }
      switch (paramJsonParser.charAt(0))
      {
      }
      for (;;)
      {
        try
        {
          float f = Float.parseFloat(paramJsonParser);
          return Float.valueOf(f);
        }
        catch (IllegalArgumentException paramJsonParser)
        {
          throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid Float value");
        }
        if (("Infinity".equals(paramJsonParser)) || ("INF".equals(paramJsonParser)))
        {
          return Float.valueOf(Float.POSITIVE_INFINITY);
          if ("NaN".equals(paramJsonParser))
          {
            return Float.valueOf(NaN.0F);
            if (("-Infinity".equals(paramJsonParser)) || ("-INF".equals(paramJsonParser))) {
              return Float.valueOf(Float.NEGATIVE_INFINITY);
            }
          }
        }
      }
    }
    if (localJsonToken == JsonToken.VALUE_NULL) {
      return (Float)getNullValue();
    }
    throw paramDeserializationContext.mappingException(this._valueClass, localJsonToken);
  }
  
  protected final float _parseFloatPrimitive(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    float f = 0.0F;
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {
      f = paramJsonParser.getFloatValue();
    }
    do
    {
      do
      {
        return f;
        if (localJsonToken != JsonToken.VALUE_STRING) {
          break;
        }
        paramJsonParser = paramJsonParser.getText().trim();
      } while (paramJsonParser.length() == 0);
      switch (paramJsonParser.charAt(0))
      {
      }
      for (;;)
      {
        try
        {
          f = Float.parseFloat(paramJsonParser);
          return f;
        }
        catch (IllegalArgumentException paramJsonParser)
        {
          throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid float value");
        }
        if (("Infinity".equals(paramJsonParser)) || ("INF".equals(paramJsonParser)))
        {
          return Float.POSITIVE_INFINITY;
          if ("NaN".equals(paramJsonParser))
          {
            return NaN.0F;
            if (("-Infinity".equals(paramJsonParser)) || ("-INF".equals(paramJsonParser))) {
              return Float.NEGATIVE_INFINITY;
            }
          }
        }
      }
    } while (localJsonToken == JsonToken.VALUE_NULL);
    throw paramDeserializationContext.mappingException(this._valueClass, localJsonToken);
  }
  
  protected final int _parseIntPrimitive(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    int i = 0;
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {
      i = paramJsonParser.getIntValue();
    }
    do
    {
      int j;
      do
      {
        return i;
        if (localJsonToken != JsonToken.VALUE_STRING) {
          break;
        }
        paramJsonParser = paramJsonParser.getText().trim();
        long l;
        try
        {
          j = paramJsonParser.length();
          if (j <= 9) {
            continue;
          }
          l = Long.parseLong(paramJsonParser);
          if ((l < -2147483648L) || (l > 2147483647L)) {
            throw paramDeserializationContext.weirdStringException(this._valueClass, "Overflow: numeric value (" + paramJsonParser + ") out of range of int (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
          }
        }
        catch (IllegalArgumentException paramJsonParser)
        {
          throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid int value");
        }
        return (int)l;
      } while (j == 0);
      i = NumberInput.parseInt(paramJsonParser);
      return i;
    } while (localJsonToken == JsonToken.VALUE_NULL);
    throw paramDeserializationContext.mappingException(this._valueClass, localJsonToken);
  }
  
  protected final Integer _parseInteger(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {
      return Integer.valueOf(paramJsonParser.getIntValue());
    }
    if (localJsonToken == JsonToken.VALUE_STRING)
    {
      paramJsonParser = paramJsonParser.getText().trim();
      long l;
      try
      {
        i = paramJsonParser.length();
        if (i <= 9) {
          break label161;
        }
        l = Long.parseLong(paramJsonParser);
        if ((l < -2147483648L) || (l > 2147483647L)) {
          throw paramDeserializationContext.weirdStringException(this._valueClass, "Overflow: numeric value (" + paramJsonParser + ") out of range of Integer (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
        }
      }
      catch (IllegalArgumentException paramJsonParser)
      {
        throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid Integer value");
      }
      int i = (int)l;
      return Integer.valueOf(i);
      label161:
      if (i == 0) {
        return (Integer)getEmptyValue();
      }
      i = NumberInput.parseInt(paramJsonParser);
      return Integer.valueOf(i);
    }
    if (localJsonToken == JsonToken.VALUE_NULL) {
      return (Integer)getNullValue();
    }
    throw paramDeserializationContext.mappingException(this._valueClass, localJsonToken);
  }
  
  protected final Long _parseLong(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {
      return Long.valueOf(paramJsonParser.getLongValue());
    }
    if (localJsonToken == JsonToken.VALUE_STRING)
    {
      paramJsonParser = paramJsonParser.getText().trim();
      if (paramJsonParser.length() == 0) {
        return (Long)getEmptyValue();
      }
      try
      {
        long l = NumberInput.parseLong(paramJsonParser);
        return Long.valueOf(l);
      }
      catch (IllegalArgumentException paramJsonParser)
      {
        throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid Long value");
      }
    }
    if (localJsonToken == JsonToken.VALUE_NULL) {
      return (Long)getNullValue();
    }
    throw paramDeserializationContext.mappingException(this._valueClass, localJsonToken);
  }
  
  protected final long _parseLongPrimitive(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    long l = 0L;
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {
      l = paramJsonParser.getLongValue();
    }
    do
    {
      do
      {
        return l;
        if (localJsonToken != JsonToken.VALUE_STRING) {
          break;
        }
        paramJsonParser = paramJsonParser.getText().trim();
      } while (paramJsonParser.length() == 0);
      try
      {
        l = NumberInput.parseLong(paramJsonParser);
        return l;
      }
      catch (IllegalArgumentException paramJsonParser)
      {
        throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid long value");
      }
    } while (localJsonToken == JsonToken.VALUE_NULL);
    throw paramDeserializationContext.mappingException(this._valueClass, localJsonToken);
  }
  
  protected Short _parseShort(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {
      return Short.valueOf(paramJsonParser.getShortValue());
    }
    if (localJsonToken == JsonToken.VALUE_STRING)
    {
      paramJsonParser = paramJsonParser.getText().trim();
      int i;
      try
      {
        if (paramJsonParser.length() == 0) {
          return (Short)getEmptyValue();
        }
        i = NumberInput.parseInt(paramJsonParser);
        if ((i < 32768) || (i > 32767)) {
          throw paramDeserializationContext.weirdStringException(this._valueClass, "overflow, value can not be represented as 16-bit value");
        }
      }
      catch (IllegalArgumentException paramJsonParser)
      {
        throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid Short value");
      }
      return Short.valueOf((short)i);
    }
    if (localJsonToken == JsonToken.VALUE_NULL) {
      return (Short)getNullValue();
    }
    throw paramDeserializationContext.mappingException(this._valueClass, localJsonToken);
  }
  
  protected final short _parseShortPrimitive(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    int i = _parseIntPrimitive(paramJsonParser, paramDeserializationContext);
    if ((i < 32768) || (i > 32767)) {
      throw paramDeserializationContext.weirdStringException(this._valueClass, "overflow, value can not be represented as 16-bit value");
    }
    return (short)i;
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException, JsonProcessingException
  {
    return paramTypeDeserializer.deserializeTypedFromAny(paramJsonParser, paramDeserializationContext);
  }
  
  protected JsonDeserializer<Object> findDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    return paramDeserializerProvider.findValueDeserializer(paramDeserializationConfig, paramJavaType, paramBeanProperty);
  }
  
  public Class<?> getValueClass()
  {
    return this._valueClass;
  }
  
  public JavaType getValueType()
  {
    return null;
  }
  
  protected void handleUnknownProperty(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, String paramString)
    throws IOException, JsonProcessingException
  {
    Object localObject = paramObject;
    if (paramObject == null) {
      localObject = getValueClass();
    }
    if (paramDeserializationContext.handleUnknownProperty(paramJsonParser, this, localObject, paramString)) {
      return;
    }
    reportUnknownProperty(paramDeserializationContext, localObject, paramString);
    paramJsonParser.skipChildren();
  }
  
  protected boolean isDefaultSerializer(JsonDeserializer<?> paramJsonDeserializer)
  {
    return (paramJsonDeserializer != null) && (paramJsonDeserializer.getClass().getAnnotation(JacksonStdImpl.class) != null);
  }
  
  protected void reportUnknownProperty(DeserializationContext paramDeserializationContext, Object paramObject, String paramString)
    throws IOException, JsonProcessingException
  {
    if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES)) {
      throw paramDeserializationContext.unknownFieldException(paramObject, paramString);
    }
  }
  
  @JacksonStdImpl
  public static class BigDecimalDeserializer
    extends StdScalarDeserializer<BigDecimal>
  {
    public BigDecimalDeserializer()
    {
      super();
    }
    
    public BigDecimal deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      JsonToken localJsonToken = paramJsonParser.getCurrentToken();
      if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {
        return paramJsonParser.getDecimalValue();
      }
      if (localJsonToken == JsonToken.VALUE_STRING)
      {
        paramJsonParser = paramJsonParser.getText().trim();
        if (paramJsonParser.length() == 0) {
          return null;
        }
        try
        {
          paramJsonParser = new BigDecimal(paramJsonParser);
          return paramJsonParser;
        }
        catch (IllegalArgumentException paramJsonParser)
        {
          throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid representation");
        }
      }
      throw paramDeserializationContext.mappingException(this._valueClass, localJsonToken);
    }
  }
  
  @JacksonStdImpl
  public static class BigIntegerDeserializer
    extends StdScalarDeserializer<BigInteger>
  {
    public BigIntegerDeserializer()
    {
      super();
    }
    
    public BigInteger deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      JsonToken localJsonToken = paramJsonParser.getCurrentToken();
      if (localJsonToken == JsonToken.VALUE_NUMBER_INT) {
        switch (StdDeserializer.1.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[paramJsonParser.getNumberType().ordinal()])
        {
        }
      }
      do
      {
        paramJsonParser = paramJsonParser.getText().trim();
        if (paramJsonParser.length() != 0) {
          break;
        }
        return null;
        return BigInteger.valueOf(paramJsonParser.getLongValue());
        if (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT) {
          return paramJsonParser.getDecimalValue().toBigInteger();
        }
      } while (localJsonToken == JsonToken.VALUE_STRING);
      throw paramDeserializationContext.mappingException(this._valueClass, localJsonToken);
      try
      {
        paramJsonParser = new BigInteger(paramJsonParser);
        return paramJsonParser;
      }
      catch (IllegalArgumentException paramJsonParser)
      {
        throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid representation");
      }
    }
  }
  
  @JacksonStdImpl
  public static final class BooleanDeserializer
    extends StdDeserializer.PrimitiveOrWrapperDeserializer<Boolean>
  {
    public BooleanDeserializer(Class<Boolean> paramClass, Boolean paramBoolean)
    {
      super(paramBoolean);
    }
    
    public Boolean deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      return _parseBoolean(paramJsonParser, paramDeserializationContext);
    }
    
    public Boolean deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
      throws IOException, JsonProcessingException
    {
      return _parseBoolean(paramJsonParser, paramDeserializationContext);
    }
  }
  
  @JacksonStdImpl
  public static final class ByteDeserializer
    extends StdDeserializer.PrimitiveOrWrapperDeserializer<Byte>
  {
    public ByteDeserializer(Class<Byte> paramClass, Byte paramByte)
    {
      super(paramByte);
    }
    
    public Byte deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      return _parseByte(paramJsonParser, paramDeserializationContext);
    }
  }
  
  @JacksonStdImpl
  public static final class CharacterDeserializer
    extends StdDeserializer.PrimitiveOrWrapperDeserializer<Character>
  {
    public CharacterDeserializer(Class<Character> paramClass, Character paramCharacter)
    {
      super(paramCharacter);
    }
    
    public Character deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      JsonToken localJsonToken = paramJsonParser.getCurrentToken();
      if (localJsonToken == JsonToken.VALUE_NUMBER_INT)
      {
        int i = paramJsonParser.getIntValue();
        if ((i >= 0) && (i <= 65535)) {
          return Character.valueOf((char)i);
        }
      }
      else if (localJsonToken == JsonToken.VALUE_STRING)
      {
        paramJsonParser = paramJsonParser.getText();
        if (paramJsonParser.length() == 1) {
          return Character.valueOf(paramJsonParser.charAt(0));
        }
        if (paramJsonParser.length() == 0) {
          return (Character)getEmptyValue();
        }
      }
      throw paramDeserializationContext.mappingException(this._valueClass, localJsonToken);
    }
  }
  
  @JacksonStdImpl
  public static final class DoubleDeserializer
    extends StdDeserializer.PrimitiveOrWrapperDeserializer<Double>
  {
    public DoubleDeserializer(Class<Double> paramClass, Double paramDouble)
    {
      super(paramDouble);
    }
    
    public Double deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      return _parseDouble(paramJsonParser, paramDeserializationContext);
    }
    
    public Double deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
      throws IOException, JsonProcessingException
    {
      return _parseDouble(paramJsonParser, paramDeserializationContext);
    }
  }
  
  @JacksonStdImpl
  public static final class FloatDeserializer
    extends StdDeserializer.PrimitiveOrWrapperDeserializer<Float>
  {
    public FloatDeserializer(Class<Float> paramClass, Float paramFloat)
    {
      super(paramFloat);
    }
    
    public Float deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      return _parseFloat(paramJsonParser, paramDeserializationContext);
    }
  }
  
  @JacksonStdImpl
  public static final class IntegerDeserializer
    extends StdDeserializer.PrimitiveOrWrapperDeserializer<Integer>
  {
    public IntegerDeserializer(Class<Integer> paramClass, Integer paramInteger)
    {
      super(paramInteger);
    }
    
    public Integer deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      return _parseInteger(paramJsonParser, paramDeserializationContext);
    }
    
    public Integer deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
      throws IOException, JsonProcessingException
    {
      return _parseInteger(paramJsonParser, paramDeserializationContext);
    }
  }
  
  @JacksonStdImpl
  public static final class LongDeserializer
    extends StdDeserializer.PrimitiveOrWrapperDeserializer<Long>
  {
    public LongDeserializer(Class<Long> paramClass, Long paramLong)
    {
      super(paramLong);
    }
    
    public Long deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      return _parseLong(paramJsonParser, paramDeserializationContext);
    }
  }
  
  @JacksonStdImpl
  public static final class NumberDeserializer
    extends StdScalarDeserializer<Number>
  {
    public NumberDeserializer()
    {
      super();
    }
    
    public Number deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      JsonToken localJsonToken = paramJsonParser.getCurrentToken();
      if (localJsonToken == JsonToken.VALUE_NUMBER_INT)
      {
        if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_INTEGER_FOR_INTS)) {
          return paramJsonParser.getBigIntegerValue();
        }
        return paramJsonParser.getNumberValue();
      }
      if (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)
      {
        if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_DECIMAL_FOR_FLOATS)) {
          return paramJsonParser.getDecimalValue();
        }
        return Double.valueOf(paramJsonParser.getDoubleValue());
      }
      if (localJsonToken == JsonToken.VALUE_STRING)
      {
        paramJsonParser = paramJsonParser.getText().trim();
        try
        {
          if (paramJsonParser.indexOf('.') < 0) {
            break label132;
          }
          if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_DECIMAL_FOR_FLOATS))
          {
            paramJsonParser = new BigDecimal(paramJsonParser);
            return paramJsonParser;
          }
        }
        catch (IllegalArgumentException paramJsonParser)
        {
          throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid number");
        }
        return new Double(paramJsonParser);
        label132:
        if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_INTEGER_FOR_INTS)) {
          return new BigInteger(paramJsonParser);
        }
        long l = Long.parseLong(paramJsonParser);
        if ((l <= 2147483647L) && (l >= -2147483648L)) {
          return Integer.valueOf((int)l);
        }
        return Long.valueOf(l);
      }
      throw paramDeserializationContext.mappingException(this._valueClass, localJsonToken);
    }
    
    public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
      throws IOException, JsonProcessingException
    {
      switch (StdDeserializer.1.$SwitchMap$org$codehaus$jackson$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
      {
      default: 
        return paramTypeDeserializer.deserializeTypedFromScalar(paramJsonParser, paramDeserializationContext);
      }
      return deserialize(paramJsonParser, paramDeserializationContext);
    }
  }
  
  protected static abstract class PrimitiveOrWrapperDeserializer<T>
    extends StdScalarDeserializer<T>
  {
    final T _nullValue;
    
    protected PrimitiveOrWrapperDeserializer(Class<T> paramClass, T paramT)
    {
      super();
      this._nullValue = paramT;
    }
    
    public final T getNullValue()
    {
      return (T)this._nullValue;
    }
  }
  
  @JacksonStdImpl
  public static final class ShortDeserializer
    extends StdDeserializer.PrimitiveOrWrapperDeserializer<Short>
  {
    public ShortDeserializer(Class<Short> paramClass, Short paramShort)
    {
      super(paramShort);
    }
    
    public Short deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      return _parseShort(paramJsonParser, paramDeserializationContext);
    }
  }
  
  public static class SqlDateDeserializer
    extends StdScalarDeserializer<java.sql.Date>
  {
    public SqlDateDeserializer()
    {
      super();
    }
    
    public java.sql.Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      paramJsonParser = _parseDate(paramJsonParser, paramDeserializationContext);
      if (paramJsonParser == null) {
        return null;
      }
      return new java.sql.Date(paramJsonParser.getTime());
    }
  }
  
  public static class StackTraceElementDeserializer
    extends StdScalarDeserializer<StackTraceElement>
  {
    public StackTraceElementDeserializer()
    {
      super();
    }
    
    public StackTraceElement deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      Object localObject = paramJsonParser.getCurrentToken();
      if (localObject == JsonToken.START_OBJECT)
      {
        String str2 = "";
        localObject = "";
        String str1 = "";
        int i = -1;
        for (;;)
        {
          JsonToken localJsonToken = paramJsonParser.nextValue();
          if (localJsonToken == JsonToken.END_OBJECT) {
            break;
          }
          String str3 = paramJsonParser.getCurrentName();
          if ("className".equals(str3)) {
            str2 = paramJsonParser.getText();
          } else if ("fileName".equals(str3)) {
            str1 = paramJsonParser.getText();
          } else if ("lineNumber".equals(str3))
          {
            if (localJsonToken.isNumeric()) {
              i = paramJsonParser.getIntValue();
            } else {
              throw JsonMappingException.from(paramJsonParser, "Non-numeric token (" + localJsonToken + ") for property 'lineNumber'");
            }
          }
          else if ("methodName".equals(str3)) {
            localObject = paramJsonParser.getText();
          } else if (!"nativeMethod".equals(str3)) {
            handleUnknownProperty(paramJsonParser, paramDeserializationContext, this._valueClass, str3);
          }
        }
        return new StackTraceElement(str2, (String)localObject, str1, i);
      }
      throw paramDeserializationContext.mappingException(this._valueClass, (JsonToken)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/std/StdDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */