package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnLoadRealtimeResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnLoadRealtimeResponse> CREATOR = new an();
  final boolean JC;
  final int xM;
  
  OnLoadRealtimeResponse(int paramInt, boolean paramBoolean)
  {
    this.xM = paramInt;
    this.JC = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    an.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/OnLoadRealtimeResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */