package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class MostRecentGameInfoEntityCreator
  implements Parcelable.Creator<MostRecentGameInfoEntity>
{
  static void a(MostRecentGameInfoEntity paramMostRecentGameInfoEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.C(paramParcel);
    b.a(paramParcel, 1, paramMostRecentGameInfoEntity.ik(), false);
    b.c(paramParcel, 1000, paramMostRecentGameInfoEntity.getVersionCode());
    b.a(paramParcel, 2, paramMostRecentGameInfoEntity.il(), false);
    b.a(paramParcel, 3, paramMostRecentGameInfoEntity.im());
    b.a(paramParcel, 4, paramMostRecentGameInfoEntity.in(), paramInt, false);
    b.a(paramParcel, 5, paramMostRecentGameInfoEntity.io(), paramInt, false);
    b.a(paramParcel, 6, paramMostRecentGameInfoEntity.ip(), paramInt, false);
    b.G(paramParcel, i);
  }
  
  public MostRecentGameInfoEntity bj(Parcel paramParcel)
  {
    Uri localUri1 = null;
    int j = a.B(paramParcel);
    int i = 0;
    long l = 0L;
    Uri localUri2 = null;
    Uri localUri3 = null;
    String str1 = null;
    String str2 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.A(paramParcel);
      switch (a.ar(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        str2 = a.o(paramParcel, k);
        break;
      case 1000: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str1 = a.o(paramParcel, k);
        break;
      case 3: 
        l = a.i(paramParcel, k);
        break;
      case 4: 
        localUri3 = (Uri)a.a(paramParcel, k, Uri.CREATOR);
        break;
      case 5: 
        localUri2 = (Uri)a.a(paramParcel, k, Uri.CREATOR);
        break;
      case 6: 
        localUri1 = (Uri)a.a(paramParcel, k, Uri.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new MostRecentGameInfoEntity(i, str2, str1, l, localUri3, localUri2, localUri1);
  }
  
  public MostRecentGameInfoEntity[] cu(int paramInt)
  {
    return new MostRecentGameInfoEntity[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/player/MostRecentGameInfoEntityCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */