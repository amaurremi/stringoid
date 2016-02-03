package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class c
  implements Parcelable.Creator<TurnBasedMatchEntity>
{
  static void a(TurnBasedMatchEntity paramTurnBasedMatchEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.k(paramParcel);
    b.a(paramParcel, 1, paramTurnBasedMatchEntity.nX(), paramInt, false);
    b.a(paramParcel, 2, paramTurnBasedMatchEntity.ot(), false);
    b.a(paramParcel, 3, paramTurnBasedMatchEntity.op(), false);
    b.a(paramParcel, 4, paramTurnBasedMatchEntity.oa());
    b.a(paramParcel, 5, paramTurnBasedMatchEntity.ov(), false);
    b.a(paramParcel, 6, paramTurnBasedMatchEntity.ow());
    b.a(paramParcel, 7, paramTurnBasedMatchEntity.ox(), false);
    b.c(paramParcel, 8, paramTurnBasedMatchEntity.getStatus());
    b.c(paramParcel, 10, paramTurnBasedMatchEntity.oc());
    b.c(paramParcel, 11, paramTurnBasedMatchEntity.getVersion());
    b.a(paramParcel, 12, paramTurnBasedMatchEntity.getData(), false);
    b.b(paramParcel, 13, paramTurnBasedMatchEntity.oe(), false);
    b.a(paramParcel, 14, paramTurnBasedMatchEntity.oy(), false);
    b.a(paramParcel, 15, paramTurnBasedMatchEntity.oz(), false);
    b.a(paramParcel, 17, paramTurnBasedMatchEntity.oq(), false);
    b.c(paramParcel, 16, paramTurnBasedMatchEntity.oA());
    b.c(paramParcel, 1000, paramTurnBasedMatchEntity.lX());
    b.a(paramParcel, 19, paramTurnBasedMatchEntity.oB());
    b.c(paramParcel, 18, paramTurnBasedMatchEntity.ou());
    b.a(paramParcel, 21, paramTurnBasedMatchEntity.oC(), false);
    b.a(paramParcel, 20, paramTurnBasedMatchEntity.getDescription(), false);
    b.D(paramParcel, i);
  }
  
  public TurnBasedMatchEntity ad(Parcel paramParcel)
  {
    int i2 = a.j(paramParcel);
    int i1 = 0;
    GameEntity localGameEntity = null;
    String str7 = null;
    String str6 = null;
    long l2 = 0L;
    String str5 = null;
    long l1 = 0L;
    String str4 = null;
    int n = 0;
    int m = 0;
    int k = 0;
    byte[] arrayOfByte2 = null;
    ArrayList localArrayList = null;
    String str3 = null;
    byte[] arrayOfByte1 = null;
    int j = 0;
    Bundle localBundle = null;
    int i = 0;
    boolean bool = false;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < i2)
    {
      int i3 = a.i(paramParcel);
      switch (a.br(i3))
      {
      default: 
        a.b(paramParcel, i3);
        break;
      case 1: 
        localGameEntity = (GameEntity)a.a(paramParcel, i3, GameEntity.CREATOR);
        break;
      case 2: 
        str7 = a.m(paramParcel, i3);
        break;
      case 3: 
        str6 = a.m(paramParcel, i3);
        break;
      case 4: 
        l2 = a.h(paramParcel, i3);
        break;
      case 5: 
        str5 = a.m(paramParcel, i3);
        break;
      case 6: 
        l1 = a.h(paramParcel, i3);
        break;
      case 7: 
        str4 = a.m(paramParcel, i3);
        break;
      case 8: 
        n = a.g(paramParcel, i3);
        break;
      case 10: 
        m = a.g(paramParcel, i3);
        break;
      case 11: 
        k = a.g(paramParcel, i3);
        break;
      case 12: 
        arrayOfByte2 = a.p(paramParcel, i3);
        break;
      case 13: 
        localArrayList = a.c(paramParcel, i3, ParticipantEntity.CREATOR);
        break;
      case 14: 
        str3 = a.m(paramParcel, i3);
        break;
      case 15: 
        arrayOfByte1 = a.p(paramParcel, i3);
        break;
      case 17: 
        localBundle = a.o(paramParcel, i3);
        break;
      case 16: 
        j = a.g(paramParcel, i3);
        break;
      case 1000: 
        i1 = a.g(paramParcel, i3);
        break;
      case 19: 
        bool = a.c(paramParcel, i3);
        break;
      case 18: 
        i = a.g(paramParcel, i3);
        break;
      case 21: 
        str1 = a.m(paramParcel, i3);
        break;
      case 20: 
        str2 = a.m(paramParcel, i3);
      }
    }
    if (paramParcel.dataPosition() != i2) {
      throw new a.a("Overread allowed size end=" + i2, paramParcel);
    }
    return new TurnBasedMatchEntity(i1, localGameEntity, str7, str6, l2, str5, l1, str4, n, m, k, arrayOfByte2, localArrayList, str3, arrayOfByte1, j, localBundle, i, bool, str2, str1);
  }
  
  public TurnBasedMatchEntity[] cm(int paramInt)
  {
    return new TurnBasedMatchEntity[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */