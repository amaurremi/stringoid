package org.codehaus.jackson.map.ser.std;

import java.io.IOException;
import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonSerializable;
import org.codehaus.jackson.map.JsonSerializableWithType;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.ser.SerializerBase;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.schema.JsonSerializableSchema;
import org.codehaus.jackson.type.JavaType;

@JacksonStdImpl
public class SerializableSerializer
  extends SerializerBase
{
  public static final SerializableSerializer instance = new SerializableSerializer();
  
  protected SerializableSerializer()
  {
    super(JsonSerializable.class);
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    String str = null;
    ObjectNode localObjectNode = createObjectNode();
    paramSerializerProvider = "any";
    JsonSerializableSchema localJsonSerializableSchema;
    if (paramType != null)
    {
      paramType = TypeFactory.type(paramType).getRawClass();
      if (paramType.isAnnotationPresent(JsonSerializableSchema.class))
      {
        localJsonSerializableSchema = (JsonSerializableSchema)paramType.getAnnotation(JsonSerializableSchema.class);
        paramType = localJsonSerializableSchema.schemaType();
        if (!"##irrelevant".equals(localJsonSerializableSchema.schemaObjectPropertiesDefinition()))
        {
          paramSerializerProvider = localJsonSerializableSchema.schemaObjectPropertiesDefinition();
          if (!"##irrelevant".equals(localJsonSerializableSchema.schemaItemDefinition())) {
            str = localJsonSerializableSchema.schemaItemDefinition();
          }
        }
      }
    }
    for (;;)
    {
      localObjectNode.put("type", paramType);
      if (paramSerializerProvider != null) {}
      try
      {
        localObjectNode.put("properties", (JsonNode)new ObjectMapper().readValue(paramSerializerProvider, JsonNode.class));
        if (str != null) {}
        continue;
        paramSerializerProvider = null;
      }
      catch (IOException paramSerializerProvider)
      {
        try
        {
          localObjectNode.put("items", (JsonNode)new ObjectMapper().readValue(str, JsonNode.class));
          return localObjectNode;
        }
        catch (IOException paramSerializerProvider)
        {
          throw new IllegalStateException(paramSerializerProvider);
        }
        paramSerializerProvider = paramSerializerProvider;
        throw new IllegalStateException(paramSerializerProvider);
      }
      break;
      localJsonSerializableSchema = null;
      paramType = paramSerializerProvider;
      paramSerializerProvider = localJsonSerializableSchema;
    }
  }
  
  public void serialize(JsonSerializable paramJsonSerializable, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    paramJsonSerializable.serialize(paramJsonGenerator, paramSerializerProvider);
  }
  
  public final void serializeWithType(JsonSerializable paramJsonSerializable, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
  {
    if ((paramJsonSerializable instanceof JsonSerializableWithType))
    {
      ((JsonSerializableWithType)paramJsonSerializable).serializeWithType(paramJsonGenerator, paramSerializerProvider, paramTypeSerializer);
      return;
    }
    serialize(paramJsonSerializable, paramJsonGenerator, paramSerializerProvider);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/std/SerializableSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */