package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.achievement.OnAchievementUpdatedListener;
import com.google.android.gms.games.achievement.OnAchievementsLoadedListener;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.OnLeaderboardMetadataLoadedListener;
import com.google.android.gms.games.leaderboard.OnLeaderboardScoresLoadedListener;
import com.google.android.gms.games.leaderboard.OnPlayerLeaderboardScoreLoadedListener;
import com.google.android.gms.games.leaderboard.OnScoreSubmittedListener;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.leaderboard.SubmitScoreResult;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.OnInvitationsLoadedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.RealTimeReliableMessageSentListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchCanceledListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchInitiatedListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchLeftListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchLoadedListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdatedListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchesLoadedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.fl;
import java.util.List;

@Deprecated
public final class GamesClient
  implements GooglePlayServicesClient
{
  public static final String EXTRA_EXCLUSIVE_BIT_MASK = "exclusive_bit_mask";
  public static final String EXTRA_INVITATION = "invitation";
  public static final String EXTRA_MAX_AUTOMATCH_PLAYERS = "max_automatch_players";
  public static final String EXTRA_MIN_AUTOMATCH_PLAYERS = "min_automatch_players";
  public static final String EXTRA_PLAYERS = "players";
  public static final String EXTRA_PLAYER_SEARCH_RESULTS = "player_search_results";
  public static final String EXTRA_ROOM = "room";
  public static final String EXTRA_TURN_BASED_MATCH = "turn_based_match";
  public static final int MAX_RELIABLE_MESSAGE_LEN = 1400;
  public static final int MAX_UNRELIABLE_MESSAGE_LEN = 1168;
  public static final int NOTIFICATION_TYPES_ALL = -1;
  public static final int NOTIFICATION_TYPES_MULTIPLAYER = 3;
  public static final int NOTIFICATION_TYPE_INVITATION = 1;
  public static final int NOTIFICATION_TYPE_MATCH_UPDATE = 2;
  public static final int STATUS_ACHIEVEMENT_NOT_INCREMENTAL = 3002;
  public static final int STATUS_ACHIEVEMENT_UNKNOWN = 3001;
  public static final int STATUS_ACHIEVEMENT_UNLOCKED = 3003;
  public static final int STATUS_ACHIEVEMENT_UNLOCK_FAILURE = 3000;
  public static final int STATUS_APP_MISCONFIGURED = 8;
  public static final int STATUS_CLIENT_RECONNECT_REQUIRED = 2;
  public static final int STATUS_GAME_NOT_FOUND = 9;
  public static final int STATUS_INTERNAL_ERROR = 1;
  public static final int STATUS_INVALID_REAL_TIME_ROOM_ID = 7002;
  public static final int STATUS_LICENSE_CHECK_FAILED = 7;
  public static final int STATUS_MATCH_ERROR_ALREADY_REMATCHED = 6505;
  public static final int STATUS_MATCH_ERROR_INACTIVE_MATCH = 6501;
  public static final int STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS = 6504;
  public static final int STATUS_MATCH_ERROR_INVALID_MATCH_STATE = 6502;
  public static final int STATUS_MATCH_ERROR_INVALID_PARTICIPANT_STATE = 6500;
  public static final int STATUS_MATCH_ERROR_LOCALLY_MODIFIED = 6507;
  public static final int STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION = 6503;
  public static final int STATUS_MATCH_NOT_FOUND = 6506;
  public static final int STATUS_MULTIPLAYER_DISABLED = 6003;
  public static final int STATUS_MULTIPLAYER_ERROR_CREATION_NOT_ALLOWED = 6000;
  public static final int STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE = 6002;
  public static final int STATUS_MULTIPLAYER_ERROR_INVALID_OPERATION = 6004;
  public static final int STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER = 6001;
  public static final int STATUS_NETWORK_ERROR_NO_DATA = 4;
  public static final int STATUS_NETWORK_ERROR_OPERATION_DEFERRED = 5;
  public static final int STATUS_NETWORK_ERROR_OPERATION_FAILED = 6;
  public static final int STATUS_NETWORK_ERROR_STALE_DATA = 3;
  public static final int STATUS_OK = 0;
  public static final int STATUS_OPERATION_IN_FLIGHT = 7007;
  public static final int STATUS_PARTICIPANT_NOT_CONNECTED = 7003;
  public static final int STATUS_REAL_TIME_CONNECTION_FAILED = 7000;
  public static final int STATUS_REAL_TIME_INACTIVE_ROOM = 7005;
  public static final int STATUS_REAL_TIME_MESSAGE_FAILED = -1;
  public static final int STATUS_REAL_TIME_MESSAGE_SEND_FAILED = 7001;
  public static final int STATUS_REAL_TIME_ROOM_NOT_JOINED = 7004;
  private final fl te;
  
  private GamesClient(Context paramContext, String paramString1, String paramString2, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, String[] paramArrayOfString, int paramInt1, View paramView, boolean paramBoolean, int paramInt2)
  {
    this.te = new fl(paramContext, paramString1, paramString2, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString, paramInt1, paramView, false, paramBoolean, paramInt2);
  }
  
  @Deprecated
  public void acceptTurnBasedInvitation(final OnTurnBasedMatchInitiatedListener paramOnTurnBasedMatchInitiatedListener, String paramString)
  {
    this.te.e(new a.c()
    {
      public void a(TurnBasedMultiplayer.InitiateMatchResult paramAnonymousInitiateMatchResult)
      {
        int i = paramAnonymousInitiateMatchResult.getStatus().getStatusCode();
        paramOnTurnBasedMatchInitiatedListener.onTurnBasedMatchInitiated(i, paramAnonymousInitiateMatchResult.getMatch());
      }
    }, paramString);
  }
  
  @Deprecated
  public void cancelTurnBasedMatch(final OnTurnBasedMatchCanceledListener paramOnTurnBasedMatchCanceledListener, String paramString)
  {
    this.te.g(new a.c()
    {
      public void a(TurnBasedMultiplayer.CancelMatchResult paramAnonymousCancelMatchResult)
      {
        int i = paramAnonymousCancelMatchResult.getStatus().getStatusCode();
        paramOnTurnBasedMatchCanceledListener.onTurnBasedMatchCanceled(i, paramAnonymousCancelMatchResult.getMatchId());
      }
    }, paramString);
  }
  
  @Deprecated
  public void cancelTurnBasedMatch(String paramString)
  {
    this.te.g(new a.c()
    {
      public void a(TurnBasedMultiplayer.CancelMatchResult paramAnonymousCancelMatchResult) {}
    }, paramString);
  }
  
  @Deprecated
  public void clearAllNotifications()
  {
    this.te.clearNotifications(-1);
  }
  
  @Deprecated
  public void clearNotifications(int paramInt)
  {
    this.te.clearNotifications(paramInt);
  }
  
  @Deprecated
  public void connect()
  {
    this.te.connect();
  }
  
  @Deprecated
  public void createRoom(RoomConfig paramRoomConfig)
  {
    this.te.createRoom(paramRoomConfig);
  }
  
  @Deprecated
  public void createTurnBasedMatch(final OnTurnBasedMatchInitiatedListener paramOnTurnBasedMatchInitiatedListener, TurnBasedMatchConfig paramTurnBasedMatchConfig)
  {
    this.te.a(new a.c()
    {
      public void a(TurnBasedMultiplayer.InitiateMatchResult paramAnonymousInitiateMatchResult)
      {
        int i = paramAnonymousInitiateMatchResult.getStatus().getStatusCode();
        paramOnTurnBasedMatchInitiatedListener.onTurnBasedMatchInitiated(i, paramAnonymousInitiateMatchResult.getMatch());
      }
    }, paramTurnBasedMatchConfig);
  }
  
  @Deprecated
  public void declineRoomInvitation(String paramString)
  {
    this.te.j(paramString, 0);
  }
  
  @Deprecated
  public void declineTurnBasedInvitation(String paramString)
  {
    this.te.j(paramString, 1);
  }
  
  @Deprecated
  public void disconnect()
  {
    this.te.disconnect();
  }
  
  @Deprecated
  public void dismissRoomInvitation(String paramString)
  {
    this.te.i(paramString, 0);
  }
  
  @Deprecated
  public void dismissTurnBasedInvitation(String paramString)
  {
    this.te.i(paramString, 1);
  }
  
  @Deprecated
  public void dismissTurnBasedMatch(String paramString)
  {
    this.te.dismissTurnBasedMatch(paramString);
  }
  
  @Deprecated
  public void finishTurnBasedMatch(final OnTurnBasedMatchUpdatedListener paramOnTurnBasedMatchUpdatedListener, String paramString)
  {
    this.te.a(new a.c()
    {
      public void a(TurnBasedMultiplayer.UpdateMatchResult paramAnonymousUpdateMatchResult)
      {
        int i = paramAnonymousUpdateMatchResult.getStatus().getStatusCode();
        paramOnTurnBasedMatchUpdatedListener.onTurnBasedMatchUpdated(i, paramAnonymousUpdateMatchResult.getMatch());
      }
    }, paramString, null, null);
  }
  
  @Deprecated
  public void finishTurnBasedMatch(OnTurnBasedMatchUpdatedListener paramOnTurnBasedMatchUpdatedListener, String paramString, byte[] paramArrayOfByte, List<ParticipantResult> paramList)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = (ParticipantResult[])paramList.toArray(new ParticipantResult[paramList.size()]))
    {
      finishTurnBasedMatch(paramOnTurnBasedMatchUpdatedListener, paramString, paramArrayOfByte, paramList);
      return;
    }
  }
  
  @Deprecated
  public void finishTurnBasedMatch(final OnTurnBasedMatchUpdatedListener paramOnTurnBasedMatchUpdatedListener, String paramString, byte[] paramArrayOfByte, ParticipantResult... paramVarArgs)
  {
    this.te.a(new a.c()
    {
      public void a(TurnBasedMultiplayer.UpdateMatchResult paramAnonymousUpdateMatchResult)
      {
        int i = paramAnonymousUpdateMatchResult.getStatus().getStatusCode();
        paramOnTurnBasedMatchUpdatedListener.onTurnBasedMatchUpdated(i, paramAnonymousUpdateMatchResult.getMatch());
      }
    }, paramString, paramArrayOfByte, paramVarArgs);
  }
  
  @Deprecated
  public Intent getAchievementsIntent()
  {
    return this.te.getAchievementsIntent();
  }
  
  @Deprecated
  public Intent getAllLeaderboardsIntent()
  {
    return this.te.getAllLeaderboardsIntent();
  }
  
  @Deprecated
  public String getAppId()
  {
    return this.te.getAppId();
  }
  
  @Deprecated
  public String getCurrentAccountName()
  {
    return this.te.getCurrentAccountName();
  }
  
  @Deprecated
  public Game getCurrentGame()
  {
    return this.te.getCurrentGame();
  }
  
  @Deprecated
  public Player getCurrentPlayer()
  {
    return this.te.getCurrentPlayer();
  }
  
  @Deprecated
  public String getCurrentPlayerId()
  {
    return this.te.getCurrentPlayerId();
  }
  
  @Deprecated
  public Intent getInvitationInboxIntent()
  {
    return this.te.getInvitationInboxIntent();
  }
  
  @Deprecated
  public Intent getLeaderboardIntent(String paramString)
  {
    return this.te.getLeaderboardIntent(paramString);
  }
  
  @Deprecated
  public Intent getMatchInboxIntent()
  {
    return this.te.getMatchInboxIntent();
  }
  
  @Deprecated
  public int getMaxTurnBasedMatchDataSize()
  {
    return this.te.getMaxTurnBasedMatchDataSize();
  }
  
  @Deprecated
  public Intent getPlayerSearchIntent()
  {
    return this.te.getPlayerSearchIntent();
  }
  
  @Deprecated
  public Intent getRealTimeSelectOpponentsIntent(int paramInt1, int paramInt2)
  {
    return this.te.getRealTimeSelectOpponentsIntent(paramInt1, paramInt2, true);
  }
  
  @Deprecated
  public Intent getRealTimeSelectOpponentsIntent(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return this.te.getRealTimeSelectOpponentsIntent(paramInt1, paramInt2, paramBoolean);
  }
  
  @Deprecated
  public RealTimeSocket getRealTimeSocketForParticipant(String paramString1, String paramString2)
  {
    return this.te.getRealTimeSocketForParticipant(paramString1, paramString2);
  }
  
  @Deprecated
  public Intent getRealTimeWaitingRoomIntent(Room paramRoom, int paramInt)
  {
    return this.te.getRealTimeWaitingRoomIntent(paramRoom, paramInt);
  }
  
  @Deprecated
  public Intent getSettingsIntent()
  {
    return this.te.getSettingsIntent();
  }
  
  @Deprecated
  public void getTurnBasedMatch(final OnTurnBasedMatchLoadedListener paramOnTurnBasedMatchLoadedListener, String paramString)
  {
    this.te.h(new a.c()
    {
      public void a(TurnBasedMultiplayer.LoadMatchResult paramAnonymousLoadMatchResult)
      {
        int i = paramAnonymousLoadMatchResult.getStatus().getStatusCode();
        paramOnTurnBasedMatchLoadedListener.onTurnBasedMatchLoaded(i, paramAnonymousLoadMatchResult.getMatch());
      }
    }, paramString);
  }
  
  @Deprecated
  public Intent getTurnBasedSelectOpponentsIntent(int paramInt1, int paramInt2)
  {
    return this.te.getTurnBasedSelectOpponentsIntent(paramInt1, paramInt2, true);
  }
  
  @Deprecated
  public Intent getTurnBasedSelectOpponentsIntent(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return this.te.getTurnBasedSelectOpponentsIntent(paramInt1, paramInt2, paramBoolean);
  }
  
  @Deprecated
  public void incrementAchievement(String paramString, int paramInt)
  {
    this.te.a(null, paramString, paramInt);
  }
  
  @Deprecated
  public void incrementAchievementImmediate(final OnAchievementUpdatedListener paramOnAchievementUpdatedListener, String paramString, int paramInt)
  {
    this.te.a(new a.c()
    {
      public void a(Achievements.UpdateAchievementResult paramAnonymousUpdateAchievementResult)
      {
        int i = paramAnonymousUpdateAchievementResult.getStatus().getStatusCode();
        paramOnAchievementUpdatedListener.onAchievementUpdated(i, paramAnonymousUpdateAchievementResult.getAchievementId());
      }
    }, paramString, paramInt);
  }
  
  @Deprecated
  public boolean isConnected()
  {
    return this.te.isConnected();
  }
  
  @Deprecated
  public boolean isConnecting()
  {
    return this.te.isConnecting();
  }
  
  @Deprecated
  public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.te.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  @Deprecated
  public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.te.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  @Deprecated
  public void joinRoom(RoomConfig paramRoomConfig)
  {
    this.te.joinRoom(paramRoomConfig);
  }
  
  @Deprecated
  public void leaveRoom(RoomUpdateListener paramRoomUpdateListener, String paramString)
  {
    this.te.leaveRoom(paramRoomUpdateListener, paramString);
  }
  
  @Deprecated
  public void leaveTurnBasedMatch(final OnTurnBasedMatchLeftListener paramOnTurnBasedMatchLeftListener, String paramString)
  {
    this.te.f(new a.c()
    {
      public void a(TurnBasedMultiplayer.LeaveMatchResult paramAnonymousLeaveMatchResult)
      {
        int i = paramAnonymousLeaveMatchResult.getStatus().getStatusCode();
        paramOnTurnBasedMatchLeftListener.onTurnBasedMatchLeft(i, paramAnonymousLeaveMatchResult.getMatch());
      }
    }, paramString);
  }
  
  @Deprecated
  public void leaveTurnBasedMatchDuringTurn(final OnTurnBasedMatchLeftListener paramOnTurnBasedMatchLeftListener, String paramString1, String paramString2)
  {
    this.te.a(new a.c()
    {
      public void a(TurnBasedMultiplayer.LeaveMatchResult paramAnonymousLeaveMatchResult)
      {
        int i = paramAnonymousLeaveMatchResult.getStatus().getStatusCode();
        paramOnTurnBasedMatchLeftListener.onTurnBasedMatchLeft(i, paramAnonymousLeaveMatchResult.getMatch());
      }
    }, paramString1, paramString2);
  }
  
  @Deprecated
  public void loadAchievements(final OnAchievementsLoadedListener paramOnAchievementsLoadedListener, boolean paramBoolean)
  {
    this.te.b(new a.c()
    {
      public void a(Achievements.LoadAchievementsResult paramAnonymousLoadAchievementsResult)
      {
        int i = paramAnonymousLoadAchievementsResult.getStatus().getStatusCode();
        paramOnAchievementsLoadedListener.onAchievementsLoaded(i, paramAnonymousLoadAchievementsResult.getAchievements());
      }
    }, paramBoolean);
  }
  
  @Deprecated
  public void loadCurrentPlayerLeaderboardScore(final OnPlayerLeaderboardScoreLoadedListener paramOnPlayerLeaderboardScoreLoadedListener, String paramString, int paramInt1, int paramInt2)
  {
    this.te.a(new a.c()
    {
      public void a(Leaderboards.LoadPlayerScoreResult paramAnonymousLoadPlayerScoreResult)
      {
        int i = paramAnonymousLoadPlayerScoreResult.getStatus().getStatusCode();
        paramOnPlayerLeaderboardScoreLoadedListener.onPlayerLeaderboardScoreLoaded(i, paramAnonymousLoadPlayerScoreResult.getScore());
      }
    }, null, paramString, paramInt1, paramInt2);
  }
  
  @Deprecated
  public void loadGame(final OnGamesLoadedListener paramOnGamesLoadedListener)
  {
    this.te.g(new a.c()
    {
      public void a(GamesMetadata.LoadGamesResult paramAnonymousLoadGamesResult)
      {
        paramOnGamesLoadedListener.onGamesLoaded(paramAnonymousLoadGamesResult.getStatus().getStatusCode(), paramAnonymousLoadGamesResult.getGames());
      }
    });
  }
  
  @Deprecated
  public void loadInvitablePlayers(final OnPlayersLoadedListener paramOnPlayersLoadedListener, int paramInt, boolean paramBoolean)
  {
    this.te.a(new a.c()
    {
      public void a(Players.LoadPlayersResult paramAnonymousLoadPlayersResult)
      {
        paramOnPlayersLoadedListener.onPlayersLoaded(paramAnonymousLoadPlayersResult.getStatus().getStatusCode(), paramAnonymousLoadPlayersResult.getPlayers());
      }
    }, paramInt, false, paramBoolean);
  }
  
  @Deprecated
  public void loadInvitations(final OnInvitationsLoadedListener paramOnInvitationsLoadedListener)
  {
    this.te.h(new a.c()
    {
      public void a(Invitations.LoadInvitationsResult paramAnonymousLoadInvitationsResult)
      {
        int i = paramAnonymousLoadInvitationsResult.getStatus().getStatusCode();
        paramOnInvitationsLoadedListener.onInvitationsLoaded(i, paramAnonymousLoadInvitationsResult.getInvitations());
      }
    });
  }
  
  @Deprecated
  public void loadLeaderboardMetadata(final OnLeaderboardMetadataLoadedListener paramOnLeaderboardMetadataLoadedListener, String paramString, boolean paramBoolean)
  {
    this.te.a(new a.c()
    {
      public void a(Leaderboards.LeaderboardMetadataResult paramAnonymousLeaderboardMetadataResult)
      {
        int i = paramAnonymousLeaderboardMetadataResult.getStatus().getStatusCode();
        paramOnLeaderboardMetadataLoadedListener.onLeaderboardMetadataLoaded(i, paramAnonymousLeaderboardMetadataResult.getLeaderboards());
      }
    }, paramString, paramBoolean);
  }
  
  @Deprecated
  public void loadLeaderboardMetadata(final OnLeaderboardMetadataLoadedListener paramOnLeaderboardMetadataLoadedListener, boolean paramBoolean)
  {
    this.te.a(new a.c()
    {
      public void a(Leaderboards.LeaderboardMetadataResult paramAnonymousLeaderboardMetadataResult)
      {
        int i = paramAnonymousLeaderboardMetadataResult.getStatus().getStatusCode();
        paramOnLeaderboardMetadataLoadedListener.onLeaderboardMetadataLoaded(i, paramAnonymousLeaderboardMetadataResult.getLeaderboards());
      }
    }, paramBoolean);
  }
  
  @Deprecated
  public void loadMoreInvitablePlayers(final OnPlayersLoadedListener paramOnPlayersLoadedListener, int paramInt)
  {
    this.te.a(new a.c()
    {
      public void a(Players.LoadPlayersResult paramAnonymousLoadPlayersResult)
      {
        paramOnPlayersLoadedListener.onPlayersLoaded(paramAnonymousLoadPlayersResult.getStatus().getStatusCode(), paramAnonymousLoadPlayersResult.getPlayers());
      }
    }, paramInt, true, false);
  }
  
  @Deprecated
  public void loadMoreScores(final OnLeaderboardScoresLoadedListener paramOnLeaderboardScoresLoadedListener, LeaderboardScoreBuffer paramLeaderboardScoreBuffer, int paramInt1, int paramInt2)
  {
    this.te.a(new a.c()
    {
      public void a(Leaderboards.LoadScoresResult paramAnonymousLoadScoresResult)
      {
        int i = paramAnonymousLoadScoresResult.getStatus().getStatusCode();
        paramOnLeaderboardScoresLoadedListener.onLeaderboardScoresLoaded(i, paramAnonymousLoadScoresResult.getLeaderboard(), paramAnonymousLoadScoresResult.getScores());
      }
    }, paramLeaderboardScoreBuffer, paramInt1, paramInt2);
  }
  
  @Deprecated
  public void loadPlayer(final OnPlayersLoadedListener paramOnPlayersLoadedListener, String paramString)
  {
    this.te.a(new a.c()
    {
      public void a(Players.LoadPlayersResult paramAnonymousLoadPlayersResult)
      {
        paramOnPlayersLoadedListener.onPlayersLoaded(paramAnonymousLoadPlayersResult.getStatus().getStatusCode(), paramAnonymousLoadPlayersResult.getPlayers());
      }
    }, paramString);
  }
  
  @Deprecated
  public void loadPlayerCenteredScores(final OnLeaderboardScoresLoadedListener paramOnLeaderboardScoresLoadedListener, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.te.b(new a.c()
    {
      public void a(Leaderboards.LoadScoresResult paramAnonymousLoadScoresResult)
      {
        int i = paramAnonymousLoadScoresResult.getStatus().getStatusCode();
        paramOnLeaderboardScoresLoadedListener.onLeaderboardScoresLoaded(i, paramAnonymousLoadScoresResult.getLeaderboard(), paramAnonymousLoadScoresResult.getScores());
      }
    }, paramString, paramInt1, paramInt2, paramInt3, false);
  }
  
  @Deprecated
  public void loadPlayerCenteredScores(final OnLeaderboardScoresLoadedListener paramOnLeaderboardScoresLoadedListener, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.te.b(new a.c()
    {
      public void a(Leaderboards.LoadScoresResult paramAnonymousLoadScoresResult)
      {
        int i = paramAnonymousLoadScoresResult.getStatus().getStatusCode();
        paramOnLeaderboardScoresLoadedListener.onLeaderboardScoresLoaded(i, paramAnonymousLoadScoresResult.getLeaderboard(), paramAnonymousLoadScoresResult.getScores());
      }
    }, paramString, paramInt1, paramInt2, paramInt3, paramBoolean);
  }
  
  @Deprecated
  public void loadTopScores(final OnLeaderboardScoresLoadedListener paramOnLeaderboardScoresLoadedListener, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.te.a(new a.c()
    {
      public void a(Leaderboards.LoadScoresResult paramAnonymousLoadScoresResult)
      {
        int i = paramAnonymousLoadScoresResult.getStatus().getStatusCode();
        paramOnLeaderboardScoresLoadedListener.onLeaderboardScoresLoaded(i, paramAnonymousLoadScoresResult.getLeaderboard(), paramAnonymousLoadScoresResult.getScores());
      }
    }, paramString, paramInt1, paramInt2, paramInt3, false);
  }
  
  @Deprecated
  public void loadTopScores(final OnLeaderboardScoresLoadedListener paramOnLeaderboardScoresLoadedListener, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.te.a(new a.c()
    {
      public void a(Leaderboards.LoadScoresResult paramAnonymousLoadScoresResult)
      {
        int i = paramAnonymousLoadScoresResult.getStatus().getStatusCode();
        paramOnLeaderboardScoresLoadedListener.onLeaderboardScoresLoaded(i, paramAnonymousLoadScoresResult.getLeaderboard(), paramAnonymousLoadScoresResult.getScores());
      }
    }, paramString, paramInt1, paramInt2, paramInt3, paramBoolean);
  }
  
  @Deprecated
  public void loadTurnBasedMatches(final OnTurnBasedMatchesLoadedListener paramOnTurnBasedMatchesLoadedListener, int... paramVarArgs)
  {
    this.te.a(new a.c()
    {
      public void a(TurnBasedMultiplayer.LoadMatchesResult paramAnonymousLoadMatchesResult)
      {
        int i = paramAnonymousLoadMatchesResult.getStatus().getStatusCode();
        paramOnTurnBasedMatchesLoadedListener.onTurnBasedMatchesLoaded(i, paramAnonymousLoadMatchesResult.getMatches());
      }
    }, paramVarArgs);
  }
  
  @Deprecated
  public void reconnect()
  {
    this.te.disconnect();
    this.te.connect();
  }
  
  @Deprecated
  public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.te.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  @Deprecated
  public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.te.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  @Deprecated
  public void registerInvitationListener(OnInvitationReceivedListener paramOnInvitationReceivedListener)
  {
    this.te.registerInvitationListener(paramOnInvitationReceivedListener);
  }
  
  @Deprecated
  public void registerMatchUpdateListener(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
  {
    this.te.registerMatchUpdateListener(paramOnTurnBasedMatchUpdateReceivedListener);
  }
  
  @Deprecated
  public void rematchTurnBasedMatch(final OnTurnBasedMatchInitiatedListener paramOnTurnBasedMatchInitiatedListener, String paramString)
  {
    this.te.d(new a.c()
    {
      public void a(TurnBasedMultiplayer.InitiateMatchResult paramAnonymousInitiateMatchResult)
      {
        int i = paramAnonymousInitiateMatchResult.getStatus().getStatusCode();
        paramOnTurnBasedMatchInitiatedListener.onTurnBasedMatchInitiated(i, paramAnonymousInitiateMatchResult.getMatch());
      }
    }, paramString);
  }
  
  @Deprecated
  public void revealAchievement(String paramString)
  {
    this.te.b(null, paramString);
  }
  
  @Deprecated
  public void revealAchievementImmediate(final OnAchievementUpdatedListener paramOnAchievementUpdatedListener, String paramString)
  {
    this.te.b(new a.c()
    {
      public void a(Achievements.UpdateAchievementResult paramAnonymousUpdateAchievementResult)
      {
        int i = paramAnonymousUpdateAchievementResult.getStatus().getStatusCode();
        paramOnAchievementUpdatedListener.onAchievementUpdated(i, paramAnonymousUpdateAchievementResult.getAchievementId());
      }
    }, paramString);
  }
  
  @Deprecated
  public int sendReliableRealTimeMessage(final RealTimeReliableMessageSentListener paramRealTimeReliableMessageSentListener, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    this.te.a(new RealTimeMultiplayer.ReliableMessageSentCallback()
    {
      public void onRealTimeMessageSent(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        paramRealTimeReliableMessageSentListener.onRealTimeMessageSent(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString);
      }
    }, paramArrayOfByte, paramString1, paramString2);
  }
  
  @Deprecated
  public int sendUnreliableRealTimeMessage(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    return this.te.a(paramArrayOfByte, paramString1, new String[] { paramString2 });
  }
  
  @Deprecated
  public int sendUnreliableRealTimeMessage(byte[] paramArrayOfByte, String paramString, List<String> paramList)
  {
    paramList = (String[])paramList.toArray(new String[paramList.size()]);
    return this.te.a(paramArrayOfByte, paramString, paramList);
  }
  
  @Deprecated
  public int sendUnreliableRealTimeMessageToAll(byte[] paramArrayOfByte, String paramString)
  {
    return this.te.sendUnreliableRealTimeMessageToAll(paramArrayOfByte, paramString);
  }
  
  @Deprecated
  public void setAchievementSteps(String paramString, int paramInt)
  {
    this.te.b(null, paramString, paramInt);
  }
  
  @Deprecated
  public void setAchievementStepsImmediate(final OnAchievementUpdatedListener paramOnAchievementUpdatedListener, String paramString, int paramInt)
  {
    this.te.b(new a.c()
    {
      public void a(Achievements.UpdateAchievementResult paramAnonymousUpdateAchievementResult)
      {
        int i = paramAnonymousUpdateAchievementResult.getStatus().getStatusCode();
        paramOnAchievementUpdatedListener.onAchievementUpdated(i, paramAnonymousUpdateAchievementResult.getAchievementId());
      }
    }, paramString, paramInt);
  }
  
  @Deprecated
  public void setGravityForPopups(int paramInt)
  {
    this.te.setGravityForPopups(paramInt);
  }
  
  @Deprecated
  public void setViewForPopups(View paramView)
  {
    eg.f(paramView);
    this.te.setViewForPopups(paramView);
  }
  
  @Deprecated
  public void signOut()
  {
    this.te.b(new a.c()
    {
      public void a(Status paramAnonymousStatus) {}
    });
  }
  
  @Deprecated
  public void signOut(final OnSignOutCompleteListener paramOnSignOutCompleteListener)
  {
    this.te.b(new a.c()
    {
      public void a(Status paramAnonymousStatus)
      {
        paramOnSignOutCompleteListener.onSignOutComplete();
      }
    });
  }
  
  @Deprecated
  public void submitScore(String paramString, long paramLong)
  {
    this.te.a(null, paramString, paramLong, null);
  }
  
  @Deprecated
  public void submitScore(String paramString1, long paramLong, String paramString2)
  {
    this.te.a(null, paramString1, paramLong, paramString2);
  }
  
  @Deprecated
  public void submitScoreImmediate(final OnScoreSubmittedListener paramOnScoreSubmittedListener, String paramString, long paramLong)
  {
    this.te.a(new a.c()
    {
      public void a(Leaderboards.SubmitScoreResult paramAnonymousSubmitScoreResult)
      {
        int i = paramAnonymousSubmitScoreResult.getStatus().getStatusCode();
        paramAnonymousSubmitScoreResult = new SubmitScoreResult(paramAnonymousSubmitScoreResult.getScoreData().dx());
        paramOnScoreSubmittedListener.onScoreSubmitted(i, paramAnonymousSubmitScoreResult);
      }
    }, paramString, paramLong, null);
  }
  
  @Deprecated
  public void submitScoreImmediate(final OnScoreSubmittedListener paramOnScoreSubmittedListener, String paramString1, long paramLong, String paramString2)
  {
    this.te.a(new a.c()
    {
      public void a(Leaderboards.SubmitScoreResult paramAnonymousSubmitScoreResult)
      {
        int i = paramAnonymousSubmitScoreResult.getStatus().getStatusCode();
        paramAnonymousSubmitScoreResult = new SubmitScoreResult(paramAnonymousSubmitScoreResult.getScoreData().dx());
        paramOnScoreSubmittedListener.onScoreSubmitted(i, paramAnonymousSubmitScoreResult);
      }
    }, paramString1, paramLong, paramString2);
  }
  
  @Deprecated
  public void takeTurn(final OnTurnBasedMatchUpdatedListener paramOnTurnBasedMatchUpdatedListener, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.te.a(new a.c()
    {
      public void a(TurnBasedMultiplayer.UpdateMatchResult paramAnonymousUpdateMatchResult)
      {
        int i = paramAnonymousUpdateMatchResult.getStatus().getStatusCode();
        paramOnTurnBasedMatchUpdatedListener.onTurnBasedMatchUpdated(i, paramAnonymousUpdateMatchResult.getMatch());
      }
    }, paramString1, paramArrayOfByte, paramString2, null);
  }
  
  @Deprecated
  public void takeTurn(final OnTurnBasedMatchUpdatedListener paramOnTurnBasedMatchUpdatedListener, String paramString1, byte[] paramArrayOfByte, String paramString2, List<ParticipantResult> paramList)
  {
    if (paramList == null) {}
    for (paramList = null;; paramList = (ParticipantResult[])paramList.toArray(new ParticipantResult[paramList.size()]))
    {
      this.te.a(new a.c()
      {
        public void a(TurnBasedMultiplayer.UpdateMatchResult paramAnonymousUpdateMatchResult)
        {
          int i = paramAnonymousUpdateMatchResult.getStatus().getStatusCode();
          paramOnTurnBasedMatchUpdatedListener.onTurnBasedMatchUpdated(i, paramAnonymousUpdateMatchResult.getMatch());
        }
      }, paramString1, paramArrayOfByte, paramString2, paramList);
      return;
    }
  }
  
  @Deprecated
  public void takeTurn(final OnTurnBasedMatchUpdatedListener paramOnTurnBasedMatchUpdatedListener, String paramString1, byte[] paramArrayOfByte, String paramString2, ParticipantResult... paramVarArgs)
  {
    this.te.a(new a.c()
    {
      public void a(TurnBasedMultiplayer.UpdateMatchResult paramAnonymousUpdateMatchResult)
      {
        int i = paramAnonymousUpdateMatchResult.getStatus().getStatusCode();
        paramOnTurnBasedMatchUpdatedListener.onTurnBasedMatchUpdated(i, paramAnonymousUpdateMatchResult.getMatch());
      }
    }, paramString1, paramArrayOfByte, paramString2, paramVarArgs);
  }
  
  @Deprecated
  public void unlockAchievement(String paramString)
  {
    this.te.c(null, paramString);
  }
  
  @Deprecated
  public void unlockAchievementImmediate(final OnAchievementUpdatedListener paramOnAchievementUpdatedListener, String paramString)
  {
    this.te.c(new a.c()
    {
      public void a(Achievements.UpdateAchievementResult paramAnonymousUpdateAchievementResult)
      {
        int i = paramAnonymousUpdateAchievementResult.getStatus().getStatusCode();
        paramOnAchievementUpdatedListener.onAchievementUpdated(i, paramAnonymousUpdateAchievementResult.getAchievementId());
      }
    }, paramString);
  }
  
  @Deprecated
  public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.te.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  @Deprecated
  public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.te.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  @Deprecated
  public void unregisterInvitationListener()
  {
    this.te.unregisterInvitationListener();
  }
  
  @Deprecated
  public void unregisterMatchUpdateListener()
  {
    this.te.unregisterMatchUpdateListener();
  }
  
  @Deprecated
  public static final class Builder
  {
    private final GooglePlayServicesClient.ConnectionCallbacks jD;
    private final GooglePlayServicesClient.OnConnectionFailedListener jE;
    private String[] jF = { "https://www.googleapis.com/auth/games" };
    private String jG = "<<default account>>";
    private final Context mContext;
    private boolean tA = true;
    private int tB = 17;
    private String tx;
    private int ty = 49;
    private View tz;
    
    public Builder(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      this.mContext = paramContext;
      this.tx = paramContext.getPackageName();
      this.jD = paramConnectionCallbacks;
      this.jE = paramOnConnectionFailedListener;
    }
    
    public GamesClient create()
    {
      return new GamesClient(this.mContext, this.tx, this.jG, this.jD, this.jE, this.jF, this.ty, this.tz, this.tA, this.tB, null);
    }
    
    public Builder setAccountName(String paramString)
    {
      this.jG = ((String)eg.f(paramString));
      return this;
    }
    
    public Builder setGravityForPopups(int paramInt)
    {
      this.ty = paramInt;
      return this;
    }
    
    public Builder setScopes(String... paramVarArgs)
    {
      this.jF = paramVarArgs;
      return this;
    }
    
    public Builder setShowConnectingPopup(boolean paramBoolean)
    {
      this.tA = paramBoolean;
      this.tB = 17;
      return this;
    }
    
    public Builder setShowConnectingPopup(boolean paramBoolean, int paramInt)
    {
      this.tA = paramBoolean;
      this.tB = paramInt;
      return this;
    }
    
    public Builder setViewForPopups(View paramView)
    {
      this.tz = ((View)eg.f(paramView));
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/games/GamesClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */