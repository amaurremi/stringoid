package com.amazonaws.org.apache.http.impl.client;

import com.amazonaws.org.apache.http.ConnectionReuseStrategy;
import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpRequestInterceptor;
import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.HttpResponseInterceptor;
import com.amazonaws.org.apache.http.auth.AuthSchemeRegistry;
import com.amazonaws.org.apache.http.client.AuthenticationStrategy;
import com.amazonaws.org.apache.http.client.BackoffManager;
import com.amazonaws.org.apache.http.client.ClientProtocolException;
import com.amazonaws.org.apache.http.client.ConnectionBackoffStrategy;
import com.amazonaws.org.apache.http.client.CookieStore;
import com.amazonaws.org.apache.http.client.CredentialsProvider;
import com.amazonaws.org.apache.http.client.HttpClient;
import com.amazonaws.org.apache.http.client.HttpRequestRetryHandler;
import com.amazonaws.org.apache.http.client.RedirectStrategy;
import com.amazonaws.org.apache.http.client.RequestDirector;
import com.amazonaws.org.apache.http.client.UserTokenHandler;
import com.amazonaws.org.apache.http.client.methods.HttpUriRequest;
import com.amazonaws.org.apache.http.client.utils.URIUtils;
import com.amazonaws.org.apache.http.conn.ClientConnectionManager;
import com.amazonaws.org.apache.http.conn.ClientConnectionManagerFactory;
import com.amazonaws.org.apache.http.conn.ConnectionKeepAliveStrategy;
import com.amazonaws.org.apache.http.conn.routing.HttpRoutePlanner;
import com.amazonaws.org.apache.http.conn.scheme.SchemeRegistry;
import com.amazonaws.org.apache.http.cookie.CookieSpecRegistry;
import com.amazonaws.org.apache.http.impl.DefaultConnectionReuseStrategy;
import com.amazonaws.org.apache.http.impl.auth.BasicSchemeFactory;
import com.amazonaws.org.apache.http.impl.auth.DigestSchemeFactory;
import com.amazonaws.org.apache.http.impl.auth.KerberosSchemeFactory;
import com.amazonaws.org.apache.http.impl.auth.NTLMSchemeFactory;
import com.amazonaws.org.apache.http.impl.auth.SPNegoSchemeFactory;
import com.amazonaws.org.apache.http.impl.conn.BasicClientConnectionManager;
import com.amazonaws.org.apache.http.impl.conn.DefaultHttpRoutePlanner;
import com.amazonaws.org.apache.http.impl.conn.SchemeRegistryFactory;
import com.amazonaws.org.apache.http.impl.cookie.BestMatchSpecFactory;
import com.amazonaws.org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import com.amazonaws.org.apache.http.impl.cookie.IgnoreSpecFactory;
import com.amazonaws.org.apache.http.impl.cookie.NetscapeDraftSpecFactory;
import com.amazonaws.org.apache.http.impl.cookie.RFC2109SpecFactory;
import com.amazonaws.org.apache.http.impl.cookie.RFC2965SpecFactory;
import com.amazonaws.org.apache.http.params.HttpParams;
import com.amazonaws.org.apache.http.protocol.BasicHttpContext;
import com.amazonaws.org.apache.http.protocol.BasicHttpProcessor;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import com.amazonaws.org.apache.http.protocol.HttpProcessor;
import com.amazonaws.org.apache.http.protocol.HttpRequestExecutor;
import com.amazonaws.org.apache.http.protocol.ImmutableHttpProcessor;
import java.net.URI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;

@ThreadSafe
public abstract class AbstractHttpClient
  implements HttpClient
{
  @GuardedBy("this")
  private BackoffManager backoffManager;
  @GuardedBy("this")
  private ClientConnectionManager connManager;
  @GuardedBy("this")
  private ConnectionBackoffStrategy connectionBackoffStrategy;
  @GuardedBy("this")
  private CookieStore cookieStore;
  @GuardedBy("this")
  private CredentialsProvider credsProvider;
  @GuardedBy("this")
  private HttpParams defaultParams;
  @GuardedBy("this")
  private ConnectionKeepAliveStrategy keepAliveStrategy;
  private final Log log = LogFactory.getLog(getClass());
  @GuardedBy("this")
  private BasicHttpProcessor mutableProcessor;
  @GuardedBy("this")
  private ImmutableHttpProcessor protocolProcessor;
  @GuardedBy("this")
  private AuthenticationStrategy proxyAuthStrategy;
  @GuardedBy("this")
  private RedirectStrategy redirectStrategy;
  @GuardedBy("this")
  private HttpRequestExecutor requestExec;
  @GuardedBy("this")
  private HttpRequestRetryHandler retryHandler;
  @GuardedBy("this")
  private ConnectionReuseStrategy reuseStrategy;
  @GuardedBy("this")
  private HttpRoutePlanner routePlanner;
  @GuardedBy("this")
  private AuthSchemeRegistry supportedAuthSchemes;
  @GuardedBy("this")
  private CookieSpecRegistry supportedCookieSpecs;
  @GuardedBy("this")
  private AuthenticationStrategy targetAuthStrategy;
  @GuardedBy("this")
  private UserTokenHandler userTokenHandler;
  
  protected AbstractHttpClient(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams)
  {
    this.defaultParams = paramHttpParams;
    this.connManager = paramClientConnectionManager;
  }
  
  private static HttpHost determineTarget(HttpUriRequest paramHttpUriRequest)
  {
    HttpHost localHttpHost = null;
    URI localURI = paramHttpUriRequest.getURI();
    paramHttpUriRequest = localHttpHost;
    if (localURI.isAbsolute())
    {
      localHttpHost = URIUtils.extractHost(localURI);
      paramHttpUriRequest = localHttpHost;
      if (localHttpHost == null) {
        throw new ClientProtocolException("URI does not specify a valid host name: " + localURI);
      }
    }
    return paramHttpUriRequest;
  }
  
  private final HttpProcessor getProtocolProcessor()
  {
    int j = 0;
    try
    {
      if (this.protocolProcessor == null)
      {
        localObject1 = getHttpProcessor();
        int k = ((BasicHttpProcessor)localObject1).getRequestInterceptorCount();
        HttpRequestInterceptor[] arrayOfHttpRequestInterceptor = new HttpRequestInterceptor[k];
        int i = 0;
        while (i < k)
        {
          arrayOfHttpRequestInterceptor[i] = ((BasicHttpProcessor)localObject1).getRequestInterceptor(i);
          i += 1;
        }
        k = ((BasicHttpProcessor)localObject1).getResponseInterceptorCount();
        HttpResponseInterceptor[] arrayOfHttpResponseInterceptor = new HttpResponseInterceptor[k];
        i = j;
        while (i < k)
        {
          arrayOfHttpResponseInterceptor[i] = ((BasicHttpProcessor)localObject1).getResponseInterceptor(i);
          i += 1;
        }
        this.protocolProcessor = new ImmutableHttpProcessor(arrayOfHttpRequestInterceptor, arrayOfHttpResponseInterceptor);
      }
      Object localObject1 = this.protocolProcessor;
      return (HttpProcessor)localObject1;
    }
    finally {}
  }
  
  public void addRequestInterceptor(HttpRequestInterceptor paramHttpRequestInterceptor, int paramInt)
  {
    try
    {
      getHttpProcessor().addInterceptor(paramHttpRequestInterceptor, paramInt);
      this.protocolProcessor = null;
      return;
    }
    finally
    {
      paramHttpRequestInterceptor = finally;
      throw paramHttpRequestInterceptor;
    }
  }
  
  protected AuthSchemeRegistry createAuthSchemeRegistry()
  {
    AuthSchemeRegistry localAuthSchemeRegistry = new AuthSchemeRegistry();
    localAuthSchemeRegistry.register("Basic", new BasicSchemeFactory());
    localAuthSchemeRegistry.register("Digest", new DigestSchemeFactory());
    localAuthSchemeRegistry.register("NTLM", new NTLMSchemeFactory());
    localAuthSchemeRegistry.register("negotiate", new SPNegoSchemeFactory());
    localAuthSchemeRegistry.register("Kerberos", new KerberosSchemeFactory());
    return localAuthSchemeRegistry;
  }
  
  protected ClientConnectionManager createClientConnectionManager()
  {
    SchemeRegistry localSchemeRegistry = SchemeRegistryFactory.createDefault();
    HttpParams localHttpParams = getParams();
    String str = (String)localHttpParams.getParameter("http.connection-manager.factory-class-name");
    if (str != null) {}
    for (;;)
    {
      try
      {
        ClientConnectionManagerFactory localClientConnectionManagerFactory = (ClientConnectionManagerFactory)Class.forName(str).newInstance();
        if (localClientConnectionManagerFactory != null) {
          return localClientConnectionManagerFactory.newInstance(localHttpParams, localSchemeRegistry);
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new IllegalStateException("Invalid class name: " + str);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new IllegalAccessError(localIllegalAccessException.getMessage());
      }
      catch (InstantiationException localInstantiationException)
      {
        throw new InstantiationError(localInstantiationException.getMessage());
      }
      return new BasicClientConnectionManager(localSchemeRegistry);
      Object localObject = null;
    }
  }
  
  protected RequestDirector createClientRequestDirector(HttpRequestExecutor paramHttpRequestExecutor, ClientConnectionManager paramClientConnectionManager, ConnectionReuseStrategy paramConnectionReuseStrategy, ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy, HttpRoutePlanner paramHttpRoutePlanner, HttpProcessor paramHttpProcessor, HttpRequestRetryHandler paramHttpRequestRetryHandler, RedirectStrategy paramRedirectStrategy, AuthenticationStrategy paramAuthenticationStrategy1, AuthenticationStrategy paramAuthenticationStrategy2, UserTokenHandler paramUserTokenHandler, HttpParams paramHttpParams)
  {
    return new DefaultRequestDirector(this.log, paramHttpRequestExecutor, paramClientConnectionManager, paramConnectionReuseStrategy, paramConnectionKeepAliveStrategy, paramHttpRoutePlanner, paramHttpProcessor, paramHttpRequestRetryHandler, paramRedirectStrategy, paramAuthenticationStrategy1, paramAuthenticationStrategy2, paramUserTokenHandler, paramHttpParams);
  }
  
  protected ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy()
  {
    return new DefaultConnectionKeepAliveStrategy();
  }
  
  protected ConnectionReuseStrategy createConnectionReuseStrategy()
  {
    return new DefaultConnectionReuseStrategy();
  }
  
  protected CookieSpecRegistry createCookieSpecRegistry()
  {
    CookieSpecRegistry localCookieSpecRegistry = new CookieSpecRegistry();
    localCookieSpecRegistry.register("best-match", new BestMatchSpecFactory());
    localCookieSpecRegistry.register("compatibility", new BrowserCompatSpecFactory());
    localCookieSpecRegistry.register("netscape", new NetscapeDraftSpecFactory());
    localCookieSpecRegistry.register("rfc2109", new RFC2109SpecFactory());
    localCookieSpecRegistry.register("rfc2965", new RFC2965SpecFactory());
    localCookieSpecRegistry.register("ignoreCookies", new IgnoreSpecFactory());
    return localCookieSpecRegistry;
  }
  
  protected CookieStore createCookieStore()
  {
    return new BasicCookieStore();
  }
  
  protected CredentialsProvider createCredentialsProvider()
  {
    return new BasicCredentialsProvider();
  }
  
  protected HttpContext createHttpContext()
  {
    BasicHttpContext localBasicHttpContext = new BasicHttpContext();
    localBasicHttpContext.setAttribute("http.scheme-registry", getConnectionManager().getSchemeRegistry());
    localBasicHttpContext.setAttribute("http.authscheme-registry", getAuthSchemes());
    localBasicHttpContext.setAttribute("http.cookiespec-registry", getCookieSpecs());
    localBasicHttpContext.setAttribute("http.cookie-store", getCookieStore());
    localBasicHttpContext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
    return localBasicHttpContext;
  }
  
  protected abstract HttpParams createHttpParams();
  
  protected abstract BasicHttpProcessor createHttpProcessor();
  
  protected HttpRequestRetryHandler createHttpRequestRetryHandler()
  {
    return new DefaultHttpRequestRetryHandler();
  }
  
  protected HttpRoutePlanner createHttpRoutePlanner()
  {
    return new DefaultHttpRoutePlanner(getConnectionManager().getSchemeRegistry());
  }
  
  protected AuthenticationStrategy createProxyAuthenticationStrategy()
  {
    return new ProxyAuthenticationStrategy();
  }
  
  protected HttpRequestExecutor createRequestExecutor()
  {
    return new HttpRequestExecutor();
  }
  
  protected AuthenticationStrategy createTargetAuthenticationStrategy()
  {
    return new TargetAuthenticationStrategy();
  }
  
  protected UserTokenHandler createUserTokenHandler()
  {
    return new DefaultUserTokenHandler();
  }
  
  protected HttpParams determineParams(HttpRequest paramHttpRequest)
  {
    return new ClientParamsStack(null, getParams(), paramHttpRequest.getParams(), null);
  }
  
  /* Error */
  public final HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +14 -> 15
    //   4: new 405	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 407
    //   11: invokespecial 408	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_0
    //   16: monitorenter
    //   17: aload_0
    //   18: invokevirtual 410	com/amazonaws/org/apache/http/impl/client/AbstractHttpClient:createHttpContext	()Lcom/amazonaws/org/apache/http/protocol/HttpContext;
    //   21: astore 4
    //   23: aload_3
    //   24: ifnonnull +144 -> 168
    //   27: aload 4
    //   29: astore_3
    //   30: aload_0
    //   31: aload_0
    //   32: invokevirtual 413	com/amazonaws/org/apache/http/impl/client/AbstractHttpClient:getRequestExecutor	()Lcom/amazonaws/org/apache/http/protocol/HttpRequestExecutor;
    //   35: aload_0
    //   36: invokevirtual 323	com/amazonaws/org/apache/http/impl/client/AbstractHttpClient:getConnectionManager	()Lcom/amazonaws/org/apache/http/conn/ClientConnectionManager;
    //   39: aload_0
    //   40: invokevirtual 416	com/amazonaws/org/apache/http/impl/client/AbstractHttpClient:getConnectionReuseStrategy	()Lcom/amazonaws/org/apache/http/ConnectionReuseStrategy;
    //   43: aload_0
    //   44: invokevirtual 419	com/amazonaws/org/apache/http/impl/client/AbstractHttpClient:getConnectionKeepAliveStrategy	()Lcom/amazonaws/org/apache/http/conn/ConnectionKeepAliveStrategy;
    //   47: aload_0
    //   48: invokevirtual 422	com/amazonaws/org/apache/http/impl/client/AbstractHttpClient:getRoutePlanner	()Lcom/amazonaws/org/apache/http/conn/routing/HttpRoutePlanner;
    //   51: aload_0
    //   52: invokespecial 424	com/amazonaws/org/apache/http/impl/client/AbstractHttpClient:getProtocolProcessor	()Lcom/amazonaws/org/apache/http/protocol/HttpProcessor;
    //   55: aload_0
    //   56: invokevirtual 427	com/amazonaws/org/apache/http/impl/client/AbstractHttpClient:getHttpRequestRetryHandler	()Lcom/amazonaws/org/apache/http/client/HttpRequestRetryHandler;
    //   59: aload_0
    //   60: invokevirtual 431	com/amazonaws/org/apache/http/impl/client/AbstractHttpClient:getRedirectStrategy	()Lcom/amazonaws/org/apache/http/client/RedirectStrategy;
    //   63: aload_0
    //   64: invokevirtual 434	com/amazonaws/org/apache/http/impl/client/AbstractHttpClient:getTargetAuthenticationStrategy	()Lcom/amazonaws/org/apache/http/client/AuthenticationStrategy;
    //   67: aload_0
    //   68: invokevirtual 437	com/amazonaws/org/apache/http/impl/client/AbstractHttpClient:getProxyAuthenticationStrategy	()Lcom/amazonaws/org/apache/http/client/AuthenticationStrategy;
    //   71: aload_0
    //   72: invokevirtual 440	com/amazonaws/org/apache/http/impl/client/AbstractHttpClient:getUserTokenHandler	()Lcom/amazonaws/org/apache/http/client/UserTokenHandler;
    //   75: aload_0
    //   76: aload_2
    //   77: invokevirtual 442	com/amazonaws/org/apache/http/impl/client/AbstractHttpClient:determineParams	(Lcom/amazonaws/org/apache/http/HttpRequest;)Lcom/amazonaws/org/apache/http/params/HttpParams;
    //   80: invokevirtual 444	com/amazonaws/org/apache/http/impl/client/AbstractHttpClient:createClientRequestDirector	(Lcom/amazonaws/org/apache/http/protocol/HttpRequestExecutor;Lcom/amazonaws/org/apache/http/conn/ClientConnectionManager;Lcom/amazonaws/org/apache/http/ConnectionReuseStrategy;Lcom/amazonaws/org/apache/http/conn/ConnectionKeepAliveStrategy;Lcom/amazonaws/org/apache/http/conn/routing/HttpRoutePlanner;Lcom/amazonaws/org/apache/http/protocol/HttpProcessor;Lcom/amazonaws/org/apache/http/client/HttpRequestRetryHandler;Lcom/amazonaws/org/apache/http/client/RedirectStrategy;Lcom/amazonaws/org/apache/http/client/AuthenticationStrategy;Lcom/amazonaws/org/apache/http/client/AuthenticationStrategy;Lcom/amazonaws/org/apache/http/client/UserTokenHandler;Lcom/amazonaws/org/apache/http/params/HttpParams;)Lcom/amazonaws/org/apache/http/client/RequestDirector;
    //   83: astore 7
    //   85: aload_0
    //   86: invokevirtual 422	com/amazonaws/org/apache/http/impl/client/AbstractHttpClient:getRoutePlanner	()Lcom/amazonaws/org/apache/http/conn/routing/HttpRoutePlanner;
    //   89: astore 8
    //   91: aload_0
    //   92: invokevirtual 448	com/amazonaws/org/apache/http/impl/client/AbstractHttpClient:getConnectionBackoffStrategy	()Lcom/amazonaws/org/apache/http/client/ConnectionBackoffStrategy;
    //   95: astore 5
    //   97: aload_0
    //   98: invokevirtual 452	com/amazonaws/org/apache/http/impl/client/AbstractHttpClient:getBackoffManager	()Lcom/amazonaws/org/apache/http/client/BackoffManager;
    //   101: astore 6
    //   103: aload_0
    //   104: monitorexit
    //   105: aload 5
    //   107: ifnull +199 -> 306
    //   110: aload 6
    //   112: ifnull +194 -> 306
    //   115: aload_1
    //   116: ifnull +71 -> 187
    //   119: aload_1
    //   120: astore 4
    //   122: aload 8
    //   124: aload 4
    //   126: aload_2
    //   127: aload_3
    //   128: invokeinterface 458 4 0
    //   133: astore 4
    //   135: aload 7
    //   137: aload_1
    //   138: aload_2
    //   139: aload_3
    //   140: invokeinterface 462 4 0
    //   145: astore_1
    //   146: aload 5
    //   148: aload_1
    //   149: invokeinterface 468 2 0
    //   154: ifeq +141 -> 295
    //   157: aload 6
    //   159: aload 4
    //   161: invokeinterface 474 2 0
    //   166: aload_1
    //   167: areturn
    //   168: new 476	com/amazonaws/org/apache/http/protocol/DefaultedHttpContext
    //   171: dup
    //   172: aload_3
    //   173: aload 4
    //   175: invokespecial 479	com/amazonaws/org/apache/http/protocol/DefaultedHttpContext:<init>	(Lcom/amazonaws/org/apache/http/protocol/HttpContext;Lcom/amazonaws/org/apache/http/protocol/HttpContext;)V
    //   178: astore_3
    //   179: goto -149 -> 30
    //   182: astore_1
    //   183: aload_0
    //   184: monitorexit
    //   185: aload_1
    //   186: athrow
    //   187: aload_0
    //   188: aload_2
    //   189: invokevirtual 442	com/amazonaws/org/apache/http/impl/client/AbstractHttpClient:determineParams	(Lcom/amazonaws/org/apache/http/HttpRequest;)Lcom/amazonaws/org/apache/http/params/HttpParams;
    //   192: ldc_w 481
    //   195: invokeinterface 211 2 0
    //   200: checkcast 483	com/amazonaws/org/apache/http/HttpHost
    //   203: astore 4
    //   205: goto -83 -> 122
    //   208: astore_1
    //   209: aload 5
    //   211: aload_1
    //   212: invokeinterface 486 2 0
    //   217: ifeq +12 -> 229
    //   220: aload 6
    //   222: aload 4
    //   224: invokeinterface 474 2 0
    //   229: aload_1
    //   230: athrow
    //   231: astore_1
    //   232: new 93	com/amazonaws/org/apache/http/client/ClientProtocolException
    //   235: dup
    //   236: aload_1
    //   237: invokespecial 489	com/amazonaws/org/apache/http/client/ClientProtocolException:<init>	(Ljava/lang/Throwable;)V
    //   240: athrow
    //   241: astore_1
    //   242: aload 5
    //   244: aload_1
    //   245: invokeinterface 486 2 0
    //   250: ifeq +12 -> 262
    //   253: aload 6
    //   255: aload 4
    //   257: invokeinterface 474 2 0
    //   262: aload_1
    //   263: instanceof 399
    //   266: ifeq +8 -> 274
    //   269: aload_1
    //   270: checkcast 399	com/amazonaws/org/apache/http/HttpException
    //   273: athrow
    //   274: aload_1
    //   275: instanceof 491
    //   278: ifeq +8 -> 286
    //   281: aload_1
    //   282: checkcast 491	java/io/IOException
    //   285: athrow
    //   286: new 493	java/lang/reflect/UndeclaredThrowableException
    //   289: dup
    //   290: aload_1
    //   291: invokespecial 494	java/lang/reflect/UndeclaredThrowableException:<init>	(Ljava/lang/Throwable;)V
    //   294: athrow
    //   295: aload 6
    //   297: aload 4
    //   299: invokeinterface 497 2 0
    //   304: aload_1
    //   305: areturn
    //   306: aload 7
    //   308: aload_1
    //   309: aload_2
    //   310: aload_3
    //   311: invokeinterface 462 4 0
    //   316: astore_1
    //   317: aload_1
    //   318: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	this	AbstractHttpClient
    //   0	319	1	paramHttpHost	HttpHost
    //   0	319	2	paramHttpRequest	HttpRequest
    //   0	319	3	paramHttpContext	HttpContext
    //   21	277	4	localObject	Object
    //   95	148	5	localConnectionBackoffStrategy	ConnectionBackoffStrategy
    //   101	195	6	localBackoffManager	BackoffManager
    //   83	224	7	localRequestDirector	RequestDirector
    //   89	34	8	localHttpRoutePlanner	HttpRoutePlanner
    // Exception table:
    //   from	to	target	type
    //   17	23	182	finally
    //   30	105	182	finally
    //   168	179	182	finally
    //   183	185	182	finally
    //   135	146	208	java/lang/RuntimeException
    //   122	135	231	com/amazonaws/org/apache/http/HttpException
    //   135	146	231	com/amazonaws/org/apache/http/HttpException
    //   146	166	231	com/amazonaws/org/apache/http/HttpException
    //   187	205	231	com/amazonaws/org/apache/http/HttpException
    //   209	229	231	com/amazonaws/org/apache/http/HttpException
    //   229	231	231	com/amazonaws/org/apache/http/HttpException
    //   242	262	231	com/amazonaws/org/apache/http/HttpException
    //   262	274	231	com/amazonaws/org/apache/http/HttpException
    //   274	286	231	com/amazonaws/org/apache/http/HttpException
    //   286	295	231	com/amazonaws/org/apache/http/HttpException
    //   295	304	231	com/amazonaws/org/apache/http/HttpException
    //   306	317	231	com/amazonaws/org/apache/http/HttpException
    //   135	146	241	java/lang/Exception
  }
  
  public final HttpResponse execute(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext)
  {
    if (paramHttpUriRequest == null) {
      throw new IllegalArgumentException("Request must not be null.");
    }
    return execute(determineTarget(paramHttpUriRequest), paramHttpUriRequest, paramHttpContext);
  }
  
  public final AuthSchemeRegistry getAuthSchemes()
  {
    try
    {
      if (this.supportedAuthSchemes == null) {
        this.supportedAuthSchemes = createAuthSchemeRegistry();
      }
      AuthSchemeRegistry localAuthSchemeRegistry = this.supportedAuthSchemes;
      return localAuthSchemeRegistry;
    }
    finally {}
  }
  
  public final BackoffManager getBackoffManager()
  {
    try
    {
      BackoffManager localBackoffManager = this.backoffManager;
      return localBackoffManager;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final ConnectionBackoffStrategy getConnectionBackoffStrategy()
  {
    try
    {
      ConnectionBackoffStrategy localConnectionBackoffStrategy = this.connectionBackoffStrategy;
      return localConnectionBackoffStrategy;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final ConnectionKeepAliveStrategy getConnectionKeepAliveStrategy()
  {
    try
    {
      if (this.keepAliveStrategy == null) {
        this.keepAliveStrategy = createConnectionKeepAliveStrategy();
      }
      ConnectionKeepAliveStrategy localConnectionKeepAliveStrategy = this.keepAliveStrategy;
      return localConnectionKeepAliveStrategy;
    }
    finally {}
  }
  
  public final ClientConnectionManager getConnectionManager()
  {
    try
    {
      if (this.connManager == null) {
        this.connManager = createClientConnectionManager();
      }
      ClientConnectionManager localClientConnectionManager = this.connManager;
      return localClientConnectionManager;
    }
    finally {}
  }
  
  public final ConnectionReuseStrategy getConnectionReuseStrategy()
  {
    try
    {
      if (this.reuseStrategy == null) {
        this.reuseStrategy = createConnectionReuseStrategy();
      }
      ConnectionReuseStrategy localConnectionReuseStrategy = this.reuseStrategy;
      return localConnectionReuseStrategy;
    }
    finally {}
  }
  
  public final CookieSpecRegistry getCookieSpecs()
  {
    try
    {
      if (this.supportedCookieSpecs == null) {
        this.supportedCookieSpecs = createCookieSpecRegistry();
      }
      CookieSpecRegistry localCookieSpecRegistry = this.supportedCookieSpecs;
      return localCookieSpecRegistry;
    }
    finally {}
  }
  
  public final CookieStore getCookieStore()
  {
    try
    {
      if (this.cookieStore == null) {
        this.cookieStore = createCookieStore();
      }
      CookieStore localCookieStore = this.cookieStore;
      return localCookieStore;
    }
    finally {}
  }
  
  public final CredentialsProvider getCredentialsProvider()
  {
    try
    {
      if (this.credsProvider == null) {
        this.credsProvider = createCredentialsProvider();
      }
      CredentialsProvider localCredentialsProvider = this.credsProvider;
      return localCredentialsProvider;
    }
    finally {}
  }
  
  protected final BasicHttpProcessor getHttpProcessor()
  {
    try
    {
      if (this.mutableProcessor == null) {
        this.mutableProcessor = createHttpProcessor();
      }
      BasicHttpProcessor localBasicHttpProcessor = this.mutableProcessor;
      return localBasicHttpProcessor;
    }
    finally {}
  }
  
  public final HttpRequestRetryHandler getHttpRequestRetryHandler()
  {
    try
    {
      if (this.retryHandler == null) {
        this.retryHandler = createHttpRequestRetryHandler();
      }
      HttpRequestRetryHandler localHttpRequestRetryHandler = this.retryHandler;
      return localHttpRequestRetryHandler;
    }
    finally {}
  }
  
  public final HttpParams getParams()
  {
    try
    {
      if (this.defaultParams == null) {
        this.defaultParams = createHttpParams();
      }
      HttpParams localHttpParams = this.defaultParams;
      return localHttpParams;
    }
    finally {}
  }
  
  public final AuthenticationStrategy getProxyAuthenticationStrategy()
  {
    try
    {
      if (this.proxyAuthStrategy == null) {
        this.proxyAuthStrategy = createProxyAuthenticationStrategy();
      }
      AuthenticationStrategy localAuthenticationStrategy = this.proxyAuthStrategy;
      return localAuthenticationStrategy;
    }
    finally {}
  }
  
  public final RedirectStrategy getRedirectStrategy()
  {
    try
    {
      if (this.redirectStrategy == null) {
        this.redirectStrategy = new DefaultRedirectStrategy();
      }
      RedirectStrategy localRedirectStrategy = this.redirectStrategy;
      return localRedirectStrategy;
    }
    finally {}
  }
  
  public final HttpRequestExecutor getRequestExecutor()
  {
    try
    {
      if (this.requestExec == null) {
        this.requestExec = createRequestExecutor();
      }
      HttpRequestExecutor localHttpRequestExecutor = this.requestExec;
      return localHttpRequestExecutor;
    }
    finally {}
  }
  
  public final HttpRoutePlanner getRoutePlanner()
  {
    try
    {
      if (this.routePlanner == null) {
        this.routePlanner = createHttpRoutePlanner();
      }
      HttpRoutePlanner localHttpRoutePlanner = this.routePlanner;
      return localHttpRoutePlanner;
    }
    finally {}
  }
  
  public final AuthenticationStrategy getTargetAuthenticationStrategy()
  {
    try
    {
      if (this.targetAuthStrategy == null) {
        this.targetAuthStrategy = createTargetAuthenticationStrategy();
      }
      AuthenticationStrategy localAuthenticationStrategy = this.targetAuthStrategy;
      return localAuthenticationStrategy;
    }
    finally {}
  }
  
  public final UserTokenHandler getUserTokenHandler()
  {
    try
    {
      if (this.userTokenHandler == null) {
        this.userTokenHandler = createUserTokenHandler();
      }
      UserTokenHandler localUserTokenHandler = this.userTokenHandler;
      return localUserTokenHandler;
    }
    finally {}
  }
  
  public void setHttpRequestRetryHandler(HttpRequestRetryHandler paramHttpRequestRetryHandler)
  {
    try
    {
      this.retryHandler = paramHttpRequestRetryHandler;
      return;
    }
    finally
    {
      paramHttpRequestRetryHandler = finally;
      throw paramHttpRequestRetryHandler;
    }
  }
  
  public void setRedirectStrategy(RedirectStrategy paramRedirectStrategy)
  {
    try
    {
      this.redirectStrategy = paramRedirectStrategy;
      return;
    }
    finally
    {
      paramRedirectStrategy = finally;
      throw paramRedirectStrategy;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/AbstractHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */