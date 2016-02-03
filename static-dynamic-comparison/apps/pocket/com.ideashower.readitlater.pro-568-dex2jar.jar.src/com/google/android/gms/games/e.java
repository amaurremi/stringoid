package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class e
  implements Parcelable.Creator
{
  static void a(GameEntity paramGameEntity, Parcel paramParcel, int paramInt)
  {
    int i = c.a(paramParcel);
    c.a(paramParcel, 1, paramGameEntity.b(), false);
    c.a(paramParcel, 2, paramGameEntity.c(), false);
    c.a(paramParcel, 3, paramGameEntity.d(), false);
    c.a(paramParcel, 4, paramGameEntity.e(), false);
    c.a(paramParcel, 5, paramGameEntity.f(), false);
    c.a(paramParcel, 6, paramGameEntity.g(), false);
    c.a(paramParcel, 7, paramGameEntity.h(), paramInt, false);
    c.a(paramParcel, 8, paramGameEntity.i(), paramInt, false);
    c.a(paramParcel, 9, paramGameEntity.j(), paramInt, false);
    c.a(paramParcel, 10, paramGameEntity.k());
    c.a(paramParcel, 11, paramGameEntity.l());
    c.a(paramParcel, 12, paramGameEntity.m(), false);
    c.a(paramParcel, 13, paramGameEntity.n());
    c.a(paramParcel, 14, paramGameEntity.o());
    c.a(paramParcel, 15, paramGameEntity.p());
    c.a(paramParcel, 1000, paramGameEntity.q());
    c.a(paramParcel, i);
  }
  
  public GameEntity a(Parcel paramParcel)
  {
    int n = a.b(paramParcel);
    int m = 0;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    Uri localUri3 = null;
    Uri localUri2 = null;
    Uri localUri1 = null;
    boolean bool2 = false;
    boolean bool1 = false;
    String str1 = null;
    int k = 0;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = a.a(paramParcel);
      switch (a.a(i1))
      {
      default: 
        a.b(paramParcel, i1);
        break;
      case 1: 
        str7 = a.l(paramParcel, i1);
        break;
      case 2: 
        str6 = a.l(paramParcel, i1);
        break;
      case 3: 
        str5 = a.l(paramParcel, i1);
        break;
      case 4: 
        str4 = a.l(paramParcel, i1);
        break;
      case 5: 
        str3 = a.l(paramParcel, i1);
        break;
      case 6: 
        str2 = a.l(paramParcel, i1);
        break;
      case 7: 
        localUri3 = (Uri)a.a(paramParcel, i1, Uri.CREATOR);
        break;
      case 8: 
        localUri2 = (Uri)a.a(paramParcel, i1, Uri.CREATOR);
        break;
      case 9: 
        localUri1 = (Uri)a.a(paramParcel, i1, Uri.CREATOR);
        break;
      case 10: 
        bool2 = a.c(paramParcel, i1);
        break;
      case 11: 
        bool1 = a.c(paramParcel, i1);
        break;
      case 12: 
        str1 = a.l(paramParcel, i1);
        break;
      case 13: 
        k = a.f(paramParcel, i1);
        break;
      case 14: 
        j = a.f(paramParcel, i1);
        break;
      case 15: 
        i = a.f(paramParcel, i1);
        break;
      case 1000: 
        m = a.f(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new b("Overread allowed size end=" + n, paramParcel);
    }
    return new GameEntity(m, str7, str6, str5, str4, str3, str2, localUri3, localUri2, localUri1, bool2, bool1, str1, k, j, i);
  }
  
  public GameEntity[] a(int paramInt)
  {
    return new GameEntity[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/games/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */