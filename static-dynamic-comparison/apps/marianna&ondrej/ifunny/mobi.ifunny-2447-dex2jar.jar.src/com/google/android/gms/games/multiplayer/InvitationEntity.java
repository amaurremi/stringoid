package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

import java.util.ArrayList;

public final class InvitationEntity
        extends GamesDowngradeableSafeParcel
        implements Invitation {
    public static final Parcelable.Creator<InvitationEntity> CREATOR = new a();
    private final int a;
    private final GameEntity b;
    private final String c;
    private final long d;
    private final int e;
    private final ParticipantEntity f;
    private final ArrayList<ParticipantEntity> g;
    private final int h;
    private final int i;

    InvitationEntity(int paramInt1, GameEntity paramGameEntity, String paramString, long paramLong, int paramInt2, ParticipantEntity paramParticipantEntity, ArrayList<ParticipantEntity> paramArrayList, int paramInt3, int paramInt4) {
        this.a = paramInt1;
        this.b = paramGameEntity;
        this.c = paramString;
        this.d = paramLong;
        this.e = paramInt2;
        this.f = paramParticipantEntity;
        this.g = paramArrayList;
        this.h = paramInt3;
        this.i = paramInt4;
    }

    InvitationEntity(Invitation paramInvitation) {
        this.a = 2;
        this.b = new GameEntity(paramInvitation.s_());
        this.c = paramInvitation.e();
        this.d = paramInvitation.g();
        this.e = paramInvitation.h();
        this.h = paramInvitation.i();
        this.i = paramInvitation.j();
        String str = paramInvitation.f().k();
        Participant localParticipant = null;
        ArrayList localArrayList = paramInvitation.l();
        int k = localArrayList.size();
        this.g = new ArrayList(k);
        int j = 0;
        paramInvitation = localParticipant;
        while (j < k) {
            localParticipant = (Participant) localArrayList.get(j);
            if (localParticipant.k().equals(str)) {
                paramInvitation = localParticipant;
            }
            this.g.add((ParticipantEntity) localParticipant.a());
            j += 1;
        }
        ag.a(paramInvitation, "Must have a valid inviter!");
        this.f = ((ParticipantEntity) paramInvitation.a());
    }

    static int a(Invitation paramInvitation) {
        return ad.a(new Object[]{paramInvitation.s_(), paramInvitation.e(), Long.valueOf(paramInvitation.g()), Integer.valueOf(paramInvitation.h()), paramInvitation.f(), paramInvitation.l(), Integer.valueOf(paramInvitation.i()), Integer.valueOf(paramInvitation.j())});
    }

    static boolean a(Invitation paramInvitation, Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof Invitation)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramInvitation == paramObject);
            paramObject = (Invitation) paramObject;
            if ((!ad.a(((Invitation) paramObject).s_(), paramInvitation.s_())) || (!ad.a(((Invitation) paramObject).e(), paramInvitation.e())) || (!ad.a(Long.valueOf(((Invitation) paramObject).g()), Long.valueOf(paramInvitation.g()))) || (!ad.a(Integer.valueOf(((Invitation) paramObject).h()), Integer.valueOf(paramInvitation.h()))) || (!ad.a(((Invitation) paramObject).f(), paramInvitation.f())) || (!ad.a(((Invitation) paramObject).l(), paramInvitation.l())) || (!ad.a(Integer.valueOf(((Invitation) paramObject).i()), Integer.valueOf(paramInvitation.i())))) {
                break;
            }
            bool1 = bool2;
        } while (ad.a(Integer.valueOf(((Invitation) paramObject).j()), Integer.valueOf(paramInvitation.j())));
        return false;
    }

    static String b(Invitation paramInvitation) {
        return ad.a(paramInvitation).a("Game", paramInvitation.s_()).a("InvitationId", paramInvitation.e()).a("CreationTimestamp", Long.valueOf(paramInvitation.g())).a("InvitationType", Integer.valueOf(paramInvitation.h())).a("Inviter", paramInvitation.f()).a("Participants", paramInvitation.l()).a("Variant", Integer.valueOf(paramInvitation.i())).a("AvailableAutoMatchSlots", Integer.valueOf(paramInvitation.j())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.c;
    }

    public boolean equals(Object paramObject) {
        return a(this, paramObject);
    }

    public Participant f() {
        return this.f;
    }

    public long g() {
        return this.d;
    }

    public int h() {
        return this.e;
    }

    public int hashCode() {
        return a(this);
    }

    public int i() {
        return this.h;
    }

    public int j() {
        return this.i;
    }

    public int k() {
        return this.a;
    }

    public ArrayList<Participant> l() {
        return new ArrayList(this.g);
    }

    public Invitation m() {
        return this;
    }

    public Game s_() {
        return this.b;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        if (!d()) {
            b.a(this, paramParcel, paramInt);
        }
        for (; ; ) {
            return;
            this.b.writeToParcel(paramParcel, paramInt);
            paramParcel.writeString(this.c);
            paramParcel.writeLong(this.d);
            paramParcel.writeInt(this.e);
            this.f.writeToParcel(paramParcel, paramInt);
            int k = this.g.size();
            paramParcel.writeInt(k);
            int j = 0;
            while (j < k) {
                ((ParticipantEntity) this.g.get(j)).writeToParcel(paramParcel, paramInt);
                j += 1;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/multiplayer/InvitationEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */