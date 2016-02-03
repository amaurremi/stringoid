package mobi.beyondpod.rsscore;

import java.net.URI;
import java.net.URLEncoder;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public class FeedURLPatcher
{
  private static final String TAG = FeedURLPatcher.class.getSimpleName();
  
  private static URI ConstructPatchURL(String paramString)
  {
    return URI.create(Configuration.BeyondPodPublicWebSite() + "/android/search/PatchFeedURL.aspx?q=" + URLEncoder.encode(paramString));
  }
  
  public static PatchResult TryPatchFeedUrl(String paramString)
  {
    return new PatchResult(new FeedURLPatcher().callUrlPatcher(paramString));
  }
  
  /* Error */
  private String callUrlPatcher(String paramString)
  {
    // Byte code:
    //   0: getstatic 19	mobi/beyondpod/rsscore/FeedURLPatcher:TAG	Ljava/lang/String;
    //   3: new 27	java/lang/StringBuilder
    //   6: dup
    //   7: ldc 76
    //   9: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: aload_1
    //   13: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: invokestatic 82	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: invokestatic 85	mobi/beyondpod/rsscore/Configuration:DefaultUserAgent	()Ljava/lang/String;
    //   25: invokestatic 91	mobi/beyondpod/downloadengine/BeyondPodHttpClient:newInstance	(Ljava/lang/String;)Lmobi/beyondpod/downloadengine/BeyondPodHttpClient;
    //   28: astore 4
    //   30: aload 4
    //   32: invokevirtual 95	mobi/beyondpod/downloadengine/BeyondPodHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
    //   35: sipush 20000
    //   38: invokestatic 101	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   41: aload 4
    //   43: invokevirtual 95	mobi/beyondpod/downloadengine/BeyondPodHttpClient:getParams	()Lorg/apache/http/params/HttpParams;
    //   46: sipush 20000
    //   49: invokestatic 104	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   52: new 106	org/apache/http/client/methods/HttpGet
    //   55: dup
    //   56: aload_1
    //   57: invokestatic 108	mobi/beyondpod/rsscore/FeedURLPatcher:ConstructPatchURL	(Ljava/lang/String;)Ljava/net/URI;
    //   60: invokespecial 111	org/apache/http/client/methods/HttpGet:<init>	(Ljava/net/URI;)V
    //   63: astore 5
    //   65: aload 4
    //   67: aload 5
    //   69: invokevirtual 115	mobi/beyondpod/downloadengine/BeyondPodHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   72: astore_3
    //   73: aload_3
    //   74: invokeinterface 121 1 0
    //   79: invokeinterface 127 1 0
    //   84: istore_2
    //   85: iload_2
    //   86: sipush 200
    //   89: if_icmpeq +48 -> 137
    //   92: getstatic 19	mobi/beyondpod/rsscore/FeedURLPatcher:TAG	Ljava/lang/String;
    //   95: new 27	java/lang/StringBuilder
    //   98: dup
    //   99: ldc -127
    //   101: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   104: iload_2
    //   105: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   108: ldc -122
    //   110: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_1
    //   114: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 82	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload 4
    //   125: ifnull +8 -> 133
    //   128: aload 4
    //   130: invokevirtual 137	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_1
    //   136: areturn
    //   137: aload_3
    //   138: invokeinterface 141 1 0
    //   143: astore 6
    //   145: aload 6
    //   147: ifnull +236 -> 383
    //   150: aload 6
    //   152: ifnull +231 -> 383
    //   155: new 143	java/io/BufferedReader
    //   158: dup
    //   159: new 145	java/io/InputStreamReader
    //   162: dup
    //   163: aload 6
    //   165: invokeinterface 151 1 0
    //   170: invokespecial 154	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   173: sipush 4096
    //   176: invokespecial 157	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   179: astore_3
    //   180: new 27	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   187: astore 7
    //   189: aload_3
    //   190: invokevirtual 161	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   193: astore 8
    //   195: aload 8
    //   197: ifnonnull +39 -> 236
    //   200: aload_3
    //   201: invokevirtual 162	java/io/BufferedReader:close	()V
    //   204: aload 7
    //   206: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: astore_3
    //   210: aload 6
    //   212: ifnull +10 -> 222
    //   215: aload 6
    //   217: invokeinterface 165 1 0
    //   222: aload_3
    //   223: astore_1
    //   224: aload 4
    //   226: ifnull -91 -> 135
    //   229: aload 4
    //   231: invokevirtual 137	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   234: aload_3
    //   235: areturn
    //   236: aload 7
    //   238: new 27	java/lang/StringBuilder
    //   241: dup
    //   242: aload 8
    //   244: invokestatic 38	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   247: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   250: ldc -89
    //   252: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: goto -73 -> 189
    //   265: astore_3
    //   266: aload 6
    //   268: ifnull +10 -> 278
    //   271: aload 6
    //   273: invokeinterface 165 1 0
    //   278: aload_3
    //   279: athrow
    //   280: astore_3
    //   281: aload 5
    //   283: invokevirtual 170	org/apache/http/client/methods/HttpGet:abort	()V
    //   286: getstatic 19	mobi/beyondpod/rsscore/FeedURLPatcher:TAG	Ljava/lang/String;
    //   289: new 27	java/lang/StringBuilder
    //   292: dup
    //   293: ldc -84
    //   295: invokespecial 41	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   298: aload_1
    //   299: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: ldc -82
    //   304: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload_3
    //   308: invokevirtual 177	java/io/IOException:getMessage	()Ljava/lang/String;
    //   311: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 82	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: aload 4
    //   322: ifnull +8 -> 330
    //   325: aload 4
    //   327: invokevirtual 137	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   330: aconst_null
    //   331: areturn
    //   332: astore_1
    //   333: aload 5
    //   335: invokevirtual 170	org/apache/http/client/methods/HttpGet:abort	()V
    //   338: aload 4
    //   340: ifnull -10 -> 330
    //   343: aload 4
    //   345: invokevirtual 137	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   348: goto -18 -> 330
    //   351: astore_1
    //   352: aload 5
    //   354: invokevirtual 170	org/apache/http/client/methods/HttpGet:abort	()V
    //   357: aload 4
    //   359: ifnull -29 -> 330
    //   362: aload 4
    //   364: invokevirtual 137	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   367: goto -37 -> 330
    //   370: astore_1
    //   371: aload 4
    //   373: ifnull +8 -> 381
    //   376: aload 4
    //   378: invokevirtual 137	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   381: aload_1
    //   382: athrow
    //   383: aload 4
    //   385: ifnull -55 -> 330
    //   388: aload 4
    //   390: invokevirtual 137	mobi/beyondpod/downloadengine/BeyondPodHttpClient:close	()V
    //   393: goto -63 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	this	FeedURLPatcher
    //   0	396	1	paramString	String
    //   84	21	2	i	int
    //   72	163	3	localObject1	Object
    //   265	14	3	localObject2	Object
    //   280	28	3	localIOException	java.io.IOException
    //   28	361	4	localBeyondPodHttpClient	mobi.beyondpod.downloadengine.BeyondPodHttpClient
    //   63	290	5	localHttpGet	org.apache.http.client.methods.HttpGet
    //   143	129	6	localHttpEntity	org.apache.http.HttpEntity
    //   187	50	7	localStringBuilder	StringBuilder
    //   193	50	8	str	String
    // Exception table:
    //   from	to	target	type
    //   155	189	265	finally
    //   189	195	265	finally
    //   200	210	265	finally
    //   236	262	265	finally
    //   65	85	280	java/io/IOException
    //   92	123	280	java/io/IOException
    //   137	145	280	java/io/IOException
    //   215	222	280	java/io/IOException
    //   271	278	280	java/io/IOException
    //   278	280	280	java/io/IOException
    //   65	85	332	java/lang/IllegalStateException
    //   92	123	332	java/lang/IllegalStateException
    //   137	145	332	java/lang/IllegalStateException
    //   215	222	332	java/lang/IllegalStateException
    //   271	278	332	java/lang/IllegalStateException
    //   278	280	332	java/lang/IllegalStateException
    //   65	85	351	java/lang/Exception
    //   92	123	351	java/lang/Exception
    //   137	145	351	java/lang/Exception
    //   215	222	351	java/lang/Exception
    //   271	278	351	java/lang/Exception
    //   278	280	351	java/lang/Exception
    //   65	85	370	finally
    //   92	123	370	finally
    //   137	145	370	finally
    //   215	222	370	finally
    //   271	278	370	finally
    //   278	280	370	finally
    //   281	320	370	finally
    //   333	338	370	finally
    //   352	357	370	finally
  }
  
  public static class PatchResult
  {
    private String _PatchMessage;
    private String _PatchedURL;
    private String _Result;
    
    public PatchResult(String paramString)
    {
      if (StringUtils.IsNullOrEmpty(paramString)) {}
      do
      {
        return;
        paramString = paramString.split("\r\n|\r|\n");
        if (paramString.length > 0) {
          this._Result = paramString[0];
        }
        if (paramString.length > 1) {
          this._PatchedURL = paramString[1];
        }
      } while (paramString.length <= 2);
      this._PatchMessage = paramString[2];
    }
    
    public boolean IsPatched()
    {
      return "PATCHED".equals(this._Result);
    }
    
    public String PatchMessage()
    {
      return this._PatchMessage;
    }
    
    public String PatchedURL()
    {
      return this._PatchedURL;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/FeedURLPatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */