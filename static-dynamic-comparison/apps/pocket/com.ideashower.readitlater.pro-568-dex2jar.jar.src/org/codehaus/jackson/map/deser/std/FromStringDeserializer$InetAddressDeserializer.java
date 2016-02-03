package org.codehaus.jackson.map.deser.std;

import java.net.InetAddress;
import org.codehaus.jackson.map.DeserializationContext;

public class FromStringDeserializer$InetAddressDeserializer
  extends FromStringDeserializer
{
  public FromStringDeserializer$InetAddressDeserializer()
  {
    super(InetAddress.class);
  }
  
  protected InetAddress _deserialize(String paramString, DeserializationContext paramDeserializationContext)
  {
    return InetAddress.getByName(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/FromStringDeserializer$InetAddressDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */