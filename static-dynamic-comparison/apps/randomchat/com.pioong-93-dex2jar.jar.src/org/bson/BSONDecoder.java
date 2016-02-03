package org.bson;

import java.io.IOException;
import java.io.InputStream;

public abstract interface BSONDecoder
{
  public abstract int decode(InputStream paramInputStream, BSONCallback paramBSONCallback)
    throws IOException;
  
  public abstract int decode(byte[] paramArrayOfByte, BSONCallback paramBSONCallback);
  
  public abstract BSONObject readObject(InputStream paramInputStream)
    throws IOException;
  
  public abstract BSONObject readObject(byte[] paramArrayOfByte);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/org/bson/BSONDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */