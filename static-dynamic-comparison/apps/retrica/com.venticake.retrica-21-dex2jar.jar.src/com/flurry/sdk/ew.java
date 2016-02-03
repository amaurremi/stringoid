package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ew
  implements ex<byte[]>
{
  public void a(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    if ((paramOutputStream == null) || (paramArrayOfByte == null)) {
      return;
    }
    paramOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public byte[] b(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    fe.a(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/flurry/sdk/ew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */