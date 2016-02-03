package com.google.android.gms.internal;

import com.google.android.gms.common.data.d;

public abstract class w
  extends u
{
  private final d c;
  
  public w(s params, Object paramObject, d paramd)
  {
    super(params, paramObject);
    this.c = paramd;
  }
  
  protected void a()
  {
    if (this.c != null) {
      this.c.i();
    }
  }
  
  protected final void a(Object paramObject)
  {
    a(paramObject, this.c);
  }
  
  protected abstract void a(Object paramObject, d paramd);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */