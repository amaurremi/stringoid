package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

import java.util.ArrayList;
import java.util.List;

public final class GameRequestRef
        extends f
        implements GameRequest {
    private final int c;

    public int a_(String paramString) {
        int i = this.b;
        while (i < this.b + this.c) {
            int j = this.a.a(i);
            if (this.a.c("recipient_external_player_id", i, j).equals(paramString)) {
                return this.a.b("recipient_status", i, j);
            }
            i += 1;
        }
        return -1;
    }

    public GameRequest c() {
        return new GameRequestEntity(this);
    }

    public String d() {
        return e("external_request_id");
    }

    public int describeContents() {
        return 0;
    }

    public Game e() {
        return new GameRef(this.a, this.b);
    }

    public boolean equals(Object paramObject) {
        return GameRequestEntity.a(this, paramObject);
    }

    public Player f() {
        return new PlayerRef(this.a, b(), "sender_");
    }

    public byte[] h() {
        return g("data");
    }

    public int hashCode() {
        return GameRequestEntity.a(this);
    }

    public int i() {
        return c("type");
    }

    public long j() {
        return b("creation_timestamp");
    }

    public long k() {
        return b("expiration_timestamp");
    }

    public int l() {
        return c("status");
    }

    public List<Player> n() {
        ArrayList localArrayList = new ArrayList(this.c);
        int i = 0;
        while (i < this.c) {
            localArrayList.add(new PlayerRef(this.a, this.b + i, "recipient_"));
            i += 1;
        }
        return localArrayList;
    }

    public String toString() {
        return GameRequestEntity.b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ((GameRequestEntity) c()).writeToParcel(paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/request/GameRequestRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */