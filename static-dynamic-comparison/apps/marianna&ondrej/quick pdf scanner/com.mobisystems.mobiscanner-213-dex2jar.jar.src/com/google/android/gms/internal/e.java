package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.a.d;
import com.google.android.gms.ads.c;

public final class e
{
  private final c[] xd;
  private final String xe;
  
  public e(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.getResources().obtainAttributes(paramAttributeSet, a.d.AdsAttrs);
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
    for (this.xd = ay(paramAttributeSet);; this.xd = ay(str))
    {
      this.xe = paramContext.getString(2);
      if (!TextUtils.isEmpty(this.xe)) {
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
  
  private static c[] ay(String paramString)
  {
    String[] arrayOfString1 = paramString.split("\\s*,\\s*");
    c[] arrayOfc = new c[arrayOfString1.length];
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
            arrayOfc[i] = new c(j, k);
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
        arrayOfc[i] = c.lF;
        continue;
        label199:
        if ("FULL_BANNER".equals(str))
        {
          arrayOfc[i] = c.lG;
        }
        else if ("LEADERBOARD".equals(str))
        {
          arrayOfc[i] = c.lH;
        }
        else if ("MEDIUM_RECTANGLE".equals(str))
        {
          arrayOfc[i] = c.lI;
        }
        else if ("SMART_BANNER".equals(str))
        {
          arrayOfc[i] = c.lK;
        }
        else
        {
          if (!"WIDE_SKYSCRAPER".equals(str)) {
            break label299;
          }
          arrayOfc[i] = c.lJ;
        }
      }
      label299:
      throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + str);
    }
    if (arrayOfc.length == 0) {
      throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + paramString);
    }
    return arrayOfc;
  }
  
  public String oL()
  {
    return this.xe;
  }
  
  public c[] v(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.xd.length != 1)) {
      throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
    }
    return this.xd;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */