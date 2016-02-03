package com.inmobi.androidsdk;

import android.content.Context;
import android.os.Message;
import com.inmobi.androidsdk.impl.AdException;
import com.inmobi.androidsdk.impl.metric.EventLog;
import com.inmobi.androidsdk.impl.metric.EventType;
import com.inmobi.androidsdk.impl.metric.Logger;
import com.inmobi.androidsdk.impl.net.HttpRequestCallback;
import com.inmobi.androidsdk.impl.net.Response;
import com.inmobi.commons.internal.Log;
import org.json.JSONException;
import org.json.JSONObject;

class c
  implements HttpRequestCallback
{
  c(IMAdView paramIMAdView) {}
  
  public void notifyResult(int paramInt, Object paramObject)
  {
    Log.debug("InMobiAndroidSDK_3.7.1", ">>> Got HTTP REQUEST callback. Status: " + paramInt);
    if (paramInt == 0)
    {
      IMAdView.b(this.a, ((Response)paramObject).getAdResponse());
      IMAdView.c(this.a, ((Response)paramObject).getImpressionId());
      IMAdView.t(this.a).sendEmptyMessage(109);
    }
    while (paramInt != 1) {
      return;
    }
    long l = System.currentTimeMillis() - IMAdView.d(this.a);
    Message localMessage = IMAdView.t(this.a).obtainMessage(110);
    AdException localAdException;
    Object localObject;
    if ((paramObject instanceof AdException))
    {
      localAdException = (AdException)paramObject;
      paramObject = localAdException.getErrorCode();
      if (IMAdView.c(this.a)) {
        localObject = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("ad", localAdException.getImpressionId());
        ((JSONObject)localObject).put("t", l);
        ((JSONObject)localObject).put("m", localAdException.getHttpCode());
        Logger.logEvent(this.a.getContext().getApplicationContext(), new EventLog(EventType.RESPONSE_ERROR, (JSONObject)localObject));
        localMessage.obj = paramObject;
        localMessage.sendToTarget();
        return;
      }
      catch (JSONException localJSONException1)
      {
        Log.internal("InMobiAndroidSDK_3.7.1", "Error creating metric logs for error at " + System.currentTimeMillis());
        continue;
      }
      localObject = (IMAdRequest.ErrorCode)paramObject;
      paramInt = ((IMAdRequest.ErrorCode)localObject).getErrorCode();
      paramObject = localObject;
      if (!IMAdView.c(this.a)) {
        continue;
      }
      paramObject = new JSONObject();
      try
      {
        ((JSONObject)paramObject).put("t", l);
        ((JSONObject)paramObject).put("m", paramInt);
        Logger.logEvent(this.a.getContext().getApplicationContext(), new EventLog(EventType.CONNECT_ERROR, (JSONObject)paramObject));
        paramObject = localObject;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          Log.internal("InMobiAndroidSDK_3.7.1", "Error creating metric logs for error at " + System.currentTimeMillis());
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */