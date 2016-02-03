package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.leaderboard.c;
import com.google.android.gms.games.leaderboard.d;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public final class fl
  extends dw<fp>
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private final String jG;
  private boolean tA = false;
  private int tB;
  private final String tO;
  private final Map<String, RealTimeSocket> tP;
  private PlayerEntity tQ;
  private GameEntity tR;
  private final fq tS;
  private boolean tT = false;
  private final Binder tU;
  private final long tV;
  private final boolean tW;
  private final int tX;
  
  @Deprecated
  public fl(Context paramContext, String paramString1, String paramString2, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener, String[] paramArrayOfString, int paramInt1, View paramView, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    this(paramContext, paramString1, paramString2, new dw.c(paramConnectionCallbacks), new dw.g(paramOnConnectionFailedListener), paramArrayOfString, paramInt1, paramView, paramBoolean1, paramBoolean2, paramInt2, 4368);
  }
  
  public fl(Context paramContext, String paramString1, String paramString2, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String[] paramArrayOfString, int paramInt1, View paramView, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    super(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString);
    this.tO = paramString1;
    this.jG = ((String)eg.f(paramString2));
    this.tU = new Binder();
    this.tP = new HashMap();
    this.tS = fq.a(this, paramInt1);
    setViewForPopups(paramView);
    this.tA = paramBoolean2;
    this.tB = paramInt2;
    this.tV = hashCode();
    this.tW = paramBoolean1;
    this.tX = paramInt3;
    registerConnectionCallbacks(this);
    registerConnectionFailedListener(this);
  }
  
  private Room E(DataHolder paramDataHolder)
  {
    com.google.android.gms.games.multiplayer.realtime.a locala = new com.google.android.gms.games.multiplayer.realtime.a(paramDataHolder);
    paramDataHolder = null;
    try
    {
      if (locala.getCount() > 0) {
        paramDataHolder = (Room)((Room)locala.get(0)).freeze();
      }
      return paramDataHolder;
    }
    finally
    {
      locala.close();
    }
  }
  
  /* Error */
  private RealTimeSocket ae(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 337	com/google/android/gms/internal/fl:bQ	()Landroid/os/IInterface;
    //   4: checkcast 339	com/google/android/gms/internal/fp
    //   7: aload_1
    //   8: invokeinterface 342 2 0
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: new 344	android/net/LocalSocket
    //   23: dup
    //   24: invokespecial 345	android/net/LocalSocket:<init>	()V
    //   27: astore_3
    //   28: aload_3
    //   29: new 347	android/net/LocalSocketAddress
    //   32: dup
    //   33: aload_2
    //   34: invokespecial 350	android/net/LocalSocketAddress:<init>	(Ljava/lang/String;)V
    //   37: invokevirtual 354	android/net/LocalSocket:connect	(Landroid/net/LocalSocketAddress;)V
    //   40: new 356	com/google/android/gms/internal/fr
    //   43: dup
    //   44: aload_3
    //   45: aload_1
    //   46: invokespecial 359	com/google/android/gms/internal/fr:<init>	(Landroid/net/LocalSocket;Ljava/lang/String;)V
    //   49: astore_2
    //   50: aload_0
    //   51: getfield 269	com/google/android/gms/internal/fl:tP	Ljava/util/Map;
    //   54: aload_1
    //   55: aload_2
    //   56: invokeinterface 365 3 0
    //   61: pop
    //   62: aload_2
    //   63: areturn
    //   64: astore_1
    //   65: ldc_w 367
    //   68: ldc_w 369
    //   71: invokestatic 374	com/google/android/gms/internal/fn:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aconst_null
    //   75: areturn
    //   76: astore_1
    //   77: ldc_w 367
    //   80: new 376	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 377	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 379
    //   90: invokevirtual 383	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 387	java/io/IOException:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 383	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 390	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 374	com/google/android/gms/internal/fn:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aconst_null
    //   107: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	fl
    //   0	108	1	paramString	String
    //   13	50	2	localObject	Object
    //   27	18	3	localLocalSocket	android.net.LocalSocket
    // Exception table:
    //   from	to	target	type
    //   0	14	64	android/os/RemoteException
    //   20	28	64	android/os/RemoteException
    //   28	40	64	android/os/RemoteException
    //   40	62	64	android/os/RemoteException
    //   77	106	64	android/os/RemoteException
    //   28	40	76	java/io/IOException
  }
  
  private void dc()
  {
    this.tQ = null;
  }
  
  private void de()
  {
    Iterator localIterator = this.tP.values().iterator();
    while (localIterator.hasNext())
    {
      RealTimeSocket localRealTimeSocket = (RealTimeSocket)localIterator.next();
      try
      {
        localRealTimeSocket.close();
      }
      catch (IOException localIOException)
      {
        fn.a("GamesClientImpl", "IOException:", localIOException);
      }
    }
    this.tP.clear();
  }
  
  protected fp F(IBinder paramIBinder)
  {
    return fp.a.H(paramIBinder);
  }
  
  public int a(RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    try
    {
      int i = ((fp)bQ()).a(new an(paramReliableMessageSentCallback), paramArrayOfByte, paramString1, paramString2);
      return i;
    }
    catch (RemoteException paramReliableMessageSentCallback)
    {
      fn.c("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public int a(byte[] paramArrayOfByte, String paramString, String[] paramArrayOfString)
  {
    eg.b(paramArrayOfString, "Participant IDs must not be null");
    try
    {
      int i = ((fp)bQ()).b(paramArrayOfByte, paramString, paramArrayOfString);
      return i;
    }
    catch (RemoteException paramArrayOfByte)
    {
      fn.c("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBundle != null)) {
      this.tT = paramBundle.getBoolean("show_welcome_popup");
    }
    super.a(paramInt, paramIBinder, paramBundle);
  }
  
  public void a(IBinder paramIBinder, Bundle paramBundle)
  {
    if (isConnected()) {}
    try
    {
      ((fp)bQ()).a(paramIBinder, paramBundle);
      return;
    }
    catch (RemoteException paramIBinder)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.c<Players.LoadPlayersResult> paramc, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ((fp)bQ()).a(new ak(paramc), paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.c<Leaderboards.LoadScoresResult> paramc, LeaderboardScoreBuffer paramLeaderboardScoreBuffer, int paramInt1, int paramInt2)
  {
    try
    {
      ((fp)bQ()).a(new r(paramc), paramLeaderboardScoreBuffer.dq().dr(), paramInt1, paramInt2);
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.c<TurnBasedMultiplayer.InitiateMatchResult> paramc, TurnBasedMatchConfig paramTurnBasedMatchConfig)
  {
    try
    {
      ((fp)bQ()).a(new bb(paramc), paramTurnBasedMatchConfig.getVariant(), paramTurnBasedMatchConfig.getMinPlayers(), paramTurnBasedMatchConfig.getInvitedPlayerIds(), paramTurnBasedMatchConfig.getAutoMatchCriteria());
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.c<Players.LoadPlayersResult> paramc, String paramString)
  {
    try
    {
      ((fp)bQ()).c(new ak(paramc), paramString);
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.c<Achievements.UpdateAchievementResult> paramc, String paramString, int paramInt)
  {
    if (paramc == null) {}
    for (paramc = null;; paramc = new d(paramc)) {
      try
      {
        ((fp)bQ()).a(paramc, paramString, paramInt, this.tS.dn(), this.tS.dm());
        return;
      }
      catch (RemoteException paramc)
      {
        fn.c("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.c<Leaderboards.LoadScoresResult> paramc, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      ((fp)bQ()).a(new r(paramc), paramString, paramInt1, paramInt2, paramInt3, paramBoolean);
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.c<Players.LoadPlayersResult> paramc, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramString.equals("playedWith")) {
      throw new IllegalArgumentException("Invalid player collection: " + paramString);
    }
    try
    {
      ((fp)bQ()).d(new ak(paramc), paramString, paramInt, paramBoolean1, paramBoolean2);
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.c<Leaderboards.SubmitScoreResult> paramc, String paramString1, long paramLong, String paramString2)
  {
    if (paramc == null) {}
    for (paramc = null;; paramc = new aw(paramc)) {
      try
      {
        ((fp)bQ()).a(paramc, paramString1, paramLong, paramString2);
        return;
      }
      catch (RemoteException paramc)
      {
        fn.c("GamesClientImpl", "service died");
      }
    }
  }
  
  public void a(a.c<TurnBasedMultiplayer.LeaveMatchResult> paramc, String paramString1, String paramString2)
  {
    try
    {
      ((fp)bQ()).d(new bd(paramc), paramString1, paramString2);
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.c<Leaderboards.LoadPlayerScoreResult> paramc, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    try
    {
      ((fp)bQ()).a(new ai(paramc), paramString1, paramString2, paramInt1, paramInt2);
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.c<Leaderboards.LeaderboardMetadataResult> paramc, String paramString, boolean paramBoolean)
  {
    try
    {
      ((fp)bQ()).c(new t(paramc), paramString, paramBoolean);
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.c<TurnBasedMultiplayer.UpdateMatchResult> paramc, String paramString1, byte[] paramArrayOfByte, String paramString2, ParticipantResult[] paramArrayOfParticipantResult)
  {
    try
    {
      ((fp)bQ()).a(new bh(paramc), paramString1, paramArrayOfByte, paramString2, paramArrayOfParticipantResult);
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.c<TurnBasedMultiplayer.UpdateMatchResult> paramc, String paramString, byte[] paramArrayOfByte, ParticipantResult[] paramArrayOfParticipantResult)
  {
    try
    {
      ((fp)bQ()).a(new bh(paramc), paramString, paramArrayOfByte, paramArrayOfParticipantResult);
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.c<Leaderboards.LeaderboardMetadataResult> paramc, boolean paramBoolean)
  {
    try
    {
      ((fp)bQ()).b(new t(paramc), paramBoolean);
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void a(a.c<TurnBasedMultiplayer.LoadMatchesResult> paramc, int[] paramArrayOfInt)
  {
    try
    {
      ((fp)bQ()).a(new bj(paramc), paramArrayOfInt);
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  protected void a(ec paramec, dw.e parame)
    throws RemoteException
  {
    String str = getContext().getResources().getConfiguration().locale.toString();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.tW);
    localBundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.tA);
    localBundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.tB);
    localBundle.putInt("com.google.android.gms.games.key.sdkVariant", this.tX);
    paramec.a(parame, 4242000, getContext().getPackageName(), this.jG, bO(), this.tO, this.tS.dn(), str, localBundle);
  }
  
  protected void a(String... paramVarArgs)
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
        eg.a(bool1, String.format("Cannot have both %s and %s!", new Object[] { "https://www.googleapis.com/auth/games", "https://www.googleapis.com/auth/games.firstparty" }));
        return;
      }
    }
    eg.a(bool1, String.format("Games APIs requires %s to function.", new Object[] { "https://www.googleapis.com/auth/games" }));
  }
  
  public Bundle aU()
  {
    try
    {
      Bundle localBundle = ((fp)bQ()).aU();
      if (localBundle != null) {
        localBundle.setClassLoader(fl.class.getClassLoader());
      }
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      fn.c("GamesClientImpl", "service died");
    }
    return null;
  }
  
  protected String am()
  {
    return "com.google.android.gms.games.service.START";
  }
  
  protected String an()
  {
    return "com.google.android.gms.games.internal.IGamesService";
  }
  
  public void b(a.c<Status> paramc)
  {
    try
    {
      ((fp)bQ()).a(new au(paramc));
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void b(a.c<Achievements.UpdateAchievementResult> paramc, String paramString)
  {
    if (paramc == null) {}
    for (paramc = null;; paramc = new d(paramc)) {
      try
      {
        ((fp)bQ()).a(paramc, paramString, this.tS.dn(), this.tS.dm());
        return;
      }
      catch (RemoteException paramc)
      {
        fn.c("GamesClientImpl", "service died");
      }
    }
  }
  
  public void b(a.c<Achievements.UpdateAchievementResult> paramc, String paramString, int paramInt)
  {
    if (paramc == null) {}
    for (paramc = null;; paramc = new d(paramc)) {
      try
      {
        ((fp)bQ()).b(paramc, paramString, paramInt, this.tS.dn(), this.tS.dm());
        return;
      }
      catch (RemoteException paramc)
      {
        fn.c("GamesClientImpl", "service died");
      }
    }
  }
  
  public void b(a.c<Leaderboards.LoadScoresResult> paramc, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    try
    {
      ((fp)bQ()).b(new r(paramc), paramString, paramInt1, paramInt2, paramInt3, paramBoolean);
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void b(a.c<Achievements.LoadAchievementsResult> paramc, boolean paramBoolean)
  {
    try
    {
      ((fp)bQ()).a(new f(paramc), paramBoolean);
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void c(a.c<Achievements.UpdateAchievementResult> paramc, String paramString)
  {
    if (paramc == null) {}
    for (paramc = null;; paramc = new d(paramc)) {
      try
      {
        ((fp)bQ()).b(paramc, paramString, this.tS.dn(), this.tS.dm());
        return;
      }
      catch (RemoteException paramc)
      {
        fn.c("GamesClientImpl", "service died");
      }
    }
  }
  
  public void clearNotifications(int paramInt)
  {
    try
    {
      ((fp)bQ()).clearNotifications(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void connect()
  {
    dc();
    super.connect();
  }
  
  public void createRoom(RoomConfig paramRoomConfig)
  {
    try
    {
      aq localaq = new aq(paramRoomConfig.getRoomUpdateListener(), paramRoomConfig.getRoomStatusUpdateListener(), paramRoomConfig.getMessageReceivedListener());
      ((fp)bQ()).a(localaq, this.tU, paramRoomConfig.getVariant(), paramRoomConfig.getInvitedPlayerIds(), paramRoomConfig.getAutoMatchCriteria(), paramRoomConfig.isSocketEnabled(), this.tV);
      return;
    }
    catch (RemoteException paramRoomConfig)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void d(a.c<TurnBasedMultiplayer.InitiateMatchResult> paramc, String paramString)
  {
    try
    {
      ((fp)bQ()).n(new bb(paramc), paramString);
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public int dd()
  {
    try
    {
      int i = ((fp)bQ()).dd();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      fn.c("GamesClientImpl", "service died");
    }
    return 4368;
  }
  
  public void df()
  {
    if (isConnected()) {}
    try
    {
      ((fp)bQ()).df();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void disconnect()
  {
    this.tT = false;
    if (isConnected()) {}
    try
    {
      fp localfp = (fp)bQ();
      localfp.df();
      localfp.j(this.tV);
      de();
      super.disconnect();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        fn.c("GamesClientImpl", "Failed to notify client disconnect.");
      }
    }
  }
  
  public void dismissTurnBasedMatch(String paramString)
  {
    try
    {
      ((fp)bQ()).ak(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void e(a.c<TurnBasedMultiplayer.InitiateMatchResult> paramc, String paramString)
  {
    try
    {
      ((fp)bQ()).o(new bb(paramc), paramString);
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void f(a.c<TurnBasedMultiplayer.LeaveMatchResult> paramc, String paramString)
  {
    try
    {
      ((fp)bQ()).q(new bd(paramc), paramString);
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void g(a.c<GamesMetadata.LoadGamesResult> paramc)
  {
    try
    {
      ((fp)bQ()).d(new j(paramc));
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void g(a.c<TurnBasedMultiplayer.CancelMatchResult> paramc, String paramString)
  {
    try
    {
      ((fp)bQ()).p(new az(paramc), paramString);
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public Intent getAchievementsIntent()
  {
    try
    {
      Intent localIntent = ((fp)bQ()).getAchievementsIntent();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      fn.c("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent getAllLeaderboardsIntent()
  {
    try
    {
      Intent localIntent = ((fp)bQ()).getAllLeaderboardsIntent();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      fn.c("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public String getAppId()
  {
    try
    {
      String str = ((fp)bQ()).getAppId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      fn.c("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public String getCurrentAccountName()
  {
    try
    {
      String str = ((fp)bQ()).getCurrentAccountName();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      fn.c("GamesClientImpl", "service died");
    }
    return null;
  }
  
  /* Error */
  public com.google.android.gms.games.Game getCurrentGame()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 797	com/google/android/gms/internal/fl:bP	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 799	com/google/android/gms/internal/fl:tR	Lcom/google/android/gms/games/GameEntity;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +51 -> 63
    //   15: new 801	com/google/android/gms/games/GameBuffer
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual 337	com/google/android/gms/internal/fl:bQ	()Landroid/os/IInterface;
    //   23: checkcast 339	com/google/android/gms/internal/fp
    //   26: invokeinterface 805 1 0
    //   31: invokespecial 806	com/google/android/gms/games/GameBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 807	com/google/android/gms/games/GameBuffer:getCount	()I
    //   39: ifle +20 -> 59
    //   42: aload_0
    //   43: aload_1
    //   44: iconst_0
    //   45: invokevirtual 810	com/google/android/gms/games/GameBuffer:get	(I)Lcom/google/android/gms/games/Game;
    //   48: invokeinterface 813 1 0
    //   53: checkcast 815	com/google/android/gms/games/GameEntity
    //   56: putfield 799	com/google/android/gms/internal/fl:tR	Lcom/google/android/gms/games/GameEntity;
    //   59: aload_1
    //   60: invokevirtual 816	com/google/android/gms/games/GameBuffer:close	()V
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_0
    //   66: getfield 799	com/google/android/gms/internal/fl:tR	Lcom/google/android/gms/games/GameEntity;
    //   69: areturn
    //   70: astore_2
    //   71: aload_1
    //   72: invokevirtual 816	com/google/android/gms/games/GameBuffer:close	()V
    //   75: aload_2
    //   76: athrow
    //   77: astore_1
    //   78: ldc_w 367
    //   81: ldc_w 440
    //   84: invokestatic 442	com/google/android/gms/internal/fn:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: goto -24 -> 63
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	fl
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
  
  /* Error */
  public com.google.android.gms.games.Player getCurrentPlayer()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 797	com/google/android/gms/internal/fl:bP	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 393	com/google/android/gms/internal/fl:tQ	Lcom/google/android/gms/games/PlayerEntity;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +51 -> 63
    //   15: new 820	com/google/android/gms/games/PlayerBuffer
    //   18: dup
    //   19: aload_0
    //   20: invokevirtual 337	com/google/android/gms/internal/fl:bQ	()Landroid/os/IInterface;
    //   23: checkcast 339	com/google/android/gms/internal/fp
    //   26: invokeinterface 823 1 0
    //   31: invokespecial 824	com/google/android/gms/games/PlayerBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 825	com/google/android/gms/games/PlayerBuffer:getCount	()I
    //   39: ifle +20 -> 59
    //   42: aload_0
    //   43: aload_1
    //   44: iconst_0
    //   45: invokevirtual 828	com/google/android/gms/games/PlayerBuffer:get	(I)Lcom/google/android/gms/games/Player;
    //   48: invokeinterface 831 1 0
    //   53: checkcast 833	com/google/android/gms/games/PlayerEntity
    //   56: putfield 393	com/google/android/gms/internal/fl:tQ	Lcom/google/android/gms/games/PlayerEntity;
    //   59: aload_1
    //   60: invokevirtual 834	com/google/android/gms/games/PlayerBuffer:close	()V
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_0
    //   66: getfield 393	com/google/android/gms/internal/fl:tQ	Lcom/google/android/gms/games/PlayerEntity;
    //   69: areturn
    //   70: astore_2
    //   71: aload_1
    //   72: invokevirtual 834	com/google/android/gms/games/PlayerBuffer:close	()V
    //   75: aload_2
    //   76: athrow
    //   77: astore_1
    //   78: ldc_w 367
    //   81: ldc_w 440
    //   84: invokestatic 442	com/google/android/gms/internal/fn:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: goto -24 -> 63
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	fl
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
  
  public String getCurrentPlayerId()
  {
    try
    {
      String str = ((fp)bQ()).getCurrentPlayerId();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      fn.c("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent getInvitationInboxIntent()
  {
    try
    {
      Intent localIntent = ((fp)bQ()).getInvitationInboxIntent();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      fn.c("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent getLeaderboardIntent(String paramString)
  {
    try
    {
      paramString = ((fp)bQ()).getLeaderboardIntent(paramString);
      return paramString;
    }
    catch (RemoteException paramString)
    {
      fn.c("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent getMatchInboxIntent()
  {
    try
    {
      Intent localIntent = ((fp)bQ()).getMatchInboxIntent();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      fn.c("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public int getMaxTurnBasedMatchDataSize()
  {
    try
    {
      int i = ((fp)bQ()).getMaxTurnBasedMatchDataSize();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      fn.c("GamesClientImpl", "service died");
    }
    return 2;
  }
  
  public Intent getPlayerSearchIntent()
  {
    try
    {
      Intent localIntent = ((fp)bQ()).getPlayerSearchIntent();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      fn.c("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent getRealTimeSelectOpponentsIntent(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = ((fp)bQ()).getRealTimeSelectOpponentsIntent(paramInt1, paramInt2, paramBoolean);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      fn.c("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public RealTimeSocket getRealTimeSocketForParticipant(String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (!ParticipantUtils.am(paramString2))) {
      throw new IllegalArgumentException("Bad participant ID");
    }
    RealTimeSocket localRealTimeSocket = (RealTimeSocket)this.tP.get(paramString2);
    if (localRealTimeSocket != null)
    {
      paramString1 = localRealTimeSocket;
      if (!localRealTimeSocket.isClosed()) {}
    }
    else
    {
      paramString1 = ae(paramString2);
    }
    return paramString1;
  }
  
  public Intent getRealTimeWaitingRoomIntent(Room paramRoom, int paramInt)
  {
    try
    {
      paramRoom = ((fp)bQ()).a((RoomEntity)paramRoom.freeze(), paramInt);
      return paramRoom;
    }
    catch (RemoteException paramRoom)
    {
      fn.c("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent getSettingsIntent()
  {
    try
    {
      Intent localIntent = ((fp)bQ()).getSettingsIntent();
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      fn.c("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public Intent getTurnBasedSelectOpponentsIntent(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      Intent localIntent = ((fp)bQ()).getTurnBasedSelectOpponentsIntent(paramInt1, paramInt2, paramBoolean);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      fn.c("GamesClientImpl", "service died");
    }
    return null;
  }
  
  public void h(a.c<Invitations.LoadInvitationsResult> paramc)
  {
    try
    {
      ((fp)bQ()).e(new o(paramc));
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void h(a.c<TurnBasedMultiplayer.LoadMatchResult> paramc, String paramString)
  {
    try
    {
      ((fp)bQ()).r(new bf(paramc), paramString);
      return;
    }
    catch (RemoteException paramc)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void i(String paramString, int paramInt)
  {
    try
    {
      ((fp)bQ()).i(paramString, paramInt);
      return;
    }
    catch (RemoteException paramString)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void j(String paramString, int paramInt)
  {
    try
    {
      ((fp)bQ()).j(paramString, paramInt);
      return;
    }
    catch (RemoteException paramString)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void joinRoom(RoomConfig paramRoomConfig)
  {
    try
    {
      aq localaq = new aq(paramRoomConfig.getRoomUpdateListener(), paramRoomConfig.getRoomStatusUpdateListener(), paramRoomConfig.getMessageReceivedListener());
      ((fp)bQ()).a(localaq, this.tU, paramRoomConfig.getInvitationId(), paramRoomConfig.isSocketEnabled(), this.tV);
      return;
    }
    catch (RemoteException paramRoomConfig)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void leaveRoom(RoomUpdateListener paramRoomUpdateListener, String paramString)
  {
    try
    {
      ((fp)bQ()).e(new aq(paramRoomUpdateListener), paramString);
      de();
      return;
    }
    catch (RemoteException paramRoomUpdateListener)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void onConnected(Bundle paramBundle)
  {
    if (this.tT)
    {
      this.tS.dl();
      this.tT = false;
    }
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    this.tT = false;
  }
  
  public void onConnectionSuspended(int paramInt) {}
  
  public void registerInvitationListener(OnInvitationReceivedListener paramOnInvitationReceivedListener)
  {
    try
    {
      paramOnInvitationReceivedListener = new l(paramOnInvitationReceivedListener);
      ((fp)bQ()).a(paramOnInvitationReceivedListener, this.tV);
      return;
    }
    catch (RemoteException paramOnInvitationReceivedListener)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void registerMatchUpdateListener(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
  {
    try
    {
      paramOnTurnBasedMatchUpdateReceivedListener = new x(paramOnTurnBasedMatchUpdateReceivedListener);
      ((fp)bQ()).b(paramOnTurnBasedMatchUpdateReceivedListener, this.tV);
      return;
    }
    catch (RemoteException paramOnTurnBasedMatchUpdateReceivedListener)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public int sendUnreliableRealTimeMessageToAll(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      int i = ((fp)bQ()).b(paramArrayOfByte, paramString, null);
      return i;
    }
    catch (RemoteException paramArrayOfByte)
    {
      fn.c("GamesClientImpl", "service died");
    }
    return -1;
  }
  
  public void setGravityForPopups(int paramInt)
  {
    this.tS.setGravity(paramInt);
  }
  
  public void setViewForPopups(View paramView)
  {
    this.tS.e(paramView);
  }
  
  public void unregisterInvitationListener()
  {
    try
    {
      ((fp)bQ()).k(this.tV);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  public void unregisterMatchUpdateListener()
  {
    try
    {
      ((fp)bQ()).l(this.tV);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      fn.c("GamesClientImpl", "service died");
    }
  }
  
  abstract class a
    extends fl.c
  {
    private final ArrayList<String> tY = new ArrayList();
    
    a(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder);
      int i = 0;
      int j = paramArrayOfString.length;
      while (i < j)
      {
        this.tY.add(paramArrayOfString[i]);
        i += 1;
      }
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      a(paramRoomStatusUpdateListener, paramRoom, this.tY);
    }
    
    protected abstract void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList);
  }
  
  final class aa
    extends dw<fp>.b<RoomStatusUpdateListener>
  {
    private final String up;
    
    aa(RoomStatusUpdateListener paramRoomStatusUpdateListener, String paramString)
    {
      super(paramRoomStatusUpdateListener);
      this.up = paramString;
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener)
    {
      if (paramRoomStatusUpdateListener != null) {
        paramRoomStatusUpdateListener.onP2PConnected(this.up);
      }
    }
    
    protected void aL() {}
  }
  
  final class ab
    extends dw<fp>.b<RoomStatusUpdateListener>
  {
    private final String up;
    
    ab(RoomStatusUpdateListener paramRoomStatusUpdateListener, String paramString)
    {
      super(paramRoomStatusUpdateListener);
      this.up = paramString;
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener)
    {
      if (paramRoomStatusUpdateListener != null) {
        paramRoomStatusUpdateListener.onP2PDisconnected(this.up);
      }
    }
    
    protected void aL() {}
  }
  
  final class ac
    extends fl.a
  {
    ac(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeersConnected(paramRoom, paramArrayList);
    }
  }
  
  final class ad
    extends fl.a
  {
    ad(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerDeclined(paramRoom, paramArrayList);
    }
  }
  
  final class ae
    extends fl.a
  {
    ae(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeersDisconnected(paramRoom, paramArrayList);
    }
  }
  
  final class af
    extends fl.a
  {
    af(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerInvitedToRoom(paramRoom, paramArrayList);
    }
  }
  
  final class ag
    extends fl.a
  {
    ag(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerJoined(paramRoom, paramArrayList);
    }
  }
  
  final class ah
    extends fl.a
  {
    ah(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList)
    {
      paramRoomStatusUpdateListener.onPeerLeft(paramRoom, paramArrayList);
    }
  }
  
  final class ai
    extends fk
  {
    private final a.c<Leaderboards.LoadPlayerScoreResult> jW;
    
    ai()
    {
      Object localObject;
      this.jW = ((a.c)eg.b(localObject, "Holder must not be null"));
    }
    
    public void D(DataHolder paramDataHolder)
    {
      fl.this.a(new fl.aj(fl.this, this.jW, paramDataHolder));
    }
  }
  
  final class aj
    extends dw<fp>.d<a.c<Leaderboards.LoadPlayerScoreResult>>
    implements Leaderboards.LoadPlayerScoreResult
  {
    private final Status jY;
    private final d uq;
    
    /* Error */
    aj(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: putfield 20	com/google/android/gms/internal/fl$aj:tZ	Lcom/google/android/gms/internal/fl;
      //   5: aload_0
      //   6: aload_1
      //   7: aload_2
      //   8: aload_3
      //   9: invokespecial 23	com/google/android/gms/internal/dw$d:<init>	(Lcom/google/android/gms/internal/dw;Ljava/lang/Object;Lcom/google/android/gms/common/data/DataHolder;)V
      //   12: aload_0
      //   13: new 25	com/google/android/gms/common/api/Status
      //   16: dup
      //   17: aload_3
      //   18: invokevirtual 31	com/google/android/gms/common/data/DataHolder:getStatusCode	()I
      //   21: invokespecial 34	com/google/android/gms/common/api/Status:<init>	(I)V
      //   24: putfield 36	com/google/android/gms/internal/fl$aj:jY	Lcom/google/android/gms/common/api/Status;
      //   27: new 38	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer
      //   30: dup
      //   31: aload_3
      //   32: invokespecial 41	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   35: astore_1
      //   36: aload_1
      //   37: invokevirtual 44	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:getCount	()I
      //   40: ifle +25 -> 65
      //   43: aload_0
      //   44: aload_1
      //   45: iconst_0
      //   46: invokevirtual 48	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:get	(I)Lcom/google/android/gms/games/leaderboard/LeaderboardScore;
      //   49: invokeinterface 54 1 0
      //   54: checkcast 56	com/google/android/gms/games/leaderboard/d
      //   57: putfield 58	com/google/android/gms/internal/fl$aj:uq	Lcom/google/android/gms/games/leaderboard/d;
      //   60: aload_1
      //   61: invokevirtual 62	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:close	()V
      //   64: return
      //   65: aload_0
      //   66: aconst_null
      //   67: putfield 58	com/google/android/gms/internal/fl$aj:uq	Lcom/google/android/gms/games/leaderboard/d;
      //   70: goto -10 -> 60
      //   73: astore_2
      //   74: aload_1
      //   75: invokevirtual 62	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:close	()V
      //   78: aload_2
      //   79: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	80	0	this	aj
      //   0	80	1	this$1	fl
      //   0	80	2	paramDataHolder	DataHolder
      //   8	24	3	localDataHolder	DataHolder
      // Exception table:
      //   from	to	target	type
      //   36	60	73	finally
      //   65	70	73	finally
    }
    
    protected void a(a.c<Leaderboards.LoadPlayerScoreResult> paramc, DataHolder paramDataHolder)
    {
      paramc.a(this);
    }
    
    public LeaderboardScore getScore()
    {
      return this.uq;
    }
    
    public Status getStatus()
    {
      return this.jY;
    }
  }
  
  final class ak
    extends fk
  {
    private final a.c<Players.LoadPlayersResult> jW;
    
    ak()
    {
      Object localObject;
      this.jW = ((a.c)eg.b(localObject, "Holder must not be null"));
    }
    
    public void e(DataHolder paramDataHolder)
    {
      fl.this.a(new fl.al(fl.this, this.jW, paramDataHolder));
    }
  }
  
  final class al
    extends fl.ao<a.c<Players.LoadPlayersResult>>
    implements Players.LoadPlayersResult
  {
    private final PlayerBuffer ur;
    
    al(DataHolder paramDataHolder)
    {
      super(paramDataHolder, localDataHolder);
      this.ur = new PlayerBuffer(localDataHolder);
    }
    
    protected void a(a.c<Players.LoadPlayersResult> paramc, DataHolder paramDataHolder)
    {
      paramc.a(this);
    }
    
    public PlayerBuffer getPlayers()
    {
      return this.ur;
    }
  }
  
  final class am
    extends dw<fp>.b<RealTimeMultiplayer.ReliableMessageSentCallback>
  {
    private final int mC;
    private final String us;
    private final int ut;
    
    am(RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback, int paramInt1, int paramInt2, String paramString)
    {
      super(paramReliableMessageSentCallback);
      this.mC = paramInt1;
      this.ut = paramInt2;
      this.us = paramString;
    }
    
    public void a(RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback)
    {
      if (paramReliableMessageSentCallback != null) {
        paramReliableMessageSentCallback.onRealTimeMessageSent(this.mC, this.ut, this.us);
      }
    }
    
    protected void aL() {}
  }
  
  final class an
    extends fk
  {
    final RealTimeMultiplayer.ReliableMessageSentCallback uu;
    
    public an(RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback)
    {
      this.uu = paramReliableMessageSentCallback;
    }
    
    public void b(int paramInt1, int paramInt2, String paramString)
    {
      fl.this.a(new fl.am(fl.this, this.uu, paramInt1, paramInt2, paramString));
    }
  }
  
  abstract class ao<R extends a.c<?>>
    extends dw<fp>.d<R>
    implements Releasable, Result
  {
    final Status jY;
    final DataHolder nE;
    
    public ao(DataHolder paramDataHolder)
    {
      super(paramDataHolder, localDataHolder);
      this.jY = new Status(localDataHolder.getStatusCode());
      this.nE = localDataHolder;
    }
    
    public Status getStatus()
    {
      return this.jY;
    }
    
    public void release()
    {
      if (this.nE != null) {
        this.nE.close();
      }
    }
  }
  
  final class ap
    extends fl.c
  {
    ap(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder);
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onRoomAutoMatching(paramRoom);
    }
  }
  
  final class aq
    extends fk
  {
    private final RoomUpdateListener uv;
    private final RoomStatusUpdateListener uw;
    private final RealTimeMessageReceivedListener ux;
    
    public aq(RoomUpdateListener paramRoomUpdateListener)
    {
      this.uv = ((RoomUpdateListener)eg.b(paramRoomUpdateListener, "Callbacks must not be null"));
      this.uw = null;
      this.ux = null;
    }
    
    public aq(RoomUpdateListener paramRoomUpdateListener, RoomStatusUpdateListener paramRoomStatusUpdateListener, RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener)
    {
      this.uv = ((RoomUpdateListener)eg.b(paramRoomUpdateListener, "Callbacks must not be null"));
      this.uw = paramRoomStatusUpdateListener;
      this.ux = paramRealTimeMessageReceivedListener;
    }
    
    public void a(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      fl.this.a(new fl.af(fl.this, this.uw, paramDataHolder, paramArrayOfString));
    }
    
    public void b(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      fl.this.a(new fl.ag(fl.this, this.uw, paramDataHolder, paramArrayOfString));
    }
    
    public void c(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      fl.this.a(new fl.ah(fl.this, this.uw, paramDataHolder, paramArrayOfString));
    }
    
    public void d(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      fl.this.a(new fl.ad(fl.this, this.uw, paramDataHolder, paramArrayOfString));
    }
    
    public void e(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      fl.this.a(new fl.ac(fl.this, this.uw, paramDataHolder, paramArrayOfString));
    }
    
    public void f(DataHolder paramDataHolder, String[] paramArrayOfString)
    {
      fl.this.a(new fl.ae(fl.this, this.uw, paramDataHolder, paramArrayOfString));
    }
    
    public void onLeftRoom(int paramInt, String paramString)
    {
      fl.this.a(new fl.v(fl.this, this.uv, paramInt, paramString));
    }
    
    public void onP2PConnected(String paramString)
    {
      fl.this.a(new fl.aa(fl.this, this.uw, paramString));
    }
    
    public void onP2PDisconnected(String paramString)
    {
      fl.this.a(new fl.ab(fl.this, this.uw, paramString));
    }
    
    public void onRealTimeMessageReceived(RealTimeMessage paramRealTimeMessage)
    {
      fl.this.a(new fl.z(fl.this, this.ux, paramRealTimeMessage));
    }
    
    public void t(DataHolder paramDataHolder)
    {
      fl.this.a(new fl.at(fl.this, this.uv, paramDataHolder));
    }
    
    public void u(DataHolder paramDataHolder)
    {
      fl.this.a(new fl.q(fl.this, this.uv, paramDataHolder));
    }
    
    public void v(DataHolder paramDataHolder)
    {
      fl.this.a(new fl.as(fl.this, this.uw, paramDataHolder));
    }
    
    public void w(DataHolder paramDataHolder)
    {
      fl.this.a(new fl.ap(fl.this, this.uw, paramDataHolder));
    }
    
    public void x(DataHolder paramDataHolder)
    {
      fl.this.a(new fl.ar(fl.this, this.uv, paramDataHolder));
    }
    
    public void y(DataHolder paramDataHolder)
    {
      fl.this.a(new fl.h(fl.this, this.uw, paramDataHolder));
    }
    
    public void z(DataHolder paramDataHolder)
    {
      fl.this.a(new fl.i(fl.this, this.uw, paramDataHolder));
    }
  }
  
  final class ar
    extends fl.b
  {
    ar(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomUpdateListener, paramDataHolder);
    }
    
    public void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt)
    {
      paramRoomUpdateListener.onRoomConnected(paramInt, paramRoom);
    }
  }
  
  final class as
    extends fl.c
  {
    as(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder);
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onRoomConnecting(paramRoom);
    }
  }
  
  final class at
    extends fl.b
  {
    public at(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomUpdateListener, paramDataHolder);
    }
    
    public void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt)
    {
      paramRoomUpdateListener.onRoomCreated(paramInt, paramRoom);
    }
  }
  
  final class au
    extends fk
  {
    private final a.c<Status> jW;
    
    public au()
    {
      Object localObject;
      this.jW = ((a.c)eg.b(localObject, "Holder must not be null"));
    }
    
    public void onSignOutComplete()
    {
      Status localStatus = new Status(0);
      fl.this.a(new fl.av(fl.this, this.jW, localStatus));
    }
  }
  
  final class av
    extends dw<fp>.b<a.c<Status>>
  {
    private final Status jY;
    
    public av(Status paramStatus)
    {
      super(paramStatus);
      Status localStatus;
      this.jY = localStatus;
    }
    
    protected void aL() {}
    
    public void c(a.c<Status> paramc)
    {
      paramc.a(this.jY);
    }
  }
  
  final class aw
    extends fk
  {
    private final a.c<Leaderboards.SubmitScoreResult> jW;
    
    public aw()
    {
      Object localObject;
      this.jW = ((a.c)eg.b(localObject, "Holder must not be null"));
    }
    
    public void d(DataHolder paramDataHolder)
    {
      fl.this.a(new fl.ax(fl.this, this.jW, paramDataHolder));
    }
  }
  
  final class ax
    extends fl.ao<a.c<Leaderboards.SubmitScoreResult>>
    implements Leaderboards.SubmitScoreResult
  {
    private final ScoreSubmissionData uy;
    
    public ax(DataHolder paramDataHolder)
    {
      super(paramDataHolder, localDataHolder);
      this.uy = new ScoreSubmissionData(localDataHolder);
    }
    
    public void a(a.c<Leaderboards.SubmitScoreResult> paramc, DataHolder paramDataHolder)
    {
      paramc.a(this);
    }
    
    public ScoreSubmissionData getScoreData()
    {
      return this.uy;
    }
  }
  
  abstract class ay<T extends a.c<?>>
    extends fl.ao<T>
  {
    final TurnBasedMatch un;
    
    /* Error */
    ay(DataHolder paramDataHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: putfield 16	com/google/android/gms/internal/fl$ay:tZ	Lcom/google/android/gms/internal/fl;
      //   5: aload_0
      //   6: aload_1
      //   7: aload_2
      //   8: aload_3
      //   9: invokespecial 18	com/google/android/gms/internal/fl$ao:<init>	(Lcom/google/android/gms/internal/fl;Lcom/google/android/gms/common/api/a$c;Lcom/google/android/gms/common/data/DataHolder;)V
      //   12: new 20	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer
      //   15: dup
      //   16: aload_3
      //   17: invokespecial 23	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   20: astore_1
      //   21: aload_1
      //   22: invokevirtual 27	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:getCount	()I
      //   25: ifle +28 -> 53
      //   28: aload_0
      //   29: aload_1
      //   30: iconst_0
      //   31: invokevirtual 31	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:get	(I)Ljava/lang/Object;
      //   34: checkcast 33	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch
      //   37: invokeinterface 37 1 0
      //   42: checkcast 33	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch
      //   45: putfield 39	com/google/android/gms/internal/fl$ay:un	Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;
      //   48: aload_1
      //   49: invokevirtual 43	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:close	()V
      //   52: return
      //   53: aload_0
      //   54: aconst_null
      //   55: putfield 39	com/google/android/gms/internal/fl$ay:un	Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;
      //   58: goto -10 -> 48
      //   61: astore_2
      //   62: aload_1
      //   63: invokevirtual 43	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:close	()V
      //   66: aload_2
      //   67: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	68	0	this	ay
      //   0	68	1	this$1	fl
      //   0	68	2	paramDataHolder	DataHolder
      //   8	9	3	localDataHolder	DataHolder
      // Exception table:
      //   from	to	target	type
      //   21	48	61	finally
      //   53	58	61	finally
    }
    
    protected void a(T paramT, DataHolder paramDataHolder)
    {
      i(paramT);
    }
    
    public TurnBasedMatch getMatch()
    {
      return this.un;
    }
    
    abstract void i(T paramT);
  }
  
  final class az
    extends fk
  {
    private final a.c<TurnBasedMultiplayer.CancelMatchResult> uz;
    
    public az()
    {
      Object localObject;
      this.uz = ((a.c)eg.b(localObject, "Holder must not be null"));
    }
    
    public void onTurnBasedMatchCanceled(int paramInt, String paramString)
    {
      Status localStatus = new Status(paramInt);
      fl.this.a(new fl.ba(fl.this, this.uz, localStatus, paramString));
    }
  }
  
  abstract class b
    extends dw<fp>.d<RoomUpdateListener>
  {
    b(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomUpdateListener, paramDataHolder);
    }
    
    protected void a(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder)
    {
      a(paramRoomUpdateListener, fl.a(fl.this, paramDataHolder), paramDataHolder.getStatusCode());
    }
    
    protected abstract void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt);
  }
  
  final class ba
    extends dw<fp>.b<a.c<TurnBasedMultiplayer.CancelMatchResult>>
    implements TurnBasedMultiplayer.CancelMatchResult
  {
    private final Status jY;
    private final String uA;
    
    ba(Status paramStatus, String paramString)
    {
      super(paramStatus);
      this.jY = paramString;
      String str;
      this.uA = str;
    }
    
    protected void aL() {}
    
    public void c(a.c<TurnBasedMultiplayer.CancelMatchResult> paramc)
    {
      paramc.a(this);
    }
    
    public String getMatchId()
    {
      return this.uA;
    }
    
    public Status getStatus()
    {
      return this.jY;
    }
  }
  
  final class bb
    extends fk
  {
    private final a.c<TurnBasedMultiplayer.InitiateMatchResult> uB;
    
    public bb()
    {
      Object localObject;
      this.uB = ((a.c)eg.b(localObject, "Holder must not be null"));
    }
    
    public void n(DataHolder paramDataHolder)
    {
      fl.this.a(new fl.bc(fl.this, this.uB, paramDataHolder));
    }
  }
  
  final class bc
    extends fl.ay<a.c<TurnBasedMultiplayer.InitiateMatchResult>>
    implements TurnBasedMultiplayer.InitiateMatchResult
  {
    bc(DataHolder paramDataHolder)
    {
      super(paramDataHolder, localDataHolder);
    }
    
    protected void i(a.c<TurnBasedMultiplayer.InitiateMatchResult> paramc)
    {
      paramc.a(this);
    }
  }
  
  final class bd
    extends fk
  {
    private final a.c<TurnBasedMultiplayer.LeaveMatchResult> uC;
    
    public bd()
    {
      Object localObject;
      this.uC = ((a.c)eg.b(localObject, "Holder must not be null"));
    }
    
    public void p(DataHolder paramDataHolder)
    {
      fl.this.a(new fl.be(fl.this, this.uC, paramDataHolder));
    }
  }
  
  final class be
    extends fl.ay<a.c<TurnBasedMultiplayer.LeaveMatchResult>>
    implements TurnBasedMultiplayer.LeaveMatchResult
  {
    be(DataHolder paramDataHolder)
    {
      super(paramDataHolder, localDataHolder);
    }
    
    protected void i(a.c<TurnBasedMultiplayer.LeaveMatchResult> paramc)
    {
      paramc.a(this);
    }
  }
  
  final class bf
    extends fk
  {
    private final a.c<TurnBasedMultiplayer.LoadMatchResult> uD;
    
    public bf()
    {
      Object localObject;
      this.uD = ((a.c)eg.b(localObject, "Holder must not be null"));
    }
    
    public void m(DataHolder paramDataHolder)
    {
      fl.this.a(new fl.bg(fl.this, this.uD, paramDataHolder));
    }
  }
  
  final class bg
    extends fl.ay<a.c<TurnBasedMultiplayer.LoadMatchResult>>
    implements TurnBasedMultiplayer.LoadMatchResult
  {
    bg(DataHolder paramDataHolder)
    {
      super(paramDataHolder, localDataHolder);
    }
    
    protected void i(a.c<TurnBasedMultiplayer.LoadMatchResult> paramc)
    {
      paramc.a(this);
    }
  }
  
  final class bh
    extends fk
  {
    private final a.c<TurnBasedMultiplayer.UpdateMatchResult> uE;
    
    public bh()
    {
      Object localObject;
      this.uE = ((a.c)eg.b(localObject, "Holder must not be null"));
    }
    
    public void o(DataHolder paramDataHolder)
    {
      fl.this.a(new fl.bi(fl.this, this.uE, paramDataHolder));
    }
  }
  
  final class bi
    extends fl.ay<a.c<TurnBasedMultiplayer.UpdateMatchResult>>
    implements TurnBasedMultiplayer.UpdateMatchResult
  {
    bi(DataHolder paramDataHolder)
    {
      super(paramDataHolder, localDataHolder);
    }
    
    protected void i(a.c<TurnBasedMultiplayer.UpdateMatchResult> paramc)
    {
      paramc.a(this);
    }
  }
  
  final class bj
    extends fk
  {
    private final a.c<TurnBasedMultiplayer.LoadMatchesResult> uF;
    
    public bj()
    {
      Object localObject;
      this.uF = ((a.c)eg.b(localObject, "Holder must not be null"));
    }
    
    public void a(int paramInt, Bundle paramBundle)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      Status localStatus = new Status(paramInt);
      fl.this.a(new fl.bk(fl.this, this.uF, localStatus, paramBundle));
    }
  }
  
  final class bk
    extends dw<fp>.b<a.c<TurnBasedMultiplayer.LoadMatchesResult>>
    implements TurnBasedMultiplayer.LoadMatchesResult
  {
    private final Status jY;
    private final LoadMatchesResponse uG;
    
    bk(Status paramStatus, Bundle paramBundle)
    {
      super(paramStatus);
      this.jY = paramBundle;
      Bundle localBundle;
      this.uG = new LoadMatchesResponse(localBundle);
    }
    
    protected void aL() {}
    
    protected void c(a.c<TurnBasedMultiplayer.LoadMatchesResult> paramc)
    {
      paramc.a(this);
    }
    
    public LoadMatchesResponse getMatches()
    {
      return this.uG;
    }
    
    public Status getStatus()
    {
      return this.jY;
    }
    
    public void release()
    {
      this.uG.close();
    }
  }
  
  abstract class c
    extends dw<fp>.d<RoomStatusUpdateListener>
  {
    c(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder);
    }
    
    protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
    {
      a(paramRoomStatusUpdateListener, fl.a(fl.this, paramDataHolder));
    }
    
    protected abstract void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom);
  }
  
  final class d
    extends fk
  {
    private final a.c<Achievements.UpdateAchievementResult> jW;
    
    d()
    {
      Object localObject;
      this.jW = ((a.c)eg.b(localObject, "Holder must not be null"));
    }
    
    public void onAchievementUpdated(int paramInt, String paramString)
    {
      fl.this.a(new fl.e(fl.this, this.jW, paramInt, paramString));
    }
  }
  
  final class e
    extends dw<fp>.b<a.c<Achievements.UpdateAchievementResult>>
    implements Achievements.UpdateAchievementResult
  {
    private final Status jY;
    private final String ua;
    
    e(int paramInt, String paramString)
    {
      super(paramInt);
      this.jY = new Status(paramString);
      String str;
      this.ua = str;
    }
    
    protected void aL() {}
    
    protected void c(a.c<Achievements.UpdateAchievementResult> paramc)
    {
      paramc.a(this);
    }
    
    public String getAchievementId()
    {
      return this.ua;
    }
    
    public Status getStatus()
    {
      return this.jY;
    }
  }
  
  final class f
    extends fk
  {
    private final a.c<Achievements.LoadAchievementsResult> jW;
    
    f()
    {
      Object localObject;
      this.jW = ((a.c)eg.b(localObject, "Holder must not be null"));
    }
    
    public void b(DataHolder paramDataHolder)
    {
      fl.this.a(new fl.g(fl.this, this.jW, paramDataHolder));
    }
  }
  
  final class g
    extends fl.ao<a.c<Achievements.LoadAchievementsResult>>
    implements Achievements.LoadAchievementsResult
  {
    private final AchievementBuffer ub;
    
    g(DataHolder paramDataHolder)
    {
      super(paramDataHolder, localDataHolder);
      this.ub = new AchievementBuffer(localDataHolder);
    }
    
    protected void a(a.c<Achievements.LoadAchievementsResult> paramc, DataHolder paramDataHolder)
    {
      paramc.a(this);
    }
    
    public AchievementBuffer getAchievements()
    {
      return this.ub;
    }
  }
  
  final class h
    extends fl.c
  {
    h(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder);
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onConnectedToRoom(paramRoom);
    }
  }
  
  final class i
    extends fl.c
  {
    i(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomStatusUpdateListener, paramDataHolder);
    }
    
    public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom)
    {
      paramRoomStatusUpdateListener.onDisconnectedFromRoom(paramRoom);
    }
  }
  
  final class j
    extends fk
  {
    private final a.c<GamesMetadata.LoadGamesResult> jW;
    
    j()
    {
      Object localObject;
      this.jW = ((a.c)eg.b(localObject, "Holder must not be null"));
    }
    
    public void g(DataHolder paramDataHolder)
    {
      fl.this.a(new fl.k(fl.this, this.jW, paramDataHolder));
    }
  }
  
  final class k
    extends fl.ao<a.c<GamesMetadata.LoadGamesResult>>
    implements GamesMetadata.LoadGamesResult
  {
    private final GameBuffer uc;
    
    k(DataHolder paramDataHolder)
    {
      super(paramDataHolder, localDataHolder);
      this.uc = new GameBuffer(localDataHolder);
    }
    
    protected void a(a.c<GamesMetadata.LoadGamesResult> paramc, DataHolder paramDataHolder)
    {
      paramc.a(this);
    }
    
    public GameBuffer getGames()
    {
      return this.uc;
    }
  }
  
  final class l
    extends fk
  {
    private final OnInvitationReceivedListener ud;
    
    l(OnInvitationReceivedListener paramOnInvitationReceivedListener)
    {
      this.ud = paramOnInvitationReceivedListener;
    }
    
    public void l(DataHolder paramDataHolder)
    {
      InvitationBuffer localInvitationBuffer = new InvitationBuffer(paramDataHolder);
      paramDataHolder = null;
      try
      {
        if (localInvitationBuffer.getCount() > 0) {
          paramDataHolder = (Invitation)((Invitation)localInvitationBuffer.get(0)).freeze();
        }
        localInvitationBuffer.close();
        if (paramDataHolder != null) {
          fl.this.a(new fl.m(fl.this, this.ud, paramDataHolder));
        }
        return;
      }
      finally
      {
        localInvitationBuffer.close();
      }
    }
    
    public void onInvitationRemoved(String paramString)
    {
      fl.this.a(new fl.n(fl.this, this.ud, paramString));
    }
  }
  
  final class m
    extends dw<fp>.b<OnInvitationReceivedListener>
  {
    private final Invitation ue;
    
    m(OnInvitationReceivedListener paramOnInvitationReceivedListener, Invitation paramInvitation)
    {
      super(paramOnInvitationReceivedListener);
      this.ue = paramInvitation;
    }
    
    protected void a(OnInvitationReceivedListener paramOnInvitationReceivedListener)
    {
      paramOnInvitationReceivedListener.onInvitationReceived(this.ue);
    }
    
    protected void aL() {}
  }
  
  final class n
    extends dw<fp>.b<OnInvitationReceivedListener>
  {
    private final String uf;
    
    n(OnInvitationReceivedListener paramOnInvitationReceivedListener, String paramString)
    {
      super(paramOnInvitationReceivedListener);
      this.uf = paramString;
    }
    
    protected void a(OnInvitationReceivedListener paramOnInvitationReceivedListener)
    {
      paramOnInvitationReceivedListener.onInvitationRemoved(this.uf);
    }
    
    protected void aL() {}
  }
  
  final class o
    extends fk
  {
    private final a.c<Invitations.LoadInvitationsResult> jW;
    
    o()
    {
      Object localObject;
      this.jW = ((a.c)eg.b(localObject, "Holder must not be null"));
    }
    
    public void k(DataHolder paramDataHolder)
    {
      fl.this.a(new fl.p(fl.this, this.jW, paramDataHolder));
    }
  }
  
  final class p
    extends fl.ao<a.c<Invitations.LoadInvitationsResult>>
    implements Invitations.LoadInvitationsResult
  {
    private final InvitationBuffer ug;
    
    p(DataHolder paramDataHolder)
    {
      super(paramDataHolder, localDataHolder);
      this.ug = new InvitationBuffer(localDataHolder);
    }
    
    protected void a(a.c<Invitations.LoadInvitationsResult> paramc, DataHolder paramDataHolder)
    {
      paramc.a(this);
    }
    
    public InvitationBuffer getInvitations()
    {
      return this.ug;
    }
  }
  
  final class q
    extends fl.b
  {
    public q(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder)
    {
      super(paramRoomUpdateListener, paramDataHolder);
    }
    
    public void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt)
    {
      paramRoomUpdateListener.onJoinedRoom(paramInt, paramRoom);
    }
  }
  
  final class r
    extends fk
  {
    private final a.c<Leaderboards.LoadScoresResult> jW;
    
    r()
    {
      Object localObject;
      this.jW = ((a.c)eg.b(localObject, "Holder must not be null"));
    }
    
    public void a(DataHolder paramDataHolder1, DataHolder paramDataHolder2)
    {
      fl.this.a(new fl.s(fl.this, this.jW, paramDataHolder1, paramDataHolder2));
    }
  }
  
  final class s
    extends fl.ao<a.c<Leaderboards.LoadScoresResult>>
    implements Leaderboards.LoadScoresResult
  {
    private final com.google.android.gms.games.leaderboard.a uh;
    private final LeaderboardScoreBuffer ui;
    
    /* Error */
    s(DataHolder paramDataHolder1, DataHolder paramDataHolder2)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: putfield 20	com/google/android/gms/internal/fl$s:tZ	Lcom/google/android/gms/internal/fl;
      //   5: aload_0
      //   6: aload_1
      //   7: aload_2
      //   8: aload 4
      //   10: invokespecial 23	com/google/android/gms/internal/fl$ao:<init>	(Lcom/google/android/gms/internal/fl;Lcom/google/android/gms/common/api/a$c;Lcom/google/android/gms/common/data/DataHolder;)V
      //   13: new 25	com/google/android/gms/games/leaderboard/LeaderboardBuffer
      //   16: dup
      //   17: aload_3
      //   18: invokespecial 28	com/google/android/gms/games/leaderboard/LeaderboardBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   21: astore_1
      //   22: aload_1
      //   23: invokevirtual 32	com/google/android/gms/games/leaderboard/LeaderboardBuffer:getCount	()I
      //   26: ifle +41 -> 67
      //   29: aload_0
      //   30: aload_1
      //   31: iconst_0
      //   32: invokevirtual 36	com/google/android/gms/games/leaderboard/LeaderboardBuffer:get	(I)Ljava/lang/Object;
      //   35: checkcast 38	com/google/android/gms/games/leaderboard/Leaderboard
      //   38: invokeinterface 42 1 0
      //   43: checkcast 44	com/google/android/gms/games/leaderboard/a
      //   46: putfield 46	com/google/android/gms/internal/fl$s:uh	Lcom/google/android/gms/games/leaderboard/a;
      //   49: aload_1
      //   50: invokevirtual 50	com/google/android/gms/games/leaderboard/LeaderboardBuffer:close	()V
      //   53: aload_0
      //   54: new 52	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer
      //   57: dup
      //   58: aload 4
      //   60: invokespecial 53	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
      //   63: putfield 55	com/google/android/gms/internal/fl$s:ui	Lcom/google/android/gms/games/leaderboard/LeaderboardScoreBuffer;
      //   66: return
      //   67: aload_0
      //   68: aconst_null
      //   69: putfield 46	com/google/android/gms/internal/fl$s:uh	Lcom/google/android/gms/games/leaderboard/a;
      //   72: goto -23 -> 49
      //   75: astore_2
      //   76: aload_1
      //   77: invokevirtual 50	com/google/android/gms/games/leaderboard/LeaderboardBuffer:close	()V
      //   80: aload_2
      //   81: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	82	0	this	s
      //   0	82	1	this$1	fl
      //   0	82	2	paramDataHolder1	DataHolder
      //   0	82	3	paramDataHolder2	DataHolder
      //   8	51	4	localDataHolder	DataHolder
      // Exception table:
      //   from	to	target	type
      //   22	49	75	finally
      //   67	72	75	finally
    }
    
    protected void a(a.c<Leaderboards.LoadScoresResult> paramc, DataHolder paramDataHolder)
    {
      paramc.a(this);
    }
    
    public Leaderboard getLeaderboard()
    {
      return this.uh;
    }
    
    public LeaderboardScoreBuffer getScores()
    {
      return this.ui;
    }
  }
  
  final class t
    extends fk
  {
    private final a.c<Leaderboards.LeaderboardMetadataResult> jW;
    
    t()
    {
      Object localObject;
      this.jW = ((a.c)eg.b(localObject, "Holder must not be null"));
    }
    
    public void c(DataHolder paramDataHolder)
    {
      fl.this.a(new fl.u(fl.this, this.jW, paramDataHolder));
    }
  }
  
  final class u
    extends fl.ao<a.c<Leaderboards.LeaderboardMetadataResult>>
    implements Leaderboards.LeaderboardMetadataResult
  {
    private final LeaderboardBuffer uj;
    
    u(DataHolder paramDataHolder)
    {
      super(paramDataHolder, localDataHolder);
      this.uj = new LeaderboardBuffer(localDataHolder);
    }
    
    protected void a(a.c<Leaderboards.LeaderboardMetadataResult> paramc, DataHolder paramDataHolder)
    {
      paramc.a(this);
    }
    
    public LeaderboardBuffer getLeaderboards()
    {
      return this.uj;
    }
  }
  
  final class v
    extends dw<fp>.b<RoomUpdateListener>
  {
    private final int mC;
    private final String uk;
    
    v(RoomUpdateListener paramRoomUpdateListener, int paramInt, String paramString)
    {
      super(paramRoomUpdateListener);
      this.mC = paramInt;
      this.uk = paramString;
    }
    
    public void a(RoomUpdateListener paramRoomUpdateListener)
    {
      paramRoomUpdateListener.onLeftRoom(this.mC, this.uk);
    }
    
    protected void aL() {}
  }
  
  final class w
    extends dw<fp>.b<OnTurnBasedMatchUpdateReceivedListener>
  {
    private final String ul;
    
    w(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener, String paramString)
    {
      super(paramOnTurnBasedMatchUpdateReceivedListener);
      this.ul = paramString;
    }
    
    protected void a(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
    {
      paramOnTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.ul);
    }
    
    protected void aL() {}
  }
  
  final class x
    extends fk
  {
    private final OnTurnBasedMatchUpdateReceivedListener um;
    
    x(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
    {
      this.um = paramOnTurnBasedMatchUpdateReceivedListener;
    }
    
    public void onTurnBasedMatchRemoved(String paramString)
    {
      fl.this.a(new fl.w(fl.this, this.um, paramString));
    }
    
    public void q(DataHolder paramDataHolder)
    {
      TurnBasedMatchBuffer localTurnBasedMatchBuffer = new TurnBasedMatchBuffer(paramDataHolder);
      paramDataHolder = null;
      try
      {
        if (localTurnBasedMatchBuffer.getCount() > 0) {
          paramDataHolder = (TurnBasedMatch)((TurnBasedMatch)localTurnBasedMatchBuffer.get(0)).freeze();
        }
        localTurnBasedMatchBuffer.close();
        if (paramDataHolder != null) {
          fl.this.a(new fl.y(fl.this, this.um, paramDataHolder));
        }
        return;
      }
      finally
      {
        localTurnBasedMatchBuffer.close();
      }
    }
  }
  
  final class y
    extends dw<fp>.b<OnTurnBasedMatchUpdateReceivedListener>
  {
    private final TurnBasedMatch un;
    
    y(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener, TurnBasedMatch paramTurnBasedMatch)
    {
      super(paramOnTurnBasedMatchUpdateReceivedListener);
      this.un = paramTurnBasedMatch;
    }
    
    protected void a(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener)
    {
      paramOnTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.un);
    }
    
    protected void aL() {}
  }
  
  final class z
    extends dw<fp>.b<RealTimeMessageReceivedListener>
  {
    private final RealTimeMessage uo;
    
    z(RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener, RealTimeMessage paramRealTimeMessage)
    {
      super(paramRealTimeMessageReceivedListener);
      this.uo = paramRealTimeMessage;
    }
    
    public void a(RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener)
    {
      if (paramRealTimeMessageReceivedListener != null) {
        paramRealTimeMessageReceivedListener.onRealTimeMessageReceived(this.uo);
      }
    }
    
    protected void aL() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/fl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */