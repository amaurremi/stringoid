package com.amazonaws.mobileconnectors.kinesis.kinesisrecorder.internal.logging;

import com.amazonaws.mobileconnectors.kinesis.kinesisrecorder.internal.logging.appender.LogAppender;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Logger
{
  private static Map<Class<?>, LogAppender> appenders;
  private static Logger.LogLevel globalLevel;
  private static boolean initialized;
  private static Map<Class<?>, Logger> loggers;
  private Logger.LogLevel classLevel = null;
  private Class<?> cls = null;
  private String tag = "KinesisBatcher";
  
  static
  {
    if (!Logger.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      globalLevel = Logger.LogLevel.WARN;
      appenders = new ConcurrentHashMap();
      loggers = new ConcurrentHashMap();
      initialized = false;
      return;
    }
  }
  
  public Logger(String paramString, Class<?> paramClass)
  {
    assert (paramClass != null);
    this.cls = paramClass;
    this.tag = paramString;
  }
  
  public static Collection<LogAppender> getAppenders()
  {
    return appenders.values();
  }
  
  /* Error */
  static Logger getClassLogger(Class<?> paramClass)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: astore_1
    //   5: aload_0
    //   6: ifnonnull +6 -> 12
    //   9: ldc 2
    //   11: astore_1
    //   12: getstatic 46	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger:loggers	Ljava/util/Map;
    //   15: aload_1
    //   16: invokeinterface 78 2 0
    //   21: ifeq +21 -> 42
    //   24: getstatic 46	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger:loggers	Ljava/util/Map;
    //   27: aload_1
    //   28: invokeinterface 82 2 0
    //   33: checkcast 2	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: areturn
    //   42: new 2	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger
    //   45: dup
    //   46: ldc 57
    //   48: aload_1
    //   49: invokespecial 84	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger:<init>	(Ljava/lang/String;Ljava/lang/Class;)V
    //   52: astore_0
    //   53: getstatic 46	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger:loggers	Ljava/util/Map;
    //   56: aload_1
    //   57: aload_0
    //   58: invokeinterface 88 3 0
    //   63: pop
    //   64: goto -27 -> 37
    //   67: astore_0
    //   68: ldc 2
    //   70: monitorexit
    //   71: aload_0
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramClass	Class<?>
    //   4	53	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	37	67	finally
    //   42	64	67	finally
  }
  
  public static Logger.LogLevel getGlobalLevel()
  {
    return globalLevel;
  }
  
  public static Collection<LogAppender> getLogAppenders()
  {
    return getAppenders();
  }
  
  public static Logger getLogger(Class<?> paramClass)
  {
    return getClassLogger(paramClass);
  }
  
  public void deve(String paramString)
  {
    Iterator localIterator = getLogAppenders().iterator();
    while (localIterator.hasNext())
    {
      LogAppender localLogAppender = (LogAppender)localIterator.next();
      localLogAppender.deve(this.tag, localLogAppender.decorateMessage(this.cls, paramString));
    }
  }
  
  public void e(String paramString)
  {
    if (isLoggingEnabled(Logger.LogLevel.ERROR))
    {
      Iterator localIterator = getLogAppenders().iterator();
      while (localIterator.hasNext())
      {
        LogAppender localLogAppender = (LogAppender)localIterator.next();
        localLogAppender.e(this.tag, localLogAppender.decorateMessage(this.cls, paramString));
      }
    }
  }
  
  public void e(String paramString, Throwable paramThrowable)
  {
    if (isLoggingEnabled(Logger.LogLevel.ERROR))
    {
      Iterator localIterator = getLogAppenders().iterator();
      while (localIterator.hasNext())
      {
        LogAppender localLogAppender = (LogAppender)localIterator.next();
        localLogAppender.e(this.tag, localLogAppender.decorateMessage(this.cls, paramString), paramThrowable);
      }
    }
  }
  
  /* Error */
  Logger.LogLevel getLogLevel()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 143	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger$LogLevel:OFF	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger$LogLevel;
    //   5: astore_1
    //   6: aload_0
    //   7: getfield 53	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger:classLevel	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger$LogLevel;
    //   10: ifnull +12 -> 22
    //   13: aload_0
    //   14: getfield 53	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger:classLevel	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger$LogLevel;
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: areturn
    //   22: invokestatic 145	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger:getGlobalLevel	()Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger$LogLevel;
    //   25: astore_1
    //   26: goto -8 -> 18
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	Logger
    //   5	21	1	localLogLevel	Logger.LogLevel
    //   29	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	29	finally
    //   22	26	29	finally
  }
  
  String getTag()
  {
    return this.tag;
  }
  
  public void i(String paramString)
  {
    if (isLoggingEnabled(Logger.LogLevel.INFO))
    {
      Iterator localIterator = getLogAppenders().iterator();
      while (localIterator.hasNext())
      {
        LogAppender localLogAppender = (LogAppender)localIterator.next();
        localLogAppender.i(getTag(), localLogAppender.decorateMessage(this.cls, paramString));
      }
    }
  }
  
  public boolean isLoggingEnabled(Logger.LogLevel paramLogLevel)
  {
    boolean bool = false;
    try
    {
      int i = paramLogLevel.compareTo(getLogLevel());
      if (i >= 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      paramLogLevel = finally;
      throw paramLogLevel;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */