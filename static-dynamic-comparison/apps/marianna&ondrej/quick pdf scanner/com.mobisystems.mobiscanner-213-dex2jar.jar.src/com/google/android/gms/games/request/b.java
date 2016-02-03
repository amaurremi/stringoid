package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;

public class b
  implements Parcelable.Creator<GameRequestEntity>
{
  static void a(GameRequestEntity paramGameRequestEntity, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.b.k(paramParcel);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 1, paramGameRequestEntity.nX(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 1000, paramGameRequestEntity.lX());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 2, paramGameRequestEntity.oF(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 3, paramGameRequestEntity.getData(), false);
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 4, paramGameRequestEntity.oE(), false);
    com.google.android.gms.common.internal.safeparcel.b.b(paramParcel, 5, paramGameRequestEntity.oG(), false);
    com.google.android.gms.common.internal.safeparcel.b.c(paramParcel, 7, paramGameRequestEntity.getType());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 9, paramGameRequestEntity.oa());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 10, paramGameRequestEntity.oH());
    com.google.android.gms.common.internal.safeparcel.b.a(paramParcel, 11, paramGameRequestEntity.oI(), false);
    com.google.android.gms.common.internal.safeparcel.b.D(paramParcel, i);
  }
  
  public GameRequestEntity ae(Parcel paramParcel)
  {
    int k = a.j(paramParcel);
    int j = 0;
    GameEntity localGameEntity = null;
    PlayerEntity localPlayerEntity = null;
    byte[] arrayOfByte = null;
    String str = null;
    ArrayList localArrayList = null;
    int i = 0;
    long l2 = 0L;
    long l1 = 0L;
    Bundle localBundle = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = a.i(paramParcel);
      switch (a.br(m))
      {
      default: 
        a.b(paramParcel, m);
        break;
      case 1: 
        localGameEntity = (GameEntity)a.a(paramParcel, m, GameEntity.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, m);
        break;
      case 2: 
        localPlayerEntity = (PlayerEntity)a.a(paramParcel, m, PlayerEntity.CREATOR);
        break;
      case 3: 
        arrayOfByte = a.p(paramParcel, m);
        break;
      case 4: 
        str = a.m(paramParcel, m);
        break;
      case 5: 
        localArrayList = a.c(paramParcel, m, PlayerEntity.CREATOR);
        break;
      case 7: 
        i = a.g(paramParcel, m);
        break;
      case 9: 
        l2 = a.h(paramParcel, m);
        break;
      case 10: 
        l1 = a.h(paramParcel, m);
        break;
      case 11: 
        localBundle = a.o(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new a.a("Overread allowed size end=" + k, paramParcel);
    }
    return new GameRequestEntity(j, localGameEntity, localPlayerEntity, arrayOfByte, str, localArrayList, i, l2, l1, localBundle);
  }
  
  public GameRequestEntity[] cn(int paramInt)
  {
    return new GameRequestEntity[paramInt];
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/games/request/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */