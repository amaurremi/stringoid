package com.google.android.gms.games.internal.player;

import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.a;

public final class ExtendedPlayerEntity
        implements ExtendedPlayer {
    private final PlayerEntity LH;
    private final String LI;
    private final long LJ;
    private final Uri LK;

    public ExtendedPlayerEntity(ExtendedPlayer paramExtendedPlayer) {
        Object localObject = paramExtendedPlayer.getPlayer();
        if (localObject == null) {
        }
        for (localObject = null; ; localObject = new PlayerEntity((Player) localObject)) {
            this.LH = ((PlayerEntity) localObject);
            this.LI = paramExtendedPlayer.hu();
            this.LJ = paramExtendedPlayer.hv();
            this.LK = paramExtendedPlayer.hw();
            return;
        }
    }

    static int a(ExtendedPlayer paramExtendedPlayer) {
        return fo.hashCode(new Object[]{paramExtendedPlayer.getPlayer(), paramExtendedPlayer.hu(), Long.valueOf(paramExtendedPlayer.hv()), paramExtendedPlayer.hw()});
    }

    static boolean a(ExtendedPlayer paramExtendedPlayer, Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof ExtendedPlayer)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramExtendedPlayer == paramObject);
            paramObject = (ExtendedPlayer) paramObject;
            if ((!fo.equal(((ExtendedPlayer) paramObject).getPlayer(), paramExtendedPlayer.getPlayer())) || (!fo.equal(((ExtendedPlayer) paramObject).hu(), paramExtendedPlayer.hu())) || (!fo.equal(Long.valueOf(((ExtendedPlayer) paramObject).hv()), Long.valueOf(paramExtendedPlayer.hv())))) {
                break;
            }
            bool1 = bool2;
        } while (fo.equal(((ExtendedPlayer) paramObject).hw(), paramExtendedPlayer.hw()));
        return false;
    }

    static String b(ExtendedPlayer paramExtendedPlayer) {
        return fo.e(paramExtendedPlayer).a("Player", paramExtendedPlayer.getPlayer()).a("MostRecentGameId", paramExtendedPlayer.hu()).a("MostRecentActivityTimestamp", Long.valueOf(paramExtendedPlayer.hv())).a("MostRecentGameIconImageUri", paramExtendedPlayer.hw()).toString();
    }

    public boolean equals(Object paramObject) {
        return a(this, paramObject);
    }

    public int hashCode() {
        return a(this);
    }

    public String hu() {
        return this.LI;
    }

    public long hv() {
        return this.LJ;
    }

    public Uri hw() {
        return this.LK;
    }

    public PlayerEntity hx() {
        return this.LH;
    }

    public ExtendedPlayer hy() {
        return this;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return b(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/internal/player/ExtendedPlayerEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */