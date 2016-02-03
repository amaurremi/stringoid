package org.osmdroid.tileprovider.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManifestUtil
{
  private static final Logger logger = LoggerFactory.getLogger(ManifestUtil.class);
  
  public static String retrieveKey(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext.metaData == null) {
        logger.info("Key %s not found in manifest", paramString);
      }
      for (;;)
      {
        return "";
        paramContext = paramContext.metaData.getString(paramString);
        if (paramContext != null) {
          break;
        }
        logger.info("Key %s not found in manifest", paramString);
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        logger.info("Key %s not found in manifest", paramString);
      }
      paramContext = paramContext.trim();
    }
    return paramContext;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/util/ManifestUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */