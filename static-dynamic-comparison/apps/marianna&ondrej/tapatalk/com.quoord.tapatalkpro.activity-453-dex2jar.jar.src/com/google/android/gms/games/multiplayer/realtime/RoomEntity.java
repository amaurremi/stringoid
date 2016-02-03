package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.a;
import com.google.android.gms.internal.gm;

import java.util.ArrayList;

public final class RoomEntity
        extends GamesDowngradeableSafeParcel
        implements Room {
    public static final Parcelable.Creator<RoomEntity> CREATOR = new RoomEntityCreatorCompat();
    private final String HD;
    private final String Ja;
    private final Bundle MO;
    private final String MS;
    private final int MT;
    private final int MU;
    private final long Mu;
    private final ArrayList<ParticipantEntity> Mx;
    private final int My;
    private final int xH;

    RoomEntity(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, String paramString3, int paramInt3, Bundle paramBundle, ArrayList<ParticipantEntity> paramArrayList, int paramInt4) {
        this.xH = paramInt1;
        this.Ja = paramString1;
        this.MS = paramString2;
        this.Mu = paramLong;
        this.MT = paramInt2;
        this.HD = paramString3;
        this.My = paramInt3;
        this.MO = paramBundle;
        this.Mx = paramArrayList;
        this.MU = paramInt4;
    }

    public RoomEntity(Room paramRoom) {
        this.xH = 2;
        this.Ja = paramRoom.getRoomId();
        this.MS = paramRoom.getCreatorId();
        this.Mu = paramRoom.getCreationTimestamp();
        this.MT = paramRoom.getStatus();
        this.HD = paramRoom.getDescription();
        this.My = paramRoom.getVariant();
        this.MO = paramRoom.getAutoMatchCriteria();
        ArrayList localArrayList = paramRoom.getParticipants();
        int j = localArrayList.size();
        this.Mx = new ArrayList(j);
        int i = 0;
        while (i < j) {
            this.Mx.add((ParticipantEntity) ((Participant) localArrayList.get(i)).freeze());
            i += 1;
        }
        this.MU = paramRoom.getAutoMatchWaitEstimateSeconds();
    }

    static int a(Room paramRoom) {
        return fo.hashCode(new Object[]{paramRoom.getRoomId(), paramRoom.getCreatorId(), Long.valueOf(paramRoom.getCreationTimestamp()), Integer.valueOf(paramRoom.getStatus()), paramRoom.getDescription(), Integer.valueOf(paramRoom.getVariant()), paramRoom.getAutoMatchCriteria(), paramRoom.getParticipants(), Integer.valueOf(paramRoom.getAutoMatchWaitEstimateSeconds())});
    }

    static int a(Room paramRoom, String paramString) {
        ArrayList localArrayList = paramRoom.getParticipants();
        int j = localArrayList.size();
        int i = 0;
        while (i < j) {
            Participant localParticipant = (Participant) localArrayList.get(i);
            if (localParticipant.getParticipantId().equals(paramString)) {
                return localParticipant.getStatus();
            }
            i += 1;
        }
        throw new IllegalStateException("Participant " + paramString + " is not in room " + paramRoom.getRoomId());
    }

    static boolean a(Room paramRoom, Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof Room)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramRoom == paramObject);
            paramObject = (Room) paramObject;
            if ((!fo.equal(((Room) paramObject).getRoomId(), paramRoom.getRoomId())) || (!fo.equal(((Room) paramObject).getCreatorId(), paramRoom.getCreatorId())) || (!fo.equal(Long.valueOf(((Room) paramObject).getCreationTimestamp()), Long.valueOf(paramRoom.getCreationTimestamp()))) || (!fo.equal(Integer.valueOf(((Room) paramObject).getStatus()), Integer.valueOf(paramRoom.getStatus()))) || (!fo.equal(((Room) paramObject).getDescription(), paramRoom.getDescription())) || (!fo.equal(Integer.valueOf(((Room) paramObject).getVariant()), Integer.valueOf(paramRoom.getVariant()))) || (!fo.equal(((Room) paramObject).getAutoMatchCriteria(), paramRoom.getAutoMatchCriteria())) || (!fo.equal(((Room) paramObject).getParticipants(), paramRoom.getParticipants()))) {
                break;
            }
            bool1 = bool2;
        }
        while (fo.equal(Integer.valueOf(((Room) paramObject).getAutoMatchWaitEstimateSeconds()), Integer.valueOf(paramRoom.getAutoMatchWaitEstimateSeconds())));
        return false;
    }

    static String b(Room paramRoom) {
        return fo.e(paramRoom).a("RoomId", paramRoom.getRoomId()).a("CreatorId", paramRoom.getCreatorId()).a("CreationTimestamp", Long.valueOf(paramRoom.getCreationTimestamp())).a("RoomStatus", Integer.valueOf(paramRoom.getStatus())).a("Description", paramRoom.getDescription()).a("Variant", Integer.valueOf(paramRoom.getVariant())).a("AutoMatchCriteria", paramRoom.getAutoMatchCriteria()).a("Participants", paramRoom.getParticipants()).a("AutoMatchWaitEstimateSeconds", Integer.valueOf(paramRoom.getAutoMatchWaitEstimateSeconds())).toString();
    }

    static String b(Room paramRoom, String paramString) {
        paramRoom = paramRoom.getParticipants();
        int j = paramRoom.size();
        int i = 0;
        while (i < j) {
            Participant localParticipant = (Participant) paramRoom.get(i);
            Player localPlayer = localParticipant.getPlayer();
            if ((localPlayer != null) && (localPlayer.getPlayerId().equals(paramString))) {
                return localParticipant.getParticipantId();
            }
            i += 1;
        }
        return null;
    }

    static Participant c(Room paramRoom, String paramString) {
        ArrayList localArrayList = paramRoom.getParticipants();
        int j = localArrayList.size();
        int i = 0;
        while (i < j) {
            Participant localParticipant = (Participant) localArrayList.get(i);
            if (localParticipant.getParticipantId().equals(paramString)) {
                return localParticipant;
            }
            i += 1;
        }
        throw new IllegalStateException("Participant " + paramString + " is not in match " + paramRoom.getRoomId());
    }

    static ArrayList<String> c(Room paramRoom) {
        paramRoom = paramRoom.getParticipants();
        int j = paramRoom.size();
        ArrayList localArrayList = new ArrayList(j);
        int i = 0;
        while (i < j) {
            localArrayList.add(((Participant) paramRoom.get(i)).getParticipantId());
            i += 1;
        }
        return localArrayList;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return a(this, paramObject);
    }

    public Room freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.MO;
    }

    public int getAutoMatchWaitEstimateSeconds() {
        return this.MU;
    }

    public long getCreationTimestamp() {
        return this.Mu;
    }

    public String getCreatorId() {
        return this.MS;
    }

    public String getDescription() {
        return this.HD;
    }

    public void getDescription(CharArrayBuffer paramCharArrayBuffer) {
        gm.b(this.HD, paramCharArrayBuffer);
    }

    public Participant getParticipant(String paramString) {
        return c(this, paramString);
    }

    public String getParticipantId(String paramString) {
        return b(this, paramString);
    }

    public ArrayList<String> getParticipantIds() {
        return c(this);
    }

    public int getParticipantStatus(String paramString) {
        return a(this, paramString);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.Mx);
    }

    public String getRoomId() {
        return this.Ja;
    }

    public int getStatus() {
        return this.MT;
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
            RoomEntityCreator.a(this, paramParcel, paramInt);
        }
        for (; ; ) {
            return;
            paramParcel.writeString(this.Ja);
            paramParcel.writeString(this.MS);
            paramParcel.writeLong(this.Mu);
            paramParcel.writeInt(this.MT);
            paramParcel.writeString(this.HD);
            paramParcel.writeInt(this.My);
            paramParcel.writeBundle(this.MO);
            int j = this.Mx.size();
            paramParcel.writeInt(j);
            int i = 0;
            while (i < j) {
                ((ParticipantEntity) this.Mx.get(i)).writeToParcel(paramParcel, paramInt);
                i += 1;
            }
        }
    }

    static final class RoomEntityCreatorCompat
            extends RoomEntityCreator {
        public RoomEntity ax(Parcel paramParcel) {
            if ((RoomEntity.b(RoomEntity.gg())) || (RoomEntity.az(RoomEntity.class.getCanonicalName()))) {
                return super.ax(paramParcel);
            }
            String str1 = paramParcel.readString();
            String str2 = paramParcel.readString();
            long l = paramParcel.readLong();
            int j = paramParcel.readInt();
            String str3 = paramParcel.readString();
            int k = paramParcel.readInt();
            Bundle localBundle = paramParcel.readBundle();
            int m = paramParcel.readInt();
            ArrayList localArrayList = new ArrayList(m);
            int i = 0;
            while (i < m) {
                localArrayList.add(ParticipantEntity.CREATOR.createFromParcel(paramParcel));
                i += 1;
            }
            return new RoomEntity(2, str1, str2, l, j, str3, k, localBundle, localArrayList, -1);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RoomEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */