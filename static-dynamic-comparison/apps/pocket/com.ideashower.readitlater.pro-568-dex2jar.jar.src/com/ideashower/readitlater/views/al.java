package com.ideashower.readitlater.views;

import android.graphics.drawable.Drawable;

abstract class al
{
  protected Drawable d;
  protected String e;
  protected long f;
  
  private al(ad paramad) {}
  
  public abstract boolean a();
  
  public abstract Drawable b();
  
  public abstract boolean c();
  
  public abstract void d();
  
  public abstract String e();
  
  public abstract boolean f();
  
  public Drawable i()
  {
    if (this.d == null) {
      this.d = b();
    }
    return this.d;
  }
  
  public String j()
  {
    return this.e;
  }
  
  public long k()
  {
    return this.f;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */