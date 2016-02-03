package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import java.util.ArrayList;

public class b
  implements Parcelable.Creator
{
  static void a(Cart paramCart, Parcel paramParcel, int paramInt)
  {
    paramInt = c.a(paramParcel);
    c.a(paramParcel, 1, paramCart.a());
    c.a(paramParcel, 2, paramCart.a, false);
    c.a(paramParcel, 3, paramCart.b, false);
    c.b(paramParcel, 4, paramCart.c, false);
    c.a(paramParcel, paramInt);
  }
  
  public Cart a(Parcel paramParcel)
  {
    String str2 = null;
    int j = a.b(paramParcel);
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.a(paramParcel);
      switch (a.a(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.f(paramParcel, k);
        break;
      case 2: 
        str1 = a.l(paramParcel, k);
        break;
      case 3: 
        str2 = a.l(paramParcel, k);
        break;
      case 4: 
        localArrayList = a.c(paramParcel, k, LineItem.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + j, paramParcel);
    }
    return new Cart(i, str1, str2, localArrayList);
  }
  
  public Cart[] a(int paramInt)
  {
    return new Cart[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/wallet/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */