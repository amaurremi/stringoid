package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.util.EnumValues;

@JacksonStdImpl
public class EnumSerializer
  extends StdScalarSerializer<Enum<?>>
  implements ContextualSerializer
{
  protected final Boolean _serializeAsIndex;
  protected final EnumValues _values;
  
  public EnumSerializer(EnumValues paramEnumValues, Boolean paramBoolean)
  {
    super(Enum.class, false);
    this._values = paramEnumValues;
    this._serializeAsIndex = paramBoolean;
  }
  
  protected static Boolean _isShapeWrittenUsingIndex(Class<?> paramClass, JsonFormat.Value paramValue, boolean paramBoolean)
  {
    if (paramValue == null)
    {
      paramValue = null;
      if (paramValue != null) {
        break label20;
      }
    }
    label20:
    while ((paramValue == JsonFormat.Shape.ANY) || (paramValue == JsonFormat.Shape.SCALAR))
    {
      return null;
      paramValue = paramValue.getShape();
      break;
    }
    if (paramValue == JsonFormat.Shape.STRING) {
      return Boolean.FALSE;
    }
    if (paramValue.isNumeric()) {
      return Boolean.TRUE;
    }
    paramValue = new StringBuilder().append("Unsupported serialization shape (").append(paramValue).append(") for Enum ").append(paramClass.getName()).append(", not supported as ");
    if (paramBoolean) {}
    for (paramClass = "class";; paramClass = "property") {
      throw new IllegalArgumentException(paramClass + " annotation");
    }
  }
  
  public static EnumSerializer construct(Class<Enum<?>> paramClass, SerializationConfig paramSerializationConfig, BeanDescription paramBeanDescription, JsonFormat.Value paramValue)
  {
    paramBeanDescription = paramSerializationConfig.getAnnotationIntrospector();
    if (paramSerializationConfig.isEnabled(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)) {}
    for (paramSerializationConfig = EnumValues.constructFromToString(paramClass, paramBeanDescription);; paramSerializationConfig = EnumValues.constructFromName(paramClass, paramBeanDescription)) {
      return new EnumSerializer(paramSerializationConfig, _isShapeWrittenUsingIndex(paramClass, paramValue, true));
    }
  }
  
  public JsonSerializer<?> createContextual(SerializerProvider paramSerializerProvider, BeanProperty paramBeanProperty)
  {
    EnumSerializer localEnumSerializer = this;
    if (paramBeanProperty != null)
    {
      paramSerializerProvider = paramSerializerProvider.getAnnotationIntrospector().findFormat(paramBeanProperty.getMember());
      localEnumSerializer = this;
      if (paramSerializerProvider != null)
      {
        paramSerializerProvider = _isShapeWrittenUsingIndex(paramBeanProperty.getType().getRawClass(), paramSerializerProvider, false);
        localEnumSerializer = this;
        if (paramSerializerProvider != this._serializeAsIndex) {
          localEnumSerializer = new EnumSerializer(this._values, paramSerializerProvider);
        }
      }
    }
    return localEnumSerializer;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/EnumSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */