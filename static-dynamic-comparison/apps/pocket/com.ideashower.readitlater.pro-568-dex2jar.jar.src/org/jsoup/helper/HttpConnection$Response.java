package org.jsoup.helper;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.jsoup.Connection.KeyVal;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Request;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.parser.TokenQueue;

public class HttpConnection$Response
  extends HttpConnection.Base
  implements Connection.Response
{
  private static final int MAX_REDIRECTS = 20;
  private ByteBuffer byteData;
  private String charset;
  private String contentType;
  private boolean executed = false;
  private int numRedirects = 0;
  private Connection.Request req;
  private int statusCode;
  private String statusMessage;
  
  HttpConnection$Response()
  {
    super(null);
  }
  
  private HttpConnection$Response(Response paramResponse)
  {
    super(null);
    if (paramResponse != null)
    {
      paramResponse.numRedirects += 1;
      if (this.numRedirects >= 20) {
        throw new IOException(String.format("Too many redirects occurred trying to load URL %s", new Object[] { paramResponse.url() }));
      }
    }
  }
  
  private static HttpURLConnection createConnection(Connection.Request paramRequest)
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramRequest.url().openConnection();
    localHttpURLConnection.setRequestMethod(paramRequest.method().name());
    localHttpURLConnection.setInstanceFollowRedirects(false);
    localHttpURLConnection.setConnectTimeout(paramRequest.timeout());
    localHttpURLConnection.setReadTimeout(paramRequest.timeout());
    if (paramRequest.method() == Connection.Method.POST) {
      localHttpURLConnection.setDoOutput(true);
    }
    if (paramRequest.cookies().size() > 0) {
      localHttpURLConnection.addRequestProperty("Cookie", getRequestCookieString(paramRequest));
    }
    paramRequest = paramRequest.headers().entrySet().iterator();
    while (paramRequest.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramRequest.next();
      localHttpURLConnection.addRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    return localHttpURLConnection;
  }
  
  static Response execute(Connection.Request paramRequest)
  {
    return execute(paramRequest, null);
  }
  
  /* Error */
  static Response execute(Connection.Request paramRequest, Response paramResponse)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: ldc -100
    //   6: invokestatic 162	org/jsoup/helper/Validate:notNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   9: aload_0
    //   10: invokeinterface 56 1 0
    //   15: invokevirtual 165	java/net/URL:getProtocol	()Ljava/lang/String;
    //   18: astore 5
    //   20: aload 5
    //   22: ldc -89
    //   24: invokevirtual 171	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   27: ifne +23 -> 50
    //   30: aload 5
    //   32: ldc -83
    //   34: invokevirtual 171	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifne +13 -> 50
    //   40: new 175	java/net/MalformedURLException
    //   43: dup
    //   44: ldc -79
    //   46: invokespecial 178	java/net/MalformedURLException:<init>	(Ljava/lang/String;)V
    //   49: athrow
    //   50: aload_0
    //   51: invokeinterface 68 1 0
    //   56: getstatic 181	org/jsoup/Connection$Method:GET	Lorg/jsoup/Connection$Method;
    //   59: if_acmpne +21 -> 80
    //   62: aload_0
    //   63: invokeinterface 185 1 0
    //   68: invokeinterface 188 1 0
    //   73: ifle +7 -> 80
    //   76: aload_0
    //   77: invokestatic 192	org/jsoup/helper/HttpConnection$Response:serialiseRequestUrl	(Lorg/jsoup/Connection$Request;)V
    //   80: aload_0
    //   81: invokestatic 194	org/jsoup/helper/HttpConnection$Response:createConnection	(Lorg/jsoup/Connection$Request;)Ljava/net/HttpURLConnection;
    //   84: astore 7
    //   86: aload 7
    //   88: invokevirtual 197	java/net/HttpURLConnection:connect	()V
    //   91: aload_0
    //   92: invokeinterface 68 1 0
    //   97: getstatic 96	org/jsoup/Connection$Method:POST	Lorg/jsoup/Connection$Method;
    //   100: if_acmpne +17 -> 117
    //   103: aload_0
    //   104: invokeinterface 185 1 0
    //   109: aload 7
    //   111: invokevirtual 201	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   114: invokestatic 205	org/jsoup/helper/HttpConnection$Response:writePost	(Ljava/util/Collection;Ljava/io/OutputStream;)V
    //   117: aload 7
    //   119: invokevirtual 208	java/net/HttpURLConnection:getResponseCode	()I
    //   122: istore 4
    //   124: iconst_0
    //   125: istore_3
    //   126: iload_3
    //   127: istore_2
    //   128: iload 4
    //   130: sipush 200
    //   133: if_icmpeq +30 -> 163
    //   136: iload 4
    //   138: sipush 302
    //   141: if_icmpeq +477 -> 618
    //   144: iload 4
    //   146: sipush 301
    //   149: if_icmpeq +469 -> 618
    //   152: iload 4
    //   154: sipush 303
    //   157: if_icmpne +159 -> 316
    //   160: goto +458 -> 618
    //   163: new 2	org/jsoup/helper/HttpConnection$Response
    //   166: dup
    //   167: aload_1
    //   168: invokespecial 210	org/jsoup/helper/HttpConnection$Response:<init>	(Lorg/jsoup/helper/HttpConnection$Response;)V
    //   171: astore 8
    //   173: aload 8
    //   175: aload 7
    //   177: aload_1
    //   178: invokespecial 214	org/jsoup/helper/HttpConnection$Response:setupFromConnection	(Ljava/net/HttpURLConnection;Lorg/jsoup/Connection$Response;)V
    //   181: iload_2
    //   182: ifeq +180 -> 362
    //   185: aload_0
    //   186: invokeinterface 217 1 0
    //   191: ifeq +171 -> 362
    //   194: aload_0
    //   195: getstatic 181	org/jsoup/Connection$Method:GET	Lorg/jsoup/Connection$Method;
    //   198: invokeinterface 220 2 0
    //   203: pop
    //   204: aload_0
    //   205: invokeinterface 185 1 0
    //   210: invokeinterface 223 1 0
    //   215: aload_0
    //   216: new 58	java/net/URL
    //   219: dup
    //   220: aload_0
    //   221: invokeinterface 56 1 0
    //   226: aload 8
    //   228: ldc -31
    //   230: invokevirtual 229	org/jsoup/helper/HttpConnection$Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   233: invokespecial 232	java/net/URL:<init>	(Ljava/net/URL;Ljava/lang/String;)V
    //   236: invokeinterface 235 2 0
    //   241: pop
    //   242: aload 8
    //   244: getfield 238	org/jsoup/helper/HttpConnection$Response:cookies	Ljava/util/Map;
    //   247: invokeinterface 125 1 0
    //   252: invokeinterface 131 1 0
    //   257: astore_1
    //   258: aload_1
    //   259: invokeinterface 137 1 0
    //   264: ifeq +84 -> 348
    //   267: aload_1
    //   268: invokeinterface 141 1 0
    //   273: checkcast 143	java/util/Map$Entry
    //   276: astore 5
    //   278: aload_0
    //   279: aload 5
    //   281: invokeinterface 146 1 0
    //   286: checkcast 44	java/lang/String
    //   289: aload 5
    //   291: invokeinterface 149 1 0
    //   296: checkcast 44	java/lang/String
    //   299: invokeinterface 242 3 0
    //   304: pop
    //   305: goto -47 -> 258
    //   308: astore_0
    //   309: aload 7
    //   311: invokevirtual 245	java/net/HttpURLConnection:disconnect	()V
    //   314: aload_0
    //   315: athrow
    //   316: iload_3
    //   317: istore_2
    //   318: aload_0
    //   319: invokeinterface 248 1 0
    //   324: ifne -161 -> 163
    //   327: new 250	org/jsoup/HttpStatusException
    //   330: dup
    //   331: ldc -4
    //   333: iload 4
    //   335: aload_0
    //   336: invokeinterface 56 1 0
    //   341: invokevirtual 255	java/net/URL:toString	()Ljava/lang/String;
    //   344: invokespecial 258	org/jsoup/HttpStatusException:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: athrow
    //   348: aload_0
    //   349: aload 8
    //   351: invokestatic 154	org/jsoup/helper/HttpConnection$Response:execute	(Lorg/jsoup/Connection$Request;Lorg/jsoup/helper/HttpConnection$Response;)Lorg/jsoup/helper/HttpConnection$Response;
    //   354: astore_0
    //   355: aload 7
    //   357: invokevirtual 245	java/net/HttpURLConnection:disconnect	()V
    //   360: aload_0
    //   361: areturn
    //   362: aload 8
    //   364: aload_0
    //   365: putfield 260	org/jsoup/helper/HttpConnection$Response:req	Lorg/jsoup/Connection$Request;
    //   368: aload 8
    //   370: invokevirtual 262	org/jsoup/helper/HttpConnection$Response:contentType	()Ljava/lang/String;
    //   373: astore_1
    //   374: aload_1
    //   375: ifnull +63 -> 438
    //   378: aload_0
    //   379: invokeinterface 265 1 0
    //   384: ifne +54 -> 438
    //   387: aload_1
    //   388: ldc_w 267
    //   391: invokevirtual 271	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   394: ifne +44 -> 438
    //   397: aload_1
    //   398: ldc_w 273
    //   401: invokevirtual 271	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   404: ifne +34 -> 438
    //   407: aload_1
    //   408: ldc_w 275
    //   411: invokevirtual 271	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   414: ifne +24 -> 438
    //   417: new 277	org/jsoup/UnsupportedMimeTypeException
    //   420: dup
    //   421: ldc_w 279
    //   424: aload_1
    //   425: aload_0
    //   426: invokeinterface 56 1 0
    //   431: invokevirtual 255	java/net/URL:toString	()Ljava/lang/String;
    //   434: invokespecial 282	org/jsoup/UnsupportedMimeTypeException:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   437: athrow
    //   438: aload 7
    //   440: invokevirtual 286	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   443: ifnull +115 -> 558
    //   446: aload 7
    //   448: invokevirtual 286	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   451: astore_1
    //   452: aload 8
    //   454: ldc_w 288
    //   457: invokevirtual 291	org/jsoup/helper/HttpConnection$Response:hasHeader	(Ljava/lang/String;)Z
    //   460: ifeq +107 -> 567
    //   463: aload 8
    //   465: ldc_w 288
    //   468: invokevirtual 229	org/jsoup/helper/HttpConnection$Response:header	(Ljava/lang/String;)Ljava/lang/String;
    //   471: ldc_w 293
    //   474: invokevirtual 296	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   477: ifeq +90 -> 567
    //   480: new 298	java/io/BufferedInputStream
    //   483: dup
    //   484: new 300	java/util/zip/GZIPInputStream
    //   487: dup
    //   488: aload_1
    //   489: invokespecial 303	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   492: invokespecial 304	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   495: astore 5
    //   497: aload 8
    //   499: aload 5
    //   501: aload_0
    //   502: invokeinterface 307 1 0
    //   507: invokestatic 313	org/jsoup/helper/DataUtil:readToByteBuffer	(Ljava/io/InputStream;I)Ljava/nio/ByteBuffer;
    //   510: putfield 315	org/jsoup/helper/HttpConnection$Response:byteData	Ljava/nio/ByteBuffer;
    //   513: aload 8
    //   515: aload 8
    //   517: getfield 317	org/jsoup/helper/HttpConnection$Response:contentType	Ljava/lang/String;
    //   520: invokestatic 320	org/jsoup/helper/DataUtil:getCharsetFromContentType	(Ljava/lang/String;)Ljava/lang/String;
    //   523: putfield 322	org/jsoup/helper/HttpConnection$Response:charset	Ljava/lang/String;
    //   526: aload 5
    //   528: ifnull +8 -> 536
    //   531: aload 5
    //   533: invokevirtual 327	java/io/InputStream:close	()V
    //   536: aload_1
    //   537: ifnull +7 -> 544
    //   540: aload_1
    //   541: invokevirtual 327	java/io/InputStream:close	()V
    //   544: aload 7
    //   546: invokevirtual 245	java/net/HttpURLConnection:disconnect	()V
    //   549: aload 8
    //   551: iconst_1
    //   552: putfield 28	org/jsoup/helper/HttpConnection$Response:executed	Z
    //   555: aload 8
    //   557: areturn
    //   558: aload 7
    //   560: invokevirtual 330	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   563: astore_1
    //   564: goto -112 -> 452
    //   567: new 298	java/io/BufferedInputStream
    //   570: dup
    //   571: aload_1
    //   572: invokespecial 304	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   575: astore 5
    //   577: goto -80 -> 497
    //   580: astore_0
    //   581: aconst_null
    //   582: astore 5
    //   584: aload 6
    //   586: astore_1
    //   587: aload 5
    //   589: ifnull +8 -> 597
    //   592: aload 5
    //   594: invokevirtual 327	java/io/InputStream:close	()V
    //   597: aload_1
    //   598: ifnull +7 -> 605
    //   601: aload_1
    //   602: invokevirtual 327	java/io/InputStream:close	()V
    //   605: aload_0
    //   606: athrow
    //   607: astore_0
    //   608: aconst_null
    //   609: astore 5
    //   611: goto -24 -> 587
    //   614: astore_0
    //   615: goto -28 -> 587
    //   618: iconst_1
    //   619: istore_2
    //   620: goto -457 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	623	0	paramRequest	Connection.Request
    //   0	623	1	paramResponse	Response
    //   127	493	2	i	int
    //   125	192	3	j	int
    //   122	212	4	k	int
    //   18	592	5	localObject1	Object
    //   1	584	6	localObject2	Object
    //   84	475	7	localHttpURLConnection	HttpURLConnection
    //   171	385	8	localResponse	Response
    // Exception table:
    //   from	to	target	type
    //   86	117	308	finally
    //   117	124	308	finally
    //   163	181	308	finally
    //   185	258	308	finally
    //   258	305	308	finally
    //   318	348	308	finally
    //   348	355	308	finally
    //   362	374	308	finally
    //   378	438	308	finally
    //   531	536	308	finally
    //   540	544	308	finally
    //   592	597	308	finally
    //   601	605	308	finally
    //   605	607	308	finally
    //   438	452	580	finally
    //   558	564	580	finally
    //   452	497	607	finally
    //   567	577	607	finally
    //   497	526	614	finally
  }
  
  private static String getRequestCookieString(Connection.Request paramRequest)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramRequest = paramRequest.cookies().entrySet().iterator();
    int i = 1;
    if (paramRequest.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramRequest.next();
      if (i == 0) {
        localStringBuilder.append("; ");
      }
      for (;;)
      {
        localStringBuilder.append((String)localEntry.getKey()).append('=').append((String)localEntry.getValue());
        break;
        i = 0;
      }
    }
    return localStringBuilder.toString();
  }
  
  private static void serialiseRequestUrl(Connection.Request paramRequest)
  {
    Object localObject = paramRequest.url();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    localStringBuilder.append(((URL)localObject).getProtocol()).append("://").append(((URL)localObject).getAuthority()).append(((URL)localObject).getPath()).append("?");
    if (((URL)localObject).getQuery() != null)
    {
      localStringBuilder.append(((URL)localObject).getQuery());
      i = 0;
    }
    localObject = paramRequest.data().iterator();
    if (((Iterator)localObject).hasNext())
    {
      Connection.KeyVal localKeyVal = (Connection.KeyVal)((Iterator)localObject).next();
      if (i == 0) {
        localStringBuilder.append('&');
      }
      for (;;)
      {
        localStringBuilder.append(URLEncoder.encode(localKeyVal.key(), "UTF-8")).append('=').append(URLEncoder.encode(localKeyVal.value(), "UTF-8"));
        break;
        i = 0;
      }
    }
    paramRequest.url(new URL(localStringBuilder.toString()));
    paramRequest.data().clear();
  }
  
  private void setupFromConnection(HttpURLConnection paramHttpURLConnection, Connection.Response paramResponse)
  {
    this.method = Connection.Method.valueOf(paramHttpURLConnection.getRequestMethod());
    this.url = paramHttpURLConnection.getURL();
    this.statusCode = paramHttpURLConnection.getResponseCode();
    this.statusMessage = paramHttpURLConnection.getResponseMessage();
    this.contentType = paramHttpURLConnection.getContentType();
    processResponseHeaders(paramHttpURLConnection.getHeaderFields());
    if (paramResponse != null)
    {
      paramHttpURLConnection = paramResponse.cookies().entrySet().iterator();
      while (paramHttpURLConnection.hasNext())
      {
        paramResponse = (Map.Entry)paramHttpURLConnection.next();
        if (!hasCookie((String)paramResponse.getKey())) {
          cookie((String)paramResponse.getKey(), (String)paramResponse.getValue());
        }
      }
    }
  }
  
  private static void writePost(Collection paramCollection, OutputStream paramOutputStream)
  {
    paramOutputStream = new OutputStreamWriter(paramOutputStream, "UTF-8");
    paramCollection = paramCollection.iterator();
    int i = 1;
    if (paramCollection.hasNext())
    {
      Connection.KeyVal localKeyVal = (Connection.KeyVal)paramCollection.next();
      if (i == 0) {
        paramOutputStream.append('&');
      }
      for (;;)
      {
        paramOutputStream.write(URLEncoder.encode(localKeyVal.key(), "UTF-8"));
        paramOutputStream.write(61);
        paramOutputStream.write(URLEncoder.encode(localKeyVal.value(), "UTF-8"));
        break;
        i = 0;
      }
    }
    paramOutputStream.close();
  }
  
  public String body()
  {
    Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
    if (this.charset == null) {}
    for (String str = Charset.forName("UTF-8").decode(this.byteData).toString();; str = Charset.forName(this.charset).decode(this.byteData).toString())
    {
      this.byteData.rewind();
      return str;
    }
  }
  
  public byte[] bodyAsBytes()
  {
    Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before getting response body");
    return this.byteData.array();
  }
  
  public String charset()
  {
    return this.charset;
  }
  
  public String contentType()
  {
    return this.contentType;
  }
  
  public Document parse()
  {
    Validate.isTrue(this.executed, "Request must be executed (with .execute(), .get(), or .post() before parsing response");
    Document localDocument = DataUtil.parseByteData(this.byteData, this.charset, this.url.toExternalForm(), this.req.parser());
    this.byteData.rewind();
    this.charset = localDocument.outputSettings().charset().name();
    return localDocument;
  }
  
  void processResponseHeaders(Map paramMap)
  {
    Iterator localIterator1 = paramMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (Map.Entry)localIterator1.next();
      paramMap = (String)((Map.Entry)localObject).getKey();
      if (paramMap != null)
      {
        localObject = (List)((Map.Entry)localObject).getValue();
        if (paramMap.equalsIgnoreCase("Set-Cookie"))
        {
          Iterator localIterator2 = ((List)localObject).iterator();
          while (localIterator2.hasNext())
          {
            paramMap = (String)localIterator2.next();
            if (paramMap != null)
            {
              paramMap = new TokenQueue(paramMap);
              String str = paramMap.chompTo("=").trim();
              localObject = paramMap.consumeTo(";").trim();
              paramMap = (Map)localObject;
              if (localObject == null) {
                paramMap = "";
              }
              if ((str != null) && (str.length() > 0)) {
                cookie(str, paramMap);
              }
            }
          }
        }
        else if (!((List)localObject).isEmpty())
        {
          header(paramMap, (String)((List)localObject).get(0));
        }
      }
    }
  }
  
  public int statusCode()
  {
    return this.statusCode;
  }
  
  public String statusMessage()
  {
    return this.statusMessage;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/jsoup/helper/HttpConnection$Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */