package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class ah
  implements Parcelable.Creator<OpenContentsRequest>
{
  static void a(OpenContentsRequest paramOpenContentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.p(paramParcel);
    b.c(paramParcel, 1, paramOpenContentsRequest.xH);
    b.a(paramParcel, 2, paramOpenContentsRequest.EV, paramInt, false);
    b.c(paramParcel, 3, paramOpenContentsRequest.Ev);
    b.F(paramParcel, i);
  }
  
  public OpenContentsRequest V(Parcel paramParcel)
  {
    int i = 0;
    int k = a.o(paramParcel);
    DriveId localDriveId = null;
    int j = 0;
    if (paramParcel.dataPosition() < k)
    {
      int m = a.n(paramParcel);
      switch (a.R(m))
      {
      default: 
        a.b(paramParcel, m);
      }
      for (;;)
      {
        break;
        j = a.g(paramParcel, m);
        continue;
        localDriveId = (DriveId)a.a(paramParcel, m, DriveId.CREATOR);
        continue;
        i = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new OpenContentsRequest(j, localDriveId, i);
  }
  
  public OpenContentsRequest[] az(int paramInt)
  {
    return new OpenContentsRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/internal/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */