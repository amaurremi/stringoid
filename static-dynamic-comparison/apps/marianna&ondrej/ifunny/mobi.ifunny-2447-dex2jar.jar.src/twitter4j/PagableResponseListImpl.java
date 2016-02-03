package twitter4j;

class PagableResponseListImpl<T>
        extends ResponseListImpl
        implements PagableResponseList {
    private static final long serialVersionUID = -8603601553967559275L;
    private final long nextCursor;
    private final long previousCursor;

    PagableResponseListImpl(int paramInt, JSONObject paramJSONObject, HttpResponse paramHttpResponse) {
        super(paramInt, paramHttpResponse);
        this.previousCursor = ParseUtil.getLong("previous_cursor", paramJSONObject);
        this.nextCursor = ParseUtil.getLong("next_cursor", paramJSONObject);
    }

    PagableResponseListImpl(RateLimitStatus paramRateLimitStatus, int paramInt) {
        super(paramRateLimitStatus, paramInt);
        this.previousCursor = 0L;
        this.nextCursor = 0L;
    }

    public long getNextCursor() {
        return this.nextCursor;
    }

    public long getPreviousCursor() {
        return this.previousCursor;
    }

    public boolean hasNext() {
        return 0L != this.nextCursor;
    }

    public boolean hasPrevious() {
        return 0L != this.previousCursor;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/PagableResponseListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */