package twitter4j.internal.json;

import java.io.Serializable;

import twitter4j.Relationship;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

class RelationshipJSONImpl
        extends TwitterResponseImpl
        implements Relationship, Serializable {
    private static final long serialVersionUID = 7725021608907856360L;
    private final boolean sourceBlockingTarget;
    private final boolean sourceCanDm;
    private final boolean sourceFollowedByTarget;
    private final boolean sourceFollowingTarget;
    private final boolean sourceNotificationsEnabled;
    private final long sourceUserId;
    private final String sourceUserScreenName;
    private final long targetUserId;
    private final String targetUserScreenName;
    private boolean wantRetweets;

    RelationshipJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration)
            throws TwitterException {
        this(paramHttpResponse, paramHttpResponse.asJSONObject());
        if (paramConfiguration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
            DataObjectFactoryUtil.registerJSONObject(this, paramHttpResponse.asJSONObject());
        }
    }

    RelationshipJSONImpl(HttpResponse paramHttpResponse, JSONObject paramJSONObject)
            throws TwitterException {
        super(paramHttpResponse);
        try {
            JSONObject localJSONObject = paramJSONObject.getJSONObject("relationship");
            paramHttpResponse = localJSONObject.getJSONObject("source");
            localJSONObject = localJSONObject.getJSONObject("target");
            this.sourceUserId = z_T4JInternalParseUtil.getLong("id", paramHttpResponse);
            this.targetUserId = z_T4JInternalParseUtil.getLong("id", localJSONObject);
            this.sourceUserScreenName = z_T4JInternalParseUtil.getUnescapedString("screen_name", paramHttpResponse);
            this.targetUserScreenName = z_T4JInternalParseUtil.getUnescapedString("screen_name", localJSONObject);
            this.sourceBlockingTarget = z_T4JInternalParseUtil.getBoolean("blocking", paramHttpResponse);
            this.sourceFollowingTarget = z_T4JInternalParseUtil.getBoolean("following", paramHttpResponse);
            this.sourceFollowedByTarget = z_T4JInternalParseUtil.getBoolean("followed_by", paramHttpResponse);
            this.sourceCanDm = z_T4JInternalParseUtil.getBoolean("can_dm", paramHttpResponse);
            this.sourceNotificationsEnabled = z_T4JInternalParseUtil.getBoolean("notifications_enabled", paramHttpResponse);
            this.wantRetweets = z_T4JInternalParseUtil.getBoolean("want_retweets", paramHttpResponse);
            return;
        } catch (JSONException paramHttpResponse) {
            throw new TwitterException(paramHttpResponse.getMessage() + ":" + paramJSONObject.toString(), paramHttpResponse);
        }
    }

    RelationshipJSONImpl(JSONObject paramJSONObject)
            throws TwitterException {
        this(null, paramJSONObject);
    }

    static ResponseList<Relationship> createRelationshipList(HttpResponse paramHttpResponse, Configuration paramConfiguration)
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
                RelationshipJSONImpl localRelationshipJSONImpl = new RelationshipJSONImpl(localJSONObject);
                if (paramConfiguration.isJSONStoreEnabled()) {
                    DataObjectFactoryUtil.registerJSONObject(localRelationshipJSONImpl, localJSONObject);
                }
                paramHttpResponse.add(localRelationshipJSONImpl);
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

    public boolean canSourceDm() {
        return this.sourceCanDm;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof Relationship)) {
                return false;
            }
            paramObject = (Relationship) paramObject;
            if (this.sourceUserId != ((Relationship) paramObject).getSourceUserId()) {
                return false;
            }
            if (this.targetUserId != ((Relationship) paramObject).getTargetUserId()) {
                return false;
            }
            if (!this.sourceUserScreenName.equals(((Relationship) paramObject).getSourceUserScreenName())) {
                return false;
            }
        } while (this.targetUserScreenName.equals(((Relationship) paramObject).getTargetUserScreenName()));
        return false;
    }

    public long getSourceUserId() {
        return this.sourceUserId;
    }

    public String getSourceUserScreenName() {
        return this.sourceUserScreenName;
    }

    public long getTargetUserId() {
        return this.targetUserId;
    }

    public String getTargetUserScreenName() {
        return this.targetUserScreenName;
    }

    public int hashCode() {
        int i1 = 1;
        int i2 = 0;
        int i3 = (int) (this.targetUserId ^ this.targetUserId >>> 32);
        int i;
        int j;
        label45:
        int k;
        label54:
        int m;
        label64:
        int n;
        if (this.targetUserScreenName != null) {
            i = this.targetUserScreenName.hashCode();
            if (!this.sourceBlockingTarget) {
                break label165;
            }
            j = 1;
            if (!this.sourceNotificationsEnabled) {
                break label170;
            }
            k = 1;
            if (!this.sourceFollowingTarget) {
                break label175;
            }
            m = 1;
            if (!this.sourceFollowedByTarget) {
                break label181;
            }
            n = 1;
            label74:
            if (!this.sourceCanDm) {
                break label187;
            }
        }
        for (; ; ) {
            int i4 = (int) (this.sourceUserId ^ this.sourceUserId >>> 32);
            if (this.sourceUserScreenName != null) {
                i2 = this.sourceUserScreenName.hashCode();
            }
            return (((((((i3 * 31 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i4) * 31 + i2;
            i = 0;
            break;
            label165:
            j = 0;
            break label45;
            label170:
            k = 0;
            break label54;
            label175:
            m = 0;
            break label64;
            label181:
            n = 0;
            break label74;
            label187:
            i1 = 0;
        }
    }

    public boolean isSourceBlockingTarget() {
        return this.sourceBlockingTarget;
    }

    public boolean isSourceFollowedByTarget() {
        return this.sourceFollowedByTarget;
    }

    public boolean isSourceFollowingTarget() {
        return this.sourceFollowingTarget;
    }

    public boolean isSourceNotificationsEnabled() {
        return this.sourceNotificationsEnabled;
    }

    public boolean isSourceWantRetweets() {
        return this.wantRetweets;
    }

    public boolean isTargetFollowedBySource() {
        return this.sourceFollowingTarget;
    }

    public boolean isTargetFollowingSource() {
        return this.sourceFollowedByTarget;
    }

    public String toString() {
        return "RelationshipJSONImpl{sourceUserId=" + this.sourceUserId + ", targetUserId=" + this.targetUserId + ", sourceUserScreenName='" + this.sourceUserScreenName + '\'' + ", targetUserScreenName='" + this.targetUserScreenName + '\'' + ", sourceFollowingTarget=" + this.sourceFollowingTarget + ", sourceFollowedByTarget=" + this.sourceFollowedByTarget + ", sourceCanDm=" + this.sourceCanDm + ", sourceNotificationsEnabled=" + this.sourceNotificationsEnabled + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/json/RelationshipJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */