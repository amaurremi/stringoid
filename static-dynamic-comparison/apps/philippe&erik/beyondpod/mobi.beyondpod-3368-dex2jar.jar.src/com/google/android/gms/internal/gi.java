package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;

public class gi
  implements Parcelable.Creator<gh>
{
  static void a(gh paramgh, Parcel paramParcel, int paramInt)
  {
    paramInt = b.o(paramParcel);
    b.c(paramParcel, 1000, paramgh.getVersionCode());
    b.a(paramParcel, 2, paramgh.isEnabled());
    b.a(paramParcel, 3, paramgh.dD());
    b.a(paramParcel, 4, paramgh.dE());
    b.a(paramParcel, 5, paramgh.dF());
    b.b(paramParcel, 6, paramgh.dG(), false);
    b.D(paramParcel, paramInt);
  }
  
  public gh[] aU(int paramInt)
  {
    return new gh[paramInt];
  }
  
  public gh ah(Parcel paramParcel)
  {
    boolean bool1 = false;
    int j = a.n(paramParcel);
    ArrayList localArrayList = null;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.m(paramParcel);
      switch (a.M(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        bool4 = a.c(paramParcel, k);
        break;
      case 3: 
        bool3 = a.c(paramParcel, k);
        break;
      case 4: 
        bool2 = a.c(paramParcel, k);
        break;
      case 5: 
        bool1 = a.c(paramParcel, k);
        break;
      case 6: 
        localArrayList = a.c(paramParcel, k, el.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new gh(i, bool4, bool3, bool2, bool1, localArrayList);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/gi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */