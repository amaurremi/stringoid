package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class d
{
  public static final a a = a.i;
  
  public static String a()
  {
    switch (1.a[a.ordinal()])
    {
    default: 
      return "https://api.crittercism.com";
    case 1: 
      return "http://10.0.2.2:6013";
    case 2: 
      return "http://192.168.2.1:6013";
    case 3: 
      return "http://192.168.1.110:6013";
    case 4: 
      return "http://192.168.1.80:6013";
    case 5: 
      return "http://10.0.1.7:6013";
    case 6: 
      return "http://192.168.1.185:6013";
    case 7: 
      return "http://192.168.1.100:6013";
    }
    return "https://www.appcred.com";
  }
  
  public static String a(Context paramContext, String paramString)
  {
    Object localObject = null;
    try
    {
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("com.crittercism.prefs", 0);
      paramContext = (Context)localObject;
      if (localSharedPreferences != null) {
        paramContext = localSharedPreferences.getString(paramString, null);
      }
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("com.crittercism.prefs", 0);
      if (paramContext != null)
      {
        paramContext = paramContext.edit();
        if (paramContext != null)
        {
          paramContext.remove(paramString1);
          paramContext.putString(paramString1, paramString2);
          paramContext.commit();
        }
      }
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.toString();
    }
  }
  
  public static String b()
  {
    return "3.0.8";
  }
  
  public static enum a {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/crittercism/android/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */