package twitter4j;

public abstract interface RateLimitStatusListener {
    public abstract void onRateLimitReached(RateLimitStatusEvent paramRateLimitStatusEvent);

    public abstract void onRateLimitStatus(RateLimitStatusEvent paramRateLimitStatusEvent);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/RateLimitStatusListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */