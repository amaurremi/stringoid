package twitter4j.internal.json;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

import twitter4j.PagableResponseList;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.UserList;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

class UserListJSONImpl
        extends TwitterResponseImpl
        implements UserList, Serializable {
    private static final long serialVersionUID = -6345893237975349030L;
    private String description;
    private boolean following;
    private String fullName;
    private int id;
    private int memberCount;
    private boolean mode;
    private String name;
    private String slug;
    private int subscriberCount;
    private String uri;
    private User user;

    UserListJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration)
            throws TwitterException {
        super(paramHttpResponse);
        if (paramConfiguration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
        }
        paramHttpResponse = paramHttpResponse.asJSONObject();
        init(paramHttpResponse);
        if (paramConfiguration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.registerJSONObject(this, paramHttpResponse);
        }
    }

    UserListJSONImpl(JSONObject paramJSONObject)
            throws TwitterException {
        init(paramJSONObject);
    }

    static PagableResponseList<UserList> createPagableUserListList(HttpResponse paramHttpResponse, Configuration paramConfiguration)
            throws TwitterException {
        for (; ; ) {
            int i;
            try {
                if (paramConfiguration.isJSONStoreEnabled()) {
                    DataObjectFactoryUtil.clearThreadLocalMap();
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
                        DataObjectFactoryUtil.registerJSONObject(localUserListJSONImpl, localJSONObject2);
                    }
                } else {
                    if (paramConfiguration.isJSONStoreEnabled()) {
                        DataObjectFactoryUtil.registerJSONObject(paramHttpResponse, localJSONObject1);
                    }
                    return paramHttpResponse;
                }
            } catch (JSONException paramHttpResponse) {
                throw new TwitterException(paramHttpResponse);
            } catch (TwitterException paramHttpResponse) {
                throw paramHttpResponse;
            }
            i += 1;
        }
    }

    static ResponseList<UserList> createUserListList(HttpResponse paramHttpResponse, Configuration paramConfiguration)
            throws TwitterException {
        for (; ; ) {
            int i;
            try {
                if (paramConfiguration.isJSONStoreEnabled()) {
                    DataObjectFactoryUtil.clearThreadLocalMap();
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
                        DataObjectFactoryUtil.registerJSONObject(localUserListJSONImpl, localJSONObject);
                    }
                } else {
                    if (paramConfiguration.isJSONStoreEnabled()) {
                        DataObjectFactoryUtil.registerJSONObject(paramHttpResponse, localJSONArray);
                    }
                    return paramHttpResponse;
                }
            } catch (JSONException paramHttpResponse) {
                throw new TwitterException(paramHttpResponse);
            } catch (TwitterException paramHttpResponse) {
                throw paramHttpResponse;
            }
            i += 1;
        }
    }

    private void init(JSONObject paramJSONObject)
            throws TwitterException {
        this.id = z_T4JInternalParseUtil.getInt("id", paramJSONObject);
        this.name = z_T4JInternalParseUtil.getRawString("name", paramJSONObject);
        this.fullName = z_T4JInternalParseUtil.getRawString("full_name", paramJSONObject);
        this.slug = z_T4JInternalParseUtil.getRawString("slug", paramJSONObject);
        this.description = z_T4JInternalParseUtil.getRawString("description", paramJSONObject);
        this.subscriberCount = z_T4JInternalParseUtil.getInt("subscriber_count", paramJSONObject);
        this.memberCount = z_T4JInternalParseUtil.getInt("member_count", paramJSONObject);
        this.uri = z_T4JInternalParseUtil.getRawString("uri", paramJSONObject);
        this.mode = "public".equals(z_T4JInternalParseUtil.getRawString("mode", paramJSONObject));
        this.following = z_T4JInternalParseUtil.getBoolean("following", paramJSONObject);
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
        return this.id - paramUserList.getId();
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

    public String getDescription() {
        return this.description;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getId() {
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
        return this.id;
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/json/UserListJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */