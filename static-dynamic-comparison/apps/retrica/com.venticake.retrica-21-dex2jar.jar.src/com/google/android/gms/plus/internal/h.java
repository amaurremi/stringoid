package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.a;
import java.util.Arrays;

public class h
  implements SafeParcelable
{
  public static final j CREATOR = new j();
  private final String[] abT;
  private final String[] abU;
  private final String[] abV;
  private final String abW;
  private final String abX;
  private final String abY;
  private final String abZ;
  private final PlusCommonExtras aca;
  private final int xM;
  private final String yQ;
  
  h(int paramInt, String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, String paramString5, PlusCommonExtras paramPlusCommonExtras)
  {
    this.xM = paramInt;
    this.yQ = paramString1;
    this.abT = paramArrayOfString1;
    this.abU = paramArrayOfString2;
    this.abV = paramArrayOfString3;
    this.abW = paramString2;
    this.abX = paramString3;
    this.abY = paramString4;
    this.abZ = paramString5;
    this.aca = paramPlusCommonExtras;
  }
  
  public h(String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, PlusCommonExtras paramPlusCommonExtras)
  {
    this.xM = 1;
    this.yQ = paramString1;
    this.abT = paramArrayOfString1;
    this.abU = paramArrayOfString2;
    this.abV = paramArrayOfString3;
    this.abW = paramString2;
    this.abX = paramString3;
    this.abY = paramString4;
    this.abZ = null;
    this.aca = paramPlusCommonExtras;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof h)) {}
    do
    {
      return false;
      paramObject = (h)paramObject;
    } while ((this.xM != ((h)paramObject).xM) || (!hk.equal(this.yQ, ((h)paramObject).yQ)) || (!Arrays.equals(this.abT, ((h)paramObject).abT)) || (!Arrays.equals(this.abU, ((h)paramObject).abU)) || (!Arrays.equals(this.abV, ((h)paramObject).abV)) || (!hk.equal(this.abW, ((h)paramObject).abW)) || (!hk.equal(this.abX, ((h)paramObject).abX)) || (!hk.equal(this.abY, ((h)paramObject).abY)) || (!hk.equal(this.abZ, ((h)paramObject).abZ)) || (!hk.equal(this.aca, ((h)paramObject).aca)));
    return true;
  }
  
  public String getAccountName()
  {
    return this.yQ;
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { Integer.valueOf(this.xM), this.yQ, this.abT, this.abU, this.abV, this.abW, this.abX, this.abY, this.abZ, this.aca });
  }
  
  public String[] jZ()
  {
    return this.abT;
  }
  
  public String[] ka()
  {
    return this.abU;
  }
  
  public String[] kb()
  {
    return this.abV;
  }
  
  public String kc()
  {
    return this.abW;
  }
  
  public String kd()
  {
    return this.abX;
  }
  
  public String ke()
  {
    return this.abY;
  }
  
  public String kf()
  {
    return this.abZ;
  }
  
  public PlusCommonExtras kg()
  {
    return this.aca;
  }
  
  public Bundle kh()
  {
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
    this.aca.n(localBundle);
    return localBundle;
  }
  
  public String toString()
  {
    return hk.e(this).a("versionCode", Integer.valueOf(this.xM)).a("accountName", this.yQ).a("requestedScopes", this.abT).a("visibleActivities", this.abU).a("requiredFeatures", this.abV).a("packageNameForAuth", this.abW).a("callingPackageName", this.abX).a("applicationName", this.abY).a("extra", this.aca.toString()).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/plus/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */