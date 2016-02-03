package twitter4j;

import java.util.Date;

import twitter4j.conf.Configuration;

final class SavedSearchJSONImpl
        extends TwitterResponseImpl
        implements SavedSearch {
    private static final long serialVersionUID = 846086437256360810L;
    private Date createdAt;
    private int id;
    private String name;
    private int position;
    private String query;

    SavedSearchJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration) {
        super(paramHttpResponse);
        if (paramConfiguration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        paramHttpResponse = paramHttpResponse.asJSONObject();
        init(paramHttpResponse);
        if (paramConfiguration.isJSONStoreEnabled()) {
            TwitterObjectFactory.registerJSONObject(this, paramHttpResponse);
        }
    }

    SavedSearchJSONImpl(JSONObject paramJSONObject) {
        init(paramJSONObject);
    }

    static ResponseList<SavedSearch> createSavedSearchList(HttpResponse paramHttpResponse, Configuration paramConfiguration) {
        if (paramConfiguration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        JSONArray localJSONArray = paramHttpResponse.asJSONArray();
        for (; ; ) {
            int i;
            try {
                ResponseListImpl localResponseListImpl = new ResponseListImpl(localJSONArray.length(), paramHttpResponse);
                i = 0;
                if (i < localJSONArray.length()) {
                    JSONObject localJSONObject = localJSONArray.getJSONObject(i);
                    SavedSearchJSONImpl localSavedSearchJSONImpl = new SavedSearchJSONImpl(localJSONObject);
                    localResponseListImpl.add(localSavedSearchJSONImpl);
                    if (paramConfiguration.isJSONStoreEnabled()) {
                        TwitterObjectFactory.registerJSONObject(localSavedSearchJSONImpl, localJSONObject);
                    }
                } else {
                    if (paramConfiguration.isJSONStoreEnabled()) {
                        TwitterObjectFactory.registerJSONObject(localResponseListImpl, localJSONArray);
                    }
                    return localResponseListImpl;
                }
            } catch (JSONException paramConfiguration) {
                throw new TwitterException(paramConfiguration.getMessage() + ":" + paramHttpResponse.asString(), paramConfiguration);
            }
            i += 1;
        }
    }

    private void init(JSONObject paramJSONObject) {
        this.createdAt = ParseUtil.getDate("created_at", paramJSONObject, "EEE MMM dd HH:mm:ss z yyyy");
        this.query = ParseUtil.getUnescapedString("query", paramJSONObject);
        this.position = ParseUtil.getInt("position", paramJSONObject);
        this.name = ParseUtil.getUnescapedString("name", paramJSONObject);
        this.id = ParseUtil.getInt("id", paramJSONObject);
    }

    public int compareTo(SavedSearch paramSavedSearch) {
        return this.id - paramSavedSearch.getId();
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof SavedSearch)) {
                return false;
            }
            paramObject = (SavedSearch) paramObject;
        } while (this.id == ((SavedSearch) paramObject).getId());
        return false;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public String getQuery() {
        return this.query;
    }

    public int hashCode() {
        return (((this.createdAt.hashCode() * 31 + this.query.hashCode()) * 31 + this.position) * 31 + this.name.hashCode()) * 31 + this.id;
    }

    public String toString() {
        return "SavedSearchJSONImpl{createdAt=" + this.createdAt + ", query='" + this.query + '\'' + ", position=" + this.position + ", name='" + this.name + '\'' + ", id=" + this.id + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/SavedSearchJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */