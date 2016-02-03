package com.bluebird.mobile.tools.score;

import android.content.Context;
import com.bluebird.mobile.tools.PreferencesName;
import java.util.HashMap;
import java.util.Map;

public class ScoreServiceDefaultFactory
{
  private static final Map<String, ScoreService> instances = new HashMap();
  
  public static ScoreService getInstance(Context paramContext, PreferencesName paramPreferencesName)
  {
    ScoreService localScoreService = (ScoreService)instances.get(paramPreferencesName.name());
    Object localObject = localScoreService;
    if (localScoreService == null)
    {
      localObject = new ScoreServiceImpl(paramContext, paramPreferencesName);
      instances.put(paramPreferencesName.name(), localObject);
    }
    return (ScoreService)localObject;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/score/ScoreServiceDefaultFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */