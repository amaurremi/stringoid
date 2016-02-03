package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class ParticipantRef
        extends b
        implements Participant {
    private final PlayerRef LL;

    public ParticipantRef(DataHolder paramDataHolder, int paramInt) {
        super(paramDataHolder, paramInt);
        this.LL = new PlayerRef(paramDataHolder, paramInt);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return ParticipantEntity.a(this, paramObject);
    }

    public Participant freeze() {
        return new ParticipantEntity(this);
    }

    public int getCapabilities() {
        return getInteger("capabilities");
    }

    public String getDisplayName() {
        if (ai("external_player_id")) {
            return getString("default_display_name");
        }
        return this.LL.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer paramCharArrayBuffer) {
        if (ai("external_player_id")) {
            a("default_display_name", paramCharArrayBuffer);
            return;
        }
        this.LL.getDisplayName(paramCharArrayBuffer);
    }

    public Uri getHiResImageUri() {
        if (ai("external_player_id")) {
            return ah("default_display_hi_res_image_uri");
        }
        return this.LL.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        if (ai("external_player_id")) {
            return getString("default_display_hi_res_image_url");
        }
        return this.LL.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        if (ai("external_player_id")) {
            return ah("default_display_image_uri");
        }
        return this.LL.getIconImageUri();
    }

    public String getIconImageUrl() {
        if (ai("external_player_id")) {
            return getString("default_display_image_url");
        }
        return this.LL.getIconImageUrl();
    }

    public String getParticipantId() {
        return getString("external_participant_id");
    }

    public Player getPlayer() {
        if (ai("external_player_id")) {
            return null;
        }
        return this.LL;
    }

    public ParticipantResult getResult() {
        if (ai("result_type")) {
            return null;
        }
        int i = getInteger("result_type");
        int j = getInteger("placing");
        return new ParticipantResult(getParticipantId(), i, j);
    }

    public int getStatus() {
        return getInteger("player_status");
    }

    public String gi() {
        return getString("client_address");
    }

    public int hashCode() {
        return ParticipantEntity.a(this);
    }

    public boolean isConnectedToRoom() {
        return getInteger("connected") > 0;
    }

    public String toString() {
        return ParticipantEntity.b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ((ParticipantEntity) freeze()).writeToParcel(paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/multiplayer/ParticipantRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */