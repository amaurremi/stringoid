package mobi.beyondpod.aggregators.feedly;

import android.net.Uri;
import android.net.Uri.Builder;
import java.io.File;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.R.string;
import mobi.beyondpod.aggregators.AggregatorLoginHelper;
import mobi.beyondpod.aggregators.AggregatorLoginHelper.GSimpleResult;
import mobi.beyondpod.aggregators.AggregatorLoginHelper.GSyncStatusResult;
import mobi.beyondpod.aggregators.AggregatorRequestQueue;
import mobi.beyondpod.aggregators.AggregatorRequestQueue.QueueListener;
import mobi.beyondpod.aggregators.GDataObject;
import mobi.beyondpod.aggregators.GDataObjectList;
import mobi.beyondpod.aggregators.RequestBase;
import mobi.beyondpod.aggregators.greader.GRequestEditSubscription;
import mobi.beyondpod.aggregators.greader.GoogleReader;
import mobi.beyondpod.downloadengine.DownloadAgent;
import mobi.beyondpod.downloadengine.DownloadAgent.DownloadListener;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.helpers.AnalyticsTracker;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.rss.ItemStateHistory;
import mobi.beyondpod.rsscore.rss.ItemStateHistory.ItemStatus;
import mobi.beyondpod.rsscore.rss.RssFeedCache;

public class Feedly
{
  private static final String ALL_NEW_ITEMS_IN;
  public static String AuthRequestHeader;
  static String ClientID;
  static String ClientSTP;
  public static URI EditMarkerURL;
  public static Uri EditTagURL;
  public static Uri FeedlyUri;
  private static final String GOOGLE_READER_FEEDS;
  public static String LoginAgent;
  private static final String MY_GOOGLE_ITEMS;
  private static final String MY_READING_LIST;
  private static final String MY_READ_ITEMS;
  private static final String MY_STARRED_ITEMS;
  public static String OAuthEndPoint;
  public static String OAuthScope;
  private static final String PERCENT_COMPLETE = CoreHelper.LoadResourceString(R.string.percent_complete);
  static String RedirectURI;
  static String Referer;
  static String StarredTag;
  private static String StreamItemsSuffix;
  private static Uri StreamItemsUri;
  private static Uri SubscriptionListUri;
  private static final String TAG;
  public static URI TokenUri;
  private static final String UPDATING_GOOGLE_READER = CoreHelper.LoadResourceString(R.string.updating_google_reader);
  private static DownloadAgent.DownloadListener _FeedListDownloadListener;
  static FGetFeedsResult _GetFeedsResult;
  static AggregatorLoginHelper.GSimpleResult _LoginResult;
  static AggregatorRequestQueue _ReaderCaller;
  static File _ReceiveFile;
  private static final String _feedlyUri = "http://cloud.feedly.com";
  private static final String _feedlyUriSecure = "https://cloud.feedly.com";
  
  static
  {
    MY_READ_ITEMS = CoreHelper.LoadResourceString(R.string.reader_folder_my_read_items);
    MY_STARRED_ITEMS = CoreHelper.LoadResourceString(R.string.reader_folder_my_starred_items);
    MY_READING_LIST = CoreHelper.LoadResourceString(R.string.reader_folder_my_reading_list);
    MY_GOOGLE_ITEMS = CoreHelper.LoadResourceString(R.string.reader_folder_my_google_items);
    ALL_NEW_ITEMS_IN = CoreHelper.LoadResourceString(R.string.reader_folder_all_new_items_in);
    GOOGLE_READER_FEEDS = CoreHelper.LoadResourceString(R.string.google_reader_feeds);
    TAG = Feedly.class.getSimpleName();
    _ReceiveFile = new File(Configuration.RssCachePath(), "feedlydata.json");
    FeedlyUri = Uri.parse("http://cloud.feedly.com");
    Referer = "beyondpod.android";
    ClientID = "beyondpod";
    ClientSTP = String.format("%s%s%s%s%s%s", new Object[] { "GFIY", Integer.valueOf(38), "T", Integer.valueOf(21), "DFHBT", "3YNACQADNK" });
    RedirectURI = "http://localhost";
    TokenUri = URI.create("https://cloud.feedly.com/v3/auth/token");
    OAuthScope = "https://cloud.feedly.com/subscriptions";
    OAuthEndPoint = String.format("%s%s?response_type=code&client_id=%s&scope=%s&redirect_uri=%s", new Object[] { "https://cloud.feedly.com", "/v3/auth/auth", ClientID, URLEncoder.encode(OAuthScope), URLEncoder.encode(RedirectURI) });
    SubscriptionListUri = Uri.parse("http://cloud.feedly.com/v3/subscriptions");
    StreamItemsUri = Uri.parse("http://cloud.feedly.com/v3/streams");
    StreamItemsSuffix = "contents";
    StarredTag = "/tag/global.saved";
    EditMarkerURL = URI.create("http://cloud.feedly.com/v3/markers");
    EditTagURL = Uri.parse("http://cloud.feedly.com/v3/tags");
    if (Configuration.HasCustomUserAgent()) {}
    for (String str = Configuration.DefaultUserAgent();; str = Configuration.MO_USER_AGENT)
    {
      LoginAgent = str;
      AuthRequestHeader = "Authorization";
      _FeedListDownloadListener = new DownloadAgent.DownloadListener()
      {
        public void OnDownloadCompleted(DownloadAgent paramAnonymousDownloadAgent, boolean paramAnonymousBoolean)
        {
          paramAnonymousDownloadAgent = Feedly.ParseFeedFile();
          if (paramAnonymousDownloadAgent != null)
          {
            Feedly._GetFeedsResult.Success(paramAnonymousDownloadAgent);
            return;
          }
          Feedly._GetFeedsResult.Failed(new Exception("Unable to load subscription list!"));
        }
        
        public void OnDownloadError(DownloadAgent paramAnonymousDownloadAgent, Exception paramAnonymousException)
        {
          Feedly._GetFeedsResult.Failed(paramAnonymousException);
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
            Feedly.this.Success();
            return;
          }
          localRequestBase = (RequestBase)paramAnonymousList.next();
        } while (localRequestBase.Status() != 2);
        Feedly.this.Failed(localRequestBase.LastException());
      }
      
      public void OnQueueProgress(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public void OnQueueStarted(int paramAnonymousInt) {}
    });
    paramGSimpleResult.QueueRequest(new GRequestEditSubscription(paramFeed.getFeedUrl(), paramFeed.getName(), 0));
    paramGSimpleResult.ExecuteQueuedRequests();
  }
  
  private static Uri AppendBeyondPodRefererParams(Uri paramUri, int paramInt)
  {
    paramUri = paramUri.buildUpon();
    if (paramInt > 0) {
      paramUri.appendQueryParameter("count", Integer.toString(paramInt));
    }
    paramUri.appendQueryParameter("ck", Long.toString(System.currentTimeMillis()));
    paramUri.appendQueryParameter("ct", Referer);
    return paramUri.build();
  }
  
  private static void BatchRequest(ArrayList<String> paramArrayList, int paramInt, String paramString)
    throws Exception
  {
    CoreHelper.WriteLogEntryInProduction(TAG, "Adding a batch of " + paramArrayList.size() + " items for tag: " + paramString);
    int i = 0;
    int k = Math.min(paramArrayList.size() - i, 50);
    int j = i;
    ArrayList localArrayList;
    if (k > 0)
    {
      localArrayList = new ArrayList(paramArrayList.subList(i, i + k));
      j = i + k;
      if ((!"keepUnread".equals(paramString)) && (!"markAsRead".equals(paramString))) {
        break label128;
      }
      _ReaderCaller.QueueRequest(new FRequestEditRead(localArrayList, paramString));
    }
    for (;;)
    {
      i = j;
      if (k > 0) {
        break;
      }
      return;
      label128:
      _ReaderCaller.QueueRequest(new FRequestEditTag(localArrayList, paramInt, paramString));
    }
  }
  
  /* Error */
  public static String BlockingGetAuthToken()
  {
    // Byte code:
    //   0: new 384	java/util/Date
    //   3: dup
    //   4: invokespecial 385	java/util/Date:<init>	()V
    //   7: astore_2
    //   8: invokestatic 389	mobi/beyondpod/rsscore/Configuration:OAuthAccessTokenExpiration	()Ljava/util/Date;
    //   11: astore_3
    //   12: invokestatic 392	mobi/beyondpod/rsscore/Configuration:OAuthAccessToken	()Ljava/lang/String;
    //   15: astore 4
    //   17: invokestatic 395	mobi/beyondpod/rsscore/Configuration:OAuthRefreshToken	()Ljava/lang/String;
    //   20: astore_1
    //   21: aload_3
    //   22: invokevirtual 398	java/util/Date:getTime	()J
    //   25: aload_2
    //   26: invokevirtual 398	java/util/Date:getTime	()J
    //   29: lsub
    //   30: ldc2_w 399
    //   33: lcmp
    //   34: ifge +20 -> 54
    //   37: iconst_1
    //   38: istore_0
    //   39: aload 4
    //   41: invokestatic 406	mobi/beyondpod/rsscore/helpers/StringUtils:IsNullOrEmpty	(Ljava/lang/String;)Z
    //   44: ifne +15 -> 59
    //   47: iload_0
    //   48: ifne +11 -> 59
    //   51: aload 4
    //   53: areturn
    //   54: iconst_0
    //   55: istore_0
    //   56: goto -17 -> 39
    //   59: iload_0
    //   60: ifeq +32 -> 92
    //   63: getstatic 118	mobi/beyondpod/aggregators/feedly/Feedly:TAG	Ljava/lang/String;
    //   66: new 322	java/lang/StringBuilder
    //   69: dup
    //   70: ldc_w 408
    //   73: invokespecial 327	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   76: aload_3
    //   77: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   80: ldc_w 413
    //   83: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 416	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_1
    //   93: invokestatic 406	mobi/beyondpod/rsscore/helpers/StringUtils:IsNullOrEmpty	(Ljava/lang/String;)Z
    //   96: ifeq +14 -> 110
    //   99: getstatic 118	mobi/beyondpod/aggregators/feedly/Feedly:TAG	Ljava/lang/String;
    //   102: ldc_w 418
    //   105: invokestatic 416	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aconst_null
    //   109: areturn
    //   110: invokestatic 234	mobi/beyondpod/rsscore/Configuration:DefaultUserAgent	()Ljava/lang/String;
    //   113: invokestatic 424	mobi/beyondpod/downloadengine/BeyondPodHttpClient:newInstance	(Ljava/lang/String;)Lmobi/beyondpod/downloadengine/BeyondPodHttpClient;
    //   116: astore_3
    //   117: aconst_null
    //   118: astore_2
    //   119: getstatic 118	mobi/beyondpod/aggregators/feedly/Feedly:TAG	Ljava/lang/String;
    //   122: ldc_w 426
    //   125: invokestatic 416	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: new 428	mobi/beyondpod/aggregators/feedly/FRequestRefreshToken
    //   131: dup
    //   132: aload_1
    //   133: invokespecial 429	mobi/beyondpod/aggregators/feedly/FRequestRefreshToken:<init>	(Ljava/lang/String;)V
    //   136: astore 4
    //   138: aload 4
    //   140: aload_3
    //   141: invokestatic 433	mobi/beyondpod/aggregators/AggregatorRequestQueue:ExecuteRequest	(Lmobi/beyondpod/aggregators/RequestBase;Lmobi/beyondpod/downloadengine/BeyondPodHttpClient;)Z
    //   144: pop
    //   145: aload 4
    //   147: invokevirtual 436	mobi/beyondpod/aggregators/feedly/FRequestRefreshToken:Status	()I
    //   150: iconst_1
    //   151: if_icmpne +29 -> 180
    //   154: invokestatic 392	mobi/beyondpod/rsscore/Configuration:OAuthAccessToken	()Ljava/lang/String;
    //   157: astore_1
    //   158: aload_1
    //   159: invokestatic 406	mobi/beyondpod/rsscore/helpers/StringUtils:IsNullOrEmpty	(Ljava/lang/String;)Z
    //   162: ifeq +76 -> 238
    //   165: getstatic 118	mobi/beyondpod/aggregators/feedly/Feedly:TAG	Ljava/lang/String;
    //   168: ldc_w 438
    //   171: invokestatic 416	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload_3
    //   175: invokevirtual 441	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   178: aload_1
    //   179: areturn
    //   180: getstatic 118	mobi/beyondpod/aggregators/feedly/Feedly:TAG	Ljava/lang/String;
    //   183: ldc_w 443
    //   186: invokestatic 416	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload_2
    //   190: astore_1
    //   191: aload 4
    //   193: invokevirtual 446	mobi/beyondpod/aggregators/feedly/FRequestRefreshToken:ShouldRetry	()Z
    //   196: ifeq -38 -> 158
    //   199: getstatic 118	mobi/beyondpod/aggregators/feedly/Feedly:TAG	Ljava/lang/String;
    //   202: ldc_w 448
    //   205: invokestatic 416	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: bipush 10
    //   210: invokestatic 452	mobi/beyondpod/rsscore/helpers/CoreHelper:nap	(I)V
    //   213: aload 4
    //   215: aload_3
    //   216: invokestatic 433	mobi/beyondpod/aggregators/AggregatorRequestQueue:ExecuteRequest	(Lmobi/beyondpod/aggregators/RequestBase;Lmobi/beyondpod/downloadengine/BeyondPodHttpClient;)Z
    //   219: pop
    //   220: aload_2
    //   221: astore_1
    //   222: aload 4
    //   224: invokevirtual 436	mobi/beyondpod/aggregators/feedly/FRequestRefreshToken:Status	()I
    //   227: iconst_1
    //   228: if_icmpne -70 -> 158
    //   231: invokestatic 392	mobi/beyondpod/rsscore/Configuration:OAuthAccessToken	()Ljava/lang/String;
    //   234: astore_1
    //   235: goto -77 -> 158
    //   238: getstatic 118	mobi/beyondpod/aggregators/feedly/Feedly:TAG	Ljava/lang/String;
    //   241: new 322	java/lang/StringBuilder
    //   244: dup
    //   245: ldc_w 454
    //   248: invokespecial 327	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   251: invokestatic 389	mobi/beyondpod/rsscore/Configuration:OAuthAccessTokenExpiration	()Ljava/util/Date;
    //   254: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 416	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: goto -89 -> 174
    //   266: astore_1
    //   267: getstatic 118	mobi/beyondpod/aggregators/feedly/Feedly:TAG	Ljava/lang/String;
    //   270: ldc_w 456
    //   273: aload_1
    //   274: invokestatic 460	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   277: aload_3
    //   278: invokevirtual 441	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   281: aconst_null
    //   282: areturn
    //   283: astore_1
    //   284: aload_3
    //   285: invokevirtual 441	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   288: aload_1
    //   289: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   38	22	0	i	int
    //   20	215	1	localObject1	Object
    //   266	8	1	localException	Exception
    //   283	6	1	localObject2	Object
    //   7	214	2	localDate	java.util.Date
    //   11	274	3	localObject3	Object
    //   15	208	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   119	158	266	java/lang/Exception
    //   158	174	266	java/lang/Exception
    //   180	189	266	java/lang/Exception
    //   191	220	266	java/lang/Exception
    //   222	235	266	java/lang/Exception
    //   238	263	266	java/lang/Exception
    //   119	158	283	finally
    //   158	174	283	finally
    //   180	189	283	finally
    //   191	220	283	finally
    //   222	235	283	finally
    //   238	263	283	finally
    //   267	277	283	finally
  }
  
  public static Feed BuildFeedList(GDataObject paramGDataObject)
  {
    HashMap localHashMap = new HashMap();
    Feed localFeed = new Feed(UUID.randomUUID(), null, GOOGLE_READER_FEEDS, null, 5);
    InsertCommonFeeds(localFeed, Configuration.OAuthUser());
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
        localObject2 = new Feed(UUID.randomUUID(), paramGDataObject, ALL_NEW_ITEMS_IN + " '" + (String)localObject2 + "'", StreamItemsUri.buildUpon().appendPath(((GDataObject)((GDataObject)localObject1).List.get(0)).ID).appendPath(StreamItemsSuffix).build().toString(), 5);
        paramGDataObject.SubFeeds().add(localObject2);
      }
    }
  }
  
  private static void CallFeedly(Uri paramUri, boolean paramBoolean, DownloadAgent.DownloadListener paramDownloadListener)
  {
    if (_ReceiveFile.exists()) {
      _ReceiveFile.delete();
    }
    paramUri = new DownloadAgent(paramUri, _ReceiveFile, null);
    paramUri.SetAllowRedirects(paramBoolean);
    paramUri.SetMustRequestReaderToken(true);
    paramUri.SetUserAgent(LoginAgent);
    paramUri.setDownloadListenter(paramDownloadListener);
    try
    {
      paramUri.StartDownload();
      return;
    }
    catch (Exception paramUri)
    {
      while (paramDownloadListener == null) {}
      paramDownloadListener.OnDownloadError(null, paramUri);
    }
  }
  
  public static void GetFeedList(FGetFeedsResult paramFGetFeedsResult)
  {
    _GetFeedsResult = paramFGetFeedsResult;
    CallFeedly(AppendBeyondPodRefererParams(SubscriptionListUri, -1), true, _FeedListDownloadListener);
  }
  
  public static Uri GetFeedUri(Feed paramFeed)
  {
    if (!paramFeed.IsGReaderFeed()) {
      return paramFeed.getFeedUri();
    }
    if (IsCategoryAggregatorFeed(paramFeed)) {}
    for (Uri localUri = paramFeed.getFeedUri();; localUri = StreamItemsUri.buildUpon().appendPath("feed/" + paramFeed.getFeedUrl()).appendPath(StreamItemsSuffix).build()) {
      return AppendBeyondPodRefererParams(localUri, paramFeed.getMaxNumGReaderItemsToGet());
    }
  }
  
  public static boolean HasCachedAuthTokens()
  {
    return ((!StringUtils.IsNullOrEmpty(Configuration.GReaderCookie())) && (Configuration.GReaderCookie().startsWith("SID"))) || (!StringUtils.IsNullOrEmpty(Configuration.GReaderAuthValue()));
  }
  
  private static void InsertCommonFeeds(Feed paramFeed, String paramString)
  {
    Feed localFeed1 = new Feed(UUID.randomUUID(), paramFeed, MY_GOOGLE_ITEMS, null, 5);
    paramFeed.SubFeeds().add(localFeed1);
    paramFeed = new Feed(UUID.randomUUID(), localFeed1, MY_READING_LIST, StreamItemsUri.buildUpon().appendPath(String.format("user/%s/category/global.all", new Object[] { paramString })).appendPath(StreamItemsSuffix).build().toString(), 5);
    Feed localFeed2 = new Feed(UUID.randomUUID(), localFeed1, MY_STARRED_ITEMS, StreamItemsUri.buildUpon().appendPath(String.format("user/%s/tag/global.saved", new Object[] { paramString })).appendPath(StreamItemsSuffix).build().toString(), 5);
    paramString = new Feed(UUID.randomUUID(), localFeed1, MY_READ_ITEMS, StreamItemsUri.buildUpon().appendPath(String.format("user/%s/tag/global.read", new Object[] { paramString })).appendPath(StreamItemsSuffix).build().toString(), 5);
    localFeed1.SubFeeds().add(paramFeed);
    localFeed1.SubFeeds().add(localFeed2);
    localFeed1.SubFeeds().add(paramString);
  }
  
  public static boolean IsCategoryAggregatorFeed(Feed paramFeed)
  {
    if ((paramFeed == null) || (!paramFeed.HasUri())) {
      return false;
    }
    try
    {
      boolean bool = paramFeed.getFeedUri().getHost().toLowerCase().startsWith(StreamItemsUri.getHost().toLowerCase());
      return bool;
    }
    catch (Exception localException)
    {
      CoreHelper.WriteTraceEntry(TAG, paramFeed.getName());
    }
    return false;
  }
  
  public static boolean IsSyncing()
  {
    return (_ReaderCaller != null) && (_ReaderCaller.IsWorking());
  }
  
  public static void LogIn(final String paramString, AggregatorLoginHelper.GSimpleResult paramGSimpleResult)
    throws Exception
  {
    try
    {
      paramString = new FRequestGetToken(paramString);
      paramGSimpleResult = new AggregatorRequestQueue(new AggregatorRequestQueue.QueueListener()
      {
        public void OnQueueCompleted(boolean paramAnonymousBoolean, List<RequestBase> paramAnonymousList)
        {
          if (Feedly.this != null)
          {
            if (paramString.Status() == 1) {
              Feedly.this.Success();
            }
          }
          else {
            return;
          }
          Feedly.this.Failed(paramString.LastException());
        }
        
        public void OnQueueProgress(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public void OnQueueStarted(int paramAnonymousInt) {}
      });
      paramGSimpleResult.QueueRequest(paramString);
      paramGSimpleResult.ExecuteQueuedRequests();
      return;
    }
    catch (Exception paramString)
    {
      while (paramGSimpleResult == null) {}
      paramGSimpleResult.Failed(paramString);
    }
  }
  
  /* Error */
  public static GDataObject ParseFeedFile()
  {
    // Byte code:
    //   0: getstatic 118	mobi/beyondpod/aggregators/feedly/Feedly:TAG	Ljava/lang/String;
    //   3: ldc_w 663
    //   6: invokestatic 416	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: getstatic 133	mobi/beyondpod/aggregators/feedly/Feedly:_ReceiveFile	Ljava/io/File;
    //   12: astore 4
    //   14: aload 4
    //   16: monitorenter
    //   17: getstatic 133	mobi/beyondpod/aggregators/feedly/Feedly:_ReceiveFile	Ljava/io/File;
    //   20: invokevirtual 558	java/io/File:exists	()Z
    //   23: istore_0
    //   24: iload_0
    //   25: ifeq +135 -> 160
    //   28: aconst_null
    //   29: astore_1
    //   30: aconst_null
    //   31: astore_3
    //   32: new 665	com/google/gson/stream/JsonReader
    //   35: dup
    //   36: new 667	java/io/FileReader
    //   39: dup
    //   40: getstatic 133	mobi/beyondpod/aggregators/feedly/Feedly:_ReceiveFile	Ljava/io/File;
    //   43: invokespecial 670	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   46: invokespecial 673	com/google/gson/stream/JsonReader:<init>	(Ljava/io/Reader;)V
    //   49: astore_2
    //   50: aload_2
    //   51: invokestatic 679	mobi/beyondpod/aggregators/feedly/FeedlySubscriptionsParser:ParseSubscriptions	(Lcom/google/gson/stream/JsonReader;)Lmobi/beyondpod/aggregators/GDataObject;
    //   54: astore_1
    //   55: aload_2
    //   56: ifnull +7 -> 63
    //   59: aload_2
    //   60: invokevirtual 680	com/google/gson/stream/JsonReader:close	()V
    //   63: getstatic 118	mobi/beyondpod/aggregators/feedly/Feedly:TAG	Ljava/lang/String;
    //   66: ldc_w 682
    //   69: invokestatic 416	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload 4
    //   74: monitorexit
    //   75: aload_1
    //   76: areturn
    //   77: astore_1
    //   78: aload 4
    //   80: monitorexit
    //   81: aconst_null
    //   82: areturn
    //   83: astore_1
    //   84: aload_3
    //   85: astore_2
    //   86: aload_1
    //   87: astore_3
    //   88: aload_2
    //   89: astore_1
    //   90: getstatic 118	mobi/beyondpod/aggregators/feedly/Feedly:TAG	Ljava/lang/String;
    //   93: ldc_w 684
    //   96: aload_3
    //   97: invokestatic 460	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 680	com/google/gson/stream/JsonReader:close	()V
    //   108: getstatic 118	mobi/beyondpod/aggregators/feedly/Feedly:TAG	Ljava/lang/String;
    //   111: ldc_w 682
    //   114: invokestatic 416	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload 4
    //   119: monitorexit
    //   120: aconst_null
    //   121: areturn
    //   122: astore_1
    //   123: aload 4
    //   125: monitorexit
    //   126: aconst_null
    //   127: areturn
    //   128: astore_2
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 680	com/google/gson/stream/JsonReader:close	()V
    //   137: getstatic 118	mobi/beyondpod/aggregators/feedly/Feedly:TAG	Ljava/lang/String;
    //   140: ldc_w 682
    //   143: invokestatic 416	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_2
    //   147: athrow
    //   148: astore_1
    //   149: aload 4
    //   151: monitorexit
    //   152: aload_1
    //   153: athrow
    //   154: astore_1
    //   155: aload 4
    //   157: monitorexit
    //   158: aconst_null
    //   159: areturn
    //   160: aload 4
    //   162: monitorexit
    //   163: aconst_null
    //   164: areturn
    //   165: astore_3
    //   166: aload_2
    //   167: astore_1
    //   168: aload_3
    //   169: astore_2
    //   170: goto -41 -> 129
    //   173: astore_3
    //   174: goto -86 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   23	2	0	bool	boolean
    //   29	47	1	localGDataObject	GDataObject
    //   77	1	1	localException1	Exception
    //   83	4	1	localException2	Exception
    //   89	1	1	localObject1	Object
    //   122	12	1	localException3	Exception
    //   148	5	1	localObject2	Object
    //   154	1	1	localException4	Exception
    //   167	1	1	localObject3	Object
    //   49	56	2	localObject4	Object
    //   128	39	2	localObject5	Object
    //   169	1	2	localObject6	Object
    //   31	66	3	localException5	Exception
    //   165	4	3	localObject7	Object
    //   173	1	3	localException6	Exception
    //   12	149	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   59	63	77	java/lang/Exception
    //   32	50	83	java/lang/Exception
    //   104	108	122	java/lang/Exception
    //   32	50	128	finally
    //   90	100	128	finally
    //   17	24	148	finally
    //   59	63	148	finally
    //   63	75	148	finally
    //   78	81	148	finally
    //   104	108	148	finally
    //   108	120	148	finally
    //   123	126	148	finally
    //   133	137	148	finally
    //   137	148	148	finally
    //   149	152	148	finally
    //   155	158	148	finally
    //   160	163	148	finally
    //   133	137	154	java/lang/Exception
    //   50	55	165	finally
    //   50	55	173	java/lang/Exception
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
  
  public static int SwitchAggregateFeedsToFeedlyForUser(String paramString)
  {
    int i = 0;
    CoreHelper.WriteTraceEntry(TAG, "Upgrading user aggregated feeds to Feedly...");
    Iterator localIterator = AggregatorLoginHelper.getAllAggregatorFeeds().iterator();
    if (!localIterator.hasNext())
    {
      ItemStateHistory.PurgeAllGoogleReaderItems();
      ItemStateHistory.SaveHistorySync();
      FeedRepository.SaveRepositoryAsync();
      CoreHelper.WriteTraceEntry(TAG, "Upgraded " + i + " feeds");
      return i;
    }
    Feed localFeed = (Feed)localIterator.next();
    RssFeedCache.DeleteFeedCacheFor(localFeed);
    localFeed.setItemFingerprintAlgorithm(-1);
    localFeed.setNumUnreadItems(0);
    localFeed.setLastModifiedDate(null);
    localFeed.setLastServerModifiedDate(null);
    localFeed.setLastItemID(null);
    String str1;
    if (GoogleReader.IsCategoryAggregatorFeed(localFeed))
    {
      str1 = null;
      if (!GoogleReader.StarredUri.toString().equals(localFeed.getFeedUrl())) {
        break label251;
      }
      str1 = "tag/global.saved";
    }
    for (;;)
    {
      String str2 = str1;
      if (str1 == null)
      {
        int j = localFeed.getFeedUrl().indexOf("/label/");
        str2 = "category/" + URLDecoder.decode(localFeed.getFeedUrl().substring(j + 7));
      }
      localFeed.setFeedUrl(StreamItemsUri.buildUpon().appendPath(String.format("user/%s/%s", new Object[] { paramString, str2 })).appendPath(StreamItemsSuffix).build().toString());
      i += 1;
      break;
      label251:
      if (GoogleReader.ReadingUri.toString().equals(localFeed.getFeedUrl())) {
        str1 = "category/global.all";
      } else if (GoogleReader.ReadItemsUri.toString().equals(localFeed.getFeedUrl())) {
        str1 = "tag/global.read";
      }
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
        int j = 0;
        int i = 0;
        int m = 0;
        int k = 0;
        int n = 0;
        Object localObject1 = paramAnonymousList.iterator();
        Object localObject2;
        Object localObject3;
        if (!((Iterator)localObject1).hasNext())
        {
          localObject2 = Feedly.TAG;
          localObject3 = new StringBuilder("--- Google Reader Sync ");
          if (!paramAnonymousBoolean) {
            break label472;
          }
        }
        label472:
        for (localObject1 = "Cancelled";; localObject1 = "Complete")
        {
          CoreHelper.WriteLogEntryInProduction((String)localObject2, (String)localObject1 + "!. (" + paramAnonymousList.size() + " total, " + n + " succeded " + m + " failed, " + k + " pending). Synced: " + i + " Read and " + j + " Starred items.");
          if ((i > 0) || (j > 0)) {
            ItemStateHistory.MarkModified();
          }
          ItemStateHistory.SaveHistoryAsync();
          BeyondPodApplication.GetInstance().ClearReaderSyncNotification();
          Feedly._ReaderCaller = null;
          if (paramGSyncStatusResult != null) {
            paramGSyncStatusResult.SyncCompleted(paramAnonymousBoolean, i + j, paramAnonymousList.size());
          }
          return;
          localObject2 = (RequestBase)((Iterator)localObject1).next();
          if (((RequestBase)localObject2).Status() == 1)
          {
            int i3 = n + 1;
            int i1 = i;
            Object localObject4;
            if ((localObject2 instanceof FRequestEditRead))
            {
              localObject3 = (FRequestEditRead)localObject2;
              localObject4 = ((FRequestEditRead)localObject3).ItemIDs.iterator();
            }
            for (;;)
            {
              if (!((Iterator)localObject4).hasNext())
              {
                i1 = i;
                n = i3;
                i = i1;
                if (!(localObject2 instanceof FRequestEditTag)) {
                  break;
                }
                localObject2 = (FRequestEditTag)localObject2;
                localObject3 = ((FRequestEditTag)localObject2).ItemIDs.iterator();
                int i2 = j;
                for (;;)
                {
                  n = i3;
                  i = i1;
                  j = i2;
                  if (!((Iterator)localObject3).hasNext()) {
                    break;
                  }
                  localObject4 = (String)((Iterator)localObject3).next();
                  localObject4 = (ItemStateHistory.ItemStatus)Feedly.this.get(localObject4);
                  if ((localObject4 != null) && (((FRequestEditTag)localObject2).Tag.equals(Feedly.StarredTag)))
                  {
                    i2 += 1;
                    ((ItemStateHistory.ItemStatus)localObject4).SetStarSynced();
                  }
                }
              }
              Object localObject5 = (String)((Iterator)localObject4).next();
              localObject5 = (ItemStateHistory.ItemStatus)Feedly.this.get(localObject5);
              if ((localObject5 != null) && ((((FRequestEditRead)localObject3).Tag.equals("markAsRead")) || (((FRequestEditRead)localObject3).Tag.equals("keepUnread"))))
              {
                i += 1;
                ((ItemStateHistory.ItemStatus)localObject5).SetReadSynced();
              }
            }
          }
          if (((RequestBase)localObject2).Status() == 2)
          {
            m += 1;
            break;
          }
          k += 1;
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
        BeyondPodApplication.GetInstance().SetReaderSyncNotification(Feedly.UPDATING_GOOGLE_READER, i + " " + Feedly.PERCENT_COMPLETE);
      }
      
      public void OnQueueStarted(int paramAnonymousInt)
      {
        BeyondPodApplication.GetInstance().SetReaderSyncNotification(Feedly.UPDATING_GOOGLE_READER, "");
      }
    });
    paramGSyncStatusResult = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    SplitUnsinchronizedToBuckets(localHashMap, paramGSyncStatusResult, localArrayList1, localArrayList2, localArrayList3);
    if (paramGSyncStatusResult.size() > 0) {
      BatchRequest(paramGSyncStatusResult, -1, "markAsRead");
    }
    if (localArrayList1.size() > 0) {
      BatchRequest(localArrayList1, -1, "keepUnread");
    }
    if (localArrayList2.size() > 0) {
      BatchRequest(localArrayList2, 0, StarredTag);
    }
    if (localArrayList3.size() > 0) {
      BatchRequest(localArrayList3, 1, StarredTag);
    }
    _ReaderCaller.ExecuteQueuedRequests();
    return true;
  }
  
  static String UserStream()
  {
    return String.format("user/%s", new Object[] { Configuration.OAuthUser() });
  }
  
  public static abstract interface FGetFeedsResult
  {
    public abstract void Failed(Exception paramException);
    
    public abstract void Success(GDataObject paramGDataObject);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/aggregators/feedly/Feedly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */