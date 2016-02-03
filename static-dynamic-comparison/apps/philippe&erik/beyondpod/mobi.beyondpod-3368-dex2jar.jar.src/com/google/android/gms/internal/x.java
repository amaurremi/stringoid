package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class x
  implements SafeParcelable
{
  public static final y CREATOR = new y();
  public final String eF;
  public final boolean eG;
  public final x[] eH;
  public final int height;
  public final int heightPixels;
  public final int versionCode;
  public final int width;
  public final int widthPixels;
  
  public x()
  {
    this(2, "interstitial_mb", 0, 0, true, 0, 0, null);
  }
  
  x(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, x[] paramArrayOfx)
  {
    this.versionCode = paramInt1;
    this.eF = paramString;
    this.height = paramInt2;
    this.heightPixels = paramInt3;
    this.eG = paramBoolean;
    this.width = paramInt4;
    this.widthPixels = paramInt5;
    this.eH = paramArrayOfx;
  }
  
  public x(Context paramContext, AdSize paramAdSize)
  {
    this(paramContext, new AdSize[] { paramAdSize });
  }
  
  public x(Context paramContext, AdSize[] paramArrayOfAdSize)
  {
    AdSize localAdSize = paramArrayOfAdSize[0];
    this.versionCode = 2;
    this.eG = false;
    this.width = localAdSize.getWidth();
    this.height = localAdSize.getHeight();
    int i;
    int j;
    label62:
    DisplayMetrics localDisplayMetrics;
    int k;
    label98:
    int m;
    if (this.width == -1)
    {
      i = 1;
      if (this.height != -2) {
        break label217;
      }
      j = 1;
      localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if (i == 0) {
        break label223;
      }
      this.widthPixels = a(localDisplayMetrics);
      k = (int)(this.widthPixels / localDisplayMetrics.density);
      if (j == 0) {
        break label245;
      }
      m = c(localDisplayMetrics);
      label110:
      this.heightPixels = cs.a(localDisplayMetrics, m);
      if ((i == 0) && (j == 0)) {
        break label254;
      }
    }
    label217:
    label223:
    label245:
    label254:
    for (this.eF = (k + "x" + m + "_as");; this.eF = localAdSize.toString())
    {
      if (paramArrayOfAdSize.length <= 1) {
        break label266;
      }
      this.eH = new x[paramArrayOfAdSize.length];
      i = n;
      while (i < paramArrayOfAdSize.length)
      {
        this.eH[i] = new x(paramContext, paramArrayOfAdSize[i]);
        i += 1;
      }
      i = 0;
      break;
      j = 0;
      break label62;
      k = this.width;
      this.widthPixels = cs.a(localDisplayMetrics, this.width);
      break label98;
      m = this.height;
      break label110;
    }
    label266:
    this.eH = null;
  }
  
  public x(x paramx, x[] paramArrayOfx)
  {
    this(2, paramx.eF, paramx.height, paramx.heightPixels, paramx.eG, paramx.width, paramx.widthPixels, paramArrayOfx);
  }
  
  public static int a(DisplayMetrics paramDisplayMetrics)
  {
    return paramDisplayMetrics.widthPixels;
  }
  
  public static int b(DisplayMetrics paramDisplayMetrics)
  {
    return (int)(c(paramDisplayMetrics) * paramDisplayMetrics.density);
  }
  
  private static int c(DisplayMetrics paramDisplayMetrics)
  {
    int i = (int)(paramDisplayMetrics.heightPixels / paramDisplayMetrics.density);
    if (i <= 400) {
      return 32;
    }
    if (i <= 720) {
      return 50;
    }
    return 90;
  }
  
  public AdSize P()
  {
    return a.a(this.width, this.height, this.eF);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    y.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */