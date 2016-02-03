package cmn;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

final class i
  implements Callable
{
  i(Context paramContext) {}
  
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */