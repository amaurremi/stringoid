package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.Contents;

public class e
  implements Parcelable.Creator<CloseContentsRequest>
{
  static void a(CloseContentsRequest paramCloseContentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.p(paramParcel);
    b.c(paramParcel, 1, paramCloseContentsRequest.xH);
    b.a(paramParcel, 2, paramCloseContentsRequest.EX, paramInt, false);
    b.a(paramParcel, 3, paramCloseContentsRequest.EY, false);
    b.F(paramParcel, i);
  }
  
  public CloseContentsRequest F(Parcel paramParcel)
  {
    Boolean localBoolean = null;
    int j = a.o(paramParcel);
    int i = 0;
    Contents localContents = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = a.n(paramParcel);
      switch (a.R(k))
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
  
  public CloseContentsRequest[] aj(int paramInt)
  {
    return new CloseContentsRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/drive/internal/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */