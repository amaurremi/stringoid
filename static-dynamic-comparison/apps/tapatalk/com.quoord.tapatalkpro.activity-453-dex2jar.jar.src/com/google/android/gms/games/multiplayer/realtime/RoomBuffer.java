package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class RoomBuffer
        extends d<Room> {
    public RoomBuffer(DataHolder paramDataHolder) {
        super(paramDataHolder);
    }

    protected Room e(int paramInt1, int paramInt2) {
        return new RoomRef(this.BB, paramInt1, paramInt2);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_match_id";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RoomBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */