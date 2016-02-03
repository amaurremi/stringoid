package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.ij;

class ar
  implements bv
{
  private final long a;
  private final long b;
  private final int c;
  private double d;
  private long e;
  private final Object f = new Object();
  private final String g;
  private final ij h;
  
  public ar(int paramInt, long paramLong1, long paramLong2, String paramString, ij paramij)
  {
    this.c = paramInt;
    this.d = this.c;
    this.a = paramLong1;
    this.b = paramLong2;
    this.g = paramString;
    this.h = paramij;
  }
  
  public boolean a()
  {
    synchronized (this.f)
    {
      long l = this.h.currentTimeMillis();
      if (l - this.e < this.b)
      {
        as.b("Excessive " + this.g + " detected; call ignored.");
        return false;
      }
      if (this.d < this.c)
      {
        double d1 = (l - this.e) / this.a;
        if (d1 > 0.0D) {
          this.d = Math.min(this.c, d1 + this.d);
        }
      }
      this.e = l;
      if (this.d >= 1.0D)
      {
        this.d -= 1.0D;
        return true;
      }
    }
    as.b("Excessive " + this.g + " detected; call ignored.");
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/tagmanager/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */