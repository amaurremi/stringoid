package cmn;

import android.annotation.TargetApi;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

@TargetApi(9)
public class g
  extends a
{
  public final long a(PackageInfo paramPackageInfo)
  {
    return paramPackageInfo.firstInstallTime;
  }
  
  public final long a(PackageInfo paramPackageInfo, ApplicationInfo paramApplicationInfo)
  {
    return paramPackageInfo.firstInstallTime;
  }
  
  public final void a(SharedPreferences.Editor paramEditor)
  {
    paramEditor.apply();
  }
  
  public final void b(SharedPreferences.Editor paramEditor)
  {
    paramEditor.apply();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/cmn/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */