package twitter4j.internal.json;

import twitter4j.Friendship;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

class FriendshipJSONImpl
        implements Friendship {
    private static final long serialVersionUID = 7724410837770709741L;
    private boolean followedBy = false;
    private boolean following = false;
    private final long id;
    private final String name;
    private final String screenName;

    FriendshipJSONImpl(JSONObject paramJSONObject)
            throws TwitterException {
        for (; ; ) {
            int i;
            try {
                this.id = z_T4JInternalParseUtil.getLong("id", paramJSONObject);
                this.name = paramJSONObject.getString("name");
                this.screenName = paramJSONObject.getString("screen_name");
                JSONArray localJSONArray = paramJSONObject.getJSONArray("connections");
                i = 0;
                if (i < localJSONArray.length()) {
                    String str = localJSONArray.getString(i);
                    if ("following".equals(str)) {
                        this.following = true;
                    } else if ("followed_by".equals(str)) {
                        this.followedBy = true;
                    }
                }
            } catch (JSONException localJSONException) {
                throw new TwitterException(localJSONException.getMessage() + ":" + paramJSONObject.toString(), localJSONException);
            }
            return;
            i += 1;
        }
    }

    static ResponseList<Friendship> createFriendshipList(HttpResponse paramHttpResponse, Configuration paramConfiguration)
            throws TwitterException {
        try {
            if (paramConfiguration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.clearThreadLocalMap();
            }
            JSONArray localJSONArray = paramHttpResponse.asJSONArray();
            int j = localJSONArray.length();
            paramHttpResponse = new ResponseListImpl(j, paramHttpResponse);
            int i = 0;
            while (i < j) {
                JSONObject localJSONObject = localJSONArray.getJSONObject(i);
                FriendshipJSONImpl localFriendshipJSONImpl = new FriendshipJSONImpl(localJSONObject);
                if (paramConfiguration.isJSONStoreEnabled()) {
                    DataObjectFactoryUtil.registerJSONObject(localFriendshipJSONImpl, localJSONObject);
                }
                paramHttpResponse.add(localFriendshipJSONImpl);
                i += 1;
            }
            if (paramConfiguration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.registerJSONObject(paramHttpResponse, localJSONArray);
            }
            return paramHttpResponse;
        } catch (JSONException paramHttpResponse) {
            throw new TwitterException(paramHttpResponse);
        } catch (TwitterException paramHttpResponse) {
            throw paramHttpResponse;
        }
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
                return false;
            }
            paramObject = (FriendshipJSONImpl) paramObject;
            if (this.followedBy != ((FriendshipJSONImpl) paramObject).followedBy) {
                return false;
            }
            if (this.following != ((FriendshipJSONImpl) paramObject).following) {
                return false;
            }
            if (this.id != ((FriendshipJSONImpl) paramObject).id) {
                return false;
            }
            if (!this.name.equals(((FriendshipJSONImpl) paramObject).name)) {
                return false;
            }
        } while (this.screenName.equals(((FriendshipJSONImpl) paramObject).screenName));
        return false;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public int hashCode() {
        int m = 1;
        int n = (int) (this.id ^ this.id >>> 32);
        int i;
        int j;
        label48:
        int k;
        if (this.name != null) {
            i = this.name.hashCode();
            if (this.screenName == null) {
                break label93;
            }
            j = this.screenName.hashCode();
            if (!this.following) {
                break label98;
            }
            k = 1;
            label57:
            if (!this.followedBy) {
                break label103;
            }
        }
        for (; ; ) {
            return (((n * 31 + i) * 31 + j) * 31 + k) * 31 + m;
            i = 0;
            break;
            label93:
            j = 0;
            break label48;
            label98:
            k = 0;
            break label57;
            label103:
            m = 0;
        }
    }

    public boolean isFollowedBy() {
        return this.followedBy;
    }

    public boolean isFollowing() {
        return this.following;
    }

    public String toString() {
        return "FriendshipJSONImpl{id=" + this.id + ", name='" + this.name + '\'' + ", screenName='" + this.screenName + '\'' + ", following=" + this.following + ", followedBy=" + this.followedBy + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/json/FriendshipJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */