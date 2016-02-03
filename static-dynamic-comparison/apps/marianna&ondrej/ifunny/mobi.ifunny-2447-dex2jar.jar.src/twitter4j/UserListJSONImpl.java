package twitter4j;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import twitter4j.conf.Configuration;

class UserListJSONImpl
        extends TwitterResponseImpl
        implements Serializable, UserList {
    private static final long serialVersionUID = 449418980060197008L;
    private Date createdAt;
    private String description;
    private boolean following;
    private String fullName;
    private long id;
    private int memberCount;
    private boolean mode;
    private String name;
    private String slug;
    private int subscriberCount;
    private String uri;
    private User user;

    UserListJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration) {
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

    UserListJSONImpl(JSONObject paramJSONObject) {
        init(paramJSONObject);
    }

    static PagableResponseList<UserList> createPagableUserListList(HttpResponse paramHttpResponse, Configuration paramConfiguration) {
        for (; ; ) {
            int i;
            try {
                if (paramConfiguration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.clearThreadLocalMap();
                }
                JSONObject localJSONObject1 = paramHttpResponse.asJSONObject();
                JSONArray localJSONArray = localJSONObject1.getJSONArray("lists");
                int j = localJSONArray.length();
                paramHttpResponse = new PagableResponseListImpl(j, localJSONObject1, paramHttpResponse);
                i = 0;
                if (i < j) {
                    JSONObject localJSONObject2 = localJSONArray.getJSONObject(i);
                    UserListJSONImpl localUserListJSONImpl = new UserListJSONImpl(localJSONObject2);
                    paramHttpResponse.add(localUserListJSONImpl);
                    if (paramConfiguration.isJSONStoreEnabled()) {
                        TwitterObjectFactory.registerJSONObject(localUserListJSONImpl, localJSONObject2);
                    }
                } else {
                    if (paramConfiguration.isJSONStoreEnabled()) {
                        TwitterObjectFactory.registerJSONObject(paramHttpResponse, localJSONObject1);
                    }
                    return paramHttpResponse;
                }
            } catch (JSONException paramHttpResponse) {
                throw new TwitterException(paramHttpResponse);
            }
            i += 1;
        }
    }

    static ResponseList<UserList> createUserListList(HttpResponse paramHttpResponse, Configuration paramConfiguration) {
        for (; ; ) {
            int i;
            try {
                if (paramConfiguration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.clearThreadLocalMap();
                }
                JSONArray localJSONArray = paramHttpResponse.asJSONArray();
                int j = localJSONArray.length();
                paramHttpResponse = new ResponseListImpl(j, paramHttpResponse);
                i = 0;
                if (i < j) {
                    JSONObject localJSONObject = localJSONArray.getJSONObject(i);
                    UserListJSONImpl localUserListJSONImpl = new UserListJSONImpl(localJSONObject);
                    paramHttpResponse.add(localUserListJSONImpl);
                    if (paramConfiguration.isJSONStoreEnabled()) {
                        TwitterObjectFactory.registerJSONObject(localUserListJSONImpl, localJSONObject);
                    }
                } else {
                    if (paramConfiguration.isJSONStoreEnabled()) {
                        TwitterObjectFactory.registerJSONObject(paramHttpResponse, localJSONArray);
                    }
                    return paramHttpResponse;
                }
            } catch (JSONException paramHttpResponse) {
                throw new TwitterException(paramHttpResponse);
            }
            i += 1;
        }
    }

    private void init(JSONObject paramJSONObject) {
        this.id = ParseUtil.getLong("id", paramJSONObject);
        this.name = ParseUtil.getRawString("name", paramJSONObject);
        this.fullName = ParseUtil.getRawString("full_name", paramJSONObject);
        this.slug = ParseUtil.getRawString("slug", paramJSONObject);
        this.description = ParseUtil.getRawString("description", paramJSONObject);
        this.subscriberCount = ParseUtil.getInt("subscriber_count", paramJSONObject);
        this.memberCount = ParseUtil.getInt("member_count", paramJSONObject);
        this.uri = ParseUtil.getRawString("uri", paramJSONObject);
        this.mode = "public".equals(ParseUtil.getRawString("mode", paramJSONObject));
        this.following = ParseUtil.getBoolean("following", paramJSONObject);
        this.createdAt = ParseUtil.getDate("created_at", paramJSONObject);
        try {
            if (!paramJSONObject.isNull("user")) {
                this.user = new UserJSONImpl(paramJSONObject.getJSONObject("user"));
            }
            return;
        } catch (JSONException localJSONException) {
            throw new TwitterException(localJSONException.getMessage() + ":" + paramJSONObject.toString(), localJSONException);
        }
    }

    public int compareTo(UserList paramUserList) {
        long l = this.id - paramUserList.getId();
        if (l < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        if (l > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) l;
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (paramObject == null) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (this == paramObject);
            if (!(paramObject instanceof UserList)) {
                break;
            }
            bool1 = bool2;
        } while (((UserList) paramObject).getId() == this.id);
        return false;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public String getDescription() {
        return this.description;
    }

    public String getFullName() {
        return this.fullName;
    }

    public long getId() {
        return this.id;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public String getName() {
        return this.name;
    }

    public String getSlug() {
        return this.slug;
    }

    public int getSubscriberCount() {
        return this.subscriberCount;
    }

    public URI getURI() {
        try {
            URI localURI = new URI(this.uri);
            return localURI;
        } catch (URISyntaxException localURISyntaxException) {
        }
        return null;
    }

    public User getUser() {
        return this.user;
    }

    public int hashCode() {
        return (int) this.id;
    }

    public boolean isFollowing() {
        return this.following;
    }

    public boolean isPublic() {
        return this.mode;
    }

    public String toString() {
        return "UserListJSONImpl{id=" + this.id + ", name='" + this.name + '\'' + ", fullName='" + this.fullName + '\'' + ", slug='" + this.slug + '\'' + ", description='" + this.description + '\'' + ", subscriberCount=" + this.subscriberCount + ", memberCount=" + this.memberCount + ", uri='" + this.uri + '\'' + ", mode=" + this.mode + ", user=" + this.user + ", following=" + this.following + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/UserListJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */