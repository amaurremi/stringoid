package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.a;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBufferHeader;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.e;
import com.google.android.gms.internal.hi;
import com.google.android.gms.internal.hm;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public final class GamesClientImpl
  extends hb<IGamesService>
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private final boolean NA;
  private final int NB;
  private final boolean NC;
  private final String ND;
  EventIncrementManager Np = new EventIncrementManager()
  {
    public EventIncrementCache hx()
    {
      return new r(GamesClientImpl.this);
    }
  };
  private final String Nq;
  private final Map<String, RealTimeSocket> Nr;
  private PlayerEntity Ns;
  private GameEntity Nt;
  private final PopupManager Nu;
  private boolean Nv = false;
  private boolean Nw = false;
  private int Nx;
  private final Binder Ny;
  private final long Nz;
  private final String yQ;
  
  public GamesClientImpl(Context paramContext, Looper paramLooper, String paramString1, String paramString2, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String[] paramArrayOfString, int paramInt1, View paramView, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, boolean paramBoolean3, int paramInt3, String paramString3)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString);
    this.Nq = paramString1;
    this.yQ = ((String)hm.f(paramString2));
    this.Ny = new Binder();
    this.Nr = new HashMap();
    this.Nu = PopupManager.a(this, paramInt1);
    f(paramView);
    this.Nw = paramBoolean2;
    this.Nx = paramInt2;
    this.Nz = hashCode();
    this.NA = paramBoolean1;
    this.NC = paramBoolean3;
    this.NB = paramInt3;
    this.ND = paramString3;
    registerConnectionCallbacks(this);
    registerConnectionFailedListener(this);
  }
  
  private Room Q(DataHolder paramDataHolder)
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
      localRoomBuffer.close();
    }
  }
  
  /* Error */
  private RealTimeSocket aT(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 150	com/google/android/gms/games/internal/GamesClientImpl:ft	()Landroid/os/IInterface;
    //   4: checkcast 152	com/google/android/gms/games/internal/IGamesService
    //   7: aload_1
    //   8: invokeinterface 156 2 0
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +33 -> 48
    //   18: ldc -98
    //   20: ldc -96
    //   22: invokestatic 166	com/google/android/gms/games/internal/GamesLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: new 168	com/google/android/gms/games/internal/LibjingleNativeSocket
    //   28: dup
    //   29: aload_2
    //   30: invokespecial 171	com/google/android/gms/games/internal/LibjingleNativeSocket:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   33: astore_2
    //   34: aload_0
    //   35: getfield 76	com/google/android/gms/games/internal/GamesClientImpl:Nr	Ljava/util/Map;
    //   38: aload_1
    //   39: aload_2
    //   40: invokeinterface 177 3 0
    //   45: pop
    //   46: aload_2
    //   47: areturn
    //   48: ldc -98
    //   50: ldc -77
    //   52: invokestatic 166	com/google/android/gms/games/internal/GamesLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_0
    //   56: invokevirtual 150	com/google/android/gms/games/internal/GamesClientImpl:ft	()Landroid/os/IInterface;
    //   59: checkcast 152	com/google/android/gms/games/internal/IGamesService
    //   62: aload_1
    //   63: invokeinterface 183 2 0
    //   68: astore_2
    //   69: aload_2
    //   70: ifnonnull +5 -> 75
    //   73: aconst_null
    //   74: areturn
    //   75: new 185	android/net/LocalSocket
    //   78: dup
    //   79: invokespecial 186	android/net/LocalSocket:<init>	()V
    //   82: astore_3
    //   83: aload_3
    //   84: new 188	android/net/LocalSocketAddress
    //   87: dup
    //   88: aload_2
    //   89: invokespecial 191	android/net/LocalSocketAddress:<init>	(Ljava/lang/String;)V
    //   92: invokevirtual 195	android/net/LocalSocket:connect	(Landroid/net/LocalSocketAddress;)V
    //   95: new 197	com/google/android/gms/games/internal/dq
    //   98: dup
    //   99: aload_3
    //   100: aload_1
    //   101: invokespecial 200	com/google/android/gms/games/internal/dq:<init>	(Landroid/net/LocalSocket;Ljava/lang/String;)V
    //   104: astore_2
    //   105: aload_0
    //   106: getfield 76	com/google/android/gms/games/internal/GamesClientImpl:Nr	Ljava/util/Map;
    //   109: aload_1
    //   110: aload_2
    //   111: invokeinterface 177 3 0
    //   116: pop
    //   117: aload_2
    //   118: areturn
    //   119: astore_1
    //   120: ldc -98
    //   122: ldc -54
    //   124: invokestatic 205	com/google/android/gms/games/internal/GamesLog:k	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aconst_null
    //   128: areturn
    //   129: astore_1
    //   130: ldc -98
    //   132: new 207	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   139: ldc -46
    //   141: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_1
    //   145: invokevirtual 218	java/io/IOException:getMessage	()Ljava/lang/String;
    //   148: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 205	com/google/android/gms/games/internal/GamesLog:k	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aconst_null
    //   158: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	GamesClientImpl
    //   0	159	1	paramString	String
    //   13	105	2	localObject	Object
    //   82	18	3	localLocalSocket	android.net.LocalSocket
    // Exception table:
    //   from	to	target	type
    //   0	14	119	android/os/RemoteException
    //   18	46	119	android/os/RemoteException
    //   48	69	119	android/os/RemoteException
    //   75	83	119	android/os/RemoteException
    //   83	95	119	android/os/RemoteException
    //   95	117	119	android/os/RemoteException
    //   130	157	119	android/os/RemoteException
    //   83	95	129	java/io/IOException
  }
  
  private void gY()
  {
    this.Ns = null;
  }
  
  private void hv()
  {
    Iterator localIterator = this.Nr.values().iterator();
    while (localIterator.hasNext())
    {
      RealTimeSocket localRealTimeSocket = (RealTimeSocket)localIterator.next();
      try
      {
        localRealTimeSocket.close();
      }
      catch (IOException localIOException)
      {
        GamesLog.b("GamesClientImpl", "IOException:", localIOException);
      }
    }
    this.Nr.clear();
  }
  
  public int a(RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    try
    {
      int i = ((IGamesService)ft()).a(new cg(this, paramReliableMessageSentCallback), paramArrayOfByte, paramString1, paramString2);
      return i;
    }
    catch (RemoteException paramReliableMessageSentCallback)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public int a(byte[] paramArrayOfByte, String paramString, String[] paramArrayOfString)
  {
    hm.b(paramArrayOfString, "Participant IDs must not be null");
    try
    {
      int i = ((IGamesService)ft()).b(paramArrayOfByte, paramString, paramArrayOfString);
      return i;
    }
    catch (RemoteException paramArrayOfByte)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public Intent a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = ((IGamesService)ft()).a(paramInt1, paramInt2, paramBoolean);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, Bitmap paramBitmap, String paramString)
  {
    try
    {
      paramArrayOfByte = ((IGamesService)ft()).a(paramInt1, paramArrayOfByte, paramInt2, paramString);
      hm.b(paramBitmap, "Must provide a non null icon");
      paramArrayOfByte.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", paramBitmap);
      return paramArrayOfByte;
    }
    catch (RemoteException paramArrayOfByte)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent a(Room paramRoom, int paramInt)
  {
    try
    {
      paramRoom = ((IGamesService)ft()).a((RoomEntity)paramRoom.freeze(), paramInt);
      return paramRoom;
    }
    catch (RemoteException paramRoom)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    try
    {
      paramString = ((IGamesService)ft()).a(paramString, paramBoolean1, paramBoolean2, paramInt);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent a(int[] paramArrayOfInt)
  {
    try
    {
      paramArrayOfInt = ((IGamesService)ft()).a(paramArrayOfInt);
      return paramArrayOfInt;
    }
    catch (RemoteException paramArrayOfInt)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return null;
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBundle != null)) {
      this.Nv = paramBundle.getBoolean("show_welcome_popup");
    }
    super.a(paramInt, paramIBinder, paramBundle);
  }
  
  public void a(IBinder paramIBinder, Bundle paramBundle)
  {
    if (isConnected()) {}
    try
    {
      ((IGamesService)ft()).a(paramIBinder, paramBundle);
      return;
    }
    catch (RemoteException paramIBinder)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Requests.LoadRequestsResult> paramd, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      ((IGamesService)ft()).a(new cm(this, paramd), paramInt1, paramInt2, paramInt3);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<GamesMetadata.LoadExtendedGamesResult> paramd, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)ft()).a(new q(this, paramd), paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Players.LoadPlayersResult> paramd, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)ft()).a(new bz(this, paramd), paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<TurnBasedMultiplayer.LoadMatchesResult> paramd, int paramInt, int[] paramArrayOfInt)
  {
    try
    {
      ((IGamesService)ft()).a(new dh(this, paramd), paramInt, paramArrayOfInt);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Leaderboards.LoadScoresResult> paramd, LeaderboardScoreBuffer paramLeaderboardScoreBuffer, int paramInt1, int paramInt2)
  {
    try
    {
      ((IGamesService)ft()).a(new ai(this, paramd), paramLeaderboardScoreBuffer.iA().iB(), paramInt1, paramInt2);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<TurnBasedMultiplayer.InitiateMatchResult> paramd, TurnBasedMatchConfig paramTurnBasedMatchConfig)
  {
    try
    {
      ((IGamesService)ft()).a(new dc(this, paramd), paramTurnBasedMatchConfig.getVariant(), paramTurnBasedMatchConfig.iH(), paramTurnBasedMatchConfig.getInvitedPlayerIds(), paramTurnBasedMatchConfig.getAutoMatchCriteria());
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Snapshots.CommitSnapshotResult> paramd, Snapshot paramSnapshot, SnapshotMetadataChange paramSnapshotMetadataChange)
  {
    Contents localContents = paramSnapshot.getContents();
    hm.b(localContents, "Must provide a previously opened Snapshot");
    a locala = paramSnapshotMetadataChange.iN();
    if (locala != null) {
      locala.a(getContext().getCacheDir());
    }
    paramSnapshot.iM();
    try
    {
      ((IGamesService)ft()).a(new cv(this, paramd), paramSnapshot.getMetadata().getSnapshotId(), paramSnapshotMetadataChange, localContents);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Players.LoadPlayersResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)ft()).a(new bz(this, paramd), paramString);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Achievements.UpdateAchievementResult> paramd, String paramString, int paramInt)
  {
    if (paramd == null) {}
    for (paramd = null;; paramd = new e(this, paramd)) {
      try
      {
        ((IGamesService)ft()).a(paramd, paramString, paramInt, this.Nu.hN(), this.Nu.hM());
        return;
      }
      catch (RemoteException paramd)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<Leaderboards.LoadScoresResult> paramd, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)ft()).a(new ai(this, paramd), paramString, paramInt1, paramInt2, paramInt3, paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Players.LoadPlayersResult> paramd, String paramString, int paramInt, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)ft()).a(new bz(this, paramd), paramString, paramInt, paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Players.LoadPlayersResult> paramd, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramString.equals("played_with")) {
      throw new IllegalArgumentException("Invalid player collection: " + paramString);
    }
    try
    {
      ((IGamesService)ft()).d(new bz(this, paramd), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<GamesMetadata.LoadExtendedGamesResult> paramd, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    try
    {
      ((IGamesService)ft()).a(new q(this, paramd), paramString, paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<TurnBasedMultiplayer.LoadMatchesResult> paramd, String paramString, int paramInt, int[] paramArrayOfInt)
  {
    try
    {
      ((IGamesService)ft()).a(new dh(this, paramd), paramString, paramInt, paramArrayOfInt);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Leaderboards.SubmitScoreResult> paramd, String paramString1, long paramLong, String paramString2)
  {
    if (paramd == null) {}
    for (paramd = null;; paramd = new cz(this, paramd)) {
      try
      {
        ((IGamesService)ft()).a(paramd, paramString1, paramLong, paramString2);
        return;
      }
      catch (RemoteException paramd)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.d<TurnBasedMultiplayer.LeaveMatchResult> paramd, String paramString1, String paramString2)
  {
    try
    {
      ((IGamesService)ft()).c(new dd(this, paramd), paramString1, paramString2);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Leaderboards.LoadPlayerScoreResult> paramd, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    try
    {
      ((IGamesService)ft()).a(new bw(this, paramd), paramString1, paramString2, paramInt1, paramInt2);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Requests.LoadRequestsResult> paramd, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      ((IGamesService)ft()).a(new cm(this, paramd), paramString1, paramString2, paramInt1, paramInt2, paramInt3);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Leaderboards.LoadScoresResult> paramd, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)ft()).a(new ai(this, paramd), paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Players.LoadPlayersResult> paramd, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramString1.equals("played_with")) && (!paramString1.equals("circled"))) {
      throw new IllegalArgumentException("Invalid player collection: " + paramString1);
    }
    try
    {
      ((IGamesService)ft()).a(new bz(this, paramd), paramString1, paramString2, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Snapshots.OpenSnapshotResult> paramd, String paramString1, String paramString2, SnapshotMetadataChange paramSnapshotMetadataChange, Contents paramContents)
  {
    a locala = paramSnapshotMetadataChange.iN();
    if (locala != null) {
      locala.a(getContext().getCacheDir());
    }
    try
    {
      ((IGamesService)ft()).a(new cx(this, paramd), paramString1, paramString2, paramSnapshotMetadataChange, paramContents);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Leaderboards.LeaderboardMetadataResult> paramd, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)ft()).b(new aj(this, paramd), paramString1, paramString2, paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Quests.LoadQuestsResult> paramd, String paramString1, String paramString2, boolean paramBoolean, String[] paramArrayOfString)
  {
    try
    {
      ((IGamesService)ft()).a(new ce(this, paramd), paramString1, paramString2, paramArrayOfString, paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Quests.LoadQuestsResult> paramd, String paramString1, String paramString2, int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)ft()).a(new ce(this, paramd), paramString1, paramString2, paramArrayOfInt, paramInt, paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Requests.UpdateRequestsResult> paramd, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      ((IGamesService)ft()).a(new cn(this, paramd), paramString1, paramString2, paramArrayOfString);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Leaderboards.LeaderboardMetadataResult> paramd, String paramString, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)ft()).c(new aj(this, paramd), paramString, paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<TurnBasedMultiplayer.UpdateMatchResult> paramd, String paramString1, byte[] paramArrayOfByte, String paramString2, ParticipantResult[] paramArrayOfParticipantResult)
  {
    try
    {
      ((IGamesService)ft()).a(new dg(this, paramd), paramString1, paramArrayOfByte, paramString2, paramArrayOfParticipantResult);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<TurnBasedMultiplayer.UpdateMatchResult> paramd, String paramString, byte[] paramArrayOfByte, ParticipantResult[] paramArrayOfParticipantResult)
  {
    try
    {
      ((IGamesService)ft()).a(new dg(this, paramd), paramString, paramArrayOfByte, paramArrayOfParticipantResult);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Requests.SendRequestResult> paramd, String paramString, String[] paramArrayOfString, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    try
    {
      ((IGamesService)ft()).a(new ck(this, paramd), paramString, paramArrayOfString, paramInt1, paramArrayOfByte, paramInt2);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Players.LoadPlayersResult> paramd, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)ft()).c(new bz(this, paramd), paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Status> paramd, boolean paramBoolean, Bundle paramBundle)
  {
    try
    {
      ((IGamesService)ft()).a(new m(this, paramd), paramBoolean, paramBundle);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Events.LoadEventsResult> paramd, boolean paramBoolean, String... paramVarArgs)
  {
    try
    {
      this.Np.flush();
      ((IGamesService)ft()).a(new p(this, paramd), paramBoolean, paramVarArgs);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Quests.LoadQuestsResult> paramd, int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    try
    {
      this.Np.flush();
      ((IGamesService)ft()).a(new ce(this, paramd), paramArrayOfInt, paramInt, paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.d<Players.LoadPlayersResult> paramd, String[] paramArrayOfString)
  {
    try
    {
      ((IGamesService)ft()).c(new bz(this, paramd), paramArrayOfString);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(OnInvitationReceivedListener paramOnInvitationReceivedListener)
  {
    try
    {
      paramOnInvitationReceivedListener = new ac(this, paramOnInvitationReceivedListener);
      ((IGamesService)ft()).a(paramOnInvitationReceivedListener, this.Nz);
      return;
    }
    catch (RemoteException paramOnInvitationReceivedListener)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(RoomConfig paramRoomConfig)
  {
    try
    {
      cp localcp = new cp(this, paramRoomConfig.getRoomUpdateListener(), paramRoomConfig.getRoomStatusUpdateListener(), paramRoomConfig.getMessageReceivedListener());
      ((IGamesService)ft()).a(localcp, this.Ny, paramRoomConfig.getVariant(), paramRoomConfig.getInvitedPlayerIds(), paramRoomConfig.getAutoMatchCriteria(), paramRoomConfig.isSocketEnabled(), this.Nz);
      return;
    }
    catch (RemoteException paramRoomConfig)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(RoomUpdateListener paramRoomUpdateListener, String paramString)
  {
    try
    {
      ((IGamesService)ft()).c(new cp(this, paramRoomUpdateListener), paramString);
      hv();
      return;
    }
    catch (RemoteException paramRoomUpdateListener)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
  {
    try
    {
      paramOnTurnBasedMatchUpdateReceivedListener = new bh(this, paramOnTurnBasedMatchUpdateReceivedListener);
      ((IGamesService)ft()).b(paramOnTurnBasedMatchUpdateReceivedListener, this.Nz);
      return;
    }
    catch (RemoteException paramOnTurnBasedMatchUpdateReceivedListener)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(QuestUpdateListener paramQuestUpdateListener)
  {
    try
    {
      paramQuestUpdateListener = new cd(this, paramQuestUpdateListener);
      ((IGamesService)ft()).d(paramQuestUpdateListener, this.Nz);
      return;
    }
    catch (RemoteException paramQuestUpdateListener)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(OnRequestReceivedListener paramOnRequestReceivedListener)
  {
    try
    {
      paramOnRequestReceivedListener = new ch(this, paramOnRequestReceivedListener);
      ((IGamesService)ft()).c(paramOnRequestReceivedListener, this.Nz);
      return;
    }
    catch (RemoteException paramOnRequestReceivedListener)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void a(Snapshot paramSnapshot)
  {
    Contents localContents = paramSnapshot.getContents();
    hm.b(localContents, "Must provide a previously opened Snapshot");
    paramSnapshot.iM();
    try
    {
      ((IGamesService)ft()).a(localContents);
      return;
    }
    catch (RemoteException paramSnapshot)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  protected void a(hi paramhi, hb.e parame)
  {
    String str = getContext().getResources().getConfiguration().locale.toString();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.NA);
    localBundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.Nw);
    localBundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.Nx);
    localBundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.NC);
    localBundle.putInt("com.google.android.gms.games.key.sdkVariant", this.NB);
    localBundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.ND);
    paramhi.a(parame, 5089000, getContext().getPackageName(), this.yQ, fs(), this.Nq, this.Nu.hN(), str, localBundle);
  }
  
  public Intent aR(String paramString)
  {
    try
    {
      paramString = ((IGamesService)ft()).aR(paramString);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public void aS(String paramString)
  {
    try
    {
      ((IGamesService)ft()).ba(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public Intent aU(String paramString)
  {
    try
    {
      paramString = ((IGamesService)ft()).aU(paramString);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return null;
  }
  
  protected IGamesService ah(IBinder paramIBinder)
  {
    return IGamesService.Stub.aj(paramIBinder);
  }
  
  public Intent b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = ((IGamesService)ft()).b(paramInt1, paramInt2, paramBoolean);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public void b(a.d<Status> paramd)
  {
    try
    {
      this.Np.flush();
      ((IGamesService)ft()).a(new cu(this, paramd));
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void b(a.d<Players.LoadPlayersResult> paramd, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)ft()).b(new bz(this, paramd), paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void b(a.d<Achievements.UpdateAchievementResult> paramd, String paramString)
  {
    if (paramd == null) {}
    for (paramd = null;; paramd = new e(this, paramd)) {
      try
      {
        ((IGamesService)ft()).a(paramd, paramString, this.Nu.hN(), this.Nu.hM());
        return;
      }
      catch (RemoteException paramd)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void b(a.d<Achievements.UpdateAchievementResult> paramd, String paramString, int paramInt)
  {
    if (paramd == null) {}
    for (paramd = null;; paramd = new e(this, paramd)) {
      try
      {
        ((IGamesService)ft()).b(paramd, paramString, paramInt, this.Nu.hN(), this.Nu.hM());
        return;
      }
      catch (RemoteException paramd)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void b(a.d<Leaderboards.LoadScoresResult> paramd, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)ft()).b(new ai(this, paramd), paramString, paramInt1, paramInt2, paramInt3, paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void b(a.d<GamesMetadata.LoadExtendedGamesResult> paramd, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)ft()).a(new q(this, paramd), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void b(a.d<Quests.ClaimMilestoneResult> paramd, String paramString1, String paramString2)
  {
    try
    {
      this.Np.flush();
      ((IGamesService)ft()).f(new cc(this, paramd, paramString2), paramString1, paramString2);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void b(a.d<Leaderboards.LoadScoresResult> paramd, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)ft()).b(new ai(this, paramd), paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void b(a.d<Achievements.LoadAchievementsResult> paramd, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)ft()).a(new f(this, paramd), paramString1, paramString2, paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void b(a.d<Snapshots.OpenSnapshotResult> paramd, String paramString, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)ft()).e(new cx(this, paramd), paramString, paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void b(a.d<Leaderboards.LeaderboardMetadataResult> paramd, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)ft()).b(new aj(this, paramd), paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void b(a.d<Quests.LoadQuestsResult> paramd, boolean paramBoolean, String[] paramArrayOfString)
  {
    try
    {
      ((IGamesService)ft()).a(new ce(this, paramd), paramArrayOfString, paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void b(a.d<Requests.UpdateRequestsResult> paramd, String[] paramArrayOfString)
  {
    try
    {
      ((IGamesService)ft()).a(new cn(this, paramd), paramArrayOfString);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void b(RoomConfig paramRoomConfig)
  {
    try
    {
      cp localcp = new cp(this, paramRoomConfig.getRoomUpdateListener(), paramRoomConfig.getRoomStatusUpdateListener(), paramRoomConfig.getMessageReceivedListener());
      ((IGamesService)ft()).a(localcp, this.Ny, paramRoomConfig.getInvitationId(), paramRoomConfig.isSocketEnabled(), this.Nz);
      return;
    }
    catch (RemoteException paramRoomConfig)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  protected void b(String... paramVarArgs)
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
        hm.a(bool1, "Cannot have both %s and %s!", new Object[] { "https://www.googleapis.com/auth/games", "https://www.googleapis.com/auth/games.firstparty" });
        return;
      }
    }
    hm.a(bool1, "Games APIs requires %s to function.", new Object[] { "https://www.googleapis.com/auth/games" });
  }
  
  protected String bu()
  {
    return "com.google.android.gms.games.service.START";
  }
  
  protected String bv()
  {
    return "com.google.android.gms.games.internal.IGamesService";
  }
  
  public void c(a.d<Invitations.LoadInvitationsResult> paramd, int paramInt)
  {
    try
    {
      ((IGamesService)ft()).a(new af(this, paramd), paramInt);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void c(a.d<Players.LoadPlayersResult> paramd, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)ft()).c(new bz(this, paramd), paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void c(a.d<Achievements.UpdateAchievementResult> paramd, String paramString)
  {
    if (paramd == null) {}
    for (paramd = null;; paramd = new e(this, paramd)) {
      try
      {
        ((IGamesService)ft()).b(paramd, paramString, this.Nu.hN(), this.Nu.hM());
        return;
      }
      catch (RemoteException paramd)
      {
        GamesLog.j("GamesClientImpl", "service died");
      }
    }
  }
  
  public void c(a.d<Players.LoadXpStreamResult> paramd, String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)ft()).b(new by(this, paramd), paramString, paramInt);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void c(a.d<GamesMetadata.LoadExtendedGamesResult> paramd, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)ft()).e(new q(this, paramd), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void c(a.d<TurnBasedMultiplayer.InitiateMatchResult> paramd, String paramString1, String paramString2)
  {
    try
    {
      ((IGamesService)ft()).d(new dc(this, paramd), paramString1, paramString2);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void c(a.d<Snapshots.LoadSnapshotsResult> paramd, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)ft()).c(new cy(this, paramd), paramString1, paramString2, paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void c(a.d<Leaderboards.LeaderboardMetadataResult> paramd, String paramString, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)ft()).d(new aj(this, paramd), paramString, paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void c(a.d<Achievements.LoadAchievementsResult> paramd, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)ft()).a(new f(this, paramd), paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void c(a.d<Requests.UpdateRequestsResult> paramd, String[] paramArrayOfString)
  {
    try
    {
      ((IGamesService)ft()).b(new cn(this, paramd), paramArrayOfString);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void cg(int paramInt)
  {
    this.Nu.setGravity(paramInt);
  }
  
  public void ch(int paramInt)
  {
    try
    {
      ((IGamesService)ft()).ch(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void connect()
  {
    gY();
    super.connect();
  }
  
  public int d(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      int i = ((IGamesService)ft()).b(paramArrayOfByte, paramString, null);
      return i;
    }
    catch (RemoteException paramArrayOfByte)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public void d(a.d<Players.LoadPlayersResult> paramd, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)ft()).e(new bz(this, paramd), paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void d(a.d<TurnBasedMultiplayer.InitiateMatchResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)ft()).l(new dc(this, paramd), paramString);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void d(a.d<Players.LoadXpStreamResult> paramd, String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)ft()).c(new by(this, paramd), paramString, paramInt);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void d(a.d<GamesMetadata.LoadExtendedGamesResult> paramd, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)ft()).f(new q(this, paramd), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void d(a.d<TurnBasedMultiplayer.InitiateMatchResult> paramd, String paramString1, String paramString2)
  {
    try
    {
      ((IGamesService)ft()).e(new dc(this, paramd), paramString1, paramString2);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void d(a.d<Notifications.GameMuteStatusChangeResult> paramd, String paramString, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)ft()).a(new u(this, paramd), paramString, paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void d(a.d<Events.LoadEventsResult> paramd, boolean paramBoolean)
  {
    try
    {
      this.Np.flush();
      ((IGamesService)ft()).f(new p(this, paramd), paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void disconnect()
  {
    this.Nv = false;
    if (isConnected()) {}
    try
    {
      IGamesService localIGamesService = (IGamesService)ft();
      localIGamesService.hw();
      this.Np.flush();
      localIGamesService.q(this.Nz);
      hv();
      super.disconnect();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        GamesLog.j("GamesClientImpl", "Failed to notify client disconnect.");
      }
    }
  }
  
  public void e(a.d<Players.LoadPlayersResult> paramd, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)ft()).d(new bz(this, paramd), paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void e(a.d<TurnBasedMultiplayer.InitiateMatchResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)ft()).m(new dc(this, paramd), paramString);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void e(a.d<Invitations.LoadInvitationsResult> paramd, String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)ft()).b(new af(this, paramd), paramString, paramInt, false);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void e(a.d<GamesMetadata.LoadExtendedGamesResult> paramd, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)ft()).c(new q(this, paramd), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void e(a.d<Snapshots.LoadSnapshotsResult> paramd, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)ft()).d(new cy(this, paramd), paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public Bundle ef()
  {
    try
    {
      Bundle localBundle = ((IGamesService)ft()).ef();
      if (localBundle != null) {
        localBundle.setClassLoader(GamesClientImpl.class.getClassLoader());
      }
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public void f(View paramView)
  {
    this.Nu.g(paramView);
  }
  
  public void f(a.d<GamesMetadata.LoadGamesResult> paramd)
  {
    try
    {
      ((IGamesService)ft()).d(new y(this, paramd));
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void f(a.d<TurnBasedMultiplayer.LeaveMatchResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)ft()).o(new dd(this, paramd), paramString);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void f(a.d<Requests.LoadRequestSummariesResult> paramd, String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)ft()).a(new cl(this, paramd), paramString, paramInt);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void f(a.d<Players.LoadPlayersResult> paramd, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)ft()).b(new bz(this, paramd), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void f(a.d<Notifications.ContactSettingLoadResult> paramd, boolean paramBoolean)
  {
    try
    {
      ((IGamesService)ft()).e(new l(this, paramd), paramBoolean);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void g(a.d<Players.LoadOwnerCoverPhotoUrisResult> paramd)
  {
    try
    {
      ((IGamesService)ft()).j(new bn(this, paramd));
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void g(a.d<TurnBasedMultiplayer.CancelMatchResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)ft()).n(new db(this, paramd), paramString);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void g(a.d<Players.LoadPlayersResult> paramd, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((IGamesService)ft()).b(new bz(this, paramd), paramString, null, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public String gZ()
  {
    try
    {
      String str = ((IGamesService)ft()).gZ();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public void h(a.d<Acls.LoadAclResult> paramd)
  {
    try
    {
      ((IGamesService)ft()).h(new bk(this, paramd));
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void h(a.d<TurnBasedMultiplayer.LoadMatchResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)ft()).p(new de(this, paramd), paramString);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public String ha()
  {
    try
    {
      String str = ((IGamesService)ft()).ha();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return null;
  }
  
  /* Error */
  public com.google.android.gms.games.Player hb()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1049	com/google/android/gms/games/internal/GamesClientImpl:cn	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 224	com/google/android/gms/games/internal/GamesClientImpl:Ns	Lcom/google/android/gms/games/PlayerEntity;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +51 -> 63
    //   15: new 1051	com/google/android/gms/games/PlayerBuffer
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual 150	com/google/android/gms/games/internal/GamesClientImpl:ft	()Landroid/os/IInterface;
    //   23: checkcast 152	com/google/android/gms/games/internal/IGamesService
    //   26: invokeinterface 1055 1 0
    //   31: invokespecial 1056	com/google/android/gms/games/PlayerBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 1057	com/google/android/gms/games/PlayerBuffer:getCount	()I
    //   39: ifle +20 -> 59
    //   42: aload_0
    //   43: aload_1
    //   44: iconst_0
    //   45: invokevirtual 1060	com/google/android/gms/games/PlayerBuffer:get	(I)Lcom/google/android/gms/games/Player;
    //   48: invokeinterface 1063 1 0
    //   53: checkcast 1065	com/google/android/gms/games/PlayerEntity
    //   56: putfield 224	com/google/android/gms/games/internal/GamesClientImpl:Ns	Lcom/google/android/gms/games/PlayerEntity;
    //   59: aload_1
    //   60: invokevirtual 1066	com/google/android/gms/games/PlayerBuffer:close	()V
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_0
    //   66: getfield 224	com/google/android/gms/games/internal/GamesClientImpl:Ns	Lcom/google/android/gms/games/PlayerEntity;
    //   69: areturn
    //   70: astore_2
    //   71: aload_1
    //   72: invokevirtual 1066	com/google/android/gms/games/PlayerBuffer:close	()V
    //   75: aload_2
    //   76: athrow
    //   77: astore_1
    //   78: ldc -98
    //   80: ldc_w 267
    //   83: invokestatic 270	com/google/android/gms/games/internal/GamesLog:j	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: goto -23 -> 63
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	GamesClientImpl
    //   10	62	1	localObject1	Object
    //   77	1	1	localRemoteException	RemoteException
    //   89	4	1	localObject2	Object
    //   70	6	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   35	59	70	finally
    //   15	35	77	android/os/RemoteException
    //   59	63	77	android/os/RemoteException
    //   71	77	77	android/os/RemoteException
    //   6	11	89	finally
    //   15	35	89	finally
    //   59	63	89	finally
    //   63	65	89	finally
    //   71	77	89	finally
    //   78	86	89	finally
    //   90	92	89	finally
  }
  
  /* Error */
  public com.google.android.gms.games.Game hc()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1049	com/google/android/gms/games/internal/GamesClientImpl:cn	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 1070	com/google/android/gms/games/internal/GamesClientImpl:Nt	Lcom/google/android/gms/games/GameEntity;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +51 -> 63
    //   15: new 1072	com/google/android/gms/games/GameBuffer
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual 150	com/google/android/gms/games/internal/GamesClientImpl:ft	()Landroid/os/IInterface;
    //   23: checkcast 152	com/google/android/gms/games/internal/IGamesService
    //   26: invokeinterface 1075 1 0
    //   31: invokespecial 1076	com/google/android/gms/games/GameBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 1077	com/google/android/gms/games/GameBuffer:getCount	()I
    //   39: ifle +20 -> 59
    //   42: aload_0
    //   43: aload_1
    //   44: iconst_0
    //   45: invokevirtual 1080	com/google/android/gms/games/GameBuffer:get	(I)Lcom/google/android/gms/games/Game;
    //   48: invokeinterface 1083 1 0
    //   53: checkcast 1085	com/google/android/gms/games/GameEntity
    //   56: putfield 1070	com/google/android/gms/games/internal/GamesClientImpl:Nt	Lcom/google/android/gms/games/GameEntity;
    //   59: aload_1
    //   60: invokevirtual 1086	com/google/android/gms/games/GameBuffer:close	()V
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_0
    //   66: getfield 1070	com/google/android/gms/games/internal/GamesClientImpl:Nt	Lcom/google/android/gms/games/GameEntity;
    //   69: areturn
    //   70: astore_2
    //   71: aload_1
    //   72: invokevirtual 1086	com/google/android/gms/games/GameBuffer:close	()V
    //   75: aload_2
    //   76: athrow
    //   77: astore_1
    //   78: ldc -98
    //   80: ldc_w 267
    //   83: invokestatic 270	com/google/android/gms/games/internal/GamesLog:j	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: goto -23 -> 63
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	GamesClientImpl
    //   10	62	1	localObject1	Object
    //   77	1	1	localRemoteException	RemoteException
    //   89	4	1	localObject2	Object
    //   70	6	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   35	59	70	finally
    //   15	35	77	android/os/RemoteException
    //   59	63	77	android/os/RemoteException
    //   71	77	77	android/os/RemoteException
    //   6	11	89	finally
    //   15	35	89	finally
    //   59	63	89	finally
    //   63	65	89	finally
    //   71	77	89	finally
    //   78	86	89	finally
    //   90	92	89	finally
  }
  
  public Intent hd()
  {
    try
    {
      Intent localIntent = ((IGamesService)ft()).hd();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent he()
  {
    try
    {
      Intent localIntent = ((IGamesService)ft()).he();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent hf()
  {
    try
    {
      Intent localIntent = ((IGamesService)ft()).hf();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent hg()
  {
    try
    {
      Intent localIntent = ((IGamesService)ft()).hg();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public void hh()
  {
    try
    {
      ((IGamesService)ft()).r(this.Nz);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void hi()
  {
    try
    {
      ((IGamesService)ft()).s(this.Nz);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void hj()
  {
    try
    {
      ((IGamesService)ft()).u(this.Nz);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void hk()
  {
    try
    {
      ((IGamesService)ft()).t(this.Nz);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public Intent hl()
  {
    try
    {
      Intent localIntent = ((IGamesService)ft()).hl();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent hm()
  {
    try
    {
      Intent localIntent = ((IGamesService)ft()).hm();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public int hn()
  {
    try
    {
      int i = ((IGamesService)ft()).hn();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return 4368;
  }
  
  public String ho()
  {
    try
    {
      String str = ((IGamesService)ft()).ho();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public int hp()
  {
    try
    {
      int i = ((IGamesService)ft()).hp();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public Intent hq()
  {
    try
    {
      Intent localIntent = ((IGamesService)ft()).hq();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public int hr()
  {
    try
    {
      int i = ((IGamesService)ft()).hr();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public int hs()
  {
    try
    {
      int i = ((IGamesService)ft()).hs();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public int ht()
  {
    try
    {
      int i = ((IGamesService)ft()).ht();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public int hu()
  {
    try
    {
      int i = ((IGamesService)ft()).hu();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public void hw()
  {
    if (isConnected()) {}
    try
    {
      ((IGamesService)ft()).hw();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  @Deprecated
  public void i(a.d<Notifications.ContactSettingLoadResult> paramd)
  {
    try
    {
      ((IGamesService)ft()).e(new l(this, paramd), false);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void i(a.d<Quests.AcceptQuestResult> paramd, String paramString)
  {
    try
    {
      this.Np.flush();
      ((IGamesService)ft()).u(new ca(this, paramd), paramString);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void j(a.d<Notifications.InboxCountResult> paramd)
  {
    try
    {
      ((IGamesService)ft()).t(new aa(this, paramd), null);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void j(a.d<Snapshots.DeleteSnapshotResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)ft()).r(new cw(this, paramd), paramString);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void k(a.d<GamesMetadata.LoadExtendedGamesResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)ft()).e(new q(this, paramd), paramString);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public RealTimeSocket l(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (!ParticipantUtils.bn(paramString2))) {
      throw new IllegalArgumentException("Bad participant ID");
    }
    RealTimeSocket localRealTimeSocket = (RealTimeSocket)this.Nr.get(paramString2);
    if (localRealTimeSocket != null)
    {
      paramString1 = localRealTimeSocket;
      if (!localRealTimeSocket.isClosed()) {}
    }
    else
    {
      paramString1 = aT(paramString2);
    }
    return paramString1;
  }
  
  public void l(a.d<GamesMetadata.LoadGameInstancesResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)ft()).f(new s(this, paramd), paramString);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void l(String paramString, int paramInt)
  {
    this.Np.l(paramString, paramInt);
  }
  
  public void m(a.d<GamesMetadata.LoadGameSearchSuggestionsResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)ft()).q(new x(this, paramd), paramString);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void m(String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)ft()).m(paramString, paramInt);
      return;
    }
    catch (RemoteException paramString)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void n(a.d<Players.LoadXpForGameCategoriesResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)ft()).s(new bx(this, paramd), paramString);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void n(String paramString, int paramInt)
  {
    try
    {
      ((IGamesService)ft()).n(paramString, paramInt);
      return;
    }
    catch (RemoteException paramString)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void o(a.d<Invitations.LoadInvitationsResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)ft()).k(new af(this, paramd), paramString);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void onConnected(Bundle paramBundle)
  {
    if (this.Nv)
    {
      this.Nu.hL();
      this.Nv = false;
    }
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.Nv = false;
  }
  
  public void onConnectionSuspended(int paramInt) {}
  
  public void p(a.d<Status> paramd, String paramString)
  {
    try
    {
      ((IGamesService)ft()).j(new bl(this, paramd), paramString);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
  
  public void q(a.d<Notifications.GameMuteStatusLoadResult> paramd, String paramString)
  {
    try
    {
      ((IGamesService)ft()).i(new w(this, paramd), paramString);
      return;
    }
    catch (RemoteException paramd)
    {
      GamesLog.j("GamesClientImpl", "service died");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/GamesClientImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */