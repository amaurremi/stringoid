package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d
  implements Parcelable.Creator<ReferenceShiftedDetails>
{
  static void a(ReferenceShiftedDetails paramReferenceShiftedDetails, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramReferenceShiftedDetails.xM);
    b.a(paramParcel, 2, paramReferenceShiftedDetails.LH, false);
    b.a(paramParcel, 3, paramReferenceShiftedDetails.LI, false);
    b.c(paramParcel, 4, paramReferenceShiftedDetails.LJ);
    b.c(paramParcel, 5, paramReferenceShiftedDetails.LK);
    b.G(paramParcel, paramInt);
  }
  
  public ReferenceShiftedDetails aW(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int m = a.B(paramParcel);
    int j = 0;
    String str2 = null;
    int k = 0;
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
        str2 = a.o(paramParcel, n);
        break;
      case 3: 
        str1 = a.o(paramParcel, n);
        break;
      case 4: 
        j = a.g(paramParcel, n);
        break;
      case 5: 
        i = a.g(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new ReferenceShiftedDetails(k, str2, str1, j, i);
  }
  
  public ReferenceShiftedDetails[] bT(int paramInt)
  {
    return new ReferenceShiftedDetails[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */