package mobi.beyondpod.rsscore.repository;

import android.os.Handler;
import android.os.Looper;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackDictionary;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.schedulercore.ScheduledTask;

public class RepositoryPersistence
{
  private static final String TAG = "RepositoryPersistence";
  private static final Pattern _AlbumArtPattern;
  static Runnable _RepositorySaver;
  static Runnable _RepositoryUnloader;
  private static IRepositoryStorage _Storage = new SQLRepositoryStorage();
  private static RepositoryWorker _Worker = new RepositoryWorker(null);
  
  static
  {
    _Worker.setName("Repository Worker Thread");
    _Worker.setPriority(1);
    _Worker.start();
    for (;;)
    {
      if (_Worker._IsReady)
      {
        _RepositorySaver = new Runnable()
        {
          public void run() {}
        };
        _RepositoryUnloader = new Runnable()
        {
          public void run() {}
        };
        _AlbumArtPattern = Pattern.compile("AlbumArt\\S*jpg|folder.jpg|thumbs.db|desktop.ini", 2);
        return;
      }
      try
      {
        Thread.sleep(10L);
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
  
  static void AddChildTrack(Feed arg0, Track paramTrack, boolean paramBoolean)
  {
    ???.Tracks().add(paramTrack);
    if (!FeedRepository._TrackDictionary.containsKey(paramTrack.TrackPath())) {}
    synchronized (FeedRepository._TrackDictionary)
    {
      FeedRepository._TrackDictionary.put(paramTrack.TrackPath(), paramTrack);
      if (paramBoolean) {
        FeedRepository.OnTrackAdded(paramTrack);
      }
      return;
    }
  }
  
  static void AutoSaveRepository()
  {
    if (System.currentTimeMillis() - FeedRepository._LastSavedTime > 240000L) {
      SaveRepositoryAsync();
    }
  }
  
  static void BuildFeedList(Feed paramFeed, TrackDictionary paramTrackDictionary)
  {
    paramFeed.SubFeeds().clear();
    if (StringUtils.IsNullOrEmpty(paramFeed.getFeedPath())) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = new File(paramFeed.getFeedPath());
    } while (!((File)localObject1).exists());
    if (!paramFeed.HasUrl()) {}
    for (;;)
    {
      try
      {
        localObject1 = ((File)localObject1).listFiles();
        int j = localObject1.length;
        i = 0;
        if (i < j) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        int i;
        Object localObject2;
        CoreHelper.WriteLogEntry("RepositoryPersistence", "Error loading feeds! " + localThrowable.getMessage());
        continue;
      }
      try
      {
        LoadFeedTracks(paramFeed, paramTrackDictionary);
        return;
      }
      catch (Throwable paramTrackDictionary)
      {
        CoreHelper.LogException("RepositoryPersistence", String.format("Error loading podcasts for feed: %s.", new Object[] { paramFeed.getName() }), paramTrackDictionary);
        return;
      }
      localObject2 = localObject1[i];
      if ((((File)localObject2).isDirectory()) && (!((File)localObject2).isHidden()) && (!((File)localObject2).getName().startsWith(".")))
      {
        localObject2 = new Feed((File)localObject2, paramFeed);
        BuildFeedList((Feed)localObject2, paramTrackDictionary);
        paramFeed.SubFeeds().add(localObject2);
        if ((!paramFeed.HasUrl()) && (paramFeed.getLastModifiedDate() != null) && (((Feed)localObject2).getLastModifiedDate() != null) && (paramFeed.getLastModifiedDate().compareTo(((Feed)localObject2).getLastModifiedDate()) < 0)) {
          paramFeed.setLastModifiedDate(((Feed)localObject2).getLastModifiedDate());
        }
      }
      i += 1;
    }
  }
  
  private static boolean CanSaveRepository()
  {
    return FeedRepository.RepositoryLoadState() == 2;
  }
  
  public static void DeleteFeed(Feed paramFeed)
  {
    _Storage.DeleteFeed(paramFeed);
  }
  
  public static void DeleteRepositoryFiles()
  {
    _Storage.DeleteRepositoryFiles();
  }
  
  public static void DeleteScheduledTask(ScheduledTask paramScheduledTask)
  {
    _Storage.DeleteTask(paramScheduledTask);
  }
  
  public static void DeleteTrack(Track paramTrack)
  {
    _Storage.DeleteTrack(paramTrack);
  }
  
  public static void DeleteTracks(TrackList paramTrackList)
  {
    _Storage.DeleteTracks(paramTrackList);
  }
  
  private static boolean IsOnIgnoreList(String paramString)
  {
    return _AlbumArtPattern.matcher(paramString).find();
  }
  
  private static boolean IsRepositoryLoadingOrSaving()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (FeedRepository.RepositoryLoadState() != 0)
    {
      bool1 = bool2;
      if (FeedRepository.RepositoryLoadState() != 1)
      {
        bool1 = bool2;
        if (FeedRepository.RepositoryLoadState() != 3) {
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  private static void LoadFeedTracks(Feed paramFeed, TrackDictionary paramTrackDictionary)
  {
    paramFeed.Tracks().clear();
    if (StringUtils.IsNullOrEmpty(paramFeed.getFeedPath())) {}
    File localFile;
    do
    {
      return;
      localFile = new File(paramFeed.getFeedPath());
    } while (!localFile.exists());
    File[] arrayOfFile = localFile.listFiles();
    int j = arrayOfFile.length;
    int i = 0;
    Object localObject;
    for (;;)
    {
      if (i >= j)
      {
        if ((paramFeed.HasUrl()) || (paramFeed.getLastModifiedDate() != null)) {
          break;
        }
        paramFeed.setLastModifiedDate(new Date(localFile.lastModified()));
        return;
      }
      localObject = arrayOfFile[i];
      if ((((File)localObject).isFile()) && (!((File)localObject).isHidden()) && (((File)localObject).length() != 0L) && (!IsOnIgnoreList(((File)localObject).getName()))) {
        break label138;
      }
      i += 1;
    }
    for (;;)
    {
      label138:
      Track localTrack2;
      try
      {
        boolean bool = FeedRepository._TrackDictionary.containsKey(((File)localObject).getPath());
        if (bool) {
          break;
        }
      }
      catch (Exception localException)
      {
        try
        {
          localTrack2 = new Track((File)localObject, paramFeed);
          if ((Configuration.getHideUnsupportedFileTypes()) && (!localTrack2.IsSupportedFileType())) {
            break;
          }
          AddChildTrack(paramFeed, localTrack2, false);
          Track localTrack1 = (Track)paramTrackDictionary.get(localTrack2.TrackPath());
          localObject = localTrack1;
          if (localTrack1 == null)
          {
            localObject = localTrack1;
            if (localTrack2.TrackPath().startsWith(Feed.MNT_SDCARD_MOUNT))
            {
              localTrack1 = (Track)paramTrackDictionary.get(localTrack2.TrackPath().substring(4));
              localObject = localTrack1;
              if (localTrack1 != null)
              {
                localTrack1.InitRowID(null);
                localObject = localTrack1;
              }
            }
          }
          if (localObject != null)
          {
            localTrack2.InitRowID(((Track)localObject).RowID());
            localTrack2.setName(((Track)localObject).getName());
            localTrack2.setContentMimeType(((Track)localObject).ContentMimeType());
            localTrack2.InitializePlayedTimes(((Track)localObject).getPlayedTime(), ((Track)localObject).getTotalTime(), ((Track)localObject).IsPlayed());
            localTrack2.setProtocol(((Track)localObject).getProtocol());
            localTrack2.setRssItemID(((Track)localObject).RssItemID());
            localTrack2.setTrackDescription(((Track)localObject).TrackDescription());
            localTrack2.setTrackImagePath(((Track)localObject).TrackImagePath());
            localTrack2.setTrackPostTitle(((Track)localObject).TrackPostTitle());
            localTrack2.setTrackPostUrl(((Track)localObject).TrackPostUrl());
            localTrack2.setLocked(((Track)localObject).Locked());
            if (((Track)localObject).HasUrl())
            {
              localTrack2.setDownloadedPortion(localTrack2.getSizeOnDisk());
              if (((Track)localObject).getDownloadSize() <= 0L) {
                break label549;
              }
              l = ((Track)localObject).getDownloadSize();
              localTrack2.setDownloadSize(l);
              localTrack2.setUrl(((Track)localObject).getUrl());
              if (!localTrack2.IsFullyDownloaded()) {
                localTrack2.setDownloadStatus(4);
              }
              if (((Track)localObject).getLastModifiedDate() != null) {
                localTrack2.setLastModifiedDate(((Track)localObject).getLastModifiedDate());
              }
            }
            if (localTrack2.RowID() != null) {
              localTrack2.SetIsModified(false);
            }
          }
          if ((paramFeed.HasUrl()) || (localTrack2.getLastModifiedDate() == null) || ((paramFeed.getLastModifiedDate() != null) && (paramFeed.getLastModifiedDate().compareTo(localTrack2.getLastModifiedDate()) >= 0))) {
            break;
          }
          paramFeed.setLastModifiedDate(localTrack2.getLastModifiedDate());
        }
        catch (IOException localIOException) {}
        localException = localException;
      }
      break;
      break;
      label549:
      long l = localTrack2.getSizeOnDisk();
    }
  }
  
  static boolean LoadRepository()
  {
    if (IsRepositoryLoadingOrSaving()) {
      return false;
    }
    Runnable local3 = new Runnable()
    {
      public void run()
      {
        try
        {
          RepositoryPersistence._Storage.LoadRepository();
          return;
        }
        catch (Exception localException)
        {
          CoreHelper.WriteTraceEntry("RepositoryPersistence", localException.getMessage());
          return;
        }
        finally
        {
          FeedRepository.OnRepositoryLoadComplete();
        }
      }
    };
    RepositoryHandler().post(local3);
    return true;
  }
  
  public static Date LongTermRepositoryBackupDate()
  {
    try
    {
      Object localObject = new File(Configuration.TrackStateBackupPath());
      if (((File)localObject).exists())
      {
        localObject = new Date(((File)localObject).lastModified());
        return (Date)localObject;
      }
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static Handler RepositoryHandler()
  {
    return _Worker.workerHandler;
  }
  
  static void SaveAndUnloadRepositoryAsync()
  {
    if (!CanSaveRepository())
    {
      CoreHelper.WriteTraceEntry("RepositoryPersistence", "Trying to save the repository but the repository is in invalid state: " + FeedRepository.RepositoryLoadState() + ". Save Ignored!");
      return;
    }
    RepositoryHandler().removeCallbacks(_RepositorySaver);
    RepositoryHandler().removeCallbacks(_RepositoryUnloader);
    RepositoryHandler().post(_RepositorySaver);
    RepositoryHandler().post(_RepositoryUnloader);
  }
  
  /* Error */
  static void SaveRepositoryAsOpml(String paramString)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore 4
    //   5: new 472	mobi/beyondpod/rsscore/helpers/XmlTextWriter
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 473	mobi/beyondpod/rsscore/helpers/XmlTextWriter:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 476	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteStartDocument	()V
    //   18: aload_2
    //   19: ldc_w 478
    //   22: invokevirtual 481	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteStartElement	(Ljava/lang/String;)V
    //   25: aload_2
    //   26: ldc_w 483
    //   29: ldc_w 485
    //   32: invokevirtual 488	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_2
    //   36: ldc_w 490
    //   39: invokevirtual 481	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteStartElement	(Ljava/lang/String;)V
    //   42: aload_2
    //   43: ldc_w 492
    //   46: invokevirtual 481	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteStartElement	(Ljava/lang/String;)V
    //   49: aload_2
    //   50: ldc_w 494
    //   53: invokevirtual 497	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteString	(Ljava/lang/String;)V
    //   56: aload_2
    //   57: ldc_w 492
    //   60: invokevirtual 500	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteEndElement	(Ljava/lang/String;)V
    //   63: aload_2
    //   64: ldc_w 502
    //   67: invokevirtual 481	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteStartElement	(Ljava/lang/String;)V
    //   70: aload_2
    //   71: new 221	java/util/Date
    //   74: dup
    //   75: invokespecial 503	java/util/Date:<init>	()V
    //   78: invokestatic 509	mobi/beyondpod/rsscore/helpers/DateTime:ToRFC822String	(Ljava/util/Date;)Ljava/lang/String;
    //   81: invokevirtual 497	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteString	(Ljava/lang/String;)V
    //   84: aload_2
    //   85: ldc_w 502
    //   88: invokevirtual 500	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteEndElement	(Ljava/lang/String;)V
    //   91: aload_2
    //   92: ldc_w 511
    //   95: invokevirtual 481	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteStartElement	(Ljava/lang/String;)V
    //   98: aload_2
    //   99: new 221	java/util/Date
    //   102: dup
    //   103: invokespecial 503	java/util/Date:<init>	()V
    //   106: invokestatic 509	mobi/beyondpod/rsscore/helpers/DateTime:ToRFC822String	(Ljava/util/Date;)Ljava/lang/String;
    //   109: invokevirtual 497	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteString	(Ljava/lang/String;)V
    //   112: aload_2
    //   113: ldc_w 511
    //   116: invokevirtual 500	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteEndElement	(Ljava/lang/String;)V
    //   119: aload_2
    //   120: ldc_w 490
    //   123: invokevirtual 500	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteEndElement	(Ljava/lang/String;)V
    //   126: aload_2
    //   127: ldc_w 513
    //   130: invokevirtual 481	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteStartElement	(Ljava/lang/String;)V
    //   133: invokestatic 519	mobi/beyondpod/rsscore/categories/CategoryManager:GetCategoriesForAssignment	()Lmobi/beyondpod/rsscore/categories/CategoryList;
    //   136: invokevirtual 525	mobi/beyondpod/rsscore/categories/CategoryList:iterator	()Ljava/util/Iterator;
    //   139: astore_1
    //   140: aload_1
    //   141: invokeinterface 530 1 0
    //   146: ifne +26 -> 172
    //   149: aload_2
    //   150: ldc_w 513
    //   153: invokevirtual 500	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteEndElement	(Ljava/lang/String;)V
    //   156: aload_2
    //   157: ldc_w 478
    //   160: invokevirtual 500	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteEndElement	(Ljava/lang/String;)V
    //   163: aload_2
    //   164: ifnull +7 -> 171
    //   167: aload_2
    //   168: invokevirtual 533	mobi/beyondpod/rsscore/helpers/XmlTextWriter:close	()V
    //   171: return
    //   172: aload_1
    //   173: invokeinterface 537 1 0
    //   178: checkcast 539	mobi/beyondpod/rsscore/categories/FeedCategory
    //   181: astore_3
    //   182: aload_2
    //   183: ldc_w 541
    //   186: invokevirtual 481	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteStartElement	(Ljava/lang/String;)V
    //   189: aload_2
    //   190: ldc_w 543
    //   193: aload_3
    //   194: invokevirtual 546	mobi/beyondpod/rsscore/categories/FeedCategory:Name	()Ljava/lang/String;
    //   197: invokevirtual 488	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: invokestatic 550	mobi/beyondpod/rsscore/repository/FeedRepository:getRootFeed	()Lmobi/beyondpod/rsscore/Feed;
    //   203: invokevirtual 148	mobi/beyondpod/rsscore/Feed:SubFeeds	()Lmobi/beyondpod/rsscore/FeedList;
    //   206: invokevirtual 551	mobi/beyondpod/rsscore/FeedList:iterator	()Ljava/util/Iterator;
    //   209: astore 4
    //   211: aload 4
    //   213: invokeinterface 530 1 0
    //   218: ifne +57 -> 275
    //   221: aload_2
    //   222: ldc_w 541
    //   225: invokevirtual 500	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteEndElement	(Ljava/lang/String;)V
    //   228: goto -88 -> 140
    //   231: astore_3
    //   232: aload_2
    //   233: astore_1
    //   234: ldc 17
    //   236: ldc_w 553
    //   239: iconst_2
    //   240: anewarray 4	java/lang/Object
    //   243: dup
    //   244: iconst_0
    //   245: aload_0
    //   246: aastore
    //   247: dup
    //   248: iconst_1
    //   249: aload_3
    //   250: invokevirtual 554	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   253: aastore
    //   254: invokestatic 191	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   257: invokestatic 248	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteLogEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: aload_2
    //   261: astore_1
    //   262: aload_3
    //   263: athrow
    //   264: astore_0
    //   265: aload_1
    //   266: ifnull +7 -> 273
    //   269: aload_1
    //   270: invokevirtual 533	mobi/beyondpod/rsscore/helpers/XmlTextWriter:close	()V
    //   273: aload_0
    //   274: athrow
    //   275: aload 4
    //   277: invokeinterface 537 1 0
    //   282: checkcast 89	mobi/beyondpod/rsscore/Feed
    //   285: astore 5
    //   287: aload 5
    //   289: invokevirtual 173	mobi/beyondpod/rsscore/Feed:HasUrl	()Z
    //   292: ifeq -81 -> 211
    //   295: aload 5
    //   297: invokevirtual 558	mobi/beyondpod/rsscore/Feed:getCategories	()Lmobi/beyondpod/rsscore/categories/FeedCategories;
    //   300: invokevirtual 564	mobi/beyondpod/rsscore/categories/FeedCategories:getPrimary	()Lmobi/beyondpod/rsscore/categories/FeedCategory;
    //   303: aload_3
    //   304: if_acmpne -93 -> 211
    //   307: aload_2
    //   308: ldc_w 541
    //   311: invokevirtual 481	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteStartElement	(Ljava/lang/String;)V
    //   314: aload_2
    //   315: ldc_w 543
    //   318: aload 5
    //   320: invokevirtual 185	mobi/beyondpod/rsscore/Feed:getName	()Ljava/lang/String;
    //   323: invokevirtual 488	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: aload_2
    //   327: ldc_w 566
    //   330: aload 5
    //   332: invokevirtual 569	mobi/beyondpod/rsscore/Feed:getFeedUrl	()Ljava/lang/String;
    //   335: invokevirtual 488	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   338: aload_2
    //   339: ldc_w 571
    //   342: ldc_w 573
    //   345: invokevirtual 488	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   348: aload_2
    //   349: ldc_w 541
    //   352: invokevirtual 500	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteEndElement	(Ljava/lang/String;)V
    //   355: goto -144 -> 211
    //   358: astore_0
    //   359: aload_2
    //   360: astore_1
    //   361: goto -96 -> 265
    //   364: astore_3
    //   365: aload 4
    //   367: astore_2
    //   368: goto -136 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	paramString	String
    //   1	360	1	localObject1	Object
    //   13	355	2	localObject2	Object
    //   181	13	3	localFeedCategory	mobi.beyondpod.rsscore.categories.FeedCategory
    //   231	73	3	localException1	Exception
    //   364	1	3	localException2	Exception
    //   3	363	4	localIterator	java.util.Iterator
    //   285	46	5	localFeed	Feed
    // Exception table:
    //   from	to	target	type
    //   14	140	231	java/lang/Exception
    //   140	163	231	java/lang/Exception
    //   172	211	231	java/lang/Exception
    //   211	228	231	java/lang/Exception
    //   275	355	231	java/lang/Exception
    //   5	14	264	finally
    //   234	260	264	finally
    //   262	264	264	finally
    //   14	140	358	finally
    //   140	163	358	finally
    //   172	211	358	finally
    //   211	228	358	finally
    //   275	355	358	finally
    //   5	14	364	java/lang/Exception
  }
  
  static void SaveRepositoryAsync()
  {
    if (!CanSaveRepository())
    {
      CoreHelper.WriteTraceEntry("RepositoryPersistence", "Trying to save the repository but the repository is in invalid state: " + FeedRepository.RepositoryLoadState() + ". Save Ignored!");
      return;
    }
    RepositoryHandler().removeCallbacks(_RepositorySaver);
    RepositoryHandler().post(_RepositorySaver);
  }
  
  static void SaveRepositorySync()
  {
    if (!CanSaveRepository())
    {
      CoreHelper.WriteTraceEntry("RepositoryPersistence", "Trying to save the repository but the repository is in invalid state: " + FeedRepository.RepositoryLoadState() + ". Save Ignored!");
      return;
    }
    _Storage.SaveRepository();
  }
  
  private static class RepositoryWorker
    extends Thread
  {
    private volatile boolean _IsReady = false;
    private Handler workerHandler;
    
    public void run()
    {
      Looper.prepare();
      this.workerHandler = new Handler();
      this._IsReady = true;
      Looper.loop();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/repository/RepositoryPersistence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */