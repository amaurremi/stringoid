package twitter4j;

import twitter4j.auth.Authorization;

public final class HttpResponseEvent {
    private final HttpRequest request;
    private final HttpResponse response;
    private final TwitterException twitterException;

    HttpResponseEvent(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, TwitterException paramTwitterException) {
        this.request = paramHttpRequest;
        this.response = paramHttpResponse;
        this.twitterException = paramTwitterException;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
                return false;
            }
            paramObject = (HttpResponseEvent) paramObject;
            if (this.request != null) {
                if (this.request.equals(((HttpResponseEvent) paramObject).request)) {
                }
            } else {
                while (((HttpResponseEvent) paramObject).request != null) {
                    return false;
                }
            }
            if (this.response == null) {
                break;
            }
        } while (this.response.equals(((HttpResponseEvent) paramObject).response));
        for (; ; ) {
            return false;
            if (((HttpResponseEvent) paramObject).response == null) {
                break;
            }
        }
    }

    public HttpRequest getRequest() {
        return this.request;
    }

    public HttpResponse getResponse() {
        return this.response;
    }

    public TwitterException getTwitterException() {
        return this.twitterException;
    }

    public int hashCode() {
        int j = 0;
        if (this.request != null) {
        }
        for (int i = this.request.hashCode(); ; i = 0) {
            if (this.response != null) {
                j = this.response.hashCode();
            }
            return i * 31 + j;
        }
    }

    public boolean isAuthenticated() {
        return this.request.getAuthorization().isEnabled();
    }

    public String toString() {
        return "HttpResponseEvent{request=" + this.request + ", response=" + this.response + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/HttpResponseEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */