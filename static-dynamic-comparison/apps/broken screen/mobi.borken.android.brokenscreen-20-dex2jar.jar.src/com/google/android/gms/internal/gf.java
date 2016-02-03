package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class gf
  implements SafeParcelable
{
  public static final Parcelable.Creator<gf> CREATOR = new gg();
  private String Bz;
  private final int xJ;
  
  public gf()
  {
    this(1, null);
  }
  
  gf(int paramInt, String paramString)
  {
    this.xJ = paramInt;
    this.Bz = paramString;
  }
  
  public String dX()
  {
    return this.Bz;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof gf)) {
      return false;
    }
    paramObject = (gf)paramObject;
    return gj.a(this.Bz, ((gf)paramObject).Bz);
  }
  
  public int getVersionCode()
  {
    return this.xJ;
  }
  
  public int hashCode()
  {
    return hl.hashCode(new Object[] { this.Bz });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    gg.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/gf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */