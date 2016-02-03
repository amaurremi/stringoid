package org.codehaus.jackson.map.ext;

import org.codehaus.jackson.map.DeserializationContext;
import org.w3c.dom.Node;

public class DOMDeserializer$NodeDeserializer
  extends DOMDeserializer
{
  public DOMDeserializer$NodeDeserializer()
  {
    super(Node.class);
  }
  
  public Node _deserialize(String paramString, DeserializationContext paramDeserializationContext)
  {
    return parse(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ext/DOMDeserializer$NodeDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */