package org.codehaus.jackson.util;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.PrettyPrinter;

public class MinimalPrettyPrinter
  implements PrettyPrinter
{
  public static final String DEFAULT_ROOT_VALUE_SEPARATOR = " ";
  protected String _rootValueSeparator = " ";
  
  public MinimalPrettyPrinter()
  {
    this(" ");
  }
  
  public MinimalPrettyPrinter(String paramString)
  {
    this._rootValueSeparator = paramString;
  }
  
  public void beforeArrayValues(JsonGenerator paramJsonGenerator) {}
  
  public void beforeObjectEntries(JsonGenerator paramJsonGenerator) {}
  
  public void setRootValueSeparator(String paramString)
  {
    this._rootValueSeparator = paramString;
  }
  
  public void writeArrayValueSeparator(JsonGenerator paramJsonGenerator)
  {
    paramJsonGenerator.writeRaw(',');
  }
  
  public void writeEndArray(JsonGenerator paramJsonGenerator, int paramInt)
  {
    paramJsonGenerator.writeRaw(']');
  }
  
  public void writeEndObject(JsonGenerator paramJsonGenerator, int paramInt)
  {
    paramJsonGenerator.writeRaw('}');
  }
  
  public void writeObjectEntrySeparator(JsonGenerator paramJsonGenerator)
  {
    paramJsonGenerator.writeRaw(',');
  }
  
  public void writeObjectFieldValueSeparator(JsonGenerator paramJsonGenerator)
  {
    paramJsonGenerator.writeRaw(':');
  }
  
  public void writeRootValueSeparator(JsonGenerator paramJsonGenerator)
  {
    if (this._rootValueSeparator != null) {
      paramJsonGenerator.writeRaw(this._rootValueSeparator);
    }
  }
  
  public void writeStartArray(JsonGenerator paramJsonGenerator)
  {
    paramJsonGenerator.writeRaw('[');
  }
  
  public void writeStartObject(JsonGenerator paramJsonGenerator)
  {
    paramJsonGenerator.writeRaw('{');
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/util/MinimalPrettyPrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */