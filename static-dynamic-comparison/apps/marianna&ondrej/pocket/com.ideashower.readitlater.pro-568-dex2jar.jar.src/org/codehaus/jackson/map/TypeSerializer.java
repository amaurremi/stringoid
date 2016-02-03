package org.codehaus.jackson.map;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.annotate.JsonTypeInfo.As;
import org.codehaus.jackson.map.jsontype.TypeIdResolver;

public abstract class TypeSerializer
{
  public abstract String getPropertyName();
  
  public abstract TypeIdResolver getTypeIdResolver();
  
  public abstract JsonTypeInfo.As getTypeInclusion();
  
  public abstract void writeTypePrefixForArray(Object paramObject, JsonGenerator paramJsonGenerator);
  
  public void writeTypePrefixForArray(Object paramObject, JsonGenerator paramJsonGenerator, Class paramClass)
  {
    writeTypePrefixForArray(paramObject, paramJsonGenerator);
  }
  
  public abstract void writeTypePrefixForObject(Object paramObject, JsonGenerator paramJsonGenerator);
  
  public void writeTypePrefixForObject(Object paramObject, JsonGenerator paramJsonGenerator, Class paramClass)
  {
    writeTypePrefixForObject(paramObject, paramJsonGenerator);
  }
  
  public abstract void writeTypePrefixForScalar(Object paramObject, JsonGenerator paramJsonGenerator);
  
  public void writeTypePrefixForScalar(Object paramObject, JsonGenerator paramJsonGenerator, Class paramClass)
  {
    writeTypePrefixForScalar(paramObject, paramJsonGenerator);
  }
  
  public abstract void writeTypeSuffixForArray(Object paramObject, JsonGenerator paramJsonGenerator);
  
  public abstract void writeTypeSuffixForObject(Object paramObject, JsonGenerator paramJsonGenerator);
  
  public abstract void writeTypeSuffixForScalar(Object paramObject, JsonGenerator paramJsonGenerator);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/TypeSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */