package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;

public class a
  implements Parcelable.Creator<UserAddressRequest>
{
  static void a(UserAddressRequest paramUserAddressRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = b.p(paramParcel);
    b.c(paramParcel, 1, paramUserAddressRequest.getVersionCode());
    b.b(paramParcel, 2, paramUserAddressRequest.Ny, false);
    b.F(paramParcel, paramInt);
  }
  
  public UserAddressRequest ay(Parcel paramParcel)
  {
    int j = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.n(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.R(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1: 
        i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 2: 
        localArrayList = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k, CountrySpecification.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new UserAddressRequest(i, localArrayList);
  }
  
  public UserAddressRequest[] bs(int paramInt)
  {
    return new UserAddressRequest[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/identity/intents/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */