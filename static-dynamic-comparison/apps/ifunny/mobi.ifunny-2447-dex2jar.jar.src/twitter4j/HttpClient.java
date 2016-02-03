package twitter4j;

import java.util.Map;

import twitter4j.auth.Authorization;

public abstract interface HttpClient {
    public abstract void addDefaultRequestHeader(String paramString1, String paramString2);

    public abstract HttpResponse delete(String paramString);

    public abstract HttpResponse delete(String paramString, HttpParameter[] paramArrayOfHttpParameter, Authorization paramAuthorization, HttpResponseListener paramHttpResponseListener);

    public abstract HttpResponse get(String paramString);

    public abstract HttpResponse get(String paramString, HttpParameter[] paramArrayOfHttpParameter, Authorization paramAuthorization, HttpResponseListener paramHttpResponseListener);

    public abstract Map<String, String> getRequestHeaders();

    public abstract HttpResponse head(String paramString);

    public abstract HttpResponse post(String paramString);

    public abstract HttpResponse post(String paramString, HttpParameter[] paramArrayOfHttpParameter, Authorization paramAuthorization, HttpResponseListener paramHttpResponseListener);

    public abstract HttpResponse put(String paramString);

    public abstract HttpResponse put(String paramString, HttpParameter[] paramArrayOfHttpParameter, Authorization paramAuthorization, HttpResponseListener paramHttpResponseListener);

    public abstract HttpResponse request(HttpRequest paramHttpRequest);

    public abstract HttpResponse request(HttpRequest paramHttpRequest, HttpResponseListener paramHttpResponseListener);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/HttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */