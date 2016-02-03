package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hi
  implements SafeParcelable
{
  public static final hj CREATOR = new hj();
  private final String OE;
  private final String mTag;
  final int xH;
  
  hi(int paramInt, String paramString1, String paramString2)
  {
    this.xH = paramInt;
    this.OE = paramString1;
    this.mTag = paramString2;
  }
  
  public int describeContents()
  {
    hj localhj = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof hi)) {}
    do
    {
      return false;
      paramObject = (hi)paramObject;
    } while ((!fo.equal(this.OE, ((hi)paramObject).OE)) || (!fo.equal(this.mTag, ((hi)paramObject).mTag)));
    return true;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public String hY()
  {
    return this.OE;
  }
  
  public int hashCode()
  {
    return fo.hashCode(new Object[] { this.OE, this.mTag });
  }
  
  public String toString()
  {
    return fo.e(this).a("mPlaceId", this.OE).a("mTag", this.mTag).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hj localhj = CREATOR;
    hj.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/hi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */