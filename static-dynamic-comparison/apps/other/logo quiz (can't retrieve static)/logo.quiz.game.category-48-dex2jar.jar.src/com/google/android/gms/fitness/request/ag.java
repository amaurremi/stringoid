package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ag
  implements Parcelable.Creator<UnclaimBleDeviceRequest>
{
  static void a(UnclaimBleDeviceRequest paramUnclaimBleDeviceRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = b.D(paramParcel);
    b.c(paramParcel, 1000, paramUnclaimBleDeviceRequest.getVersionCode());
    b.a(paramParcel, 2, paramUnclaimBleDeviceRequest.getDeviceAddress(), false);
    b.H(paramParcel, paramInt);
  }
  
  public UnclaimBleDeviceRequest bT(Parcel paramParcel)
  {
    int j = a.C(paramParcel);
    int i = 0;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new UnclaimBleDeviceRequest(i, str);
  }
  
  public UnclaimBleDeviceRequest[] dl(int paramInt)
  {
    return new UnclaimBleDeviceRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/fitness/request/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */