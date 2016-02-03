package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.Serializable;
import java.util.Date;

public abstract class StdDeserializer<T>
  extends JsonDeserializer<T>
  implements Serializable
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
  {
    if ("2.2250738585072012e-308".equals(paramString)) {
      return Double.MIN_VALUE;
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
      throw paramDeserializationContext.weirdStringException(paramJsonParser, this._valueClass, "only \"true\" or \"false\" recognized");
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
    throw paramDeserializationContext.weirdStringException(paramJsonParser, this._valueClass, "only \"true\" or \"false\" recognized");
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
        if ((i < -128) || (i > 255)) {
          throw paramDeserializationContext.weirdStringException(paramJsonParser, this._valueClass, "overflow, value can not be represented as 8-bit value");
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw paramDeserializationContext.weirdStringException(paramJsonParser, this._valueClass, "not a valid Byte value");
      }
      return Byte.valueOf((byte)i);
    }
    if (localIllegalArgumentException == JsonToken.VALUE_NULL) {
      return (Byte)getNullValue();
    }
    throw paramDeserializationContext.mappingException(this._valueClass, localIllegalArgumentException);
  }
  
  protected Date _parseDate(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    Object localObject = paramJsonParser.getCurrentToken();
    if (localObject == JsonToken.VALUE_NUMBER_INT) {
      return new Date(paramJsonParser.getLongValue());
    }
    if (localObject == JsonToken.VALUE_NULL) {
      return (Date)getNullValue();
    }
    if (localObject == JsonToken.VALUE_STRING)
    {
      localObject = null;
      try
      {
        paramJsonParser = paramJsonParser.getText().trim();
        localObject = paramJsonParser;
        if (paramJsonParser.length() == 0)
        {
          localObject = paramJsonParser;
          return (Date)getEmptyValue();
        }
        localObject = paramJsonParser;
        paramJsonParser = paramDeserializationContext.parseDate(paramJsonParser);
        return paramJsonParser;
      }
      catch (IllegalArgumentException paramJsonParser)
      {
        throw paramDeserializationContext.weirdStringException((String)localObject, this._valueClass, "not a valid representation (error: " + paramJsonParser.getMessage() + ")");
      }
    }
    throw paramDeserializationContext.mappingException(this._valueClass, (JsonToken)localObject);
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
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          throw paramDeserializationContext.weirdStringException(paramJsonParser, this._valueClass, "not a valid Double value");
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
    if (localIllegalArgumentException == JsonToken.VALUE_NULL) {
      return (Double)getNullValue();
    }
    throw paramDeserializationContext.mappingException(this._valueClass, localIllegalArgumentException);
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
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          throw paramDeserializationContext.weirdStringException(paramJsonParser, this._valueClass, "not a valid double value");
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
    } while (localIllegalArgumentException == JsonToken.VALUE_NULL);
    throw paramDeserializationContext.mappingException(this._valueClass, localIllegalArgumentException);
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
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          throw paramDeserializationContext.weirdStringException(paramJsonParser, this._valueClass, "not a valid Float value");
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
    if (localIllegalArgumentException == JsonToken.VALUE_NULL) {
      return (Float)getNullValue();
    }
    throw paramDeserializationContext.mappingException(this._valueClass, localIllegalArgumentException);
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
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          throw paramDeserializationContext.weirdStringException(paramJsonParser, this._valueClass, "not a valid float value");
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
    } while (localIllegalArgumentException == JsonToken.VALUE_NULL);
    throw paramDeserializationContext.mappingException(this._valueClass, localIllegalArgumentException);
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
            throw paramDeserializationContext.weirdStringException(paramJsonParser, this._valueClass, "Overflow: numeric value (" + paramJsonParser + ") out of range of int (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          throw paramDeserializationContext.weirdStringException(paramJsonParser, this._valueClass, "not a valid int value");
        }
        return (int)l;
      } while (j == 0);
      i = NumberInput.parseInt(paramJsonParser);
      return i;
    } while (localIllegalArgumentException == JsonToken.VALUE_NULL);
    throw paramDeserializationContext.mappingException(this._valueClass, localIllegalArgumentException);
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
          break label164;
        }
        l = Long.parseLong(paramJsonParser);
        if ((l < -2147483648L) || (l > 2147483647L)) {
          throw paramDeserializationContext.weirdStringException(paramJsonParser, this._valueClass, "Overflow: numeric value (" + paramJsonParser + ") out of range of Integer (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw paramDeserializationContext.weirdStringException(paramJsonParser, this._valueClass, "not a valid Integer value");
      }
      int i = (int)l;
      return Integer.valueOf(i);
      label164:
      if (i == 0) {
        return (Integer)getEmptyValue();
      }
      i = NumberInput.parseInt(paramJsonParser);
      return Integer.valueOf(i);
    }
    if (localIllegalArgumentException == JsonToken.VALUE_NULL) {
      return (Integer)getNullValue();
    }
    throw paramDeserializationContext.mappingException(this._valueClass, localIllegalArgumentException);
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
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw paramDeserializationContext.weirdStringException(paramJsonParser, this._valueClass, "not a valid Long value");
      }
    }
    if (localIllegalArgumentException == JsonToken.VALUE_NULL) {
      return (Long)getNullValue();
    }
    throw paramDeserializationContext.mappingException(this._valueClass, localIllegalArgumentException);
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
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw paramDeserializationContext.weirdStringException(paramJsonParser, this._valueClass, "not a valid long value");
      }
    } while (localIllegalArgumentException == JsonToken.VALUE_NULL);
    throw paramDeserializationContext.mappingException(this._valueClass, localIllegalArgumentException);
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
          throw paramDeserializationContext.weirdStringException(paramJsonParser, this._valueClass, "overflow, value can not be represented as 16-bit value");
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw paramDeserializationContext.weirdStringException(paramJsonParser, this._valueClass, "not a valid Short value");
      }
      return Short.valueOf((short)i);
    }
    if (localIllegalArgumentException == JsonToken.VALUE_NULL) {
      return (Short)getNullValue();
    }
    throw paramDeserializationContext.mappingException(this._valueClass, localIllegalArgumentException);
  }
  
  protected final short _parseShortPrimitive(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    int i = _parseIntPrimitive(paramJsonParser, paramDeserializationContext);
    if ((i < 32768) || (i > 32767)) {
      throw paramDeserializationContext.weirdStringException(String.valueOf(i), this._valueClass, "overflow, value can not be represented as 16-bit value");
    }
    return (short)i;
  }
  
  protected final String _parseString(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    String str = paramJsonParser.getValueAsString();
    if (str != null) {
      return str;
    }
    throw paramDeserializationContext.mappingException(String.class, paramJsonParser.getCurrentToken());
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
  {
    return paramTypeDeserializer.deserializeTypedFromAny(paramJsonParser, paramDeserializationContext);
  }
  
  protected JsonDeserializer<Object> findDeserializer(DeserializationContext paramDeserializationContext, JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    return paramDeserializationContext.findContextualValueDeserializer(paramJavaType, paramBeanProperty);
  }
  
  public Class<?> getValueClass()
  {
    return this._valueClass;
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
    paramDeserializationContext.reportUnknownProperty(localObject, paramString, this);
    paramJsonParser.skipChildren();
  }
  
  protected boolean isDefaultDeserializer(JsonDeserializer<?> paramJsonDeserializer)
  {
    return (paramJsonDeserializer != null) && (paramJsonDeserializer.getClass().getAnnotation(JacksonStdImpl.class) != null);
  }
  
  protected boolean isDefaultKeyDeserializer(KeyDeserializer paramKeyDeserializer)
  {
    return (paramKeyDeserializer != null) && (paramKeyDeserializer.getClass().getAnnotation(JacksonStdImpl.class) != null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/StdDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */