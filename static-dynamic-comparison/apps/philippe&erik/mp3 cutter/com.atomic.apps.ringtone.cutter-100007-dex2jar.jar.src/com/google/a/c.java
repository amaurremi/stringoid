package com.google.a;

import com.google.android.gms.ads.d;

public final class c
{
  public static final c a = new c(-1, -2);
  public static final c b = new c(320, 50);
  public static final c c = new c(300, 250);
  public static final c d = new c(468, 60);
  public static final c e = new c(728, 90);
  public static final c f = new c(160, 600);
  private final d g;
  
  private c(int paramInt1, int paramInt2)
  {
    this(new d(paramInt1, paramInt2));
  }
  
  public c(d paramd)
  {
    this.g = paramd;
  }
  
  public final int a()
  {
    return this.g.b();
  }
  
  public final int b()
  {
    return this.g.a();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof c)) {
      return false;
    }
    paramObject = (c)paramObject;
    return this.g.equals(((c)paramObject).g);
  }
  
  public final int hashCode()
  {
    return this.g.hashCode();
  }
  
  public final String toString()
  {
    return this.g.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */