package twitter4j;

import java.util.ArrayList;

class ResponseListImpl<T>
        extends ArrayList<T>
        implements ResponseList<T> {
    private static final long serialVersionUID = 9105950888010803544L;
    private transient int accessLevel;
    private transient RateLimitStatus rateLimitStatus = null;

    ResponseListImpl(int paramInt, HttpResponse paramHttpResponse) {
        super(paramInt);
        init(paramHttpResponse);
    }

    ResponseListImpl(HttpResponse paramHttpResponse) {
        init(paramHttpResponse);
    }

    ResponseListImpl(RateLimitStatus paramRateLimitStatus, int paramInt) {
        this.rateLimitStatus = paramRateLimitStatus;
        this.accessLevel = paramInt;
    }

    private void init(HttpResponse paramHttpResponse) {
        this.rateLimitStatus = RateLimitStatusJSONImpl.createFromResponseHeader(paramHttpResponse);
        this.accessLevel = ParseUtil.toAccessLevel(paramHttpResponse);
    }

    public int getAccessLevel() {
        return this.accessLevel;
    }

    public RateLimitStatus getRateLimitStatus() {
        return this.rateLimitStatus;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/ResponseListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */