package org.codehaus.jackson.map.ext;

import javax.xml.namespace.QName;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.std.FromStringDeserializer;

public class CoreXMLDeserializers$QNameDeserializer
  extends FromStringDeserializer
{
  public CoreXMLDeserializers$QNameDeserializer()
  {
    super(QName.class);
  }
  
  protected QName _deserialize(String paramString, DeserializationContext paramDeserializationContext)
  {
    return QName.valueOf(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ext/CoreXMLDeserializers$QNameDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */