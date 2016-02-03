package twitter4j.internal.json;

import java.util.Arrays;
import twitter4j.IDs;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

final class IDsJSONImpl
  extends TwitterResponseImpl
  implements IDs
{
  private static final long serialVersionUID = -6585026560164704953L;
  private long[] ids;
  private long nextCursor = -1L;
  private long previousCursor = -1L;
  
  IDsJSONImpl(String paramString)
  {
    init(paramString);
  }
  
  IDsJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration)
  {
    super(paramHttpResponse);
    paramHttpResponse = paramHttpResponse.asString();
    init(paramHttpResponse);
    if (paramConfiguration.isJSONStoreEnabled())
    {
      DataObjectFactoryUtil.clearThreadLocalMap();
      DataObjectFactoryUtil.registerJSONObject(this, paramHttpResponse);
    }
  }
  
  private void init(String paramString)
  {
    int j = 0;
    int i = 0;
    try
    {
      if (!paramString.startsWith("{")) {
        break label136;
      }
      paramString = new JSONObject(paramString);
      JSONArray localJSONArray = paramString.getJSONArray("ids");
      this.ids = new long[localJSONArray.length()];
      for (;;)
      {
        j = localJSONArray.length();
        if (i < j) {
          try
          {
            this.ids[i] = Long.parseLong(localJSONArray.getString(i));
            i += 1;
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            throw new TwitterException("Twitter API returned malformed response: " + paramString, localNumberFormatException1);
          }
        }
      }
      this.previousCursor = z_T4JInternalParseUtil.getLong("previous_cursor", paramString);
    }
    catch (JSONException paramString)
    {
      throw new TwitterException(paramString);
    }
    this.nextCursor = z_T4JInternalParseUtil.getLong("next_cursor", paramString);
    return;
    label136:
    paramString = new JSONArray(paramString);
    this.ids = new long[paramString.length()];
    i = j;
    for (;;)
    {
      j = paramString.length();
      if (i < j) {
        try
        {
          this.ids[i] = Long.parseLong(paramString.getString(i));
          i += 1;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          throw new TwitterException("Twitter API returned malformed response: " + paramString, localNumberFormatException2);
        }
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof IDs)) {
        return false;
      }
      paramObject = (IDs)paramObject;
    } while (Arrays.equals(this.ids, ((IDs)paramObject).getIDs()));
    return false;
  }
  
  public long[] getIDs()
  {
    return this.ids;
  }
  
  public long getNextCursor()
  {
    return this.nextCursor;
  }
  
  public long getPreviousCursor()
  {
    return this.previousCursor;
  }
  
  public boolean hasNext()
  {
    return 0L != this.nextCursor;
  }
  
  public boolean hasPrevious()
  {
    return 0L != this.previousCursor;
  }
  
  public int hashCode()
  {
    if (this.ids != null) {
      return Arrays.hashCode(this.ids);
    }
    return 0;
  }
  
  public String toString()
  {
    return "IDsJSONImpl{ids=" + Arrays.toString(this.ids) + ", previousCursor=" + this.previousCursor + ", nextCursor=" + this.nextCursor + '}';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/json/IDsJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */