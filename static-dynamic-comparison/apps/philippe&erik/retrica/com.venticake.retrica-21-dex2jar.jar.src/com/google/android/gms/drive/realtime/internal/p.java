package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class p
  implements Parcelable.Creator<ParcelableCollaborator>
{
  static void a(ParcelableCollaborator paramParcelableCollaborator, Parcel paramParcel, int paramInt)
  {
    paramInt = b.C(paramParcel);
    b.c(paramParcel, 1, paramParcelableCollaborator.xM);
    b.a(paramParcel, 2, paramParcelableCollaborator.Lk);
    b.a(paramParcel, 3, paramParcelableCollaborator.Ll);
    b.a(paramParcel, 4, paramParcelableCollaborator.rR, false);
    b.a(paramParcel, 5, paramParcelableCollaborator.Lm, false);
    b.a(paramParcel, 6, paramParcelableCollaborator.Ln, false);
    b.a(paramParcel, 7, paramParcelableCollaborator.Lo, false);
    b.a(paramParcel, 8, paramParcelableCollaborator.Lp, false);
    b.G(paramParcel, paramInt);
  }
  
  public ParcelableCollaborator aR(Parcel paramParcel)
  {
    boolean bool1 = false;
    String str1 = null;
    int j = a.B(paramParcel);
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    boolean bool2 = false;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        bool2 = a.c(paramParcel, k);
        break;
      case 3: 
        bool1 = a.c(paramParcel, k);
        break;
      case 4: 
        str5 = a.o(paramParcel, k);
        break;
      case 5: 
        str4 = a.o(paramParcel, k);
        break;
      case 6: 
        str3 = a.o(paramParcel, k);
        break;
      case 7: 
        str2 = a.o(paramParcel, k);
        break;
      case 8: 
        str1 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new ParcelableCollaborator(i, bool2, bool1, str5, str4, str3, str2, str1);
  }
  
  public ParcelableCollaborator[] bO(int paramInt)
  {
    return new ParcelableCollaborator[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */