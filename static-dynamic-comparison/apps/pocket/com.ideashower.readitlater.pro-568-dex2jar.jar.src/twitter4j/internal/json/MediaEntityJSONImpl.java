package twitter4j.internal.json;

import java.util.HashMap;
import java.util.Map;
import twitter4j.MediaEntity;
import twitter4j.MediaEntity.Size;
import twitter4j.TwitterException;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

public class MediaEntityJSONImpl
  extends EntityIndex
  implements MediaEntity
{
  private static final long serialVersionUID = 224487082931268487L;
  private String displayURL;
  private String expandedURL;
  private long id;
  private String mediaURL;
  private String mediaURLHttps;
  private Map sizes;
  private String type;
  private String url;
  
  MediaEntityJSONImpl() {}
  
  MediaEntityJSONImpl(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = paramJSONObject.getJSONArray("indices");
      setStart(((JSONArray)localObject).getInt(0));
      setEnd(((JSONArray)localObject).getInt(1));
      this.id = z_T4JInternalParseUtil.getLong("id", paramJSONObject);
      this.url = paramJSONObject.getString("url");
      this.expandedURL = paramJSONObject.getString("expanded_url");
      this.mediaURL = paramJSONObject.getString("media_url");
      this.mediaURLHttps = paramJSONObject.getString("media_url_https");
      this.displayURL = paramJSONObject.getString("display_url");
      localObject = paramJSONObject.getJSONObject("sizes");
      this.sizes = new HashMap(4);
      addMediaEntitySizeIfNotNull(this.sizes, (JSONObject)localObject, MediaEntity.Size.LARGE, "large");
      addMediaEntitySizeIfNotNull(this.sizes, (JSONObject)localObject, MediaEntity.Size.MEDIUM, "medium");
      addMediaEntitySizeIfNotNull(this.sizes, (JSONObject)localObject, MediaEntity.Size.SMALL, "small");
      addMediaEntitySizeIfNotNull(this.sizes, (JSONObject)localObject, MediaEntity.Size.THUMB, "thumb");
      if (!paramJSONObject.isNull("type")) {
        this.type = paramJSONObject.getString("type");
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      throw new TwitterException(paramJSONObject);
    }
  }
  
  private void addMediaEntitySizeIfNotNull(Map paramMap, JSONObject paramJSONObject, Integer paramInteger, String paramString)
  {
    if (!paramJSONObject.isNull(paramString)) {
      paramMap.put(paramInteger, new MediaEntityJSONImpl.Size(paramJSONObject.getJSONObject(paramString)));
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof MediaEntityJSONImpl)) {
        return false;
      }
      paramObject = (MediaEntityJSONImpl)paramObject;
    } while (this.id == ((MediaEntityJSONImpl)paramObject).id);
    return false;
  }
  
  public String getDisplayURL()
  {
    return this.displayURL;
  }
  
  public int getEnd()
  {
    return super.getEnd();
  }
  
  public String getExpandedURL()
  {
    return this.expandedURL;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public String getMediaURL()
  {
    return this.mediaURL;
  }
  
  public String getMediaURLHttps()
  {
    return this.mediaURLHttps;
  }
  
  public Map getSizes()
  {
    return this.sizes;
  }
  
  public int getStart()
  {
    return super.getStart();
  }
  
  public String getText()
  {
    return this.url;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public String getURL()
  {
    return this.url;
  }
  
  public int hashCode()
  {
    return (int)(this.id ^ this.id >>> 32);
  }
  
  public String toString()
  {
    return "MediaEntityJSONImpl{id=" + this.id + ", url=" + this.url + ", mediaURL=" + this.mediaURL + ", mediaURLHttps=" + this.mediaURLHttps + ", expandedURL=" + this.expandedURL + ", displayURL='" + this.displayURL + '\'' + ", sizes=" + this.sizes + ", type=" + this.type + '}';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/json/MediaEntityJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */