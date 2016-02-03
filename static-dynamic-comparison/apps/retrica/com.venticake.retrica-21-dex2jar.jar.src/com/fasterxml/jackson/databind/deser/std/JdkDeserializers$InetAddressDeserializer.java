package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.net.InetAddress;

public class JdkDeserializers$InetAddressDeserializer
  extends FromStringDeserializer<InetAddress>
{
  public JdkDeserializers$InetAddressDeserializer()
  {
    super(InetAddress.class);
  }
  
  protected InetAddress _deserialize(String paramString, DeserializationContext paramDeserializationContext)
  {
    return InetAddress.getByName(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/JdkDeserializers$InetAddressDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */