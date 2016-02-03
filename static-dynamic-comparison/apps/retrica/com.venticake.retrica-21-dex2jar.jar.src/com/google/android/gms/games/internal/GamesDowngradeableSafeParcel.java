package com.google.android.gms.games.internal;

import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.im;

public abstract class GamesDowngradeableSafeParcel
  extends ha
{
  protected static boolean c(Integer paramInteger)
  {
    if (paramInteger == null) {
      return false;
    }
    return im.aE(paramInteger.intValue());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/GamesDowngradeableSafeParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */