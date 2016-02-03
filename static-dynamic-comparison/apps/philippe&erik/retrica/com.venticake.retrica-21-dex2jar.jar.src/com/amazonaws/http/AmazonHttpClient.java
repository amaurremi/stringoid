package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonServiceException.ErrorType;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.RequestClientOptions;
import com.amazonaws.RequestClientOptions.Marker;
import com.amazonaws.Response;
import com.amazonaws.handlers.CredentialsRequestHandler;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.internal.CRC32MismatchException;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpEntity;
import com.amazonaws.org.apache.http.HttpEntityEnclosingRequest;
import com.amazonaws.org.apache.http.StatusLine;
import com.amazonaws.org.apache.http.client.HttpClient;
import com.amazonaws.org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import com.amazonaws.org.apache.http.client.methods.HttpRequestBase;
import com.amazonaws.org.apache.http.conn.ClientConnectionManager;
import com.amazonaws.org.apache.http.pool.ConnPoolControl;
import com.amazonaws.org.apache.http.pool.PoolStats;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.retry.RetryPolicy.BackoffStrategy;
import com.amazonaws.retry.RetryPolicy.RetryCondition;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazonaws.util.CountingInputStream;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.ResponseMetadataCache;
import com.amazonaws.util.TimingInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public class AmazonHttpClient
{
  private static final HttpClientFactory httpClientFactory;
  private static final HttpRequestFactory httpRequestFactory;
  static final Log log;
  private static final Log requestLog = LogFactory.getLog("com.amazonaws.request");
  private final ClientConfiguration config;
  private final HttpClient httpClient;
  private final RequestMetricCollector requestMetricCollector;
  private final ResponseMetadataCache responseMetadataCache = new ResponseMetadataCache(50);
  
  static
  {
    log = LogFactory.getLog(AmazonHttpClient.class);
    httpRequestFactory = new HttpRequestFactory();
    httpClientFactory = new HttpClientFactory();
    List localList = Arrays.asList(new String[] { "1.6.0_06", "1.6.0_13", "1.6.0_17" });
    String str = System.getProperty("java.version");
    if (localList.contains(str)) {
      log.warn("Detected a possible problem with the current JVM version (" + str + ").  " + "If you experience XML parsing problems using the SDK, try upgrading to a more recent JVM update.");
    }
  }
  
  public AmazonHttpClient(ClientConfiguration paramClientConfiguration, RequestMetricCollector paramRequestMetricCollector)
  {
    this(paramClientConfiguration, httpClientFactory.createHttpClient(paramClientConfiguration), paramRequestMetricCollector);
  }
  
  AmazonHttpClient(ClientConfiguration paramClientConfiguration, HttpClient paramHttpClient, RequestMetricCollector paramRequestMetricCollector)
  {
    this.config = paramClientConfiguration;
    this.httpClient = paramHttpClient;
    this.requestMetricCollector = paramRequestMetricCollector;
  }
  
  private void afterError(Request<?> paramRequest, Response<?> paramResponse, List<RequestHandler2> paramList, AmazonClientException paramAmazonClientException)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((RequestHandler2)paramList.next()).afterError(paramRequest, paramResponse, paramAmazonClientException);
    }
  }
  
  private <T> void afterResponse(Request<?> paramRequest, List<RequestHandler2> paramList, Response<T> paramResponse, TimingInfo paramTimingInfo)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((RequestHandler2)paramList.next()).afterResponse(paramRequest, paramResponse);
    }
  }
  
  private void captureConnectionPoolMetrics(ClientConnectionManager paramClientConnectionManager, AWSRequestMetrics paramAWSRequestMetrics)
  {
    if ((paramAWSRequestMetrics.isEnabled()) && ((paramClientConnectionManager instanceof ConnPoolControl)))
    {
      paramClientConnectionManager = ((ConnPoolControl)paramClientConnectionManager).getTotalStats();
      paramAWSRequestMetrics.setCounter(AWSRequestMetrics.Field.HttpClientPoolAvailableCount, paramClientConnectionManager.getAvailable());
      paramAWSRequestMetrics.setCounter(AWSRequestMetrics.Field.HttpClientPoolLeasedCount, paramClientConnectionManager.getLeased());
      paramAWSRequestMetrics.setCounter(AWSRequestMetrics.Field.HttpClientPoolPendingCount, paramClientConnectionManager.getPending());
    }
  }
  
  private HttpResponse createResponse(HttpRequestBase paramHttpRequestBase, Request<?> paramRequest, com.amazonaws.org.apache.http.HttpResponse paramHttpResponse)
  {
    paramHttpRequestBase = new HttpResponse(paramRequest, paramHttpRequestBase);
    if (paramHttpResponse.getEntity() != null) {
      paramHttpRequestBase.setContent(paramHttpResponse.getEntity().getContent());
    }
    paramHttpRequestBase.setStatusCode(paramHttpResponse.getStatusLine().getStatusCode());
    paramHttpRequestBase.setStatusText(paramHttpResponse.getStatusLine().getReasonPhrase());
    paramRequest = paramHttpResponse.getAllHeaders();
    int j = paramRequest.length;
    int i = 0;
    while (i < j)
    {
      paramHttpResponse = paramRequest[i];
      paramHttpRequestBase.addHeader(paramHttpResponse.getName(), paramHttpResponse.getValue());
      i += 1;
    }
    return paramHttpRequestBase;
  }
  
  private static String createUserAgentString(String paramString1, String paramString2)
  {
    if (paramString1.contains(paramString2)) {
      return paramString1;
    }
    return paramString1.trim() + " " + paramString2.trim();
  }
  
  /* Error */
  private <T> Response<T> executeHelper(Request<?> paramRequest, HttpResponseHandler<AmazonWebServiceResponse<T>> paramHttpResponseHandler, HttpResponseHandler<AmazonServiceException> paramHttpResponseHandler1, ExecutionContext paramExecutionContext)
  {
    // Byte code:
    //   0: aload 4
    //   2: invokevirtual 276	com/amazonaws/http/ExecutionContext:getAwsRequestMetrics	()Lcom/amazonaws/util/AWSRequestMetrics;
    //   5: astore 26
    //   7: aload 26
    //   9: getstatic 279	com/amazonaws/util/AWSRequestMetrics$Field:ServiceName	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   12: aload_1
    //   13: invokeinterface 284 1 0
    //   18: invokevirtual 288	com/amazonaws/util/AWSRequestMetrics:addProperty	(Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
    //   21: aload 26
    //   23: getstatic 291	com/amazonaws/util/AWSRequestMetrics$Field:ServiceEndpoint	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   26: aload_1
    //   27: invokeinterface 295 1 0
    //   32: invokevirtual 288	com/amazonaws/util/AWSRequestMetrics:addProperty	(Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
    //   35: aload_0
    //   36: aload_1
    //   37: invokespecial 299	com/amazonaws/http/AmazonHttpClient:setUserAgent	(Lcom/amazonaws/Request;)V
    //   40: iconst_0
    //   41: istore 5
    //   43: aconst_null
    //   44: astore 16
    //   46: aconst_null
    //   47: astore 13
    //   49: new 301	java/util/LinkedHashMap
    //   52: dup
    //   53: invokespecial 302	java/util/LinkedHashMap:<init>	()V
    //   56: astore 27
    //   58: aload 27
    //   60: aload_1
    //   61: invokeinterface 306 1 0
    //   66: invokeinterface 312 2 0
    //   71: new 314	java/util/HashMap
    //   74: dup
    //   75: invokespecial 315	java/util/HashMap:<init>	()V
    //   78: astore 28
    //   80: aload 28
    //   82: aload_1
    //   83: invokeinterface 318 1 0
    //   88: invokeinterface 312 2 0
    //   93: aload 4
    //   95: invokevirtual 322	com/amazonaws/http/ExecutionContext:getCredentials	()Lcom/amazonaws/auth/AWSCredentials;
    //   98: astore 29
    //   100: aconst_null
    //   101: astore 11
    //   103: aconst_null
    //   104: astore 12
    //   106: iconst_0
    //   107: istore 6
    //   109: iload 5
    //   111: iconst_1
    //   112: iadd
    //   113: istore 5
    //   115: aload 26
    //   117: getstatic 325	com/amazonaws/util/AWSRequestMetrics$Field:RequestCount	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   120: iload 5
    //   122: i2l
    //   123: invokevirtual 181	com/amazonaws/util/AWSRequestMetrics:setCounter	(Lcom/amazonaws/metrics/MetricType;J)V
    //   126: iload 5
    //   128: iconst_1
    //   129: if_icmple +19 -> 148
    //   132: aload_1
    //   133: aload 27
    //   135: invokeinterface 328 2 0
    //   140: aload_1
    //   141: aload 28
    //   143: invokeinterface 331 2 0
    //   148: aconst_null
    //   149: astore 21
    //   151: aconst_null
    //   152: astore 22
    //   154: aconst_null
    //   155: astore 23
    //   157: aconst_null
    //   158: astore 24
    //   160: aconst_null
    //   161: astore 25
    //   163: aconst_null
    //   164: astore 20
    //   166: aload 11
    //   168: ifnonnull +2858 -> 3026
    //   171: iload 6
    //   173: istore 9
    //   175: aload 22
    //   177: astore 18
    //   179: iload 6
    //   181: istore 7
    //   183: aload 23
    //   185: astore 15
    //   187: iload 6
    //   189: istore 10
    //   191: aload 24
    //   193: astore 19
    //   195: aload 4
    //   197: aload_1
    //   198: invokeinterface 295 1 0
    //   203: invokevirtual 335	com/amazonaws/http/ExecutionContext:getSignerByURI	(Ljava/net/URI;)Lcom/amazonaws/auth/Signer;
    //   206: astore 14
    //   208: aload 14
    //   210: astore 11
    //   212: aload 11
    //   214: ifnull +82 -> 296
    //   217: aload 29
    //   219: ifnull +77 -> 296
    //   222: iload 6
    //   224: istore 9
    //   226: aload 22
    //   228: astore 18
    //   230: iload 6
    //   232: istore 7
    //   234: aload 23
    //   236: astore 15
    //   238: iload 6
    //   240: istore 10
    //   242: aload 24
    //   244: astore 19
    //   246: aload 26
    //   248: getstatic 338	com/amazonaws/util/AWSRequestMetrics$Field:RequestSigningTime	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   251: invokevirtual 342	com/amazonaws/util/AWSRequestMetrics:startEvent	(Lcom/amazonaws/metrics/MetricType;)V
    //   254: aload 11
    //   256: aload_1
    //   257: aload 29
    //   259: invokeinterface 348 3 0
    //   264: iload 6
    //   266: istore 9
    //   268: aload 22
    //   270: astore 18
    //   272: iload 6
    //   274: istore 7
    //   276: aload 23
    //   278: astore 15
    //   280: iload 6
    //   282: istore 10
    //   284: aload 24
    //   286: astore 19
    //   288: aload 26
    //   290: getstatic 338	com/amazonaws/util/AWSRequestMetrics$Field:RequestSigningTime	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   293: invokevirtual 351	com/amazonaws/util/AWSRequestMetrics:endEvent	(Lcom/amazonaws/metrics/MetricType;)V
    //   296: iload 6
    //   298: istore 9
    //   300: aload 22
    //   302: astore 18
    //   304: iload 6
    //   306: istore 7
    //   308: aload 23
    //   310: astore 15
    //   312: iload 6
    //   314: istore 10
    //   316: aload 24
    //   318: astore 19
    //   320: getstatic 32	com/amazonaws/http/AmazonHttpClient:requestLog	Lorg/apache/commons/logging/Log;
    //   323: invokeinterface 354 1 0
    //   328: ifeq +58 -> 386
    //   331: iload 6
    //   333: istore 9
    //   335: aload 22
    //   337: astore 18
    //   339: iload 6
    //   341: istore 7
    //   343: aload 23
    //   345: astore 15
    //   347: iload 6
    //   349: istore 10
    //   351: aload 24
    //   353: astore 19
    //   355: getstatic 32	com/amazonaws/http/AmazonHttpClient:requestLog	Lorg/apache/commons/logging/Log;
    //   358: new 79	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   365: ldc_w 356
    //   368: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload_1
    //   372: invokevirtual 357	java/lang/Object:toString	()Ljava/lang/String;
    //   375: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokeinterface 360 2 0
    //   386: iload 6
    //   388: istore 9
    //   390: aload 22
    //   392: astore 18
    //   394: iload 6
    //   396: istore 7
    //   398: aload 23
    //   400: astore 15
    //   402: iload 6
    //   404: istore 10
    //   406: aload 24
    //   408: astore 19
    //   410: getstatic 44	com/amazonaws/http/AmazonHttpClient:httpRequestFactory	Lcom/amazonaws/http/HttpRequestFactory;
    //   413: aload_1
    //   414: aload_0
    //   415: getfield 119	com/amazonaws/http/AmazonHttpClient:config	Lcom/amazonaws/ClientConfiguration;
    //   418: aload 4
    //   420: invokevirtual 364	com/amazonaws/http/HttpRequestFactory:createHttpRequest	(Lcom/amazonaws/Request;Lcom/amazonaws/ClientConfiguration;Lcom/amazonaws/http/ExecutionContext;)Lcom/amazonaws/org/apache/http/client/methods/HttpRequestBase;
    //   423: astore 17
    //   425: iload 6
    //   427: istore 9
    //   429: aload 22
    //   431: astore 18
    //   433: iload 6
    //   435: istore 7
    //   437: aload 23
    //   439: astore 15
    //   441: iload 6
    //   443: istore 10
    //   445: aload 24
    //   447: astore 19
    //   449: aload 17
    //   451: instanceof 366
    //   454: ifeq +2565 -> 3019
    //   457: iload 6
    //   459: istore 9
    //   461: aload 22
    //   463: astore 18
    //   465: iload 6
    //   467: istore 7
    //   469: aload 23
    //   471: astore 15
    //   473: iload 6
    //   475: istore 10
    //   477: aload 24
    //   479: astore 19
    //   481: aload 17
    //   483: checkcast 366	com/amazonaws/org/apache/http/HttpEntityEnclosingRequest
    //   486: invokeinterface 367 1 0
    //   491: astore 14
    //   493: aload 12
    //   495: ifnull +42 -> 537
    //   498: iload 6
    //   500: istore 9
    //   502: aload 22
    //   504: astore 18
    //   506: iload 6
    //   508: istore 7
    //   510: aload 23
    //   512: astore 15
    //   514: iload 6
    //   516: istore 10
    //   518: aload 24
    //   520: astore 19
    //   522: aload 25
    //   524: astore 16
    //   526: aload 12
    //   528: astore 20
    //   530: aload 17
    //   532: aload 12
    //   534: invokevirtual 373	com/amazonaws/org/apache/http/client/methods/HttpRequestBase:setURI	(Ljava/net/URI;)V
    //   537: iload 5
    //   539: iconst_1
    //   540: if_icmple +104 -> 644
    //   543: iload 6
    //   545: istore 9
    //   547: aload 22
    //   549: astore 18
    //   551: iload 6
    //   553: istore 7
    //   555: aload 23
    //   557: astore 15
    //   559: iload 6
    //   561: istore 10
    //   563: aload 24
    //   565: astore 19
    //   567: aload 25
    //   569: astore 16
    //   571: aload 12
    //   573: astore 20
    //   575: aload 26
    //   577: getstatic 376	com/amazonaws/util/AWSRequestMetrics$Field:RetryPauseTime	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   580: invokevirtual 342	com/amazonaws/util/AWSRequestMetrics:startEvent	(Lcom/amazonaws/metrics/MetricType;)V
    //   583: aload_0
    //   584: aload_1
    //   585: invokeinterface 380 1 0
    //   590: aload 13
    //   592: iload 5
    //   594: aload_0
    //   595: getfield 119	com/amazonaws/http/AmazonHttpClient:config	Lcom/amazonaws/ClientConfiguration;
    //   598: invokevirtual 386	com/amazonaws/ClientConfiguration:getRetryPolicy	()Lcom/amazonaws/retry/RetryPolicy;
    //   601: invokespecial 390	com/amazonaws/http/AmazonHttpClient:pauseBeforeNextRetry	(Lcom/amazonaws/AmazonWebServiceRequest;Lcom/amazonaws/AmazonClientException;ILcom/amazonaws/retry/RetryPolicy;)V
    //   604: iload 6
    //   606: istore 9
    //   608: aload 22
    //   610: astore 18
    //   612: iload 6
    //   614: istore 7
    //   616: aload 23
    //   618: astore 15
    //   620: iload 6
    //   622: istore 10
    //   624: aload 24
    //   626: astore 19
    //   628: aload 25
    //   630: astore 16
    //   632: aload 12
    //   634: astore 20
    //   636: aload 26
    //   638: getstatic 376	com/amazonaws/util/AWSRequestMetrics$Field:RetryPauseTime	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   641: invokevirtual 351	com/amazonaws/util/AWSRequestMetrics:endEvent	(Lcom/amazonaws/metrics/MetricType;)V
    //   644: aload 14
    //   646: ifnull +165 -> 811
    //   649: iload 6
    //   651: istore 9
    //   653: aload 22
    //   655: astore 18
    //   657: iload 6
    //   659: istore 7
    //   661: aload 23
    //   663: astore 15
    //   665: iload 6
    //   667: istore 10
    //   669: aload 24
    //   671: astore 19
    //   673: aload 25
    //   675: astore 16
    //   677: aload 12
    //   679: astore 20
    //   681: aload 14
    //   683: invokeinterface 212 1 0
    //   688: astore 13
    //   690: iload 5
    //   692: iconst_1
    //   693: if_icmple +924 -> 1617
    //   696: iload 6
    //   698: istore 9
    //   700: aload 22
    //   702: astore 18
    //   704: iload 6
    //   706: istore 7
    //   708: aload 23
    //   710: astore 15
    //   712: iload 6
    //   714: istore 10
    //   716: aload 24
    //   718: astore 19
    //   720: aload 25
    //   722: astore 16
    //   724: aload 12
    //   726: astore 20
    //   728: aload 13
    //   730: invokevirtual 395	java/io/InputStream:markSupported	()Z
    //   733: ifeq +78 -> 811
    //   736: iload 6
    //   738: istore 9
    //   740: aload 22
    //   742: astore 18
    //   744: iload 6
    //   746: istore 7
    //   748: aload 23
    //   750: astore 15
    //   752: iload 6
    //   754: istore 10
    //   756: aload 24
    //   758: astore 19
    //   760: aload 25
    //   762: astore 16
    //   764: aload 12
    //   766: astore 20
    //   768: aload 13
    //   770: invokevirtual 398	java/io/InputStream:reset	()V
    //   773: iload 6
    //   775: istore 9
    //   777: aload 22
    //   779: astore 18
    //   781: iload 6
    //   783: istore 7
    //   785: aload 23
    //   787: astore 15
    //   789: iload 6
    //   791: istore 10
    //   793: aload 24
    //   795: astore 19
    //   797: aload 25
    //   799: astore 16
    //   801: aload 12
    //   803: astore 20
    //   805: aload 13
    //   807: iconst_m1
    //   808: invokevirtual 401	java/io/InputStream:mark	(I)V
    //   811: iload 6
    //   813: istore 9
    //   815: aload 22
    //   817: astore 18
    //   819: iload 6
    //   821: istore 7
    //   823: aload 23
    //   825: astore 15
    //   827: iload 6
    //   829: istore 10
    //   831: aload 24
    //   833: astore 19
    //   835: aload 25
    //   837: astore 16
    //   839: aload 12
    //   841: astore 20
    //   843: aload_0
    //   844: aload_0
    //   845: getfield 121	com/amazonaws/http/AmazonHttpClient:httpClient	Lcom/amazonaws/org/apache/http/client/HttpClient;
    //   848: invokeinterface 407 1 0
    //   853: aload 26
    //   855: invokespecial 409	com/amazonaws/http/AmazonHttpClient:captureConnectionPoolMetrics	(Lcom/amazonaws/org/apache/http/conn/ClientConnectionManager;Lcom/amazonaws/util/AWSRequestMetrics;)V
    //   858: iload 6
    //   860: istore 9
    //   862: aload 22
    //   864: astore 18
    //   866: iload 6
    //   868: istore 7
    //   870: aload 23
    //   872: astore 15
    //   874: iload 6
    //   876: istore 10
    //   878: aload 24
    //   880: astore 19
    //   882: aload 25
    //   884: astore 16
    //   886: aload 12
    //   888: astore 20
    //   890: new 411	com/amazonaws/org/apache/http/protocol/BasicHttpContext
    //   893: dup
    //   894: invokespecial 412	com/amazonaws/org/apache/http/protocol/BasicHttpContext:<init>	()V
    //   897: astore 13
    //   899: iload 6
    //   901: istore 9
    //   903: aload 22
    //   905: astore 18
    //   907: iload 6
    //   909: istore 7
    //   911: aload 23
    //   913: astore 15
    //   915: iload 6
    //   917: istore 10
    //   919: aload 24
    //   921: astore 19
    //   923: aload 25
    //   925: astore 16
    //   927: aload 12
    //   929: astore 20
    //   931: aload 13
    //   933: ldc -100
    //   935: invokevirtual 417	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   938: aload 26
    //   940: invokeinterface 423 3 0
    //   945: aconst_null
    //   946: astore 21
    //   948: iload 6
    //   950: istore 9
    //   952: aload 22
    //   954: astore 18
    //   956: iload 6
    //   958: istore 7
    //   960: aload 23
    //   962: astore 15
    //   964: iload 6
    //   966: istore 10
    //   968: aload 24
    //   970: astore 19
    //   972: aload 25
    //   974: astore 16
    //   976: aload 12
    //   978: astore 20
    //   980: aload 26
    //   982: getstatic 426	com/amazonaws/util/AWSRequestMetrics$Field:HttpRequestTime	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   985: invokevirtual 342	com/amazonaws/util/AWSRequestMetrics:startEvent	(Lcom/amazonaws/metrics/MetricType;)V
    //   988: aload_0
    //   989: getfield 121	com/amazonaws/http/AmazonHttpClient:httpClient	Lcom/amazonaws/org/apache/http/client/HttpClient;
    //   992: aload 17
    //   994: aload 13
    //   996: invokeinterface 430 3 0
    //   1001: astore 13
    //   1003: iload 6
    //   1005: istore 9
    //   1007: aload 13
    //   1009: astore 18
    //   1011: iload 6
    //   1013: istore 7
    //   1015: aload 13
    //   1017: astore 15
    //   1019: iload 6
    //   1021: istore 10
    //   1023: aload 13
    //   1025: astore 19
    //   1027: aload 13
    //   1029: astore 16
    //   1031: aload 12
    //   1033: astore 20
    //   1035: aload 26
    //   1037: getstatic 426	com/amazonaws/util/AWSRequestMetrics$Field:HttpRequestTime	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   1040: invokevirtual 351	com/amazonaws/util/AWSRequestMetrics:endEvent	(Lcom/amazonaws/metrics/MetricType;)V
    //   1043: iload 6
    //   1045: istore 9
    //   1047: aload 13
    //   1049: astore 18
    //   1051: iload 6
    //   1053: istore 7
    //   1055: aload 13
    //   1057: astore 15
    //   1059: iload 6
    //   1061: istore 10
    //   1063: aload 13
    //   1065: astore 19
    //   1067: aload 13
    //   1069: astore 16
    //   1071: aload 12
    //   1073: astore 20
    //   1075: aload_0
    //   1076: aload 13
    //   1078: invokespecial 434	com/amazonaws/http/AmazonHttpClient:isRequestSuccessful	(Lcom/amazonaws/org/apache/http/HttpResponse;)Z
    //   1081: ifeq +766 -> 1847
    //   1084: iload 6
    //   1086: istore 9
    //   1088: aload 13
    //   1090: astore 18
    //   1092: iload 6
    //   1094: istore 7
    //   1096: aload 13
    //   1098: astore 15
    //   1100: iload 6
    //   1102: istore 10
    //   1104: aload 13
    //   1106: astore 19
    //   1108: aload 13
    //   1110: astore 16
    //   1112: aload 12
    //   1114: astore 20
    //   1116: aload 26
    //   1118: getstatic 437	com/amazonaws/util/AWSRequestMetrics$Field:StatusCode	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   1121: aload 13
    //   1123: invokeinterface 220 1 0
    //   1128: invokeinterface 225 1 0
    //   1133: invokestatic 443	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1136: invokevirtual 288	com/amazonaws/util/AWSRequestMetrics:addProperty	(Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
    //   1139: iload 6
    //   1141: istore 9
    //   1143: aload 13
    //   1145: astore 18
    //   1147: iload 6
    //   1149: istore 7
    //   1151: aload 13
    //   1153: astore 15
    //   1155: iload 6
    //   1157: istore 10
    //   1159: aload 13
    //   1161: astore 19
    //   1163: aload 13
    //   1165: astore 16
    //   1167: aload 12
    //   1169: astore 20
    //   1171: aload_2
    //   1172: invokeinterface 448 1 0
    //   1177: istore 8
    //   1179: aload_0
    //   1180: aload 17
    //   1182: aload_1
    //   1183: aload 13
    //   1185: invokespecial 450	com/amazonaws/http/AmazonHttpClient:createResponse	(Lcom/amazonaws/org/apache/http/client/methods/HttpRequestBase;Lcom/amazonaws/Request;Lcom/amazonaws/org/apache/http/HttpResponse;)Lcom/amazonaws/http/HttpResponse;
    //   1188: astore 15
    //   1190: new 452	com/amazonaws/Response
    //   1193: dup
    //   1194: aload_0
    //   1195: aload_1
    //   1196: aload_2
    //   1197: aload 17
    //   1199: aload 15
    //   1201: aload 13
    //   1203: aload 4
    //   1205: invokespecial 456	com/amazonaws/http/AmazonHttpClient:handleResponse	(Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/org/apache/http/client/methods/HttpRequestBase;Lcom/amazonaws/http/HttpResponse;Lcom/amazonaws/org/apache/http/HttpResponse;Lcom/amazonaws/http/ExecutionContext;)Ljava/lang/Object;
    //   1208: aload 15
    //   1210: invokespecial 459	com/amazonaws/Response:<init>	(Ljava/lang/Object;Lcom/amazonaws/http/HttpResponse;)V
    //   1213: astore 15
    //   1215: iload 8
    //   1217: ifne +48 -> 1265
    //   1220: aload 13
    //   1222: ifnull +43 -> 1265
    //   1225: aload 13
    //   1227: invokeinterface 206 1 0
    //   1232: ifnull +33 -> 1265
    //   1235: aload 13
    //   1237: invokeinterface 206 1 0
    //   1242: invokeinterface 212 1 0
    //   1247: ifnull +18 -> 1265
    //   1250: aload 13
    //   1252: invokeinterface 206 1 0
    //   1257: invokeinterface 212 1 0
    //   1262: invokevirtual 462	java/io/InputStream:close	()V
    //   1265: aload 15
    //   1267: areturn
    //   1268: astore 13
    //   1270: iload 6
    //   1272: istore 9
    //   1274: aload 22
    //   1276: astore 18
    //   1278: iload 6
    //   1280: istore 7
    //   1282: aload 23
    //   1284: astore 15
    //   1286: iload 6
    //   1288: istore 10
    //   1290: aload 24
    //   1292: astore 19
    //   1294: aload 26
    //   1296: getstatic 338	com/amazonaws/util/AWSRequestMetrics$Field:RequestSigningTime	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   1299: invokevirtual 351	com/amazonaws/util/AWSRequestMetrics:endEvent	(Lcom/amazonaws/metrics/MetricType;)V
    //   1302: iload 6
    //   1304: istore 9
    //   1306: aload 22
    //   1308: astore 18
    //   1310: iload 6
    //   1312: istore 7
    //   1314: aload 23
    //   1316: astore 15
    //   1318: iload 6
    //   1320: istore 10
    //   1322: aload 24
    //   1324: astore 19
    //   1326: aload 13
    //   1328: athrow
    //   1329: astore 14
    //   1331: aload 21
    //   1333: astore 13
    //   1335: aload 20
    //   1337: astore 17
    //   1339: aload 16
    //   1341: astore 15
    //   1343: getstatic 37	com/amazonaws/http/AmazonHttpClient:log	Lorg/apache/commons/logging/Log;
    //   1346: invokeinterface 465 1 0
    //   1351: ifeq +37 -> 1388
    //   1354: getstatic 37	com/amazonaws/http/AmazonHttpClient:log	Lorg/apache/commons/logging/Log;
    //   1357: new 79	java/lang/StringBuilder
    //   1360: dup
    //   1361: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1364: ldc_w 467
    //   1367: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1370: aload 14
    //   1372: invokevirtual 470	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1375: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1381: aload 14
    //   1383: invokeinterface 474 3 0
    //   1388: aload 26
    //   1390: getstatic 477	com/amazonaws/util/AWSRequestMetrics$Field:Exception	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   1393: invokevirtual 480	com/amazonaws/util/AWSRequestMetrics:incrementCounter	(Lcom/amazonaws/metrics/MetricType;)V
    //   1396: aload 26
    //   1398: getstatic 477	com/amazonaws/util/AWSRequestMetrics$Field:Exception	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   1401: aload 14
    //   1403: invokevirtual 288	com/amazonaws/util/AWSRequestMetrics:addProperty	(Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
    //   1406: aload 26
    //   1408: getstatic 483	com/amazonaws/util/AWSRequestMetrics$Field:AWSRequestID	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   1411: aconst_null
    //   1412: invokevirtual 288	com/amazonaws/util/AWSRequestMetrics:addProperty	(Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
    //   1415: new 485	com/amazonaws/AmazonClientException
    //   1418: dup
    //   1419: new 79	java/lang/StringBuilder
    //   1422: dup
    //   1423: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1426: ldc_w 467
    //   1429: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1432: aload 14
    //   1434: invokevirtual 470	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1437: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1440: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1443: aload 14
    //   1445: invokespecial 488	com/amazonaws/AmazonClientException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1448: astore 19
    //   1450: aload_0
    //   1451: aload_1
    //   1452: invokeinterface 380 1 0
    //   1457: aload 13
    //   1459: aload 19
    //   1461: iload 5
    //   1463: aload_0
    //   1464: getfield 119	com/amazonaws/http/AmazonHttpClient:config	Lcom/amazonaws/ClientConfiguration;
    //   1467: invokevirtual 386	com/amazonaws/ClientConfiguration:getRetryPolicy	()Lcom/amazonaws/retry/RetryPolicy;
    //   1470: invokespecial 492	com/amazonaws/http/AmazonHttpClient:shouldRetry	(Lcom/amazonaws/AmazonWebServiceRequest;Lcom/amazonaws/org/apache/http/client/methods/HttpRequestBase;Lcom/amazonaws/AmazonClientException;ILcom/amazonaws/retry/RetryPolicy;)Z
    //   1473: ifne +1245 -> 2718
    //   1476: aload 19
    //   1478: athrow
    //   1479: astore_1
    //   1480: aload 17
    //   1482: astore 13
    //   1484: iload 6
    //   1486: istore 7
    //   1488: iload 7
    //   1490: ifne +48 -> 1538
    //   1493: aload 13
    //   1495: ifnull +43 -> 1538
    //   1498: aload 13
    //   1500: invokeinterface 206 1 0
    //   1505: ifnull +33 -> 1538
    //   1508: aload 13
    //   1510: invokeinterface 206 1 0
    //   1515: invokeinterface 212 1 0
    //   1520: ifnull +18 -> 1538
    //   1523: aload 13
    //   1525: invokeinterface 206 1 0
    //   1530: invokeinterface 212 1 0
    //   1535: invokevirtual 462	java/io/InputStream:close	()V
    //   1538: aload_1
    //   1539: athrow
    //   1540: astore 13
    //   1542: iload 6
    //   1544: istore 9
    //   1546: aload 22
    //   1548: astore 18
    //   1550: iload 6
    //   1552: istore 7
    //   1554: aload 23
    //   1556: astore 15
    //   1558: iload 6
    //   1560: istore 10
    //   1562: aload 24
    //   1564: astore 19
    //   1566: aload 25
    //   1568: astore 16
    //   1570: aload 12
    //   1572: astore 20
    //   1574: aload 26
    //   1576: getstatic 376	com/amazonaws/util/AWSRequestMetrics$Field:RetryPauseTime	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   1579: invokevirtual 351	com/amazonaws/util/AWSRequestMetrics:endEvent	(Lcom/amazonaws/metrics/MetricType;)V
    //   1582: iload 6
    //   1584: istore 9
    //   1586: aload 22
    //   1588: astore 18
    //   1590: iload 6
    //   1592: istore 7
    //   1594: aload 23
    //   1596: astore 15
    //   1598: iload 6
    //   1600: istore 10
    //   1602: aload 24
    //   1604: astore 19
    //   1606: aload 25
    //   1608: astore 16
    //   1610: aload 12
    //   1612: astore 20
    //   1614: aload 13
    //   1616: athrow
    //   1617: iload 6
    //   1619: istore 9
    //   1621: aload 22
    //   1623: astore 18
    //   1625: iload 6
    //   1627: istore 7
    //   1629: aload 23
    //   1631: astore 15
    //   1633: iload 6
    //   1635: istore 10
    //   1637: aload 24
    //   1639: astore 19
    //   1641: aload 25
    //   1643: astore 16
    //   1645: aload 12
    //   1647: astore 20
    //   1649: aload 13
    //   1651: invokevirtual 395	java/io/InputStream:markSupported	()Z
    //   1654: ifeq -843 -> 811
    //   1657: iload 6
    //   1659: istore 9
    //   1661: aload 22
    //   1663: astore 18
    //   1665: iload 6
    //   1667: istore 7
    //   1669: aload 23
    //   1671: astore 15
    //   1673: iload 6
    //   1675: istore 10
    //   1677: aload 24
    //   1679: astore 19
    //   1681: aload 25
    //   1683: astore 16
    //   1685: aload 12
    //   1687: astore 20
    //   1689: aload 13
    //   1691: iconst_m1
    //   1692: invokevirtual 401	java/io/InputStream:mark	(I)V
    //   1695: goto -884 -> 811
    //   1698: astore_1
    //   1699: aload 18
    //   1701: astore 13
    //   1703: iload 9
    //   1705: istore 7
    //   1707: aload 13
    //   1709: astore 15
    //   1711: aload_0
    //   1712: aload_1
    //   1713: aload 26
    //   1715: invokespecial 496	com/amazonaws/http/AmazonHttpClient:handleUnexpectedFailure	(Ljava/lang/Throwable;Lcom/amazonaws/util/AWSRequestMetrics;)Ljava/lang/Throwable;
    //   1718: checkcast 268	java/lang/RuntimeException
    //   1721: athrow
    //   1722: astore_1
    //   1723: aload 15
    //   1725: astore 13
    //   1727: goto -239 -> 1488
    //   1730: astore 13
    //   1732: iload 6
    //   1734: istore 9
    //   1736: aload 22
    //   1738: astore 18
    //   1740: iload 6
    //   1742: istore 7
    //   1744: aload 23
    //   1746: astore 15
    //   1748: iload 6
    //   1750: istore 10
    //   1752: aload 24
    //   1754: astore 19
    //   1756: aload 25
    //   1758: astore 16
    //   1760: aload 12
    //   1762: astore 20
    //   1764: aload 26
    //   1766: getstatic 426	com/amazonaws/util/AWSRequestMetrics$Field:HttpRequestTime	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   1769: invokevirtual 351	com/amazonaws/util/AWSRequestMetrics:endEvent	(Lcom/amazonaws/metrics/MetricType;)V
    //   1772: iload 6
    //   1774: istore 9
    //   1776: aload 22
    //   1778: astore 18
    //   1780: iload 6
    //   1782: istore 7
    //   1784: aload 23
    //   1786: astore 15
    //   1788: iload 6
    //   1790: istore 10
    //   1792: aload 24
    //   1794: astore 19
    //   1796: aload 25
    //   1798: astore 16
    //   1800: aload 12
    //   1802: astore 20
    //   1804: aload 13
    //   1806: athrow
    //   1807: astore_1
    //   1808: aload 19
    //   1810: astore 13
    //   1812: iload 10
    //   1814: istore 7
    //   1816: aload 13
    //   1818: astore 15
    //   1820: aload_0
    //   1821: aload_1
    //   1822: aload 26
    //   1824: invokespecial 496	com/amazonaws/http/AmazonHttpClient:handleUnexpectedFailure	(Ljava/lang/Throwable;Lcom/amazonaws/util/AWSRequestMetrics;)Ljava/lang/Throwable;
    //   1827: checkcast 270	java/lang/Error
    //   1830: athrow
    //   1831: astore_1
    //   1832: getstatic 37	com/amazonaws/http/AmazonHttpClient:log	Lorg/apache/commons/logging/Log;
    //   1835: ldc_w 498
    //   1838: aload_1
    //   1839: invokeinterface 500 3 0
    //   1844: aload 15
    //   1846: areturn
    //   1847: iload 6
    //   1849: istore 9
    //   1851: aload 13
    //   1853: astore 18
    //   1855: iload 6
    //   1857: istore 7
    //   1859: aload 13
    //   1861: astore 15
    //   1863: iload 6
    //   1865: istore 10
    //   1867: aload 13
    //   1869: astore 19
    //   1871: aload 13
    //   1873: astore 16
    //   1875: aload 12
    //   1877: astore 20
    //   1879: aload 13
    //   1881: invokestatic 503	com/amazonaws/http/AmazonHttpClient:isTemporaryRedirect	(Lcom/amazonaws/org/apache/http/HttpResponse;)Z
    //   1884: ifeq +424 -> 2308
    //   1887: iload 6
    //   1889: istore 9
    //   1891: aload 13
    //   1893: astore 18
    //   1895: iload 6
    //   1897: istore 7
    //   1899: aload 13
    //   1901: astore 15
    //   1903: iload 6
    //   1905: istore 10
    //   1907: aload 13
    //   1909: astore 19
    //   1911: aload 13
    //   1913: astore 16
    //   1915: aload 12
    //   1917: astore 20
    //   1919: aload 13
    //   1921: ldc_w 505
    //   1924: invokeinterface 508 2 0
    //   1929: iconst_0
    //   1930: aaload
    //   1931: invokeinterface 247 1 0
    //   1936: astore 22
    //   1938: iload 6
    //   1940: istore 9
    //   1942: aload 13
    //   1944: astore 18
    //   1946: iload 6
    //   1948: istore 7
    //   1950: aload 13
    //   1952: astore 15
    //   1954: iload 6
    //   1956: istore 10
    //   1958: aload 13
    //   1960: astore 19
    //   1962: aload 13
    //   1964: astore 16
    //   1966: aload 12
    //   1968: astore 20
    //   1970: getstatic 37	com/amazonaws/http/AmazonHttpClient:log	Lorg/apache/commons/logging/Log;
    //   1973: new 79	java/lang/StringBuilder
    //   1976: dup
    //   1977: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1980: ldc_w 510
    //   1983: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1986: aload 22
    //   1988: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1991: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1994: invokeinterface 360 2 0
    //   1999: iload 6
    //   2001: istore 9
    //   2003: aload 13
    //   2005: astore 18
    //   2007: iload 6
    //   2009: istore 7
    //   2011: aload 13
    //   2013: astore 15
    //   2015: iload 6
    //   2017: istore 10
    //   2019: aload 13
    //   2021: astore 19
    //   2023: aload 13
    //   2025: astore 16
    //   2027: aload 12
    //   2029: astore 20
    //   2031: aload 22
    //   2033: invokestatic 516	java/net/URI:create	(Ljava/lang/String;)Ljava/net/URI;
    //   2036: astore 12
    //   2038: iload 6
    //   2040: istore 9
    //   2042: aload 13
    //   2044: astore 18
    //   2046: iload 6
    //   2048: istore 7
    //   2050: aload 13
    //   2052: astore 15
    //   2054: iload 6
    //   2056: istore 10
    //   2058: aload 13
    //   2060: astore 19
    //   2062: aload 13
    //   2064: astore 16
    //   2066: aload 12
    //   2068: astore 20
    //   2070: aload 17
    //   2072: aload 12
    //   2074: invokevirtual 373	com/amazonaws/org/apache/http/client/methods/HttpRequestBase:setURI	(Ljava/net/URI;)V
    //   2077: iload 6
    //   2079: istore 9
    //   2081: aload 13
    //   2083: astore 18
    //   2085: iload 6
    //   2087: istore 7
    //   2089: aload 13
    //   2091: astore 15
    //   2093: iload 6
    //   2095: istore 10
    //   2097: aload 13
    //   2099: astore 19
    //   2101: aload 13
    //   2103: astore 16
    //   2105: aload 12
    //   2107: astore 20
    //   2109: aload 26
    //   2111: getstatic 437	com/amazonaws/util/AWSRequestMetrics$Field:StatusCode	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   2114: aload 13
    //   2116: invokeinterface 220 1 0
    //   2121: invokeinterface 225 1 0
    //   2126: invokestatic 443	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2129: invokevirtual 288	com/amazonaws/util/AWSRequestMetrics:addProperty	(Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
    //   2132: iload 6
    //   2134: istore 9
    //   2136: aload 13
    //   2138: astore 18
    //   2140: iload 6
    //   2142: istore 7
    //   2144: aload 13
    //   2146: astore 15
    //   2148: iload 6
    //   2150: istore 10
    //   2152: aload 13
    //   2154: astore 19
    //   2156: aload 13
    //   2158: astore 16
    //   2160: aload 12
    //   2162: astore 20
    //   2164: aload 26
    //   2166: getstatic 519	com/amazonaws/util/AWSRequestMetrics$Field:RedirectLocation	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   2169: aload 22
    //   2171: invokevirtual 288	com/amazonaws/util/AWSRequestMetrics:addProperty	(Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
    //   2174: iload 6
    //   2176: istore 9
    //   2178: aload 13
    //   2180: astore 18
    //   2182: iload 6
    //   2184: istore 7
    //   2186: aload 13
    //   2188: astore 15
    //   2190: iload 6
    //   2192: istore 10
    //   2194: aload 13
    //   2196: astore 19
    //   2198: aload 13
    //   2200: astore 16
    //   2202: aload 12
    //   2204: astore 20
    //   2206: aload 26
    //   2208: getstatic 483	com/amazonaws/util/AWSRequestMetrics$Field:AWSRequestID	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   2211: aconst_null
    //   2212: invokevirtual 288	com/amazonaws/util/AWSRequestMetrics:addProperty	(Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
    //   2215: aload 21
    //   2217: astore 15
    //   2219: iload 6
    //   2221: ifne +808 -> 3029
    //   2224: aload 13
    //   2226: ifnull +43 -> 2269
    //   2229: aload 13
    //   2231: invokeinterface 206 1 0
    //   2236: ifnull +33 -> 2269
    //   2239: aload 13
    //   2241: invokeinterface 206 1 0
    //   2246: invokeinterface 212 1 0
    //   2251: ifnull +18 -> 2269
    //   2254: aload 13
    //   2256: invokeinterface 206 1 0
    //   2261: invokeinterface 212 1 0
    //   2266: invokevirtual 462	java/io/InputStream:close	()V
    //   2269: aload 15
    //   2271: astore 18
    //   2273: iload 6
    //   2275: istore 7
    //   2277: aload 12
    //   2279: astore 16
    //   2281: aload 11
    //   2283: astore 13
    //   2285: aload 16
    //   2287: astore 12
    //   2289: iload 7
    //   2291: istore 6
    //   2293: aload 13
    //   2295: astore 11
    //   2297: aload 14
    //   2299: astore 16
    //   2301: aload 18
    //   2303: astore 13
    //   2305: goto -2196 -> 109
    //   2308: iload 6
    //   2310: istore 9
    //   2312: aload 13
    //   2314: astore 18
    //   2316: iload 6
    //   2318: istore 7
    //   2320: aload 13
    //   2322: astore 15
    //   2324: iload 6
    //   2326: istore 10
    //   2328: aload 13
    //   2330: astore 19
    //   2332: aload 13
    //   2334: astore 16
    //   2336: aload 12
    //   2338: astore 20
    //   2340: aload_3
    //   2341: invokeinterface 448 1 0
    //   2346: istore 8
    //   2348: iload 8
    //   2350: istore 6
    //   2352: iload 6
    //   2354: istore 9
    //   2356: aload 13
    //   2358: astore 18
    //   2360: iload 6
    //   2362: istore 7
    //   2364: aload 13
    //   2366: astore 15
    //   2368: iload 6
    //   2370: istore 10
    //   2372: aload 13
    //   2374: astore 19
    //   2376: aload_0
    //   2377: aload_1
    //   2378: aload_3
    //   2379: aload 17
    //   2381: aload 13
    //   2383: invokespecial 523	com/amazonaws/http/AmazonHttpClient:handleErrorResponse	(Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/org/apache/http/client/methods/HttpRequestBase;Lcom/amazonaws/org/apache/http/HttpResponse;)Lcom/amazonaws/AmazonServiceException;
    //   2386: astore 16
    //   2388: iload 6
    //   2390: istore 9
    //   2392: aload 13
    //   2394: astore 18
    //   2396: iload 6
    //   2398: istore 7
    //   2400: aload 13
    //   2402: astore 15
    //   2404: iload 6
    //   2406: istore 10
    //   2408: aload 13
    //   2410: astore 19
    //   2412: aload 26
    //   2414: getstatic 483	com/amazonaws/util/AWSRequestMetrics$Field:AWSRequestID	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   2417: aload 16
    //   2419: invokevirtual 528	com/amazonaws/AmazonServiceException:getRequestId	()Ljava/lang/String;
    //   2422: invokevirtual 288	com/amazonaws/util/AWSRequestMetrics:addProperty	(Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
    //   2425: iload 6
    //   2427: istore 9
    //   2429: aload 13
    //   2431: astore 18
    //   2433: iload 6
    //   2435: istore 7
    //   2437: aload 13
    //   2439: astore 15
    //   2441: iload 6
    //   2443: istore 10
    //   2445: aload 13
    //   2447: astore 19
    //   2449: aload 26
    //   2451: getstatic 531	com/amazonaws/util/AWSRequestMetrics$Field:AWSErrorCode	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   2454: aload 16
    //   2456: invokevirtual 534	com/amazonaws/AmazonServiceException:getErrorCode	()Ljava/lang/String;
    //   2459: invokevirtual 288	com/amazonaws/util/AWSRequestMetrics:addProperty	(Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
    //   2462: iload 6
    //   2464: istore 9
    //   2466: aload 13
    //   2468: astore 18
    //   2470: iload 6
    //   2472: istore 7
    //   2474: aload 13
    //   2476: astore 15
    //   2478: iload 6
    //   2480: istore 10
    //   2482: aload 13
    //   2484: astore 19
    //   2486: aload 26
    //   2488: getstatic 437	com/amazonaws/util/AWSRequestMetrics$Field:StatusCode	Lcom/amazonaws/util/AWSRequestMetrics$Field;
    //   2491: aload 16
    //   2493: invokevirtual 535	com/amazonaws/AmazonServiceException:getStatusCode	()I
    //   2496: invokestatic 443	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2499: invokevirtual 288	com/amazonaws/util/AWSRequestMetrics:addProperty	(Lcom/amazonaws/metrics/MetricType;Ljava/lang/Object;)V
    //   2502: iload 6
    //   2504: istore 9
    //   2506: aload 13
    //   2508: astore 18
    //   2510: iload 6
    //   2512: istore 7
    //   2514: aload 13
    //   2516: astore 15
    //   2518: iload 6
    //   2520: istore 10
    //   2522: aload 13
    //   2524: astore 19
    //   2526: aload_0
    //   2527: aload_1
    //   2528: invokeinterface 380 1 0
    //   2533: aload 17
    //   2535: aload 16
    //   2537: iload 5
    //   2539: aload_0
    //   2540: getfield 119	com/amazonaws/http/AmazonHttpClient:config	Lcom/amazonaws/ClientConfiguration;
    //   2543: invokevirtual 386	com/amazonaws/ClientConfiguration:getRetryPolicy	()Lcom/amazonaws/retry/RetryPolicy;
    //   2546: invokespecial 492	com/amazonaws/http/AmazonHttpClient:shouldRetry	(Lcom/amazonaws/AmazonWebServiceRequest;Lcom/amazonaws/org/apache/http/client/methods/HttpRequestBase;Lcom/amazonaws/AmazonClientException;ILcom/amazonaws/retry/RetryPolicy;)Z
    //   2549: ifne +30 -> 2579
    //   2552: iload 6
    //   2554: istore 9
    //   2556: aload 13
    //   2558: astore 18
    //   2560: iload 6
    //   2562: istore 7
    //   2564: aload 13
    //   2566: astore 15
    //   2568: iload 6
    //   2570: istore 10
    //   2572: aload 13
    //   2574: astore 19
    //   2576: aload 16
    //   2578: athrow
    //   2579: iload 6
    //   2581: istore 9
    //   2583: aload 13
    //   2585: astore 18
    //   2587: iload 6
    //   2589: istore 7
    //   2591: aload 13
    //   2593: astore 15
    //   2595: iload 6
    //   2597: istore 10
    //   2599: aload 13
    //   2601: astore 19
    //   2603: aload 16
    //   2605: invokestatic 541	com/amazonaws/retry/RetryUtils:isClockSkewError	(Lcom/amazonaws/AmazonServiceException;)Z
    //   2608: ifeq +38 -> 2646
    //   2611: iload 6
    //   2613: istore 9
    //   2615: aload 13
    //   2617: astore 18
    //   2619: iload 6
    //   2621: istore 7
    //   2623: aload 13
    //   2625: astore 15
    //   2627: iload 6
    //   2629: istore 10
    //   2631: aload 13
    //   2633: astore 19
    //   2635: aload_0
    //   2636: aload 13
    //   2638: aload 16
    //   2640: invokespecial 545	com/amazonaws/http/AmazonHttpClient:parseClockSkewOffset	(Lcom/amazonaws/org/apache/http/HttpResponse;Lcom/amazonaws/AmazonServiceException;)I
    //   2643: invokestatic 550	com/amazonaws/SDKGlobalConfiguration:setGlobalTimeOffset	(I)V
    //   2646: iload 6
    //   2648: istore 9
    //   2650: aload 13
    //   2652: astore 18
    //   2654: iload 6
    //   2656: istore 7
    //   2658: aload 13
    //   2660: astore 15
    //   2662: iload 6
    //   2664: istore 10
    //   2666: aload 13
    //   2668: astore 19
    //   2670: aload_0
    //   2671: aload_1
    //   2672: aload 16
    //   2674: invokespecial 554	com/amazonaws/http/AmazonHttpClient:resetRequestAfterError	(Lcom/amazonaws/Request;Ljava/lang/Exception;)V
    //   2677: aload 16
    //   2679: astore 15
    //   2681: goto -462 -> 2219
    //   2684: astore 13
    //   2686: getstatic 37	com/amazonaws/http/AmazonHttpClient:log	Lorg/apache/commons/logging/Log;
    //   2689: ldc_w 498
    //   2692: aload 13
    //   2694: invokeinterface 500 3 0
    //   2699: aload 11
    //   2701: astore 13
    //   2703: aload 12
    //   2705: astore 16
    //   2707: iload 6
    //   2709: istore 7
    //   2711: aload 15
    //   2713: astore 18
    //   2715: goto -430 -> 2285
    //   2718: aload_0
    //   2719: aload_1
    //   2720: aload 14
    //   2722: invokespecial 554	com/amazonaws/http/AmazonHttpClient:resetRequestAfterError	(Lcom/amazonaws/Request;Ljava/lang/Exception;)V
    //   2725: aload 11
    //   2727: astore 13
    //   2729: aload 15
    //   2731: astore 14
    //   2733: aload 12
    //   2735: astore 16
    //   2737: iload 6
    //   2739: istore 7
    //   2741: aload 19
    //   2743: astore 18
    //   2745: iload 6
    //   2747: ifne -462 -> 2285
    //   2750: aload 11
    //   2752: astore 13
    //   2754: aload 15
    //   2756: astore 14
    //   2758: aload 12
    //   2760: astore 16
    //   2762: iload 6
    //   2764: istore 7
    //   2766: aload 19
    //   2768: astore 18
    //   2770: aload 17
    //   2772: ifnull -487 -> 2285
    //   2775: aload 11
    //   2777: astore 13
    //   2779: aload 15
    //   2781: astore 14
    //   2783: aload 12
    //   2785: astore 16
    //   2787: iload 6
    //   2789: istore 7
    //   2791: aload 19
    //   2793: astore 18
    //   2795: aload 17
    //   2797: invokeinterface 206 1 0
    //   2802: ifnull -517 -> 2285
    //   2805: aload 11
    //   2807: astore 13
    //   2809: aload 15
    //   2811: astore 14
    //   2813: aload 12
    //   2815: astore 16
    //   2817: iload 6
    //   2819: istore 7
    //   2821: aload 19
    //   2823: astore 18
    //   2825: aload 17
    //   2827: invokeinterface 206 1 0
    //   2832: invokeinterface 212 1 0
    //   2837: ifnull -552 -> 2285
    //   2840: aload 17
    //   2842: invokeinterface 206 1 0
    //   2847: invokeinterface 212 1 0
    //   2852: invokevirtual 462	java/io/InputStream:close	()V
    //   2855: aload 11
    //   2857: astore 13
    //   2859: aload 15
    //   2861: astore 14
    //   2863: aload 12
    //   2865: astore 16
    //   2867: iload 6
    //   2869: istore 7
    //   2871: aload 19
    //   2873: astore 18
    //   2875: goto -590 -> 2285
    //   2878: astore 13
    //   2880: getstatic 37	com/amazonaws/http/AmazonHttpClient:log	Lorg/apache/commons/logging/Log;
    //   2883: ldc_w 498
    //   2886: aload 13
    //   2888: invokeinterface 500 3 0
    //   2893: aload 11
    //   2895: astore 13
    //   2897: aload 15
    //   2899: astore 14
    //   2901: aload 12
    //   2903: astore 16
    //   2905: iload 6
    //   2907: istore 7
    //   2909: aload 19
    //   2911: astore 18
    //   2913: goto -628 -> 2285
    //   2916: astore_2
    //   2917: getstatic 37	com/amazonaws/http/AmazonHttpClient:log	Lorg/apache/commons/logging/Log;
    //   2920: ldc_w 498
    //   2923: aload_2
    //   2924: invokeinterface 500 3 0
    //   2929: goto -1391 -> 1538
    //   2932: astore_1
    //   2933: iload 8
    //   2935: istore 7
    //   2937: goto -1449 -> 1488
    //   2940: astore_1
    //   2941: iload 8
    //   2943: istore 7
    //   2945: goto -1129 -> 1816
    //   2948: astore_1
    //   2949: iload 8
    //   2951: istore 7
    //   2953: goto -1246 -> 1707
    //   2956: astore 14
    //   2958: aload 16
    //   2960: astore 15
    //   2962: aload 20
    //   2964: astore 17
    //   2966: aload 21
    //   2968: astore 13
    //   2970: goto -1627 -> 1343
    //   2973: astore 14
    //   2975: aload 17
    //   2977: astore 13
    //   2979: aload 16
    //   2981: astore 15
    //   2983: aload 20
    //   2985: astore 17
    //   2987: goto -1644 -> 1343
    //   2990: astore 18
    //   2992: aload 17
    //   2994: astore 16
    //   2996: iload 8
    //   2998: istore 6
    //   3000: aload 14
    //   3002: astore 15
    //   3004: aload 18
    //   3006: astore 14
    //   3008: aload 13
    //   3010: astore 17
    //   3012: aload 16
    //   3014: astore 13
    //   3016: goto -1673 -> 1343
    //   3019: aload 16
    //   3021: astore 14
    //   3023: goto -2530 -> 493
    //   3026: goto -2814 -> 212
    //   3029: aload 11
    //   3031: astore 13
    //   3033: aload 12
    //   3035: astore 16
    //   3037: iload 6
    //   3039: istore 7
    //   3041: aload 15
    //   3043: astore 18
    //   3045: goto -760 -> 2285
    //   3048: astore 18
    //   3050: aload 17
    //   3052: astore 13
    //   3054: aload 20
    //   3056: astore 12
    //   3058: aload 14
    //   3060: astore 15
    //   3062: aload 18
    //   3064: astore 14
    //   3066: aload 16
    //   3068: astore 17
    //   3070: goto -1727 -> 1343
    //   3073: astore 18
    //   3075: aload 17
    //   3077: astore 16
    //   3079: aload 14
    //   3081: astore 15
    //   3083: aload 18
    //   3085: astore 14
    //   3087: aload 13
    //   3089: astore 17
    //   3091: aload 16
    //   3093: astore 13
    //   3095: goto -1752 -> 1343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3098	0	this	AmazonHttpClient
    //   0	3098	1	paramRequest	Request<?>
    //   0	3098	2	paramHttpResponseHandler	HttpResponseHandler<AmazonWebServiceResponse<T>>
    //   0	3098	3	paramHttpResponseHandler1	HttpResponseHandler<AmazonServiceException>
    //   0	3098	4	paramExecutionContext	ExecutionContext
    //   41	2497	5	i	int
    //   107	2931	6	j	int
    //   181	2859	7	k	int
    //   1177	1820	8	bool	boolean
    //   173	2476	9	m	int
    //   189	2476	10	n	int
    //   101	2929	11	localObject1	Object
    //   104	2953	12	localObject2	Object
    //   47	1204	13	localObject3	Object
    //   1268	59	13	localObject4	Object
    //   1333	191	13	localObject5	Object
    //   1540	150	13	localObject6	Object
    //   1701	25	13	localObject7	Object
    //   1730	75	13	localObject8	Object
    //   1810	857	13	localObject9	Object
    //   2684	9	13	localIOException1	IOException
    //   2701	157	13	localObject10	Object
    //   2878	9	13	localIOException2	IOException
    //   2895	199	13	localObject11	Object
    //   206	476	14	localObject12	Object
    //   1329	1392	14	localIOException3	IOException
    //   2731	169	14	localObject13	Object
    //   2956	1	14	localIOException4	IOException
    //   2973	28	14	localIOException5	IOException
    //   3006	80	14	localObject14	Object
    //   185	2897	15	localObject15	Object
    //   44	3048	16	localObject16	Object
    //   423	2667	17	localObject17	Object
    //   177	2735	18	localObject18	Object
    //   2990	15	18	localIOException6	IOException
    //   3043	1	18	localObject19	Object
    //   3048	15	18	localIOException7	IOException
    //   3073	11	18	localIOException8	IOException
    //   193	2717	19	localObject20	Object
    //   164	2891	20	localObject21	Object
    //   149	2818	21	localObject22	Object
    //   152	2018	22	str	String
    //   155	1630	23	localObject23	Object
    //   158	1635	24	localObject24	Object
    //   161	1636	25	localObject25	Object
    //   5	2482	26	localAWSRequestMetrics	AWSRequestMetrics
    //   56	78	27	localLinkedHashMap	java.util.LinkedHashMap
    //   78	64	28	localHashMap	java.util.HashMap
    //   98	160	29	localAWSCredentials	com.amazonaws.auth.AWSCredentials
    // Exception table:
    //   from	to	target	type
    //   254	264	1268	finally
    //   246	254	1329	java/io/IOException
    //   288	296	1329	java/io/IOException
    //   320	331	1329	java/io/IOException
    //   355	386	1329	java/io/IOException
    //   410	425	1329	java/io/IOException
    //   1294	1302	1329	java/io/IOException
    //   1326	1329	1329	java/io/IOException
    //   1343	1388	1479	finally
    //   1388	1479	1479	finally
    //   2718	2725	1479	finally
    //   583	604	1540	finally
    //   195	208	1698	java/lang/RuntimeException
    //   246	254	1698	java/lang/RuntimeException
    //   288	296	1698	java/lang/RuntimeException
    //   320	331	1698	java/lang/RuntimeException
    //   355	386	1698	java/lang/RuntimeException
    //   410	425	1698	java/lang/RuntimeException
    //   449	457	1698	java/lang/RuntimeException
    //   481	493	1698	java/lang/RuntimeException
    //   530	537	1698	java/lang/RuntimeException
    //   575	583	1698	java/lang/RuntimeException
    //   636	644	1698	java/lang/RuntimeException
    //   681	690	1698	java/lang/RuntimeException
    //   728	736	1698	java/lang/RuntimeException
    //   768	773	1698	java/lang/RuntimeException
    //   805	811	1698	java/lang/RuntimeException
    //   843	858	1698	java/lang/RuntimeException
    //   890	899	1698	java/lang/RuntimeException
    //   931	945	1698	java/lang/RuntimeException
    //   980	988	1698	java/lang/RuntimeException
    //   1035	1043	1698	java/lang/RuntimeException
    //   1075	1084	1698	java/lang/RuntimeException
    //   1116	1139	1698	java/lang/RuntimeException
    //   1171	1179	1698	java/lang/RuntimeException
    //   1294	1302	1698	java/lang/RuntimeException
    //   1326	1329	1698	java/lang/RuntimeException
    //   1574	1582	1698	java/lang/RuntimeException
    //   1614	1617	1698	java/lang/RuntimeException
    //   1649	1657	1698	java/lang/RuntimeException
    //   1689	1695	1698	java/lang/RuntimeException
    //   1764	1772	1698	java/lang/RuntimeException
    //   1804	1807	1698	java/lang/RuntimeException
    //   1879	1887	1698	java/lang/RuntimeException
    //   1919	1938	1698	java/lang/RuntimeException
    //   1970	1999	1698	java/lang/RuntimeException
    //   2031	2038	1698	java/lang/RuntimeException
    //   2070	2077	1698	java/lang/RuntimeException
    //   2109	2132	1698	java/lang/RuntimeException
    //   2164	2174	1698	java/lang/RuntimeException
    //   2206	2215	1698	java/lang/RuntimeException
    //   2340	2348	1698	java/lang/RuntimeException
    //   2376	2388	1698	java/lang/RuntimeException
    //   2412	2425	1698	java/lang/RuntimeException
    //   2449	2462	1698	java/lang/RuntimeException
    //   2486	2502	1698	java/lang/RuntimeException
    //   2526	2552	1698	java/lang/RuntimeException
    //   2576	2579	1698	java/lang/RuntimeException
    //   2603	2611	1698	java/lang/RuntimeException
    //   2635	2646	1698	java/lang/RuntimeException
    //   2670	2677	1698	java/lang/RuntimeException
    //   195	208	1722	finally
    //   246	254	1722	finally
    //   288	296	1722	finally
    //   320	331	1722	finally
    //   355	386	1722	finally
    //   410	425	1722	finally
    //   449	457	1722	finally
    //   481	493	1722	finally
    //   530	537	1722	finally
    //   575	583	1722	finally
    //   636	644	1722	finally
    //   681	690	1722	finally
    //   728	736	1722	finally
    //   768	773	1722	finally
    //   805	811	1722	finally
    //   843	858	1722	finally
    //   890	899	1722	finally
    //   931	945	1722	finally
    //   980	988	1722	finally
    //   1035	1043	1722	finally
    //   1075	1084	1722	finally
    //   1116	1139	1722	finally
    //   1171	1179	1722	finally
    //   1294	1302	1722	finally
    //   1326	1329	1722	finally
    //   1574	1582	1722	finally
    //   1614	1617	1722	finally
    //   1649	1657	1722	finally
    //   1689	1695	1722	finally
    //   1711	1722	1722	finally
    //   1764	1772	1722	finally
    //   1804	1807	1722	finally
    //   1820	1831	1722	finally
    //   1879	1887	1722	finally
    //   1919	1938	1722	finally
    //   1970	1999	1722	finally
    //   2031	2038	1722	finally
    //   2070	2077	1722	finally
    //   2109	2132	1722	finally
    //   2164	2174	1722	finally
    //   2206	2215	1722	finally
    //   2340	2348	1722	finally
    //   2376	2388	1722	finally
    //   2412	2425	1722	finally
    //   2449	2462	1722	finally
    //   2486	2502	1722	finally
    //   2526	2552	1722	finally
    //   2576	2579	1722	finally
    //   2603	2611	1722	finally
    //   2635	2646	1722	finally
    //   2670	2677	1722	finally
    //   988	1003	1730	finally
    //   195	208	1807	java/lang/Error
    //   246	254	1807	java/lang/Error
    //   288	296	1807	java/lang/Error
    //   320	331	1807	java/lang/Error
    //   355	386	1807	java/lang/Error
    //   410	425	1807	java/lang/Error
    //   449	457	1807	java/lang/Error
    //   481	493	1807	java/lang/Error
    //   530	537	1807	java/lang/Error
    //   575	583	1807	java/lang/Error
    //   636	644	1807	java/lang/Error
    //   681	690	1807	java/lang/Error
    //   728	736	1807	java/lang/Error
    //   768	773	1807	java/lang/Error
    //   805	811	1807	java/lang/Error
    //   843	858	1807	java/lang/Error
    //   890	899	1807	java/lang/Error
    //   931	945	1807	java/lang/Error
    //   980	988	1807	java/lang/Error
    //   1035	1043	1807	java/lang/Error
    //   1075	1084	1807	java/lang/Error
    //   1116	1139	1807	java/lang/Error
    //   1171	1179	1807	java/lang/Error
    //   1294	1302	1807	java/lang/Error
    //   1326	1329	1807	java/lang/Error
    //   1574	1582	1807	java/lang/Error
    //   1614	1617	1807	java/lang/Error
    //   1649	1657	1807	java/lang/Error
    //   1689	1695	1807	java/lang/Error
    //   1764	1772	1807	java/lang/Error
    //   1804	1807	1807	java/lang/Error
    //   1879	1887	1807	java/lang/Error
    //   1919	1938	1807	java/lang/Error
    //   1970	1999	1807	java/lang/Error
    //   2031	2038	1807	java/lang/Error
    //   2070	2077	1807	java/lang/Error
    //   2109	2132	1807	java/lang/Error
    //   2164	2174	1807	java/lang/Error
    //   2206	2215	1807	java/lang/Error
    //   2340	2348	1807	java/lang/Error
    //   2376	2388	1807	java/lang/Error
    //   2412	2425	1807	java/lang/Error
    //   2449	2462	1807	java/lang/Error
    //   2486	2502	1807	java/lang/Error
    //   2526	2552	1807	java/lang/Error
    //   2576	2579	1807	java/lang/Error
    //   2603	2611	1807	java/lang/Error
    //   2635	2646	1807	java/lang/Error
    //   2670	2677	1807	java/lang/Error
    //   1225	1265	1831	java/io/IOException
    //   2229	2269	2684	java/io/IOException
    //   2795	2805	2878	java/io/IOException
    //   2825	2855	2878	java/io/IOException
    //   1498	1538	2916	java/io/IOException
    //   1179	1215	2932	finally
    //   1179	1215	2940	java/lang/Error
    //   1179	1215	2948	java/lang/RuntimeException
    //   195	208	2956	java/io/IOException
    //   449	457	2973	java/io/IOException
    //   481	493	2973	java/io/IOException
    //   1179	1215	2990	java/io/IOException
    //   530	537	3048	java/io/IOException
    //   575	583	3048	java/io/IOException
    //   636	644	3048	java/io/IOException
    //   681	690	3048	java/io/IOException
    //   728	736	3048	java/io/IOException
    //   768	773	3048	java/io/IOException
    //   805	811	3048	java/io/IOException
    //   843	858	3048	java/io/IOException
    //   890	899	3048	java/io/IOException
    //   931	945	3048	java/io/IOException
    //   980	988	3048	java/io/IOException
    //   1035	1043	3048	java/io/IOException
    //   1075	1084	3048	java/io/IOException
    //   1116	1139	3048	java/io/IOException
    //   1171	1179	3048	java/io/IOException
    //   1574	1582	3048	java/io/IOException
    //   1614	1617	3048	java/io/IOException
    //   1649	1657	3048	java/io/IOException
    //   1689	1695	3048	java/io/IOException
    //   1764	1772	3048	java/io/IOException
    //   1804	1807	3048	java/io/IOException
    //   1879	1887	3048	java/io/IOException
    //   1919	1938	3048	java/io/IOException
    //   1970	1999	3048	java/io/IOException
    //   2031	2038	3048	java/io/IOException
    //   2070	2077	3048	java/io/IOException
    //   2109	2132	3048	java/io/IOException
    //   2164	2174	3048	java/io/IOException
    //   2206	2215	3048	java/io/IOException
    //   2340	2348	3048	java/io/IOException
    //   2376	2388	3073	java/io/IOException
    //   2412	2425	3073	java/io/IOException
    //   2449	2462	3073	java/io/IOException
    //   2486	2502	3073	java/io/IOException
    //   2526	2552	3073	java/io/IOException
    //   2576	2579	3073	java/io/IOException
    //   2603	2611	3073	java/io/IOException
    //   2635	2646	3073	java/io/IOException
    //   2670	2677	3073	java/io/IOException
  }
  
  private String getServerDateFromException(String paramString)
  {
    int j = paramString.indexOf("(");
    if (paramString.contains(" + 15")) {}
    for (int i = paramString.indexOf(" + 15");; i = paramString.indexOf(" - 15")) {
      return paramString.substring(j + 1, i);
    }
  }
  
  private AmazonServiceException handleErrorResponse(Request<?> paramRequest, HttpResponseHandler<AmazonServiceException> paramHttpResponseHandler, HttpRequestBase paramHttpRequestBase, com.amazonaws.org.apache.http.HttpResponse paramHttpResponse)
  {
    int i = paramHttpResponse.getStatusLine().getStatusCode();
    HttpResponse localHttpResponse = createResponse(paramHttpRequestBase, paramRequest, paramHttpResponse);
    if ((paramHttpResponseHandler.needsConnectionLeftOpen()) && ((paramHttpRequestBase instanceof HttpEntityEnclosingRequestBase))) {
      localHttpResponse.setContent(new HttpMethodReleaseInputStream((HttpEntityEnclosingRequestBase)paramHttpRequestBase));
    }
    try
    {
      paramHttpResponseHandler = (AmazonServiceException)paramHttpResponseHandler.handle(localHttpResponse);
      requestLog.debug("Received error response: " + paramHttpResponseHandler.toString());
      paramHttpResponseHandler.setStatusCode(i);
      paramHttpResponseHandler.setServiceName(paramRequest.getServiceName());
      paramHttpResponseHandler.fillInStackTrace();
      return paramHttpResponseHandler;
    }
    catch (Exception paramHttpResponseHandler)
    {
      for (;;)
      {
        if (i == 413)
        {
          paramHttpResponseHandler = new AmazonServiceException("Request entity too large");
          paramHttpResponseHandler.setServiceName(paramRequest.getServiceName());
          paramHttpResponseHandler.setStatusCode(413);
          paramHttpResponseHandler.setErrorType(AmazonServiceException.ErrorType.Client);
          paramHttpResponseHandler.setErrorCode("Request entity too large");
        }
        else
        {
          if ((i != 503) || (!"Service Unavailable".equalsIgnoreCase(paramHttpResponse.getStatusLine().getReasonPhrase()))) {
            break;
          }
          paramHttpResponseHandler = new AmazonServiceException("Service unavailable");
          paramHttpResponseHandler.setServiceName(paramRequest.getServiceName());
          paramHttpResponseHandler.setStatusCode(503);
          paramHttpResponseHandler.setErrorType(AmazonServiceException.ErrorType.Service);
          paramHttpResponseHandler.setErrorCode("Service unavailable");
        }
      }
      if ((paramHttpResponseHandler instanceof IOException)) {
        throw ((IOException)paramHttpResponseHandler);
      }
      throw new AmazonClientException("Unable to unmarshall error response (" + paramHttpResponseHandler.getMessage() + "). Response Code: " + i + ", Response Text: " + paramHttpResponse.getStatusLine().getReasonPhrase(), paramHttpResponseHandler);
    }
  }
  
  private <T> T handleResponse(Request<?> paramRequest, HttpResponseHandler<AmazonWebServiceResponse<T>> paramHttpResponseHandler, HttpRequestBase paramHttpRequestBase, HttpResponse paramHttpResponse, com.amazonaws.org.apache.http.HttpResponse paramHttpResponse1, ExecutionContext paramExecutionContext)
  {
    if ((paramHttpResponseHandler.needsConnectionLeftOpen()) && ((paramHttpRequestBase instanceof HttpEntityEnclosingRequest))) {
      paramHttpResponse.setContent(new HttpMethodReleaseInputStream((HttpEntityEnclosingRequest)paramHttpRequestBase));
    }
    for (;;)
    {
      try
      {
        if (System.getProperty("com.amazonaws.sdk.enableRuntimeProfiling") != null)
        {
          paramHttpRequestBase = new CountingInputStream(paramHttpResponse.getContent());
          paramHttpResponse.setContent(paramHttpRequestBase);
          paramExecutionContext = paramExecutionContext.getAwsRequestMetrics();
          paramExecutionContext.startEvent(AWSRequestMetrics.Field.ResponseProcessingTime);
        }
        paramHttpRequestBase = null;
      }
      catch (CRC32MismatchException paramRequest)
      {
        try
        {
          paramHttpResponseHandler = (AmazonWebServiceResponse)paramHttpResponseHandler.handle(paramHttpResponse);
          paramExecutionContext.endEvent(AWSRequestMetrics.Field.ResponseProcessingTime);
          if (paramHttpRequestBase != null) {
            paramExecutionContext.setCounter(AWSRequestMetrics.Field.BytesProcessed, paramHttpRequestBase.getByteCount());
          }
          if (paramHttpResponseHandler != null) {
            continue;
          }
          throw new RuntimeException("Unable to unmarshall response metadata. Response Code: " + paramHttpResponse.getStatusCode() + ", Response Text: " + paramHttpResponse.getStatusText());
        }
        finally
        {
          paramExecutionContext.endEvent(AWSRequestMetrics.Field.ResponseProcessingTime);
        }
        paramRequest = paramRequest;
        throw paramRequest;
      }
      catch (IOException paramRequest)
      {
        throw paramRequest;
        this.responseMetadataCache.add(paramRequest.getOriginalRequest(), paramHttpResponseHandler.getResponseMetadata());
        if (requestLog.isDebugEnabled()) {
          requestLog.debug("Received successful response: " + paramHttpResponse1.getStatusLine().getStatusCode() + ", AWS Request ID: " + paramHttpResponseHandler.getRequestId());
        }
        paramExecutionContext.addProperty(AWSRequestMetrics.Field.AWSRequestID, paramHttpResponseHandler.getRequestId());
        paramRequest = paramHttpResponseHandler.getResult();
        return paramRequest;
      }
      catch (Exception paramRequest)
      {
        throw new AmazonClientException("Unable to unmarshall response (" + paramRequest.getMessage() + "). Response Code: " + paramHttpResponse.getStatusCode() + ", Response Text: " + paramHttpResponse.getStatusText(), paramRequest);
      }
    }
  }
  
  private <T extends Throwable> T handleUnexpectedFailure(T paramT, AWSRequestMetrics paramAWSRequestMetrics)
  {
    paramAWSRequestMetrics.incrementCounter(AWSRequestMetrics.Field.Exception);
    paramAWSRequestMetrics.addProperty(AWSRequestMetrics.Field.Exception, paramT);
    return paramT;
  }
  
  private boolean isRequestSuccessful(com.amazonaws.org.apache.http.HttpResponse paramHttpResponse)
  {
    return paramHttpResponse.getStatusLine().getStatusCode() / 100 == 2;
  }
  
  private static boolean isTemporaryRedirect(com.amazonaws.org.apache.http.HttpResponse paramHttpResponse)
  {
    return (paramHttpResponse.getStatusLine().getStatusCode() == 307) && (paramHttpResponse.getHeaders("Location") != null) && (paramHttpResponse.getHeaders("Location").length > 0);
  }
  
  private int parseClockSkewOffset(com.amazonaws.org.apache.http.HttpResponse paramHttpResponse, AmazonServiceException paramAmazonServiceException)
  {
    Date localDate = new Date();
    Object localObject = null;
    Header[] arrayOfHeader = paramHttpResponse.getHeaders("Date");
    paramHttpResponse = (com.amazonaws.org.apache.http.HttpResponse)localObject;
    try
    {
      if (arrayOfHeader.length == 0)
      {
        paramHttpResponse = (com.amazonaws.org.apache.http.HttpResponse)localObject;
        paramAmazonServiceException = getServerDateFromException(paramAmazonServiceException.getMessage());
        paramHttpResponse = paramAmazonServiceException;
        paramAmazonServiceException = DateUtils.parseCompressedISO8601Date(paramAmazonServiceException);
      }
      for (paramHttpResponse = paramAmazonServiceException;; paramHttpResponse = paramAmazonServiceException)
      {
        return (int)((localDate.getTime() - paramHttpResponse.getTime()) / 1000L);
        paramHttpResponse = (com.amazonaws.org.apache.http.HttpResponse)localObject;
        paramAmazonServiceException = arrayOfHeader[0].getValue();
        paramHttpResponse = paramAmazonServiceException;
        paramAmazonServiceException = DateUtils.parseRFC822Date(paramAmazonServiceException);
      }
      return 0;
    }
    catch (RuntimeException paramAmazonServiceException)
    {
      log.warn("Unable to parse clock skew offset from response: " + paramHttpResponse, paramAmazonServiceException);
    }
  }
  
  private void pauseBeforeNextRetry(AmazonWebServiceRequest paramAmazonWebServiceRequest, AmazonClientException paramAmazonClientException, int paramInt, RetryPolicy paramRetryPolicy)
  {
    paramInt = paramInt - 1 - 1;
    long l = paramRetryPolicy.getBackoffStrategy().delayBeforeNextRetry(paramAmazonWebServiceRequest, paramAmazonClientException, paramInt);
    if (log.isDebugEnabled()) {
      log.debug("Retriable error detected, will retry in " + l + "ms, attempt number: " + paramInt);
    }
    try
    {
      Thread.sleep(l);
      return;
    }
    catch (InterruptedException paramAmazonWebServiceRequest)
    {
      Thread.currentThread().interrupt();
      throw new AmazonClientException(paramAmazonWebServiceRequest.getMessage(), paramAmazonWebServiceRequest);
    }
  }
  
  private List<RequestHandler2> requestHandler2s(Request<?> paramRequest, ExecutionContext paramExecutionContext)
  {
    List localList = paramExecutionContext.getRequestHandler2s();
    if (localList == null) {
      return Collections.emptyList();
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      RequestHandler2 localRequestHandler2 = (RequestHandler2)localIterator.next();
      if ((localRequestHandler2 instanceof CredentialsRequestHandler)) {
        ((CredentialsRequestHandler)localRequestHandler2).setCredentials(paramExecutionContext.getCredentials());
      }
      localRequestHandler2.beforeRequest(paramRequest);
    }
    return localList;
  }
  
  private void resetRequestAfterError(Request<?> paramRequest, Exception paramException)
  {
    if (paramRequest.getContent() == null) {
      return;
    }
    if (!paramRequest.getContent().markSupported()) {
      throw new AmazonClientException("Encountered an exception and stream is not resettable", paramException);
    }
    try
    {
      paramRequest.getContent().reset();
      return;
    }
    catch (IOException paramRequest)
    {
      throw new AmazonClientException("Encountered an exception and couldn't reset the stream to retry", paramException);
    }
  }
  
  private void setUserAgent(Request<?> paramRequest)
  {
    Object localObject2 = this.config.getUserAgent();
    Object localObject1 = localObject2;
    if (!((String)localObject2).equals(ClientConfiguration.DEFAULT_USER_AGENT)) {
      localObject1 = (String)localObject2 + ", " + ClientConfiguration.DEFAULT_USER_AGENT;
    }
    if (localObject1 != null) {
      paramRequest.addHeader("User-Agent", (String)localObject1);
    }
    localObject2 = paramRequest.getOriginalRequest();
    if (localObject2 != null)
    {
      localObject2 = ((AmazonWebServiceRequest)localObject2).getRequestClientOptions();
      if (localObject2 != null)
      {
        localObject2 = ((RequestClientOptions)localObject2).getClientMarker(RequestClientOptions.Marker.USER_AGENT);
        if (localObject2 != null) {
          paramRequest.addHeader("User-Agent", createUserAgentString((String)localObject1, (String)localObject2));
        }
      }
    }
  }
  
  private boolean shouldRetry(AmazonWebServiceRequest paramAmazonWebServiceRequest, HttpRequestBase paramHttpRequestBase, AmazonClientException paramAmazonClientException, int paramInt, RetryPolicy paramRetryPolicy)
  {
    int i = paramInt - 1;
    paramInt = this.config.getMaxErrorRetry();
    if ((paramInt < 0) || (!paramRetryPolicy.isMaxErrorRetryInClientConfigHonored())) {
      paramInt = paramRetryPolicy.getMaxErrorRetry();
    }
    if (i >= paramInt) {}
    do
    {
      return false;
      if (!(paramHttpRequestBase instanceof HttpEntityEnclosingRequest)) {
        break;
      }
      paramHttpRequestBase = ((HttpEntityEnclosingRequest)paramHttpRequestBase).getEntity();
      if ((paramHttpRequestBase == null) || (paramHttpRequestBase.isRepeatable())) {
        break;
      }
    } while (!log.isDebugEnabled());
    log.debug("Entity not repeatable");
    return false;
    return paramRetryPolicy.getRetryCondition().shouldRetry(paramAmazonWebServiceRequest, paramAmazonClientException, i);
  }
  
  public <T> Response<T> execute(Request<?> paramRequest, HttpResponseHandler<AmazonWebServiceResponse<T>> paramHttpResponseHandler, HttpResponseHandler<AmazonServiceException> paramHttpResponseHandler1, ExecutionContext paramExecutionContext)
  {
    if (paramExecutionContext == null) {
      throw new AmazonClientException("Internal SDK Error: No execution context parameter specified.");
    }
    List localList = requestHandler2s(paramRequest, paramExecutionContext);
    AWSRequestMetrics localAWSRequestMetrics = paramExecutionContext.getAwsRequestMetrics();
    HttpResponseHandler<AmazonWebServiceResponse<T>> localHttpResponseHandler = null;
    try
    {
      paramHttpResponseHandler = executeHelper(paramRequest, paramHttpResponseHandler, paramHttpResponseHandler1, paramExecutionContext);
      localHttpResponseHandler = paramHttpResponseHandler;
      afterResponse(paramRequest, localList, paramHttpResponseHandler, localAWSRequestMetrics.getTimingInfo().endTiming());
      return paramHttpResponseHandler;
    }
    catch (AmazonClientException paramHttpResponseHandler)
    {
      afterError(paramRequest, localHttpResponseHandler, localList, paramHttpResponseHandler);
      throw paramHttpResponseHandler;
    }
  }
  
  protected void finalize()
  {
    shutdown();
    super.finalize();
  }
  
  public RequestMetricCollector getRequestMetricCollector()
  {
    return this.requestMetricCollector;
  }
  
  public void shutdown()
  {
    IdleConnectionReaper.removeConnectionManager(this.httpClient.getConnectionManager());
    this.httpClient.getConnectionManager().shutdown();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/http/AmazonHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */