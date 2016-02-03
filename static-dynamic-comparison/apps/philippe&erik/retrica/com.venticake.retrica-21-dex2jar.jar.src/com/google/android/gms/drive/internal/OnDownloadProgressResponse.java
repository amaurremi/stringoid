package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDownloadProgressResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnDownloadProgressResponse> CREATOR = new ah();
  final long Jw;
  final long Jx;
  final int xM;
  
  OnDownloadProgressResponse(int paramInt, long paramLong1, long paramLong2)
  {
    this.xM = paramInt;
    this.Jw = paramLong1;
    this.Jx = paramLong2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long gu()
  {
    return this.Jw;
  }
  
  public long gv()
  {
    return this.Jx;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ah.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/OnDownloadProgressResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */