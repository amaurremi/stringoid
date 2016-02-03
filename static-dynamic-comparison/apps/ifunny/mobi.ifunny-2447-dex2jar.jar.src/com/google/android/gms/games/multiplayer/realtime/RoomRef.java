package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.f;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;

import java.util.ArrayList;

public final class RoomRef
        extends f
        implements Room {
    private final int c;

    public int describeContents() {
        return 0;
    }

    public int e() {
        return c("status");
    }

    public boolean equals(Object paramObject) {
        return RoomEntity.a(this, paramObject);
    }

    public String f() {
        return e("description");
    }

    public int g() {
        return c("variant");
    }

    public Bundle h() {
        if (!d("has_automatch_criteria")) {
            return null;
        }
        return b.a(c("automatch_min_players"), c("automatch_max_players"), b("automatch_bit_mask"));
    }

    public int hashCode() {
        return RoomEntity.a(this);
    }

    public int i() {
        return c("automatch_wait_estimate_sec");
    }

    public Room j() {
        return new RoomEntity(this);
    }

    public ArrayList<Participant> l() {
        ArrayList localArrayList = new ArrayList(this.c);
        int i = 0;
        while (i < this.c) {
            localArrayList.add(new ParticipantRef(this.a, this.b + i));
            i += 1;
        }
        return localArrayList;
    }

    public String toString() {
        return RoomEntity.b(this);
    }

    public String w_() {
        return e("external_match_id");
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ((RoomEntity) j()).writeToParcel(paramParcel, paramInt);
    }

    public String x_() {
        return e("creator_external");
    }

    public long y_() {
        return b("creation_timestamp");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RoomRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */