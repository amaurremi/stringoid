package com.scoreloop.client.android.core.controller;

import android.content.Context;

final class j
  implements LocalAchievementsController.a
{
  public AchievementsStore a(Context paramContext, String paramString)
  {
    return new SharedPreferencesAchievementsStore(paramContext, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/scoreloop/client/android/core/controller/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */