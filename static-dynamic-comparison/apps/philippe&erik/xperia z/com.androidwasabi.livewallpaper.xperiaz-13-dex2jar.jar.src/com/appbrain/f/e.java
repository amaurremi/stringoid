package com.appbrain.f;

import com.appbrain.b.d;
import com.appbrain.g.b;

public final class e
{
  public final byte[] a;
  public final String b;
  
  private e(byte[] paramArrayOfByte, String paramString)
  {
    this.a = paramArrayOfByte;
    this.b = paramString;
  }
  
  public static e a(b paramb)
  {
    String str = null;
    byte[] arrayOfByte;
    if (paramb.u())
    {
      arrayOfByte = null;
      if (paramb.q()) {
        if (paramb.s().length() <= 0) {
          break label54;
        }
      }
    }
    label54:
    for (str = paramb.s();; str = "There was an error contacting the server.")
    {
      return new e(arrayOfByte, str);
      arrayOfByte = paramb.i().d();
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */