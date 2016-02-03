package com.google.android.gms.internal;

import android.os.SystemClock;

public final class jw
  implements ju
{
  private static jw MK;
  
  public static ju hA()
  {
    try
    {
      if (MK == null) {
        MK = new jw();
      }
      jw localjw = MK;
      return localjw;
    }
    finally {}
  }
  
  public long currentTimeMillis()
  {
    return System.currentTimeMillis();
  }
  
  public long elapsedRealtime()
  {
    return SystemClock.elapsedRealtime();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/jw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */