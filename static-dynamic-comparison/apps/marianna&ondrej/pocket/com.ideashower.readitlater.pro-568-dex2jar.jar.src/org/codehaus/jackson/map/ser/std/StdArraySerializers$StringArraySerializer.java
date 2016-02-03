package org.codehaus.jackson.map.ser.std;

import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ResolvableSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.node.ObjectNode;

@JacksonStdImpl
public final class StdArraySerializers$StringArraySerializer
  extends StdArraySerializers.ArraySerializerBase
  implements ResolvableSerializer
{
  protected JsonSerializer _elementSerializer;
  
  public StdArraySerializers$StringArraySerializer(BeanProperty paramBeanProperty)
  {
    super(String[].class, null, paramBeanProperty);
  }
  
  private void serializeContentsSlow(String[] paramArrayOfString, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, JsonSerializer paramJsonSerializer)
  {
    int i = 0;
    int j = paramArrayOfString.length;
    if (i < j)
    {
      if (paramArrayOfString[i] == null) {
        paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
      }
      for (;;)
      {
        i += 1;
        break;
        paramJsonSerializer.serialize(paramArrayOfString[i], paramJsonGenerator, paramSerializerProvider);
      }
    }
  }
  
  public ContainerSerializerBase _withValueTypeSerializer(TypeSerializer paramTypeSerializer)
  {
    return this;
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    paramSerializerProvider = createSchemaNode("array", true);
    paramSerializerProvider.put("items", createSchemaNode("string"));
    return paramSerializerProvider;
  }
  
  public void resolve(SerializerProvider paramSerializerProvider)
  {
    paramSerializerProvider = paramSerializerProvider.findValueSerializer(String.class, this._property);
    if ((paramSerializerProvider != null) && (paramSerializerProvider.getClass().getAnnotation(JacksonStdImpl.class) == null)) {
      this._elementSerializer = paramSerializerProvider;
    }
  }
  
  public void serializeContents(String[] paramArrayOfString, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    int j = paramArrayOfString.length;
    if (j == 0) {
      return;
    }
    if (this._elementSerializer != null)
    {
      serializeContentsSlow(paramArrayOfString, paramJsonGenerator, paramSerializerProvider, this._elementSerializer);
      return;
    }
    int i = 0;
    label32:
    if (i < j)
    {
      if (paramArrayOfString[i] != null) {
        break label59;
      }
      paramJsonGenerator.writeNull();
    }
    for (;;)
    {
      i += 1;
      break label32;
      break;
      label59:
      paramJsonGenerator.writeString(paramArrayOfString[i]);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/std/StdArraySerializers$StringArraySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */