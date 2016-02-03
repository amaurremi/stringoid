package org.codehaus.jackson.map.ser.std;

import java.net.InetAddress;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;

public class InetAddressSerializer
  extends ScalarSerializerBase
{
  public static final InetAddressSerializer instance = new InetAddressSerializer();
  
  public InetAddressSerializer()
  {
    super(InetAddress.class);
  }
  
  public void serialize(InetAddress paramInetAddress, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    paramSerializerProvider = paramInetAddress.toString().trim();
    int i = paramSerializerProvider.indexOf('/');
    paramInetAddress = paramSerializerProvider;
    if (i >= 0) {
      if (i != 0) {
        break label40;
      }
    }
    label40:
    for (paramInetAddress = paramSerializerProvider.substring(1);; paramInetAddress = paramSerializerProvider.substring(0, i))
    {
      paramJsonGenerator.writeString(paramInetAddress);
      return;
    }
  }
  
  public void serializeWithType(InetAddress paramInetAddress, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
  {
    paramTypeSerializer.writeTypePrefixForScalar(paramInetAddress, paramJsonGenerator, InetAddress.class);
    serialize(paramInetAddress, paramJsonGenerator, paramSerializerProvider);
    paramTypeSerializer.writeTypeSuffixForScalar(paramInetAddress, paramJsonGenerator);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/std/InetAddressSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */