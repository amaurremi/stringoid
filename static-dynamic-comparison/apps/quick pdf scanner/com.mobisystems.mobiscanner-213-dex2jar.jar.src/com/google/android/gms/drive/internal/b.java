package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;

public class b
  implements Parcelable.Creator<OnDownloadProgressResponse>
{
  static void a(OnDownloadProgressResponse paramOnDownloadProgressResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.b.k(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1, paramOnDownloadProgressResponse.qh);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramOnDownloadProgressResponse.tm);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramOnDownloadProgressResponse.tn);
    com.google.android.gms.common.internal.safeparcel.b.D(paramParcel, paramInt);
  }
  
  public OnDownloadProgressResponse[] by(int paramInt)
  {
    return new OnDownloadProgressResponse[paramInt];
  }
  
  public OnDownloadProgressResponse q(Parcel paramParcel)
  {
    long l1 = 0L;
    int j = a.j(paramParcel);
    int i = 0;
    long l2 = 0L;
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
        l2 = a.h(paramParcel, k);
        break;
      case 3: 
        l1 = a.h(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new OnDownloadProgressResponse(i, l2, l1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/drive/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */