package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;

public class EnumDeserializer
  extends StdScalarDeserializer<Enum<?>>
{
  protected final EnumResolver<?> _resolver;
  
  public EnumDeserializer(EnumResolver<?> paramEnumResolver)
  {
    super(Enum.class);
    this._resolver = paramEnumResolver;
  }
  
  public static JsonDeserializer<?> deserializerForCreator(DeserializationConfig paramDeserializationConfig, Class<?> paramClass, AnnotatedMethod paramAnnotatedMethod)
  {
    Class localClass = paramAnnotatedMethod.getRawParameterType(0);
    if (localClass == String.class) {
      localClass = null;
    }
    for (;;)
    {
      if (paramDeserializationConfig.canOverrideAccessModifiers()) {
        ClassUtil.checkAndFixAccess(paramAnnotatedMethod.getMember());
      }
      return new EnumDeserializer.FactoryBasedDeserializer(paramClass, paramAnnotatedMethod, localClass);
      if ((localClass == Integer.TYPE) || (localClass == Integer.class))
      {
        localClass = Integer.class;
      }
      else
      {
        if ((localClass != Long.TYPE) && (localClass != Long.class)) {
          break;
        }
        localClass = Long.class;
      }
    }
    throw new IllegalArgumentException("Parameter #0 type for factory method (" + paramAnnotatedMethod + ") not suitable, must be java.lang.String or int/Integer/long/Long");
  }
  
  public Enum<?> deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    Object localObject = paramJsonParser.getCurrentToken();
    if ((localObject == JsonToken.VALUE_STRING) || (localObject == JsonToken.FIELD_NAME))
    {
      String str = paramJsonParser.getText();
      localObject = this._resolver.findEnum(str);
      paramJsonParser = (JsonParser)localObject;
      if (localObject == null)
      {
        paramJsonParser = (JsonParser)localObject;
        if (!paramDeserializationContext.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
          throw paramDeserializationContext.weirdStringException(str, this._resolver.getEnumClass(), "value not one of declared Enum instance names");
        }
      }
    }
    else if (localObject == JsonToken.VALUE_NUMBER_INT)
    {
      if (paramDeserializationContext.isEnabled(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS)) {
        throw paramDeserializationContext.mappingException("Not allowed to deserialize Enum value out of JSON number (disable DeserializationConfig.DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS to allow)");
      }
      int i = paramJsonParser.getIntValue();
      localObject = this._resolver.getEnum(i);
      paramJsonParser = (JsonParser)localObject;
      if (localObject == null)
      {
        paramJsonParser = (JsonParser)localObject;
        if (!paramDeserializationContext.isEnabled(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
          throw paramDeserializationContext.weirdNumberException(Integer.valueOf(i), this._resolver.getEnumClass(), "index value outside legal index range [0.." + this._resolver.lastValidIndex() + "]");
        }
      }
    }
    else
    {
      throw paramDeserializationContext.mappingException(this._resolver.getEnumClass());
    }
    return paramJsonParser;
  }
  
  public boolean isCachable()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/EnumDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */