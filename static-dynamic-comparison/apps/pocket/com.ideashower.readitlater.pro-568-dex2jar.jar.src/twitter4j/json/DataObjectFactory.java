package twitter4j.json;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import twitter4j.AccountTotals;
import twitter4j.Category;
import twitter4j.DirectMessage;
import twitter4j.IDs;
import twitter4j.Location;
import twitter4j.OEmbed;
import twitter4j.Place;
import twitter4j.Relationship;
import twitter4j.SavedSearch;
import twitter4j.Status;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.UserList;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

public final class DataObjectFactory
{
  private static final Constructor IDsConstructor;
  private static final Constructor accountTotalsConstructor;
  private static final Constructor categoryConstructor;
  private static final Constructor directMessageConstructor;
  private static final Constructor locationConstructor;
  private static final Constructor oembedConstructor;
  private static final Constructor placeConstructor;
  private static final Method rateLimitStatusConstructor;
  private static final ThreadLocal rawJsonMap;
  private static final Constructor relationshipConstructor;
  private static final Constructor savedSearchConstructor;
  private static final Constructor statusConstructor;
  private static final Constructor statusDeletionNoticeConstructor;
  private static final Constructor trendConstructor;
  private static final Constructor trendsConstructor;
  private static final Constructor userConstructor;
  private static final Constructor userListConstructor;
  
  static
  {
    try
    {
      statusConstructor = Class.forName("twitter4j.internal.json.StatusJSONImpl").getDeclaredConstructor(new Class[] { JSONObject.class });
      statusConstructor.setAccessible(true);
      userConstructor = Class.forName("twitter4j.internal.json.UserJSONImpl").getDeclaredConstructor(new Class[] { JSONObject.class });
      userConstructor.setAccessible(true);
      relationshipConstructor = Class.forName("twitter4j.internal.json.RelationshipJSONImpl").getDeclaredConstructor(new Class[] { JSONObject.class });
      relationshipConstructor.setAccessible(true);
      placeConstructor = Class.forName("twitter4j.internal.json.PlaceJSONImpl").getDeclaredConstructor(new Class[] { JSONObject.class });
      placeConstructor.setAccessible(true);
      savedSearchConstructor = Class.forName("twitter4j.internal.json.SavedSearchJSONImpl").getDeclaredConstructor(new Class[] { JSONObject.class });
      savedSearchConstructor.setAccessible(true);
      trendConstructor = Class.forName("twitter4j.internal.json.TrendJSONImpl").getDeclaredConstructor(new Class[] { JSONObject.class });
      trendConstructor.setAccessible(true);
      trendsConstructor = Class.forName("twitter4j.internal.json.TrendsJSONImpl").getDeclaredConstructor(new Class[] { String.class });
      trendsConstructor.setAccessible(true);
      IDsConstructor = Class.forName("twitter4j.internal.json.IDsJSONImpl").getDeclaredConstructor(new Class[] { String.class });
      IDsConstructor.setAccessible(true);
      rateLimitStatusConstructor = Class.forName("twitter4j.internal.json.RateLimitStatusJSONImpl").getDeclaredMethod("createRateLimitStatuses", new Class[] { JSONObject.class });
      rateLimitStatusConstructor.setAccessible(true);
      categoryConstructor = Class.forName("twitter4j.internal.json.CategoryJSONImpl").getDeclaredConstructor(new Class[] { JSONObject.class });
      categoryConstructor.setAccessible(true);
      directMessageConstructor = Class.forName("twitter4j.internal.json.DirectMessageJSONImpl").getDeclaredConstructor(new Class[] { JSONObject.class });
      directMessageConstructor.setAccessible(true);
      locationConstructor = Class.forName("twitter4j.internal.json.LocationJSONImpl").getDeclaredConstructor(new Class[] { JSONObject.class });
      locationConstructor.setAccessible(true);
      userListConstructor = Class.forName("twitter4j.internal.json.UserListJSONImpl").getDeclaredConstructor(new Class[] { JSONObject.class });
      userListConstructor.setAccessible(true);
      statusDeletionNoticeConstructor = Class.forName("twitter4j.StatusDeletionNoticeImpl").getDeclaredConstructor(new Class[] { JSONObject.class });
      statusDeletionNoticeConstructor.setAccessible(true);
      accountTotalsConstructor = Class.forName("twitter4j.internal.json.AccountTotalsJSONImpl").getDeclaredConstructor(new Class[] { JSONObject.class });
      accountTotalsConstructor.setAccessible(true);
      oembedConstructor = Class.forName("twitter4j.internal.json.OEmbedJSONImpl").getDeclaredConstructor(new Class[] { JSONObject.class });
      oembedConstructor.setAccessible(true);
      rawJsonMap = new ThreadLocal()
      {
        protected Map initialValue()
        {
          return new HashMap();
        }
      };
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new ExceptionInInitializerError(localNoSuchMethodException);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new ExceptionInInitializerError(localClassNotFoundException);
    }
  }
  
  private DataObjectFactory()
  {
    throw new AssertionError("not intended to be instantiated.");
  }
  
  static void clearThreadLocalMap()
  {
    ((Map)rawJsonMap.get()).clear();
  }
  
  public static AccountTotals createAccountTotals(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      paramString = (AccountTotals)accountTotalsConstructor.newInstance(new Object[] { paramString });
      return paramString;
    }
    catch (InstantiationException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new AssertionError(paramString);
    }
    catch (InvocationTargetException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (JSONException paramString)
    {
      throw new TwitterException(paramString);
    }
  }
  
  public static Category createCategory(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      paramString = (Category)categoryConstructor.newInstance(new Object[] { paramString });
      return paramString;
    }
    catch (InstantiationException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new AssertionError(paramString);
    }
    catch (InvocationTargetException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (JSONException paramString)
    {
      throw new TwitterException(paramString);
    }
  }
  
  public static DirectMessage createDirectMessage(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      paramString = (DirectMessage)directMessageConstructor.newInstance(new Object[] { paramString });
      return paramString;
    }
    catch (InstantiationException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new AssertionError(paramString);
    }
    catch (InvocationTargetException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (JSONException paramString)
    {
      throw new TwitterException(paramString);
    }
  }
  
  public static IDs createIDs(String paramString)
  {
    try
    {
      paramString = (IDs)IDsConstructor.newInstance(new Object[] { paramString });
      return paramString;
    }
    catch (InstantiationException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new AssertionError(paramString);
    }
    catch (InvocationTargetException paramString)
    {
      throw new TwitterException(paramString);
    }
  }
  
  public static Location createLocation(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      paramString = (Location)locationConstructor.newInstance(new Object[] { paramString });
      return paramString;
    }
    catch (InstantiationException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new AssertionError(paramString);
    }
    catch (InvocationTargetException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (JSONException paramString)
    {
      throw new TwitterException(paramString);
    }
  }
  
  public static OEmbed createOEmbed(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      paramString = (OEmbed)oembedConstructor.newInstance(new Object[] { paramString });
      return paramString;
    }
    catch (InstantiationException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new AssertionError(paramString);
    }
    catch (InvocationTargetException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (JSONException paramString)
    {
      throw new TwitterException(paramString);
    }
  }
  
  public static Object createObject(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      JSONObjectType.Type localType = JSONObjectType.determine(paramString);
      switch (2.$SwitchMap$twitter4j$json$JSONObjectType$Type[localType.ordinal()])
      {
      case 1: 
        return registerJSONObject(directMessageConstructor.newInstance(new Object[] { paramString.getJSONObject("direct_message") }), paramString);
      }
    }
    catch (InstantiationException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new AssertionError(paramString);
    }
    catch (InvocationTargetException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (JSONException paramString)
    {
      throw new TwitterException(paramString);
    }
    return registerJSONObject(statusConstructor.newInstance(new Object[] { paramString }), paramString);
    return registerJSONObject(directMessageConstructor.newInstance(new Object[] { paramString.getJSONObject("direct_message") }), paramString);
    paramString = registerJSONObject(statusDeletionNoticeConstructor.newInstance(new Object[] { paramString.getJSONObject("delete").getJSONObject("status") }), paramString);
    return paramString;
    return paramString;
  }
  
  public static Place createPlace(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      paramString = (Place)placeConstructor.newInstance(new Object[] { paramString });
      return paramString;
    }
    catch (InstantiationException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new AssertionError(paramString);
    }
    catch (InvocationTargetException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (JSONException paramString)
    {
      throw new TwitterException(paramString);
    }
  }
  
  public static Map createRateLimitStatus(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      paramString = (Map)rateLimitStatusConstructor.invoke(Class.forName("twitter4j.internal.json.RateLimitStatusJSONImpl"), new Object[] { paramString });
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new AssertionError(paramString);
    }
    catch (InvocationTargetException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (JSONException paramString)
    {
      throw new TwitterException(paramString);
    }
  }
  
  public static Relationship createRelationship(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      paramString = (Relationship)relationshipConstructor.newInstance(new Object[] { paramString });
      return paramString;
    }
    catch (InstantiationException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new AssertionError(paramString);
    }
    catch (InvocationTargetException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (JSONException paramString)
    {
      throw new TwitterException(paramString);
    }
  }
  
  public static SavedSearch createSavedSearch(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      paramString = (SavedSearch)savedSearchConstructor.newInstance(new Object[] { paramString });
      return paramString;
    }
    catch (InstantiationException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new AssertionError(paramString);
    }
    catch (InvocationTargetException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (JSONException paramString)
    {
      throw new TwitterException(paramString);
    }
  }
  
  public static Status createStatus(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      paramString = (Status)statusConstructor.newInstance(new Object[] { paramString });
      return paramString;
    }
    catch (InstantiationException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new AssertionError(paramString);
    }
    catch (InvocationTargetException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (JSONException paramString)
    {
      throw new TwitterException(paramString);
    }
  }
  
  public static Trend createTrend(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      paramString = (Trend)trendConstructor.newInstance(new Object[] { paramString });
      return paramString;
    }
    catch (InstantiationException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new AssertionError(paramString);
    }
    catch (InvocationTargetException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (JSONException paramString)
    {
      throw new TwitterException(paramString);
    }
  }
  
  public static Trends createTrends(String paramString)
  {
    try
    {
      paramString = (Trends)trendsConstructor.newInstance(new Object[] { paramString });
      return paramString;
    }
    catch (InstantiationException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (InvocationTargetException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public static User createUser(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      paramString = (User)userConstructor.newInstance(new Object[] { paramString });
      return paramString;
    }
    catch (InstantiationException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new AssertionError(paramString);
    }
    catch (InvocationTargetException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (JSONException paramString)
    {
      throw new TwitterException(paramString);
    }
  }
  
  public static UserList createUserList(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      paramString = (UserList)userListConstructor.newInstance(new Object[] { paramString });
      return paramString;
    }
    catch (InstantiationException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new AssertionError(paramString);
    }
    catch (InvocationTargetException paramString)
    {
      throw new TwitterException(paramString);
    }
    catch (JSONException paramString)
    {
      throw new TwitterException(paramString);
    }
  }
  
  public static String getRawJSON(Object paramObject)
  {
    paramObject = ((Map)rawJsonMap.get()).get(paramObject);
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if (paramObject != null) {
      return paramObject.toString();
    }
    return null;
  }
  
  static Object registerJSONObject(Object paramObject1, Object paramObject2)
  {
    ((Map)rawJsonMap.get()).put(paramObject1, paramObject2);
    return paramObject1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/json/DataObjectFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */