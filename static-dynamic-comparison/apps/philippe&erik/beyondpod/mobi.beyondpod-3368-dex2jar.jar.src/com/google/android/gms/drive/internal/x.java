package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class x
  implements Parcelable.Creator<OpenFileIntentSenderRequest>
{
  static void a(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.c(paramParcel, 1, paramOpenFileIntentSenderRequest.kg);
    b.a(paramParcel, 2, paramOpenFileIntentSenderRequest.qL, false);
    b.a(paramParcel, 3, paramOpenFileIntentSenderRequest.qW, false);
    b.a(paramParcel, 4, paramOpenFileIntentSenderRequest.qM, paramInt, false);
    b.D(paramParcel, i);
  }
  
  public OpenFileIntentSenderRequest M(Parcel paramParcel)
  {
    DriveId localDriveId = null;
    int j = a.n(paramParcel);
    int i = 0;
    String[] arrayOfString = null;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.m(paramParcel);
      switch (a.M(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str = a.m(paramParcel, k);
        break;
      case 3: 
        arrayOfString = a.x(paramParcel, k);
        break;
      case 4: 
        localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new OpenFileIntentSenderRequest(i, str, arrayOfString, localDriveId);
  }
  
  public OpenFileIntentSenderRequest[] am(int paramInt)
  {
    return new OpenFileIntentSenderRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/internal/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */