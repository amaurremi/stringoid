package twitter4j.internal.json;

import java.io.Serializable;
import java.util.Map;

import twitter4j.AccountSettings;
import twitter4j.AccountTotals;
import twitter4j.Category;
import twitter4j.DirectMessage;
import twitter4j.Friendship;
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
import twitter4j.User;
import twitter4j.UserList;
import twitter4j.api.HelpResources.Language;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONObject;

public abstract interface z_T4JInternalFactory
        extends Serializable {
    public abstract UserList createAUserList(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract UserList createAUserList(JSONObject paramJSONObject)
            throws TwitterException;

    public abstract AccountSettings createAccountSettings(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract AccountTotals createAccountTotals(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract ResponseList<Category> createCategoryList(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract DirectMessage createDirectMessage(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract DirectMessage createDirectMessage(JSONObject paramJSONObject)
            throws TwitterException;

    public abstract ResponseList<DirectMessage> createDirectMessageList(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract <T> ResponseList<T> createEmptyResponseList();

    public abstract ResponseList<Friendship> createFriendshipList(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract IDs createIDs(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract ResponseList<HelpResources.Language> createLanguageList(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract ResponseList<Location> createLocationList(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract OEmbed createOEmbed(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract PagableResponseList<User> createPagableUserList(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract PagableResponseList<UserList> createPagableUserListList(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract Place createPlace(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract ResponseList<Place> createPlaceList(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract QueryResult createQueryResult(HttpResponse paramHttpResponse, Query paramQuery)
            throws TwitterException;

    public abstract Map<String, RateLimitStatus> createRateLimitStatuses(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract Relationship createRelationship(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract SavedSearch createSavedSearch(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract ResponseList<SavedSearch> createSavedSearchList(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract SimilarPlaces createSimilarPlaces(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract Status createStatus(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract Status createStatus(JSONObject paramJSONObject)
            throws TwitterException;

    public abstract ResponseList<Status> createStatusList(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract Trends createTrends(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract TwitterAPIConfiguration createTwitterAPIConfiguration(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract User createUser(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract User createUser(JSONObject paramJSONObject)
            throws TwitterException;

    public abstract ResponseList<User> createUserList(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract ResponseList<User> createUserListFromJSONArray(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract ResponseList<User> createUserListFromJSONArray_Users(HttpResponse paramHttpResponse)
            throws TwitterException;

    public abstract ResponseList<UserList> createUserListList(HttpResponse paramHttpResponse)
            throws TwitterException;
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/json/z_T4JInternalFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */