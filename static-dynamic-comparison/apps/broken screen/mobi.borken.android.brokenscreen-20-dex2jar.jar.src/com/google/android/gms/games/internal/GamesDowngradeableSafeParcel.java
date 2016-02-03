package com.google.android.gms.games.internal;

import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.in;

public abstract class GamesDowngradeableSafeParcel
  extends hb
{
  protected static boolean c(Integer paramInteger)
  {
    if (paramInteger == null) {
      return false;
    }
    return in.aE(paramInteger.intValue());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/GamesDowngradeableSafeParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */