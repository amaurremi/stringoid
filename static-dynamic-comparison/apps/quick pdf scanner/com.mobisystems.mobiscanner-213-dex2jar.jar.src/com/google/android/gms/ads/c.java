package com.google.android.gms.ads;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.ab;
import com.google.android.gms.internal.cb;

public final class c
{
  public static final c lF = new c(320, 50, "320x50_mb");
  public static final c lG = new c(468, 60, "468x60_as");
  public static final c lH = new c(728, 90, "728x90_as");
  public static final c lI = new c(300, 250, "300x250_as");
  public static final c lJ = new c(160, 600, "160x600_as");
  public static final c lK = new c(-1, -2, "smart_banner");
  private final int lL;
  private final String lM;
  private final int w;
  
  public c(int paramInt1, int paramInt2) {}
  
  c(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 < 0) && (paramInt1 != -1)) {
      throw new IllegalArgumentException("Invalid width for AdSize: " + paramInt1);
    }
    if ((paramInt2 < 0) && (paramInt2 != -2)) {
      throw new IllegalArgumentException("Invalid height for AdSize: " + paramInt2);
    }
    this.w = paramInt1;
    this.lL = paramInt2;
    this.lM = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof c)) {
        return false;
      }
      paramObject = (c)paramObject;
    } while ((this.w == ((c)paramObject).w) && (this.lL == ((c)paramObject).lL) && (this.lM.equals(((c)paramObject).lM)));
    return false;
  }
  
  public int getHeight()
  {
    return this.lL;
  }
  
  public int getWidth()
  {
    return this.w;
  }
  
  public int hashCode()
  {
    return this.lM.hashCode();
  }
  
  public int k(Context paramContext)
  {
    if (this.lL == -2) {
      return ab.b(paramContext.getResources().getDisplayMetrics());
    }
    return cb.b(paramContext, this.lL);
  }
  
  public int l(Context paramContext)
  {
    if (this.w == -1) {
      return ab.a(paramContext.getResources().getDisplayMetrics());
    }
    return cb.b(paramContext, this.w);
  }
  
  public String toString()
  {
    return this.lM;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/ads/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */