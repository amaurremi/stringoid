package mobi.beyondpod.aggregators.feedly;

import android.net.Uri;
import android.net.Uri.Builder;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import mobi.beyondpod.aggregators.AggregatorLoginHelper;
import mobi.beyondpod.aggregators.RequestBase;
import mobi.beyondpod.downloadengine.BeyondPodHttpClient;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;

public class FRequestEditTag
  extends RequestBase
{
  public static final int OPERATION_TAG = 0;
  public static final int OPERATION_UNTAG = 1;
  private static final String TAG = FRequestEditTag.class.getSimpleName();
  ArrayList<String> ItemIDs;
  String Tag;
  int _Operation;
  
  public FRequestEditTag(ArrayList<String> paramArrayList, int paramInt, String paramString)
    throws Exception
  {
    this.ItemIDs = paramArrayList;
    this._Operation = paramInt;
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
    HttpPut localHttpPut = null;
    Object localObject1 = new StringBuilder();
    int i = 0;
    Object localObject2 = this.ItemIDs.iterator();
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext())
      {
        if (i != 0) {
          break;
        }
        return null;
      }
      String str = (String)((Iterator)localObject2).next();
      int j = str.indexOf('|');
      if (j > 0)
      {
        str = str.substring(0, j);
        if (((StringBuilder)localObject1).length() > 0) {
          ((StringBuilder)localObject1).append(",");
        }
        if (this._Operation == 0) {
          ((StringBuilder)localObject1).append(String.format("\"%s\"", new Object[] { str }));
        }
        for (;;)
        {
          i = 1;
          break;
          ((StringBuilder)localObject1).append(str);
        }
      }
      CoreHelper.WriteTraceEntry(TAG, "Invalid item id: " + str);
    }
    if (this._Operation == 0)
    {
      localObject2 = Feedly.EditTagURL.buildUpon().appendPath(Feedly.UserStream() + this.Tag).build();
      localObject1 = String.format("{\"entryIds\": [%s]}", new Object[] { ((StringBuilder)localObject1).toString() });
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        localHttpPut = new HttpPut(((Uri)localObject2).toString());
        CoreHelper.LogException(TAG, "Failed to create request", localUnsupportedEncodingException1);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        try
        {
          ((HttpPut)localHttpPut).setEntity(new StringEntity((String)localObject1, "UTF-8"));
          BeyondPodHttpClient.SetAcceptTo("*/*", localHttpPut);
          BeyondPodHttpClient.SetHeader(localHttpPut, AuthRequestHeader, AggregatorLoginHelper.BlockingGetAuthToken());
          return localHttpPut;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          HttpDelete localHttpDelete;
          for (;;) {}
        }
        localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
      }
      return null;
      localHttpDelete = new HttpDelete(Feedly.EditTagURL.buildUpon().appendPath(Feedly.UserStream() + this.Tag).appendPath(((StringBuilder)localObject1).toString()).build().toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Operation: ");
    if (this._Operation == 0) {}
    for (String str = "[TAG]";; str = "[UNTAG]") {
      return str + " Tag: [" + this.Tag + "] For [" + this.ItemIDs.size() + "] items";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/aggregators/feedly/FRequestEditTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */