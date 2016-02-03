package com.amazonaws.org.apache.http.impl.client;

import com.amazonaws.org.apache.http.ConnectionReuseStrategy;
import com.amazonaws.org.apache.http.HttpEntity;
import com.amazonaws.org.apache.http.HttpEntityEnclosingRequest;
import com.amazonaws.org.apache.http.HttpException;
import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.ProtocolException;
import com.amazonaws.org.apache.http.StatusLine;
import com.amazonaws.org.apache.http.auth.AuthProtocolState;
import com.amazonaws.org.apache.http.auth.AuthScheme;
import com.amazonaws.org.apache.http.auth.AuthState;
import com.amazonaws.org.apache.http.auth.UsernamePasswordCredentials;
import com.amazonaws.org.apache.http.client.AuthenticationHandler;
import com.amazonaws.org.apache.http.client.AuthenticationStrategy;
import com.amazonaws.org.apache.http.client.HttpRequestRetryHandler;
import com.amazonaws.org.apache.http.client.NonRepeatableRequestException;
import com.amazonaws.org.apache.http.client.RedirectException;
import com.amazonaws.org.apache.http.client.RedirectHandler;
import com.amazonaws.org.apache.http.client.RedirectStrategy;
import com.amazonaws.org.apache.http.client.RequestDirector;
import com.amazonaws.org.apache.http.client.UserTokenHandler;
import com.amazonaws.org.apache.http.client.methods.AbortableHttpRequest;
import com.amazonaws.org.apache.http.client.methods.HttpUriRequest;
import com.amazonaws.org.apache.http.client.params.HttpClientParams;
import com.amazonaws.org.apache.http.client.utils.URIUtils;
import com.amazonaws.org.apache.http.conn.BasicManagedEntity;
import com.amazonaws.org.apache.http.conn.ClientConnectionManager;
import com.amazonaws.org.apache.http.conn.ClientConnectionRequest;
import com.amazonaws.org.apache.http.conn.ConnectionKeepAliveStrategy;
import com.amazonaws.org.apache.http.conn.ManagedClientConnection;
import com.amazonaws.org.apache.http.conn.routing.BasicRouteDirector;
import com.amazonaws.org.apache.http.conn.routing.HttpRoute;
import com.amazonaws.org.apache.http.conn.routing.HttpRouteDirector;
import com.amazonaws.org.apache.http.conn.routing.HttpRoutePlanner;
import com.amazonaws.org.apache.http.conn.scheme.Scheme;
import com.amazonaws.org.apache.http.conn.scheme.SchemeRegistry;
import com.amazonaws.org.apache.http.entity.BufferedHttpEntity;
import com.amazonaws.org.apache.http.impl.auth.BasicScheme;
import com.amazonaws.org.apache.http.impl.conn.ConnectionShutdownException;
import com.amazonaws.org.apache.http.message.BasicHttpRequest;
import com.amazonaws.org.apache.http.params.HttpConnectionParams;
import com.amazonaws.org.apache.http.params.HttpParams;
import com.amazonaws.org.apache.http.params.HttpProtocolParams;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import com.amazonaws.org.apache.http.protocol.HttpProcessor;
import com.amazonaws.org.apache.http.protocol.HttpRequestExecutor;
import com.amazonaws.org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class DefaultRequestDirector
  implements RequestDirector
{
  private final HttpAuthenticator authenticator;
  protected final ClientConnectionManager connManager;
  private int execCount;
  protected final HttpProcessor httpProcessor;
  protected final ConnectionKeepAliveStrategy keepAliveStrategy;
  private final Log log;
  protected ManagedClientConnection managedConn;
  private int maxRedirects;
  protected final HttpParams params;
  @Deprecated
  protected final AuthenticationHandler proxyAuthHandler;
  protected final AuthState proxyAuthState;
  protected final AuthenticationStrategy proxyAuthStrategy;
  private int redirectCount;
  @Deprecated
  protected final RedirectHandler redirectHandler;
  protected final RedirectStrategy redirectStrategy;
  protected final HttpRequestExecutor requestExec;
  protected final HttpRequestRetryHandler retryHandler;
  protected final ConnectionReuseStrategy reuseStrategy;
  protected final HttpRoutePlanner routePlanner;
  @Deprecated
  protected final AuthenticationHandler targetAuthHandler;
  protected final AuthState targetAuthState;
  protected final AuthenticationStrategy targetAuthStrategy;
  protected final UserTokenHandler userTokenHandler;
  private HttpHost virtualHost;
  
  public DefaultRequestDirector(Log paramLog, HttpRequestExecutor paramHttpRequestExecutor, ClientConnectionManager paramClientConnectionManager, ConnectionReuseStrategy paramConnectionReuseStrategy, ConnectionKeepAliveStrategy paramConnectionKeepAliveStrategy, HttpRoutePlanner paramHttpRoutePlanner, HttpProcessor paramHttpProcessor, HttpRequestRetryHandler paramHttpRequestRetryHandler, RedirectStrategy paramRedirectStrategy, AuthenticationStrategy paramAuthenticationStrategy1, AuthenticationStrategy paramAuthenticationStrategy2, UserTokenHandler paramUserTokenHandler, HttpParams paramHttpParams)
  {
    if (paramLog == null) {
      throw new IllegalArgumentException("Log may not be null.");
    }
    if (paramHttpRequestExecutor == null) {
      throw new IllegalArgumentException("Request executor may not be null.");
    }
    if (paramClientConnectionManager == null) {
      throw new IllegalArgumentException("Client connection manager may not be null.");
    }
    if (paramConnectionReuseStrategy == null) {
      throw new IllegalArgumentException("Connection reuse strategy may not be null.");
    }
    if (paramConnectionKeepAliveStrategy == null) {
      throw new IllegalArgumentException("Connection keep alive strategy may not be null.");
    }
    if (paramHttpRoutePlanner == null) {
      throw new IllegalArgumentException("Route planner may not be null.");
    }
    if (paramHttpProcessor == null) {
      throw new IllegalArgumentException("HTTP protocol processor may not be null.");
    }
    if (paramHttpRequestRetryHandler == null) {
      throw new IllegalArgumentException("HTTP request retry handler may not be null.");
    }
    if (paramRedirectStrategy == null) {
      throw new IllegalArgumentException("Redirect strategy may not be null.");
    }
    if (paramAuthenticationStrategy1 == null) {
      throw new IllegalArgumentException("Target authentication strategy may not be null.");
    }
    if (paramAuthenticationStrategy2 == null) {
      throw new IllegalArgumentException("Proxy authentication strategy may not be null.");
    }
    if (paramUserTokenHandler == null) {
      throw new IllegalArgumentException("User token handler may not be null.");
    }
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("HTTP parameters may not be null");
    }
    this.log = paramLog;
    this.authenticator = new HttpAuthenticator(paramLog);
    this.requestExec = paramHttpRequestExecutor;
    this.connManager = paramClientConnectionManager;
    this.reuseStrategy = paramConnectionReuseStrategy;
    this.keepAliveStrategy = paramConnectionKeepAliveStrategy;
    this.routePlanner = paramHttpRoutePlanner;
    this.httpProcessor = paramHttpProcessor;
    this.retryHandler = paramHttpRequestRetryHandler;
    this.redirectStrategy = paramRedirectStrategy;
    this.targetAuthStrategy = paramAuthenticationStrategy1;
    this.proxyAuthStrategy = paramAuthenticationStrategy2;
    this.userTokenHandler = paramUserTokenHandler;
    this.params = paramHttpParams;
    if ((paramRedirectStrategy instanceof DefaultRedirectStrategyAdaptor))
    {
      this.redirectHandler = ((DefaultRedirectStrategyAdaptor)paramRedirectStrategy).getHandler();
      if (!(paramAuthenticationStrategy1 instanceof AuthenticationStrategyAdaptor)) {
        break label406;
      }
      this.targetAuthHandler = ((AuthenticationStrategyAdaptor)paramAuthenticationStrategy1).getHandler();
      label323:
      if (!(paramAuthenticationStrategy2 instanceof AuthenticationStrategyAdaptor)) {
        break label414;
      }
    }
    label406:
    label414:
    for (this.proxyAuthHandler = ((AuthenticationStrategyAdaptor)paramAuthenticationStrategy2).getHandler();; this.proxyAuthHandler = null)
    {
      this.managedConn = null;
      this.execCount = 0;
      this.redirectCount = 0;
      this.targetAuthState = new AuthState();
      this.proxyAuthState = new AuthState();
      this.maxRedirects = this.params.getIntParameter("http.protocol.max-redirects", 100);
      return;
      this.redirectHandler = null;
      break;
      this.targetAuthHandler = null;
      break label323;
    }
  }
  
  private void abortConnection()
  {
    ManagedClientConnection localManagedClientConnection = this.managedConn;
    if (localManagedClientConnection != null) {
      this.managedConn = null;
    }
    try
    {
      localManagedClientConnection.abortConnection();
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        try
        {
          localManagedClientConnection.releaseConnection();
          return;
        }
        catch (IOException localIOException1)
        {
          this.log.debug("Error releasing connection", localIOException1);
        }
        localIOException2 = localIOException2;
        if (this.log.isDebugEnabled()) {
          this.log.debug(localIOException2.getMessage(), localIOException2);
        }
      }
    }
  }
  
  private void tryConnect(RoutedRequest paramRoutedRequest, HttpContext paramHttpContext)
  {
    HttpRoute localHttpRoute = paramRoutedRequest.getRoute();
    paramRoutedRequest = paramRoutedRequest.getRequest();
    i = 0;
    for (;;)
    {
      paramHttpContext.setAttribute("http.request", paramRoutedRequest);
      j = i + 1;
      try
      {
        if (!this.managedConn.isOpen()) {
          this.managedConn.open(localHttpRoute, paramHttpContext, this.params);
        }
        for (;;)
        {
          establishRoute(localHttpRoute, paramHttpContext);
          return;
          this.managedConn.setSocketTimeout(HttpConnectionParams.getSoTimeout(this.params));
        }
        try
        {
          this.managedConn.close();
          if (this.retryHandler.retryRequest(localIOException1, j, paramHttpContext))
          {
            i = j;
            if (!this.log.isInfoEnabled()) {
              continue;
            }
            this.log.info("I/O exception (" + localIOException1.getClass().getName() + ") caught when connecting to the target host: " + localIOException1.getMessage());
            if (this.log.isDebugEnabled()) {
              this.log.debug(localIOException1.getMessage(), localIOException1);
            }
            this.log.info("Retrying connect");
            i = j;
            continue;
          }
          throw localIOException1;
        }
        catch (IOException localIOException2)
        {
          for (;;) {}
        }
      }
      catch (IOException localIOException1) {}
    }
  }
  
  private HttpResponse tryExecute(RoutedRequest paramRoutedRequest, HttpContext paramHttpContext)
  {
    RequestWrapper localRequestWrapper = paramRoutedRequest.getRequest();
    HttpRoute localHttpRoute = paramRoutedRequest.getRoute();
    paramRoutedRequest = null;
    for (;;)
    {
      this.execCount += 1;
      localRequestWrapper.incrementExecCount();
      if (!localRequestWrapper.isRepeatable())
      {
        this.log.debug("Cannot retry non-repeatable request");
        if (paramRoutedRequest != null) {
          throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.  The cause lists the reason the original request failed.", paramRoutedRequest);
        }
        throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.");
      }
      try
      {
        if (!this.managedConn.isOpen())
        {
          if (!localHttpRoute.isTunnelled())
          {
            this.log.debug("Reopening the direct connection.");
            this.managedConn.open(localHttpRoute, paramHttpContext, this.params);
          }
        }
        else
        {
          if (this.log.isDebugEnabled()) {
            this.log.debug("Attempt " + this.execCount + " to execute request");
          }
          return this.requestExec.execute(localRequestWrapper, this.managedConn, paramHttpContext);
        }
        this.log.debug("Proxied connection. Need to start over.");
        return null;
      }
      catch (IOException paramRoutedRequest)
      {
        this.log.debug("Closing the connection.");
      }
      try
      {
        this.managedConn.close();
        if (this.retryHandler.retryRequest(paramRoutedRequest, localRequestWrapper.getExecCount(), paramHttpContext))
        {
          if (this.log.isInfoEnabled()) {
            this.log.info("I/O exception (" + paramRoutedRequest.getClass().getName() + ") caught when processing request: " + paramRoutedRequest.getMessage());
          }
          if (this.log.isDebugEnabled()) {
            this.log.debug(paramRoutedRequest.getMessage(), paramRoutedRequest);
          }
          this.log.info("Retrying request");
          continue;
        }
        throw paramRoutedRequest;
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
  }
  
  private RequestWrapper wrapRequest(HttpRequest paramHttpRequest)
  {
    if ((paramHttpRequest instanceof HttpEntityEnclosingRequest)) {
      return new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest)paramHttpRequest);
    }
    return new RequestWrapper(paramHttpRequest);
  }
  
  protected HttpRequest createConnectRequest(HttpRoute paramHttpRoute, HttpContext paramHttpContext)
  {
    paramHttpContext = paramHttpRoute.getTargetHost();
    paramHttpRoute = paramHttpContext.getHostName();
    int j = paramHttpContext.getPort();
    int i = j;
    if (j < 0) {
      i = this.connManager.getSchemeRegistry().getScheme(paramHttpContext.getSchemeName()).getDefaultPort();
    }
    paramHttpContext = new StringBuilder(paramHttpRoute.length() + 6);
    paramHttpContext.append(paramHttpRoute);
    paramHttpContext.append(':');
    paramHttpContext.append(Integer.toString(i));
    return new BasicHttpRequest("CONNECT", paramHttpContext.toString(), HttpProtocolParams.getVersion(this.params));
  }
  
  protected boolean createTunnelToProxy(HttpRoute paramHttpRoute, int paramInt, HttpContext paramHttpContext)
  {
    throw new HttpException("Proxy chains are not supported.");
  }
  
  protected boolean createTunnelToTarget(HttpRoute paramHttpRoute, HttpContext paramHttpContext)
  {
    HttpHost localHttpHost1 = paramHttpRoute.getProxyHost();
    HttpHost localHttpHost2 = paramHttpRoute.getTargetHost();
    Object localObject;
    for (;;)
    {
      if (!this.managedConn.isOpen()) {
        this.managedConn.open(paramHttpRoute, paramHttpContext, this.params);
      }
      localObject = createConnectRequest(paramHttpRoute, paramHttpContext);
      ((HttpRequest)localObject).setParams(this.params);
      paramHttpContext.setAttribute("http.target_host", localHttpHost2);
      paramHttpContext.setAttribute("http.proxy_host", localHttpHost1);
      paramHttpContext.setAttribute("http.connection", this.managedConn);
      paramHttpContext.setAttribute("http.request", localObject);
      this.requestExec.preProcess((HttpRequest)localObject, this.httpProcessor, paramHttpContext);
      localObject = this.requestExec.execute((HttpRequest)localObject, this.managedConn, paramHttpContext);
      ((HttpResponse)localObject).setParams(this.params);
      this.requestExec.postProcess((HttpResponse)localObject, this.httpProcessor, paramHttpContext);
      if (((HttpResponse)localObject).getStatusLine().getStatusCode() < 200) {
        throw new HttpException("Unexpected response to CONNECT request: " + ((HttpResponse)localObject).getStatusLine());
      }
      if (HttpClientParams.isAuthenticating(this.params))
      {
        if ((!this.authenticator.isAuthenticationRequested(localHttpHost1, (HttpResponse)localObject, this.proxyAuthStrategy, this.proxyAuthState, paramHttpContext)) || (!this.authenticator.authenticate(localHttpHost1, (HttpResponse)localObject, this.proxyAuthStrategy, this.proxyAuthState, paramHttpContext))) {
          break;
        }
        if (this.reuseStrategy.keepAlive((HttpResponse)localObject, paramHttpContext))
        {
          this.log.debug("Connection kept alive");
          EntityUtils.consume(((HttpResponse)localObject).getEntity());
        }
        else
        {
          this.managedConn.close();
        }
      }
    }
    if (((HttpResponse)localObject).getStatusLine().getStatusCode() > 299)
    {
      paramHttpRoute = ((HttpResponse)localObject).getEntity();
      if (paramHttpRoute != null) {
        ((HttpResponse)localObject).setEntity(new BufferedHttpEntity(paramHttpRoute));
      }
      this.managedConn.close();
      throw new TunnelRefusedException("CONNECT refused by proxy: " + ((HttpResponse)localObject).getStatusLine(), (HttpResponse)localObject);
    }
    this.managedConn.markReusable();
    return false;
  }
  
  protected HttpRoute determineRoute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    if (paramHttpHost == null) {
      paramHttpHost = (HttpHost)paramHttpRequest.getParams().getParameter("http.default-host");
    }
    for (;;)
    {
      if (paramHttpHost == null) {
        throw new IllegalStateException("Target host must not be null, or set in parameters.");
      }
      return this.routePlanner.determineRoute(paramHttpHost, paramHttpRequest, paramHttpContext);
    }
  }
  
  protected void establishRoute(HttpRoute paramHttpRoute, HttpContext paramHttpContext)
  {
    BasicRouteDirector localBasicRouteDirector = new BasicRouteDirector();
    HttpRoute localHttpRoute = this.managedConn.getRoute();
    int i = localBasicRouteDirector.nextStep(paramHttpRoute, localHttpRoute);
    switch (i)
    {
    default: 
      throw new IllegalStateException("Unknown step indicator " + i + " from RouteDirector.");
    case 1: 
    case 2: 
      this.managedConn.open(paramHttpRoute, paramHttpContext, this.params);
    case 0: 
    case 3: 
    case 4: 
    case 5: 
      while (i <= 0)
      {
        return;
        boolean bool = createTunnelToTarget(paramHttpRoute, paramHttpContext);
        this.log.debug("Tunnel to target created.");
        this.managedConn.tunnelTarget(bool, this.params);
        continue;
        int j = localHttpRoute.getHopCount() - 1;
        bool = createTunnelToProxy(paramHttpRoute, j, paramHttpContext);
        this.log.debug("Tunnel to proxy created.");
        this.managedConn.tunnelProxy(paramHttpRoute.getHopTarget(j), bool, this.params);
        continue;
        this.managedConn.layerProtocol(paramHttpContext, this.params);
      }
    }
    throw new HttpException("Unable to establish route: planned = " + paramHttpRoute + "; current = " + localHttpRoute);
  }
  
  public HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    int i = 0;
    paramHttpContext.setAttribute("http.auth.target-scope", this.targetAuthState);
    paramHttpContext.setAttribute("http.auth.proxy-scope", this.proxyAuthState);
    Object localObject1 = wrapRequest(paramHttpRequest);
    ((RequestWrapper)localObject1).setParams(this.params);
    Object localObject2 = determineRoute(paramHttpHost, (HttpRequest)localObject1, paramHttpContext);
    this.virtualHost = ((HttpHost)((RequestWrapper)localObject1).getParams().getParameter("http.virtual-host"));
    if ((this.virtualHost != null) && (this.virtualHost.getPort() == -1)) {
      if (paramHttpHost == null) {
        break label496;
      }
    }
    boolean bool;
    Object localObject3;
    for (HttpHost localHttpHost1 = paramHttpHost;; localHttpHost1 = ((HttpRoute)localObject2).getTargetHost())
    {
      int j = localHttpHost1.getPort();
      if (j != -1) {
        this.virtualHost = new HttpHost(this.virtualHost.getHostName(), j, this.virtualHost.getSchemeName());
      }
      localObject1 = new RoutedRequest((RequestWrapper)localObject1, (HttpRoute)localObject2);
      localObject2 = null;
      bool = false;
      localHttpHost1 = paramHttpHost;
      paramHttpHost = (HttpHost)localObject2;
      while (i == 0)
      {
        for (;;)
        {
          try
          {
            localObject2 = ((RoutedRequest)localObject1).getRequest();
            localHttpRoute = ((RoutedRequest)localObject1).getRoute();
            localObject3 = paramHttpContext.getAttribute("http.user-token");
            if (this.managedConn == null)
            {
              paramHttpHost = this.connManager.requestConnection(localHttpRoute, localObject3);
              if ((paramHttpRequest instanceof AbortableHttpRequest)) {
                ((AbortableHttpRequest)paramHttpRequest).setConnectionRequest(paramHttpHost);
              }
              l = HttpClientParams.getConnectionManagerTimeout(this.params);
            }
          }
          catch (ConnectionShutdownException paramHttpHost)
          {
            HttpRoute localHttpRoute;
            HttpHost localHttpHost2;
            paramHttpRequest = new InterruptedIOException("Connection has been shut down");
            paramHttpRequest.initCause(paramHttpHost);
            throw paramHttpRequest;
            if ((paramHttpHost != null) && (paramHttpHost.getEntity() != null) && (paramHttpHost.getEntity().isStreaming())) {
              continue;
            }
            if (!bool) {
              continue;
            }
            this.managedConn.markReusable();
            releaseConnection();
            return paramHttpHost;
            localURI = ((RequestWrapper)localObject2).getURI();
            paramHttpHost = localHttpHost1;
            if (!localURI.isAbsolute()) {
              continue;
            }
            paramHttpHost = new HttpHost(localURI.getHost(), localURI.getPort(), localURI.getScheme());
            continue;
          }
          catch (HttpException paramHttpHost)
          {
            abortConnection();
            throw paramHttpHost;
            paramHttpHost.setParams(this.params);
            this.requestExec.postProcess(paramHttpHost, this.httpProcessor, paramHttpContext);
            bool = this.reuseStrategy.keepAlive(paramHttpHost, paramHttpContext);
            if (!bool) {
              continue;
            }
            long l = this.keepAliveStrategy.getKeepAliveDuration(paramHttpHost, paramHttpContext);
            if (!this.log.isDebugEnabled()) {
              continue;
            }
            if (l <= 0L) {
              break label1125;
            }
            localObject2 = "for " + l + " " + TimeUnit.MILLISECONDS;
            this.log.debug("Connection can be kept alive " + (String)localObject2);
            this.managedConn.setIdleDuration(l, TimeUnit.MILLISECONDS);
            localObject2 = handleResponse((RoutedRequest)localObject1, paramHttpHost, paramHttpContext);
            if (localObject2 != null) {
              continue;
            }
            i = 1;
            if (this.managedConn == null) {
              break label1122;
            }
            if (localObject3 != null) {
              break label1115;
            }
            localObject2 = this.userTokenHandler.getUserToken(paramHttpContext);
            paramHttpContext.setAttribute("http.user-token", localObject2);
            if (localObject2 == null) {
              break label1122;
            }
            this.managedConn.setState(localObject2);
            break label1122;
            if (!bool) {
              continue;
            }
            EntityUtils.consume(paramHttpHost.getEntity());
            this.managedConn.markReusable();
            if (((RoutedRequest)localObject2).getRoute().equals(((RoutedRequest)localObject1).getRoute())) {
              break label1133;
            }
            releaseConnection();
            break label1133;
            this.managedConn.close();
            if ((this.proxyAuthState.getState().compareTo(AuthProtocolState.CHALLENGED) <= 0) || (this.proxyAuthState.getAuthScheme() == null) || (!this.proxyAuthState.getAuthScheme().isConnectionBased())) {
              continue;
            }
            this.log.debug("Resetting proxy auth state");
            this.proxyAuthState.reset();
            if ((this.targetAuthState.getState().compareTo(AuthProtocolState.CHALLENGED) <= 0) || (this.targetAuthState.getAuthScheme() == null) || (!this.targetAuthState.getAuthScheme().isConnectionBased())) {
              continue;
            }
            this.log.debug("Resetting target auth state");
            this.targetAuthState.reset();
            continue;
          }
          catch (IOException paramHttpHost)
          {
            abortConnection();
            throw paramHttpHost;
            paramHttpHost.setEntity(new BasicManagedEntity(paramHttpHost.getEntity(), this.managedConn, bool));
            return paramHttpHost;
          }
          catch (RuntimeException paramHttpHost)
          {
            label496:
            abortConnection();
            throw paramHttpHost;
          }
          try
          {
            this.managedConn = paramHttpHost.getConnection(l, TimeUnit.MILLISECONDS);
            if ((HttpConnectionParams.isStaleCheckingEnabled(this.params)) && (this.managedConn.isOpen()))
            {
              this.log.debug("Stale connection check");
              if (this.managedConn.isStale())
              {
                this.log.debug("Stale connection detected");
                this.managedConn.close();
              }
            }
            if ((paramHttpRequest instanceof AbortableHttpRequest)) {
              ((AbortableHttpRequest)paramHttpRequest).setReleaseTrigger(this.managedConn);
            }
          }
          catch (InterruptedException paramHttpHost)
          {
            paramHttpRequest = new InterruptedIOException();
            paramHttpRequest.initCause(paramHttpHost);
            throw paramHttpRequest;
          }
        }
        try
        {
          tryConnect((RoutedRequest)localObject1, paramHttpContext);
          paramHttpHost = ((RequestWrapper)localObject2).getURI().getUserInfo();
          if (paramHttpHost != null) {
            this.targetAuthState.update(new BasicScheme(), new UsernamePasswordCredentials(paramHttpHost));
          }
          localHttpHost2 = localHttpRoute.getProxyHost();
          if (this.virtualHost == null) {
            break label621;
          }
          paramHttpHost = this.virtualHost;
          localHttpHost1 = paramHttpHost;
          if (paramHttpHost == null) {
            localHttpHost1 = localHttpRoute.getTargetHost();
          }
          ((RequestWrapper)localObject2).resetHeaders();
          rewriteRequestURI((RequestWrapper)localObject2, localHttpRoute);
          paramHttpContext.setAttribute("http.target_host", localHttpHost1);
          paramHttpContext.setAttribute("http.proxy_host", localHttpHost2);
          paramHttpContext.setAttribute("http.connection", this.managedConn);
          this.requestExec.preProcess((HttpRequest)localObject2, this.httpProcessor, paramHttpContext);
          paramHttpHost = tryExecute((RoutedRequest)localObject1, paramHttpContext);
          if (paramHttpHost != null) {
            break label672;
          }
        }
        catch (TunnelRefusedException paramHttpHost)
        {
          if (!this.log.isDebugEnabled()) {
            break label569;
          }
          this.log.debug(paramHttpHost.getMessage());
          paramHttpHost = paramHttpHost.getResponse();
        }
      }
    }
    for (;;)
    {
      label569:
      label621:
      URI localURI;
      label672:
      label1115:
      localObject2 = localObject3;
      continue;
      label1122:
      break;
      label1125:
      localObject2 = "indefinitely";
      continue;
      label1133:
      localObject1 = localObject2;
    }
  }
  
  protected RoutedRequest handleResponse(RoutedRequest paramRoutedRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    HttpRoute localHttpRoute = paramRoutedRequest.getRoute();
    RequestWrapper localRequestWrapper = paramRoutedRequest.getRequest();
    HttpParams localHttpParams = localRequestWrapper.getParams();
    Object localObject2;
    Object localObject1;
    if (HttpClientParams.isAuthenticating(localHttpParams))
    {
      localObject2 = (HttpHost)paramHttpContext.getAttribute("http.target_host");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localHttpRoute.getTargetHost();
      }
      if (((HttpHost)localObject1).getPort() >= 0) {
        break label544;
      }
      localObject2 = this.connManager.getSchemeRegistry().getScheme((HttpHost)localObject1);
      localObject1 = new HttpHost(((HttpHost)localObject1).getHostName(), ((Scheme)localObject2).getDefaultPort(), ((HttpHost)localObject1).getSchemeName());
    }
    label544:
    for (;;)
    {
      if ((this.authenticator.isAuthenticationRequested((HttpHost)localObject1, paramHttpResponse, this.targetAuthStrategy, this.targetAuthState, paramHttpContext)) && (this.authenticator.authenticate((HttpHost)localObject1, paramHttpResponse, this.targetAuthStrategy, this.targetAuthState, paramHttpContext))) {}
      do
      {
        do
        {
          return paramRoutedRequest;
          localObject2 = localHttpRoute.getProxyHost();
          if (!this.authenticator.isAuthenticationRequested((HttpHost)localObject2, paramHttpResponse, this.proxyAuthStrategy, this.proxyAuthState, paramHttpContext)) {
            break;
          }
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = localHttpRoute.getTargetHost();
          }
        } while (this.authenticator.authenticate((HttpHost)localObject1, paramHttpResponse, this.proxyAuthStrategy, this.proxyAuthState, paramHttpContext));
        if ((!HttpClientParams.isRedirecting(localHttpParams)) || (!this.redirectStrategy.isRedirected(localRequestWrapper, paramHttpResponse, paramHttpContext))) {
          break;
        }
        if (this.redirectCount >= this.maxRedirects) {
          throw new RedirectException("Maximum redirects (" + this.maxRedirects + ") exceeded");
        }
        this.redirectCount += 1;
        this.virtualHost = null;
        paramRoutedRequest = this.redirectStrategy.getRedirect(localRequestWrapper, paramHttpResponse, paramHttpContext);
        paramRoutedRequest.setHeaders(localRequestWrapper.getOriginal().getAllHeaders());
        localObject1 = paramRoutedRequest.getURI();
        paramHttpResponse = URIUtils.extractHost((URI)localObject1);
        if (paramHttpResponse == null) {
          throw new ProtocolException("Redirect URI does not specify a valid host name: " + localObject1);
        }
        if (!localHttpRoute.getTargetHost().equals(paramHttpResponse))
        {
          this.log.debug("Resetting target auth state");
          this.targetAuthState.reset();
          localObject2 = this.proxyAuthState.getAuthScheme();
          if ((localObject2 != null) && (((AuthScheme)localObject2).isConnectionBased()))
          {
            this.log.debug("Resetting proxy auth state");
            this.proxyAuthState.reset();
          }
        }
        paramRoutedRequest = wrapRequest(paramRoutedRequest);
        paramRoutedRequest.setParams(localHttpParams);
        paramHttpContext = determineRoute(paramHttpResponse, paramRoutedRequest, paramHttpContext);
        paramHttpResponse = new RoutedRequest(paramRoutedRequest, paramHttpContext);
        paramRoutedRequest = paramHttpResponse;
      } while (!this.log.isDebugEnabled());
      this.log.debug("Redirecting to '" + localObject1 + "' via " + paramHttpContext);
      return paramHttpResponse;
      return null;
    }
  }
  
  protected void releaseConnection()
  {
    try
    {
      this.managedConn.releaseConnection();
      this.managedConn = null;
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        this.log.debug("IOException releasing connection", localIOException);
      }
    }
  }
  
  /* Error */
  protected void rewriteRequestURI(RequestWrapper paramRequestWrapper, HttpRoute paramHttpRoute)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 641	com/amazonaws/org/apache/http/impl/client/RequestWrapper:getURI	()Ljava/net/URI;
    //   4: astore_3
    //   5: aload_2
    //   6: invokevirtual 411	com/amazonaws/org/apache/http/conn/routing/HttpRoute:getProxyHost	()Lcom/amazonaws/org/apache/http/HttpHost;
    //   9: ifnull +41 -> 50
    //   12: aload_2
    //   13: invokevirtual 298	com/amazonaws/org/apache/http/conn/routing/HttpRoute:isTunnelled	()Z
    //   16: ifne +34 -> 50
    //   19: aload_3
    //   20: invokevirtual 688	java/net/URI:isAbsolute	()Z
    //   23: ifne +19 -> 42
    //   26: aload_3
    //   27: aload_2
    //   28: invokevirtual 343	com/amazonaws/org/apache/http/conn/routing/HttpRoute:getTargetHost	()Lcom/amazonaws/org/apache/http/HttpHost;
    //   31: iconst_1
    //   32: invokestatic 830	com/amazonaws/org/apache/http/client/utils/URIUtils:rewriteURI	(Ljava/net/URI;Lcom/amazonaws/org/apache/http/HttpHost;Z)Ljava/net/URI;
    //   35: astore_2
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual 834	com/amazonaws/org/apache/http/impl/client/RequestWrapper:setURI	(Ljava/net/URI;)V
    //   41: return
    //   42: aload_3
    //   43: invokestatic 837	com/amazonaws/org/apache/http/client/utils/URIUtils:rewriteURI	(Ljava/net/URI;)Ljava/net/URI;
    //   46: astore_2
    //   47: goto -11 -> 36
    //   50: aload_3
    //   51: invokevirtual 688	java/net/URI:isAbsolute	()Z
    //   54: ifeq +13 -> 67
    //   57: aload_3
    //   58: aconst_null
    //   59: iconst_1
    //   60: invokestatic 830	com/amazonaws/org/apache/http/client/utils/URIUtils:rewriteURI	(Ljava/net/URI;Lcom/amazonaws/org/apache/http/HttpHost;Z)Ljava/net/URI;
    //   63: astore_2
    //   64: goto -28 -> 36
    //   67: aload_3
    //   68: invokestatic 837	com/amazonaws/org/apache/http/client/utils/URIUtils:rewriteURI	(Ljava/net/URI;)Ljava/net/URI;
    //   71: astore_2
    //   72: goto -36 -> 36
    //   75: astore_2
    //   76: new 814	com/amazonaws/org/apache/http/ProtocolException
    //   79: dup
    //   80: new 242	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 839
    //   90: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 843	com/amazonaws/org/apache/http/impl/client/RequestWrapper:getRequestLine	()Lcom/amazonaws/org/apache/http/RequestLine;
    //   97: invokeinterface 848 1 0
    //   102: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: aload_2
    //   109: invokespecial 849	com/amazonaws/org/apache/http/ProtocolException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	DefaultRequestDirector
    //   0	113	1	paramRequestWrapper	RequestWrapper
    //   0	113	2	paramHttpRoute	HttpRoute
    //   4	64	3	localURI	URI
    // Exception table:
    //   from	to	target	type
    //   0	36	75	java/net/URISyntaxException
    //   36	41	75	java/net/URISyntaxException
    //   42	47	75	java/net/URISyntaxException
    //   50	64	75	java/net/URISyntaxException
    //   67	72	75	java/net/URISyntaxException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/DefaultRequestDirector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */