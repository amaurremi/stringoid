package crittercism.android;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;

public final class a
{
  private static String a = "";
  private static String b = "en";
  
  public static String a(int paramInt)
  {
    return b.a(paramInt);
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      a = paramContext.getCacheDir().getAbsolutePath();
      b.a();
      b = b(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("Crittercism", "Unable to initialize Crittercism's resources. Please report this error to support@crittercism.com.");
    }
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getResources().getConfiguration().locale.getLanguage();
      b = paramContext;
      if ((paramContext == null) || (b.equals(""))) {
        b = "en";
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        new StringBuilder("Exception in getLocale(): ").append(paramContext.getClass().getName()).toString();
      }
    }
    return b;
  }
  
  public static final class a
  {
    public static String a = "uhe";
    public static String b = "uhe-bg";
    public static String c = "he";
    public static String d = "he-bg";
    public static String e = "appload";
    public static String f = "error";
  }
  
  public static final class b
  {
    private static HashMap a = new HashMap();
    private static final String b = a.a() + "/strings/";
    
    public static String a(int paramInt)
    {
      String str = "";
      try
      {
        if (a.containsKey(Integer.valueOf(paramInt))) {
          str = (String)a.get(Integer.valueOf(paramInt));
        }
        return str;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public static void a()
    {
      a.put(Integer.valueOf(10), "Error: no internet connection");
      a.put(Integer.valueOf(11), "Error: connection timed out, please try again later.");
      a.put(Integer.valueOf(13), "Unknown Error");
      a.put(Integer.valueOf(28), "Developer Reply");
      a.put(Integer.valueOf(29), "Loading...");
    }
  }
  
  public static final class c
  {
    public static final String a = ;
    public static final String b = a + "/android_v2/handle_app_loads";
    public static final String c = a + "/android_v2/handle_exceptions";
    public static final String d = a + "/android_v2/handle_crashes";
    public static final String e = a + "/android_v2/update_user_metadata";
    public static final String f = a + "/android_v2/update_package_name";
    public static final String g = a + "/android_v2/ndk_crash";
    public static final String h = a + "/forum/springboard";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/crittercism/android/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */