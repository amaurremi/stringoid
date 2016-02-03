package twitter4j;

import java.util.Map;

import twitter4j.api.HelpResources.Language;
import twitter4j.conf.Configuration;

class JSONImplFactory
        implements ObjectFactory {
    private static final long serialVersionUID = -1853541456182663343L;
    private final Configuration conf;

    public JSONImplFactory(Configuration paramConfiguration) {
        this.conf = paramConfiguration;
    }

    static GeoLocation[][] coordinatesAsGeoLocationArray(JSONArray paramJSONArray) {
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

    static GeoLocation createGeoLocation(JSONObject paramJSONObject) {
        try {
            if (!paramJSONObject.isNull("coordinates")) {
                paramJSONObject = paramJSONObject.getJSONObject("coordinates").getString("coordinates");
                paramJSONObject = paramJSONObject.substring(1, paramJSONObject.length() - 1).split(",");
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

    public UserList createAUserList(HttpResponse paramHttpResponse) {
        return new UserListJSONImpl(paramHttpResponse, this.conf);
    }

    public UserList createAUserList(JSONObject paramJSONObject) {
        return new UserListJSONImpl(paramJSONObject);
    }

    public AccountSettings createAccountSettings(HttpResponse paramHttpResponse) {
        return new AccountSettingsJSONImpl(paramHttpResponse, this.conf);
    }

    public AccountTotals createAccountTotals(HttpResponse paramHttpResponse) {
        return new AccountTotalsJSONImpl(paramHttpResponse, this.conf);
    }

    public ResponseList<Category> createCategoryList(HttpResponse paramHttpResponse) {
        return CategoryJSONImpl.createCategoriesList(paramHttpResponse, this.conf);
    }

    public DirectMessage createDirectMessage(HttpResponse paramHttpResponse) {
        return new DirectMessageJSONImpl(paramHttpResponse, this.conf);
    }

    public ResponseList<DirectMessage> createDirectMessageList(HttpResponse paramHttpResponse) {
        return DirectMessageJSONImpl.createDirectMessageList(paramHttpResponse, this.conf);
    }

    public <T> ResponseList<T> createEmptyResponseList() {
        return new ResponseListImpl(0, null);
    }

    public ResponseList<Friendship> createFriendshipList(HttpResponse paramHttpResponse) {
        return FriendshipJSONImpl.createFriendshipList(paramHttpResponse, this.conf);
    }

    public IDs createIDs(HttpResponse paramHttpResponse) {
        return new IDsJSONImpl(paramHttpResponse, this.conf);
    }

    public ResponseList<HelpResources.Language> createLanguageList(HttpResponse paramHttpResponse) {
        return LanguageJSONImpl.createLanguageList(paramHttpResponse, this.conf);
    }

    public ResponseList<Location> createLocationList(HttpResponse paramHttpResponse) {
        return LocationJSONImpl.createLocationList(paramHttpResponse, this.conf);
    }

    public OEmbed createOEmbed(HttpResponse paramHttpResponse) {
        return new OEmbedJSONImpl(paramHttpResponse, this.conf);
    }

    public PagableResponseList<User> createPagableUserList(HttpResponse paramHttpResponse) {
        return UserJSONImpl.createPagableUserList(paramHttpResponse, this.conf);
    }

    public PagableResponseList<UserList> createPagableUserListList(HttpResponse paramHttpResponse) {
        return UserListJSONImpl.createPagableUserListList(paramHttpResponse, this.conf);
    }

    public Place createPlace(HttpResponse paramHttpResponse) {
        return new PlaceJSONImpl(paramHttpResponse, this.conf);
    }

    public ResponseList<Place> createPlaceList(HttpResponse paramHttpResponse) {
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

    public QueryResult createQueryResult(HttpResponse paramHttpResponse, Query paramQuery) {
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

    public Map<String, RateLimitStatus> createRateLimitStatuses(HttpResponse paramHttpResponse) {
        return RateLimitStatusJSONImpl.createRateLimitStatuses(paramHttpResponse, this.conf);
    }

    public Relationship createRelationship(HttpResponse paramHttpResponse) {
        return new RelationshipJSONImpl(paramHttpResponse, this.conf);
    }

    public SavedSearch createSavedSearch(HttpResponse paramHttpResponse) {
        return new SavedSearchJSONImpl(paramHttpResponse, this.conf);
    }

    public ResponseList<SavedSearch> createSavedSearchList(HttpResponse paramHttpResponse) {
        return SavedSearchJSONImpl.createSavedSearchList(paramHttpResponse, this.conf);
    }

    public Status createStatus(HttpResponse paramHttpResponse) {
        return new StatusJSONImpl(paramHttpResponse, this.conf);
    }

    public Status createStatus(JSONObject paramJSONObject) {
        return new StatusJSONImpl(paramJSONObject);
    }

    public ResponseList<Status> createStatusList(HttpResponse paramHttpResponse) {
        return StatusJSONImpl.createStatusList(paramHttpResponse, this.conf);
    }

    public Trends createTrends(HttpResponse paramHttpResponse) {
        return new TrendsJSONImpl(paramHttpResponse, this.conf);
    }

    public TwitterAPIConfiguration createTwitterAPIConfiguration(HttpResponse paramHttpResponse) {
        return new TwitterAPIConfigurationJSONImpl(paramHttpResponse, this.conf);
    }

    public User createUser(HttpResponse paramHttpResponse) {
        return new UserJSONImpl(paramHttpResponse, this.conf);
    }

    public User createUser(JSONObject paramJSONObject) {
        return new UserJSONImpl(paramJSONObject);
    }

    public ResponseList<User> createUserList(HttpResponse paramHttpResponse) {
        return UserJSONImpl.createUserList(paramHttpResponse, this.conf);
    }

    public ResponseList<User> createUserListFromJSONArray(HttpResponse paramHttpResponse) {
        return UserJSONImpl.createUserList(paramHttpResponse.asJSONArray(), paramHttpResponse, this.conf);
    }

    public ResponseList<User> createUserListFromJSONArray_Users(HttpResponse paramHttpResponse) {
        try {
            paramHttpResponse = UserJSONImpl.createUserList(paramHttpResponse.asJSONObject().getJSONArray("users"), paramHttpResponse, this.conf);
            return paramHttpResponse;
        } catch (JSONException paramHttpResponse) {
            throw new TwitterException(paramHttpResponse);
        }
    }

    public ResponseList<UserList> createUserListList(HttpResponse paramHttpResponse) {
        return UserListJSONImpl.createUserListList(paramHttpResponse, this.conf);
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof JSONImplFactory)) {
                return false;
            }
            paramObject = (JSONImplFactory) paramObject;
            if (this.conf == null) {
                break;
            }
        } while (this.conf.equals(((JSONImplFactory) paramObject).conf));
        for (; ; ) {
            return false;
            if (((JSONImplFactory) paramObject).conf == null) {
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/JSONImplFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */