package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenFileIntentSenderRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<OpenFileIntentSenderRequest> CREATOR = new aw();
  final int BR;
  final String No;
  final String[] Np;
  final DriveId Nq;
  
  OpenFileIntentSenderRequest(int paramInt, String paramString, String[] paramArrayOfString, DriveId paramDriveId)
  {
    this.BR = paramInt;
    this.No = paramString;
    this.Np = paramArrayOfString;
    this.Nq = paramDriveId;
  }
  
  public OpenFileIntentSenderRequest(String paramString, String[] paramArrayOfString, DriveId paramDriveId)
  {
    this(1, paramString, paramArrayOfString, paramDriveId);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    aw.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/internal/OpenFileIntentSenderRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */