package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class bz
  implements SafeParcelable
{
  public static final ca CREATOR = new ca();
  public final String adUnitId;
  public final ApplicationInfo applicationInfo;
  public final cu ej;
  public final x em;
  public final Bundle hq;
  public final v hr;
  public final PackageInfo hs;
  public final String ht;
  public final String hu;
  public final String hv;
  public final int versionCode;
  
  bz(int paramInt, Bundle paramBundle, v paramv, x paramx, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, cu paramcu)
  {
    this.versionCode = paramInt;
    this.hq = paramBundle;
    this.hr = paramv;
    this.em = paramx;
    this.adUnitId = paramString1;
    this.applicationInfo = paramApplicationInfo;
    this.hs = paramPackageInfo;
    this.ht = paramString2;
    this.hu = paramString3;
    this.hv = paramString4;
    this.ej = paramcu;
  }
  
  public bz(Bundle paramBundle, v paramv, x paramx, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, cu paramcu)
  {
    this(1, paramBundle, paramv, paramx, paramString1, paramApplicationInfo, paramPackageInfo, paramString2, paramString3, paramString4, paramcu);
  }
  
  public bz(a parama, String paramString)
  {
    this(parama.hq, parama.hr, parama.em, parama.adUnitId, parama.applicationInfo, parama.hs, paramString, parama.hu, parama.hv, parama.ej);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ca.a(this, paramParcel, paramInt);
  }
  
  public static final class a
  {
    public final String adUnitId;
    public final ApplicationInfo applicationInfo;
    public final cu ej;
    public final x em;
    public final Bundle hq;
    public final v hr;
    public final PackageInfo hs;
    public final String hu;
    public final String hv;
    
    public a(Bundle paramBundle, v paramv, x paramx, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, cu paramcu)
    {
      this.hq = paramBundle;
      this.hr = paramv;
      this.em = paramx;
      this.adUnitId = paramString1;
      this.applicationInfo = paramApplicationInfo;
      this.hs = paramPackageInfo;
      this.hu = paramString2;
      this.hv = paramString3;
      this.ej = paramcu;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */