package twitter4j.internal.json;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import twitter4j.PagableResponseList;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.URLEntity;
import twitter4j.User;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

final class UserJSONImpl
        extends TwitterResponseImpl
        implements User, Serializable {
    private static final long serialVersionUID = -6345893237975349030L;
    private Date createdAt;
    private String description;
    private URLEntity[] descriptionURLEntities;
    private int favouritesCount;
    private int followersCount;
    private int friendsCount;
    private long id;
    private boolean isContributorsEnabled;
    private boolean isFollowRequestSent;
    private boolean isGeoEnabled;
    private boolean isProtected;
    private boolean isVerified;
    private String lang;
    private int listedCount;
    private String location;
    private String name;
    private String profileBackgroundColor;
    private String profileBackgroundImageUrl;
    private String profileBackgroundImageUrlHttps;
    private boolean profileBackgroundTiled;
    private String profileBannerImageUrl;
    private String profileImageUrl;
    private String profileImageUrlHttps;
    private String profileLinkColor;
    private String profileSidebarBorderColor;
    private String profileSidebarFillColor;
    private String profileTextColor;
    private boolean profileUseBackgroundImage;
    private String screenName;
    private boolean showAllInlineMedia;
    private Status status;
    private int statusesCount;
    private String timeZone;
    private boolean translator;
    private String url;
    private URLEntity urlEntity;
    private int utcOffset;

    UserJSONImpl() {
    }

    UserJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration)
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

    UserJSONImpl(JSONObject paramJSONObject)
            throws TwitterException {
        init(paramJSONObject);
    }

    static PagableResponseList<User> createPagableUserList(HttpResponse paramHttpResponse, Configuration paramConfiguration)
            throws TwitterException {
        try {
            if (paramConfiguration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.clearThreadLocalMap();
            }
            JSONObject localJSONObject1 = paramHttpResponse.asJSONObject();
            JSONArray localJSONArray = localJSONObject1.getJSONArray("users");
            int j = localJSONArray.length();
            paramHttpResponse = new PagableResponseListImpl(j, localJSONObject1, paramHttpResponse);
            int i = 0;
            while (i < j) {
                JSONObject localJSONObject2 = localJSONArray.getJSONObject(i);
                UserJSONImpl localUserJSONImpl = new UserJSONImpl(localJSONObject2);
                if (paramConfiguration.isJSONStoreEnabled()) {
                    DataObjectFactoryUtil.registerJSONObject(localUserJSONImpl, localJSONObject2);
                }
                paramHttpResponse.add(localUserJSONImpl);
                i += 1;
            }
            if (paramConfiguration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.registerJSONObject(paramHttpResponse, localJSONObject1);
            }
            return paramHttpResponse;
        } catch (JSONException paramHttpResponse) {
            throw new TwitterException(paramHttpResponse);
        } catch (TwitterException paramHttpResponse) {
            throw paramHttpResponse;
        }
    }

    static ResponseList<User> createUserList(HttpResponse paramHttpResponse, Configuration paramConfiguration)
            throws TwitterException {
        return createUserList(paramHttpResponse.asJSONArray(), paramHttpResponse, paramConfiguration);
    }

    static ResponseList<User> createUserList(JSONArray paramJSONArray, HttpResponse paramHttpResponse, Configuration paramConfiguration)
            throws TwitterException {
        for (; ; ) {
            int i;
            try {
                if (paramConfiguration.isJSONStoreEnabled()) {
                    DataObjectFactoryUtil.clearThreadLocalMap();
                }
                int j = paramJSONArray.length();
                paramHttpResponse = new ResponseListImpl(j, paramHttpResponse);
                i = 0;
                if (i < j) {
                    JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
                    UserJSONImpl localUserJSONImpl = new UserJSONImpl(localJSONObject);
                    paramHttpResponse.add(localUserJSONImpl);
                    if (paramConfiguration.isJSONStoreEnabled()) {
                        DataObjectFactoryUtil.registerJSONObject(localUserJSONImpl, localJSONObject);
                    }
                } else {
                    if (paramConfiguration.isJSONStoreEnabled()) {
                        DataObjectFactoryUtil.registerJSONObject(paramHttpResponse, paramJSONArray);
                    }
                    return paramHttpResponse;
                }
            } catch (JSONException paramJSONArray) {
                throw new TwitterException(paramJSONArray);
            } catch (TwitterException paramJSONArray) {
                throw paramJSONArray;
            }
            i += 1;
        }
    }

    private static URLEntity[] getURLEntitiesFromJSON(JSONObject paramJSONObject, String paramString)
            throws JSONException, TwitterException {
        if (!paramJSONObject.isNull("entities")) {
            paramJSONObject = paramJSONObject.getJSONObject("entities");
            if (!paramJSONObject.isNull(paramString)) {
                paramJSONObject = paramJSONObject.getJSONObject(paramString);
                if (!paramJSONObject.isNull("urls")) {
                    JSONArray localJSONArray = paramJSONObject.getJSONArray("urls");
                    int j = localJSONArray.length();
                    paramString = new URLEntity[j];
                    int i = 0;
                    for (; ; ) {
                        paramJSONObject = paramString;
                        if (i >= j) {
                            break;
                        }
                        paramString[i] = new URLEntityJSONImpl(localJSONArray.getJSONObject(i));
                        i += 1;
                    }
                }
            }
        }
        paramJSONObject = null;
        return paramJSONObject;
    }

    private void init(JSONObject paramJSONObject)
            throws TwitterException {
        try {
            this.id = z_T4JInternalParseUtil.getLong("id", paramJSONObject);
            this.name = z_T4JInternalParseUtil.getRawString("name", paramJSONObject);
            this.screenName = z_T4JInternalParseUtil.getRawString("screen_name", paramJSONObject);
            this.location = z_T4JInternalParseUtil.getRawString("location", paramJSONObject);
            this.descriptionURLEntities = getURLEntitiesFromJSON(paramJSONObject, "description");
            if (this.descriptionURLEntities == null) {
            }
            for (URLEntity[] arrayOfURLEntity = new URLEntity[0]; ; arrayOfURLEntity = this.descriptionURLEntities) {
                this.descriptionURLEntities = arrayOfURLEntity;
                arrayOfURLEntity = getURLEntitiesFromJSON(paramJSONObject, "url");
                if ((arrayOfURLEntity != null) && (arrayOfURLEntity.length > 0)) {
                    this.urlEntity = arrayOfURLEntity[0];
                }
                this.description = z_T4JInternalParseUtil.getRawString("description", paramJSONObject);
                if (this.description != null) {
                    this.description = HTMLEntity.unescapeAndSlideEntityIncdices(this.description, null, this.descriptionURLEntities, null, null);
                }
                this.isContributorsEnabled = z_T4JInternalParseUtil.getBoolean("contributors_enabled", paramJSONObject);
                this.profileImageUrl = z_T4JInternalParseUtil.getRawString("profile_image_url", paramJSONObject);
                this.profileImageUrlHttps = z_T4JInternalParseUtil.getRawString("profile_image_url_https", paramJSONObject);
                this.url = z_T4JInternalParseUtil.getRawString("url", paramJSONObject);
                this.isProtected = z_T4JInternalParseUtil.getBoolean("protected", paramJSONObject);
                this.isGeoEnabled = z_T4JInternalParseUtil.getBoolean("geo_enabled", paramJSONObject);
                this.isVerified = z_T4JInternalParseUtil.getBoolean("verified", paramJSONObject);
                this.translator = z_T4JInternalParseUtil.getBoolean("is_translator", paramJSONObject);
                this.followersCount = z_T4JInternalParseUtil.getInt("followers_count", paramJSONObject);
                this.profileBackgroundColor = z_T4JInternalParseUtil.getRawString("profile_background_color", paramJSONObject);
                this.profileTextColor = z_T4JInternalParseUtil.getRawString("profile_text_color", paramJSONObject);
                this.profileLinkColor = z_T4JInternalParseUtil.getRawString("profile_link_color", paramJSONObject);
                this.profileSidebarFillColor = z_T4JInternalParseUtil.getRawString("profile_sidebar_fill_color", paramJSONObject);
                this.profileSidebarBorderColor = z_T4JInternalParseUtil.getRawString("profile_sidebar_border_color", paramJSONObject);
                this.profileUseBackgroundImage = z_T4JInternalParseUtil.getBoolean("profile_use_background_image", paramJSONObject);
                this.showAllInlineMedia = z_T4JInternalParseUtil.getBoolean("show_all_inline_media", paramJSONObject);
                this.friendsCount = z_T4JInternalParseUtil.getInt("friends_count", paramJSONObject);
                this.createdAt = z_T4JInternalParseUtil.getDate("created_at", paramJSONObject, "EEE MMM dd HH:mm:ss z yyyy");
                this.favouritesCount = z_T4JInternalParseUtil.getInt("favourites_count", paramJSONObject);
                this.utcOffset = z_T4JInternalParseUtil.getInt("utc_offset", paramJSONObject);
                this.timeZone = z_T4JInternalParseUtil.getRawString("time_zone", paramJSONObject);
                this.profileBackgroundImageUrl = z_T4JInternalParseUtil.getRawString("profile_background_image_url", paramJSONObject);
                this.profileBackgroundImageUrlHttps = z_T4JInternalParseUtil.getRawString("profile_background_image_url_https", paramJSONObject);
                this.profileBannerImageUrl = z_T4JInternalParseUtil.getRawString("profile_banner_url", paramJSONObject);
                this.profileBackgroundTiled = z_T4JInternalParseUtil.getBoolean("profile_background_tile", paramJSONObject);
                this.lang = z_T4JInternalParseUtil.getRawString("lang", paramJSONObject);
                this.statusesCount = z_T4JInternalParseUtil.getInt("statuses_count", paramJSONObject);
                this.listedCount = z_T4JInternalParseUtil.getInt("listed_count", paramJSONObject);
                this.isFollowRequestSent = z_T4JInternalParseUtil.getBoolean("follow_request_sent", paramJSONObject);
                if (paramJSONObject.isNull("status")) {
                    break;
                }
                this.status = new StatusJSONImpl(paramJSONObject.getJSONObject("status"));
                return;
            }
            return;
        } catch (JSONException localJSONException) {
            throw new TwitterException(localJSONException.getMessage() + ":" + paramJSONObject.toString(), localJSONException);
        }
    }

    private String toResizedURL(String paramString1, String paramString2) {
        if (paramString1 != null) {
            int i = paramString1.lastIndexOf("_");
            int j = paramString1.lastIndexOf(".");
            int k = paramString1.lastIndexOf("/");
            String str = paramString1.substring(0, i) + paramString2;
            paramString2 = str;
            if (j > k) {
                paramString2 = str + paramString1.substring(j);
            }
            return paramString2;
        }
        return null;
    }

    public int compareTo(User paramUser) {
        return (int) (this.id - paramUser.getId());
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
            if (!(paramObject instanceof User)) {
                break;
            }
            bool1 = bool2;
        } while (((User) paramObject).getId() == this.id);
        return false;
    }

    public String getBiggerProfileImageURL() {
        return toResizedURL(this.profileImageUrl, "_bigger");
    }

    public String getBiggerProfileImageURLHttps() {
        return toResizedURL(this.profileImageUrlHttps, "_bigger");
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public String getDescription() {
        return this.description;
    }

    public URLEntity[] getDescriptionURLEntities() {
        return this.descriptionURLEntities;
    }

    public int getFavouritesCount() {
        return this.favouritesCount;
    }

    public int getFollowersCount() {
        return this.followersCount;
    }

    public int getFriendsCount() {
        return this.friendsCount;
    }

    public long getId() {
        return this.id;
    }

    public String getLang() {
        return this.lang;
    }

    public int getListedCount() {
        return this.listedCount;
    }

    public String getLocation() {
        return this.location;
    }

    public String getMiniProfileImageURL() {
        return toResizedURL(this.profileImageUrl, "_mini");
    }

    public String getMiniProfileImageURLHttps() {
        return toResizedURL(this.profileImageUrlHttps, "_mini");
    }

    public String getName() {
        return this.name;
    }

    public String getOriginalProfileImageURL() {
        return toResizedURL(this.profileImageUrl, "");
    }

    public String getOriginalProfileImageURLHttps() {
        return toResizedURL(this.profileImageUrlHttps, "");
    }

    public String getProfileBackgroundColor() {
        return this.profileBackgroundColor;
    }

    public String getProfileBackgroundImageURL() {
        return this.profileBackgroundImageUrl;
    }

    public String getProfileBackgroundImageUrl() {
        return getProfileBackgroundImageURL();
    }

    public String getProfileBackgroundImageUrlHttps() {
        return this.profileBackgroundImageUrlHttps;
    }

    public String getProfileBannerIPadRetinaURL() {
        if (this.profileBannerImageUrl != null) {
            return this.profileBannerImageUrl + "/ipad_retina";
        }
        return null;
    }

    public String getProfileBannerIPadURL() {
        if (this.profileBannerImageUrl != null) {
            return this.profileBannerImageUrl + "/ipad";
        }
        return null;
    }

    public String getProfileBannerMobileRetinaURL() {
        if (this.profileBannerImageUrl != null) {
            return this.profileBannerImageUrl + "/mobile_retina";
        }
        return null;
    }

    public String getProfileBannerMobileURL() {
        if (this.profileBannerImageUrl != null) {
            return this.profileBannerImageUrl + "/mobile";
        }
        return null;
    }

    public String getProfileBannerRetinaURL() {
        if (this.profileBannerImageUrl != null) {
            return this.profileBannerImageUrl + "/web_retina";
        }
        return null;
    }

    public String getProfileBannerURL() {
        if (this.profileBannerImageUrl != null) {
            return this.profileBannerImageUrl + "/web";
        }
        return null;
    }

    public String getProfileImageURL() {
        return this.profileImageUrl;
    }

    public String getProfileImageURLHttps() {
        return this.profileImageUrlHttps;
    }

    public URL getProfileImageUrlHttps() {
        try {
            URL localURL = new URL(this.profileImageUrlHttps);
            return localURL;
        } catch (MalformedURLException localMalformedURLException) {
        }
        return null;
    }

    public String getProfileLinkColor() {
        return this.profileLinkColor;
    }

    public String getProfileSidebarBorderColor() {
        return this.profileSidebarBorderColor;
    }

    public String getProfileSidebarFillColor() {
        return this.profileSidebarFillColor;
    }

    public String getProfileTextColor() {
        return this.profileTextColor;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public Status getStatus() {
        return this.status;
    }

    public int getStatusesCount() {
        return this.statusesCount;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public String getURL() {
        return this.url;
    }

    public URLEntity getURLEntity() {
        if (this.urlEntity == null) {
            if (this.url != null) {
                break label42;
            }
        }
        label42:
        for (String str = ""; ; str = this.url) {
            this.urlEntity = new URLEntityJSONImpl(0, str.length(), str, str, str);
            return this.urlEntity;
        }
    }

    public int getUtcOffset() {
        return this.utcOffset;
    }

    public int hashCode() {
        return (int) this.id;
    }

    public boolean isContributorsEnabled() {
        return this.isContributorsEnabled;
    }

    public boolean isFollowRequestSent() {
        return this.isFollowRequestSent;
    }

    public boolean isGeoEnabled() {
        return this.isGeoEnabled;
    }

    public boolean isProfileBackgroundTiled() {
        return this.profileBackgroundTiled;
    }

    public boolean isProfileUseBackgroundImage() {
        return this.profileUseBackgroundImage;
    }

    public boolean isProtected() {
        return this.isProtected;
    }

    public boolean isShowAllInlineMedia() {
        return this.showAllInlineMedia;
    }

    public boolean isTranslator() {
        return this.translator;
    }

    public boolean isVerified() {
        return this.isVerified;
    }

    public String toString() {
        return "UserJSONImpl{id=" + this.id + ", name='" + this.name + '\'' + ", screenName='" + this.screenName + '\'' + ", location='" + this.location + '\'' + ", description='" + this.description + '\'' + ", isContributorsEnabled=" + this.isContributorsEnabled + ", profileImageUrl='" + this.profileImageUrl + '\'' + ", profileImageUrlHttps='" + this.profileImageUrlHttps + '\'' + ", url='" + this.url + '\'' + ", isProtected=" + this.isProtected + ", followersCount=" + this.followersCount + ", status=" + this.status + ", profileBackgroundColor='" + this.profileBackgroundColor + '\'' + ", profileTextColor='" + this.profileTextColor + '\'' + ", profileLinkColor='" + this.profileLinkColor + '\'' + ", profileSidebarFillColor='" + this.profileSidebarFillColor + '\'' + ", profileSidebarBorderColor='" + this.profileSidebarBorderColor + '\'' + ", profileUseBackgroundImage=" + this.profileUseBackgroundImage + ", showAllInlineMedia=" + this.showAllInlineMedia + ", friendsCount=" + this.friendsCount + ", createdAt=" + this.createdAt + ", favouritesCount=" + this.favouritesCount + ", utcOffset=" + this.utcOffset + ", timeZone='" + this.timeZone + '\'' + ", profileBackgroundImageUrl='" + this.profileBackgroundImageUrl + '\'' + ", profileBackgroundImageUrlHttps='" + this.profileBackgroundImageUrlHttps + '\'' + ", profileBackgroundTiled=" + this.profileBackgroundTiled + ", lang='" + this.lang + '\'' + ", statusesCount=" + this.statusesCount + ", isGeoEnabled=" + this.isGeoEnabled + ", isVerified=" + this.isVerified + ", translator=" + this.translator + ", listedCount=" + this.listedCount + ", isFollowRequestSent=" + this.isFollowRequestSent + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/json/UserJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */