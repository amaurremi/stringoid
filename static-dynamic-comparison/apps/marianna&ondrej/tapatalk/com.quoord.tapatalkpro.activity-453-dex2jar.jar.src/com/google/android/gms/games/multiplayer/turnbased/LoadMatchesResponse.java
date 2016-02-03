package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public final class LoadMatchesResponse {
    private final InvitationBuffer MV;
    private final TurnBasedMatchBuffer MW;
    private final TurnBasedMatchBuffer MX;
    private final TurnBasedMatchBuffer MY;

    public LoadMatchesResponse(Bundle paramBundle) {
        DataHolder localDataHolder = a(paramBundle, 0);
        if (localDataHolder != null) {
            this.MV = new InvitationBuffer(localDataHolder);
            localDataHolder = a(paramBundle, 1);
            if (localDataHolder == null) {
                break label101;
            }
            this.MW = new TurnBasedMatchBuffer(localDataHolder);
            label48:
            localDataHolder = a(paramBundle, 2);
            if (localDataHolder == null) {
                break label109;
            }
        }
        label101:
        label109:
        for (this.MX = new TurnBasedMatchBuffer(localDataHolder); ; this.MX = null) {
            paramBundle = a(paramBundle, 3);
            if (paramBundle == null) {
                break label117;
            }
            this.MY = new TurnBasedMatchBuffer(paramBundle);
            return;
            this.MV = null;
            break;
            this.MW = null;
            break label48;
        }
        label117:
        this.MY = null;
    }

    private static DataHolder a(Bundle paramBundle, int paramInt) {
        String str = TurnBasedMatchTurnStatus.bd(paramInt);
        if (!paramBundle.containsKey(str)) {
            return null;
        }
        return (DataHolder) paramBundle.getParcelable(str);
    }

    public void close() {
        if (this.MV != null) {
            this.MV.close();
        }
        if (this.MW != null) {
            this.MW.close();
        }
        if (this.MX != null) {
            this.MX.close();
        }
        if (this.MY != null) {
            this.MY.close();
        }
    }

    public TurnBasedMatchBuffer getCompletedMatches() {
        return this.MY;
    }

    public InvitationBuffer getInvitations() {
        return this.MV;
    }

    public TurnBasedMatchBuffer getMyTurnMatches() {
        return this.MW;
    }

    public TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.MX;
    }

    public boolean hasData() {
        if ((this.MV != null) && (this.MV.getCount() > 0)) {
        }
        while (((this.MW != null) && (this.MW.getCount() > 0)) || ((this.MX != null) && (this.MX.getCount() > 0)) || ((this.MY != null) && (this.MY.getCount() > 0))) {
            return true;
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/LoadMatchesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */