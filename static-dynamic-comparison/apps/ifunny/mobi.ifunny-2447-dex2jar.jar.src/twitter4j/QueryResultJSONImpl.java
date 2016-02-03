package twitter4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import twitter4j.conf.Configuration;

final class QueryResultJSONImpl
        extends TwitterResponseImpl
        implements Serializable, QueryResult {
    private static final long serialVersionUID = -5359566235429947156L;
    private double completedIn;
    private int count;
    private long maxId;
    private String nextResults;
    private String query;
    private String refreshUrl;
    private long sinceId;
    private List<Status> tweets;

    QueryResultJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration) {
        super(paramHttpResponse);
        JSONObject localJSONObject1 = paramHttpResponse.asJSONObject();
        for (; ; ) {
            try {
                JSONObject localJSONObject2 = localJSONObject1.getJSONObject("search_metadata");
                this.completedIn = ParseUtil.getDouble("completed_in", localJSONObject2);
                this.count = ParseUtil.getInt("count", localJSONObject2);
                this.maxId = ParseUtil.getLong("max_id", localJSONObject2);
                if (localJSONObject2.has("next_results")) {
                    paramHttpResponse = localJSONObject2.getString("next_results");
                    this.nextResults = paramHttpResponse;
                    this.query = ParseUtil.getURLDecodedString("query", localJSONObject2);
                    this.refreshUrl = ParseUtil.getUnescapedString("refresh_url", localJSONObject2);
                    this.sinceId = ParseUtil.getLong("since_id", localJSONObject2);
                    paramHttpResponse = localJSONObject1.getJSONArray("statuses");
                    this.tweets = new ArrayList(paramHttpResponse.length());
                    if (!paramConfiguration.isJSONStoreEnabled()) {
                        break label235;
                    }
                    TwitterObjectFactory.clearThreadLocalMap();
                    break label235;
                    if (i < paramHttpResponse.length()) {
                        localJSONObject2 = paramHttpResponse.getJSONObject(i);
                        this.tweets.add(new StatusJSONImpl(localJSONObject2, paramConfiguration));
                        i += 1;
                        continue;
                    }
                } else {
                    paramHttpResponse = null;
                    continue;
                }
                return;
            } catch (JSONException paramHttpResponse) {
                throw new TwitterException(paramHttpResponse.getMessage() + ":" + localJSONObject1.toString(), paramHttpResponse);
            }
            label235:
            int i = 0;
        }
    }

    QueryResultJSONImpl(Query paramQuery) {
        this.sinceId = paramQuery.getSinceId();
        this.count = paramQuery.getCount();
        this.tweets = new ArrayList(0);
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
                return false;
            }
            paramObject = (QueryResult) paramObject;
            if (Double.compare(((QueryResult) paramObject).getCompletedIn(), this.completedIn) != 0) {
                return false;
            }
            if (this.maxId != ((QueryResult) paramObject).getMaxId()) {
                return false;
            }
            if (this.count != ((QueryResult) paramObject).getCount()) {
                return false;
            }
            if (this.sinceId != ((QueryResult) paramObject).getSinceId()) {
                return false;
            }
            if (!this.query.equals(((QueryResult) paramObject).getQuery())) {
                return false;
            }
            if (this.refreshUrl != null) {
                if (this.refreshUrl.equals(((QueryResult) paramObject).getRefreshURL())) {
                }
            } else {
                while (((QueryResult) paramObject).getRefreshURL() != null) {
                    return false;
                }
            }
            if (this.tweets == null) {
                break;
            }
        } while (this.tweets.equals(((QueryResult) paramObject).getTweets()));
        for (; ; ) {
            return false;
            if (((QueryResult) paramObject).getTweets() == null) {
                break;
            }
        }
    }

    public double getCompletedIn() {
        return this.completedIn;
    }

    public int getCount() {
        return this.count;
    }

    public long getMaxId() {
        return this.maxId;
    }

    public String getQuery() {
        return this.query;
    }

    public String getRefreshURL() {
        return this.refreshUrl;
    }

    public long getSinceId() {
        return this.sinceId;
    }

    public List<Status> getTweets() {
        return this.tweets;
    }

    public boolean hasNext() {
        return this.nextResults != null;
    }

    public int hashCode() {
        int j = 0;
        int k = (int) (this.sinceId ^ this.sinceId >>> 32);
        int m = (int) (this.maxId ^ this.maxId >>> 32);
        int i;
        int n;
        if (this.refreshUrl != null) {
            i = this.refreshUrl.hashCode();
            n = this.count;
            if (this.completedIn == 0.0D) {
                break label148;
            }
        }
        label148:
        for (long l = Double.doubleToLongBits(this.completedIn); ; l = 0L) {
            int i1 = (int) (l ^ l >>> 32);
            int i2 = this.query.hashCode();
            if (this.tweets != null) {
                j = this.tweets.hashCode();
            }
            return ((((i + (k * 31 + m) * 31) * 31 + n) * 31 + i1) * 31 + i2) * 31 + j;
            i = 0;
            break;
        }
    }

    public Query nextQuery() {
        if (this.nextResults == null) {
            return null;
        }
        return Query.createWithNextPageQuery(this.nextResults);
    }

    public String toString() {
        return "QueryResultJSONImpl{sinceId=" + this.sinceId + ", maxId=" + this.maxId + ", refreshUrl='" + this.refreshUrl + '\'' + ", count=" + this.count + ", completedIn=" + this.completedIn + ", query='" + this.query + '\'' + ", tweets=" + this.tweets + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/QueryResultJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */