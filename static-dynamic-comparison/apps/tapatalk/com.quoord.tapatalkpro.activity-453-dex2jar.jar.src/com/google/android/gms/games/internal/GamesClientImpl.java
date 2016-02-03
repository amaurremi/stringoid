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
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadExtendedPlayersResult;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;
import com.google.android.gms.games.internal.game.ExtendedGameBuffer;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.player.ExtendedPlayerBuffer;
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
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.internal.ff;
import com.google.android.gms.internal.ff.b;
import com.google.android.gms.internal.ff.d;
import com.google.android.gms.internal.ff.e;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.fq;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class GamesClientImpl
        extends ff<IGamesService>
        implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private boolean IA = false;
    private int IB;
    private final Binder IC;
    private final long IE;
    private final boolean IF;
    private final int IG;
    private final boolean IH;
    private final String Iu;
    private final Map<String, RealTimeSocket> Iv;
    private PlayerEntity Iw;
    private GameEntity Ix;
    private final PopupManager Iy;
    private boolean Iz = false;
    private final String wG;

    public GamesClientImpl(Context paramContext, Looper paramLooper, String paramString1, String paramString2, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String[] paramArrayOfString, int paramInt1, View paramView, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, boolean paramBoolean3, int paramInt3) {
        super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramArrayOfString);
        this.Iu = paramString1;
        this.wG = ((String) fq.f(paramString2));
        this.IC = new Binder();
        this.Iv = new HashMap();
        this.Iy = PopupManager.a(this, paramInt1);
        f(paramView);
        this.IA = paramBoolean2;
        this.IB = paramInt2;
        this.IE = hashCode();
        this.IF = paramBoolean1;
        this.IH = paramBoolean3;
        this.IG = paramInt3;
        registerConnectionCallbacks(this);
        registerConnectionFailedListener(this);
    }

    private Room G(DataHolder paramDataHolder) {
        RoomBuffer localRoomBuffer = new RoomBuffer(paramDataHolder);
        paramDataHolder = null;
        try {
            if (localRoomBuffer.getCount() > 0) {
                paramDataHolder = (Room) ((Room) localRoomBuffer.get(0)).freeze();
            }
            return paramDataHolder;
        } finally {
            localRoomBuffer.close();
        }
    }

    /* Error */
    private RealTimeSocket aC(String paramString) {
        // Byte code:
        //   0: aload_0
        //   1: invokevirtual 426	com/google/android/gms/games/internal/GamesClientImpl:eM	()Landroid/os/IInterface;
        //   4: checkcast 428	com/google/android/gms/games/internal/IGamesService
        //   7: aload_1
        //   8: invokeinterface 432 2 0
        //   13: astore_2
        //   14: aload_2
        //   15: ifnull +35 -> 50
        //   18: ldc_w 434
        //   21: ldc_w 436
        //   24: invokestatic 441	com/google/android/gms/games/internal/GamesLog:f	(Ljava/lang/String;Ljava/lang/String;)V
        //   27: new 443	com/google/android/gms/games/internal/LibjingleNativeSocket
        //   30: dup
        //   31: aload_2
        //   32: invokespecial 446	com/google/android/gms/games/internal/LibjingleNativeSocket:<init>	(Landroid/os/ParcelFileDescriptor;)V
        //   35: astore_2
        //   36: aload_0
        //   37: getfield 354	com/google/android/gms/games/internal/GamesClientImpl:Iv	Ljava/util/Map;
        //   40: aload_1
        //   41: aload_2
        //   42: invokeinterface 452 3 0
        //   47: pop
        //   48: aload_2
        //   49: areturn
        //   50: ldc_w 434
        //   53: ldc_w 454
        //   56: invokestatic 441	com/google/android/gms/games/internal/GamesLog:f	(Ljava/lang/String;Ljava/lang/String;)V
        //   59: aload_0
        //   60: invokevirtual 426	com/google/android/gms/games/internal/GamesClientImpl:eM	()Landroid/os/IInterface;
        //   63: checkcast 428	com/google/android/gms/games/internal/IGamesService
        //   66: aload_1
        //   67: invokeinterface 458 2 0
        //   72: astore_2
        //   73: aload_2
        //   74: ifnonnull +5 -> 79
        //   77: aconst_null
        //   78: areturn
        //   79: new 460	android/net/LocalSocket
        //   82: dup
        //   83: invokespecial 461	android/net/LocalSocket:<init>	()V
        //   86: astore_3
        //   87: aload_3
        //   88: new 463	android/net/LocalSocketAddress
        //   91: dup
        //   92: aload_2
        //   93: invokespecial 466	android/net/LocalSocketAddress:<init>	(Ljava/lang/String;)V
        //   96: invokevirtual 470	android/net/LocalSocket:connect	(Landroid/net/LocalSocketAddress;)V
        //   99: new 472	com/google/android/gms/games/internal/RealTimeSocketImpl
        //   102: dup
        //   103: aload_3
        //   104: aload_1
        //   105: invokespecial 475	com/google/android/gms/games/internal/RealTimeSocketImpl:<init>	(Landroid/net/LocalSocket;Ljava/lang/String;)V
        //   108: astore_2
        //   109: aload_0
        //   110: getfield 354	com/google/android/gms/games/internal/GamesClientImpl:Iv	Ljava/util/Map;
        //   113: aload_1
        //   114: aload_2
        //   115: invokeinterface 452 3 0
        //   120: pop
        //   121: aload_2
        //   122: areturn
        //   123: astore_1
        //   124: ldc_w 434
        //   127: ldc_w 477
        //   130: invokestatic 480	com/google/android/gms/games/internal/GamesLog:h	(Ljava/lang/String;Ljava/lang/String;)V
        //   133: aconst_null
        //   134: areturn
        //   135: astore_1
        //   136: ldc_w 434
        //   139: new 482	java/lang/StringBuilder
        //   142: dup
        //   143: invokespecial 483	java/lang/StringBuilder:<init>	()V
        //   146: ldc_w 485
        //   149: invokevirtual 489	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   152: aload_1
        //   153: invokevirtual 493	java/io/IOException:getMessage	()Ljava/lang/String;
        //   156: invokevirtual 489	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   159: invokevirtual 496	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   162: invokestatic 480	com/google/android/gms/games/internal/GamesLog:h	(Ljava/lang/String;Ljava/lang/String;)V
        //   165: aconst_null
        //   166: areturn
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	167	0	this	GamesClientImpl
        //   0	167	1	paramString	String
        //   13	109	2	localObject	Object
        //   86	18	3	localLocalSocket	android.net.LocalSocket
        // Exception table:
        //   from	to	target	type
        //   0	14	123	android/os/RemoteException
        //   18	48	123	android/os/RemoteException
        //   50	73	123	android/os/RemoteException
        //   79	87	123	android/os/RemoteException
        //   87	99	123	android/os/RemoteException
        //   99	121	123	android/os/RemoteException
        //   136	165	123	android/os/RemoteException
        //   87	99	135	java/io/IOException
    }

    private void gE() {
        Iterator localIterator = this.Iv.values().iterator();
        while (localIterator.hasNext()) {
            RealTimeSocket localRealTimeSocket = (RealTimeSocket) localIterator.next();
            try {
                localRealTimeSocket.close();
            } catch (IOException localIOException) {
                GamesLog.a("GamesClientImpl", "IOException:", localIOException);
            }
        }
        this.Iv.clear();
    }

    private void gk() {
        this.Iw = null;
    }

    protected IGamesService L(IBinder paramIBinder) {
        return IGamesService.Stub.N(paramIBinder);
    }

    public int a(RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback, byte[] paramArrayOfByte, String paramString1, String paramString2) {
        try {
            int i = ((IGamesService) eM()).a(new RealTimeReliableMessageBinderCallbacks(paramReliableMessageSentCallback), paramArrayOfByte, paramString1, paramString2);
            return i;
        } catch (RemoteException paramReliableMessageSentCallback) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return -1;
    }

    public int a(byte[] paramArrayOfByte, String paramString, String[] paramArrayOfString) {
        fq.b(paramArrayOfString, "Participant IDs must not be null");
        try {
            int i = ((IGamesService) eM()).b(paramArrayOfByte, paramString, paramArrayOfString);
            return i;
        } catch (RemoteException paramArrayOfByte) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return -1;
    }

    public Intent a(int paramInt1, int paramInt2, boolean paramBoolean) {
        try {
            Intent localIntent = ((IGamesService) eM()).a(paramInt1, paramInt2, paramBoolean);
            return localIntent;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return null;
    }

    public Intent a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, Bitmap paramBitmap, String paramString) {
        try {
            paramArrayOfByte = ((IGamesService) eM()).a(paramInt1, paramArrayOfByte, paramInt2, paramString);
            fq.b(paramBitmap, "Must provide a non null icon");
            paramArrayOfByte.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", paramBitmap);
            return paramArrayOfByte;
        } catch (RemoteException paramArrayOfByte) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return null;
    }

    public Intent a(Room paramRoom, int paramInt) {
        try {
            paramRoom = ((IGamesService) eM()).a((RoomEntity) paramRoom.freeze(), paramInt);
            return paramRoom;
        } catch (RemoteException paramRoom) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return null;
    }

    protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle) {
        if ((paramInt == 0) && (paramBundle != null)) {
            this.Iz = paramBundle.getBoolean("show_welcome_popup");
        }
        super.a(paramInt, paramIBinder, paramBundle);
    }

    public void a(IBinder paramIBinder, Bundle paramBundle) {
        if (isConnected()) {
        }
        try {
            ((IGamesService) eM()).a(paramIBinder, paramBundle);
            return;
        } catch (RemoteException paramIBinder) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<Requests.LoadRequestsResult> paramd, int paramInt1, int paramInt2, int paramInt3) {
        try {
            ((IGamesService) eM()).a(new RequestsLoadedBinderCallbacks(paramd), paramInt1, paramInt2, paramInt3);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<GamesMetadata.LoadExtendedGamesResult> paramd, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
        try {
            ((IGamesService) eM()).a(new ExtendedGamesLoadedBinderCallback(paramd), paramInt1, paramInt2, paramBoolean1, paramBoolean2);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<Players.LoadPlayersResult> paramd, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
        try {
            ((IGamesService) eM()).a(new PlayersLoadedBinderCallback(paramd), paramInt, paramBoolean1, paramBoolean2);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<TurnBasedMultiplayer.LoadMatchesResult> paramd, int paramInt, int[] paramArrayOfInt) {
        try {
            ((IGamesService) eM()).a(new TurnBasedMatchesLoadedBinderCallbacks(paramd), paramInt, paramArrayOfInt);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<Leaderboards.LoadScoresResult> paramd, LeaderboardScoreBuffer paramLeaderboardScoreBuffer, int paramInt1, int paramInt2) {
        try {
            ((IGamesService) eM()).a(new LeaderboardScoresLoadedBinderCallback(paramd), paramLeaderboardScoreBuffer.hD().hE(), paramInt1, paramInt2);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<TurnBasedMultiplayer.InitiateMatchResult> paramd, TurnBasedMatchConfig paramTurnBasedMatchConfig) {
        try {
            ((IGamesService) eM()).a(new TurnBasedMatchInitiatedBinderCallbacks(paramd), paramTurnBasedMatchConfig.getVariant(), paramTurnBasedMatchConfig.getMinPlayers(), paramTurnBasedMatchConfig.getInvitedPlayerIds(), paramTurnBasedMatchConfig.getAutoMatchCriteria());
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<Players.LoadPlayersResult> paramd, String paramString) {
        try {
            ((IGamesService) eM()).a(new PlayersLoadedBinderCallback(paramd), paramString);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<Achievements.UpdateAchievementResult> paramd, String paramString, int paramInt) {
        if (paramd == null) {
        }
        for (paramd = null; ; paramd = new AchievementUpdatedBinderCallback(paramd)) {
            try {
                ((IGamesService) eM()).a(paramd, paramString, paramInt, this.Iy.gU(), this.Iy.gT());
                return;
            } catch (RemoteException paramd) {
                GamesLog.g("GamesClientImpl", "service died");
            }
        }
    }

    public void a(a.d<Leaderboards.LoadScoresResult> paramd, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
        try {
            ((IGamesService) eM()).a(new LeaderboardScoresLoadedBinderCallback(paramd), paramString, paramInt1, paramInt2, paramInt3, paramBoolean);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<Players.LoadPlayersResult> paramd, String paramString, int paramInt, boolean paramBoolean) {
        try {
            ((IGamesService) eM()).a(new PlayersLoadedBinderCallback(paramd), paramString, paramInt, paramBoolean);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<Players.LoadPlayersResult> paramd, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
        if (!paramString.equals("playedWith")) {
            throw new IllegalArgumentException("Invalid player collection: " + paramString);
        }
        try {
            ((IGamesService) eM()).d(new PlayersLoadedBinderCallback(paramd), paramString, paramInt, paramBoolean1, paramBoolean2);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<GamesMetadata.LoadExtendedGamesResult> paramd, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
        try {
            ((IGamesService) eM()).a(new ExtendedGamesLoadedBinderCallback(paramd), paramString, paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<TurnBasedMultiplayer.LoadMatchesResult> paramd, String paramString, int paramInt, int[] paramArrayOfInt) {
        try {
            ((IGamesService) eM()).a(new TurnBasedMatchesLoadedBinderCallbacks(paramd), paramString, paramInt, paramArrayOfInt);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<Leaderboards.SubmitScoreResult> paramd, String paramString1, long paramLong, String paramString2) {
        if (paramd == null) {
        }
        for (paramd = null; ; paramd = new SubmitScoreBinderCallbacks(paramd)) {
            try {
                ((IGamesService) eM()).a(paramd, paramString1, paramLong, paramString2);
                return;
            } catch (RemoteException paramd) {
                GamesLog.g("GamesClientImpl", "service died");
            }
        }
    }

    public void a(a.d<TurnBasedMultiplayer.LeaveMatchResult> paramd, String paramString1, String paramString2) {
        try {
            ((IGamesService) eM()).c(new TurnBasedMatchLeftBinderCallbacks(paramd), paramString1, paramString2);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<Leaderboards.LoadPlayerScoreResult> paramd, String paramString1, String paramString2, int paramInt1, int paramInt2) {
        try {
            ((IGamesService) eM()).a(new PlayerLeaderboardScoreLoadedBinderCallback(paramd), paramString1, paramString2, paramInt1, paramInt2);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<Requests.LoadRequestsResult> paramd, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3) {
        try {
            ((IGamesService) eM()).a(new RequestsLoadedBinderCallbacks(paramd), paramString1, paramString2, paramInt1, paramInt2, paramInt3);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<Leaderboards.LoadScoresResult> paramd, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
        try {
            ((IGamesService) eM()).a(new LeaderboardScoresLoadedBinderCallback(paramd), paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramBoolean);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<Players.LoadPlayersResult> paramd, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
        if ((!paramString1.equals("playedWith")) && (!paramString1.equals("circled"))) {
            throw new IllegalArgumentException("Invalid player collection: " + paramString1);
        }
        try {
            ((IGamesService) eM()).a(new PlayersLoadedBinderCallback(paramd), paramString1, paramString2, paramInt, paramBoolean1, paramBoolean2);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<Leaderboards.LeaderboardMetadataResult> paramd, String paramString1, String paramString2, boolean paramBoolean) {
        try {
            ((IGamesService) eM()).b(new LeaderboardsLoadedBinderCallback(paramd), paramString1, paramString2, paramBoolean);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<Requests.UpdateRequestsResult> paramd, String paramString1, String paramString2, String[] paramArrayOfString) {
        try {
            ((IGamesService) eM()).a(new RequestsUpdatedBinderCallbacks(paramd), paramString1, paramString2, paramArrayOfString);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<Leaderboards.LeaderboardMetadataResult> paramd, String paramString, boolean paramBoolean) {
        try {
            ((IGamesService) eM()).c(new LeaderboardsLoadedBinderCallback(paramd), paramString, paramBoolean);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<TurnBasedMultiplayer.UpdateMatchResult> paramd, String paramString1, byte[] paramArrayOfByte, String paramString2, ParticipantResult[] paramArrayOfParticipantResult) {
        try {
            ((IGamesService) eM()).a(new TurnBasedMatchUpdatedBinderCallbacks(paramd), paramString1, paramArrayOfByte, paramString2, paramArrayOfParticipantResult);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<TurnBasedMultiplayer.UpdateMatchResult> paramd, String paramString, byte[] paramArrayOfByte, ParticipantResult[] paramArrayOfParticipantResult) {
        try {
            ((IGamesService) eM()).a(new TurnBasedMatchUpdatedBinderCallbacks(paramd), paramString, paramArrayOfByte, paramArrayOfParticipantResult);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<Requests.SendRequestResult> paramd, String paramString, String[] paramArrayOfString, int paramInt1, byte[] paramArrayOfByte, int paramInt2) {
        try {
            ((IGamesService) eM()).a(new RequestSentBinderCallbacks(paramd), paramString, paramArrayOfString, paramInt1, paramArrayOfByte, paramInt2);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<Players.LoadPlayersResult> paramd, boolean paramBoolean) {
        try {
            ((IGamesService) eM()).c(new PlayersLoadedBinderCallback(paramd), paramBoolean);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<Status> paramd, boolean paramBoolean, Bundle paramBundle) {
        try {
            ((IGamesService) eM()).a(new ContactSettingsUpdatedBinderCallback(paramd), paramBoolean, paramBundle);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(a.d<Players.LoadPlayersResult> paramd, String[] paramArrayOfString) {
        try {
            ((IGamesService) eM()).c(new PlayersLoadedBinderCallback(paramd), paramArrayOfString);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(OnInvitationReceivedListener paramOnInvitationReceivedListener) {
        try {
            paramOnInvitationReceivedListener = new InvitationReceivedBinderCallback(paramOnInvitationReceivedListener);
            ((IGamesService) eM()).a(paramOnInvitationReceivedListener, this.IE);
            return;
        } catch (RemoteException paramOnInvitationReceivedListener) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(RoomConfig paramRoomConfig) {
        try {
            RoomBinderCallbacks localRoomBinderCallbacks = new RoomBinderCallbacks(paramRoomConfig.getRoomUpdateListener(), paramRoomConfig.getRoomStatusUpdateListener(), paramRoomConfig.getMessageReceivedListener());
            ((IGamesService) eM()).a(localRoomBinderCallbacks, this.IC, paramRoomConfig.getVariant(), paramRoomConfig.getInvitedPlayerIds(), paramRoomConfig.getAutoMatchCriteria(), paramRoomConfig.isSocketEnabled(), this.IE);
            return;
        } catch (RemoteException paramRoomConfig) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(RoomUpdateListener paramRoomUpdateListener, String paramString) {
        try {
            ((IGamesService) eM()).c(new RoomBinderCallbacks(paramRoomUpdateListener), paramString);
            gE();
            return;
        } catch (RemoteException paramRoomUpdateListener) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener) {
        try {
            paramOnTurnBasedMatchUpdateReceivedListener = new MatchUpdateReceivedBinderCallback(paramOnTurnBasedMatchUpdateReceivedListener);
            ((IGamesService) eM()).b(paramOnTurnBasedMatchUpdateReceivedListener, this.IE);
            return;
        } catch (RemoteException paramOnTurnBasedMatchUpdateReceivedListener) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void a(OnRequestReceivedListener paramOnRequestReceivedListener) {
        try {
            paramOnRequestReceivedListener = new RequestReceivedBinderCallback(paramOnRequestReceivedListener);
            ((IGamesService) eM()).c(paramOnRequestReceivedListener, this.IE);
            return;
        } catch (RemoteException paramOnRequestReceivedListener) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    protected void a(fm paramfm, ff.e parame)
            throws RemoteException {
        String str = getContext().getResources().getConfiguration().locale.toString();
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.IF);
        localBundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.IA);
        localBundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.IB);
        localBundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.IH);
        localBundle.putInt("com.google.android.gms.games.key.sdkVariant", this.IG);
        paramfm.a(parame, 4452000, getContext().getPackageName(), this.wG, eL(), this.Iu, this.Iy.gU(), str, localBundle);
    }

    public Intent aA(String paramString) {
        try {
            paramString = ((IGamesService) eM()).aA(paramString);
            return paramString;
        } catch (RemoteException paramString) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return null;
    }

    public void aB(String paramString) {
        try {
            ((IGamesService) eM()).aI(paramString);
            return;
        } catch (RemoteException paramString) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void aX(int paramInt) {
        this.Iy.setGravity(paramInt);
    }

    public void aY(int paramInt) {
        try {
            ((IGamesService) eM()).aY(paramInt);
            return;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public Intent b(int paramInt1, int paramInt2, boolean paramBoolean) {
        try {
            Intent localIntent = ((IGamesService) eM()).b(paramInt1, paramInt2, paramBoolean);
            return localIntent;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return null;
    }

    public void b(a.d<Status> paramd) {
        try {
            ((IGamesService) eM()).a(new SignOutCompleteBinderCallbacks(paramd));
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void b(a.d<Players.LoadPlayersResult> paramd, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
        try {
            ((IGamesService) eM()).b(new PlayersLoadedBinderCallback(paramd), paramInt, paramBoolean1, paramBoolean2);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void b(a.d<Achievements.UpdateAchievementResult> paramd, String paramString) {
        if (paramd == null) {
        }
        for (paramd = null; ; paramd = new AchievementUpdatedBinderCallback(paramd)) {
            try {
                ((IGamesService) eM()).a(paramd, paramString, this.Iy.gU(), this.Iy.gT());
                return;
            } catch (RemoteException paramd) {
                GamesLog.g("GamesClientImpl", "service died");
            }
        }
    }

    public void b(a.d<Achievements.UpdateAchievementResult> paramd, String paramString, int paramInt) {
        if (paramd == null) {
        }
        for (paramd = null; ; paramd = new AchievementUpdatedBinderCallback(paramd)) {
            try {
                ((IGamesService) eM()).b(paramd, paramString, paramInt, this.Iy.gU(), this.Iy.gT());
                return;
            } catch (RemoteException paramd) {
                GamesLog.g("GamesClientImpl", "service died");
            }
        }
    }

    public void b(a.d<Leaderboards.LoadScoresResult> paramd, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
        try {
            ((IGamesService) eM()).b(new LeaderboardScoresLoadedBinderCallback(paramd), paramString, paramInt1, paramInt2, paramInt3, paramBoolean);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void b(a.d<GamesMetadata.LoadExtendedGamesResult> paramd, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
        try {
            ((IGamesService) eM()).a(new ExtendedGamesLoadedBinderCallback(paramd), paramString, paramInt, paramBoolean1, paramBoolean2);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void b(a.d<TurnBasedMultiplayer.InitiateMatchResult> paramd, String paramString1, String paramString2) {
        try {
            ((IGamesService) eM()).d(new TurnBasedMatchInitiatedBinderCallbacks(paramd), paramString1, paramString2);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void b(a.d<Leaderboards.LoadScoresResult> paramd, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
        try {
            ((IGamesService) eM()).b(new LeaderboardScoresLoadedBinderCallback(paramd), paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramBoolean);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void b(a.d<Achievements.LoadAchievementsResult> paramd, String paramString1, String paramString2, boolean paramBoolean) {
        try {
            ((IGamesService) eM()).a(new AchievementsLoadedBinderCallback(paramd), paramString1, paramString2, paramBoolean);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void b(a.d<Leaderboards.LeaderboardMetadataResult> paramd, String paramString, boolean paramBoolean) {
        try {
            ((IGamesService) eM()).d(new LeaderboardsLoadedBinderCallback(paramd), paramString, paramBoolean);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void b(a.d<Leaderboards.LeaderboardMetadataResult> paramd, boolean paramBoolean) {
        try {
            ((IGamesService) eM()).b(new LeaderboardsLoadedBinderCallback(paramd), paramBoolean);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void b(a.d<Requests.UpdateRequestsResult> paramd, String[] paramArrayOfString) {
        try {
            ((IGamesService) eM()).a(new RequestsUpdatedBinderCallbacks(paramd), paramArrayOfString);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void b(RoomConfig paramRoomConfig) {
        try {
            RoomBinderCallbacks localRoomBinderCallbacks = new RoomBinderCallbacks(paramRoomConfig.getRoomUpdateListener(), paramRoomConfig.getRoomStatusUpdateListener(), paramRoomConfig.getMessageReceivedListener());
            ((IGamesService) eM()).a(localRoomBinderCallbacks, this.IC, paramRoomConfig.getInvitationId(), paramRoomConfig.isSocketEnabled(), this.IE);
            return;
        } catch (RemoteException paramRoomConfig) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    protected void b(String... paramVarArgs) {
        int i = 0;
        int j = 0;
        boolean bool1 = false;
        if (i < paramVarArgs.length) {
            String str = paramVarArgs[i];
            boolean bool2;
            if (str.equals("https://www.googleapis.com/auth/games")) {
                bool2 = true;
            }
            for (; ; ) {
                i += 1;
                bool1 = bool2;
                break;
                bool2 = bool1;
                if (str.equals("https://www.googleapis.com/auth/games.firstparty")) {
                    j = 1;
                    bool2 = bool1;
                }
            }
        }
        if (j != 0) {
            if (!bool1) {
            }
            for (bool1 = true; ; bool1 = false) {
                fq.a(bool1, String.format("Cannot have both %s and %s!", new Object[]{"https://www.googleapis.com/auth/games", "https://www.googleapis.com/auth/games.firstparty"}));
                return;
            }
        }
        fq.a(bool1, String.format("Games APIs requires %s to function.", new Object[]{"https://www.googleapis.com/auth/games"}));
    }

    protected String bg() {
        return "com.google.android.gms.games.service.START";
    }

    protected String bh() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void c(a.d<Invitations.LoadInvitationsResult> paramd, int paramInt) {
        try {
            ((IGamesService) eM()).a(new InvitationsLoadedBinderCallback(paramd), paramInt);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void c(a.d<Players.LoadPlayersResult> paramd, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
        try {
            ((IGamesService) eM()).c(new PlayersLoadedBinderCallback(paramd), paramInt, paramBoolean1, paramBoolean2);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void c(a.d<Achievements.UpdateAchievementResult> paramd, String paramString) {
        if (paramd == null) {
        }
        for (paramd = null; ; paramd = new AchievementUpdatedBinderCallback(paramd)) {
            try {
                ((IGamesService) eM()).b(paramd, paramString, this.Iy.gU(), this.Iy.gT());
                return;
            } catch (RemoteException paramd) {
                GamesLog.g("GamesClientImpl", "service died");
            }
        }
    }

    public void c(a.d<Invitations.LoadInvitationsResult> paramd, String paramString, int paramInt) {
        try {
            ((IGamesService) eM()).b(new InvitationsLoadedBinderCallback(paramd), paramString, paramInt, false);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void c(a.d<GamesMetadata.LoadExtendedGamesResult> paramd, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
        try {
            ((IGamesService) eM()).c(new ExtendedGamesLoadedBinderCallback(paramd), paramString, paramInt, paramBoolean1, paramBoolean2);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void c(a.d<TurnBasedMultiplayer.InitiateMatchResult> paramd, String paramString1, String paramString2) {
        try {
            ((IGamesService) eM()).e(new TurnBasedMatchInitiatedBinderCallbacks(paramd), paramString1, paramString2);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void c(a.d<Notifications.GameMuteStatusChangeResult> paramd, String paramString, boolean paramBoolean) {
        try {
            ((IGamesService) eM()).a(new GameMuteStatusChangedBinderCallback(paramd), paramString, paramBoolean);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void c(a.d<Achievements.LoadAchievementsResult> paramd, boolean paramBoolean) {
        try {
            ((IGamesService) eM()).a(new AchievementsLoadedBinderCallback(paramd), paramBoolean);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void c(a.d<Requests.UpdateRequestsResult> paramd, String[] paramArrayOfString) {
        try {
            ((IGamesService) eM()).b(new RequestsUpdatedBinderCallbacks(paramd), paramArrayOfString);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void connect() {
        gk();
        super.connect();
    }

    public int d(byte[] paramArrayOfByte, String paramString) {
        try {
            int i = ((IGamesService) eM()).b(paramArrayOfByte, paramString, null);
            return i;
        } catch (RemoteException paramArrayOfByte) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return -1;
    }

    public void d(a.d<Players.LoadPlayersResult> paramd, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
        try {
            ((IGamesService) eM()).e(new PlayersLoadedBinderCallback(paramd), paramInt, paramBoolean1, paramBoolean2);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void d(a.d<TurnBasedMultiplayer.InitiateMatchResult> paramd, String paramString) {
        try {
            ((IGamesService) eM()).l(new TurnBasedMatchInitiatedBinderCallbacks(paramd), paramString);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void d(a.d<Requests.LoadRequestSummariesResult> paramd, String paramString, int paramInt) {
        try {
            ((IGamesService) eM()).a(new RequestSummariesLoadedBinderCallbacks(paramd), paramString, paramInt);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void d(a.d<Players.LoadPlayersResult> paramd, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
        try {
            ((IGamesService) eM()).b(new PlayersLoadedBinderCallback(paramd), paramString, paramInt, paramBoolean1, paramBoolean2);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public Bundle dG() {
        try {
            Bundle localBundle = ((IGamesService) eM()).dG();
            if (localBundle != null) {
                localBundle.setClassLoader(GamesClientImpl.class.getClassLoader());
            }
            return localBundle;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return null;
    }

    public void disconnect() {
        this.Iz = false;
        if (isConnected()) {
        }
        try {
            IGamesService localIGamesService = (IGamesService) eM();
            localIGamesService.gF();
            localIGamesService.o(this.IE);
            gE();
            super.disconnect();
            return;
        } catch (RemoteException localRemoteException) {
            for (; ; ) {
                GamesLog.g("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
    }

    public void e(a.d<Players.LoadExtendedPlayersResult> paramd, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
        try {
            ((IGamesService) eM()).d(new ExtendedPlayersLoadedBinderCallback(paramd), paramInt, paramBoolean1, paramBoolean2);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void e(a.d<TurnBasedMultiplayer.InitiateMatchResult> paramd, String paramString) {
        try {
            ((IGamesService) eM()).m(new TurnBasedMatchInitiatedBinderCallbacks(paramd), paramString);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void f(View paramView) {
        this.Iy.g(paramView);
    }

    public void f(a.d<TurnBasedMultiplayer.LeaveMatchResult> paramd, String paramString) {
        try {
            ((IGamesService) eM()).o(new TurnBasedMatchLeftBinderCallbacks(paramd), paramString);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void g(a.d<GamesMetadata.LoadGamesResult> paramd) {
        try {
            ((IGamesService) eM()).d(new GamesLoadedBinderCallback(paramd));
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void g(a.d<TurnBasedMultiplayer.CancelMatchResult> paramd, String paramString) {
        try {
            ((IGamesService) eM()).n(new TurnBasedMatchCanceledBinderCallbacks(paramd), paramString);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public int gA() {
        try {
            int i = ((IGamesService) eM()).gA();
            return i;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return 2;
    }

    public Intent gB() {
        try {
            Intent localIntent = ((IGamesService) eM()).gB();
            return localIntent;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return null;
    }

    public int gC() {
        try {
            int i = ((IGamesService) eM()).gC();
            return i;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return 2;
    }

    public int gD() {
        try {
            int i = ((IGamesService) eM()).gD();
            return i;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return 2;
    }

    public void gF() {
        if (isConnected()) {
        }
        try {
            ((IGamesService) eM()).gF();
            return;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public String gl() {
        try {
            String str = ((IGamesService) eM()).gl();
            return str;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return null;
    }

    public String gm() {
        try {
            String str = ((IGamesService) eM()).gm();
            return str;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return null;
    }

    /* Error */
    public com.google.android.gms.games.Player gn() {
        // Byte code:
        //   0: aload_0
        //   1: invokevirtual 1113	com/google/android/gms/games/internal/GamesClientImpl:bT	()V
        //   4: aload_0
        //   5: monitorenter
        //   6: aload_0
        //   7: getfield 530	com/google/android/gms/games/internal/GamesClientImpl:Iw	Lcom/google/android/gms/games/PlayerEntity;
        //   10: astore_1
        //   11: aload_1
        //   12: ifnonnull +51 -> 63
        //   15: new 1115	com/google/android/gms/games/PlayerBuffer
        //   18: dup
        //   19: aload_0
        //   20: invokevirtual 426	com/google/android/gms/games/internal/GamesClientImpl:eM	()Landroid/os/IInterface;
        //   23: checkcast 428	com/google/android/gms/games/internal/IGamesService
        //   26: invokeinterface 1119 1 0
        //   31: invokespecial 1120	com/google/android/gms/games/PlayerBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
        //   34: astore_1
        //   35: aload_1
        //   36: invokevirtual 1121	com/google/android/gms/games/PlayerBuffer:getCount	()I
        //   39: ifle +20 -> 59
        //   42: aload_0
        //   43: aload_1
        //   44: iconst_0
        //   45: invokevirtual 1124	com/google/android/gms/games/PlayerBuffer:get	(I)Lcom/google/android/gms/games/Player;
        //   48: invokeinterface 1127 1 0
        //   53: checkcast 1129	com/google/android/gms/games/PlayerEntity
        //   56: putfield 530	com/google/android/gms/games/internal/GamesClientImpl:Iw	Lcom/google/android/gms/games/PlayerEntity;
        //   59: aload_1
        //   60: invokevirtual 1130	com/google/android/gms/games/PlayerBuffer:close	()V
        //   63: aload_0
        //   64: monitorexit
        //   65: aload_0
        //   66: getfield 530	com/google/android/gms/games/internal/GamesClientImpl:Iw	Lcom/google/android/gms/games/PlayerEntity;
        //   69: areturn
        //   70: astore_2
        //   71: aload_1
        //   72: invokevirtual 1130	com/google/android/gms/games/PlayerBuffer:close	()V
        //   75: aload_2
        //   76: athrow
        //   77: astore_1
        //   78: ldc_w 434
        //   81: ldc_w 546
        //   84: invokestatic 549	com/google/android/gms/games/internal/GamesLog:g	(Ljava/lang/String;Ljava/lang/String;)V
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

    /* Error */
    public com.google.android.gms.games.Game go() {
        // Byte code:
        //   0: aload_0
        //   1: invokevirtual 1113	com/google/android/gms/games/internal/GamesClientImpl:bT	()V
        //   4: aload_0
        //   5: monitorenter
        //   6: aload_0
        //   7: getfield 1134	com/google/android/gms/games/internal/GamesClientImpl:Ix	Lcom/google/android/gms/games/GameEntity;
        //   10: astore_1
        //   11: aload_1
        //   12: ifnonnull +51 -> 63
        //   15: new 1136	com/google/android/gms/games/GameBuffer
        //   18: dup
        //   19: aload_0
        //   20: invokevirtual 426	com/google/android/gms/games/internal/GamesClientImpl:eM	()Landroid/os/IInterface;
        //   23: checkcast 428	com/google/android/gms/games/internal/IGamesService
        //   26: invokeinterface 1139 1 0
        //   31: invokespecial 1140	com/google/android/gms/games/GameBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
        //   34: astore_1
        //   35: aload_1
        //   36: invokevirtual 1141	com/google/android/gms/games/GameBuffer:getCount	()I
        //   39: ifle +20 -> 59
        //   42: aload_0
        //   43: aload_1
        //   44: iconst_0
        //   45: invokevirtual 1144	com/google/android/gms/games/GameBuffer:get	(I)Lcom/google/android/gms/games/Game;
        //   48: invokeinterface 1147 1 0
        //   53: checkcast 1149	com/google/android/gms/games/GameEntity
        //   56: putfield 1134	com/google/android/gms/games/internal/GamesClientImpl:Ix	Lcom/google/android/gms/games/GameEntity;
        //   59: aload_1
        //   60: invokevirtual 1150	com/google/android/gms/games/GameBuffer:close	()V
        //   63: aload_0
        //   64: monitorexit
        //   65: aload_0
        //   66: getfield 1134	com/google/android/gms/games/internal/GamesClientImpl:Ix	Lcom/google/android/gms/games/GameEntity;
        //   69: areturn
        //   70: astore_2
        //   71: aload_1
        //   72: invokevirtual 1150	com/google/android/gms/games/GameBuffer:close	()V
        //   75: aload_2
        //   76: athrow
        //   77: astore_1
        //   78: ldc_w 434
        //   81: ldc_w 546
        //   84: invokestatic 549	com/google/android/gms/games/internal/GamesLog:g	(Ljava/lang/String;Ljava/lang/String;)V
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

    public Intent gp() {
        try {
            Intent localIntent = ((IGamesService) eM()).gp();
            return localIntent;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return null;
    }

    public Intent gq() {
        try {
            Intent localIntent = ((IGamesService) eM()).gq();
            return localIntent;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return null;
    }

    public Intent gr() {
        try {
            Intent localIntent = ((IGamesService) eM()).gr();
            return localIntent;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return null;
    }

    public Intent gs() {
        try {
            Intent localIntent = ((IGamesService) eM()).gs();
            return localIntent;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return null;
    }

    public void gt() {
        try {
            ((IGamesService) eM()).p(this.IE);
            return;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void gu() {
        try {
            ((IGamesService) eM()).q(this.IE);
            return;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void gv() {
        try {
            ((IGamesService) eM()).r(this.IE);
            return;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public Intent gw() {
        try {
            Intent localIntent = ((IGamesService) eM()).gw();
            return localIntent;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return null;
    }

    public Intent gx() {
        try {
            Intent localIntent = ((IGamesService) eM()).gx();
            return localIntent;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return null;
    }

    public int gy() {
        try {
            int i = ((IGamesService) eM()).gy();
            return i;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return 4368;
    }

    public String gz() {
        try {
            String str = ((IGamesService) eM()).gz();
            return str;
        } catch (RemoteException localRemoteException) {
            GamesLog.g("GamesClientImpl", "service died");
        }
        return null;
    }

    public void h(a.d<Players.LoadOwnerCoverPhotoUrisResult> paramd) {
        try {
            ((IGamesService) eM()).j(new OwnerCoverPhotoUrisLoadedBinderCallback(paramd));
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void h(a.d<TurnBasedMultiplayer.LoadMatchResult> paramd, String paramString) {
        try {
            ((IGamesService) eM()).p(new TurnBasedMatchLoadedBinderCallbacks(paramd), paramString);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public RealTimeSocket i(String paramString1, String paramString2) {
        if ((paramString2 == null) || (!ParticipantUtils.aV(paramString2))) {
            throw new IllegalArgumentException("Bad participant ID");
        }
        RealTimeSocket localRealTimeSocket = (RealTimeSocket) this.Iv.get(paramString2);
        if (localRealTimeSocket != null) {
            paramString1 = localRealTimeSocket;
            if (!localRealTimeSocket.isClosed()) {
            }
        } else {
            paramString1 = aC(paramString2);
        }
        return paramString1;
    }

    public void i(a.d<Acls.LoadAclResult> paramd) {
        try {
            ((IGamesService) eM()).h(new NotifyAclLoadedBinderCallback(paramd));
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void i(a.d<GamesMetadata.LoadExtendedGamesResult> paramd, String paramString) {
        try {
            ((IGamesService) eM()).e(new ExtendedGamesLoadedBinderCallback(paramd), paramString);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void j(a.d<Notifications.ContactSettingLoadResult> paramd) {
        try {
            ((IGamesService) eM()).i(new ContactSettingsLoadedBinderCallback(paramd));
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void j(a.d<GamesMetadata.LoadGameInstancesResult> paramd, String paramString) {
        try {
            ((IGamesService) eM()).f(new GameInstancesLoadedBinderCallback(paramd), paramString);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void k(a.d<GamesMetadata.LoadGameSearchSuggestionsResult> paramd, String paramString) {
        try {
            ((IGamesService) eM()).q(new GameSearchSuggestionsLoadedBinderCallback(paramd), paramString);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void l(a.d<Invitations.LoadInvitationsResult> paramd, String paramString) {
        try {
            ((IGamesService) eM()).k(new InvitationsLoadedBinderCallback(paramd), paramString);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void l(String paramString, int paramInt) {
        try {
            ((IGamesService) eM()).l(paramString, paramInt);
            return;
        } catch (RemoteException paramString) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void m(a.d<Status> paramd, String paramString) {
        try {
            ((IGamesService) eM()).j(new NotifyAclUpdatedBinderCallback(paramd), paramString);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void m(String paramString, int paramInt) {
        try {
            ((IGamesService) eM()).m(paramString, paramInt);
            return;
        } catch (RemoteException paramString) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void n(a.d<Notifications.GameMuteStatusLoadResult> paramd, String paramString) {
        try {
            ((IGamesService) eM()).i(new GameMuteStatusLoadedBinderCallback(paramd), paramString);
            return;
        } catch (RemoteException paramd) {
            GamesLog.g("GamesClientImpl", "service died");
        }
    }

    public void onConnected(Bundle paramBundle) {
        if (this.Iz) {
            this.Iy.gS();
            this.Iz = false;
        }
    }

    public void onConnectionFailed(ConnectionResult paramConnectionResult) {
        this.Iz = false;
    }

    public void onConnectionSuspended(int paramInt) {
    }

    abstract class AbstractPeerStatusCallback
            extends GamesClientImpl.AbstractRoomStatusCallback {
        private final ArrayList<String> II = new ArrayList();

        AbstractPeerStatusCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString) {
            super(paramRoomStatusUpdateListener, paramDataHolder);
            int i = 0;
            int j = paramArrayOfString.length;
            while (i < j) {
                this.II.add(paramArrayOfString[i]);
                i += 1;
            }
        }

        protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom) {
            a(paramRoomStatusUpdateListener, paramRoom, this.II);
        }

        protected abstract void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList);
    }

    abstract class AbstractRoomCallback
            extends ff<IGamesService>.d<RoomUpdateListener> {
        AbstractRoomCallback(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder) {
            super(paramRoomUpdateListener, paramDataHolder);
        }

        protected void a(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder) {
            a(paramRoomUpdateListener, GamesClientImpl.a(GamesClientImpl.this, paramDataHolder), paramDataHolder.getStatusCode());
        }

        protected abstract void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt);
    }

    abstract class AbstractRoomStatusCallback
            extends ff<IGamesService>.d<RoomStatusUpdateListener> {
        AbstractRoomStatusCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder) {
            super(paramRoomStatusUpdateListener, paramDataHolder);
        }

        protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder) {
            a(paramRoomStatusUpdateListener, GamesClientImpl.a(GamesClientImpl.this, paramDataHolder));
        }

        protected abstract void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom);
    }

    final class AchievementUpdatedBinderCallback
            extends AbstractGamesCallbacks {
        private final a.d<Achievements.UpdateAchievementResult> wH;

        AchievementUpdatedBinderCallback() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void e(int paramInt, String paramString) {
            GamesClientImpl.this.a(new GamesClientImpl.AchievementUpdatedCallback(GamesClientImpl.this, this.wH, paramInt, paramString));
        }
    }

    final class AchievementUpdatedCallback
            extends ff<IGamesService>.b<a.d<Achievements.UpdateAchievementResult>>
            implements Achievements.UpdateAchievementResult {
        private final String IK;
        private final Status wJ;

        AchievementUpdatedCallback(int paramInt, String paramString) {
            super(paramInt);
            this.wJ = new Status(paramString);
            String str;
            this.IK = str;
        }

        protected void c(a.d<Achievements.UpdateAchievementResult> paramd) {
            paramd.b(this);
        }

        protected void dx() {
        }

        public String getAchievementId() {
            return this.IK;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    final class AchievementsLoadedBinderCallback
            extends AbstractGamesCallbacks {
        private final a.d<Achievements.LoadAchievementsResult> wH;

        AchievementsLoadedBinderCallback() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void b(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.AchievementsLoadedCallback(GamesClientImpl.this, this.wH, paramDataHolder));
        }
    }

    final class AchievementsLoadedCallback
            extends GamesClientImpl.ResultDataHolderCallback<a.d<Achievements.LoadAchievementsResult>>
            implements Achievements.LoadAchievementsResult {
        private final AchievementBuffer IL;

        AchievementsLoadedCallback(DataHolder paramDataHolder) {
            super(paramDataHolder, localDataHolder);
            this.IL = new AchievementBuffer(localDataHolder);
        }

        protected void a(a.d<Achievements.LoadAchievementsResult> paramd, DataHolder paramDataHolder) {
            paramd.b(this);
        }

        public AchievementBuffer getAchievements() {
            return this.IL;
        }
    }

    final class ConnectedToRoomCallback
            extends GamesClientImpl.AbstractRoomStatusCallback {
        ConnectedToRoomCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder) {
            super(paramRoomStatusUpdateListener, paramDataHolder);
        }

        public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom) {
            paramRoomStatusUpdateListener.onConnectedToRoom(paramRoom);
        }
    }

    final class ContactSettingsLoadedBinderCallback
            extends AbstractGamesCallbacks {
        private final a.d<Notifications.ContactSettingLoadResult> wH;

        ContactSettingsLoadedBinderCallback() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void B(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.ContactSettingsLoadedCallback(GamesClientImpl.this, this.wH, paramDataHolder));
        }
    }

    final class ContactSettingsLoadedCallback
            extends GamesClientImpl.ResultDataHolderCallback<a.d<Notifications.ContactSettingLoadResult>>
            implements Notifications.ContactSettingLoadResult {
        ContactSettingsLoadedCallback(DataHolder paramDataHolder) {
            super(paramDataHolder, localDataHolder);
        }

        protected void a(a.d<Notifications.ContactSettingLoadResult> paramd, DataHolder paramDataHolder) {
            paramd.b(this);
        }
    }

    final class ContactSettingsUpdatedBinderCallback
            extends AbstractGamesCallbacks {
        private final a.d<Status> wH;

        ContactSettingsUpdatedBinderCallback() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void aV(int paramInt) {
            GamesClientImpl.this.a(new GamesClientImpl.ContactSettingsUpdatedCallback(GamesClientImpl.this, this.wH, paramInt));
        }
    }

    final class ContactSettingsUpdatedCallback
            extends ff<IGamesService>.b<a.d<Status>> {
        private final Status wJ;

        ContactSettingsUpdatedCallback(int paramInt) {
            super(paramInt);
            int i;
            this.wJ = new Status(i);
        }

        protected void c(a.d<Status> paramd) {
            paramd.b(this.wJ);
        }

        protected void dx() {
        }
    }

    final class DisconnectedFromRoomCallback
            extends GamesClientImpl.AbstractRoomStatusCallback {
        DisconnectedFromRoomCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder) {
            super(paramRoomStatusUpdateListener, paramDataHolder);
        }

        public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom) {
            paramRoomStatusUpdateListener.onDisconnectedFromRoom(paramRoom);
        }
    }

    final class ExtendedGamesLoadedBinderCallback
            extends AbstractGamesCallbacks {
        private final a.d<GamesMetadata.LoadExtendedGamesResult> wH;

        ExtendedGamesLoadedBinderCallback() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void h(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.ExtendedGamesLoadedCallback(GamesClientImpl.this, this.wH, paramDataHolder));
        }
    }

    final class ExtendedGamesLoadedCallback
            extends GamesClientImpl.ResultDataHolderCallback<a.d<GamesMetadata.LoadExtendedGamesResult>>
            implements GamesMetadata.LoadExtendedGamesResult {
        private final ExtendedGameBuffer IM;

        ExtendedGamesLoadedCallback(DataHolder paramDataHolder) {
            super(paramDataHolder, localDataHolder);
            this.IM = new ExtendedGameBuffer(localDataHolder);
        }

        protected void a(a.d<GamesMetadata.LoadExtendedGamesResult> paramd, DataHolder paramDataHolder) {
            paramd.b(this);
        }
    }

    final class ExtendedPlayersLoadedBinderCallback
            extends AbstractGamesCallbacks {
        private final a.d<Players.LoadExtendedPlayersResult> wH;

        ExtendedPlayersLoadedBinderCallback() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void f(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.ExtendedPlayersLoadedCallback(GamesClientImpl.this, this.wH, paramDataHolder));
        }
    }

    final class ExtendedPlayersLoadedCallback
            extends GamesClientImpl.ResultDataHolderCallback<a.d<Players.LoadExtendedPlayersResult>>
            implements Players.LoadExtendedPlayersResult {
        private final ExtendedPlayerBuffer IN;

        ExtendedPlayersLoadedCallback(DataHolder paramDataHolder) {
            super(paramDataHolder, localDataHolder);
            this.IN = new ExtendedPlayerBuffer(localDataHolder);
        }

        protected void a(a.d<Players.LoadExtendedPlayersResult> paramd, DataHolder paramDataHolder) {
            paramd.b(this);
        }
    }

    final class GameInstancesLoadedBinderCallback
            extends AbstractGamesCallbacks {
        private final a.d<GamesMetadata.LoadGameInstancesResult> wH;

        GameInstancesLoadedBinderCallback() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void i(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.GameInstancesLoadedCallback(GamesClientImpl.this, this.wH, paramDataHolder));
        }
    }

    final class GameInstancesLoadedCallback
            extends GamesClientImpl.ResultDataHolderCallback<a.d<GamesMetadata.LoadGameInstancesResult>>
            implements GamesMetadata.LoadGameInstancesResult {
        private final GameInstanceBuffer IO;

        GameInstancesLoadedCallback(DataHolder paramDataHolder) {
            super(paramDataHolder, localDataHolder);
            this.IO = new GameInstanceBuffer(localDataHolder);
        }

        protected void a(a.d<GamesMetadata.LoadGameInstancesResult> paramd, DataHolder paramDataHolder) {
            paramd.b(this);
        }
    }

    final class GameMuteStatusChangedBinderCallback
            extends AbstractGamesCallbacks {
        private final a.d<Notifications.GameMuteStatusChangeResult> wH;

        GameMuteStatusChangedBinderCallback() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void a(int paramInt, String paramString, boolean paramBoolean) {
            GamesClientImpl.this.a(new GamesClientImpl.GameMuteStatusChangedCallback(GamesClientImpl.this, this.wH, paramInt, paramString, paramBoolean));
        }
    }

    final class GameMuteStatusChangedCallback
            extends ff<IGamesService>.b<a.d<Notifications.GameMuteStatusChangeResult>>
            implements Notifications.GameMuteStatusChangeResult {
        private final String IP;
        private final boolean IQ;
        private final Status wJ;

        public GameMuteStatusChangedCallback(int paramInt, String paramString, boolean paramBoolean) {
            super(paramInt);
            this.wJ = new Status(paramString);
            this.IP = paramBoolean;
            boolean bool;
            this.IQ = bool;
        }

        protected void c(a.d<Notifications.GameMuteStatusChangeResult> paramd) {
            paramd.b(this);
        }

        protected void dx() {
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    final class GameMuteStatusLoadedBinderCallback
            extends AbstractGamesCallbacks {
        private final a.d<Notifications.GameMuteStatusLoadResult> wH;

        GameMuteStatusLoadedBinderCallback() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void z(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.GameMuteStatusLoadedCallback(GamesClientImpl.this, this.wH, paramDataHolder));
        }
    }

    final class GameMuteStatusLoadedCallback
            extends ff<IGamesService>.b<a.d<Notifications.GameMuteStatusLoadResult>>
            implements Notifications.GameMuteStatusLoadResult {
        private final String IP;
        private final boolean IQ;
        private final Status wJ;

        /* Error */
        public GameMuteStatusLoadedCallback(DataHolder paramDataHolder) {
            // Byte code:
            //   0: aload_0
            //   1: aload_1
            //   2: putfield 22	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadedCallback:IJ	Lcom/google/android/gms/games/internal/GamesClientImpl;
            //   5: aload_0
            //   6: aload_1
            //   7: aload_2
            //   8: invokespecial 25	com/google/android/gms/internal/ff$b:<init>	(Lcom/google/android/gms/internal/ff;Ljava/lang/Object;)V
            //   11: aload_0
            //   12: new 27	com/google/android/gms/common/api/Status
            //   15: dup
            //   16: aload_3
            //   17: invokevirtual 33	com/google/android/gms/common/data/DataHolder:getStatusCode	()I
            //   20: invokespecial 36	com/google/android/gms/common/api/Status:<init>	(I)V
            //   23: putfield 38	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadedCallback:wJ	Lcom/google/android/gms/common/api/Status;
            //   26: aload_3
            //   27: invokevirtual 41	com/google/android/gms/common/data/DataHolder:getCount	()I
            //   30: ifle +32 -> 62
            //   33: aload_0
            //   34: aload_3
            //   35: ldc 43
            //   37: iconst_0
            //   38: iconst_0
            //   39: invokevirtual 47	com/google/android/gms/common/data/DataHolder:getString	(Ljava/lang/String;II)Ljava/lang/String;
            //   42: putfield 49	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadedCallback:IP	Ljava/lang/String;
            //   45: aload_0
            //   46: aload_3
            //   47: ldc 51
            //   49: iconst_0
            //   50: iconst_0
            //   51: invokevirtual 55	com/google/android/gms/common/data/DataHolder:getBoolean	(Ljava/lang/String;II)Z
            //   54: putfield 57	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadedCallback:IQ	Z
            //   57: aload_3
            //   58: invokevirtual 61	com/google/android/gms/common/data/DataHolder:close	()V
            //   61: return
            //   62: aload_0
            //   63: aconst_null
            //   64: putfield 49	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadedCallback:IP	Ljava/lang/String;
            //   67: aload_0
            //   68: iconst_0
            //   69: putfield 57	com/google/android/gms/games/internal/GamesClientImpl$GameMuteStatusLoadedCallback:IQ	Z
            //   72: goto -15 -> 57
            //   75: astore_1
            //   76: aload_3
            //   77: invokevirtual 61	com/google/android/gms/common/data/DataHolder:close	()V
            //   80: aload_1
            //   81: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	82	0	this	GameMuteStatusLoadedCallback
            //   0	82	1	this$1	GamesClientImpl
            //   0	82	2	paramDataHolder	DataHolder
            //   16	61	3	localObject	Object
            // Exception table:
            //   from	to	target	type
            //   11	57	75	finally
            //   62	72	75	finally
        }

        protected void c(a.d<Notifications.GameMuteStatusLoadResult> paramd) {
            paramd.b(this);
        }

        protected void dx() {
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    final class GameSearchSuggestionsLoadedBinderCallback
            extends AbstractGamesCallbacks {
        private final a.d<GamesMetadata.LoadGameSearchSuggestionsResult> wH;

        GameSearchSuggestionsLoadedBinderCallback() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void j(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.GameSearchSuggestionsLoadedCallback(GamesClientImpl.this, this.wH, paramDataHolder));
        }
    }

    final class GameSearchSuggestionsLoadedCallback
            extends GamesClientImpl.ResultDataHolderCallback<a.d<GamesMetadata.LoadGameSearchSuggestionsResult>>
            implements GamesMetadata.LoadGameSearchSuggestionsResult {
        private final DataHolder IR;

        GameSearchSuggestionsLoadedCallback(DataHolder paramDataHolder) {
            super(paramDataHolder, localDataHolder);
            this.IR = localDataHolder;
        }

        protected void a(a.d<GamesMetadata.LoadGameSearchSuggestionsResult> paramd, DataHolder paramDataHolder) {
            paramd.b(this);
        }
    }

    final class GamesLoadedBinderCallback
            extends AbstractGamesCallbacks {
        private final a.d<GamesMetadata.LoadGamesResult> wH;

        GamesLoadedBinderCallback() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void g(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.GamesLoadedCallback(GamesClientImpl.this, this.wH, paramDataHolder));
        }
    }

    final class GamesLoadedCallback
            extends GamesClientImpl.ResultDataHolderCallback<a.d<GamesMetadata.LoadGamesResult>>
            implements GamesMetadata.LoadGamesResult {
        private final GameBuffer IS;

        GamesLoadedCallback(DataHolder paramDataHolder) {
            super(paramDataHolder, localDataHolder);
            this.IS = new GameBuffer(localDataHolder);
        }

        protected void a(a.d<GamesMetadata.LoadGamesResult> paramd, DataHolder paramDataHolder) {
            paramd.b(this);
        }

        public GameBuffer getGames() {
            return this.IS;
        }
    }

    final class InvitationReceivedBinderCallback
            extends AbstractGamesCallbacks {
        private final OnInvitationReceivedListener IT;

        InvitationReceivedBinderCallback(OnInvitationReceivedListener paramOnInvitationReceivedListener) {
            this.IT = paramOnInvitationReceivedListener;
        }

        public void l(DataHolder paramDataHolder) {
            InvitationBuffer localInvitationBuffer = new InvitationBuffer(paramDataHolder);
            paramDataHolder = null;
            try {
                if (localInvitationBuffer.getCount() > 0) {
                    paramDataHolder = (Invitation) ((Invitation) localInvitationBuffer.get(0)).freeze();
                }
                localInvitationBuffer.close();
                if (paramDataHolder != null) {
                    GamesClientImpl.this.a(new GamesClientImpl.InvitationReceivedCallback(GamesClientImpl.this, this.IT, paramDataHolder));
                }
                return;
            } finally {
                localInvitationBuffer.close();
            }
        }

        public void onInvitationRemoved(String paramString) {
            GamesClientImpl.this.a(new GamesClientImpl.InvitationRemovedCallback(GamesClientImpl.this, this.IT, paramString));
        }
    }

    final class InvitationReceivedCallback
            extends ff<IGamesService>.b<OnInvitationReceivedListener> {
        private final Invitation IU;

        InvitationReceivedCallback(OnInvitationReceivedListener paramOnInvitationReceivedListener, Invitation paramInvitation) {
            super(paramOnInvitationReceivedListener);
            this.IU = paramInvitation;
        }

        protected void b(OnInvitationReceivedListener paramOnInvitationReceivedListener) {
            paramOnInvitationReceivedListener.onInvitationReceived(this.IU);
        }

        protected void dx() {
        }
    }

    final class InvitationRemovedCallback
            extends ff<IGamesService>.b<OnInvitationReceivedListener> {
        private final String IV;

        InvitationRemovedCallback(OnInvitationReceivedListener paramOnInvitationReceivedListener, String paramString) {
            super(paramOnInvitationReceivedListener);
            this.IV = paramString;
        }

        protected void b(OnInvitationReceivedListener paramOnInvitationReceivedListener) {
            paramOnInvitationReceivedListener.onInvitationRemoved(this.IV);
        }

        protected void dx() {
        }
    }

    final class InvitationsLoadedBinderCallback
            extends AbstractGamesCallbacks {
        private final a.d<Invitations.LoadInvitationsResult> wH;

        InvitationsLoadedBinderCallback() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void k(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.InvitationsLoadedCallback(GamesClientImpl.this, this.wH, paramDataHolder));
        }
    }

    final class InvitationsLoadedCallback
            extends GamesClientImpl.ResultDataHolderCallback<a.d<Invitations.LoadInvitationsResult>>
            implements Invitations.LoadInvitationsResult {
        private final InvitationBuffer IW;

        InvitationsLoadedCallback(DataHolder paramDataHolder) {
            super(paramDataHolder, localDataHolder);
            this.IW = new InvitationBuffer(localDataHolder);
        }

        protected void a(a.d<Invitations.LoadInvitationsResult> paramd, DataHolder paramDataHolder) {
            paramd.b(this);
        }

        public InvitationBuffer getInvitations() {
            return this.IW;
        }
    }

    final class JoinedRoomCallback
            extends GamesClientImpl.AbstractRoomCallback {
        public JoinedRoomCallback(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder) {
            super(paramRoomUpdateListener, paramDataHolder);
        }

        public void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt) {
            paramRoomUpdateListener.onJoinedRoom(paramInt, paramRoom);
        }
    }

    final class LeaderboardScoresLoadedBinderCallback
            extends AbstractGamesCallbacks {
        private final a.d<Leaderboards.LoadScoresResult> wH;

        LeaderboardScoresLoadedBinderCallback() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void a(DataHolder paramDataHolder1, DataHolder paramDataHolder2) {
            GamesClientImpl.this.a(new GamesClientImpl.LeaderboardScoresLoadedCallback(GamesClientImpl.this, this.wH, paramDataHolder1, paramDataHolder2));
        }
    }

    final class LeaderboardScoresLoadedCallback
            extends GamesClientImpl.ResultDataHolderCallback<a.d<Leaderboards.LoadScoresResult>>
            implements Leaderboards.LoadScoresResult {
        private final LeaderboardEntity IX;
        private final LeaderboardScoreBuffer IY;

        /* Error */
        LeaderboardScoresLoadedCallback(DataHolder paramDataHolder1, DataHolder paramDataHolder2) {
            // Byte code:
            //   0: aload_0
            //   1: aload_1
            //   2: putfield 20	com/google/android/gms/games/internal/GamesClientImpl$LeaderboardScoresLoadedCallback:IJ	Lcom/google/android/gms/games/internal/GamesClientImpl;
            //   5: aload_0
            //   6: aload_1
            //   7: aload_2
            //   8: aload 4
            //   10: invokespecial 23	com/google/android/gms/games/internal/GamesClientImpl$ResultDataHolderCallback:<init>	(Lcom/google/android/gms/games/internal/GamesClientImpl;Lcom/google/android/gms/common/api/a$d;Lcom/google/android/gms/common/data/DataHolder;)V
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
            //   43: checkcast 44	com/google/android/gms/games/leaderboard/LeaderboardEntity
            //   46: putfield 46	com/google/android/gms/games/internal/GamesClientImpl$LeaderboardScoresLoadedCallback:IX	Lcom/google/android/gms/games/leaderboard/LeaderboardEntity;
            //   49: aload_1
            //   50: invokevirtual 50	com/google/android/gms/games/leaderboard/LeaderboardBuffer:close	()V
            //   53: aload_0
            //   54: new 52	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer
            //   57: dup
            //   58: aload 4
            //   60: invokespecial 53	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
            //   63: putfield 55	com/google/android/gms/games/internal/GamesClientImpl$LeaderboardScoresLoadedCallback:IY	Lcom/google/android/gms/games/leaderboard/LeaderboardScoreBuffer;
            //   66: return
            //   67: aload_0
            //   68: aconst_null
            //   69: putfield 46	com/google/android/gms/games/internal/GamesClientImpl$LeaderboardScoresLoadedCallback:IX	Lcom/google/android/gms/games/leaderboard/LeaderboardEntity;
            //   72: goto -23 -> 49
            //   75: astore_2
            //   76: aload_1
            //   77: invokevirtual 50	com/google/android/gms/games/leaderboard/LeaderboardBuffer:close	()V
            //   80: aload_2
            //   81: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	82	0	this	LeaderboardScoresLoadedCallback
            //   0	82	1	this$1	GamesClientImpl
            //   0	82	2	paramDataHolder1	DataHolder
            //   0	82	3	paramDataHolder2	DataHolder
            //   8	51	4	localDataHolder	DataHolder
            // Exception table:
            //   from	to	target	type
            //   22	49	75	finally
            //   67	72	75	finally
        }

        protected void a(a.d<Leaderboards.LoadScoresResult> paramd, DataHolder paramDataHolder) {
            paramd.b(this);
        }

        public Leaderboard getLeaderboard() {
            return this.IX;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.IY;
        }
    }

    final class LeaderboardsLoadedBinderCallback
            extends AbstractGamesCallbacks {
        private final a.d<Leaderboards.LeaderboardMetadataResult> wH;

        LeaderboardsLoadedBinderCallback() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void c(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.LeaderboardsLoadedCallback(GamesClientImpl.this, this.wH, paramDataHolder));
        }
    }

    final class LeaderboardsLoadedCallback
            extends GamesClientImpl.ResultDataHolderCallback<a.d<Leaderboards.LeaderboardMetadataResult>>
            implements Leaderboards.LeaderboardMetadataResult {
        private final LeaderboardBuffer IZ;

        LeaderboardsLoadedCallback(DataHolder paramDataHolder) {
            super(paramDataHolder, localDataHolder);
            this.IZ = new LeaderboardBuffer(localDataHolder);
        }

        protected void a(a.d<Leaderboards.LeaderboardMetadataResult> paramd, DataHolder paramDataHolder) {
            paramd.b(this);
        }

        public LeaderboardBuffer getLeaderboards() {
            return this.IZ;
        }
    }

    final class LeftRoomCallback
            extends ff<IGamesService>.b<RoomUpdateListener> {
        private final int Ah;
        private final String Ja;

        LeftRoomCallback(RoomUpdateListener paramRoomUpdateListener, int paramInt, String paramString) {
            super(paramRoomUpdateListener);
            this.Ah = paramInt;
            this.Ja = paramString;
        }

        public void a(RoomUpdateListener paramRoomUpdateListener) {
            paramRoomUpdateListener.onLeftRoom(this.Ah, this.Ja);
        }

        protected void dx() {
        }
    }

    final class MatchRemovedCallback
            extends ff<IGamesService>.b<OnTurnBasedMatchUpdateReceivedListener> {
        private final String Jb;

        MatchRemovedCallback(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener, String paramString) {
            super(paramOnTurnBasedMatchUpdateReceivedListener);
            this.Jb = paramString;
        }

        protected void b(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener) {
            paramOnTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.Jb);
        }

        protected void dx() {
        }
    }

    final class MatchUpdateReceivedBinderCallback
            extends AbstractGamesCallbacks {
        private final OnTurnBasedMatchUpdateReceivedListener Jc;

        MatchUpdateReceivedBinderCallback(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener) {
            this.Jc = paramOnTurnBasedMatchUpdateReceivedListener;
        }

        public void onTurnBasedMatchRemoved(String paramString) {
            GamesClientImpl.this.a(new GamesClientImpl.MatchRemovedCallback(GamesClientImpl.this, this.Jc, paramString));
        }

        public void r(DataHolder paramDataHolder) {
            TurnBasedMatchBuffer localTurnBasedMatchBuffer = new TurnBasedMatchBuffer(paramDataHolder);
            paramDataHolder = null;
            try {
                if (localTurnBasedMatchBuffer.getCount() > 0) {
                    paramDataHolder = (TurnBasedMatch) ((TurnBasedMatch) localTurnBasedMatchBuffer.get(0)).freeze();
                }
                localTurnBasedMatchBuffer.close();
                if (paramDataHolder != null) {
                    GamesClientImpl.this.a(new GamesClientImpl.MatchUpdateReceivedCallback(GamesClientImpl.this, this.Jc, paramDataHolder));
                }
                return;
            } finally {
                localTurnBasedMatchBuffer.close();
            }
        }
    }

    final class MatchUpdateReceivedCallback
            extends ff<IGamesService>.b<OnTurnBasedMatchUpdateReceivedListener> {
        private final TurnBasedMatch Jd;

        MatchUpdateReceivedCallback(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener, TurnBasedMatch paramTurnBasedMatch) {
            super(paramOnTurnBasedMatchUpdateReceivedListener);
            this.Jd = paramTurnBasedMatch;
        }

        protected void b(OnTurnBasedMatchUpdateReceivedListener paramOnTurnBasedMatchUpdateReceivedListener) {
            paramOnTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.Jd);
        }

        protected void dx() {
        }
    }

    final class MessageReceivedCallback
            extends ff<IGamesService>.b<RealTimeMessageReceivedListener> {
        private final RealTimeMessage Je;

        MessageReceivedCallback(RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener, RealTimeMessage paramRealTimeMessage) {
            super(paramRealTimeMessageReceivedListener);
            this.Je = paramRealTimeMessage;
        }

        public void a(RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener) {
            if (paramRealTimeMessageReceivedListener != null) {
                paramRealTimeMessageReceivedListener.onRealTimeMessageReceived(this.Je);
            }
        }

        protected void dx() {
        }
    }

    final class NotifyAclLoadedBinderCallback
            extends AbstractGamesCallbacks {
        private final a.d<Acls.LoadAclResult> wH;

        NotifyAclLoadedBinderCallback() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void A(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.NotifyAclLoadedCallback(GamesClientImpl.this, this.wH, paramDataHolder));
        }
    }

    final class NotifyAclLoadedCallback
            extends GamesClientImpl.ResultDataHolderCallback<a.d<Acls.LoadAclResult>>
            implements Acls.LoadAclResult {
        NotifyAclLoadedCallback(DataHolder paramDataHolder) {
            super(paramDataHolder, localDataHolder);
        }

        protected void a(a.d<Acls.LoadAclResult> paramd, DataHolder paramDataHolder) {
            paramd.b(this);
        }
    }

    final class NotifyAclUpdatedBinderCallback
            extends AbstractGamesCallbacks {
        private final a.d<Status> wH;

        NotifyAclUpdatedBinderCallback() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void aU(int paramInt) {
            GamesClientImpl.this.a(new GamesClientImpl.NotifyAclUpdatedCallback(GamesClientImpl.this, this.wH, paramInt));
        }
    }

    final class NotifyAclUpdatedCallback
            extends ff<IGamesService>.b<a.d<Status>> {
        private final Status wJ;

        NotifyAclUpdatedCallback(int paramInt) {
            super(paramInt);
            int i;
            this.wJ = new Status(i);
        }

        protected void c(a.d<Status> paramd) {
            paramd.b(this.wJ);
        }

        protected void dx() {
        }
    }

    final class OwnerCoverPhotoUrisLoadedBinderCallback
            extends AbstractGamesCallbacks {
        private final a.d<Players.LoadOwnerCoverPhotoUrisResult> wH;

        OwnerCoverPhotoUrisLoadedBinderCallback() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void c(int paramInt, Bundle paramBundle) {
            paramBundle.setClassLoader(getClass().getClassLoader());
            GamesClientImpl.this.a(new GamesClientImpl.OwnerCoverPhotoUrisLoadedCallback(GamesClientImpl.this, this.wH, paramInt, paramBundle));
        }
    }

    final class OwnerCoverPhotoUrisLoadedCallback
            extends ff<IGamesService>.b<a.d<Players.LoadOwnerCoverPhotoUrisResult>>
            implements Players.LoadOwnerCoverPhotoUrisResult {
        private final Bundle Jf;
        private final Status wJ;

        OwnerCoverPhotoUrisLoadedCallback(int paramInt, Bundle paramBundle) {
            super(paramInt);
            this.wJ = new Status(paramBundle);
            Bundle localBundle;
            this.Jf = localBundle;
        }

        protected void c(a.d<Players.LoadOwnerCoverPhotoUrisResult> paramd) {
            paramd.b(this);
        }

        protected void dx() {
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    final class P2PConnectedCallback
            extends ff<IGamesService>.b<RoomStatusUpdateListener> {
        private final String Jg;

        P2PConnectedCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, String paramString) {
            super(paramRoomStatusUpdateListener);
            this.Jg = paramString;
        }

        public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener) {
            if (paramRoomStatusUpdateListener != null) {
                paramRoomStatusUpdateListener.onP2PConnected(this.Jg);
            }
        }

        protected void dx() {
        }
    }

    final class P2PDisconnectedCallback
            extends ff<IGamesService>.b<RoomStatusUpdateListener> {
        private final String Jg;

        P2PDisconnectedCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, String paramString) {
            super(paramRoomStatusUpdateListener);
            this.Jg = paramString;
        }

        public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener) {
            if (paramRoomStatusUpdateListener != null) {
                paramRoomStatusUpdateListener.onP2PDisconnected(this.Jg);
            }
        }

        protected void dx() {
        }
    }

    final class PeerConnectedCallback
            extends GamesClientImpl.AbstractPeerStatusCallback {
        PeerConnectedCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString) {
            super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
        }

        protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList) {
            paramRoomStatusUpdateListener.onPeersConnected(paramRoom, paramArrayList);
        }
    }

    final class PeerDeclinedCallback
            extends GamesClientImpl.AbstractPeerStatusCallback {
        PeerDeclinedCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString) {
            super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
        }

        protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList) {
            paramRoomStatusUpdateListener.onPeerDeclined(paramRoom, paramArrayList);
        }
    }

    final class PeerDisconnectedCallback
            extends GamesClientImpl.AbstractPeerStatusCallback {
        PeerDisconnectedCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString) {
            super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
        }

        protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList) {
            paramRoomStatusUpdateListener.onPeersDisconnected(paramRoom, paramArrayList);
        }
    }

    final class PeerInvitedToRoomCallback
            extends GamesClientImpl.AbstractPeerStatusCallback {
        PeerInvitedToRoomCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString) {
            super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
        }

        protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList) {
            paramRoomStatusUpdateListener.onPeerInvitedToRoom(paramRoom, paramArrayList);
        }
    }

    final class PeerJoinedRoomCallback
            extends GamesClientImpl.AbstractPeerStatusCallback {
        PeerJoinedRoomCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString) {
            super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
        }

        protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList) {
            paramRoomStatusUpdateListener.onPeerJoined(paramRoom, paramArrayList);
        }
    }

    final class PeerLeftRoomCallback
            extends GamesClientImpl.AbstractPeerStatusCallback {
        PeerLeftRoomCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder, String[] paramArrayOfString) {
            super(paramRoomStatusUpdateListener, paramDataHolder, paramArrayOfString);
        }

        protected void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom, ArrayList<String> paramArrayList) {
            paramRoomStatusUpdateListener.onPeerLeft(paramRoom, paramArrayList);
        }
    }

    final class PlayerLeaderboardScoreLoadedBinderCallback
            extends AbstractGamesCallbacks {
        private final a.d<Leaderboards.LoadPlayerScoreResult> wH;

        PlayerLeaderboardScoreLoadedBinderCallback() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void C(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.PlayerLeaderboardScoreLoadedCallback(GamesClientImpl.this, this.wH, paramDataHolder));
        }
    }

    final class PlayerLeaderboardScoreLoadedCallback
            extends ff<IGamesService>.d<a.d<Leaderboards.LoadPlayerScoreResult>>
            implements Leaderboards.LoadPlayerScoreResult {
        private final LeaderboardScoreEntity Jh;
        private final Status wJ;

        /* Error */
        PlayerLeaderboardScoreLoadedCallback(DataHolder paramDataHolder) {
            // Byte code:
            //   0: aload_0
            //   1: aload_1
            //   2: putfield 20	com/google/android/gms/games/internal/GamesClientImpl$PlayerLeaderboardScoreLoadedCallback:IJ	Lcom/google/android/gms/games/internal/GamesClientImpl;
            //   5: aload_0
            //   6: aload_1
            //   7: aload_2
            //   8: aload_3
            //   9: invokespecial 23	com/google/android/gms/internal/ff$d:<init>	(Lcom/google/android/gms/internal/ff;Ljava/lang/Object;Lcom/google/android/gms/common/data/DataHolder;)V
            //   12: aload_0
            //   13: new 25	com/google/android/gms/common/api/Status
            //   16: dup
            //   17: aload_3
            //   18: invokevirtual 31	com/google/android/gms/common/data/DataHolder:getStatusCode	()I
            //   21: invokespecial 34	com/google/android/gms/common/api/Status:<init>	(I)V
            //   24: putfield 36	com/google/android/gms/games/internal/GamesClientImpl$PlayerLeaderboardScoreLoadedCallback:wJ	Lcom/google/android/gms/common/api/Status;
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
            //   54: checkcast 56	com/google/android/gms/games/leaderboard/LeaderboardScoreEntity
            //   57: putfield 58	com/google/android/gms/games/internal/GamesClientImpl$PlayerLeaderboardScoreLoadedCallback:Jh	Lcom/google/android/gms/games/leaderboard/LeaderboardScoreEntity;
            //   60: aload_1
            //   61: invokevirtual 62	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:close	()V
            //   64: return
            //   65: aload_0
            //   66: aconst_null
            //   67: putfield 58	com/google/android/gms/games/internal/GamesClientImpl$PlayerLeaderboardScoreLoadedCallback:Jh	Lcom/google/android/gms/games/leaderboard/LeaderboardScoreEntity;
            //   70: goto -10 -> 60
            //   73: astore_2
            //   74: aload_1
            //   75: invokevirtual 62	com/google/android/gms/games/leaderboard/LeaderboardScoreBuffer:close	()V
            //   78: aload_2
            //   79: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	80	0	this	PlayerLeaderboardScoreLoadedCallback
            //   0	80	1	this$1	GamesClientImpl
            //   0	80	2	paramDataHolder	DataHolder
            //   8	24	3	localDataHolder	DataHolder
            // Exception table:
            //   from	to	target	type
            //   36	60	73	finally
            //   65	70	73	finally
        }

        protected void a(a.d<Leaderboards.LoadPlayerScoreResult> paramd, DataHolder paramDataHolder) {
            paramd.b(this);
        }

        public LeaderboardScore getScore() {
            return this.Jh;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    final class PlayersLoadedBinderCallback
            extends AbstractGamesCallbacks {
        private final a.d<Players.LoadPlayersResult> wH;

        PlayersLoadedBinderCallback() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void e(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.PlayersLoadedCallback(GamesClientImpl.this, this.wH, paramDataHolder));
        }
    }

    final class PlayersLoadedCallback
            extends GamesClientImpl.ResultDataHolderCallback<a.d<Players.LoadPlayersResult>>
            implements Players.LoadPlayersResult {
        private final PlayerBuffer Ji;

        PlayersLoadedCallback(DataHolder paramDataHolder) {
            super(paramDataHolder, localDataHolder);
            this.Ji = new PlayerBuffer(localDataHolder);
        }

        protected void a(a.d<Players.LoadPlayersResult> paramd, DataHolder paramDataHolder) {
            paramd.b(this);
        }

        public PlayerBuffer getPlayers() {
            return this.Ji;
        }
    }

    final class RealTimeMessageSentCallback
            extends ff<IGamesService>.b<RealTimeMultiplayer.ReliableMessageSentCallback> {
        private final int Ah;
        private final String Jj;
        private final int Jk;

        RealTimeMessageSentCallback(RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback, int paramInt1, int paramInt2, String paramString) {
            super(paramReliableMessageSentCallback);
            this.Ah = paramInt1;
            this.Jk = paramInt2;
            this.Jj = paramString;
        }

        public void a(RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback) {
            if (paramReliableMessageSentCallback != null) {
                paramReliableMessageSentCallback.onRealTimeMessageSent(this.Ah, this.Jk, this.Jj);
            }
        }

        protected void dx() {
        }
    }

    final class RealTimeReliableMessageBinderCallbacks
            extends AbstractGamesCallbacks {
        final RealTimeMultiplayer.ReliableMessageSentCallback Jl;

        public RealTimeReliableMessageBinderCallbacks(RealTimeMultiplayer.ReliableMessageSentCallback paramReliableMessageSentCallback) {
            this.Jl = paramReliableMessageSentCallback;
        }

        public void b(int paramInt1, int paramInt2, String paramString) {
            GamesClientImpl.this.a(new GamesClientImpl.RealTimeMessageSentCallback(GamesClientImpl.this, this.Jl, paramInt1, paramInt2, paramString));
        }
    }

    final class RequestReceivedBinderCallback
            extends AbstractGamesCallbacks {
        private final OnRequestReceivedListener Jm;

        RequestReceivedBinderCallback(OnRequestReceivedListener paramOnRequestReceivedListener) {
            this.Jm = paramOnRequestReceivedListener;
        }

        public void m(DataHolder paramDataHolder) {
            GameRequestBuffer localGameRequestBuffer = new GameRequestBuffer(paramDataHolder);
            paramDataHolder = null;
            try {
                if (localGameRequestBuffer.getCount() > 0) {
                    paramDataHolder = (GameRequest) ((GameRequest) localGameRequestBuffer.get(0)).freeze();
                }
                localGameRequestBuffer.close();
                if (paramDataHolder != null) {
                    GamesClientImpl.this.a(new GamesClientImpl.RequestReceivedCallback(GamesClientImpl.this, this.Jm, paramDataHolder));
                }
                return;
            } finally {
                localGameRequestBuffer.close();
            }
        }

        public void onRequestRemoved(String paramString) {
            GamesClientImpl.this.a(new GamesClientImpl.RequestRemovedCallback(GamesClientImpl.this, this.Jm, paramString));
        }
    }

    final class RequestReceivedCallback
            extends ff<IGamesService>.b<OnRequestReceivedListener> {
        private final GameRequest Jn;

        RequestReceivedCallback(OnRequestReceivedListener paramOnRequestReceivedListener, GameRequest paramGameRequest) {
            super(paramOnRequestReceivedListener);
            this.Jn = paramGameRequest;
        }

        protected void b(OnRequestReceivedListener paramOnRequestReceivedListener) {
            paramOnRequestReceivedListener.onRequestReceived(this.Jn);
        }

        protected void dx() {
        }
    }

    final class RequestRemovedCallback
            extends ff<IGamesService>.b<OnRequestReceivedListener> {
        private final String Jo;

        RequestRemovedCallback(OnRequestReceivedListener paramOnRequestReceivedListener, String paramString) {
            super(paramOnRequestReceivedListener);
            this.Jo = paramString;
        }

        protected void b(OnRequestReceivedListener paramOnRequestReceivedListener) {
            paramOnRequestReceivedListener.onRequestRemoved(this.Jo);
        }

        protected void dx() {
        }
    }

    final class RequestSentBinderCallbacks
            extends AbstractGamesCallbacks {
        private final a.d<Requests.SendRequestResult> Jp;

        public RequestSentBinderCallbacks() {
            Object localObject;
            this.Jp = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void E(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.RequestSentCallback(GamesClientImpl.this, this.Jp, paramDataHolder));
        }
    }

    final class RequestSentCallback
            extends GamesClientImpl.ResultDataHolderCallback<a.d<Requests.SendRequestResult>>
            implements Requests.SendRequestResult {
        private final GameRequest Jn;

        /* Error */
        RequestSentCallback(DataHolder paramDataHolder) {
            // Byte code:
            //   0: aload_0
            //   1: aload_1
            //   2: putfield 18	com/google/android/gms/games/internal/GamesClientImpl$RequestSentCallback:IJ	Lcom/google/android/gms/games/internal/GamesClientImpl;
            //   5: aload_0
            //   6: aload_1
            //   7: aload_2
            //   8: aload_3
            //   9: invokespecial 20	com/google/android/gms/games/internal/GamesClientImpl$ResultDataHolderCallback:<init>	(Lcom/google/android/gms/games/internal/GamesClientImpl;Lcom/google/android/gms/common/api/a$d;Lcom/google/android/gms/common/data/DataHolder;)V
            //   12: new 22	com/google/android/gms/games/request/GameRequestBuffer
            //   15: dup
            //   16: aload_3
            //   17: invokespecial 25	com/google/android/gms/games/request/GameRequestBuffer:<init>	(Lcom/google/android/gms/common/data/DataHolder;)V
            //   20: astore_1
            //   21: aload_1
            //   22: invokevirtual 29	com/google/android/gms/games/request/GameRequestBuffer:getCount	()I
            //   25: ifle +28 -> 53
            //   28: aload_0
            //   29: aload_1
            //   30: iconst_0
            //   31: invokevirtual 33	com/google/android/gms/games/request/GameRequestBuffer:get	(I)Ljava/lang/Object;
            //   34: checkcast 35	com/google/android/gms/games/request/GameRequest
            //   37: invokeinterface 39 1 0
            //   42: checkcast 35	com/google/android/gms/games/request/GameRequest
            //   45: putfield 41	com/google/android/gms/games/internal/GamesClientImpl$RequestSentCallback:Jn	Lcom/google/android/gms/games/request/GameRequest;
            //   48: aload_1
            //   49: invokevirtual 45	com/google/android/gms/games/request/GameRequestBuffer:close	()V
            //   52: return
            //   53: aload_0
            //   54: aconst_null
            //   55: putfield 41	com/google/android/gms/games/internal/GamesClientImpl$RequestSentCallback:Jn	Lcom/google/android/gms/games/request/GameRequest;
            //   58: goto -10 -> 48
            //   61: astore_2
            //   62: aload_1
            //   63: invokevirtual 45	com/google/android/gms/games/request/GameRequestBuffer:close	()V
            //   66: aload_2
            //   67: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	68	0	this	RequestSentCallback
            //   0	68	1	this$1	GamesClientImpl
            //   0	68	2	paramDataHolder	DataHolder
            //   8	9	3	localDataHolder	DataHolder
            // Exception table:
            //   from	to	target	type
            //   21	48	61	finally
            //   53	58	61	finally
        }

        protected void a(a.d<Requests.SendRequestResult> paramd, DataHolder paramDataHolder) {
            paramd.b(this);
        }
    }

    final class RequestSummariesLoadedBinderCallbacks
            extends AbstractGamesCallbacks {
        private final a.d<Requests.LoadRequestSummariesResult> Jq;

        public RequestSummariesLoadedBinderCallbacks() {
            Object localObject;
            this.Jq = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void F(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.RequestSummariesLoadedCallback(GamesClientImpl.this, this.Jq, paramDataHolder));
        }
    }

    final class RequestSummariesLoadedCallback
            extends GamesClientImpl.ResultDataHolderCallback<a.d<Requests.LoadRequestSummariesResult>>
            implements Requests.LoadRequestSummariesResult {
        RequestSummariesLoadedCallback(DataHolder paramDataHolder) {
            super(paramDataHolder, localDataHolder);
        }

        protected void a(a.d<Requests.LoadRequestSummariesResult> paramd, DataHolder paramDataHolder) {
            paramd.b(this);
        }
    }

    final class RequestsLoadedBinderCallbacks
            extends AbstractGamesCallbacks {
        private final a.d<Requests.LoadRequestsResult> Jr;

        public RequestsLoadedBinderCallbacks() {
            Object localObject;
            this.Jr = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void b(int paramInt, Bundle paramBundle) {
            paramBundle.setClassLoader(getClass().getClassLoader());
            Status localStatus = new Status(paramInt);
            GamesClientImpl.this.a(new GamesClientImpl.RequestsLoadedCallback(GamesClientImpl.this, this.Jr, localStatus, paramBundle));
        }
    }

    final class RequestsLoadedCallback
            extends ff<IGamesService>.b<a.d<Requests.LoadRequestsResult>>
            implements Requests.LoadRequestsResult {
        private final Bundle Js;
        private final Status wJ;

        RequestsLoadedCallback(Status paramStatus, Bundle paramBundle) {
            super(paramStatus);
            this.wJ = paramBundle;
            Bundle localBundle;
            this.Js = localBundle;
        }

        protected void c(a.d<Requests.LoadRequestsResult> paramd) {
            paramd.b(this);
        }

        protected void dx() {
            release();
        }

        public GameRequestBuffer getRequests(int paramInt) {
            String str = RequestType.bd(paramInt);
            if (!this.Js.containsKey(str)) {
                return null;
            }
            return new GameRequestBuffer((DataHolder) this.Js.get(str));
        }

        public Status getStatus() {
            return this.wJ;
        }

        public void release() {
            Iterator localIterator = this.Js.keySet().iterator();
            while (localIterator.hasNext()) {
                Object localObject = (String) localIterator.next();
                localObject = (DataHolder) this.Js.getParcelable((String) localObject);
                if (localObject != null) {
                    ((DataHolder) localObject).close();
                }
            }
        }
    }

    final class RequestsUpdatedBinderCallbacks
            extends AbstractGamesCallbacks {
        private final a.d<Requests.UpdateRequestsResult> Jt;

        public RequestsUpdatedBinderCallbacks() {
            Object localObject;
            this.Jt = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void D(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.RequestsUpdatedCallback(GamesClientImpl.this, this.Jt, paramDataHolder));
        }
    }

    final class RequestsUpdatedCallback
            extends GamesClientImpl.ResultDataHolderCallback<a.d<Requests.UpdateRequestsResult>>
            implements Requests.UpdateRequestsResult {
        private final RequestUpdateOutcomes Ju;

        RequestsUpdatedCallback(DataHolder paramDataHolder) {
            super(paramDataHolder, localDataHolder);
            this.Ju = RequestUpdateOutcomes.J(localDataHolder);
        }

        protected void a(a.d<Requests.UpdateRequestsResult> paramd, DataHolder paramDataHolder) {
            paramd.b(this);
        }

        public Set<String> getRequestIds() {
            return this.Ju.getRequestIds();
        }

        public int getRequestOutcome(String paramString) {
            return this.Ju.getRequestOutcome(paramString);
        }
    }

    abstract class ResultDataHolderCallback<R extends a.d<?>>
            extends ff<IGamesService>.d<R>
            implements Releasable, Result {
        final DataHolder BB;
        final Status wJ;

        public ResultDataHolderCallback(DataHolder paramDataHolder) {
            super(paramDataHolder, localDataHolder);
            this.wJ = new Status(localDataHolder.getStatusCode());
            this.BB = localDataHolder;
        }

        public Status getStatus() {
            return this.wJ;
        }

        public void release() {
            if (this.BB != null) {
                this.BB.close();
            }
        }
    }

    final class RoomAutoMatchingCallback
            extends GamesClientImpl.AbstractRoomStatusCallback {
        RoomAutoMatchingCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder) {
            super(paramRoomStatusUpdateListener, paramDataHolder);
        }

        public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom) {
            paramRoomStatusUpdateListener.onRoomAutoMatching(paramRoom);
        }
    }

    final class RoomBinderCallbacks
            extends AbstractGamesCallbacks {
        private final RoomUpdateListener Jv;
        private final RoomStatusUpdateListener Jw;
        private final RealTimeMessageReceivedListener Jx;

        public RoomBinderCallbacks(RoomUpdateListener paramRoomUpdateListener) {
            this.Jv = ((RoomUpdateListener) fq.b(paramRoomUpdateListener, "Callbacks must not be null"));
            this.Jw = null;
            this.Jx = null;
        }

        public RoomBinderCallbacks(RoomUpdateListener paramRoomUpdateListener, RoomStatusUpdateListener paramRoomStatusUpdateListener, RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener) {
            this.Jv = ((RoomUpdateListener) fq.b(paramRoomUpdateListener, "Callbacks must not be null"));
            this.Jw = paramRoomStatusUpdateListener;
            this.Jx = paramRealTimeMessageReceivedListener;
        }

        public void a(DataHolder paramDataHolder, String[] paramArrayOfString) {
            GamesClientImpl.this.a(new GamesClientImpl.PeerInvitedToRoomCallback(GamesClientImpl.this, this.Jw, paramDataHolder, paramArrayOfString));
        }

        public void b(DataHolder paramDataHolder, String[] paramArrayOfString) {
            GamesClientImpl.this.a(new GamesClientImpl.PeerJoinedRoomCallback(GamesClientImpl.this, this.Jw, paramDataHolder, paramArrayOfString));
        }

        public void c(DataHolder paramDataHolder, String[] paramArrayOfString) {
            GamesClientImpl.this.a(new GamesClientImpl.PeerLeftRoomCallback(GamesClientImpl.this, this.Jw, paramDataHolder, paramArrayOfString));
        }

        public void d(DataHolder paramDataHolder, String[] paramArrayOfString) {
            GamesClientImpl.this.a(new GamesClientImpl.PeerDeclinedCallback(GamesClientImpl.this, this.Jw, paramDataHolder, paramArrayOfString));
        }

        public void e(DataHolder paramDataHolder, String[] paramArrayOfString) {
            GamesClientImpl.this.a(new GamesClientImpl.PeerConnectedCallback(GamesClientImpl.this, this.Jw, paramDataHolder, paramArrayOfString));
        }

        public void f(DataHolder paramDataHolder, String[] paramArrayOfString) {
            GamesClientImpl.this.a(new GamesClientImpl.PeerDisconnectedCallback(GamesClientImpl.this, this.Jw, paramDataHolder, paramArrayOfString));
        }

        public void onLeftRoom(int paramInt, String paramString) {
            GamesClientImpl.this.a(new GamesClientImpl.LeftRoomCallback(GamesClientImpl.this, this.Jv, paramInt, paramString));
        }

        public void onP2PConnected(String paramString) {
            GamesClientImpl.this.a(new GamesClientImpl.P2PConnectedCallback(GamesClientImpl.this, this.Jw, paramString));
        }

        public void onP2PDisconnected(String paramString) {
            GamesClientImpl.this.a(new GamesClientImpl.P2PDisconnectedCallback(GamesClientImpl.this, this.Jw, paramString));
        }

        public void onRealTimeMessageReceived(RealTimeMessage paramRealTimeMessage) {
            GamesClientImpl.this.a(new GamesClientImpl.MessageReceivedCallback(GamesClientImpl.this, this.Jx, paramRealTimeMessage));
        }

        public void s(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.RoomCreatedCallback(GamesClientImpl.this, this.Jv, paramDataHolder));
        }

        public void t(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.JoinedRoomCallback(GamesClientImpl.this, this.Jv, paramDataHolder));
        }

        public void u(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.RoomConnectingCallback(GamesClientImpl.this, this.Jw, paramDataHolder));
        }

        public void v(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.RoomAutoMatchingCallback(GamesClientImpl.this, this.Jw, paramDataHolder));
        }

        public void w(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.RoomConnectedCallback(GamesClientImpl.this, this.Jv, paramDataHolder));
        }

        public void x(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.ConnectedToRoomCallback(GamesClientImpl.this, this.Jw, paramDataHolder));
        }

        public void y(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.DisconnectedFromRoomCallback(GamesClientImpl.this, this.Jw, paramDataHolder));
        }
    }

    final class RoomConnectedCallback
            extends GamesClientImpl.AbstractRoomCallback {
        RoomConnectedCallback(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder) {
            super(paramRoomUpdateListener, paramDataHolder);
        }

        public void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt) {
            paramRoomUpdateListener.onRoomConnected(paramInt, paramRoom);
        }
    }

    final class RoomConnectingCallback
            extends GamesClientImpl.AbstractRoomStatusCallback {
        RoomConnectingCallback(RoomStatusUpdateListener paramRoomStatusUpdateListener, DataHolder paramDataHolder) {
            super(paramRoomStatusUpdateListener, paramDataHolder);
        }

        public void a(RoomStatusUpdateListener paramRoomStatusUpdateListener, Room paramRoom) {
            paramRoomStatusUpdateListener.onRoomConnecting(paramRoom);
        }
    }

    final class RoomCreatedCallback
            extends GamesClientImpl.AbstractRoomCallback {
        public RoomCreatedCallback(RoomUpdateListener paramRoomUpdateListener, DataHolder paramDataHolder) {
            super(paramRoomUpdateListener, paramDataHolder);
        }

        public void a(RoomUpdateListener paramRoomUpdateListener, Room paramRoom, int paramInt) {
            paramRoomUpdateListener.onRoomCreated(paramInt, paramRoom);
        }
    }

    final class SignOutCompleteBinderCallbacks
            extends AbstractGamesCallbacks {
        private final a.d<Status> wH;

        public SignOutCompleteBinderCallbacks() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void du() {
            Status localStatus = new Status(0);
            GamesClientImpl.this.a(new GamesClientImpl.SignOutCompleteCallback(GamesClientImpl.this, this.wH, localStatus));
        }
    }

    final class SignOutCompleteCallback
            extends ff<IGamesService>.b<a.d<Status>> {
        private final Status wJ;

        public SignOutCompleteCallback(Status paramStatus) {
            super(paramStatus);
            Status localStatus;
            this.wJ = localStatus;
        }

        public void c(a.d<Status> paramd) {
            paramd.b(this.wJ);
        }

        protected void dx() {
        }
    }

    final class SubmitScoreBinderCallbacks
            extends AbstractGamesCallbacks {
        private final a.d<Leaderboards.SubmitScoreResult> wH;

        public SubmitScoreBinderCallbacks() {
            Object localObject;
            this.wH = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void d(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.SubmitScoreCallback(GamesClientImpl.this, this.wH, paramDataHolder));
        }
    }

    final class SubmitScoreCallback
            extends GamesClientImpl.ResultDataHolderCallback<a.d<Leaderboards.SubmitScoreResult>>
            implements Leaderboards.SubmitScoreResult {
        private final ScoreSubmissionData Jy;

        public SubmitScoreCallback(DataHolder paramDataHolder) {
            super(paramDataHolder, localDataHolder);
            try {
                this.Jy = new ScoreSubmissionData(localDataHolder);
                return;
            } finally {
                localDataHolder.close();
            }
        }

        public void a(a.d<Leaderboards.SubmitScoreResult> paramd, DataHolder paramDataHolder) {
            paramd.b(this);
        }

        public ScoreSubmissionData getScoreData() {
            return this.Jy;
        }
    }

    abstract class TurnBasedMatchCallback<T extends a.d<?>>
            extends GamesClientImpl.ResultDataHolderCallback<T> {
        final TurnBasedMatch Jd;

        /* Error */
        TurnBasedMatchCallback(DataHolder paramDataHolder) {
            // Byte code:
            //   0: aload_0
            //   1: aload_1
            //   2: putfield 16	com/google/android/gms/games/internal/GamesClientImpl$TurnBasedMatchCallback:IJ	Lcom/google/android/gms/games/internal/GamesClientImpl;
            //   5: aload_0
            //   6: aload_1
            //   7: aload_2
            //   8: aload_3
            //   9: invokespecial 18	com/google/android/gms/games/internal/GamesClientImpl$ResultDataHolderCallback:<init>	(Lcom/google/android/gms/games/internal/GamesClientImpl;Lcom/google/android/gms/common/api/a$d;Lcom/google/android/gms/common/data/DataHolder;)V
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
            //   45: putfield 39	com/google/android/gms/games/internal/GamesClientImpl$TurnBasedMatchCallback:Jd	Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;
            //   48: aload_1
            //   49: invokevirtual 43	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:close	()V
            //   52: return
            //   53: aload_0
            //   54: aconst_null
            //   55: putfield 39	com/google/android/gms/games/internal/GamesClientImpl$TurnBasedMatchCallback:Jd	Lcom/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch;
            //   58: goto -10 -> 48
            //   61: astore_2
            //   62: aload_1
            //   63: invokevirtual 43	com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatchBuffer:close	()V
            //   66: aload_2
            //   67: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	68	0	this	TurnBasedMatchCallback
            //   0	68	1	this$1	GamesClientImpl
            //   0	68	2	paramDataHolder	DataHolder
            //   8	9	3	localDataHolder	DataHolder
            // Exception table:
            //   from	to	target	type
            //   21	48	61	finally
            //   53	58	61	finally
        }

        protected void a(T paramT, DataHolder paramDataHolder) {
            k(paramT);
        }

        public TurnBasedMatch getMatch() {
            return this.Jd;
        }

        abstract void k(T paramT);
    }

    final class TurnBasedMatchCanceledBinderCallbacks
            extends AbstractGamesCallbacks {
        private final a.d<TurnBasedMultiplayer.CancelMatchResult> Jz;

        public TurnBasedMatchCanceledBinderCallbacks() {
            Object localObject;
            this.Jz = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void f(int paramInt, String paramString) {
            Status localStatus = new Status(paramInt);
            GamesClientImpl.this.a(new GamesClientImpl.TurnBasedMatchCanceledCallback(GamesClientImpl.this, this.Jz, localStatus, paramString));
        }
    }

    final class TurnBasedMatchCanceledCallback
            extends ff<IGamesService>.b<a.d<TurnBasedMultiplayer.CancelMatchResult>>
            implements TurnBasedMultiplayer.CancelMatchResult {
        private final String JA;
        private final Status wJ;

        TurnBasedMatchCanceledCallback(Status paramStatus, String paramString) {
            super(paramStatus);
            this.wJ = paramString;
            String str;
            this.JA = str;
        }

        public void c(a.d<TurnBasedMultiplayer.CancelMatchResult> paramd) {
            paramd.b(this);
        }

        protected void dx() {
        }

        public String getMatchId() {
            return this.JA;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    final class TurnBasedMatchInitiatedBinderCallbacks
            extends AbstractGamesCallbacks {
        private final a.d<TurnBasedMultiplayer.InitiateMatchResult> JB;

        public TurnBasedMatchInitiatedBinderCallbacks() {
            Object localObject;
            this.JB = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void o(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.TurnBasedMatchInitiatedCallback(GamesClientImpl.this, this.JB, paramDataHolder));
        }
    }

    final class TurnBasedMatchInitiatedCallback
            extends GamesClientImpl.TurnBasedMatchCallback<a.d<TurnBasedMultiplayer.InitiateMatchResult>>
            implements TurnBasedMultiplayer.InitiateMatchResult {
        TurnBasedMatchInitiatedCallback(DataHolder paramDataHolder) {
            super(paramDataHolder, localDataHolder);
        }

        protected void k(a.d<TurnBasedMultiplayer.InitiateMatchResult> paramd) {
            paramd.b(this);
        }
    }

    final class TurnBasedMatchLeftBinderCallbacks
            extends AbstractGamesCallbacks {
        private final a.d<TurnBasedMultiplayer.LeaveMatchResult> JC;

        public TurnBasedMatchLeftBinderCallbacks() {
            Object localObject;
            this.JC = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void q(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.TurnBasedMatchLeftCallback(GamesClientImpl.this, this.JC, paramDataHolder));
        }
    }

    final class TurnBasedMatchLeftCallback
            extends GamesClientImpl.TurnBasedMatchCallback<a.d<TurnBasedMultiplayer.LeaveMatchResult>>
            implements TurnBasedMultiplayer.LeaveMatchResult {
        TurnBasedMatchLeftCallback(DataHolder paramDataHolder) {
            super(paramDataHolder, localDataHolder);
        }

        protected void k(a.d<TurnBasedMultiplayer.LeaveMatchResult> paramd) {
            paramd.b(this);
        }
    }

    final class TurnBasedMatchLoadedBinderCallbacks
            extends AbstractGamesCallbacks {
        private final a.d<TurnBasedMultiplayer.LoadMatchResult> JD;

        public TurnBasedMatchLoadedBinderCallbacks() {
            Object localObject;
            this.JD = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void n(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.TurnBasedMatchLoadedCallback(GamesClientImpl.this, this.JD, paramDataHolder));
        }
    }

    final class TurnBasedMatchLoadedCallback
            extends GamesClientImpl.TurnBasedMatchCallback<a.d<TurnBasedMultiplayer.LoadMatchResult>>
            implements TurnBasedMultiplayer.LoadMatchResult {
        TurnBasedMatchLoadedCallback(DataHolder paramDataHolder) {
            super(paramDataHolder, localDataHolder);
        }

        protected void k(a.d<TurnBasedMultiplayer.LoadMatchResult> paramd) {
            paramd.b(this);
        }
    }

    final class TurnBasedMatchUpdatedBinderCallbacks
            extends AbstractGamesCallbacks {
        private final a.d<TurnBasedMultiplayer.UpdateMatchResult> JE;

        public TurnBasedMatchUpdatedBinderCallbacks() {
            Object localObject;
            this.JE = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void p(DataHolder paramDataHolder) {
            GamesClientImpl.this.a(new GamesClientImpl.TurnBasedMatchUpdatedCallback(GamesClientImpl.this, this.JE, paramDataHolder));
        }
    }

    final class TurnBasedMatchUpdatedCallback
            extends GamesClientImpl.TurnBasedMatchCallback<a.d<TurnBasedMultiplayer.UpdateMatchResult>>
            implements TurnBasedMultiplayer.UpdateMatchResult {
        TurnBasedMatchUpdatedCallback(DataHolder paramDataHolder) {
            super(paramDataHolder, localDataHolder);
        }

        protected void k(a.d<TurnBasedMultiplayer.UpdateMatchResult> paramd) {
            paramd.b(this);
        }
    }

    final class TurnBasedMatchesLoadedBinderCallbacks
            extends AbstractGamesCallbacks {
        private final a.d<TurnBasedMultiplayer.LoadMatchesResult> JF;

        public TurnBasedMatchesLoadedBinderCallbacks() {
            Object localObject;
            this.JF = ((a.d) fq.b(localObject, "Holder must not be null"));
        }

        public void a(int paramInt, Bundle paramBundle) {
            paramBundle.setClassLoader(getClass().getClassLoader());
            Status localStatus = new Status(paramInt);
            GamesClientImpl.this.a(new GamesClientImpl.TurnBasedMatchesLoadedCallback(GamesClientImpl.this, this.JF, localStatus, paramBundle));
        }
    }

    final class TurnBasedMatchesLoadedCallback
            extends ff<IGamesService>.b<a.d<TurnBasedMultiplayer.LoadMatchesResult>>
            implements TurnBasedMultiplayer.LoadMatchesResult {
        private final LoadMatchesResponse JG;
        private final Status wJ;

        TurnBasedMatchesLoadedCallback(Status paramStatus, Bundle paramBundle) {
            super(paramStatus);
            this.wJ = paramBundle;
            Bundle localBundle;
            this.JG = new LoadMatchesResponse(localBundle);
        }

        protected void c(a.d<TurnBasedMultiplayer.LoadMatchesResult> paramd) {
            paramd.b(this);
        }

        protected void dx() {
        }

        public LoadMatchesResponse getMatches() {
            return this.JG;
        }

        public Status getStatus() {
            return this.wJ;
        }

        public void release() {
            this.JG.close();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/internal/GamesClientImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */