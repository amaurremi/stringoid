package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class g
  implements Parcelable.Creator<CreateFileIntentSenderRequest>
{
  static void a(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.p(paramParcel);
    b.c(paramParcel, 1, paramCreateFileIntentSenderRequest.xH);
    b.a(paramParcel, 2, paramCreateFileIntentSenderRequest.EZ, paramInt, false);
    b.c(paramParcel, 3, paramCreateFileIntentSenderRequest.Eu);
    b.a(paramParcel, 4, paramCreateFileIntentSenderRequest.EB, false);
    b.a(paramParcel, 5, paramCreateFileIntentSenderRequest.EC, paramInt, false);
    b.F(paramParcel, i);
  }
  
  public CreateFileIntentSenderRequest H(Parcel paramParcel)
  {
    int i = 0;
    DriveId localDriveId = null;
    int k = a.o(paramParcel);
    String str = null;
    MetadataBundle localMetadataBundle = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.n(paramParcel);
      switch (a.R(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        localMetadataBundle = (MetadataBundle)a.a(paramParcel, m, MetadataBundle.CREATOR);
        break;
      case 3: 
        i = a.g(paramParcel, m);
        break;
      case 4: 
        str = a.n(paramParcel, m);
        break;
      case 5: 
        localDriveId = (DriveId)a.a(paramParcel, m, DriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new CreateFileIntentSenderRequest(j, localMetadataBundle, i, str, localDriveId);
  }
  
  public CreateFileIntentSenderRequest[] al(int paramInt)
  {
    return new CreateFileIntentSenderRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */