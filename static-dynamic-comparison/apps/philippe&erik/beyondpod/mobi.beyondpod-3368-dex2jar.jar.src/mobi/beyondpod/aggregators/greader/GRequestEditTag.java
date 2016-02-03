package mobi.beyondpod.aggregators.greader;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
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

public class GRequestEditTag
  extends RequestBase
{
  public static URI EditTagURL = URI.create("https://www.google.com/reader/api/0/edit-tag?client=scroll");
  public static final int OPERATION_ADD = 0;
  public static final int OPERATION_REMOVE = 1;
  private static final String TAG;
  public static final String TAG_MOBILE_READ;
  public static final String TAG_READ = CreateTagName("read");
  public static final String TAG_STARRED;
  ArrayList<String> ItemIDs;
  String Tag;
  int _Operation;
  
  static
  {
    TAG_MOBILE_READ = CreateTagName("tracking-mobile-read");
    TAG_STARRED = CreateTagName("starred");
    TAG = GRequestEditTag.class.getSimpleName();
  }
  
  public GRequestEditTag(ArrayList<String> paramArrayList, int paramInt, String paramString)
    throws Exception
  {
    this.ItemIDs = paramArrayList;
    this.Tag = paramString;
    this._Operation = paramInt;
    this._RetryCount = 0;
  }
  
  private static String CreateTagName(String paramString)
  {
    return "user/" + GoogleReader.UserID + "/state/com.google/" + paramString;
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
    int i;
    Object localObject;
    if (this._Operation == 0)
    {
      localArrayList.add(new BasicNameValuePair("a", this.Tag));
      if (TAG_READ.equals(this.Tag)) {
        localArrayList.add(new BasicNameValuePair("a", TAG_MOBILE_READ));
      }
      localArrayList.add(new BasicNameValuePair("async", "true"));
      i = 0;
      localObject = this.ItemIDs.iterator();
      label118:
      if (((Iterator)localObject).hasNext()) {
        break label159;
      }
      if (i != 0) {
        break label281;
      }
      localObject = null;
    }
    label159:
    label281:
    do
    {
      return (HttpUriRequest)localObject;
      localArrayList.add(new BasicNameValuePair("r", this.Tag));
      break;
      String str1 = (String)((Iterator)localObject).next();
      int j = str1.indexOf('|');
      if (j > 0)
      {
        String str2 = "tag:google.com,2005:reader/" + str1.substring(0, j);
        localArrayList.add(new BasicNameValuePair("s", str1.substring(j + 1)));
        localArrayList.add(new BasicNameValuePair("i", str2));
        i = 1;
        break label118;
      }
      CoreHelper.WriteTraceEntry(TAG, "Invalid item id: " + str1);
      break label118;
      localArrayList.add(new BasicNameValuePair("T", GoogleReader.AuthenticationToken));
      BeyondPodHttpClient.SetRequestCookie(Configuration.GReaderCookie(), localHttpPost);
      BeyondPodHttpClient.SetHeader(localHttpPost, AuthRequestHeader, AggregatorLoginHelper.BlockingGetAuthToken());
      localObject = localHttpPost;
    } while (localArrayList == null);
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
    StringBuilder localStringBuilder = new StringBuilder("Operation: ");
    if (this._Operation == 0) {}
    for (String str = "[ADD]";; str = "[REMOVE]") {
      return str + " Tag: [" + this.Tag + "] For [" + this.ItemIDs.size() + "] items";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/aggregators/greader/GRequestEditTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */