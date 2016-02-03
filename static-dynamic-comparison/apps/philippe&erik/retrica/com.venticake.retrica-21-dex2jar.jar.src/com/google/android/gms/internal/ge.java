package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ge
  implements SafeParcelable
{
  public static final Parcelable.Creator<ge> CREATOR = new gf();
  private String BC;
  private final int xM;
  
  public ge()
  {
    this(1, null);
  }
  
  ge(int paramInt, String paramString)
  {
    this.xM = paramInt;
    this.BC = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String ec()
  {
    return this.BC;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ge)) {
      return false;
    }
    paramObject = (ge)paramObject;
    return gi.a(this.BC, ((ge)paramObject).BC);
  }
  
  public int getVersionCode()
  {
    return this.xM;
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { this.BC });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    gf.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */