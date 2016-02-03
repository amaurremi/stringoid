package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class InvitationBuffer
        extends d<Invitation> {
    public InvitationBuffer(DataHolder paramDataHolder) {
        super(paramDataHolder);
    }

    protected Invitation getEntry(int paramInt1, int paramInt2) {
        return new InvitationRef(this.BB, paramInt1, paramInt2);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_invitation_id";
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/multiplayer/InvitationBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */