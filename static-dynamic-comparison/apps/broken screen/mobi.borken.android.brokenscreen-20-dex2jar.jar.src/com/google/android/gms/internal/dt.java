package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class dt
  implements SafeParcelable
{
  public static final du CREATOR = new du();
  public final ApplicationInfo applicationInfo;
  public final String kL;
  public final ew kO;
  public final am kR;
  public final Bundle pU;
  public final aj pV;
  public final PackageInfo pW;
  public final String pX;
  public final String pY;
  public final String pZ;
  public final Bundle qa;
  public final int versionCode;
  
  dt(int paramInt, Bundle paramBundle1, aj paramaj, am paramam, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, ew paramew, Bundle paramBundle2)
  {
    this.versionCode = paramInt;
    this.pU = paramBundle1;
    this.pV = paramaj;
    this.kR = paramam;
    this.kL = paramString1;
    this.applicationInfo = paramApplicationInfo;
    this.pW = paramPackageInfo;
    this.pX = paramString2;
    this.pY = paramString3;
    this.pZ = paramString4;
    this.kO = paramew;
    this.qa = paramBundle2;
  }
  
  public dt(Bundle paramBundle1, aj paramaj, am paramam, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, ew paramew, Bundle paramBundle2)
  {
    this(2, paramBundle1, paramaj, paramam, paramString1, paramApplicationInfo, paramPackageInfo, paramString2, paramString3, paramString4, paramew, paramBundle2);
  }
  
  public dt(a parama, String paramString)
  {
    this(parama.pU, parama.pV, parama.kR, parama.kL, parama.applicationInfo, parama.pW, paramString, parama.pY, parama.pZ, parama.kO, parama.qa);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    du.a(this, paramParcel, paramInt);
  }
  
  public static final class a
  {
    public final ApplicationInfo applicationInfo;
    public final String kL;
    public final ew kO;
    public final am kR;
    public final Bundle pU;
    public final aj pV;
    public final PackageInfo pW;
    public final String pY;
    public final String pZ;
    public final Bundle qa;
    
    public a(Bundle paramBundle1, aj paramaj, am paramam, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, ew paramew, Bundle paramBundle2)
    {
      this.pU = paramBundle1;
      this.pV = paramaj;
      this.kR = paramam;
      this.kL = paramString1;
      this.applicationInfo = paramApplicationInfo;
      this.pW = paramPackageInfo;
      this.pY = paramString2;
      this.pZ = paramString3;
      this.kO = paramew;
      this.qa = paramBundle2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */