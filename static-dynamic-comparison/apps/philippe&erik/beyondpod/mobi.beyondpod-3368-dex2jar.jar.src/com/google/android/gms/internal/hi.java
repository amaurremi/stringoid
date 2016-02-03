package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hi
  implements SafeParcelable
{
  public static final hj CREATOR = new hj();
  public final String Bn;
  public final String Bo;
  public final int versionCode;
  
  public hi(int paramInt, String paramString1, String paramString2)
  {
    this.versionCode = paramInt;
    this.Bn = paramString1;
    this.Bo = paramString2;
  }
  
  public int describeContents()
  {
    hj localhj = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof hi))) {
        return false;
      }
      paramObject = (hi)paramObject;
    } while ((this.Bo.equals(((hi)paramObject).Bo)) && (this.Bn.equals(((hi)paramObject).Bn)));
    return false;
  }
  
  public int hashCode()
  {
    return ee.hashCode(new Object[] { this.Bn, this.Bo });
  }
  
  public String toString()
  {
    return ee.e(this).a("clientPackageName", this.Bn).a("locale", this.Bo).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    hj localhj = CREATOR;
    hj.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/hi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */