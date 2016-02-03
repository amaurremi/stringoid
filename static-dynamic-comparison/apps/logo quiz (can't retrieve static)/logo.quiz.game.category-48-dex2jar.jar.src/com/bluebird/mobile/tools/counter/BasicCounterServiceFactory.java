package com.bluebird.mobile.tools.counter;

import android.content.Context;
import com.bluebird.mobile.tools.PreferencesName;
import java.util.HashMap;
import java.util.Map;

public class BasicCounterServiceFactory
{
  private static CounterService instance;
  private static Map<String, CounterService> instances = new HashMap();
  
  public static CounterService getInstance(Context paramContext, PreferencesName paramPreferencesName)
  {
    return getInstance(paramContext, paramPreferencesName.name());
  }
  
  public static CounterService getInstance(Context paramContext, String paramString)
  {
    CounterService localCounterService = (CounterService)instances.get(paramString);
    Object localObject = localCounterService;
    if (localCounterService == null)
    {
      localObject = new BasicCounterService(paramContext, paramString);
      instances.put(paramString, localObject);
    }
    return (CounterService)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/counter/BasicCounterServiceFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */