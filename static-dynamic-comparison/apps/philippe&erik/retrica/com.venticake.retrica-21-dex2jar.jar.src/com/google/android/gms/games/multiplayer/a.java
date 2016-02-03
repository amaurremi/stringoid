package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

final class a
  extends InvitationEntityCreator
{
  public InvitationEntity bl(Parcel paramParcel)
  {
    if ((InvitationEntity.b(InvitationEntity.gR())) || (InvitationEntity.aQ(InvitationEntity.class.getCanonicalName()))) {
      return super.bl(paramParcel);
    }
    GameEntity localGameEntity = (GameEntity)GameEntity.CREATOR.createFromParcel(paramParcel);
    String str = paramParcel.readString();
    long l = paramParcel.readLong();
    int j = paramParcel.readInt();
    ParticipantEntity localParticipantEntity = (ParticipantEntity)ParticipantEntity.CREATOR.createFromParcel(paramParcel);
    int k = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList(k);
    int i = 0;
    while (i < k)
    {
      localArrayList.add(ParticipantEntity.CREATOR.createFromParcel(paramParcel));
      i += 1;
    }
    return new InvitationEntity(2, localGameEntity, str, l, j, localParticipantEntity, localArrayList, -1, 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/multiplayer/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */