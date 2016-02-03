package twitter4j;

import java.util.EventObject;

public final class RateLimitStatusEvent
        extends EventObject {
    private static final long serialVersionUID = 3749366911109722414L;
    private final boolean isAccountRateLimitStatus;
    private final RateLimitStatus rateLimitStatus;

    RateLimitStatusEvent(Object paramObject, RateLimitStatus paramRateLimitStatus, boolean paramBoolean) {
        super(paramObject);
        this.rateLimitStatus = paramRateLimitStatus;
        this.isAccountRateLimitStatus = paramBoolean;
    }

    public RateLimitStatus getRateLimitStatus() {
        return this.rateLimitStatus;
    }

    public boolean isAccountRateLimitStatus() {
        return this.isAccountRateLimitStatus;
    }

    public boolean isIPRateLimitStatus() {
        return !this.isAccountRateLimitStatus;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/RateLimitStatusEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */