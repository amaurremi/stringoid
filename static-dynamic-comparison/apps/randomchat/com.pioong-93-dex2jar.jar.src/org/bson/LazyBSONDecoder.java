package org.bson;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;
import org.bson.io.Bits;

public class LazyBSONDecoder
  implements BSONDecoder
{
  private static int BYTES_IN_INTEGER = 4;
  static final Logger LOG = Logger.getLogger(LazyBSONDecoder.class.getName());
  
  public int decode(InputStream paramInputStream, BSONCallback paramBSONCallback)
    throws IOException
  {
    byte[] arrayOfByte1 = new byte[BYTES_IN_INTEGER];
    Bits.readFully(paramInputStream, arrayOfByte1, 0, BYTES_IN_INTEGER);
    int i = Bits.readInt(arrayOfByte1);
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, BYTES_IN_INTEGER);
    Bits.readFully(paramInputStream, arrayOfByte2, BYTES_IN_INTEGER, i - BYTES_IN_INTEGER);
    paramBSONCallback.gotBinary(null, (byte)0, arrayOfByte2);
    return i;
  }
  
  public int decode(byte[] paramArrayOfByte, BSONCallback paramBSONCallback)
  {
    try
    {
      int i = decode(new ByteArrayInputStream(paramArrayOfByte), paramBSONCallback);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new BSONException("should be impossible", paramArrayOfByte);
    }
  }
  
  public BSONObject readObject(InputStream paramInputStream)
    throws IOException
  {
    LazyBSONCallback localLazyBSONCallback = new LazyBSONCallback();
    decode(paramInputStream, localLazyBSONCallback);
    return (BSONObject)localLazyBSONCallback.get();
  }
  
  public BSONObject readObject(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = readObject(new ByteArrayInputStream(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new BSONException("should be impossible", paramArrayOfByte);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/LazyBSONDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */