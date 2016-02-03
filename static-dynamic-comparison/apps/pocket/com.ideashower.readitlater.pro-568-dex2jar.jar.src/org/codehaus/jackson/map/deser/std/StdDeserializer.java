package org.codehaus.jackson.map.deser.std;

import java.util.Date;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonParser.NumberType;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.io.NumberInput;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.type.JavaType;

public abstract class StdDeserializer
  extends JsonDeserializer
{
  protected final Class _valueClass;
  
  protected StdDeserializer(Class paramClass)
  {
    this._valueClass = paramClass;
  }
  
  protected StdDeserializer(JavaType paramJavaType)
  {
    if (paramJavaType == null) {}
    for (paramJavaType = null;; paramJavaType = paramJavaType.getRawClass())
    {
      this._valueClass = paramJavaType;
      return;
    }
  }
  
  protected static final double parseDouble(String paramString)
  {
    if ("2.2250738585072012e-308".equals(paramString)) {
      return 2.2250738585072014E-308D;
    }
    return Double.parseDouble(paramString);
  }
  
  protected final Boolean _parseBoolean(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
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
  
  protected Date _parseDate(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.VALUE_NUMBER_INT) {
      return new Date(paramJsonParser.getLongValue());
    }
    if (localJsonToken == JsonToken.VALUE_NULL) {
      return (Date)getNullValue();
    }
    if (localJsonToken == JsonToken.VALUE_STRING) {
      try
      {
        paramJsonParser = paramJsonParser.getText().trim();
        if (paramJsonParser.length() == 0) {
          return (Date)getEmptyValue();
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
  {
    int i = _parseIntPrimitive(paramJsonParser, paramDeserializationContext);
    if ((i < 32768) || (i > 32767)) {
      throw paramDeserializationContext.weirdStringException(this._valueClass, "overflow, value can not be represented as 16-bit value");
    }
    return (short)i;
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
  {
    return paramTypeDeserializer.deserializeTypedFromAny(paramJsonParser, paramDeserializationContext);
  }
  
  protected JsonDeserializer findDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    return paramDeserializerProvider.findValueDeserializer(paramDeserializationConfig, paramJavaType, paramBeanProperty);
  }
  
  public Class getValueClass()
  {
    return this._valueClass;
  }
  
  public JavaType getValueType()
  {
    return null;
  }
  
  protected void handleUnknownProperty(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, String paramString)
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
  
  protected boolean isDefaultSerializer(JsonDeserializer paramJsonDeserializer)
  {
    return (paramJsonDeserializer != null) && (paramJsonDeserializer.getClass().getAnnotation(JacksonStdImpl.class) != null);
  }
  
  protected void reportUnknownProperty(DeserializationContext paramDeserializationContext, Object paramObject, String paramString)
  {
    if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES)) {
      throw paramDeserializationContext.unknownFieldException(paramObject, paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */