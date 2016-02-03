package com.google.android.gms.games.internal.player;

import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class ExtendedPlayerRef
        extends b
        implements ExtendedPlayer {
    private final PlayerRef LL;

    ExtendedPlayerRef(DataHolder paramDataHolder, int paramInt) {
        super(paramDataHolder, paramInt);
        this.LL = new PlayerRef(paramDataHolder, paramInt);
    }

    public Player getPlayer() {
        return this.LL;
    }

    public String hu() {
        return getString("most_recent_external_game_id");
    }

    public long hv() {
        return getLong("most_recent_activity_timestamp");
    }

    public Uri hw() {
        return ah("game_icon_image_uri");
    }

    public ExtendedPlayer hy() {
        return new ExtendedPlayerEntity(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/internal/player/ExtendedPlayerRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */