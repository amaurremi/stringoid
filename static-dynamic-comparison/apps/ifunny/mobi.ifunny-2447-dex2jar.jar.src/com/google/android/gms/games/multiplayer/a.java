package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.GameEntity;

import java.util.ArrayList;

final class a
        extends b {
    public InvitationEntity a(Parcel paramParcel) {
        if ((InvitationEntity.a(InvitationEntity.n())) || (InvitationEntity.b(InvitationEntity.class.getCanonicalName()))) {
            return super.a(paramParcel);
        }
        GameEntity localGameEntity = (GameEntity) GameEntity.CREATOR.createFromParcel(paramParcel);
        String str = paramParcel.readString();
        long l = paramParcel.readLong();
        int j = paramParcel.readInt();
        ParticipantEntity localParticipantEntity = (ParticipantEntity) ParticipantEntity.CREATOR.createFromParcel(paramParcel);
        int k = paramParcel.readInt();
        ArrayList localArrayList = new ArrayList(k);
        int i = 0;
        while (i < k) {
            localArrayList.add(ParticipantEntity.CREATOR.createFromParcel(paramParcel));
            i += 1;
        }
        return new InvitationEntity(2, localGameEntity, str, l, j, localParticipantEntity, localArrayList, -1, 0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/multiplayer/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */