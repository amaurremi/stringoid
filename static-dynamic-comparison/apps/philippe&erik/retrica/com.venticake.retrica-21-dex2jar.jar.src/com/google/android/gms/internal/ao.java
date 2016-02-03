package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.R.styleable;
import com.google.android.gms.ads.AdSize;

public final class ao
{
  private final AdSize[] mi;
  private final String mj;
  
  public ao(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.AdsAttrs);
    paramAttributeSet = paramContext.getString(0);
    String str = paramContext.getString(1);
    int i;
    if (!TextUtils.isEmpty(paramAttributeSet))
    {
      i = 1;
      if (TextUtils.isEmpty(str)) {
        break label100;
      }
      label49:
      if ((i == 0) || (j != 0)) {
        break label106;
      }
    }
    for (this.mi = f(paramAttributeSet);; this.mi = f(str))
    {
      this.mj = paramContext.getString(2);
      if (!TextUtils.isEmpty(this.mj)) {
        return;
      }
      throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
      i = 0;
      break;
      label100:
      j = 0;
      break label49;
      label106:
      if ((i != 0) || (j == 0)) {
        break label127;
      }
    }
    label127:
    if ((i != 0) && (j != 0)) {
      throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
    }
    throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
  }
  
  private static AdSize[] f(String paramString)
  {
    String[] arrayOfString1 = paramString.split("\\s*,\\s*");
    AdSize[] arrayOfAdSize = new AdSize[arrayOfString1.length];
    int i = 0;
    if (i < arrayOfString1.length)
    {
      String str = arrayOfString1[i].trim();
      String[] arrayOfString2;
      if (str.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$"))
      {
        arrayOfString2 = str.split("[xX]");
        arrayOfString2[0] = arrayOfString2[0].trim();
        arrayOfString2[1] = arrayOfString2[1].trim();
      }
      for (;;)
      {
        try
        {
          if ("FULL_WIDTH".equals(arrayOfString2[0]))
          {
            j = -1;
            boolean bool = "AUTO_HEIGHT".equals(arrayOfString2[1]);
            if (!bool) {
              continue;
            }
            k = -2;
            arrayOfAdSize[i] = new AdSize(j, k);
            i += 1;
            break;
          }
          int j = Integer.parseInt(arrayOfString2[0]);
          continue;
          int k = Integer.parseInt(arrayOfString2[1]);
          continue;
          if (!"BANNER".equals(str)) {
            break label199;
          }
        }
        catch (NumberFormatException paramString)
        {
          throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + str);
        }
        arrayOfAdSize[i] = AdSize.BANNER;
        continue;
        label199:
        if ("LARGE_BANNER".equals(str))
        {
          arrayOfAdSize[i] = AdSize.LARGE_BANNER;
        }
        else if ("FULL_BANNER".equals(str))
        {
          arrayOfAdSize[i] = AdSize.FULL_BANNER;
        }
        else if ("LEADERBOARD".equals(str))
        {
          arrayOfAdSize[i] = AdSize.LEADERBOARD;
        }
        else if ("MEDIUM_RECTANGLE".equals(str))
        {
          arrayOfAdSize[i] = AdSize.MEDIUM_RECTANGLE;
        }
        else if ("SMART_BANNER".equals(str))
        {
          arrayOfAdSize[i] = AdSize.SMART_BANNER;
        }
        else
        {
          if (!"WIDE_SKYSCRAPER".equals(str)) {
            break label319;
          }
          arrayOfAdSize[i] = AdSize.WIDE_SKYSCRAPER;
        }
      }
      label319:
      throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + str);
    }
    if (arrayOfAdSize.length == 0) {
      throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + paramString);
    }
    return arrayOfAdSize;
  }
  
  public AdSize[] f(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.mi.length != 1)) {
      throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
    }
    return this.mi;
  }
  
  public String getAdUnitId()
  {
    return this.mj;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */