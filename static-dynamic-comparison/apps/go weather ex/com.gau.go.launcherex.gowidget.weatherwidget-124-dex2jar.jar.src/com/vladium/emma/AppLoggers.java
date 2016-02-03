package com.vladium.emma;

import com.vladium.logging.Logger;
import com.vladium.util.IProperties;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public abstract class AppLoggers
{
  private static final String COMMA_DELIMITERS = ", \t\r\n";
  public static final String DEFAULT_VERBOSITY_LEVEL = "info";
  public static final String PREFIX_VERBOSITY = "verbosity.";
  public static final String PROPERTY_VERBOSITY_FILTER = "verbosity.filter";
  public static final String PROPERTY_VERBOSITY_LEVEL = "verbosity.level";
  
  public static Logger create(String paramString, IProperties paramIProperties, Logger paramLogger)
  {
    if (paramIProperties == null) {
      throw new IllegalArgumentException("null input: properties");
    }
    int i = Logger.stringToLevel(paramIProperties.getProperty("verbosity.level", "info"));
    Object localObject = paramIProperties.getProperty("verbosity.filter");
    HashSet localHashSet = null;
    paramIProperties = localHashSet;
    if (localObject != null)
    {
      localObject = new StringTokenizer((String)localObject, ", \t\r\n");
      paramIProperties = localHashSet;
      if (((StringTokenizer)localObject).countTokens() > 0)
      {
        localHashSet = new HashSet(((StringTokenizer)localObject).countTokens());
        for (;;)
        {
          paramIProperties = localHashSet;
          if (!((StringTokenizer)localObject).hasMoreTokens()) {
            break;
          }
          localHashSet.add(((StringTokenizer)localObject).nextToken());
        }
      }
    }
    return Logger.create(i, null, paramString, paramIProperties, paramLogger);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/AppLoggers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */