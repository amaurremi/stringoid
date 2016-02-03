package twitter4j.internal.json;

import java.util.Map;

import twitter4j.AccountSettings;
import twitter4j.AccountTotals;
import twitter4j.Category;
import twitter4j.DirectMessage;
import twitter4j.Friendship;
import twitter4j.GeoLocation;
import twitter4j.HashtagEntity;
import twitter4j.IDs;
import twitter4j.Location;
import twitter4j.OEmbed;
import twitter4j.PagableResponseList;
import twitter4j.Place;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.RateLimitStatus;
import twitter4j.Relationship;
import twitter4j.ResponseList;
import twitter4j.SavedSearch;
import twitter4j.SimilarPlaces;
import twitter4j.Status;
import twitter4j.Trends;
import twitter4j.TwitterAPIConfiguration;
import twitter4j.TwitterException;
import twitter4j.URLEntity;
import twitter4j.User;
import twitter4j.UserList;
import twitter4j.UserMentionEntity;
import twitter4j.api.HelpResources.Language;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;
import twitter4j.internal.util.z_T4JInternalStringUtil;

public class z_T4JInternalJSONImplFactory
        implements z_T4JInternalFactory {
    private static final long serialVersionUID = 5217622295050444866L;
    private Configuration conf;

    public z_T4JInternalJSONImplFactory(Configuration paramConfiguration) {
        this.conf = paramConfiguration;
    }

    static GeoLocation[][] coordinatesAsGeoLocationArray(JSONArray paramJSONArray)
            throws TwitterException {
        try {
            GeoLocation[][] arrayOfGeoLocation = new GeoLocation[paramJSONArray.length()][];
            int i = 0;
            while (i < paramJSONArray.length()) {
                JSONArray localJSONArray1 = paramJSONArray.getJSONArray(i);
                arrayOfGeoLocation[i] = new GeoLocation[localJSONArray1.length()];
                int j = 0;
                while (j < localJSONArray1.length()) {
                    JSONArray localJSONArray2 = localJSONArray1.getJSONArray(j);
                    arrayOfGeoLocation[i][j] = new GeoLocation(localJSONArray2.getDouble(1), localJSONArray2.getDouble(0));
                    j += 1;
                }
                i += 1;
            }
            return arrayOfGeoLocation;
        } catch (JSONException paramJSONArray) {
            throw new TwitterException(paramJSONArray);
        }
    }

    static GeoLocation createGeoLocation(JSONObject paramJSONObject)
            throws TwitterException {
        try {
            if (!paramJSONObject.isNull("coordinates")) {
                paramJSONObject = paramJSONObject.getJSONObject("coordinates").getString("coordinates");
                paramJSONObject = z_T4JInternalStringUtil.split(paramJSONObject.substring(1, paramJSONObject.length() - 1), ",");
                paramJSONObject = new GeoLocation(Double.parseDouble(paramJSONObject[1]), Double.parseDouble(paramJSONObject[0]));
                return paramJSONObject;
            }
        } catch (JSONException paramJSONObject) {
            throw new TwitterException(paramJSONObject);
        }
        return null;
    }

    public static HashtagEntity createHashtagEntity(int paramInt1, int paramInt2, String paramString) {
        return new HashtagEntityJSONImpl(paramInt1, paramInt2, paramString);
    }

    public static RateLimitStatus createRateLimitStatusFromResponseHeader(HttpResponse paramHttpResponse) {
        return RateLimitStatusJSONImpl.createFromResponseHeader(paramHttpResponse);
    }

    public static URLEntity createUrlEntity(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3) {
        return new URLEntityJSONImpl(paramInt1, paramInt2, paramString1, paramString2, paramString3);
    }

    public static UserMentionEntity createUserMentionEntity(int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong) {
        return new UserMentionEntityJSONImpl(paramInt1, paramInt2, paramString1, paramString2, paramLong);
    }

    public UserList createAUserList(HttpResponse paramHttpResponse)
            throws TwitterException {
        return new UserListJSONImpl(paramHttpResponse, this.conf);
    }

    public UserList createAUserList(JSONObject paramJSONObject)
            throws TwitterException {
        return new UserListJSONImpl(paramJSONObject);
    }

    public AccountSettings createAccountSettings(HttpResponse paramHttpResponse)
            throws TwitterException {
        return new AccountSettingsJSONImpl(paramHttpResponse, this.conf);
    }

    public AccountTotals createAccountTotals(HttpResponse paramHttpResponse)
            throws TwitterException {
        return new AccountTotalsJSONImpl(paramHttpResponse, this.conf);
    }

    public ResponseList<Category> createCategoryList(HttpResponse paramHttpResponse)
            throws TwitterException {
        return CategoryJSONImpl.createCategoriesList(paramHttpResponse, this.conf);
    }

    public DirectMessage createDirectMessage(HttpResponse paramHttpResponse)
            throws TwitterException {
        return new DirectMessageJSONImpl(paramHttpResponse, this.conf);
    }

    public DirectMessage createDirectMessage(JSONObject paramJSONObject)
            throws TwitterException {
        return new DirectMessageJSONImpl(paramJSONObject);
    }

    public ResponseList<DirectMessage> createDirectMessageList(HttpResponse paramHttpResponse)
            throws TwitterException {
        return DirectMessageJSONImpl.createDirectMessageList(paramHttpResponse, this.conf);
    }

    public <T> ResponseList<T> createEmptyResponseList() {
        return new ResponseListImpl(0, null);
    }

    public ResponseList<Friendship> createFriendshipList(HttpResponse paramHttpResponse)
            throws TwitterException {
        return FriendshipJSONImpl.createFriendshipList(paramHttpResponse, this.conf);
    }

    public IDs createIDs(HttpResponse paramHttpResponse)
            throws TwitterException {
        return new IDsJSONImpl(paramHttpResponse, this.conf);
    }

    public ResponseList<HelpResources.Language> createLanguageList(HttpResponse paramHttpResponse)
            throws TwitterException {
        return LanguageJSONImpl.createLanguageList(paramHttpResponse, this.conf);
    }

    public ResponseList<Location> createLocationList(HttpResponse paramHttpResponse)
            throws TwitterException {
        return LocationJSONImpl.createLocationList(paramHttpResponse, this.conf);
    }

    public OEmbed createOEmbed(HttpResponse paramHttpResponse)
            throws TwitterException {
        return new OEmbedJSONImpl(paramHttpResponse, this.conf);
    }

    public PagableResponseList<User> createPagableUserList(HttpResponse paramHttpResponse)
            throws TwitterException {
        return UserJSONImpl.createPagableUserList(paramHttpResponse, this.conf);
    }

    public PagableResponseList<UserList> createPagableUserListList(HttpResponse paramHttpResponse)
            throws TwitterException {
        return UserListJSONImpl.createPagableUserListList(paramHttpResponse, this.conf);
    }

    public Place createPlace(HttpResponse paramHttpResponse)
            throws TwitterException {
        return new PlaceJSONImpl(paramHttpResponse, this.conf);
    }

    public ResponseList<Place> createPlaceList(HttpResponse paramHttpResponse)
            throws TwitterException {
        try {
            paramHttpResponse = PlaceJSONImpl.createPlaceList(paramHttpResponse, this.conf);
            return paramHttpResponse;
        } catch (TwitterException paramHttpResponse) {
            if (paramHttpResponse.getStatusCode() == 404) {
                return new ResponseListImpl(0, null);
            }
            throw paramHttpResponse;
        }
    }

    public QueryResult createQueryResult(HttpResponse paramHttpResponse, Query paramQuery)
            throws TwitterException {
        try {
            paramHttpResponse = new QueryResultJSONImpl(paramHttpResponse, this.conf);
            return paramHttpResponse;
        } catch (TwitterException paramHttpResponse) {
            if (404 == paramHttpResponse.getStatusCode()) {
                return new QueryResultJSONImpl(paramQuery);
            }
            throw paramHttpResponse;
        }
    }

    public Map<String, RateLimitStatus> createRateLimitStatuses(HttpResponse paramHttpResponse)
            throws TwitterException {
        return RateLimitStatusJSONImpl.createRateLimitStatuses(paramHttpResponse, this.conf);
    }

    public Relationship createRelationship(HttpResponse paramHttpResponse)
            throws TwitterException {
        return new RelationshipJSONImpl(paramHttpResponse, this.conf);
    }

    public SavedSearch createSavedSearch(HttpResponse paramHttpResponse)
            throws TwitterException {
        return new SavedSearchJSONImpl(paramHttpResponse, this.conf);
    }

    public ResponseList<SavedSearch> createSavedSearchList(HttpResponse paramHttpResponse)
            throws TwitterException {
        return SavedSearchJSONImpl.createSavedSearchList(paramHttpResponse, this.conf);
    }

    public SimilarPlaces createSimilarPlaces(HttpResponse paramHttpResponse)
            throws TwitterException {
        return SimilarPlacesImpl.createSimilarPlaces(paramHttpResponse, this.conf);
    }

    public Status createStatus(HttpResponse paramHttpResponse)
            throws TwitterException {
        return new StatusJSONImpl(paramHttpResponse, this.conf);
    }

    public Status createStatus(JSONObject paramJSONObject)
            throws TwitterException {
        return new StatusJSONImpl(paramJSONObject);
    }

    public ResponseList<Status> createStatusList(HttpResponse paramHttpResponse)
            throws TwitterException {
        return StatusJSONImpl.createStatusList(paramHttpResponse, this.conf);
    }

    public Trends createTrends(HttpResponse paramHttpResponse)
            throws TwitterException {
        return new TrendsJSONImpl(paramHttpResponse, this.conf);
    }

    public TwitterAPIConfiguration createTwitterAPIConfiguration(HttpResponse paramHttpResponse)
            throws TwitterException {
        return new TwitterAPIConfigurationJSONImpl(paramHttpResponse, this.conf);
    }

    public User createUser(HttpResponse paramHttpResponse)
            throws TwitterException {
        return new UserJSONImpl(paramHttpResponse, this.conf);
    }

    public User createUser(JSONObject paramJSONObject)
            throws TwitterException {
        return new UserJSONImpl(paramJSONObject);
    }

    public ResponseList<User> createUserList(HttpResponse paramHttpResponse)
            throws TwitterException {
        return UserJSONImpl.createUserList(paramHttpResponse, this.conf);
    }

    public ResponseList<User> createUserListFromJSONArray(HttpResponse paramHttpResponse)
            throws TwitterException {
        return UserJSONImpl.createUserList(paramHttpResponse.asJSONArray(), paramHttpResponse, this.conf);
    }

    public ResponseList<User> createUserListFromJSONArray_Users(HttpResponse paramHttpResponse)
            throws TwitterException {
        try {
            paramHttpResponse = UserJSONImpl.createUserList(paramHttpResponse.asJSONObject().getJSONArray("users"), paramHttpResponse, this.conf);
            return paramHttpResponse;
        } catch (JSONException paramHttpResponse) {
            throw new TwitterException(paramHttpResponse);
        }
    }

    public ResponseList<UserList> createUserListList(HttpResponse paramHttpResponse)
            throws TwitterException {
        return UserListJSONImpl.createUserListList(paramHttpResponse, this.conf);
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof z_T4JInternalJSONImplFactory)) {
                return false;
            }
            paramObject = (z_T4JInternalJSONImplFactory) paramObject;
            if (this.conf == null) {
                break;
            }
        } while (this.conf.equals(((z_T4JInternalJSONImplFactory) paramObject).conf));
        for (; ; ) {
            return false;
            if (((z_T4JInternalJSONImplFactory) paramObject).conf == null) {
                break;
            }
        }
    }

    public int hashCode() {
        if (this.conf != null) {
            return this.conf.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "JSONImplFactory{conf=" + this.conf + '}';
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/json/z_T4JInternalJSONImplFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */