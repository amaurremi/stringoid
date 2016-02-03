package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class CloseContentsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CloseContentsRequest> CREATOR = new r();
  final int qh;
  final Contents te;
  final Boolean tf;
  
  CloseContentsRequest(int paramInt, Contents paramContents, Boolean paramBoolean)
  {
    this.qh = paramInt;
    this.te = paramContents;
    this.tf = paramBoolean;
  }
  
  public CloseContentsRequest(Contents paramContents, boolean paramBoolean)
  {
    this(1, paramContents, Boolean.valueOf(paramBoolean));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    r.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/internal/CloseContentsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */