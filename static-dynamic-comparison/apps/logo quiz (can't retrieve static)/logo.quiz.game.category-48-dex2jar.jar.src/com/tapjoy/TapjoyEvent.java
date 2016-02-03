package com.tapjoy;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public class TapjoyEvent
{
  public static final int EVENT_TYPE_IAP = 1;
  public static final int EVENT_TYPE_SHUTDOWN = 2;
  private static final String TAG = "Event";
  private static TapjoyURLConnection tapjoyURLConnection = null;
  private Context context;
  
  public TapjoyEvent(Context paramContext)
  {
    this.context = paramContext;
    tapjoyURLConnection = new TapjoyURLConnection();
  }
  
  public String createEventParameter(String paramString)
  {
    return "ue[" + paramString + "]";
  }
  
  public void sendEvent(int paramInt, Map<String, String> paramMap)
  {
    TapjoyLog.i("Event", "sendEvent type: " + paramInt);
    Map localMap = TapjoyConnectCore.getGenericURLParams();
    TapjoyUtil.safePut(localMap, "event_type_id", String.valueOf(paramInt), true);
    if (paramMap != null) {
      localMap.putAll(paramMap);
    }
    new Thread(new EventThread(localMap)).start();
  }
  
  public void sendIAPEvent(String paramString1, float paramFloat, int paramInt, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    TapjoyUtil.safePut(localHashMap, createEventParameter("name"), paramString1, true);
    TapjoyUtil.safePut(localHashMap, createEventParameter("price"), String.valueOf(paramFloat), true);
    TapjoyUtil.safePut(localHashMap, createEventParameter("quantity"), String.valueOf(paramInt), true);
    TapjoyUtil.safePut(localHashMap, createEventParameter("currency_code"), paramString2, true);
    sendEvent(1, localHashMap);
  }
  
  public void sendShutDownEvent()
  {
    sendEvent(2, null);
  }
  
  public class EventThread
    implements Runnable
  {
    private Map<String, String> params;
    
    public EventThread()
    {
      Map localMap;
      this.params = localMap;
    }
    
    public void run()
    {
      String str = TapjoyConnectCore.getHostURL() + "user_events?";
      TapjoyHttpURLResponse localTapjoyHttpURLResponse = TapjoyEvent.tapjoyURLConnection.getResponseFromURL(str, this.params, 1);
      if (localTapjoyHttpURLResponse != null)
      {
        switch (localTapjoyHttpURLResponse.statusCode)
        {
        default: 
          TapjoyLog.e("Event", "Unknown error: " + localTapjoyHttpURLResponse.statusCode);
          return;
        case 0: 
          TapjoyLog.e("Event", "Event network error: " + localTapjoyHttpURLResponse.statusCode);
          TapjoyConnectCore.saveOfflineLog(str + "?" + this.params);
          return;
        case 200: 
          TapjoyLog.i("Event", "Successfully sent Tapjoy event");
          return;
        }
        TapjoyLog.e("Event", "Error sending event: " + localTapjoyHttpURLResponse.response);
        return;
      }
      TapjoyLog.e("Event", "Server/network error");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TapjoyEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */