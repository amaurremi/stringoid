package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class j
  implements Parcelable.Creator<CreateFileRequest>
{
  static void a(CreateFileRequest paramCreateFileRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramCreateFileRequest.xJ);
    b.a(paramParcel, 2, paramCreateFileRequest.IC, paramInt, false);
    b.a(paramParcel, 3, paramCreateFileRequest.IA, paramInt, false);
    b.a(paramParcel, 4, paramCreateFileRequest.It, paramInt, false);
    b.a(paramParcel, 5, paramCreateFileRequest.IB, false);
    b.a(paramParcel, 6, paramCreateFileRequest.IE);
    b.a(paramParcel, 7, paramCreateFileRequest.Iv, false);
    b.G(paramParcel, i);
  }
  
  public CreateFileRequest Y(Parcel paramParcel)
  {
    boolean bool = false;
    String str = null;
    int j = a.B(paramParcel);
    Integer localInteger = null;
    Contents localContents = null;
    MetadataBundle localMetadataBundle = null;
    DriveId localDriveId = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        localDriveId = (DriveId)a.a(paramParcel, k, DriveId.CREATOR);
        break;
      case 3: 
        localMetadataBundle = (MetadataBundle)a.a(paramParcel, k, MetadataBundle.CREATOR);
        break;
      case 4: 
        localContents = (Contents)a.a(paramParcel, k, Contents.CREATOR);
        break;
      case 5: 
        localInteger = a.h(paramParcel, k);
        break;
      case 6: 
        bool = a.c(paramParcel, k);
        break;
      case 7: 
        str = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new CreateFileRequest(i, localDriveId, localMetadataBundle, localContents, localInteger, bool, str);
  }
  
  public CreateFileRequest[] aU(int paramInt)
  {
    return new CreateFileRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/internal/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */