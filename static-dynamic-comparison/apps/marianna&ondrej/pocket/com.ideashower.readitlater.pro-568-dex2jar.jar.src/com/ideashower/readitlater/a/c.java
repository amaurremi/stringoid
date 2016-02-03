package com.ideashower.readitlater.a;

import android.app.Activity;
import com.ideashower.readitlater.util.j;
import com.ideashower.readitlater.util.q;
import java.util.Locale;

public abstract class c
{
  public static boolean a()
  {
    String str = a.b("getstarted_android_flow_v1", true, false);
    if (str.equals("app_demo_v1.1")) {
      return true;
    }
    if (str.equals("control")) {
      return false;
    }
    a.a(str);
    return false;
  }
  
  public static boolean a(Activity paramActivity)
  {
    if (!as.t()) {}
    do
    {
      do
      {
        return false;
      } while (!b(paramActivity));
      paramActivity = a.b("getstarted_android_reader_tooltips_v1", true, false);
      if (paramActivity.equals("tooltips_v1.1")) {
        return true;
      }
    } while (paramActivity.equals("control"));
    a.a(paramActivity);
    return false;
  }
  
  public static boolean b()
  {
    if (!as.t()) {}
    String str;
    do
    {
      return true;
      str = a.b("getstarted_android_skip_v1", true, false);
    } while (str.equals("control"));
    if (str.equals("no_skip_v1.1")) {
      return false;
    }
    a.a(str);
    return false;
  }
  
  private static boolean b(Activity paramActivity)
  {
    if (j.c()) {}
    while (q.b(paramActivity).b(true) >= 555) {
      return true;
    }
    return false;
  }
  
  public static String c()
  {
    d locald = a.c("getstarted_android_browser_url_v1", true, false);
    if (d.a(locald).equals("control")) {
      return null;
    }
    return d.b(locald);
  }
  
  public static boolean d()
  {
    if (!as.t()) {}
    String str;
    do
    {
      do
      {
        return false;
      } while (!Locale.getDefault().getLanguage().equals(Locale.ENGLISH.getLanguage()));
      str = a.b("getstarted_android_list_tooltips_v1", true, false);
      if (str.equals("tooltips_v1.1")) {
        return true;
      }
    } while (str.equals("control"));
    a.a(str);
    return false;
  }
  
  public static boolean e()
  {
    String str = a.b("howtosave_android_apps_v1", true, false);
    if (str.equals("control")) {
      return true;
    }
    if (str.equals("no_demos_v1.1")) {
      return false;
    }
    a.a(str);
    return false;
  }
  
  public static boolean f()
  {
    String str = a.b("getstarted_android_return_to_pocket_v1", true, false);
    if (str.equals("no_return_v1.1")) {
      return true;
    }
    if (str.equals("control")) {
      return false;
    }
    a.a(str);
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */