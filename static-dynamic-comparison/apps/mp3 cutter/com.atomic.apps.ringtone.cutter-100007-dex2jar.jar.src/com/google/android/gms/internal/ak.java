package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.d;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ak
  implements SafeParcelable
{
  public static final n CREATOR = new n();
  public final int a;
  public final String b;
  public final int c;
  public final int d;
  public final boolean e;
  public final int f;
  public final int g;
  public final ak[] h;
  
  public ak()
  {
    this(2, "interstitial_mb", 0, 0, true, 0, 0, null);
  }
  
  ak(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, ak[] paramArrayOfak)
  {
    this.a = paramInt1;
    this.b = paramString;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramBoolean;
    this.f = paramInt4;
    this.g = paramInt5;
    this.h = paramArrayOfak;
  }
  
  public ak(Context paramContext, d paramd)
  {
    this(paramContext, new d[] { paramd });
  }
  
  public ak(Context paramContext, d[] paramArrayOfd)
  {
    d locald = paramArrayOfd[0];
    this.a = 2;
    this.e = false;
    this.f = locald.b();
    this.c = locald.a();
    int i;
    int j;
    label62:
    DisplayMetrics localDisplayMetrics;
    int k;
    label98:
    int m;
    if (this.f == -1)
    {
      i = 1;
      if (this.c != -2) {
        break label217;
      }
      j = 1;
      localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if (i == 0) {
        break label223;
      }
      this.g = localDisplayMetrics.widthPixels;
      k = (int)(this.g / localDisplayMetrics.density);
      if (j == 0) {
        break label245;
      }
      m = c(localDisplayMetrics);
      label110:
      this.d = bU.a(localDisplayMetrics, m);
      if ((i == 0) && (j == 0)) {
        break label254;
      }
    }
    label217:
    label223:
    label245:
    label254:
    for (this.b = (k + "x" + m + "_as");; this.b = locald.toString())
    {
      if (paramArrayOfd.length <= 1) {
        break label266;
      }
      this.h = new ak[paramArrayOfd.length];
      i = n;
      while (i < paramArrayOfd.length)
      {
        this.h[i] = new ak(paramContext, paramArrayOfd[i]);
        i += 1;
      }
      i = 0;
      break;
      j = 0;
      break label62;
      k = this.f;
      this.g = bU.a(localDisplayMetrics, this.f);
      break label98;
      m = this.c;
      break label110;
    }
    label266:
    this.h = null;
  }
  
  public ak(ak paramak, ak[] paramArrayOfak)
  {
    this(2, paramak.b, paramak.c, paramak.d, paramak.e, paramak.f, paramak.g, paramArrayOfak);
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
  
  public final d a()
  {
    return c.a(this.f, this.c, this.b);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    n.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */