package a.a.a.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class d
{
  private static String a = "versionInfo";
  
  public static String a(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences("HockeyApp", 0).getString(a, "[]");
    }
    return "[]";
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("HockeyApp", 0).edit();
      paramContext.putString(a, paramString);
      c.a(paramContext);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/a/a/a/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */