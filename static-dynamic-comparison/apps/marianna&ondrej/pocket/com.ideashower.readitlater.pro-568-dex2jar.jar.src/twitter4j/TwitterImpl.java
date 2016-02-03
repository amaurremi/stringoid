package twitter4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import twitter4j.api.DirectMessagesResources;
import twitter4j.api.FavoritesResources;
import twitter4j.api.FriendsFollowersResources;
import twitter4j.api.HelpResources;
import twitter4j.api.ListsResources;
import twitter4j.api.PlacesGeoResources;
import twitter4j.api.SavedSearchesResources;
import twitter4j.api.SearchResource;
import twitter4j.api.SpamReportingResource;
import twitter4j.api.SuggestedUsersResources;
import twitter4j.api.TimelinesResources;
import twitter4j.api.TrendsResources;
import twitter4j.api.TweetsResources;
import twitter4j.api.UsersResources;
import twitter4j.auth.Authorization;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpClientWrapper;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.json.z_T4JInternalFactory;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;
import twitter4j.internal.util.z_T4JInternalStringUtil;

class TwitterImpl
  extends TwitterBaseImpl
  implements Twitter
{
  private static final Map implicitParamsMap = new HashMap();
  private static final Map implicitParamsStrMap = new HashMap();
  private static final long serialVersionUID = -1486360080128882436L;
  private final HttpParameter[] IMPLICIT_PARAMS;
  private final String IMPLICIT_PARAMS_STR;
  private final HttpParameter INCLUDE_MY_RETWEET;
  
  TwitterImpl(Configuration paramConfiguration, Authorization paramAuthorization)
  {
    super(paramConfiguration, paramAuthorization);
    this.INCLUDE_MY_RETWEET = new HttpParameter("include_my_retweet", paramConfiguration.isIncludeMyRetweetEnabled());
    Object localObject2 = (HttpParameter[])implicitParamsMap.get(paramConfiguration);
    Object localObject1 = (String)implicitParamsStrMap.get(paramConfiguration);
    paramAuthorization = (Authorization)localObject2;
    label86:
    int i;
    label101:
    Object localObject3;
    if (localObject2 == null)
    {
      if (!paramConfiguration.isIncludeEntitiesEnabled()) {
        break label333;
      }
      paramAuthorization = "1";
      if (!paramConfiguration.isIncludeRTsEnabled()) {
        break label339;
      }
      localObject1 = "1";
      if (paramConfiguration.getContributingTo() == -1L) {
        break label346;
      }
      i = 1;
      localObject3 = new StringBuilder().append("include_entities=").append(paramAuthorization).append("&include_rts=").append((String)localObject1);
      if (i == 0) {
        break label351;
      }
    }
    label333:
    label339:
    label346:
    label351:
    for (localObject2 = "&contributingto=" + paramConfiguration.getContributingTo();; localObject2 = "")
    {
      localObject2 = (String)localObject2;
      implicitParamsStrMap.put(paramConfiguration, localObject2);
      localObject3 = new ArrayList(4);
      ((List)localObject3).add(new HttpParameter("include_entities", paramAuthorization));
      ((List)localObject3).add(new HttpParameter("include_rts", (String)localObject1));
      if (i != 0) {
        ((List)localObject3).add(new HttpParameter("contributingto", paramConfiguration.getContributingTo()));
      }
      if (paramConfiguration.isTrimUserEnabled()) {
        ((List)localObject3).add(new HttpParameter("trim_user", "1"));
      }
      paramAuthorization = (HttpParameter[])((List)localObject3).toArray(new HttpParameter[((List)localObject3).size()]);
      implicitParamsMap.put(paramConfiguration, paramAuthorization);
      localObject1 = localObject2;
      this.IMPLICIT_PARAMS = paramAuthorization;
      this.IMPLICIT_PARAMS_STR = ((String)localObject1);
      return;
      paramAuthorization = "0";
      break;
      localObject1 = "0";
      break label86;
      i = 0;
      break label101;
    }
  }
  
  private void addParameterToList(List paramList, String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      paramList.add(new HttpParameter(paramString1, paramString2));
    }
  }
  
  private void checkFileValidity(File paramFile)
  {
    if (!paramFile.exists()) {
      throw new TwitterException(new FileNotFoundException(paramFile + " is not found."));
    }
    if (!paramFile.isFile()) {
      throw new TwitterException(new IOException(paramFile + " is not a file."));
    }
  }
  
  private HttpResponse get(String paramString)
  {
    ensureAuthorizationEnabled();
    if (paramString.contains("?")) {}
    for (paramString = paramString + "&" + this.IMPLICIT_PARAMS_STR; !this.conf.isMBeanEnabled(); paramString = paramString + "?" + this.IMPLICIT_PARAMS_STR) {
      return this.http.get(paramString, this.auth);
    }
    long l1 = System.currentTimeMillis();
    try
    {
      HttpResponse localHttpResponse = this.http.get(paramString, this.auth);
      l2 = System.currentTimeMillis();
      TwitterAPIMonitor.getInstance().methodCalled(paramString, l2 - l1, isOk(localHttpResponse));
      return localHttpResponse;
    }
    finally
    {
      long l2 = System.currentTimeMillis();
      TwitterAPIMonitor.getInstance().methodCalled(paramString, l2 - l1, isOk(null));
    }
  }
  
  private HttpResponse get(String paramString, HttpParameter[] paramArrayOfHttpParameter)
  {
    ensureAuthorizationEnabled();
    if (!this.conf.isMBeanEnabled()) {
      return this.http.get(paramString, mergeImplicitParams(paramArrayOfHttpParameter), this.auth);
    }
    long l1 = System.currentTimeMillis();
    try
    {
      paramArrayOfHttpParameter = this.http.get(paramString, mergeImplicitParams(paramArrayOfHttpParameter), this.auth);
      l2 = System.currentTimeMillis();
      TwitterAPIMonitor.getInstance().methodCalled(paramString, l2 - l1, isOk(paramArrayOfHttpParameter));
      return paramArrayOfHttpParameter;
    }
    finally
    {
      long l2 = System.currentTimeMillis();
      TwitterAPIMonitor.getInstance().methodCalled(paramString, l2 - l1, isOk(null));
    }
  }
  
  private boolean isOk(HttpResponse paramHttpResponse)
  {
    return (paramHttpResponse != null) && (paramHttpResponse.getStatusCode() < 300);
  }
  
  private HttpParameter[] mergeImplicitParams(HttpParameter[] paramArrayOfHttpParameter)
  {
    return mergeParameters(paramArrayOfHttpParameter, this.IMPLICIT_PARAMS);
  }
  
  private HttpParameter[] mergeParameters(HttpParameter[] paramArrayOfHttpParameter, HttpParameter paramHttpParameter)
  {
    HttpParameter[] arrayOfHttpParameter;
    if ((paramArrayOfHttpParameter != null) && (paramHttpParameter != null))
    {
      arrayOfHttpParameter = new HttpParameter[paramArrayOfHttpParameter.length + 1];
      System.arraycopy(paramArrayOfHttpParameter, 0, arrayOfHttpParameter, 0, paramArrayOfHttpParameter.length);
      arrayOfHttpParameter[(arrayOfHttpParameter.length - 1)] = paramHttpParameter;
    }
    do
    {
      return arrayOfHttpParameter;
      if ((paramArrayOfHttpParameter == null) && (paramHttpParameter == null)) {
        return new HttpParameter[0];
      }
      arrayOfHttpParameter = paramArrayOfHttpParameter;
    } while (paramArrayOfHttpParameter != null);
    return new HttpParameter[] { paramHttpParameter };
  }
  
  private HttpParameter[] mergeParameters(HttpParameter[] paramArrayOfHttpParameter1, HttpParameter[] paramArrayOfHttpParameter2)
  {
    HttpParameter[] arrayOfHttpParameter;
    if ((paramArrayOfHttpParameter1 != null) && (paramArrayOfHttpParameter2 != null))
    {
      arrayOfHttpParameter = new HttpParameter[paramArrayOfHttpParameter1.length + paramArrayOfHttpParameter2.length];
      System.arraycopy(paramArrayOfHttpParameter1, 0, arrayOfHttpParameter, 0, paramArrayOfHttpParameter1.length);
      System.arraycopy(paramArrayOfHttpParameter2, 0, arrayOfHttpParameter, paramArrayOfHttpParameter1.length, paramArrayOfHttpParameter2.length);
    }
    do
    {
      return arrayOfHttpParameter;
      if ((paramArrayOfHttpParameter1 == null) && (paramArrayOfHttpParameter2 == null)) {
        return new HttpParameter[0];
      }
      arrayOfHttpParameter = paramArrayOfHttpParameter1;
    } while (paramArrayOfHttpParameter1 != null);
    return paramArrayOfHttpParameter2;
  }
  
  private HttpResponse post(String paramString)
  {
    ensureAuthorizationEnabled();
    if (!this.conf.isMBeanEnabled()) {
      return this.http.post(paramString, this.IMPLICIT_PARAMS, this.auth);
    }
    long l1 = System.currentTimeMillis();
    try
    {
      HttpResponse localHttpResponse = this.http.post(paramString, this.IMPLICIT_PARAMS, this.auth);
      l2 = System.currentTimeMillis();
      TwitterAPIMonitor.getInstance().methodCalled(paramString, l2 - l1, isOk(localHttpResponse));
      return localHttpResponse;
    }
    finally
    {
      long l2 = System.currentTimeMillis();
      TwitterAPIMonitor.getInstance().methodCalled(paramString, l2 - l1, isOk(null));
    }
  }
  
  private HttpResponse post(String paramString, HttpParameter[] paramArrayOfHttpParameter)
  {
    ensureAuthorizationEnabled();
    if (!this.conf.isMBeanEnabled()) {
      return this.http.post(paramString, mergeImplicitParams(paramArrayOfHttpParameter), this.auth);
    }
    long l1 = System.currentTimeMillis();
    try
    {
      paramArrayOfHttpParameter = this.http.post(paramString, mergeImplicitParams(paramArrayOfHttpParameter), this.auth);
      l2 = System.currentTimeMillis();
      TwitterAPIMonitor.getInstance().methodCalled(paramString, l2 - l1, isOk(paramArrayOfHttpParameter));
      return paramArrayOfHttpParameter;
    }
    finally
    {
      long l2 = System.currentTimeMillis();
      TwitterAPIMonitor.getInstance().methodCalled(paramString, l2 - l1, isOk(null));
    }
  }
  
  private UserList updateUserList(String paramString1, boolean paramBoolean, String paramString2, HttpParameter... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    Collections.addAll(localArrayList, paramVarArgs);
    if (paramString1 != null) {
      localArrayList.add(new HttpParameter("name", paramString1));
    }
    if (paramBoolean) {}
    for (paramString1 = "public";; paramString1 = "private")
    {
      localArrayList.add(new HttpParameter("mode", paramString1));
      if (paramString2 != null) {
        localArrayList.add(new HttpParameter("description", paramString2));
      }
      return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/update.json", (HttpParameter[])localArrayList.toArray(new HttpParameter[localArrayList.size()])));
    }
  }
  
  public UserList addUserListMember(int paramInt, long paramLong)
  {
    return null;
  }
  
  public UserList addUserListMember(long paramLong1, String paramString, long paramLong2)
  {
    return null;
  }
  
  public UserList addUserListMembers(int paramInt, long[] paramArrayOfLong)
  {
    return createUserListMembers(paramInt, paramArrayOfLong);
  }
  
  public UserList addUserListMembers(int paramInt, String[] paramArrayOfString)
  {
    return createUserListMembers(paramInt, paramArrayOfString);
  }
  
  public UserList addUserListMembers(long paramLong, String paramString, long[] paramArrayOfLong)
  {
    return createUserListMembers(paramLong, paramString, paramArrayOfLong);
  }
  
  public UserList addUserListMembers(long paramLong, String paramString, String[] paramArrayOfString)
  {
    return createUserListMembers(paramLong, paramString, paramArrayOfString);
  }
  
  public User createBlock(long paramLong)
  {
    return this.factory.createUser(post(this.conf.getRestBaseURL() + "blocks/create.json?user_id=" + paramLong));
  }
  
  public User createBlock(String paramString)
  {
    return this.factory.createUser(post(this.conf.getRestBaseURL() + "blocks/create.json?screen_name=" + paramString));
  }
  
  public Status createFavorite(long paramLong)
  {
    return this.factory.createStatus(post(this.conf.getRestBaseURL() + "favorites/create.json?id=" + paramLong));
  }
  
  public User createFriendship(long paramLong)
  {
    return this.factory.createUser(post(this.conf.getRestBaseURL() + "friendships/create.json?user_id=" + paramLong));
  }
  
  public User createFriendship(long paramLong, boolean paramBoolean)
  {
    return this.factory.createUser(post(this.conf.getRestBaseURL() + "friendships/create.json?user_id=" + paramLong + "&follow=" + paramBoolean));
  }
  
  public User createFriendship(String paramString)
  {
    return this.factory.createUser(post(this.conf.getRestBaseURL() + "friendships/create.json?screen_name=" + paramString));
  }
  
  public User createFriendship(String paramString, boolean paramBoolean)
  {
    return this.factory.createUser(post(this.conf.getRestBaseURL() + "friendships/create.json?screen_name=" + paramString + "&follow=" + paramBoolean));
  }
  
  public Place createPlace(String paramString1, String paramString2, String paramString3, GeoLocation paramGeoLocation, String paramString4)
  {
    ArrayList localArrayList = new ArrayList(3);
    localArrayList.add(new HttpParameter("name", paramString1));
    localArrayList.add(new HttpParameter("contained_within", paramString2));
    localArrayList.add(new HttpParameter("token", paramString3));
    localArrayList.add(new HttpParameter("lat", paramGeoLocation.getLatitude()));
    localArrayList.add(new HttpParameter("long", paramGeoLocation.getLongitude()));
    if (paramString4 != null) {
      localArrayList.add(new HttpParameter("attribute:street_address", paramString4));
    }
    return this.factory.createPlace(post(this.conf.getRestBaseURL() + "geo/place.json", (HttpParameter[])localArrayList.toArray(new HttpParameter[localArrayList.size()])));
  }
  
  public SavedSearch createSavedSearch(String paramString)
  {
    return this.factory.createSavedSearch(post(this.conf.getRestBaseURL() + "saved_searches/create.json", new HttpParameter[] { new HttpParameter("query", paramString) }));
  }
  
  public UserList createUserList(String paramString1, boolean paramBoolean, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new HttpParameter("name", paramString1));
    if (paramBoolean) {}
    for (paramString1 = "public";; paramString1 = "private")
    {
      localArrayList.add(new HttpParameter("mode", paramString1));
      if (paramString2 != null) {
        localArrayList.add(new HttpParameter("description", paramString2));
      }
      return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/create.json", (HttpParameter[])localArrayList.toArray(new HttpParameter[localArrayList.size()])));
    }
  }
  
  public UserList createUserListMember(int paramInt, long paramLong)
  {
    return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/create.json", new HttpParameter[] { new HttpParameter("user_id", paramLong), new HttpParameter("list_id", paramInt) }));
  }
  
  public UserList createUserListMember(long paramLong1, String paramString, long paramLong2)
  {
    return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/create.json", new HttpParameter[] { new HttpParameter("user_id", paramLong2), new HttpParameter("owner_id", paramLong1), new HttpParameter("slug", paramString) }));
  }
  
  public UserList createUserListMember(String paramString1, String paramString2, long paramLong)
  {
    return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/create.json", new HttpParameter[] { new HttpParameter("user_id", paramLong), new HttpParameter("owner_screen_name", paramString1), new HttpParameter("slug", paramString2) }));
  }
  
  public UserList createUserListMembers(int paramInt, long[] paramArrayOfLong)
  {
    return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/create_all.json", new HttpParameter[] { new HttpParameter("list_id", paramInt), new HttpParameter("user_id", z_T4JInternalStringUtil.join(paramArrayOfLong)) }));
  }
  
  public UserList createUserListMembers(int paramInt, String[] paramArrayOfString)
  {
    return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/create_all.json", new HttpParameter[] { new HttpParameter("list_id", paramInt), new HttpParameter("screen_name", z_T4JInternalStringUtil.join(paramArrayOfString)) }));
  }
  
  public UserList createUserListMembers(long paramLong, String paramString, long[] paramArrayOfLong)
  {
    return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/create_all.json", new HttpParameter[] { new HttpParameter("owner_id", paramLong), new HttpParameter("slug", paramString), new HttpParameter("user_id", z_T4JInternalStringUtil.join(paramArrayOfLong)) }));
  }
  
  public UserList createUserListMembers(long paramLong, String paramString, String[] paramArrayOfString)
  {
    return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/create_all.json", new HttpParameter[] { new HttpParameter("owner_id", paramLong), new HttpParameter("slug", paramString), new HttpParameter("screen_name", z_T4JInternalStringUtil.join(paramArrayOfString)) }));
  }
  
  public UserList createUserListMembers(String paramString1, String paramString2, long[] paramArrayOfLong)
  {
    return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/create_all.json", new HttpParameter[] { new HttpParameter("owner_screen_name", paramString1), new HttpParameter("slug", paramString2), new HttpParameter("user_id", z_T4JInternalStringUtil.join(paramArrayOfLong)) }));
  }
  
  public UserList createUserListMembers(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/create_all.json", new HttpParameter[] { new HttpParameter("owner_screen_name", paramString1), new HttpParameter("slug", paramString2), new HttpParameter("screen_name", z_T4JInternalStringUtil.join(paramArrayOfString)) }));
  }
  
  public UserList createUserListSubscription(int paramInt)
  {
    return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/subscribers/create.json", new HttpParameter[] { new HttpParameter("list_id", paramInt) }));
  }
  
  public UserList createUserListSubscription(long paramLong, String paramString)
  {
    return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/subscribers/create.json", new HttpParameter[] { new HttpParameter("owner_id", paramLong), new HttpParameter("slug", paramString) }));
  }
  
  public UserList createUserListSubscription(String paramString1, String paramString2)
  {
    return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/subscribers/create.json", new HttpParameter[] { new HttpParameter("owner_screen_name", paramString1), new HttpParameter("slug", paramString2) }));
  }
  
  public UserList deleteUserListMember(int paramInt, long paramLong)
  {
    return destroyUserListMember(paramInt, paramLong);
  }
  
  public UserList deleteUserListMember(long paramLong1, String paramString, long paramLong2)
  {
    return destroyUserListMember(paramLong1, paramString, paramLong2);
  }
  
  public User destroyBlock(long paramLong)
  {
    return this.factory.createUser(post(this.conf.getRestBaseURL() + "blocks/destroy.json?user_id=" + paramLong));
  }
  
  public User destroyBlock(String paramString)
  {
    return this.factory.createUser(post(this.conf.getRestBaseURL() + "blocks/destroy.json?screen_name=" + paramString));
  }
  
  public DirectMessage destroyDirectMessage(long paramLong)
  {
    return this.factory.createDirectMessage(post(this.conf.getRestBaseURL() + "direct_messages/destroy.json?id=" + paramLong));
  }
  
  public Status destroyFavorite(long paramLong)
  {
    return this.factory.createStatus(post(this.conf.getRestBaseURL() + "favorites/destroy.json?id=" + paramLong));
  }
  
  public User destroyFriendship(long paramLong)
  {
    return this.factory.createUser(post(this.conf.getRestBaseURL() + "friendships/destroy.json?user_id=" + paramLong));
  }
  
  public User destroyFriendship(String paramString)
  {
    return this.factory.createUser(post(this.conf.getRestBaseURL() + "friendships/destroy.json?screen_name=" + paramString));
  }
  
  public SavedSearch destroySavedSearch(int paramInt)
  {
    return this.factory.createSavedSearch(post(this.conf.getRestBaseURL() + "saved_searches/destroy/" + paramInt + ".json"));
  }
  
  public Status destroyStatus(long paramLong)
  {
    return this.factory.createStatus(post(this.conf.getRestBaseURL() + "statuses/destroy/" + paramLong + ".json"));
  }
  
  public UserList destroyUserList(int paramInt)
  {
    return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/destroy.json", new HttpParameter[] { new HttpParameter("list_id", paramInt) }));
  }
  
  public UserList destroyUserList(long paramLong, String paramString)
  {
    return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/destroy.json", new HttpParameter[] { new HttpParameter("owner_id", paramLong), new HttpParameter("slug", paramString) }));
  }
  
  public UserList destroyUserList(String paramString1, String paramString2)
  {
    return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/destroy.json", new HttpParameter[] { new HttpParameter("owner_screen_name", paramString1), new HttpParameter("slug", paramString2) }));
  }
  
  public UserList destroyUserListMember(int paramInt, long paramLong)
  {
    return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/destroy.json", new HttpParameter[] { new HttpParameter("list_id", paramInt), new HttpParameter("user_id", paramLong) }));
  }
  
  public UserList destroyUserListMember(long paramLong1, String paramString, long paramLong2)
  {
    return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/destroy.json", new HttpParameter[] { new HttpParameter("owner_id", paramLong1), new HttpParameter("slug", paramString), new HttpParameter("user_id", paramLong2) }));
  }
  
  public UserList destroyUserListMember(String paramString1, String paramString2, long paramLong)
  {
    return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/members/destroy.json", new HttpParameter[] { new HttpParameter("owner_screen_name", paramString1), new HttpParameter("slug", paramString2), new HttpParameter("user_id", paramLong) }));
  }
  
  public UserList destroyUserListSubscription(int paramInt)
  {
    return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/subscribers/destroy.json", new HttpParameter[] { new HttpParameter("list_id", paramInt) }));
  }
  
  public UserList destroyUserListSubscription(long paramLong, String paramString)
  {
    return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/subscribers/destroy.json", new HttpParameter[] { new HttpParameter("owner_id", paramLong), new HttpParameter("slug", paramString) }));
  }
  
  public UserList destroyUserListSubscription(String paramString1, String paramString2)
  {
    return this.factory.createAUserList(post(this.conf.getRestBaseURL() + "lists/subscribers/destroy.json", new HttpParameter[] { new HttpParameter("owner_screen_name", paramString1), new HttpParameter("slug", paramString2) }));
  }
  
  public DirectMessagesResources directMessages()
  {
    return this;
  }
  
  public FavoritesResources favorites()
  {
    return this;
  }
  
  public FriendsFollowersResources friendsFollowers()
  {
    return this;
  }
  
  public TwitterAPIConfiguration getAPIConfiguration()
  {
    return this.factory.createTwitterAPIConfiguration(get(this.conf.getRestBaseURL() + "help/configuration.json"));
  }
  
  public AccountSettings getAccountSettings()
  {
    return this.factory.createAccountSettings(get(this.conf.getRestBaseURL() + "account/settings.json"));
  }
  
  public ResponseList getAvailableTrends()
  {
    return this.factory.createLocationList(get(this.conf.getRestBaseURL() + "trends/available.json"));
  }
  
  public ResponseList getAvailableTrends(GeoLocation paramGeoLocation)
  {
    return getClosestTrends(paramGeoLocation);
  }
  
  public IDs getBlocksIDs()
  {
    return this.factory.createIDs(get(this.conf.getRestBaseURL() + "blocks/ids.json"));
  }
  
  public IDs getBlocksIDs(long paramLong)
  {
    return this.factory.createIDs(get(this.conf.getRestBaseURL() + "blocks/ids.json?cursor=" + paramLong));
  }
  
  public PagableResponseList getBlocksList()
  {
    return getBlocksList(-1L);
  }
  
  public PagableResponseList getBlocksList(long paramLong)
  {
    return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + "blocks/list.json?cursor=" + paramLong));
  }
  
  public ResponseList getClosestTrends(GeoLocation paramGeoLocation)
  {
    return this.factory.createLocationList(get(this.conf.getRestBaseURL() + "trends/closest.json", new HttpParameter[] { new HttpParameter("lat", paramGeoLocation.getLatitude()), new HttpParameter("long", paramGeoLocation.getLongitude()) }));
  }
  
  public ResponseList getContributees(long paramLong)
  {
    return this.factory.createUserList(get(this.conf.getRestBaseURL() + "users/contributees.json?user_id=" + paramLong));
  }
  
  public ResponseList getContributees(String paramString)
  {
    return this.factory.createUserList(get(this.conf.getRestBaseURL() + "users/contributees.json?screen_name=" + paramString));
  }
  
  public ResponseList getContributors(long paramLong)
  {
    return this.factory.createUserList(get(this.conf.getRestBaseURL() + "users/contributors.json?user_id=" + paramLong));
  }
  
  public ResponseList getContributors(String paramString)
  {
    return this.factory.createUserList(get(this.conf.getRestBaseURL() + "users/contributors.json?screen_name=" + paramString));
  }
  
  public ResponseList getDirectMessages()
  {
    return this.factory.createDirectMessageList(get(this.conf.getRestBaseURL() + "direct_messages.json"));
  }
  
  public ResponseList getDirectMessages(Paging paramPaging)
  {
    return this.factory.createDirectMessageList(get(this.conf.getRestBaseURL() + "direct_messages.json", paramPaging.asPostParameterArray()));
  }
  
  public ResponseList getFavorites()
  {
    return this.factory.createStatusList(get(this.conf.getRestBaseURL() + "favorites/list.json"));
  }
  
  public ResponseList getFavorites(long paramLong)
  {
    return this.factory.createStatusList(get(this.conf.getRestBaseURL() + "favorites/list.json?user_id=" + paramLong));
  }
  
  public ResponseList getFavorites(long paramLong, Paging paramPaging)
  {
    z_T4JInternalFactory localz_T4JInternalFactory = this.factory;
    String str = this.conf.getRestBaseURL() + "favorites/list.json";
    HttpParameter localHttpParameter = new HttpParameter("user_id", paramLong);
    paramPaging = paramPaging.asPostParameterArray();
    return localz_T4JInternalFactory.createStatusList(get(str, mergeParameters(new HttpParameter[] { localHttpParameter }, paramPaging)));
  }
  
  public ResponseList getFavorites(String paramString)
  {
    return this.factory.createStatusList(get(this.conf.getRestBaseURL() + "favorites/list.json?screen_name=" + paramString));
  }
  
  public ResponseList getFavorites(String paramString, Paging paramPaging)
  {
    z_T4JInternalFactory localz_T4JInternalFactory = this.factory;
    String str = this.conf.getRestBaseURL() + "favorites/list.json";
    paramString = new HttpParameter("screen_name", paramString);
    paramPaging = paramPaging.asPostParameterArray();
    return localz_T4JInternalFactory.createStatusList(get(str, mergeParameters(new HttpParameter[] { paramString }, paramPaging)));
  }
  
  public ResponseList getFavorites(Paging paramPaging)
  {
    return this.factory.createStatusList(get(this.conf.getRestBaseURL() + "favorites/list.json", paramPaging.asPostParameterArray()));
  }
  
  public IDs getFollowersIDs(long paramLong)
  {
    return this.factory.createIDs(get(this.conf.getRestBaseURL() + "followers/ids.json?cursor=" + paramLong));
  }
  
  public IDs getFollowersIDs(long paramLong1, long paramLong2)
  {
    return this.factory.createIDs(get(this.conf.getRestBaseURL() + "followers/ids.json?user_id=" + paramLong1 + "&cursor=" + paramLong2));
  }
  
  public IDs getFollowersIDs(String paramString, long paramLong)
  {
    return this.factory.createIDs(get(this.conf.getRestBaseURL() + "followers/ids.json?screen_name=" + paramString + "&cursor=" + paramLong));
  }
  
  public PagableResponseList getFollowersList(long paramLong1, long paramLong2)
  {
    return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + "followers/list.json?user_id=" + paramLong1 + "&cursor=" + paramLong2));
  }
  
  public PagableResponseList getFollowersList(String paramString, long paramLong)
  {
    return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + "followers/list.json?screen_name=" + paramString + "&cursor=" + paramLong));
  }
  
  public IDs getFriendsIDs(long paramLong)
  {
    return this.factory.createIDs(get(this.conf.getRestBaseURL() + "friends/ids.json?cursor=" + paramLong));
  }
  
  public IDs getFriendsIDs(long paramLong1, long paramLong2)
  {
    return this.factory.createIDs(get(this.conf.getRestBaseURL() + "friends/ids.json?user_id=" + paramLong1 + "&cursor=" + paramLong2));
  }
  
  public IDs getFriendsIDs(String paramString, long paramLong)
  {
    return this.factory.createIDs(get(this.conf.getRestBaseURL() + "friends/ids.json?screen_name=" + paramString + "&cursor=" + paramLong));
  }
  
  public PagableResponseList getFriendsList(long paramLong1, long paramLong2)
  {
    return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + "friends/list.json?user_id=" + paramLong1 + "&cursor=" + paramLong2));
  }
  
  public PagableResponseList getFriendsList(String paramString, long paramLong)
  {
    return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + "friends/list.json?screen_name=" + paramString + "&cursor=" + paramLong));
  }
  
  public Place getGeoDetails(String paramString)
  {
    return this.factory.createPlace(get(this.conf.getRestBaseURL() + "geo/id/" + paramString + ".json"));
  }
  
  public ResponseList getHomeTimeline()
  {
    return this.factory.createStatusList(get(this.conf.getRestBaseURL() + "statuses/home_timeline.json", new HttpParameter[] { this.INCLUDE_MY_RETWEET }));
  }
  
  public ResponseList getHomeTimeline(Paging paramPaging)
  {
    return this.factory.createStatusList(get(this.conf.getRestBaseURL() + "statuses/home_timeline.json", mergeParameters(paramPaging.asPostParameterArray(), new HttpParameter[] { this.INCLUDE_MY_RETWEET })));
  }
  
  public IDs getIncomingFriendships(long paramLong)
  {
    return this.factory.createIDs(get(this.conf.getRestBaseURL() + "friendships/incoming.json?cursor=" + paramLong));
  }
  
  public ResponseList getLanguages()
  {
    return this.factory.createLanguageList(get(this.conf.getRestBaseURL() + "help/languages.json"));
  }
  
  public Trends getLocationTrends(int paramInt)
  {
    return getPlaceTrends(paramInt);
  }
  
  public ResponseList getMemberSuggestions(String paramString)
  {
    try
    {
      paramString = get(this.conf.getRestBaseURL() + "users/suggestions/" + URLEncoder.encode(paramString, "UTF-8") + "/members.json");
      return this.factory.createUserListFromJSONArray(paramString);
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public ResponseList getMentions()
  {
    return getMentionsTimeline();
  }
  
  public ResponseList getMentions(Paging paramPaging)
  {
    return getMentionsTimeline(paramPaging);
  }
  
  public ResponseList getMentionsTimeline()
  {
    return this.factory.createStatusList(get(this.conf.getRestBaseURL() + "statuses/mentions_timeline.json"));
  }
  
  public ResponseList getMentionsTimeline(Paging paramPaging)
  {
    return this.factory.createStatusList(get(this.conf.getRestBaseURL() + "statuses/mentions_timeline.json", paramPaging.asPostParameterArray()));
  }
  
  public OEmbed getOEmbed(OEmbedRequest paramOEmbedRequest)
  {
    return this.factory.createOEmbed(get(this.conf.getRestBaseURL() + "statuses/oembed.json", paramOEmbedRequest.asHttpParameterArray()));
  }
  
  public IDs getOutgoingFriendships(long paramLong)
  {
    return this.factory.createIDs(get(this.conf.getRestBaseURL() + "friendships/outgoing.json?cursor=" + paramLong));
  }
  
  public Trends getPlaceTrends(int paramInt)
  {
    return this.factory.createTrends(get(this.conf.getRestBaseURL() + "trends/place.json?id=" + paramInt));
  }
  
  public String getPrivacyPolicy()
  {
    try
    {
      String str = get(this.conf.getRestBaseURL() + "help/privacy.json").asJSONObject().getString("privacy");
      return str;
    }
    catch (JSONException localJSONException)
    {
      throw new TwitterException(localJSONException);
    }
  }
  
  public Map getRateLimitStatus()
  {
    return this.factory.createRateLimitStatuses(get(this.conf.getRestBaseURL() + "application/rate_limit_status.json"));
  }
  
  public Map getRateLimitStatus(String... paramVarArgs)
  {
    return this.factory.createRateLimitStatuses(get(this.conf.getRestBaseURL() + "application/rate_limit_status.json?resources=" + z_T4JInternalStringUtil.join(paramVarArgs)));
  }
  
  public IDs getRetweeterIds(long paramLong1, int paramInt, long paramLong2)
  {
    return this.factory.createIDs(get(this.conf.getRestBaseURL() + "statuses/retweeters/ids.json?id=" + paramLong1 + "&cursor=" + paramLong2 + "&count=" + paramInt));
  }
  
  public IDs getRetweeterIds(long paramLong1, long paramLong2)
  {
    return getRetweeterIds(paramLong1, 100, paramLong2);
  }
  
  public ResponseList getRetweets(long paramLong)
  {
    return this.factory.createStatusList(get(this.conf.getRestBaseURL() + "statuses/retweets/" + paramLong + ".json?count=100"));
  }
  
  public ResponseList getRetweetsOfMe()
  {
    return this.factory.createStatusList(get(this.conf.getRestBaseURL() + "statuses/retweets_of_me.json"));
  }
  
  public ResponseList getRetweetsOfMe(Paging paramPaging)
  {
    return this.factory.createStatusList(get(this.conf.getRestBaseURL() + "statuses/retweets_of_me.json", paramPaging.asPostParameterArray()));
  }
  
  public ResponseList getSavedSearches()
  {
    return this.factory.createSavedSearchList(get(this.conf.getRestBaseURL() + "saved_searches/list.json"));
  }
  
  public ResponseList getSentDirectMessages()
  {
    return this.factory.createDirectMessageList(get(this.conf.getRestBaseURL() + "direct_messages/sent.json"));
  }
  
  public ResponseList getSentDirectMessages(Paging paramPaging)
  {
    return this.factory.createDirectMessageList(get(this.conf.getRestBaseURL() + "direct_messages/sent.json", paramPaging.asPostParameterArray()));
  }
  
  public SimilarPlaces getSimilarPlaces(GeoLocation paramGeoLocation, String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList(3);
    localArrayList.add(new HttpParameter("lat", paramGeoLocation.getLatitude()));
    localArrayList.add(new HttpParameter("long", paramGeoLocation.getLongitude()));
    localArrayList.add(new HttpParameter("name", paramString1));
    if (paramString2 != null) {
      localArrayList.add(new HttpParameter("contained_within", paramString2));
    }
    if (paramString3 != null) {
      localArrayList.add(new HttpParameter("attribute:street_address", paramString3));
    }
    return this.factory.createSimilarPlaces(get(this.conf.getRestBaseURL() + "geo/similar_places.json", (HttpParameter[])localArrayList.toArray(new HttpParameter[localArrayList.size()])));
  }
  
  public ResponseList getSuggestedUserCategories()
  {
    return this.factory.createCategoryList(get(this.conf.getRestBaseURL() + "users/suggestions.json"));
  }
  
  public String getTermsOfService()
  {
    try
    {
      String str = get(this.conf.getRestBaseURL() + "help/tos.json").asJSONObject().getString("tos");
      return str;
    }
    catch (JSONException localJSONException)
    {
      throw new TwitterException(localJSONException);
    }
  }
  
  public PagableResponseList getUserListMembers(int paramInt, long paramLong)
  {
    return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + "lists/members.json?list_id=" + paramInt + "&cursor=" + paramLong));
  }
  
  public PagableResponseList getUserListMembers(long paramLong1, String paramString, long paramLong2)
  {
    return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + "lists/members.json?owner_id=" + paramLong1 + "&slug=" + paramString + "&cursor=" + paramLong2));
  }
  
  public PagableResponseList getUserListMembers(String paramString1, String paramString2, long paramLong)
  {
    return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + "lists/members.json?owner_screen_name=" + paramString1 + "&slug=" + paramString2 + "&cursor=" + paramLong));
  }
  
  public PagableResponseList getUserListMemberships(long paramLong)
  {
    return this.factory.createPagableUserListList(get(this.conf.getRestBaseURL() + "lists/memberships.json?cursor=" + paramLong));
  }
  
  public PagableResponseList getUserListMemberships(long paramLong1, long paramLong2)
  {
    return getUserListMemberships(paramLong1, paramLong2, false);
  }
  
  public PagableResponseList getUserListMemberships(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    return this.factory.createPagableUserListList(get(this.conf.getRestBaseURL() + "lists/memberships.json?user_id=" + paramLong1 + "&cursor=" + paramLong2 + "&filter_to_owned_lists=" + paramBoolean));
  }
  
  public PagableResponseList getUserListMemberships(String paramString, long paramLong)
  {
    return getUserListMemberships(paramString, paramLong, false);
  }
  
  public PagableResponseList getUserListMemberships(String paramString, long paramLong, boolean paramBoolean)
  {
    return this.factory.createPagableUserListList(get(this.conf.getRestBaseURL() + "lists/memberships.json?screen_name=" + paramString + "&cursor=" + paramLong + "&filter_to_owned_lists=" + paramBoolean));
  }
  
  public ResponseList getUserListStatuses(int paramInt, Paging paramPaging)
  {
    return this.factory.createStatusList(get(this.conf.getRestBaseURL() + "lists/statuses.json", mergeParameters(paramPaging.asPostParameterArray(Paging.SMCP, "count"), new HttpParameter("list_id", paramInt))));
  }
  
  public ResponseList getUserListStatuses(long paramLong, String paramString, Paging paramPaging)
  {
    return this.factory.createStatusList(get(this.conf.getRestBaseURL() + "lists/statuses.json", mergeParameters(paramPaging.asPostParameterArray(Paging.SMCP, "count"), new HttpParameter[] { new HttpParameter("owner_id", paramLong), new HttpParameter("slug", paramString) })));
  }
  
  public ResponseList getUserListStatuses(String paramString1, String paramString2, Paging paramPaging)
  {
    return this.factory.createStatusList(get(this.conf.getRestBaseURL() + "lists/statuses.json", mergeParameters(paramPaging.asPostParameterArray(Paging.SMCP, "count"), new HttpParameter[] { new HttpParameter("owner_screen_name", paramString1), new HttpParameter("slug", paramString2) })));
  }
  
  public PagableResponseList getUserListSubscribers(int paramInt, long paramLong)
  {
    return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + "lists/subscribers.json?list_id=" + paramInt + "&cursor=" + paramLong));
  }
  
  public PagableResponseList getUserListSubscribers(long paramLong1, String paramString, long paramLong2)
  {
    return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + "lists/subscribers.json?owner_id=" + paramLong1 + "&slug=" + paramString + "&cursor=" + paramLong2));
  }
  
  public PagableResponseList getUserListSubscribers(String paramString1, String paramString2, long paramLong)
  {
    return this.factory.createPagableUserList(get(this.conf.getRestBaseURL() + "lists/subscribers.json?owner_screen_name=" + paramString1 + "&slug=" + paramString2 + "&cursor=" + paramLong));
  }
  
  public PagableResponseList getUserListSubscriptions(String paramString, long paramLong)
  {
    return this.factory.createPagableUserListList(get(this.conf.getRestBaseURL() + "lists/subscriptions.json?screen_name=" + paramString + "&cursor=" + paramLong));
  }
  
  public ResponseList getUserLists(long paramLong)
  {
    return this.factory.createUserListList(get(this.conf.getRestBaseURL() + "lists/list.json?user_id=" + paramLong));
  }
  
  public ResponseList getUserLists(String paramString)
  {
    return this.factory.createUserListList(get(this.conf.getRestBaseURL() + "lists/list.json?screen_name=" + paramString));
  }
  
  public ResponseList getUserSuggestions(String paramString)
  {
    try
    {
      paramString = get(this.conf.getRestBaseURL() + "users/suggestions/" + URLEncoder.encode(paramString, "UTF-8") + ".json");
      return this.factory.createUserListFromJSONArray_Users(paramString);
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public ResponseList getUserTimeline()
  {
    return getUserTimeline(new Paging());
  }
  
  public ResponseList getUserTimeline(long paramLong)
  {
    return getUserTimeline(paramLong, new Paging());
  }
  
  public ResponseList getUserTimeline(long paramLong, Paging paramPaging)
  {
    z_T4JInternalFactory localz_T4JInternalFactory = this.factory;
    String str = this.conf.getRestBaseURL() + "statuses/user_timeline.json";
    HttpParameter localHttpParameter1 = new HttpParameter("user_id", paramLong);
    HttpParameter localHttpParameter2 = this.INCLUDE_MY_RETWEET;
    paramPaging = paramPaging.asPostParameterArray();
    return localz_T4JInternalFactory.createStatusList(get(str, mergeParameters(new HttpParameter[] { localHttpParameter1, localHttpParameter2 }, paramPaging)));
  }
  
  public ResponseList getUserTimeline(String paramString)
  {
    return getUserTimeline(paramString, new Paging());
  }
  
  public ResponseList getUserTimeline(String paramString, Paging paramPaging)
  {
    z_T4JInternalFactory localz_T4JInternalFactory = this.factory;
    String str = this.conf.getRestBaseURL() + "statuses/user_timeline.json";
    paramString = new HttpParameter("screen_name", paramString);
    HttpParameter localHttpParameter = this.INCLUDE_MY_RETWEET;
    paramPaging = paramPaging.asPostParameterArray();
    return localz_T4JInternalFactory.createStatusList(get(str, mergeParameters(new HttpParameter[] { paramString, localHttpParameter }, paramPaging)));
  }
  
  public ResponseList getUserTimeline(Paging paramPaging)
  {
    z_T4JInternalFactory localz_T4JInternalFactory = this.factory;
    String str = this.conf.getRestBaseURL() + "statuses/user_timeline.json";
    HttpParameter localHttpParameter = this.INCLUDE_MY_RETWEET;
    paramPaging = paramPaging.asPostParameterArray();
    return localz_T4JInternalFactory.createStatusList(get(str, mergeParameters(new HttpParameter[] { localHttpParameter }, paramPaging)));
  }
  
  public HelpResources help()
  {
    return this;
  }
  
  public ListsResources list()
  {
    return this;
  }
  
  public ResponseList lookupFriendships(long[] paramArrayOfLong)
  {
    return this.factory.createFriendshipList(get(this.conf.getRestBaseURL() + "friendships/lookup.json?user_id=" + z_T4JInternalStringUtil.join(paramArrayOfLong)));
  }
  
  public ResponseList lookupFriendships(String[] paramArrayOfString)
  {
    return this.factory.createFriendshipList(get(this.conf.getRestBaseURL() + "friendships/lookup.json?screen_name=" + z_T4JInternalStringUtil.join(paramArrayOfString)));
  }
  
  public ResponseList lookupUsers(long[] paramArrayOfLong)
  {
    return this.factory.createUserList(get(this.conf.getRestBaseURL() + "users/lookup.json", new HttpParameter[] { new HttpParameter("user_id", z_T4JInternalStringUtil.join(paramArrayOfLong)) }));
  }
  
  public ResponseList lookupUsers(String[] paramArrayOfString)
  {
    return this.factory.createUserList(get(this.conf.getRestBaseURL() + "users/lookup.json", new HttpParameter[] { new HttpParameter("screen_name", z_T4JInternalStringUtil.join(paramArrayOfString)) }));
  }
  
  public PlacesGeoResources placesGeo()
  {
    return this;
  }
  
  public void removeProfileBanner()
  {
    post(this.conf.getRestBaseURL() + "account/remove_profile_banner.json");
  }
  
  public User reportSpam(long paramLong)
  {
    return this.factory.createUser(post(this.conf.getRestBaseURL() + "users/report_spam.json?user_id=" + paramLong));
  }
  
  public User reportSpam(String paramString)
  {
    return this.factory.createUser(post(this.conf.getRestBaseURL() + "users/report_spam.json?screen_name=" + paramString));
  }
  
  public Status retweetStatus(long paramLong)
  {
    return this.factory.createStatus(post(this.conf.getRestBaseURL() + "statuses/retweet/" + paramLong + ".json"));
  }
  
  public ResponseList reverseGeoCode(GeoQuery paramGeoQuery)
  {
    try
    {
      paramGeoQuery = this.factory.createPlaceList(get(this.conf.getRestBaseURL() + "geo/reverse_geocode.json", paramGeoQuery.asHttpParameterArray()));
      return paramGeoQuery;
    }
    catch (TwitterException paramGeoQuery)
    {
      if (paramGeoQuery.getStatusCode() == 404) {
        return this.factory.createEmptyResponseList();
      }
      throw paramGeoQuery;
    }
  }
  
  public SavedSearchesResources savedSearches()
  {
    return this;
  }
  
  public QueryResult search(Query paramQuery)
  {
    if (paramQuery.nextPage() != null) {
      return this.factory.createQueryResult(get(this.conf.getRestBaseURL() + "search/tweets.json" + paramQuery.nextPage()), paramQuery);
    }
    return this.factory.createQueryResult(get(this.conf.getRestBaseURL() + "search/tweets.json", paramQuery.asHttpParameterArray()), paramQuery);
  }
  
  public SearchResource search()
  {
    return this;
  }
  
  public ResponseList searchPlaces(GeoQuery paramGeoQuery)
  {
    return this.factory.createPlaceList(get(this.conf.getRestBaseURL() + "geo/search.json", paramGeoQuery.asHttpParameterArray()));
  }
  
  public ResponseList searchUsers(String paramString, int paramInt)
  {
    return this.factory.createUserList(get(this.conf.getRestBaseURL() + "users/search.json", new HttpParameter[] { new HttpParameter("q", paramString), new HttpParameter("per_page", 20), new HttpParameter("page", paramInt) }));
  }
  
  public DirectMessage sendDirectMessage(long paramLong, String paramString)
  {
    return this.factory.createDirectMessage(post(this.conf.getRestBaseURL() + "direct_messages/new.json", new HttpParameter[] { new HttpParameter("user_id", paramLong), new HttpParameter("text", paramString) }));
  }
  
  public DirectMessage sendDirectMessage(String paramString1, String paramString2)
  {
    return this.factory.createDirectMessage(post(this.conf.getRestBaseURL() + "direct_messages/new.json", new HttpParameter[] { new HttpParameter("screen_name", paramString1), new HttpParameter("text", paramString2) }));
  }
  
  public DirectMessage showDirectMessage(long paramLong)
  {
    return this.factory.createDirectMessage(get(this.conf.getRestBaseURL() + "direct_messages/show.json?id=" + paramLong));
  }
  
  public Relationship showFriendship(long paramLong1, long paramLong2)
  {
    return this.factory.createRelationship(get(this.conf.getRestBaseURL() + "friendships/show.json", new HttpParameter[] { new HttpParameter("source_id", paramLong1), new HttpParameter("target_id", paramLong2) }));
  }
  
  public Relationship showFriendship(String paramString1, String paramString2)
  {
    return this.factory.createRelationship(get(this.conf.getRestBaseURL() + "friendships/show.json", HttpParameter.getParameterArray("source_screen_name", paramString1, "target_screen_name", paramString2)));
  }
  
  public SavedSearch showSavedSearch(int paramInt)
  {
    return this.factory.createSavedSearch(get(this.conf.getRestBaseURL() + "saved_searches/show/" + paramInt + ".json"));
  }
  
  public Status showStatus(long paramLong)
  {
    return this.factory.createStatus(get(this.conf.getRestBaseURL() + "statuses/show/" + paramLong + ".json", new HttpParameter[] { this.INCLUDE_MY_RETWEET }));
  }
  
  public User showUser(long paramLong)
  {
    return this.factory.createUser(get(this.conf.getRestBaseURL() + "users/show.json?user_id=" + paramLong));
  }
  
  public User showUser(String paramString)
  {
    return this.factory.createUser(get(this.conf.getRestBaseURL() + "users/show.json?screen_name=" + paramString));
  }
  
  public UserList showUserList(int paramInt)
  {
    return this.factory.createAUserList(get(this.conf.getRestBaseURL() + "lists/show.json?list_id=" + paramInt));
  }
  
  public UserList showUserList(long paramLong, String paramString)
  {
    return this.factory.createAUserList(get(this.conf.getRestBaseURL() + "lists/show.json?owner_id=" + paramLong + "&slug=" + paramString));
  }
  
  public UserList showUserList(String paramString1, String paramString2)
  {
    return this.factory.createAUserList(get(this.conf.getRestBaseURL() + "lists/show.json?owner_screen_name=" + paramString1 + "&slug=" + paramString2));
  }
  
  public User showUserListMembership(int paramInt, long paramLong)
  {
    return this.factory.createUser(get(this.conf.getRestBaseURL() + "lists/members/show.json?list_id=" + paramInt + "&user_id=" + paramLong));
  }
  
  public User showUserListMembership(long paramLong1, String paramString, long paramLong2)
  {
    return this.factory.createUser(get(this.conf.getRestBaseURL() + "lists/members/show.json?owner_id=" + paramLong1 + "&slug=" + paramString + "&user_id=" + paramLong2));
  }
  
  public User showUserListMembership(String paramString1, String paramString2, long paramLong)
  {
    return this.factory.createUser(get(this.conf.getRestBaseURL() + "lists/members/show.json?owner_screen_name=" + paramString1 + "&slug=" + paramString2 + "&user_id=" + paramLong));
  }
  
  public User showUserListSubscription(int paramInt, long paramLong)
  {
    return this.factory.createUser(get(this.conf.getRestBaseURL() + "lists/subscribers/show.json?list_id=" + paramInt + "&user_id=" + paramLong));
  }
  
  public User showUserListSubscription(long paramLong1, String paramString, long paramLong2)
  {
    return this.factory.createUser(get(this.conf.getRestBaseURL() + "lists/subscribers/show.json?owner_id=" + paramLong1 + "&slug=" + paramString + "&user_id=" + paramLong2));
  }
  
  public User showUserListSubscription(String paramString1, String paramString2, long paramLong)
  {
    return this.factory.createUser(get(this.conf.getRestBaseURL() + "lists/subscribers/show.json?owner_screen_name=" + paramString1 + "&slug=" + paramString2 + "&user_id=" + paramLong));
  }
  
  public SpamReportingResource spamReporting()
  {
    return this;
  }
  
  public SuggestedUsersResources suggestedUsers()
  {
    return this;
  }
  
  public TimelinesResources timelines()
  {
    return this;
  }
  
  public String toString()
  {
    return "TwitterImpl{INCLUDE_MY_RETWEET=" + this.INCLUDE_MY_RETWEET + '}';
  }
  
  public TrendsResources trends()
  {
    return this;
  }
  
  public TweetsResources tweets()
  {
    return this;
  }
  
  public AccountSettings updateAccountSettings(Integer paramInteger, Boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList(6);
    if (paramInteger != null) {
      localArrayList.add(new HttpParameter("trend_location_woeid", paramInteger.intValue()));
    }
    if (paramBoolean != null) {
      localArrayList.add(new HttpParameter("sleep_time_enabled", paramBoolean.toString()));
    }
    if (paramString1 != null) {
      localArrayList.add(new HttpParameter("start_sleep_time", paramString1));
    }
    if (paramString2 != null) {
      localArrayList.add(new HttpParameter("end_sleep_time", paramString2));
    }
    if (paramString3 != null) {
      localArrayList.add(new HttpParameter("time_zone", paramString3));
    }
    if (paramString4 != null) {
      localArrayList.add(new HttpParameter("lang", paramString4));
    }
    return this.factory.createAccountSettings(post(this.conf.getRestBaseURL() + "account/settings.json", (HttpParameter[])localArrayList.toArray(new HttpParameter[localArrayList.size()])));
  }
  
  public Relationship updateFriendship(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.factory.createRelationship(post(this.conf.getRestBaseURL() + "friendships/update.json", new HttpParameter[] { new HttpParameter("user_id", paramLong), new HttpParameter("device", paramBoolean1), new HttpParameter("retweets", paramBoolean2) }));
  }
  
  public Relationship updateFriendship(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.factory.createRelationship(post(this.conf.getRestBaseURL() + "friendships/update.json", new HttpParameter[] { new HttpParameter("screen_name", paramString), new HttpParameter("device", paramBoolean1), new HttpParameter("retweets", paramBoolean1) }));
  }
  
  public User updateProfile(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList(4);
    addParameterToList(localArrayList, "name", paramString1);
    addParameterToList(localArrayList, "url", paramString2);
    addParameterToList(localArrayList, "location", paramString3);
    addParameterToList(localArrayList, "description", paramString4);
    return this.factory.createUser(post(this.conf.getRestBaseURL() + "account/update_profile.json", (HttpParameter[])localArrayList.toArray(new HttpParameter[localArrayList.size()])));
  }
  
  public User updateProfileBackgroundImage(File paramFile, boolean paramBoolean)
  {
    checkFileValidity(paramFile);
    return this.factory.createUser(post(this.conf.getRestBaseURL() + "account/update_profile_background_image.json", new HttpParameter[] { new HttpParameter("image", paramFile), new HttpParameter("tile", paramBoolean) }));
  }
  
  public User updateProfileBackgroundImage(InputStream paramInputStream, boolean paramBoolean)
  {
    return this.factory.createUser(post(this.conf.getRestBaseURL() + "account/update_profile_background_image.json", new HttpParameter[] { new HttpParameter("image", "image", paramInputStream), new HttpParameter("tile", paramBoolean) }));
  }
  
  public void updateProfileBanner(File paramFile)
  {
    checkFileValidity(paramFile);
    post(this.conf.getRestBaseURL() + "account/update_profile_banner.json", new HttpParameter[] { new HttpParameter("banner", paramFile) });
  }
  
  public void updateProfileBanner(InputStream paramInputStream)
  {
    post(this.conf.getRestBaseURL() + "account/update_profile_banner.json", new HttpParameter[] { new HttpParameter("banner", "banner", paramInputStream) });
  }
  
  public User updateProfileColors(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    ArrayList localArrayList = new ArrayList(6);
    addParameterToList(localArrayList, "profile_background_color", paramString1);
    addParameterToList(localArrayList, "profile_text_color", paramString2);
    addParameterToList(localArrayList, "profile_link_color", paramString3);
    addParameterToList(localArrayList, "profile_sidebar_fill_color", paramString4);
    addParameterToList(localArrayList, "profile_sidebar_border_color", paramString5);
    return this.factory.createUser(post(this.conf.getRestBaseURL() + "account/update_profile_colors.json", (HttpParameter[])localArrayList.toArray(new HttpParameter[localArrayList.size()])));
  }
  
  public User updateProfileImage(File paramFile)
  {
    checkFileValidity(paramFile);
    return this.factory.createUser(post(this.conf.getRestBaseURL() + "account/update_profile_image.json", new HttpParameter[] { new HttpParameter("image", paramFile) }));
  }
  
  public User updateProfileImage(InputStream paramInputStream)
  {
    return this.factory.createUser(post(this.conf.getRestBaseURL() + "account/update_profile_image.json", new HttpParameter[] { new HttpParameter("image", "image", paramInputStream) }));
  }
  
  public Status updateStatus(String paramString)
  {
    return this.factory.createStatus(post(this.conf.getRestBaseURL() + "statuses/update.json", new HttpParameter[] { new HttpParameter("status", paramString) }));
  }
  
  public Status updateStatus(StatusUpdate paramStatusUpdate)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(this.conf.getRestBaseURL());
    if (paramStatusUpdate.isWithMedia()) {}
    for (String str = "statuses/update_with_media.json";; str = "statuses/update.json")
    {
      str = str;
      return this.factory.createStatus(post(str, paramStatusUpdate.asHttpParameterArray()));
    }
  }
  
  public UserList updateUserList(int paramInt, String paramString1, boolean paramBoolean, String paramString2)
  {
    return updateUserList(paramString1, paramBoolean, paramString2, new HttpParameter[] { new HttpParameter("list_id", paramInt) });
  }
  
  public UserList updateUserList(long paramLong, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    return updateUserList(paramString2, paramBoolean, paramString3, new HttpParameter[] { new HttpParameter("owner_id", paramLong), new HttpParameter("slug", paramString1) });
  }
  
  public UserList updateUserList(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    return updateUserList(paramString3, paramBoolean, paramString4, new HttpParameter[] { new HttpParameter("owner_screen_name", paramString1), new HttpParameter("slug", paramString2) });
  }
  
  public UsersResources users()
  {
    return this;
  }
  
  public User verifyCredentials()
  {
    return super.fillInIDAndScreenName();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/TwitterImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */