package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class h
  implements Parcelable.Creator<ValuesAddedDetails>
{
  static void a(ValuesAddedDetails paramValuesAddedDetails, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramValuesAddedDetails.xJ);
    b.c(paramParcel, 2, paramValuesAddedDetails.mIndex);
    b.c(paramParcel, 3, paramValuesAddedDetails.LC);
    b.c(paramParcel, 4, paramValuesAddedDetails.LD);
    b.a(paramParcel, 5, paramValuesAddedDetails.LK, false);
    b.c(paramParcel, 6, paramValuesAddedDetails.LL);
    b.G(paramParcel, paramInt);
  }
  
  public ValuesAddedDetails[] bX(int paramInt)
  {
    return new ValuesAddedDetails[paramInt];
  }
  
  public ValuesAddedDetails ba(Parcel paramParcel)
  {
    int i = 0;
    int i1 = a.B(paramParcel);
    String str = null;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    while (paramParcel.dataPosition() < i1)
    {
      int i2 = a.A(paramParcel);
      switch (a.ar(i2))
      {
      default: 
        a.b(paramParcel, i2);
        break;
      case 1: 
        n = a.g(paramParcel, i2);
        break;
      case 2: 
        m = a.g(paramParcel, i2);
        break;
      case 3: 
        k = a.g(paramParcel, i2);
        break;
      case 4: 
        j = a.g(paramParcel, i2);
        break;
      case 5: 
        str = a.o(paramParcel, i2);
        break;
      case 6: 
        i = a.g(paramParcel, i2);
      }
    }
    if (paramParcel.dataPosition() != i1) {
      throw new a.a("Overread allowed size end=" + i1, paramParcel);
    }
    return new ValuesAddedDetails(n, m, k, j, str, i);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */