package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ah
  implements Parcelable.Creator<OnDownloadProgressResponse>
{
  static void a(OnDownloadProgressResponse paramOnDownloadProgressResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramOnDownloadProgressResponse.xJ);
    b.a(paramParcel, 2, paramOnDownloadProgressResponse.Jt);
    b.a(paramParcel, 3, paramOnDownloadProgressResponse.Ju);
    b.G(paramParcel, paramInt);
  }
  
  public OnDownloadProgressResponse ai(Parcel paramParcel)
  {
    long l1 = 0L;
    int j = a.B(paramParcel);
    int i = 0;
    long l2 = 0L;
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
        l2 = a.i(paramParcel, k);
        break;
      case 3: 
        l1 = a.i(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new OnDownloadProgressResponse(i, l2, l1);
  }
  
  public OnDownloadProgressResponse[] be(int paramInt)
  {
    return new OnDownloadProgressResponse[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/internal/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */