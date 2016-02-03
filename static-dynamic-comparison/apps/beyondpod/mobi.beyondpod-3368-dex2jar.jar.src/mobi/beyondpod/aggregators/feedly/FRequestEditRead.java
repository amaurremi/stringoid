package mobi.beyondpod.aggregators.feedly;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import mobi.beyondpod.aggregators.AggregatorLoginHelper;
import mobi.beyondpod.aggregators.RequestBase;
import mobi.beyondpod.downloadengine.BeyondPodHttpClient;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;

public class FRequestEditRead
  extends RequestBase
{
  private static final String TAG = FRequestEditRead.class.getSimpleName();
  public static final String TAG_READ = "markAsRead";
  public static final String TAG_UNREAD = "keepUnread";
  ArrayList<String> ItemIDs;
  String Tag;
  
  public FRequestEditRead(ArrayList<String> paramArrayList, String paramString)
    throws Exception
  {
    this.ItemIDs = paramArrayList;
    this.Tag = paramString;
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
    HttpPost localHttpPost = new HttpPost(Feedly.EditMarkerURL);
    BeyondPodHttpClient.SetAcceptTo("*/*", localHttpPost);
    Object localObject1 = new StringBuilder();
    int i = 0;
    Object localObject2 = this.ItemIDs.iterator();
    if (!((Iterator)localObject2).hasNext())
    {
      if (i != 0) {
        break label153;
      }
      localObject1 = null;
    }
    label153:
    do
    {
      return (HttpUriRequest)localObject1;
      String str = (String)((Iterator)localObject2).next();
      int j = str.indexOf('|');
      if (j > 0)
      {
        str = str.substring(0, j);
        if (((StringBuilder)localObject1).length() > 0) {
          ((StringBuilder)localObject1).append(",");
        }
        ((StringBuilder)localObject1).append(String.format("\"%s\"", new Object[] { str }));
        i = 1;
        break;
      }
      CoreHelper.WriteTraceEntry(TAG, "Invalid item id: " + str);
      break;
      localObject2 = String.format("{\"action\": \"%s\",\"type\": \"entries\",\"entryIds\": [%s]}", new Object[] { this.Tag, ((StringBuilder)localObject1).toString() });
      BeyondPodHttpClient.SetHeader(localHttpPost, AuthRequestHeader, AggregatorLoginHelper.BlockingGetAuthToken());
      localObject1 = localHttpPost;
    } while (localObject2 == null);
    try
    {
      localHttpPost.setEntity(new StringEntity((String)localObject2, "UTF-8"));
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
    return "Operation:  Tag: [" + this.Tag + "] For [" + this.ItemIDs.size() + "] items";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/aggregators/feedly/FRequestEditRead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */