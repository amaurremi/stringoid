package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetDriveIdFromUniqueIdentifierRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetDriveIdFromUniqueIdentifierRequest> CREATOR = new z();
  final int BR;
  final String OZ;
  final boolean Pa;
  
  GetDriveIdFromUniqueIdentifierRequest(int paramInt, String paramString, boolean paramBoolean)
  {
    this.BR = paramInt;
    this.OZ = paramString;
    this.Pa = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    z.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/internal/GetDriveIdFromUniqueIdentifierRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */