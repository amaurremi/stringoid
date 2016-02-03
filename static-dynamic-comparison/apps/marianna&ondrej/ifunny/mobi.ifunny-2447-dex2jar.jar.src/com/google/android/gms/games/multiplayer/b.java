package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.games.GameEntity;

import java.util.ArrayList;

public class b
        implements Parcelable.Creator<InvitationEntity> {
    static void a(InvitationEntity paramInvitationEntity, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramInvitationEntity.s_(), paramInt, false);
        c.a(paramParcel, 1000, paramInvitationEntity.k());
        c.a(paramParcel, 2, paramInvitationEntity.e(), false);
        c.a(paramParcel, 3, paramInvitationEntity.g());
        c.a(paramParcel, 4, paramInvitationEntity.h());
        c.a(paramParcel, 5, paramInvitationEntity.f(), paramInt, false);
        c.c(paramParcel, 6, paramInvitationEntity.l(), false);
        c.a(paramParcel, 7, paramInvitationEntity.i());
        c.a(paramParcel, 8, paramInvitationEntity.j());
        c.a(paramParcel, i);
    }

    public InvitationEntity a(Parcel paramParcel) {
        ArrayList localArrayList = null;
        int i = 0;
        int n = a.b(paramParcel);
        long l = 0L;
        int j = 0;
        ParticipantEntity localParticipantEntity = null;
        int k = 0;
        String str = null;
        GameEntity localGameEntity = null;
        int m = 0;
        while (paramParcel.dataPosition() < n) {
            int i1 = a.a(paramParcel);
            switch (a.a(i1)) {
                default:
                    a.b(paramParcel, i1);
                    break;
                case 1:
                    localGameEntity = (GameEntity) a.a(paramParcel, i1, GameEntity.CREATOR);
                    break;
                case 1000:
                    m = a.g(paramParcel, i1);
                    break;
                case 2:
                    str = a.o(paramParcel, i1);
                    break;
                case 3:
                    l = a.i(paramParcel, i1);
                    break;
                case 4:
                    k = a.g(paramParcel, i1);
                    break;
                case 5:
                    localParticipantEntity = (ParticipantEntity) a.a(paramParcel, i1, ParticipantEntity.CREATOR);
                    break;
                case 6:
                    localArrayList = a.c(paramParcel, i1, ParticipantEntity.CREATOR);
                    break;
                case 7:
                    j = a.g(paramParcel, i1);
                    break;
                case 8:
                    i = a.g(paramParcel, i1);
            }
        }
        if (paramParcel.dataPosition() != n) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + n, paramParcel);
        }
        return new InvitationEntity(m, localGameEntity, str, l, k, localParticipantEntity, localArrayList, j, i);
    }

    public InvitationEntity[] a(int paramInt) {
        return new InvitationEntity[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/multiplayer/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */