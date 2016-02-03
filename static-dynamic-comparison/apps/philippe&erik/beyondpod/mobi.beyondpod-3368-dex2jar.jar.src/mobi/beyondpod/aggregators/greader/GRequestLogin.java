package mobi.beyondpod.aggregators.greader;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
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

public class GRequestLogin
  extends RequestBase
{
  public static URI LoginUri = URI.create("https://www.google.com/accounts/ClientLogin");
  private static final String TAG = GRequestLogin.class.getSimpleName();
  String _Password;
  String _UserName;
  
  public GRequestLogin(String paramString1, String paramString2)
    throws Exception
  {
    this._UserName = paramString1;
    this._Password = paramString2;
    if ((StringUtils.IsNullOrEmpty(paramString1)) || (StringUtils.IsNullOrEmpty(paramString2))) {
      throw new Exception("Username and password are both required!");
    }
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
    int j;
    int i;
    if (!StringUtils.IsNullOrEmpty(paramString))
    {
      paramString = paramString.split("\r\n|\r|\n");
      if (paramString != null)
      {
        j = paramString.length;
        i = 0;
      }
    }
    for (;;)
    {
      if (i >= j) {
        return;
      }
      Object localObject = paramString[i];
      if (((String)localObject).startsWith("Auth="))
      {
        Configuration.setGReaderAuthValue("GoogleLogin auth=" + ((String)localObject).substring(5));
        this._RequestStatus = 1;
        Configuration.setGReaderCookie(null);
        return;
      }
      i += 1;
    }
  }
  
  public HttpUriRequest Request()
  {
    HttpPost localHttpPost = new HttpPost(LoginUri);
    BeyondPodHttpClient.SetAcceptTo("*/*", localHttpPost);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("Email", this._UserName));
    localArrayList.add(new BasicNameValuePair("Passwd", this._Password));
    localArrayList.add(new BasicNameValuePair("accountType", "GOOGLE"));
    localArrayList.add(new BasicNameValuePair("service", "reader"));
    localArrayList.add(new BasicNameValuePair("source", "Beyondpod_for_Android"));
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
    return "Reader Login Request";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/aggregators/greader/GRequestLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */