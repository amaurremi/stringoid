package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AddEventListenerRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AddEventListenerRequest> CREATOR = new a();
  final int BR;
  final DriveId MO;
  final int NS;
  
  AddEventListenerRequest(int paramInt1, DriveId paramDriveId, int paramInt2)
  {
    this.BR = paramInt1;
    this.MO = paramDriveId;
    this.NS = paramInt2;
  }
  
  public AddEventListenerRequest(DriveId paramDriveId, int paramInt)
  {
    this(1, paramDriveId, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/internal/AddEventListenerRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */