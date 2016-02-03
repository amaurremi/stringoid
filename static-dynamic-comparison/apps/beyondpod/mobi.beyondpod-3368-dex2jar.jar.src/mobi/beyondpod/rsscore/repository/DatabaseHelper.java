package mobi.beyondpod.rsscore.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackDictionary;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategories;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.FileUtils;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.helpers.TimeSpan;
import mobi.beyondpod.schedulercore.Event;
import mobi.beyondpod.schedulercore.OperationBase;
import mobi.beyondpod.schedulercore.ScheduledTask;
import mobi.beyondpod.schedulercore.ScheduledTasksManager;
import mobi.beyondpod.sync.ChangeTracker;
import mobi.beyondpod.sync.TrackedChangeBase;
import mobi.beyondpod.sync.TrackedChangeEnclosure;
import mobi.beyondpod.sync.TrackedChangeEpisode;
import mobi.beyondpod.sync.TrackedChangeFeed;
import mobi.beyondpod.sync.TrackedChangePost;

public class DatabaseHelper
{
  private static final int CATEGORY_COL_categories = 1;
  private static final int CATEGORY_COL_rowId = 0;
  private static final int CHANGE_HISTORY_COL_blob = 4;
  private static final int CHANGE_HISTORY_COL_changeType = 2;
  private static final int CHANGE_HISTORY_COL_rowId = 0;
  private static final int CHANGE_HISTORY_COL_syncStatus = 3;
  private static final int CHANGE_HISTORY_COL_timestamp = 1;
  private static final String[] COLS_CATEGORIES = { "_id", "categories" };
  private static final String[] COLS_CHANGE_HISTORY = { "_id", "timestamp", "changeType", "syncStatus", "blob" };
  public static final String[] COLS_FEEDS;
  private static final String[] COLS_SCHEDULER;
  public static final String[] COLS_TRACKS;
  public static final String DB_NAME = "beyondpod.db";
  private static final String DB_TABLE_CATEGORIES = "categories";
  public static final String DB_TABLE_CHANGE_HISTORY = "change_history";
  public static final String DB_TABLE_FEEDS = "feeds";
  private static final String DB_TABLE_SCHEDULER = "scheduled_tasks";
  public static final String DB_TABLE_TRACKS = "tracks";
  private static final int DB_VERSION = 7;
  private static final int FEED_COL_autodelete = 4;
  private static final int FEED_COL_category = 12;
  private static final int FEED_COL_custDownload = 13;
  private static final int FEED_COL_feedId = 1;
  private static final int FEED_COL_feedPlayer = 19;
  private static final int FEED_COL_fingerprintType = 26;
  private static final int FEED_COL_forceItemSort = 16;
  private static final int FEED_COL_forceUniqueNames = 14;
  private static final int FEED_COL_hasUnread = 9;
  private static final int FEED_COL_imageUrl = 8;
  private static final int FEED_COL_lastItemId = 17;
  private static final int FEED_COL_leftTruncateLongTrackNames = 15;
  private static final int FEED_COL_maxDownload = 21;
  private static final int FEED_COL_maxGReaderItems = 22;
  private static final int FEED_COL_maxTrackAge = 24;
  private static final int FEED_COL_maxTracks = 23;
  private static final int FEED_COL_name = 3;
  public static final int FEED_COL_path = 2;
  private static final int FEED_COL_pubDate = 10;
  public static final int FEED_COL_rowID = 0;
  private static final int FEED_COL_savePlayedPosition = 25;
  private static final int FEED_COL_srvPubDate = 11;
  private static final int FEED_COL_trackSort = 18;
  private static final int FEED_COL_type = 6;
  private static final int FEED_COL_url = 7;
  private static final int FEED_COL_username = 20;
  private static final int FEED_COL_view = 5;
  private static final int SCHEDULER_COL_active = 2;
  private static final int SCHEDULER_COL_minBattLevel = 3;
  private static final int SCHEDULER_COL_operationId = 7;
  private static final int SCHEDULER_COL_recInterval = 6;
  private static final int SCHEDULER_COL_recPeriod = 5;
  private static final int SCHEDULER_COL_rowId = 0;
  private static final int SCHEDULER_COL_startTime = 4;
  private static final int SCHEDULER_COL_state = 8;
  private static final int SCHEDULER_COL_taskId = 1;
  private static final String TAG = DatabaseHelper.class.getSimpleName();
  private static final int TRACK_COL_contentType = 5;
  private static final int TRACK_COL_description = 16;
  private static final int TRACK_COL_downloadPortion = 10;
  private static final int TRACK_COL_downloadSize = 9;
  private static final int TRACK_COL_imagePath = 15;
  private static final int TRACK_COL_locked = 19;
  private static final int TRACK_COL_name = 4;
  private static final int TRACK_COL_orgRssItemID = 13;
  private static final int TRACK_COL_parentFeedID = 14;
  public static final int TRACK_COL_path = 1;
  private static final int TRACK_COL_played = 6;
  private static final int TRACK_COL_playedTime = 3;
  private static final int TRACK_COL_postTitle = 17;
  private static final int TRACK_COL_postUrl = 18;
  private static final int TRACK_COL_protocol = 7;
  private static final int TRACK_COL_pubDate = 11;
  public static final int TRACK_COL_rowId = 0;
  private static final int TRACK_COL_totalTime = 2;
  private static final int TRACK_COL_url = 8;
  private SQLiteDatabase db;
  private final DBOpenHelper dbOpenHelper;
  
  static
  {
    COLS_FEEDS = new String[] { "_id", "feedId", "path", "name", "autodelete", "view", "type", "url", "imageUrl", "hasUnread", "pubDate", "srvPubDate", "category", "custDownload", "forceUniqueNames", "leftTruncateLongTrackNames", "forceItemSort", "lastItemId", "trackSort", "feedPlayer", "username", "maxDownload", "maxGReaderItems", "maxTracks", "maxTrackAge", "savePlayedPosition", "fingerprintType" };
    COLS_TRACKS = new String[] { "_id", "path", "totalTime", "playedTime", "name", "contentType", "played", "protocol", "url", "downloadSize", "downloadPortion", "pubDate", "orgFeedItemID", "orgRssItemID", "parentFeedID", "imagePath", "description", "postTitle", "postUrl", "locked" };
    COLS_SCHEDULER = new String[] { "_id", "taskId", "active", "minBattLevel", "startTime", "recPeriod", "recInterval", "operationId", "state" };
  }
  
  public DatabaseHelper(Context paramContext)
  {
    this.dbOpenHelper = new DBOpenHelper(paramContext);
    establishDb();
  }
  
  public static boolean DataBaseExists()
  {
    boolean bool = true;
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject4 = DatabasePath();
    CoreHelper.WriteTraceEntry(TAG, "Looking for BeyondPod database file at: " + (String)localObject4);
    if (!FileUtils.Exists((String)localObject4))
    {
      CoreHelper.WriteLogEntry(TAG, "BeyondPod database file DOES NOT EXIST!");
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        localObject4 = SQLiteDatabase.openDatabase((String)localObject4, null, 1);
        localObject1 = localObject4;
        localObject3 = localObject4;
        CoreHelper.WriteTraceEntry(TAG, "Found BeyondPod database file");
        return true;
      }
      catch (SQLiteException localSQLiteException)
      {
        localObject3 = localObject1;
        CoreHelper.LogException(TAG, "BeyondPod SQL database file exists but opening the database failed!", localSQLiteException);
        return true;
      }
      finally
      {
        if (localObject3 != null) {
          ((SQLiteDatabase)localObject3).close();
        }
      }
    }
  }
  
  public static String DatabasePath()
  {
    return BeyondPodApplication.GetInstance().getDatabasePath("beyondpod.db").getAbsolutePath();
  }
  
  private void LoadFeed(Cursor paramCursor, Feed paramFeed)
  {
    try
    {
      long l = paramCursor.getLong(0);
      Object localObject = StringUtils.TryParseUUIDFromString(paramCursor.getString(1), UUID.randomUUID());
      String str1 = StringUtils.TryParseStringFromString(paramCursor.getString(3), "");
      String str2 = StringUtils.TryParseStringFromString(paramCursor.getString(2), "");
      String str3 = StringUtils.TryParseStringFromString(paramCursor.getString(7), "");
      String str4 = StringUtils.TryParseStringFromString(paramCursor.getString(8), "");
      String str5 = StringUtils.TryParseStringFromString(paramCursor.getString(12), "");
      String str6 = StringUtils.TryParseStringFromString(paramCursor.getString(20), "");
      int i = SafeGetInt(paramCursor, 4, 0);
      int j = SafeGetInt(paramCursor, 5, 0);
      int k = SafeGetInt(paramCursor, 6, 0);
      int m = SafeGetInt(paramCursor, 23, Configuration.getGlobalDefaultKeepAtMostPodcasts());
      int n = SafeGetInt(paramCursor, 24, 99999);
      int i1 = SafeGetInt(paramCursor, 21, Configuration.getGlobalDefaultNumberPodcastsToDownload());
      int i2 = SafeGetInt(paramCursor, 22, 0);
      int i3 = SafeGetInt(paramCursor, 9, 0);
      int i4 = SafeGetInt(paramCursor, 13, 0);
      boolean bool1 = SafeGetBoolean(paramCursor, 14, false);
      boolean bool2 = SafeGetBoolean(paramCursor, 25, true);
      int i5 = SafeGetInt(paramCursor, 26, 1);
      boolean bool3 = SafeGetBoolean(paramCursor, 15, false);
      int i6 = SafeGetInt(paramCursor, 16, -1);
      int i7 = SafeGetInt(paramCursor, 18, -1);
      int i8 = SafeGetInt(paramCursor, 19, -1);
      Date localDate1 = SafeGetDate(paramCursor, 10);
      Date localDate2 = SafeGetDate(paramCursor, 11);
      paramCursor = StringUtils.TryParseStringFromString(paramCursor.getString(17), null);
      localObject = new Feed((UUID)localObject, paramFeed);
      try
      {
        ((Feed)localObject).InitRowID(Long.valueOf(l));
        ((Feed)localObject).setName(str1);
        ((Feed)localObject).setFeedUrl(str3);
        ((Feed)localObject).setFeedImageUrl(str4);
        ((Feed)localObject).setAllowAutoTrackDeletions(i);
        ((Feed)localObject).setPreferredEnclosureIndex(j);
        ((Feed)localObject).setType(k);
        ((Feed)localObject).setFeedPath(str2);
        ((Feed)localObject).setNumUnreadItems(i3);
        ((Feed)localObject).setLastModifiedDate(localDate1);
        ((Feed)localObject).setLastServerModifiedDate(localDate2);
        ((Feed)localObject).setCategories(FeedCategories.Deserialize(str5));
        ((Feed)localObject).setForceFeedItemSort(i6);
        ((Feed)localObject).setForceUniqueTrackNames(bool1);
        ((Feed)localObject).setShouldRememberPlayedPosition(bool2);
        ((Feed)localObject).setItemFingerprintAlgorithm(i5);
        ((Feed)localObject).setLeftTruncateLongTrackNames(bool3);
        ((Feed)localObject).setLastItemID(paramCursor);
        ((Feed)localObject).setFeedPlayer(i8);
        ((Feed)localObject).setUserName(str6);
        ((Feed)localObject).setTrackSortOrder(i7);
        if (i2 > 0) {
          ((Feed)localObject).setMaxNumGReaderItemsToGet(i2);
        }
        ((Feed)localObject).setPodcastDownloadAction(i4);
        ((Feed)localObject).setMaxNumberPodcastsToDownload(i1);
        ((Feed)localObject).setKeepAtMostPodcasts(m);
        ((Feed)localObject).setMaximumPodcastAge(new TimeSpan(n, 0L, 0L, 0L));
        ((Feed)localObject).SetIsModified(false);
      }
      catch (Throwable paramCursor)
      {
        for (;;)
        {
          CoreHelper.WriteLogEntry(TAG, "Unable to read feed! " + paramCursor.getMessage());
        }
      }
      paramFeed.SubFeeds().add(localObject);
      return;
    }
    catch (Throwable paramCursor)
    {
      CoreHelper.WriteLogEntry(TAG, "Unable to read feed! " + paramCursor.getMessage());
    }
  }
  
  private void LoadTask(Cursor paramCursor)
  {
    try
    {
      long l = paramCursor.getLong(0);
      String str = paramCursor.getString(1);
      boolean bool = SafeGetBoolean(paramCursor, 2, false);
      int i = SafeGetInt(paramCursor, 3, 6);
      Date localDate2 = SafeGetDate(paramCursor, 4);
      Date localDate1 = localDate2;
      if (localDate2 == null) {
        localDate1 = new Date();
      }
      paramCursor = ScheduledTasksManager.LoadTask(l, str, bool, i, localDate1, SafeGetInt(paramCursor, 6, 1), SafeGetLong(paramCursor, 5, 1L), StringUtils.TryParseUUIDFromString(paramCursor.getString(7), null), paramCursor.getString(8));
      paramCursor.SetIsModified(false);
      paramCursor.Event.SetIsModified(false);
      paramCursor.Operation().SetIsModified(false);
      return;
    }
    catch (Throwable paramCursor)
    {
      CoreHelper.WriteLogEntry(TAG, "Unable to read scheduled task from database! " + paramCursor.getMessage());
    }
  }
  
  private void LoadTrack(Cursor paramCursor, TrackDictionary paramTrackDictionary)
  {
    try
    {
      long l1 = paramCursor.getLong(0);
      String str10 = StringUtils.TryParseStringFromString(paramCursor.getString(1), "");
      String str1 = StringUtils.TryParseStringFromString(paramCursor.getString(4), "");
      String str2 = StringUtils.TryParseStringFromString(paramCursor.getString(7), "");
      String str3 = StringUtils.TryParseStringFromString(paramCursor.getString(8), "");
      String str4 = StringUtils.TryParseStringFromString(paramCursor.getString(15), "");
      String str5 = StringUtils.TryParseStringFromString(paramCursor.getString(16), "");
      String str6 = StringUtils.TryParseStringFromString(paramCursor.getString(17), "");
      String str7 = StringUtils.TryParseStringFromString(paramCursor.getString(18), "");
      int i = SafeGetInt(paramCursor, 19, 0);
      String str8 = StringUtils.TryParseStringFromString(paramCursor.getString(5), "");
      long l2 = SafeGetLong(paramCursor, 2, 0L);
      long l3 = SafeGetLong(paramCursor, 3, 0L);
      boolean bool = SafeGetBoolean(paramCursor, 6, false);
      long l4 = SafeGetLong(paramCursor, 9, 0L);
      long l5 = SafeGetLong(paramCursor, 10, 0L);
      Date localDate = SafeGetDate(paramCursor, 11);
      String str9 = paramCursor.getString(13);
      String str11 = paramCursor.getString(14);
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (!StringUtils.IsNullOrEmpty(str11))
      {
        paramCursor = StringUtils.TryParseUUIDFromString(paramCursor.getString(14), null);
        localObject1 = localObject2;
        if (paramCursor != null) {
          localObject1 = FeedRepository.GetFeedById(paramCursor);
        }
      }
      paramCursor = new Track(str10, (Feed)localObject1);
      paramCursor.InitRowID(Long.valueOf(l1));
      paramCursor.setName(str1);
      paramCursor.setContentMimeType(str8);
      paramCursor.setProtocol(str2);
      paramCursor.setUrl(str3);
      paramCursor.InitializePlayedTimes(l3, l2, bool);
      paramCursor.setDownloadedPortion(l5);
      paramCursor.setDownloadSize(l4);
      paramCursor.setLastModifiedDate(localDate);
      paramCursor.setRssItemID(str9);
      paramCursor.setTrackDescription(str5);
      paramCursor.setTrackImagePath(str4);
      paramCursor.setTrackPostTitle(str6);
      paramCursor.setTrackPostUrl(str7);
      if (i == 1) {}
      for (bool = true;; bool = false)
      {
        paramCursor.setLocked(bool);
        paramTrackDictionary.put(paramCursor.TrackPath(), paramCursor);
        paramCursor.SetIsModified(false);
        return;
      }
      return;
    }
    catch (Throwable paramCursor)
    {
      CoreHelper.WriteLogEntry(TAG, "Unable to read track from database! " + paramCursor.getMessage());
    }
  }
  
  private TrackedChangeBase LoadTrackedChange(Cursor paramCursor)
  {
    Object localObject;
    int i;
    for (;;)
    {
      try
      {
        localObject = Long.valueOf(paramCursor.getLong(0));
        i = SafeGetInt(paramCursor, 2, 0);
        l = SafeGetLong(paramCursor, 1, 0L);
        j = SafeGetInt(paramCursor, 3, 0);
        str = StringUtils.TryParseStringFromString(paramCursor.getString(4), "");
        paramCursor = null;
        if ((i != 1) && (i != 2) && (i != 3) && (i != 14)) {
          break label195;
        }
        paramCursor = new TrackedChangeFeed((Long)localObject, l, i, j, str);
        localObject = paramCursor;
        if (paramCursor == null) {
          break;
        }
        paramCursor.SetIsModified(false);
        return paramCursor;
      }
      catch (Throwable paramCursor)
      {
        long l;
        int j;
        String str;
        label105:
        label124:
        CoreHelper.WriteLogEntry(TAG, "Unable to read feed! " + paramCursor.getMessage());
        localObject = null;
      }
      paramCursor = new TrackedChangeEnclosure((Long)localObject, l, i, j, str);
      continue;
      paramCursor = new TrackedChangePost((Long)localObject, l, i, j, str);
    }
    for (;;)
    {
      paramCursor = new TrackedChangeEpisode((Long)localObject, l, i, j, str);
      break;
      return (TrackedChangeBase)localObject;
      label195:
      if ((i == 4) || (i == 5) || (i == 6)) {
        break label105;
      }
      if ((i == 12) || (i == 13) || (i == 10) || (i == 11)) {
        break label124;
      }
      if ((i != 9) && (i != 7) && (i != 8)) {
        if (i != 15) {
          break;
        }
      }
    }
  }
  
  private boolean SafeGetBoolean(Cursor paramCursor, int paramInt, boolean paramBoolean)
  {
    if (paramCursor.isNull(paramInt)) {
      return paramBoolean;
    }
    return paramCursor.getInt(paramInt) == 1;
  }
  
  private Date SafeGetDate(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.isNull(paramInt)) {
      return null;
    }
    return new Date(paramCursor.getLong(paramInt));
  }
  
  private int SafeGetInt(Cursor paramCursor, int paramInt1, int paramInt2)
  {
    if (paramCursor.isNull(paramInt1)) {
      return paramInt2;
    }
    return paramCursor.getInt(paramInt1);
  }
  
  private long SafeGetLong(Cursor paramCursor, int paramInt, long paramLong)
  {
    if (paramCursor.isNull(paramInt)) {
      return paramLong;
    }
    return paramCursor.getLong(paramInt);
  }
  
  /* Error */
  public static boolean createTempDB()
  {
    // Byte code:
    //   0: invokestatic 277	mobi/beyondpod/rsscore/repository/DatabaseHelper:DatabasePath	()Ljava/lang/String;
    //   3: astore 4
    //   5: aload 4
    //   7: invokestatic 303	mobi/beyondpod/rsscore/helpers/FileUtils:Exists	(Ljava/lang/String;)Z
    //   10: ifeq +16 -> 26
    //   13: getstatic 138	mobi/beyondpod/rsscore/repository/DatabaseHelper:TAG	Ljava/lang/String;
    //   16: ldc_w 655
    //   19: invokestatic 308	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteLogEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: iconst_1
    //   23: istore_0
    //   24: iload_0
    //   25: ireturn
    //   26: getstatic 138	mobi/beyondpod/rsscore/repository/DatabaseHelper:TAG	Ljava/lang/String;
    //   29: new 279	java/lang/StringBuilder
    //   32: dup
    //   33: ldc_w 657
    //   36: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: aload 4
    //   41: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc_w 659
    //   47: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 297	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aconst_null
    //   57: astore_2
    //   58: aconst_null
    //   59: astore 5
    //   61: new 2	mobi/beyondpod/rsscore/repository/DatabaseHelper
    //   64: dup
    //   65: invokestatic 331	mobi/beyondpod/BeyondPodApplication:GetInstance	()Lmobi/beyondpod/BeyondPodApplication;
    //   68: invokespecial 660	mobi/beyondpod/rsscore/repository/DatabaseHelper:<init>	(Landroid/content/Context;)V
    //   71: astore_3
    //   72: aload 4
    //   74: invokestatic 303	mobi/beyondpod/rsscore/helpers/FileUtils:Exists	(Ljava/lang/String;)Z
    //   77: istore_1
    //   78: iload_1
    //   79: istore_0
    //   80: aload_3
    //   81: ifnull -57 -> 24
    //   84: aload_3
    //   85: invokevirtual 663	mobi/beyondpod/rsscore/repository/DatabaseHelper:cleanup	()V
    //   88: iload_1
    //   89: ireturn
    //   90: astore 4
    //   92: aload 5
    //   94: astore_3
    //   95: aload_3
    //   96: astore_2
    //   97: getstatic 138	mobi/beyondpod/rsscore/repository/DatabaseHelper:TAG	Ljava/lang/String;
    //   100: ldc_w 665
    //   103: aload 4
    //   105: invokestatic 325	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   108: aload_3
    //   109: ifnull +7 -> 116
    //   112: aload_3
    //   113: invokevirtual 663	mobi/beyondpod/rsscore/repository/DatabaseHelper:cleanup	()V
    //   116: iconst_0
    //   117: ireturn
    //   118: astore_3
    //   119: aload_2
    //   120: ifnull +7 -> 127
    //   123: aload_2
    //   124: invokevirtual 663	mobi/beyondpod/rsscore/repository/DatabaseHelper:cleanup	()V
    //   127: aload_3
    //   128: athrow
    //   129: astore 4
    //   131: aload_3
    //   132: astore_2
    //   133: aload 4
    //   135: astore_3
    //   136: goto -17 -> 119
    //   139: astore 4
    //   141: goto -46 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   23	57	0	bool1	boolean
    //   77	12	1	bool2	boolean
    //   57	76	2	localObject1	Object
    //   71	42	3	localObject2	Object
    //   118	14	3	localObject3	Object
    //   135	1	3	localObject4	Object
    //   3	70	4	str	String
    //   90	14	4	localSQLiteException1	SQLiteException
    //   129	5	4	localObject5	Object
    //   139	1	4	localSQLiteException2	SQLiteException
    //   59	34	5	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   61	72	90	android/database/sqlite/SQLiteException
    //   61	72	118	finally
    //   97	108	118	finally
    //   72	78	129	finally
    //   72	78	139	android/database/sqlite/SQLiteException
  }
  
  private void establishDb()
  {
    if (this.db == null) {
      this.db = this.dbOpenHelper.getWritableDatabase();
    }
  }
  
  /* Error */
  public void CleanAnyDuplicateDatabaseTracks(TrackDictionary paramTrackDictionary)
  {
    // Byte code:
    //   0: new 677	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 678	java/util/ArrayList:<init>	()V
    //   7: astore 8
    //   9: new 677	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 678	java/util/ArrayList:<init>	()V
    //   16: astore 9
    //   18: aload_1
    //   19: invokevirtual 682	mobi/beyondpod/rsscore/TrackDictionary:values	()Ljava/util/Collection;
    //   22: invokeinterface 688 1 0
    //   27: astore_1
    //   28: aload_1
    //   29: invokeinterface 693 1 0
    //   34: ifne +177 -> 211
    //   37: aconst_null
    //   38: astore 6
    //   40: aconst_null
    //   41: astore_1
    //   42: aload_0
    //   43: getfield 667	mobi/beyondpod/rsscore/repository/DatabaseHelper:db	Landroid/database/sqlite/SQLiteDatabase;
    //   46: ldc 45
    //   48: getstatic 228	mobi/beyondpod/rsscore/repository/DatabaseHelper:COLS_TRACKS	[Ljava/lang/String;
    //   51: aconst_null
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: aconst_null
    //   56: invokevirtual 697	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   59: astore 7
    //   61: aload 7
    //   63: astore_1
    //   64: aload 7
    //   66: astore 6
    //   68: aload 7
    //   70: invokeinterface 700 1 0
    //   75: istore_3
    //   76: aload 7
    //   78: astore_1
    //   79: aload 7
    //   81: astore 6
    //   83: aload 7
    //   85: invokeinterface 703 1 0
    //   90: pop
    //   91: iconst_0
    //   92: istore_2
    //   93: iload_2
    //   94: iload_3
    //   95: if_icmplt +137 -> 232
    //   98: aload 7
    //   100: astore_1
    //   101: aload 7
    //   103: astore 6
    //   105: aload 8
    //   107: invokevirtual 706	java/util/ArrayList:size	()I
    //   110: istore_2
    //   111: iload_2
    //   112: ifle +333 -> 445
    //   115: aload_0
    //   116: invokevirtual 709	mobi/beyondpod/rsscore/repository/DatabaseHelper:beginTransaction	()V
    //   119: iconst_0
    //   120: istore_2
    //   121: aload 8
    //   123: invokevirtual 710	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   126: astore_1
    //   127: aload_1
    //   128: invokeinterface 693 1 0
    //   133: ifne +176 -> 309
    //   136: getstatic 138	mobi/beyondpod/rsscore/repository/DatabaseHelper:TAG	Ljava/lang/String;
    //   139: new 279	java/lang/StringBuilder
    //   142: dup
    //   143: ldc_w 712
    //   146: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   149: aload 8
    //   151: invokevirtual 706	java/util/ArrayList:size	()I
    //   154: invokevirtual 715	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   157: ldc_w 717
    //   160: invokevirtual 288	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: iload_2
    //   164: invokevirtual 715	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 297	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload_0
    //   174: invokevirtual 720	mobi/beyondpod/rsscore/repository/DatabaseHelper:setTransactionSuccessful	()V
    //   177: aload 7
    //   179: astore_1
    //   180: aload 7
    //   182: astore 6
    //   184: aload_0
    //   185: invokevirtual 723	mobi/beyondpod/rsscore/repository/DatabaseHelper:endTransaction	()V
    //   188: aload 7
    //   190: ifnull +20 -> 210
    //   193: aload 7
    //   195: invokeinterface 726 1 0
    //   200: ifne +10 -> 210
    //   203: aload 7
    //   205: invokeinterface 727 1 0
    //   210: return
    //   211: aload 9
    //   213: aload_1
    //   214: invokeinterface 731 1 0
    //   219: checkcast 564	mobi/beyondpod/rsscore/Track
    //   222: invokevirtual 735	mobi/beyondpod/rsscore/Track:RowID	()Ljava/lang/Long;
    //   225: invokevirtual 736	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   228: pop
    //   229: goto -201 -> 28
    //   232: aload 7
    //   234: astore_1
    //   235: aload 7
    //   237: astore 6
    //   239: aload 7
    //   241: iconst_0
    //   242: invokeinterface 350 2 0
    //   247: lstore 4
    //   249: aload 7
    //   251: astore_1
    //   252: aload 7
    //   254: astore 6
    //   256: aload 9
    //   258: lload 4
    //   260: invokestatic 405	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   263: invokevirtual 739	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   266: ifne +21 -> 287
    //   269: aload 7
    //   271: astore_1
    //   272: aload 7
    //   274: astore 6
    //   276: aload 8
    //   278: lload 4
    //   280: invokestatic 405	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   283: invokevirtual 736	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   286: pop
    //   287: aload 7
    //   289: astore_1
    //   290: aload 7
    //   292: astore 6
    //   294: aload 7
    //   296: invokeinterface 742 1 0
    //   301: pop
    //   302: iload_2
    //   303: iconst_1
    //   304: iadd
    //   305: istore_2
    //   306: goto -213 -> 93
    //   309: aload_1
    //   310: invokeinterface 731 1 0
    //   315: checkcast 401	java/lang/Long
    //   318: astore 6
    //   320: aload_0
    //   321: getfield 667	mobi/beyondpod/rsscore/repository/DatabaseHelper:db	Landroid/database/sqlite/SQLiteDatabase;
    //   324: ldc 45
    //   326: new 279	java/lang/StringBuilder
    //   329: dup
    //   330: ldc_w 744
    //   333: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   336: aload 6
    //   338: invokevirtual 747	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: aconst_null
    //   345: invokevirtual 751	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   348: iconst_1
    //   349: if_icmpeq +89 -> 438
    //   352: getstatic 138	mobi/beyondpod/rsscore/repository/DatabaseHelper:TAG	Ljava/lang/String;
    //   355: new 279	java/lang/StringBuilder
    //   358: dup
    //   359: ldc_w 753
    //   362: invokespecial 284	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   365: aload 6
    //   367: invokevirtual 747	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 291	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 297	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   376: goto -249 -> 127
    //   379: astore 8
    //   381: aload 7
    //   383: astore_1
    //   384: aload 7
    //   386: astore 6
    //   388: aload_0
    //   389: invokevirtual 723	mobi/beyondpod/rsscore/repository/DatabaseHelper:endTransaction	()V
    //   392: aload 7
    //   394: astore_1
    //   395: aload 7
    //   397: astore 6
    //   399: aload 8
    //   401: athrow
    //   402: astore 7
    //   404: aload_1
    //   405: astore 6
    //   407: getstatic 138	mobi/beyondpod/rsscore/repository/DatabaseHelper:TAG	Ljava/lang/String;
    //   410: ldc_w 755
    //   413: aload 7
    //   415: invokestatic 325	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   418: aload_1
    //   419: ifnull -209 -> 210
    //   422: aload_1
    //   423: invokeinterface 726 1 0
    //   428: ifne -218 -> 210
    //   431: aload_1
    //   432: invokeinterface 727 1 0
    //   437: return
    //   438: iload_2
    //   439: iconst_1
    //   440: iadd
    //   441: istore_2
    //   442: goto -315 -> 127
    //   445: aload 7
    //   447: astore_1
    //   448: aload 7
    //   450: astore 6
    //   452: getstatic 138	mobi/beyondpod/rsscore/repository/DatabaseHelper:TAG	Ljava/lang/String;
    //   455: ldc_w 757
    //   458: invokestatic 297	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   461: goto -273 -> 188
    //   464: astore_1
    //   465: aload 6
    //   467: ifnull +20 -> 487
    //   470: aload 6
    //   472: invokeinterface 726 1 0
    //   477: ifne +10 -> 487
    //   480: aload 6
    //   482: invokeinterface 727 1 0
    //   487: aload_1
    //   488: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	489	0	this	DatabaseHelper
    //   0	489	1	paramTrackDictionary	TrackDictionary
    //   92	350	2	i	int
    //   75	21	3	j	int
    //   247	32	4	l	long
    //   38	443	6	localObject1	Object
    //   59	337	7	localCursor	Cursor
    //   402	47	7	localSQLException	SQLException
    //   7	270	8	localArrayList1	ArrayList
    //   379	21	8	localObject2	Object
    //   16	241	9	localArrayList2	ArrayList
    // Exception table:
    //   from	to	target	type
    //   115	119	379	finally
    //   121	127	379	finally
    //   127	177	379	finally
    //   309	376	379	finally
    //   42	61	402	android/database/SQLException
    //   68	76	402	android/database/SQLException
    //   83	91	402	android/database/SQLException
    //   105	111	402	android/database/SQLException
    //   184	188	402	android/database/SQLException
    //   239	249	402	android/database/SQLException
    //   256	269	402	android/database/SQLException
    //   276	287	402	android/database/SQLException
    //   294	302	402	android/database/SQLException
    //   388	392	402	android/database/SQLException
    //   399	402	402	android/database/SQLException
    //   452	461	402	android/database/SQLException
    //   42	61	464	finally
    //   68	76	464	finally
    //   83	91	464	finally
    //   105	111	464	finally
    //   184	188	464	finally
    //   239	249	464	finally
    //   256	269	464	finally
    //   276	287	464	finally
    //   294	302	464	finally
    //   388	392	464	finally
    //   399	402	464	finally
    //   407	418	464	finally
    //   452	461	464	finally
  }
  
  public void DeleteFeed(Feed paramFeed)
  {
    if ((paramFeed != null) && (paramFeed.RowID() != null))
    {
      CoreHelper.WriteTraceEntry(TAG, "Deleting feed record for: " + paramFeed.getName());
      if (this.db.delete("feeds", "_id=" + paramFeed.RowID(), null) != 1) {
        CoreHelper.WriteTraceEntry(TAG, "!!! Failed to delete Feed record for: " + paramFeed.getName());
      }
    }
    else
    {
      return;
    }
    ChangeTracker.AddLocalFeedChange(2, paramFeed, 60);
  }
  
  public void DeleteTask(ScheduledTask paramScheduledTask)
  {
    if ((paramScheduledTask != null) && (paramScheduledTask.RowID() != null))
    {
      CoreHelper.WriteTraceEntry(TAG, "Deleting task record for: " + paramScheduledTask);
      if (this.db.delete("scheduled_tasks", "_id=" + paramScheduledTask.RowID(), null) != 1) {
        CoreHelper.WriteTraceEntry(TAG, "!!! Failed to delete scheduled task record for: " + paramScheduledTask);
      }
    }
  }
  
  public void DeleteTrack(Track paramTrack)
  {
    if ((paramTrack != null) && (paramTrack.RowID() != null))
    {
      CoreHelper.WriteTraceEntry(TAG, "Deleting track record for: " + paramTrack.getName());
      if (this.db.delete("tracks", "_id=" + paramTrack.RowID(), null) != 1) {
        CoreHelper.WriteTraceEntry(TAG, "!!! Failed to delete track record for: " + paramTrack.getName());
      }
    }
  }
  
  public boolean DeleteTrackedChange(TrackedChangeBase paramTrackedChangeBase)
  {
    boolean bool = true;
    if ((paramTrackedChangeBase != null) && (paramTrackedChangeBase.RowID() != null))
    {
      if (this.db.delete("change_history", "_id=" + paramTrackedChangeBase.RowID(), null) != 1) {
        CoreHelper.WriteTraceEntry(TAG, "!!! Failed to delete record for: " + paramTrackedChangeBase.FriendlyName());
      }
    }
    else {
      bool = false;
    }
    return bool;
  }
  
  public void LoadCategories()
  {
    localObject3 = null;
    localObject1 = null;
    for (;;)
    {
      try
      {
        localCursor = this.db.query("categories", COLS_CATEGORIES, null, null, null, null, COLS_CATEGORIES[0]);
        localObject1 = localCursor;
        localObject3 = localCursor;
        if (localCursor.moveToFirst())
        {
          localObject1 = localCursor;
          localObject3 = localCursor;
          CategoryManager.Deserialize(localCursor.getString(1));
          localObject1 = localCursor;
          localObject3 = localCursor;
          CategoryManager.SetIsModified(false);
          if ((localCursor != null) && (!localCursor.isClosed())) {
            localCursor.close();
          }
          return;
        }
      }
      catch (SQLException localSQLException)
      {
        Cursor localCursor;
        localObject3 = localObject1;
        CoreHelper.LogException(TAG, "Unable to load categories database record", localSQLException);
        return;
      }
      finally
      {
        if ((localObject3 == null) || (((Cursor)localObject3).isClosed())) {
          continue;
        }
        ((Cursor)localObject3).close();
      }
      localObject1 = localCursor;
      localObject3 = localCursor;
      CoreHelper.WriteLogEntry(TAG, "Load of categories failed - unable to move to the first record!");
    }
  }
  
  public void LoadFeeds(Feed paramFeed)
  {
    paramFeed.SubFeeds().clear();
    localObject2 = null;
    localObject1 = null;
    for (;;)
    {
      try
      {
        localCursor = this.db.query("feeds", COLS_FEEDS, null, null, null, null, null);
        localObject1 = localCursor;
        localObject2 = localCursor;
        int j = localCursor.getCount();
        localObject1 = localCursor;
        localObject2 = localCursor;
        localCursor.moveToFirst();
        i = 0;
        if (i >= j)
        {
          if ((localCursor != null) && (!localCursor.isClosed())) {
            localCursor.close();
          }
          return;
        }
      }
      catch (SQLException paramFeed)
      {
        Cursor localCursor;
        int i;
        localObject2 = localObject1;
        CoreHelper.LogException(TAG, "Unable to load feed database records", paramFeed);
        return;
      }
      finally
      {
        if ((localObject2 == null) || (((Cursor)localObject2).isClosed())) {
          continue;
        }
        ((Cursor)localObject2).close();
      }
      localObject1 = localCursor;
      localObject2 = localCursor;
      LoadFeed(localCursor, paramFeed);
      localObject1 = localCursor;
      localObject2 = localCursor;
      localCursor.moveToNext();
      i += 1;
    }
  }
  
  public void LoadTasks()
  {
    Object localObject3 = null;
    Cursor localCursor2 = null;
    localCursor1 = localCursor2;
    localObject1 = localObject3;
    for (;;)
    {
      try
      {
        ScheduledTasksManager.ClearAllTasks();
        localCursor1 = localCursor2;
        localObject1 = localObject3;
        localCursor2 = this.db.query("scheduled_tasks", COLS_SCHEDULER, null, null, null, null, null);
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        int j = localCursor2.getCount();
        localCursor1 = localCursor2;
        localObject1 = localCursor2;
        localCursor2.moveToFirst();
        i = 0;
        if (i >= j)
        {
          if ((localCursor2 != null) && (!localCursor2.isClosed())) {
            localCursor2.close();
          }
          return;
        }
      }
      catch (SQLException localSQLException)
      {
        int i;
        localObject1 = localCursor1;
        CoreHelper.LogException(TAG, "Unable to load track database records", localSQLException);
        if ((localCursor1 == null) || (localCursor1.isClosed())) {
          continue;
        }
        localCursor1.close();
        return;
      }
      finally
      {
        if ((localObject1 == null) || (((Cursor)localObject1).isClosed())) {
          continue;
        }
        ((Cursor)localObject1).close();
      }
      localCursor1 = localCursor2;
      localObject1 = localCursor2;
      LoadTask(localCursor2);
      localCursor1 = localCursor2;
      localObject1 = localCursor2;
      localCursor2.moveToNext();
      i += 1;
    }
  }
  
  public void LoadTrackedChanges(ArrayList<TrackedChangeBase> paramArrayList)
  {
    paramArrayList.clear();
    localObject2 = null;
    localObject1 = null;
    for (;;)
    {
      try
      {
        localCursor = this.db.query("change_history", COLS_CHANGE_HISTORY, null, null, null, null, null);
        localObject1 = localCursor;
        localObject2 = localCursor;
        int j = localCursor.getCount();
        localObject1 = localCursor;
        localObject2 = localCursor;
        localCursor.moveToFirst();
        i = 0;
        if (i >= j)
        {
          if ((localCursor != null) && (!localCursor.isClosed())) {
            localCursor.close();
          }
          return;
        }
      }
      catch (SQLException paramArrayList)
      {
        Cursor localCursor;
        int i;
        TrackedChangeBase localTrackedChangeBase;
        localObject2 = localObject1;
        CoreHelper.LogException(TAG, "Unable to load change history database records", paramArrayList);
        return;
      }
      finally
      {
        if ((localObject2 == null) || (((Cursor)localObject2).isClosed())) {
          continue;
        }
        ((Cursor)localObject2).close();
      }
      localObject1 = localCursor;
      localObject2 = localCursor;
      localTrackedChangeBase = LoadTrackedChange(localCursor);
      if (localTrackedChangeBase != null)
      {
        localObject1 = localCursor;
        localObject2 = localCursor;
        paramArrayList.add(localTrackedChangeBase);
      }
      localObject1 = localCursor;
      localObject2 = localCursor;
      localCursor.moveToNext();
      i += 1;
    }
  }
  
  public TrackDictionary LoadTracks()
  {
    localTrackDictionary = new TrackDictionary();
    localObject3 = null;
    localObject1 = null;
    for (;;)
    {
      try
      {
        localCursor = this.db.query("tracks", COLS_TRACKS, null, null, null, null, null);
        localObject1 = localCursor;
        localObject3 = localCursor;
        int j = localCursor.getCount();
        localObject1 = localCursor;
        localObject3 = localCursor;
        CoreHelper.WriteTraceEntry(TAG, "Database has " + j + " track records.");
        localObject1 = localCursor;
        localObject3 = localCursor;
        localCursor.moveToFirst();
        i = 0;
        if (i < j) {
          continue;
        }
        if ((localCursor != null) && (!localCursor.isClosed())) {
          localCursor.close();
        }
      }
      catch (SQLException localSQLException)
      {
        Cursor localCursor;
        int i;
        localObject3 = localObject1;
        CoreHelper.LogException(TAG, "Unable to load track database records", localSQLException);
        return localTrackDictionary;
      }
      finally
      {
        if ((localObject3 == null) || (((Cursor)localObject3).isClosed())) {
          continue;
        }
        ((Cursor)localObject3).close();
      }
      return localTrackDictionary;
      localObject1 = localCursor;
      localObject3 = localCursor;
      LoadTrack(localCursor, localTrackDictionary);
      localObject1 = localCursor;
      localObject3 = localCursor;
      localCursor.moveToNext();
      i += 1;
    }
  }
  
  public void SaveCategories()
  {
    ContentValues localContentValues = new ContentValues();
    Object localObject1 = CategoryManager.Serialize();
    localContentValues.put(COLS_CATEGORIES[1], (String)localObject1);
    CoreHelper.WriteLogEntryInProduction(TAG, "Saving category record! Serialized Data: " + (String)localObject1);
    Object localObject3 = null;
    localObject1 = null;
    long l2 = Long.MIN_VALUE;
    long l3;
    label268:
    try
    {
      Cursor localCursor = this.db.query("categories", COLS_CATEGORIES, null, null, null, null, COLS_CATEGORIES[0]);
      long l1 = l2;
      localObject1 = localCursor;
      localObject3 = localCursor;
      if (localCursor.moveToFirst())
      {
        localObject1 = localCursor;
        localObject3 = localCursor;
        l1 = localCursor.getLong(0);
      }
      l3 = l1;
      if (localCursor != null)
      {
        l3 = l1;
        if (!localCursor.isClosed())
        {
          localCursor.close();
          l3 = l1;
        }
      }
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        CoreHelper.LogException(TAG, "Unable to read categories database record", localSQLException);
        l3 = l2;
        if (localObject1 != null)
        {
          l3 = l2;
          if (!((Cursor)localObject1).isClosed())
          {
            ((Cursor)localObject1).close();
            l3 = l2;
          }
        }
      }
    }
    finally
    {
      if ((localObject3 == null) || (((Cursor)localObject3).isClosed())) {
        break label268;
      }
      ((Cursor)localObject3).close();
    }
    if (l3 == Long.MIN_VALUE) {
      if (this.db.insert("categories", null, localContentValues) == -1L) {
        CoreHelper.WriteLogEntry(TAG, "!!! Failed to insert category record!");
      }
    }
    for (;;)
    {
      CategoryManager.SetIsModified(false);
      return;
      if (this.db.update("categories", localContentValues, "_id=" + l3, null) != 1) {
        CoreHelper.WriteLogEntry(TAG, "!!! Failed to update category record!");
      }
    }
  }
  
  public void SaveFeed(Feed paramFeed)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("feedId", paramFeed.ID().toString());
    localContentValues.put("path", paramFeed.GetRawFeedPath());
    localContentValues.put("name", paramFeed.getName());
    localContentValues.put("autodelete", Integer.valueOf(paramFeed.getAllowAutoTrackDeletions()));
    localContentValues.put("view", Integer.valueOf(paramFeed.getPreferredEnclosureIndex()));
    localContentValues.put("type", Integer.valueOf(paramFeed.getType()));
    localContentValues.put("url", paramFeed.getFeedUrl());
    localContentValues.put("imageUrl", paramFeed.getFeedImageUrl());
    localContentValues.put("hasUnread", Integer.valueOf(paramFeed.NumUnreadItems()));
    Object localObject;
    if (paramFeed.getLastModifiedDate() != null)
    {
      localObject = Long.valueOf(paramFeed.getLastModifiedDate().getTime());
      localContentValues.put("pubDate", (Long)localObject);
      if (paramFeed.getLastServerModifiedDate() == null) {
        break label509;
      }
      localObject = Long.valueOf(paramFeed.getLastServerModifiedDate().getTime());
      label170:
      localContentValues.put("srvPubDate", (Long)localObject);
      localContentValues.put("category", paramFeed.getCategories().Serialize());
      localContentValues.put("custDownload", Integer.valueOf(paramFeed.getPodcastDownloadAction()));
      localContentValues.put("forceUniqueNames", Boolean.valueOf(paramFeed.getForceUniqueTrackNames()));
      localContentValues.put("savePlayedPosition", Boolean.valueOf(paramFeed.getShouldRememberPlayedPosition()));
      localContentValues.put("fingerprintType", Integer.valueOf(paramFeed.getItemFingerprintAlgorithm()));
      localContentValues.put("leftTruncateLongTrackNames", Boolean.valueOf(paramFeed.getLeftTruncateLongTrackNames()));
      localContentValues.put("forceItemSort", Integer.valueOf(paramFeed.getForceFeedItemSort()));
      localContentValues.put("lastItemId", paramFeed.getLastItemID());
      if (paramFeed.getTrackSortOrder() == Configuration.getPodcastsSortOrder()) {
        break label515;
      }
      localObject = Integer.valueOf(paramFeed.getTrackSortOrder());
      label307:
      localContentValues.put("trackSort", (Integer)localObject);
      localContentValues.put("feedPlayer", Integer.valueOf(paramFeed.getFeedPlayer()));
      localContentValues.put("username", paramFeed.getUserName());
      localContentValues.put("maxDownload", Integer.valueOf(paramFeed.getMaxNumberPodcastToDownload()));
      localContentValues.put("maxGReaderItems", Integer.valueOf(paramFeed.getMaxNumGReaderItemsToGet()));
      if (paramFeed.getKeepAtMostPodcasts() == Configuration.getGlobalDefaultKeepAtMostPodcasts()) {
        break label521;
      }
      localObject = Integer.valueOf(paramFeed.getKeepAtMostPodcasts());
      label388:
      localContentValues.put("maxTracks", (Integer)localObject);
      if (paramFeed.getMaximumPodcastAge() == Configuration.getGlobalDefaultMaximumPodcastAge()) {
        break label527;
      }
      localObject = Double.valueOf(paramFeed.getMaximumPodcastAge().getTotalDays());
      label419:
      localContentValues.put("maxTrackAge", (Double)localObject);
      CoreHelper.WriteTraceEntry(TAG, "Saving feed record for: " + paramFeed.getName());
      if (paramFeed.RowID() != null) {
        break label562;
      }
      long l = this.db.insert("feeds", null, localContentValues);
      if (l == -1L) {
        break label533;
      }
      paramFeed.InitRowID(Long.valueOf(l));
      ChangeTracker.AddLocalFeedChange(1, paramFeed, 60);
    }
    for (;;)
    {
      paramFeed.SetIsModified(false);
      return;
      localObject = null;
      break;
      label509:
      localObject = null;
      break label170;
      label515:
      localObject = null;
      break label307;
      label521:
      localObject = null;
      break label388;
      label527:
      localObject = null;
      break label419;
      label533:
      CoreHelper.WriteTraceEntry(TAG, "!!! Failed to insert feed record for: " + paramFeed.getName());
      continue;
      label562:
      if (this.db.update("feeds", localContentValues, "_id=" + paramFeed.RowID(), null) != 1) {
        CoreHelper.WriteTraceEntry(TAG, "!!! Failed to update feed record for: " + paramFeed.getName());
      }
    }
  }
  
  public void SaveTask(ScheduledTask paramScheduledTask)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("taskId", paramScheduledTask.TaskID());
    int i;
    if (paramScheduledTask.Active)
    {
      i = 1;
      localContentValues.put("active", Integer.valueOf(i));
      localContentValues.put("minBattLevel", Integer.valueOf(paramScheduledTask.MinBatteryLevelRequired));
      localContentValues.put("startTime", Long.valueOf(paramScheduledTask.Event.UnadjustedStartTime().getTime()));
      localContentValues.put("recPeriod", Long.valueOf(paramScheduledTask.Event.getRecurrencePeriod().getTotalMilliseconds()));
      localContentValues.put("recInterval", Integer.valueOf(paramScheduledTask.Event.getRecurrenceInterval()));
      localContentValues.put("operationId", paramScheduledTask.Operation().ID().toString());
      localContentValues.put("state", paramScheduledTask.Operation().SerializedData());
      CoreHelper.WriteTraceEntry(TAG, "Saving task record for: " + paramScheduledTask);
      if (paramScheduledTask.RowID() != null) {
        break label254;
      }
      long l = this.db.insert("scheduled_tasks", null, localContentValues);
      if (l == -1L) {
        break label228;
      }
      paramScheduledTask.InitRowID(Long.valueOf(l));
    }
    for (;;)
    {
      paramScheduledTask.SetIsModified(false);
      paramScheduledTask.Event.SetIsModified(false);
      paramScheduledTask.Operation().SetIsModified(false);
      return;
      i = 0;
      break;
      label228:
      CoreHelper.WriteTraceEntry(TAG, "!!! Failed to insert task record for: " + paramScheduledTask);
      continue;
      label254:
      if (this.db.update("scheduled_tasks", localContentValues, "_id=" + paramScheduledTask.RowID(), null) != 1) {
        CoreHelper.WriteTraceEntry(TAG, "!!! Failed to update task record for: " + paramScheduledTask);
      }
    }
  }
  
  public void SaveTrack(Track paramTrack)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("path", paramTrack.TrackPath());
    localContentValues.put("totalTime", Long.valueOf(paramTrack.getTotalTime()));
    localContentValues.put("playedTime", Long.valueOf(paramTrack.getPlayedTime()));
    localContentValues.put("name", paramTrack.getName());
    localContentValues.put("contentType", paramTrack.ContentMimeType());
    int i;
    Long localLong;
    if (paramTrack.IsPlayed())
    {
      i = 1;
      localContentValues.put("played", Integer.valueOf(i));
      localContentValues.put("protocol", paramTrack.getProtocol());
      localContentValues.put("url", paramTrack.getUrl());
      localContentValues.put("downloadSize", Long.valueOf(paramTrack.getDownloadSize()));
      localContentValues.put("downloadPortion", Long.valueOf(paramTrack.getDownloadedPortion()));
      if (paramTrack.getLastModifiedDate() == null) {
        break label338;
      }
      localLong = Long.valueOf(paramTrack.getLastModifiedDate().getTime());
      label159:
      localContentValues.put("pubDate", localLong);
      localContentValues.put("orgRssItemID", paramTrack.RssItemID());
      localContentValues.put("parentFeedID", paramTrack.getParentFeed().ID().toString());
      localContentValues.put("imagePath", paramTrack.TrackImagePath());
      localContentValues.put("description", paramTrack.TrackDescription());
      localContentValues.put("postTitle", paramTrack.TrackPostTitle());
      localContentValues.put("postUrl", paramTrack.TrackPostUrl());
      if (!paramTrack.Locked()) {
        break label344;
      }
      i = 1;
      label249:
      localContentValues.put("locked", Integer.valueOf(i));
      CoreHelper.WriteTraceEntry(TAG, "Saving track record for: " + paramTrack.getName());
      if (paramTrack.RowID() != null) {
        break label378;
      }
      long l = this.db.insert("tracks", null, localContentValues);
      if (l == -1L) {
        break label349;
      }
      paramTrack.InitRowID(Long.valueOf(l));
      paramTrack.ChangeTrackingEnabled = true;
    }
    for (;;)
    {
      paramTrack.SetIsModified(false);
      return;
      i = 0;
      break;
      label338:
      localLong = null;
      break label159;
      label344:
      i = 0;
      break label249;
      label349:
      CoreHelper.WriteTraceEntry(TAG, "!!! Failed to insert track record for: " + paramTrack.getName());
      continue;
      label378:
      if (this.db.update("tracks", localContentValues, "_id=" + paramTrack.RowID(), null) != 1) {
        CoreHelper.WriteTraceEntry(TAG, "!!! Failed to update track record for: " + paramTrack.getName());
      }
    }
  }
  
  public void SaveTrackedChange(TrackedChangeBase paramTrackedChangeBase)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(COLS_CHANGE_HISTORY[1], Long.valueOf(paramTrackedChangeBase.TimeStamp()));
    localContentValues.put(COLS_CHANGE_HISTORY[2], Integer.valueOf(paramTrackedChangeBase.ChangeType()));
    localContentValues.put(COLS_CHANGE_HISTORY[3], Integer.valueOf(paramTrackedChangeBase.SyncStatus()));
    localContentValues.put(COLS_CHANGE_HISTORY[4], paramTrackedChangeBase.Blob());
    if (paramTrackedChangeBase.RowID() == null)
    {
      long l = this.db.insert("change_history", null, localContentValues);
      if (l != -1L)
      {
        paramTrackedChangeBase.InitRowID(Long.valueOf(l));
        paramTrackedChangeBase.SetIsModified(false);
        return;
      }
      CoreHelper.WriteTraceEntry(TAG, "!!! Failed to isert change history record for: " + paramTrackedChangeBase.FriendlyName());
      return;
    }
    if (this.db.update("change_history", localContentValues, "_id=" + paramTrackedChangeBase.RowID(), null) != 1)
    {
      CoreHelper.WriteTraceEntry(TAG, "!!! Failed to update change history record for: " + paramTrackedChangeBase.FriendlyName());
      return;
    }
    paramTrackedChangeBase.SetIsModified(false);
  }
  
  public void beginTransaction()
  {
    this.db.beginTransaction();
  }
  
  public void cleanup()
  {
    if (this.db != null)
    {
      this.db.close();
      this.db = null;
    }
  }
  
  public void endTransaction()
  {
    this.db.endTransaction();
  }
  
  public void setTransactionSuccessful()
  {
    this.db.setTransactionSuccessful();
  }
  
  private static class DBOpenHelper
    extends SQLiteOpenHelper
  {
    private static final String DB_CREATE_CATEGORIES = "CREATE TABLE categories (_id INTEGER PRIMARY KEY, categories TEXT );";
    private static final String DB_CREATE_CHANGE_HISTORY = "CREATE TABLE change_history ( _id INTEGER PRIMARY KEY, timestamp INTEGER, changeType INTEGER, syncStatus INTEGER, blob TEXT);";
    private static final String DB_CREATE_FEEDS = "CREATE TABLE feeds (_id INTEGER PRIMARY KEY, feedId TEXT , path TEXT, name TEXT, autodelete INTEGER, view INTEGER,type INTEGER, url TEXT, imageUrl TEXT, hasUnread INTEGER, pubDate INTEGER,srvPubDate INTEGER, category TEXT, custDownload INTEGER, forceUniqueNames INTEGER,leftTruncateLongTrackNames INTEGER, forceItemSort INTEGER, lastItemId TEXT,trackSort INTEGER, feedPlayer INTEGER, username TEXT, maxDownload INTEGER,maxGReaderItems INTEGER, maxTracks INTEGER, maxTrackAge INTEGER, savePlayedPosition INTEGER, fingerprintType INTEGER);";
    private static final String DB_CREATE_SCHEDULER = "CREATE TABLE scheduled_tasks ( _id INTEGER PRIMARY KEY, taskId TEXT, active INTEGER, minBattLevel INTEGER, startTime INTEGER,recPeriod INTEGER, recInterval INTEGER, operationId TEXT, state TEXT );";
    private static final String DB_CREATE_TRACKS = "CREATE TABLE tracks (_id INTEGER PRIMARY KEY, path TEXT, totalTime INTEGER, playedTime INTEGER, name TEXT, contentType TEXT, played INTEGER,protocol TEXT, url TEXT, downloadSize INTEGER, downloadPortion INTEGER, pubDate INTEGER,orgFeedItemID TEXT, orgRssItemID TEXT, parentFeedID TEXT, imagePath TEXT, description TEXT, postTitle TEXT, postUrl TEXT, locked INTEGER );";
    private static final String UPGRADE_ADD_FEED_FINGERPRINT_COLUMN = "ALTER TABLE feeds ADD COLUMN fingerprintType INTEGER";
    private static final String UPGRADE_ADD_ORG_RSS_ITEM_ID_COLUMN = "ALTER TABLE tracks ADD COLUMN orgRssItemID TEXT";
    private static final String UPGRADE_ADD_PARENT_FEED_ID_COLUMN = "ALTER TABLE tracks ADD COLUMN parentFeedID TEXT";
    private static final String UPGRADE_ADD_SAVE_PLAYED_POSITION_COLUMN = "ALTER TABLE feeds ADD COLUMN savePlayedPosition INTEGER";
    private static final String UPGRADE_ADD_TRACK_DESCRIPTION_COLUMN = "ALTER TABLE tracks ADD COLUMN description TEXT";
    private static final String UPGRADE_ADD_TRACK_IMAGE_PATH_COLUMN = "ALTER TABLE tracks ADD COLUMN imagePath TEXT";
    private static final String UPGRADE_ADD_TRACK_LOCKED_COLUMN = "ALTER TABLE tracks ADD COLUMN locked INTEGER";
    private static final String UPGRADE_ADD_TRACK_POSTTITLE_COLUMN = "ALTER TABLE tracks ADD COLUMN postTitle TEXT";
    private static final String UPGRADE_ADD_TRACK_POSTURL_COLUMN = "ALTER TABLE tracks ADD COLUMN postUrl TEXT";
    private boolean _ForceSchemaCheck = false;
    
    public DBOpenHelper(Context paramContext)
    {
      super("beyondpod.db", null, 7);
    }
    
    private void ForceSchemaCheck(SQLiteDatabase paramSQLiteDatabase)
    {
      try
      {
        CoreHelper.WriteLogEntry(DatabaseHelper.TAG, "Executing Schema Check...");
        if (!HasField(paramSQLiteDatabase, "tracks", "orgRssItemID"))
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE tracks ADD COLUMN orgRssItemID TEXT");
          CoreHelper.WriteLogEntry(DatabaseHelper.TAG, "Inserted orgRssItemID column");
        }
        if (!HasField(paramSQLiteDatabase, "tracks", "parentFeedID"))
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE tracks ADD COLUMN parentFeedID TEXT");
          CoreHelper.WriteLogEntry(DatabaseHelper.TAG, "Inserted parentFeedID column");
        }
        if (!HasField(paramSQLiteDatabase, "feeds", "savePlayedPosition"))
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE feeds ADD COLUMN savePlayedPosition INTEGER");
          CoreHelper.WriteLogEntry(DatabaseHelper.TAG, "Inserted savePlayedPosition column");
        }
        if (!HasField(paramSQLiteDatabase, "tracks", "imagePath"))
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE tracks ADD COLUMN imagePath TEXT");
          CoreHelper.WriteLogEntry(DatabaseHelper.TAG, "Inserted imagePath column");
        }
        if (!HasField(paramSQLiteDatabase, "tracks", "description"))
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE tracks ADD COLUMN description TEXT");
          CoreHelper.WriteLogEntry(DatabaseHelper.TAG, "Inserted description column");
        }
        if (!HasField(paramSQLiteDatabase, "tracks", "postTitle"))
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE tracks ADD COLUMN postTitle TEXT");
          CoreHelper.WriteLogEntry(DatabaseHelper.TAG, "Inserted postTitle column");
        }
        if (!HasField(paramSQLiteDatabase, "tracks", "postUrl"))
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE tracks ADD COLUMN postUrl TEXT");
          CoreHelper.WriteLogEntry(DatabaseHelper.TAG, "Inserted postUrl column");
        }
        if (!HasField(paramSQLiteDatabase, "tracks", "locked"))
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE tracks ADD COLUMN locked INTEGER");
          CoreHelper.WriteLogEntry(DatabaseHelper.TAG, "Inserted locked column");
        }
        if (!HasField(paramSQLiteDatabase, "feeds", "fingerprintType"))
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE feeds ADD COLUMN fingerprintType INTEGER");
          CoreHelper.WriteLogEntry(DatabaseHelper.TAG, "Inserted fingerprintType column");
        }
        if (!HasField(paramSQLiteDatabase, "change_history", DatabaseHelper.COLS_CHANGE_HISTORY[0]))
        {
          paramSQLiteDatabase.execSQL("CREATE TABLE change_history ( _id INTEGER PRIMARY KEY, timestamp INTEGER, changeType INTEGER, syncStatus INTEGER, blob TEXT);");
          CoreHelper.WriteLogEntry(DatabaseHelper.TAG, "Created CHANGE_HISTORY table");
        }
        CoreHelper.WriteLogEntry(DatabaseHelper.TAG, "Schema Check Completed!");
        return;
      }
      catch (Exception paramSQLiteDatabase)
      {
        CoreHelper.LogException(DatabaseHelper.TAG, "Unable to Force Shchema Check!", paramSQLiteDatabase);
      }
    }
    
    private boolean HasField(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("PRAGMA table_info(" + paramString1 + ");", null);
      if (paramSQLiteDatabase != null)
      {
        boolean bool = false;
        if (!paramSQLiteDatabase.moveToNext()) {}
        for (;;)
        {
          paramSQLiteDatabase.close();
          return bool;
          if (!paramSQLiteDatabase.getString(1).equals(paramString2)) {
            break;
          }
          bool = true;
        }
      }
      return false;
    }
    
    private void onUpgradeInternal(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      CoreHelper.WriteLogEntry(DatabaseHelper.TAG, "Upgrading database from v" + paramInt1 + " to v" + paramInt2);
      if ((paramInt1 == 1) && (paramInt2 == 2)) {}
      try
      {
        paramSQLiteDatabase.execSQL("ALTER TABLE tracks ADD COLUMN orgRssItemID TEXT");
        if ((paramInt1 != 2) || (paramInt2 != 3)) {}
      }
      catch (Exception localException4)
      {
        try
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE tracks ADD COLUMN parentFeedID TEXT");
          paramSQLiteDatabase.execSQL("ALTER TABLE feeds ADD COLUMN savePlayedPosition INTEGER");
          if ((paramInt1 != 3) || (paramInt2 != 4)) {}
        }
        catch (Exception localException4)
        {
          try
          {
            paramSQLiteDatabase.execSQL("ALTER TABLE tracks ADD COLUMN imagePath TEXT");
            paramSQLiteDatabase.execSQL("ALTER TABLE tracks ADD COLUMN description TEXT");
            paramSQLiteDatabase.execSQL("ALTER TABLE tracks ADD COLUMN postTitle TEXT");
            paramSQLiteDatabase.execSQL("ALTER TABLE tracks ADD COLUMN postUrl TEXT");
            if ((paramInt1 != 4) || (paramInt2 != 5)) {}
          }
          catch (Exception localException4)
          {
            try
            {
              paramSQLiteDatabase.execSQL("ALTER TABLE tracks ADD COLUMN locked INTEGER");
              if ((paramInt1 != 5) || (paramInt2 != 6)) {}
            }
            catch (Exception localException4)
            {
              try
              {
                for (;;)
                {
                  paramSQLiteDatabase.execSQL("ALTER TABLE feeds ADD COLUMN fingerprintType INTEGER");
                  if ((paramInt1 == 6) && (paramInt2 == 7)) {}
                  try
                  {
                    paramSQLiteDatabase.execSQL("CREATE TABLE change_history ( _id INTEGER PRIMARY KEY, timestamp INTEGER, changeType INTEGER, syncStatus INTEGER, blob TEXT);");
                    return;
                  }
                  catch (Exception localException6)
                  {
                    CoreHelper.LogException(DatabaseHelper.TAG, "Unable to upgrade database from v6 -> v7! Forcing Schema Check...", localException6);
                    ForceSchemaCheck(paramSQLiteDatabase);
                  }
                  localException1 = localException1;
                  CoreHelper.LogException(DatabaseHelper.TAG, "Unable to upgrade from v 1 -> v2", localException1);
                  continue;
                  localException2 = localException2;
                  CoreHelper.LogException(DatabaseHelper.TAG, "Unable to upgrade database from v1 -> v2! Forcing Schema Check...", localException2);
                  ForceSchemaCheck(paramSQLiteDatabase);
                  continue;
                  localException3 = localException3;
                  CoreHelper.LogException(DatabaseHelper.TAG, "Unable to upgrade database from v3 -> v4! Forcing Schema Check...", localException3);
                  ForceSchemaCheck(paramSQLiteDatabase);
                }
                localException4 = localException4;
                CoreHelper.LogException(DatabaseHelper.TAG, "Unable to upgrade database from v4 -> v5! Forcing Schema Check...", localException4);
                ForceSchemaCheck(paramSQLiteDatabase);
              }
              catch (Exception localException5)
              {
                for (;;)
                {
                  CoreHelper.LogException(DatabaseHelper.TAG, "Unable to upgrade database from v5 -> v6! Forcing Schema Check...", localException5);
                  ForceSchemaCheck(paramSQLiteDatabase);
                }
              }
            }
          }
        }
      }
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      try
      {
        paramSQLiteDatabase.execSQL("CREATE TABLE feeds (_id INTEGER PRIMARY KEY, feedId TEXT , path TEXT, name TEXT, autodelete INTEGER, view INTEGER,type INTEGER, url TEXT, imageUrl TEXT, hasUnread INTEGER, pubDate INTEGER,srvPubDate INTEGER, category TEXT, custDownload INTEGER, forceUniqueNames INTEGER,leftTruncateLongTrackNames INTEGER, forceItemSort INTEGER, lastItemId TEXT,trackSort INTEGER, feedPlayer INTEGER, username TEXT, maxDownload INTEGER,maxGReaderItems INTEGER, maxTracks INTEGER, maxTrackAge INTEGER, savePlayedPosition INTEGER, fingerprintType INTEGER);");
        paramSQLiteDatabase.execSQL("CREATE TABLE tracks (_id INTEGER PRIMARY KEY, path TEXT, totalTime INTEGER, playedTime INTEGER, name TEXT, contentType TEXT, played INTEGER,protocol TEXT, url TEXT, downloadSize INTEGER, downloadPortion INTEGER, pubDate INTEGER,orgFeedItemID TEXT, orgRssItemID TEXT, parentFeedID TEXT, imagePath TEXT, description TEXT, postTitle TEXT, postUrl TEXT, locked INTEGER );");
        paramSQLiteDatabase.execSQL("CREATE TABLE categories (_id INTEGER PRIMARY KEY, categories TEXT );");
        paramSQLiteDatabase.execSQL("CREATE TABLE scheduled_tasks ( _id INTEGER PRIMARY KEY, taskId TEXT, active INTEGER, minBattLevel INTEGER, startTime INTEGER,recPeriod INTEGER, recInterval INTEGER, operationId TEXT, state TEXT );");
        paramSQLiteDatabase.execSQL("CREATE TABLE change_history ( _id INTEGER PRIMARY KEY, timestamp INTEGER, changeType INTEGER, syncStatus INTEGER, blob TEXT);");
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        CoreHelper.LogException(DatabaseHelper.TAG, "Unable to create BeyondPod Database", paramSQLiteDatabase);
      }
    }
    
    public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      CoreHelper.WriteLogEntry(DatabaseHelper.TAG, "Downgrading database from v" + paramInt1 + " to v" + paramInt2);
    }
    
    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      super.onOpen(paramSQLiteDatabase);
      if (this._ForceSchemaCheck) {
        ForceSchemaCheck(paramSQLiteDatabase);
      }
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      int i = paramInt1;
      paramInt1 = i + 1;
      int j;
      do
      {
        onUpgradeInternal(paramSQLiteDatabase, i, paramInt1);
        j = paramInt1 + 1;
        i = paramInt1;
        paramInt1 = j;
      } while (j <= paramInt2);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/repository/DatabaseHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */