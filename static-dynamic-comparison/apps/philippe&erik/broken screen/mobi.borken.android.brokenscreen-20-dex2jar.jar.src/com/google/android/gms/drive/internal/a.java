package com.google.android.gms.drive.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;

public class a
  implements Parcelable.Creator<AddEventListenerRequest>
{
  static void a(AddEventListenerRequest paramAddEventListenerRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramAddEventListenerRequest.xJ);
    b.a(paramParcel, 2, paramAddEventListenerRequest.Hw, paramInt, false);
    b.c(paramParcel, 3, paramAddEventListenerRequest.In);
    b.a(paramParcel, 4, paramAddEventListenerRequest.Io, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public AddEventListenerRequest R(Parcel paramParcel)
  {
    PendingIntent localPendingIntent = null;
    int j = 0;
    int m = com.google.android.gms.common.internal.safeparcel.a.B(paramParcel);
    DriveId localDriveId = null;
    int i = 0;
    if (paramParcel.dataPosition() < m)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.A(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.ar(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        k = j;
        j = i;
        i = k;
      }
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break;
        k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        i = j;
        j = k;
        continue;
        localDriveId = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, DriveId.CREATOR);
        k = i;
        i = j;
        j = k;
        continue;
        k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        j = i;
        i = k;
        continue;
        localPendingIntent = (PendingIntent)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, PendingIntent.CREATOR);
        k = i;
        i = j;
        j = k;
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new AddEventListenerRequest(i, localDriveId, j, localPendingIntent);
  }
  
  public AddEventListenerRequest[] aM(int paramInt)
  {
    return new AddEventListenerRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */