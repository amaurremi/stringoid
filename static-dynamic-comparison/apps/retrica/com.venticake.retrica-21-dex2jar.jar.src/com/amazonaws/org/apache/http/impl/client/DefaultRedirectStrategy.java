package com.amazonaws.org.apache.http.impl.client;

import com.amazonaws.org.apache.http.Header;
import com.amazonaws.org.apache.http.HttpEntityEnclosingRequest;
import com.amazonaws.org.apache.http.HttpHost;
import com.amazonaws.org.apache.http.HttpRequest;
import com.amazonaws.org.apache.http.HttpResponse;
import com.amazonaws.org.apache.http.ProtocolException;
import com.amazonaws.org.apache.http.RequestLine;
import com.amazonaws.org.apache.http.StatusLine;
import com.amazonaws.org.apache.http.client.CircularRedirectException;
import com.amazonaws.org.apache.http.client.RedirectStrategy;
import com.amazonaws.org.apache.http.client.methods.HttpDelete;
import com.amazonaws.org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import com.amazonaws.org.apache.http.client.methods.HttpGet;
import com.amazonaws.org.apache.http.client.methods.HttpHead;
import com.amazonaws.org.apache.http.client.methods.HttpOptions;
import com.amazonaws.org.apache.http.client.methods.HttpPatch;
import com.amazonaws.org.apache.http.client.methods.HttpPost;
import com.amazonaws.org.apache.http.client.methods.HttpPut;
import com.amazonaws.org.apache.http.client.methods.HttpTrace;
import com.amazonaws.org.apache.http.client.methods.HttpUriRequest;
import com.amazonaws.org.apache.http.client.utils.URIUtils;
import com.amazonaws.org.apache.http.params.HttpParams;
import com.amazonaws.org.apache.http.protocol.HttpContext;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.Immutable;

@Immutable
public class DefaultRedirectStrategy
  implements RedirectStrategy
{
  private static final String[] REDIRECT_METHODS = { "GET", "HEAD" };
  private final Log log = LogFactory.getLog(getClass());
  
  private HttpUriRequest copyEntity(HttpEntityEnclosingRequestBase paramHttpEntityEnclosingRequestBase, HttpRequest paramHttpRequest)
  {
    if ((paramHttpRequest instanceof HttpEntityEnclosingRequest)) {
      paramHttpEntityEnclosingRequestBase.setEntity(((HttpEntityEnclosingRequest)paramHttpRequest).getEntity());
    }
    return paramHttpEntityEnclosingRequestBase;
  }
  
  protected URI createLocationURI(String paramString)
  {
    try
    {
      URI localURI = new URI(paramString).normalize();
      return localURI;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      throw new ProtocolException("Invalid redirect URI: " + paramString, localURISyntaxException);
    }
  }
  
  public URI getLocationURI(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    if (paramHttpRequest == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    if (paramHttpResponse == null) {
      throw new IllegalArgumentException("HTTP response may not be null");
    }
    if (paramHttpContext == null) {
      throw new IllegalArgumentException("HTTP context may not be null");
    }
    Object localObject = paramHttpResponse.getFirstHeader("location");
    if (localObject == null) {
      throw new ProtocolException("Received redirect response " + paramHttpResponse.getStatusLine() + " but no location header");
    }
    paramHttpResponse = ((Header)localObject).getValue();
    if (this.log.isDebugEnabled()) {
      this.log.debug("Redirect requested to location '" + paramHttpResponse + "'");
    }
    paramHttpResponse = createLocationURI(paramHttpResponse);
    HttpParams localHttpParams = paramHttpRequest.getParams();
    try
    {
      localObject = URIUtils.rewriteURI(paramHttpResponse);
      paramHttpResponse = (HttpResponse)localObject;
      if (((URI)localObject).isAbsolute()) {
        break label292;
      }
      if (localHttpParams.isParameterTrue("http.protocol.reject-relative-redirect")) {
        throw new ProtocolException("Relative redirect location '" + localObject + "' not allowed");
      }
    }
    catch (URISyntaxException paramHttpRequest)
    {
      throw new ProtocolException(paramHttpRequest.getMessage(), paramHttpRequest);
    }
    paramHttpResponse = (HttpHost)paramHttpContext.getAttribute("http.target_host");
    if (paramHttpResponse == null) {
      throw new IllegalStateException("Target host not available in the HTTP context");
    }
    paramHttpResponse = URIUtils.resolve(URIUtils.rewriteURI(new URI(paramHttpRequest.getRequestLine().getUri()), paramHttpResponse, true), (URI)localObject);
    label292:
    localObject = (RedirectLocations)paramHttpContext.getAttribute("http.protocol.redirect-locations");
    paramHttpRequest = (HttpRequest)localObject;
    if (localObject == null)
    {
      paramHttpRequest = new RedirectLocations();
      paramHttpContext.setAttribute("http.protocol.redirect-locations", paramHttpRequest);
    }
    if ((localHttpParams.isParameterFalse("http.protocol.allow-circular-redirects")) && (paramHttpRequest.contains(paramHttpResponse))) {
      throw new CircularRedirectException("Circular redirect to '" + paramHttpResponse + "'");
    }
    paramHttpRequest.add(paramHttpResponse);
    return paramHttpResponse;
  }
  
  public HttpUriRequest getRedirect(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    paramHttpContext = getLocationURI(paramHttpRequest, paramHttpResponse, paramHttpContext);
    String str = paramHttpRequest.getRequestLine().getMethod();
    if (str.equalsIgnoreCase("HEAD")) {
      return new HttpHead(paramHttpContext);
    }
    if (str.equalsIgnoreCase("GET")) {
      return new HttpGet(paramHttpContext);
    }
    if (paramHttpResponse.getStatusLine().getStatusCode() == 307)
    {
      if (str.equalsIgnoreCase("POST")) {
        return copyEntity(new HttpPost(paramHttpContext), paramHttpRequest);
      }
      if (str.equalsIgnoreCase("PUT")) {
        return copyEntity(new HttpPut(paramHttpContext), paramHttpRequest);
      }
      if (str.equalsIgnoreCase("DELETE")) {
        return new HttpDelete(paramHttpContext);
      }
      if (str.equalsIgnoreCase("TRACE")) {
        return new HttpTrace(paramHttpContext);
      }
      if (str.equalsIgnoreCase("OPTIONS")) {
        return new HttpOptions(paramHttpContext);
      }
      if (str.equalsIgnoreCase("PATCH")) {
        return copyEntity(new HttpPatch(paramHttpContext), paramHttpRequest);
      }
    }
    return new HttpGet(paramHttpContext);
  }
  
  protected boolean isRedirectable(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = REDIRECT_METHODS;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean isRedirected(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    boolean bool2 = true;
    if (paramHttpRequest == null) {
      throw new IllegalArgumentException("HTTP request may not be null");
    }
    if (paramHttpResponse == null) {
      throw new IllegalArgumentException("HTTP response may not be null");
    }
    int i = paramHttpResponse.getStatusLine().getStatusCode();
    paramHttpRequest = paramHttpRequest.getRequestLine().getMethod();
    paramHttpResponse = paramHttpResponse.getFirstHeader("location");
    boolean bool1 = bool2;
    switch (i)
    {
    case 304: 
    case 305: 
    case 306: 
    default: 
      bool1 = false;
    case 303: 
    case 302: 
      do
      {
        return bool1;
        if (!isRedirectable(paramHttpRequest)) {
          break;
        }
        bool1 = bool2;
      } while (paramHttpResponse != null);
      return false;
    }
    return isRedirectable(paramHttpRequest);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/org/apache/http/impl/client/DefaultRedirectStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */