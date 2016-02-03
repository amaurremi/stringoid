package twitter4j;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import twitter4j.auth.Authorization;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

class HttpClientImpl
        extends HttpClientBase
        implements Serializable, HttpResponseCode {
    private static final Map<HttpClientConfiguration, HttpClient> instanceMap;
    private static final Logger logger = Logger.getLogger(HttpClientImpl.class);
    private static final long serialVersionUID = -403500272719330534L;

    static {
        try {
            if (Integer.parseInt((String) Class.forName("android.os.Build$VERSION").getField("SDK").get(null)) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
            instanceMap = new HashMap(1);
            return;
        } catch (Exception localException) {
            for (; ; ) {
            }
        }
    }

    public HttpClientImpl() {
        super(ConfigurationContext.getInstance().getHttpClientConfiguration());
    }

    public HttpClientImpl(HttpClientConfiguration paramHttpClientConfiguration) {
        super(paramHttpClientConfiguration);
    }

    public static HttpClient getInstance(HttpClientConfiguration paramHttpClientConfiguration) {
        HttpClient localHttpClient = (HttpClient) instanceMap.get(paramHttpClientConfiguration);
        Object localObject = localHttpClient;
        if (localHttpClient == null) {
            localObject = new HttpClientImpl(paramHttpClientConfiguration);
            instanceMap.put(paramHttpClientConfiguration, localObject);
        }
        return (HttpClient) localObject;
    }

    private void setHeaders(HttpRequest paramHttpRequest, HttpURLConnection paramHttpURLConnection) {
        if (logger.isDebugEnabled()) {
            logger.debug("Request: ");
            logger.debug(paramHttpRequest.getMethod().name() + " ", paramHttpRequest.getURL());
        }
        Object localObject;
        if (paramHttpRequest.getAuthorization() != null) {
            localObject = paramHttpRequest.getAuthorization().getAuthorizationHeader(paramHttpRequest);
            if (localObject != null) {
                if (logger.isDebugEnabled()) {
                    logger.debug("Authorization: ", ((String) localObject).replaceAll(".", "*"));
                }
                paramHttpURLConnection.addRequestProperty("Authorization", (String) localObject);
            }
        }
        if (paramHttpRequest.getRequestHeaders() != null) {
            localObject = paramHttpRequest.getRequestHeaders().keySet().iterator();
            while (((Iterator) localObject).hasNext()) {
                String str = (String) ((Iterator) localObject).next();
                paramHttpURLConnection.addRequestProperty(str, (String) paramHttpRequest.getRequestHeaders().get(str));
                logger.debug(str + ": " + (String) paramHttpRequest.getRequestHeaders().get(str));
            }
        }
    }

    public HttpResponse get(String paramString) {
        return request(new HttpRequest(RequestMethod.GET, paramString, null, null, null));
    }

    HttpURLConnection getConnection(String paramString) {
        Proxy localProxy;
        if (isProxyConfigured()) {
            if ((this.CONF.getHttpProxyUser() != null) && (!this.CONF.getHttpProxyUser().equals(""))) {
                if (logger.isDebugEnabled()) {
                    logger.debug("Proxy AuthUser: " + this.CONF.getHttpProxyUser());
                    logger.debug("Proxy AuthPassword: " + this.CONF.getHttpProxyPassword().replaceAll(".", "*"));
                }
                Authenticator.setDefault(new HttpClientImpl .1 (this));
            }
            localProxy = new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(this.CONF.getHttpProxyHost(), this.CONF.getHttpProxyPort()));
            if (logger.isDebugEnabled()) {
                logger.debug("Opening proxied connection(" + this.CONF.getHttpProxyHost() + ":" + this.CONF.getHttpProxyPort() + ")");
            }
        }
        for (paramString = (HttpURLConnection) new URL(paramString).openConnection(localProxy); ; paramString = (HttpURLConnection) new URL(paramString).openConnection()) {
            if (this.CONF.getHttpConnectionTimeout() > 0) {
                paramString.setConnectTimeout(this.CONF.getHttpConnectionTimeout());
            }
            if (this.CONF.getHttpReadTimeout() > 0) {
                paramString.setReadTimeout(this.CONF.getHttpReadTimeout());
            }
            paramString.setInstanceFollowRedirects(false);
            return paramString;
        }
    }

    /* Error */
    public HttpResponse handleRequest(HttpRequest paramHttpRequest) {
        // Byte code:
        //   0: aload_0
        //   1: getfield 217	twitter4j/HttpClientImpl:CONF	Ltwitter4j/HttpClientConfiguration;
        //   4: invokeinterface 314 1 0
        //   9: istore 5
        //   11: aconst_null
        //   12: astore 8
        //   14: iconst_0
        //   15: istore_3
        //   16: aload 8
        //   18: astore 9
        //   20: iload_3
        //   21: iload 5
        //   23: iconst_1
        //   24: iadd
        //   25: if_icmpge +1093 -> 1118
        //   28: iconst_m1
        //   29: istore 4
        //   31: aload_0
        //   32: aload_1
        //   33: invokevirtual 142	twitter4j/HttpRequest:getURL	()Ljava/lang/String;
        //   36: invokevirtual 316	twitter4j/HttpClientImpl:getConnection	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
        //   39: astore 12
        //   41: aload 12
        //   43: iconst_1
        //   44: invokevirtual 319	java/net/HttpURLConnection:setDoInput	(Z)V
        //   47: aload_0
        //   48: aload_1
        //   49: aload 12
        //   51: invokespecial 321	twitter4j/HttpClientImpl:setHeaders	(Ltwitter4j/HttpRequest;Ljava/net/HttpURLConnection;)V
        //   54: aload 12
        //   56: aload_1
        //   57: invokevirtual 124	twitter4j/HttpRequest:getMethod	()Ltwitter4j/RequestMethod;
        //   60: invokevirtual 130	twitter4j/RequestMethod:name	()Ljava/lang/String;
        //   63: invokevirtual 324	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   66: aload_1
        //   67: invokevirtual 124	twitter4j/HttpRequest:getMethod	()Ltwitter4j/RequestMethod;
        //   70: getstatic 327	twitter4j/RequestMethod:POST	Ltwitter4j/RequestMethod;
        //   73: if_acmpne +1185 -> 1258
        //   76: aload_1
        //   77: invokevirtual 331	twitter4j/HttpRequest:getParameters	()[Ltwitter4j/HttpParameter;
        //   80: invokestatic 337	twitter4j/HttpParameter:containsFile	([Ltwitter4j/HttpParameter;)Z
        //   83: ifeq +876 -> 959
        //   86: new 116	java/lang/StringBuilder
        //   89: dup
        //   90: invokespecial 118	java/lang/StringBuilder:<init>	()V
        //   93: ldc_w 339
        //   96: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   99: invokestatic 343	java/lang/System:currentTimeMillis	()J
        //   102: invokevirtual 346	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   105: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   108: astore 9
        //   110: aload 12
        //   112: ldc_w 348
        //   115: new 116	java/lang/StringBuilder
        //   118: dup
        //   119: invokespecial 118	java/lang/StringBuilder:<init>	()V
        //   122: ldc_w 350
        //   125: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   128: aload 9
        //   130: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   133: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   136: invokevirtual 353	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   139: new 116	java/lang/StringBuilder
        //   142: dup
        //   143: invokespecial 118	java/lang/StringBuilder:<init>	()V
        //   146: ldc_w 355
        //   149: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   152: aload 9
        //   154: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   157: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   160: astore 13
        //   162: aload 12
        //   164: iconst_1
        //   165: invokevirtual 358	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   168: aload 12
        //   170: invokevirtual 362	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   173: astore 10
        //   175: aload 10
        //   177: astore 9
        //   179: new 364	java/io/DataOutputStream
        //   182: dup
        //   183: aload 10
        //   185: invokespecial 367	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   188: astore 14
        //   190: aload 10
        //   192: astore 9
        //   194: aload_1
        //   195: invokevirtual 331	twitter4j/HttpRequest:getParameters	()[Ltwitter4j/HttpParameter;
        //   198: astore 15
        //   200: aload 10
        //   202: astore 9
        //   204: aload 15
        //   206: arraylength
        //   207: istore 6
        //   209: iconst_0
        //   210: istore_2
        //   211: iload_2
        //   212: iload 6
        //   214: if_icmpge +474 -> 688
        //   217: aload 15
        //   219: iload_2
        //   220: aaload
        //   221: astore 11
        //   223: aload 10
        //   225: astore 9
        //   227: aload 11
        //   229: invokevirtual 370	twitter4j/HttpParameter:isFile	()Z
        //   232: ifeq +321 -> 553
        //   235: aload 10
        //   237: astore 9
        //   239: aload_0
        //   240: aload 14
        //   242: new 116	java/lang/StringBuilder
        //   245: dup
        //   246: invokespecial 118	java/lang/StringBuilder:<init>	()V
        //   249: aload 13
        //   251: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   254: ldc_w 372
        //   257: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   260: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   263: invokevirtual 376	twitter4j/HttpClientImpl:write	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
        //   266: aload 10
        //   268: astore 9
        //   270: aload_0
        //   271: aload 14
        //   273: new 116	java/lang/StringBuilder
        //   276: dup
        //   277: invokespecial 118	java/lang/StringBuilder:<init>	()V
        //   280: ldc_w 378
        //   283: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   286: aload 11
        //   288: invokevirtual 381	twitter4j/HttpParameter:getName	()Ljava/lang/String;
        //   291: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   294: ldc_w 383
        //   297: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   300: aload 11
        //   302: invokevirtual 387	twitter4j/HttpParameter:getFile	()Ljava/io/File;
        //   305: invokevirtual 390	java/io/File:getName	()Ljava/lang/String;
        //   308: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   311: ldc_w 392
        //   314: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   317: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   320: invokevirtual 376	twitter4j/HttpClientImpl:write	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
        //   323: aload 10
        //   325: astore 9
        //   327: aload_0
        //   328: aload 14
        //   330: new 116	java/lang/StringBuilder
        //   333: dup
        //   334: invokespecial 118	java/lang/StringBuilder:<init>	()V
        //   337: ldc_w 394
        //   340: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   343: aload 11
        //   345: invokevirtual 397	twitter4j/HttpParameter:getContentType	()Ljava/lang/String;
        //   348: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   351: ldc_w 399
        //   354: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   357: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   360: invokevirtual 376	twitter4j/HttpClientImpl:write	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
        //   363: aload 10
        //   365: astore 9
        //   367: aload 11
        //   369: invokevirtual 402	twitter4j/HttpParameter:hasFileBody	()Z
        //   372: ifeq +135 -> 507
        //   375: aload 10
        //   377: astore 9
        //   379: aload 11
        //   381: invokevirtual 406	twitter4j/HttpParameter:getFileBody	()Ljava/io/InputStream;
        //   384: astore 11
        //   386: aload 10
        //   388: astore 9
        //   390: new 408	java/io/BufferedInputStream
        //   393: dup
        //   394: aload 11
        //   396: invokespecial 411	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
        //   399: astore 11
        //   401: aload 10
        //   403: astore 9
        //   405: sipush 1024
        //   408: newarray <illegal type>
        //   410: astore 16
        //   412: aload 10
        //   414: astore 9
        //   416: aload 11
        //   418: aload 16
        //   420: invokevirtual 415	java/io/BufferedInputStream:read	([B)I
        //   423: istore 7
        //   425: iload 7
        //   427: iconst_m1
        //   428: if_icmpeq +100 -> 528
        //   431: aload 10
        //   433: astore 9
        //   435: aload 14
        //   437: aload 16
        //   439: iconst_0
        //   440: iload 7
        //   442: invokevirtual 418	java/io/DataOutputStream:write	([BII)V
        //   445: goto -33 -> 412
        //   448: astore 11
        //   450: iconst_m1
        //   451: istore_2
        //   452: aload 9
        //   454: astore 10
        //   456: aload 11
        //   458: astore 9
        //   460: aload 10
        //   462: invokevirtual 423	java/io/OutputStream:close	()V
        //   465: aload 9
        //   467: athrow
        //   468: astore 10
        //   470: aload 8
        //   472: astore 9
        //   474: aload 10
        //   476: astore 8
        //   478: iload_3
        //   479: aload_0
        //   480: getfield 217	twitter4j/HttpClientImpl:CONF	Ltwitter4j/HttpClientConfiguration;
        //   483: invokeinterface 314 1 0
        //   488: if_icmpne +776 -> 1264
        //   491: new 425	twitter4j/TwitterException
        //   494: dup
        //   495: aload 8
        //   497: invokevirtual 428	java/io/IOException:getMessage	()Ljava/lang/String;
        //   500: aload 8
        //   502: iload_2
        //   503: invokespecial 431	twitter4j/TwitterException:<init>	(Ljava/lang/String;Ljava/lang/Exception;I)V
        //   506: athrow
        //   507: aload 10
        //   509: astore 9
        //   511: new 433	java/io/FileInputStream
        //   514: dup
        //   515: aload 11
        //   517: invokevirtual 387	twitter4j/HttpParameter:getFile	()Ljava/io/File;
        //   520: invokespecial 436	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   523: astore 11
        //   525: goto -139 -> 386
        //   528: aload 10
        //   530: astore 9
        //   532: aload_0
        //   533: aload 14
        //   535: ldc_w 372
        //   538: invokevirtual 376	twitter4j/HttpClientImpl:write	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
        //   541: aload 10
        //   543: astore 9
        //   545: aload 11
        //   547: invokevirtual 437	java/io/BufferedInputStream:close	()V
        //   550: goto +721 -> 1271
        //   553: aload 10
        //   555: astore 9
        //   557: aload_0
        //   558: aload 14
        //   560: new 116	java/lang/StringBuilder
        //   563: dup
        //   564: invokespecial 118	java/lang/StringBuilder:<init>	()V
        //   567: aload 13
        //   569: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   572: ldc_w 372
        //   575: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   578: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   581: invokevirtual 376	twitter4j/HttpClientImpl:write	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
        //   584: aload 10
        //   586: astore 9
        //   588: aload_0
        //   589: aload 14
        //   591: new 116	java/lang/StringBuilder
        //   594: dup
        //   595: invokespecial 118	java/lang/StringBuilder:<init>	()V
        //   598: ldc_w 378
        //   601: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   604: aload 11
        //   606: invokevirtual 381	twitter4j/HttpParameter:getName	()Ljava/lang/String;
        //   609: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   612: ldc_w 392
        //   615: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   618: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   621: invokevirtual 376	twitter4j/HttpClientImpl:write	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
        //   624: aload 10
        //   626: astore 9
        //   628: aload_0
        //   629: aload 14
        //   631: ldc_w 439
        //   634: invokevirtual 376	twitter4j/HttpClientImpl:write	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
        //   637: aload 10
        //   639: astore 9
        //   641: getstatic 29	twitter4j/HttpClientImpl:logger	Ltwitter4j/Logger;
        //   644: aload 11
        //   646: invokevirtual 442	twitter4j/HttpParameter:getValue	()Ljava/lang/String;
        //   649: invokevirtual 114	twitter4j/Logger:debug	(Ljava/lang/String;)V
        //   652: aload 10
        //   654: astore 9
        //   656: aload 14
        //   658: aload 11
        //   660: invokevirtual 442	twitter4j/HttpParameter:getValue	()Ljava/lang/String;
        //   663: ldc_w 444
        //   666: invokevirtual 448	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   669: invokevirtual 451	java/io/DataOutputStream:write	([B)V
        //   672: aload 10
        //   674: astore 9
        //   676: aload_0
        //   677: aload 14
        //   679: ldc_w 372
        //   682: invokevirtual 376	twitter4j/HttpClientImpl:write	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
        //   685: goto +586 -> 1271
        //   688: aload 10
        //   690: astore 9
        //   692: aload_0
        //   693: aload 14
        //   695: new 116	java/lang/StringBuilder
        //   698: dup
        //   699: invokespecial 118	java/lang/StringBuilder:<init>	()V
        //   702: aload 13
        //   704: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   707: ldc_w 453
        //   710: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   713: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   716: invokevirtual 376	twitter4j/HttpClientImpl:write	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
        //   719: aload 10
        //   721: astore 9
        //   723: aload_0
        //   724: aload 14
        //   726: ldc_w 372
        //   729: invokevirtual 376	twitter4j/HttpClientImpl:write	(Ljava/io/DataOutputStream;Ljava/lang/String;)V
        //   732: aload 10
        //   734: astore 9
        //   736: aload 10
        //   738: invokevirtual 456	java/io/OutputStream:flush	()V
        //   741: aload 10
        //   743: astore 9
        //   745: aload 10
        //   747: invokevirtual 423	java/io/OutputStream:close	()V
        //   750: new 458	twitter4j/HttpResponseImpl
        //   753: dup
        //   754: aload 12
        //   756: aload_0
        //   757: getfield 217	twitter4j/HttpClientImpl:CONF	Ltwitter4j/HttpClientConfiguration;
        //   760: invokespecial 461	twitter4j/HttpResponseImpl:<init>	(Ljava/net/HttpURLConnection;Ltwitter4j/HttpClientConfiguration;)V
        //   763: astore 9
        //   765: iload 4
        //   767: istore_2
        //   768: aload 12
        //   770: invokevirtual 464	java/net/HttpURLConnection:getResponseCode	()I
        //   773: istore 4
        //   775: iload 4
        //   777: istore_2
        //   778: getstatic 29	twitter4j/HttpClientImpl:logger	Ltwitter4j/Logger;
        //   781: invokevirtual 108	twitter4j/Logger:isDebugEnabled	()Z
        //   784: ifeq +494 -> 1278
        //   787: iload 4
        //   789: istore_2
        //   790: getstatic 29	twitter4j/HttpClientImpl:logger	Ltwitter4j/Logger;
        //   793: ldc_w 466
        //   796: invokevirtual 114	twitter4j/Logger:debug	(Ljava/lang/String;)V
        //   799: iload 4
        //   801: istore_2
        //   802: aload 12
        //   804: invokevirtual 469	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
        //   807: astore 8
        //   809: iload 4
        //   811: istore_2
        //   812: aload 8
        //   814: invokeinterface 179 1 0
        //   819: invokeinterface 185 1 0
        //   824: astore 11
        //   826: iload 4
        //   828: istore_2
        //   829: aload 11
        //   831: invokeinterface 190 1 0
        //   836: ifeq +442 -> 1278
        //   839: iload 4
        //   841: istore_2
        //   842: aload 11
        //   844: invokeinterface 194 1 0
        //   849: checkcast 51	java/lang/String
        //   852: astore 12
        //   854: iload 4
        //   856: istore_2
        //   857: aload 8
        //   859: aload 12
        //   861: invokeinterface 95 2 0
        //   866: checkcast 471	java/util/List
        //   869: invokeinterface 472 1 0
        //   874: astore 13
        //   876: iload 4
        //   878: istore_2
        //   879: aload 13
        //   881: invokeinterface 190 1 0
        //   886: ifeq -60 -> 826
        //   889: iload 4
        //   891: istore_2
        //   892: aload 13
        //   894: invokeinterface 194 1 0
        //   899: checkcast 51	java/lang/String
        //   902: astore 14
        //   904: aload 12
        //   906: ifnull +135 -> 1041
        //   909: iload 4
        //   911: istore_2
        //   912: getstatic 29	twitter4j/HttpClientImpl:logger	Ltwitter4j/Logger;
        //   915: new 116	java/lang/StringBuilder
        //   918: dup
        //   919: invokespecial 118	java/lang/StringBuilder:<init>	()V
        //   922: aload 12
        //   924: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   927: ldc -60
        //   929: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   932: aload 14
        //   934: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   937: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   940: invokevirtual 114	twitter4j/Logger:debug	(Ljava/lang/String;)V
        //   943: goto -67 -> 876
        //   946: astore 11
        //   948: aload 9
        //   950: astore 8
        //   952: aload 11
        //   954: astore 9
        //   956: goto -496 -> 460
        //   959: aload 12
        //   961: ldc_w 348
        //   964: ldc_w 474
        //   967: invokevirtual 353	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   970: aload_1
        //   971: invokevirtual 331	twitter4j/HttpRequest:getParameters	()[Ltwitter4j/HttpParameter;
        //   974: invokestatic 478	twitter4j/HttpParameter:encodeParameters	([Ltwitter4j/HttpParameter;)Ljava/lang/String;
        //   977: astore 9
        //   979: getstatic 29	twitter4j/HttpClientImpl:logger	Ltwitter4j/Logger;
        //   982: ldc_w 480
        //   985: aload 9
        //   987: invokevirtual 145	twitter4j/Logger:debug	(Ljava/lang/String;Ljava/lang/String;)V
        //   990: aload 9
        //   992: ldc_w 444
        //   995: invokevirtual 448	java/lang/String:getBytes	(Ljava/lang/String;)[B
        //   998: astore 11
        //   1000: aload 12
        //   1002: ldc_w 482
        //   1005: aload 11
        //   1007: arraylength
        //   1008: invokestatic 485	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   1011: invokevirtual 353	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
        //   1014: aload 12
        //   1016: iconst_1
        //   1017: invokevirtual 358	java/net/HttpURLConnection:setDoOutput	(Z)V
        //   1020: aload 12
        //   1022: invokevirtual 362	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
        //   1025: astore 10
        //   1027: aload 10
        //   1029: astore 9
        //   1031: aload 10
        //   1033: aload 11
        //   1035: invokevirtual 486	java/io/OutputStream:write	([B)V
        //   1038: goto -306 -> 732
        //   1041: iload 4
        //   1043: istore_2
        //   1044: getstatic 29	twitter4j/HttpClientImpl:logger	Ltwitter4j/Logger;
        //   1047: aload 14
        //   1049: invokevirtual 114	twitter4j/Logger:debug	(Ljava/lang/String;)V
        //   1052: goto -176 -> 876
        //   1055: iload 4
        //   1057: sipush 420
        //   1060: if_icmpeq +35 -> 1095
        //   1063: iload 4
        //   1065: sipush 400
        //   1068: if_icmpeq +27 -> 1095
        //   1071: iload 4
        //   1073: sipush 500
        //   1076: if_icmplt +19 -> 1095
        //   1079: iload 4
        //   1081: istore_2
        //   1082: iload_3
        //   1083: aload_0
        //   1084: getfield 217	twitter4j/HttpClientImpl:CONF	Ltwitter4j/HttpClientConfiguration;
        //   1087: invokeinterface 314 1 0
        //   1092: if_icmpne +29 -> 1121
        //   1095: iload 4
        //   1097: istore_2
        //   1098: new 425	twitter4j/TwitterException
        //   1101: dup
        //   1102: aload 9
        //   1104: invokevirtual 491	twitter4j/HttpResponse:asString	()Ljava/lang/String;
        //   1107: aload 9
        //   1109: invokespecial 494	twitter4j/TwitterException:<init>	(Ljava/lang/String;Ltwitter4j/HttpResponse;)V
        //   1112: athrow
        //   1113: aload 10
        //   1115: invokevirtual 423	java/io/OutputStream:close	()V
        //   1118: aload 9
        //   1120: areturn
        //   1121: aload 10
        //   1123: invokevirtual 423	java/io/OutputStream:close	()V
        //   1126: aload 9
        //   1128: astore 8
        //   1130: getstatic 29	twitter4j/HttpClientImpl:logger	Ltwitter4j/Logger;
        //   1133: invokevirtual 108	twitter4j/Logger:isDebugEnabled	()Z
        //   1136: ifeq +14 -> 1150
        //   1139: aload 8
        //   1141: ifnull +9 -> 1150
        //   1144: aload 8
        //   1146: invokevirtual 491	twitter4j/HttpResponse:asString	()Ljava/lang/String;
        //   1149: pop
        //   1150: getstatic 29	twitter4j/HttpClientImpl:logger	Ltwitter4j/Logger;
        //   1153: new 116	java/lang/StringBuilder
        //   1156: dup
        //   1157: invokespecial 118	java/lang/StringBuilder:<init>	()V
        //   1160: ldc_w 496
        //   1163: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1166: aload_0
        //   1167: getfield 217	twitter4j/HttpClientImpl:CONF	Ltwitter4j/HttpClientConfiguration;
        //   1170: invokeinterface 499 1 0
        //   1175: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   1178: ldc_w 501
        //   1181: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1184: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1187: invokevirtual 114	twitter4j/Logger:debug	(Ljava/lang/String;)V
        //   1190: aload_0
        //   1191: getfield 217	twitter4j/HttpClientImpl:CONF	Ltwitter4j/HttpClientConfiguration;
        //   1194: invokeinterface 499 1 0
        //   1199: sipush 1000
        //   1202: imul
        //   1203: i2l
        //   1204: invokestatic 507	java/lang/Thread:sleep	(J)V
        //   1207: iload_3
        //   1208: iconst_1
        //   1209: iadd
        //   1210: istore_3
        //   1211: goto -1195 -> 16
        //   1214: astore_1
        //   1215: goto -97 -> 1118
        //   1218: astore 8
        //   1220: goto -94 -> 1126
        //   1223: astore 10
        //   1225: goto -760 -> 465
        //   1228: astore 9
        //   1230: goto -23 -> 1207
        //   1233: astore 8
        //   1235: iload 4
        //   1237: istore_2
        //   1238: goto -760 -> 478
        //   1241: astore 9
        //   1243: aconst_null
        //   1244: astore 10
        //   1246: iconst_m1
        //   1247: istore_2
        //   1248: goto -788 -> 460
        //   1251: astore 9
        //   1253: iconst_m1
        //   1254: istore_2
        //   1255: goto -795 -> 460
        //   1258: aconst_null
        //   1259: astore 10
        //   1261: goto -511 -> 750
        //   1264: aload 9
        //   1266: astore 8
        //   1268: goto -138 -> 1130
        //   1271: iload_2
        //   1272: iconst_1
        //   1273: iadd
        //   1274: istore_2
        //   1275: goto -1064 -> 211
        //   1278: iload 4
        //   1280: sipush 200
        //   1283: if_icmplt -228 -> 1055
        //   1286: iload 4
        //   1288: sipush 302
        //   1291: if_icmpeq -178 -> 1113
        //   1294: sipush 300
        //   1297: iload 4
        //   1299: if_icmpgt -186 -> 1113
        //   1302: goto -247 -> 1055
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1305	0	this	HttpClientImpl
        //   0	1305	1	paramHttpRequest	HttpRequest
        //   210	1065	2	i	int
        //   15	1196	3	j	int
        //   29	1271	4	k	int
        //   9	16	5	m	int
        //   207	8	6	n	int
        //   423	18	7	i1	int
        //   12	1133	8	localObject1	Object
        //   1218	1	8	localException1	Exception
        //   1233	1	8	localIOException1	java.io.IOException
        //   1266	1	8	localObject2	Object
        //   18	1109	9	localObject3	Object
        //   1228	1	9	localInterruptedException	InterruptedException
        //   1241	1	9	localObject4	Object
        //   1251	14	9	localObject5	Object
        //   173	288	10	localObject6	Object
        //   468	278	10	localIOException2	java.io.IOException
        //   1025	97	10	localOutputStream	java.io.OutputStream
        //   1223	1	10	localException2	Exception
        //   1244	16	10	localObject7	Object
        //   221	196	11	localObject8	Object
        //   448	68	11	localObject9	Object
        //   523	320	11	localObject10	Object
        //   946	7	11	localObject11	Object
        //   998	36	11	arrayOfByte1	byte[]
        //   39	982	12	localObject12	Object
        //   160	733	13	localObject13	Object
        //   188	860	14	localObject14	Object
        //   198	20	15	arrayOfHttpParameter	HttpParameter[]
        //   410	28	16	arrayOfByte2	byte[]
        // Exception table:
        //   from	to	target	type
        //   179	190	448	finally
        //   194	200	448	finally
        //   204	209	448	finally
        //   227	235	448	finally
        //   239	266	448	finally
        //   270	323	448	finally
        //   327	363	448	finally
        //   367	375	448	finally
        //   379	386	448	finally
        //   390	401	448	finally
        //   405	412	448	finally
        //   416	425	448	finally
        //   435	445	448	finally
        //   511	525	448	finally
        //   532	541	448	finally
        //   545	550	448	finally
        //   557	584	448	finally
        //   588	624	448	finally
        //   628	637	448	finally
        //   641	652	448	finally
        //   656	672	448	finally
        //   676	685	448	finally
        //   692	719	448	finally
        //   723	732	448	finally
        //   736	741	448	finally
        //   745	750	448	finally
        //   1031	1038	448	finally
        //   460	465	468	java/io/IOException
        //   465	468	468	java/io/IOException
        //   768	775	946	finally
        //   778	787	946	finally
        //   790	799	946	finally
        //   802	809	946	finally
        //   812	826	946	finally
        //   829	839	946	finally
        //   842	854	946	finally
        //   857	876	946	finally
        //   879	889	946	finally
        //   892	904	946	finally
        //   912	943	946	finally
        //   1044	1052	946	finally
        //   1082	1095	946	finally
        //   1098	1113	946	finally
        //   1113	1118	1214	java/lang/Exception
        //   1121	1126	1218	java/lang/Exception
        //   460	465	1223	java/lang/Exception
        //   1130	1139	1228	java/lang/InterruptedException
        //   1144	1150	1228	java/lang/InterruptedException
        //   1150	1207	1228	java/lang/InterruptedException
        //   1113	1118	1233	java/io/IOException
        //   1121	1126	1233	java/io/IOException
        //   31	175	1241	finally
        //   959	1027	1241	finally
        //   750	765	1251	finally
    }

    public HttpResponse post(String paramString, HttpParameter[] paramArrayOfHttpParameter) {
        return request(new HttpRequest(RequestMethod.POST, paramString, paramArrayOfHttpParameter, null, null));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/HttpClientImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */