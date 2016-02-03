package com.appbrain.b;

import java.io.IOException;

public abstract class a
  implements t
{
  public final d a()
  {
    try
    {
      Object localObject = d.a(c());
      a(((f)localObject).b());
      localObject = ((f)localObject).a();
      return (d)localObject;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", localIOException);
    }
  }
  
  public final byte[] b()
  {
    try
    {
      byte[] arrayOfByte = new byte[c()];
      h localh = h.a(arrayOfByte);
      a(localh);
      localh.b();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", localIOException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */