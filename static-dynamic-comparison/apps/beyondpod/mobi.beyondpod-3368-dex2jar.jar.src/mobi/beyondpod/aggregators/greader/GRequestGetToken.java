package mobi.beyondpod.aggregators.greader;

import mobi.beyondpod.aggregators.AggregatorLoginHelper;
import mobi.beyondpod.aggregators.AggregatorLoginHelper.AuthenticationException;
import mobi.beyondpod.aggregators.RequestBase;
import mobi.beyondpod.downloadengine.BeyondPodHttpClient;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

public class GRequestGetToken
  extends RequestBase
{
  private static final String TAG = GRequestGetToken.class.getSimpleName();
  
  public GRequestGetToken()
  {
    this._RetryCount = 1;
  }
  
  public void OnFail(Exception paramException)
  {
    super.OnFail(paramException);
    CoreHelper.WriteLogEntry(TAG, "--- Failed to get authentication token from Google Reader! Reason: " + CoreHelper.ExtractExceptionMessages(paramException) + ", Type:" + paramException.getClass().getSimpleName());
  }
  
  public void OnSuccess(String paramString)
  {
    if (!StringUtils.IsNullOrEmpty(paramString))
    {
      GoogleReader.AuthenticationToken = paramString;
      this._RequestStatus = 1;
      return;
    }
    this._RequestStatus = 2;
  }
  
  public HttpUriRequest Request()
  {
    if (!AggregatorLoginHelper.IsLoggedIn())
    {
      OnFail(new AggregatorLoginHelper.AuthenticationException());
      return null;
    }
    HttpGet localHttpGet = new HttpGet(GoogleReader.TokenUri);
    BeyondPodHttpClient.SetAcceptTo("*/*", localHttpGet);
    BeyondPodHttpClient.SetRequestCookie(Configuration.GReaderCookie(), localHttpGet);
    BeyondPodHttpClient.SetHeader(localHttpGet, AuthRequestHeader, AggregatorLoginHelper.BlockingGetAuthToken());
    return localHttpGet;
  }
  
  public String toString()
  {
    return "Get Authentication Token";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/aggregators/greader/GRequestGetToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */