package twitter4j.internal.logging;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

public abstract class Logger
{
  private static final LoggerFactory LOGGER_FACTORY;
  private static final String LOGGER_FACTORY_IMPLEMENTATION = "twitter4j.loggerFactory";
  
  static
  {
    Object localObject1 = null;
    Object localObject2 = System.getProperty("twitter4j.loggerFactory");
    if (localObject2 != null) {
      localObject1 = getLoggerFactoryIfAvailable((String)localObject2, (String)localObject2);
    }
    Configuration localConfiguration = ConfigurationContext.getInstance();
    localObject2 = localConfiguration.getLoggerFactory();
    if (localObject2 != null) {
      localObject1 = getLoggerFactoryIfAvailable((String)localObject2, (String)localObject2);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = getLoggerFactoryIfAvailable("org.slf4j.impl.StaticLoggerBinder", "twitter4j.internal.logging.SLF4JLoggerFactory");
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = getLoggerFactoryIfAvailable("org.apache.commons.logging.Log", "twitter4j.internal.logging.CommonsLoggingLoggerFactory");
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = getLoggerFactoryIfAvailable("org.apache.log4j.Logger", "twitter4j.internal.logging.Log4JLoggerFactory");
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = getLoggerFactoryIfAvailable("com.google.appengine.api.urlfetch.URLFetchService", "twitter4j.internal.logging.JULLoggerFactory");
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new StdOutLoggerFactory();
    }
    LOGGER_FACTORY = (LoggerFactory)localObject2;
    try
    {
      localObject1 = localConfiguration.getClass().getMethod("dumpConfiguration", new Class[0]);
      ((Method)localObject1).setAccessible(true);
      ((Method)localObject1).invoke(localConfiguration, new Object[0]);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}catch (InvocationTargetException localInvocationTargetException) {}catch (IllegalAccessException localIllegalAccessException) {}
  }
  
  public static Logger getLogger(Class paramClass)
  {
    return LOGGER_FACTORY.getLogger(paramClass);
  }
  
  private static LoggerFactory getLoggerFactoryIfAvailable(String paramString1, String paramString2)
  {
    try
    {
      Class.forName(paramString1);
      paramString1 = (LoggerFactory)Class.forName(paramString2).newInstance();
      return paramString1;
    }
    catch (InstantiationException paramString1)
    {
      throw new AssertionError(paramString1);
    }
    catch (IllegalAccessException paramString1)
    {
      throw new AssertionError(paramString1);
    }
    catch (SecurityException paramString1)
    {
      return null;
    }
    catch (ClassNotFoundException paramString1)
    {
      for (;;) {}
    }
  }
  
  public abstract void debug(String paramString);
  
  public abstract void debug(String paramString1, String paramString2);
  
  public abstract void error(String paramString);
  
  public abstract void error(String paramString, Throwable paramThrowable);
  
  public abstract void info(String paramString);
  
  public abstract void info(String paramString1, String paramString2);
  
  public abstract boolean isDebugEnabled();
  
  public abstract boolean isErrorEnabled();
  
  public abstract boolean isInfoEnabled();
  
  public abstract boolean isWarnEnabled();
  
  public abstract void warn(String paramString);
  
  public abstract void warn(String paramString1, String paramString2);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/logging/Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */