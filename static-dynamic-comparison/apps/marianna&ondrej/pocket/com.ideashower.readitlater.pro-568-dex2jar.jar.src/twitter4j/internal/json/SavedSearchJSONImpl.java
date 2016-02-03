package twitter4j.internal.json;

import java.util.Date;
import twitter4j.ResponseList;
import twitter4j.SavedSearch;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

final class SavedSearchJSONImpl
  extends TwitterResponseImpl
  implements SavedSearch
{
  private static final long serialVersionUID = 3083819860391598212L;
  private Date createdAt;
  private int id;
  private String name;
  private int position;
  private String query;
  
  SavedSearchJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration)
  {
    super(paramHttpResponse);
    if (paramConfiguration.isJSONStoreEnabled()) {
      DataObjectFactoryUtil.clearThreadLocalMap();
    }
    paramHttpResponse = paramHttpResponse.asJSONObject();
    init(paramHttpResponse);
    if (paramConfiguration.isJSONStoreEnabled()) {
      DataObjectFactoryUtil.registerJSONObject(this, paramHttpResponse);
    }
  }
  
  SavedSearchJSONImpl(JSONObject paramJSONObject)
  {
    init(paramJSONObject);
  }
  
  static ResponseList createSavedSearchList(HttpResponse paramHttpResponse, Configuration paramConfiguration)
  {
    if (paramConfiguration.isJSONStoreEnabled()) {
      DataObjectFactoryUtil.clearThreadLocalMap();
    }
    JSONArray localJSONArray = paramHttpResponse.asJSONArray();
    for (;;)
    {
      int i;
      try
      {
        ResponseListImpl localResponseListImpl = new ResponseListImpl(localJSONArray.length(), paramHttpResponse);
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          SavedSearchJSONImpl localSavedSearchJSONImpl = new SavedSearchJSONImpl(localJSONObject);
          localResponseListImpl.add(localSavedSearchJSONImpl);
          if (paramConfiguration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.registerJSONObject(localSavedSearchJSONImpl, localJSONObject);
          }
        }
        else
        {
          if (paramConfiguration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.registerJSONObject(localResponseListImpl, localJSONArray);
          }
          return localResponseListImpl;
        }
      }
      catch (JSONException paramConfiguration)
      {
        throw new TwitterException(paramConfiguration.getMessage() + ":" + paramHttpResponse.asString(), paramConfiguration);
      }
      i += 1;
    }
  }
  
  private void init(JSONObject paramJSONObject)
  {
    this.createdAt = z_T4JInternalParseUtil.getDate("created_at", paramJSONObject, "EEE MMM dd HH:mm:ss z yyyy");
    this.query = z_T4JInternalParseUtil.getUnescapedString("query", paramJSONObject);
    this.position = z_T4JInternalParseUtil.getInt("position", paramJSONObject);
    this.name = z_T4JInternalParseUtil.getUnescapedString("name", paramJSONObject);
    this.id = z_T4JInternalParseUtil.getInt("id", paramJSONObject);
  }
  
  public int compareTo(SavedSearch paramSavedSearch)
  {
    return this.id - paramSavedSearch.getId();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof SavedSearch)) {
        return false;
      }
      paramObject = (SavedSearch)paramObject;
    } while (this.id == ((SavedSearch)paramObject).getId());
    return false;
  }
  
  public Date getCreatedAt()
  {
    return this.createdAt;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public String getQuery()
  {
    return this.query;
  }
  
  public int hashCode()
  {
    return (((this.createdAt.hashCode() * 31 + this.query.hashCode()) * 31 + this.position) * 31 + this.name.hashCode()) * 31 + this.id;
  }
  
  public String toString()
  {
    return "SavedSearchJSONImpl{createdAt=" + this.createdAt + ", query='" + this.query + '\'' + ", position=" + this.position + ", name='" + this.name + '\'' + ", id=" + this.id + '}';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/json/SavedSearchJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */