package com.google.android.gms.ads;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.x;

public final class AdSize
{
  public static final int AUTO_HEIGHT = -2;
  public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
  public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
  public static final int FULL_WIDTH = -1;
  public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
  public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
  public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
  public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
  private final String dY;
  private final int v;
  private final int w;
  
  public AdSize(int paramInt1, int paramInt2) {}
  
  AdSize(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 < 0) && (paramInt1 != -1)) {
      throw new IllegalArgumentException("Invalid width for AdSize: " + paramInt1);
    }
    if ((paramInt2 < 0) && (paramInt2 != -2)) {
      throw new IllegalArgumentException("Invalid height for AdSize: " + paramInt2);
    }
    this.w = paramInt1;
    this.v = paramInt2;
    this.dY = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof AdSize)) {
        return false;
      }
      paramObject = (AdSize)paramObject;
    } while ((this.w == ((AdSize)paramObject).w) && (this.v == ((AdSize)paramObject).v) && (this.dY.equals(((AdSize)paramObject).dY)));
    return false;
  }
  
  public int getHeight()
  {
    return this.v;
  }
  
  public int getHeightInPixels(Context paramContext)
  {
    if (this.v == -2) {
      return x.b(paramContext.getResources().getDisplayMetrics());
    }
    return cs.a(paramContext, this.v);
  }
  
  public int getWidth()
  {
    return this.w;
  }
  
  public int getWidthInPixels(Context paramContext)
  {
    if (this.w == -1) {
      return x.a(paramContext.getResources().getDisplayMetrics());
    }
    return cs.a(paramContext, this.w);
  }
  
  public int hashCode()
  {
    return this.dY.hashCode();
  }
  
  public boolean isAutoHeight()
  {
    return this.v == -2;
  }
  
  public boolean isFullWidth()
  {
    return this.w == -1;
  }
  
  public String toString()
  {
    return this.dY;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/ads/AdSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */