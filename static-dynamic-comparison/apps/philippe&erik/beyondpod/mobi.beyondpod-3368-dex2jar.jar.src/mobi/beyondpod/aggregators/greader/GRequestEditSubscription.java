package mobi.beyondpod.aggregators.greader;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import mobi.beyondpod.aggregators.AggregatorLoginHelper;
import mobi.beyondpod.aggregators.RequestBase;
import mobi.beyondpod.downloadengine.BeyondPodHttpClient;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;

public class GRequestEditSubscription
  extends RequestBase
{
  public static URI EditTagURL = URI.create("https://www.google.com/reader/api/0/subscription/edit?client=scroll");
  public static final int OPERATION_SUBSCRIBE = 0;
  public static final int OPERATION_UNSUBSCRIBE = 1;
  private static final String TAG = GRequestEditSubscription.class.getSimpleName();
  String FeedTitle;
  String FeedURL;
  int _Operation;
  
  public GRequestEditSubscription(String paramString1, String paramString2, int paramInt)
    throws Exception
  {
    this.FeedURL = paramString1;
    this.FeedTitle = paramString2;
    this._Operation = paramInt;
    this._RetryCount = 0;
  }
  
  public void OnFail(Exception paramException)
  {
    super.OnFail(paramException);
  }
  
  public void OnSuccess(String paramString)
  {
    if (!StringUtils.IsNullOrEmpty(paramString))
    {
      "OK".equals(paramString);
      this._RequestStatus = 1;
      return;
    }
    this._RequestStatus = 2;
  }
  
  public HttpUriRequest Request()
  {
    HttpPost localHttpPost = new HttpPost(EditTagURL);
    BeyondPodHttpClient.SetAcceptTo("*/*", localHttpPost);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("s", "feed/" + this.FeedURL));
    if (this._Operation == 0) {}
    for (String str = "subscribe";; str = "unsubscribe")
    {
      localArrayList.add(new BasicNameValuePair("ac", str));
      localArrayList.add(new BasicNameValuePair("t", this.FeedTitle));
      localArrayList.add(new BasicNameValuePair("T", GoogleReader.AuthenticationToken));
      BeyondPodHttpClient.SetRequestCookie(Configuration.GReaderCookie(), localHttpPost);
      BeyondPodHttpClient.SetHeader(localHttpPost, AuthRequestHeader, AggregatorLoginHelper.BlockingGetAuthToken());
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
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Operation: ");
    if (this._Operation == 0) {}
    for (String str = "[ADD]";; str = "[REMOVE]") {
      return str + "Subscription for Feed: [" + this.FeedURL + "]";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/aggregators/greader/GRequestEditSubscription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */