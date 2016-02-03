package com.google.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class AdSize
{
  public static final int AUTO_HEIGHT = -2;
  public static final AdSize BANNER;
  public static final int FULL_WIDTH = -1;
  public static final AdSize IAB_BANNER = new AdSize(468, 60, "as");
  public static final AdSize IAB_LEADERBOARD = new AdSize(728, 90, "as");
  public static final AdSize IAB_MRECT;
  public static final AdSize IAB_WIDE_SKYSCRAPER = new AdSize(160, 600, "as");
  public static final int LANDSCAPE_AD_HEIGHT = 32;
  public static final int LARGE_AD_HEIGHT = 90;
  public static final int PORTRAIT_AD_HEIGHT = 50;
  public static final AdSize SMART_BANNER = new AdSize(-1, -2, "mb");
  private final int a;
  private final int b;
  private boolean c;
  private boolean d;
  private boolean e;
  private String f;
  
  static
  {
    BANNER = new AdSize(320, 50, "mb");
    IAB_MRECT = new AdSize(300, 250, "as");
  }
  
  public AdSize(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, null);
    if (a())
    {
      this.e = false;
      this.f = "mb";
      return;
    }
    this.e = true;
  }
  
  private AdSize(int paramInt1, int paramInt2, String paramString)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.f = paramString;
    if (paramInt1 == -1)
    {
      bool1 = true;
      this.c = bool1;
      if (paramInt2 != -2) {
        break label64;
      }
    }
    label64:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.d = bool1;
      this.e = false;
      return;
      bool1 = false;
      break;
    }
  }
  
  private static int a(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    return (int)(paramContext.widthPixels / paramContext.density);
  }
  
  private boolean a()
  {
    return (this.a < 0) || (this.b < 0);
  }
  
  private static int b(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    int i = (int)(paramContext.heightPixels / paramContext.density);
    if (i <= 400) {
      return 32;
    }
    if (i <= 720) {
      return 50;
    }
    return 90;
  }
  
  public static AdSize createAdSize(AdSize paramAdSize, Context paramContext)
  {
    if ((paramContext == null) || (!paramAdSize.a()))
    {
      paramContext = paramAdSize;
      if (paramAdSize.a()) {
        paramContext = BANNER;
      }
      return paramContext;
    }
    int i;
    if (paramAdSize.c)
    {
      i = a(paramContext);
      if (!paramAdSize.d) {
        break label98;
      }
    }
    label98:
    for (int j = b(paramContext);; j = paramAdSize.getHeight())
    {
      paramContext = new AdSize(i, j, paramAdSize.f);
      paramContext.d = paramAdSize.d;
      paramContext.c = paramAdSize.c;
      paramContext.e = paramAdSize.e;
      return paramContext;
      i = paramAdSize.getWidth();
      break;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AdSize)) {}
    do
    {
      return false;
      paramObject = (AdSize)paramObject;
    } while ((this.a != ((AdSize)paramObject).a) || (this.b != ((AdSize)paramObject).b));
    return true;
  }
  
  public AdSize findBestSize(AdSize... paramVarArgs)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    double d1 = 0.0D;
    int i;
    double d2;
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      i = 0;
      localObject2 = localObject1;
      if (i < j)
      {
        localObject2 = paramVarArgs[i];
        if (!isSizeAppropriate(((AdSize)localObject2).a, ((AdSize)localObject2).b)) {
          break label123;
        }
        double d3 = ((AdSize)localObject2).a * ((AdSize)localObject2).b / (this.a * this.b);
        d2 = d3;
        if (d3 > 1.0D) {
          d2 = 1.0D / d3;
        }
        if (d2 <= d1) {
          break label123;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      i += 1;
      d1 = d2;
      break;
      return (AdSize)localObject2;
      label123:
      d2 = d1;
    }
  }
  
  public int getHeight()
  {
    if (this.b < 0) {
      throw new UnsupportedOperationException("Ad size was not set before getHeight() was called.");
    }
    return this.b;
  }
  
  public int getHeightInPixels(Context paramContext)
  {
    return (int)TypedValue.applyDimension(1, this.b, paramContext.getResources().getDisplayMetrics());
  }
  
  public int getWidth()
  {
    if (this.a < 0) {
      throw new UnsupportedOperationException("Ad size was not set before getWidth() was called.");
    }
    return this.a;
  }
  
  public int getWidthInPixels(Context paramContext)
  {
    return (int)TypedValue.applyDimension(1, this.a, paramContext.getResources().getDisplayMetrics());
  }
  
  public int hashCode()
  {
    return Integer.valueOf(this.a).hashCode() << 16 | Integer.valueOf(this.b).hashCode() & 0xFFFF;
  }
  
  public boolean isAutoHeight()
  {
    return this.d;
  }
  
  public boolean isCustomAdSize()
  {
    return this.e;
  }
  
  public boolean isFullWidth()
  {
    return this.c;
  }
  
  public boolean isSizeAppropriate(int paramInt1, int paramInt2)
  {
    return (paramInt1 <= this.a * 1.25D) && (paramInt1 >= this.a * 0.8D) && (paramInt2 <= this.b * 1.25D) && (paramInt2 >= this.b * 0.8D);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(getWidth()).append("x").append(getHeight());
    if (this.f == null) {}
    for (String str = "";; str = "_" + this.f) {
      return str;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/AdSize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */