package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;

public class ag
  implements Parcelable.Creator<OnContentsResponse>
{
  static void a(OnContentsResponse paramOnContentsResponse, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramOnContentsResponse.xM);
    b.a(paramParcel, 2, paramOnContentsResponse.HG, paramInt, false);
    b.G(paramParcel, i);
  }
  
  public OnContentsResponse ah(Parcel paramParcel)
  {
    int j = a.B(paramParcel);
    int i = 0;
    Contents localContents = null;
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
        localContents = (Contents)a.a(paramParcel, k, Contents.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new OnContentsResponse(i, localContents);
  }
  
  public OnContentsResponse[] bd(int paramInt)
  {
    return new OnContentsResponse[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */