package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataBuffer;

public final class ParticipantBuffer
        extends DataBuffer<Participant> {
    public Participant get(int paramInt) {
        return new ParticipantRef(this.BB, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/multiplayer/ParticipantBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */