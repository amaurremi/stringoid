package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.a;
import com.google.android.gms.internal.fq;

import java.util.ArrayList;

public final class InvitationEntity
        extends GamesDowngradeableSafeParcel
        implements Invitation {
    public static final Parcelable.Creator<InvitationEntity> CREATOR = new InvitationEntityCreatorCompat();
    private final String IV;
    private final GameEntity Lt;
    private final long Mu;
    private final int Mv;
    private final ParticipantEntity Mw;
    private final ArrayList<ParticipantEntity> Mx;
    private final int My;
    private final int Mz;
    private final int xH;

    InvitationEntity(int paramInt1, GameEntity paramGameEntity, String paramString, long paramLong, int paramInt2, ParticipantEntity paramParticipantEntity, ArrayList<ParticipantEntity> paramArrayList, int paramInt3, int paramInt4) {
        this.xH = paramInt1;
        this.Lt = paramGameEntity;
        this.IV = paramString;
        this.Mu = paramLong;
        this.Mv = paramInt2;
        this.Mw = paramParticipantEntity;
        this.Mx = paramArrayList;
        this.My = paramInt3;
        this.Mz = paramInt4;
    }

    InvitationEntity(Invitation paramInvitation) {
        this.xH = 2;
        this.Lt = new GameEntity(paramInvitation.getGame());
        this.IV = paramInvitation.getInvitationId();
        this.Mu = paramInvitation.getCreationTimestamp();
        this.Mv = paramInvitation.getInvitationType();
        this.My = paramInvitation.getVariant();
        this.Mz = paramInvitation.getAvailableAutoMatchSlots();
        String str = paramInvitation.getInviter().getParticipantId();
        Participant localParticipant = null;
        ArrayList localArrayList = paramInvitation.getParticipants();
        int j = localArrayList.size();
        this.Mx = new ArrayList(j);
        int i = 0;
        paramInvitation = localParticipant;
        while (i < j) {
            localParticipant = (Participant) localArrayList.get(i);
            if (localParticipant.getParticipantId().equals(str)) {
                paramInvitation = localParticipant;
            }
            this.Mx.add((ParticipantEntity) localParticipant.freeze());
            i += 1;
        }
        fq.b(paramInvitation, "Must have a valid inviter!");
        this.Mw = ((ParticipantEntity) paramInvitation.freeze());
    }

    static int a(Invitation paramInvitation) {
        return fo.hashCode(new Object[]{paramInvitation.getGame(), paramInvitation.getInvitationId(), Long.valueOf(paramInvitation.getCreationTimestamp()), Integer.valueOf(paramInvitation.getInvitationType()), paramInvitation.getInviter(), paramInvitation.getParticipants(), Integer.valueOf(paramInvitation.getVariant()), Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots())});
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
            if ((!fo.equal(((Invitation) paramObject).getGame(), paramInvitation.getGame())) || (!fo.equal(((Invitation) paramObject).getInvitationId(), paramInvitation.getInvitationId())) || (!fo.equal(Long.valueOf(((Invitation) paramObject).getCreationTimestamp()), Long.valueOf(paramInvitation.getCreationTimestamp()))) || (!fo.equal(Integer.valueOf(((Invitation) paramObject).getInvitationType()), Integer.valueOf(paramInvitation.getInvitationType()))) || (!fo.equal(((Invitation) paramObject).getInviter(), paramInvitation.getInviter())) || (!fo.equal(((Invitation) paramObject).getParticipants(), paramInvitation.getParticipants())) || (!fo.equal(Integer.valueOf(((Invitation) paramObject).getVariant()), Integer.valueOf(paramInvitation.getVariant())))) {
                break;
            }
            bool1 = bool2;
        }
        while (fo.equal(Integer.valueOf(((Invitation) paramObject).getAvailableAutoMatchSlots()), Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots())));
        return false;
    }

    static String b(Invitation paramInvitation) {
        return fo.e(paramInvitation).a("Game", paramInvitation.getGame()).a("InvitationId", paramInvitation.getInvitationId()).a("CreationTimestamp", Long.valueOf(paramInvitation.getCreationTimestamp())).a("InvitationType", Integer.valueOf(paramInvitation.getInvitationType())).a("Inviter", paramInvitation.getInviter()).a("Participants", paramInvitation.getParticipants()).a("Variant", Integer.valueOf(paramInvitation.getVariant())).a("AvailableAutoMatchSlots", Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return a(this, paramObject);
    }

    public Invitation freeze() {
        return this;
    }

    public int getAvailableAutoMatchSlots() {
        return this.Mz;
    }

    public long getCreationTimestamp() {
        return this.Mu;
    }

    public Game getGame() {
        return this.Lt;
    }

    public String getInvitationId() {
        return this.IV;
    }

    public int getInvitationType() {
        return this.Mv;
    }

    public Participant getInviter() {
        return this.Mw;
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.Mx);
    }

    public int getVariant() {
        return this.My;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public int hashCode() {
        return a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        if (!eK()) {
            InvitationEntityCreator.a(this, paramParcel, paramInt);
        }
        for (; ; ) {
            return;
            this.Lt.writeToParcel(paramParcel, paramInt);
            paramParcel.writeString(this.IV);
            paramParcel.writeLong(this.Mu);
            paramParcel.writeInt(this.Mv);
            this.Mw.writeToParcel(paramParcel, paramInt);
            int j = this.Mx.size();
            paramParcel.writeInt(j);
            int i = 0;
            while (i < j) {
                ((ParticipantEntity) this.Mx.get(i)).writeToParcel(paramParcel, paramInt);
                i += 1;
            }
        }
    }

    static final class InvitationEntityCreatorCompat
            extends InvitationEntityCreator {
        public InvitationEntity au(Parcel paramParcel) {
            if ((InvitationEntity.b(InvitationEntity.gg())) || (InvitationEntity.az(InvitationEntity.class.getCanonicalName()))) {
                return super.au(paramParcel);
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
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/multiplayer/InvitationEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */