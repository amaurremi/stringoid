package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.f;
import com.google.android.gms.games.Game;

import java.util.ArrayList;

public final class InvitationRef
        extends f
        implements Invitation {
    private final Game c;
    private final ParticipantRef d;
    private final ArrayList<Participant> e;

    public Invitation c() {
        return new InvitationEntity(this);
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return e("external_invitation_id");
    }

    public boolean equals(Object paramObject) {
        return InvitationEntity.a(this, paramObject);
    }

    public Participant f() {
        return this.d;
    }

    public long g() {
        return Math.max(b("creation_timestamp"), b("last_modified_timestamp"));
    }

    public int h() {
        return c("type");
    }

    public int hashCode() {
        return InvitationEntity.a(this);
    }

    public int i() {
        return c("variant");
    }

    public int j() {
        if (!d("has_automatch_criteria")) {
            return 0;
        }
        return c("automatch_max_players");
    }

    public ArrayList<Participant> l() {
        return this.e;
    }

    public Game s_() {
        return this.c;
    }

    public String toString() {
        return InvitationEntity.b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ((InvitationEntity) c()).writeToParcel(paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/multiplayer/InvitationRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */