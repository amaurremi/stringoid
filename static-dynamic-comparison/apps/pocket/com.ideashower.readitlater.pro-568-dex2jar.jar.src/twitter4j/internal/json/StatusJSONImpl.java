package twitter4j.internal.json;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import twitter4j.GeoLocation;
import twitter4j.HashtagEntity;
import twitter4j.MediaEntity;
import twitter4j.Place;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.SymbolEntity;
import twitter4j.TwitterException;
import twitter4j.URLEntity;
import twitter4j.User;
import twitter4j.UserMentionEntity;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.logging.Logger;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

final class StatusJSONImpl
  extends TwitterResponseImpl
  implements Serializable, Status
{
  private static final Logger logger = Logger.getLogger(StatusJSONImpl.class);
  private static final long serialVersionUID = 7548618898682727465L;
  private long[] contributorsIDs;
  private Date createdAt;
  private long currentUserRetweetId = -1L;
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
  private String isoLanguageCode;
  private MediaEntity[] mediaEntities;
  private Place place = null;
  private long retweetCount;
  private Status retweetedStatus;
  private String source;
  private SymbolEntity[] symbolEntities;
  private String text;
  private URLEntity[] urlEntities;
  private User user = null;
  private UserMentionEntity[] userMentionEntities;
  
  StatusJSONImpl() {}
  
  StatusJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration)
  {
    super(paramHttpResponse);
    paramHttpResponse = paramHttpResponse.asJSONObject();
    init(paramHttpResponse);
    if (paramConfiguration.isJSONStoreEnabled())
    {
      DataObjectFactoryUtil.clearThreadLocalMap();
      DataObjectFactoryUtil.registerJSONObject(this, paramHttpResponse);
    }
  }
  
  StatusJSONImpl(JSONObject paramJSONObject)
  {
    init(paramJSONObject);
  }
  
  StatusJSONImpl(JSONObject paramJSONObject, Configuration paramConfiguration)
  {
    init(paramJSONObject);
    if (paramConfiguration.isJSONStoreEnabled()) {
      DataObjectFactoryUtil.registerJSONObject(this, paramJSONObject);
    }
  }
  
  static ResponseList createStatusList(HttpResponse paramHttpResponse, Configuration paramConfiguration)
  {
    try
    {
      if (paramConfiguration.isJSONStoreEnabled()) {
        DataObjectFactoryUtil.clearThreadLocalMap();
      }
      JSONArray localJSONArray = paramHttpResponse.asJSONArray();
      int j = localJSONArray.length();
      paramHttpResponse = new ResponseListImpl(j, paramHttpResponse);
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        StatusJSONImpl localStatusJSONImpl = new StatusJSONImpl(localJSONObject);
        if (paramConfiguration.isJSONStoreEnabled()) {
          DataObjectFactoryUtil.registerJSONObject(localStatusJSONImpl, localJSONObject);
        }
        paramHttpResponse.add(localStatusJSONImpl);
        i += 1;
      }
      if (paramConfiguration.isJSONStoreEnabled()) {
        DataObjectFactoryUtil.registerJSONObject(paramHttpResponse, localJSONArray);
      }
      return paramHttpResponse;
    }
    catch (JSONException paramHttpResponse)
    {
      throw new TwitterException(paramHttpResponse);
    }
  }
  
  private void init(JSONObject paramJSONObject)
  {
    int j = 0;
    this.id = z_T4JInternalParseUtil.getLong("id", paramJSONObject);
    this.source = z_T4JInternalParseUtil.getUnescapedString("source", paramJSONObject);
    this.createdAt = z_T4JInternalParseUtil.getDate("created_at", paramJSONObject);
    this.isTruncated = z_T4JInternalParseUtil.getBoolean("truncated", paramJSONObject);
    this.inReplyToStatusId = z_T4JInternalParseUtil.getLong("in_reply_to_status_id", paramJSONObject);
    this.inReplyToUserId = z_T4JInternalParseUtil.getLong("in_reply_to_user_id", paramJSONObject);
    this.isFavorited = z_T4JInternalParseUtil.getBoolean("favorited", paramJSONObject);
    this.isRetweeted = z_T4JInternalParseUtil.getBoolean("retweeted", paramJSONObject);
    this.inReplyToScreenName = z_T4JInternalParseUtil.getUnescapedString("in_reply_to_screen_name", paramJSONObject);
    this.retweetCount = z_T4JInternalParseUtil.getLong("retweet_count", paramJSONObject);
    this.favoriteCount = z_T4JInternalParseUtil.getInt("favorite_count", paramJSONObject);
    this.isPossiblySensitive = z_T4JInternalParseUtil.getBoolean("possibly_sensitive", paramJSONObject);
    try
    {
      if (!paramJSONObject.isNull("user")) {
        this.user = new UserJSONImpl(paramJSONObject.getJSONObject("user"));
      }
      this.geoLocation = z_T4JInternalJSONImplFactory.createGeoLocation(paramJSONObject);
      if (!paramJSONObject.isNull("place")) {
        this.place = new PlaceJSONImpl(paramJSONObject.getJSONObject("place"));
      }
      if (!paramJSONObject.isNull("retweeted_status")) {
        this.retweetedStatus = new StatusJSONImpl(paramJSONObject.getJSONObject("retweeted_status"));
      }
      int i;
      if (!paramJSONObject.isNull("contributors"))
      {
        localObject = paramJSONObject.getJSONArray("contributors");
        this.contributorsIDs = new long[((JSONArray)localObject).length()];
        i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          this.contributorsIDs[i] = Long.parseLong(((JSONArray)localObject).getString(i));
          i += 1;
        }
      }
      this.contributorsIDs = new long[0];
      if (!paramJSONObject.isNull("entities"))
      {
        localObject = paramJSONObject.getJSONObject("entities");
        JSONArray localJSONArray;
        int k;
        if (!((JSONObject)localObject).isNull("user_mentions"))
        {
          localJSONArray = ((JSONObject)localObject).getJSONArray("user_mentions");
          k = localJSONArray.length();
          this.userMentionEntities = new UserMentionEntity[k];
          i = 0;
          while (i < k)
          {
            this.userMentionEntities[i] = new UserMentionEntityJSONImpl(localJSONArray.getJSONObject(i));
            i += 1;
          }
        }
        if (!((JSONObject)localObject).isNull("urls"))
        {
          localJSONArray = ((JSONObject)localObject).getJSONArray("urls");
          k = localJSONArray.length();
          this.urlEntities = new URLEntity[k];
          i = 0;
          while (i < k)
          {
            this.urlEntities[i] = new URLEntityJSONImpl(localJSONArray.getJSONObject(i));
            i += 1;
          }
        }
        if (!((JSONObject)localObject).isNull("hashtags"))
        {
          localJSONArray = ((JSONObject)localObject).getJSONArray("hashtags");
          k = localJSONArray.length();
          this.hashtagEntities = new HashtagEntity[k];
          i = 0;
          while (i < k)
          {
            this.hashtagEntities[i] = new HashtagEntityJSONImpl(localJSONArray.getJSONObject(i));
            i += 1;
          }
        }
        if (!((JSONObject)localObject).isNull("symbols"))
        {
          localJSONArray = ((JSONObject)localObject).getJSONArray("symbols");
          k = localJSONArray.length();
          this.symbolEntities = new SymbolEntity[k];
          i = 0;
          while (i < k)
          {
            this.symbolEntities[i] = new HashtagEntityJSONImpl(localJSONArray.getJSONObject(i));
            i += 1;
          }
        }
        if (!((JSONObject)localObject).isNull("media"))
        {
          localObject = ((JSONObject)localObject).getJSONArray("media");
          k = ((JSONArray)localObject).length();
          this.mediaEntities = new MediaEntity[k];
          i = j;
          while (i < k)
          {
            this.mediaEntities[i] = new MediaEntityJSONImpl(((JSONArray)localObject).getJSONObject(i));
            i += 1;
          }
        }
      }
      this.isoLanguageCode = z_T4JInternalParseUtil.getRawString("lang", paramJSONObject);
      if (this.userMentionEntities == null)
      {
        localObject = new UserMentionEntity[0];
        this.userMentionEntities = ((UserMentionEntity[])localObject);
        if (this.urlEntities != null) {
          break label822;
        }
        localObject = new URLEntity[0];
        label693:
        this.urlEntities = ((URLEntity[])localObject);
        if (this.hashtagEntities != null) {
          break label831;
        }
        localObject = new HashtagEntity[0];
        label712:
        this.hashtagEntities = ((HashtagEntity[])localObject);
        if (this.symbolEntities != null) {
          break label840;
        }
        localObject = new SymbolEntity[0];
        label731:
        this.symbolEntities = ((SymbolEntity[])localObject);
        if (this.mediaEntities != null) {
          break label849;
        }
      }
      label822:
      label831:
      label840:
      label849:
      for (Object localObject = new MediaEntity[0];; localObject = this.mediaEntities)
      {
        this.mediaEntities = ((MediaEntity[])localObject);
        this.text = HTMLEntity.unescapeAndSlideEntityIncdices(paramJSONObject.getString("text"), this.userMentionEntities, this.urlEntities, this.hashtagEntities, this.mediaEntities);
        if (paramJSONObject.isNull("current_user_retweet")) {
          return;
        }
        this.currentUserRetweetId = paramJSONObject.getJSONObject("current_user_retweet").getLong("id");
        return;
        localObject = this.userMentionEntities;
        break;
        localObject = this.urlEntities;
        break label693;
        localObject = this.hashtagEntities;
        break label712;
        localObject = this.symbolEntities;
        break label731;
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      throw new TwitterException(paramJSONObject);
    }
  }
  
  public int compareTo(Status paramStatus)
  {
    long l = this.id - paramStatus.getId();
    if (l < -2147483648L) {
      return Integer.MIN_VALUE;
    }
    if (l > 2147483647L) {
      return Integer.MAX_VALUE;
    }
    return (int)l;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramObject == null) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this == paramObject);
      if (!(paramObject instanceof Status)) {
        break;
      }
      bool1 = bool2;
    } while (((Status)paramObject).getId() == this.id);
    return false;
  }
  
  public long[] getContributors()
  {
    return this.contributorsIDs;
  }
  
  public Date getCreatedAt()
  {
    return this.createdAt;
  }
  
  public long getCurrentUserRetweetId()
  {
    return this.currentUserRetweetId;
  }
  
  public int getFavoriteCount()
  {
    return this.favoriteCount;
  }
  
  public GeoLocation getGeoLocation()
  {
    return this.geoLocation;
  }
  
  public HashtagEntity[] getHashtagEntities()
  {
    return this.hashtagEntities;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public String getInReplyToScreenName()
  {
    return this.inReplyToScreenName;
  }
  
  public long getInReplyToStatusId()
  {
    return this.inReplyToStatusId;
  }
  
  public long getInReplyToUserId()
  {
    return this.inReplyToUserId;
  }
  
  public String getIsoLanguageCode()
  {
    return this.isoLanguageCode;
  }
  
  public MediaEntity[] getMediaEntities()
  {
    return this.mediaEntities;
  }
  
  public Place getPlace()
  {
    return this.place;
  }
  
  public int getRetweetCount()
  {
    return (int)this.retweetCount;
  }
  
  public Status getRetweetedStatus()
  {
    return this.retweetedStatus;
  }
  
  public String getSource()
  {
    return this.source;
  }
  
  public SymbolEntity[] getSymbolEntities()
  {
    return this.symbolEntities;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public URLEntity[] getURLEntities()
  {
    return this.urlEntities;
  }
  
  public User getUser()
  {
    return this.user;
  }
  
  public UserMentionEntity[] getUserMentionEntities()
  {
    return this.userMentionEntities;
  }
  
  public int hashCode()
  {
    return (int)this.id;
  }
  
  public boolean isFavorited()
  {
    return this.isFavorited;
  }
  
  public boolean isPossiblySensitive()
  {
    return this.isPossiblySensitive;
  }
  
  public boolean isRetweet()
  {
    return this.retweetedStatus != null;
  }
  
  public boolean isRetweeted()
  {
    return this.isRetweeted;
  }
  
  public boolean isRetweetedByMe()
  {
    return this.currentUserRetweetId != -1L;
  }
  
  public boolean isTruncated()
  {
    return this.isTruncated;
  }
  
  public String toString()
  {
    Object localObject2 = null;
    StringBuilder localStringBuilder = new StringBuilder().append("StatusJSONImpl{createdAt=").append(this.createdAt).append(", id=").append(this.id).append(", text='").append(this.text).append('\'').append(", source='").append(this.source).append('\'').append(", isTruncated=").append(this.isTruncated).append(", inReplyToStatusId=").append(this.inReplyToStatusId).append(", inReplyToUserId=").append(this.inReplyToUserId).append(", isFavorited=").append(this.isFavorited).append(", isRetweeted=").append(this.isRetweeted).append(", favoriteCount=").append(this.favoriteCount).append(", inReplyToScreenName='").append(this.inReplyToScreenName).append('\'').append(", geoLocation=").append(this.geoLocation).append(", place=").append(this.place).append(", retweetCount=").append(this.retweetCount).append(", isPossiblySensitive=").append(this.isPossiblySensitive).append(", isoLanguageCode=").append(this.isoLanguageCode).append(", contributorsIDs=").append(this.contributorsIDs).append(", retweetedStatus=").append(this.retweetedStatus).append(", userMentionEntities=");
    if (this.userMentionEntities == null)
    {
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append(", urlEntities=");
      if (this.urlEntities != null) {
        break label388;
      }
      localObject1 = null;
      label295:
      localStringBuilder = localStringBuilder.append(localObject1).append(", hashtagEntities=");
      if (this.hashtagEntities != null) {
        break label399;
      }
      localObject1 = null;
      label316:
      localStringBuilder = localStringBuilder.append(localObject1).append(", mediaEntities=");
      if (this.mediaEntities != null) {
        break label410;
      }
    }
    label388:
    label399:
    label410:
    for (Object localObject1 = localObject2;; localObject1 = Arrays.asList(this.mediaEntities))
    {
      return localObject1 + ", currentUserRetweetId=" + this.currentUserRetweetId + ", user=" + this.user + '}';
      localObject1 = Arrays.asList(this.userMentionEntities);
      break;
      localObject1 = Arrays.asList(this.urlEntities);
      break label295;
      localObject1 = Arrays.asList(this.hashtagEntities);
      break label316;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/json/StatusJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */