package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TJEvent
{
  private static final String TAG = "TJEvent";
  private boolean autoShowContent = true;
  private TJEventCallback callback;
  private boolean contentAvailable = false;
  private boolean contentShown = false;
  private Context context;
  private TJEventData eventData;
  private Map<String, String> eventParams;
  private Map<String, String> urlParams;
  
  public TJEvent(Context paramContext, String paramString, TJEventCallback paramTJEventCallback)
  {
    this(paramContext, paramString, null, paramTJEventCallback);
  }
  
  public TJEvent(Context paramContext, String paramString1, String paramString2, TJEventCallback paramTJEventCallback)
  {
    this.context = paramContext;
    this.callback = paramTJEventCallback;
    this.eventData = new TJEventData();
    this.eventData.name = paramString1;
    this.eventData.value = paramString2;
    for (this.eventData.guid = UUID.randomUUID().toString(); TJEventManager.get(this.eventData.guid) != null; this.eventData.guid = UUID.randomUUID().toString()) {}
    TJEventManager.put(this.eventData.guid, this);
  }
  
  public void enableAutoPresent(boolean paramBoolean)
  {
    this.autoShowContent = paramBoolean;
  }
  
  public TJEventCallback getCallback()
  {
    return this.callback;
  }
  
  public String getGUID()
  {
    return this.eventData.guid;
  }
  
  public String getName()
  {
    return this.eventData.name;
  }
  
  public void send()
  {
    this.contentShown = false;
    if (this.callback == null) {
      Log.e("TJEvent", "TJEventSendCallback is null");
    }
    if ((TapjoyConnectCore.getInstance() == null) || (!TapjoyConnectCore.getInstance().isInitialized()))
    {
      Log.e("TJEvent", "ERROR -- SDK not initialized -- requestTapjoyConnect must be called first");
      if (this.callback != null) {
        this.callback.sendEventFail(this, new TJError(0, "SDK not initialized -- requestTapjoyConnect must be called first"));
      }
    }
    do
    {
      do
      {
        return;
        if (this.context != null) {
          break;
        }
      } while (this.callback == null);
      this.callback.sendEventFail(this, new TJError(0, "Context is null -- TJEvent requires a valid Context."));
      return;
      if ((this.eventData.name != null) && (this.eventData.name.length() != 0)) {
        break;
      }
    } while (this.callback == null);
    this.callback.sendEventFail(this, new TJError(0, "Invalid eventName -- TJEvent requires a valid eventName."));
    return;
    this.urlParams = TapjoyConnectCore.getGenericURLParams();
    if (this.eventParams == null) {
      this.eventParams = new HashMap();
    }
    TapjoyUtil.safePut(this.eventParams, "event_name", this.eventData.name, true);
    TapjoyUtil.safePut(this.eventParams, "event_value", this.eventData.value, true);
    this.urlParams.putAll(this.eventParams);
    this.urlParams.putAll(TapjoyConnectCore.getTimeStampAndVerifierParams());
    this.eventData.url = "https://events.tapjoy.com/events?";
    this.eventData.baseURL = "https://events.tapjoy.com/events?".substring(0, "https://events.tapjoy.com/events?".indexOf('/', "https://events.tapjoy.com/events?".indexOf("//") + ("//".length() + 1)));
    new Thread()
    {
      public void run()
      {
        TapjoyHttpURLResponse localTapjoyHttpURLResponse = new TapjoyURLConnection().getResponseFromURL(TJEvent.this.eventData.url, TJEvent.this.urlParams);
        TJEvent.this.eventData.httpStatusCode = localTapjoyHttpURLResponse.statusCode;
        TJEvent.this.eventData.httpResponse = localTapjoyHttpURLResponse.response;
        if ((localTapjoyHttpURLResponse != null) && (TJEvent.this.callback != null)) {}
        switch (localTapjoyHttpURLResponse.statusCode)
        {
        default: 
          TJEvent.this.callback.sendEventCompleted(TJEvent.this, TJEvent.this.contentAvailable);
        case 200: 
          do
          {
            return;
            TJEvent.access$302(TJEvent.this, true);
            TJEvent.this.callback.sendEventCompleted(TJEvent.this, TJEvent.this.contentAvailable);
          } while (!TJEvent.this.autoShowContent);
          TJEvent.this.showContent();
          return;
        }
        TJEvent.this.callback.sendEventFail(TJEvent.this, new TJError(localTapjoyHttpURLResponse.statusCode, localTapjoyHttpURLResponse.response));
        TJEvent.this.urlParams.remove("timestamp");
        TJEvent.this.urlParams.remove("verifier");
        TapjoyConnectCore.saveOfflineLog(TJEvent.this.eventData.url + TapjoyUtil.convertURLParams(TJEvent.this.urlParams, false));
      }
    }.start();
  }
  
  public void setParameters(Map<String, String> paramMap)
  {
    this.eventParams = paramMap;
  }
  
  public void showContent()
  {
    if (!this.contentAvailable)
    {
      Log.e("TJEvent", "cannot show content for non-200 send event");
      return;
    }
    if (this.callback == null)
    {
      Log.e("TJEvent", "TJEventShowCallback cb is null");
      return;
    }
    if (this.contentShown)
    {
      Log.e("TJEvent", "Content has already been shown for event " + this.eventData.name);
      return;
    }
    Intent localIntent;
    if (this.eventData.name.equals("tj_legacy_featured_ad")) {
      if (this.eventParams.containsKey("featured_app_legacy"))
      {
        localIntent = new Intent(this.context, TapjoyFeaturedAppWebView.class);
        localIntent.putExtra("legacy_view", true);
      }
    }
    for (;;)
    {
      this.contentShown = true;
      localIntent.putExtra("view_type", 1);
      localIntent.putExtra("tjevent", this.eventData);
      localIntent.setFlags(268435456);
      this.context.startActivity(localIntent);
      return;
      localIntent = new Intent(this.context, TapjoyFullScreenAdWebView.class);
      break;
      if (this.eventData.name.equals("tj_legacy_reengagement_rewards"))
      {
        localIntent = new Intent(this.context, TapjoyDailyRewardAdWebView.class);
        localIntent.putExtra("legacy_view", true);
      }
      else
      {
        localIntent = new Intent(this.context, TJAdUnitView.class);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TJEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */