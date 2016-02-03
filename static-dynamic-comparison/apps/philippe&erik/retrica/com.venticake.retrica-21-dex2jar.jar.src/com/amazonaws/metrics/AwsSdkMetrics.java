package com.amazonaws.metrics;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.regions.Regions;
import java.io.File;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public enum AwsSdkMetrics
{
  private static final String MBEAN_OBJECT_NAME = "com.amazonaws.management:type=" + AwsSdkMetrics.class.getSimpleName();
  private static volatile String credentialFile;
  private static volatile AWSCredentialsProvider credentialProvider;
  private static final boolean defaultMetricsEnabled;
  private static boolean dirtyEnabling;
  private static volatile String hostMetricName;
  private static volatile String jvmMetricName;
  private static volatile boolean machineMetricsExcluded;
  private static volatile MetricCollector mc;
  private static volatile String metricNameSpace = "AWSSDK/Java";
  private static volatile Integer metricQueueSize;
  private static volatile boolean perHostMetricsIncluded;
  private static volatile Long queuePollTimeoutMilli;
  private static volatile Regions region;
  private static final AwsSdkMetrics.MetricRegistry registry;
  private static volatile boolean singleMetricNamespace;
  
  static
  {
    Object localObject1 = System.getProperty("com.amazonaws.sdk.enableDefaultMetrics");
    boolean bool1;
    int i;
    boolean bool3;
    boolean bool2;
    label84:
    String str1;
    boolean bool6;
    boolean bool5;
    boolean bool4;
    if (localObject1 != null)
    {
      bool1 = true;
      defaultMetricsEnabled = bool1;
      if (!defaultMetricsEnabled) {
        break label588;
      }
      localObject1 = ((String)localObject1).split(",");
      int j = localObject1.length;
      i = 0;
      bool3 = false;
      bool2 = false;
      bool1 = false;
      if (i >= j) {
        break label575;
      }
      str1 = localObject1[i].trim();
      if ((bool1) || (!"excludeMachineMetrics".equals(str1))) {
        break label144;
      }
      bool6 = true;
      bool5 = bool2;
      bool4 = bool3;
    }
    for (;;)
    {
      i += 1;
      bool3 = bool4;
      bool2 = bool5;
      bool1 = bool6;
      break label84;
      bool1 = false;
      break;
      label144:
      if ((!bool2) && ("includePerHostMetrics".equals(str1)))
      {
        bool5 = true;
        bool4 = bool3;
        bool6 = bool1;
      }
      else if ((!bool3) && ("useSingleMetricNamespace".equals(str1)))
      {
        bool4 = true;
        bool5 = bool2;
        bool6 = bool1;
      }
      else
      {
        Object localObject3 = str1.split("=");
        bool4 = bool3;
        bool5 = bool2;
        bool6 = bool1;
        if (localObject3.length == 2)
        {
          String str2 = localObject3[0].trim();
          localObject3 = localObject3[1].trim();
          try
          {
            if (!"credentialFile".equals(str2)) {
              break label299;
            }
            setCredentialFile0((String)localObject3);
            bool4 = bool3;
            bool5 = bool2;
            bool6 = bool1;
          }
          catch (Exception localException)
          {
            LogFactory.getLog(AwsSdkMetrics.class).debug("Ignoring failure", localException);
            bool4 = bool3;
            bool5 = bool2;
            bool6 = bool1;
          }
          continue;
          label299:
          if ("cloudwatchRegion".equals(str2))
          {
            region = Regions.fromName((String)localObject3);
            bool4 = bool3;
            bool5 = bool2;
            bool6 = bool1;
          }
          else
          {
            Object localObject2;
            if ("metricQueueSize".equals(str2))
            {
              localObject2 = new Integer((String)localObject3);
              if (((Integer)localObject2).intValue() < 1) {
                throw new IllegalArgumentException("metricQueueSize must be at least 1");
              }
              metricQueueSize = (Integer)localObject2;
              bool4 = bool3;
              bool5 = bool2;
              bool6 = bool1;
            }
            else if ("getQueuePollTimeoutMilli".equals(str2))
            {
              localObject2 = new Long((String)localObject3);
              if (((Long)localObject2).intValue() < 1000) {
                throw new IllegalArgumentException("getQueuePollTimeoutMilli must be at least 1000");
              }
              queuePollTimeoutMilli = (Long)localObject2;
              bool4 = bool3;
              bool5 = bool2;
              bool6 = bool1;
            }
            else if ("metricNameSpace".equals(str2))
            {
              metricNameSpace = (String)localObject3;
              bool4 = bool3;
              bool5 = bool2;
              bool6 = bool1;
            }
            else if ("jvmMetricName".equals(str2))
            {
              jvmMetricName = (String)localObject3;
              bool4 = bool3;
              bool5 = bool2;
              bool6 = bool1;
            }
            else if ("hostMetricName".equals(str2))
            {
              hostMetricName = (String)localObject3;
              bool4 = bool3;
              bool5 = bool2;
              bool6 = bool1;
            }
            else
            {
              LogFactory.getLog(AwsSdkMetrics.class).debug("Ignoring unrecognized parameter: " + (String)localObject2);
              bool4 = bool3;
              bool5 = bool2;
              bool6 = bool1;
            }
          }
        }
      }
    }
    label575:
    machineMetricsExcluded = bool1;
    perHostMetricsIncluded = bool2;
    singleMetricNamespace = bool3;
    label588:
    registry = new AwsSdkMetrics.MetricRegistry();
  }
  
  public static boolean enableDefaultMetrics()
  {
    try
    {
      if ((mc != null) && (mc.isEnabled())) {
        break label84;
      }
      if (dirtyEnabling) {
        throw new IllegalStateException("Reentrancy is not allowed");
      }
    }
    finally {}
    dirtyEnabling = true;
    for (;;)
    {
      try
      {
        MetricCollector localMetricCollector = ((MetricCollector.Factory)Class.forName("com.amazonaws.metrics.internal.cloudwatch.DefaultMetricCollectorFactory").newInstance()).getInstance();
        if (localMetricCollector != null)
        {
          setMetricCollector(localMetricCollector);
          dirtyEnabling = false;
          bool = true;
          return bool;
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        label84:
        LogFactory.getLog(AwsSdkMetrics.class).warn("Failed to enable the default metrics", localException);
        dirtyEnabling = false;
        continue;
      }
      finally
      {
        dirtyEnabling = false;
      }
      bool = false;
    }
  }
  
  public static <T extends RequestMetricCollector> T getRequestMetricCollector()
  {
    if ((mc == null) && (isDefaultMetricsEnabled())) {
      enableDefaultMetrics();
    }
    if (mc == null) {
      return RequestMetricCollector.NONE;
    }
    return mc.getRequestMetricCollector();
  }
  
  public static <T extends ServiceMetricCollector> T getServiceMetricCollector()
  {
    if ((mc == null) && (isDefaultMetricsEnabled())) {
      enableDefaultMetrics();
    }
    if (mc == null) {
      return ServiceMetricCollector.NONE;
    }
    return mc.getServiceMetricCollector();
  }
  
  public static boolean isDefaultMetricsEnabled()
  {
    return defaultMetricsEnabled;
  }
  
  public static boolean isMetricsEnabled()
  {
    MetricCollector localMetricCollector = mc;
    return (localMetricCollector != null) && (localMetricCollector.isEnabled());
  }
  
  private static void setCredentialFile0(String paramString)
  {
    PropertiesCredentials localPropertiesCredentials = new PropertiesCredentials(new File(paramString));
    try
    {
      credentialProvider = new AWSCredentialsProvider()
      {
        public AWSCredentials getCredentials()
        {
          return AwsSdkMetrics.this;
        }
      };
      credentialFile = paramString;
      return;
    }
    finally {}
  }
  
  public static void setMetricCollector(MetricCollector paramMetricCollector)
  {
    try
    {
      MetricCollector localMetricCollector = mc;
      mc = paramMetricCollector;
      if (localMetricCollector != null) {
        localMetricCollector.stop();
      }
      return;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/metrics/AwsSdkMetrics.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */