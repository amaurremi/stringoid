package twitter4j;

import java.io.Serializable;

abstract class TwitterResponseImpl
        implements Serializable, TwitterResponse {
    private static final long serialVersionUID = 7422171124869859808L;
    private final transient int accessLevel;
    private transient RateLimitStatus rateLimitStatus = null;

    public TwitterResponseImpl() {
        this.accessLevel = 0;
    }

    public TwitterResponseImpl(HttpResponse paramHttpResponse) {
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/TwitterResponseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */