package cmn;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

final class y
  implements Callable
{
  y(Context paramContext) {}
  
  private List a()
  {
    Object localObject = this.a.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getInstalledPackages(this.b);
      return (List)localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return new ArrayList();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/cmn/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */