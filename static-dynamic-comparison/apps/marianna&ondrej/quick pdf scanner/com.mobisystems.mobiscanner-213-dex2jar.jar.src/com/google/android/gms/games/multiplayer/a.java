package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class a
  implements Parcelable.Creator<ParticipantResult>
{
  static void a(ParticipantResult paramParticipantResult, Parcel paramParcel, int paramInt)
  {
    paramInt = b.k(paramParcel);
    b.a(paramParcel, 1, paramParticipantResult.oi(), false);
    b.c(paramParcel, 1000, paramParticipantResult.lX());
    b.c(paramParcel, 2, paramParticipantResult.om());
    b.c(paramParcel, 3, paramParticipantResult.on());
    b.D(paramParcel, paramInt);
  }
  
  public ParticipantResult aa(Parcel paramParcel)
  {
    int k = 0;
    int m = com.google.android.gms.common.internal.safeparcel.a.j(paramParcel);
    String str = null;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.br(n))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, n);
        break;
      case 1: 
        str = com.google.android.gms.common.internal.safeparcel.a.m(paramParcel, n);
        break;
      case 1000: 
        i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
        break;
      case 2: 
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
        break;
      case 3: 
        k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new ParticipantResult(i, str, j, k);
  }
  
  public ParticipantResult[] ch(int paramInt)
  {
    return new ParticipantResult[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/multiplayer/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */