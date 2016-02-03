package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.drive.Contents;

public class b
  implements Parcelable.Creator<CloseContentsRequest>
{
  static void a(CloseContentsRequest paramCloseContentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.o(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramCloseContentsRequest.kg);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramCloseContentsRequest.qX, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramCloseContentsRequest.qY, false);
    com.google.android.gms.common.internal.safeparcel.b.D(paramParcel, i);
  }
  
  public CloseContentsRequest A(Parcel paramParcel)
  {
    Boolean localBoolean = null;
    int j = a.n(paramParcel);
    int i = 0;
    Contents localContents = null;
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
        localContents = (Contents)a.a(paramParcel, k, Contents.CREATOR);
        continue;
        localBoolean = a.d(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new CloseContentsRequest(i, localContents, localBoolean);
  }
  
  public CloseContentsRequest[] aa(int paramInt)
  {
    return new CloseContentsRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/drive/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */