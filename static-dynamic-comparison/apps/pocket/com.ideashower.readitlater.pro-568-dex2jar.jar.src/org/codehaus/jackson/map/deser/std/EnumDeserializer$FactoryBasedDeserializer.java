package org.codehaus.jackson.map.deser.std;

import java.lang.reflect.Method;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.util.ClassUtil;

public class EnumDeserializer$FactoryBasedDeserializer
  extends StdScalarDeserializer
{
  protected final Class _enumClass;
  protected final Method _factory;
  
  public EnumDeserializer$FactoryBasedDeserializer(Class paramClass, AnnotatedMethod paramAnnotatedMethod)
  {
    super(Enum.class);
    this._enumClass = paramClass;
    this._factory = paramAnnotatedMethod.getAnnotated();
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/EnumDeserializer$FactoryBasedDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */