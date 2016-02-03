package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class jo
  implements SafeParcelable
{
  public static final jp CREATOR = new jp();
  private final String Wl;
  private final String mTag;
  final int xM;
  
  jo(int paramInt, String paramString1, String paramString2)
  {
    this.xM = paramInt;
    this.Wl = paramString1;
    this.mTag = paramString2;
  }
  
  public int describeContents()
  {
    jp localjp = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof jo)) {}
    do
    {
      return false;
      paramObject = (jo)paramObject;
    } while ((!hk.equal(this.Wl, ((jo)paramObject).Wl)) || (!hk.equal(this.mTag, ((jo)paramObject).mTag)));
    return true;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public int hashCode()
  {
    return hk.hashCode(new Object[] { this.Wl, this.mTag });
  }
  
  public String jj()
  {
    return this.Wl;
  }
  
  public String toString()
  {
    return hk.e(this).a("mPlaceId", this.Wl).a("mTag", this.mTag).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    jp localjp = CREATOR;
    jp.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/jo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */