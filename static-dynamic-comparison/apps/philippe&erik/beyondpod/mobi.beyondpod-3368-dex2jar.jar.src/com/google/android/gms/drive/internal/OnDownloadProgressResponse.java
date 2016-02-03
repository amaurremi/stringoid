package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDownloadProgressResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnDownloadProgressResponse> CREATOR = new s();
  final int kg;
  final long rx;
  final long ry;
  
  OnDownloadProgressResponse(int paramInt, long paramLong1, long paramLong2)
  {
    this.kg = paramInt;
    this.rx = paramLong1;
    this.ry = paramLong2;
  }
  
  public long cR()
  {
    return this.rx;
  }
  
  public long cS()
  {
    return this.ry;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    s.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/internal/OnDownloadProgressResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */