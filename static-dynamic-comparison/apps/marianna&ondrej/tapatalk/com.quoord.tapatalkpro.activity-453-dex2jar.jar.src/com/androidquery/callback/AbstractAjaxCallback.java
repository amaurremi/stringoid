package com.androidquery.callback;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import com.androidquery.auth.AccountHandle;
import com.androidquery.auth.GoogleHandle;
import com.androidquery.util.AQUtility;
import com.androidquery.util.Common;
import com.androidquery.util.Progress;
import com.androidquery.util.XmlDom;

import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.xmlpull.v1.XmlPullParser;

public abstract class AbstractAjaxCallback<T, K>
        implements Runnable {
    private static String AGENT;
    private static final Class<?>[] DEFAULT_SIG = {String.class, Object.class, AjaxStatus.class};
    private static boolean GZIP = false;
    private static int NETWORK_POOL = 0;
    private static int NET_TIMEOUT = 30000;
    private static boolean REUSE_CLIENT = false;
    private static boolean SIMULATE_ERROR = false;
    private static final String boundary = "*****";
    private static DefaultHttpClient client;
    private static ExecutorService fetchExe;
    private static int lastStatus = 200;
    private static final String lineEnd = "\r\n";
    private static ProxyHandle proxyHandle;
    private static SocketFactory ssf;
    private static Transformer st;
    private static final String twoHyphens = "--";
    private boolean abort;
    private WeakReference<Activity> act;
    protected AccountHandle ah;
    private boolean blocked;
    private File cacheDir;
    private String callback;
    private boolean completed;
    protected Map<String, String> cookies;
    private String encoding = "UTF-8";
    private long expire;
    protected boolean fileCache;
    private Object handler;
    protected Map<String, String> headers;
    protected boolean memCache;
    private int method = 4;
    private String networkUrl;
    protected Map<String, Object> params;
    private int policy = 0;
    private WeakReference<Object> progress;
    private HttpHost proxy;
    private boolean reauth;
    private boolean redirect = true;
    private boolean refresh;
    private HttpUriRequest request;
    protected T result;
    private int retry = 0;
    protected AjaxStatus status;
    private File targetFile;
    private int timeout = 0;
    private Transformer transformer;
    private Class<T> type;
    private boolean uiCallback = true;
    private String url;
    private Reference<Object> whandler;

    static {
        AGENT = null;
        NETWORK_POOL = 4;
        GZIP = true;
        REUSE_CLIENT = true;
        SIMULATE_ERROR = false;
    }

    private void afterWork() {
        if ((this.url != null) && (this.memCache)) {
            memPut(this.url, this.result);
        }
        callback();
        clear();
    }

    private void backgroundWork() {
        if ((!this.refresh) && (this.fileCache)) {
            fileWork();
        }
        if (this.result == null) {
            datastoreWork();
        }
        if (this.result == null) {
            networkWork();
        }
    }

    public static void cancel() {
        if (fetchExe != null) {
            fetchExe.shutdownNow();
            fetchExe = null;
        }
        BitmapAjaxCallback.clearTasks();
    }

    private void clear() {
        this.whandler = null;
        this.handler = null;
        this.progress = null;
        this.request = null;
        this.transformer = null;
        this.ah = null;
        this.act = null;
    }

    private void copy(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt)
            throws IOException {
        Object localObject = null;
        if (this.progress != null) {
            localObject = this.progress.get();
        }
        Progress localProgress = null;
        if (localObject != null) {
            localProgress = new Progress(localObject);
        }
        AQUtility.copy(paramInputStream, paramOutputStream, paramInt, localProgress);
    }

    private void copy(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt, File paramFile1, File paramFile2)
            throws IOException {
        if (paramFile2 == null) {
            copy(paramInputStream, paramOutputStream, paramInt);
            return;
        }
        try {
            copy(paramInputStream, paramOutputStream, paramInt);
            paramInputStream.close();
            paramOutputStream.close();
            paramFile1.renameTo(paramFile2);
            return;
        } catch (IOException localIOException) {
            AQUtility.debug("copy failed, deleting files");
            paramFile1.delete();
            paramFile2.delete();
            AQUtility.close(paramInputStream);
            AQUtility.close(paramOutputStream);
            throw localIOException;
        }
    }

    private String correctEncoding(byte[] paramArrayOfByte, String paramString, AjaxStatus paramAjaxStatus) {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        try {
            if (!"utf-8".equalsIgnoreCase(paramString)) {
                localObject1 = localObject2;
                return new String(paramArrayOfByte, paramString);
            }
            localObject1 = localObject2;
            paramString = parseCharset(paramAjaxStatus.getHeader("Content-Type"));
            localObject1 = localObject2;
            AQUtility.debug("parsing header", paramString);
            if (paramString == null) {
                break label85;
            }
            localObject1 = localObject2;
            paramArrayOfByte = new String(paramArrayOfByte, paramString);
            return paramArrayOfByte;
        } catch (Exception paramArrayOfByte) {
        }
        AQUtility.report(paramArrayOfByte);
        for (; ; ) {
            return (String) localObject1;
            label85:
            localObject1 = localObject2;
            paramString = new String(paramArrayOfByte, "utf-8");
            try {
                localObject1 = getCharset(paramString);
                AQUtility.debug("parsing needed", localObject1);
                if ((localObject1 == null) || ("utf-8".equalsIgnoreCase((String) localObject1))) {
                    break label176;
                }
                AQUtility.debug("correction needed", localObject1);
                paramArrayOfByte = new String(paramArrayOfByte, (String) localObject1);
                localObject1 = paramArrayOfByte;
                paramAjaxStatus.data(paramArrayOfByte.getBytes("utf-8"));
                localObject1 = paramArrayOfByte;
            } catch (Exception paramArrayOfByte) {
                localObject1 = paramString;
            }
            break;
            label176:
            localObject1 = paramString;
        }
    }

    private void datastoreWork() {
        this.result = datastoreGet(this.url);
        if (this.result != null) {
            this.status.source(2).done();
        }
    }

    private HttpResponse execute(HttpUriRequest paramHttpUriRequest, DefaultHttpClient paramDefaultHttpClient, HttpContext paramHttpContext)
            throws ClientProtocolException, IOException {
        if (paramHttpUriRequest.getURI().getAuthority().contains("_")) {
            Object localObject = paramHttpUriRequest.getURI().toURL();
            if (((URL) localObject).getPort() == -1) {
            }
            for (localObject = new HttpHost(((URL) localObject).getHost(), 80, ((URL) localObject).getProtocol()); ; localObject = new HttpHost(((URL) localObject).getHost(), ((URL) localObject).getPort(), ((URL) localObject).getProtocol())) {
                return paramDefaultHttpClient.execute((HttpHost) localObject, paramHttpUriRequest, paramHttpContext);
            }
        }
        return paramDefaultHttpClient.execute(paramHttpUriRequest, paramHttpContext);
    }

    public static void execute(Runnable paramRunnable) {
        if (fetchExe == null) {
            fetchExe = Executors.newFixedThreadPool(NETWORK_POOL);
        }
        fetchExe.execute(paramRunnable);
    }

    private static Map<String, Object> extractParams(Uri paramUri) {
        HashMap localHashMap = new HashMap();
        paramUri = paramUri.getQuery().split("&");
        int j = paramUri.length;
        int i = 0;
        if (i >= j) {
            return localHashMap;
        }
        String[] arrayOfString = paramUri[i].split("=");
        if (arrayOfString.length >= 2) {
            localHashMap.put(arrayOfString[0], arrayOfString[1]);
        }
        for (; ; ) {
            i += 1;
            break;
            if (arrayOfString.length == 1) {
                localHashMap.put(arrayOfString[0], "");
            }
        }
    }

    private static String extractUrl(Uri paramUri) {
        String str1 = paramUri.getScheme() + "://" + paramUri.getAuthority() + paramUri.getPath();
        String str2 = paramUri.getFragment();
        paramUri = str1;
        if (str2 != null) {
            paramUri = str1 + "#" + str2;
        }
        return paramUri;
    }

    private void filePut() {
        byte[] arrayOfByte;
        if ((this.result != null) && (this.fileCache)) {
            arrayOfByte = this.status.getData();
            if (arrayOfByte == null) {
            }
        }
        label76:
        File localFile1;
        do {
            do {
                try {
                    File localFile2;
                    if (this.status.getSource() == 1) {
                        localFile2 = getCacheFile();
                        if (this.status.getInvalid()) {
                            break label76;
                        }
                        filePut(this.url, this.result, localFile2, arrayOfByte);
                    }
                    for (; ; ) {
                        this.status.data(null);
                        return;
                        if (localFile2.exists()) {
                            localFile2.delete();
                        }
                    }
                } catch (Exception localException) {
                    for (; ; ) {
                        AQUtility.debug(localException);
                    }
                }
            } while (this.status.getCode() != -103);
            localFile1 = getCacheFile();
        } while (!localFile1.exists());
        localFile1.delete();
        AQUtility.debug("invalidated cache due to transform error");
    }

    private void fileWork() {
        File localFile = accessFile(this.cacheDir, getCacheUrl());
        if (localFile != null) {
            this.status.source(3);
            this.result = fileGet(this.url, localFile, this.status);
            if (this.result != null) {
                this.status.time(new Date(localFile.lastModified())).done();
            }
        }
    }

    public static int getActiveCount() {
        int i = 0;
        if ((fetchExe instanceof ThreadPoolExecutor)) {
            i = ((ThreadPoolExecutor) fetchExe).getActiveCount();
        }
        return i;
    }

    private String getCacheUrl() {
        if (this.ah != null) {
            return this.ah.getCacheUrl(this.url);
        }
        return this.url;
    }

    private String getCharset(String paramString) {
        paramString = Pattern.compile("<meta [^>]*http-equiv[^>]*\"Content-Type\"[^>]*>", 2).matcher(paramString);
        if (!paramString.find()) {
            return null;
        }
        return parseCharset(paramString.group());
    }

    private static DefaultHttpClient getClient() {
        BasicHttpParams localBasicHttpParams;
        SchemeRegistry localSchemeRegistry;
        if ((client == null) || (!REUSE_CLIENT)) {
            AQUtility.debug("creating http client");
            localBasicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, NET_TIMEOUT);
            HttpConnectionParams.setSoTimeout(localBasicHttpParams, NET_TIMEOUT);
            ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(25));
            HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
            localSchemeRegistry = new SchemeRegistry();
            localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            if (ssf != null) {
                break label141;
            }
        }
        label141:
        for (Object localObject = SSLSocketFactory.getSocketFactory(); ; localObject = ssf) {
            localSchemeRegistry.register(new Scheme("https", (SocketFactory) localObject, 443));
            client = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
            return client;
        }
    }

    private String getEncoding(HttpEntity paramHttpEntity) {
        if (paramHttpEntity == null) {
        }
        do {
            return null;
            paramHttpEntity = paramHttpEntity.getContentEncoding();
        } while (paramHttpEntity == null);
        return paramHttpEntity.getValue();
    }

    protected static int getLastStatus() {
        return lastStatus;
    }

    private String getNetworkUrl(String paramString) {
        if (this.networkUrl != null) {
            paramString = this.networkUrl;
        }
        String str = paramString;
        if (this.ah != null) {
            str = this.ah.getNetworkUrl(paramString);
        }
        return str;
    }

    private File getPreFile() {
        boolean bool = isStreamingContent();
        Object localObject = null;
        if (bool) {
            if (this.targetFile == null) {
                break label49;
            }
            localObject = this.targetFile;
        }
        for (; ; ) {
            if ((localObject != null) && (!((File) localObject).exists())) {
            }
            try {
                ((File) localObject).getParentFile().mkdirs();
                ((File) localObject).createNewFile();
                return (File) localObject;
            } catch (Exception localException) {
                label49:
                File localFile;
                AQUtility.report(localException);
            }
            if (this.fileCache) {
                localObject = getCacheFile();
            } else {
                localFile = AQUtility.getTempDir();
                localObject = localFile;
                if (localFile == null) {
                    localObject = this.cacheDir;
                }
                localObject = AQUtility.getCacheFile((File) localObject, this.url);
            }
        }
        return null;
    }

    private void httpDelete(String paramString, AjaxStatus paramAjaxStatus)
            throws IOException {
        AQUtility.debug("get", paramString);
        paramString = patchUrl(paramString);
        httpDo(new HttpDelete(paramString), paramString, paramAjaxStatus);
    }

    /* Error */
    private void httpDo(HttpUriRequest paramHttpUriRequest, String paramString, AjaxStatus paramAjaxStatus)
            throws ClientProtocolException, IOException {
        // Byte code:
        //   0: invokestatic 636	com/androidquery/callback/AbstractAjaxCallback:getClient	()Lorg/apache/http/impl/client/DefaultHttpClient;
        //   3: astore 18
        //   5: getstatic 638	com/androidquery/callback/AbstractAjaxCallback:proxyHandle	Lcom/androidquery/callback/ProxyHandle;
        //   8: ifnull +13 -> 21
        //   11: getstatic 638	com/androidquery/callback/AbstractAjaxCallback:proxyHandle	Lcom/androidquery/callback/ProxyHandle;
        //   14: aload_0
        //   15: aload_1
        //   16: aload 18
        //   18: invokevirtual 644	com/androidquery/callback/ProxyHandle:applyProxy	(Lcom/androidquery/callback/AbstractAjaxCallback;Lorg/apache/http/HttpRequest;Lorg/apache/http/impl/client/DefaultHttpClient;)V
        //   21: getstatic 100	com/androidquery/callback/AbstractAjaxCallback:AGENT	Ljava/lang/String;
        //   24: ifnull +267 -> 291
        //   27: aload_1
        //   28: ldc_w 646
        //   31: getstatic 100	com/androidquery/callback/AbstractAjaxCallback:AGENT	Ljava/lang/String;
        //   34: invokeinterface 650 3 0
        //   39: aload_0
        //   40: getfield 652	com/androidquery/callback/AbstractAjaxCallback:headers	Ljava/util/Map;
        //   43: ifnull +29 -> 72
        //   46: aload_0
        //   47: getfield 652	com/androidquery/callback/AbstractAjaxCallback:headers	Ljava/util/Map;
        //   50: invokeinterface 656 1 0
        //   55: invokeinterface 662 1 0
        //   60: astore 8
        //   62: aload 8
        //   64: invokeinterface 667 1 0
        //   69: ifne +249 -> 318
        //   72: getstatic 104	com/androidquery/callback/AbstractAjaxCallback:GZIP	Z
        //   75: ifeq +37 -> 112
        //   78: aload_0
        //   79: getfield 652	com/androidquery/callback/AbstractAjaxCallback:headers	Ljava/util/Map;
        //   82: ifnull +18 -> 100
        //   85: aload_0
        //   86: getfield 652	com/androidquery/callback/AbstractAjaxCallback:headers	Ljava/util/Map;
        //   89: ldc_w 669
        //   92: invokeinterface 673 2 0
        //   97: ifne +15 -> 112
        //   100: aload_1
        //   101: ldc_w 669
        //   104: ldc_w 675
        //   107: invokeinterface 650 3 0
        //   112: aload_0
        //   113: getfield 196	com/androidquery/callback/AbstractAjaxCallback:ah	Lcom/androidquery/auth/AccountHandle;
        //   116: ifnull +12 -> 128
        //   119: aload_0
        //   120: getfield 196	com/androidquery/callback/AbstractAjaxCallback:ah	Lcom/androidquery/auth/AccountHandle;
        //   123: aload_0
        //   124: aload_1
        //   125: invokevirtual 679	com/androidquery/auth/AccountHandle:applyToken	(Lcom/androidquery/callback/AbstractAjaxCallback;Lorg/apache/http/HttpRequest;)V
        //   128: aload_0
        //   129: invokespecial 682	com/androidquery/callback/AbstractAjaxCallback:makeCookie	()Ljava/lang/String;
        //   132: astore 8
        //   134: aload 8
        //   136: ifnull +14 -> 150
        //   139: aload_1
        //   140: ldc_w 684
        //   143: aload 8
        //   145: invokeinterface 650 3 0
        //   150: aload_1
        //   151: invokeinterface 688 1 0
        //   156: astore 8
        //   158: aload_0
        //   159: getfield 690	com/androidquery/callback/AbstractAjaxCallback:proxy	Lorg/apache/http/HttpHost;
        //   162: ifnull +18 -> 180
        //   165: aload 8
        //   167: ldc_w 692
        //   170: aload_0
        //   171: getfield 690	com/androidquery/callback/AbstractAjaxCallback:proxy	Lorg/apache/http/HttpHost;
        //   174: invokeinterface 698 3 0
        //   179: pop
        //   180: aload_0
        //   181: getfield 126	com/androidquery/callback/AbstractAjaxCallback:timeout	I
        //   184: ifle +39 -> 223
        //   187: aload 8
        //   189: ldc_w 700
        //   192: aload_0
        //   193: getfield 126	com/androidquery/callback/AbstractAjaxCallback:timeout	I
        //   196: invokestatic 705	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   199: invokeinterface 698 3 0
        //   204: pop
        //   205: aload 8
        //   207: ldc_w 707
        //   210: aload_0
        //   211: getfield 126	com/androidquery/callback/AbstractAjaxCallback:timeout	I
        //   214: invokestatic 705	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   217: invokeinterface 698 3 0
        //   222: pop
        //   223: aload_0
        //   224: getfield 128	com/androidquery/callback/AbstractAjaxCallback:redirect	Z
        //   227: ifne +15 -> 242
        //   230: aload 8
        //   232: ldc_w 709
        //   235: iconst_0
        //   236: invokeinterface 713 3 0
        //   241: pop
        //   242: new 715	org/apache/http/protocol/BasicHttpContext
        //   245: dup
        //   246: invokespecial 716	org/apache/http/protocol/BasicHttpContext:<init>	()V
        //   249: astore 19
        //   251: aload 19
        //   253: ldc_w 718
        //   256: new 720	org/apache/http/impl/client/BasicCookieStore
        //   259: dup
        //   260: invokespecial 721	org/apache/http/impl/client/BasicCookieStore:<init>	()V
        //   263: invokeinterface 726 3 0
        //   268: aload_0
        //   269: aload_1
        //   270: putfield 192	com/androidquery/callback/AbstractAjaxCallback:request	Lorg/apache/http/client/methods/HttpUriRequest;
        //   273: aload_0
        //   274: getfield 728	com/androidquery/callback/AbstractAjaxCallback:abort	Z
        //   277: ifeq +78 -> 355
        //   280: new 202	java/io/IOException
        //   283: dup
        //   284: ldc_w 730
        //   287: invokespecial 731	java/io/IOException:<init>	(Ljava/lang/String;)V
        //   290: athrow
        //   291: getstatic 100	com/androidquery/callback/AbstractAjaxCallback:AGENT	Ljava/lang/String;
        //   294: ifnonnull -255 -> 39
        //   297: getstatic 104	com/androidquery/callback/AbstractAjaxCallback:GZIP	Z
        //   300: ifeq -261 -> 39
        //   303: aload_1
        //   304: ldc_w 646
        //   307: ldc_w 675
        //   310: invokeinterface 650 3 0
        //   315: goto -276 -> 39
        //   318: aload 8
        //   320: invokeinterface 734 1 0
        //   325: checkcast 112	java/lang/String
        //   328: astore 9
        //   330: aload_1
        //   331: aload 9
        //   333: aload_0
        //   334: getfield 652	com/androidquery/callback/AbstractAjaxCallback:headers	Ljava/util/Map;
        //   337: aload 9
        //   339: invokeinterface 737 2 0
        //   344: checkcast 112	java/lang/String
        //   347: invokeinterface 650 3 0
        //   352: goto -290 -> 62
        //   355: getstatic 108	com/androidquery/callback/AbstractAjaxCallback:SIMULATE_ERROR	Z
        //   358: ifeq +14 -> 372
        //   361: new 202	java/io/IOException
        //   364: dup
        //   365: ldc_w 739
        //   368: invokespecial 731	java/io/IOException:<init>	(Ljava/lang/String;)V
        //   371: athrow
        //   372: aload_0
        //   373: aload_1
        //   374: aload 18
        //   376: aload 19
        //   378: invokespecial 741	com/androidquery/callback/AbstractAjaxCallback:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/impl/client/DefaultHttpClient;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
        //   381: astore 11
        //   383: aconst_null
        //   384: astore 16
        //   386: aconst_null
        //   387: astore 13
        //   389: aload_2
        //   390: astore 10
        //   392: aload 11
        //   394: invokeinterface 747 1 0
        //   399: invokeinterface 752 1 0
        //   404: istore 4
        //   406: aload 11
        //   408: invokeinterface 747 1 0
        //   413: invokeinterface 755 1 0
        //   418: astore 20
        //   420: aconst_null
        //   421: astore 14
        //   423: aconst_null
        //   424: astore 17
        //   426: aconst_null
        //   427: astore 8
        //   429: aload 11
        //   431: invokeinterface 759 1 0
        //   436: astore 21
        //   438: aconst_null
        //   439: astore 15
        //   441: aconst_null
        //   442: astore 12
        //   444: iload 4
        //   446: sipush 200
        //   449: if_icmplt +11 -> 460
        //   452: iload 4
        //   454: sipush 300
        //   457: if_icmplt +255 -> 712
        //   460: aconst_null
        //   461: astore 9
        //   463: aconst_null
        //   464: astore 12
        //   466: aconst_null
        //   467: astore_1
        //   468: aload 21
        //   470: ifnull +55 -> 525
        //   473: aload 12
        //   475: astore 8
        //   477: aload 21
        //   479: invokeinterface 763 1 0
        //   484: astore_1
        //   485: aload_1
        //   486: astore 9
        //   488: aload_1
        //   489: astore 8
        //   491: new 112	java/lang/String
        //   494: dup
        //   495: aload_0
        //   496: aload_0
        //   497: aload 21
        //   499: invokespecial 765	com/androidquery/callback/AbstractAjaxCallback:getEncoding	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
        //   502: aload_1
        //   503: invokespecial 769	com/androidquery/callback/AbstractAjaxCallback:toData	(Ljava/lang/String;Ljava/io/InputStream;)[B
        //   506: ldc -126
        //   508: invokespecial 261	java/lang/String:<init>	([BLjava/lang/String;)V
        //   511: astore 12
        //   513: ldc_w 771
        //   516: aload 12
        //   518: invokestatic 275	com/androidquery/util/AQUtility:debug	(Ljava/lang/Object;Ljava/lang/Object;)V
        //   521: aload 12
        //   523: astore 8
        //   525: aload_1
        //   526: invokestatic 248	com/androidquery/util/AQUtility:close	(Ljava/io/Closeable;)V
        //   529: aload 8
        //   531: astore_1
        //   532: aload 13
        //   534: astore 9
        //   536: aload 15
        //   538: astore 8
        //   540: ldc_w 773
        //   543: iload 4
        //   545: invokestatic 705	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   548: invokestatic 275	com/androidquery/util/AQUtility:debug	(Ljava/lang/Object;Ljava/lang/Object;)V
        //   551: aload 9
        //   553: ifnull +13 -> 566
        //   556: aload 9
        //   558: arraylength
        //   559: invokestatic 705	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   562: aload_2
        //   563: invokestatic 275	com/androidquery/util/AQUtility:debug	(Ljava/lang/Object;Ljava/lang/Object;)V
        //   566: aload_3
        //   567: iload 4
        //   569: invokevirtual 776	com/androidquery/callback/AjaxStatus:code	(I)Lcom/androidquery/callback/AjaxStatus;
        //   572: aload 20
        //   574: invokevirtual 780	com/androidquery/callback/AjaxStatus:message	(Ljava/lang/String;)Lcom/androidquery/callback/AjaxStatus;
        //   577: aload_1
        //   578: invokevirtual 782	com/androidquery/callback/AjaxStatus:error	(Ljava/lang/String;)Lcom/androidquery/callback/AjaxStatus;
        //   581: aload 10
        //   583: invokevirtual 784	com/androidquery/callback/AjaxStatus:redirect	(Ljava/lang/String;)Lcom/androidquery/callback/AjaxStatus;
        //   586: new 471	java/util/Date
        //   589: dup
        //   590: invokespecial 785	java/util/Date:<init>	()V
        //   593: invokevirtual 482	com/androidquery/callback/AjaxStatus:time	(Ljava/util/Date;)Lcom/androidquery/callback/AjaxStatus;
        //   596: aload 9
        //   598: invokevirtual 294	com/androidquery/callback/AjaxStatus:data	([B)Lcom/androidquery/callback/AjaxStatus;
        //   601: aload 8
        //   603: invokevirtual 789	com/androidquery/callback/AjaxStatus:file	(Ljava/io/File;)Lcom/androidquery/callback/AjaxStatus;
        //   606: aload 18
        //   608: invokevirtual 792	com/androidquery/callback/AjaxStatus:client	(Lorg/apache/http/impl/client/DefaultHttpClient;)Lcom/androidquery/callback/AjaxStatus;
        //   611: aload 19
        //   613: invokevirtual 796	com/androidquery/callback/AjaxStatus:context	(Lorg/apache/http/protocol/HttpContext;)Lcom/androidquery/callback/AjaxStatus;
        //   616: aload 11
        //   618: invokeinterface 800 1 0
        //   623: invokevirtual 803	com/androidquery/callback/AjaxStatus:headers	([Lorg/apache/http/Header;)Lcom/androidquery/callback/AjaxStatus;
        //   626: pop
        //   627: return
        //   628: astore 9
        //   630: aload_0
        //   631: getfield 690	com/androidquery/callback/AbstractAjaxCallback:proxy	Lorg/apache/http/HttpHost;
        //   634: ifnull +35 -> 669
        //   637: ldc_w 805
        //   640: invokestatic 241	com/androidquery/util/AQUtility:debug	(Ljava/lang/Object;)V
        //   643: aload 8
        //   645: ldc_w 692
        //   648: aconst_null
        //   649: invokeinterface 698 3 0
        //   654: pop
        //   655: aload_0
        //   656: aload_1
        //   657: aload 18
        //   659: aload 19
        //   661: invokespecial 741	com/androidquery/callback/AbstractAjaxCallback:execute	(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/impl/client/DefaultHttpClient;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
        //   664: astore 11
        //   666: goto -283 -> 383
        //   669: aload 9
        //   671: athrow
        //   672: astore 12
        //   674: aload 17
        //   676: astore_1
        //   677: aload 9
        //   679: astore 8
        //   681: aload 12
        //   683: invokestatic 451	com/androidquery/util/AQUtility:debug	(Ljava/lang/Throwable;)V
        //   686: aload 9
        //   688: invokestatic 248	com/androidquery/util/AQUtility:close	(Ljava/io/Closeable;)V
        //   691: aload 15
        //   693: astore 8
        //   695: aload 13
        //   697: astore 9
        //   699: goto -159 -> 540
        //   702: astore_2
        //   703: aload 8
        //   705: astore_1
        //   706: aload_1
        //   707: invokestatic 248	com/androidquery/util/AQUtility:close	(Ljava/io/Closeable;)V
        //   710: aload_2
        //   711: athrow
        //   712: aload 19
        //   714: ldc_w 807
        //   717: invokeinterface 810 2 0
        //   722: checkcast 342	org/apache/http/HttpHost
        //   725: astore_1
        //   726: aload 19
        //   728: ldc_w 812
        //   731: invokeinterface 810 2 0
        //   736: checkcast 314	org/apache/http/client/methods/HttpUriRequest
        //   739: astore 8
        //   741: new 400	java/lang/StringBuilder
        //   744: dup
        //   745: aload_1
        //   746: invokevirtual 815	org/apache/http/HttpHost:toURI	()Ljava/lang/String;
        //   749: invokestatic 407	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   752: invokespecial 410	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   755: aload 8
        //   757: invokeinterface 318 1 0
        //   762: invokevirtual 818	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   765: invokevirtual 423	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   768: astore 15
        //   770: bipush 32
        //   772: ldc_w 819
        //   775: aload 21
        //   777: invokeinterface 822 1 0
        //   782: l2i
        //   783: invokestatic 828	java/lang/Math:min	(II)I
        //   786: invokestatic 831	java/lang/Math:max	(II)I
        //   789: istore 5
        //   791: aconst_null
        //   792: astore 8
        //   794: aconst_null
        //   795: astore 9
        //   797: aload 9
        //   799: astore_1
        //   800: aload 8
        //   802: astore 10
        //   804: aload_0
        //   805: invokespecial 833	com/androidquery/callback/AbstractAjaxCallback:getPreFile	()Ljava/io/File;
        //   808: astore 17
        //   810: aload 17
        //   812: ifnonnull +164 -> 976
        //   815: aload 9
        //   817: astore_1
        //   818: aload 8
        //   820: astore 10
        //   822: new 835	com/androidquery/util/PredefinedBAOS
        //   825: dup
        //   826: iload 5
        //   828: invokespecial 836	com/androidquery/util/PredefinedBAOS:<init>	(I)V
        //   831: astore 8
        //   833: aload 9
        //   835: astore_1
        //   836: aload 8
        //   838: astore 10
        //   840: aload 21
        //   842: invokeinterface 763 1 0
        //   847: astore 13
        //   849: aload 13
        //   851: astore 9
        //   853: aload 13
        //   855: astore_1
        //   856: aload 8
        //   858: astore 10
        //   860: ldc_w 675
        //   863: aload_0
        //   864: aload 21
        //   866: invokespecial 765	com/androidquery/callback/AbstractAjaxCallback:getEncoding	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
        //   869: invokevirtual 258	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
        //   872: ifeq +21 -> 893
        //   875: aload 13
        //   877: astore_1
        //   878: aload 8
        //   880: astore 10
        //   882: new 838	java/util/zip/GZIPInputStream
        //   885: dup
        //   886: aload 13
        //   888: invokespecial 841	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
        //   891: astore 9
        //   893: aload 9
        //   895: astore_1
        //   896: aload 8
        //   898: astore 10
        //   900: aload_0
        //   901: aload 9
        //   903: aload 8
        //   905: aload 21
        //   907: invokeinterface 822 1 0
        //   912: l2i
        //   913: aload 12
        //   915: aload 17
        //   917: invokespecial 843	com/androidquery/callback/AbstractAjaxCallback:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;ILjava/io/File;Ljava/io/File;)V
        //   920: aload 17
        //   922: ifnonnull +97 -> 1019
        //   925: aload 9
        //   927: astore_1
        //   928: aload 8
        //   930: astore 10
        //   932: aload 8
        //   934: checkcast 835	com/androidquery/util/PredefinedBAOS
        //   937: invokevirtual 846	com/androidquery/util/PredefinedBAOS:toByteArray	()[B
        //   940: astore 12
        //   942: aload 12
        //   944: astore_1
        //   945: aload 17
        //   947: astore 10
        //   949: aload 9
        //   951: invokestatic 248	com/androidquery/util/AQUtility:close	(Ljava/io/Closeable;)V
        //   954: aload 8
        //   956: invokestatic 248	com/androidquery/util/AQUtility:close	(Ljava/io/Closeable;)V
        //   959: aload 10
        //   961: astore 8
        //   963: aload_1
        //   964: astore 9
        //   966: aload 14
        //   968: astore_1
        //   969: aload 15
        //   971: astore 10
        //   973: goto -433 -> 540
        //   976: aload 9
        //   978: astore_1
        //   979: aload 8
        //   981: astore 10
        //   983: aload_0
        //   984: aload 17
        //   986: invokespecial 850	com/androidquery/callback/AbstractAjaxCallback:makeTempFile	(Ljava/io/File;)Ljava/io/File;
        //   989: astore 12
        //   991: aload 9
        //   993: astore_1
        //   994: aload 8
        //   996: astore 10
        //   998: new 852	java/io/BufferedOutputStream
        //   1001: dup
        //   1002: new 854	java/io/FileOutputStream
        //   1005: dup
        //   1006: aload 12
        //   1008: invokespecial 857	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   1011: invokespecial 860	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
        //   1014: astore 8
        //   1016: goto -183 -> 833
        //   1019: aload 9
        //   1021: astore_1
        //   1022: aload 8
        //   1024: astore 10
        //   1026: aload 17
        //   1028: invokevirtual 449	java/io/File:exists	()Z
        //   1031: ifeq +31 -> 1062
        //   1034: aload 9
        //   1036: astore_1
        //   1037: aload 8
        //   1039: astore 10
        //   1041: aload 17
        //   1043: invokevirtual 863	java/io/File:length	()J
        //   1046: lstore 6
        //   1048: aload 17
        //   1050: astore 10
        //   1052: aload 16
        //   1054: astore_1
        //   1055: lload 6
        //   1057: lconst_0
        //   1058: lcmp
        //   1059: ifne -110 -> 949
        //   1062: aconst_null
        //   1063: astore 10
        //   1065: aload 16
        //   1067: astore_1
        //   1068: goto -119 -> 949
        //   1071: astore_2
        //   1072: aload_1
        //   1073: invokestatic 248	com/androidquery/util/AQUtility:close	(Ljava/io/Closeable;)V
        //   1076: aload 10
        //   1078: invokestatic 248	com/androidquery/util/AQUtility:close	(Ljava/io/Closeable;)V
        //   1081: aload_2
        //   1082: athrow
        //   1083: astore_2
        //   1084: goto -378 -> 706
        //   1087: astore 14
        //   1089: aload 12
        //   1091: astore 8
        //   1093: aload_1
        //   1094: astore 9
        //   1096: aload 14
        //   1098: astore 12
        //   1100: aload 8
        //   1102: astore_1
        //   1103: goto -426 -> 677
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	1106	0	this	AbstractAjaxCallback
        //   0	1106	1	paramHttpUriRequest	HttpUriRequest
        //   0	1106	2	paramString	String
        //   0	1106	3	paramAjaxStatus	AjaxStatus
        //   404	164	4	i	int
        //   789	38	5	j	int
        //   1046	10	6	l	long
        //   60	1041	8	localObject1	Object
        //   328	269	9	localObject2	Object
        //   628	59	9	localHttpHostConnectException	org.apache.http.conn.HttpHostConnectException
        //   697	398	9	localObject3	Object
        //   390	687	10	localObject4	Object
        //   381	284	11	localHttpResponse	HttpResponse
        //   442	80	12	str1	String
        //   672	242	12	localException1	Exception
        //   940	159	12	localObject5	Object
        //   387	500	13	localInputStream	InputStream
        //   421	546	14	localObject6	Object
        //   1087	10	14	localException2	Exception
        //   439	531	15	str2	String
        //   384	682	16	localObject7	Object
        //   424	625	17	localFile	File
        //   3	655	18	localDefaultHttpClient	DefaultHttpClient
        //   249	478	19	localBasicHttpContext	org.apache.http.protocol.BasicHttpContext
        //   418	155	20	str3	String
        //   436	470	21	localHttpEntity	HttpEntity
        // Exception table:
        //   from	to	target	type
        //   372	383	628	org/apache/http/conn/HttpHostConnectException
        //   477	485	672	java/lang/Exception
        //   491	513	672	java/lang/Exception
        //   477	485	702	finally
        //   491	513	702	finally
        //   681	686	702	finally
        //   804	810	1071	finally
        //   822	833	1071	finally
        //   840	849	1071	finally
        //   860	875	1071	finally
        //   882	893	1071	finally
        //   900	920	1071	finally
        //   932	942	1071	finally
        //   983	991	1071	finally
        //   998	1016	1071	finally
        //   1026	1034	1071	finally
        //   1041	1048	1071	finally
        //   513	521	1083	finally
        //   513	521	1087	java/lang/Exception
    }

    private void httpEntity(String paramString, HttpEntityEnclosingRequestBase paramHttpEntityEnclosingRequestBase, Map<String, Object> paramMap, AjaxStatus paramAjaxStatus)
            throws ClientProtocolException, IOException {
        paramHttpEntityEnclosingRequestBase.getParams().setBooleanParameter("http.protocol.expect-continue", false);
        Object localObject1 = paramMap.get("%entity");
        if ((localObject1 instanceof HttpEntity)) {
            paramMap = (HttpEntity) localObject1;
            if ((this.headers != null) && (!this.headers.containsKey("Content-Type"))) {
                this.headers.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            }
            paramHttpEntityEnclosingRequestBase.setEntity(paramMap);
            httpDo(paramHttpEntityEnclosingRequestBase, paramString, paramAjaxStatus);
            return;
        }
        localObject1 = new ArrayList();
        paramMap = paramMap.entrySet().iterator();
        for (; ; ) {
            if (!paramMap.hasNext()) {
                paramMap = new UrlEncodedFormEntity((List) localObject1, "UTF-8");
                break;
            }
            Map.Entry localEntry = (Map.Entry) paramMap.next();
            Object localObject2 = localEntry.getValue();
            if (localObject2 != null) {
                ((List) localObject1).add(new BasicNameValuePair((String) localEntry.getKey(), localObject2.toString()));
            }
        }
    }

    private void httpGet(String paramString, AjaxStatus paramAjaxStatus)
            throws IOException {
        AQUtility.debug("get", paramString);
        paramString = patchUrl(paramString);
        httpDo(new HttpGet(paramString), paramString, paramAjaxStatus);
    }

    private void httpMulti(String paramString, Map<String, Object> paramMap, AjaxStatus paramAjaxStatus)
            throws IOException {
        AQUtility.debug("multipart", paramString);
        Object localObject2 = new URL(paramString);
        Object localObject1 = null;
        label85:
        label172:
        label246:
        int i;
        Object localObject3;
        String str;
        if (this.proxy != null) {
            AQUtility.debug("proxy", this.proxy);
            localObject1 = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.proxy.getHostName(), this.proxy.getPort()));
            if (localObject1 != null) {
                break label432;
            }
            localObject1 = (HttpURLConnection) ((URL) localObject2).openConnection();
            ((HttpURLConnection) localObject1).setInstanceFollowRedirects(false);
            ((HttpURLConnection) localObject1).setConnectTimeout(NET_TIMEOUT * 4);
            ((HttpURLConnection) localObject1).setDoInput(true);
            ((HttpURLConnection) localObject1).setDoOutput(true);
            ((HttpURLConnection) localObject1).setUseCaches(false);
            ((HttpURLConnection) localObject1).setRequestMethod("POST");
            ((HttpURLConnection) localObject1).setRequestProperty("Connection", "Keep-Alive");
            ((HttpURLConnection) localObject1).setRequestProperty("Content-Type", "multipart/form-data;charset=utf-8;boundary=*****");
            if (this.headers != null) {
                localObject2 = this.headers.keySet().iterator();
                if (((Iterator) localObject2).hasNext()) {
                    break label447;
                }
            }
            localObject2 = makeCookie();
            if (localObject2 != null) {
                ((HttpURLConnection) localObject1).setRequestProperty("Cookie", (String) localObject2);
            }
            if (this.ah != null) {
                this.ah.applyToken(this, (HttpURLConnection) localObject1);
            }
            localObject2 = new DataOutputStream(((HttpURLConnection) localObject1).getOutputStream());
            paramMap = paramMap.entrySet().iterator();
            if (paramMap.hasNext()) {
                break label483;
            }
            ((DataOutputStream) localObject2).writeBytes("--*****--\r\n");
            ((DataOutputStream) localObject2).flush();
            ((DataOutputStream) localObject2).close();
            ((HttpURLConnection) localObject1).connect();
            i = ((HttpURLConnection) localObject1).getResponseCode();
            localObject3 = ((HttpURLConnection) localObject1).getResponseMessage();
            paramMap = null;
            str = ((HttpURLConnection) localObject1).getContentEncoding();
            localObject2 = null;
            if ((i >= 200) && (i < 300)) {
                break label519;
            }
            localObject1 = new String(toData(str, ((HttpURLConnection) localObject1).getErrorStream()), "UTF-8");
            AQUtility.debug("error", localObject1);
        }
        for (; ; ) {
            AQUtility.debug("response", Integer.valueOf(i));
            if (paramMap != null) {
                AQUtility.debug(Integer.valueOf(paramMap.length), paramString);
            }
            paramAjaxStatus.code(i).message((String) localObject3).redirect(paramString).time(new Date()).data(paramMap).error((String) localObject1).client(null);
            return;
            if (proxyHandle == null) {
                break;
            }
            localObject1 = proxyHandle.makeProxy(this);
            break;
            label432:
            localObject1 = (HttpURLConnection) ((URL) localObject2).openConnection((Proxy) localObject1);
            break label85;
            label447:
            localObject3 = (String) ((Iterator) localObject2).next();
            ((HttpURLConnection) localObject1).setRequestProperty((String) localObject3, (String) this.headers.get(localObject3));
            break label172;
            label483:
            localObject3 = (Map.Entry) paramMap.next();
            writeObject((DataOutputStream) localObject2, (String) ((Map.Entry) localObject3).getKey(), ((Map.Entry) localObject3).getValue());
            break label246;
            label519:
            paramMap = toData(str, ((HttpURLConnection) localObject1).getInputStream());
            localObject1 = localObject2;
        }
    }

    private void httpPost(String paramString, Map<String, Object> paramMap, AjaxStatus paramAjaxStatus)
            throws ClientProtocolException, IOException {
        AQUtility.debug("post", paramString);
        httpEntity(paramString, new HttpPost(paramString), paramMap, paramAjaxStatus);
    }

    private void httpPut(String paramString, Map<String, Object> paramMap, AjaxStatus paramAjaxStatus)
            throws ClientProtocolException, IOException {
        AQUtility.debug("put", paramString);
        httpEntity(paramString, new HttpPut(paramString), paramMap, paramAjaxStatus);
    }

    private boolean isActive() {
        if (this.act == null) {
        }
        Activity localActivity;
        do {
            return true;
            localActivity = (Activity) this.act.get();
        } while ((localActivity != null) && (!localActivity.isFinishing()));
        return false;
    }

    private static boolean isMultiPart(Map<String, Object> paramMap) {
        paramMap = paramMap.entrySet().iterator();
        Object localObject;
        do {
            if (!paramMap.hasNext()) {
                return false;
            }
            Map.Entry localEntry = (Map.Entry) paramMap.next();
            localObject = localEntry.getValue();
            AQUtility.debug(localEntry.getKey(), localObject);
        }
        while ((!(localObject instanceof File)) && (!(localObject instanceof byte[])) && (!(localObject instanceof InputStream)));
        return true;
    }

    private static String makeAuthHeader(String paramString1, String paramString2) {
        paramString1 = (paramString1 + ":" + paramString2).getBytes();
        return "Basic " + new String(AQUtility.encode64(paramString1, 0, paramString1.length));
    }

    private String makeCookie() {
        if ((this.cookies == null) || (this.cookies.size() == 0)) {
            return null;
        }
        Iterator localIterator = this.cookies.keySet().iterator();
        StringBuilder localStringBuilder = new StringBuilder();
        for (; ; ) {
            if (!localIterator.hasNext()) {
                return localStringBuilder.toString();
            }
            String str1 = (String) localIterator.next();
            String str2 = (String) this.cookies.get(str1);
            localStringBuilder.append(str1);
            localStringBuilder.append("=");
            localStringBuilder.append(str2);
            if (localIterator.hasNext()) {
                localStringBuilder.append("; ");
            }
        }
    }

    private File makeTempFile(File paramFile)
            throws IOException {
        paramFile = new File(paramFile.getAbsolutePath() + ".tmp");
        paramFile.createNewFile();
        return paramFile;
    }

    private void network()
            throws IOException {
        String str = this.url;
        Map localMap = this.params;
        Object localObject1 = localMap;
        Object localObject2 = str;
        if (localMap == null) {
            localObject1 = localMap;
            localObject2 = str;
            if (str.length() > 2000) {
                localObject1 = Uri.parse(str);
                localObject2 = extractUrl((Uri) localObject1);
                localObject1 = extractParams((Uri) localObject1);
            }
        }
        str = getNetworkUrl((String) localObject2);
        if (2 == this.method) {
            httpDelete(str, this.status);
            return;
        }
        if (3 == this.method) {
            httpPut(str, (Map) localObject1, this.status);
            return;
        }
        localObject2 = localObject1;
        if (1 == this.method) {
            localObject2 = localObject1;
            if (localObject1 == null) {
                localObject2 = new HashMap();
            }
        }
        if (localObject2 == null) {
            httpGet(str, this.status);
            return;
        }
        if (isMultiPart((Map) localObject2)) {
            httpMulti(str, (Map) localObject2, this.status);
            return;
        }
        httpPost(str, (Map) localObject2, this.status);
    }

    private void network(int paramInt)
            throws IOException {
        if (paramInt <= 1) {
            network();
        }
        for (; ; ) {
            return;
            int i = 0;
            while (i < paramInt) {
                try {
                    network();
                    return;
                } catch (IOException localIOException) {
                    if (i == paramInt - 1) {
                        throw localIOException;
                    }
                    i += 1;
                }
            }
        }
    }

    /* Error */
    private void networkWork() {
        // Byte code:
        //   0: aload_0
        //   1: getfield 142	com/androidquery/callback/AbstractAjaxCallback:url	Ljava/lang/String;
        //   4: ifnonnull +17 -> 21
        //   7: aload_0
        //   8: getfield 300	com/androidquery/callback/AbstractAjaxCallback:status	Lcom/androidquery/callback/AjaxStatus;
        //   11: bipush -101
        //   13: invokevirtual 776	com/androidquery/callback/AjaxStatus:code	(I)Lcom/androidquery/callback/AjaxStatus;
        //   16: invokevirtual 308	com/androidquery/callback/AjaxStatus:done	()Lcom/androidquery/callback/AjaxStatus;
        //   19: pop
        //   20: return
        //   21: aconst_null
        //   22: astore_1
        //   23: aload_0
        //   24: aload_0
        //   25: getfield 138	com/androidquery/callback/AbstractAjaxCallback:retry	I
        //   28: iconst_1
        //   29: iadd
        //   30: invokespecial 1104	com/androidquery/callback/AbstractAjaxCallback:network	(I)V
        //   33: aload_0
        //   34: getfield 196	com/androidquery/callback/AbstractAjaxCallback:ah	Lcom/androidquery/auth/AccountHandle;
        //   37: ifnull +58 -> 95
        //   40: aload_0
        //   41: getfield 196	com/androidquery/callback/AbstractAjaxCallback:ah	Lcom/androidquery/auth/AccountHandle;
        //   44: aload_0
        //   45: aload_0
        //   46: getfield 300	com/androidquery/callback/AbstractAjaxCallback:status	Lcom/androidquery/callback/AjaxStatus;
        //   49: invokevirtual 1108	com/androidquery/auth/AccountHandle:expired	(Lcom/androidquery/callback/AbstractAjaxCallback;Lcom/androidquery/callback/AjaxStatus;)Z
        //   52: ifeq +43 -> 95
        //   55: aload_0
        //   56: getfield 1110	com/androidquery/callback/AbstractAjaxCallback:reauth	Z
        //   59: ifne +36 -> 95
        //   62: ldc_w 1112
        //   65: aload_0
        //   66: getfield 300	com/androidquery/callback/AbstractAjaxCallback:status	Lcom/androidquery/callback/AjaxStatus;
        //   69: invokevirtual 1115	com/androidquery/callback/AjaxStatus:getMessage	()Ljava/lang/String;
        //   72: invokestatic 275	com/androidquery/util/AQUtility:debug	(Ljava/lang/Object;Ljava/lang/Object;)V
        //   75: aload_0
        //   76: iconst_1
        //   77: putfield 1110	com/androidquery/callback/AbstractAjaxCallback:reauth	Z
        //   80: aload_0
        //   81: getfield 196	com/androidquery/callback/AbstractAjaxCallback:ah	Lcom/androidquery/auth/AccountHandle;
        //   84: aload_0
        //   85: invokevirtual 1118	com/androidquery/auth/AccountHandle:reauth	(Lcom/androidquery/callback/AbstractAjaxCallback;)Z
        //   88: ifeq +80 -> 168
        //   91: aload_0
        //   92: invokespecial 1102	com/androidquery/callback/AbstractAjaxCallback:network	()V
        //   95: aload_0
        //   96: getfield 300	com/androidquery/callback/AbstractAjaxCallback:status	Lcom/androidquery/callback/AjaxStatus;
        //   99: invokevirtual 433	com/androidquery/callback/AjaxStatus:getData	()[B
        //   102: astore_2
        //   103: aload_2
        //   104: astore_1
        //   105: aload_0
        //   106: aload_0
        //   107: aload_0
        //   108: getfield 142	com/androidquery/callback/AbstractAjaxCallback:url	Ljava/lang/String;
        //   111: aload_1
        //   112: aload_0
        //   113: getfield 300	com/androidquery/callback/AbstractAjaxCallback:status	Lcom/androidquery/callback/AjaxStatus;
        //   116: invokevirtual 1122	com/androidquery/callback/AbstractAjaxCallback:transform	(Ljava/lang/String;[BLcom/androidquery/callback/AjaxStatus;)Ljava/lang/Object;
        //   119: putfield 147	com/androidquery/callback/AbstractAjaxCallback:result	Ljava/lang/Object;
        //   122: aload_0
        //   123: getfield 147	com/androidquery/callback/AbstractAjaxCallback:result	Ljava/lang/Object;
        //   126: ifnonnull +23 -> 149
        //   129: aload_1
        //   130: ifnull +19 -> 149
        //   133: aload_0
        //   134: getfield 300	com/androidquery/callback/AbstractAjaxCallback:status	Lcom/androidquery/callback/AjaxStatus;
        //   137: bipush -103
        //   139: invokevirtual 776	com/androidquery/callback/AjaxStatus:code	(I)Lcom/androidquery/callback/AjaxStatus;
        //   142: ldc_w 1124
        //   145: invokevirtual 780	com/androidquery/callback/AjaxStatus:message	(Ljava/lang/String;)Lcom/androidquery/callback/AjaxStatus;
        //   148: pop
        //   149: aload_0
        //   150: getfield 300	com/androidquery/callback/AbstractAjaxCallback:status	Lcom/androidquery/callback/AjaxStatus;
        //   153: invokevirtual 454	com/androidquery/callback/AjaxStatus:getCode	()I
        //   156: putstatic 118	com/androidquery/callback/AbstractAjaxCallback:lastStatus	I
        //   159: aload_0
        //   160: getfield 300	com/androidquery/callback/AbstractAjaxCallback:status	Lcom/androidquery/callback/AjaxStatus;
        //   163: invokevirtual 308	com/androidquery/callback/AjaxStatus:done	()Lcom/androidquery/callback/AjaxStatus;
        //   166: pop
        //   167: return
        //   168: aload_0
        //   169: getfield 300	com/androidquery/callback/AbstractAjaxCallback:status	Lcom/androidquery/callback/AjaxStatus;
        //   172: iconst_1
        //   173: invokevirtual 1127	com/androidquery/callback/AjaxStatus:reauth	(Z)Lcom/androidquery/callback/AjaxStatus;
        //   176: pop
        //   177: return
        //   178: astore_2
        //   179: ldc_w 1129
        //   182: invokestatic 241	com/androidquery/util/AQUtility:debug	(Ljava/lang/Object;)V
        //   185: aload_2
        //   186: invokevirtual 1130	java/io/IOException:getMessage	()Ljava/lang/String;
        //   189: astore_2
        //   190: aload_2
        //   191: ifnull +31 -> 222
        //   194: aload_2
        //   195: ldc_w 1132
        //   198: invokevirtual 330	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
        //   201: ifeq +21 -> 222
        //   204: aload_0
        //   205: getfield 300	com/androidquery/callback/AbstractAjaxCallback:status	Lcom/androidquery/callback/AjaxStatus;
        //   208: sipush 401
        //   211: invokevirtual 776	com/androidquery/callback/AjaxStatus:code	(I)Lcom/androidquery/callback/AjaxStatus;
        //   214: aload_2
        //   215: invokevirtual 780	com/androidquery/callback/AjaxStatus:message	(Ljava/lang/String;)Lcom/androidquery/callback/AjaxStatus;
        //   218: pop
        //   219: goto -114 -> 105
        //   222: aload_0
        //   223: getfield 300	com/androidquery/callback/AbstractAjaxCallback:status	Lcom/androidquery/callback/AjaxStatus;
        //   226: bipush -101
        //   228: invokevirtual 776	com/androidquery/callback/AjaxStatus:code	(I)Lcom/androidquery/callback/AjaxStatus;
        //   231: ldc_w 1134
        //   234: invokevirtual 780	com/androidquery/callback/AjaxStatus:message	(Ljava/lang/String;)Lcom/androidquery/callback/AjaxStatus;
        //   237: pop
        //   238: goto -133 -> 105
        //   241: astore_2
        //   242: aload_2
        //   243: invokestatic 451	com/androidquery/util/AQUtility:debug	(Ljava/lang/Throwable;)V
        //   246: aload_0
        //   247: getfield 300	com/androidquery/callback/AbstractAjaxCallback:status	Lcom/androidquery/callback/AjaxStatus;
        //   250: bipush -101
        //   252: invokevirtual 776	com/androidquery/callback/AjaxStatus:code	(I)Lcom/androidquery/callback/AjaxStatus;
        //   255: ldc_w 1134
        //   258: invokevirtual 780	com/androidquery/callback/AjaxStatus:message	(Ljava/lang/String;)Lcom/androidquery/callback/AjaxStatus;
        //   261: pop
        //   262: goto -157 -> 105
        //   265: astore_2
        //   266: aload_2
        //   267: invokestatic 451	com/androidquery/util/AQUtility:debug	(Ljava/lang/Throwable;)V
        //   270: goto -148 -> 122
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	273	0	this	AbstractAjaxCallback
        //   22	108	1	localObject	Object
        //   102	2	2	arrayOfByte	byte[]
        //   178	8	2	localIOException	IOException
        //   189	26	2	str	String
        //   241	2	2	localException1	Exception
        //   265	2	2	localException2	Exception
        // Exception table:
        //   from	to	target	type
        //   23	95	178	java/io/IOException
        //   95	103	178	java/io/IOException
        //   168	177	178	java/io/IOException
        //   23	95	241	java/lang/Exception
        //   95	103	241	java/lang/Exception
        //   168	177	241	java/lang/Exception
        //   105	122	265	java/lang/Exception
    }

    private String parseCharset(String paramString) {
        if (paramString == null) {
        }
        int k;
        do {
            return null;
            k = paramString.indexOf("charset");
        } while (k == -1);
        int j = paramString.indexOf(";", k);
        int i = j;
        if (j == -1) {
            i = paramString.length();
        }
        return paramString.substring(k + 7, i).replaceAll("[^\\w-]", "");
    }

    private static String patchUrl(String paramString) {
        return paramString.replaceAll(" ", "%20").replaceAll("\\|", "%7C");
    }

    private K self() {
        return this;
    }

    public static void setAgent(String paramString) {
        AGENT = paramString;
    }

    public static void setGZip(boolean paramBoolean) {
        GZIP = paramBoolean;
    }

    public static void setNetworkLimit(int paramInt) {
        NETWORK_POOL = Math.max(1, Math.min(25, paramInt));
        fetchExe = null;
        AQUtility.debug("setting network limit", Integer.valueOf(NETWORK_POOL));
    }

    public static void setProxyHandle(ProxyHandle paramProxyHandle) {
        proxyHandle = paramProxyHandle;
    }

    public static void setReuseHttpClient(boolean paramBoolean) {
        REUSE_CLIENT = paramBoolean;
        client = null;
    }

    public static void setSSF(SocketFactory paramSocketFactory) {
        ssf = paramSocketFactory;
        client = null;
    }

    public static void setSimulateError(boolean paramBoolean) {
        SIMULATE_ERROR = paramBoolean;
    }

    public static void setTimeout(int paramInt) {
        NET_TIMEOUT = paramInt;
    }

    public static void setTransformer(Transformer paramTransformer) {
        st = paramTransformer;
    }

    private byte[] toData(String paramString, InputStream paramInputStream)
            throws IOException {
        Object localObject = paramInputStream;
        if ("gzip".equalsIgnoreCase(paramString)) {
            localObject = new GZIPInputStream(paramInputStream);
        }
        return AQUtility.toBytes((InputStream) localObject);
    }

    /* Error */
    private void wake() {
        // Byte code:
        //   0: aload_0
        //   1: getfield 1187	com/androidquery/callback/AbstractAjaxCallback:blocked	Z
        //   4: ifne +4 -> 8
        //   7: return
        //   8: aload_0
        //   9: monitorenter
        //   10: aload_0
        //   11: invokevirtual 1190	java/lang/Object:notifyAll	()V
        //   14: aload_0
        //   15: monitorexit
        //   16: return
        //   17: astore_1
        //   18: aload_0
        //   19: monitorexit
        //   20: aload_1
        //   21: athrow
        //   22: astore_1
        //   23: goto -9 -> 14
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	26	0	this	AbstractAjaxCallback
        //   17	4	1	localObject	Object
        //   22	1	1	localException	Exception
        // Exception table:
        //   from	to	target	type
        //   10	14	17	finally
        //   14	16	17	finally
        //   18	20	17	finally
        //   10	14	22	java/lang/Exception
    }

    private void work(Context paramContext) {
        Object localObject = memGet(this.url);
        if (localObject != null) {
            this.result = localObject;
            this.status.source(4).done();
            callback();
            return;
        }
        this.cacheDir = AQUtility.getCacheDir(paramContext, this.policy);
        execute(this);
    }

    private static void writeData(DataOutputStream paramDataOutputStream, String paramString1, String paramString2, InputStream paramInputStream)
            throws IOException {
        paramDataOutputStream.writeBytes("--*****\r\n");
        paramDataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + paramString1 + "\";" + " filename=\"" + paramString2 + "\"" + "\r\n");
        paramDataOutputStream.writeBytes("Content-Type: application/octet-stream");
        paramDataOutputStream.writeBytes("\r\n");
        paramDataOutputStream.writeBytes("Content-Transfer-Encoding: binary");
        paramDataOutputStream.writeBytes("\r\n");
        paramDataOutputStream.writeBytes("\r\n");
        AQUtility.copy(paramInputStream, paramDataOutputStream);
        paramDataOutputStream.writeBytes("\r\n");
    }

    private static void writeField(DataOutputStream paramDataOutputStream, String paramString1, String paramString2)
            throws IOException {
        paramDataOutputStream.writeBytes("--*****\r\n");
        paramDataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + paramString1 + "\"");
        paramDataOutputStream.writeBytes("\r\n");
        paramDataOutputStream.writeBytes("\r\n");
        paramDataOutputStream.write(paramString2.getBytes("UTF-8"));
        paramDataOutputStream.writeBytes("\r\n");
    }

    private static void writeObject(DataOutputStream paramDataOutputStream, String paramString, Object paramObject)
            throws IOException {
        if (paramObject == null) {
            return;
        }
        if ((paramObject instanceof File)) {
            paramObject = (File) paramObject;
            writeData(paramDataOutputStream, paramString, ((File) paramObject).getName(), new FileInputStream((File) paramObject));
            return;
        }
        if ((paramObject instanceof byte[])) {
            writeData(paramDataOutputStream, paramString, paramString, new ByteArrayInputStream((byte[]) paramObject));
            return;
        }
        if ((paramObject instanceof InputStream)) {
            writeData(paramDataOutputStream, paramString, paramString, (InputStream) paramObject);
            return;
        }
        writeField(paramDataOutputStream, paramString, paramObject.toString());
    }

    public void abort() {
        this.abort = true;
        if ((this.request != null) && (!this.request.isAborted())) {
            this.request.abort();
        }
    }

    protected File accessFile(File paramFile, String paramString) {
        if (this.expire < 0L) {
            paramFile = null;
        }
        do {
            do {
                do {
                    return paramFile;
                    paramString = AQUtility.getExistedCacheByUrl(paramFile, paramString);
                    paramFile = paramString;
                } while (paramString == null);
                paramFile = paramString;
            } while (this.expire == 0L);
            paramFile = paramString;
        } while (System.currentTimeMillis() - paramString.lastModified() <= this.expire);
        return null;
    }

    public void async(Activity paramActivity) {
        if (paramActivity.isFinishing()) {
            AQUtility.warn("Warning", "Possible memory leak. Calling ajax with a terminated activity.");
        }
        if (this.type == null) {
            AQUtility.warn("Warning", "type() is not called with response type.");
            return;
        }
        this.act = new WeakReference(paramActivity);
        async(paramActivity);
    }

    public void async(Context paramContext) {
        if (this.status == null) {
            this.status = new AjaxStatus();
            this.status.redirect(this.url).refresh(this.refresh);
        }
        for (; ; ) {
            showProgress(true);
            if ((this.ah == null) || (this.ah.authenticated())) {
                break;
            }
            AQUtility.debug("auth needed", this.url);
            this.ah.auth(this);
            return;
            if (this.status.getDone()) {
                this.status.reset();
                this.result = null;
            }
        }
        work(paramContext);
    }

    public K auth(Activity paramActivity, String paramString1, String paramString2) {
        if ((Build.VERSION.SDK_INT >= 5) && (paramString1.startsWith("g."))) {
            this.ah = new GoogleHandle(paramActivity, paramString1, paramString2);
        }
        return (K) self();
    }

    public K auth(AccountHandle paramAccountHandle) {
        this.ah = paramAccountHandle;
        return (K) self();
    }

    public void block() {
        if (AQUtility.isUIThread()) {
            throw new IllegalStateException("Cannot block UI thread.");
        }
        if (this.completed) {
            return;
        }
        try {
            try {
                this.blocked = true;
                wait(NET_TIMEOUT + 5000);
                return;
            } finally {
            }
            return;
        } catch (Exception localException) {
        }
    }

    protected boolean cacheAvailable(Context paramContext) {
        return (this.fileCache) && (AQUtility.getExistedCacheByUrl(AQUtility.getCacheDir(paramContext, this.policy), this.url) != null);
    }

    void callback() {
        showProgress(false);
        this.completed = true;
        if (isActive()) {
            if (this.callback != null) {
                Object localObject1 = getHandler();
                Class localClass = this.type;
                String str1 = this.callback;
                Class[] arrayOfClass = DEFAULT_SIG;
                String str2 = this.url;
                Object localObject2 = this.result;
                AjaxStatus localAjaxStatus = this.status;
                AQUtility.invokeHandler(localObject1, str1, true, true, new Class[]{String.class, localClass, AjaxStatus.class}, arrayOfClass, new Object[]{str2, localObject2, localAjaxStatus});
            }
        }
        for (; ; ) {
            filePut();
            if (!this.blocked) {
                this.status.close();
            }
            wake();
            AQUtility.debugNotify();
            return;
            try {
                callback(this.url, this.result, this.status);
            } catch (Exception localException) {
                AQUtility.report(localException);
            }
            continue;
            skip(this.url, this.result, this.status);
        }
    }

    public void callback(String paramString, T paramT, AjaxStatus paramAjaxStatus) {
    }

    public K cookie(String paramString1, String paramString2) {
        if (this.cookies == null) {
            this.cookies = new HashMap();
        }
        this.cookies.put(paramString1, paramString2);
        return (K) self();
    }

    public K cookies(Map<String, String> paramMap) {
        this.cookies = paramMap;
        return (K) self();
    }

    protected T datastoreGet(String paramString) {
        return null;
    }

    public K encoding(String paramString) {
        this.encoding = paramString;
        return (K) self();
    }

    public K expire(long paramLong) {
        this.expire = paramLong;
        return (K) self();
    }

    public void failure(int paramInt, String paramString) {
        if (this.status != null) {
            this.status.code(paramInt).message(paramString).done();
            if (this.uiCallback) {
                AQUtility.post(this);
            }
        } else {
            return;
        }
        afterWork();
    }

    public K fileCache(boolean paramBoolean) {
        this.fileCache = paramBoolean;
        return (K) self();
    }

    protected T fileGet(String paramString, File paramFile, AjaxStatus paramAjaxStatus) {
        Object localObject = null;
        try {
            if (isStreamingContent()) {
                paramAjaxStatus.file(paramFile);
            }
            for (paramFile = (File) localObject; ; paramFile = AQUtility.toBytes(new FileInputStream(paramFile))) {
                return (T) transform(paramString, paramFile, paramAjaxStatus);
            }
            return null;
        } catch (Exception paramString) {
            AQUtility.debug(paramString);
        }
    }

    protected void filePut(String paramString, T paramT, File paramFile, byte[] paramArrayOfByte) {
        if ((paramFile == null) || (paramArrayOfByte == null)) {
            return;
        }
        AQUtility.storeAsync(paramFile, paramArrayOfByte, 0L);
    }

    protected File getCacheFile() {
        return AQUtility.getCacheFile(this.cacheDir, getCacheUrl());
    }

    public String getCallback() {
        return this.callback;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public Object getHandler() {
        if (this.handler != null) {
            return this.handler;
        }
        if (this.whandler == null) {
            return null;
        }
        return this.whandler.get();
    }

    public T getResult() {
        return (T) this.result;
    }

    public AjaxStatus getStatus() {
        return this.status;
    }

    public Class<T> getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public K handler(Object paramObject, String paramString) {
        this.handler = paramObject;
        this.callback = paramString;
        this.whandler = null;
        return (K) self();
    }

    public K header(String paramString1, String paramString2) {
        if (this.headers == null) {
            this.headers = new HashMap();
        }
        this.headers.put(paramString1, paramString2);
        return (K) self();
    }

    public K headers(Map<String, String> paramMap) {
        this.headers = paramMap;
        return (K) self();
    }

    protected boolean isStreamingContent() {
        return (File.class.equals(this.type)) || (XmlPullParser.class.equals(this.type)) || (InputStream.class.equals(this.type)) || (XmlDom.class.equals(this.type));
    }

    public K memCache(boolean paramBoolean) {
        this.memCache = paramBoolean;
        return (K) self();
    }

    protected T memGet(String paramString) {
        return null;
    }

    protected void memPut(String paramString, T paramT) {
    }

    public K method(int paramInt) {
        this.method = paramInt;
        return (K) self();
    }

    public K networkUrl(String paramString) {
        this.networkUrl = paramString;
        return (K) self();
    }

    public K param(String paramString, Object paramObject) {
        if (this.params == null) {
            this.params = new HashMap();
        }
        this.params.put(paramString, paramObject);
        return (K) self();
    }

    public K params(Map<String, ?> paramMap) {
        this.params = paramMap;
        return (K) self();
    }

    public K policy(int paramInt) {
        this.policy = paramInt;
        return (K) self();
    }

    public K progress(Dialog paramDialog) {
        return (K) progress(paramDialog);
    }

    public K progress(View paramView) {
        return (K) progress(paramView);
    }

    public K progress(Object paramObject) {
        if (paramObject != null) {
            this.progress = new WeakReference(paramObject);
        }
        return (K) self();
    }

    public K proxy(String paramString, int paramInt) {
        this.proxy = new HttpHost(paramString, paramInt);
        return (K) self();
    }

    public K proxy(String paramString1, int paramInt, String paramString2, String paramString3) {
        proxy(paramString1, paramInt);
        paramString1 = makeAuthHeader(paramString2, paramString3);
        AQUtility.debug("proxy auth", paramString1);
        return (K) header("Proxy-Authorization", paramString1);
    }

    public K redirect(boolean paramBoolean) {
        this.redirect = paramBoolean;
        return (K) self();
    }

    public K refresh(boolean paramBoolean) {
        this.refresh = paramBoolean;
        return (K) self();
    }

    public K retry(int paramInt) {
        this.retry = paramInt;
        return (K) self();
    }

    public void run() {
        if (!this.status.getDone()) {
            try {
                backgroundWork();
                if (!this.status.getReauth()) {
                    if (this.uiCallback) {
                        AQUtility.post(this);
                    }
                } else {
                    return;
                }
            } catch (Throwable localThrowable) {
                for (; ; ) {
                    AQUtility.debug(localThrowable);
                    this.status.code(-101).done();
                }
                afterWork();
                return;
            }
        }
        afterWork();
    }

    protected void showProgress(final boolean paramBoolean) {
        if (this.progress == null) {
        }
        for (final Object localObject = null; ; localObject = this.progress.get()) {
            if (localObject != null) {
                if (!AQUtility.isUIThread()) {
                    break;
                }
                Common.showProgress(localObject, this.url, paramBoolean);
            }
            return;
        }
        AQUtility.post(new Runnable() {
            public void run() {
                Common.showProgress(localObject, AbstractAjaxCallback.this.url, paramBoolean);
            }
        });
    }

    protected void skip(String paramString, T paramT, AjaxStatus paramAjaxStatus) {
    }

    public K targetFile(File paramFile) {
        this.targetFile = paramFile;
        return (K) self();
    }

    public K timeout(int paramInt) {
        this.timeout = paramInt;
        return (K) self();
    }

    /* Error */
    protected T transform(String paramString, byte[] paramArrayOfByte, AjaxStatus paramAjaxStatus) {
        // Byte code:
        //   0: aload_0
        //   1: getfield 1265	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
        //   4: ifnonnull +5 -> 9
        //   7: aconst_null
        //   8: areturn
        //   9: aload_3
        //   10: invokevirtual 1450	com/androidquery/callback/AjaxStatus:getFile	()Ljava/io/File;
        //   13: astore 4
        //   15: aload_2
        //   16: ifnull +266 -> 282
        //   19: aload_0
        //   20: getfield 1265	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
        //   23: ldc_w 1452
        //   26: invokevirtual 1396	java/lang/Object:equals	(Ljava/lang/Object;)Z
        //   29: ifeq +11 -> 40
        //   32: aload_2
        //   33: iconst_0
        //   34: aload_2
        //   35: arraylength
        //   36: invokestatic 1458	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
        //   39: areturn
        //   40: aload_0
        //   41: getfield 1265	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
        //   44: ldc_w 1460
        //   47: invokevirtual 1396	java/lang/Object:equals	(Ljava/lang/Object;)Z
        //   50: ifeq +50 -> 100
        //   53: aconst_null
        //   54: astore_1
        //   55: new 112	java/lang/String
        //   58: dup
        //   59: aload_2
        //   60: aload_0
        //   61: getfield 132	com/androidquery/callback/AbstractAjaxCallback:encoding	Ljava/lang/String;
        //   64: invokespecial 261	java/lang/String:<init>	([BLjava/lang/String;)V
        //   67: astore_2
        //   68: new 1462	org/json/JSONTokener
        //   71: dup
        //   72: aload_2
        //   73: invokespecial 1463	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
        //   76: invokevirtual 1466	org/json/JSONTokener:nextValue	()Ljava/lang/Object;
        //   79: checkcast 1460	org/json/JSONObject
        //   82: astore_1
        //   83: aload_1
        //   84: areturn
        //   85: astore_3
        //   86: aload_1
        //   87: astore_2
        //   88: aload_3
        //   89: astore_1
        //   90: aload_1
        //   91: invokestatic 451	com/androidquery/util/AQUtility:debug	(Ljava/lang/Throwable;)V
        //   94: aload_2
        //   95: invokestatic 241	com/androidquery/util/AQUtility:debug	(Ljava/lang/Object;)V
        //   98: aconst_null
        //   99: areturn
        //   100: aload_0
        //   101: getfield 1265	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
        //   104: ldc_w 1468
        //   107: invokevirtual 1396	java/lang/Object:equals	(Ljava/lang/Object;)Z
        //   110: ifeq +38 -> 148
        //   113: new 1462	org/json/JSONTokener
        //   116: dup
        //   117: new 112	java/lang/String
        //   120: dup
        //   121: aload_2
        //   122: aload_0
        //   123: getfield 132	com/androidquery/callback/AbstractAjaxCallback:encoding	Ljava/lang/String;
        //   126: invokespecial 261	java/lang/String:<init>	([BLjava/lang/String;)V
        //   129: invokespecial 1463	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
        //   132: invokevirtual 1466	org/json/JSONTokener:nextValue	()Ljava/lang/Object;
        //   135: checkcast 1468	org/json/JSONArray
        //   138: astore_1
        //   139: aload_1
        //   140: areturn
        //   141: astore_1
        //   142: aload_1
        //   143: invokestatic 451	com/androidquery/util/AQUtility:debug	(Ljava/lang/Throwable;)V
        //   146: aconst_null
        //   147: areturn
        //   148: aload_0
        //   149: getfield 1265	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
        //   152: ldc 112
        //   154: invokevirtual 1396	java/lang/Object:equals	(Ljava/lang/Object;)Z
        //   157: ifeq +56 -> 213
        //   160: aload_3
        //   161: invokevirtual 436	com/androidquery/callback/AjaxStatus:getSource	()I
        //   164: iconst_1
        //   165: if_icmpne +20 -> 185
        //   168: ldc_w 1469
        //   171: invokestatic 241	com/androidquery/util/AQUtility:debug	(Ljava/lang/Object;)V
        //   174: aload_0
        //   175: aload_2
        //   176: aload_0
        //   177: getfield 132	com/androidquery/callback/AbstractAjaxCallback:encoding	Ljava/lang/String;
        //   180: aload_3
        //   181: invokespecial 1471	com/androidquery/callback/AbstractAjaxCallback:correctEncoding	([BLjava/lang/String;Lcom/androidquery/callback/AjaxStatus;)Ljava/lang/String;
        //   184: areturn
        //   185: ldc_w 1472
        //   188: invokestatic 241	com/androidquery/util/AQUtility:debug	(Ljava/lang/Object;)V
        //   191: new 112	java/lang/String
        //   194: dup
        //   195: aload_2
        //   196: aload_0
        //   197: getfield 132	com/androidquery/callback/AbstractAjaxCallback:encoding	Ljava/lang/String;
        //   200: invokespecial 261	java/lang/String:<init>	([BLjava/lang/String;)V
        //   203: astore_1
        //   204: aload_1
        //   205: areturn
        //   206: astore_1
        //   207: aload_1
        //   208: invokestatic 451	com/androidquery/util/AQUtility:debug	(Ljava/lang/Throwable;)V
        //   211: aconst_null
        //   212: areturn
        //   213: aload_0
        //   214: getfield 1265	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
        //   217: ldc_w 1044
        //   220: invokevirtual 1396	java/lang/Object:equals	(Ljava/lang/Object;)Z
        //   223: ifeq +5 -> 228
        //   226: aload_2
        //   227: areturn
        //   228: aload_0
        //   229: getfield 194	com/androidquery/callback/AbstractAjaxCallback:transformer	Lcom/androidquery/callback/Transformer;
        //   232: ifnull +24 -> 256
        //   235: aload_0
        //   236: getfield 194	com/androidquery/callback/AbstractAjaxCallback:transformer	Lcom/androidquery/callback/Transformer;
        //   239: aload_1
        //   240: aload_0
        //   241: getfield 1265	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
        //   244: aload_0
        //   245: getfield 132	com/androidquery/callback/AbstractAjaxCallback:encoding	Ljava/lang/String;
        //   248: aload_2
        //   249: aload_3
        //   250: invokeinterface 1477 6 0
        //   255: areturn
        //   256: getstatic 1180	com/androidquery/callback/AbstractAjaxCallback:st	Lcom/androidquery/callback/Transformer;
        //   259: ifnull +177 -> 436
        //   262: getstatic 1180	com/androidquery/callback/AbstractAjaxCallback:st	Lcom/androidquery/callback/Transformer;
        //   265: aload_1
        //   266: aload_0
        //   267: getfield 1265	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
        //   270: aload_0
        //   271: getfield 132	com/androidquery/callback/AbstractAjaxCallback:encoding	Ljava/lang/String;
        //   274: aload_2
        //   275: aload_3
        //   276: invokeinterface 1477 6 0
        //   281: areturn
        //   282: aload 4
        //   284: ifnull +152 -> 436
        //   287: aload_0
        //   288: getfield 1265	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
        //   291: ldc -24
        //   293: invokevirtual 1396	java/lang/Object:equals	(Ljava/lang/Object;)Z
        //   296: ifeq +6 -> 302
        //   299: aload 4
        //   301: areturn
        //   302: aload_0
        //   303: getfield 1265	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
        //   306: ldc_w 1400
        //   309: invokevirtual 1396	java/lang/Object:equals	(Ljava/lang/Object;)Z
        //   312: ifeq +36 -> 348
        //   315: new 1230	java/io/FileInputStream
        //   318: dup
        //   319: aload 4
        //   321: invokespecial 1231	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   324: astore_1
        //   325: new 1400	com/androidquery/util/XmlDom
        //   328: dup
        //   329: aload_1
        //   330: invokespecial 1478	com/androidquery/util/XmlDom:<init>	(Ljava/io/InputStream;)V
        //   333: astore_2
        //   334: aload_3
        //   335: aload_1
        //   336: invokevirtual 1481	com/androidquery/callback/AjaxStatus:closeLater	(Ljava/io/Closeable;)V
        //   339: aload_2
        //   340: areturn
        //   341: astore_1
        //   342: aload_1
        //   343: invokestatic 279	com/androidquery/util/AQUtility:report	(Ljava/lang/Throwable;)V
        //   346: aconst_null
        //   347: areturn
        //   348: aload_0
        //   349: getfield 1265	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
        //   352: ldc_w 1398
        //   355: invokevirtual 1396	java/lang/Object:equals	(Ljava/lang/Object;)Z
        //   358: ifeq +42 -> 400
        //   361: invokestatic 1487	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
        //   364: astore_1
        //   365: new 1230	java/io/FileInputStream
        //   368: dup
        //   369: aload 4
        //   371: invokespecial 1231	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   374: astore_2
        //   375: aload_1
        //   376: aload_2
        //   377: aload_0
        //   378: getfield 132	com/androidquery/callback/AbstractAjaxCallback:encoding	Ljava/lang/String;
        //   381: invokeinterface 1491 3 0
        //   386: aload_3
        //   387: aload_2
        //   388: invokevirtual 1481	com/androidquery/callback/AjaxStatus:closeLater	(Ljava/io/Closeable;)V
        //   391: aload_1
        //   392: areturn
        //   393: astore_1
        //   394: aload_1
        //   395: invokestatic 279	com/androidquery/util/AQUtility:report	(Ljava/lang/Throwable;)V
        //   398: aconst_null
        //   399: areturn
        //   400: aload_0
        //   401: getfield 1265	com/androidquery/callback/AbstractAjaxCallback:type	Ljava/lang/Class;
        //   404: ldc -32
        //   406: invokevirtual 1396	java/lang/Object:equals	(Ljava/lang/Object;)Z
        //   409: ifeq +27 -> 436
        //   412: new 1230	java/io/FileInputStream
        //   415: dup
        //   416: aload 4
        //   418: invokespecial 1231	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   421: astore_1
        //   422: aload_3
        //   423: aload_1
        //   424: invokevirtual 1481	com/androidquery/callback/AjaxStatus:closeLater	(Ljava/io/Closeable;)V
        //   427: aload_1
        //   428: areturn
        //   429: astore_1
        //   430: aload_1
        //   431: invokestatic 279	com/androidquery/util/AQUtility:report	(Ljava/lang/Throwable;)V
        //   434: aconst_null
        //   435: areturn
        //   436: aconst_null
        //   437: areturn
        //   438: astore_1
        //   439: goto -97 -> 342
        //   442: astore_1
        //   443: goto -353 -> 90
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	446	0	this	AbstractAjaxCallback
        //   0	446	1	paramString	String
        //   0	446	2	paramArrayOfByte	byte[]
        //   0	446	3	paramAjaxStatus	AjaxStatus
        //   13	404	4	localFile	File
        // Exception table:
        //   from	to	target	type
        //   55	68	85	java/lang/Exception
        //   113	139	141	java/lang/Exception
        //   191	204	206	java/lang/Exception
        //   315	334	341	java/lang/Exception
        //   365	391	393	java/lang/Exception
        //   412	427	429	java/lang/Exception
        //   334	339	438	java/lang/Exception
        //   68	83	442	java/lang/Exception
    }

    public K transformer(Transformer paramTransformer) {
        this.transformer = paramTransformer;
        return (K) self();
    }

    public K type(Class<T> paramClass) {
        this.type = paramClass;
        return (K) self();
    }

    public K uiCallback(boolean paramBoolean) {
        this.uiCallback = paramBoolean;
        return (K) self();
    }

    public K url(String paramString) {
        this.url = paramString;
        return (K) self();
    }

    public K weakHandler(Object paramObject, String paramString) {
        this.whandler = new WeakReference(paramObject);
        this.callback = paramString;
        this.handler = null;
        return (K) self();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/androidquery/callback/AbstractAjaxCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */