package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ds
  implements SafeParcelable
{
  public static final dt CREATOR = new dt();
  public final ApplicationInfo applicationInfo;
  public final String kN;
  public final ev kQ;
  public final al kT;
  public final Bundle pW;
  public final ai pX;
  public final PackageInfo pY;
  public final String pZ;
  public final String qa;
  public final String qb;
  public final Bundle qc;
  public final String qd;
  public final int versionCode;
  
  ds(int paramInt, Bundle paramBundle1, ai paramai, al paramal, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, ev paramev, Bundle paramBundle2, String paramString5)
  {
    this.versionCode = paramInt;
    this.pW = paramBundle1;
    this.pX = paramai;
    this.kT = paramal;
    this.kN = paramString1;
    this.applicationInfo = paramApplicationInfo;
    this.pY = paramPackageInfo;
    this.pZ = paramString2;
    this.qa = paramString3;
    this.qb = paramString4;
    this.kQ = paramev;
    this.qc = paramBundle2;
    this.qd = paramString5;
  }
  
  public ds(Bundle paramBundle1, ai paramai, al paramal, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, ev paramev, Bundle paramBundle2, String paramString5)
  {
    this(3, paramBundle1, paramai, paramal, paramString1, paramApplicationInfo, paramPackageInfo, paramString2, paramString3, paramString4, paramev, paramBundle2, paramString5);
  }
  
  public ds(ds.a parama, String paramString1, String paramString2)
  {
    this(parama.pW, parama.pX, parama.kT, parama.kN, parama.applicationInfo, parama.pY, paramString1, parama.qa, parama.qb, parama.kQ, parama.qc, paramString2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    dt.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */