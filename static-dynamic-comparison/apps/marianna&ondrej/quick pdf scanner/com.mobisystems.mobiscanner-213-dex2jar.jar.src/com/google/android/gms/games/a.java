package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class a
  implements Parcelable.Creator<GameEntity>
{
  static void a(GameEntity paramGameEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.a(paramParcel, 1, paramGameEntity.lY(), false);
    b.a(paramParcel, 2, paramGameEntity.getDisplayName(), false);
    b.a(paramParcel, 3, paramGameEntity.nz(), false);
    b.a(paramParcel, 4, paramGameEntity.nA(), false);
    b.a(paramParcel, 5, paramGameEntity.getDescription(), false);
    b.a(paramParcel, 6, paramGameEntity.nB(), false);
    b.a(paramParcel, 7, paramGameEntity.nC(), paramInt, false);
    b.a(paramParcel, 8, paramGameEntity.nE(), paramInt, false);
    b.a(paramParcel, 9, paramGameEntity.nG(), paramInt, false);
    b.a(paramParcel, 10, paramGameEntity.nI());
    b.a(paramParcel, 11, paramGameEntity.nJ());
    b.a(paramParcel, 12, paramGameEntity.nK(), false);
    b.c(paramParcel, 13, paramGameEntity.nL());
    b.c(paramParcel, 14, paramGameEntity.nM());
    b.c(paramParcel, 15, paramGameEntity.nN());
    b.a(paramParcel, 17, paramGameEntity.nP());
    b.a(paramParcel, 16, paramGameEntity.nO());
    b.c(paramParcel, 1000, paramGameEntity.lX());
    b.a(paramParcel, 19, paramGameEntity.nF(), false);
    b.a(paramParcel, 18, paramGameEntity.nD(), false);
    b.a(paramParcel, 21, paramGameEntity.isMuted());
    b.a(paramParcel, 20, paramGameEntity.nH(), false);
    b.D(paramParcel, i);
  }
  
  public GameEntity W(Parcel paramParcel)
  {
    int n = com.google.android.gms.common.internal.safeparcel.a.j(paramParcel);
    int m = 0;
    String str10 = null;
    String str9 = null;
    String str8 = null;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    Uri localUri3 = null;
    Uri localUri2 = null;
    Uri localUri1 = null;
    boolean bool5 = false;
    boolean bool4 = false;
    String str4 = null;
    int k = 0;
    int j = 0;
    int i = 0;
    boolean bool3 = false;
    boolean bool2 = false;
    String str3 = null;
    String str2 = null;
    String str1 = null;
    boolean bool1 = false;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.br(i1))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, i1);
        break;
      case 1: 
        str10 = com.google.android.gms.common.internal.safeparcel.a.m(paramParcel, i1);
        break;
      case 2: 
        str9 = com.google.android.gms.common.internal.safeparcel.a.m(paramParcel, i1);
        break;
      case 3: 
        str8 = com.google.android.gms.common.internal.safeparcel.a.m(paramParcel, i1);
        break;
      case 4: 
        str7 = com.google.android.gms.common.internal.safeparcel.a.m(paramParcel, i1);
        break;
      case 5: 
        str6 = com.google.android.gms.common.internal.safeparcel.a.m(paramParcel, i1);
        break;
      case 6: 
        str5 = com.google.android.gms.common.internal.safeparcel.a.m(paramParcel, i1);
        break;
      case 7: 
        localUri3 = (Uri)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, i1, Uri.CREATOR);
        break;
      case 8: 
        localUri2 = (Uri)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, i1, Uri.CREATOR);
        break;
      case 9: 
        localUri1 = (Uri)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, i1, Uri.CREATOR);
        break;
      case 10: 
        bool5 = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, i1);
        break;
      case 11: 
        bool4 = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, i1);
        break;
      case 12: 
        str4 = com.google.android.gms.common.internal.safeparcel.a.m(paramParcel, i1);
        break;
      case 13: 
        k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, i1);
        break;
      case 14: 
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, i1);
        break;
      case 15: 
        i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, i1);
        break;
      case 17: 
        bool2 = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, i1);
        break;
      case 16: 
        bool3 = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, i1);
        break;
      case 1000: 
        m = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, i1);
        break;
      case 19: 
        str2 = com.google.android.gms.common.internal.safeparcel.a.m(paramParcel, i1);
        break;
      case 18: 
        str3 = com.google.android.gms.common.internal.safeparcel.a.m(paramParcel, i1);
        break;
      case 21: 
        bool1 = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, i1);
        break;
      case 20: 
        str1 = com.google.android.gms.common.internal.safeparcel.a.m(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new a.a("Overread allowed size end=" + n, paramParcel);
    }
    return new GameEntity(m, str10, str9, str8, str7, str6, str5, localUri3, localUri2, localUri1, bool5, bool4, str4, k, j, i, bool3, bool2, str3, str2, str1, bool1);
  }
  
  public GameEntity[] cf(int paramInt)
  {
    return new GameEntity[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */