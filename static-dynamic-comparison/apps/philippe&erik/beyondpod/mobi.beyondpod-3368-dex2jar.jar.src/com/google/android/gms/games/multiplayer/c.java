package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.PlayerEntity;

public class c
  implements Parcelable.Creator<ParticipantEntity>
{
  static void a(ParticipantEntity paramParticipantEntity, Parcel paramParcel, int paramInt)
  {
    int i = b.o(paramParcel);
    b.a(paramParcel, 1, paramParticipantEntity.getParticipantId(), false);
    b.c(paramParcel, 1000, paramParticipantEntity.getVersionCode());
    b.a(paramParcel, 2, paramParticipantEntity.getDisplayName(), false);
    b.a(paramParcel, 3, paramParticipantEntity.getIconImageUri(), paramInt, false);
    b.a(paramParcel, 4, paramParticipantEntity.getHiResImageUri(), paramInt, false);
    b.c(paramParcel, 5, paramParticipantEntity.getStatus());
    b.a(paramParcel, 6, paramParticipantEntity.dy(), false);
    b.a(paramParcel, 7, paramParticipantEntity.isConnectedToRoom());
    b.a(paramParcel, 8, paramParticipantEntity.getPlayer(), paramInt, false);
    b.c(paramParcel, 9, paramParticipantEntity.getCapabilities());
    b.a(paramParcel, 10, paramParticipantEntity.getResult(), paramInt, false);
    b.D(paramParcel, i);
  }
  
  public ParticipantEntity[] aJ(int paramInt)
  {
    return new ParticipantEntity[paramInt];
  }
  
  public ParticipantEntity ab(Parcel paramParcel)
  {
    int i = 0;
    ParticipantResult localParticipantResult = null;
    int m = a.n(paramParcel);
    PlayerEntity localPlayerEntity = null;
    boolean bool = false;
    String str1 = null;
    int j = 0;
    Uri localUri1 = null;
    Uri localUri2 = null;
    String str2 = null;
    String str3 = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = a.m(paramParcel);
      switch (a.M(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        str3 = a.m(paramParcel, n);
        break;
      case 1000: 
        k = a.g(paramParcel, n);
        break;
      case 2: 
        str2 = a.m(paramParcel, n);
        break;
      case 3: 
        localUri2 = (Uri)a.a(paramParcel, n, Uri.CREATOR);
        break;
      case 4: 
        localUri1 = (Uri)a.a(paramParcel, n, Uri.CREATOR);
        break;
      case 5: 
        j = a.g(paramParcel, n);
        break;
      case 6: 
        str1 = a.m(paramParcel, n);
        break;
      case 7: 
        bool = a.c(paramParcel, n);
        break;
      case 8: 
        localPlayerEntity = (PlayerEntity)a.a(paramParcel, n, PlayerEntity.CREATOR);
        break;
      case 9: 
        i = a.g(paramParcel, n);
        break;
      case 10: 
        localParticipantResult = (ParticipantResult)a.a(paramParcel, n, ParticipantResult.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new a.a("Overread allowed size end=" + m, paramParcel);
    }
    return new ParticipantEntity(k, str3, str2, localUri2, localUri1, j, str1, bool, localPlayerEntity, i, localParticipantResult);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/multiplayer/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */