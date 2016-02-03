package twitter4j.internal.json;

import java.io.Serializable;
import java.util.Map;
import twitter4j.AccountSettings;
import twitter4j.AccountTotals;
import twitter4j.DirectMessage;
import twitter4j.IDs;
import twitter4j.OEmbed;
import twitter4j.PagableResponseList;
import twitter4j.Place;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Relationship;
import twitter4j.ResponseList;
import twitter4j.SavedSearch;
import twitter4j.SimilarPlaces;
import twitter4j.Status;
import twitter4j.Trends;
import twitter4j.TwitterAPIConfiguration;
import twitter4j.User;
import twitter4j.UserList;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONObject;

public abstract interface z_T4JInternalFactory
  extends Serializable
{
  public abstract UserList createAUserList(HttpResponse paramHttpResponse);
  
  public abstract UserList createAUserList(JSONObject paramJSONObject);
  
  public abstract AccountSettings createAccountSettings(HttpResponse paramHttpResponse);
  
  public abstract AccountTotals createAccountTotals(HttpResponse paramHttpResponse);
  
  public abstract ResponseList createCategoryList(HttpResponse paramHttpResponse);
  
  public abstract DirectMessage createDirectMessage(HttpResponse paramHttpResponse);
  
  public abstract DirectMessage createDirectMessage(JSONObject paramJSONObject);
  
  public abstract ResponseList createDirectMessageList(HttpResponse paramHttpResponse);
  
  public abstract ResponseList createEmptyResponseList();
  
  public abstract ResponseList createFriendshipList(HttpResponse paramHttpResponse);
  
  public abstract IDs createIDs(HttpResponse paramHttpResponse);
  
  public abstract ResponseList createLanguageList(HttpResponse paramHttpResponse);
  
  public abstract ResponseList createLocationList(HttpResponse paramHttpResponse);
  
  public abstract OEmbed createOEmbed(HttpResponse paramHttpResponse);
  
  public abstract PagableResponseList createPagableUserList(HttpResponse paramHttpResponse);
  
  public abstract PagableResponseList createPagableUserListList(HttpResponse paramHttpResponse);
  
  public abstract Place createPlace(HttpResponse paramHttpResponse);
  
  public abstract ResponseList createPlaceList(HttpResponse paramHttpResponse);
  
  public abstract QueryResult createQueryResult(HttpResponse paramHttpResponse, Query paramQuery);
  
  public abstract Map createRateLimitStatuses(HttpResponse paramHttpResponse);
  
  public abstract Relationship createRelationship(HttpResponse paramHttpResponse);
  
  public abstract SavedSearch createSavedSearch(HttpResponse paramHttpResponse);
  
  public abstract ResponseList createSavedSearchList(HttpResponse paramHttpResponse);
  
  public abstract SimilarPlaces createSimilarPlaces(HttpResponse paramHttpResponse);
  
  public abstract Status createStatus(HttpResponse paramHttpResponse);
  
  public abstract Status createStatus(JSONObject paramJSONObject);
  
  public abstract ResponseList createStatusList(HttpResponse paramHttpResponse);
  
  public abstract Trends createTrends(HttpResponse paramHttpResponse);
  
  public abstract TwitterAPIConfiguration createTwitterAPIConfiguration(HttpResponse paramHttpResponse);
  
  public abstract User createUser(HttpResponse paramHttpResponse);
  
  public abstract User createUser(JSONObject paramJSONObject);
  
  public abstract ResponseList createUserList(HttpResponse paramHttpResponse);
  
  public abstract ResponseList createUserListFromJSONArray(HttpResponse paramHttpResponse);
  
  public abstract ResponseList createUserListFromJSONArray_Users(HttpResponse paramHttpResponse);
  
  public abstract ResponseList createUserListList(HttpResponse paramHttpResponse);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/json/z_T4JInternalFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */