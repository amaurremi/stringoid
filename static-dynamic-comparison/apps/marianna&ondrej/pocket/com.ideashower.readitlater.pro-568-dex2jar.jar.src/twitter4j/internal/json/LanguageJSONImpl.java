package twitter4j.internal.json;

import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.api.HelpResources.Language;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.org.json.JSONArray;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;

public class LanguageJSONImpl
  implements HelpResources.Language
{
  private String code;
  private String name;
  private String status;
  
  LanguageJSONImpl(JSONObject paramJSONObject)
  {
    init(paramJSONObject);
  }
  
  static ResponseList createLanguageList(HttpResponse paramHttpResponse, Configuration paramConfiguration)
  {
    return createLanguageList(paramHttpResponse.asJSONArray(), paramHttpResponse, paramConfiguration);
  }
  
  static ResponseList createLanguageList(JSONArray paramJSONArray, HttpResponse paramHttpResponse, Configuration paramConfiguration)
  {
    if (paramConfiguration.isJSONStoreEnabled()) {
      DataObjectFactoryUtil.clearThreadLocalMap();
    }
    for (;;)
    {
      int i;
      try
      {
        int j = paramJSONArray.length();
        paramHttpResponse = new ResponseListImpl(j, paramHttpResponse);
        i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          LanguageJSONImpl localLanguageJSONImpl = new LanguageJSONImpl(localJSONObject);
          paramHttpResponse.add(localLanguageJSONImpl);
          if (paramConfiguration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.registerJSONObject(localLanguageJSONImpl, localJSONObject);
          }
        }
        else
        {
          if (paramConfiguration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.registerJSONObject(paramHttpResponse, paramJSONArray);
          }
          return paramHttpResponse;
        }
      }
      catch (JSONException paramJSONArray)
      {
        throw new TwitterException(paramJSONArray);
      }
      catch (TwitterException paramJSONArray)
      {
        throw paramJSONArray;
      }
      i += 1;
    }
  }
  
  private void init(JSONObject paramJSONObject)
  {
    try
    {
      this.name = paramJSONObject.getString("name");
      this.code = paramJSONObject.getString("code");
      this.status = paramJSONObject.getString("status");
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new TwitterException(localJSONException.getMessage() + ":" + paramJSONObject.toString(), localJSONException);
    }
  }
  
  public String getCode()
  {
    return this.code;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getStatus()
  {
    return this.status;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/json/LanguageJSONImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */