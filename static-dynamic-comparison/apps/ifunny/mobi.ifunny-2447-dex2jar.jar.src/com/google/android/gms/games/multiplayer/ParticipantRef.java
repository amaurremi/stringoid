package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class ParticipantRef
        extends f
        implements Participant {
    private final PlayerRef c;

    public ParticipantRef(DataHolder paramDataHolder, int paramInt) {
        super(paramDataHolder, paramInt);
        this.c = new PlayerRef(paramDataHolder, paramInt);
    }

    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return c("connected") > 0;
    }

    public boolean equals(Object paramObject) {
        return ParticipantEntity.a(this, paramObject);
    }

    public String f() {
        if (i("external_player_id")) {
            return e("default_display_name");
        }
        return this.c.h_();
    }

    public Uri g() {
        if (i("external_player_id")) {
            return h("default_display_image_uri");
        }
        return this.c.i_();
    }

    public String h() {
        if (i("external_player_id")) {
            return e("default_display_image_url");
        }
        return this.c.e();
    }

    public int hashCode() {
        return ParticipantEntity.a(this);
    }

    public Uri i() {
        if (i("external_player_id")) {
            return h("default_display_hi_res_image_uri");
        }
        return this.c.f();
    }

    public String j() {
        if (i("external_player_id")) {
            return e("default_display_hi_res_image_url");
        }
        return this.c.g();
    }

    public String k() {
        return e("external_participant_id");
    }

    public Player l() {
        if (i("external_player_id")) {
            return null;
        }
        return this.c;
    }

    public ParticipantResult m() {
        if (i("result_type")) {
            return null;
        }
        int i = c("result_type");
        int j = c("placing");
        return new ParticipantResult(k(), i, j);
    }

    public Participant n() {
        return new ParticipantEntity(this);
    }

    public int t_() {
        return c("player_status");
    }

    public String toString() {
        return ParticipantEntity.b(this);
    }

    public String u_() {
        return e("client_address");
    }

    public int v_() {
        return c("capabilities");
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ((ParticipantEntity) n()).writeToParcel(paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/multiplayer/ParticipantRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */