package mobi.beyondpod.services.player;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.CoreHelper.TrackSizeInfo;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEvent;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEventListener;
import mobi.beyondpod.rsscore.repository.RepositoryPersistence;
import mobi.beyondpod.rsscore.rss.ItemStateHistory;
import mobi.beyondpod.ui.commands.CommandManagerBase;
import mobi.beyondpod.ui.core.MusicUtils;

public class PlayList
  implements RepositoryEvents.RepositoryEventListener
{
  public static final int MOVE_BOTTOM = 2;
  public static final int MOVE_TOP = 1;
  public static final int PLAYLIST_END_ACTION_Clear_Playlist = 1;
  public static final int PLAYLIST_END_ACTION_Do_Nothing = 0;
  public static final int PLAYLIST_END_ACTION_StartSmartPlay = 2;
  public static final int PLAYLIST_SLEEP_TO_END_OF_TRACK_VALUE = Integer.MIN_VALUE;
  public static final String TAG = PlayList.class.getSimpleName();
  private Track _CurrentTrack;
  private boolean _IsManuallyModified = false;
  public ArrayList<Track> _PlayList = new ArrayList();
  private boolean _PlaylistIsSaving = false;
  Runnable _PlaylistSaveRunnable = new Runnable()
  {
    public void run()
    {
      PlayList.this.SaveToFileInternal();
      PlayList.this.PublishM3UPlaylistIfNeeded();
    }
  };
  private Track _TrackToDelete;
  
  public PlayList()
  {
    BeyondPodApplication.MessageBus.Subscribe(this, RepositoryEvents.RepositoryEvent.class);
  }
  
  private void AddTrackIntrnal(Track paramTrack)
  {
    if ((paramTrack != null) && (!HasTrack(paramTrack)) && (CanPlayStreamableTrack(paramTrack))) {}
    try
    {
      this._PlayList.add(paramTrack);
      if (this._CurrentTrack == null) {
        this._CurrentTrack = paramTrack;
      }
      return;
    }
    catch (ArrayIndexOutOfBoundsException paramTrack)
    {
      CoreHelper.LogException(TAG, "Failed to append to playlist!", paramTrack);
    }
  }
  
  public static boolean AllowStreaming(Track paramTrack)
  {
    if (!paramTrack.Exists())
    {
      if (Configuration.AllowEpisodeStreaming() == 2) {}
      while ((Configuration.AllowEpisodeStreaming() == 1) && (!CoreHelper.IsWiFiConnected())) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean CanAddToPlaylist(Track paramTrack, List<Track> paramList)
  {
    if (paramTrack == null) {}
    while ((paramList.contains(paramTrack)) || (!CanPlayStreamableTrack(paramTrack)) || ((paramTrack.HasDownloadStarted()) && (!paramTrack.IsFullyDownloaded()))) {
      return false;
    }
    return true;
  }
  
  public static boolean CanPlayStreamableTrack(Track paramTrack)
  {
    return (Configuration.AllowEpisodeStreaming() != 2) || (paramTrack.Exists());
  }
  
  private void ClearPlayedIfNeeded()
  {
    if (!Configuration.RemovePlayedFromPlaylist()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this._PlayList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (localArrayList.size() <= 0) {
          break;
        }
        RemoveTracks(localArrayList);
        CoreHelper.WriteTraceEntry(TAG, "Removed " + localArrayList.size() + " played episodes.");
        return;
      }
      Track localTrack = (Track)localIterator.next();
      if (localTrack.IsPlayed()) {
        localArrayList.add(localTrack);
      }
    }
  }
  
  private void ExecuteActionDeleteCurrentTrackIfAllowed()
  {
    if (this._CurrentTrack.AllowAutoDelete()) {
      this._TrackToDelete = this._CurrentTrack;
    }
  }
  
  private void ExecuteActionDoNothing()
  {
    ClearCurrentTrack();
    ClearPlayedIfNeeded();
    BeyondPodApplication.MessageBus.PublishEvent(new PlayListEvents.PlayListEvent(this, 3));
  }
  
  private Track GetNextPlayableTrack()
  {
    for (;;)
    {
      int i;
      synchronized (this._PlayList)
      {
        i = GetCurrentPlayingTrackPosition() + 1;
        if (i >= PlaylistSize()) {
          return null;
        }
        Track localTrack = (Track)this._PlayList.get(i);
        if (!localTrack.IsPlayed()) {
          return localTrack;
        }
      }
      i += 1;
    }
  }
  
  public static boolean IsCurrentlyPlaying()
  {
    Track localTrack = BeyondPodApplication.GetInstance().PlayList().CurrentTrack();
    return (localTrack != null) && (localTrack.getCurrentPlayState() == 1);
  }
  
  public static boolean IsEmpty()
  {
    return BeyondPodApplication.GetInstance().PlayList().PlaylistSize() == 0;
  }
  
  public static boolean IsManuallyModified()
  {
    return BeyondPodApplication.GetInstance().PlayList()._IsManuallyModified;
  }
  
  private void NotifyPlaylistChanged()
  {
    SaveIndexOfCurrentPlaylistTrackInPlaylist();
    BeyondPodApplication.MessageBus.PublishEvent(new PlayListEvents.PlayListEvent(this, 0));
  }
  
  private int PrepareNextPosition(boolean paramBoolean)
  {
    int j = -1;
    int k = GetCurrentPlayingTrackPosition();
    int i = j;
    if (k >= 0)
    {
      i = j;
      if (k < PlaylistSize() - 1)
      {
        if (!paramBoolean) {
          return k + 1;
        }
        Track localTrack = GetNextPlayableTrack();
        i = j;
        if (localTrack != null)
        {
          if (localTrack.IsPlayed()) {
            localTrack.ClearPlayed();
          }
          if (Configuration.RemovePlayedFromPlaylist()) {
            this._CurrentTrack = localTrack;
          }
          ClearPlayedIfNeeded();
          i = GetTrackPosition(localTrack);
          CoreHelper.WriteTraceEntry(TAG, "Found next playable episode: " + localTrack.DisplayName() + " at position: " + i);
        }
      }
    }
    return i;
  }
  
  /* Error */
  private void PublishM3UPlaylistIfNeeded()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	mobi/beyondpod/services/player/PlayList:_PlayList	Ljava/util/ArrayList;
    //   4: astore 5
    //   6: aload 5
    //   8: monitorenter
    //   9: aconst_null
    //   10: astore_2
    //   11: aconst_null
    //   12: astore 4
    //   14: aload_2
    //   15: astore_1
    //   16: aload_0
    //   17: getfield 51	mobi/beyondpod/services/player/PlayList:_PlayList	Ljava/util/ArrayList;
    //   20: invokevirtual 146	java/util/ArrayList:size	()I
    //   23: ifeq +11 -> 34
    //   26: aload_2
    //   27: astore_1
    //   28: invokestatic 258	mobi/beyondpod/rsscore/Configuration:PublishPlaylist	()Z
    //   31: ifne +78 -> 109
    //   34: aload_2
    //   35: astore_1
    //   36: new 260	java/io/File
    //   39: dup
    //   40: invokestatic 263	mobi/beyondpod/rsscore/Configuration:PlaylistM3UFilePath	()Ljava/lang/String;
    //   43: invokespecial 264	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: astore_3
    //   47: aload_2
    //   48: astore_1
    //   49: aload_3
    //   50: invokevirtual 267	java/io/File:exists	()Z
    //   53: ifeq +21 -> 74
    //   56: aload_2
    //   57: astore_1
    //   58: aload_3
    //   59: invokevirtual 270	java/io/File:delete	()Z
    //   62: pop
    //   63: aload_2
    //   64: astore_1
    //   65: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   68: ldc_w 272
    //   71: invokestatic 173	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: iconst_0
    //   75: ifeq +11 -> 86
    //   78: new 274	java/lang/NullPointerException
    //   81: dup
    //   82: invokespecial 275	java/lang/NullPointerException:<init>	()V
    //   85: athrow
    //   86: aload 5
    //   88: monitorexit
    //   89: return
    //   90: astore_1
    //   91: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   94: ldc_w 277
    //   97: aload_1
    //   98: invokestatic 99	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   101: goto -15 -> 86
    //   104: aload 5
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    //   109: aload_2
    //   110: astore_1
    //   111: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   114: ldc_w 279
    //   117: invokestatic 173	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_2
    //   121: astore_1
    //   122: new 281	java/io/FileOutputStream
    //   125: dup
    //   126: invokestatic 263	mobi/beyondpod/rsscore/Configuration:PlaylistM3UFilePath	()Ljava/lang/String;
    //   129: invokespecial 282	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   132: astore_3
    //   133: aload_2
    //   134: astore_1
    //   135: new 284	java/io/PrintWriter
    //   138: dup
    //   139: aload_3
    //   140: invokespecial 287	java/io/PrintWriter:<init>	(Ljava/io/OutputStream;)V
    //   143: astore_2
    //   144: aload_0
    //   145: getfield 51	mobi/beyondpod/services/player/PlayList:_PlayList	Ljava/util/ArrayList;
    //   148: invokevirtual 138	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   151: astore_1
    //   152: aload_1
    //   153: invokeinterface 143 1 0
    //   158: ifne +30 -> 188
    //   161: aload_3
    //   162: invokestatic 291	mobi/beyondpod/rsscore/helpers/CoreHelper:sync	(Ljava/io/FileOutputStream;)Z
    //   165: pop
    //   166: aload_2
    //   167: invokevirtual 294	java/io/PrintWriter:close	()V
    //   170: invokestatic 263	mobi/beyondpod/rsscore/Configuration:PlaylistM3UFilePath	()Ljava/lang/String;
    //   173: invokestatic 299	mobi/beyondpod/ui/core/MusicUtils:ForceMediaScanFor	(Ljava/lang/String;)V
    //   176: aload_2
    //   177: ifnull +144 -> 321
    //   180: aload_2
    //   181: invokevirtual 294	java/io/PrintWriter:close	()V
    //   184: aload 5
    //   186: monitorexit
    //   187: return
    //   188: aload_1
    //   189: invokeinterface 177 1 0
    //   194: checkcast 102	mobi/beyondpod/rsscore/Track
    //   197: astore 4
    //   199: aload 4
    //   201: invokevirtual 106	mobi/beyondpod/rsscore/Track:Exists	()Z
    //   204: ifeq -52 -> 152
    //   207: aload 4
    //   209: invokevirtual 302	mobi/beyondpod/rsscore/Track:ContentType	()I
    //   212: iconst_1
    //   213: if_icmpne -61 -> 152
    //   216: aload_2
    //   217: new 152	java/lang/StringBuilder
    //   220: dup
    //   221: aload 4
    //   223: invokevirtual 305	mobi/beyondpod/rsscore/Track:TrackPath	()Ljava/lang/String;
    //   226: invokestatic 311	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   229: invokespecial 157	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   232: ldc_w 313
    //   235: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokevirtual 316	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   244: goto -92 -> 152
    //   247: astore_3
    //   248: aload_2
    //   249: astore_1
    //   250: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   253: ldc_w 277
    //   256: aload_3
    //   257: invokestatic 99	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   260: aload_2
    //   261: ifnull -77 -> 184
    //   264: aload_2
    //   265: invokevirtual 294	java/io/PrintWriter:close	()V
    //   268: goto -84 -> 184
    //   271: astore_1
    //   272: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   275: ldc_w 277
    //   278: aload_1
    //   279: invokestatic 99	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   282: goto -98 -> 184
    //   285: astore_2
    //   286: aload_1
    //   287: ifnull +7 -> 294
    //   290: aload_1
    //   291: invokevirtual 294	java/io/PrintWriter:close	()V
    //   294: aload_2
    //   295: athrow
    //   296: astore_1
    //   297: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   300: ldc_w 277
    //   303: aload_1
    //   304: invokestatic 99	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   307: goto -13 -> 294
    //   310: astore_1
    //   311: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   314: ldc_w 277
    //   317: aload_1
    //   318: invokestatic 99	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   321: goto -137 -> 184
    //   324: astore_1
    //   325: goto -221 -> 104
    //   328: astore_3
    //   329: aload_2
    //   330: astore_1
    //   331: aload_3
    //   332: astore_2
    //   333: goto -47 -> 286
    //   336: astore_3
    //   337: aload 4
    //   339: astore_2
    //   340: goto -92 -> 248
    //   343: astore_1
    //   344: goto -240 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	this	PlayList
    //   15	50	1	localPrintWriter1	java.io.PrintWriter
    //   90	18	1	localException1	Exception
    //   110	140	1	localObject1	Object
    //   271	20	1	localException2	Exception
    //   296	8	1	localException3	Exception
    //   310	8	1	localException4	Exception
    //   324	1	1	localObject2	Object
    //   330	1	1	localObject3	Object
    //   343	1	1	localObject4	Object
    //   10	255	2	localPrintWriter2	java.io.PrintWriter
    //   285	45	2	localObject5	Object
    //   332	8	2	localObject6	Object
    //   46	116	3	localObject7	Object
    //   247	10	3	localException5	Exception
    //   328	4	3	localObject8	Object
    //   336	1	3	localException6	Exception
    //   12	326	4	localTrack	Track
    //   4	181	5	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   78	86	90	java/lang/Exception
    //   144	152	247	java/lang/Exception
    //   152	176	247	java/lang/Exception
    //   188	244	247	java/lang/Exception
    //   264	268	271	java/lang/Exception
    //   16	26	285	finally
    //   28	34	285	finally
    //   36	47	285	finally
    //   49	56	285	finally
    //   58	63	285	finally
    //   65	74	285	finally
    //   111	120	285	finally
    //   122	133	285	finally
    //   135	144	285	finally
    //   250	260	285	finally
    //   290	294	296	java/lang/Exception
    //   180	184	310	java/lang/Exception
    //   180	184	324	finally
    //   311	321	324	finally
    //   144	152	328	finally
    //   152	176	328	finally
    //   188	244	328	finally
    //   16	26	336	java/lang/Exception
    //   28	34	336	java/lang/Exception
    //   36	47	336	java/lang/Exception
    //   49	56	336	java/lang/Exception
    //   58	63	336	java/lang/Exception
    //   65	74	336	java/lang/Exception
    //   111	120	336	java/lang/Exception
    //   122	133	336	java/lang/Exception
    //   135	144	336	java/lang/Exception
    //   78	86	343	finally
    //   86	89	343	finally
    //   91	101	343	finally
    //   104	107	343	finally
    //   184	187	343	finally
    //   264	268	343	finally
    //   272	282	343	finally
    //   290	294	343	finally
    //   294	296	343	finally
    //   297	307	343	finally
  }
  
  private boolean RemoveTrackInternal(Track paramTrack)
  {
    if ((paramTrack == null) || (!this._PlayList.contains(paramTrack))) {
      return false;
    }
    if (paramTrack == this._CurrentTrack)
    {
      CommandManagerBase.CmdStopPlayback();
      int i = GetNextTrackPosition();
      if (i >= 0)
      {
        SetCurrentTrack(i);
        CommandManagerBase.CmdLoadCurrentTrack();
      }
    }
    this._PlayList.remove(paramTrack);
    if (this._PlayList.size() == 0) {
      ClearCurrentTrack();
    }
    this._IsManuallyModified = true;
    return true;
  }
  
  private void SaveIndexOfCurrentPlaylistTrackInPlaylist()
  {
    int i = GetCurrentPlayingTrackPosition();
    if (i != Configuration.IndexOfCurrentPlaylistTrackInPlaylist())
    {
      Configuration.setIndexOfCurrentPlaylistTrackInPlaylist(i);
      CoreHelper.WriteTraceEntry(TAG, "Saved index of current Playlist track in Playlist: " + i);
    }
  }
  
  private void SaveToFileAsync()
  {
    RepositoryPersistence.RepositoryHandler().removeCallbacks(this._PlaylistSaveRunnable);
    RepositoryPersistence.RepositoryHandler().post(this._PlaylistSaveRunnable);
  }
  
  /* Error */
  private void SaveToFileInternal()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	mobi/beyondpod/services/player/PlayList:_PlayList	Ljava/util/ArrayList;
    //   4: astore 6
    //   6: aload 6
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 60	mobi/beyondpod/services/player/PlayList:_PlaylistIsSaving	Z
    //   13: ifeq +7 -> 20
    //   16: aload 6
    //   18: monitorexit
    //   19: return
    //   20: invokestatic 366	mobi/beyondpod/rsscore/Configuration:PlaylistFilePath	()Ljava/lang/String;
    //   23: astore 4
    //   25: aload_0
    //   26: getfield 53	mobi/beyondpod/services/player/PlayList:_IsManuallyModified	Z
    //   29: invokestatic 370	mobi/beyondpod/rsscore/Configuration:setIsCurrentPlaylistManuallyModified	(Z)V
    //   32: aload_0
    //   33: getfield 51	mobi/beyondpod/services/player/PlayList:_PlayList	Ljava/util/ArrayList;
    //   36: invokevirtual 146	java/util/ArrayList:size	()I
    //   39: invokestatic 373	mobi/beyondpod/rsscore/Configuration:setPlaylistSizeOnSave	(I)V
    //   42: aconst_null
    //   43: astore_3
    //   44: aconst_null
    //   45: astore 5
    //   47: aload_3
    //   48: astore_2
    //   49: aload_0
    //   50: iconst_1
    //   51: putfield 60	mobi/beyondpod/services/player/PlayList:_PlaylistIsSaving	Z
    //   54: aload_3
    //   55: astore_2
    //   56: aload_0
    //   57: getfield 51	mobi/beyondpod/services/player/PlayList:_PlayList	Ljava/util/ArrayList;
    //   60: invokevirtual 146	java/util/ArrayList:size	()I
    //   63: ifne +87 -> 150
    //   66: aload_3
    //   67: astore_2
    //   68: new 260	java/io/File
    //   71: dup
    //   72: invokestatic 366	mobi/beyondpod/rsscore/Configuration:PlaylistFilePath	()Ljava/lang/String;
    //   75: invokespecial 264	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore 4
    //   80: aload_3
    //   81: astore_2
    //   82: aload 4
    //   84: invokevirtual 267	java/io/File:exists	()Z
    //   87: ifeq +11 -> 98
    //   90: aload_3
    //   91: astore_2
    //   92: aload 4
    //   94: invokevirtual 270	java/io/File:delete	()Z
    //   97: pop
    //   98: aload_3
    //   99: astore_2
    //   100: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   103: ldc_w 375
    //   106: invokestatic 173	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: iconst_0
    //   110: ifeq +11 -> 121
    //   113: new 274	java/lang/NullPointerException
    //   116: dup
    //   117: invokespecial 275	java/lang/NullPointerException:<init>	()V
    //   120: athrow
    //   121: aload_0
    //   122: iconst_0
    //   123: putfield 60	mobi/beyondpod/services/player/PlayList:_PlaylistIsSaving	Z
    //   126: aload 6
    //   128: monitorexit
    //   129: return
    //   130: astore_2
    //   131: aload 6
    //   133: monitorexit
    //   134: aload_2
    //   135: athrow
    //   136: astore_2
    //   137: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   140: ldc_w 377
    //   143: aload_2
    //   144: invokestatic 99	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   147: goto -26 -> 121
    //   150: aload_3
    //   151: astore_2
    //   152: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   155: new 152	java/lang/StringBuilder
    //   158: dup
    //   159: ldc_w 379
    //   162: invokespecial 157	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   165: aload_0
    //   166: getfield 51	mobi/beyondpod/services/player/PlayList:_PlayList	Ljava/util/ArrayList;
    //   169: invokevirtual 146	java/util/ArrayList:size	()I
    //   172: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   175: ldc_w 381
    //   178: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 173	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload_3
    //   188: astore_2
    //   189: new 281	java/io/FileOutputStream
    //   192: dup
    //   193: aload 4
    //   195: invokespecial 282	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   198: astore 4
    //   200: aload_3
    //   201: astore_2
    //   202: new 383	java/io/DataOutputStream
    //   205: dup
    //   206: aload 4
    //   208: invokespecial 384	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   211: astore_3
    //   212: iconst_0
    //   213: istore_1
    //   214: iload_1
    //   215: aload_0
    //   216: getfield 51	mobi/beyondpod/services/player/PlayList:_PlayList	Ljava/util/ArrayList;
    //   219: invokevirtual 146	java/util/ArrayList:size	()I
    //   222: if_icmpne +30 -> 252
    //   225: aload 4
    //   227: invokestatic 291	mobi/beyondpod/rsscore/helpers/CoreHelper:sync	(Ljava/io/FileOutputStream;)Z
    //   230: pop
    //   231: aload_3
    //   232: invokevirtual 385	java/io/DataOutputStream:close	()V
    //   235: aload_3
    //   236: ifnull +7 -> 243
    //   239: aload_3
    //   240: invokevirtual 385	java/io/DataOutputStream:close	()V
    //   243: aload_0
    //   244: iconst_0
    //   245: putfield 60	mobi/beyondpod/services/player/PlayList:_PlaylistIsSaving	Z
    //   248: aload 6
    //   250: monitorexit
    //   251: return
    //   252: aload_3
    //   253: aload_0
    //   254: getfield 51	mobi/beyondpod/services/player/PlayList:_PlayList	Ljava/util/ArrayList;
    //   257: iload_1
    //   258: invokevirtual 213	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   261: checkcast 102	mobi/beyondpod/rsscore/Track
    //   264: invokevirtual 305	mobi/beyondpod/rsscore/Track:TrackPath	()Ljava/lang/String;
    //   267: invokevirtual 388	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   270: iload_1
    //   271: iconst_1
    //   272: iadd
    //   273: istore_1
    //   274: goto -60 -> 214
    //   277: astore 4
    //   279: aload 5
    //   281: astore_3
    //   282: aload_3
    //   283: astore_2
    //   284: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   287: ldc_w 377
    //   290: aload 4
    //   292: invokestatic 99	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   295: aload_3
    //   296: ifnull +7 -> 303
    //   299: aload_3
    //   300: invokevirtual 385	java/io/DataOutputStream:close	()V
    //   303: aload_0
    //   304: iconst_0
    //   305: putfield 60	mobi/beyondpod/services/player/PlayList:_PlaylistIsSaving	Z
    //   308: goto -60 -> 248
    //   311: astore_2
    //   312: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   315: ldc_w 377
    //   318: aload_2
    //   319: invokestatic 99	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   322: goto -19 -> 303
    //   325: astore_3
    //   326: aload_2
    //   327: ifnull +7 -> 334
    //   330: aload_2
    //   331: invokevirtual 385	java/io/DataOutputStream:close	()V
    //   334: aload_0
    //   335: iconst_0
    //   336: putfield 60	mobi/beyondpod/services/player/PlayList:_PlaylistIsSaving	Z
    //   339: aload_3
    //   340: athrow
    //   341: astore_2
    //   342: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   345: ldc_w 377
    //   348: aload_2
    //   349: invokestatic 99	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   352: goto -18 -> 334
    //   355: astore_2
    //   356: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   359: ldc_w 377
    //   362: aload_2
    //   363: invokestatic 99	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   366: goto -123 -> 243
    //   369: astore 4
    //   371: aload_3
    //   372: astore_2
    //   373: aload 4
    //   375: astore_3
    //   376: goto -50 -> 326
    //   379: astore 4
    //   381: goto -99 -> 282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	this	PlayList
    //   213	61	1	i	int
    //   48	52	2	localObject1	Object
    //   130	5	2	localObject2	Object
    //   136	8	2	localException1	Exception
    //   151	133	2	localObject3	Object
    //   311	20	2	localException2	Exception
    //   341	8	2	localException3	Exception
    //   355	8	2	localException4	Exception
    //   372	1	2	localObject4	Object
    //   43	257	3	localObject5	Object
    //   325	47	3	localObject6	Object
    //   375	1	3	localObject7	Object
    //   23	203	4	localObject8	Object
    //   277	14	4	localException5	Exception
    //   369	5	4	localObject9	Object
    //   379	1	4	localException6	Exception
    //   45	235	5	localObject10	Object
    //   4	245	6	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   9	19	130	finally
    //   20	42	130	finally
    //   113	121	130	finally
    //   121	129	130	finally
    //   131	134	130	finally
    //   137	147	130	finally
    //   239	243	130	finally
    //   243	248	130	finally
    //   248	251	130	finally
    //   299	303	130	finally
    //   303	308	130	finally
    //   312	322	130	finally
    //   330	334	130	finally
    //   334	341	130	finally
    //   342	352	130	finally
    //   356	366	130	finally
    //   113	121	136	java/lang/Exception
    //   49	54	277	java/lang/Exception
    //   56	66	277	java/lang/Exception
    //   68	80	277	java/lang/Exception
    //   82	90	277	java/lang/Exception
    //   92	98	277	java/lang/Exception
    //   100	109	277	java/lang/Exception
    //   152	187	277	java/lang/Exception
    //   189	200	277	java/lang/Exception
    //   202	212	277	java/lang/Exception
    //   299	303	311	java/lang/Exception
    //   49	54	325	finally
    //   56	66	325	finally
    //   68	80	325	finally
    //   82	90	325	finally
    //   92	98	325	finally
    //   100	109	325	finally
    //   152	187	325	finally
    //   189	200	325	finally
    //   202	212	325	finally
    //   284	295	325	finally
    //   330	334	341	java/lang/Exception
    //   239	243	355	java/lang/Exception
    //   214	235	369	finally
    //   252	270	369	finally
    //   214	235	379	java/lang/Exception
    //   252	270	379	java/lang/Exception
  }
  
  private void SetCurrentTrack(Track paramTrack)
  {
    if (this._CurrentTrack != null) {
      this._CurrentTrack.setCurrentPlayState(-1);
    }
    this._CurrentTrack = paramTrack;
    BeyondPodApplication.MessageBus.PublishEvent(new PlayListEvents.PlayListEvent(this, 1));
    if (this._TrackToDelete != null)
    {
      FeedRepository.DeleteTrackAsync(this._TrackToDelete);
      if (Configuration.ForceMediaDatabaseRescanOnDownloadOrDelete()) {
        MusicUtils.ForceMediaScanFor(this._TrackToDelete.TrackPath());
      }
      this._TrackToDelete = null;
    }
    SaveIndexOfCurrentPlaylistTrackInPlaylist();
  }
  
  public void AddTrack(Track paramTrack)
  {
    AddTrackIntrnal(paramTrack);
    this._IsManuallyModified = true;
    NotifyPlaylistChanged();
    SaveToFileAsync();
  }
  
  public void AddTracks(List<Track> paramList)
  {
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext())
      {
        this._IsManuallyModified = true;
        NotifyPlaylistChanged();
        SaveToFileAsync();
        return;
      }
      AddTrackIntrnal((Track)paramList.next());
    }
  }
  
  public boolean CanAddToPlaylist(Track paramTrack)
  {
    return CanAddToPlaylist(paramTrack, this._PlayList);
  }
  
  public void Clear()
  {
    LoadTracks(null, false);
  }
  
  void ClearCurrentTrack()
  {
    SetCurrentTrack(null);
  }
  
  public Track CurrentTrack()
  {
    return this._CurrentTrack;
  }
  
  public void ExecuteActionPlayNextPosition(int paramInt)
  {
    if (Configuration.DefferAutoSyncSmartPlay())
    {
      ClearCurrentTrack();
      CoreHelper.WriteTraceEntry(TAG, "SmartPlay sync - Detected pending deffered rebuild at the end of playback. SmartPlay will be restarted.");
      Configuration.setDefferAutoSyncSmartPlay(false);
      RebuildSmartPlay(false, true);
      return;
    }
    int i = GetCurrentPlayingTrackPosition();
    int j = PrepareNextPosition(Configuration.RemovePlayedFromPlaylist());
    if (j >= 0)
    {
      CommandManagerBase.CmdPlayPosition(j);
      CoreHelper.WriteTraceEntry(TAG, "Starting playback of the next track:" + i + " -> " + j);
      return;
    }
    if (paramInt == 1)
    {
      CoreHelper.WriteTraceEntry(TAG, "Playlist ended and will be cleared!");
      LoadTracks(null, false);
      BeyondPodApplication.MessageBus.PublishEvent(new PlayListEvents.PlayListEvent(this, 3));
      return;
    }
    if (paramInt == 2)
    {
      ClearCurrentTrack();
      CoreHelper.WriteTraceEntry(TAG, "Playlist ended and SmartPlay will be restarted!");
      RebuildSmartPlay(false, true);
      return;
    }
    ClearPlayedIfNeeded();
  }
  
  public int GetCurrentPlayingTrackPosition()
  {
    if (this._CurrentTrack != null) {
      return GetTrackPosition(this._CurrentTrack);
    }
    return -1;
  }
  
  public int GetNextTrackPosition()
  {
    int i = GetCurrentPlayingTrackPosition();
    if ((i >= 0) && (i < PlaylistSize() - 1)) {
      return i + 1;
    }
    if (this._PlayList.size() > 0) {
      return 0;
    }
    return -1;
  }
  
  public Track GetNextVideoTrack(Track paramTrack)
  {
    int i = GetTrackPosition(paramTrack);
    if (i < 0)
    {
      i = 0;
      if ((i < 0) || (i > PlaylistSize() - 1)) {}
    }
    for (;;)
    {
      if (i >= PlaylistSize()) {
        paramTrack = null;
      }
      Track localTrack;
      do
      {
        return paramTrack;
        i += 1;
        break;
        localTrack = (Track)this._PlayList.get(i);
        paramTrack = localTrack;
      } while (localTrack.ContentType() == 2);
      i += 1;
    }
  }
  
  public int GetPreviousTrackPosition()
  {
    int i = GetCurrentPlayingTrackPosition();
    if (i > 0) {
      return i - 1;
    }
    if (this._PlayList.size() > 0) {
      return 0;
    }
    return -1;
  }
  
  public Track GetPreviousVideoTrack(Track paramTrack)
  {
    int i = GetTrackPosition(paramTrack);
    if (i < 0)
    {
      i = PlaylistSize() - 1;
      if ((i < 0) || (i > PlaylistSize() - 1)) {}
    }
    for (;;)
    {
      if (i < 0) {
        paramTrack = null;
      }
      Track localTrack;
      do
      {
        return paramTrack;
        i -= 1;
        break;
        localTrack = (Track)this._PlayList.get(i);
        paramTrack = localTrack;
      } while (localTrack.ContentType() == 2);
      i -= 1;
    }
  }
  
  public Track GetTrackAtPosition(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < PlaylistSize())) {
      return (Track)this._PlayList.get(paramInt);
    }
    return null;
  }
  
  public int GetTrackPosition(Track paramTrack)
  {
    return this._PlayList.indexOf(paramTrack);
  }
  
  public List<Track> GetTracks()
  {
    return this._PlayList;
  }
  
  public boolean HasEpisodesToDownload()
  {
    Iterator localIterator = this._PlayList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
    } while (((Track)localIterator.next()).IsFullyDownloaded());
    return true;
  }
  
  public boolean HasTrack(Track paramTrack)
  {
    return this._PlayList.contains(paramTrack);
  }
  
  /* Error */
  public void LoadFromFile()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: getfield 51	mobi/beyondpod/services/player/PlayList:_PlayList	Ljava/util/ArrayList;
    //   9: invokevirtual 469	java/util/ArrayList:clear	()V
    //   12: new 48	java/util/ArrayList
    //   15: dup
    //   16: invokespecial 49	java/util/ArrayList:<init>	()V
    //   19: astore 7
    //   21: new 260	java/io/File
    //   24: dup
    //   25: invokestatic 366	mobi/beyondpod/rsscore/Configuration:PlaylistFilePath	()Ljava/lang/String;
    //   28: invokespecial 264	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore 5
    //   33: aload 5
    //   35: invokevirtual 267	java/io/File:exists	()Z
    //   38: ifeq +160 -> 198
    //   41: new 471	java/io/FileInputStream
    //   44: dup
    //   45: aload 5
    //   47: invokespecial 474	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   50: astore 5
    //   52: new 476	java/io/DataInputStream
    //   55: dup
    //   56: aload 5
    //   58: invokespecial 479	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore 8
    //   63: aconst_null
    //   64: astore 4
    //   66: aload 4
    //   68: astore_3
    //   69: aload 8
    //   71: invokevirtual 482	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   74: astore 9
    //   76: aload 4
    //   78: astore_3
    //   79: aload 9
    //   81: invokestatic 486	mobi/beyondpod/rsscore/repository/FeedRepository:GetTrackByPath	(Ljava/lang/String;)Lmobi/beyondpod/rsscore/Track;
    //   84: astore 6
    //   86: aload 6
    //   88: astore 4
    //   90: aload 6
    //   92: ifnonnull +16 -> 108
    //   95: aload 6
    //   97: astore_3
    //   98: aload 9
    //   100: invokestatic 490	mobi/beyondpod/rsscore/repository/FeedRepository:PatchRootPath	(Ljava/lang/String;)Ljava/lang/String;
    //   103: invokestatic 486	mobi/beyondpod/rsscore/repository/FeedRepository:GetTrackByPath	(Ljava/lang/String;)Lmobi/beyondpod/rsscore/Track;
    //   106: astore 4
    //   108: aload 4
    //   110: astore_3
    //   111: aload 4
    //   113: ifnonnull +39 -> 152
    //   116: aload 4
    //   118: astore_3
    //   119: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   122: new 152	java/lang/StringBuilder
    //   125: dup
    //   126: ldc_w 492
    //   129: invokespecial 157	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: aload 9
    //   134: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc_w 494
    //   140: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 497	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteLogEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload 4
    //   151: astore_3
    //   152: aload_3
    //   153: ifnull -90 -> 63
    //   156: aload 7
    //   158: aload_3
    //   159: invokevirtual 89	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   162: pop
    //   163: goto -100 -> 63
    //   166: astore_3
    //   167: aload 5
    //   169: astore 4
    //   171: aload_3
    //   172: astore 5
    //   174: aload 4
    //   176: astore_3
    //   177: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   180: ldc_w 499
    //   183: aload 5
    //   185: invokestatic 99	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: aload 4
    //   190: ifnull +8 -> 198
    //   193: aload 4
    //   195: invokevirtual 500	java/io/FileInputStream:close	()V
    //   198: aload_0
    //   199: invokestatic 503	mobi/beyondpod/rsscore/Configuration:IsCurrentPlaylistManuallyModified	()Z
    //   202: putfield 53	mobi/beyondpod/services/player/PlayList:_IsManuallyModified	Z
    //   205: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   208: new 152	java/lang/StringBuilder
    //   211: dup
    //   212: ldc_w 505
    //   215: invokespecial 157	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   218: aload_0
    //   219: getfield 51	mobi/beyondpod/services/player/PlayList:_PlayList	Ljava/util/ArrayList;
    //   222: invokevirtual 146	java/util/ArrayList:size	()I
    //   225: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   228: ldc_w 507
    //   231: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokestatic 510	mobi/beyondpod/rsscore/Configuration:PlaylistSizeOnSave	()I
    //   237: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   240: ldc_w 512
    //   243: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 173	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload_0
    //   253: getfield 51	mobi/beyondpod/services/player/PlayList:_PlayList	Ljava/util/ArrayList;
    //   256: invokevirtual 146	java/util/ArrayList:size	()I
    //   259: invokestatic 510	mobi/beyondpod/rsscore/Configuration:PlaylistSizeOnSave	()I
    //   262: if_icmpeq +12 -> 274
    //   265: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   268: ldc_w 514
    //   271: invokestatic 517	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntryInDebug	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: return
    //   275: astore_3
    //   276: aload 5
    //   278: invokevirtual 500	java/io/FileInputStream:close	()V
    //   281: aload 7
    //   283: invokevirtual 146	java/util/ArrayList:size	()I
    //   286: ifle +78 -> 364
    //   289: aload_0
    //   290: getfield 51	mobi/beyondpod/services/player/PlayList:_PlayList	Ljava/util/ArrayList;
    //   293: aload 7
    //   295: invokevirtual 521	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   298: pop
    //   299: invokestatic 339	mobi/beyondpod/rsscore/Configuration:IndexOfCurrentPlaylistTrackInPlaylist	()I
    //   302: istore_2
    //   303: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   306: new 152	java/lang/StringBuilder
    //   309: dup
    //   310: ldc_w 523
    //   313: invokespecial 157	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   316: iload_2
    //   317: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   320: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 526	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteLogEntryInProduction	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: iload_2
    //   327: iflt +16 -> 343
    //   330: iload_2
    //   331: istore_1
    //   332: iload_2
    //   333: aload_0
    //   334: getfield 51	mobi/beyondpod/services/player/PlayList:_PlayList	Ljava/util/ArrayList;
    //   337: invokevirtual 146	java/util/ArrayList:size	()I
    //   340: if_icmplt +14 -> 354
    //   343: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   346: ldc_w 528
    //   349: invokestatic 526	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteLogEntryInProduction	(Ljava/lang/String;Ljava/lang/String;)V
    //   352: iconst_0
    //   353: istore_1
    //   354: aload_0
    //   355: iload_1
    //   356: invokevirtual 330	mobi/beyondpod/services/player/PlayList:SetCurrentTrack	(I)Lmobi/beyondpod/rsscore/Track;
    //   359: pop
    //   360: aload_0
    //   361: invokespecial 410	mobi/beyondpod/services/player/PlayList:NotifyPlaylistChanged	()V
    //   364: aload 5
    //   366: ifnull +63 -> 429
    //   369: aload 5
    //   371: invokevirtual 500	java/io/FileInputStream:close	()V
    //   374: goto -176 -> 198
    //   377: astore_3
    //   378: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   381: ldc_w 530
    //   384: aload_3
    //   385: invokestatic 99	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   388: goto -190 -> 198
    //   391: astore 4
    //   393: aload_3
    //   394: ifnull +7 -> 401
    //   397: aload_3
    //   398: invokevirtual 500	java/io/FileInputStream:close	()V
    //   401: aload 4
    //   403: athrow
    //   404: astore_3
    //   405: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   408: ldc_w 530
    //   411: aload_3
    //   412: invokestatic 99	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   415: goto -14 -> 401
    //   418: astore_3
    //   419: getstatic 42	mobi/beyondpod/services/player/PlayList:TAG	Ljava/lang/String;
    //   422: ldc_w 530
    //   425: aload_3
    //   426: invokestatic 99	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   429: goto -231 -> 198
    //   432: astore 4
    //   434: aload 5
    //   436: astore_3
    //   437: goto -44 -> 393
    //   440: astore 5
    //   442: goto -268 -> 174
    //   445: astore 4
    //   447: goto -295 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	450	0	this	PlayList
    //   331	25	1	i	int
    //   302	39	2	j	int
    //   1	158	3	localObject1	Object
    //   166	6	3	localException1	Exception
    //   176	1	3	localObject2	Object
    //   275	1	3	localEOFException	java.io.EOFException
    //   377	21	3	localException2	Exception
    //   404	8	3	localException3	Exception
    //   418	8	3	localException4	Exception
    //   436	1	3	localObject3	Object
    //   3	191	4	localObject4	Object
    //   391	11	4	localObject5	Object
    //   432	1	4	localObject6	Object
    //   445	1	4	localException5	Exception
    //   31	404	5	localObject7	Object
    //   440	1	5	localException6	Exception
    //   84	12	6	localTrack	Track
    //   19	275	7	localArrayList	ArrayList
    //   61	9	8	localDataInputStream	java.io.DataInputStream
    //   74	59	9	str	String
    // Exception table:
    //   from	to	target	type
    //   52	63	166	java/lang/Exception
    //   156	163	166	java/lang/Exception
    //   276	326	166	java/lang/Exception
    //   332	343	166	java/lang/Exception
    //   343	352	166	java/lang/Exception
    //   354	364	166	java/lang/Exception
    //   69	76	275	java/io/EOFException
    //   79	86	275	java/io/EOFException
    //   98	108	275	java/io/EOFException
    //   119	149	275	java/io/EOFException
    //   193	198	377	java/lang/Exception
    //   41	52	391	finally
    //   177	188	391	finally
    //   397	401	404	java/lang/Exception
    //   369	374	418	java/lang/Exception
    //   52	63	432	finally
    //   69	76	432	finally
    //   79	86	432	finally
    //   98	108	432	finally
    //   119	149	432	finally
    //   156	163	432	finally
    //   276	326	432	finally
    //   332	343	432	finally
    //   343	352	432	finally
    //   354	364	432	finally
    //   41	52	440	java/lang/Exception
    //   69	76	445	java/lang/Exception
    //   79	86	445	java/lang/Exception
    //   98	108	445	java/lang/Exception
    //   119	149	445	java/lang/Exception
  }
  
  public void LoadTracks(Collection<Track> paramCollection, boolean paramBoolean)
  {
    CommandManagerBase.CmdStopPlayback();
    this._PlayList.clear();
    if (paramCollection != null) {}
    for (;;)
    {
      try
      {
        paramCollection = paramCollection.iterator();
        boolean bool = paramCollection.hasNext();
        if (bool) {
          continue;
        }
      }
      catch (ArrayIndexOutOfBoundsException paramCollection)
      {
        Track localTrack;
        CoreHelper.LogException(TAG, "Failed to append to playlist!", paramCollection);
        continue;
      }
      SetCurrentTrack(null);
      this._IsManuallyModified = paramBoolean;
      NotifyPlaylistChanged();
      SaveToFileAsync();
      return;
      localTrack = (Track)paramCollection.next();
      if (CanAddToPlaylist(localTrack)) {
        this._PlayList.add(localTrack);
      }
    }
  }
  
  public void MoveTrack(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {}
    Track localTrack;
    do
    {
      return;
      localTrack = GetTrackAtPosition(paramInt1);
    } while ((localTrack == null) || (paramInt2 < 0) || (paramInt2 >= PlaylistSize()));
    this._PlayList.remove(localTrack);
    this._PlayList.add(paramInt2, localTrack);
    this._IsManuallyModified = true;
    NotifyPlaylistChanged();
    SaveToFileAsync();
  }
  
  public void MoveTracks(List<Track> paramList, int paramInt)
  {
    if ((paramList.size() < 1) || (this._PlayList.size() < 2)) {
      return;
    }
    this._PlayList.removeAll(paramList);
    ArrayList localArrayList = this._PlayList;
    if (paramInt == 1) {}
    for (paramInt = 0;; paramInt = this._PlayList.size())
    {
      localArrayList.addAll(paramInt, paramList);
      this._IsManuallyModified = true;
      NotifyPlaylistChanged();
      SaveToFileAsync();
      return;
    }
  }
  
  public void OnRepositoryEvent(RepositoryEvents.RepositoryEvent paramRepositoryEvent)
  {
    if (paramRepositoryEvent.Type == 10)
    {
      boolean bool = this._IsManuallyModified;
      RemoveTrack(paramRepositoryEvent.Track);
      this._IsManuallyModified = bool;
    }
  }
  
  public void OnTrackPlayStateCahged(Track paramTrack)
  {
    BeyondPodApplication.MessageBus.PublishEvent(new PlayListEvents.PlayListEvent(this, 2));
  }
  
  public void OnTrackPlaybackComplete(boolean paramBoolean)
  {
    if (this._CurrentTrack == null) {}
    do
    {
      return;
      ItemStateHistory.MarkTracksItemAsRead(this._CurrentTrack);
      int i = Configuration.PlaylistEndAction();
      if (paramBoolean) {
        i = 0;
      }
      if (Configuration.getMediaEndAction() == 2)
      {
        ExecuteActionDoNothing();
        return;
      }
      if (Configuration.getMediaEndAction() == 0)
      {
        ExecuteActionPlayNextPosition(i);
        return;
      }
      if (Configuration.getMediaEndAction() == 1)
      {
        ExecuteActionDeleteCurrentTrackIfAllowed();
        ExecuteActionPlayNextPosition(i);
        return;
      }
    } while (Configuration.getMediaEndAction() != 3);
    ExecuteActionDeleteCurrentTrackIfAllowed();
    ExecuteActionDoNothing();
  }
  
  public int PlaylistSize()
  {
    return this._PlayList.size();
  }
  
  public CoreHelper.TrackSizeInfo PlaylistTotalTime()
  {
    CoreHelper.TrackSizeInfo localTrackSizeInfo = new CoreHelper.TrackSizeInfo();
    Iterator localIterator = this._PlayList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localTrackSizeInfo;
      }
      Track localTrack = (Track)localIterator.next();
      localTrackSizeInfo.SizeOnDisk += localTrack.getSizeOnDisk();
      localTrackSizeInfo.TotalTime += localTrack.getTotalTime();
      if (localTrack.getTotalTime() == 0L) {
        localTrackSizeInfo.TotalTimeIsApproximate = true;
      }
    }
  }
  
  public void RebuildSmartPlay(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!SmartPlaylistTemplate.IsConfigured())
    {
      CoreHelper.WriteTraceEntry(TAG, "Trying to restart SmartPlay but SmartPlay is not configured! Ignoring...");
      return;
    }
    List localList = new SmartPlaylistTemplate().GeneratePlaylist();
    if (paramBoolean1)
    {
      Track localTrack = BeyondPodApplication.GetInstance().PlayList().CurrentTrack();
      if ((localTrack != null) && (localTrack.IsPartialyPlayed()))
      {
        localList.add(0, localTrack);
        CoreHelper.WriteTraceEntry(TAG, "Restarting SmartPlay and keeping the current playing track '" + localTrack.getName() + "' at the top.");
      }
    }
    for (;;)
    {
      if (localList.size() <= 0) {
        break label180;
      }
      if (IsCurrentlyPlaying()) {
        CommandManagerBase.CmdStopPlayback();
      }
      LoadTracks(localList, false);
      SetCurrentTrack(0);
      CoreHelper.WriteTraceEntry(TAG, "SmartPlaylist replaced! New Playlist size: " + localList.size());
      if (!paramBoolean2) {
        break;
      }
      CoreHelper.WriteTraceEntry(TAG, "Starting automatic playback of the first track");
      CommandManagerBase.CmdPlayPosition(0);
      return;
      Clear();
    }
    label180:
    CoreHelper.WriteTraceEntry(TAG, "SmartPlaylist is empty! Clearing the playlist...");
    Clear();
  }
  
  public void RemoveTrack(Track paramTrack)
  {
    if (RemoveTrackInternal(paramTrack))
    {
      NotifyPlaylistChanged();
      SaveToFileAsync();
    }
  }
  
  public void RemoveTracks(List<Track> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    paramList = paramList.iterator();
    if (!paramList.hasNext())
    {
      if (this._PlayList.size() != 0) {
        break label97;
      }
      ClearCurrentTrack();
    }
    for (;;)
    {
      NotifyPlaylistChanged();
      SaveToFileAsync();
      return;
      Track localTrack = (Track)paramList.next();
      if (localTrack == this._CurrentTrack) {
        CommandManagerBase.CmdStopPlayback();
      }
      if (!this._PlayList.contains(localTrack)) {
        break;
      }
      this._PlayList.remove(localTrack);
      break;
      label97:
      if (GetTrackPosition(this._CurrentTrack) < 0)
      {
        SetCurrentTrack(0);
        CommandManagerBase.CmdLoadCurrentTrack();
      }
    }
  }
  
  public Track SetCurrentTrack(int paramInt)
  {
    Track localTrack = GetTrackAtPosition(paramInt);
    if (localTrack != null) {
      SetCurrentTrack(localTrack);
    }
    return this._CurrentTrack;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/PlayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */