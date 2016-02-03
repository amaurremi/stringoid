package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetDriveIdFromUniqueIdentifierRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetDriveIdFromUniqueIdentifierRequest> CREATOR = new y();
  final String Jm;
  final boolean Jn;
  final int xJ;
  
  GetDriveIdFromUniqueIdentifierRequest(int paramInt, String paramString, boolean paramBoolean)
  {
    this.xJ = paramInt;
    this.Jm = paramString;
    this.Jn = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    y.a(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/internal/GetDriveIdFromUniqueIdentifierRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */