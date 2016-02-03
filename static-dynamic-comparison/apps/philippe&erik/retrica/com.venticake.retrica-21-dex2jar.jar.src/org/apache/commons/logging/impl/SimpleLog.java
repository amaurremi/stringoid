package org.apache.commons.logging.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.security.AccessController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.logging.Log;

public class SimpleLog
  implements Serializable, Log
{
  protected static final String DEFAULT_DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss:SSS zzz";
  public static final int LOG_LEVEL_ALL = 0;
  public static final int LOG_LEVEL_DEBUG = 2;
  public static final int LOG_LEVEL_ERROR = 5;
  public static final int LOG_LEVEL_FATAL = 6;
  public static final int LOG_LEVEL_INFO = 3;
  public static final int LOG_LEVEL_OFF = 7;
  public static final int LOG_LEVEL_TRACE = 1;
  public static final int LOG_LEVEL_WARN = 4;
  protected static DateFormat dateFormatter;
  protected static String dateTimeFormat;
  protected static boolean showDateTime = false;
  protected static boolean showLogName = false;
  protected static boolean showShortName = false;
  protected static final Properties simpleLogProps = new Properties();
  protected static final String systemPrefix = "org.apache.commons.logging.simplelog.";
  protected int currentLogLevel;
  protected String logName = null;
  private String shortLogName = null;
  
  static
  {
    showLogName = false;
    showShortName = true;
    showDateTime = false;
    dateTimeFormat = "yyyy/MM/dd HH:mm:ss:SSS zzz";
    dateFormatter = null;
    InputStream localInputStream = getResourceAsStream("simplelog.properties");
    if (localInputStream != null) {}
    try
    {
      simpleLogProps.load(localInputStream);
      localInputStream.close();
      showLogName = getBooleanProperty("org.apache.commons.logging.simplelog.showlogname", showLogName);
      showShortName = getBooleanProperty("org.apache.commons.logging.simplelog.showShortLogname", showShortName);
      showDateTime = getBooleanProperty("org.apache.commons.logging.simplelog.showdatetime", showDateTime);
      if (showDateTime) {
        dateTimeFormat = getStringProperty("org.apache.commons.logging.simplelog.dateTimeFormat", dateTimeFormat);
      }
      try
      {
        dateFormatter = new SimpleDateFormat(dateTimeFormat);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        dateTimeFormat = "yyyy/MM/dd HH:mm:ss:SSS zzz";
        dateFormatter = new SimpleDateFormat(dateTimeFormat);
        return;
      }
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public SimpleLog(String paramString)
  {
    this.logName = paramString;
    setLevel(3);
    String str1 = getStringProperty("org.apache.commons.logging.simplelog.log." + this.logName);
    int i = String.valueOf(paramString).lastIndexOf(".");
    String str2 = paramString;
    paramString = str1;
    while ((paramString == null) && (i > -1))
    {
      str2 = str2.substring(0, i);
      paramString = getStringProperty("org.apache.commons.logging.simplelog.log." + str2);
      i = String.valueOf(str2).lastIndexOf(".");
    }
    str1 = paramString;
    if (paramString == null) {
      str1 = getStringProperty("org.apache.commons.logging.simplelog.defaultlog");
    }
    if ("all".equalsIgnoreCase(str1)) {
      setLevel(0);
    }
    do
    {
      return;
      if ("trace".equalsIgnoreCase(str1))
      {
        setLevel(1);
        return;
      }
      if ("debug".equalsIgnoreCase(str1))
      {
        setLevel(2);
        return;
      }
      if ("info".equalsIgnoreCase(str1))
      {
        setLevel(3);
        return;
      }
      if ("warn".equalsIgnoreCase(str1))
      {
        setLevel(4);
        return;
      }
      if ("error".equalsIgnoreCase(str1))
      {
        setLevel(5);
        return;
      }
      if ("fatal".equalsIgnoreCase(str1))
      {
        setLevel(6);
        return;
      }
    } while (!"off".equalsIgnoreCase(str1));
    setLevel(7);
  }
  
  private static boolean getBooleanProperty(String paramString, boolean paramBoolean)
  {
    paramString = getStringProperty(paramString);
    if (paramString == null) {
      return paramBoolean;
    }
    return "true".equalsIgnoreCase(paramString);
  }
  
  /* Error */
  private static ClassLoader getContextClassLoader()
  {
    // Byte code:
    //   0: iconst_0
    //   1: ifne +124 -> 125
    //   4: getstatic 202	org/apache/commons/logging/impl/SimpleLog:class$java$lang$Thread	Ljava/lang/Class;
    //   7: ifnonnull +68 -> 75
    //   10: ldc -52
    //   12: invokestatic 206	org/apache/commons/logging/impl/SimpleLog:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   15: astore_0
    //   16: aload_0
    //   17: putstatic 202	org/apache/commons/logging/impl/SimpleLog:class$java$lang$Thread	Ljava/lang/Class;
    //   20: aload_0
    //   21: ldc -49
    //   23: aconst_null
    //   24: checkcast 209	[Ljava/lang/Class;
    //   27: invokevirtual 213	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   30: astore_0
    //   31: aload_0
    //   32: invokestatic 219	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   35: aconst_null
    //   36: checkcast 209	[Ljava/lang/Class;
    //   39: invokevirtual 225	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast 227	java/lang/ClassLoader
    //   45: astore_0
    //   46: aload_0
    //   47: astore_1
    //   48: aload_0
    //   49: ifnonnull +24 -> 73
    //   52: getstatic 229	org/apache/commons/logging/impl/SimpleLog:class$org$apache$commons$logging$impl$SimpleLog	Ljava/lang/Class;
    //   55: ifnonnull +63 -> 118
    //   58: ldc -25
    //   60: invokestatic 206	org/apache/commons/logging/impl/SimpleLog:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   63: astore_0
    //   64: aload_0
    //   65: putstatic 229	org/apache/commons/logging/impl/SimpleLog:class$org$apache$commons$logging$impl$SimpleLog	Ljava/lang/Class;
    //   68: aload_0
    //   69: invokevirtual 234	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   72: astore_1
    //   73: aload_1
    //   74: areturn
    //   75: getstatic 202	org/apache/commons/logging/impl/SimpleLog:class$java$lang$Thread	Ljava/lang/Class;
    //   78: astore_0
    //   79: goto -59 -> 20
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 238	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   87: instanceof 240
    //   90: ifeq +8 -> 98
    //   93: aconst_null
    //   94: astore_0
    //   95: goto -49 -> 46
    //   98: new 242	org/apache/commons/logging/LogConfigurationException
    //   101: dup
    //   102: ldc -12
    //   104: aload_0
    //   105: invokevirtual 238	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   108: invokespecial 247	org/apache/commons/logging/LogConfigurationException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: athrow
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_0
    //   115: goto -69 -> 46
    //   118: getstatic 229	org/apache/commons/logging/impl/SimpleLog:class$org$apache$commons$logging$impl$SimpleLog	Ljava/lang/Class;
    //   121: astore_0
    //   122: goto -54 -> 68
    //   125: aconst_null
    //   126: astore_0
    //   127: goto -81 -> 46
    //   130: astore_0
    //   131: aconst_null
    //   132: astore_0
    //   133: goto -87 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	64	0	localObject1	Object
    //   82	2	0	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   94	11	0	localObject2	Object
    //   112	1	0	localNoSuchMethodException	NoSuchMethodException
    //   114	13	0	localClass	Class
    //   130	1	0	localIllegalAccessException	IllegalAccessException
    //   132	1	0	localObject3	Object
    //   47	27	1	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   31	46	82	java/lang/reflect/InvocationTargetException
    //   4	20	112	java/lang/NoSuchMethodException
    //   20	31	112	java/lang/NoSuchMethodException
    //   31	46	112	java/lang/NoSuchMethodException
    //   75	79	112	java/lang/NoSuchMethodException
    //   83	93	112	java/lang/NoSuchMethodException
    //   98	112	112	java/lang/NoSuchMethodException
    //   31	46	130	java/lang/IllegalAccessException
  }
  
  private static InputStream getResourceAsStream(String paramString)
  {
    return (InputStream)AccessController.doPrivileged(new SimpleLog.1(paramString));
  }
  
  private static String getStringProperty(String paramString)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = System.getProperty(paramString);
      localObject1 = localObject2;
    }
    catch (SecurityException localSecurityException)
    {
      Object localObject2;
      for (;;) {}
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = simpleLogProps.getProperty(paramString);
    }
    return (String)localObject2;
  }
  
  private static String getStringProperty(String paramString1, String paramString2)
  {
    paramString1 = getStringProperty(paramString1);
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public final void debug(Object paramObject)
  {
    if (isLevelEnabled(2)) {
      log(2, paramObject, null);
    }
  }
  
  public final void debug(Object paramObject, Throwable paramThrowable)
  {
    if (isLevelEnabled(2)) {
      log(2, paramObject, paramThrowable);
    }
  }
  
  public final void error(Object paramObject)
  {
    if (isLevelEnabled(5)) {
      log(5, paramObject, null);
    }
  }
  
  public final void error(Object paramObject, Throwable paramThrowable)
  {
    if (isLevelEnabled(5)) {
      log(5, paramObject, paramThrowable);
    }
  }
  
  public final void fatal(Object paramObject)
  {
    if (isLevelEnabled(6)) {
      log(6, paramObject, null);
    }
  }
  
  public final void fatal(Object paramObject, Throwable paramThrowable)
  {
    if (isLevelEnabled(6)) {
      log(6, paramObject, paramThrowable);
    }
  }
  
  public int getLevel()
  {
    return this.currentLogLevel;
  }
  
  public final void info(Object paramObject)
  {
    if (isLevelEnabled(3)) {
      log(3, paramObject, null);
    }
  }
  
  public final void info(Object paramObject, Throwable paramThrowable)
  {
    if (isLevelEnabled(3)) {
      log(3, paramObject, paramThrowable);
    }
  }
  
  public final boolean isDebugEnabled()
  {
    return isLevelEnabled(2);
  }
  
  public final boolean isErrorEnabled()
  {
    return isLevelEnabled(5);
  }
  
  public final boolean isFatalEnabled()
  {
    return isLevelEnabled(6);
  }
  
  public final boolean isInfoEnabled()
  {
    return isLevelEnabled(3);
  }
  
  protected boolean isLevelEnabled(int paramInt)
  {
    return paramInt >= this.currentLogLevel;
  }
  
  public final boolean isTraceEnabled()
  {
    return isLevelEnabled(1);
  }
  
  public final boolean isWarnEnabled()
  {
    return isLevelEnabled(4);
  }
  
  protected void log(int paramInt, Object paramObject, Throwable paramThrowable)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject2;
    if (showDateTime) {
      localObject2 = new Date();
    }
    for (;;)
    {
      synchronized (dateFormatter)
      {
        localObject2 = dateFormatter.format((Date)localObject2);
        localStringBuffer.append((String)localObject2);
        localStringBuffer.append(" ");
        switch (paramInt)
        {
        default: 
          if (!showShortName) {
            break label346;
          }
          if (this.shortLogName == null)
          {
            this.shortLogName = this.logName.substring(this.logName.lastIndexOf(".") + 1);
            this.shortLogName = this.shortLogName.substring(this.shortLogName.lastIndexOf("/") + 1);
          }
          localStringBuffer.append(String.valueOf(this.shortLogName)).append(" - ");
          localStringBuffer.append(String.valueOf(paramObject));
          if (paramThrowable != null)
          {
            localStringBuffer.append(" <");
            localStringBuffer.append(paramThrowable.toString());
            localStringBuffer.append(">");
            paramObject = new StringWriter(1024);
            ??? = new PrintWriter((Writer)paramObject);
            paramThrowable.printStackTrace((PrintWriter)???);
            ((PrintWriter)???).close();
            localStringBuffer.append(((StringWriter)paramObject).toString());
          }
          write(localStringBuffer);
          return;
        }
      }
      localStringBuffer.append("[TRACE] ");
      continue;
      localStringBuffer.append("[DEBUG] ");
      continue;
      localStringBuffer.append("[INFO] ");
      continue;
      localStringBuffer.append("[WARN] ");
      continue;
      localStringBuffer.append("[ERROR] ");
      continue;
      localStringBuffer.append("[FATAL] ");
      continue;
      label346:
      if (showLogName) {
        localStringBuffer.append(String.valueOf(this.logName)).append(" - ");
      }
    }
  }
  
  public void setLevel(int paramInt)
  {
    this.currentLogLevel = paramInt;
  }
  
  public final void trace(Object paramObject)
  {
    if (isLevelEnabled(1)) {
      log(1, paramObject, null);
    }
  }
  
  public final void trace(Object paramObject, Throwable paramThrowable)
  {
    if (isLevelEnabled(1)) {
      log(1, paramObject, paramThrowable);
    }
  }
  
  public final void warn(Object paramObject)
  {
    if (isLevelEnabled(4)) {
      log(4, paramObject, null);
    }
  }
  
  public final void warn(Object paramObject, Throwable paramThrowable)
  {
    if (isLevelEnabled(4)) {
      log(4, paramObject, paramThrowable);
    }
  }
  
  protected void write(StringBuffer paramStringBuffer)
  {
    System.err.println(paramStringBuffer.toString());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/apache/commons/logging/impl/SimpleLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */