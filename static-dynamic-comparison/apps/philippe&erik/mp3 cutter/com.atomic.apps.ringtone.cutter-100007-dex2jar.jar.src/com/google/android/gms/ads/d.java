package com.google.android.gms.ads;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.ak;
import com.google.android.gms.internal.bU;

public final class d
{
  public static final d a = new d(320, 50, "320x50_mb");
  public static final d b = new d(468, 60, "468x60_as");
  public static final d c = new d(320, 100, "320x100_as");
  public static final d d = new d(728, 90, "728x90_as");
  public static final d e = new d(300, 250, "300x250_as");
  public static final d f = new d(160, 600, "160x600_as");
  public static final d g = new d(-1, -2, "smart_banner");
  private final int h;
  private final int i;
  private final String j;
  
  public d(int paramInt1, int paramInt2) {}
  
  d(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 < 0) && (paramInt1 != -1)) {
      throw new IllegalArgumentException("Invalid width for AdSize: " + paramInt1);
    }
    if ((paramInt2 < 0) && (paramInt2 != -2)) {
      throw new IllegalArgumentException("Invalid height for AdSize: " + paramInt2);
    }
    this.h = paramInt1;
    this.i = paramInt2;
    this.j = paramString;
  }
  
  public final int a()
  {
    return this.i;
  }
  
  public final int a(Context paramContext)
  {
    if (this.i == -2) {
      return ak.b(paramContext.getResources().getDisplayMetrics());
    }
    return bU.a(paramContext, this.i);
  }
  
  public final int b()
  {
    return this.h;
  }
  
  public final int b(Context paramContext)
  {
    if (this.h == -1) {
      return ak.a(paramContext.getResources().getDisplayMetrics());
    }
    return bU.a(paramContext, this.h);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof d)) {
        return false;
      }
      paramObject = (d)paramObject;
    } while ((this.h == ((d)paramObject).h) && (this.i == ((d)paramObject).i) && (this.j.equals(((d)paramObject).j)));
    return false;
  }
  
  public final int hashCode()
  {
    return this.j.hashCode();
  }
  
  public final String toString()
  {
    return this.j;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/ads/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */