package mobi.borken.android.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationMetaDataHelper
{
  private Properties properties = new Properties();
  private int versionCode = 0;
  private String versionName = "unknown";
  
  public ApplicationMetaDataHelper(Context paramContext)
  {
    try
    {
      InputStream localInputStream = paramContext.getAssets().open("app.properties");
      if (localInputStream != null) {
        this.properties.load(localInputStream);
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    paramContext = getPackageInfo(paramContext);
    if (paramContext != null)
    {
      this.versionName = paramContext.versionName;
      this.versionCode = paramContext.versionCode;
    }
  }
  
  public static PackageInfo getPackageInfo(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 128);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public Properties getProperties()
  {
    return this.properties;
  }
  
  public boolean hasProperty(String paramString)
  {
    return this.properties.containsKey(paramString);
  }
  
  public String property(String paramString)
  {
    return getProperties().getProperty(paramString);
  }
  
  public int versionCode()
  {
    return this.versionCode;
  }
  
  public String versionName()
  {
    return this.versionName;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/mobi/borken/android/common/ApplicationMetaDataHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */