package com.flurry.org.codehaus.jackson.map.ser.std;

import com.flurry.org.codehaus.jackson.JsonGenerationException;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonNode;
import com.flurry.org.codehaus.jackson.io.SerializedString;
import com.flurry.org.codehaus.jackson.map.SerializationConfig;
import com.flurry.org.codehaus.jackson.map.SerializationConfig.Feature;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import com.flurry.org.codehaus.jackson.map.annotate.JacksonStdImpl;
import com.flurry.org.codehaus.jackson.map.introspect.BasicBeanDescription;
import com.flurry.org.codehaus.jackson.map.util.EnumValues;
import com.flurry.org.codehaus.jackson.node.ArrayNode;
import com.flurry.org.codehaus.jackson.node.ObjectNode;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

@JacksonStdImpl
public class EnumSerializer
  extends ScalarSerializerBase<Enum<?>>
{
  protected final EnumValues _values;
  
  public EnumSerializer(EnumValues paramEnumValues)
  {
    super(Enum.class, false);
    this._values = paramEnumValues;
  }
  
  public static EnumSerializer construct(Class<Enum<?>> paramClass, SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription)
  {
    paramBasicBeanDescription = paramSerializationConfig.getAnnotationIntrospector();
    if (paramSerializationConfig.isEnabled(SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING)) {}
    for (paramClass = EnumValues.constructFromToString(paramClass, paramBasicBeanDescription);; paramClass = EnumValues.constructFromName(paramClass, paramBasicBeanDescription)) {
      return new EnumSerializer(paramClass);
    }
  }
  
  public EnumValues getEnumValues()
  {
    return this._values;
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    Object localObject;
    if (paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_ENUMS_USING_INDEX)) {
      localObject = createSchemaNode("integer", true);
    }
    ObjectNode localObjectNode;
    do
    {
      do
      {
        return (JsonNode)localObject;
        localObjectNode = createSchemaNode("string", true);
        localObject = localObjectNode;
      } while (paramType == null);
      localObject = localObjectNode;
    } while (!paramSerializerProvider.constructType(paramType).isEnumType());
    paramSerializerProvider = localObjectNode.putArray("enum");
    paramType = this._values.values().iterator();
    for (;;)
    {
      localObject = localObjectNode;
      if (!paramType.hasNext()) {
        break;
      }
      paramSerializerProvider.add(((SerializedString)paramType.next()).getValue());
    }
  }
  
  public final void serialize(Enum<?> paramEnum, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonGenerationException
  {
    if (paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_ENUMS_USING_INDEX))
    {
      paramJsonGenerator.writeNumber(paramEnum.ordinal());
      return;
    }
    paramJsonGenerator.writeString(this._values.serializedValueFor(paramEnum));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/ser/std/EnumSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */