package org.codehaus.jackson.map.ext;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.std.FromStringDeserializer;

public class CoreXMLDeserializers$DurationDeserializer
  extends FromStringDeserializer
{
  public CoreXMLDeserializers$DurationDeserializer()
  {
    super(Duration.class);
  }
  
  protected Duration _deserialize(String paramString, DeserializationContext paramDeserializationContext)
  {
    return CoreXMLDeserializers._dataTypeFactory.newDuration(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ext/CoreXMLDeserializers$DurationDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */