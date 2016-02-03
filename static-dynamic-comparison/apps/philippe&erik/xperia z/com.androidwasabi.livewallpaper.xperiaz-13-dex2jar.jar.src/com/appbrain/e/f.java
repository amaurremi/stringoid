package com.appbrain.e;

import com.appbrain.b.ab;
import com.appbrain.b.l;

public final class f
  extends l
  implements g
{
  private int a;
  private Object b = "";
  private int c;
  private long d;
  
  private f g()
  {
    return new f().a(h());
  }
  
  private e h()
  {
    int j = 1;
    e locale = new e('\000');
    int k = this.a;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      e.a(locale, this.b);
      int i = j;
      if ((k & 0x2) == 2) {
        i = j | 0x2;
      }
      e.a(locale, this.c);
      j = i;
      if ((k & 0x4) == 4) {
        j = i | 0x4;
      }
      e.a(locale, this.d);
      e.b(locale, j);
      return locale;
      j = 0;
    }
  }
  
  public final f a(int paramInt)
  {
    this.a |= 0x2;
    this.c = paramInt;
    return this;
  }
  
  public final f a(long paramLong)
  {
    this.a |= 0x4;
    this.d = paramLong;
    return this;
  }
  
  public final f a(e parame)
  {
    if (parame == e.f()) {}
    do
    {
      return this;
      if (parame.g())
      {
        this.a |= 0x1;
        this.b = e.a(parame);
      }
      if (parame.h()) {
        a(parame.i());
      }
    } while (!parame.j());
    a(parame.k());
    return this;
  }
  
  public final f a(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.a |= 0x1;
    this.b = paramString;
    return this;
  }
  
  public final e d()
  {
    e locale = h();
    if (!locale.e()) {
      throw new ab();
    }
    return locale;
  }
  
  public final boolean e()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/e/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */