package org.slf4j.impl;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.ILoggerFactory;

public class AndroidLoggerFactory
  implements ILoggerFactory
{
  private final Map<String, AndroidLogger> loggerMap = new HashMap();
  
  public AndroidLogger getLogger(String paramString)
  {
    for (;;)
    {
      try
      {
        AndroidLogger localAndroidLogger2 = (AndroidLogger)this.loggerMap.get(paramString);
        localAndroidLogger1 = localAndroidLogger2;
        if (localAndroidLogger2 == null) {
          localAndroidLogger1 = new AndroidLogger(paramString);
        }
      }
      finally
      {
        AndroidLogger localAndroidLogger1;
        continue;
      }
      try
      {
        this.loggerMap.put(paramString, localAndroidLogger1);
        return localAndroidLogger1;
      }
      finally {}
    }
    throw paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/slf4j/impl/AndroidLoggerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */