package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.drive.DriveId;

public class b
  implements Parcelable.Creator<AuthorizeAccessRequest>
{
  static void a(AuthorizeAccessRequest paramAuthorizeAccessRequest, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.p(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramAuthorizeAccessRequest.xH);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramAuthorizeAccessRequest.EU);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramAuthorizeAccessRequest.Ew, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.F(paramParcel, i);
  }
  
  public AuthorizeAccessRequest D(Parcel paramParcel)
  {
    int j = a.o(paramParcel);
    int i = 0;
    long l = 0L;
    DriveId localDriveId = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.n(paramParcel);
      switch (a.R(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        l = a.i(paramParcel, k);
        break;
      case 3: 
        localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new AuthorizeAccessRequest(i, l, localDriveId);
  }
  
  public AuthorizeAccessRequest[] ah(int paramInt)
  {
    return new AuthorizeAccessRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */