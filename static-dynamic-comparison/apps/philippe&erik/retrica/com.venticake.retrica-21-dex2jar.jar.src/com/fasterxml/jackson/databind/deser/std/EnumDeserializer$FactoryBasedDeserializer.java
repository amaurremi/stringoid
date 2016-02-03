package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.reflect.Method;

public class EnumDeserializer$FactoryBasedDeserializer
  extends StdScalarDeserializer<Object>
{
  protected final Class<?> _enumClass;
  protected final Method _factory;
  protected final Class<?> _inputType;
  
  public EnumDeserializer$FactoryBasedDeserializer(Class<?> paramClass1, AnnotatedMethod paramAnnotatedMethod, Class<?> paramClass2)
  {
    super(Enum.class);
    this._enumClass = paramClass1;
    this._factory = paramAnnotatedMethod.getAnnotated();
    this._inputType = paramClass2;
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (this._inputType == null) {
      paramJsonParser = paramJsonParser.getText();
    }
    for (;;)
    {
      try
      {
        paramJsonParser = this._factory.invoke(this._enumClass, new Object[] { paramJsonParser });
        return paramJsonParser;
      }
      catch (Exception paramJsonParser)
      {
        ClassUtil.unwrapAndThrowAsIAE(paramJsonParser);
      }
      if (this._inputType == Integer.class) {
        paramJsonParser = Integer.valueOf(paramJsonParser.getValueAsInt());
      } else if (this._inputType == Long.class) {
        paramJsonParser = Long.valueOf(paramJsonParser.getValueAsLong());
      } else {
        throw paramDeserializationContext.mappingException(this._enumClass);
      }
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/EnumDeserializer$FactoryBasedDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */