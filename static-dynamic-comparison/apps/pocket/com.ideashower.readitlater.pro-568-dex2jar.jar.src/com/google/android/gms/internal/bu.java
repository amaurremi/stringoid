package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class bu
  implements SafeParcelable
{
  public static final f CREATOR = new f();
  public final int a;
  public final Bundle b;
  public final v c;
  public final x d;
  public final String e;
  public final ApplicationInfo f;
  public final PackageInfo g;
  public final String h;
  public final String i;
  public final String j;
  public final co k;
  
  bu(int paramInt, Bundle paramBundle, v paramv, x paramx, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, co paramco)
  {
    this.a = paramInt;
    this.b = paramBundle;
    this.c = paramv;
    this.d = paramx;
    this.e = paramString1;
    this.f = paramApplicationInfo;
    this.g = paramPackageInfo;
    this.h = paramString2;
    this.i = paramString3;
    this.j = paramString4;
    this.k = paramco;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */