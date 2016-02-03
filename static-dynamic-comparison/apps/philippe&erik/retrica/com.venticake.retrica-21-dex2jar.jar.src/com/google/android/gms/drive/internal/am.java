package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class am
  implements Parcelable.Creator<OnMetadataResponse>
{
  static void a(OnMetadataResponse paramOnMetadataResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramOnMetadataResponse.xM);
    b.a(paramParcel, 2, paramOnMetadataResponse.IE, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public OnMetadataResponse an(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    MetadataBundle localMetadataBundle = null;
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
        localMetadataBundle = (MetadataBundle)a.a(paramParcel, k, MetadataBundle.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new OnMetadataResponse(i, localMetadataBundle);
  }
  
  public OnMetadataResponse[] bj(int paramInt)
  {
    return new OnMetadataResponse[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */