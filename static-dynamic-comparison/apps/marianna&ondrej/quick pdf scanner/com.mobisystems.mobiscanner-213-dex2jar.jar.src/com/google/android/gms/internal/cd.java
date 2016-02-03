package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class cd
  implements SafeParcelable
{
  public static final ba Dz = new ba();
  public final db CY;
  public final Bundle DA;
  public final z DB;
  public final ab DC;
  public final String DD;
  public final PackageInfo DE;
  public final String DF;
  public final String DG;
  public final String DI;
  public final Bundle DJ;
  public final ApplicationInfo applicationInfo;
  public final int versionCode;
  
  cd(int paramInt, Bundle paramBundle1, z paramz, ab paramab, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, db paramdb, Bundle paramBundle2)
  {
    this.versionCode = paramInt;
    this.DA = paramBundle1;
    this.DB = paramz;
    this.DC = paramab;
    this.DD = paramString1;
    this.applicationInfo = paramApplicationInfo;
    this.DE = paramPackageInfo;
    this.DF = paramString2;
    this.DG = paramString3;
    this.DI = paramString4;
    this.CY = paramdb;
    this.DJ = paramBundle2;
  }
  
  public cd(Bundle paramBundle1, z paramz, ab paramab, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, db paramdb, Bundle paramBundle2)
  {
    this(2, paramBundle1, paramz, paramab, paramString1, paramApplicationInfo, paramPackageInfo, paramString2, paramString3, paramString4, paramdb, paramBundle2);
  }
  
  public cd(a parama, String paramString)
  {
    this(parama.DA, parama.DB, parama.DC, parama.DD, parama.applicationInfo, parama.DE, paramString, parama.DG, parama.DI, parama.CY, parama.DJ);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ba.a(this, paramParcel, paramInt);
  }
  
  public static final class a
  {
    public final db CY;
    public final Bundle DA;
    public final z DB;
    public final ab DC;
    public final String DD;
    public final PackageInfo DE;
    public final String DG;
    public final String DI;
    public final Bundle DJ;
    public final ApplicationInfo applicationInfo;
    
    public a(Bundle paramBundle1, z paramz, ab paramab, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, db paramdb, Bundle paramBundle2)
    {
      this.DA = paramBundle1;
      this.DB = paramz;
      this.DC = paramab;
      this.DD = paramString1;
      this.applicationInfo = paramApplicationInfo;
      this.DE = paramPackageInfo;
      this.DG = paramString2;
      this.DI = paramString3;
      this.CY = paramdb;
      this.DJ = paramBundle2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */