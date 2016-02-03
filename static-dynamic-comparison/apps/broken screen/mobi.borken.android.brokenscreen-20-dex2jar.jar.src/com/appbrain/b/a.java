package com.appbrain.b;

import java.io.IOException;

public abstract class a
  implements m
{
  public final c a()
  {
    try
    {
      Object localObject = c.a(c());
      a(((c.b)localObject).b());
      localObject = ((c.b)localObject).a();
      return (c)localObject;
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
      e locale = e.a(arrayOfByte);
      a(locale);
      locale.b();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", localIOException);
    }
  }
  
  public static abstract class a
    implements m.a
  {
    public abstract a a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */