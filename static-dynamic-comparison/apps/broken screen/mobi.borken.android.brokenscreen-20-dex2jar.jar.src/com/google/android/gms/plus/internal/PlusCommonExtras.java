package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hl.a;

public class PlusCommonExtras
  implements SafeParcelable
{
  public static final f CREATOR = new f();
  public static String TAG = "PlusCommonExtras";
  private String abN;
  private String abO;
  private final int xJ;
  
  public PlusCommonExtras()
  {
    this.xJ = 1;
    this.abN = "";
    this.abO = "";
  }
  
  PlusCommonExtras(int paramInt, String paramString1, String paramString2)
  {
    this.xJ = paramInt;
    this.abN = paramString1;
    this.abO = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlusCommonExtras)) {}
    do
    {
      return false;
      paramObject = (PlusCommonExtras)paramObject;
    } while ((this.xJ != ((PlusCommonExtras)paramObject).xJ) || (!hl.equal(this.abN, ((PlusCommonExtras)paramObject).abN)) || (!hl.equal(this.abO, ((PlusCommonExtras)paramObject).abO)));
    return true;
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { Integer.valueOf(this.xJ), this.abN, this.abO });
  }
  
  public String jS()
  {
    return this.abN;
  }
  
  public String jT()
  {
    return this.abO;
  }
  
  public void n(Bundle paramBundle)
  {
    paramBundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", c.a(this));
  }
  
  public String toString()
  {
    return hl.e(this).a("versionCode", Integer.valueOf(this.xJ)).a("Gpsrc", this.abN).a("ClientCallingPackage", this.abO).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/plus/internal/PlusCommonExtras.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */