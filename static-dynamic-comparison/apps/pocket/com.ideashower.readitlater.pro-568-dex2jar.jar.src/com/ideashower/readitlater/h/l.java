package com.ideashower.readitlater.h;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public abstract class l
{
  protected final SharedPreferences a;
  protected final SharedPreferences b;
  protected SharedPreferences.Editor c;
  protected SharedPreferences.Editor d;
  
  public l(SharedPreferences paramSharedPreferences1, SharedPreferences paramSharedPreferences2)
  {
    this.a = paramSharedPreferences1;
    this.b = paramSharedPreferences2;
  }
  
  protected SharedPreferences.Editor a(g paramg)
  {
    if (paramg == g.b)
    {
      if (this.d == null) {
        this.d = this.b.edit();
      }
      return this.d;
    }
    if (this.c == null) {
      this.c = this.a.edit();
    }
    return this.c;
  }
  
  public l a(b paramb, boolean paramBoolean)
  {
    a(paramb.c).putBoolean(paramb.b(), paramBoolean);
    return this;
  }
  
  public l a(c paramc, float paramFloat)
  {
    a(paramc.c).putFloat(paramc.b(), paramFloat);
    return this;
  }
  
  public l a(d paramd, int paramInt)
  {
    a(paramd.c).putInt(paramd.b(), paramInt);
    return this;
  }
  
  public l a(e parame, long paramLong)
  {
    a(parame.c).putLong(parame.b(), paramLong);
    return this;
  }
  
  public l a(f paramf)
  {
    a(paramf.c).remove(paramf.b());
    return this;
  }
  
  public l a(h paramh, String paramString)
  {
    a(paramh.c).putString(paramh.b(), paramString);
    return this;
  }
  
  public l a(String paramString, g paramg)
  {
    a(paramg).remove(paramString);
    return this;
  }
  
  public abstract boolean a();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/h/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */