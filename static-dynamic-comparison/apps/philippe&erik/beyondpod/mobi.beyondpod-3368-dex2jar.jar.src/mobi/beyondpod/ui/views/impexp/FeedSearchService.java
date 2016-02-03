package mobi.beyondpod.ui.views.impexp;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.RequestQueue.RequestFilter;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonArrayRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mobi.beyondpod.BeyondPodApplication;
import org.json.JSONArray;
import org.json.JSONObject;

public class FeedSearchService
{
  private static final int CLIENT_VERSION = 1;
  private RequestFilter _requestFilter = new RequestFilter();
  private RequestQueue mRequestQueue = null;
  private String rootUrl;
  
  public FeedSearchService(String paramString, RequestQueue paramRequestQueue)
  {
    this.rootUrl = paramString;
    if (!this.rootUrl.endsWith("/")) {
      this.rootUrl += "/";
    }
    this.mRequestQueue = paramRequestQueue;
  }
  
  private Map<String, String> buildParams(String... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    int j;
    int i;
    if (paramVarArgs != null)
    {
      j = paramVarArgs.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        return localHashMap;
      }
      if ((paramVarArgs[i].equals("start")) && (paramVarArgs[(i + 1)].equals("0"))) {
        this.mRequestQueue.cancelAll(this._requestFilter);
      }
      localHashMap.put(paramVarArgs[i], paramVarArgs[(i + 1)]);
      i += 2;
    }
  }
  
  private String getSoftwareVersion()
  {
    try
    {
      Object localObject = BeyondPodApplication.GetInstance();
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0).versionName;
      return (String)localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  /* Error */
  private void performGet(String paramString, Map<String, String> paramMap, Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener)
    throws FeedSearchService.ServiceException
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +102 -> 103
    //   4: aload_1
    //   5: ldc -127
    //   7: invokevirtual 132	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   10: ifeq +93 -> 103
    //   13: new 45	java/lang/StringBuilder
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_2
    //   23: ifnull +54 -> 77
    //   26: aload_2
    //   27: invokeinterface 136 1 0
    //   32: ifle +45 -> 77
    //   35: aload_1
    //   36: ldc -118
    //   38: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: invokeinterface 142 1 0
    //   48: invokeinterface 148 1 0
    //   53: astore_2
    //   54: aload_2
    //   55: invokeinterface 154 1 0
    //   60: istore 5
    //   62: iload 5
    //   64: ifne +64 -> 128
    //   67: aload_1
    //   68: aload_1
    //   69: invokevirtual 157	java/lang/StringBuilder:length	()I
    //   72: iconst_1
    //   73: isub
    //   74: invokevirtual 161	java/lang/StringBuilder:setLength	(I)V
    //   77: new 6	mobi/beyondpod/ui/views/impexp/FeedSearchService$1
    //   80: dup
    //   81: aload_0
    //   82: aload_1
    //   83: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: aload_3
    //   87: aload 4
    //   89: invokespecial 164	mobi/beyondpod/ui/views/impexp/FeedSearchService$1:<init>	(Lmobi/beyondpod/ui/views/impexp/FeedSearchService;Ljava/lang/String;Lcom/android/volley/Response$Listener;Lcom/android/volley/Response$ErrorListener;)V
    //   92: astore_1
    //   93: aload_0
    //   94: getfield 28	mobi/beyondpod/ui/views/impexp/FeedSearchService:mRequestQueue	Lcom/android/volley/RequestQueue;
    //   97: aload_1
    //   98: invokevirtual 168	com/android/volley/RequestQueue:add	(Lcom/android/volley/Request;)Lcom/android/volley/Request;
    //   101: pop
    //   102: return
    //   103: new 45	java/lang/StringBuilder
    //   106: dup
    //   107: aload_0
    //   108: getfield 35	mobi/beyondpod/ui/views/impexp/FeedSearchService:rootUrl	Ljava/lang/String;
    //   111: invokestatic 49	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   114: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload_1
    //   118: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: astore_1
    //   125: goto -112 -> 13
    //   128: aload_2
    //   129: invokeinterface 172 1 0
    //   134: checkcast 174	java/util/Map$Entry
    //   137: astore 6
    //   139: aload_1
    //   140: aload 6
    //   142: invokeinterface 177 1 0
    //   147: checkcast 39	java/lang/String
    //   150: ldc -77
    //   152: invokestatic 185	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   155: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_1
    //   160: ldc -69
    //   162: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload_1
    //   167: aload 6
    //   169: invokeinterface 190 1 0
    //   174: checkcast 39	java/lang/String
    //   177: ldc -77
    //   179: invokestatic 185	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   182: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload_1
    //   187: ldc -64
    //   189: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: goto -139 -> 54
    //   196: astore_1
    //   197: new 11	mobi/beyondpod/ui/views/impexp/FeedSearchService$ServiceException
    //   200: dup
    //   201: bipush 100
    //   203: ldc -62
    //   205: aload_1
    //   206: invokespecial 197	mobi/beyondpod/ui/views/impexp/FeedSearchService$ServiceException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   209: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	FeedSearchService
    //   0	210	1	paramString	String
    //   0	210	2	paramMap	Map<String, String>
    //   0	210	3	paramListener	Response.Listener<JSONArray>
    //   0	210	4	paramErrorListener	Response.ErrorListener
    //   60	3	5	bool	boolean
    //   137	31	6	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   42	54	196	java/io/UnsupportedEncodingException
    //   54	62	196	java/io/UnsupportedEncodingException
    //   128	193	196	java/io/UnsupportedEncodingException
  }
  
  /* Error */
  private String performPost(String paramString, Map<String, String> paramMap)
    throws FeedSearchService.ServiceException
  {
    // Byte code:
    //   0: invokestatic 212	mobi/beyondpod/rsscore/Configuration:DefaultUserAgent	()Ljava/lang/String;
    //   3: invokestatic 218	mobi/beyondpod/downloadengine/BeyondPodHttpClient:newInstance	(Ljava/lang/String;)Lmobi/beyondpod/downloadengine/BeyondPodHttpClient;
    //   6: astore_3
    //   7: new 45	java/lang/StringBuilder
    //   10: dup
    //   11: aload_0
    //   12: getfield 35	mobi/beyondpod/ui/views/impexp/FeedSearchService:rootUrl	Ljava/lang/String;
    //   15: invokestatic 49	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   18: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: aload_1
    //   22: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore_1
    //   29: new 220	org/apache/http/client/methods/HttpPost
    //   32: dup
    //   33: new 222	java/net/URI
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 223	java/net/URI:<init>	(Ljava/lang/String;)V
    //   41: invokespecial 226	org/apache/http/client/methods/HttpPost:<init>	(Ljava/net/URI;)V
    //   44: astore 4
    //   46: aload 4
    //   48: ldc -28
    //   50: ldc -26
    //   52: invokevirtual 234	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload 4
    //   57: ldc -20
    //   59: iconst_1
    //   60: invokestatic 239	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   63: invokevirtual 234	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload 4
    //   68: ldc -15
    //   70: aload_0
    //   71: invokespecial 66	mobi/beyondpod/ui/views/impexp/FeedSearchService:getSoftwareVersion	()Ljava/lang/String;
    //   74: invokevirtual 234	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload_2
    //   78: ifnull +62 -> 140
    //   81: aload_2
    //   82: invokeinterface 136 1 0
    //   87: ifle +53 -> 140
    //   90: new 243	java/util/ArrayList
    //   93: dup
    //   94: aload_2
    //   95: invokeinterface 136 1 0
    //   100: invokespecial 245	java/util/ArrayList:<init>	(I)V
    //   103: astore 5
    //   105: aload_2
    //   106: invokeinterface 142 1 0
    //   111: invokeinterface 148 1 0
    //   116: astore_2
    //   117: aload_2
    //   118: invokeinterface 154 1 0
    //   123: ifne +38 -> 161
    //   126: aload 4
    //   128: new 247	org/apache/http/client/entity/UrlEncodedFormEntity
    //   131: dup
    //   132: aload 5
    //   134: invokespecial 250	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;)V
    //   137: invokevirtual 254	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   140: aload_3
    //   141: aload 4
    //   143: invokevirtual 258	mobi/beyondpod/downloadengine/BeyondPodHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   146: invokeinterface 264 1 0
    //   151: invokestatic 269	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   154: astore_2
    //   155: aload_3
    //   156: invokevirtual 272	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   159: aload_2
    //   160: areturn
    //   161: aload_2
    //   162: invokeinterface 172 1 0
    //   167: checkcast 174	java/util/Map$Entry
    //   170: astore 6
    //   172: aload 5
    //   174: new 274	org/apache/http/message/BasicNameValuePair
    //   177: dup
    //   178: aload 6
    //   180: invokeinterface 177 1 0
    //   185: checkcast 39	java/lang/String
    //   188: aload 6
    //   190: invokeinterface 190 1 0
    //   195: checkcast 39	java/lang/String
    //   198: invokespecial 276	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: invokeinterface 280 2 0
    //   206: pop
    //   207: goto -90 -> 117
    //   210: astore_2
    //   211: new 11	mobi/beyondpod/ui/views/impexp/FeedSearchService$ServiceException
    //   214: dup
    //   215: bipush 100
    //   217: new 45	java/lang/StringBuilder
    //   220: dup
    //   221: ldc_w 282
    //   224: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   227: aload_1
    //   228: invokevirtual 283	java/lang/String:toString	()Ljava/lang/String;
    //   231: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: aload_2
    //   238: invokespecial 197	mobi/beyondpod/ui/views/impexp/FeedSearchService$ServiceException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   241: athrow
    //   242: astore_1
    //   243: aload_3
    //   244: invokevirtual 272	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   247: aload_1
    //   248: athrow
    //   249: astore_2
    //   250: new 11	mobi/beyondpod/ui/views/impexp/FeedSearchService$ServiceException
    //   253: dup
    //   254: bipush 100
    //   256: new 45	java/lang/StringBuilder
    //   259: dup
    //   260: ldc_w 285
    //   263: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   266: aload_1
    //   267: invokevirtual 283	java/lang/String:toString	()Ljava/lang/String;
    //   270: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: aload_2
    //   277: invokespecial 197	mobi/beyondpod/ui/views/impexp/FeedSearchService$ServiceException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   280: athrow
    //   281: astore_2
    //   282: new 11	mobi/beyondpod/ui/views/impexp/FeedSearchService$ServiceException
    //   285: dup
    //   286: bipush 100
    //   288: new 45	java/lang/StringBuilder
    //   291: dup
    //   292: ldc_w 287
    //   295: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   298: aload_1
    //   299: invokevirtual 283	java/lang/String:toString	()Ljava/lang/String;
    //   302: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: aload_2
    //   309: invokespecial 197	mobi/beyondpod/ui/views/impexp/FeedSearchService$ServiceException:<init>	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   312: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	FeedSearchService
    //   0	313	1	paramString	String
    //   0	313	2	paramMap	Map<String, String>
    //   6	238	3	localBeyondPodHttpClient	mobi.beyondpod.downloadengine.BeyondPodHttpClient
    //   44	98	4	localHttpPost	org.apache.http.client.methods.HttpPost
    //   103	70	5	localArrayList	ArrayList
    //   170	19	6	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   29	77	210	java/net/URISyntaxException
    //   81	117	210	java/net/URISyntaxException
    //   117	140	210	java/net/URISyntaxException
    //   140	155	210	java/net/URISyntaxException
    //   161	207	210	java/net/URISyntaxException
    //   29	77	242	finally
    //   81	117	242	finally
    //   117	140	242	finally
    //   140	155	242	finally
    //   161	207	242	finally
    //   211	242	242	finally
    //   250	281	242	finally
    //   282	313	242	finally
    //   29	77	249	org/apache/http/client/ClientProtocolException
    //   81	117	249	org/apache/http/client/ClientProtocolException
    //   117	140	249	org/apache/http/client/ClientProtocolException
    //   140	155	249	org/apache/http/client/ClientProtocolException
    //   161	207	249	org/apache/http/client/ClientProtocolException
    //   29	77	281	java/io/IOException
    //   81	117	281	java/io/IOException
    //   117	140	281	java/io/IOException
    //   140	155	281	java/io/IOException
    //   161	207	281	java/io/IOException
  }
  
  private void queryGetFeeds(String paramString, Map<String, String> paramMap, boolean paramBoolean, Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener)
    throws FeedSearchService.ServiceException
  {
    if (paramBoolean) {}
    try
    {
      performPost(paramString, paramMap);
      return;
    }
    catch (Exception paramString)
    {
      throw new ServiceException(-100, "Service Error", paramString);
    }
    performGet(paramString, paramMap, paramListener, paramErrorListener);
  }
  
  private void queryGetStrings(String paramString, Map<String, String> paramMap, Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener)
    throws FeedSearchService.ServiceException
  {
    try
    {
      performGet(paramString, paramMap, paramListener, paramErrorListener);
      return;
    }
    catch (Exception paramString)
    {
      throw new ServiceException(-100, "Service Error", paramString);
    }
  }
  
  public void findByAudioBookCategory(String paramString1, String paramString2, int paramInt1, int paramInt2, Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener)
    throws FeedSearchService.ServiceException
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "*";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "*";
    }
    queryGetFeeds("audiobookcategories", buildParams(new String[] { "genre", str, "language", paramString1, "start", String.valueOf(paramInt1 * paramInt2), "take", String.valueOf(paramInt2) }), false, paramListener, paramErrorListener);
  }
  
  public void findByAudioBookQuery(String paramString, int paramInt1, int paramInt2, Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener)
    throws FeedSearchService.ServiceException
  {
    queryGetFeeds("audiobooksearch", buildParams(new String[] { "query", paramString, "start", String.valueOf(paramInt1 * paramInt2), "take", String.valueOf(paramInt2) }), false, paramListener, paramErrorListener);
  }
  
  public void findByPopularCategory(String paramString1, String paramString2, int paramInt1, int paramInt2, Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener)
    throws FeedSearchService.ServiceException
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "*";
    }
    queryGetFeeds("feedcategories", buildParams(new String[] { "category", str, "type", paramString2, "start", String.valueOf(paramInt1 * paramInt2), "take", String.valueOf(paramInt2) }), false, paramListener, paramErrorListener);
  }
  
  public void findByQuery(String paramString1, String paramString2, int paramInt1, int paramInt2, Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener)
    throws FeedSearchService.ServiceException
  {
    queryGetFeeds("feedsearch", buildParams(new String[] { "query", paramString1, "type", paramString2, "start", String.valueOf(paramInt1 * paramInt2), "take", String.valueOf(paramInt2) }), false, paramListener, paramErrorListener);
  }
  
  public void getAudioBookGenres(Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener)
    throws FeedSearchService.ServiceException
  {
    queryGetStrings("audiobookmeta", buildParams(new String[] { "type", "genres" }), paramListener, paramErrorListener);
  }
  
  public void getAudioBookLanguages(Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener)
    throws FeedSearchService.ServiceException
  {
    queryGetStrings("audiobookmeta", buildParams(new String[] { "type", "languages" }), paramListener, paramErrorListener);
  }
  
  public void getPopularCategories(Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener)
    throws FeedSearchService.ServiceException
  {
    queryGetStrings("feedcategoriesmeta", buildParams(new String[] { "type", "feed" }), paramListener, paramErrorListener);
  }
  
  public void getPublisherFeeds(String paramString1, String paramString2, int paramInt1, int paramInt2, Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener)
    throws FeedSearchService.ServiceException
  {
    queryGetFeeds("publisherFeeds", buildParams(new String[] { "pid", paramString1, "type", paramString2, "start", String.valueOf(paramInt1 * paramInt2), "take", String.valueOf(paramInt2) }), false, paramListener, paramErrorListener);
  }
  
  public void getPublishers(int paramInt1, int paramInt2, int paramInt3, Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener)
    throws FeedSearchService.ServiceException
  {
    queryGetFeeds("feedPublishers", buildParams(new String[] { "type", String.valueOf(paramInt1), "start", String.valueOf(paramInt2 * paramInt3), "take", String.valueOf(paramInt3) }), false, paramListener, paramErrorListener);
  }
  
  public void getRecommendedFeeds(String paramString1, String paramString2, int paramInt1, int paramInt2, Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener)
    throws FeedSearchService.ServiceException
  {
    queryGetFeeds("recommendedFeeds", buildParams(new String[] { "userfeeds", paramString1, "type", paramString2, "start", String.valueOf(paramInt1 * paramInt2), "take", String.valueOf(paramInt2) }), false, paramListener, paramErrorListener);
  }
  
  public void getTrendingEpisodes(String paramString1, String paramString2, int paramInt1, int paramInt2, Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener)
    throws FeedSearchService.ServiceException
  {
    queryGetFeeds("trendingEpisodes", buildParams(new String[] { "userfeeds", paramString1, "type", paramString2, "start", String.valueOf(paramInt1 * paramInt2), "take", String.valueOf(paramInt2) }), false, paramListener, paramErrorListener);
  }
  
  public List<FeedSearchResult> parseJSONResults(JSONArray paramJSONArray)
    throws FeedSearchService.ServiceException
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      if (paramJSONArray.length() == 0) {
        return localArrayList;
      }
      if (paramJSONArray != null)
      {
        int j = paramJSONArray.length();
        int i = 0;
        if (i < j)
        {
          Object localObject = paramJSONArray.getJSONObject(i);
          String str1;
          label56:
          String str2;
          label70:
          String str3;
          label84:
          String str4;
          label98:
          String str5;
          label112:
          String str6;
          label126:
          String str7;
          label140:
          String str8;
          if (((JSONObject)localObject).isNull("Title"))
          {
            str1 = null;
            if (!((JSONObject)localObject).isNull("Description")) {
              break label221;
            }
            str2 = null;
            if (!((JSONObject)localObject).isNull("Link")) {
              break label234;
            }
            str3 = null;
            if (!((JSONObject)localObject).isNull("ImageUrl")) {
              break label247;
            }
            str4 = null;
            if (!((JSONObject)localObject).isNull("Type")) {
              break label260;
            }
            str5 = null;
            if (!((JSONObject)localObject).isNull("OriginatingFeed")) {
              break label273;
            }
            str6 = null;
            if (!((JSONObject)localObject).isNull("EpisodeUrl")) {
              break label286;
            }
            str7 = null;
            if (!((JSONObject)localObject).isNull("Language")) {
              break label299;
            }
            str8 = null;
            label154:
            if (!((JSONObject)localObject).isNull("TotalTime")) {
              break label312;
            }
          }
          label221:
          label234:
          label247:
          label260:
          label273:
          label286:
          label299:
          label312:
          for (localObject = null;; localObject = ((JSONObject)localObject).getString("TotalTime"))
          {
            localArrayList.add(new FeedSearchResult(str1, str2, str3, str4, str5, str6, str7, str8, (String)localObject));
            i += 1;
            break;
            str1 = ((JSONObject)localObject).getString("Title");
            break label56;
            str2 = ((JSONObject)localObject).getString("Description");
            break label70;
            str3 = ((JSONObject)localObject).getString("Link");
            break label84;
            str4 = ((JSONObject)localObject).getString("ImageUrl");
            break label98;
            str5 = ((JSONObject)localObject).getString("Type");
            break label112;
            str6 = ((JSONObject)localObject).getString("OriginatingFeed");
            break label126;
            str7 = ((JSONObject)localObject).getString("EpisodeUrl");
            break label140;
            str8 = ((JSONObject)localObject).getString("Language");
            break label154;
          }
        }
      }
      return localArrayList;
    }
    catch (Exception paramJSONArray)
    {
      throw new ServiceException(-100, "Service Error", paramJSONArray);
    }
  }
  
  class RequestFilter
    implements RequestQueue.RequestFilter
  {
    RequestFilter() {}
    
    public boolean apply(Request<?> paramRequest)
    {
      return true;
    }
  }
  
  public static class ServiceException
    extends Exception
  {
    private static final long serialVersionUID = 1L;
    private int statusCode;
    
    public ServiceException(int paramInt, String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
    
    public int getStatusCode()
    {
      return this.statusCode;
    }
    
    public void setStatusCode(int paramInt)
    {
      this.statusCode = paramInt;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/impexp/FeedSearchService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */