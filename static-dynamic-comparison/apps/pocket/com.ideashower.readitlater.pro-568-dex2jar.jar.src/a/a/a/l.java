package a.a.a;

import a.a.a.c.a;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask.Status;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.Date;

public class l
{
  private static a a = null;
  private static m b = null;
  
  @SuppressLint({"NewApi"})
  public static Boolean a()
  {
    try
    {
      if ((Build.VERSION.SDK_INT >= 11) && (Fragment.class != null)) {}
      for (boolean bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
      return Boolean.valueOf(false);
    }
    catch (NoClassDefFoundError localNoClassDefFoundError) {}
  }
  
  public static Boolean a(WeakReference paramWeakReference)
  {
    if (paramWeakReference != null)
    {
      paramWeakReference = (Activity)paramWeakReference.get();
      if (paramWeakReference != null)
      {
        paramWeakReference = paramWeakReference.getResources().getConfiguration();
        if (((paramWeakReference.screenLayout & 0xF) == 3) || ((paramWeakReference.screenLayout & 0xF) == 4)) {}
        for (boolean bool = true;; bool = false) {
          return Boolean.valueOf(bool);
        }
      }
    }
    return Boolean.valueOf(false);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    a(paramActivity, paramString, null);
  }
  
  public static void a(Activity paramActivity, String paramString, m paramm)
  {
    a(paramActivity, "https://sdk.hockeyapp.net/", paramString, paramm);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, m paramm)
  {
    b = paramm;
    paramActivity = new WeakReference(paramActivity);
    if ((a().booleanValue()) && (d(paramActivity))) {}
    while ((a(paramActivity, paramm)) || (b(paramActivity))) {
      return;
    }
    a(paramActivity, paramString1, paramString2, paramm);
  }
  
  private static void a(WeakReference paramWeakReference, String paramString1, String paramString2, m paramm)
  {
    if ((a == null) || (a.getStatus() == AsyncTask.Status.FINISHED))
    {
      a = new a(paramWeakReference, paramString1, paramString2, paramm);
      a.execute(new String[0]);
      return;
    }
    a.a(paramWeakReference);
  }
  
  private static boolean a(WeakReference paramWeakReference, m paramm)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramm != null)
    {
      Date localDate = paramm.e();
      if ((localDate != null) && (new Date().compareTo(localDate) > 0))
      {
        bool1 = true;
        bool3 = bool1;
        if (bool1) {
          bool2 = paramm.f();
        }
      }
    }
    for (boolean bool3 = bool1;; bool3 = false)
    {
      if ((bool3) && (bool2)) {
        c(paramWeakReference);
      }
      return bool3;
      bool1 = false;
      break;
    }
  }
  
  public static m b()
  {
    return b;
  }
  
  private static boolean b(WeakReference paramWeakReference)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    paramWeakReference = (Activity)paramWeakReference.get();
    if (paramWeakReference != null) {
      try
      {
        paramWeakReference = paramWeakReference.getPackageManager().getInstallerPackageName(paramWeakReference.getPackageName());
        if (Build.VERSION.SDK_INT >= 9)
        {
          if ((paramWeakReference == null) || (paramWeakReference.isEmpty())) {
            break label80;
          }
          bool1 = true;
        }
        else
        {
          if (paramWeakReference != null)
          {
            int i = paramWeakReference.length();
            if (i <= 0) {}
          }
          for (bool1 = bool2;; bool1 = false) {
            break;
          }
        }
        return bool1;
      }
      catch (Throwable paramWeakReference)
      {
        return false;
      }
    }
    for (;;)
    {
      label80:
      bool1 = false;
    }
  }
  
  private static void c(WeakReference paramWeakReference)
  {
    if (paramWeakReference != null)
    {
      paramWeakReference = (Activity)paramWeakReference.get();
      if (paramWeakReference != null)
      {
        paramWeakReference.finish();
        Intent localIntent = new Intent(paramWeakReference, e.class);
        localIntent.addFlags(335544320);
        paramWeakReference.startActivity(localIntent);
      }
    }
  }
  
  @TargetApi(11)
  private static boolean d(WeakReference paramWeakReference)
  {
    if (paramWeakReference != null)
    {
      paramWeakReference = (Activity)paramWeakReference.get();
      if (paramWeakReference != null) {
        return paramWeakReference.getFragmentManager().findFragmentByTag("hockey_update_dialog") != null;
      }
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/a/a/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */