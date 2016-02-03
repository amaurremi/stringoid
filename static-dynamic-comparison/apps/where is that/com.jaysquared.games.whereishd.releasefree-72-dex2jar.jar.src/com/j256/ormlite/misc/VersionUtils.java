package com.j256.ormlite.misc;

import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;

public class VersionUtils
{
  private static final String CORE_VERSION = "VERSION__4.47__";
  private static String coreVersion = "VERSION__4.47__";
  private static Logger logger;
  private static boolean thrownOnErrors = false;
  
  public static final void checkCoreVersusAndroidVersions(String paramString)
  {
    logVersionWarnings("core", coreVersion, "android", paramString);
  }
  
  public static final void checkCoreVersusJdbcVersions(String paramString)
  {
    logVersionWarnings("core", coreVersion, "jdbc", paramString);
  }
  
  public static String getCoreVersion()
  {
    return coreVersion;
  }
  
  private static Logger getLogger()
  {
    if (logger == null) {
      logger = LoggerFactory.getLogger(VersionUtils.class);
    }
    return logger;
  }
  
  private static void logVersionWarnings(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramString2 == null) {
      if (paramString4 != null) {
        warning(null, "Unknown version", " for {}, version for {} is '{}'", new Object[] { paramString1, paramString3, paramString4 });
      }
    }
    do
    {
      return;
      if (paramString4 == null)
      {
        warning(null, "Unknown version", " for {}, version for {} is '{}'", new Object[] { paramString3, paramString1, paramString2 });
        return;
      }
    } while (paramString2.equals(paramString4));
    warning(null, "Mismatched versions", ": {} is '{}', while {} is '{}'", new Object[] { paramString1, paramString2, paramString3, paramString4 });
  }
  
  static void setThrownOnErrors(boolean paramBoolean)
  {
    thrownOnErrors = paramBoolean;
  }
  
  private static void warning(Throwable paramThrowable, String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    getLogger().warn(paramThrowable, paramString1 + paramString2, paramArrayOfObject);
    if (thrownOnErrors) {
      throw new IllegalStateException("See error log for details:" + paramString1);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/misc/VersionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */