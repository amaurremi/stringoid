package twitter4j.internal.json;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import twitter4j.RateLimitStatus;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

final class RateLimitStatusJSONImpl
  implements Serializable, RateLimitStatus
{
  private static final long serialVersionUID = 1625565652687304084L;
  private int limit;
  private int remaining;
  private int resetTimeInSeconds;
  private int secondsUntilReset;
  
  private RateLimitStatusJSONImpl(int paramInt1, int paramInt2, int paramInt3)
  {
    this.limit = paramInt1;
    this.remaining = paramInt2;
    this.resetTimeInSeconds = paramInt3;
    this.secondsUntilReset = ((int)((paramInt3 * 1000L - System.currentTimeMillis()) / 1000L));
  }
  
  RateLimitStatusJSONImpl(JSONObject paramJSONObject)
  {
    init(paramJSONObject);
  }
  
  static RateLimitStatus createFromResponseHeader(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse == null) {}
    int i;
    int j;
    do
    {
      String str;
      do
      {
        do
        {
          return null;
          str = paramHttpResponse.getResponseHeader("X-Rate-Limit-Limit");
        } while (str == null);
        i = Integer.parseInt(str);
        str = paramHttpResponse.getResponseHeader("X-Rate-Limit-Remaining");
      } while (str == null);
      j = Integer.parseInt(str);
      paramHttpResponse = paramHttpResponse.getResponseHeader("X-Rate-Limit-Reset");
    } while (paramHttpResponse == null);
    return new RateLimitStatusJSONImpl(i, j, (int)Long.parseLong(paramHttpResponse));
  }
  
  static Map createRateLimitStatuses(HttpResponse paramHttpResponse, Configuration paramConfiguration)
  {
    paramHttpResponse = paramHttpResponse.asJSONObject();
    Map localMap = createRateLimitStatuses(paramHttpResponse);
    if (paramConfiguration.isJSONStoreEnabled())
    {
      DataObjectFactoryUtil.clearThreadLocalMap();
      DataObjectFactoryUtil.registerJSONObject(localMap, paramHttpResponse);
    }
    return localMap;
  }
  
  static Map createRateLimitStatuses(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("resources");
      Iterator localIterator1 = paramJSONObject.keys();
      while (localIterator1.hasNext())
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject((String)localIterator1.next());
        Iterator localIterator2 = localJSONObject.keys();
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          localHashMap.put(str, new RateLimitStatusJSONImpl(localJSONObject.getJSONObject(str)));
        }
      }
      paramJSONObject = Collections.unmodifiableMap(localHashMap);
    }
    catch (JSONException paramJSONObject)
    {
      throw new TwitterException(paramJSONObject);
    }
    return paramJSONObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (RateLimitStatusJSONImpl)paramObject;
      if (this.limit != ((RateLimitStatusJSONImpl)paramObject).limit) {
        return false;
      }
      if (this.remaining != ((RateLimitStatusJSONImpl)paramObject).remaining) {
        return false;
      }
      if (this.resetTimeInSeconds != ((RateLimitStatusJSONImpl)paramObject).resetTimeInSeconds) {
        return false;
      }
    } while (this.secondsUntilReset == ((RateLimitStatusJSONImpl)paramObject).secondsUntilReset);
    return false;
  }
  
  public int getLimit()
  {
    return this.limit;
  }
  
  public int getRemaining()
  {
    return this.remaining;
  }
  
  public int getRemainingHits()
  {
    return getRemaining();
  }
  
  public int getResetTimeInSeconds()
  {
    return this.resetTimeInSeconds;
  }
  
  public int getSecondsUntilReset()
  {
    return this.secondsUntilReset;
  }
  
  public int hashCode()
  {
    return ((this.remaining * 31 + this.limit) * 31 + this.resetTimeInSeconds) * 31 + this.secondsUntilReset;
  }
  
  void init(JSONObject paramJSONObject)
  {
    this.limit = z_T4JInternalParseUtil.getInt("limit", paramJSONObject);
    this.remaining = z_T4JInternalParseUtil.getInt("remaining", paramJSONObject);
    this.resetTimeInSeconds = z_T4JInternalParseUtil.getInt("reset", paramJSONObject);
    this.secondsUntilReset = ((int)((this.resetTimeInSeconds * 1000L - System.currentTimeMillis()) / 1000L));
  }
  
  public String toString()
  {
    return "RateLimitStatusJSONImpl{remaining=" + this.remaining + ", limit=" + this.limit + ", resetTimeInSeconds=" + this.resetTimeInSeconds + ", secondsUntilReset=" + this.secondsUntilReset + '}';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/json/RateLimitStatusJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */