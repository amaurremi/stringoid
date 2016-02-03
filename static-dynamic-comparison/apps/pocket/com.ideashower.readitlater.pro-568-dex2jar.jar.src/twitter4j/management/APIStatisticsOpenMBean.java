package twitter4j.management;

import java.util.Iterator;
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.DynamicMBean;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.ReflectionException;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenMBeanAttributeInfoSupport;
import javax.management.openmbean.OpenMBeanConstructorInfoSupport;
import javax.management.openmbean.OpenMBeanInfoSupport;
import javax.management.openmbean.OpenMBeanOperationInfoSupport;
import javax.management.openmbean.OpenMBeanParameterInfoSupport;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;
import javax.management.openmbean.TabularDataSupport;
import javax.management.openmbean.TabularType;

public class APIStatisticsOpenMBean
  implements DynamicMBean
{
  private static final String[] ITEM_DESCRIPTIONS = { "The method name", "The number of times this method has been called", "The number of calls that failed", "The total amount of time spent invoking this method in milliseconds", "The average amount of time spent invoking this method in milliseconds" };
  private static final String[] ITEM_NAMES = { "methodName", "callCount", "errorCount", "totalTime", "avgTime" };
  private static final OpenType[] ITEM_TYPES = { SimpleType.STRING, SimpleType.LONG, SimpleType.LONG, SimpleType.LONG, SimpleType.LONG };
  private final APIStatisticsMBean API_STATISTICS;
  private final TabularType API_STATISTICS_TYPE;
  private final CompositeType METHOD_STATS_TYPE;
  
  public APIStatisticsOpenMBean(APIStatistics paramAPIStatistics)
  {
    this.API_STATISTICS = paramAPIStatistics;
    try
    {
      this.METHOD_STATS_TYPE = new CompositeType("method statistics", "method statistics", ITEM_NAMES, ITEM_DESCRIPTIONS, ITEM_TYPES);
      this.API_STATISTICS_TYPE = new TabularType("API statistics", "list of methods", this.METHOD_STATS_TYPE, new String[] { "methodName" });
      return;
    }
    catch (OpenDataException paramAPIStatistics)
    {
      throw new RuntimeException(paramAPIStatistics);
    }
  }
  
  public Object getAttribute(String paramString)
  {
    if (paramString.equals("statisticsTable")) {
      return getStatistics();
    }
    if (paramString.equals("callCount")) {
      return Long.valueOf(this.API_STATISTICS.getCallCount());
    }
    if (paramString.equals("errorCount")) {
      return Long.valueOf(this.API_STATISTICS.getErrorCount());
    }
    if (paramString.equals("totalTime")) {
      return Long.valueOf(this.API_STATISTICS.getTotalTime());
    }
    if (paramString.equals("averageTime")) {
      return Long.valueOf(this.API_STATISTICS.getAverageTime());
    }
    throw new AttributeNotFoundException("Cannot find " + paramString + " attribute ");
  }
  
  public AttributeList getAttributes(String[] paramArrayOfString)
  {
    AttributeList localAttributeList = new AttributeList();
    if (paramArrayOfString.length == 0) {
      return localAttributeList;
    }
    int i = 0;
    for (;;)
    {
      if (i < paramArrayOfString.length) {
        try
        {
          Object localObject = getAttribute(paramArrayOfString[i]);
          localAttributeList.add(new Attribute(paramArrayOfString[i], localObject));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    return localAttributeList;
  }
  
  public MBeanInfo getMBeanInfo()
  {
    OpenMBeanAttributeInfoSupport localOpenMBeanAttributeInfoSupport1 = new OpenMBeanAttributeInfoSupport("callCount", "Total number of API calls", SimpleType.LONG, true, false, false);
    OpenMBeanAttributeInfoSupport localOpenMBeanAttributeInfoSupport2 = new OpenMBeanAttributeInfoSupport("errorCount", "The number of failed API calls", SimpleType.LONG, true, false, false);
    OpenMBeanAttributeInfoSupport localOpenMBeanAttributeInfoSupport3 = new OpenMBeanAttributeInfoSupport("averageTime", "Average time spent invoking any API method", SimpleType.LONG, true, false, false);
    OpenMBeanAttributeInfoSupport localOpenMBeanAttributeInfoSupport4 = new OpenMBeanAttributeInfoSupport("totalTime", "Average time spent invoking any API method", SimpleType.LONG, true, false, false);
    OpenMBeanAttributeInfoSupport localOpenMBeanAttributeInfoSupport5 = new OpenMBeanAttributeInfoSupport("statisticsTable", "Table of statisics for all API methods", this.API_STATISTICS_TYPE, true, false, false);
    OpenMBeanConstructorInfoSupport localOpenMBeanConstructorInfoSupport = new OpenMBeanConstructorInfoSupport("APIStatisticsOpenMBean", "Constructs an APIStatisticsOpenMBean instance", new OpenMBeanParameterInfoSupport[0]);
    Object localObject = SimpleType.VOID;
    localObject = new OpenMBeanOperationInfoSupport("reset", "reset the statistics", new OpenMBeanParameterInfoSupport[0], (OpenType)localObject, 0);
    return new OpenMBeanInfoSupport(getClass().getName(), "API Statistics Open MBean", new OpenMBeanAttributeInfoSupport[] { localOpenMBeanAttributeInfoSupport1, localOpenMBeanAttributeInfoSupport2, localOpenMBeanAttributeInfoSupport3, localOpenMBeanAttributeInfoSupport4, localOpenMBeanAttributeInfoSupport5 }, new OpenMBeanConstructorInfoSupport[] { localOpenMBeanConstructorInfoSupport }, new OpenMBeanOperationInfoSupport[] { localObject }, new MBeanNotificationInfo[0]);
  }
  
  public TabularDataSupport getStatistics()
  {
    try
    {
      TabularDataSupport localTabularDataSupport1 = new TabularDataSupport(this.API_STATISTICS_TYPE);
      Iterator localIterator = this.API_STATISTICS.getInvocationStatistics().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          InvocationStatistics localInvocationStatistics = (InvocationStatistics)localIterator.next();
          String str = localInvocationStatistics.getName();
          long l1 = localInvocationStatistics.getCallCount();
          long l2 = localInvocationStatistics.getErrorCount();
          long l3 = localInvocationStatistics.getTotalTime();
          long l4 = localInvocationStatistics.getAverageTime();
          try
          {
            localTabularDataSupport1.put(new CompositeDataSupport(this.METHOD_STATS_TYPE, ITEM_NAMES, new Object[] { str, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4) }));
          }
          catch (OpenDataException localOpenDataException)
          {
            throw new RuntimeException(localOpenDataException);
          }
        }
      }
    }
    finally {}
    return localTabularDataSupport2;
  }
  
  public Object invoke(String paramString, Object[] paramArrayOfObject, String[] paramArrayOfString)
  {
    if (paramString.equals("reset"))
    {
      reset();
      return "Statistics reset";
    }
    throw new ReflectionException(new NoSuchMethodException(paramString), "Cannot find the operation " + paramString);
  }
  
  public void reset()
  {
    this.API_STATISTICS.reset();
  }
  
  public void setAttribute(Attribute paramAttribute)
  {
    throw new AttributeNotFoundException("No attributes can be set in this MBean");
  }
  
  public AttributeList setAttributes(AttributeList paramAttributeList)
  {
    return new AttributeList();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/management/APIStatisticsOpenMBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */