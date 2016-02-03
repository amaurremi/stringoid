package cmn;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(8)
public class a
{
  private static a a = null;
  private final AtomicInteger b = new AtomicInteger(1);
  
  public static a a()
  {
    for (;;)
    {
      try
      {
        if (a == null)
        {
          if (Build.VERSION.SDK_INT >= 17) {
            a = new f();
          }
        }
        else
        {
          a locala = a;
          return locala;
        }
        if (Build.VERSION.SDK_INT >= 16)
        {
          a = new e();
          continue;
        }
        if (Build.VERSION.SDK_INT < 13) {
          break label84;
        }
      }
      finally {}
      a = new d();
      continue;
      label84:
      if (Build.VERSION.SDK_INT >= 11) {
        a = new c();
      } else if (Build.VERSION.SDK_INT >= 9) {
        a = new g();
      } else {
        a = new a();
      }
    }
  }
  
  public long a(PackageInfo paramPackageInfo)
  {
    return 0L;
  }
  
  public long a(PackageInfo paramPackageInfo, ApplicationInfo paramApplicationInfo)
  {
    paramPackageInfo = paramApplicationInfo.publicSourceDir;
    try
    {
      long l = new File(paramPackageInfo).lastModified();
      return l;
    }
    catch (Throwable paramPackageInfo) {}
    return 0L;
  }
  
  public Point a(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = paramContext.getDefaultDisplay())
    {
      Point localPoint = new Point();
      if (paramContext != null)
      {
        localPoint.x = paramContext.getWidth();
        localPoint.y = paramContext.getHeight();
      }
      return localPoint;
    }
  }
  
  public void a(Activity paramActivity) {}
  
  public void a(SharedPreferences.Editor paramEditor)
  {
    paramEditor.commit();
  }
  
  public void a(View paramView) {}
  
  public void a(View paramView, Drawable paramDrawable)
  {
    paramView.setBackgroundDrawable(paramDrawable);
  }
  
  public void b(SharedPreferences.Editor paramEditor)
  {
    new Thread(new b(this, paramEditor)).start();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */