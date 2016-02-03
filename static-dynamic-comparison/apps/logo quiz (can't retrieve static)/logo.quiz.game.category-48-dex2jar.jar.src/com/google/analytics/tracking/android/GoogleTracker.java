package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class GoogleTracker
  implements Tracker
{
  private static final DecimalFormat DF = new DecimalFormat("0.######", new DecimalFormatSymbols(Locale.US));
  private volatile ExceptionParser exceptionParser;
  private final TrackerHandler handler;
  private final SimpleModel model;
  private volatile boolean trackerClosed = false;
  private volatile boolean trackingStarted = false;
  
  GoogleTracker(String paramString, TrackerHandler paramTrackerHandler)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("trackingId cannot be null");
    }
    this.handler = paramTrackerHandler;
    this.model = new SimpleModel(null);
    this.model.set("trackingId", paramString);
    this.model.set("sampleRate", "100");
    this.model.setForNextHit("sessionControl", "start");
  }
  
  private void assertTrackerOpen()
  {
    if (this.trackerClosed) {
      throw new IllegalStateException("Tracker closed");
    }
  }
  
  private void internalSend(String paramString, Map<String, String> paramMap)
  {
    this.trackingStarted = true;
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("hitType", paramString);
    this.model.setAll((Map)localObject, Boolean.valueOf(true));
    this.handler.sendHit(this.model.getKeysAndValues());
    this.model.clearTemporaryValues();
  }
  
  private static String microsToCurrencyString(long paramLong)
  {
    return DF.format(paramLong / 1000000.0D);
  }
  
  public boolean anonymizeIpEnabled()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_ANONYMIZE_IP);
    return Utils.safeParseBoolean(this.model.get("anonymizeIp"));
  }
  
  public void close()
  {
    this.trackerClosed = true;
    this.handler.closeTracker(this);
  }
  
  public Map<String, String> constructEvent(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("eventCategory", paramString1);
    localHashMap.put("eventAction", paramString2);
    localHashMap.put("eventLabel", paramString3);
    if (paramLong != null) {
      localHashMap.put("eventValue", Long.toString(paramLong.longValue()));
    }
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_EVENT);
    return localHashMap;
  }
  
  public Map<String, String> constructException(String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("exDescription", paramString);
    localHashMap.put("exFatal", Boolean.toString(paramBoolean));
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_EXCEPTION);
    return localHashMap;
  }
  
  Map<String, String> constructItem(Item paramItem, Transaction paramTransaction)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("transactionId", paramTransaction.getTransactionId());
    localHashMap.put("currencyCode", paramTransaction.getCurrencyCode());
    localHashMap.put("itemCode", paramItem.getProductSKU());
    localHashMap.put("itemName", paramItem.getProductName());
    localHashMap.put("itemCategory", paramItem.getProductCategory());
    localHashMap.put("itemPrice", microsToCurrencyString(paramItem.getItemPriceInMicros()));
    localHashMap.put("itemQuantity", Long.toString(paramItem.getItemQuantity()));
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_ITEM);
    return localHashMap;
  }
  
  public Map<String, String> constructRawException(String paramString, Throwable paramThrowable, boolean paramBoolean)
    throws IOException
  {
    HashMap localHashMap = new HashMap();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
    localObjectOutputStream.writeObject(paramThrowable);
    localObjectOutputStream.close();
    localHashMap.put("rawException", Utils.hexEncode(localByteArrayOutputStream.toByteArray()));
    if (paramString != null) {
      localHashMap.put("exceptionThreadName", paramString);
    }
    localHashMap.put("exFatal", Boolean.toString(paramBoolean));
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_RAW_EXCEPTION);
    return localHashMap;
  }
  
  public Map<String, String> constructSocial(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("socialNetwork", paramString1);
    localHashMap.put("socialAction", paramString2);
    localHashMap.put("socialTarget", paramString3);
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_SOCIAL);
    return localHashMap;
  }
  
  public Map<String, String> constructTiming(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("timingCategory", paramString1);
    localHashMap.put("timingValue", Long.toString(paramLong));
    localHashMap.put("timingVar", paramString2);
    localHashMap.put("timingLabel", paramString3);
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_TIMING);
    return localHashMap;
  }
  
  public Map<String, String> constructTransaction(Transaction paramTransaction)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("transactionId", paramTransaction.getTransactionId());
    localHashMap.put("transactionAffiliation", paramTransaction.getAffiliation());
    localHashMap.put("transactionShipping", microsToCurrencyString(paramTransaction.getShippingCostInMicros()));
    localHashMap.put("transactionTax", microsToCurrencyString(paramTransaction.getTotalTaxInMicros()));
    localHashMap.put("transactionTotal", microsToCurrencyString(paramTransaction.getTotalCostInMicros()));
    localHashMap.put("currencyCode", paramTransaction.getCurrencyCode());
    GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_TRANSACTION);
    return localHashMap;
  }
  
  public String get(String paramString)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET);
    return this.model.get(paramString);
  }
  
  public String getAppId()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_APP_ID);
    return this.model.get("appId");
  }
  
  public String getAppInstallerId()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_APP_INSTALLER_ID);
    return this.model.get("appInstallerId");
  }
  
  public ExceptionParser getExceptionParser()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_EXCEPTION_PARSER);
    return this.exceptionParser;
  }
  
  public double getSampleRate()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_SAMPLE_RATE);
    return Utils.safeParseDouble(this.model.get("sampleRate"));
  }
  
  public String getTrackingId()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_TRACKING_ID);
    return this.model.get("trackingId");
  }
  
  public boolean getUseSecure()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_USE_SECURE);
    return Boolean.parseBoolean(this.model.get("useSecure"));
  }
  
  public void send(String paramString, Map<String, String> paramMap)
  {
    assertTrackerOpen();
    GAUsage.getInstance().setUsage(GAUsage.Field.SEND);
    internalSend(paramString, paramMap);
  }
  
  public void set(String paramString1, String paramString2)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET);
    this.model.set(paramString1, paramString2);
  }
  
  public void setAnonymizeIp(boolean paramBoolean)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_ANONYMIZE_IP);
    this.model.set("anonymizeIp", Boolean.toString(paramBoolean));
  }
  
  public void setAppId(String paramString)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_APP_ID);
    this.model.set("appId", paramString);
  }
  
  public void setAppInstallerId(String paramString)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_APP_INSTALLER_ID);
    this.model.set("appInstallerId", paramString);
  }
  
  public void setAppName(String paramString)
  {
    if (this.trackingStarted)
    {
      Log.wDebug("Tracking already started, setAppName call ignored");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      Log.wDebug("setting appName to empty value not allowed, call ignored");
      return;
    }
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_APP_NAME);
    this.model.set("appName", paramString);
  }
  
  public void setAppScreen(String paramString)
  {
    assertTrackerOpen();
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_APP_SCREEN);
    this.model.set("description", paramString);
  }
  
  public void setAppVersion(String paramString)
  {
    if (this.trackingStarted)
    {
      Log.wDebug("Tracking already started, setAppVersion call ignored");
      return;
    }
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_APP_VERSION);
    this.model.set("appVersion", paramString);
  }
  
  public void setCampaign(String paramString)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_CAMPAIGN);
    this.model.setForNextHit("campaign", paramString);
  }
  
  public void setCustomDimension(int paramInt, String paramString)
  {
    if (paramInt < 1)
    {
      Log.w("slot must be > 0, ignoring setCustomDimension call for " + paramInt + ", " + paramString);
      return;
    }
    this.model.setForNextHit(Utils.getSlottedModelField("customDimension", paramInt), paramString);
  }
  
  public void setCustomDimensionsAndMetrics(Map<Integer, String> paramMap, Map<Integer, Long> paramMap1)
  {
    Object localObject;
    if (paramMap != null)
    {
      localObject = paramMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        setCustomDimension(localInteger.intValue(), (String)paramMap.get(localInteger));
      }
    }
    if (paramMap1 != null)
    {
      paramMap = paramMap1.keySet().iterator();
      while (paramMap.hasNext())
      {
        localObject = (Integer)paramMap.next();
        setCustomMetric(((Integer)localObject).intValue(), (Long)paramMap1.get(localObject));
      }
    }
  }
  
  public void setCustomMetric(int paramInt, Long paramLong)
  {
    if (paramInt < 1)
    {
      Log.w("slot must be > 0, ignoring setCustomMetric call for " + paramInt + ", " + paramLong);
      return;
    }
    String str = null;
    if (paramLong != null) {
      str = Long.toString(paramLong.longValue());
    }
    this.model.setForNextHit(Utils.getSlottedModelField("customMetric", paramInt), str);
  }
  
  public void setExceptionParser(ExceptionParser paramExceptionParser)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_EXCEPTION_PARSER);
    this.exceptionParser = paramExceptionParser;
  }
  
  public void setReferrer(String paramString)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_REFERRER);
    this.model.setForNextHit("referrer", paramString);
  }
  
  public void setSampleRate(double paramDouble)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_SAMPLE_RATE);
    this.model.set("sampleRate", Double.toString(paramDouble));
  }
  
  public void setStartSession(boolean paramBoolean)
  {
    assertTrackerOpen();
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_START_SESSION);
    SimpleModel localSimpleModel = this.model;
    if (paramBoolean) {}
    for (String str = "start";; str = null)
    {
      localSimpleModel.setForNextHit("sessionControl", str);
      return;
    }
  }
  
  public void setUseSecure(boolean paramBoolean)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET_USE_SECURE);
    this.model.set("useSecure", Boolean.toString(paramBoolean));
  }
  
  public void trackEvent(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    assertTrackerOpen();
    GAUsage.getInstance().setUsage(GAUsage.Field.TRACK_EVENT);
    GAUsage.getInstance().setDisableUsage(true);
    internalSend("event", constructEvent(paramString1, paramString2, paramString3, paramLong));
    GAUsage.getInstance().setDisableUsage(false);
  }
  
  public void trackException(String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    assertTrackerOpen();
    GAUsage.getInstance().setUsage(GAUsage.Field.TRACK_EXCEPTION_WITH_THROWABLE);
    if (this.exceptionParser != null) {
      paramString = this.exceptionParser.getDescription(paramString, paramThrowable);
    }
    for (;;)
    {
      GAUsage.getInstance().setDisableUsage(true);
      trackException(paramString, paramBoolean);
      GAUsage.getInstance().setDisableUsage(false);
      return;
      try
      {
        GAUsage.getInstance().setDisableUsage(true);
        internalSend("exception", constructRawException(paramString, paramThrowable, paramBoolean));
        GAUsage.getInstance().setDisableUsage(false);
        return;
      }
      catch (IOException paramString)
      {
        Log.w("trackException: couldn't serialize, sending \"Unknown Exception\"");
        paramString = "Unknown Exception";
      }
    }
  }
  
  public void trackException(String paramString, boolean paramBoolean)
  {
    assertTrackerOpen();
    GAUsage.getInstance().setUsage(GAUsage.Field.TRACK_EXCEPTION_WITH_DESCRIPTION);
    GAUsage.getInstance().setDisableUsage(true);
    internalSend("exception", constructException(paramString, paramBoolean));
    GAUsage.getInstance().setDisableUsage(false);
  }
  
  public void trackSocial(String paramString1, String paramString2, String paramString3)
  {
    assertTrackerOpen();
    GAUsage.getInstance().setUsage(GAUsage.Field.TRACK_SOCIAL);
    GAUsage.getInstance().setDisableUsage(true);
    internalSend("social", constructSocial(paramString1, paramString2, paramString3));
    GAUsage.getInstance().setDisableUsage(false);
  }
  
  public void trackTiming(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    assertTrackerOpen();
    GAUsage.getInstance().setUsage(GAUsage.Field.TRACK_TIMING);
    GAUsage.getInstance().setDisableUsage(true);
    internalSend("timing", constructTiming(paramString1, paramLong, paramString2, paramString3));
    GAUsage.getInstance().setDisableUsage(false);
  }
  
  public void trackTransaction(Transaction paramTransaction)
  {
    assertTrackerOpen();
    GAUsage.getInstance().setUsage(GAUsage.Field.TRACK_TRANSACTION);
    GAUsage.getInstance().setDisableUsage(true);
    internalSend("tran", constructTransaction(paramTransaction));
    Iterator localIterator = paramTransaction.getItems().iterator();
    while (localIterator.hasNext()) {
      internalSend("item", constructItem((Item)localIterator.next(), paramTransaction));
    }
    GAUsage.getInstance().setDisableUsage(false);
  }
  
  public void trackView()
  {
    assertTrackerOpen();
    if (TextUtils.isEmpty(this.model.get("description"))) {
      throw new IllegalStateException("trackView requires a appScreen to be set");
    }
    GAUsage.getInstance().setUsage(GAUsage.Field.TRACK_VIEW);
    internalSend("appview", null);
  }
  
  public void trackView(String paramString)
  {
    assertTrackerOpen();
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalStateException("trackView requires a appScreen to be set");
    }
    GAUsage.getInstance().setUsage(GAUsage.Field.TRACK_VIEW_WITH_APPSCREEN);
    this.model.set("description", paramString);
    internalSend("appview", null);
  }
  
  private static class SimpleModel
  {
    private Map<String, String> permanentMap = new HashMap();
    private Map<String, String> temporaryMap = new HashMap();
    
    public void clearTemporaryValues()
    {
      try
      {
        this.temporaryMap.clear();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    /* Error */
    public String get(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 20	com/google/analytics/tracking/android/GoogleTracker$SimpleModel:temporaryMap	Ljava/util/Map;
      //   6: aload_1
      //   7: invokeinterface 36 2 0
      //   12: checkcast 38	java/lang/String
      //   15: astore_2
      //   16: aload_2
      //   17: ifnull +9 -> 26
      //   20: aload_2
      //   21: astore_1
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_1
      //   25: areturn
      //   26: aload_0
      //   27: getfield 22	com/google/analytics/tracking/android/GoogleTracker$SimpleModel:permanentMap	Ljava/util/Map;
      //   30: aload_1
      //   31: invokeinterface 36 2 0
      //   36: checkcast 38	java/lang/String
      //   39: astore_1
      //   40: goto -18 -> 22
      //   43: astore_1
      //   44: aload_0
      //   45: monitorexit
      //   46: aload_1
      //   47: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	48	0	this	SimpleModel
      //   0	48	1	paramString	String
      //   15	6	2	str	String
      // Exception table:
      //   from	to	target	type
      //   2	16	43	finally
      //   26	40	43	finally
    }
    
    public Map<String, String> getKeysAndValues()
    {
      try
      {
        HashMap localHashMap = new HashMap(this.permanentMap);
        localHashMap.putAll(this.temporaryMap);
        return localHashMap;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void set(String paramString1, String paramString2)
    {
      try
      {
        this.permanentMap.put(paramString1, paramString2);
        return;
      }
      finally
      {
        paramString1 = finally;
        throw paramString1;
      }
    }
    
    /* Error */
    public void setAll(Map<String, String> paramMap, Boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_2
      //   3: invokevirtual 62	java/lang/Boolean:booleanValue	()Z
      //   6: ifeq +16 -> 22
      //   9: aload_0
      //   10: getfield 20	com/google/analytics/tracking/android/GoogleTracker$SimpleModel:temporaryMap	Ljava/util/Map;
      //   13: aload_1
      //   14: invokeinterface 46 2 0
      //   19: aload_0
      //   20: monitorexit
      //   21: return
      //   22: aload_0
      //   23: getfield 22	com/google/analytics/tracking/android/GoogleTracker$SimpleModel:permanentMap	Ljava/util/Map;
      //   26: aload_1
      //   27: invokeinterface 46 2 0
      //   32: goto -13 -> 19
      //   35: astore_1
      //   36: aload_0
      //   37: monitorexit
      //   38: aload_1
      //   39: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	40	0	this	SimpleModel
      //   0	40	1	paramMap	Map<String, String>
      //   0	40	2	paramBoolean	Boolean
      // Exception table:
      //   from	to	target	type
      //   2	19	35	finally
      //   22	32	35	finally
    }
    
    public void setForNextHit(String paramString1, String paramString2)
    {
      try
      {
        this.temporaryMap.put(paramString1, paramString2);
        return;
      }
      finally
      {
        paramString1 = finally;
        throw paramString1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/analytics/tracking/android/GoogleTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */