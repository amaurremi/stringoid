package org.slf4j.impl;

import org.slf4j.helpers.NOPMakerAdapter;
import org.slf4j.spi.MDCAdapter;

public class StaticMDCBinder
{
  public static final StaticMDCBinder SINGLETON = new StaticMDCBinder();
  
  public MDCAdapter getMDCA()
  {
    return new NOPMakerAdapter();
  }
  
  public String getMDCAdapterClassStr()
  {
    return NOPMakerAdapter.class.getName();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/slf4j/impl/StaticMDCBinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */