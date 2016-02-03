package twitter4j;

import java.io.Serializable;
import java.util.Map;

import twitter4j.api.HelpResources.Language;

abstract interface ObjectFactory
        extends Serializable {
    public abstract UserList createAUserList(HttpResponse paramHttpResponse);

    public abstract UserList createAUserList(JSONObject paramJSONObject);

    public abstract AccountSettings createAccountSettings(HttpResponse paramHttpResponse);

    public abstract AccountTotals createAccountTotals(HttpResponse paramHttpResponse);

    public abstract ResponseList<Category> createCategoryList(HttpResponse paramHttpResponse);

    public abstract DirectMessage createDirectMessage(HttpResponse paramHttpResponse);

    public abstract ResponseList<DirectMessage> createDirectMessageList(HttpResponse paramHttpResponse);

    public abstract <T> ResponseList<T> createEmptyResponseList();

    public abstract ResponseList<Friendship> createFriendshipList(HttpResponse paramHttpResponse);

    public abstract IDs createIDs(HttpResponse paramHttpResponse);

    public abstract ResponseList<HelpResources.Language> createLanguageList(HttpResponse paramHttpResponse);

    public abstract ResponseList<Location> createLocationList(HttpResponse paramHttpResponse);

    public abstract OEmbed createOEmbed(HttpResponse paramHttpResponse);

    public abstract PagableResponseList<User> createPagableUserList(HttpResponse paramHttpResponse);

    public abstract PagableResponseList<UserList> createPagableUserListList(HttpResponse paramHttpResponse);

    public abstract Place createPlace(HttpResponse paramHttpResponse);

    public abstract ResponseList<Place> createPlaceList(HttpResponse paramHttpResponse);

    public abstract QueryResult createQueryResult(HttpResponse paramHttpResponse, Query paramQuery);

    public abstract Map<String, RateLimitStatus> createRateLimitStatuses(HttpResponse paramHttpResponse);

    public abstract Relationship createRelationship(HttpResponse paramHttpResponse);

    public abstract SavedSearch createSavedSearch(HttpResponse paramHttpResponse);

    public abstract ResponseList<SavedSearch> createSavedSearchList(HttpResponse paramHttpResponse);

    public abstract Status createStatus(HttpResponse paramHttpResponse);

    public abstract Status createStatus(JSONObject paramJSONObject);

    public abstract ResponseList<Status> createStatusList(HttpResponse paramHttpResponse);

    public abstract Trends createTrends(HttpResponse paramHttpResponse);

    public abstract TwitterAPIConfiguration createTwitterAPIConfiguration(HttpResponse paramHttpResponse);

    public abstract User createUser(HttpResponse paramHttpResponse);

    public abstract User createUser(JSONObject paramJSONObject);

    public abstract ResponseList<User> createUserList(HttpResponse paramHttpResponse);

    public abstract ResponseList<User> createUserListFromJSONArray(HttpResponse paramHttpResponse);

    public abstract ResponseList<User> createUserListFromJSONArray_Users(HttpResponse paramHttpResponse);

    public abstract ResponseList<UserList> createUserListList(HttpResponse paramHttpResponse);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/ObjectFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */