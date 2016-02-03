package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class f
  implements Parcelable.Creator<CreateFolderRequest>
{
  static void a(CreateFolderRequest paramCreateFolderRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.c(paramParcel, 1, paramCreateFolderRequest.kg);
    b.a(paramParcel, 2, paramCreateFolderRequest.ra, paramInt, false);
    b.a(paramParcel, 3, paramCreateFolderRequest.qZ, paramInt, false);
    b.D(paramParcel, i);
  }
  
  public CreateFolderRequest E(Parcel paramParcel)
  {
    MetadataBundle localMetadataBundle = null;
    int j = a.n(paramParcel);
    int i = 0;
    DriveId localDriveId = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = a.m(paramParcel);
      switch (a.M(k))
      {
      default: 
        a.b(paramParcel, k);
      }
      for (;;)
      {
        break;
        i = a.g(paramParcel, k);
        continue;
        localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
        continue;
        localMetadataBundle = (MetadataBundle)a.a(paramParcel, k, MetadataBundle.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new CreateFolderRequest(i, localDriveId, localMetadataBundle);
  }
  
  public CreateFolderRequest[] ae(int paramInt)
  {
    return new CreateFolderRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/internal/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */