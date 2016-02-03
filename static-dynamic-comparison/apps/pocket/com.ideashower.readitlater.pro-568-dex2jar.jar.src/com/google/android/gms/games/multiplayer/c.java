package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.PlayerEntity;

final class c
  extends g
{
  public ParticipantEntity a(Parcel paramParcel)
  {
    int i = 0;
    if ((ParticipantEntity.a(ParticipantEntity.m())) || (ParticipantEntity.a(ParticipantEntity.class.getCanonicalName()))) {
      return super.a(paramParcel);
    }
    String str1 = paramParcel.readString();
    String str2 = paramParcel.readString();
    Object localObject1 = paramParcel.readString();
    Object localObject2;
    label68:
    int j;
    String str3;
    boolean bool;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = paramParcel.readString();
      if (localObject2 != null) {
        break label150;
      }
      localObject2 = null;
      j = paramParcel.readInt();
      str3 = paramParcel.readString();
      if (paramParcel.readInt() <= 0) {
        break label160;
      }
      bool = true;
      label89:
      if (paramParcel.readInt() > 0) {
        i = 1;
      }
      if (i == 0) {
        break label166;
      }
    }
    label150:
    label160:
    label166:
    for (paramParcel = (PlayerEntity)PlayerEntity.CREATOR.createFromParcel(paramParcel);; paramParcel = null)
    {
      return new ParticipantEntity(1, str1, str2, (Uri)localObject1, (Uri)localObject2, j, str3, bool, paramParcel, 7);
      localObject1 = Uri.parse((String)localObject1);
      break;
      localObject2 = Uri.parse((String)localObject2);
      break label68;
      bool = false;
      break label89;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/games/multiplayer/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */