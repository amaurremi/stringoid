package twitter4j;

import java.lang.management.ManagementFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;
import twitter4j.internal.logging.Logger;
import twitter4j.management.APIStatistics;
import twitter4j.management.APIStatisticsMBean;
import twitter4j.management.APIStatisticsOpenMBean;

public class TwitterAPIMonitor
{
  private static final TwitterAPIMonitor SINGLETON = new TwitterAPIMonitor();
  private static final APIStatistics STATISTICS = new APIStatistics(100);
  private static final Logger logger;
  private static final Pattern pattern;
  
  static
  {
    j = 1;
    int k = 0;
    logger = Logger.getLogger(TwitterAPIMonitor.class);
    pattern = Pattern.compile("https?:\\/\\/[^\\/]+\\/[0-9.]*\\/([a-zA-Z_\\.]*).*");
    for (;;)
    {
      try
      {
        localObject = System.getProperty("java.specification.version");
        i = k;
        if (localObject != null)
        {
          i = k;
          if (1.5D > Double.parseDouble((String)localObject)) {
            i = 1;
          }
        }
        if (ConfigurationContext.getInstance().isDalvik()) {
          System.setProperty("http.keepAlive", "false");
        }
      }
      catch (SecurityException localSecurityException)
      {
        Object localObject;
        ObjectName localObjectName;
        int i = j;
        continue;
      }
      try
      {
        localObject = ManagementFactory.getPlatformMBeanServer();
        if (i != 0)
        {
          localObjectName = new ObjectName("twitter4j.mbean:type=APIStatistics");
          ((MBeanServer)localObject).registerMBean(STATISTICS, localObjectName);
          return;
        }
        localObjectName = new ObjectName("twitter4j.mbean:type=APIStatisticsOpenMBean");
        ((MBeanServer)localObject).registerMBean(new APIStatisticsOpenMBean(STATISTICS), localObjectName);
        return;
      }
      catch (InstanceAlreadyExistsException localInstanceAlreadyExistsException)
      {
        localInstanceAlreadyExistsException.printStackTrace();
        logger.error(localInstanceAlreadyExistsException.getMessage());
        return;
      }
      catch (MBeanRegistrationException localMBeanRegistrationException)
      {
        localMBeanRegistrationException.printStackTrace();
        logger.error(localMBeanRegistrationException.getMessage());
        return;
      }
      catch (NotCompliantMBeanException localNotCompliantMBeanException)
      {
        localNotCompliantMBeanException.printStackTrace();
        logger.error(localNotCompliantMBeanException.getMessage());
        return;
      }
      catch (MalformedObjectNameException localMalformedObjectNameException)
      {
        localMalformedObjectNameException.printStackTrace();
        logger.error(localMalformedObjectNameException.getMessage());
        return;
      }
    }
  }
  
  public static TwitterAPIMonitor getInstance()
  {
    return SINGLETON;
  }
  
  public APIStatisticsMBean getStatistics()
  {
    return STATISTICS;
  }
  
  void methodCalled(String paramString, long paramLong, boolean paramBoolean)
  {
    paramString = pattern.matcher(paramString);
    if ((paramString.matches()) && (paramString.groupCount() > 0))
    {
      paramString = paramString.group(1);
      STATISTICS.methodCalled(paramString, paramLong, paramBoolean);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/TwitterAPIMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */