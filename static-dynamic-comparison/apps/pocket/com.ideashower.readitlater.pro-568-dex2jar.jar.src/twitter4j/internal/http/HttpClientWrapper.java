package twitter4j.internal.http;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import twitter4j.TwitterException;
import twitter4j.auth.Authorization;
import twitter4j.conf.ConfigurationContext;

public final class HttpClientWrapper
  implements Serializable
{
  private static final long serialVersionUID = -6511977105603119379L;
  private HttpClient http;
  private HttpResponseListener httpResponseListener;
  private final Map requestHeaders;
  private final HttpClientWrapperConfiguration wrapperConf;
  
  public HttpClientWrapper()
  {
    this.wrapperConf = ConfigurationContext.getInstance();
    this.requestHeaders = this.wrapperConf.getRequestHeaders();
    this.http = HttpClientFactory.getInstance(this.wrapperConf);
  }
  
  public HttpClientWrapper(HttpClientWrapperConfiguration paramHttpClientWrapperConfiguration)
  {
    this.wrapperConf = paramHttpClientWrapperConfiguration;
    this.requestHeaders = paramHttpClientWrapperConfiguration.getRequestHeaders();
    this.http = HttpClientFactory.getInstance(paramHttpClientWrapperConfiguration);
  }
  
  private HttpResponse request(HttpRequest paramHttpRequest)
  {
    try
    {
      HttpResponse localHttpResponse = this.http.request(paramHttpRequest);
      if (this.httpResponseListener != null) {
        this.httpResponseListener.httpResponseReceived(new HttpResponseEvent(paramHttpRequest, localHttpResponse, null));
      }
      return localHttpResponse;
    }
    catch (TwitterException localTwitterException)
    {
      if (this.httpResponseListener != null) {
        this.httpResponseListener.httpResponseReceived(new HttpResponseEvent(paramHttpRequest, null, localTwitterException));
      }
      throw localTwitterException;
    }
  }
  
  public HttpResponse delete(String paramString)
  {
    return request(new HttpRequest(RequestMethod.DELETE, paramString, null, null, this.requestHeaders));
  }
  
  public HttpResponse delete(String paramString, Authorization paramAuthorization)
  {
    return request(new HttpRequest(RequestMethod.DELETE, paramString, null, paramAuthorization, this.requestHeaders));
  }
  
  public HttpResponse delete(String paramString, HttpParameter[] paramArrayOfHttpParameter)
  {
    return request(new HttpRequest(RequestMethod.DELETE, paramString, paramArrayOfHttpParameter, null, this.requestHeaders));
  }
  
  public HttpResponse delete(String paramString, HttpParameter[] paramArrayOfHttpParameter, Authorization paramAuthorization)
  {
    return request(new HttpRequest(RequestMethod.DELETE, paramString, paramArrayOfHttpParameter, paramAuthorization, this.requestHeaders));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (HttpClientWrapper)paramObject;
      if (!this.http.equals(((HttpClientWrapper)paramObject).http)) {
        return false;
      }
      if (!this.requestHeaders.equals(((HttpClientWrapper)paramObject).requestHeaders)) {
        return false;
      }
    } while (this.wrapperConf.equals(((HttpClientWrapper)paramObject).wrapperConf));
    return false;
  }
  
  public HttpResponse get(String paramString)
  {
    return request(new HttpRequest(RequestMethod.GET, paramString, null, null, this.requestHeaders));
  }
  
  public HttpResponse get(String paramString, Authorization paramAuthorization)
  {
    return request(new HttpRequest(RequestMethod.GET, paramString, null, paramAuthorization, this.requestHeaders));
  }
  
  public HttpResponse get(String paramString, HttpParameter[] paramArrayOfHttpParameter)
  {
    return request(new HttpRequest(RequestMethod.GET, paramString, paramArrayOfHttpParameter, null, this.requestHeaders));
  }
  
  public HttpResponse get(String paramString, HttpParameter[] paramArrayOfHttpParameter, Authorization paramAuthorization)
  {
    return request(new HttpRequest(RequestMethod.GET, paramString, paramArrayOfHttpParameter, paramAuthorization, this.requestHeaders));
  }
  
  public int hashCode()
  {
    return (this.wrapperConf.hashCode() * 31 + this.http.hashCode()) * 31 + this.requestHeaders.hashCode();
  }
  
  public HttpResponse head(String paramString)
  {
    return request(new HttpRequest(RequestMethod.HEAD, paramString, null, null, this.requestHeaders));
  }
  
  public HttpResponse head(String paramString, Authorization paramAuthorization)
  {
    return request(new HttpRequest(RequestMethod.HEAD, paramString, null, paramAuthorization, this.requestHeaders));
  }
  
  public HttpResponse head(String paramString, HttpParameter[] paramArrayOfHttpParameter)
  {
    return request(new HttpRequest(RequestMethod.HEAD, paramString, paramArrayOfHttpParameter, null, this.requestHeaders));
  }
  
  public HttpResponse head(String paramString, HttpParameter[] paramArrayOfHttpParameter, Authorization paramAuthorization)
  {
    return request(new HttpRequest(RequestMethod.HEAD, paramString, paramArrayOfHttpParameter, paramAuthorization, this.requestHeaders));
  }
  
  public HttpResponse post(String paramString)
  {
    return request(new HttpRequest(RequestMethod.POST, paramString, null, null, this.requestHeaders));
  }
  
  public HttpResponse post(String paramString, Authorization paramAuthorization)
  {
    return request(new HttpRequest(RequestMethod.POST, paramString, null, paramAuthorization, this.requestHeaders));
  }
  
  public HttpResponse post(String paramString, HttpParameter[] paramArrayOfHttpParameter)
  {
    return request(new HttpRequest(RequestMethod.POST, paramString, paramArrayOfHttpParameter, null, this.requestHeaders));
  }
  
  public HttpResponse post(String paramString, HttpParameter[] paramArrayOfHttpParameter, Map paramMap)
  {
    HashMap localHashMap = new HashMap(this.requestHeaders);
    if (paramMap != null) {
      localHashMap.putAll(paramMap);
    }
    return request(new HttpRequest(RequestMethod.POST, paramString, paramArrayOfHttpParameter, null, localHashMap));
  }
  
  public HttpResponse post(String paramString, HttpParameter[] paramArrayOfHttpParameter, Authorization paramAuthorization)
  {
    return request(new HttpRequest(RequestMethod.POST, paramString, paramArrayOfHttpParameter, paramAuthorization, this.requestHeaders));
  }
  
  public HttpResponse put(String paramString)
  {
    return request(new HttpRequest(RequestMethod.PUT, paramString, null, null, this.requestHeaders));
  }
  
  public HttpResponse put(String paramString, Authorization paramAuthorization)
  {
    return request(new HttpRequest(RequestMethod.PUT, paramString, null, paramAuthorization, this.requestHeaders));
  }
  
  public HttpResponse put(String paramString, HttpParameter[] paramArrayOfHttpParameter)
  {
    return request(new HttpRequest(RequestMethod.PUT, paramString, paramArrayOfHttpParameter, null, this.requestHeaders));
  }
  
  public HttpResponse put(String paramString, HttpParameter[] paramArrayOfHttpParameter, Authorization paramAuthorization)
  {
    return request(new HttpRequest(RequestMethod.PUT, paramString, paramArrayOfHttpParameter, paramAuthorization, this.requestHeaders));
  }
  
  public void setHttpResponseListener(HttpResponseListener paramHttpResponseListener)
  {
    this.httpResponseListener = paramHttpResponseListener;
  }
  
  public void shutdown()
  {
    this.http.shutdown();
  }
  
  public String toString()
  {
    return "HttpClientWrapper{wrapperConf=" + this.wrapperConf + ", http=" + this.http + ", requestHeaders=" + this.requestHeaders + ", httpResponseListener=" + this.httpResponseListener + '}';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/http/HttpClientWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */