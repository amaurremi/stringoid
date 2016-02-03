package com.flurry.org.codehaus.jackson.map.deser;

import com.flurry.org.codehaus.jackson.Base64Variant;
import com.flurry.org.codehaus.jackson.Base64Variants;
import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.TypeDeserializer;
import com.flurry.org.codehaus.jackson.map.annotate.JacksonStdImpl;
import com.flurry.org.codehaus.jackson.map.deser.std.CalendarDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.std.ClassDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.std.StdScalarDeserializer;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.io.IOException;

@Deprecated
public abstract class StdDeserializer<T>
  extends com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer<T>
{
  protected StdDeserializer(JavaType paramJavaType)
  {
    super(paramJavaType);
  }
  
  protected StdDeserializer(Class<?> paramClass)
  {
    super(paramClass);
  }
  
  @JacksonStdImpl
  @Deprecated
  public class CalendarDeserializer
    extends CalendarDeserializer
  {
    public CalendarDeserializer() {}
  }
  
  @JacksonStdImpl
  @Deprecated
  public class ClassDeserializer
    extends ClassDeserializer
  {
    public ClassDeserializer() {}
  }
  
  @JacksonStdImpl
  @Deprecated
  public static final class StringDeserializer
    extends StdScalarDeserializer<String>
  {
    public StringDeserializer()
    {
      super();
    }
    
    public String deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      JsonToken localJsonToken = paramJsonParser.getCurrentToken();
      if (localJsonToken == JsonToken.VALUE_STRING) {
        return paramJsonParser.getText();
      }
      if (localJsonToken == JsonToken.VALUE_EMBEDDED_OBJECT)
      {
        paramJsonParser = paramJsonParser.getEmbeddedObject();
        if (paramJsonParser == null) {
          return null;
        }
        if ((paramJsonParser instanceof byte[])) {
          return Base64Variants.getDefaultVariant().encode((byte[])paramJsonParser, false);
        }
        return paramJsonParser.toString();
      }
      if (localJsonToken.isScalarValue()) {
        return paramJsonParser.getText();
      }
      throw paramDeserializationContext.mappingException(this._valueClass, localJsonToken);
    }
    
    public String deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
      throws IOException, JsonProcessingException
    {
      return deserialize(paramJsonParser, paramDeserializationContext);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/StdDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */