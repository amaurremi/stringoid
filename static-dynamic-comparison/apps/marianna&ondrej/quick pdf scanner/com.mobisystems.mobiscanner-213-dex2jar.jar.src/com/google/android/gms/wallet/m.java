package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class m
  implements Parcelable.Creator<NotifyTransactionStatusRequest>
{
  static void a(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.c(paramParcel, 1, paramNotifyTransactionStatusRequest.qh);
    b.a(paramParcel, 2, paramNotifyTransactionStatusRequest.Yt, false);
    b.c(paramParcel, 3, paramNotifyTransactionStatusRequest.status);
    b.a(paramParcel, 4, paramNotifyTransactionStatusRequest.Zp, false);
    b.D(paramParcel, paramInt);
  }
  
  public NotifyTransactionStatusRequest bI(Parcel paramParcel)
  {
    String str2 = null;
    int j = 0;
    int k = a.j(paramParcel);
    String str1 = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.i(paramParcel);
      switch (a.br(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        i = a.g(paramParcel, m);
        break;
      case 2: 
        str1 = a.m(paramParcel, m);
        break;
      case 3: 
        j = a.g(paramParcel, m);
        break;
      case 4: 
        str2 = a.m(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new NotifyTransactionStatusRequest(i, str1, j, str2);
  }
  
  public NotifyTransactionStatusRequest[] eA(int paramInt)
  {
    return new NotifyTransactionStatusRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/wallet/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */