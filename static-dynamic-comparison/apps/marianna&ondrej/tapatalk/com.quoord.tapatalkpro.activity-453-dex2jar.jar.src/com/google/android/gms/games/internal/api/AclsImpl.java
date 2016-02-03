package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;

public final class AclsImpl
        implements Acls {
    private static Acls.LoadAclResult v(Status paramStatus) {
        new Acls.LoadAclResult() {
            public Status getStatus() {
                return this.wz;
            }

            public void release() {
            }
        };
    }

    private static abstract class LoadNotifyAclImpl
            extends Games.BaseGamesApiMethodImpl<Acls.LoadAclResult> {
        public Acls.LoadAclResult x(Status paramStatus) {
            return AclsImpl.w(paramStatus);
        }
    }

    private static abstract class UpdateNotifyAclImpl
            extends Games.BaseGamesApiMethodImpl<Status> {
        public Status f(Status paramStatus) {
            return paramStatus;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/internal/api/AclsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */