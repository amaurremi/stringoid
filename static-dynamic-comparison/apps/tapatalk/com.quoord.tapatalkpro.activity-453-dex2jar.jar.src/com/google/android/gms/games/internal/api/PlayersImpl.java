package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadExtendedPlayersResult;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl
        implements Players {
    public Player getCurrentPlayer(GoogleApiClient paramGoogleApiClient) {
        return Games.c(paramGoogleApiClient).gn();
    }

    public String getCurrentPlayerId(GoogleApiClient paramGoogleApiClient) {
        return Games.c(paramGoogleApiClient).gm();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient paramGoogleApiClient) {
        return Games.c(paramGoogleApiClient).gw();
    }

    public PendingResult<Players.LoadPlayersResult> loadConnectedPlayers(GoogleApiClient paramGoogleApiClient, final boolean paramBoolean) {
        paramGoogleApiClient.a(new LoadPlayersImpl(paramBoolean) {
            protected void a(GamesClientImpl paramAnonymousGamesClientImpl) {
                paramAnonymousGamesClientImpl.a(this, paramBoolean);
            }
        });
    }

    public PendingResult<Players.LoadPlayersResult> loadInvitablePlayers(GoogleApiClient paramGoogleApiClient, final int paramInt, final boolean paramBoolean) {
        paramGoogleApiClient.a(new LoadPlayersImpl(paramInt) {
            protected void a(GamesClientImpl paramAnonymousGamesClientImpl) {
                paramAnonymousGamesClientImpl.a(this, paramInt, false, paramBoolean);
            }
        });
    }

    public PendingResult<Players.LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient paramGoogleApiClient, final int paramInt) {
        paramGoogleApiClient.a(new LoadPlayersImpl(paramInt) {
            protected void a(GamesClientImpl paramAnonymousGamesClientImpl) {
                paramAnonymousGamesClientImpl.a(this, paramInt, true, false);
            }
        });
    }

    public PendingResult<Players.LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient paramGoogleApiClient, final int paramInt) {
        paramGoogleApiClient.a(new LoadPlayersImpl(paramInt) {
            protected void a(GamesClientImpl paramAnonymousGamesClientImpl) {
                paramAnonymousGamesClientImpl.a(this, "playedWith", paramInt, true, false);
            }
        });
    }

    public PendingResult<Players.LoadPlayersResult> loadPlayer(GoogleApiClient paramGoogleApiClient, final String paramString) {
        paramGoogleApiClient.a(new LoadPlayersImpl(paramString) {
            protected void a(GamesClientImpl paramAnonymousGamesClientImpl) {
                paramAnonymousGamesClientImpl.a(this, paramString);
            }
        });
    }

    public PendingResult<Players.LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient paramGoogleApiClient, final int paramInt, final boolean paramBoolean) {
        paramGoogleApiClient.a(new LoadPlayersImpl(paramInt) {
            protected void a(GamesClientImpl paramAnonymousGamesClientImpl) {
                paramAnonymousGamesClientImpl.a(this, "playedWith", paramInt, false, paramBoolean);
            }
        });
    }

    private static abstract class LoadExtendedPlayersImpl
            extends Games.BaseGamesApiMethodImpl<Players.LoadExtendedPlayersResult> {
        public Players.LoadExtendedPlayersResult K(final Status paramStatus) {
            new Players.LoadExtendedPlayersResult() {
                public Status getStatus() {
                    return paramStatus;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadOwnerCoverPhotoUrisImpl
            extends Games.BaseGamesApiMethodImpl<Players.LoadOwnerCoverPhotoUrisResult> {
        public Players.LoadOwnerCoverPhotoUrisResult L(final Status paramStatus) {
            new Players.LoadOwnerCoverPhotoUrisResult() {
                public Status getStatus() {
                    return paramStatus;
                }
            };
        }
    }

    private static abstract class LoadPlayersImpl
            extends Games.BaseGamesApiMethodImpl<Players.LoadPlayersResult> {
        public Players.LoadPlayersResult M(final Status paramStatus) {
            new Players.LoadPlayersResult() {
                public PlayerBuffer getPlayers() {
                    return new PlayerBuffer(DataHolder.empty(14));
                }

                public Status getStatus() {
                    return paramStatus;
                }

                public void release() {
                }
            };
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/internal/api/PlayersImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */