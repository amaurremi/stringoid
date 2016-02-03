package org.slf4j.helpers;

import java.util.Map;
import org.slf4j.spi.MDCAdapter;

public class NOPMakerAdapter
  implements MDCAdapter
{
  public void clear() {}
  
  public String get(String paramString)
  {
    return null;
  }
  
  public Map getCopyOfContextMap()
  {
    return null;
  }
  
  public void put(String paramString1, String paramString2) {}
  
  public void remove(String paramString) {}
  
  public void setContextMap(Map paramMap) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/slf4j/helpers/NOPMakerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */