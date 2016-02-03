package twitter4j;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import twitter4j.conf.Configuration;

final class StatusJSONImpl
        extends TwitterResponseImpl
        implements Serializable, Status {
    private static final Logger logger = Logger.getLogger(StatusJSONImpl.class);
    private static final long serialVersionUID = -6461195536943679985L;
    private long[] contributorsIDs;
    private Date createdAt;
    private long currentUserRetweetId = -1L;
    private MediaEntity[] extendedMediaEntities;
    private int favoriteCount;
    private GeoLocation geoLocation = null;
    private HashtagEntity[] hashtagEntities;
    private long id;
    private String inReplyToScreenName;
    private long inReplyToStatusId;
    private long inReplyToUserId;
    private boolean isFavorited;
    private boolean isPossiblySensitive;
    private boolean isRetweeted;
    private boolean isTruncated;
    private String lang;
    private MediaEntity[] mediaEntities;
    private Place place = null;
    private long retweetCount;
    private Status retweetedStatus;
    private Scopes scopes;
    private String source;
    private SymbolEntity[] symbolEntities;
    private String text;
    private URLEntity[] urlEntities;
    private User user = null;
    private UserMentionEntity[] userMentionEntities;

    StatusJSONImpl() {
    }

    StatusJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration) {
        super(paramHttpResponse);
        paramHttpResponse = paramHttpResponse.asJSONObject();
        init(paramHttpResponse);
        if (paramConfiguration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, paramHttpResponse);
        }
    }

    StatusJSONImpl(JSONObject paramJSONObject) {
        init(paramJSONObject);
    }

    StatusJSONImpl(JSONObject paramJSONObject, Configuration paramConfiguration) {
        init(paramJSONObject);
        if (paramConfiguration.isJSONStoreEnabled()) {
            TwitterObjectFactory.registerJSONObject(this, paramJSONObject);
        }
    }

    static ResponseList<Status> createStatusList(HttpResponse paramHttpResponse, Configuration paramConfiguration) {
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
                StatusJSONImpl localStatusJSONImpl = new StatusJSONImpl(localJSONObject);
                if (paramConfiguration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(localStatusJSONImpl, localJSONObject);
                }
                paramHttpResponse.add(localStatusJSONImpl);
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

    private void init(JSONObject paramJSONObject) {
        int j = 0;
        this.id = ParseUtil.getLong("id", paramJSONObject);
        this.source = ParseUtil.getUnescapedString("source", paramJSONObject);
        this.createdAt = ParseUtil.getDate("created_at", paramJSONObject);
        this.isTruncated = ParseUtil.getBoolean("truncated", paramJSONObject);
        this.inReplyToStatusId = ParseUtil.getLong("in_reply_to_status_id", paramJSONObject);
        this.inReplyToUserId = ParseUtil.getLong("in_reply_to_user_id", paramJSONObject);
        this.isFavorited = ParseUtil.getBoolean("favorited", paramJSONObject);
        this.isRetweeted = ParseUtil.getBoolean("retweeted", paramJSONObject);
        this.inReplyToScreenName = ParseUtil.getUnescapedString("in_reply_to_screen_name", paramJSONObject);
        this.retweetCount = ParseUtil.getLong("retweet_count", paramJSONObject);
        this.favoriteCount = ParseUtil.getInt("favorite_count", paramJSONObject);
        this.isPossiblySensitive = ParseUtil.getBoolean("possibly_sensitive", paramJSONObject);
        try {
            if (!paramJSONObject.isNull("user")) {
                this.user = new UserJSONImpl(paramJSONObject.getJSONObject("user"));
            }
            this.geoLocation = JSONImplFactory.createGeoLocation(paramJSONObject);
            if (!paramJSONObject.isNull("place")) {
                this.place = new PlaceJSONImpl(paramJSONObject.getJSONObject("place"));
            }
            if (!paramJSONObject.isNull("retweeted_status")) {
                this.retweetedStatus = new StatusJSONImpl(paramJSONObject.getJSONObject("retweeted_status"));
            }
            int i;
            if (!paramJSONObject.isNull("contributors")) {
                localObject = paramJSONObject.getJSONArray("contributors");
                this.contributorsIDs = new long[((JSONArray) localObject).length()];
                i = 0;
                while (i < ((JSONArray) localObject).length()) {
                    this.contributorsIDs[i] = Long.parseLong(((JSONArray) localObject).getString(i));
                    i += 1;
                }
            }
            this.contributorsIDs = new long[0];
            int k;
            if (!paramJSONObject.isNull("entities")) {
                localObject = paramJSONObject.getJSONObject("entities");
                JSONArray localJSONArray;
                if (!((JSONObject) localObject).isNull("user_mentions")) {
                    localJSONArray = ((JSONObject) localObject).getJSONArray("user_mentions");
                    k = localJSONArray.length();
                    this.userMentionEntities = new UserMentionEntity[k];
                    i = 0;
                    while (i < k) {
                        this.userMentionEntities[i] = new UserMentionEntityJSONImpl(localJSONArray.getJSONObject(i));
                        i += 1;
                    }
                }
                if (!((JSONObject) localObject).isNull("urls")) {
                    localJSONArray = ((JSONObject) localObject).getJSONArray("urls");
                    k = localJSONArray.length();
                    this.urlEntities = new URLEntity[k];
                    i = 0;
                    while (i < k) {
                        this.urlEntities[i] = new URLEntityJSONImpl(localJSONArray.getJSONObject(i));
                        i += 1;
                    }
                }
                if (!((JSONObject) localObject).isNull("hashtags")) {
                    localJSONArray = ((JSONObject) localObject).getJSONArray("hashtags");
                    k = localJSONArray.length();
                    this.hashtagEntities = new HashtagEntity[k];
                    i = 0;
                    while (i < k) {
                        this.hashtagEntities[i] = new HashtagEntityJSONImpl(localJSONArray.getJSONObject(i));
                        i += 1;
                    }
                }
                if (!((JSONObject) localObject).isNull("symbols")) {
                    localJSONArray = ((JSONObject) localObject).getJSONArray("symbols");
                    k = localJSONArray.length();
                    this.symbolEntities = new SymbolEntity[k];
                    i = 0;
                    while (i < k) {
                        this.symbolEntities[i] = new HashtagEntityJSONImpl(localJSONArray.getJSONObject(i));
                        i += 1;
                    }
                }
                if (!((JSONObject) localObject).isNull("media")) {
                    localObject = ((JSONObject) localObject).getJSONArray("media");
                    k = ((JSONArray) localObject).length();
                    this.mediaEntities = new MediaEntity[k];
                    i = 0;
                    while (i < k) {
                        this.mediaEntities[i] = new MediaEntityJSONImpl(((JSONArray) localObject).getJSONObject(i));
                        i += 1;
                    }
                }
            }
            if (!paramJSONObject.isNull("extended_entities")) {
                localObject = paramJSONObject.getJSONObject("extended_entities");
                if (!((JSONObject) localObject).isNull("media")) {
                    localObject = ((JSONObject) localObject).getJSONArray("media");
                    k = ((JSONArray) localObject).length();
                    this.extendedMediaEntities = new MediaEntity[k];
                    i = 0;
                    while (i < k) {
                        this.extendedMediaEntities[i] = new MediaEntityJSONImpl(((JSONArray) localObject).getJSONObject(i));
                        i += 1;
                    }
                }
            }
            if (this.userMentionEntities == null) {
                localObject = new UserMentionEntity[0];
                this.userMentionEntities = ((UserMentionEntity[]) localObject);
                if (this.urlEntities != null) {
                    break label1013;
                }
                localObject = new URLEntity[0];
                label772:
                this.urlEntities = ((URLEntity[]) localObject);
                if (this.hashtagEntities != null) {
                    break label1022;
                }
                localObject = new HashtagEntity[0];
                label791:
                this.hashtagEntities = ((HashtagEntity[]) localObject);
                if (this.symbolEntities != null) {
                    break label1031;
                }
                localObject = new SymbolEntity[0];
                label810:
                this.symbolEntities = ((SymbolEntity[]) localObject);
                if (this.mediaEntities != null) {
                    break label1040;
                }
                localObject = new MediaEntity[0];
                label829:
                this.mediaEntities = ((MediaEntity[]) localObject);
                if (this.extendedMediaEntities != null) {
                    break label1049;
                }
            }
            label1013:
            label1022:
            label1031:
            label1040:
            label1049:
            for (Object localObject = new MediaEntity[0]; ; localObject = this.extendedMediaEntities) {
                this.extendedMediaEntities = ((MediaEntity[]) localObject);
                this.text = HTMLEntity.unescapeAndSlideEntityIncdices(paramJSONObject.getString("text"), this.userMentionEntities, this.urlEntities, this.hashtagEntities, this.mediaEntities);
                if (!paramJSONObject.isNull("current_user_retweet")) {
                    this.currentUserRetweetId = paramJSONObject.getJSONObject("current_user_retweet").getLong("id");
                }
                if (!paramJSONObject.isNull("lang")) {
                    this.lang = ParseUtil.getUnescapedString("lang", paramJSONObject);
                }
                if (paramJSONObject.isNull("scopes")) {
                    break label1071;
                }
                paramJSONObject = paramJSONObject.getJSONObject("scopes");
                if (paramJSONObject.isNull("place_ids")) {
                    break label1071;
                }
                paramJSONObject = paramJSONObject.getJSONArray("place_ids");
                k = paramJSONObject.length();
                localObject = new String[k];
                i = j;
                while (i < k) {
                    localObject[i] = paramJSONObject.getString(i);
                    i += 1;
                }
                localObject = this.userMentionEntities;
                break;
                localObject = this.urlEntities;
                break label772;
                localObject = this.hashtagEntities;
                break label791;
                localObject = this.symbolEntities;
                break label810;
                localObject = this.mediaEntities;
                break label829;
            }
            this.scopes = new ScopesImpl((String[]) localObject);
            label1071:
            return;
        } catch (JSONException paramJSONObject) {
            throw new TwitterException(paramJSONObject);
        }
    }

    public int compareTo(Status paramStatus) {
        long l = this.id - paramStatus.getId();
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
            if (!(paramObject instanceof Status)) {
                break;
            }
            bool1 = bool2;
        } while (((Status) paramObject).getId() == this.id);
        return false;
    }

    public long[] getContributors() {
        return this.contributorsIDs;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public long getCurrentUserRetweetId() {
        return this.currentUserRetweetId;
    }

    public MediaEntity[] getExtendedMediaEntities() {
        return this.extendedMediaEntities;
    }

    public int getFavoriteCount() {
        return this.favoriteCount;
    }

    public GeoLocation getGeoLocation() {
        return this.geoLocation;
    }

    public HashtagEntity[] getHashtagEntities() {
        return this.hashtagEntities;
    }

    public long getId() {
        return this.id;
    }

    public String getInReplyToScreenName() {
        return this.inReplyToScreenName;
    }

    public long getInReplyToStatusId() {
        return this.inReplyToStatusId;
    }

    public long getInReplyToUserId() {
        return this.inReplyToUserId;
    }

    public String getLang() {
        return this.lang;
    }

    public MediaEntity[] getMediaEntities() {
        return this.mediaEntities;
    }

    public Place getPlace() {
        return this.place;
    }

    public int getRetweetCount() {
        return (int) this.retweetCount;
    }

    public Status getRetweetedStatus() {
        return this.retweetedStatus;
    }

    public Scopes getScopes() {
        return this.scopes;
    }

    public String getSource() {
        return this.source;
    }

    public SymbolEntity[] getSymbolEntities() {
        return this.symbolEntities;
    }

    public String getText() {
        return this.text;
    }

    public URLEntity[] getURLEntities() {
        return this.urlEntities;
    }

    public User getUser() {
        return this.user;
    }

    public UserMentionEntity[] getUserMentionEntities() {
        return this.userMentionEntities;
    }

    public int hashCode() {
        return (int) this.id;
    }

    public boolean isFavorited() {
        return this.isFavorited;
    }

    public boolean isPossiblySensitive() {
        return this.isPossiblySensitive;
    }

    public boolean isRetweet() {
        return this.retweetedStatus != null;
    }

    public boolean isRetweeted() {
        return this.isRetweeted;
    }

    public boolean isRetweetedByMe() {
        return this.currentUserRetweetId != -1L;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public String toString() {
        return "StatusJSONImpl{createdAt=" + this.createdAt + ", id=" + this.id + ", text='" + this.text + '\'' + ", source='" + this.source + '\'' + ", isTruncated=" + this.isTruncated + ", inReplyToStatusId=" + this.inReplyToStatusId + ", inReplyToUserId=" + this.inReplyToUserId + ", isFavorited=" + this.isFavorited + ", isRetweeted=" + this.isRetweeted + ", favoriteCount=" + this.favoriteCount + ", inReplyToScreenName='" + this.inReplyToScreenName + '\'' + ", geoLocation=" + this.geoLocation + ", place=" + this.place + ", retweetCount=" + this.retweetCount + ", isPossiblySensitive=" + this.isPossiblySensitive + ", lang='" + this.lang + '\'' + ", contributorsIDs=" + Arrays.toString(this.contributorsIDs) + ", retweetedStatus=" + this.retweetedStatus + ", userMentionEntities=" + Arrays.toString(this.userMentionEntities) + ", urlEntities=" + Arrays.toString(this.urlEntities) + ", hashtagEntities=" + Arrays.toString(this.hashtagEntities) + ", mediaEntities=" + Arrays.toString(this.mediaEntities) + ", symbolEntities=" + Arrays.toString(this.symbolEntities) + ", currentUserRetweetId=" + this.currentUserRetweetId + ", user=" + this.user + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/StatusJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */