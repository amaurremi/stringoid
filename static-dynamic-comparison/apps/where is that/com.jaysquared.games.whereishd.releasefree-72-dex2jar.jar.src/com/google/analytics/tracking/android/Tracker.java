package com.google.analytics.tracking.android;

import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Tracker
{
  static final long MAX_TOKENS = 120000L;
  static final long NUM_TOKENS_PER_HIT = 2000L;
  private final AppFieldsDefaultProvider mAppFieldsDefaultProvider;
  private final ClientIdDefaultProvider mClientIdDefaultProvider;
  private final TrackerHandler mHandler;
  private long mLastTrackTime;
  private final String mName;
  private final Map<String, String> mParams = new HashMap();
  private final ScreenResolutionDefaultProvider mScreenResolutionDefaultProvider;
  private long mTokens = 120000L;
  
  Tracker(String paramString1, String paramString2, TrackerHandler paramTrackerHandler)
  {
    this(paramString1, paramString2, paramTrackerHandler, ClientIdDefaultProvider.getProvider(), ScreenResolutionDefaultProvider.getProvider(), AppFieldsDefaultProvider.getProvider());
  }
  
  @VisibleForTesting
  Tracker(String paramString1, String paramString2, TrackerHandler paramTrackerHandler, ClientIdDefaultProvider paramClientIdDefaultProvider, ScreenResolutionDefaultProvider paramScreenResolutionDefaultProvider, AppFieldsDefaultProvider paramAppFieldsDefaultProvider)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("Tracker name cannot be empty.");
    }
    this.mName = paramString1;
    this.mHandler = paramTrackerHandler;
    this.mParams.put("&tid", paramString2);
    this.mParams.put("useSecure", "1");
    this.mClientIdDefaultProvider = paramClientIdDefaultProvider;
    this.mScreenResolutionDefaultProvider = paramScreenResolutionDefaultProvider;
    this.mAppFieldsDefaultProvider = paramAppFieldsDefaultProvider;
  }
  
  public String get(String paramString)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET);
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (this.mParams.containsKey(paramString)) {
        return (String)this.mParams.get(paramString);
      }
      if (paramString.equals("&ul")) {
        return Utils.getLanguage(Locale.getDefault());
      }
      if ((this.mClientIdDefaultProvider != null) && (this.mClientIdDefaultProvider.providesField(paramString))) {
        return this.mClientIdDefaultProvider.getValue(paramString);
      }
      if ((this.mScreenResolutionDefaultProvider != null) && (this.mScreenResolutionDefaultProvider.providesField(paramString))) {
        return this.mScreenResolutionDefaultProvider.getValue(paramString);
      }
    } while ((this.mAppFieldsDefaultProvider == null) || (!this.mAppFieldsDefaultProvider.providesField(paramString)));
    return this.mAppFieldsDefaultProvider.getValue(paramString);
  }
  
  public String getName()
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.GET_TRACKER_NAME);
    return this.mName;
  }
  
  public void send(Map<String, String> paramMap)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SEND);
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(this.mParams);
    if (paramMap != null) {
      localHashMap.putAll(paramMap);
    }
    if (TextUtils.isEmpty((CharSequence)localHashMap.get("&tid"))) {
      Log.w(String.format("Missing tracking id (%s) parameter.", new Object[] { "&tid" }));
    }
    String str = (String)localHashMap.get("&t");
    paramMap = str;
    if (TextUtils.isEmpty(str))
    {
      Log.w(String.format("Missing hit type (%s) parameter.", new Object[] { "&t" }));
      paramMap = "";
    }
    if ((!paramMap.equals("transaction")) && (!paramMap.equals("item")) && (!tokensAvailable()))
    {
      Log.w("Too many hits sent too quickly, rate limiting invoked.");
      return;
    }
    this.mHandler.sendHit(localHashMap);
  }
  
  public void set(String paramString1, String paramString2)
  {
    GAUsage.getInstance().setUsage(GAUsage.Field.SET);
    if (paramString2 == null)
    {
      this.mParams.remove(paramString1);
      return;
    }
    this.mParams.put(paramString1, paramString2);
  }
  
  @VisibleForTesting
  void setLastTrackTime(long paramLong)
  {
    this.mLastTrackTime = paramLong;
  }
  
  @VisibleForTesting
  void setTokens(long paramLong)
  {
    this.mTokens = paramLong;
  }
  
  /* Error */
  @VisibleForTesting
  boolean tokensAvailable()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 218	java/lang/System:currentTimeMillis	()J
    //   5: lstore_1
    //   6: aload_0
    //   7: getfield 59	com/google/analytics/tracking/android/Tracker:mTokens	J
    //   10: ldc2_w 7
    //   13: lcmp
    //   14: ifge +32 -> 46
    //   17: lload_1
    //   18: aload_0
    //   19: getfield 211	com/google/analytics/tracking/android/Tracker:mLastTrackTime	J
    //   22: lsub
    //   23: lstore_3
    //   24: lload_3
    //   25: lconst_0
    //   26: lcmp
    //   27: ifle +19 -> 46
    //   30: aload_0
    //   31: ldc2_w 7
    //   34: aload_0
    //   35: getfield 59	com/google/analytics/tracking/android/Tracker:mTokens	J
    //   38: lload_3
    //   39: ladd
    //   40: invokestatic 224	java/lang/Math:min	(JJ)J
    //   43: putfield 59	com/google/analytics/tracking/android/Tracker:mTokens	J
    //   46: aload_0
    //   47: lload_1
    //   48: putfield 211	com/google/analytics/tracking/android/Tracker:mLastTrackTime	J
    //   51: aload_0
    //   52: getfield 59	com/google/analytics/tracking/android/Tracker:mTokens	J
    //   55: ldc2_w 10
    //   58: lcmp
    //   59: iflt +23 -> 82
    //   62: aload_0
    //   63: aload_0
    //   64: getfield 59	com/google/analytics/tracking/android/Tracker:mTokens	J
    //   67: ldc2_w 10
    //   70: lsub
    //   71: putfield 59	com/google/analytics/tracking/android/Tracker:mTokens	J
    //   74: iconst_1
    //   75: istore 5
    //   77: aload_0
    //   78: monitorexit
    //   79: iload 5
    //   81: ireturn
    //   82: ldc -30
    //   84: invokestatic 176	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)V
    //   87: iconst_0
    //   88: istore 5
    //   90: goto -13 -> 77
    //   93: astore 6
    //   95: aload_0
    //   96: monitorexit
    //   97: aload 6
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	Tracker
    //   5	43	1	l1	long
    //   23	16	3	l2	long
    //   75	14	5	bool	boolean
    //   93	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	93	finally
    //   30	46	93	finally
    //   46	74	93	finally
    //   82	87	93	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/analytics/tracking/android/Tracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */