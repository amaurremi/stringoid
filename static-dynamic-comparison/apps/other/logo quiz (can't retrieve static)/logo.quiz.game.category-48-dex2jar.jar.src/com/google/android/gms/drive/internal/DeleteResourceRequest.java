package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class DeleteResourceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DeleteResourceRequest> CREATOR = new m();
  final int BR;
  final DriveId NV;
  
  DeleteResourceRequest(int paramInt, DriveId paramDriveId)
  {
    this.BR = paramInt;
    this.NV = paramDriveId;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    m.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/internal/DeleteResourceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */