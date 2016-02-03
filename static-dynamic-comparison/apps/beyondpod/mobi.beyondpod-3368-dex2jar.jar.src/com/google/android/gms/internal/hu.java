package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public class hu
  implements SafeParcelable
{
  public static final hw CREATOR = new hw();
  private final String[] DR;
  private final String[] DS;
  private final String[] DT;
  private final String DU;
  private final String DV;
  private final String DW;
  private final String DX;
  private final String jG;
  private final int kg;
  
  hu(int paramInt, String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.kg = paramInt;
    this.jG = paramString1;
    this.DR = paramArrayOfString1;
    this.DS = paramArrayOfString2;
    this.DT = paramArrayOfString3;
    this.DU = paramString2;
    this.DV = paramString3;
    this.DW = paramString4;
    this.DX = paramString5;
  }
  
  public hu(String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4)
  {
    this.kg = 1;
    this.jG = paramString1;
    this.DR = paramArrayOfString1;
    this.DS = paramArrayOfString2;
    this.DT = paramArrayOfString3;
    this.DU = paramString2;
    this.DV = paramString3;
    this.DW = paramString4;
    this.DX = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String[] eR()
  {
    return this.DR;
  }
  
  public String[] eS()
  {
    return this.DS;
  }
  
  public String[] eT()
  {
    return this.DT;
  }
  
  public String eU()
  {
    return this.DU;
  }
  
  public String eV()
  {
    return this.DV;
  }
  
  public String eW()
  {
    return this.DW;
  }
  
  public String eX()
  {
    return this.DX;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof hu)) {}
    do
    {
      return false;
      paramObject = (hu)paramObject;
    } while ((this.kg != ((hu)paramObject).kg) || (!ee.equal(this.jG, ((hu)paramObject).jG)) || (!Arrays.equals(this.DR, ((hu)paramObject).DR)) || (!Arrays.equals(this.DS, ((hu)paramObject).DS)) || (!Arrays.equals(this.DT, ((hu)paramObject).DT)) || (!ee.equal(this.DU, ((hu)paramObject).DU)) || (!ee.equal(this.DV, ((hu)paramObject).DV)) || (!ee.equal(this.DW, ((hu)paramObject).DW)) || (!ee.equal(this.DX, ((hu)paramObject).DX)));
    return true;
  }
  
  public String getAccountName()
  {
    return this.jG;
  }
  
  public int getVersionCode()
  {
    return this.kg;
  }
  
  public int hashCode()
  {
    return ee.hashCode(new Object[] { Integer.valueOf(this.kg), this.jG, this.DR, this.DS, this.DT, this.DU, this.DV, this.DW, this.DX });
  }
  
  public String toString()
  {
    return ee.e(this).a("versionCode", Integer.valueOf(this.kg)).a("accountName", this.jG).a("requestedScopes", this.DR).a("visibleActivities", this.DS).a("requiredFeatures", this.DT).a("packageNameForAuth", this.DU).a("callingPackageName", this.DV).a("applicationName", this.DW).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hw.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/hu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */