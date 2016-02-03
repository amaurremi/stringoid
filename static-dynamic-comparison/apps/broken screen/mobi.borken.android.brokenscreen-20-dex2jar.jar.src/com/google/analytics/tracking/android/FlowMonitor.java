package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

class FlowMonitor
{
  static final String HITS_DISPATCHED = "hitsDispatched";
  static final String HITS_DISPATCHED_PARAM = "_s";
  static final String HITS_GENERATED = "hitsGenerated";
  static final String HITS_GENERATED_PARAM = "_g";
  static final String HITS_PAST_PROXY = "hitsPastProxy";
  static final String HITS_PAST_PROXY_PARAM = "_p";
  static final String HITS_STORED_IN_DB = "hitsStoredInDb";
  static final String HITS_STORED_IN_DB_PARAM = "_d";
  private static final int HIT_INTERVAL = 50;
  static final String LAST_QUERY_TIMESTAMP = "lastQueryTimestamp";
  static final String LAST_QUERY_TIMESTAMP_PARAM = "_ts";
  static final String MONITOR_TYPE = "flow";
  static final String MONITOR_TYPE_PARAM = "_t";
  static final String PREFERENCES_LABEL = "GoogleAnalytics";
  private static final long TIME_INTERVAL = 14400000L;
  private static FlowMonitor sInstance;
  SharedPreferences.Editor mEditor;
  private int mHitsDispatched;
  private int mHitsGenerated;
  private int mHitsPastProxy;
  private int mHitsStoredInDb;
  private long mLastQueryTimeStamp;
  SharedPreferences mPersistentStore;
  
  @VisibleForTesting
  FlowMonitor(Context paramContext)
  {
    this.mPersistentStore = paramContext.getSharedPreferences("GoogleAnalytics", 0);
    this.mEditor = this.mPersistentStore.edit();
    this.mHitsGenerated = this.mPersistentStore.getInt("hitsGenerated", 0);
    this.mHitsPastProxy = this.mPersistentStore.getInt("hitsPastProxy", 0);
    this.mHitsStoredInDb = this.mPersistentStore.getInt("hitsStoredInDb", 0);
    this.mHitsDispatched = this.mPersistentStore.getInt("hitsDispatched", 0);
    this.mLastQueryTimeStamp = this.mPersistentStore.getLong("lastQueryTimestamp", 0L);
    if (this.mLastQueryTimeStamp == 0L)
    {
      this.mLastQueryTimeStamp = System.currentTimeMillis();
      this.mEditor.putLong("lastQueryTimestamp", this.mLastQueryTimeStamp);
      this.mEditor.commit();
    }
  }
  
  public static FlowMonitor getInstance(Context paramContext)
  {
    if (sInstance == null) {
      sInstance = new FlowMonitor(paramContext);
    }
    return sInstance;
  }
  
  public String buildAndResetHitsDispatched()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("_s").append("=").append(this.mHitsDispatched);
    this.mHitsDispatched = 0;
    this.mEditor.putInt("hitsDispatched", this.mHitsDispatched);
    this.mEditor.commit();
    return localStringBuilder.toString();
  }
  
  public Map<String, String> generateHit()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("_t", "flow");
    localHashMap.put("_ts", String.valueOf(this.mLastQueryTimeStamp));
    this.mLastQueryTimeStamp = System.currentTimeMillis();
    this.mEditor.putLong("lastQueryTimestamp", this.mLastQueryTimeStamp);
    localHashMap.put("_g", getAndResetHitsGeneratedParameter());
    return localHashMap;
  }
  
  String getAndResetHitsGeneratedParameter()
  {
    int i = this.mHitsGenerated;
    this.mHitsGenerated = 0;
    this.mEditor.putInt("hitsGenerated", 0);
    this.mEditor.commit();
    return String.valueOf(i);
  }
  
  public String getAndResetHitsPastProxy()
  {
    int i = this.mHitsPastProxy;
    this.mHitsPastProxy = 0;
    this.mEditor.putInt("hitsPastProxy", this.mHitsPastProxy);
    this.mEditor.commit();
    return String.valueOf(i);
  }
  
  public String getAndResetHitsStoredInDb()
  {
    int i = this.mHitsStoredInDb;
    this.mHitsStoredInDb = 0;
    this.mEditor.putInt("hitsStoredInDb", this.mHitsStoredInDb);
    this.mEditor.commit();
    return String.valueOf(i);
  }
  
  public void incrementHitsDispatched(int paramInt)
  {
    this.mHitsDispatched += paramInt;
    this.mEditor.putInt("hitsDispatched", paramInt);
    this.mEditor.commit();
  }
  
  public void incrementHitsGenerated(int paramInt)
  {
    this.mHitsGenerated += paramInt;
    this.mEditor.putInt("hitsGenerated", paramInt);
    this.mEditor.commit();
  }
  
  public void incrementHitsPastProxy(int paramInt)
  {
    this.mHitsPastProxy += paramInt;
    this.mEditor.putInt("hitsPastProxy", paramInt);
    this.mEditor.commit();
  }
  
  public void incrementHitsStoredInDb(int paramInt)
  {
    this.mHitsStoredInDb += paramInt;
    this.mEditor.putInt("hitsStoredInDb", paramInt);
    this.mEditor.commit();
  }
  
  public boolean shouldReport()
  {
    return (this.mHitsGenerated >= 50) && (System.currentTimeMillis() - this.mLastQueryTimeStamp >= 14400000L);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/analytics/tracking/android/FlowMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */