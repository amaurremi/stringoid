package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class i
  implements Parcelable.Creator<CreateFileIntentSenderRequest>
{
  static void a(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramCreateFileIntentSenderRequest.xJ);
    b.a(paramParcel, 2, paramCreateFileIntentSenderRequest.IA, paramInt, false);
    b.c(paramParcel, 3, paramCreateFileIntentSenderRequest.qX);
    b.a(paramParcel, 4, paramCreateFileIntentSenderRequest.HV, false);
    b.a(paramParcel, 5, paramCreateFileIntentSenderRequest.HX, paramInt, false);
    b.a(paramParcel, 6, paramCreateFileIntentSenderRequest.IB, false);
    b.G(paramParcel, i);
  }
  
  public CreateFileIntentSenderRequest X(Parcel paramParcel)
  {
    int i = 0;
    Integer localInteger = null;
    int k = a.B(paramParcel);
    DriveId localDriveId = null;
    String str = null;
    MetadataBundle localMetadataBundle = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.A(paramParcel);
      switch (a.ar(m))
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
        str = a.o(paramParcel, m);
        break;
      case 5: 
        localDriveId = (DriveId)a.a(paramParcel, m, DriveId.CREATOR);
        break;
      case 6: 
        localInteger = a.h(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new CreateFileIntentSenderRequest(j, localMetadataBundle, i, str, localDriveId, localInteger);
  }
  
  public CreateFileIntentSenderRequest[] aT(int paramInt)
  {
    return new CreateFileIntentSenderRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */