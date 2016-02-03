package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class i
  implements Parcelable.Creator<LineItem>
{
  static void a(LineItem paramLineItem, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.c(paramParcel, 1, paramLineItem.lX());
    b.a(paramParcel, 2, paramLineItem.description, false);
    b.a(paramParcel, 3, paramLineItem.YG, false);
    b.a(paramParcel, 4, paramLineItem.YH, false);
    b.a(paramParcel, 5, paramLineItem.Yq, false);
    b.c(paramParcel, 6, paramLineItem.YI);
    b.a(paramParcel, 7, paramLineItem.Yr, false);
    b.D(paramParcel, paramInt);
  }
  
  public LineItem bE(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int k = a.j(paramParcel);
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.i(paramParcel);
      switch (a.br(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        str5 = a.m(paramParcel, m);
        break;
      case 3: 
        str4 = a.m(paramParcel, m);
        break;
      case 4: 
        str3 = a.m(paramParcel, m);
        break;
      case 5: 
        str2 = a.m(paramParcel, m);
        break;
      case 6: 
        i = a.g(paramParcel, m);
        break;
      case 7: 
        str1 = a.m(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new LineItem(j, str5, str4, str3, str2, i, str1);
  }
  
  public LineItem[] ew(int paramInt)
  {
    return new LineItem[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/wallet/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */