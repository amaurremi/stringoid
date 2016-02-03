package twitter4j;

import java.io.Serializable;

import twitter4j.conf.Configuration;

class RelationshipJSONImpl
        extends TwitterResponseImpl
        implements Serializable, Relationship {
    private static final long serialVersionUID = -2001484553401916448L;
    private final boolean sourceBlockingTarget;
    private final boolean sourceCanDm;
    private final boolean sourceFollowedByTarget;
    private final boolean sourceFollowingTarget;
    private final boolean sourceMutingTarget;
    private final boolean sourceNotificationsEnabled;
    private final long sourceUserId;
    private final String sourceUserScreenName;
    private final long targetUserId;
    private final String targetUserScreenName;
    private boolean wantRetweets;

    RelationshipJSONImpl(HttpResponse paramHttpResponse, JSONObject paramJSONObject) {
        super(paramHttpResponse);
        try {
            JSONObject localJSONObject = paramJSONObject.getJSONObject("relationship");
            paramHttpResponse = localJSONObject.getJSONObject("source");
            localJSONObject = localJSONObject.getJSONObject("target");
            this.sourceUserId = ParseUtil.getLong("id", paramHttpResponse);
            this.targetUserId = ParseUtil.getLong("id", localJSONObject);
            this.sourceUserScreenName = ParseUtil.getUnescapedString("screen_name", paramHttpResponse);
            this.targetUserScreenName = ParseUtil.getUnescapedString("screen_name", localJSONObject);
            this.sourceBlockingTarget = ParseUtil.getBoolean("blocking", paramHttpResponse);
            this.sourceFollowingTarget = ParseUtil.getBoolean("following", paramHttpResponse);
            this.sourceFollowedByTarget = ParseUtil.getBoolean("followed_by", paramHttpResponse);
            this.sourceCanDm = ParseUtil.getBoolean("can_dm", paramHttpResponse);
            this.sourceMutingTarget = ParseUtil.getBoolean("muting", paramHttpResponse);
            this.sourceNotificationsEnabled = ParseUtil.getBoolean("notifications_enabled", paramHttpResponse);
            this.wantRetweets = ParseUtil.getBoolean("want_retweets", paramHttpResponse);
            return;
        } catch (JSONException paramHttpResponse) {
            throw new TwitterException(paramHttpResponse.getMessage() + ":" + paramJSONObject.toString(), paramHttpResponse);
        }
    }

    RelationshipJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration) {
        this(paramHttpResponse, paramHttpResponse.asJSONObject());
        if (paramConfiguration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, paramHttpResponse.asJSONObject());
        }
    }

    RelationshipJSONImpl(JSONObject paramJSONObject) {
        this(null, paramJSONObject);
    }

    static ResponseList<Relationship> createRelationshipList(HttpResponse paramHttpResponse, Configuration paramConfiguration) {
        try {
            if (paramConfiguration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            JSONArray localJSONArray = paramHttpResponse.asJSONArray();
            int j = localJSONArray.length();
            paramHttpResponse = new ResponseListImpl(j, paramHttpResponse);
            int i = 0;
            while (i < j) {
                JSONObject localJSONObject = localJSONArray.getJSONObject(i);
                RelationshipJSONImpl localRelationshipJSONImpl = new RelationshipJSONImpl(localJSONObject);
                if (paramConfiguration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(localRelationshipJSONImpl, localJSONObject);
                }
                paramHttpResponse.add(localRelationshipJSONImpl);
                i += 1;
            }
            if (paramConfiguration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(paramHttpResponse, localJSONArray);
            }
            return paramHttpResponse;
        } catch (JSONException paramHttpResponse) {
            throw new TwitterException(paramHttpResponse);
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
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
                return false;
            }
            paramObject = (RelationshipJSONImpl) paramObject;
            if (this.sourceBlockingTarget != ((RelationshipJSONImpl) paramObject).sourceBlockingTarget) {
                return false;
            }
            if (this.sourceCanDm != ((RelationshipJSONImpl) paramObject).sourceCanDm) {
                return false;
            }
            if (this.sourceFollowedByTarget != ((RelationshipJSONImpl) paramObject).sourceFollowedByTarget) {
                return false;
            }
            if (this.sourceFollowingTarget != ((RelationshipJSONImpl) paramObject).sourceFollowingTarget) {
                return false;
            }
            if (this.sourceMutingTarget != ((RelationshipJSONImpl) paramObject).sourceMutingTarget) {
                return false;
            }
            if (this.sourceNotificationsEnabled != ((RelationshipJSONImpl) paramObject).sourceNotificationsEnabled) {
                return false;
            }
            if (this.sourceUserId != ((RelationshipJSONImpl) paramObject).sourceUserId) {
                return false;
            }
            if (this.targetUserId != ((RelationshipJSONImpl) paramObject).targetUserId) {
                return false;
            }
            if (this.wantRetweets != ((RelationshipJSONImpl) paramObject).wantRetweets) {
                return false;
            }
            if (this.sourceUserScreenName != null) {
                if (this.sourceUserScreenName.equals(((RelationshipJSONImpl) paramObject).sourceUserScreenName)) {
                }
            } else {
                while (((RelationshipJSONImpl) paramObject).sourceUserScreenName != null) {
                    return false;
                }
            }
            if (this.targetUserScreenName == null) {
                break;
            }
        } while (this.targetUserScreenName.equals(((RelationshipJSONImpl) paramObject).targetUserScreenName));
        for (; ; ) {
            return false;
            if (((RelationshipJSONImpl) paramObject).targetUserScreenName == null) {
                break;
            }
        }
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
        int i4 = 1;
        int i5 = (int) (this.targetUserId ^ this.targetUserId >>> 32);
        int i;
        int j;
        label42:
        int k;
        label51:
        int m;
        label61:
        int n;
        label71:
        int i1;
        label81:
        int i2;
        label91:
        int i6;
        int i3;
        if (this.targetUserScreenName != null) {
            i = this.targetUserScreenName.hashCode();
            if (!this.sourceBlockingTarget) {
                break label194;
            }
            j = 1;
            if (!this.sourceNotificationsEnabled) {
                break label199;
            }
            k = 1;
            if (!this.sourceFollowingTarget) {
                break label204;
            }
            m = 1;
            if (!this.sourceFollowedByTarget) {
                break label210;
            }
            n = 1;
            if (!this.sourceCanDm) {
                break label216;
            }
            i1 = 1;
            if (!this.sourceMutingTarget) {
                break label222;
            }
            i2 = 1;
            i6 = (int) (this.sourceUserId ^ this.sourceUserId >>> 32);
            if (this.sourceUserScreenName == null) {
                break label228;
            }
            i3 = this.sourceUserScreenName.hashCode();
            label122:
            if (!this.wantRetweets) {
                break label234;
            }
        }
        for (; ; ) {
            return (i3 + ((i2 + (i1 + (n + (m + (k + (j + (i + i5 * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i6) * 31) * 31 + i4;
            i = 0;
            break;
            label194:
            j = 0;
            break label42;
            label199:
            k = 0;
            break label51;
            label204:
            m = 0;
            break label61;
            label210:
            n = 0;
            break label71;
            label216:
            i1 = 0;
            break label81;
            label222:
            i2 = 0;
            break label91;
            label228:
            i3 = 0;
            break label122;
            label234:
            i4 = 0;
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

    public boolean isSourceMutingTarget() {
        return this.sourceMutingTarget;
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
        return "RelationshipJSONImpl{targetUserId=" + this.targetUserId + ", targetUserScreenName='" + this.targetUserScreenName + '\'' + ", sourceBlockingTarget=" + this.sourceBlockingTarget + ", sourceNotificationsEnabled=" + this.sourceNotificationsEnabled + ", sourceFollowingTarget=" + this.sourceFollowingTarget + ", sourceFollowedByTarget=" + this.sourceFollowedByTarget + ", sourceCanDm=" + this.sourceCanDm + ", sourceMutingTarget=" + this.sourceMutingTarget + ", sourceUserId=" + this.sourceUserId + ", sourceUserScreenName='" + this.sourceUserScreenName + '\'' + ", wantRetweets=" + this.wantRetweets + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/RelationshipJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */