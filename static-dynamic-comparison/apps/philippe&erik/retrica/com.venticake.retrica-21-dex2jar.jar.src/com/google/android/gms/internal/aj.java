package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class aj
  implements Parcelable.Creator<ai>
{
  static void a(ai paramai, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1, paramai.versionCode);
    b.a(paramParcel, 2, paramai.lS);
    b.a(paramParcel, 3, paramai.extras, false);
    b.c(paramParcel, 4, paramai.lT);
    b.a(paramParcel, 5, paramai.lU, false);
    b.a(paramParcel, 6, paramai.lV);
    b.c(paramParcel, 7, paramai.lW);
    b.a(paramParcel, 8, paramai.lX);
    b.a(paramParcel, 9, paramai.lY, false);
    b.a(paramParcel, 10, paramai.lZ, paramInt, false);
    b.a(paramParcel, 11, paramai.ma, paramInt, false);
    b.a(paramParcel, 12, paramai.mb, false);
    b.a(paramParcel, 13, paramai.mc, false);
    b.G(paramParcel, i);
  }
  
  public ai b(Parcel paramParcel)
  {
    int m = a.B(paramParcel);
    int k = 0;
    long l = 0L;
    Bundle localBundle2 = null;
    int j = 0;
    ArrayList localArrayList = null;
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = false;
    String str2 = null;
    aw localaw = null;
    Location localLocation = null;
    String str1 = null;
    Bundle localBundle1 = null;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.A(paramParcel);
      switch (a.ar(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        l = a.i(paramParcel, n);
        break;
      case 3: 
        localBundle2 = a.q(paramParcel, n);
        break;
      case 4: 
        j = a.g(paramParcel, n);
        break;
      case 5: 
        localArrayList = a.B(paramParcel, n);
        break;
      case 6: 
        bool2 = a.c(paramParcel, n);
        break;
      case 7: 
        i = a.g(paramParcel, n);
        break;
      case 8: 
        bool1 = a.c(paramParcel, n);
        break;
      case 9: 
        str2 = a.o(paramParcel, n);
        break;
      case 10: 
        localaw = (aw)a.a(paramParcel, n, aw.CREATOR);
        break;
      case 11: 
        localLocation = (Location)a.a(paramParcel, n, Location.CREATOR);
        break;
      case 12: 
        str1 = a.o(paramParcel, n);
        break;
      case 13: 
        localBundle1 = a.q(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new ai(k, l, localBundle2, j, localArrayList, bool2, i, bool1, str2, localaw, localLocation, str1, localBundle1);
  }
  
  public ai[] c(int paramInt)
  {
    return new ai[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */