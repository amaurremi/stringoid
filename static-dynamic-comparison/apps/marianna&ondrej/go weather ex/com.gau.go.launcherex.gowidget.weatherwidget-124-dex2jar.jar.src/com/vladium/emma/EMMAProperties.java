package com.vladium.emma;

import com.vladium.emma.report.ReportProperties;
import com.vladium.util.ClassLoaderResolver;
import com.vladium.util.IProperties;
import com.vladium.util.IProperties.Factory;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.WeakHashMap;

public abstract class EMMAProperties
{
  public static final String DEFAULT_COVERAGE_DATA_OUT_FILE = "coverage.ec";
  public static final Boolean DEFAULT_COVERAGE_DATA_OUT_MERGE;
  public static final String DEFAULT_META_DATA_OUT_FILE = "coverage.em";
  public static final Boolean DEFAULT_META_DATA_OUT_MERGE = Boolean.TRUE;
  public static final String DEFAULT_SESSION_DATA_OUT_FILE = "coverage.es";
  public static final Boolean DEFAULT_SESSION_DATA_OUT_MERGE;
  public static final String GENERIC_PROPERTY_OVERRIDE_PREFIX = "D";
  public static final String PREFIX_COVERAGE_DATA = "coverage.";
  public static final String PREFIX_META_DATA = "metadata.";
  public static final String PREFIX_SESSION_DATA = "session.";
  public static final String PROPERTY_COVERAGE_DATA_OUT_FILE = "coverage.out.file";
  public static final String PROPERTY_COVERAGE_DATA_OUT_MERGE = "coverage.out.merge";
  public static final String PROPERTY_META_DATA_OUT_FILE = "metadata.out.file";
  public static final String PROPERTY_META_DATA_OUT_MERGE = "metadata.out.merge";
  public static final String PROPERTY_SESSION_DATA_OUT_FILE = "session.out.file";
  public static final String PROPERTY_SESSION_DATA_OUT_MERGE = "session.out.merge";
  public static final String PROPERTY_TEMP_FILE_EXT = ".et";
  public static final Map SYSTEM_PROPERTY_REDIRECTS;
  private static final Map s_properties;
  private static long s_timestamp;
  
  static
  {
    DEFAULT_COVERAGE_DATA_OUT_MERGE = Boolean.TRUE;
    DEFAULT_SESSION_DATA_OUT_MERGE = Boolean.TRUE;
    s_properties = new WeakHashMap();
    HashMap localHashMap = new HashMap();
    localHashMap.put("report.".concat("out.encoding"), "file.encoding");
    localHashMap.put("report.".concat("out.dir"), "user.dir");
    SYSTEM_PROPERTY_REDIRECTS = Collections.unmodifiableMap(localHashMap);
  }
  
  public static IProperties getAppProperties()
  {
    try
    {
      IProperties localIProperties = getAppProperties(ClassLoaderResolver.getClassLoader());
      return localIProperties;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public static IProperties getAppProperties(ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 76	com/vladium/emma/EMMAProperties:s_properties	Ljava/util/Map;
    //   6: aload_0
    //   7: invokeinterface 126 2 0
    //   12: checkcast 128	com/vladium/util/IProperties
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +10 -> 27
    //   20: aload_1
    //   21: astore_0
    //   22: ldc 2
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: getstatic 109	com/vladium/emma/EMMAProperties:SYSTEM_PROPERTY_REDIRECTS	Ljava/util/Map;
    //   30: invokestatic 134	com/vladium/util/Property:getSystemPropertyRedirects	(Ljava/util/Map;)Ljava/util/Properties;
    //   33: invokestatic 138	com/vladium/emma/EMMAProperties:wrap	(Ljava/util/Properties;)Lcom/vladium/util/IProperties;
    //   36: astore_2
    //   37: ldc -116
    //   39: aload_0
    //   40: invokestatic 144	com/vladium/util/Property:getProperties	(Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/util/Properties;
    //   43: invokestatic 138	com/vladium/emma/EMMAProperties:wrap	(Ljava/util/Properties;)Lcom/vladium/util/IProperties;
    //   46: astore_3
    //   47: ldc -110
    //   49: invokestatic 149	com/vladium/util/Property:getSystemProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore_1
    //   53: aload_1
    //   54: ifnull +73 -> 127
    //   57: new 151	java/io/File
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 154	java/io/File:<init>	(Ljava/lang/String;)V
    //   65: astore_1
    //   66: aload_1
    //   67: invokestatic 158	com/vladium/util/Property:getLazyPropertiesFromFile	(Ljava/io/File;)Ljava/util/Properties;
    //   70: invokestatic 138	com/vladium/emma/EMMAProperties:wrap	(Ljava/util/Properties;)Lcom/vladium/util/IProperties;
    //   73: astore_1
    //   74: ldc -96
    //   76: invokestatic 164	com/vladium/util/Property:getSystemProperties	(Ljava/lang/String;)Ljava/util/Properties;
    //   79: invokestatic 138	com/vladium/emma/EMMAProperties:wrap	(Ljava/util/Properties;)Lcom/vladium/util/IProperties;
    //   82: astore 4
    //   84: ldc -110
    //   86: aload_0
    //   87: invokestatic 144	com/vladium/util/Property:getProperties	(Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/util/Properties;
    //   90: invokestatic 138	com/vladium/emma/EMMAProperties:wrap	(Ljava/util/Properties;)Lcom/vladium/util/IProperties;
    //   93: aload 4
    //   95: aload_1
    //   96: aload_3
    //   97: aload_2
    //   98: invokestatic 170	com/vladium/util/IProperties$Factory:combine	(Lcom/vladium/util/IProperties;Lcom/vladium/util/IProperties;)Lcom/vladium/util/IProperties;
    //   101: invokestatic 170	com/vladium/util/IProperties$Factory:combine	(Lcom/vladium/util/IProperties;Lcom/vladium/util/IProperties;)Lcom/vladium/util/IProperties;
    //   104: invokestatic 170	com/vladium/util/IProperties$Factory:combine	(Lcom/vladium/util/IProperties;Lcom/vladium/util/IProperties;)Lcom/vladium/util/IProperties;
    //   107: invokestatic 170	com/vladium/util/IProperties$Factory:combine	(Lcom/vladium/util/IProperties;Lcom/vladium/util/IProperties;)Lcom/vladium/util/IProperties;
    //   110: astore_1
    //   111: getstatic 76	com/vladium/emma/EMMAProperties:s_properties	Ljava/util/Map;
    //   114: aload_0
    //   115: aload_1
    //   116: invokeinterface 97 3 0
    //   121: pop
    //   122: aload_1
    //   123: astore_0
    //   124: goto -102 -> 22
    //   127: aconst_null
    //   128: astore_1
    //   129: goto -63 -> 66
    //   132: astore_0
    //   133: ldc 2
    //   135: monitorexit
    //   136: aload_0
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramClassLoader	ClassLoader
    //   15	114	1	localObject	Object
    //   36	62	2	localIProperties1	IProperties
    //   46	51	3	localIProperties2	IProperties
    //   82	12	4	localIProperties3	IProperties
    // Exception table:
    //   from	to	target	type
    //   3	16	132	finally
    //   27	53	132	finally
    //   57	66	132	finally
    //   66	122	132	finally
  }
  
  public static long getTimeStamp()
  {
    try
    {
      long l2 = s_timestamp;
      long l1 = l2;
      if (l2 == 0L)
      {
        l1 = System.currentTimeMillis();
        s_timestamp = l1;
      }
      return l1;
    }
    finally {}
  }
  
  public static String makeAppVersion(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt1);
    localStringBuffer.append('.');
    localStringBuffer.append(paramInt2);
    localStringBuffer.append('.');
    localStringBuffer.append(paramInt3);
    return localStringBuffer.toString();
  }
  
  public static IProperties wrap(Properties paramProperties)
  {
    if (paramProperties == null) {
      return null;
    }
    return IProperties.Factory.wrap(paramProperties, ReportProperties.REPORT_PROPERTY_MAPPER);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/EMMAProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */