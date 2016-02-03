package mobi.beyondpod.aggregators.greader;

import android.net.Uri;
import android.net.Uri.Builder;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.R.string;
import mobi.beyondpod.aggregators.AggregatorLoginHelper.GSimpleResult;
import mobi.beyondpod.aggregators.AggregatorLoginHelper.GSyncStatusResult;
import mobi.beyondpod.aggregators.AggregatorRequestQueue;
import mobi.beyondpod.aggregators.AggregatorRequestQueue.QueueListener;
import mobi.beyondpod.aggregators.GDataObject;
import mobi.beyondpod.aggregators.GDataObjectList;
import mobi.beyondpod.aggregators.RequestBase;
import mobi.beyondpod.downloadengine.DownloadAgent;
import mobi.beyondpod.downloadengine.DownloadAgent.DownloadListener;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.rss.ItemStateHistory;
import mobi.beyondpod.rsscore.rss.ItemStateHistory.ItemStatus;

public class GoogleReader
{
  private static final String ALL_NEW_ITEMS_IN;
  public static String AuthRequestHeader;
  static volatile String AuthenticationToken;
  public static Uri FeedUri;
  private static final String GOOGLE_READER_FEEDS;
  public static String LoginAgent;
  private static final String MY_GOOGLE_ITEMS;
  private static final String MY_READING_LIST;
  private static final String MY_READ_ITEMS;
  private static final String MY_STARRED_ITEMS;
  private static final String PERCENT_COMPLETE = CoreHelper.LoadResourceString(R.string.percent_complete);
  public static Uri ReadItemsUri;
  public static Uri ReaderUri;
  public static Uri ReadingTagUri;
  public static Uri ReadingUri;
  public static Uri SharedFeedUri;
  public static Uri StarredUri;
  public static Uri SubscriptionListUri;
  public static Uri SubscriptionUri;
  private static final String TAG;
  public static URI TokenUri;
  private static final String UPDATING_GOOGLE_READER = CoreHelper.LoadResourceString(R.string.updating_google_reader);
  static volatile String UserID;
  private static DownloadAgent.DownloadListener _FeedListDownloadListener;
  static GGetFeedsResult _GetFeedsResult;
  static AggregatorLoginHelper.GSimpleResult _LoginResult;
  static AggregatorRequestQueue _ReaderCaller;
  static File _ReceiveFile;
  static final String readerUri = "http://www.google.com/reader";
  
  static
  {
    MY_READ_ITEMS = CoreHelper.LoadResourceString(R.string.reader_folder_my_read_items);
    MY_STARRED_ITEMS = CoreHelper.LoadResourceString(R.string.reader_folder_my_starred_items);
    MY_READING_LIST = CoreHelper.LoadResourceString(R.string.reader_folder_my_reading_list);
    MY_GOOGLE_ITEMS = CoreHelper.LoadResourceString(R.string.reader_folder_my_google_items);
    ALL_NEW_ITEMS_IN = CoreHelper.LoadResourceString(R.string.reader_folder_all_new_items_in);
    GOOGLE_READER_FEEDS = CoreHelper.LoadResourceString(R.string.google_reader_feeds);
    TAG = GoogleReader.class.getSimpleName();
    _ReceiveFile = new File(Configuration.RssCachePath(), "googlereader.xml");
    ReaderUri = Uri.parse("http://www.google.com/reader");
    TokenUri = URI.create("http://www.google.com/reader/api/0/token");
    SubscriptionListUri = Uri.parse("http://www.google.com/reader/api/0/subscription/list");
    ReadingUri = Uri.parse("http://www.google.com/reader/atom/user/-/state/com.google/reading-list");
    ReadItemsUri = Uri.parse("http://www.google.com/reader/atom/user/-/state/com.google/read");
    ReadingTagUri = Uri.parse("http://www.google.com/reader/atom/user/-/label/");
    StarredUri = Uri.parse("http://www.google.com/reader/atom/user/-/state/com.google/starred");
    SubscriptionUri = Uri.parse("http://www.google.com/reader/api/0/subscription/edit");
    FeedUri = Uri.parse("http://www.google.com/reader/atom/feed/");
    SharedFeedUri = Uri.parse("http://www.google.com/reader/public/atom/user");
    if (Configuration.HasCustomUserAgent()) {}
    for (String str = Configuration.DefaultUserAgent();; str = Configuration.MO_USER_AGENT)
    {
      LoginAgent = str;
      AuthRequestHeader = "Authorization";
      UserID = "-";
      _FeedListDownloadListener = new DownloadAgent.DownloadListener()
      {
        public void OnDownloadCompleted(DownloadAgent paramAnonymousDownloadAgent, boolean paramAnonymousBoolean)
        {
          paramAnonymousDownloadAgent = GoogleReader.ParseFeedFile();
          if (paramAnonymousDownloadAgent != null)
          {
            GoogleReader._GetFeedsResult.Success(paramAnonymousDownloadAgent);
            return;
          }
          GoogleReader._GetFeedsResult.Failed(new Exception("Unable to load subscription list!"));
        }
        
        public void OnDownloadError(DownloadAgent paramAnonymousDownloadAgent, Exception paramAnonymousException)
        {
          GoogleReader._GetFeedsResult.Failed(paramAnonymousException);
        }
        
        public void OnDownloadProgress(DownloadAgent paramAnonymousDownloadAgent, long paramAnonymousLong1, long paramAnonymousLong2) {}
        
        public void OnDownloadStarted(DownloadAgent paramAnonymousDownloadAgent) {}
        
        public void OnDownloadTerminated(DownloadAgent paramAnonymousDownloadAgent) {}
      };
      return;
    }
  }
  
  public static void AddSubscription(Feed paramFeed, AggregatorLoginHelper.GSimpleResult paramGSimpleResult)
    throws Exception
  {
    paramGSimpleResult = new AggregatorRequestQueue(new AggregatorRequestQueue.QueueListener()
    {
      public void OnQueueCompleted(boolean paramAnonymousBoolean, List<RequestBase> paramAnonymousList)
      {
        paramAnonymousList = paramAnonymousList.iterator();
        RequestBase localRequestBase;
        do
        {
          if (!paramAnonymousList.hasNext())
          {
            GoogleReader.this.Success();
            return;
          }
          localRequestBase = (RequestBase)paramAnonymousList.next();
        } while (localRequestBase.Status() != 2);
        GoogleReader.this.Failed(localRequestBase.LastException());
      }
      
      public void OnQueueProgress(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public void OnQueueStarted(int paramAnonymousInt) {}
    });
    paramGSimpleResult.QueueRequest(new GRequestGetToken());
    paramGSimpleResult.QueueRequest(new GRequestEditSubscription(paramFeed.getFeedUrl(), paramFeed.getName(), 0));
    paramGSimpleResult.ExecuteQueuedRequests();
  }
  
  private static void BatchRequest(ArrayList<String> paramArrayList, int paramInt, String paramString)
    throws Exception
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("Adding a batch of ").append(paramArrayList.size()).append(" items for tag: ");
    if (paramInt == 0) {}
    for (Object localObject = "Add ";; localObject = "Remove ")
    {
      CoreHelper.WriteLogEntryInProduction(str, (String)localObject + paramString);
      int i = 0;
      int k;
      do
      {
        k = Math.min(paramArrayList.size() - i, 50);
        int j = i;
        if (k > 0)
        {
          localObject = new ArrayList(paramArrayList.subList(i, i + k));
          j = i + k;
          _ReaderCaller.QueueRequest(new GRequestEditTag((ArrayList)localObject, paramInt, paramString));
        }
        i = j;
      } while (k > 0);
      return;
    }
  }
  
  public static Feed BuildFeedList(GDataObject paramGDataObject)
  {
    HashMap localHashMap = new HashMap();
    Feed localFeed = new Feed(UUID.randomUUID(), null, GOOGLE_READER_FEEDS, null, 5);
    InsertCommonFeeds(localFeed);
    Iterator localIterator = paramGDataObject.List.iterator();
    if (!localIterator.hasNext()) {
      return localFeed;
    }
    Object localObject1 = (GDataObject)localIterator.next();
    if ((((GDataObject)localObject1).List == null) || (((GDataObject)localObject1).List.size() == 0)) {
      paramGDataObject = localFeed;
    }
    for (;;)
    {
      localObject1 = new Feed(UUID.randomUUID(), localFeed, ((GDataObject)localObject1).Title, ((GDataObject)localObject1).GetIDAsUrl(), 5);
      paramGDataObject.SubFeeds().add(localObject1);
      break;
      Object localObject2 = ((GDataObject)((GDataObject)localObject1).List.get(0)).Label;
      if (localHashMap.containsKey(localObject2))
      {
        paramGDataObject = (Feed)localHashMap.get(localObject2);
      }
      else
      {
        paramGDataObject = new Feed(UUID.randomUUID(), localFeed, (String)localObject2, null, 5);
        localFeed.setType(5);
        localHashMap.put(localObject2, paramGDataObject);
        localFeed.SubFeeds().add(paramGDataObject);
        localObject2 = new Feed(UUID.randomUUID(), paramGDataObject, ALL_NEW_ITEMS_IN + " '" + (String)localObject2 + "'", ReadingTagUri.buildUpon().appendPath((String)localObject2).build().toString(), 5);
        paramGDataObject.SubFeeds().add(localObject2);
      }
    }
  }
  
  private static void CallGoolge(String paramString, boolean paramBoolean, DownloadAgent.DownloadListener paramDownloadListener)
  {
    if (_ReceiveFile.exists()) {
      _ReceiveFile.delete();
    }
    paramString = new DownloadAgent(Uri.parse(paramString), _ReceiveFile, null);
    paramString.SetAllowRedirects(paramBoolean);
    paramString.SetRequestCookie(Configuration.GReaderCookie());
    paramString.SetMustRequestReaderToken(true);
    paramString.SetUserAgent(LoginAgent);
    paramString.setDownloadListenter(paramDownloadListener);
    try
    {
      paramString.StartDownload();
      return;
    }
    catch (Exception paramString)
    {
      while (paramDownloadListener == null) {}
      paramDownloadListener.OnDownloadError(null, paramString);
    }
  }
  
  public static void GetFeedList(GGetFeedsResult paramGGetFeedsResult)
  {
    _GetFeedsResult = paramGGetFeedsResult;
    CallGoolge("http://www.google.com/reader/api/0/subscription/list?output=xml", true, _FeedListDownloadListener);
  }
  
  public static Uri GetFeedUri(Feed paramFeed)
  {
    if (!paramFeed.IsGReaderFeed())
    {
      localObject2 = paramFeed.getFeedUri();
      return (Uri)localObject2;
    }
    Object localObject1 = paramFeed.getFeedUri().getScheme();
    Object localObject2 = paramFeed.getFeedUri().getHost();
    if ((localObject1 == null) || (localObject2 == null)) {
      localObject1 = SharedFeedUri.buildUpon().appendPath(paramFeed.getFeedUrl()).build();
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (paramFeed.getMaxNumGReaderItemsToGet() <= 0) {
        break;
      }
      return ((Uri)localObject1).buildUpon().appendQueryParameter("n", Integer.toString(paramFeed.getMaxNumGReaderItemsToGet())).build();
      if ((("http".equalsIgnoreCase((String)localObject1)) || ("https".equalsIgnoreCase((String)localObject1))) && (!"www.google.com".equalsIgnoreCase((String)localObject2))) {
        localObject1 = FeedUri.buildUpon().appendPath(paramFeed.getFeedUrl()).build();
      } else {
        localObject1 = paramFeed.getFeedUri();
      }
    }
  }
  
  public static boolean HasCachedAuthTokens()
  {
    return ((!StringUtils.IsNullOrEmpty(Configuration.GReaderCookie())) && (Configuration.GReaderCookie().startsWith("SID"))) || (!StringUtils.IsNullOrEmpty(Configuration.GReaderAuthValue()));
  }
  
  private static void InsertCommonFeeds(Feed paramFeed)
  {
    Feed localFeed1 = new Feed(UUID.randomUUID(), paramFeed, MY_GOOGLE_ITEMS, null, 5);
    paramFeed.SubFeeds().add(localFeed1);
    paramFeed = new Feed(UUID.randomUUID(), localFeed1, MY_READING_LIST, ReadingUri.toString(), 5);
    Feed localFeed2 = new Feed(UUID.randomUUID(), localFeed1, MY_STARRED_ITEMS, StarredUri.toString(), 5);
    Feed localFeed3 = new Feed(UUID.randomUUID(), localFeed1, MY_READ_ITEMS, ReadItemsUri.toString(), 5);
    localFeed1.SubFeeds().add(paramFeed);
    localFeed1.SubFeeds().add(localFeed2);
    localFeed1.SubFeeds().add(localFeed3);
  }
  
  public static boolean IsCategoryAggregatorFeed(Feed paramFeed)
  {
    if ((paramFeed == null) || (!paramFeed.HasUrl())) {
      return false;
    }
    return paramFeed.getFeedUrl().toLowerCase().startsWith("http://www.google.com/reader/atom/user/-/");
  }
  
  public static boolean IsLoggedIn()
  {
    if (!StringUtils.IsNullOrEmpty(Configuration.GReaderAccountName())) {}
    while ((!StringUtils.IsNullOrEmpty(Configuration.GReaderAuthValue())) || (!StringUtils.IsNullOrEmpty(Configuration.GReaderCookie()))) {
      return true;
    }
    return false;
  }
  
  public static boolean IsSyncing()
  {
    return (_ReaderCaller != null) && (_ReaderCaller.IsWorking());
  }
  
  public static void LogIn(final String paramString1, String paramString2, AggregatorLoginHelper.GSimpleResult paramGSimpleResult)
    throws Exception
  {
    paramString1 = paramString1.trim();
    paramString2 = paramString2.trim();
    try
    {
      paramString1 = new GRequestLogin(paramString1, paramString2);
      paramString2 = new AggregatorRequestQueue(new AggregatorRequestQueue.QueueListener()
      {
        public void OnQueueCompleted(boolean paramAnonymousBoolean, List<RequestBase> paramAnonymousList)
        {
          if (GoogleReader.this != null)
          {
            if (paramString1.Status() == 1) {
              GoogleReader.this.Success();
            }
          }
          else {
            return;
          }
          GoogleReader.this.Failed(paramString1.LastException());
        }
        
        public void OnQueueProgress(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public void OnQueueStarted(int paramAnonymousInt) {}
      });
      paramString2.QueueRequest(paramString1);
      paramString2.ExecuteQueuedRequests();
      return;
    }
    catch (Exception paramString1)
    {
      while (paramGSimpleResult == null) {}
      paramGSimpleResult.Failed(paramString1);
    }
  }
  
  /* Error */
  public static GDataObject ParseFeedFile()
  {
    // Byte code:
    //   0: getstatic 113	mobi/beyondpod/aggregators/greader/GoogleReader:TAG	Ljava/lang/String;
    //   3: ldc_w 537
    //   6: invokestatic 540	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: getstatic 128	mobi/beyondpod/aggregators/greader/GoogleReader:_ReceiveFile	Ljava/io/File;
    //   12: astore 5
    //   14: aload 5
    //   16: monitorenter
    //   17: getstatic 128	mobi/beyondpod/aggregators/greader/GoogleReader:_ReceiveFile	Ljava/io/File;
    //   20: invokevirtual 402	java/io/File:exists	()Z
    //   23: istore_0
    //   24: iload_0
    //   25: ifeq +179 -> 204
    //   28: aconst_null
    //   29: astore_2
    //   30: aconst_null
    //   31: astore 4
    //   33: aload_2
    //   34: astore_1
    //   35: invokestatic 546	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   38: invokevirtual 550	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   41: invokevirtual 556	javax/xml/parsers/SAXParser:getXMLReader	()Lorg/xml/sax/XMLReader;
    //   44: astore_3
    //   45: aload_2
    //   46: astore_1
    //   47: new 558	mobi/beyondpod/aggregators/greader/GoogleObjectParser$RootParser
    //   50: dup
    //   51: aload_3
    //   52: invokespecial 561	mobi/beyondpod/aggregators/greader/GoogleObjectParser$RootParser:<init>	(Lorg/xml/sax/XMLReader;)V
    //   55: astore 6
    //   57: aload_2
    //   58: astore_1
    //   59: aload_3
    //   60: aload 6
    //   62: invokeinterface 567 2 0
    //   67: aload_2
    //   68: astore_1
    //   69: new 569	java/io/FileInputStream
    //   72: dup
    //   73: getstatic 128	mobi/beyondpod/aggregators/greader/GoogleReader:_ReceiveFile	Ljava/io/File;
    //   76: invokespecial 572	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   79: astore_2
    //   80: aload_3
    //   81: new 574	org/xml/sax/InputSource
    //   84: dup
    //   85: aload_2
    //   86: invokespecial 577	org/xml/sax/InputSource:<init>	(Ljava/io/InputStream;)V
    //   89: invokeinterface 580 2 0
    //   94: aload 6
    //   96: invokevirtual 583	mobi/beyondpod/aggregators/greader/GoogleObjectParser$RootParser:Root	()Lmobi/beyondpod/aggregators/GDataObject;
    //   99: astore_1
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 586	java/io/FileInputStream:close	()V
    //   108: getstatic 113	mobi/beyondpod/aggregators/greader/GoogleReader:TAG	Ljava/lang/String;
    //   111: ldc_w 588
    //   114: invokestatic 540	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload 5
    //   119: monitorexit
    //   120: aload_1
    //   121: areturn
    //   122: astore_1
    //   123: aload 5
    //   125: monitorexit
    //   126: aconst_null
    //   127: areturn
    //   128: astore_1
    //   129: aload 5
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    //   134: astore_3
    //   135: aload 4
    //   137: astore_2
    //   138: aload_2
    //   139: astore_1
    //   140: getstatic 113	mobi/beyondpod/aggregators/greader/GoogleReader:TAG	Ljava/lang/String;
    //   143: ldc_w 590
    //   146: aload_3
    //   147: invokestatic 594	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   150: aload_2
    //   151: ifnull +7 -> 158
    //   154: aload_2
    //   155: invokevirtual 586	java/io/FileInputStream:close	()V
    //   158: getstatic 113	mobi/beyondpod/aggregators/greader/GoogleReader:TAG	Ljava/lang/String;
    //   161: ldc_w 588
    //   164: invokestatic 540	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload 5
    //   169: monitorexit
    //   170: aconst_null
    //   171: areturn
    //   172: astore_1
    //   173: aload 5
    //   175: monitorexit
    //   176: aconst_null
    //   177: areturn
    //   178: astore_2
    //   179: aload_1
    //   180: ifnull +7 -> 187
    //   183: aload_1
    //   184: invokevirtual 586	java/io/FileInputStream:close	()V
    //   187: getstatic 113	mobi/beyondpod/aggregators/greader/GoogleReader:TAG	Ljava/lang/String;
    //   190: ldc_w 588
    //   193: invokestatic 540	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload_2
    //   197: athrow
    //   198: astore_1
    //   199: aload 5
    //   201: monitorexit
    //   202: aconst_null
    //   203: areturn
    //   204: aload 5
    //   206: monitorexit
    //   207: aconst_null
    //   208: areturn
    //   209: astore_3
    //   210: aload_2
    //   211: astore_1
    //   212: aload_3
    //   213: astore_2
    //   214: goto -35 -> 179
    //   217: astore_3
    //   218: goto -80 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   23	2	0	bool	boolean
    //   34	87	1	localObject1	Object
    //   122	1	1	localException1	Exception
    //   128	5	1	localObject2	Object
    //   139	1	1	localObject3	Object
    //   172	12	1	localException2	Exception
    //   198	1	1	localException3	Exception
    //   211	1	1	localObject4	Object
    //   29	126	2	localObject5	Object
    //   178	33	2	localObject6	Object
    //   213	1	2	localObject7	Object
    //   44	37	3	localXMLReader	org.xml.sax.XMLReader
    //   134	13	3	localException4	Exception
    //   209	4	3	localObject8	Object
    //   217	1	3	localException5	Exception
    //   31	105	4	localObject9	Object
    //   12	193	5	localFile	File
    //   55	40	6	localRootParser	GoogleObjectParser.RootParser
    // Exception table:
    //   from	to	target	type
    //   104	108	122	java/lang/Exception
    //   17	24	128	finally
    //   104	108	128	finally
    //   108	120	128	finally
    //   123	126	128	finally
    //   129	132	128	finally
    //   154	158	128	finally
    //   158	170	128	finally
    //   173	176	128	finally
    //   183	187	128	finally
    //   187	198	128	finally
    //   199	202	128	finally
    //   204	207	128	finally
    //   35	45	134	java/lang/Exception
    //   47	57	134	java/lang/Exception
    //   59	67	134	java/lang/Exception
    //   69	80	134	java/lang/Exception
    //   154	158	172	java/lang/Exception
    //   35	45	178	finally
    //   47	57	178	finally
    //   59	67	178	finally
    //   69	80	178	finally
    //   140	150	178	finally
    //   183	187	198	java/lang/Exception
    //   80	100	209	finally
    //   80	100	217	java/lang/Exception
  }
  
  public static void SearchSubscriptions(String paramString, int paramInt, GGetFeedsResult paramGGetFeedsResult)
  {
    if (paramInt == 0) {}
    for (paramString = "http://www.google.com/reader/directory/search?q=" + paramString + "&client=scroll&output=xml";; paramString = "http://www.google.com/reader/directory/search?q=" + paramString + "&start=" + paramInt + "&client=scroll&output=xml")
    {
      _GetFeedsResult = paramGGetFeedsResult;
      CallGoolge(paramString, true, _FeedListDownloadListener);
      return;
    }
  }
  
  public static void SplitUnsinchronizedToBuckets(HashMap<String, ItemStateHistory.ItemStatus> paramHashMap, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<String> paramArrayList3, ArrayList<String> paramArrayList4)
  {
    Iterator localIterator = paramHashMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      String str = (String)localIterator.next();
      ItemStateHistory.ItemStatus localItemStatus = (ItemStateHistory.ItemStatus)paramHashMap.get(str);
      if (!localItemStatus.IsReadSynced())
      {
        if (!localItemStatus.IsRead()) {
          break label94;
        }
        paramArrayList1.add(str);
      }
      for (;;)
      {
        if (localItemStatus.IsStarSynced()) {
          break label102;
        }
        if (!localItemStatus.IsStarred()) {
          break label104;
        }
        paramArrayList3.add(str);
        break;
        label94:
        paramArrayList2.add(str);
      }
      label102:
      continue;
      label104:
      paramArrayList4.add(str);
    }
  }
  
  public static void StopSyncing()
  {
    if (IsSyncing()) {
      _ReaderCaller.Stop();
    }
  }
  
  public static boolean SyncItemStatus(final AggregatorLoginHelper.GSyncStatusResult paramGSyncStatusResult)
    throws Exception
  {
    CoreHelper.WriteTraceEntry(TAG, "--- Starting Reader Sync...");
    if (_ReaderCaller != null)
    {
      if (paramGSyncStatusResult != null) {
        paramGSyncStatusResult.SyncCompleted(false, 0, 0);
      }
      CoreHelper.WriteTraceEntry(TAG, "--- Another Reader Sync is already in progress! Exiting...");
    }
    HashMap localHashMap;
    do
    {
      return false;
      localHashMap = ItemStateHistory.GetAllUnsynchronizedGoogleReaderItems();
      if (localHashMap.size() != 0) {
        break;
      }
      CoreHelper.WriteTraceEntry(TAG, "--- Nothing to sync! Exiting...");
    } while (paramGSyncStatusResult == null);
    paramGSyncStatusResult.SyncCompleted(false, 0, -1);
    return false;
    CoreHelper.WriteTraceEntry(TAG, "--- Found " + localHashMap.size() + " items to sync");
    AnalyticsTracker.OnGReaderSync(localHashMap.size());
    _ReaderCaller = new AggregatorRequestQueue(new AggregatorRequestQueue.QueueListener()
    {
      public void OnQueueCompleted(boolean paramAnonymousBoolean, List<RequestBase> paramAnonymousList)
      {
        int i = 0;
        int k = 0;
        int m = 0;
        int j = 0;
        int n = 0;
        Object localObject1 = paramAnonymousList.iterator();
        Object localObject2;
        Object localObject3;
        if (!((Iterator)localObject1).hasNext())
        {
          localObject2 = GoogleReader.TAG;
          localObject3 = new StringBuilder("--- Google Reader Sync ");
          if (!paramAnonymousBoolean) {
            break label390;
          }
        }
        label390:
        for (localObject1 = "Cancelled";; localObject1 = "Complete")
        {
          CoreHelper.WriteLogEntryInProduction((String)localObject2, (String)localObject1 + "!. (" + paramAnonymousList.size() + " total, " + n + " succeded " + m + " failed, " + j + " pending). Synced: " + k + " Read and " + i + " Starred items.");
          if ((k > 0) || (i > 0)) {
            ItemStateHistory.MarkModified();
          }
          ItemStateHistory.SaveHistoryAsync();
          BeyondPodApplication.GetInstance().ClearReaderSyncNotification();
          GoogleReader._ReaderCaller = null;
          if (paramGSyncStatusResult != null) {
            paramGSyncStatusResult.SyncCompleted(paramAnonymousBoolean, k + i, paramAnonymousList.size());
          }
          return;
          localObject2 = (RequestBase)((Iterator)localObject1).next();
          if (((RequestBase)localObject2).Status() == 1)
          {
            int i3 = n + 1;
            n = i3;
            if (!(localObject2 instanceof GRequestEditTag)) {
              break;
            }
            localObject2 = (GRequestEditTag)localObject2;
            localObject3 = ((GRequestEditTag)localObject2).ItemIDs.iterator();
            int i2 = i;
            int i1 = k;
            for (;;)
            {
              n = i3;
              k = i1;
              i = i2;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
              Object localObject4 = (String)((Iterator)localObject3).next();
              localObject4 = (ItemStateHistory.ItemStatus)GoogleReader.this.get(localObject4);
              if (localObject4 != null) {
                if (((GRequestEditTag)localObject2).Tag.equals(GRequestEditTag.TAG_READ))
                {
                  i1 += 1;
                  ((ItemStateHistory.ItemStatus)localObject4).SetReadSynced();
                }
                else if (((GRequestEditTag)localObject2).Tag.equals(GRequestEditTag.TAG_STARRED))
                {
                  i2 += 1;
                  ((ItemStateHistory.ItemStatus)localObject4).SetStarSynced();
                }
              }
            }
          }
          if (((RequestBase)localObject2).Status() == 2)
          {
            m += 1;
            break;
          }
          j += 1;
          break;
        }
      }
      
      public void OnQueueProgress(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        int j = 0;
        int i = j;
        if (paramAnonymousInt1 >= 0)
        {
          i = j;
          if (paramAnonymousInt2 >= 0)
          {
            i = j;
            if (paramAnonymousInt2 >= paramAnonymousInt1) {
              i = (int)(paramAnonymousInt1 / paramAnonymousInt2 * 100.0F);
            }
          }
        }
        BeyondPodApplication.GetInstance().SetReaderSyncNotification(GoogleReader.UPDATING_GOOGLE_READER, i + " " + GoogleReader.PERCENT_COMPLETE);
      }
      
      public void OnQueueStarted(int paramAnonymousInt)
      {
        BeyondPodApplication.GetInstance().SetReaderSyncNotification(GoogleReader.UPDATING_GOOGLE_READER, "");
      }
    });
    _ReaderCaller.QueueRequest(new GRequestGetToken());
    paramGSyncStatusResult = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    SplitUnsinchronizedToBuckets(localHashMap, paramGSyncStatusResult, localArrayList1, localArrayList2, localArrayList3);
    if (paramGSyncStatusResult.size() > 0) {
      BatchRequest(paramGSyncStatusResult, 0, GRequestEditTag.TAG_READ);
    }
    if (localArrayList1.size() > 0) {
      BatchRequest(localArrayList1, 1, GRequestEditTag.TAG_READ);
    }
    if (localArrayList2.size() > 0) {
      BatchRequest(localArrayList2, 0, GRequestEditTag.TAG_STARRED);
    }
    if (localArrayList3.size() > 0) {
      BatchRequest(localArrayList3, 1, GRequestEditTag.TAG_STARRED);
    }
    _ReaderCaller.ExecuteQueuedRequests();
    return true;
  }
  
  public static abstract interface GGetFeedsResult
  {
    public abstract void Failed(Exception paramException);
    
    public abstract void Success(GDataObject paramGDataObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/aggregators/greader/GoogleReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */