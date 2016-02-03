package com.google.android.gms.internal;

import com.atomic.apps.ringtone.cutter.aa;

public final class bv
{
  public final R a = new bw(this);
  public final R b = new bx(this);
  private final Object c = new Object();
  private String d;
  private int e = -2;
  private String f;
  
  public bv(String paramString)
  {
    this.d = paramString;
  }
  
  public final int a()
  {
    synchronized (this.c)
    {
      int i = this.e;
      return i;
    }
  }
  
  public final void a(bW parambW)
  {
    parambW = this.c;
  }
  
  public final String b()
  {
    synchronized (this.c)
    {
      while (this.f == null)
      {
        int i = this.e;
        if (i == -2) {
          try
          {
            this.c.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            aa.e("Ad request service was interrupted.");
            return null;
          }
        }
      }
      String str = this.f;
      return str;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */