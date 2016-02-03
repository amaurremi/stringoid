package com.jumptap.adtag.events;

import android.content.Context;
import android.text.format.DateFormat;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.jumptap.adtag.JtAdWidgetSettings;
import com.jumptap.adtag.db.DBManager;
import com.jumptap.adtag.listeners.JtAdViewInnerListener;
import com.jumptap.adtag.utils.JtAdManager;
import com.jumptap.adtag.utils.JtAdUrlBuilder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class EventManager
{
  private static final String AD_REQUEST_ID_STRING = "jtreqid";
  private static final String AMP_STRING = "&";
  public static final String APP_ID_STRING = "app";
  public static final String APP_VER_STRING = "appVer";
  private static final String CONVERSION_TRACKING_URL = "http://a.jumptap.com/a/conversion?";
  private static final String DATE_FORMAT = "yyyyMMddhhmmss";
  public static final String DATE_STRING = "date";
  public static final int DELAY_AFTER_INTERACTION = 60;
  private static final String DURATION_STRING = "duration";
  private static final String EQUAL_STRING = "=";
  public static final String EVENT_STRING = "event";
  private static final String FIRST_LAUNCH = "1";
  public static final String HIDSHA1_STRING = "hid_sha1";
  public static final String HID_STRING = "hid";
  protected static final String INSTALL_DATE_PREF_NAME = "installDate";
  protected static final String IS_FIRST_PREF_NAME = "isFirstLaunch";
  protected static final String JT_AD_TRACKING = "JtAd-Tracking";
  protected static final String NOT_FIRST_LAUNCH = "0";
  private static final String PUB_STRING = "pub";
  private static final String SPOT_STRING = "spot";
  private static final String UNITS_STRING = "units";
  private static Timer eventTimer;
  private JtAdViewInnerListener adViewListener;
  private Context context;
  private EventInteractionInfo eventInteractionInfo;
  private InteractEventTask interEventTask;
  
  public EventManager(Context paramContext, JtAdViewInnerListener paramJtAdViewInnerListener)
  {
    this.context = paramContext;
    this.adViewListener = paramJtAdViewInnerListener;
    this.eventInteractionInfo = new EventInteractionInfo();
    initTimer();
    scheduleConversionTask(paramContext);
  }
  
  public static String buildEventTrackingUrl(Map<String, String> paramMap)
  {
    Object localObject = getConversionTrackingUrl(paramMap);
    StringBuilder localStringBuilder = new StringBuilder((String)localObject);
    int i = 1;
    if (((String)localObject).endsWith("?")) {
      i = 0;
    }
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        localObject = (Map.Entry)paramMap.next();
        if (i != 0) {
          localStringBuilder.append("&");
        }
        localStringBuilder.append((String)((Map.Entry)localObject).getKey());
        localStringBuilder.append("=");
        localStringBuilder.append(JtAdUrlBuilder.encodeParam((String)((Map.Entry)localObject).getValue()));
        i = 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  private static String getConversionTrackingUrl()
  {
    return "http://a.jumptap.com/a/conversion?";
  }
  
  private static String getConversionTrackingUrl(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("reportUrl");
    if (str == null) {
      return getConversionTrackingUrl();
    }
    paramMap.remove("reportUrl");
    return str;
  }
  
  public static String getDateByEventType(EventType paramEventType, Context paramContext)
  {
    if ((EventType.download.equals(paramEventType)) && (paramContext != null)) {
      return getDateForDownloadEvent(paramContext);
    }
    return (String)DateFormat.format("yyyyMMddhhmmss", System.currentTimeMillis());
  }
  
  private static String getDateForDownloadEvent(Context paramContext)
  {
    paramContext = JtAdManager.getPreferences(paramContext, "installDate", null);
    if (paramContext == null) {
      return (String)DateFormat.format("yyyyMMddhhmmss", System.currentTimeMillis());
    }
    return paramContext;
  }
  
  public static String getFirstLaunchStr()
  {
    return "1";
  }
  
  public static String getFirstPrefName()
  {
    return "isFirstLaunch";
  }
  
  private static void initTimer()
  {
    if (eventTimer == null) {
      eventTimer = new Timer("EventManagerTimer");
    }
  }
  
  private void populateParamsMap(Context paramContext, JtAdViewInnerListener paramJtAdViewInnerListener, EventType paramEventType, String paramString, Map<String, String> paramMap)
  {
    paramContext = JtAdManager.getHIDSHA1(paramContext);
    String str1 = paramJtAdViewInnerListener.getWidgetSettings().getApplicationId();
    String str2 = paramJtAdViewInnerListener.getWidgetSettings().getApplicationVersion();
    paramMap.put("event", paramEventType.value());
    paramMap.put("hid_sha1", paramContext);
    paramMap.put("app", str1);
    paramMap.put("appVer", str2);
    paramMap.put("date", paramString);
    paramMap.put("jtreqid", paramJtAdViewInnerListener.getAdRequestId());
    paramMap.put("pub", paramJtAdViewInnerListener.getWidgetSettings().getPublisherId());
    paramMap.put("spot", paramJtAdViewInnerListener.getWidgetSettings().getSpotId());
  }
  
  private static void scheduleConversionTask(Context paramContext)
  {
    paramContext = new SendConversionUrlTask(paramContext);
    eventTimer.schedule(paramContext, 0L);
  }
  
  public static void sendReport(Context paramContext, String paramString1, EventType paramEventType, String paramString2)
  {
    initTimer();
    new Thread(new LogEvent(paramContext, new JtEvent(paramString1, paramEventType, paramString2))).start();
  }
  
  private void sendReport(EventType paramEventType, Map<String, String> paramMap)
  {
    Log.i("JtAd-Tracking", "sendReport: eventType=" + paramEventType.name());
    String str = getDateByEventType(paramEventType, this.context);
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    populateParamsMap(this.context, this.adViewListener, paramEventType, str, (Map)localObject);
    paramMap = buildEventTrackingUrl((Map)localObject);
    sendReport(this.context, paramMap, paramEventType, str);
  }
  
  private void startTimer()
  {
    Log.i("JtAd-Tracking", "Starting Interaction Event Task timer");
    if (this.interEventTask != null) {
      this.interEventTask.cancel();
    }
    this.interEventTask = new InteractEventTask(null);
    eventTimer.schedule(this.interEventTask, 60000L);
  }
  
  private void stopTimer()
  {
    Log.i("JtAd-Tracking", "stopping Interaction Event Task timer");
    if (this.interEventTask != null) {
      this.interEventTask.cancel();
    }
  }
  
  public void close()
  {
    DBManager.getInstance(this.context).close();
  }
  
  public void forceSendingInteractEvent()
  {
    stopInteraction();
    Log.d("JtAd-Tracking", "forceSendingInteractEvent");
    new Thread(this.interEventTask).start();
  }
  
  public void sendReport(EventType paramEventType)
  {
    sendReport(paramEventType, null);
  }
  
  @JavascriptInterface
  public void startInteraction()
  {
    Log.d("JtAd-Tracking", "startInteraction");
    this.eventInteractionInfo.interactionStarted();
    this.adViewListener.onBeginAdInteraction();
    stopTimer();
  }
  
  @JavascriptInterface
  public void stopInteraction()
  {
    Log.d("JtAd-Tracking", "stopInteraction");
    this.eventInteractionInfo.interactionEnded();
    this.adViewListener.onEndAdInteraction();
    startTimer();
  }
  
  private class EventInteractionInfo
  {
    private long endInteractionTime;
    private int numOfInteractions;
    private long startInteractionTime;
    
    EventInteractionInfo()
    {
      reset();
    }
    
    public long getDuration()
    {
      return this.endInteractionTime - this.startInteractionTime;
    }
    
    public int getNumOfInteractions()
    {
      return this.numOfInteractions;
    }
    
    public void interactionEnded()
    {
      if (this.startInteractionTime != -1L) {
        this.endInteractionTime = System.currentTimeMillis();
      }
      Log.d("JtAd-Tracking", "interactionEnded: startInteractionTime=" + this.startInteractionTime + " endInteractionTime=" + this.endInteractionTime);
    }
    
    public void interactionStarted()
    {
      if (this.startInteractionTime == -1L) {
        this.startInteractionTime = System.currentTimeMillis();
      }
      Log.d("JtAd-Tracking", "interactionStarted: startInteractionTime=" + this.startInteractionTime + " endInteractionTime=" + this.endInteractionTime);
      this.numOfInteractions += 1;
    }
    
    public void reset()
    {
      this.startInteractionTime = -1L;
      this.endInteractionTime = -1L;
      this.numOfInteractions = 0;
    }
  }
  
  private class InteractEventTask
    extends TimerTask
  {
    private InteractEventTask() {}
    
    public void run()
    {
      EventManager.this.adViewListener.post(new Runnable()
      {
        public void run()
        {
          long l = EventManager.this.eventInteractionInfo.getDuration();
          if (l > 0L)
          {
            Log.i("JtAd-Tracking", "performing Interaction Event Task timer");
            HashMap localHashMap = new HashMap();
            localHashMap.put("duration", "" + l);
            localHashMap.put("units", "" + EventManager.this.eventInteractionInfo.getNumOfInteractions());
            Log.i("JtAd-Tracking", "reset");
            EventManager.this.eventInteractionInfo.reset();
            EventManager.this.sendReport(EventType.interact, localHashMap);
          }
        }
      });
    }
  }
  
  private static class LogEvent
    implements Runnable
  {
    private Context context;
    private JtEvent event;
    
    public LogEvent(Context paramContext, JtEvent paramJtEvent)
    {
      this.context = paramContext;
      this.event = paramJtEvent;
    }
    
    public void run()
    {
      DBManager.getInstance(this.context).insertEvent(this.event);
      EventManager.scheduleConversionTask(this.context);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/events/EventManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */