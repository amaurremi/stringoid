package com.flurry.org.codehaus.jackson.map.deser.std;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.DeserializationConfig;
import com.flurry.org.codehaus.jackson.map.DeserializationConfig.Feature;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.JsonDeserializer;
import com.flurry.org.codehaus.jackson.map.annotate.JsonCachable;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedMethod;
import com.flurry.org.codehaus.jackson.map.util.ClassUtil;
import com.flurry.org.codehaus.jackson.map.util.EnumResolver;
import java.io.IOException;
import java.lang.reflect.Method;

@JsonCachable
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
    if (paramAnnotatedMethod.getParameterType(0) != String.class) {
      throw new IllegalArgumentException("Parameter #0 type for factory method (" + paramAnnotatedMethod + ") not suitable, must be java.lang.String");
    }
    if (paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
      ClassUtil.checkAndFixAccess(paramAnnotatedMethod.getMember());
    }
    return new FactoryBasedDeserializer(paramClass, paramAnnotatedMethod);
  }
  
  public Enum<?> deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if ((localJsonToken == JsonToken.VALUE_STRING) || (localJsonToken == JsonToken.FIELD_NAME))
    {
      paramJsonParser = paramJsonParser.getText();
      paramJsonParser = this._resolver.findEnum(paramJsonParser);
      if (paramJsonParser == null) {
        throw paramDeserializationContext.weirdStringException(this._resolver.getEnumClass(), "value not one of declared Enum instance names");
      }
      return paramJsonParser;
    }
    if (localJsonToken == JsonToken.VALUE_NUMBER_INT)
    {
      if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.FAIL_ON_NUMBERS_FOR_ENUMS)) {
        throw paramDeserializationContext.mappingException("Not allowed to deserialize Enum value out of JSON number (disable DeserializationConfig.Feature.FAIL_ON_NUMBERS_FOR_ENUMS to allow)");
      }
      int i = paramJsonParser.getIntValue();
      paramJsonParser = this._resolver.getEnum(i);
      if (paramJsonParser == null) {
        throw paramDeserializationContext.weirdNumberException(this._resolver.getEnumClass(), "index value outside legal index range [0.." + this._resolver.lastValidIndex() + "]");
      }
      return paramJsonParser;
    }
    throw paramDeserializationContext.mappingException(this._resolver.getEnumClass());
  }
  
  protected static class FactoryBasedDeserializer
    extends StdScalarDeserializer<Object>
  {
    protected final Class<?> _enumClass;
    protected final Method _factory;
    
    public FactoryBasedDeserializer(Class<?> paramClass, AnnotatedMethod paramAnnotatedMethod)
    {
      super();
      this._enumClass = paramClass;
      this._factory = paramAnnotatedMethod.getAnnotated();
    }
    
    public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      JsonToken localJsonToken = paramJsonParser.getCurrentToken();
      if ((localJsonToken != JsonToken.VALUE_STRING) && (localJsonToken != JsonToken.FIELD_NAME)) {
        throw paramDeserializationContext.mappingException(this._enumClass);
      }
      paramJsonParser = paramJsonParser.getText();
      try
      {
        paramJsonParser = this._factory.invoke(this._enumClass, new Object[] { paramJsonParser });
        return paramJsonParser;
      }
      catch (Exception paramJsonParser)
      {
        ClassUtil.unwrapAndThrowAsIAE(paramJsonParser);
      }
      return null;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/std/EnumDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */