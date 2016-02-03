package com.bluebird.mobile.tools.capping;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.bluebird.mobile.tools.storage.SharedPreferencesUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CappingEvent
{
  private CappingParams cappingParams;
  
  private Set<Long> convertStringsToLongs(Set<String> paramSet)
  {
    HashSet localHashSet = new HashSet();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      localHashSet.add(Long.valueOf((String)paramSet.next()));
    }
    return localHashSet;
  }
  
  private SharedPreferences.Editor getCappingSharedPreferences(Context paramContext)
  {
    return paramContext.getSharedPreferences("capping", 0).edit();
  }
  
  private Set<Long> getEventTimestampsInTimeDefinision(Set<Long> paramSet)
  {
    long l1 = System.currentTimeMillis();
    long l2 = TimeUnit.MILLISECONDS.convert(this.cappingParams.duration, this.cappingParams.timeUnit);
    HashSet localHashSet = new HashSet();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      Long localLong = (Long)paramSet.next();
      if (l1 - localLong.longValue() < l2) {
        localHashSet.add(localLong);
      }
    }
    return localHashSet;
  }
  
  private void useInAsync(final Context paramContext, final boolean paramBoolean)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        SharedPreferences.Editor localEditor = CappingEvent.this.getCappingSharedPreferences(paramContext);
        Object localObject1 = new HashSet(SharedPreferencesUtils.getStringArrayPref(paramContext, "timestamps-" + CappingEvent.CappingParams.access$000(CappingEvent.this.cappingParams)));
        localObject1 = CappingEvent.this.convertStringsToLongs((Set)localObject1);
        Object localObject2 = CappingEvent.this.getEventTimestampsInTimeDefinision((Set)localObject1);
        ((Set)localObject2).add(Long.valueOf(System.currentTimeMillis()));
        localObject1 = new HashSet();
        localObject2 = ((Set)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Set)localObject1).add(String.valueOf((Long)((Iterator)localObject2).next()));
        }
        SharedPreferencesUtils.setStringArrayPref(paramContext, "timestamps-" + CappingEvent.CappingParams.access$000(CappingEvent.this.cappingParams), new ArrayList((Collection)localObject1));
        localEditor.commit();
        if (paramBoolean) {
          CappingEvent.this.increaseUsageCount(paramContext);
        }
      }
    }).start();
  }
  
  public boolean canBeUsed(Context paramContext)
  {
    int i = paramContext.getSharedPreferences("capping", 0).getInt("usageCount-" + this.cappingParams.eventName, 0);
    if ((this.cappingParams.skipFirstUsages > 0) && (i <= this.cappingParams.skipFirstUsages - 1)) {}
    while (getEventTimestampsInTimeDefinision(convertStringsToLongs(new HashSet(SharedPreferencesUtils.getStringArrayPref(paramContext, "timestamps-" + this.cappingParams.eventName)))).size() >= this.cappingParams.times) {
      return false;
    }
    return true;
  }
  
  public boolean canBeUsedAndIncreaseUsage(final Context paramContext)
  {
    boolean bool = canBeUsed(paramContext);
    if (bool)
    {
      useInAsync(paramContext, true);
      return bool;
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        CappingEvent.this.increaseUsageCount(paramContext);
      }
    }).start();
    return bool;
  }
  
  public void increaseUsageCount(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("capping", 0);
    SharedPreferences.Editor localEditor = paramContext.edit();
    int i = paramContext.getInt("usageCount-" + this.cappingParams.eventName, 0);
    localEditor.putInt("usageCount-" + this.cappingParams.eventName, i + 1);
    localEditor.commit();
  }
  
  public void useInAsync(Context paramContext)
  {
    useInAsync(paramContext, false);
  }
  
  public static class Builder
  {
    private CappingEvent.CappingParams cappingParams = new CappingEvent.CappingParams();
    
    public CappingEvent create()
    {
      CappingEvent localCappingEvent = new CappingEvent();
      CappingEvent.access$402(localCappingEvent, this.cappingParams);
      return localCappingEvent;
    }
    
    public Builder setDuration(long paramLong)
    {
      CappingEvent.CappingParams.access$702(this.cappingParams, paramLong);
      return this;
    }
    
    public Builder setEventName(String paramString)
    {
      CappingEvent.CappingParams.access$002(this.cappingParams, paramString);
      return this;
    }
    
    public Builder setTimeUnit(TimeUnit paramTimeUnit)
    {
      CappingEvent.CappingParams.access$802(this.cappingParams, paramTimeUnit);
      return this;
    }
    
    public Builder setTimes(int paramInt)
    {
      CappingEvent.CappingParams.access$202(this.cappingParams, paramInt);
      return this;
    }
    
    public Builder skipFirstUsages(int paramInt)
    {
      CappingEvent.CappingParams.access$102(this.cappingParams, paramInt);
      return this;
    }
  }
  
  static class CappingParams
  {
    private long duration = 1L;
    private String eventName;
    private int skipFirstUsages = 0;
    private TimeUnit timeUnit = TimeUnit.SECONDS;
    private int times = 1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/capping/CappingEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */