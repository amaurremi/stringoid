package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class js
  implements Parcelable.Creator<jr>
{
  static void a(jr paramjr, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.c(paramParcel, 1000, paramjr.xJ);
    b.a(paramParcel, 2, paramjr.ja(), paramInt, false);
    b.a(paramParcel, 3, paramjr.getInterval());
    b.c(paramParcel, 4, paramjr.getPriority());
    b.G(paramParcel, i);
  }
  
  public jr bx(Parcel paramParcel)
  {
    int k = a.B(paramParcel);
    int j = 0;
    jn localjn = null;
    long l = jr.Wj;
    int i = 102;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.A(paramParcel);
      switch (a.ar(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1000: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        localjn = (jn)a.a(paramParcel, m, jn.CREATOR);
        break;
      case 3: 
        l = a.i(paramParcel, m);
        break;
      case 4: 
        i = a.g(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new jr(j, localjn, l, i);
  }
  
  public jr[] cS(int paramInt)
  {
    return new jr[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/js.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */