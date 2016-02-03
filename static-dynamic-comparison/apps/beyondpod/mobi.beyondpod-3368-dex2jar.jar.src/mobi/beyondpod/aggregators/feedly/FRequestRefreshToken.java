package mobi.beyondpod.aggregators.feedly;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mobi.beyondpod.aggregators.AggregatorLoginHelper.AuthenticationException;
import mobi.beyondpod.aggregators.RequestBase;
import mobi.beyondpod.downloadengine.BeyondPodHttpClient;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class FRequestRefreshToken
  extends RequestBase
{
  private static final String TAG = FRequestRefreshToken.class.getSimpleName();
  private String _RefreshToken;
  
  public FRequestRefreshToken(String paramString)
    throws Exception
  {
    if (StringUtils.IsNullOrEmpty(paramString)) {
      throw new Exception("Refresh token is required!");
    }
    this._RefreshToken = paramString;
    this._RetryCount = 1;
  }
  
  public void OnFail(Exception paramException)
  {
    if ((paramException != null) && ((paramException instanceof AggregatorLoginHelper.AuthenticationException))) {
      this._RetryCount = 0;
    }
    super.OnFail(paramException);
  }
  
  public void OnSuccess(String paramString)
  {
    this._RequestStatus = 2;
    if (!StringUtils.IsNullOrEmpty(paramString)) {}
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("access_token");
      String str = ((JSONObject)localObject).getString("id");
      int i = ((JSONObject)localObject).getInt("expires_in");
      if (!StringUtils.IsNullOrEmpty(paramString))
      {
        localObject = new Date();
        ((Date)localObject).setTime(((Date)localObject).getTime() + i * 1000);
        Configuration.setOAuthAccessTokenExpiration((Date)localObject);
        Configuration.setOAuthAccessToken(paramString);
        Configuration.setOAuthUser(str);
        this._RequestStatus = 1;
      }
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public HttpUriRequest Request()
  {
    HttpPost localHttpPost = new HttpPost(Feedly.TokenUri);
    BeyondPodHttpClient.SetAcceptTo("*/*", localHttpPost);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("refresh_token", this._RefreshToken));
    localArrayList.add(new BasicNameValuePair("client_id", Feedly.ClientID));
    localArrayList.add(new BasicNameValuePair("client_secret", Feedly.ClientSTP));
    localArrayList.add(new BasicNameValuePair("grant_type", "refresh_token"));
    if (localArrayList != null) {}
    try
    {
      localHttpPost.setEntity(new UrlEncodedFormEntity(localArrayList, "UTF-8"));
      return localHttpPost;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      CoreHelper.LogException(TAG, "Failed to create request", localUnsupportedEncodingException);
    }
    return null;
  }
  
  public String toString()
  {
    return "Refresh Feedly token";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/aggregators/feedly/FRequestRefreshToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */