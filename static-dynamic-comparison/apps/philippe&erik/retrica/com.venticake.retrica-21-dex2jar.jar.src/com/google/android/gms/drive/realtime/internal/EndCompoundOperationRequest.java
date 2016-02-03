package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class EndCompoundOperationRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<EndCompoundOperationRequest> CREATOR = new b();
  final int xM;
  
  public EndCompoundOperationRequest()
  {
    this(1);
  }
  
  EndCompoundOperationRequest(int paramInt)
  {
    this.xM = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/EndCompoundOperationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */