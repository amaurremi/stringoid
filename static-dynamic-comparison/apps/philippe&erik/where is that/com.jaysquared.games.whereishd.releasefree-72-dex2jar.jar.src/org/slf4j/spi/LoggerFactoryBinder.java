package org.slf4j.spi;

import org.slf4j.ILoggerFactory;

public abstract interface LoggerFactoryBinder
{
  public abstract ILoggerFactory getLoggerFactory();
  
  public abstract String getLoggerFactoryClassStr();
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/slf4j/spi/LoggerFactoryBinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */