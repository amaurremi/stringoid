package a.a.a;

import android.content.Context;
import android.content.SharedPreferences;

public class h
{
  public static long a(Context paramContext)
  {
    if (!b(paramContext)) {
      return 0L;
    }
    return c(paramContext).getLong("usageTime" + a.b, 0L) / 1000L;
  }
  
  private static boolean b(Context paramContext)
  {
    if (a.b == null)
    {
      a.a(paramContext);
      if (a.b == null) {
        return false;
      }
    }
    return true;
  }
  
  private static SharedPreferences c(Context paramContext)
  {
    return paramContext.getSharedPreferences("HockeyApp", 0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/a/a/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */