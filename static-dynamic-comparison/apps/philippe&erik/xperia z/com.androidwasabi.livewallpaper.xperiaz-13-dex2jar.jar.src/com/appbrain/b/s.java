package com.appbrain.b;

import java.util.NoSuchElementException;

final class s
  implements e
{
  private int b = 0;
  private final int c;
  
  private s(r paramr)
  {
    this.c = paramr.b();
  }
  
  public final byte a()
  {
    try
    {
      byte[] arrayOfByte = this.a.c;
      int i = this.b;
      this.b = (i + 1);
      byte b1 = arrayOfByte[i];
      return b1;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage());
    }
  }
  
  public final boolean hasNext()
  {
    return this.b < this.c;
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */