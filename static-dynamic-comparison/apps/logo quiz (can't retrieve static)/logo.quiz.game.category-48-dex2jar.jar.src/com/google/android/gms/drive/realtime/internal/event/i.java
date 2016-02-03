package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class i
  implements Parcelable.Creator<ValuesRemovedDetails>
{
  static void a(ValuesRemovedDetails paramValuesRemovedDetails, Parcel paramParcel, int paramInt)
  {
    paramInt = b.D(paramParcel);
    b.c(paramParcel, 1, paramValuesRemovedDetails.BR);
    b.c(paramParcel, 2, paramValuesRemovedDetails.mIndex);
    b.c(paramParcel, 3, paramValuesRemovedDetails.Rj);
    b.c(paramParcel, 4, paramValuesRemovedDetails.Rk);
    b.a(paramParcel, 5, paramValuesRemovedDetails.RH, false);
    b.c(paramParcel, 6, paramValuesRemovedDetails.RI);
    b.H(paramParcel, paramInt);
  }
  
  public ValuesRemovedDetails bg(Parcel paramParcel)
  {
    int i = 0;
    int i1 = a.C(paramParcel);
    String str = null;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    while (paramParcel.dataPosition() < i1)
    {
      int i2 = a.B(paramParcel);
      switch (a.aD(i2))
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
    return new ValuesRemovedDetails(n, m, k, j, str, i);
  }
  
  public ValuesRemovedDetails[] ct(int paramInt)
  {
    return new ValuesRemovedDetails[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */