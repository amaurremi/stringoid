package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.drive.DriveId;

public class b
  implements Parcelable.Creator<ConflictEvent>
{
  static void a(ConflictEvent paramConflictEvent, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.k(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramConflictEvent.qh);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramConflictEvent.sG, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.D(paramParcel, i);
  }
  
  public ConflictEvent[] bw(int paramInt)
  {
    return new ConflictEvent[paramInt];
  }
  
  public ConflictEvent o(Parcel paramParcel)
  {
    int j = a.j(paramParcel);
    int i = 0;
    DriveId localDriveId = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.i(paramParcel);
      switch (a.br(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ConflictEvent(i, localDriveId);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/events/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */