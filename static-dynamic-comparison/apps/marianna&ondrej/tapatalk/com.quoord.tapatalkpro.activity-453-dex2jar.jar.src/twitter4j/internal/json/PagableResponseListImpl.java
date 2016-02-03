package twitter4j.internal.json;

import twitter4j.PagableResponseList;
import twitter4j.RateLimitStatus;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONObject;

class PagableResponseListImpl<T>
        extends ResponseListImpl
        implements PagableResponseList {
    private static final long serialVersionUID = 1531950333538983361L;
    private final long nextCursor;
    private final long previousCursor;

    PagableResponseListImpl(int paramInt, JSONObject paramJSONObject, HttpResponse paramHttpResponse) {
        super(paramInt, paramHttpResponse);
        this.previousCursor = z_T4JInternalParseUtil.getLong("previous_cursor", paramJSONObject);
        this.nextCursor = z_T4JInternalParseUtil.getLong("next_cursor", paramJSONObject);
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/json/PagableResponseListImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */