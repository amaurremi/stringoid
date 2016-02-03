package org.codehaus.jackson.map.deser.std;

import java.util.ArrayList;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;

public abstract class FromStringDeserializer
  extends StdScalarDeserializer
{
  protected FromStringDeserializer(Class paramClass)
  {
    super(paramClass);
  }
  
  public static Iterable all()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new FromStringDeserializer.UUIDDeserializer());
    localArrayList.add(new FromStringDeserializer.URLDeserializer());
    localArrayList.add(new FromStringDeserializer.URIDeserializer());
    localArrayList.add(new FromStringDeserializer.CurrencyDeserializer());
    localArrayList.add(new FromStringDeserializer.PatternDeserializer());
    localArrayList.add(new FromStringDeserializer.LocaleDeserializer());
    localArrayList.add(new FromStringDeserializer.InetAddressDeserializer());
    localArrayList.add(new FromStringDeserializer.TimeZoneDeserializer());
    return localArrayList;
  }
  
  protected abstract Object _deserialize(String paramString, DeserializationContext paramDeserializationContext);
  
  protected Object _deserializeEmbedded(Object paramObject, DeserializationContext paramDeserializationContext)
  {
    throw paramDeserializationContext.mappingException("Don't know how to convert embedded Object of type " + paramObject.getClass().getName() + " into " + this._valueClass.getName());
  }
  
  public final Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    Object localObject1 = null;
    if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING)
    {
      paramJsonParser = paramJsonParser.getText().trim();
      if (paramJsonParser.length() == 0) {
        paramJsonParser = (JsonParser)localObject1;
      }
    }
    do
    {
      for (;;)
      {
        return paramJsonParser;
        try
        {
          localObject1 = _deserialize(paramJsonParser, paramDeserializationContext);
          paramJsonParser = (JsonParser)localObject1;
          if (localObject1 != null) {}
        }
        catch (IllegalArgumentException paramJsonParser)
        {
          Object localObject2;
          for (;;) {}
        }
      }
      throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid textual representation");
      if (paramJsonParser.getCurrentToken() != JsonToken.VALUE_EMBEDDED_OBJECT) {
        break;
      }
      localObject2 = paramJsonParser.getEmbeddedObject();
      paramJsonParser = (JsonParser)localObject1;
    } while (localObject2 == null);
    if (this._valueClass.isAssignableFrom(localObject2.getClass())) {
      return localObject2;
    }
    return _deserializeEmbedded(localObject2, paramDeserializationContext);
    throw paramDeserializationContext.mappingException(this._valueClass);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/FromStringDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */