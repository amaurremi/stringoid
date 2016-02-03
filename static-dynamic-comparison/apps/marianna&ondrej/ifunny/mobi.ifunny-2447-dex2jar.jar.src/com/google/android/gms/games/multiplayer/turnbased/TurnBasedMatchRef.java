package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.f;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;

import java.util.ArrayList;

public final class TurnBasedMatchRef
        extends f
        implements TurnBasedMatch {
    private final Game c;
    private final int d;

    public String c() {
        return e("external_match_id");
    }

    public String d() {
        return e("creator_external");
    }

    public int describeContents() {
        return 0;
    }

    public long e() {
        return b("creation_timestamp");
    }

    public boolean equals(Object paramObject) {
        return TurnBasedMatchEntity.a(this, paramObject);
    }

    public int f() {
        return c("status");
    }

    public int g() {
        return c("user_match_status");
    }

    public String h() {
        return e("description");
    }

    public int hashCode() {
        return TurnBasedMatchEntity.a(this);
    }

    public int i() {
        return c("variant");
    }

    public String j() {
        return e("last_updater_external");
    }

    public long k() {
        return b("last_updated_timestamp");
    }

    public ArrayList<Participant> l() {
        ArrayList localArrayList = new ArrayList(this.d);
        int i = 0;
        while (i < this.d) {
            localArrayList.add(new ParticipantRef(this.a, this.b + i));
            i += 1;
        }
        return localArrayList;
    }

    public String m() {
        return e("pending_participant_external");
    }

    public byte[] n() {
        return g("data");
    }

    public int o() {
        return c("version");
    }

    public String p() {
        return e("rematch_id");
    }

    public byte[] q() {
        return g("previous_match_data");
    }

    public int r() {
        return c("match_number");
    }

    public Bundle s() {
        if (!d("has_automatch_criteria")) {
            return null;
        }
        return a.a(c("automatch_min_players"), c("automatch_max_players"), b("automatch_bit_mask"));
    }

    public int t() {
        if (!d("has_automatch_criteria")) {
            return 0;
        }
        return c("automatch_max_players");
    }

    public String toString() {
        return TurnBasedMatchEntity.b(this);
    }

    public boolean u() {
        return d("upsync_required");
    }

    public String v() {
        return e("description_participant_id");
    }

    public TurnBasedMatch w() {
        return new TurnBasedMatchEntity(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ((TurnBasedMatchEntity) w()).writeToParcel(paramParcel, paramInt);
    }

    public Game z_() {
        return this.c;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */