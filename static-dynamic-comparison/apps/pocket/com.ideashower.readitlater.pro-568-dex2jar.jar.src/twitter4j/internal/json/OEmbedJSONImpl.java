package twitter4j.internal.json;

import java.io.Serializable;
import twitter4j.OEmbed;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

public class OEmbedJSONImpl
  extends TwitterResponseImpl
  implements Serializable, OEmbed
{
  private static final long serialVersionUID = -675438169712979958L;
  private String authorName;
  private String authorURL;
  private long cacheAge;
  private String html;
  private String url;
  private String version;
  private int width;
  
  OEmbedJSONImpl(HttpResponse paramHttpResponse, Configuration paramConfiguration)
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
  
  OEmbedJSONImpl(JSONObject paramJSONObject)
  {
    init(paramJSONObject);
  }
  
  private void init(JSONObject paramJSONObject)
  {
    try
    {
      this.html = paramJSONObject.getString("html");
      this.authorName = paramJSONObject.getString("author_name");
      this.url = paramJSONObject.getString("url");
      this.version = paramJSONObject.getString("version");
      this.cacheAge = paramJSONObject.getLong("cache_age");
      this.authorURL = paramJSONObject.getString("author_url");
      this.width = paramJSONObject.getInt("width");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      throw new TwitterException(paramJSONObject);
    }
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
      paramObject = (OEmbedJSONImpl)paramObject;
      if (this.cacheAge != ((OEmbedJSONImpl)paramObject).cacheAge) {
        return false;
      }
      if (this.width != ((OEmbedJSONImpl)paramObject).width) {
        return false;
      }
      if (this.authorName != null)
      {
        if (this.authorName.equals(((OEmbedJSONImpl)paramObject).authorName)) {}
      }
      else {
        while (((OEmbedJSONImpl)paramObject).authorName != null) {
          return false;
        }
      }
      if (this.authorURL != null)
      {
        if (this.authorURL.equals(((OEmbedJSONImpl)paramObject).authorURL)) {}
      }
      else {
        while (((OEmbedJSONImpl)paramObject).authorURL != null) {
          return false;
        }
      }
      if (this.html != null)
      {
        if (this.html.equals(((OEmbedJSONImpl)paramObject).html)) {}
      }
      else {
        while (((OEmbedJSONImpl)paramObject).html != null) {
          return false;
        }
      }
      if (this.url != null)
      {
        if (this.url.equals(((OEmbedJSONImpl)paramObject).url)) {}
      }
      else {
        while (((OEmbedJSONImpl)paramObject).url != null) {
          return false;
        }
      }
      if (this.version == null) {
        break;
      }
    } while (this.version.equals(((OEmbedJSONImpl)paramObject).version));
    for (;;)
    {
      return false;
      if (((OEmbedJSONImpl)paramObject).version == null) {
        break;
      }
    }
  }
  
  public String getAuthorName()
  {
    return this.authorName;
  }
  
  public String getAuthorURL()
  {
    return this.authorURL;
  }
  
  public long getCacheAge()
  {
    return this.cacheAge;
  }
  
  public String getHtml()
  {
    return this.html;
  }
  
  public String getURL()
  {
    return this.url;
  }
  
  public String getVersion()
  {
    return this.version;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public int hashCode()
  {
    int n = 0;
    int i;
    int j;
    label33:
    int k;
    if (this.html != null)
    {
      i = this.html.hashCode();
      if (this.authorName == null) {
        break label138;
      }
      j = this.authorName.hashCode();
      if (this.url == null) {
        break label143;
      }
      k = this.url.hashCode();
      label48:
      if (this.version == null) {
        break label148;
      }
    }
    label138:
    label143:
    label148:
    for (int m = this.version.hashCode();; m = 0)
    {
      int i1 = (int)(this.cacheAge ^ this.cacheAge >>> 32);
      if (this.authorURL != null) {
        n = this.authorURL.hashCode();
      }
      return (((m + (k + (j + i * 31) * 31) * 31) * 31 + i1) * 31 + n) * 31 + this.width;
      i = 0;
      break;
      j = 0;
      break label33;
      k = 0;
      break label48;
    }
  }
  
  public String toString()
  {
    return "OEmbedJSONImpl{html='" + this.html + '\'' + ", authorName='" + this.authorName + '\'' + ", url='" + this.url + '\'' + ", version='" + this.version + '\'' + ", cacheAge=" + this.cacheAge + ", authorURL='" + this.authorURL + '\'' + ", width=" + this.width + '}';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/json/OEmbedJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */