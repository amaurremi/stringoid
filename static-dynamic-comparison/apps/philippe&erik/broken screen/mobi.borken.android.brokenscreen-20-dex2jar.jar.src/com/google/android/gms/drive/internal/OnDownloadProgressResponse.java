package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDownloadProgressResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnDownloadProgressResponse> CREATOR = new ah();
  final long Jt;
  final long Ju;
  final int xJ;
  
  OnDownloadProgressResponse(int paramInt, long paramLong1, long paramLong2)
  {
    this.xJ = paramInt;
    this.Jt = paramLong1;
    this.Ju = paramLong2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public long gp()
  {
    return this.Jt;
  }
  
  public long gq()
  {
    return this.Ju;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ah.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/internal/OnDownloadProgressResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */