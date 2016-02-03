package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class ey
  implements ex<String>
{
  public void a(OutputStream paramOutputStream, String paramString)
  {
    if ((paramOutputStream == null) || (paramString == null)) {
      return;
    }
    paramString = paramString.getBytes("utf-8");
    paramOutputStream.write(paramString, 0, paramString.length);
  }
  
  public String b(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    fe.a(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/flurry/sdk/ey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */