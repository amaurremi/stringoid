package org.codehaus.jackson.map.jsontype.impl;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.annotate.JsonTypeInfo.As;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.jsontype.TypeIdResolver;

public class AsWrapperTypeSerializer
  extends TypeSerializerBase
{
  public AsWrapperTypeSerializer(TypeIdResolver paramTypeIdResolver, BeanProperty paramBeanProperty)
  {
    super(paramTypeIdResolver, paramBeanProperty);
  }
  
  public JsonTypeInfo.As getTypeInclusion()
  {
    return JsonTypeInfo.As.WRAPPER_OBJECT;
  }
  
  public void writeTypePrefixForArray(Object paramObject, JsonGenerator paramJsonGenerator)
  {
    paramJsonGenerator.writeStartObject();
    paramJsonGenerator.writeArrayFieldStart(this._idResolver.idFromValue(paramObject));
  }
  
  public void writeTypePrefixForArray(Object paramObject, JsonGenerator paramJsonGenerator, Class paramClass)
  {
    paramJsonGenerator.writeStartObject();
    paramJsonGenerator.writeArrayFieldStart(this._idResolver.idFromValueAndType(paramObject, paramClass));
  }
  
  public void writeTypePrefixForObject(Object paramObject, JsonGenerator paramJsonGenerator)
  {
    paramJsonGenerator.writeStartObject();
    paramJsonGenerator.writeObjectFieldStart(this._idResolver.idFromValue(paramObject));
  }
  
  public void writeTypePrefixForObject(Object paramObject, JsonGenerator paramJsonGenerator, Class paramClass)
  {
    paramJsonGenerator.writeStartObject();
    paramJsonGenerator.writeObjectFieldStart(this._idResolver.idFromValueAndType(paramObject, paramClass));
  }
  
  public void writeTypePrefixForScalar(Object paramObject, JsonGenerator paramJsonGenerator)
  {
    paramJsonGenerator.writeStartObject();
    paramJsonGenerator.writeFieldName(this._idResolver.idFromValue(paramObject));
  }
  
  public void writeTypePrefixForScalar(Object paramObject, JsonGenerator paramJsonGenerator, Class paramClass)
  {
    paramJsonGenerator.writeStartObject();
    paramJsonGenerator.writeFieldName(this._idResolver.idFromValueAndType(paramObject, paramClass));
  }
  
  public void writeTypeSuffixForArray(Object paramObject, JsonGenerator paramJsonGenerator)
  {
    paramJsonGenerator.writeEndArray();
    paramJsonGenerator.writeEndObject();
  }
  
  public void writeTypeSuffixForObject(Object paramObject, JsonGenerator paramJsonGenerator)
  {
    paramJsonGenerator.writeEndObject();
    paramJsonGenerator.writeEndObject();
  }
  
  public void writeTypeSuffixForScalar(Object paramObject, JsonGenerator paramJsonGenerator)
  {
    paramJsonGenerator.writeEndObject();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/jsontype/impl/AsWrapperTypeSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */