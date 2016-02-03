package org.codehaus.jackson;

public abstract interface PrettyPrinter
{
  public abstract void beforeArrayValues(JsonGenerator paramJsonGenerator);
  
  public abstract void beforeObjectEntries(JsonGenerator paramJsonGenerator);
  
  public abstract void writeArrayValueSeparator(JsonGenerator paramJsonGenerator);
  
  public abstract void writeEndArray(JsonGenerator paramJsonGenerator, int paramInt);
  
  public abstract void writeEndObject(JsonGenerator paramJsonGenerator, int paramInt);
  
  public abstract void writeObjectEntrySeparator(JsonGenerator paramJsonGenerator);
  
  public abstract void writeObjectFieldValueSeparator(JsonGenerator paramJsonGenerator);
  
  public abstract void writeRootValueSeparator(JsonGenerator paramJsonGenerator);
  
  public abstract void writeStartArray(JsonGenerator paramJsonGenerator);
  
  public abstract void writeStartObject(JsonGenerator paramJsonGenerator);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/PrettyPrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */