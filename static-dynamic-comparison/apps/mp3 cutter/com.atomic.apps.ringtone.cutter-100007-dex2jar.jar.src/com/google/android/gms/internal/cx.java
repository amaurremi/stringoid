package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class cx
  implements SafeParcelable
{
  public static final bm CREATOR = new bm();
  public final int a;
  public final Bundle b;
  public final ah c;
  public final ak d;
  public final String e;
  public final ApplicationInfo f;
  public final PackageInfo g;
  public final String h;
  public final String i;
  public final String j;
  public final dx k;
  public final Bundle l;
  
  cx(int paramInt, Bundle paramBundle1, ah paramah, ak paramak, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, dx paramdx, Bundle paramBundle2)
  {
    this.a = paramInt;
    this.b = paramBundle1;
    this.c = paramah;
    this.d = paramak;
    this.e = paramString1;
    this.f = paramApplicationInfo;
    this.g = paramPackageInfo;
    this.h = paramString2;
    this.i = paramString3;
    this.j = paramString4;
    this.k = paramdx;
    this.l = paramBundle2;
  }
  
  private cx(Bundle paramBundle1, ah paramah, ak paramak, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, dx paramdx, Bundle paramBundle2)
  {
    this(2, paramBundle1, paramah, paramak, paramString1, paramApplicationInfo, paramPackageInfo, paramString2, paramString3, paramString4, paramdx, paramBundle2);
  }
  
  public cx(bl parambl, String paramString)
  {
    this(parambl.a, parambl.b, parambl.c, parambl.d, parambl.e, parambl.f, paramString, parambl.g, parambl.h, parambl.j, parambl.i);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    bm.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */