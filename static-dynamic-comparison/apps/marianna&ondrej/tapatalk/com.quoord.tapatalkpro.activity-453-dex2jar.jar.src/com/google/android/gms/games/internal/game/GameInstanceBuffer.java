package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class GameInstanceBuffer
        extends DataBuffer<GameInstance> {
    public GameInstanceBuffer(DataHolder paramDataHolder) {
        super(paramDataHolder);
    }

    public GameInstance bh(int paramInt) {
        return new GameInstanceRef(this.BB, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/internal/game/GameInstanceBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */