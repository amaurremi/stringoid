package mobi.beyondpod.downloadengine;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Date;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.aggregators.AggregatorLoginHelper;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.rss.ItemStateHistory;
import mobi.beyondpod.rsscore.rss.RssFeedCache;
import mobi.beyondpod.rsscore.rss.entities.RssFeed;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;
import mobi.beyondpod.rsscore.rss.parsers.FeedParseData;
import mobi.beyondpod.ui.core.FeedImageCache;

public class RssFeedCatcher
  implements DownloadAgent.DownloadListener
{
  private static final String TAG = RssFeedCatcher.class.getSimpleName();
  FeedUpdateListener _FeedUpdateListener;
  private FeedImageDownloader.FeedImageDownloadListener _ImageDownloadListener = new FeedImageDownloader.FeedImageDownloadListener()
  {
    public void OnImageDownloadCompleted(Feed paramAnonymousFeed)
    {
      RssFeedCatcher.this.PublishUpdateCompletedEvent();
    }
  };
  private FeedParseData _LastParseData;
  long _LastProgressNotificationTime = 0L;
  private boolean _WiFiTurnedOnAtStart = false;
  private Feed m_Feed;
  private DownloadAgent m_FeedDownloadAgent;
  private FeedImageDownloader m_FeedImageDownloader;
  private boolean m_ForceUpdate = false;
  private DownloadStatistics m_Statistics;
  
  private void AutodetectItemFingerprintTypeIfNeeded(RssFeed paramRssFeed)
  {
    if (this.m_Feed.getItemFingerprintAlgorithm() != -1) {
      break label11;
    }
    label11:
    while (paramRssFeed == null) {
      return;
    }
    CoreHelper.WriteTraceEntry(TAG, "Detecting item fingerprint for feed " + this.m_Feed.getName() + "...");
    int i = paramRssFeed.AutodetectFingerprintType();
    this.m_Feed.setItemFingerprintAlgorithm(i);
    paramRssFeed.updateFingerprintAlgorithmTo(i);
    String str2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder("Fingerprint Type was set to: ");
    if (i == 2) {}
    for (String str1 = "GUID";; str1 = "TLP")
    {
      CoreHelper.WriteTraceEntry(str2, str1);
      if ((this.m_Feed.getForceFeedItemSort() == -1) && (paramRssFeed.AutodetectSortOrder() == 2))
      {
        CoreHelper.WriteTraceEntry(TAG, "Detected reverse item sort! Setting to 'By Date Desc'...");
        this.m_Feed.setForceFeedItemSort(3);
      }
      if (paramRssFeed.peekEnclosureMediaTypes() != 1) {
        break;
      }
      this.m_Feed.setPodcastDownloadAction(3);
      return;
    }
  }
  
  private void CaptureStatistics()
  {
    if (this.m_FeedDownloadAgent != null) {
      this.m_Statistics = this.m_FeedDownloadAgent.Statistics();
    }
  }
  
  /* Error */
  public static void CreateFeedSnapshot(Feed paramFeed, RssFeed paramRssFeed, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aload 6
    //   8: astore 4
    //   10: aload_0
    //   11: invokevirtual 146	mobi/beyondpod/rsscore/Feed:getFeedUri	()Landroid/net/Uri;
    //   14: invokestatic 152	mobi/beyondpod/rsscore/rss/RssFeedCache:GetFeedDownloadPath	(Landroid/net/Uri;)Ljava/io/File;
    //   17: astore 8
    //   19: iload_2
    //   20: ifeq +240 -> 260
    //   23: aload 6
    //   25: astore 4
    //   27: new 154	java/io/File
    //   30: dup
    //   31: aload 8
    //   33: invokevirtual 157	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   36: ldc -97
    //   38: new 69	java/lang/StringBuilder
    //   41: dup
    //   42: ldc -95
    //   44: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   47: aload_1
    //   48: getfield 164	mobi/beyondpod/rsscore/rss/entities/RssFeed:Title	Ljava/lang/String;
    //   51: invokestatic 168	mobi/beyondpod/rsscore/helpers/CoreHelper:MakeValidFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   54: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc -86
    //   59: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokevirtual 176	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   68: invokespecial 177	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: astore 5
    //   73: iload_2
    //   74: ifne +15 -> 89
    //   77: aload 6
    //   79: astore 4
    //   81: aload 8
    //   83: aload 5
    //   85: invokestatic 183	mobi/beyondpod/rsscore/helpers/FileUtils:CopyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   88: pop
    //   89: aload 6
    //   91: astore 4
    //   93: new 185	java/io/FileOutputStream
    //   96: dup
    //   97: aload 5
    //   99: invokevirtual 157	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   102: ldc -97
    //   104: ldc -69
    //   106: invokevirtual 176	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   109: invokespecial 188	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   112: astore 8
    //   114: aload 6
    //   116: astore 4
    //   118: new 190	java/io/PrintWriter
    //   121: dup
    //   122: aload 8
    //   124: invokespecial 193	java/io/PrintWriter:<init>	(Ljava/io/OutputStream;)V
    //   127: astore 6
    //   129: aload_1
    //   130: getfield 164	mobi/beyondpod/rsscore/rss/entities/RssFeed:Title	Ljava/lang/String;
    //   133: astore 7
    //   135: aload_1
    //   136: getfield 197	mobi/beyondpod/rsscore/rss/entities/RssFeed:ItemIDGenerationAlgorithm	I
    //   139: istore_3
    //   140: aload_1
    //   141: getfield 197	mobi/beyondpod/rsscore/rss/entities/RssFeed:ItemIDGenerationAlgorithm	I
    //   144: iconst_1
    //   145: if_icmpne +217 -> 362
    //   148: ldc -57
    //   150: astore 4
    //   152: aload 6
    //   154: ldc -55
    //   156: iconst_3
    //   157: anewarray 4	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: aload 7
    //   164: aastore
    //   165: dup
    //   166: iconst_1
    //   167: iload_3
    //   168: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   171: aastore
    //   172: dup
    //   173: iconst_2
    //   174: aload 4
    //   176: aastore
    //   177: invokestatic 211	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   180: invokevirtual 214	java/io/PrintWriter:print	(Ljava/lang/String;)V
    //   183: aload_1
    //   184: getfield 218	mobi/beyondpod/rsscore/rss/entities/RssFeed:Items	Ljava/util/ArrayList;
    //   187: invokevirtual 224	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   190: astore_1
    //   191: aload_1
    //   192: invokeinterface 230 1 0
    //   197: ifne +173 -> 370
    //   200: aload 8
    //   202: invokestatic 234	mobi/beyondpod/rsscore/helpers/CoreHelper:sync	(Ljava/io/FileOutputStream;)Z
    //   205: pop
    //   206: aload 6
    //   208: invokevirtual 237	java/io/PrintWriter:close	()V
    //   211: getstatic 42	mobi/beyondpod/downloadengine/RssFeedCatcher:TAG	Ljava/lang/String;
    //   214: new 69	java/lang/StringBuilder
    //   217: dup
    //   218: ldc -17
    //   220: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   223: aload_0
    //   224: invokevirtual 77	mobi/beyondpod/rsscore/Feed:getName	()Ljava/lang/String;
    //   227: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: ldc -15
    //   232: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload 5
    //   237: invokevirtual 242	java/io/File:getName	()Ljava/lang/String;
    //   240: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 92	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: aload 6
    //   251: ifnull +181 -> 432
    //   254: aload 6
    //   256: invokevirtual 237	java/io/PrintWriter:close	()V
    //   259: return
    //   260: aload 6
    //   262: astore 4
    //   264: new 154	java/io/File
    //   267: dup
    //   268: aload 8
    //   270: invokevirtual 157	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   273: ldc -97
    //   275: new 69	java/lang/StringBuilder
    //   278: dup
    //   279: ldc -95
    //   281: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   284: aload_1
    //   285: getfield 164	mobi/beyondpod/rsscore/rss/entities/RssFeed:Title	Ljava/lang/String;
    //   288: invokestatic 168	mobi/beyondpod/rsscore/helpers/CoreHelper:MakeValidFileName	(Ljava/lang/String;)Ljava/lang/String;
    //   291: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: ldc -12
    //   296: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokestatic 250	java/lang/System:currentTimeMillis	()J
    //   302: invokevirtual 253	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   305: ldc -1
    //   307: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokevirtual 176	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   316: invokespecial 177	java/io/File:<init>	(Ljava/lang/String;)V
    //   319: astore 5
    //   321: goto -248 -> 73
    //   324: astore_1
    //   325: aload 7
    //   327: astore_0
    //   328: aload_0
    //   329: astore 4
    //   331: getstatic 42	mobi/beyondpod/downloadengine/RssFeedCatcher:TAG	Ljava/lang/String;
    //   334: ldc_w 257
    //   337: aload_1
    //   338: invokestatic 261	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   341: aload_0
    //   342: ifnull -83 -> 259
    //   345: aload_0
    //   346: invokevirtual 237	java/io/PrintWriter:close	()V
    //   349: return
    //   350: astore_0
    //   351: getstatic 42	mobi/beyondpod/downloadengine/RssFeedCatcher:TAG	Ljava/lang/String;
    //   354: ldc_w 257
    //   357: aload_0
    //   358: invokestatic 261	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   361: return
    //   362: ldc_w 263
    //   365: astore 4
    //   367: goto -215 -> 152
    //   370: aload_1
    //   371: invokeinterface 267 1 0
    //   376: checkcast 269	mobi/beyondpod/rsscore/rss/entities/RssFeedItem
    //   379: aload 6
    //   381: invokevirtual 273	mobi/beyondpod/rsscore/rss/entities/RssFeedItem:CreateItemSnapshot	(Ljava/io/PrintWriter;)V
    //   384: goto -193 -> 191
    //   387: astore_1
    //   388: aload 6
    //   390: astore_0
    //   391: goto -63 -> 328
    //   394: astore_0
    //   395: aload 4
    //   397: ifnull +8 -> 405
    //   400: aload 4
    //   402: invokevirtual 237	java/io/PrintWriter:close	()V
    //   405: aload_0
    //   406: athrow
    //   407: astore_1
    //   408: getstatic 42	mobi/beyondpod/downloadengine/RssFeedCatcher:TAG	Ljava/lang/String;
    //   411: ldc_w 257
    //   414: aload_1
    //   415: invokestatic 261	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   418: goto -13 -> 405
    //   421: astore_0
    //   422: getstatic 42	mobi/beyondpod/downloadengine/RssFeedCatcher:TAG	Ljava/lang/String;
    //   425: ldc_w 257
    //   428: aload_0
    //   429: invokestatic 261	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   432: return
    //   433: astore_0
    //   434: aload 6
    //   436: astore 4
    //   438: goto -43 -> 395
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	441	0	paramFeed	Feed
    //   0	441	1	paramRssFeed	RssFeed
    //   0	441	2	paramBoolean	boolean
    //   139	29	3	i	int
    //   8	429	4	localObject1	Object
    //   71	249	5	localFile	java.io.File
    //   1	434	6	localPrintWriter	java.io.PrintWriter
    //   4	322	7	str	String
    //   17	252	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   10	19	324	java/lang/Exception
    //   27	73	324	java/lang/Exception
    //   81	89	324	java/lang/Exception
    //   93	114	324	java/lang/Exception
    //   118	129	324	java/lang/Exception
    //   264	321	324	java/lang/Exception
    //   345	349	350	java/lang/Exception
    //   129	148	387	java/lang/Exception
    //   152	191	387	java/lang/Exception
    //   191	249	387	java/lang/Exception
    //   370	384	387	java/lang/Exception
    //   10	19	394	finally
    //   27	73	394	finally
    //   81	89	394	finally
    //   93	114	394	finally
    //   118	129	394	finally
    //   264	321	394	finally
    //   331	341	394	finally
    //   400	405	407	java/lang/Exception
    //   254	259	421	java/lang/Exception
    //   129	148	433	finally
    //   152	191	433	finally
    //   191	249	433	finally
    //   370	384	433	finally
  }
  
  private void DownloadFeedImage()
  {
    try
    {
      this.m_FeedImageDownloader = new FeedImageDownloader();
      this.m_FeedImageDownloader.setFeedUpdateListener(this._ImageDownloadListener);
      this.m_FeedImageDownloader.DownloadImage(this.m_Feed);
      return;
    }
    catch (Exception localException)
    {
      PublishUpdateCompletedEvent();
    }
  }
  
  private Uri GetFeedUrl(Feed paramFeed)
  {
    if (paramFeed.IsGReaderFeed()) {
      return AggregatorLoginHelper.GetFeedUri(paramFeed);
    }
    return paramFeed.getFeedUri();
  }
  
  private Date GetLastModifiedDate()
  {
    if (this.m_FeedDownloadAgent == null) {
      return new Date();
    }
    if (this.m_FeedDownloadAgent.LastModifiedDate() == null) {
      return new Date();
    }
    return this.m_FeedDownloadAgent.LastModifiedDate();
  }
  
  private void PostProcessFeed()
  {
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        this._LastParseData = new FeedParseData(2);
        this._LastParseData.LoadTempFeed = true;
        RssFeedCache.LoadFromCache(this.m_Feed, this._LastParseData);
        Object localObject1;
        if ((this._LastParseData.RssFeed != null) && (FeedParseData.IsRssFeedType(this._LastParseData.ParsedFeedType)))
        {
          localObject1 = this._LastParseData.RssFeed;
          if (localObject1 == null) {
            break label349;
          }
          boolean bool = RssFeedCache.CopyTempToPrimaryForFeed(this.m_Feed);
          AutodetectItemFingerprintTypeIfNeeded((RssFeed)localObject1);
          if (this.m_Feed.getName().contains("#*SAVE*#")) {
            CreateFeedSnapshot(this.m_Feed, (RssFeed)localObject1, false);
          }
          if (!StringUtils.IsNullOrEmpty(((RssFeed)localObject1).getFeedImageLink())) {
            this.m_Feed.setFeedImageUrl(((RssFeed)localObject1).getFeedImageLink());
          }
          ((RssFeed)localObject1).SyncOwnerFeedReadStatus();
          ItemStateHistory.PurgeOldRecordsForFeed((RssFeed)localObject1);
          localObject4 = ((RssFeed)localObject1).getLatestItemPubDate();
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = ((RssFeed)localObject1).PubDate;
          }
          if (((RssFeed)localObject1).Items.size() > 0)
          {
            localObject4 = ((RssFeedItem)((RssFeed)localObject1).Items.get(0)).ItemID();
            if (localObject3 == null) {
              continue;
            }
            if (!((Date)localObject3).equals(this.m_Feed.getLastModifiedDate()))
            {
              this.m_Feed.setHasNewContent(true);
              this.m_Feed.setLastModifiedDate((Date)localObject3);
            }
            if (bool) {
              this.m_Feed.setHasNewContent(true);
            }
            this.m_Feed.UpdateNameIfDefault(((RssFeed)localObject1).Title);
            this.m_Feed.setLastServerModifiedDate(GetLastModifiedDate());
          }
        }
        else
        {
          localObject1 = localObject3;
          if (this._LastParseData.ParsedFeedType != 3) {
            continue;
          }
          this.m_Feed.setType(4);
          localObject1 = localObject3;
          continue;
        }
      }
      catch (Exception localException)
      {
        Object localObject2 = null;
        continue;
        Object localObject4 = null;
        continue;
        if (localObject4 != null)
        {
          if (((String)localObject4).equals(this.m_Feed.getLastItemID())) {
            continue;
          }
          this.m_Feed.setHasNewContent(true);
          this.m_Feed.setLastItemID((String)localObject4);
          continue;
        }
        this.m_Feed.setHasNewContent(true);
        this.m_Feed.setLastModifiedDate(GetLastModifiedDate());
        continue;
      }
      label349:
      if (!RssFeedCache.HasCachedFileFor(this.m_Feed)) {
        RssFeedCache.CopyTempToPrimaryForFeed(this.m_Feed);
      }
      while (this.m_Feed.IsGReaderFeed())
      {
        this.m_Feed.setHasNewContent(true);
        return;
        RssFeedCache.DeleteTempFeedCacheFor(this.m_Feed);
      }
    }
  }
  
  private void PublishUpdateCompletedEvent()
  {
    TurnWiFiOffIfNeeded();
    if (this._FeedUpdateListener != null) {
      this._FeedUpdateListener.OnFeedUpdateCompleted(this.m_Feed);
    }
  }
  
  private void TurnWiFiOffIfNeeded()
  {
    if (this._WiFiTurnedOnAtStart) {
      BeyondPodApplication.ToggleWiFi(false, TAG);
    }
    this._WiFiTurnedOnAtStart = false;
  }
  
  private void TurnWiFiOnIfNeeded()
  {
    if (Configuration.TurnWiFiDuringUpdate()) {
      this._WiFiTurnedOnAtStart = BeyondPodApplication.ToggleWiFi(true, TAG);
    }
  }
  
  public boolean IsUpdating()
  {
    return (this.m_FeedDownloadAgent != null) && (this.m_FeedDownloadAgent.IsDownloading());
  }
  
  public FeedParseData LastFeedParseData()
  {
    return this._LastParseData;
  }
  
  public void OnDownloadCompleted(DownloadAgent paramDownloadAgent, boolean paramBoolean)
  {
    CaptureStatistics();
    int i;
    if (RssFeedCache.HasCachedFileFor(this.m_Feed))
    {
      i = 0;
      if ((!paramBoolean) && (!this.m_ForceUpdate) && (this.m_Feed.getItemFingerprintAlgorithm() != -1)) {
        break label84;
      }
      PostProcessFeed();
    }
    for (;;)
    {
      this.m_Feed.UpdateFailed = false;
      if (((!this.m_Feed.IsGReaderFeed()) || (i == 0)) && (!FeedImageCache.HasImageToDownload(this.m_Feed))) {
        break label101;
      }
      DownloadFeedImage();
      return;
      i = 1;
      break;
      label84:
      RssFeedCache.TouchFeedCacheFor(this.m_Feed);
      RssFeedCache.DeleteTempFeedCacheFor(this.m_Feed);
    }
    label101:
    PublishUpdateCompletedEvent();
  }
  
  public void OnDownloadError(DownloadAgent paramDownloadAgent, Exception paramException)
  {
    CaptureStatistics();
    this.m_Feed.UpdateFailed = true;
    RssFeedCache.DeleteTempFeedCacheFor(this.m_Feed);
    TurnWiFiOffIfNeeded();
    if (this._FeedUpdateListener != null) {
      this._FeedUpdateListener.OnFeedUpdateError(this.m_Feed, paramException);
    }
  }
  
  public void OnDownloadProgress(DownloadAgent paramDownloadAgent, long paramLong1, long paramLong2)
  {
    this.m_Feed.setUpdateSize(paramLong2);
    this.m_Feed.setUpdatedPortion(paramLong1);
    paramLong1 = System.currentTimeMillis();
    if (paramLong1 - this._LastProgressNotificationTime > 2000L)
    {
      this._LastProgressNotificationTime = paramLong1;
      if (this._FeedUpdateListener != null) {
        this._FeedUpdateListener.OnFeedUpdateProgress(this.m_Feed);
      }
    }
  }
  
  public void OnDownloadStarted(DownloadAgent paramDownloadAgent)
  {
    this.m_Feed.UpdateFailed = false;
    if (this._FeedUpdateListener != null) {
      this._FeedUpdateListener.OnFeedUpdateStarted(this.m_Feed);
    }
  }
  
  public void OnDownloadTerminated(DownloadAgent paramDownloadAgent)
  {
    CaptureStatistics();
    RssFeedCache.DeleteTempFeedCacheFor(this.m_Feed);
    TurnWiFiOffIfNeeded();
    if (this._FeedUpdateListener != null) {
      this._FeedUpdateListener.OnFeedUpdateTerminated(this.m_Feed);
    }
  }
  
  public DownloadStatistics Statistics()
  {
    return this.m_Statistics;
  }
  
  public void Stop()
  {
    if (this.m_FeedDownloadAgent != null) {
      this.m_FeedDownloadAgent.Stop();
    }
    if (this.m_FeedImageDownloader != null) {
      this.m_FeedImageDownloader.Stop();
    }
  }
  
  public void UpdateFeed(Feed paramFeed, boolean paramBoolean)
  {
    this.m_Feed = paramFeed;
    this.m_FeedDownloadAgent = null;
    this.m_Statistics = null;
    try
    {
      if (!this.m_Feed.HasUri()) {
        throw new IllegalArgumentException("Trying to update feed with invalid URL!");
      }
    }
    catch (Exception paramFeed)
    {
      CoreHelper.WriteLogEntry(TAG, String.format("Unable to start the download of Url: %s ! Reason: %s", new Object[] { this.m_Feed.getFeedUrl(), paramFeed.getMessage() }));
      OnDownloadError(null, paramFeed);
      return;
    }
    TurnWiFiOnIfNeeded();
    this.m_FeedDownloadAgent = new DownloadAgent(GetFeedUrl(this.m_Feed), RssFeedCache.GetFeedTempPath(this.m_Feed.getFeedUri()), this.m_Feed.Credentials());
    this.m_FeedDownloadAgent.setDownloadListenter(this);
    this.m_FeedDownloadAgent.SetAllowResume(false);
    if (paramFeed.IsGReaderFeed())
    {
      this.m_FeedDownloadAgent.SetRequestCookie(Configuration.GReaderCookie());
      this.m_FeedDownloadAgent.SetMustRequestReaderToken(true);
    }
    this.m_ForceUpdate = paramBoolean;
    if (!this.m_ForceUpdate)
    {
      long l = RssFeedCache.GetCachedFileSize(this.m_Feed.getFeedUri());
      if (l != -1L)
      {
        this.m_FeedDownloadAgent.SetIgnoreIfSize(Long.valueOf(l));
        this.m_FeedDownloadAgent.SetIgnoreIfNotModifiedSinceDate(this.m_Feed.getLastServerModifiedDate());
      }
    }
    this.m_Feed.setUpdateSize(0L);
    this.m_Feed.setUpdatedPortion(0L);
    this.m_FeedDownloadAgent.StartDownload();
  }
  
  public void setFeedUpdateListener(FeedUpdateListener paramFeedUpdateListener)
  {
    this._FeedUpdateListener = paramFeedUpdateListener;
  }
  
  public static abstract interface FeedUpdateListener
  {
    public abstract void OnFeedUpdateCompleted(Feed paramFeed);
    
    public abstract void OnFeedUpdateError(Feed paramFeed, Exception paramException);
    
    public abstract void OnFeedUpdateProgress(Feed paramFeed);
    
    public abstract void OnFeedUpdateStarted(Feed paramFeed);
    
    public abstract void OnFeedUpdateTerminated(Feed paramFeed);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/downloadengine/RssFeedCatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */