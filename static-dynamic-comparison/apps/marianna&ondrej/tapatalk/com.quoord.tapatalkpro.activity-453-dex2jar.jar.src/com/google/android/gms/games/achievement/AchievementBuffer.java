package com.google.android.gms.games.achievement;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class AchievementBuffer
        extends DataBuffer<Achievement> {
    public AchievementBuffer(DataHolder paramDataHolder) {
        super(paramDataHolder);
    }

    public Achievement get(int paramInt) {
        return new AchievementRef(this.BB, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/achievement/AchievementBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */