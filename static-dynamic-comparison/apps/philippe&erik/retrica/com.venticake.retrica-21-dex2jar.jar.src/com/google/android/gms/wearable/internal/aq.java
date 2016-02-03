package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class aq
  implements SafeParcelable
{
  public static final Parcelable.Creator<aq> CREATOR = new ar();
  public final int amc;
  public final int statusCode;
  public final int versionCode;
  
  aq(int paramInt1, int paramInt2, int paramInt3)
  {
    this.versionCode = paramInt1;
    this.statusCode = paramInt2;
    this.amc = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ar.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/internal/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */