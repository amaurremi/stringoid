package org.codehaus.jackson.map.ser.std;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.io.SerializedString;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.util.EnumValues;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.type.JavaType;

@JacksonStdImpl
public class EnumSerializer
  extends ScalarSerializerBase
{
  protected final EnumValues _values;
  
  public EnumSerializer(EnumValues paramEnumValues)
  {
    super(Enum.class, false);
    this._values = paramEnumValues;
  }
  
  public static EnumSerializer construct(Class paramClass, SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription)
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
    if (paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_ENUMS_USING_INDEX)) {
      return createSchemaNode("integer", true);
    }
    ObjectNode localObjectNode = createSchemaNode("string", true);
    if ((paramType != null) && (paramSerializerProvider.constructType(paramType).isEnumType()))
    {
      paramSerializerProvider = localObjectNode.putArray("enum");
      paramType = this._values.values().iterator();
      while (paramType.hasNext()) {
        paramSerializerProvider.add(((SerializedString)paramType.next()).getValue());
      }
    }
    return localObjectNode;
  }
  
  public final void serialize(Enum paramEnum, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    if (paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_ENUMS_USING_INDEX))
    {
      paramJsonGenerator.writeNumber(paramEnum.ordinal());
      return;
    }
    paramJsonGenerator.writeString(this._values.serializedValueFor(paramEnum));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/std/EnumSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */