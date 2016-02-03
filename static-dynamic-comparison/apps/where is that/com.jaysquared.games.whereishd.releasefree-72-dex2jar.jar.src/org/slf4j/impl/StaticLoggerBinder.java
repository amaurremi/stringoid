package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

public class StaticLoggerBinder
  implements LoggerFactoryBinder
{
  public static String REQUESTED_API_VERSION = "1.5.8";
  private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();
  private static final String loggerFactoryClassStr = AndroidLoggerFactory.class.getName();
  private final ILoggerFactory loggerFactory = new AndroidLoggerFactory();
  
  public static final StaticLoggerBinder getSingleton()
  {
    return SINGLETON;
  }
  
  public ILoggerFactory getLoggerFactory()
  {
    return this.loggerFactory;
  }
  
  public String getLoggerFactoryClassStr()
  {
    return loggerFactoryClassStr;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/slf4j/impl/StaticLoggerBinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */