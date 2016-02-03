package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.d.b;
import com.google.android.gms.common.internal.d.d;
import com.google.android.gms.common.internal.d.e;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;
import com.google.android.gms.games.internal.game.ExtendedGameBuffer;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBufferHeader;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.internal.kc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class GamesClientImpl
  extends d<IGamesService>
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private final String Dd;
  EventIncrementManager Wh = new EventIncrementManager()
  {
    public EventIncrementCache kv()
    {
      return new GamesClientImpl.GameClientEventIncrementCache(GamesClientImpl.this);
    }
  };
  private final String Wi;
  private final Map<String, RealTimeSocket> Wj;
  private PlayerEntity Wk;
  private GameEntity Wl;
  private final PopupManager Wm;
  private boolean Wn = false;
  private final Binder Wo;
  private final long Wp;
  private final Games.GamesOptions Wq;
  
  public GamesClientImpl(Context paramContext, Looper paramLooper, String paramString1, String paramString2, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String[] paramArrayOfString, int paramInt, View paramView, Games.GamesOptions paramGamesOptions)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString);
    this.Wi = paramString1;
    this.Dd = ((String)n.i(paramString2));
    this.Wo = new Binder();
    this.Wj = new HashMap();
    this.Wm = PopupManager.a(this, paramInt);
    k(paramView);
    this.Wp = hashCode();
    this.Wq = paramGamesOptions;
    registerConnectionCallbacks(this);
    registerConnectionFailedListener(this);
  }
  
  private Room R(DataHolder paramDataHolder)
  {
    RoomBuffer localRoomBuffer = new RoomBuffer(paramDataHolder);
    paramDataHolder = null;
    try
    {
      if (localRoomBuffer.getCount() > 0) {
        paramDataHolder = (Room)((Room)localRoomBuffer.get(0)).freeze();
      }
      return paramDataHolder;
    }
    finally
    {
      localRoomBuffer.release();
    }
  }
  
  private RealTimeSocket bw(String paramString)
  {
    if (kc.hD()) {}
    for (RealTimeSocket localRealTimeSocket = by(paramString);; localRealTimeSocket = bx(paramString))
    {
      if (localRealTimeSocket != null) {
        this.Wj.put(paramString, localRealTimeSocket);
      }
      return localRealTimeSocket;
    }
  }
  
  private RealTimeSocket bx(String paramString)
  {
    try
    {
      String str = ((IGamesService)gS()).bC(paramString);
      if (str == null) {
        return null;
      }
      LocalSocket localLocalSocket = new LocalSocket();
      localLocalSocket.connect(new LocalSocketAddress(str));
      paramString = new RealTimeSocketImpl(localLocalSocket, paramString);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      GamesLog.q("GamesClientImpl", "Unable to create socket. Service died.");
      return null;
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        GamesLog.q("GamesClientImpl", "connect() call failed on socket: " + paramString.getMessage());
      }
    }
  }
  
  private RealTimeSocket by(String paramString)
  {
    try
    {
      ParcelFileDescriptor localParcelFileDescriptor = ((IGamesService)gS()).bH(paramString);
      if (localParcelFileDescriptor != null)
      {
        GamesLog.o("GamesClientImpl", "Created native libjingle socket.");
        return new LibjingleNativeSocket(localParcelFileDescriptor);
      }
      GamesLog.q("GamesClientImpl", "Unable to create socket for " + paramString);
      return null;
    }
    catch (RemoteException paramString)
    {
      GamesLog.q("GamesClientImpl", "Unable to create socket. Service died.");
    }
    return null;
  }
  
  private void jW()
  {
    this.Wk = null;
  }
  
  private void kt()
  {
    Iterator localIterator = this.Wj.values().iterator();
    while (localIterator.hasNext())
    {
      RealTimeSocket localRealTimeSocket = (RealTimeSocket)localIterator.next();
      try
      {
        localRealTimeSocket.close();
      }
      catch (IOException localIOException)
      {
        GamesLog.c("GamesClientImpl", "IOException:", localIOException);
      }
    }
    this.Wj.clear();
  }
  
  public int a(RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    try
    {
      int i = ((IGamesService)gS()).a(new RealTimeReliableMessageBinderCallbacks(paramReliableMessageSentCallback), paramArrayOfByte, paramString1, paramString2);
      return i;
    }
    catch (RemoteException paramReliableMessageSentCallback)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public int a(byte[] paramArrayOfByte, String paramString, String[] paramArrayOfString)
  {
    n.b(paramArrayOfString, "Participant IDs must not be null");
    try
    {
      int i = ((IGamesService)gS()).b(paramArrayOfByte, paramString, paramArrayOfString);
      return i;
    }
    catch (RemoteException paramArrayOfByte)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public Intent a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = ((IGamesService)gS()).a(paramInt1, paramInt2, paramBoolean);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, Bitmap paramBitmap, String paramString)
  {
    try
    {
      paramArrayOfByte = ((IGamesService)gS()).a(paramInt1, paramArrayOfByte, paramInt2, paramString);
      n.b(paramBitmap, "Must provide a non null icon");
      paramArrayOfByte.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", paramBitmap);
      return paramArrayOfByte;
    }
    catch (RemoteException paramArrayOfByte)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent a(Room paramRoom, int paramInt)
  {
    try
    {
      paramRoom = ((IGamesService)gS()).a((RoomEntity)paramRoom.freeze(), paramInt);
      return paramRoom;
    }
    catch (RemoteException paramRoom)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    try
    {
      paramString = ((IGamesService)gS()).a(paramString, paramBoolean1, paramBoolean2, paramInt);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return null;
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBundle != null)) {
      this.Wn = paramBundle.getBoolean("show_welcome_popup");
    }
    super.a(paramInt, paramIBinder, paramBundle);
  }
  
  public void a(IBinder paramIBinder, Bundle paramBundle)
  {
    if (isConnected()) {}
    try
    {
      ((IGamesService)gS()).a(paramIBinder, paramBundle);
      return;
    }
    catch (RemoteException paramIBinder)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Requests.LoadRequestsResult> paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      ((IGamesService)gS()).a(new RequestsLoadedBinderCallbacks(paramb), paramInt1, paramInt2, paramInt3);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<GamesMetadata.LoadExtendedGamesResult> paramb, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)gS()).a(new ExtendedGamesLoadedBinderCallback(paramb), paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Players.LoadPlayersResult> paramb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)gS()).a(new PlayersLoadedBinderCallback(paramb), paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<TurnBasedMultiplayer.LoadMatchesResult> paramb, int paramInt, int[] paramArrayOfInt)
  {
    try
    {
      ((IGamesService)gS()).a(new TurnBasedMatchesLoadedBinderCallbacks(paramb), paramInt, paramArrayOfInt);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Leaderboards.LoadScoresResult> paramb, LeaderboardScoreBuffer paramLeaderboardScoreBuffer, int paramInt1, int paramInt2)
  {
    try
    {
      ((IGamesService)gS()).a(new LeaderboardScoresLoadedBinderCallback(paramb), paramLeaderboardScoreBuffer.ly().lz(), paramInt1, paramInt2);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<TurnBasedMultiplayer.InitiateMatchResult> paramb, TurnBasedMatchConfig paramTurnBasedMatchConfig)
  {
    try
    {
      ((IGamesService)gS()).a(new TurnBasedMatchInitiatedBinderCallbacks(paramb), paramTurnBasedMatchConfig.getVariant(), paramTurnBasedMatchConfig.lF(), paramTurnBasedMatchConfig.getInvitedPlayerIds(), paramTurnBasedMatchConfig.getAutoMatchCriteria());
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Snapshots.CommitSnapshotResult> paramb, Snapshot paramSnapshot, SnapshotMetadataChange paramSnapshotMetadataChange)
  {
    SnapshotContents localSnapshotContents = paramSnapshot.getSnapshotContents();
    if (!localSnapshotContents.isClosed()) {}
    for (boolean bool = true;; bool = false)
    {
      n.a(bool, "Snapshot already closed");
      Object localObject = paramSnapshotMetadataChange.lK();
      if (localObject != null) {
        ((com.google.android.gms.common.data.a)localObject).a(getContext().getCacheDir());
      }
      localObject = localSnapshotContents.getContents();
      localSnapshotContents.close();
      try
      {
        ((IGamesService)gS()).a(new SnapshotCommittedBinderCallbacks(paramb), paramSnapshot.getMetadata().getSnapshotId(), paramSnapshotMetadataChange, (Contents)localObject);
        return;
      }
      catch (RemoteException paramb)
      {
        GamesLog.p("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(BaseImplementation.b<Players.LoadPlayersResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)gS()).a(new PlayersLoadedBinderCallback(paramb), paramString);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Achievements.UpdateAchievementResult> paramb, String paramString, int paramInt)
  {
    if (paramb == null) {}
    for (paramb = null;; paramb = new AchievementUpdatedBinderCallback(paramb)) {
      try
      {
        ((IGamesService)gS()).a(paramb, paramString, paramInt, this.Wm.kL(), this.Wm.kK());
        return;
      }
      catch (RemoteException paramb)
      {
        GamesLog.p("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(BaseImplementation.b<Leaderboards.LoadScoresResult> paramb, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)gS()).a(new LeaderboardScoresLoadedBinderCallback(paramb), paramString, paramInt1, paramInt2, paramInt3, paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Players.LoadPlayersResult> paramb, String paramString, int paramInt, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)gS()).a(new PlayersLoadedBinderCallback(paramb), paramString, paramInt, paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Players.LoadPlayersResult> paramb, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Invalid player collection: " + paramString);
        if (paramString.equals("played_with")) {
          i = 0;
        }
        break;
      }
    }
    try
    {
      ((IGamesService)gS()).d(new PlayersLoadedBinderCallback(paramb), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<GamesMetadata.LoadExtendedGamesResult> paramb, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    try
    {
      ((IGamesService)gS()).a(new ExtendedGamesLoadedBinderCallback(paramb), paramString, paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<TurnBasedMultiplayer.LoadMatchesResult> paramb, String paramString, int paramInt, int[] paramArrayOfInt)
  {
    try
    {
      ((IGamesService)gS()).a(new TurnBasedMatchesLoadedBinderCallbacks(paramb), paramString, paramInt, paramArrayOfInt);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Leaderboards.SubmitScoreResult> paramb, String paramString1, long paramLong, String paramString2)
  {
    if (paramb == null) {}
    for (paramb = null;; paramb = new SubmitScoreBinderCallbacks(paramb)) {
      try
      {
        ((IGamesService)gS()).a(paramb, paramString1, paramLong, paramString2);
        return;
      }
      catch (RemoteException paramb)
      {
        GamesLog.p("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(BaseImplementation.b<TurnBasedMultiplayer.LeaveMatchResult> paramb, String paramString1, String paramString2)
  {
    try
    {
      ((IGamesService)gS()).c(new TurnBasedMatchLeftBinderCallbacks(paramb), paramString1, paramString2);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Leaderboards.LoadPlayerScoreResult> paramb, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    try
    {
      ((IGamesService)gS()).a(new PlayerLeaderboardScoreLoadedBinderCallback(paramb), paramString1, paramString2, paramInt1, paramInt2);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Requests.LoadRequestsResult> paramb, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      ((IGamesService)gS()).a(new RequestsLoadedBinderCallbacks(paramb), paramString1, paramString2, paramInt1, paramInt2, paramInt3);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Leaderboards.LoadScoresResult> paramb, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)gS()).a(new LeaderboardScoresLoadedBinderCallback(paramb), paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Players.LoadPlayersResult> paramb, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = -1;
    switch (paramString1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Invalid player collection: " + paramString1);
        if (paramString1.equals("circled"))
        {
          i = 0;
          continue;
          if (paramString1.equals("played_with"))
          {
            i = 1;
            continue;
            if (paramString1.equals("nearby")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    try
    {
      ((IGamesService)gS()).a(new PlayersLoadedBinderCallback(paramb), paramString1, paramString2, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Snapshots.OpenSnapshotResult> paramb, String paramString1, String paramString2, SnapshotMetadataChange paramSnapshotMetadataChange, SnapshotContents paramSnapshotContents)
  {
    if (!paramSnapshotContents.isClosed()) {}
    for (boolean bool = true;; bool = false)
    {
      n.a(bool, "SnapshotContents already closed");
      Object localObject = paramSnapshotMetadataChange.lK();
      if (localObject != null) {
        ((com.google.android.gms.common.data.a)localObject).a(getContext().getCacheDir());
      }
      localObject = paramSnapshotContents.getContents();
      paramSnapshotContents.close();
      try
      {
        ((IGamesService)gS()).a(new SnapshotOpenedBinderCallbacks(paramb), paramString1, paramString2, paramSnapshotMetadataChange, (Contents)localObject);
        return;
      }
      catch (RemoteException paramb)
      {
        GamesLog.p("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(BaseImplementation.b<Leaderboards.LeaderboardMetadataResult> paramb, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)gS()).b(new LeaderboardsLoadedBinderCallback(paramb), paramString1, paramString2, paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Quests.LoadQuestsResult> paramb, String paramString1, String paramString2, boolean paramBoolean, String[] paramArrayOfString)
  {
    try
    {
      this.Wh.flush();
      ((IGamesService)gS()).a(new QuestsLoadedBinderCallbacks(paramb), paramString1, paramString2, paramArrayOfString, paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Quests.LoadQuestsResult> paramb, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    try
    {
      this.Wh.flush();
      ((IGamesService)gS()).a(new QuestsLoadedBinderCallbacks(paramb), paramString1, paramString2, paramArrayOfInt, paramInt, paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Requests.UpdateRequestsResult> paramb, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      ((IGamesService)gS()).a(new RequestsUpdatedBinderCallbacks(paramb), paramString1, paramString2, paramArrayOfString);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Leaderboards.LeaderboardMetadataResult> paramb, String paramString, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)gS()).c(new LeaderboardsLoadedBinderCallback(paramb), paramString, paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<TurnBasedMultiplayer.UpdateMatchResult> paramb, String paramString1, byte[] paramArrayOfByte, String paramString2, ParticipantResult[] paramArrayOfParticipantResult)
  {
    try
    {
      ((IGamesService)gS()).a(new TurnBasedMatchUpdatedBinderCallbacks(paramb), paramString1, paramArrayOfByte, paramString2, paramArrayOfParticipantResult);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<TurnBasedMultiplayer.UpdateMatchResult> paramb, String paramString, byte[] paramArrayOfByte, ParticipantResult[] paramArrayOfParticipantResult)
  {
    try
    {
      ((IGamesService)gS()).a(new TurnBasedMatchUpdatedBinderCallbacks(paramb), paramString, paramArrayOfByte, paramArrayOfParticipantResult);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Requests.SendRequestResult> paramb, String paramString, String[] paramArrayOfString, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    try
    {
      ((IGamesService)gS()).a(new RequestSentBinderCallbacks(paramb), paramString, paramArrayOfString, paramInt1, paramArrayOfByte, paramInt2);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Players.LoadPlayersResult> paramb, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)gS()).c(new PlayersLoadedBinderCallback(paramb), paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Status> paramb, boolean paramBoolean, Bundle paramBundle)
  {
    try
    {
      ((IGamesService)gS()).a(new ContactSettingsUpdatedBinderCallback(paramb), paramBoolean, paramBundle);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Events.LoadEventsResult> paramb, boolean paramBoolean, String... paramVarArgs)
  {
    try
    {
      this.Wh.flush();
      ((IGamesService)gS()).a(new EventsLoadedBinderCallback(paramb), paramBoolean, paramVarArgs);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Quests.LoadQuestsResult> paramb, int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    try
    {
      this.Wh.flush();
      ((IGamesService)gS()).a(new QuestsLoadedBinderCallbacks(paramb), paramArrayOfInt, paramInt, paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(BaseImplementation.b<Players.LoadPlayersResult> paramb, String[] paramArrayOfString)
  {
    try
    {
      ((IGamesService)gS()).c(new PlayersLoadedBinderCallback(paramb), paramArrayOfString);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  protected void a(k paramk, d.e parame)
    throws RemoteException
  {
    String str = getContext().getResources().getConfiguration().locale.toString();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.Wq.Vs);
    localBundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.Wq.Vt);
    localBundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.Wq.Vu);
    localBundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.Wq.Vv);
    localBundle.putInt("com.google.android.gms.games.key.sdkVariant", this.Wq.Vw);
    localBundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.Wq.Vx);
    localBundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.Wq.Vy);
    paramk.a(parame, 6111000, getContext().getPackageName(), this.Dd, gR(), this.Wi, this.Wm.kL(), str, localBundle);
  }
  
  public void a(OnInvitationReceivedListener paramOnInvitationReceivedListener)
  {
    try
    {
      paramOnInvitationReceivedListener = new InvitationReceivedBinderCallback(paramOnInvitationReceivedListener);
      ((IGamesService)gS()).a(paramOnInvitationReceivedListener, this.Wp);
      return;
    }
    catch (RemoteException paramOnInvitationReceivedListener)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(RoomConfig paramRoomConfig)
  {
    kt();
    try
    {
      RoomBinderCallbacks localRoomBinderCallbacks = new RoomBinderCallbacks(paramRoomConfig.getRoomUpdateListener(), paramRoomConfig.getRoomStatusUpdateListener(), paramRoomConfig.getMessageReceivedListener());
      ((IGamesService)gS()).a(localRoomBinderCallbacks, this.Wo, paramRoomConfig.getVariant(), paramRoomConfig.getInvitedPlayerIds(), paramRoomConfig.getAutoMatchCriteria(), paramRoomConfig.isSocketEnabled(), this.Wp);
      return;
    }
    catch (RemoteException paramRoomConfig)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(RoomUpdateListener paramRoomUpdateListener, String paramString)
  {
    try
    {
      ((IGamesService)gS()).c(new RoomBinderCallbacks(paramRoomUpdateListener), paramString);
      kt();
      return;
    }
    catch (RemoteException paramRoomUpdateListener)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
  {
    try
    {
      paramOnTurnBasedMatchUpdateReceivedListener = new MatchUpdateReceivedBinderCallback(paramOnTurnBasedMatchUpdateReceivedListener);
      ((IGamesService)gS()).b(paramOnTurnBasedMatchUpdateReceivedListener, this.Wp);
      return;
    }
    catch (RemoteException paramOnTurnBasedMatchUpdateReceivedListener)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(QuestUpdateListener paramQuestUpdateListener)
  {
    try
    {
      paramQuestUpdateListener = new QuestUpdateBinderCallback(paramQuestUpdateListener);
      ((IGamesService)gS()).d(paramQuestUpdateListener, this.Wp);
      return;
    }
    catch (RemoteException paramQuestUpdateListener)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(OnRequestReceivedListener paramOnRequestReceivedListener)
  {
    try
    {
      paramOnRequestReceivedListener = new RequestReceivedBinderCallback(paramOnRequestReceivedListener);
      ((IGamesService)gS()).c(paramOnRequestReceivedListener, this.Wp);
      return;
    }
    catch (RemoteException paramOnRequestReceivedListener)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void a(Snapshot paramSnapshot)
  {
    paramSnapshot = paramSnapshot.getSnapshotContents();
    if (!paramSnapshot.isClosed()) {}
    for (boolean bool = true;; bool = false)
    {
      n.a(bool, "Snapshot already closed");
      Contents localContents = paramSnapshot.getContents();
      paramSnapshot.close();
      try
      {
        ((IGamesService)gS()).a(localContents);
        return;
      }
      catch (RemoteException paramSnapshot)
      {
        GamesLog.p("GamesClientImpl", "service died");
      }
    }
  }
  
  protected IGamesService az(IBinder paramIBinder)
  {
    return IGamesService.Stub.aB(paramIBinder);
  }
  
  public Intent b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = ((IGamesService)gS()).b(paramInt1, paramInt2, paramBoolean);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent b(int[] paramArrayOfInt)
  {
    try
    {
      paramArrayOfInt = ((IGamesService)gS()).b(paramArrayOfInt);
      return paramArrayOfInt;
    }
    catch (RemoteException paramArrayOfInt)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public void b(BaseImplementation.b<Status> paramb)
  {
    try
    {
      this.Wh.flush();
      ((IGamesService)gS()).a(new SignOutCompleteBinderCallbacks(paramb));
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void b(BaseImplementation.b<Players.LoadPlayersResult> paramb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)gS()).b(new PlayersLoadedBinderCallback(paramb), paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void b(BaseImplementation.b<Achievements.UpdateAchievementResult> paramb, String paramString)
  {
    if (paramb == null) {}
    for (paramb = null;; paramb = new AchievementUpdatedBinderCallback(paramb)) {
      try
      {
        ((IGamesService)gS()).a(paramb, paramString, this.Wm.kL(), this.Wm.kK());
        return;
      }
      catch (RemoteException paramb)
      {
        GamesLog.p("GamesClientImpl", "service died");
      }
    }
  }
  
  public void b(BaseImplementation.b<Achievements.UpdateAchievementResult> paramb, String paramString, int paramInt)
  {
    if (paramb == null) {}
    for (paramb = null;; paramb = new AchievementUpdatedBinderCallback(paramb)) {
      try
      {
        ((IGamesService)gS()).b(paramb, paramString, paramInt, this.Wm.kL(), this.Wm.kK());
        return;
      }
      catch (RemoteException paramb)
      {
        GamesLog.p("GamesClientImpl", "service died");
      }
    }
  }
  
  public void b(BaseImplementation.b<Leaderboards.LoadScoresResult> paramb, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)gS()).b(new LeaderboardScoresLoadedBinderCallback(paramb), paramString, paramInt1, paramInt2, paramInt3, paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void b(BaseImplementation.b<GamesMetadata.LoadExtendedGamesResult> paramb, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)gS()).a(new ExtendedGamesLoadedBinderCallback(paramb), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void b(BaseImplementation.b<Quests.ClaimMilestoneResult> paramb, String paramString1, String paramString2)
  {
    try
    {
      this.Wh.flush();
      ((IGamesService)gS()).f(new QuestMilestoneClaimBinderCallbacks(paramb, paramString2), paramString1, paramString2);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void b(BaseImplementation.b<Leaderboards.LoadScoresResult> paramb, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)gS()).b(new LeaderboardScoresLoadedBinderCallback(paramb), paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void b(BaseImplementation.b<Achievements.LoadAchievementsResult> paramb, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)gS()).a(new AchievementsLoadedBinderCallback(paramb), paramString1, paramString2, paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void b(BaseImplementation.b<Snapshots.OpenSnapshotResult> paramb, String paramString, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)gS()).e(new SnapshotOpenedBinderCallbacks(paramb), paramString, paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void b(BaseImplementation.b<Leaderboards.LeaderboardMetadataResult> paramb, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)gS()).b(new LeaderboardsLoadedBinderCallback(paramb), paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void b(BaseImplementation.b<Quests.LoadQuestsResult> paramb, boolean paramBoolean, String[] paramArrayOfString)
  {
    try
    {
      this.Wh.flush();
      ((IGamesService)gS()).a(new QuestsLoadedBinderCallbacks(paramb), paramArrayOfString, paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void b(BaseImplementation.b<Requests.UpdateRequestsResult> paramb, String[] paramArrayOfString)
  {
    try
    {
      ((IGamesService)gS()).a(new RequestsUpdatedBinderCallbacks(paramb), paramArrayOfString);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void b(RoomConfig paramRoomConfig)
  {
    kt();
    try
    {
      RoomBinderCallbacks localRoomBinderCallbacks = new RoomBinderCallbacks(paramRoomConfig.getRoomUpdateListener(), paramRoomConfig.getRoomStatusUpdateListener(), paramRoomConfig.getMessageReceivedListener());
      ((IGamesService)gS()).a(localRoomBinderCallbacks, this.Wo, paramRoomConfig.getInvitationId(), paramRoomConfig.isSocketEnabled(), this.Wp);
      return;
    }
    catch (RemoteException paramRoomConfig)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void bA(String paramString)
  {
    try
    {
      ((IGamesService)gS()).a(paramString, this.Wm.kL(), this.Wm.kK());
      return;
    }
    catch (RemoteException paramString)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public Intent bu(String paramString)
  {
    try
    {
      paramString = ((IGamesService)gS()).bu(paramString);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public void bv(String paramString)
  {
    try
    {
      ((IGamesService)gS()).bG(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public Intent bz(String paramString)
  {
    try
    {
      paramString = ((IGamesService)gS()).bz(paramString);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public void c(BaseImplementation.b<Invitations.LoadInvitationsResult> paramb, int paramInt)
  {
    try
    {
      ((IGamesService)gS()).a(new InvitationsLoadedBinderCallback(paramb), paramInt);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void c(BaseImplementation.b<Players.LoadPlayersResult> paramb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)gS()).c(new PlayersLoadedBinderCallback(paramb), paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void c(BaseImplementation.b<Achievements.UpdateAchievementResult> paramb, String paramString)
  {
    if (paramb == null) {}
    for (paramb = null;; paramb = new AchievementUpdatedBinderCallback(paramb)) {
      try
      {
        ((IGamesService)gS()).b(paramb, paramString, this.Wm.kL(), this.Wm.kK());
        return;
      }
      catch (RemoteException paramb)
      {
        GamesLog.p("GamesClientImpl", "service died");
      }
    }
  }
  
  public void c(BaseImplementation.b<Players.LoadXpStreamResult> paramb, String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)gS()).b(new PlayerXpStreamLoadedBinderCallback(paramb), paramString, paramInt);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void c(BaseImplementation.b<GamesMetadata.LoadExtendedGamesResult> paramb, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)gS()).e(new ExtendedGamesLoadedBinderCallback(paramb), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void c(BaseImplementation.b<TurnBasedMultiplayer.InitiateMatchResult> paramb, String paramString1, String paramString2)
  {
    try
    {
      ((IGamesService)gS()).d(new TurnBasedMatchInitiatedBinderCallbacks(paramb), paramString1, paramString2);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void c(BaseImplementation.b<Snapshots.LoadSnapshotsResult> paramb, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)gS()).c(new SnapshotsLoadedBinderCallbacks(paramb), paramString1, paramString2, paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void c(BaseImplementation.b<Leaderboards.LeaderboardMetadataResult> paramb, String paramString, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)gS()).d(new LeaderboardsLoadedBinderCallback(paramb), paramString, paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void c(BaseImplementation.b<Achievements.LoadAchievementsResult> paramb, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)gS()).a(new AchievementsLoadedBinderCallback(paramb), paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void c(BaseImplementation.b<Requests.UpdateRequestsResult> paramb, String[] paramArrayOfString)
  {
    try
    {
      ((IGamesService)gS()).b(new RequestsUpdatedBinderCallbacks(paramb), paramArrayOfString);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  protected void c(String... paramVarArgs)
  {
    int i = 0;
    int j = 0;
    boolean bool1 = false;
    if (i < paramVarArgs.length)
    {
      String str = paramVarArgs[i];
      boolean bool2;
      if (str.equals("https://www.googleapis.com/auth/games")) {
        bool2 = true;
      }
      for (;;)
      {
        i += 1;
        bool1 = bool2;
        break;
        bool2 = bool1;
        if (str.equals("https://www.googleapis.com/auth/games.firstparty"))
        {
          j = 1;
          bool2 = bool1;
        }
      }
    }
    if (j != 0)
    {
      if (!bool1) {}
      for (bool1 = true;; bool1 = false)
      {
        n.a(bool1, "Cannot have both %s and %s!", new Object[] { "https://www.googleapis.com/auth/games", "https://www.googleapis.com/auth/games.firstparty" });
        return;
      }
    }
    n.a(bool1, "Games APIs requires %s to function.", new Object[] { "https://www.googleapis.com/auth/games" });
  }
  
  public void connect()
  {
    jW();
    super.connect();
  }
  
  public int d(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      int i = ((IGamesService)gS()).b(paramArrayOfByte, paramString, null);
      return i;
    }
    catch (RemoteException paramArrayOfByte)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public void d(BaseImplementation.b<Players.LoadPlayersResult> paramb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)gS()).e(new PlayersLoadedBinderCallback(paramb), paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void d(BaseImplementation.b<TurnBasedMultiplayer.InitiateMatchResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)gS()).l(new TurnBasedMatchInitiatedBinderCallbacks(paramb), paramString);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void d(BaseImplementation.b<Players.LoadXpStreamResult> paramb, String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)gS()).c(new PlayerXpStreamLoadedBinderCallback(paramb), paramString, paramInt);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void d(BaseImplementation.b<GamesMetadata.LoadExtendedGamesResult> paramb, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)gS()).f(new ExtendedGamesLoadedBinderCallback(paramb), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void d(BaseImplementation.b<TurnBasedMultiplayer.InitiateMatchResult> paramb, String paramString1, String paramString2)
  {
    try
    {
      ((IGamesService)gS()).e(new TurnBasedMatchInitiatedBinderCallbacks(paramb), paramString1, paramString2);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void d(BaseImplementation.b<Notifications.GameMuteStatusChangeResult> paramb, String paramString, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)gS()).a(new GameMuteStatusChangedBinderCallback(paramb), paramString, paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void d(BaseImplementation.b<Events.LoadEventsResult> paramb, boolean paramBoolean)
  {
    try
    {
      this.Wh.flush();
      ((IGamesService)gS()).f(new EventsLoadedBinderCallback(paramb), paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void dB(int paramInt)
  {
    this.Wm.setGravity(paramInt);
  }
  
  public void dC(int paramInt)
  {
    try
    {
      ((IGamesService)gS()).dC(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void disconnect()
  {
    this.Wn = false;
    if (isConnected()) {}
    try
    {
      IGamesService localIGamesService = (IGamesService)gS();
      localIGamesService.ku();
      this.Wh.flush();
      localIGamesService.q(this.Wp);
      kt();
      super.disconnect();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.p("GamesClientImpl", "Failed to notify client disconnect.");
      }
    }
  }
  
  public void e(BaseImplementation.b<Players.LoadPlayersResult> paramb, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)gS()).d(new PlayersLoadedBinderCallback(paramb), paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void e(BaseImplementation.b<TurnBasedMultiplayer.InitiateMatchResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)gS()).m(new TurnBasedMatchInitiatedBinderCallbacks(paramb), paramString);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void e(BaseImplementation.b<Invitations.LoadInvitationsResult> paramb, String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)gS()).b(new InvitationsLoadedBinderCallback(paramb), paramString, paramInt, false);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void e(BaseImplementation.b<GamesMetadata.LoadExtendedGamesResult> paramb, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)gS()).c(new ExtendedGamesLoadedBinderCallback(paramb), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void e(BaseImplementation.b<Snapshots.LoadSnapshotsResult> paramb, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)gS()).d(new SnapshotsLoadedBinderCallbacks(paramb), paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void f(BaseImplementation.b<GamesMetadata.LoadGamesResult> paramb)
  {
    try
    {
      ((IGamesService)gS()).d(new GamesLoadedBinderCallback(paramb));
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void f(BaseImplementation.b<TurnBasedMultiplayer.LeaveMatchResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)gS()).o(new TurnBasedMatchLeftBinderCallbacks(paramb), paramString);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void f(BaseImplementation.b<Requests.LoadRequestSummariesResult> paramb, String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)gS()).a(new RequestSummariesLoadedBinderCallbacks(paramb), paramString, paramInt);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void f(BaseImplementation.b<Players.LoadPlayersResult> paramb, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)gS()).b(new PlayersLoadedBinderCallback(paramb), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void f(BaseImplementation.b<Players.LoadProfileSettingsResult> paramb, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)gS()).g(new ProfileSettingsLoadedBinderCallback(paramb), paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public Bundle fD()
  {
    try
    {
      Bundle localBundle = ((IGamesService)gS()).fD();
      if (localBundle != null) {
        localBundle.setClassLoader(GamesClientImpl.class.getClassLoader());
      }
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public void g(BaseImplementation.b<Players.LoadOwnerCoverPhotoUrisResult> paramb)
  {
    try
    {
      ((IGamesService)gS()).j(new OwnerCoverPhotoUrisLoadedBinderCallback(paramb));
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void g(BaseImplementation.b<TurnBasedMultiplayer.CancelMatchResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)gS()).n(new TurnBasedMatchCanceledBinderCallbacks(paramb), paramString);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void g(BaseImplementation.b<Players.LoadPlayersResult> paramb, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)gS()).b(new PlayersLoadedBinderCallback(paramb), paramString, null, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void g(BaseImplementation.b<Status> paramb, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)gS()).h(new ProfileSettingsUpdatedBinderCallback(paramb), paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.games.internal.IGamesService";
  }
  
  protected String getStartServiceAction()
  {
    return "com.google.android.gms.games.service.START";
  }
  
  public void h(BaseImplementation.b<Acls.LoadAclResult> paramb)
  {
    try
    {
      ((IGamesService)gS()).h(new NotifyAclLoadedBinderCallback(paramb));
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void h(BaseImplementation.b<TurnBasedMultiplayer.LoadMatchResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)gS()).p(new TurnBasedMatchLoadedBinderCallbacks(paramb), paramString);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void h(BaseImplementation.b<Notifications.ContactSettingLoadResult> paramb, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)gS()).e(new ContactSettingsLoadedBinderCallback(paramb), paramBoolean);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  @Deprecated
  public void i(BaseImplementation.b<Notifications.ContactSettingLoadResult> paramb)
  {
    try
    {
      ((IGamesService)gS()).e(new ContactSettingsLoadedBinderCallback(paramb), false);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void i(BaseImplementation.b<Quests.AcceptQuestResult> paramb, String paramString)
  {
    try
    {
      this.Wh.flush();
      ((IGamesService)gS()).u(new QuestAcceptedBinderCallbacks(paramb), paramString);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void j(BaseImplementation.b<Notifications.InboxCountResult> paramb)
  {
    try
    {
      ((IGamesService)gS()).t(new InboxCountsLoadedBinderCallback(paramb), null);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void j(BaseImplementation.b<Snapshots.DeleteSnapshotResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)gS()).r(new SnapshotDeletedBinderCallbacks(paramb), paramString);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public String jX()
  {
    try
    {
      String str = ((IGamesService)gS()).jX();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public String jY()
  {
    try
    {
      String str = ((IGamesService)gS()).jY();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return null;
  }
  
  /* Error */
  public Player jZ()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1404	com/google/android/gms/games/internal/GamesClientImpl:dK	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 579	com/google/android/gms/games/internal/GamesClientImpl:Wk	Lcom/google/android/gms/games/PlayerEntity;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +51 -> 63
    //   15: new 1406	com/google/android/gms/games/PlayerBuffer
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual 511	com/google/android/gms/games/internal/GamesClientImpl:gS	()Landroid/os/IInterface;
    //   23: checkcast 513	com/google/android/gms/games/internal/IGamesService
    //   26: invokeinterface 1410 1 0
    //   31: invokespecial 1411	com/google/android/gms/games/PlayerBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 1412	com/google/android/gms/games/PlayerBuffer:getCount	()I
    //   39: ifle +20 -> 59
    //   42: aload_0
    //   43: aload_1
    //   44: iconst_0
    //   45: invokevirtual 1415	com/google/android/gms/games/PlayerBuffer:get	(I)Lcom/google/android/gms/games/Player;
    //   48: invokeinterface 1418 1 0
    //   53: checkcast 1420	com/google/android/gms/games/PlayerEntity
    //   56: putfield 579	com/google/android/gms/games/internal/GamesClientImpl:Wk	Lcom/google/android/gms/games/PlayerEntity;
    //   59: aload_1
    //   60: invokevirtual 1421	com/google/android/gms/games/PlayerBuffer:release	()V
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_0
    //   66: getfield 579	com/google/android/gms/games/internal/GamesClientImpl:Wk	Lcom/google/android/gms/games/PlayerEntity;
    //   69: areturn
    //   70: astore_2
    //   71: aload_1
    //   72: invokevirtual 1421	com/google/android/gms/games/PlayerBuffer:release	()V
    //   75: aload_2
    //   76: athrow
    //   77: astore_1
    //   78: ldc_w 536
    //   81: ldc_w 621
    //   84: invokestatic 624	com/google/android/gms/games/internal/GamesLog:p	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: goto -24 -> 63
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	GamesClientImpl
    //   10	62	1	localObject1	Object
    //   77	1	1	localRemoteException	RemoteException
    //   90	4	1	localObject2	Object
    //   70	6	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   35	59	70	finally
    //   15	35	77	android/os/RemoteException
    //   59	63	77	android/os/RemoteException
    //   71	77	77	android/os/RemoteException
    //   6	11	90	finally
    //   15	35	90	finally
    //   59	63	90	finally
    //   63	65	90	finally
    //   71	77	90	finally
    //   78	87	90	finally
    //   91	93	90	finally
  }
  
  public void k(View paramView)
  {
    this.Wm.l(paramView);
  }
  
  public void k(BaseImplementation.b<GamesMetadata.LoadExtendedGamesResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)gS()).e(new ExtendedGamesLoadedBinderCallback(paramb), paramString);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  /* Error */
  public com.google.android.gms.games.Game ka()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1404	com/google/android/gms/games/internal/GamesClientImpl:dK	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 1430	com/google/android/gms/games/internal/GamesClientImpl:Wl	Lcom/google/android/gms/games/GameEntity;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +51 -> 63
    //   15: new 1432	com/google/android/gms/games/GameBuffer
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual 511	com/google/android/gms/games/internal/GamesClientImpl:gS	()Landroid/os/IInterface;
    //   23: checkcast 513	com/google/android/gms/games/internal/IGamesService
    //   26: invokeinterface 1435 1 0
    //   31: invokespecial 1436	com/google/android/gms/games/GameBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 1437	com/google/android/gms/games/GameBuffer:getCount	()I
    //   39: ifle +20 -> 59
    //   42: aload_0
    //   43: aload_1
    //   44: iconst_0
    //   45: invokevirtual 1440	com/google/android/gms/games/GameBuffer:get	(I)Lcom/google/android/gms/games/Game;
    //   48: invokeinterface 1443 1 0
    //   53: checkcast 1445	com/google/android/gms/games/GameEntity
    //   56: putfield 1430	com/google/android/gms/games/internal/GamesClientImpl:Wl	Lcom/google/android/gms/games/GameEntity;
    //   59: aload_1
    //   60: invokevirtual 1446	com/google/android/gms/games/GameBuffer:release	()V
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_0
    //   66: getfield 1430	com/google/android/gms/games/internal/GamesClientImpl:Wl	Lcom/google/android/gms/games/GameEntity;
    //   69: areturn
    //   70: astore_2
    //   71: aload_1
    //   72: invokevirtual 1446	com/google/android/gms/games/GameBuffer:release	()V
    //   75: aload_2
    //   76: athrow
    //   77: astore_1
    //   78: ldc_w 536
    //   81: ldc_w 621
    //   84: invokestatic 624	com/google/android/gms/games/internal/GamesLog:p	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: goto -24 -> 63
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	GamesClientImpl
    //   10	62	1	localObject1	Object
    //   77	1	1	localRemoteException	RemoteException
    //   90	4	1	localObject2	Object
    //   70	6	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   35	59	70	finally
    //   15	35	77	android/os/RemoteException
    //   59	63	77	android/os/RemoteException
    //   71	77	77	android/os/RemoteException
    //   6	11	90	finally
    //   15	35	90	finally
    //   59	63	90	finally
    //   63	65	90	finally
    //   71	77	90	finally
    //   78	87	90	finally
    //   91	93	90	finally
  }
  
  public Intent kb()
  {
    try
    {
      Intent localIntent = ((IGamesService)gS()).kb();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent kc()
  {
    try
    {
      Intent localIntent = ((IGamesService)gS()).kc();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent kd()
  {
    try
    {
      Intent localIntent = ((IGamesService)gS()).kd();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent ke()
  {
    try
    {
      Intent localIntent = ((IGamesService)gS()).ke();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public void kf()
  {
    try
    {
      ((IGamesService)gS()).r(this.Wp);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void kg()
  {
    try
    {
      ((IGamesService)gS()).s(this.Wp);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void kh()
  {
    try
    {
      ((IGamesService)gS()).u(this.Wp);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void ki()
  {
    try
    {
      ((IGamesService)gS()).t(this.Wp);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public Intent kj()
  {
    try
    {
      Intent localIntent = ((IGamesService)gS()).kj();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent kk()
  {
    try
    {
      Intent localIntent = ((IGamesService)gS()).kk();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public int kl()
  {
    try
    {
      int i = ((IGamesService)gS()).kl();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return 4368;
  }
  
  public String km()
  {
    try
    {
      String str = ((IGamesService)gS()).km();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public int kn()
  {
    try
    {
      int i = ((IGamesService)gS()).kn();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public Intent ko()
  {
    try
    {
      Intent localIntent = ((IGamesService)gS()).ko();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public int kp()
  {
    try
    {
      int i = ((IGamesService)gS()).kp();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public int kq()
  {
    try
    {
      int i = ((IGamesService)gS()).kq();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public int kr()
  {
    try
    {
      int i = ((IGamesService)gS()).kr();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public int ks()
  {
    try
    {
      int i = ((IGamesService)gS()).ks();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public void ku()
  {
    if (isConnected()) {}
    try
    {
      ((IGamesService)gS()).ku();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void l(BaseImplementation.b<GamesMetadata.LoadGameInstancesResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)gS()).f(new GameInstancesLoadedBinderCallback(paramb), paramString);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void m(BaseImplementation.b<GamesMetadata.LoadGameSearchSuggestionsResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)gS()).q(new GameSearchSuggestionsLoadedBinderCallback(paramb), paramString);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void n(BaseImplementation.b<Players.LoadXpForGameCategoriesResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)gS()).s(new PlayerXpForGameCategoriesLoadedBinderCallback(paramb), paramString);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void n(String paramString, int paramInt)
  {
    this.Wh.n(paramString, paramInt);
  }
  
  public void o(BaseImplementation.b<Invitations.LoadInvitationsResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)gS()).k(new InvitationsLoadedBinderCallback(paramb), paramString);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void o(String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)gS()).o(paramString, paramInt);
      return;
    }
    catch (RemoteException paramString)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void onConnected(Bundle paramBundle)
  {
    if (this.Wn)
    {
      this.Wm.kJ();
      this.Wn = false;
    }
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.Wn = false;
  }
  
  public void onConnectionSuspended(int paramInt) {}
  
  public void p(BaseImplementation.b<Status> paramb, String paramString)
  {
    try
    {
      ((IGamesService)gS()).j(new NotifyAclUpdatedBinderCallback(paramb), paramString);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void p(String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)gS()).p(paramString, paramInt);
      return;
    }
    catch (RemoteException paramString)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public void q(BaseImplementation.b<Notifications.GameMuteStatusLoadResult> paramb, String paramString)
  {
    try
    {
      ((IGamesService)gS()).i(new GameMuteStatusLoadedBinderCallback(paramb), paramString);
      return;
    }
    catch (RemoteException paramb)
    {
      GamesLog.p("GamesClientImpl", "service died");
    }
  }
  
  public RealTimeSocket t(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (!ParticipantUtils.bS(paramString2))) {
      throw new IllegalArgumentException("Bad participant ID");
    }
    RealTimeSocket localRealTimeSocket = (RealTimeSocket)this.Wj.get(paramString2);
    if (localRealTimeSocket != null)
    {
      paramString1 = localRealTimeSocket;
      if (!localRealTimeSocket.isClosed()) {}
    }
    else
    {
      paramString1 = bw(paramString2);
    }
    return paramString1;
  }
  
  private abstract class AbstractPeerStatusCallback
    extends GamesClientImpl.AbstractRoomStatusCallback
  {
    private final ArrayList<String> Ws = new ArrayList();
    
    AbstractPeerStatusCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder);
      int i = 0;
      int j = paramArrayOfString.length;
      while (i < j)
      {
        this.Ws.add(paramArrayOfString[i]);
        i += 1;
      }
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      a(paramRoomStatusUpdateListener, paramRoom, this.Ws);
    }
    
    protected abstract void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList);
  }
  
  private abstract class AbstractRoomCallback
    extends d<IGamesService>.d<RoomUpdateListener>
  {
    AbstractRoomCallback(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomUpdateListener, paramDataHolder);
    }
    
    protected void a(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder)
    {
      a(paramRoomUpdateListener, GamesClientImpl.a(GamesClientImpl.this, paramDataHolder), paramDataHolder.getStatusCode());
    }
    
    protected abstract void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt);
  }
  
  private abstract class AbstractRoomStatusCallback
    extends d<IGamesService>.d<RoomStatusUpdateListener>
  {
    AbstractRoomStatusCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
    {
      a(paramRoomStatusUpdateListener, GamesClientImpl.a(GamesClientImpl.this, paramDataHolder));
    }
    
    protected abstract void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom);
  }
  
  private static final class AcceptQuestResultImpl
    extends com.google.android.gms.common.api.a
    implements Quests.AcceptQuestResult
  {
    private final Quest Wt;
    
    /* Error */
    AcceptQuestResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 15	com/google/android/gms/common/api/a:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 17	com/google/android/gms/games/quest/QuestBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 18	com/google/android/gms/games/quest/QuestBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_1
      //   14: aload_1
      //   15: invokevirtual 22	com/google/android/gms/games/quest/QuestBuffer:getCount	()I
      //   18: ifle +27 -> 45
      //   21: aload_0
      //   22: new 24	com/google/android/gms/games/quest/QuestEntity
      //   25: dup
      //   26: aload_1
      //   27: iconst_0
      //   28: invokevirtual 28	com/google/android/gms/games/quest/QuestBuffer:get	(I)Ljava/lang/Object;
      //   31: checkcast 30	com/google/android/gms/games/quest/Quest
      //   34: invokespecial 33	com/google/android/gms/games/quest/QuestEntity:<init>	(Lcom/google/android/gms/games/quest/Quest;)V
      //   37: putfield 35	com/google/android/gms/games/internal/GamesClientImpl$AcceptQuestResultImpl:Wt	Lcom/google/android/gms/games/quest/Quest;
      //   40: aload_1
      //   41: invokevirtual 39	com/google/android/gms/games/quest/QuestBuffer:release	()V
      //   44: return
      //   45: aload_0
      //   46: aconst_null
      //   47: putfield 35	com/google/android/gms/games/internal/GamesClientImpl$AcceptQuestResultImpl:Wt	Lcom/google/android/gms/games/quest/Quest;
      //   50: goto -10 -> 40
      //   53: astore_2
      //   54: aload_1
      //   55: invokevirtual 39	com/google/android/gms/games/quest/QuestBuffer:release	()V
      //   58: aload_2
      //   59: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	60	0	this	AcceptQuestResultImpl
      //   0	60	1	paramDataHolder	DataHolder
      //   53	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	40	53	finally
      //   45	50	53	finally
    }
    
    public Quest getQuest()
    {
      return this.Wt;
    }
  }
  
  private final class AchievementUpdatedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Achievements.UpdateAchievementResult> De;
    
    AchievementUpdatedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void g(int paramInt, String paramString)
    {
      this.De.b(new GamesClientImpl.UpdateAchievementResultImpl(paramInt, paramString));
    }
  }
  
  private final class AchievementsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Achievements.LoadAchievementsResult> De;
    
    AchievementsLoadedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void c(DataHolder paramDataHolder)
    {
      this.De.b(new GamesClientImpl.LoadAchievementsResultImpl(paramDataHolder));
    }
  }
  
  private static final class CancelMatchResultImpl
    implements TurnBasedMultiplayer.CancelMatchResult
  {
    private final Status CM;
    private final String Wu;
    
    CancelMatchResultImpl(Status paramStatus, String paramString)
    {
      this.CM = paramStatus;
      this.Wu = paramString;
    }
    
    public String getMatchId()
    {
      return this.Wu;
    }
    
    public Status getStatus()
    {
      return this.CM;
    }
  }
  
  private static final class ClaimMilestoneResultImpl
    extends com.google.android.gms.common.api.a
    implements Quests.ClaimMilestoneResult
  {
    private final Quest Wt;
    private final Milestone Wv;
    
    /* Error */
    ClaimMilestoneResultImpl(DataHolder paramDataHolder, String paramString)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: aload_1
      //   4: invokespecial 18	com/google/android/gms/common/api/a:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   7: new 20	com/google/android/gms/games/quest/QuestBuffer
      //   10: dup
      //   11: aload_1
      //   12: invokespecial 21	com/google/android/gms/games/quest/QuestBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   15: astore_1
      //   16: aload_1
      //   17: invokevirtual 25	com/google/android/gms/games/quest/QuestBuffer:getCount	()I
      //   20: ifle +108 -> 128
      //   23: aload_0
      //   24: new 27	com/google/android/gms/games/quest/QuestEntity
      //   27: dup
      //   28: aload_1
      //   29: iconst_0
      //   30: invokevirtual 31	com/google/android/gms/games/quest/QuestBuffer:get	(I)Ljava/lang/Object;
      //   33: checkcast 33	com/google/android/gms/games/quest/Quest
      //   36: invokespecial 36	com/google/android/gms/games/quest/QuestEntity:<init>	(Lcom/google/android/gms/games/quest/Quest;)V
      //   39: putfield 38	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:Wt	Lcom/google/android/gms/games/quest/Quest;
      //   42: aload_0
      //   43: getfield 38	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:Wt	Lcom/google/android/gms/games/quest/Quest;
      //   46: invokeinterface 42 1 0
      //   51: astore 5
      //   53: aload 5
      //   55: invokeinterface 47 1 0
      //   60: istore 4
      //   62: iload_3
      //   63: iload 4
      //   65: if_icmpge +53 -> 118
      //   68: aload 5
      //   70: iload_3
      //   71: invokeinterface 48 2 0
      //   76: checkcast 50	com/google/android/gms/games/quest/Milestone
      //   79: invokeinterface 54 1 0
      //   84: aload_2
      //   85: invokevirtual 60	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   88: ifeq +23 -> 111
      //   91: aload_0
      //   92: aload 5
      //   94: iload_3
      //   95: invokeinterface 48 2 0
      //   100: checkcast 50	com/google/android/gms/games/quest/Milestone
      //   103: putfield 62	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:Wv	Lcom/google/android/gms/games/quest/Milestone;
      //   106: aload_1
      //   107: invokevirtual 66	com/google/android/gms/games/quest/QuestBuffer:release	()V
      //   110: return
      //   111: iload_3
      //   112: iconst_1
      //   113: iadd
      //   114: istore_3
      //   115: goto -53 -> 62
      //   118: aload_0
      //   119: aconst_null
      //   120: putfield 62	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:Wv	Lcom/google/android/gms/games/quest/Milestone;
      //   123: aload_1
      //   124: invokevirtual 66	com/google/android/gms/games/quest/QuestBuffer:release	()V
      //   127: return
      //   128: aload_0
      //   129: aconst_null
      //   130: putfield 62	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:Wv	Lcom/google/android/gms/games/quest/Milestone;
      //   133: aload_0
      //   134: aconst_null
      //   135: putfield 38	com/google/android/gms/games/internal/GamesClientImpl$ClaimMilestoneResultImpl:Wt	Lcom/google/android/gms/games/quest/Quest;
      //   138: goto -15 -> 123
      //   141: astore_2
      //   142: aload_1
      //   143: invokevirtual 66	com/google/android/gms/games/quest/QuestBuffer:release	()V
      //   146: aload_2
      //   147: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	148	0	this	ClaimMilestoneResultImpl
      //   0	148	1	paramDataHolder	DataHolder
      //   0	148	2	paramString	String
      //   1	114	3	i	int
      //   60	6	4	j	int
      //   51	42	5	localList	List
      // Exception table:
      //   from	to	target	type
      //   16	62	141	finally
      //   68	106	141	finally
      //   118	123	141	finally
      //   128	138	141	finally
    }
    
    public Milestone getMilestone()
    {
      return this.Wv;
    }
    
    public Quest getQuest()
    {
      return this.Wt;
    }
  }
  
  private static final class CommitSnapshotResultImpl
    extends com.google.android.gms.common.api.a
    implements Snapshots.CommitSnapshotResult
  {
    private final SnapshotMetadata Ww;
    
    /* Error */
    CommitSnapshotResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 15	com/google/android/gms/common/api/a:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 17	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 18	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_1
      //   14: aload_1
      //   15: invokevirtual 22	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:getCount	()I
      //   18: ifle +24 -> 42
      //   21: aload_0
      //   22: new 24	com/google/android/gms/games/snapshot/SnapshotMetadataEntity
      //   25: dup
      //   26: aload_1
      //   27: iconst_0
      //   28: invokevirtual 28	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:get	(I)Lcom/google/android/gms/games/snapshot/SnapshotMetadata;
      //   31: invokespecial 31	com/google/android/gms/games/snapshot/SnapshotMetadataEntity:<init>	(Lcom/google/android/gms/games/snapshot/SnapshotMetadata;)V
      //   34: putfield 33	com/google/android/gms/games/internal/GamesClientImpl$CommitSnapshotResultImpl:Ww	Lcom/google/android/gms/games/snapshot/SnapshotMetadata;
      //   37: aload_1
      //   38: invokevirtual 37	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:release	()V
      //   41: return
      //   42: aload_0
      //   43: aconst_null
      //   44: putfield 33	com/google/android/gms/games/internal/GamesClientImpl$CommitSnapshotResultImpl:Ww	Lcom/google/android/gms/games/snapshot/SnapshotMetadata;
      //   47: goto -10 -> 37
      //   50: astore_2
      //   51: aload_1
      //   52: invokevirtual 37	com/google/android/gms/games/snapshot/SnapshotMetadataBuffer:release	()V
      //   55: aload_2
      //   56: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	57	0	this	CommitSnapshotResultImpl
      //   0	57	1	paramDataHolder	DataHolder
      //   50	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	37	50	finally
      //   42	47	50	finally
    }
    
    public SnapshotMetadata getSnapshotMetadata()
    {
      return this.Ww;
    }
  }
  
  private final class ConnectedToRoomCallback
    extends GamesClientImpl.AbstractRoomStatusCallback
  {
    ConnectedToRoomCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder);
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onConnectedToRoom(paramRoom);
    }
  }
  
  private static final class ContactSettingLoadResultImpl
    extends com.google.android.gms.common.api.a
    implements Notifications.ContactSettingLoadResult
  {
    ContactSettingLoadResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private final class ContactSettingsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Notifications.ContactSettingLoadResult> De;
    
    ContactSettingsLoadedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void D(DataHolder paramDataHolder)
    {
      this.De.b(new GamesClientImpl.ContactSettingLoadResultImpl(paramDataHolder));
    }
  }
  
  private final class ContactSettingsUpdatedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Status> De;
    
    ContactSettingsUpdatedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void dy(int paramInt)
    {
      this.De.b(new Status(paramInt));
    }
  }
  
  private static final class DeleteSnapshotResultImpl
    implements Snapshots.DeleteSnapshotResult
  {
    private final Status CM;
    private final String Wx;
    
    DeleteSnapshotResultImpl(int paramInt, String paramString)
    {
      this.CM = new Status(paramInt);
      this.Wx = paramString;
    }
    
    public String getSnapshotId()
    {
      return this.Wx;
    }
    
    public Status getStatus()
    {
      return this.CM;
    }
  }
  
  private final class DisconnectedFromRoomCallback
    extends GamesClientImpl.AbstractRoomStatusCallback
  {
    DisconnectedFromRoomCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder);
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onDisconnectedFromRoom(paramRoom);
    }
  }
  
  private final class EventsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Events.LoadEventsResult> De;
    
    EventsLoadedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void d(DataHolder paramDataHolder)
    {
      this.De.b(new GamesClientImpl.LoadEventResultImpl(paramDataHolder));
    }
  }
  
  private final class ExtendedGamesLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<GamesMetadata.LoadExtendedGamesResult> De;
    
    ExtendedGamesLoadedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void j(DataHolder paramDataHolder)
    {
      this.De.b(new GamesClientImpl.LoadExtendedGamesResultImpl(paramDataHolder));
    }
  }
  
  private class GameClientEventIncrementCache
    extends EventIncrementCache
  {
    public GameClientEventIncrementCache()
    {
      super(1000);
    }
    
    protected void q(String paramString, int paramInt)
    {
      try
      {
        if (GamesClientImpl.this.isConnected())
        {
          ((IGamesService)GamesClientImpl.this.gS()).n(paramString, paramInt);
          return;
        }
        GamesLog.q("GamesClientImpl", "Unable to increment event " + paramString + " by " + paramInt + " because the games client is no longer connected");
        return;
      }
      catch (RemoteException paramString)
      {
        GamesLog.p("GamesClientImpl", "service died");
      }
    }
  }
  
  private final class GameInstancesLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<GamesMetadata.LoadGameInstancesResult> De;
    
    GameInstancesLoadedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void k(DataHolder paramDataHolder)
    {
      this.De.b(new GamesClientImpl.LoadGameInstancesResultImpl(paramDataHolder));
    }
  }
  
  private static final class GameMuteStatusChangeResultImpl
    implements Notifications.GameMuteStatusChangeResult
  {
    private final Status CM;
    private final String Wy;
    private final boolean Wz;
    
    public GameMuteStatusChangeResultImpl(int paramInt, String paramString, boolean paramBoolean)
    {
      this.CM = new Status(paramInt);
      this.Wy = paramString;
      this.Wz = paramBoolean;
    }
    
    public Status getStatus()
    {
      return this.CM;
    }
  }
  
  private final class GameMuteStatusChangedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Notifications.GameMuteStatusChangeResult> De;
    
    GameMuteStatusChangedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void a(int paramInt, String paramString, boolean paramBoolean)
    {
      this.De.b(new GamesClientImpl.GameMuteStatusChangeResultImpl(paramInt, paramString, paramBoolean));
    }
  }
  
  private static final class GameMuteStatusLoadResultImpl
    implements Notifications.GameMuteStatusLoadResult
  {
    private final Status CM;
    private final String Wy;
    private final boolean Wz;
    
    /* Error */
    public GameMuteStatusLoadResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 20	java/lang/Object:<init>	()V
      //   4: aload_0
      //   5: new 22	com/google/android/gms/common/api/Status
      //   8: dup
      //   9: aload_1
      //   10: invokevirtual 28	com/google/android/gms/common/data/DataHolder:getStatusCode	()I
      //   13: invokespecial 31	com/google/android/gms/common/api/Status:<init>	(I)V
      //   16: putfield 33	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:CM	Lcom/google/android/gms/common/api/Status;
      //   19: aload_1
      //   20: invokevirtual 36	com/google/android/gms/common/data/DataHolder:getCount	()I
      //   23: ifle +32 -> 55
      //   26: aload_0
      //   27: aload_1
      //   28: ldc 38
      //   30: iconst_0
      //   31: iconst_0
      //   32: invokevirtual 42	com/google/android/gms/common/data/DataHolder:c	(Ljava/lang/String;II)Ljava/lang/String;
      //   35: putfield 44	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:Wy	Ljava/lang/String;
      //   38: aload_0
      //   39: aload_1
      //   40: ldc 46
      //   42: iconst_0
      //   43: iconst_0
      //   44: invokevirtual 50	com/google/android/gms/common/data/DataHolder:d	(Ljava/lang/String;II)Z
      //   47: putfield 52	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:Wz	Z
      //   50: aload_1
      //   51: invokevirtual 55	com/google/android/gms/common/data/DataHolder:close	()V
      //   54: return
      //   55: aload_0
      //   56: aconst_null
      //   57: putfield 44	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:Wy	Ljava/lang/String;
      //   60: aload_0
      //   61: iconst_0
      //   62: putfield 52	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadResultImpl:Wz	Z
      //   65: goto -15 -> 50
      //   68: astore_2
      //   69: aload_1
      //   70: invokevirtual 55	com/google/android/gms/common/data/DataHolder:close	()V
      //   73: aload_2
      //   74: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	75	0	this	GameMuteStatusLoadResultImpl
      //   0	75	1	paramDataHolder	DataHolder
      //   68	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   4	50	68	finally
      //   55	65	68	finally
    }
    
    public Status getStatus()
    {
      return this.CM;
    }
  }
  
  private final class GameMuteStatusLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Notifications.GameMuteStatusLoadResult> De;
    
    GameMuteStatusLoadedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void B(DataHolder paramDataHolder)
    {
      this.De.b(new GamesClientImpl.GameMuteStatusLoadResultImpl(paramDataHolder));
    }
  }
  
  private final class GameSearchSuggestionsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<GamesMetadata.LoadGameSearchSuggestionsResult> De;
    
    GameSearchSuggestionsLoadedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void l(DataHolder paramDataHolder)
    {
      this.De.b(new GamesClientImpl.LoadGameSearchSuggestionsResultImpl(paramDataHolder));
    }
  }
  
  private final class GamesLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<GamesMetadata.LoadGamesResult> De;
    
    GamesLoadedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void i(DataHolder paramDataHolder)
    {
      this.De.b(new GamesClientImpl.LoadGamesResultImpl(paramDataHolder));
    }
  }
  
  private static final class InboxCountResultImpl
    implements Notifications.InboxCountResult
  {
    private final Status CM;
    private final Bundle WA;
    
    InboxCountResultImpl(Status paramStatus, Bundle paramBundle)
    {
      this.CM = paramStatus;
      this.WA = paramBundle;
    }
    
    public Status getStatus()
    {
      return this.CM;
    }
  }
  
  private final class InboxCountsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Notifications.InboxCountResult> De;
    
    InboxCountsLoadedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void f(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      Status localStatus = new Status(paramInt);
      this.De.b(new GamesClientImpl.InboxCountResultImpl(localStatus, paramBundle));
    }
  }
  
  private static final class InitiateMatchResultImpl
    extends GamesClientImpl.TurnBasedMatchResult
    implements TurnBasedMultiplayer.InitiateMatchResult
  {
    InitiateMatchResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private final class InvitationReceivedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final OnInvitationReceivedListener WB;
    
    InvitationReceivedBinderCallback(OnInvitationReceivedListener paramOnInvitationReceivedListener)
    {
      this.WB = paramOnInvitationReceivedListener;
    }
    
    public void n(DataHolder paramDataHolder)
    {
      InvitationBuffer localInvitationBuffer = new InvitationBuffer(paramDataHolder);
      paramDataHolder = null;
      try
      {
        if (localInvitationBuffer.getCount() > 0) {
          paramDataHolder = (Invitation)((Invitation)localInvitationBuffer.get(0)).freeze();
        }
        localInvitationBuffer.release();
        if (paramDataHolder != null) {
          GamesClientImpl.this.a(new GamesClientImpl.InvitationReceivedCallback(GamesClientImpl.this, this.WB, paramDataHolder));
        }
        return;
      }
      finally
      {
        localInvitationBuffer.release();
      }
    }
    
    public void onInvitationRemoved(String paramString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.InvitationRemovedCallback(GamesClientImpl.this, this.WB, paramString));
    }
  }
  
  private final class InvitationReceivedCallback
    extends d<IGamesService>.b<OnInvitationReceivedListener>
  {
    private final Invitation WC;
    
    InvitationReceivedCallback(OnInvitationReceivedListener paramOnInvitationReceivedListener, Invitation paramInvitation)
    {
      super(paramOnInvitationReceivedListener);
      this.WC = paramInvitation;
    }
    
    protected void b(OnInvitationReceivedListener paramOnInvitationReceivedListener)
    {
      paramOnInvitationReceivedListener.onInvitationReceived(this.WC);
    }
    
    protected void gT() {}
  }
  
  private final class InvitationRemovedCallback
    extends d<IGamesService>.b<OnInvitationReceivedListener>
  {
    private final String WD;
    
    InvitationRemovedCallback(OnInvitationReceivedListener paramOnInvitationReceivedListener, String paramString)
    {
      super(paramOnInvitationReceivedListener);
      this.WD = paramString;
    }
    
    protected void b(OnInvitationReceivedListener paramOnInvitationReceivedListener)
    {
      paramOnInvitationReceivedListener.onInvitationRemoved(this.WD);
    }
    
    protected void gT() {}
  }
  
  private final class InvitationsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Invitations.LoadInvitationsResult> De;
    
    InvitationsLoadedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void m(DataHolder paramDataHolder)
    {
      this.De.b(new GamesClientImpl.LoadInvitationsResultImpl(paramDataHolder));
    }
  }
  
  private final class JoinedRoomCallback
    extends GamesClientImpl.AbstractRoomCallback
  {
    public JoinedRoomCallback(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomUpdateListener, paramDataHolder);
    }
    
    public void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt)
    {
      paramRoomUpdateListener.onJoinedRoom(paramInt, paramRoom);
    }
  }
  
  private static final class LeaderboardMetadataResultImpl
    extends com.google.android.gms.common.api.a
    implements Leaderboards.LeaderboardMetadataResult
  {
    private final LeaderboardBuffer WE;
    
    LeaderboardMetadataResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.WE = new LeaderboardBuffer(paramDataHolder);
    }
    
    public LeaderboardBuffer getLeaderboards()
    {
      return this.WE;
    }
  }
  
  private final class LeaderboardScoresLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Leaderboards.LoadScoresResult> De;
    
    LeaderboardScoresLoadedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void a(DataHolder paramDataHolder1, DataHolder paramDataHolder2)
    {
      this.De.b(new GamesClientImpl.LoadScoresResultImpl(paramDataHolder1, paramDataHolder2));
    }
  }
  
  private final class LeaderboardsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Leaderboards.LeaderboardMetadataResult> De;
    
    LeaderboardsLoadedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void e(DataHolder paramDataHolder)
    {
      this.De.b(new GamesClientImpl.LeaderboardMetadataResultImpl(paramDataHolder));
    }
  }
  
  private static final class LeaveMatchResultImpl
    extends GamesClientImpl.TurnBasedMatchResult
    implements TurnBasedMultiplayer.LeaveMatchResult
  {
    LeaveMatchResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private final class LeftRoomCallback
    extends d<IGamesService>.b<RoomUpdateListener>
  {
    private final int HF;
    private final String WF;
    
    LeftRoomCallback(RoomUpdateListener paramRoomUpdateListener, int paramInt, String paramString)
    {
      super(paramRoomUpdateListener);
      this.HF = paramInt;
      this.WF = paramString;
    }
    
    public void a(RoomUpdateListener paramRoomUpdateListener)
    {
      paramRoomUpdateListener.onLeftRoom(this.HF, this.WF);
    }
    
    protected void gT() {}
  }
  
  private static final class LoadAchievementsResultImpl
    extends com.google.android.gms.common.api.a
    implements Achievements.LoadAchievementsResult
  {
    private final AchievementBuffer WG;
    
    LoadAchievementsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.WG = new AchievementBuffer(paramDataHolder);
    }
    
    public AchievementBuffer getAchievements()
    {
      return this.WG;
    }
  }
  
  private static final class LoadAclResultImpl
    extends com.google.android.gms.common.api.a
    implements Acls.LoadAclResult
  {
    LoadAclResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class LoadEventResultImpl
    extends com.google.android.gms.common.api.a
    implements Events.LoadEventsResult
  {
    private final EventBuffer WH;
    
    LoadEventResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.WH = new EventBuffer(paramDataHolder);
    }
    
    public EventBuffer getEvents()
    {
      return this.WH;
    }
  }
  
  private static final class LoadExtendedGamesResultImpl
    extends com.google.android.gms.common.api.a
    implements GamesMetadata.LoadExtendedGamesResult
  {
    private final ExtendedGameBuffer WI;
    
    LoadExtendedGamesResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.WI = new ExtendedGameBuffer(paramDataHolder);
    }
  }
  
  private static final class LoadGameInstancesResultImpl
    extends com.google.android.gms.common.api.a
    implements GamesMetadata.LoadGameInstancesResult
  {
    private final GameInstanceBuffer WJ;
    
    LoadGameInstancesResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.WJ = new GameInstanceBuffer(paramDataHolder);
    }
  }
  
  private static final class LoadGameSearchSuggestionsResultImpl
    extends com.google.android.gms.common.api.a
    implements GamesMetadata.LoadGameSearchSuggestionsResult
  {
    LoadGameSearchSuggestionsResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class LoadGamesResultImpl
    extends com.google.android.gms.common.api.a
    implements GamesMetadata.LoadGamesResult
  {
    private final GameBuffer WK;
    
    LoadGamesResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.WK = new GameBuffer(paramDataHolder);
    }
    
    public GameBuffer getGames()
    {
      return this.WK;
    }
  }
  
  private static final class LoadInvitationsResultImpl
    extends com.google.android.gms.common.api.a
    implements Invitations.LoadInvitationsResult
  {
    private final InvitationBuffer WL;
    
    LoadInvitationsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.WL = new InvitationBuffer(paramDataHolder);
    }
    
    public InvitationBuffer getInvitations()
    {
      return this.WL;
    }
  }
  
  private static final class LoadMatchResultImpl
    extends GamesClientImpl.TurnBasedMatchResult
    implements TurnBasedMultiplayer.LoadMatchResult
  {
    LoadMatchResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class LoadMatchesResultImpl
    implements TurnBasedMultiplayer.LoadMatchesResult
  {
    private final Status CM;
    private final LoadMatchesResponse WM;
    
    LoadMatchesResultImpl(Status paramStatus, Bundle paramBundle)
    {
      this.CM = paramStatus;
      this.WM = new LoadMatchesResponse(paramBundle);
    }
    
    public LoadMatchesResponse getMatches()
    {
      return this.WM;
    }
    
    public Status getStatus()
    {
      return this.CM;
    }
    
    public void release()
    {
      this.WM.close();
    }
  }
  
  private static final class LoadOwnerCoverPhotoUrisResultImpl
    implements Players.LoadOwnerCoverPhotoUrisResult
  {
    private final Status CM;
    private final Bundle MZ;
    
    LoadOwnerCoverPhotoUrisResultImpl(int paramInt, Bundle paramBundle)
    {
      this.CM = new Status(paramInt);
      this.MZ = paramBundle;
    }
    
    public Status getStatus()
    {
      return this.CM;
    }
  }
  
  private static final class LoadPlayerScoreResultImpl
    extends com.google.android.gms.common.api.a
    implements Leaderboards.LoadPlayerScoreResult
  {
    private final LeaderboardScoreEntity WN;
    
    /* Error */
    LoadPlayerScoreResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 15	com/google/android/gms/common/api/a:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 17	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 18	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_1
      //   14: aload_1
      //   15: invokevirtual 22	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:getCount	()I
      //   18: ifle +25 -> 43
      //   21: aload_0
      //   22: aload_1
      //   23: iconst_0
      //   24: invokevirtual 26	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:get	(I)Lcom/google/android/gms/games/leaderboard/LeaderboardScore;
      //   27: invokeinterface 32 1 0
      //   32: checkcast 34	com/google/android/gms/games/leaderboard/LeaderboardScoreEntity
      //   35: putfield 36	com/google/android/gms/games/internal/GamesClientImpl$LoadPlayerScoreResultImpl:WN	Lcom/google/android/gms/games/leaderboard/LeaderboardScoreEntity;
      //   38: aload_1
      //   39: invokevirtual 40	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:release	()V
      //   42: return
      //   43: aload_0
      //   44: aconst_null
      //   45: putfield 36	com/google/android/gms/games/internal/GamesClientImpl$LoadPlayerScoreResultImpl:WN	Lcom/google/android/gms/games/leaderboard/LeaderboardScoreEntity;
      //   48: goto -10 -> 38
      //   51: astore_2
      //   52: aload_1
      //   53: invokevirtual 40	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:release	()V
      //   56: aload_2
      //   57: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	58	0	this	LoadPlayerScoreResultImpl
      //   0	58	1	paramDataHolder	DataHolder
      //   51	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	38	51	finally
      //   43	48	51	finally
    }
    
    public LeaderboardScore getScore()
    {
      return this.WN;
    }
  }
  
  private static final class LoadPlayersResultImpl
    extends com.google.android.gms.common.api.a
    implements Players.LoadPlayersResult
  {
    private final PlayerBuffer WO;
    
    LoadPlayersResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.WO = new PlayerBuffer(paramDataHolder);
    }
    
    public PlayerBuffer getPlayers()
    {
      return this.WO;
    }
  }
  
  private static final class LoadProfileSettingsResultImpl
    extends com.google.android.gms.common.api.a
    implements Players.LoadProfileSettingsResult
  {
    private final boolean WP;
    private final boolean We;
    
    /* Error */
    LoadProfileSettingsResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 16	com/google/android/gms/common/api/a:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: aload_1
      //   6: invokevirtual 22	com/google/android/gms/common/data/DataHolder:getCount	()I
      //   9: ifle +38 -> 47
      //   12: aload_1
      //   13: iconst_0
      //   14: invokevirtual 26	com/google/android/gms/common/data/DataHolder:ar	(I)I
      //   17: istore_2
      //   18: aload_0
      //   19: aload_1
      //   20: ldc 28
      //   22: iconst_0
      //   23: iload_2
      //   24: invokevirtual 32	com/google/android/gms/common/data/DataHolder:d	(Ljava/lang/String;II)Z
      //   27: putfield 34	com/google/android/gms/games/internal/GamesClientImpl$LoadProfileSettingsResultImpl:We	Z
      //   30: aload_0
      //   31: aload_1
      //   32: ldc 36
      //   34: iconst_0
      //   35: iload_2
      //   36: invokevirtual 32	com/google/android/gms/common/data/DataHolder:d	(Ljava/lang/String;II)Z
      //   39: putfield 38	com/google/android/gms/games/internal/GamesClientImpl$LoadProfileSettingsResultImpl:WP	Z
      //   42: aload_1
      //   43: invokevirtual 42	com/google/android/gms/common/data/DataHolder:close	()V
      //   46: return
      //   47: aload_0
      //   48: iconst_1
      //   49: putfield 34	com/google/android/gms/games/internal/GamesClientImpl$LoadProfileSettingsResultImpl:We	Z
      //   52: aload_0
      //   53: iconst_0
      //   54: putfield 38	com/google/android/gms/games/internal/GamesClientImpl$LoadProfileSettingsResultImpl:WP	Z
      //   57: goto -15 -> 42
      //   60: astore_3
      //   61: aload_1
      //   62: invokevirtual 42	com/google/android/gms/common/data/DataHolder:close	()V
      //   65: aload_3
      //   66: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	67	0	this	LoadProfileSettingsResultImpl
      //   0	67	1	paramDataHolder	DataHolder
      //   17	19	2	i	int
      //   60	6	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   5	42	60	finally
      //   47	57	60	finally
    }
    
    public Status getStatus()
    {
      return this.CM;
    }
    
    public boolean isProfileVisible()
    {
      return this.We;
    }
    
    public boolean isVisibilityExplicitlySet()
    {
      return this.WP;
    }
  }
  
  private static final class LoadQuestsResultImpl
    extends com.google.android.gms.common.api.a
    implements Quests.LoadQuestsResult
  {
    private final DataHolder IC;
    
    LoadQuestsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.IC = paramDataHolder;
    }
    
    public QuestBuffer getQuests()
    {
      return new QuestBuffer(this.IC);
    }
  }
  
  private static final class LoadRequestSummariesResultImpl
    extends com.google.android.gms.common.api.a
    implements Requests.LoadRequestSummariesResult
  {
    LoadRequestSummariesResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class LoadRequestsResultImpl
    implements Requests.LoadRequestsResult
  {
    private final Status CM;
    private final Bundle WQ;
    
    LoadRequestsResultImpl(Status paramStatus, Bundle paramBundle)
    {
      this.CM = paramStatus;
      this.WQ = paramBundle;
    }
    
    public GameRequestBuffer getRequests(int paramInt)
    {
      String str = RequestType.dH(paramInt);
      if (!this.WQ.containsKey(str)) {
        return null;
      }
      return new GameRequestBuffer((DataHolder)this.WQ.get(str));
    }
    
    public Status getStatus()
    {
      return this.CM;
    }
    
    public void release()
    {
      Iterator localIterator = this.WQ.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (DataHolder)this.WQ.getParcelable((String)localObject);
        if (localObject != null) {
          ((DataHolder)localObject).close();
        }
      }
    }
  }
  
  private static final class LoadScoresResultImpl
    extends com.google.android.gms.common.api.a
    implements Leaderboards.LoadScoresResult
  {
    private final LeaderboardEntity WR;
    private final LeaderboardScoreBuffer WS;
    
    /* Error */
    LoadScoresResultImpl(DataHolder paramDataHolder1, DataHolder paramDataHolder2)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_2
      //   2: invokespecial 18	com/google/android/gms/common/api/a:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 20	com/google/android/gms/games/leaderboard/LeaderboardBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 21	com/google/android/gms/games/leaderboard/LeaderboardBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_1
      //   14: aload_1
      //   15: invokevirtual 25	com/google/android/gms/games/leaderboard/LeaderboardBuffer:getCount	()I
      //   18: ifle +40 -> 58
      //   21: aload_0
      //   22: aload_1
      //   23: iconst_0
      //   24: invokevirtual 29	com/google/android/gms/games/leaderboard/LeaderboardBuffer:get	(I)Ljava/lang/Object;
      //   27: checkcast 31	com/google/android/gms/games/leaderboard/Leaderboard
      //   30: invokeinterface 35 1 0
      //   35: checkcast 37	com/google/android/gms/games/leaderboard/LeaderboardEntity
      //   38: putfield 39	com/google/android/gms/games/internal/GamesClientImpl$LoadScoresResultImpl:WR	Lcom/google/android/gms/games/leaderboard/LeaderboardEntity;
      //   41: aload_1
      //   42: invokevirtual 43	com/google/android/gms/games/leaderboard/LeaderboardBuffer:release	()V
      //   45: aload_0
      //   46: new 45	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer
      //   49: dup
      //   50: aload_2
      //   51: invokespecial 46	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   54: putfield 48	com/google/android/gms/games/internal/GamesClientImpl$LoadScoresResultImpl:WS	Lcom/google/android/gms/games/leaderboard/LeaderboardScoreBuffer;
      //   57: return
      //   58: aload_0
      //   59: aconst_null
      //   60: putfield 39	com/google/android/gms/games/internal/GamesClientImpl$LoadScoresResultImpl:WR	Lcom/google/android/gms/games/leaderboard/LeaderboardEntity;
      //   63: goto -22 -> 41
      //   66: astore_2
      //   67: aload_1
      //   68: invokevirtual 43	com/google/android/gms/games/leaderboard/LeaderboardBuffer:release	()V
      //   71: aload_2
      //   72: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	73	0	this	LoadScoresResultImpl
      //   0	73	1	paramDataHolder1	DataHolder
      //   0	73	2	paramDataHolder2	DataHolder
      // Exception table:
      //   from	to	target	type
      //   14	41	66	finally
      //   58	63	66	finally
    }
    
    public Leaderboard getLeaderboard()
    {
      return this.WR;
    }
    
    public LeaderboardScoreBuffer getScores()
    {
      return this.WS;
    }
  }
  
  private static final class LoadSnapshotsResultImpl
    extends com.google.android.gms.common.api.a
    implements Snapshots.LoadSnapshotsResult
  {
    LoadSnapshotsResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
    
    public SnapshotMetadataBuffer getSnapshots()
    {
      return new SnapshotMetadataBuffer(this.IC);
    }
  }
  
  private static final class LoadXpForGameCategoriesResultImpl
    implements Players.LoadXpForGameCategoriesResult
  {
    private final Status CM;
    private final List<String> WT;
    private final Bundle WU;
    
    LoadXpForGameCategoriesResultImpl(Status paramStatus, Bundle paramBundle)
    {
      this.CM = paramStatus;
      this.WT = paramBundle.getStringArrayList("game_category_list");
      this.WU = paramBundle;
    }
    
    public Status getStatus()
    {
      return this.CM;
    }
  }
  
  private static final class LoadXpStreamResultImpl
    extends com.google.android.gms.common.api.a
    implements Players.LoadXpStreamResult
  {
    private final ExperienceEventBuffer WV;
    
    LoadXpStreamResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.WV = new ExperienceEventBuffer(paramDataHolder);
    }
  }
  
  private final class MatchRemovedCallback
    extends d<IGamesService>.b<OnTurnBasedMatchUpdateReceivedListener>
  {
    private final String WW;
    
    MatchRemovedCallback(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener, String paramString)
    {
      super(paramOnTurnBasedMatchUpdateReceivedListener);
      this.WW = paramString;
    }
    
    protected void b(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
    {
      paramOnTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.WW);
    }
    
    protected void gT() {}
  }
  
  private final class MatchUpdateReceivedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final OnTurnBasedMatchUpdateReceivedListener WX;
    
    MatchUpdateReceivedBinderCallback(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
    {
      this.WX = paramOnTurnBasedMatchUpdateReceivedListener;
    }
    
    public void onTurnBasedMatchRemoved(String paramString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.MatchRemovedCallback(GamesClientImpl.this, this.WX, paramString));
    }
    
    public void t(DataHolder paramDataHolder)
    {
      TurnBasedMatchBuffer localTurnBasedMatchBuffer = new TurnBasedMatchBuffer(paramDataHolder);
      paramDataHolder = null;
      try
      {
        if (localTurnBasedMatchBuffer.getCount() > 0) {
          paramDataHolder = (TurnBasedMatch)((TurnBasedMatch)localTurnBasedMatchBuffer.get(0)).freeze();
        }
        localTurnBasedMatchBuffer.release();
        if (paramDataHolder != null) {
          GamesClientImpl.this.a(new GamesClientImpl.MatchUpdateReceivedCallback(GamesClientImpl.this, this.WX, paramDataHolder));
        }
        return;
      }
      finally
      {
        localTurnBasedMatchBuffer.release();
      }
    }
  }
  
  private final class MatchUpdateReceivedCallback
    extends d<IGamesService>.b<OnTurnBasedMatchUpdateReceivedListener>
  {
    private final TurnBasedMatch WY;
    
    MatchUpdateReceivedCallback(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener, TurnBasedMatch paramTurnBasedMatch)
    {
      super(paramOnTurnBasedMatchUpdateReceivedListener);
      this.WY = paramTurnBasedMatch;
    }
    
    protected void b(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
    {
      paramOnTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.WY);
    }
    
    protected void gT() {}
  }
  
  private final class MessageReceivedCallback
    extends d<IGamesService>.b<RealTimeMessageReceivedListener>
  {
    private final RealTimeMessage WZ;
    
    MessageReceivedCallback(RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener, RealTimeMessage paramRealTimeMessage)
    {
      super(paramRealTimeMessageReceivedListener);
      this.WZ = paramRealTimeMessage;
    }
    
    public void a(RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener)
    {
      if (paramRealTimeMessageReceivedListener != null) {
        paramRealTimeMessageReceivedListener.onRealTimeMessageReceived(this.WZ);
      }
    }
    
    protected void gT() {}
  }
  
  private final class NearbyPlayerDetectedCallback
    extends d<IGamesService>.b<OnNearbyPlayerDetectedListener>
  {
    private final Player Xa;
    
    protected void a(OnNearbyPlayerDetectedListener paramOnNearbyPlayerDetectedListener)
    {
      paramOnNearbyPlayerDetectedListener.a(this.Xa);
    }
    
    protected void gT() {}
  }
  
  private final class NotifyAclLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Acls.LoadAclResult> De;
    
    NotifyAclLoadedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void C(DataHolder paramDataHolder)
    {
      this.De.b(new GamesClientImpl.LoadAclResultImpl(paramDataHolder));
    }
  }
  
  private final class NotifyAclUpdatedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Status> De;
    
    NotifyAclUpdatedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void dx(int paramInt)
    {
      this.De.b(new Status(paramInt));
    }
  }
  
  private static final class OpenSnapshotResultImpl
    extends com.google.android.gms.common.api.a
    implements Snapshots.OpenSnapshotResult
  {
    private final Snapshot Xb;
    private final String Xc;
    private final Snapshot Xd;
    private final Contents Xe;
    private final SnapshotContents Xf;
    
    OpenSnapshotResultImpl(DataHolder paramDataHolder, Contents paramContents)
    {
      this(paramDataHolder, null, paramContents, null, null);
    }
    
    OpenSnapshotResultImpl(DataHolder paramDataHolder, String paramString, Contents paramContents1, Contents paramContents2, Contents paramContents3)
    {
      super();
      SnapshotMetadataBuffer localSnapshotMetadataBuffer = new SnapshotMetadataBuffer(paramDataHolder);
      for (;;)
      {
        try
        {
          if (localSnapshotMetadataBuffer.getCount() == 0)
          {
            this.Xb = null;
            this.Xd = null;
            localSnapshotMetadataBuffer.release();
            this.Xc = paramString;
            this.Xe = paramContents3;
            this.Xf = new SnapshotContents(paramContents3);
            return;
          }
          if (localSnapshotMetadataBuffer.getCount() != 1) {
            break label144;
          }
          if (paramDataHolder.getStatusCode() != 4004)
          {
            com.google.android.gms.common.internal.a.I(bool);
            this.Xb = new SnapshotEntity(new SnapshotMetadataEntity(localSnapshotMetadataBuffer.get(0)), new SnapshotContents(paramContents1));
            this.Xd = null;
            continue;
          }
          bool = false;
        }
        finally
        {
          localSnapshotMetadataBuffer.release();
        }
        continue;
        label144:
        this.Xb = new SnapshotEntity(new SnapshotMetadataEntity(localSnapshotMetadataBuffer.get(0)), new SnapshotContents(paramContents1));
        this.Xd = new SnapshotEntity(new SnapshotMetadataEntity(localSnapshotMetadataBuffer.get(1)), new SnapshotContents(paramContents2));
      }
    }
    
    public String getConflictId()
    {
      return this.Xc;
    }
    
    public Snapshot getConflictingSnapshot()
    {
      return this.Xd;
    }
    
    @Deprecated
    public Contents getResolutionContents()
    {
      return this.Xe;
    }
    
    public SnapshotContents getResolutionSnapshotContents()
    {
      return this.Xf;
    }
    
    public Snapshot getSnapshot()
    {
      return this.Xb;
    }
  }
  
  private final class OwnerCoverPhotoUrisLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Players.LoadOwnerCoverPhotoUrisResult> De;
    
    OwnerCoverPhotoUrisLoadedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void d(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      this.De.b(new GamesClientImpl.LoadOwnerCoverPhotoUrisResultImpl(paramInt, paramBundle));
    }
  }
  
  private final class P2PConnectedCallback
    extends d<IGamesService>.b<RoomStatusUpdateListener>
  {
    private final String Xg;
    
    P2PConnectedCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, String paramString)
    {
      super(paramRoomStatusUpdateListener);
      this.Xg = paramString;
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener)
    {
      if (paramRoomStatusUpdateListener != null) {
        paramRoomStatusUpdateListener.onP2PConnected(this.Xg);
      }
    }
    
    protected void gT() {}
  }
  
  private final class P2PDisconnectedCallback
    extends d<IGamesService>.b<RoomStatusUpdateListener>
  {
    private final String Xg;
    
    P2PDisconnectedCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, String paramString)
    {
      super(paramRoomStatusUpdateListener);
      this.Xg = paramString;
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener)
    {
      if (paramRoomStatusUpdateListener != null) {
        paramRoomStatusUpdateListener.onP2PDisconnected(this.Xg);
      }
    }
    
    protected void gT() {}
  }
  
  private final class PeerConnectedCallback
    extends GamesClientImpl.AbstractPeerStatusCallback
  {
    PeerConnectedCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeersConnected(paramRoom, paramArrayList);
    }
  }
  
  private final class PeerDeclinedCallback
    extends GamesClientImpl.AbstractPeerStatusCallback
  {
    PeerDeclinedCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerDeclined(paramRoom, paramArrayList);
    }
  }
  
  private final class PeerDisconnectedCallback
    extends GamesClientImpl.AbstractPeerStatusCallback
  {
    PeerDisconnectedCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeersDisconnected(paramRoom, paramArrayList);
    }
  }
  
  private final class PeerInvitedToRoomCallback
    extends GamesClientImpl.AbstractPeerStatusCallback
  {
    PeerInvitedToRoomCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerInvitedToRoom(paramRoom, paramArrayList);
    }
  }
  
  private final class PeerJoinedRoomCallback
    extends GamesClientImpl.AbstractPeerStatusCallback
  {
    PeerJoinedRoomCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerJoined(paramRoom, paramArrayList);
    }
  }
  
  private final class PeerLeftRoomCallback
    extends GamesClientImpl.AbstractPeerStatusCallback
  {
    PeerLeftRoomCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerLeft(paramRoom, paramArrayList);
    }
  }
  
  private final class PlayerLeaderboardScoreLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Leaderboards.LoadPlayerScoreResult> De;
    
    PlayerLeaderboardScoreLoadedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void E(DataHolder paramDataHolder)
    {
      this.De.b(new GamesClientImpl.LoadPlayerScoreResultImpl(paramDataHolder));
    }
  }
  
  private final class PlayerXpForGameCategoriesLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Players.LoadXpForGameCategoriesResult> De;
    
    PlayerXpForGameCategoriesLoadedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void e(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      Status localStatus = new Status(paramInt);
      this.De.b(new GamesClientImpl.LoadXpForGameCategoriesResultImpl(localStatus, paramBundle));
    }
  }
  
  final class PlayerXpStreamLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Players.LoadXpStreamResult> De;
    
    PlayerXpStreamLoadedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void P(DataHolder paramDataHolder)
    {
      this.De.b(new GamesClientImpl.LoadXpStreamResultImpl(paramDataHolder));
    }
  }
  
  private final class PlayersLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Players.LoadPlayersResult> De;
    
    PlayersLoadedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void g(DataHolder paramDataHolder)
    {
      this.De.b(new GamesClientImpl.LoadPlayersResultImpl(paramDataHolder));
    }
    
    public void h(DataHolder paramDataHolder)
    {
      this.De.b(new GamesClientImpl.LoadPlayersResultImpl(paramDataHolder));
    }
  }
  
  final class ProfileSettingsLoadedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Players.LoadProfileSettingsResult> De;
    
    ProfileSettingsLoadedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void Q(DataHolder paramDataHolder)
    {
      this.De.b(new GamesClientImpl.LoadProfileSettingsResultImpl(paramDataHolder));
    }
  }
  
  private final class ProfileSettingsUpdatedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Status> De;
    
    ProfileSettingsUpdatedBinderCallback()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void dz(int paramInt)
    {
      this.De.b(new Status(paramInt));
    }
  }
  
  private final class QuestAcceptedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Quests.AcceptQuestResult> Xh;
    
    public QuestAcceptedBinderCallbacks()
    {
      Object localObject;
      this.Xh = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void L(DataHolder paramDataHolder)
    {
      this.Xh.b(new GamesClientImpl.AcceptQuestResultImpl(paramDataHolder));
    }
  }
  
  private final class QuestCompletedCallback
    extends d<IGamesService>.b<QuestUpdateListener>
  {
    private final Quest Wt;
    
    QuestCompletedCallback(QuestUpdateListener paramQuestUpdateListener, Quest paramQuest)
    {
      super(paramQuestUpdateListener);
      this.Wt = paramQuest;
    }
    
    protected void b(QuestUpdateListener paramQuestUpdateListener)
    {
      paramQuestUpdateListener.onQuestCompleted(this.Wt);
    }
    
    protected void gT() {}
  }
  
  private final class QuestMilestoneClaimBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Quests.ClaimMilestoneResult> Xi;
    private final String Xj;
    
    public QuestMilestoneClaimBinderCallbacks(String paramString)
    {
      this.Xi = ((BaseImplementation.b)n.b(paramString, "Holder must not be null"));
      Object localObject;
      this.Xj = ((String)n.b(localObject, "MilestoneId must not be null"));
    }
    
    public void K(DataHolder paramDataHolder)
    {
      this.Xi.b(new GamesClientImpl.ClaimMilestoneResultImpl(paramDataHolder, this.Xj));
    }
  }
  
  private final class QuestUpdateBinderCallback
    extends AbstractGamesCallbacks
  {
    private final QuestUpdateListener Xk;
    
    QuestUpdateBinderCallback(QuestUpdateListener paramQuestUpdateListener)
    {
      this.Xk = paramQuestUpdateListener;
    }
    
    private Quest S(DataHolder paramDataHolder)
    {
      QuestBuffer localQuestBuffer = new QuestBuffer(paramDataHolder);
      paramDataHolder = null;
      try
      {
        if (localQuestBuffer.getCount() > 0) {
          paramDataHolder = (Quest)((Quest)localQuestBuffer.get(0)).freeze();
        }
        return paramDataHolder;
      }
      finally
      {
        localQuestBuffer.release();
      }
    }
    
    public void M(DataHolder paramDataHolder)
    {
      paramDataHolder = S(paramDataHolder);
      if (paramDataHolder != null) {
        GamesClientImpl.this.a(new GamesClientImpl.QuestCompletedCallback(GamesClientImpl.this, this.Xk, paramDataHolder));
      }
    }
  }
  
  private final class QuestsLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Quests.LoadQuestsResult> Xl;
    
    public QuestsLoadedBinderCallbacks()
    {
      Object localObject;
      this.Xl = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void O(DataHolder paramDataHolder)
    {
      this.Xl.b(new GamesClientImpl.LoadQuestsResultImpl(paramDataHolder));
    }
  }
  
  private final class RealTimeMessageSentCallback
    extends d<IGamesService>.b<RealTimeMultiplayer.ReliableMessageSentCallback>
  {
    private final int HF;
    private final String Xm;
    private final int Xn;
    
    RealTimeMessageSentCallback(RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback, int paramInt1, int paramInt2, String paramString)
    {
      super(paramReliableMessageSentCallback);
      this.HF = paramInt1;
      this.Xn = paramInt2;
      this.Xm = paramString;
    }
    
    public void a(RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback)
    {
      if (paramReliableMessageSentCallback != null) {
        paramReliableMessageSentCallback.onRealTimeMessageSent(this.HF, this.Xn, this.Xm);
      }
    }
    
    protected void gT() {}
  }
  
  private final class RealTimeReliableMessageBinderCallbacks
    extends AbstractGamesCallbacks
  {
    final RealTimeMultiplayer.ReliableMessageSentCallback Xo;
    
    public RealTimeReliableMessageBinderCallbacks(RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback)
    {
      this.Xo = paramReliableMessageSentCallback;
    }
    
    public void b(int paramInt1, int paramInt2, String paramString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.RealTimeMessageSentCallback(GamesClientImpl.this, this.Xo, paramInt1, paramInt2, paramString));
    }
  }
  
  private final class RequestReceivedBinderCallback
    extends AbstractGamesCallbacks
  {
    private final OnRequestReceivedListener Xp;
    
    RequestReceivedBinderCallback(OnRequestReceivedListener paramOnRequestReceivedListener)
    {
      this.Xp = paramOnRequestReceivedListener;
    }
    
    public void o(DataHolder paramDataHolder)
    {
      GameRequestBuffer localGameRequestBuffer = new GameRequestBuffer(paramDataHolder);
      paramDataHolder = null;
      try
      {
        if (localGameRequestBuffer.getCount() > 0) {
          paramDataHolder = (GameRequest)((GameRequest)localGameRequestBuffer.get(0)).freeze();
        }
        localGameRequestBuffer.release();
        if (paramDataHolder != null) {
          GamesClientImpl.this.a(new GamesClientImpl.RequestReceivedCallback(GamesClientImpl.this, this.Xp, paramDataHolder));
        }
        return;
      }
      finally
      {
        localGameRequestBuffer.release();
      }
    }
    
    public void onRequestRemoved(String paramString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.RequestRemovedCallback(GamesClientImpl.this, this.Xp, paramString));
    }
  }
  
  private final class RequestReceivedCallback
    extends d<IGamesService>.b<OnRequestReceivedListener>
  {
    private final GameRequest Xq;
    
    RequestReceivedCallback(OnRequestReceivedListener paramOnRequestReceivedListener, GameRequest paramGameRequest)
    {
      super(paramOnRequestReceivedListener);
      this.Xq = paramGameRequest;
    }
    
    protected void b(OnRequestReceivedListener paramOnRequestReceivedListener)
    {
      paramOnRequestReceivedListener.onRequestReceived(this.Xq);
    }
    
    protected void gT() {}
  }
  
  private final class RequestRemovedCallback
    extends d<IGamesService>.b<OnRequestReceivedListener>
  {
    private final String Xr;
    
    RequestRemovedCallback(OnRequestReceivedListener paramOnRequestReceivedListener, String paramString)
    {
      super(paramOnRequestReceivedListener);
      this.Xr = paramString;
    }
    
    protected void b(OnRequestReceivedListener paramOnRequestReceivedListener)
    {
      paramOnRequestReceivedListener.onRequestRemoved(this.Xr);
    }
    
    protected void gT() {}
  }
  
  private final class RequestSentBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Requests.SendRequestResult> Xs;
    
    public RequestSentBinderCallbacks()
    {
      Object localObject;
      this.Xs = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void G(DataHolder paramDataHolder)
    {
      this.Xs.b(new GamesClientImpl.SendRequestResultImpl(paramDataHolder));
    }
  }
  
  private final class RequestSummariesLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Requests.LoadRequestSummariesResult> Xt;
    
    public RequestSummariesLoadedBinderCallbacks()
    {
      Object localObject;
      this.Xt = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void H(DataHolder paramDataHolder)
    {
      this.Xt.b(new GamesClientImpl.LoadRequestSummariesResultImpl(paramDataHolder));
    }
  }
  
  private final class RequestsLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Requests.LoadRequestsResult> Xu;
    
    public RequestsLoadedBinderCallbacks()
    {
      Object localObject;
      this.Xu = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void c(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      Status localStatus = new Status(paramInt);
      this.Xu.b(new GamesClientImpl.LoadRequestsResultImpl(localStatus, paramBundle));
    }
  }
  
  private final class RequestsUpdatedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Requests.UpdateRequestsResult> Xv;
    
    public RequestsUpdatedBinderCallbacks()
    {
      Object localObject;
      this.Xv = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void F(DataHolder paramDataHolder)
    {
      this.Xv.b(new GamesClientImpl.UpdateRequestsResultImpl(paramDataHolder));
    }
  }
  
  private final class RoomAutoMatchingCallback
    extends GamesClientImpl.AbstractRoomStatusCallback
  {
    RoomAutoMatchingCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder);
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onRoomAutoMatching(paramRoom);
    }
  }
  
  private final class RoomBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final RoomUpdateListener Xw;
    private final RoomStatusUpdateListener Xx;
    private final RealTimeMessageReceivedListener Xy;
    
    public RoomBinderCallbacks(RoomUpdateListener paramRoomUpdateListener)
    {
      this.Xw = ((RoomUpdateListener)n.b(paramRoomUpdateListener, "Callbacks must not be null"));
      this.Xx = null;
      this.Xy = null;
    }
    
    public RoomBinderCallbacks(RoomUpdateListener paramRoomUpdateListener, RoomStatusUpdateListener paramRoomStatusUpdateListener, RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener)
    {
      this.Xw = ((RoomUpdateListener)n.b(paramRoomUpdateListener, "Callbacks must not be null"));
      this.Xx = paramRoomStatusUpdateListener;
      this.Xy = paramRealTimeMessageReceivedListener;
    }
    
    public void A(DataHolder paramDataHolder)
    {
      GamesClientImpl.this.a(new GamesClientImpl.DisconnectedFromRoomCallback(GamesClientImpl.this, this.Xx, paramDataHolder));
    }
    
    public void a(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.PeerInvitedToRoomCallback(GamesClientImpl.this, this.Xx, paramDataHolder, paramArrayOfString));
    }
    
    public void b(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.PeerJoinedRoomCallback(GamesClientImpl.this, this.Xx, paramDataHolder, paramArrayOfString));
    }
    
    public void c(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.PeerLeftRoomCallback(GamesClientImpl.this, this.Xx, paramDataHolder, paramArrayOfString));
    }
    
    public void d(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.PeerDeclinedCallback(GamesClientImpl.this, this.Xx, paramDataHolder, paramArrayOfString));
    }
    
    public void e(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.PeerConnectedCallback(GamesClientImpl.this, this.Xx, paramDataHolder, paramArrayOfString));
    }
    
    public void f(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.PeerDisconnectedCallback(GamesClientImpl.this, this.Xx, paramDataHolder, paramArrayOfString));
    }
    
    public void onLeftRoom(int paramInt, String paramString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.LeftRoomCallback(GamesClientImpl.this, this.Xw, paramInt, paramString));
    }
    
    public void onP2PConnected(String paramString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.P2PConnectedCallback(GamesClientImpl.this, this.Xx, paramString));
    }
    
    public void onP2PDisconnected(String paramString)
    {
      GamesClientImpl.this.a(new GamesClientImpl.P2PDisconnectedCallback(GamesClientImpl.this, this.Xx, paramString));
    }
    
    public void onRealTimeMessageReceived(RealTimeMessage paramRealTimeMessage)
    {
      GamesClientImpl.this.a(new GamesClientImpl.MessageReceivedCallback(GamesClientImpl.this, this.Xy, paramRealTimeMessage));
    }
    
    public void u(DataHolder paramDataHolder)
    {
      GamesClientImpl.this.a(new GamesClientImpl.RoomCreatedCallback(GamesClientImpl.this, this.Xw, paramDataHolder));
    }
    
    public void v(DataHolder paramDataHolder)
    {
      GamesClientImpl.this.a(new GamesClientImpl.JoinedRoomCallback(GamesClientImpl.this, this.Xw, paramDataHolder));
    }
    
    public void w(DataHolder paramDataHolder)
    {
      GamesClientImpl.this.a(new GamesClientImpl.RoomConnectingCallback(GamesClientImpl.this, this.Xx, paramDataHolder));
    }
    
    public void x(DataHolder paramDataHolder)
    {
      GamesClientImpl.this.a(new GamesClientImpl.RoomAutoMatchingCallback(GamesClientImpl.this, this.Xx, paramDataHolder));
    }
    
    public void y(DataHolder paramDataHolder)
    {
      GamesClientImpl.this.a(new GamesClientImpl.RoomConnectedCallback(GamesClientImpl.this, this.Xw, paramDataHolder));
    }
    
    public void z(DataHolder paramDataHolder)
    {
      GamesClientImpl.this.a(new GamesClientImpl.ConnectedToRoomCallback(GamesClientImpl.this, this.Xx, paramDataHolder));
    }
  }
  
  private final class RoomConnectedCallback
    extends GamesClientImpl.AbstractRoomCallback
  {
    RoomConnectedCallback(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomUpdateListener, paramDataHolder);
    }
    
    public void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt)
    {
      paramRoomUpdateListener.onRoomConnected(paramInt, paramRoom);
    }
  }
  
  private final class RoomConnectingCallback
    extends GamesClientImpl.AbstractRoomStatusCallback
  {
    RoomConnectingCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder);
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onRoomConnecting(paramRoom);
    }
  }
  
  private final class RoomCreatedCallback
    extends GamesClientImpl.AbstractRoomCallback
  {
    public RoomCreatedCallback(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomUpdateListener, paramDataHolder);
    }
    
    public void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt)
    {
      paramRoomUpdateListener.onRoomCreated(paramInt, paramRoom);
    }
  }
  
  private static final class SendRequestResultImpl
    extends com.google.android.gms.common.api.a
    implements Requests.SendRequestResult
  {
    private final GameRequest Xq;
    
    /* Error */
    SendRequestResultImpl(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 15	com/google/android/gms/common/api/a:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 17	com/google/android/gms/games/request/GameRequestBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 18	com/google/android/gms/games/request/GameRequestBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_1
      //   14: aload_1
      //   15: invokevirtual 22	com/google/android/gms/games/request/GameRequestBuffer:getCount	()I
      //   18: ifle +28 -> 46
      //   21: aload_0
      //   22: aload_1
      //   23: iconst_0
      //   24: invokevirtual 26	com/google/android/gms/games/request/GameRequestBuffer:get	(I)Ljava/lang/Object;
      //   27: checkcast 28	com/google/android/gms/games/request/GameRequest
      //   30: invokeinterface 32 1 0
      //   35: checkcast 28	com/google/android/gms/games/request/GameRequest
      //   38: putfield 34	com/google/android/gms/games/internal/GamesClientImpl$SendRequestResultImpl:Xq	Lcom/google/android/gms/games/request/GameRequest;
      //   41: aload_1
      //   42: invokevirtual 38	com/google/android/gms/games/request/GameRequestBuffer:release	()V
      //   45: return
      //   46: aload_0
      //   47: aconst_null
      //   48: putfield 34	com/google/android/gms/games/internal/GamesClientImpl$SendRequestResultImpl:Xq	Lcom/google/android/gms/games/request/GameRequest;
      //   51: goto -10 -> 41
      //   54: astore_2
      //   55: aload_1
      //   56: invokevirtual 38	com/google/android/gms/games/request/GameRequestBuffer:release	()V
      //   59: aload_2
      //   60: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	SendRequestResultImpl
      //   0	61	1	paramDataHolder	DataHolder
      //   54	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	41	54	finally
      //   46	51	54	finally
    }
  }
  
  private final class SignOutCompleteBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Status> De;
    
    public SignOutCompleteBinderCallbacks()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void fq()
    {
      Status localStatus = new Status(0);
      this.De.b(localStatus);
    }
  }
  
  private final class SnapshotCommittedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Snapshots.CommitSnapshotResult> Xz;
    
    public SnapshotCommittedBinderCallbacks()
    {
      Object localObject;
      this.Xz = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void J(DataHolder paramDataHolder)
    {
      this.Xz.b(new GamesClientImpl.CommitSnapshotResultImpl(paramDataHolder));
    }
  }
  
  final class SnapshotDeletedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Snapshots.DeleteSnapshotResult> De;
    
    public SnapshotDeletedBinderCallbacks()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void i(int paramInt, String paramString)
    {
      this.De.b(new GamesClientImpl.DeleteSnapshotResultImpl(paramInt, paramString));
    }
  }
  
  private final class SnapshotOpenedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Snapshots.OpenSnapshotResult> XA;
    
    public SnapshotOpenedBinderCallbacks()
    {
      Object localObject;
      this.XA = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void a(DataHolder paramDataHolder, Contents paramContents)
    {
      this.XA.b(new GamesClientImpl.OpenSnapshotResultImpl(paramDataHolder, paramContents));
    }
    
    public void a(DataHolder paramDataHolder, String paramString, Contents paramContents1, Contents paramContents2, Contents paramContents3)
    {
      this.XA.b(new GamesClientImpl.OpenSnapshotResultImpl(paramDataHolder, paramString, paramContents1, paramContents2, paramContents3));
    }
  }
  
  private final class SnapshotsLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Snapshots.LoadSnapshotsResult> XB;
    
    public SnapshotsLoadedBinderCallbacks()
    {
      Object localObject;
      this.XB = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void I(DataHolder paramDataHolder)
    {
      this.XB.b(new GamesClientImpl.LoadSnapshotsResultImpl(paramDataHolder));
    }
  }
  
  private final class SubmitScoreBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<Leaderboards.SubmitScoreResult> De;
    
    public SubmitScoreBinderCallbacks()
    {
      Object localObject;
      this.De = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void f(DataHolder paramDataHolder)
    {
      this.De.b(new GamesClientImpl.SubmitScoreResultImpl(paramDataHolder));
    }
  }
  
  private static final class SubmitScoreResultImpl
    extends com.google.android.gms.common.api.a
    implements Leaderboards.SubmitScoreResult
  {
    private final ScoreSubmissionData XC;
    
    public SubmitScoreResultImpl(DataHolder paramDataHolder)
    {
      super();
      try
      {
        this.XC = new ScoreSubmissionData(paramDataHolder);
        return;
      }
      finally
      {
        paramDataHolder.close();
      }
    }
    
    public ScoreSubmissionData getScoreData()
    {
      return this.XC;
    }
  }
  
  private final class TurnBasedMatchCanceledBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<TurnBasedMultiplayer.CancelMatchResult> XD;
    
    public TurnBasedMatchCanceledBinderCallbacks()
    {
      Object localObject;
      this.XD = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void h(int paramInt, String paramString)
    {
      Status localStatus = new Status(paramInt);
      this.XD.b(new GamesClientImpl.CancelMatchResultImpl(localStatus, paramString));
    }
  }
  
  private final class TurnBasedMatchInitiatedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<TurnBasedMultiplayer.InitiateMatchResult> XE;
    
    public TurnBasedMatchInitiatedBinderCallbacks()
    {
      Object localObject;
      this.XE = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void q(DataHolder paramDataHolder)
    {
      this.XE.b(new GamesClientImpl.InitiateMatchResultImpl(paramDataHolder));
    }
  }
  
  private final class TurnBasedMatchLeftBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<TurnBasedMultiplayer.LeaveMatchResult> XF;
    
    public TurnBasedMatchLeftBinderCallbacks()
    {
      Object localObject;
      this.XF = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void s(DataHolder paramDataHolder)
    {
      this.XF.b(new GamesClientImpl.LeaveMatchResultImpl(paramDataHolder));
    }
  }
  
  private final class TurnBasedMatchLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<TurnBasedMultiplayer.LoadMatchResult> XG;
    
    public TurnBasedMatchLoadedBinderCallbacks()
    {
      Object localObject;
      this.XG = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void p(DataHolder paramDataHolder)
    {
      this.XG.b(new GamesClientImpl.LoadMatchResultImpl(paramDataHolder));
    }
  }
  
  private static abstract class TurnBasedMatchResult
    extends com.google.android.gms.common.api.a
  {
    final TurnBasedMatch WY;
    
    /* Error */
    TurnBasedMatchResult(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 13	com/google/android/gms/common/api/a:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   5: new 15	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer
      //   8: dup
      //   9: aload_1
      //   10: invokespecial 16	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: astore_1
      //   14: aload_1
      //   15: invokevirtual 20	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:getCount	()I
      //   18: ifle +28 -> 46
      //   21: aload_0
      //   22: aload_1
      //   23: iconst_0
      //   24: invokevirtual 24	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:get	(I)Ljava/lang/Object;
      //   27: checkcast 26	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch
      //   30: invokeinterface 30 1 0
      //   35: checkcast 26	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch
      //   38: putfield 32	com/google/android/gms/games/internal/GamesClientImpl$TurnBasedMatchResult:WY	Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;
      //   41: aload_1
      //   42: invokevirtual 36	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:release	()V
      //   45: return
      //   46: aload_0
      //   47: aconst_null
      //   48: putfield 32	com/google/android/gms/games/internal/GamesClientImpl$TurnBasedMatchResult:WY	Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;
      //   51: goto -10 -> 41
      //   54: astore_2
      //   55: aload_1
      //   56: invokevirtual 36	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:release	()V
      //   59: aload_2
      //   60: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	TurnBasedMatchResult
      //   0	61	1	paramDataHolder	DataHolder
      //   54	6	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   14	41	54	finally
      //   46	51	54	finally
    }
    
    public TurnBasedMatch getMatch()
    {
      return this.WY;
    }
  }
  
  private final class TurnBasedMatchUpdatedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<TurnBasedMultiplayer.UpdateMatchResult> XH;
    
    public TurnBasedMatchUpdatedBinderCallbacks()
    {
      Object localObject;
      this.XH = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void r(DataHolder paramDataHolder)
    {
      this.XH.b(new GamesClientImpl.UpdateMatchResultImpl(paramDataHolder));
    }
  }
  
  private final class TurnBasedMatchesLoadedBinderCallbacks
    extends AbstractGamesCallbacks
  {
    private final BaseImplementation.b<TurnBasedMultiplayer.LoadMatchesResult> XI;
    
    public TurnBasedMatchesLoadedBinderCallbacks()
    {
      Object localObject;
      this.XI = ((BaseImplementation.b)n.b(localObject, "Holder must not be null"));
    }
    
    public void b(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      Status localStatus = new Status(paramInt);
      this.XI.b(new GamesClientImpl.LoadMatchesResultImpl(localStatus, paramBundle));
    }
  }
  
  private static final class UpdateAchievementResultImpl
    implements Achievements.UpdateAchievementResult
  {
    private final Status CM;
    private final String VP;
    
    UpdateAchievementResultImpl(int paramInt, String paramString)
    {
      this.CM = new Status(paramInt);
      this.VP = paramString;
    }
    
    public String getAchievementId()
    {
      return this.VP;
    }
    
    public Status getStatus()
    {
      return this.CM;
    }
  }
  
  private static final class UpdateMatchResultImpl
    extends GamesClientImpl.TurnBasedMatchResult
    implements TurnBasedMultiplayer.UpdateMatchResult
  {
    UpdateMatchResultImpl(DataHolder paramDataHolder)
    {
      super();
    }
  }
  
  private static final class UpdateRequestsResultImpl
    extends com.google.android.gms.common.api.a
    implements Requests.UpdateRequestsResult
  {
    private final RequestUpdateOutcomes XJ;
    
    UpdateRequestsResultImpl(DataHolder paramDataHolder)
    {
      super();
      this.XJ = RequestUpdateOutcomes.V(paramDataHolder);
    }
    
    public Set<String> getRequestIds()
    {
      return this.XJ.getRequestIds();
    }
    
    public int getRequestOutcome(String paramString)
    {
      return this.XJ.getRequestOutcome(paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/internal/GamesClientImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */