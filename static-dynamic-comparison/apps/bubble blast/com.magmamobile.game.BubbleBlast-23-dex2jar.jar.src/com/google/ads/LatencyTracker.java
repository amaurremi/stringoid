package com.google.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.SystemClock;

class LatencyTracker
{
  private static final String CLICK_LATENCY = "click_latency";
  private static final String CLICK_START = "click_start";
  private static final String CLICK_STRING = "click_string";
  private static final String CURRENT_CLICK_STRING = "current_click_string";
  private static final String FETCH_LATENCY = "fetch_latency";
  private static final String FETCH_START = "fetch_start";
  private static final String LATENCY_PREFERENCES = "latency_preferences";
  private Clock mClock;
  private PersistentState mPersistent;
  private TransientState mTransient;
  
  public LatencyTracker(Context paramContext)
  {
    this.mClock = new RealClock(null);
    this.mTransient = new TransientState(null);
    this.mPersistent = new PersistentState(paramContext, null);
    this.mPersistent.restore();
  }
  
  LatencyTracker(Clock paramClock, SharedPreferences paramSharedPreferences)
  {
    this.mClock = paramClock;
    this.mTransient = new TransientState(null);
    this.mPersistent = new PersistentState(paramSharedPreferences, null);
    this.mPersistent.restore();
  }
  
  public void clear()
  {
    this.mPersistent.clear();
  }
  
  public int getAdClickLatency()
  {
    return this.mPersistent.mAdClickLatency;
  }
  
  public int getAdFetchLatency()
  {
    return this.mPersistent.mAdFetchLatency;
  }
  
  public String getClickString()
  {
    return this.mPersistent.mClickString;
  }
  
  public boolean hasAdClickLatency()
  {
    return this.mPersistent.mAdClickLatency != -1;
  }
  
  public boolean hasAdFetchLatency()
  {
    return this.mPersistent.mAdFetchLatency != -1;
  }
  
  public boolean hasClickString()
  {
    return (this.mPersistent.mClickString != null) && (this.mPersistent.mClickString.length() > 0);
  }
  
  public void onAdClickStart(String paramString)
  {
    TransientState.access$802(this.mTransient, this.mClock.elapsedRealtime());
    TransientState.access$902(this.mTransient, paramString);
  }
  
  public void onAdFetchFinished()
  {
    if (this.mTransient.mAdFetchStartTimestamp == -1L) {
      return;
    }
    PersistentState.access$602(this.mPersistent, (int)(this.mClock.elapsedRealtime() - this.mTransient.mAdFetchStartTimestamp));
    TransientState.access$502(this.mTransient, -1L);
    this.mPersistent.save();
  }
  
  public void onAdFetchStart()
  {
    TransientState.access$502(this.mTransient, this.mClock.elapsedRealtime());
  }
  
  public void onWindowGetFocus()
  {
    if (this.mTransient.mAdClickStartTimestamp == -1L) {
      return;
    }
    PersistentState.access$1002(this.mPersistent, (int)(this.mClock.elapsedRealtime() - this.mTransient.mAdClickStartTimestamp));
    PersistentState.access$1102(this.mPersistent, this.mTransient.mCurrentClickString);
    TransientState.access$802(this.mTransient, -1L);
    this.mPersistent.save();
  }
  
  public void restoreTransientState(Bundle paramBundle)
  {
    this.mTransient.restore(paramBundle);
  }
  
  public void saveTransientState(Bundle paramBundle)
  {
    this.mTransient.save(paramBundle);
  }
  
  public String toString()
  {
    return "Latency[fstart=" + this.mTransient.mAdFetchStartTimestamp + ", " + "cstart=" + this.mTransient.mAdClickStartTimestamp + ", " + "ccstr=" + this.mTransient.mCurrentClickString + ", " + "flat=" + this.mPersistent.mAdFetchLatency + ", " + "clat=" + this.mPersistent.mAdClickLatency + ", " + "cstr=" + this.mPersistent.mClickString + "]";
  }
  
  static abstract interface Clock
  {
    public abstract long elapsedRealtime();
  }
  
  private class PersistentState
  {
    private static final String CLICK_LATENCY = "click_latency";
    private static final String CLICK_STRING = "click_string";
    private static final String FETCH_LATENCY = "fetch_latency";
    private static final String LATENCY_PREFERENCES = "google_ads.xml";
    private int mAdClickLatency = -1;
    private int mAdFetchLatency = -1;
    private String mClickString = null;
    private SharedPreferences mSharedPreferences;
    
    private PersistentState(Context paramContext)
    {
      this.mSharedPreferences = paramContext.getSharedPreferences("google_ads.xml", 0);
    }
    
    private PersistentState(SharedPreferences paramSharedPreferences)
    {
      this.mSharedPreferences = paramSharedPreferences;
    }
    
    private void clear()
    {
      this.mAdFetchLatency = -1;
      this.mAdClickLatency = -1;
      this.mClickString = null;
      save();
    }
    
    private void restore()
    {
      if (this.mSharedPreferences == null) {
        return;
      }
      this.mAdFetchLatency = this.mSharedPreferences.getInt("fetch_latency", -1);
      this.mAdClickLatency = this.mSharedPreferences.getInt("click_latency", -1);
      this.mClickString = this.mSharedPreferences.getString("click_string", null);
    }
    
    private void save()
    {
      if (this.mSharedPreferences == null) {
        return;
      }
      SharedPreferences.Editor localEditor = this.mSharedPreferences.edit();
      localEditor.putInt("fetch_latency", this.mAdFetchLatency);
      localEditor.putInt("click_latency", this.mAdClickLatency);
      localEditor.putString("click_string", this.mClickString);
      localEditor.commit();
    }
  }
  
  private class RealClock
    implements LatencyTracker.Clock
  {
    private RealClock() {}
    
    public long elapsedRealtime()
    {
      return SystemClock.elapsedRealtime();
    }
  }
  
  private class TransientState
  {
    private static final String CLICK_START = "click_start";
    private static final String CURRENT_CLICK_STRING = "current_click_string";
    private static final String FETCH_START = "fetch_start";
    private long mAdClickStartTimestamp = -1L;
    private long mAdFetchStartTimestamp = -1L;
    private String mCurrentClickString = null;
    
    private TransientState() {}
    
    private void restore(Bundle paramBundle)
    {
      this.mAdFetchStartTimestamp = paramBundle.getLong("fetch_start");
      this.mAdClickStartTimestamp = paramBundle.getLong("click_start");
      this.mCurrentClickString = paramBundle.getString("current_click_string");
    }
    
    private void save(Bundle paramBundle)
    {
      paramBundle.putLong("fetch_start", this.mAdFetchStartTimestamp);
      paramBundle.putLong("click_start", this.mAdClickStartTimestamp);
      paramBundle.putString("current_click_string", this.mCurrentClickString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/LatencyTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */