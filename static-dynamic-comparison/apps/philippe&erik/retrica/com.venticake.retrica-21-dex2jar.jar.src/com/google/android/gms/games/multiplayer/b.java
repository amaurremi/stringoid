package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.PlayerEntity;

final class b
  extends ParticipantEntityCreator
{
  public ParticipantEntity bm(Parcel paramParcel)
  {
    int i = 1;
    if ((ParticipantEntity.b(ParticipantEntity.gR())) || (ParticipantEntity.aQ(ParticipantEntity.class.getCanonicalName()))) {
      return super.bm(paramParcel);
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
        break label151;
      }
      localObject2 = null;
      j = paramParcel.readInt();
      str3 = paramParcel.readString();
      if (paramParcel.readInt() <= 0) {
        break label161;
      }
      bool = true;
      label89:
      if (paramParcel.readInt() <= 0) {
        break label167;
      }
      label96:
      if (i == 0) {
        break label172;
      }
    }
    label151:
    label161:
    label167:
    label172:
    for (paramParcel = (PlayerEntity)PlayerEntity.CREATOR.createFromParcel(paramParcel);; paramParcel = null)
    {
      return new ParticipantEntity(3, str1, str2, (Uri)localObject1, (Uri)localObject2, j, str3, bool, paramParcel, 7, null, null, null);
      localObject1 = Uri.parse((String)localObject1);
      break;
      localObject2 = Uri.parse((String)localObject2);
      break label68;
      bool = false;
      break label89;
      i = 0;
      break label96;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/multiplayer/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */