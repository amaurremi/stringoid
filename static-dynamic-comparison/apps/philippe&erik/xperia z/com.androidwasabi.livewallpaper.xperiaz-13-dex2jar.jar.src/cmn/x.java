package cmn;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public final class x
{
  public static List a(Context paramContext)
  {
    paramContext = new FutureTask(new y(paramContext));
    f.a(paramContext);
    try
    {
      paramContext = (List)paramContext.get(10L, TimeUnit.SECONDS);
      Object localObject = paramContext;
      if (paramContext == null) {
        localObject = new ArrayList();
      }
      return (List)localObject;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      boolean bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.versionCode >= -1) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/cmn/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */