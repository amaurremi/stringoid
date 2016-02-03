package com.vladium.emma.rt;

import com.vladium.emma.data.DataFactory;
import com.vladium.emma.data.ICoverageData;
import com.vladium.logging.Logger;
import java.io.File;

abstract class RTCoverageDataPersister
{
  static void dumpCoverageData(ICoverageData paramICoverageData, boolean paramBoolean1, File paramFile, boolean paramBoolean2)
  {
    if (paramICoverageData != null) {}
    label175:
    for (;;)
    {
      try
      {
        Logger localLogger = Logger.getLogger();
        boolean bool = localLogger.atINFO();
        if (bool)
        {
          l1 = System.currentTimeMillis();
          if (!paramBoolean1) {
            continue;
          }
          paramICoverageData = paramICoverageData.shallowCopy();
        }
        try
        {
          DataFactory.persist(paramICoverageData, paramFile, paramBoolean2);
          if (bool)
          {
            long l2 = System.currentTimeMillis();
            StringBuilder localStringBuilder = new StringBuilder().append("runtime coverage data ");
            if (!paramBoolean2) {
              break label175;
            }
            paramICoverageData = "merged into";
            localLogger.info(paramICoverageData + " [" + paramFile.getAbsolutePath() + "] {in " + (l2 - l1) + " ms}");
          }
          return;
        }
        finally {}
        long l1 = 0L;
        continue;
        continue;
        paramICoverageData = "written to";
      }
      catch (Throwable paramICoverageData)
      {
        paramICoverageData.printStackTrace();
        throw new RuntimeException("EMMA failed to dump coverage data: " + paramICoverageData.toString());
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/rt/RTCoverageDataPersister.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */