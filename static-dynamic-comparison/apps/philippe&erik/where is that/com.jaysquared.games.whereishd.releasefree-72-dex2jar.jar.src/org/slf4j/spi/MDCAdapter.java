package org.slf4j.spi;

import java.util.Map;

public abstract interface MDCAdapter
{
  public abstract void clear();
  
  public abstract String get(String paramString);
  
  public abstract Map getCopyOfContextMap();
  
  public abstract void put(String paramString1, String paramString2);
  
  public abstract void remove(String paramString);
  
  public abstract void setContextMap(Map paramMap);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/slf4j/spi/MDCAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */