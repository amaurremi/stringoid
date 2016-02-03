package com.fasterxml.jackson.databind.ser.std;

import java.net.InetAddress;

public class InetAddressSerializer
  extends StdScalarSerializer<InetAddress>
{
  public static final InetAddressSerializer instance = new InetAddressSerializer();
  
  public InetAddressSerializer()
  {
    super(InetAddress.class);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/std/InetAddressSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */