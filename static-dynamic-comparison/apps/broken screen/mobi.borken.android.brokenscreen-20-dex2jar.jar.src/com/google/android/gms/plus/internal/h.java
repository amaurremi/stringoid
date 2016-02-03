package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;
import java.util.Arrays;

public class h
  implements SafeParcelable
{
  public static final j CREATOR = new j();
  private final String[] abQ;
  private final String[] abR;
  private final String[] abS;
  private final String abT;
  private final String abU;
  private final String abV;
  private final String abW;
  private final PlusCommonExtras abX;
  private final int xJ;
  private final String yN;
  
  h(int paramInt, String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, String paramString5, PlusCommonExtras paramPlusCommonExtras)
  {
    this.xJ = paramInt;
    this.yN = paramString1;
    this.abQ = paramArrayOfString1;
    this.abR = paramArrayOfString2;
    this.abS = paramArrayOfString3;
    this.abT = paramString2;
    this.abU = paramString3;
    this.abV = paramString4;
    this.abW = paramString5;
    this.abX = paramPlusCommonExtras;
  }
  
  public h(String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String paramString2, String paramString3, String paramString4, PlusCommonExtras paramPlusCommonExtras)
  {
    this.xJ = 1;
    this.yN = paramString1;
    this.abQ = paramArrayOfString1;
    this.abR = paramArrayOfString2;
    this.abS = paramArrayOfString3;
    this.abT = paramString2;
    this.abU = paramString3;
    this.abV = paramString4;
    this.abW = null;
    this.abX = paramPlusCommonExtras;
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
    } while ((this.xJ != ((h)paramObject).xJ) || (!hl.equal(this.yN, ((h)paramObject).yN)) || (!Arrays.equals(this.abQ, ((h)paramObject).abQ)) || (!Arrays.equals(this.abR, ((h)paramObject).abR)) || (!Arrays.equals(this.abS, ((h)paramObject).abS)) || (!hl.equal(this.abT, ((h)paramObject).abT)) || (!hl.equal(this.abU, ((h)paramObject).abU)) || (!hl.equal(this.abV, ((h)paramObject).abV)) || (!hl.equal(this.abW, ((h)paramObject).abW)) || (!hl.equal(this.abX, ((h)paramObject).abX)));
    return true;
  }
  
  public String getAccountName()
  {
    return this.yN;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { Integer.valueOf(this.xJ), this.yN, this.abQ, this.abR, this.abS, this.abT, this.abU, this.abV, this.abW, this.abX });
  }
  
  public String[] jU()
  {
    return this.abQ;
  }
  
  public String[] jV()
  {
    return this.abR;
  }
  
  public String[] jW()
  {
    return this.abS;
  }
  
  public String jX()
  {
    return this.abT;
  }
  
  public String jY()
  {
    return this.abU;
  }
  
  public String jZ()
  {
    return this.abV;
  }
  
  public String ka()
  {
    return this.abW;
  }
  
  public PlusCommonExtras kb()
  {
    return this.abX;
  }
  
  public Bundle kc()
  {
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
    this.abX.n(localBundle);
    return localBundle;
  }
  
  public String toString()
  {
    return hl.e(this).a("versionCode", Integer.valueOf(this.xJ)).a("accountName", this.yN).a("requestedScopes", this.abQ).a("visibleActivities", this.abR).a("requiredFeatures", this.abS).a("packageNameForAuth", this.abT).a("callingPackageName", this.abU).a("applicationName", this.abV).a("extra", this.abX.toString()).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/plus/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */