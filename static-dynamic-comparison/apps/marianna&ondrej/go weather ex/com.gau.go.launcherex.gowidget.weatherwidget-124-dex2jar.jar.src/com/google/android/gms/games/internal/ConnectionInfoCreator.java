package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ConnectionInfoCreator
  implements Parcelable.Creator<ConnectionInfo>
{
  static void a(ConnectionInfo paramConnectionInfo, Parcel paramParcel, int paramInt)
  {
    paramInt = b.p(paramParcel);
    b.a(paramParcel, 1, paramConnectionInfo.gi(), false);
    b.c(paramParcel, 1000, paramConnectionInfo.getVersionCode());
    b.c(paramParcel, 2, paramConnectionInfo.gj());
    b.F(paramParcel, paramInt);
  }
  
  public ConnectionInfo[] aW(int paramInt)
  {
    return new ConnectionInfo[paramInt];
  }
  
  public ConnectionInfo ap(Parcel paramParcel)
  {
    int j = 0;
    int k = a.o(paramParcel);
    String str = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.n(paramParcel);
      switch (a.R(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        str = a.n(paramParcel, m);
        break;
      case 1000: 
        i = a.g(paramParcel, m);
        break;
      case 2: 
        j = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new ConnectionInfo(i, str, j);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/games/internal/ConnectionInfoCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */