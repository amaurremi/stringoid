package mobi.beyondpod.rsscore.repository;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackDictionary;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.FileUtils;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.schedulercore.ScheduledTask;
import mobi.beyondpod.schedulercore.ScheduledTasksManager;
import mobi.beyondpod.services.player.PlayList;
import mobi.beyondpod.sync.ChangeTracker;

public class SQLRepositoryStorage
  implements IRepositoryStorage
{
  private static final int REPO_MOVED_BP_DLG = 2;
  private static final int REPO_MOVED_EXTERNAL = 1;
  private static final int REPO_NOT_MOVED = 0;
  private static final String TAG = "SQLRepositoryStorage";
  
  private static int CheckIfRepositryRootHasMoved()
  {
    int j = 0;
    int i;
    if (!StringUtils.IsNullOrEmpty(Configuration.getRepoMovedPath()))
    {
      i = 2;
      return i;
    }
    Iterator localIterator = FeedRepository.getRootFeed().SubFeeds().iterator();
    Feed localFeed;
    do
    {
      do
      {
        i = j;
        if (!localIterator.hasNext()) {
          break;
        }
        localFeed = (Feed)localIterator.next();
      } while ((!localFeed.HasUrl()) || (localFeed.getFeedPath() == null));
      i = j;
      if (localFeed.DownloadPathExists()) {
        break;
      }
    } while (!FileUtils.DirectoryExists(FeedRepository.PatchRootPath(localFeed.getFeedPath())));
    return 1;
  }
  
  private TrackDictionary LoadRepositoryTables()
  {
    TrackDictionary localTrackDictionary2 = null;
    DatabaseHelper localDatabaseHelper = new DatabaseHelper(BeyondPodApplication.GetInstance().getApplicationContext());
    TrackDictionary localTrackDictionary1 = localTrackDictionary2;
    try
    {
      localDatabaseHelper.LoadCategories();
      localTrackDictionary1 = localTrackDictionary2;
      localDatabaseHelper.LoadTasks();
      localTrackDictionary1 = localTrackDictionary2;
      localDatabaseHelper.LoadFeeds(FeedRepository.getRootFeed());
      localTrackDictionary1 = localTrackDictionary2;
      localTrackDictionary2 = localDatabaseHelper.LoadTracks();
      localTrackDictionary1 = localTrackDictionary2;
      FeedRepository.RepositoryLoadKind = 1;
      localTrackDictionary1 = localTrackDictionary2;
      FeedRepository.OnRepositoryScaningForChanges();
      return localTrackDictionary2;
    }
    catch (Exception localException)
    {
      CoreHelper.LogException("SQLRepositoryStorage", "Unable to load the repository from database", localException);
      return localTrackDictionary1;
    }
    finally
    {
      localDatabaseHelper.cleanup();
    }
  }
  
  private static void PatchRepositoryRoot(TrackDictionary paramTrackDictionary, int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    boolean bool;
    Object localObject;
    label22:
    Iterator localIterator;
    if (paramInt == 2)
    {
      bool = true;
      localObject = FeedRepository.getRootFeed().SubFeeds().iterator();
      if (((Iterator)localObject).hasNext()) {
        break label79;
      }
      localObject = new TrackDictionary();
      localIterator = paramTrackDictionary.values().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        paramTrackDictionary.clear();
        paramTrackDictionary.putAll((Map)localObject);
        Configuration.setRepoMovedPath(null);
        return;
        bool = false;
        break;
        label79:
        ((Feed)((Iterator)localObject).next()).PatchFeedPathForCurrentRoot(bool);
        break label22;
      }
      Track localTrack = (Track)localIterator.next();
      if (localTrack != null)
      {
        localTrack.PatchTrackPathForCurrentRoot(bool);
        ((TrackDictionary)localObject).put(localTrack.TrackPath(), localTrack);
      }
    }
  }
  
  /* Error */
  private int VerifyAndPatchAudioRecords()
  {
    // Byte code:
    //   0: ldc 17
    //   2: ldc -83
    //   4: invokestatic 177	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: iconst_0
    //   8: istore_2
    //   9: iconst_0
    //   10: istore_3
    //   11: iconst_0
    //   12: istore_1
    //   13: iconst_0
    //   14: istore 4
    //   16: invokestatic 94	mobi/beyondpod/BeyondPodApplication:GetInstance	()Lmobi/beyondpod/BeyondPodApplication;
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokestatic 183	mobi/beyondpod/ui/core/MusicUtils:getAudioCursor	(Landroid/content/Context;Ljava/lang/String;Landroid/net/Uri;)Landroid/database/Cursor;
    //   24: astore 6
    //   26: aload 6
    //   28: ifnull +61 -> 89
    //   31: ldc 17
    //   33: new 185	java/lang/StringBuilder
    //   36: dup
    //   37: ldc -69
    //   39: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: aload 6
    //   44: invokeinterface 194 1 0
    //   49: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: ldc -56
    //   54: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 177	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: iload 4
    //   65: istore_1
    //   66: iload_3
    //   67: istore_2
    //   68: aload 6
    //   70: invokeinterface 209 1 0
    //   75: istore 5
    //   77: iload 5
    //   79: ifeq +42 -> 121
    //   82: aload 6
    //   84: invokeinterface 212 1 0
    //   89: ldc 17
    //   91: new 185	java/lang/StringBuilder
    //   94: dup
    //   95: ldc -42
    //   97: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: iload_2
    //   101: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: ldc -40
    //   106: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: iload_1
    //   110: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 177	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: iload_1
    //   120: ireturn
    //   121: aload 6
    //   123: aload 6
    //   125: ldc -38
    //   127: invokeinterface 222 2 0
    //   132: invokeinterface 226 2 0
    //   137: astore 7
    //   139: iload_2
    //   140: istore_3
    //   141: iload_1
    //   142: istore 4
    //   144: aload 7
    //   146: invokestatic 36	mobi/beyondpod/rsscore/helpers/StringUtils:IsNullOrEmpty	(Ljava/lang/String;)Z
    //   149: ifne +66 -> 215
    //   152: getstatic 230	mobi/beyondpod/rsscore/repository/FeedRepository:_TrackDictionary	Lmobi/beyondpod/rsscore/TrackDictionary;
    //   155: aload 7
    //   157: invokevirtual 234	mobi/beyondpod/rsscore/TrackDictionary:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   160: checkcast 160	mobi/beyondpod/rsscore/Track
    //   163: astore 7
    //   165: iload_2
    //   166: istore_3
    //   167: iload_1
    //   168: istore 4
    //   170: aload 7
    //   172: ifnull +43 -> 215
    //   175: iload_2
    //   176: iconst_1
    //   177: iadd
    //   178: istore_2
    //   179: iload_2
    //   180: istore_3
    //   181: iload_1
    //   182: istore 4
    //   184: aload 7
    //   186: aload 6
    //   188: invokestatic 238	mobi/beyondpod/ui/core/MusicUtils:AudioTrackImageMatchesDatabase	(Lmobi/beyondpod/rsscore/Track;Landroid/database/Cursor;)Z
    //   191: ifne +24 -> 215
    //   194: aload 7
    //   196: aconst_null
    //   197: invokevirtual 241	mobi/beyondpod/rsscore/Track:setTrackImagePath	(Ljava/lang/String;)V
    //   200: aload 7
    //   202: aload 6
    //   204: invokevirtual 245	mobi/beyondpod/rsscore/Track:EnsureTrackHasContentTypeAndImage	(Landroid/database/Cursor;)Z
    //   207: pop
    //   208: iload_1
    //   209: iconst_1
    //   210: iadd
    //   211: istore 4
    //   213: iload_2
    //   214: istore_3
    //   215: aload 6
    //   217: invokeinterface 248 1 0
    //   222: pop
    //   223: iload_3
    //   224: istore_2
    //   225: iload 4
    //   227: istore_1
    //   228: goto -160 -> 68
    //   231: astore 7
    //   233: aload 6
    //   235: invokeinterface 212 1 0
    //   240: aload 7
    //   242: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	SQLRepositoryStorage
    //   12	216	1	i	int
    //   8	217	2	j	int
    //   10	214	3	k	int
    //   14	212	4	m	int
    //   75	3	5	bool	boolean
    //   24	210	6	localCursor	android.database.Cursor
    //   137	64	7	localObject1	Object
    //   231	10	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   31	63	231	finally
    //   68	77	231	finally
    //   121	139	231	finally
    //   144	165	231	finally
    //   184	208	231	finally
    //   215	223	231	finally
  }
  
  /* Error */
  private int VerifyAndPatchVideoRecords()
  {
    // Byte code:
    //   0: ldc 17
    //   2: ldc -5
    //   4: invokestatic 177	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: iconst_0
    //   8: istore_2
    //   9: iconst_0
    //   10: istore_3
    //   11: iconst_0
    //   12: istore_1
    //   13: iconst_0
    //   14: istore 4
    //   16: invokestatic 94	mobi/beyondpod/BeyondPodApplication:GetInstance	()Lmobi/beyondpod/BeyondPodApplication;
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokestatic 254	mobi/beyondpod/ui/core/MusicUtils:getVideoCursor	(Landroid/content/Context;Ljava/lang/String;Landroid/net/Uri;)Landroid/database/Cursor;
    //   24: astore 6
    //   26: aload 6
    //   28: ifnull +62 -> 90
    //   31: ldc 17
    //   33: new 185	java/lang/StringBuilder
    //   36: dup
    //   37: ldc -69
    //   39: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: aload 6
    //   44: invokeinterface 194 1 0
    //   49: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: ldc_w 256
    //   55: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 177	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: iload 4
    //   66: istore_1
    //   67: iload_3
    //   68: istore_2
    //   69: aload 6
    //   71: invokeinterface 209 1 0
    //   76: istore 5
    //   78: iload 5
    //   80: ifeq +43 -> 123
    //   83: aload 6
    //   85: invokeinterface 212 1 0
    //   90: ldc 17
    //   92: new 185	java/lang/StringBuilder
    //   95: dup
    //   96: ldc_w 258
    //   99: invokespecial 189	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   102: iload_2
    //   103: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: ldc -40
    //   108: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: iload_1
    //   112: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 177	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: iload_1
    //   122: ireturn
    //   123: aload 6
    //   125: aload 6
    //   127: ldc -38
    //   129: invokeinterface 222 2 0
    //   134: invokeinterface 226 2 0
    //   139: astore 7
    //   141: iload_2
    //   142: istore_3
    //   143: iload_1
    //   144: istore 4
    //   146: aload 7
    //   148: invokestatic 36	mobi/beyondpod/rsscore/helpers/StringUtils:IsNullOrEmpty	(Ljava/lang/String;)Z
    //   151: ifne +66 -> 217
    //   154: getstatic 230	mobi/beyondpod/rsscore/repository/FeedRepository:_TrackDictionary	Lmobi/beyondpod/rsscore/TrackDictionary;
    //   157: aload 7
    //   159: invokevirtual 234	mobi/beyondpod/rsscore/TrackDictionary:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   162: checkcast 160	mobi/beyondpod/rsscore/Track
    //   165: astore 7
    //   167: iload_2
    //   168: istore_3
    //   169: iload_1
    //   170: istore 4
    //   172: aload 7
    //   174: ifnull +43 -> 217
    //   177: iload_2
    //   178: iconst_1
    //   179: iadd
    //   180: istore_2
    //   181: iload_2
    //   182: istore_3
    //   183: iload_1
    //   184: istore 4
    //   186: aload 7
    //   188: aload 6
    //   190: invokestatic 261	mobi/beyondpod/ui/core/MusicUtils:VideoTrackImageMatchesDatabase	(Lmobi/beyondpod/rsscore/Track;Landroid/database/Cursor;)Z
    //   193: ifne +24 -> 217
    //   196: aload 7
    //   198: aconst_null
    //   199: invokevirtual 241	mobi/beyondpod/rsscore/Track:setTrackImagePath	(Ljava/lang/String;)V
    //   202: aload 7
    //   204: aload 6
    //   206: invokevirtual 245	mobi/beyondpod/rsscore/Track:EnsureTrackHasContentTypeAndImage	(Landroid/database/Cursor;)Z
    //   209: pop
    //   210: iload_1
    //   211: iconst_1
    //   212: iadd
    //   213: istore 4
    //   215: iload_2
    //   216: istore_3
    //   217: aload 6
    //   219: invokeinterface 248 1 0
    //   224: pop
    //   225: iload_3
    //   226: istore_2
    //   227: iload 4
    //   229: istore_1
    //   230: goto -161 -> 69
    //   233: astore 7
    //   235: aload 6
    //   237: invokeinterface 212 1 0
    //   242: aload 7
    //   244: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	SQLRepositoryStorage
    //   12	218	1	i	int
    //   8	219	2	j	int
    //   10	216	3	k	int
    //   14	214	4	m	int
    //   76	3	5	bool	boolean
    //   24	212	6	localCursor	android.database.Cursor
    //   139	64	7	localObject1	Object
    //   233	10	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   31	64	233	finally
    //   69	78	233	finally
    //   123	141	233	finally
    //   146	167	233	finally
    //   186	210	233	finally
    //   217	225	233	finally
  }
  
  public void DeleteFeed(Feed paramFeed)
  {
    DatabaseHelper localDatabaseHelper = new DatabaseHelper(BeyondPodApplication.GetInstance().getApplicationContext());
    try
    {
      localDatabaseHelper.DeleteFeed(paramFeed);
      return;
    }
    catch (Exception paramFeed)
    {
      CoreHelper.LogException("SQLRepositoryStorage", "Unable to delete feed from database", paramFeed);
      return;
    }
    finally
    {
      localDatabaseHelper.cleanup();
    }
  }
  
  public void DeleteRepositoryFiles() {}
  
  public void DeleteTask(ScheduledTask paramScheduledTask)
  {
    DatabaseHelper localDatabaseHelper = new DatabaseHelper(BeyondPodApplication.GetInstance().getApplicationContext());
    try
    {
      localDatabaseHelper.DeleteTask(paramScheduledTask);
      return;
    }
    catch (Exception paramScheduledTask)
    {
      CoreHelper.LogException("SQLRepositoryStorage", "Unable to delete task from database", paramScheduledTask);
      return;
    }
    finally
    {
      localDatabaseHelper.cleanup();
    }
  }
  
  public void DeleteTrack(Track paramTrack)
  {
    TrackList localTrackList = new TrackList();
    localTrackList.add(paramTrack);
    DeleteTracks(localTrackList);
  }
  
  /* Error */
  public void DeleteTracks(TrackList paramTrackList)
  {
    // Byte code:
    //   0: new 88	mobi/beyondpod/rsscore/repository/DatabaseHelper
    //   3: dup
    //   4: invokestatic 94	mobi/beyondpod/BeyondPodApplication:GetInstance	()Lmobi/beyondpod/BeyondPodApplication;
    //   7: invokevirtual 98	mobi/beyondpod/BeyondPodApplication:getApplicationContext	()Landroid/content/Context;
    //   10: invokespecial 101	mobi/beyondpod/rsscore/repository/DatabaseHelper:<init>	(Landroid/content/Context;)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 289	mobi/beyondpod/rsscore/repository/DatabaseHelper:beginTransaction	()V
    //   18: aload_1
    //   19: invokevirtual 290	mobi/beyondpod/rsscore/TrackList:iterator	()Ljava/util/Iterator;
    //   22: astore_1
    //   23: aload_1
    //   24: invokeinterface 60 1 0
    //   29: ifne +16 -> 45
    //   32: aload_2
    //   33: invokevirtual 293	mobi/beyondpod/rsscore/repository/DatabaseHelper:setTransactionSuccessful	()V
    //   36: aload_2
    //   37: invokevirtual 296	mobi/beyondpod/rsscore/repository/DatabaseHelper:endTransaction	()V
    //   40: aload_2
    //   41: invokevirtual 123	mobi/beyondpod/rsscore/repository/DatabaseHelper:cleanup	()V
    //   44: return
    //   45: aload_2
    //   46: aload_1
    //   47: invokeinterface 64 1 0
    //   52: checkcast 160	mobi/beyondpod/rsscore/Track
    //   55: invokevirtual 298	mobi/beyondpod/rsscore/repository/DatabaseHelper:DeleteTrack	(Lmobi/beyondpod/rsscore/Track;)V
    //   58: goto -35 -> 23
    //   61: astore_1
    //   62: ldc 17
    //   64: ldc_w 300
    //   67: aload_1
    //   68: invokestatic 131	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   71: aload_2
    //   72: invokevirtual 296	mobi/beyondpod/rsscore/repository/DatabaseHelper:endTransaction	()V
    //   75: aload_2
    //   76: invokevirtual 123	mobi/beyondpod/rsscore/repository/DatabaseHelper:cleanup	()V
    //   79: return
    //   80: astore_1
    //   81: aload_2
    //   82: invokevirtual 296	mobi/beyondpod/rsscore/repository/DatabaseHelper:endTransaction	()V
    //   85: aload_2
    //   86: invokevirtual 123	mobi/beyondpod/rsscore/repository/DatabaseHelper:cleanup	()V
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	SQLRepositoryStorage
    //   0	91	1	paramTrackList	TrackList
    //   13	73	2	localDatabaseHelper	DatabaseHelper
    // Exception table:
    //   from	to	target	type
    //   18	23	61	java/lang/Exception
    //   23	36	61	java/lang/Exception
    //   45	58	61	java/lang/Exception
    //   18	23	80	finally
    //   23	36	80	finally
    //   45	58	80	finally
    //   62	71	80	finally
  }
  
  public void LoadRepository()
  {
    if (!DatabaseHelper.DataBaseExists())
    {
      CoreHelper.WriteLogEntry("SQLRepositoryStorage", "Feed Database not found, Trying to load from a SQL backup: " + Configuration.DatabaseBackupFilePath());
      i = 1;
      if (FileUtils.Exists(Configuration.DatabaseBackupFilePath())) {
        CoreHelper.WriteTraceEntry("SQLRepositoryStorage", "SQLite database backup exists. Restoring to: " + DatabaseHelper.DatabasePath() + "...");
      }
      for (;;)
      {
        try
        {
          if (CoreHelper.ApiLevel() >= 19)
          {
            CoreHelper.WriteTraceEntry("SQLRepositoryStorage", "Detected Android 4.4 or later! Creating a temporary database before restoring...");
            if (!DatabaseHelper.createTempDB()) {
              CoreHelper.WriteTraceEntry("SQLRepositoryStorage", "Unable to create a temporary database!");
            }
          }
          if (!FileUtils.CopyFile(Configuration.DatabaseBackupFilePath(), DatabaseHelper.DatabasePath())) {
            continue;
          }
          CoreHelper.WriteTraceEntry("SQLRepositoryStorage", "SQLite database backup was restored!");
          i = 0;
        }
        catch (Exception localException1)
        {
          CoreHelper.LogException("SQLRepositoryStorage", "Failed to restore SQLite backup!", localException1);
          continue;
        }
        if (i == 0) {
          break;
        }
        new XMLRepositoryStorage().LoadRepository();
        ChangeTracker.InitializeHistory();
        return;
        CoreHelper.WriteLogEntry("SQLRepositoryStorage", "Unable to restore SQLite database backup! Will try XML backup...");
        continue;
        CoreHelper.WriteLogEntry("SQLRepositoryStorage", "SQLite database backup does not exist!");
      }
      CoreHelper.WriteTraceEntry("SQLRepositoryStorage", "Detected Database restore! Clearing sync settings...");
      Configuration.setCDSPassword(null);
      Configuration.setCDSToken(null);
      Configuration.setCDSTokenExpiration(new Date());
      Configuration.setLastSyncTimeStamp(-1L);
      Configuration.setLastRemoteChangeTimeStamp(-1L);
    }
    CoreHelper.KeepDeviceAwake();
    CoreHelper.WriteLogEntryInProduction("SQLRepositoryStorage", "Loading repository from SQL database...");
    FeedRepository.OnRepositoryLoadStart();
    FeedRepository.getRootFeed().SubFeeds().clear();
    FeedRepository._TrackDictionary.clear();
    Object localObject1 = LoadRepositoryTables();
    int i = CheckIfRepositryRootHasMoved();
    if (i != 0)
    {
      CoreHelper.WriteLogEntry("SQLRepositoryStorage", "Detected change of the repository root folder! New location: " + Configuration.EnclosureDownloadRoot());
      PatchRepositoryRoot((TrackDictionary)localObject1, i);
    }
    Object localObject3 = FeedRepository.getRootFeed().SubFeeds().iterator();
    label300:
    if (!((Iterator)localObject3).hasNext())
    {
      localObject3 = new DatabaseHelper(BeyondPodApplication.GetInstance().getApplicationContext());
      ((DatabaseHelper)localObject3).beginTransaction();
    }
    for (;;)
    {
      try
      {
        Object localObject4 = ((TrackDictionary)localObject1).keySet().iterator();
        if (!((Iterator)localObject4).hasNext())
        {
          ((DatabaseHelper)localObject3).setTransactionSuccessful();
          ((DatabaseHelper)localObject3).endTransaction();
          ((DatabaseHelper)localObject3).cleanup();
          BeyondPodApplication.GetInstance().PlayList().LoadFromFile();
          ChangeTracker.InitializeHistory();
          int j = VerifyAndPatchAudioRecords();
          int k = VerifyAndPatchVideoRecords();
          if ((j > 0) || (k > 0)) {
            SaveRepository();
          }
          if (i == 0) {
            break;
          }
          CoreHelper.WriteLogEntry("SQLRepositoryStorage", "Saving Repository after root change...");
          localObject1 = FeedRepository._TrackDictionary.values().iterator();
          if (((Iterator)localObject1).hasNext()) {
            break label642;
          }
          SaveRepository();
          return;
          localObject4 = (Feed)((Iterator)localObject3).next();
          ((Feed)localObject4).PatchFeedPathForMntRoot();
          RepositoryPersistence.BuildFeedList((Feed)localObject4, (TrackDictionary)localObject1);
          break label300;
        }
        String str = (String)((Iterator)localObject4).next();
        localTrack = (Track)((TrackDictionary)localObject1).get(str);
        if (FeedRepository._TrackDictionary.containsKey(str)) {
          continue;
        }
        if (localTrack.getParentFeed() != null)
        {
          if ((!Configuration.KeepMetadataForMissingEpisodes()) && ((localTrack.HasDownloadStarted()) || (!localTrack.HasUrl()))) {
            continue;
          }
          if ((localTrack.HasUrl()) && (localTrack.HasDownloadStarted()))
          {
            localTrack.setDownloadedPortion(0L);
            localTrack.setDownloadSize(0L);
          }
          if (!StringUtils.IsNullOrEmpty(localTrack.TrackImagePath())) {
            localTrack.setTrackImagePath(null);
          }
          RepositoryPersistence.AddChildTrack(localTrack.getParentFeed(), localTrack, true);
          continue;
        }
      }
      catch (Exception localException2)
      {
        Track localTrack;
        CoreHelper.LogException("SQLRepositoryStorage", "Unable to delete unused tracks from database", localException2);
        ((DatabaseHelper)localObject3).endTransaction();
        ((DatabaseHelper)localObject3).cleanup();
        continue;
        ((DatabaseHelper)localObject3).DeleteTrack(localTrack);
        continue;
      }
      finally
      {
        ((DatabaseHelper)localObject3).endTransaction();
        ((DatabaseHelper)localObject3).cleanup();
      }
      label642:
      ((Track)((Iterator)localObject2).next()).SetIsModified(true);
    }
  }
  
  public void SaveRepository()
  {
    for (;;)
    {
      DatabaseHelper localDatabaseHelper;
      synchronized (FeedRepository._TrackDictionary)
      {
        FeedRepository.OnRepositorySaveStart();
        localDatabaseHelper = new DatabaseHelper(BeyondPodApplication.GetInstance().getApplicationContext());
        localDatabaseHelper.beginTransaction();
        try
        {
          localIterator = FeedRepository._TrackDictionary.values().iterator();
          if (localIterator.hasNext()) {
            continue;
          }
          localIterator = FeedRepository.getRootFeed().SubFeeds().iterator();
        }
        catch (Exception localException)
        {
          Iterator localIterator;
          CoreHelper.LogException("SQLRepositoryStorage", "Failed to save tracks and feeds to the database!", localException);
          localDatabaseHelper.endTransaction();
          localDatabaseHelper.cleanup();
          FeedRepository.OnRepositorySaveComplete();
          continue;
          localObject1 = finally;
          throw ((Throwable)localObject1);
          localObject3 = (Feed)localException.next();
          if ((((Feed)localObject3).RowID() != null) && (!((Feed)localObject3).IsModified())) {
            continue;
          }
          ((DatabaseHelper)localObject1).SaveFeed((Feed)localObject3);
          continue;
        }
        finally
        {
          ((DatabaseHelper)localObject1).endTransaction();
          ((DatabaseHelper)localObject1).cleanup();
          FeedRepository.OnRepositorySaveComplete();
        }
        if (!localIterator.hasNext())
        {
          if (CategoryManager.IsModified()) {
            localDatabaseHelper.SaveCategories();
          }
          localIterator = ScheduledTasksManager.Tasks().iterator();
          if (localIterator.hasNext()) {
            break label220;
          }
          localDatabaseHelper.setTransactionSuccessful();
          localDatabaseHelper.endTransaction();
          localDatabaseHelper.cleanup();
          FeedRepository.OnRepositorySaveComplete();
          return;
          localObject3 = (Track)localIterator.next();
          if (!((Track)localObject3).IsModified()) {
            continue;
          }
          localDatabaseHelper.SaveTrack((Track)localObject3);
        }
      }
      label220:
      Object localObject3 = (ScheduledTask)((Iterator)localObject2).next();
      if ((((ScheduledTask)localObject3).RowID() == null) || (((ScheduledTask)localObject3).IsModified())) {
        ((DatabaseHelper)localObject1).SaveTask((ScheduledTask)localObject3);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/repository/SQLRepositoryStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */