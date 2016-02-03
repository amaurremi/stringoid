package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class h
  implements Parcelable.Creator
{
  static void a(d paramd, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramd.c(), false);
    c.a(paramParcel, 1000, paramd.b());
    c.a(paramParcel, 2, paramd.d(), paramInt, false);
    c.a(paramParcel, 3, paramd.e());
    c.a(paramParcel, 4, paramd.f(), false);
    c.a(paramParcel, i);
  }
  
  public d a(Parcel paramParcel)
  {
    int i = 0;
    Bundle localBundle = null;
    int k = a.b(paramParcel);
    CursorWindow[] arrayOfCursorWindow = null;
    String[] arrayOfString = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.a(paramParcel);
      switch (a.a(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        arrayOfString = a.w(paramParcel, m);
        break;
      case 1000: 
        j = a.f(paramParcel, m);
        break;
      case 2: 
        arrayOfCursorWindow = (CursorWindow[])a.b(paramParcel, m, CursorWindow.CREATOR);
        break;
      case 3: 
        i = a.f(paramParcel, m);
        break;
      case 4: 
        localBundle = a.n(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new b("Overread allowed size end=" + k, paramParcel);
    }
    paramParcel = new d(j, arrayOfString, arrayOfCursorWindow, i, localBundle);
    paramParcel.a();
    return paramParcel;
  }
  
  public d[] a(int paramInt)
  {
    return new d[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/common/data/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */