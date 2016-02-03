package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class f
  implements Parcelable.Creator<TextInsertedDetails>
{
  static void a(TextInsertedDetails paramTextInsertedDetails, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramTextInsertedDetails.xJ);
    b.c(paramParcel, 2, paramTextInsertedDetails.mIndex);
    b.c(paramParcel, 3, paramTextInsertedDetails.LI);
    b.G(paramParcel, paramInt);
  }
  
  public TextInsertedDetails aY(Parcel paramParcel)
  {
    int k = 0;
    int m = a.B(paramParcel);
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.A(paramParcel);
      switch (a.ar(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        i = a.g(paramParcel, n);
        break;
      case 2: 
        j = a.g(paramParcel, n);
        break;
      case 3: 
        k = a.g(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new TextInsertedDetails(i, j, k);
  }
  
  public TextInsertedDetails[] bV(int paramInt)
  {
    return new TextInsertedDetails[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */