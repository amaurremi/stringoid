package twitter4j;

import java.io.DataOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import twitter4j.auth.Authorization;

public abstract class HttpClientBase
        implements Serializable, HttpClient {
    private static final Logger logger = Logger.getLogger(HttpClientBase.class);
    private static final long serialVersionUID = -8016974810651763053L;
    protected final HttpClientConfiguration CONF;
    private final Map<String, String> requestHeaders;

    public HttpClientBase(HttpClientConfiguration paramHttpClientConfiguration) {
        this.CONF = paramHttpClientConfiguration;
        this.requestHeaders = new HashMap();
        this.requestHeaders.put("X-Twitter-Client-Version", Version.getVersion());
        this.requestHeaders.put("X-Twitter-Client-URL", "http://twitter4j.org/en/twitter4j-" + Version.getVersion() + ".xml");
        this.requestHeaders.put("X-Twitter-Client", "Twitter4J");
        this.requestHeaders.put("User-Agent", "twitter4j http://twitter4j.org/ /" + Version.getVersion());
        if (paramHttpClientConfiguration.isGZIPEnabled()) {
            this.requestHeaders.put("Accept-Encoding", "gzip");
        }
    }

    public void addDefaultRequestHeader(String paramString1, String paramString2) {
        this.requestHeaders.put(paramString1, paramString2);
    }

    public HttpResponse delete(String paramString) {
        return request(new HttpRequest(RequestMethod.DELETE, paramString, null, null, this.requestHeaders));
    }

    public HttpResponse delete(String paramString, HttpParameter[] paramArrayOfHttpParameter, Authorization paramAuthorization, HttpResponseListener paramHttpResponseListener) {
        return request(new HttpRequest(RequestMethod.DELETE, paramString, paramArrayOfHttpParameter, paramAuthorization, this.requestHeaders), paramHttpResponseListener);
    }

    public HttpResponse get(String paramString) {
        return request(new HttpRequest(RequestMethod.GET, paramString, null, null, this.requestHeaders));
    }

    public HttpResponse get(String paramString, HttpParameter[] paramArrayOfHttpParameter, Authorization paramAuthorization, HttpResponseListener paramHttpResponseListener) {
        return request(new HttpRequest(RequestMethod.GET, paramString, paramArrayOfHttpParameter, paramAuthorization, this.requestHeaders), paramHttpResponseListener);
    }

    public Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    abstract HttpResponse handleRequest(HttpRequest paramHttpRequest);

    public HttpResponse head(String paramString) {
        return request(new HttpRequest(RequestMethod.HEAD, paramString, null, null, this.requestHeaders));
    }

    protected boolean isProxyConfigured() {
        return (this.CONF.getHttpProxyHost() != null) && (!this.CONF.getHttpProxyHost().equals(""));
    }

    public HttpResponse post(String paramString) {
        return request(new HttpRequest(RequestMethod.POST, paramString, null, null, this.requestHeaders));
    }

    public HttpResponse post(String paramString, HttpParameter[] paramArrayOfHttpParameter, Authorization paramAuthorization, HttpResponseListener paramHttpResponseListener) {
        return request(new HttpRequest(RequestMethod.POST, paramString, paramArrayOfHttpParameter, paramAuthorization, this.requestHeaders), paramHttpResponseListener);
    }

    public HttpResponse put(String paramString) {
        return request(new HttpRequest(RequestMethod.PUT, paramString, null, null, this.requestHeaders));
    }

    public HttpResponse put(String paramString, HttpParameter[] paramArrayOfHttpParameter, Authorization paramAuthorization, HttpResponseListener paramHttpResponseListener) {
        return request(new HttpRequest(RequestMethod.PUT, paramString, paramArrayOfHttpParameter, paramAuthorization, this.requestHeaders), paramHttpResponseListener);
    }

    public final HttpResponse request(HttpRequest paramHttpRequest) {
        return handleRequest(paramHttpRequest);
    }

    public final HttpResponse request(HttpRequest paramHttpRequest, HttpResponseListener paramHttpResponseListener) {
        try {
            HttpResponse localHttpResponse = handleRequest(paramHttpRequest);
            if (paramHttpResponseListener != null) {
                paramHttpResponseListener.httpResponseReceived(new HttpResponseEvent(paramHttpRequest, localHttpResponse, null));
            }
            return localHttpResponse;
        } catch (TwitterException localTwitterException) {
            if (paramHttpResponseListener != null) {
                paramHttpResponseListener.httpResponseReceived(new HttpResponseEvent(paramHttpRequest, null, localTwitterException));
            }
            throw localTwitterException;
        }
    }

    public void write(DataOutputStream paramDataOutputStream, String paramString) {
        paramDataOutputStream.writeBytes(paramString);
        logger.debug(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/HttpClientBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */