package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.c;
import com.google.android.gms.internal.jx;

public abstract class GamesDowngradeableSafeParcel
  extends c
{
  protected static boolean c(Integer paramInteger)
  {
    if (paramInteger == null) {
      return false;
    }
    return jx.aQ(paramInteger.intValue());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/games/internal/GamesDowngradeableSafeParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */