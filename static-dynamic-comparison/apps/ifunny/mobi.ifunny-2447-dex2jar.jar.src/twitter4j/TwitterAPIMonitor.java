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

import twitter4j.management.APIStatistics;
import twitter4j.management.APIStatisticsMBean;
import twitter4j.management.APIStatisticsOpenMBean;

public class TwitterAPIMonitor {
    private static final TwitterAPIMonitor SINGLETON;
    private static final APIStatistics STATISTICS;
    private static final Logger logger = Logger.getLogger(TwitterAPIMonitor.class);
    private static final Pattern pattern = Pattern.compile("https?://[^/]+/[0-9.]*/([a-zA-Z_\\.]*).*");

    static {
        SINGLETON = new TwitterAPIMonitor();
        STATISTICS = new APIStatistics(100);
        try {
            MBeanServer localMBeanServer = ManagementFactory.getPlatformMBeanServer();
            ObjectName localObjectName = new ObjectName("twitter4j.mbean:type=APIStatisticsOpenMBean");
            localMBeanServer.registerMBean(new APIStatisticsOpenMBean(STATISTICS), localObjectName);
            return;
        } catch (InstanceAlreadyExistsException localInstanceAlreadyExistsException) {
            localInstanceAlreadyExistsException.printStackTrace();
            logger.error(localInstanceAlreadyExistsException.getMessage());
            return;
        } catch (MBeanRegistrationException localMBeanRegistrationException) {
            localMBeanRegistrationException.printStackTrace();
            logger.error(localMBeanRegistrationException.getMessage());
            return;
        } catch (NotCompliantMBeanException localNotCompliantMBeanException) {
            localNotCompliantMBeanException.printStackTrace();
            logger.error(localNotCompliantMBeanException.getMessage());
            return;
        } catch (MalformedObjectNameException localMalformedObjectNameException) {
            localMalformedObjectNameException.printStackTrace();
            logger.error(localMalformedObjectNameException.getMessage());
        }
    }

    public static TwitterAPIMonitor getInstance() {
        return SINGLETON;
    }

    public APIStatisticsMBean getStatistics() {
        return STATISTICS;
    }

    void methodCalled(String paramString, long paramLong, boolean paramBoolean) {
        paramString = pattern.matcher(paramString);
        if ((paramString.matches()) && (paramString.groupCount() > 0)) {
            paramString = paramString.group(1);
            STATISTICS.methodCalled(paramString, paramLong, paramBoolean);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/TwitterAPIMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */