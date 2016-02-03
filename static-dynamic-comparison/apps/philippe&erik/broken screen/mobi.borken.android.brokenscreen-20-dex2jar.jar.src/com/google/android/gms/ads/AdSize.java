package com.google.android.gms.ads;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.am;
import com.google.android.gms.internal.eu;

public final class AdSize
{
  public static final int AUTO_HEIGHT = -2;
  public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
  public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
  public static final int FULL_WIDTH = -1;
  public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
  public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
  public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
  public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
  public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
  private final int ks;
  private final int kt;
  private final String ku;
  
  public AdSize(int paramInt1, int paramInt2) {}
  
  AdSize(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 < 0) && (paramInt1 != -1)) {
      throw new IllegalArgumentException("Invalid width for AdSize: " + paramInt1);
    }
    if ((paramInt2 < 0) && (paramInt2 != -2)) {
      throw new IllegalArgumentException("Invalid height for AdSize: " + paramInt2);
    }
    this.ks = paramInt1;
    this.kt = paramInt2;
    this.ku = paramString;
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
    } while ((this.ks == ((AdSize)paramObject).ks) && (this.kt == ((AdSize)paramObject).kt) && (this.ku.equals(((AdSize)paramObject).ku)));
    return false;
  }
  
  public int getHeight()
  {
    return this.kt;
  }
  
  public int getHeightInPixels(Context paramContext)
  {
    if (this.kt == -2) {
      return am.b(paramContext.getResources().getDisplayMetrics());
    }
    return eu.a(paramContext, this.kt);
  }
  
  public int getWidth()
  {
    return this.ks;
  }
  
  public int getWidthInPixels(Context paramContext)
  {
    if (this.ks == -1) {
      return am.a(paramContext.getResources().getDisplayMetrics());
    }
    return eu.a(paramContext, this.ks);
  }
  
  public int hashCode()
  {
    return this.ku.hashCode();
  }
  
  public boolean isAutoHeight()
  {
    return this.kt == -2;
  }
  
  public boolean isFullWidth()
  {
    return this.ks == -1;
  }
  
  public String toString()
  {
    return this.ku;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/ads/AdSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */