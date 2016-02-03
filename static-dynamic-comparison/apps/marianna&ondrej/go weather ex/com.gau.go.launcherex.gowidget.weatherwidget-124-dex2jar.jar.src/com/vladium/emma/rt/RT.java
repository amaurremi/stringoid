package com.vladium.emma.rt;

import com.vladium.emma.EMMAProperties;
import com.vladium.emma.IAppConstants;
import com.vladium.emma.data.DataFactory;
import com.vladium.emma.data.ICoverageData;
import com.vladium.logging.Logger;
import com.vladium.util.IProperties;
import com.vladium.util.Property;
import com.vladium.util.exit.ExitHookManager;
import java.io.File;

public abstract class RT
  implements IAppConstants
{
  private static final boolean DEBUG = false;
  private static final ExitHookManager EXIT_HOOK_MANAGER;
  private static IProperties s_appProperties;
  private static ICoverageData s_cdata;
  private static Runnable s_exitHook;
  
  static
  {
    Object localObject = null;
    try
    {
      ExitHookManager localExitHookManager = ExitHookManager.getSingleton();
      localObject = localExitHookManager;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace(System.out);
      }
      reset(false, false);
    }
    EXIT_HOOK_MANAGER = (ExitHookManager)localObject;
    if (RTSettings.isStandaloneMode())
    {
      reset(true, true);
      localObject = Logger.getLogger();
      if (((Logger)localObject).atINFO()) {
        ((Logger)localObject).info("collecting runtime coverage data ...");
      }
      return;
    }
  }
  
  public static void dumpCoverageData(File paramFile, boolean paramBoolean)
  {
    if (paramFile != null) {}
    for (;;)
    {
      ICoverageData localICoverageData;
      try
      {
        localICoverageData = s_cdata;
        if (!paramBoolean) {
          break label53;
        }
        s_cdata = null;
      }
      finally {}
      RTCoverageDataPersister.dumpCoverageData(localICoverageData, paramBoolean, paramFile, getCoverageOutMerge());
      return;
      paramFile = getCoverageOutFile();
      continue;
      paramBoolean = false;
      continue;
      label53:
      if (!paramBoolean) {
        paramBoolean = true;
      }
    }
  }
  
  public static void dumpCoverageData(File paramFile, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramFile != null) {}
    for (;;)
    {
      ICoverageData localICoverageData;
      try
      {
        localICoverageData = s_cdata;
        if (!paramBoolean2) {
          break label51;
        }
        s_cdata = null;
      }
      finally {}
      RTCoverageDataPersister.dumpCoverageData(localICoverageData, paramBoolean2, paramFile, paramBoolean1);
      return;
      paramFile = getCoverageOutFile();
      continue;
      paramBoolean2 = false;
      continue;
      label51:
      if (!paramBoolean2) {
        paramBoolean2 = true;
      }
    }
  }
  
  public static IProperties getAppProperties()
  {
    try
    {
      IProperties localIProperties = s_appProperties;
      return localIProperties;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static ICoverageData getCoverageData()
  {
    try
    {
      ICoverageData localICoverageData = s_cdata;
      return localICoverageData;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static File getCoverageOutFile()
  {
    IProperties localIProperties = getAppProperties();
    if (localIProperties != null) {
      return new File(localIProperties.getProperty("coverage.out.file", "coverage.ec"));
    }
    return new File("coverage.ec");
  }
  
  private static boolean getCoverageOutMerge()
  {
    IProperties localIProperties = getAppProperties();
    if (localIProperties != null) {
      return Property.toBoolean(localIProperties.getProperty("coverage.out.merge", EMMAProperties.DEFAULT_COVERAGE_DATA_OUT_MERGE.toString()));
    }
    return EMMAProperties.DEFAULT_COVERAGE_DATA_OUT_MERGE.booleanValue();
  }
  
  public static void r(boolean[][] paramArrayOfBoolean, String paramString, long paramLong)
  {
    ICoverageData localICoverageData = getCoverageData();
    if (localICoverageData != null) {
      synchronized (localICoverageData.lock())
      {
        localICoverageData.addClass(paramArrayOfBoolean, paramString, paramLong);
        return;
      }
    }
  }
  
  public static ICoverageData reset(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        Object localObject4 = RT.class.getClassLoader();
        Object localObject1 = localObject4;
        if (localObject4 == null) {
          localObject1 = ClassLoader.getSystemClassLoader();
        }
        localObject4 = null;
        try
        {
          localObject1 = EMMAProperties.getAppProperties((ClassLoader)localObject1);
          s_appProperties = (IProperties)localObject1;
          if ((EXIT_HOOK_MANAGER != null) && (s_exitHook != null))
          {
            EXIT_HOOK_MANAGER.removeExitHook(s_exitHook);
            s_exitHook = null;
          }
          localObject1 = s_cdata;
          if (paramBoolean1)
          {
            localObject1 = DataFactory.newCoverageData();
            s_cdata = (ICoverageData)localObject1;
            if ((EXIT_HOOK_MANAGER != null) && (paramBoolean2) && (localObject1 != null))
            {
              localObject4 = new RTExitHook(RT.class, (ICoverageData)localObject1, getCoverageOutFile(), getCoverageOutMerge());
              RTExitHook.createClassLoaderClosure();
              if (EXIT_HOOK_MANAGER.addExitHook((Runnable)localObject4)) {
                s_exitHook = (Runnable)localObject4;
              }
            }
            return (ICoverageData)localObject1;
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace(System.out);
          Object localObject2 = localObject4;
          continue;
        }
        s_cdata = null;
      }
      finally {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/rt/RT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */