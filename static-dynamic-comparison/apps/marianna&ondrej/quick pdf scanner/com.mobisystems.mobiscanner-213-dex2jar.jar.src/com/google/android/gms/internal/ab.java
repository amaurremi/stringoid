package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.d;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ab
  implements SafeParcelable
{
  public static final c wY = new c();
  public final int height;
  public final int heightPixels;
  public final int versionCode;
  public final String wZ;
  public final int width;
  public final int widthPixels;
  public final boolean xa;
  public final ab[] xb;
  
  public ab()
  {
    this(2, "interstitial_mb", 0, 0, true, 0, 0, null);
  }
  
  ab(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, ab[] paramArrayOfab)
  {
    this.versionCode = paramInt1;
    this.wZ = paramString;
    this.height = paramInt2;
    this.heightPixels = paramInt3;
    this.xa = paramBoolean;
    this.width = paramInt4;
    this.widthPixels = paramInt5;
    this.xb = paramArrayOfab;
  }
  
  public ab(Context paramContext, com.google.android.gms.ads.c paramc)
  {
    this(paramContext, new com.google.android.gms.ads.c[] { paramc });
  }
  
  public ab(Context paramContext, com.google.android.gms.ads.c[] paramArrayOfc)
  {
    com.google.android.gms.ads.c localc = paramArrayOfc[0];
    this.versionCode = 2;
    this.xa = false;
    this.width = localc.getWidth();
    this.height = localc.getHeight();
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
      this.heightPixels = cb.a(localDisplayMetrics, m);
      if ((i == 0) && (j == 0)) {
        break label254;
      }
    }
    label217:
    label223:
    label245:
    label254:
    for (this.wZ = (k + "x" + m + "_as");; this.wZ = localc.toString())
    {
      if (paramArrayOfc.length <= 1) {
        break label266;
      }
      this.xb = new ab[paramArrayOfc.length];
      i = n;
      while (i < paramArrayOfc.length)
      {
        this.xb[i] = new ab(paramContext, paramArrayOfc[i]);
        i += 1;
      }
      i = 0;
      break;
      j = 0;
      break label62;
      k = this.width;
      this.widthPixels = cb.a(localDisplayMetrics, this.width);
      break label98;
      m = this.height;
      break label110;
    }
    label266:
    this.xb = null;
  }
  
  public ab(ab paramab, ab[] paramArrayOfab)
  {
    this(2, paramab.wZ, paramab.height, paramab.heightPixels, paramab.xa, paramab.width, paramab.widthPixels, paramArrayOfab);
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
  
  public int describeContents()
  {
    return 0;
  }
  
  public com.google.android.gms.ads.c oK()
  {
    return d.b(this.width, this.height, this.wZ);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */