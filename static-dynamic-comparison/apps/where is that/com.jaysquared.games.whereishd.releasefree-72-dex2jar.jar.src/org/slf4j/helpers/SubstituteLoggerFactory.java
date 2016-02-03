package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class SubstituteLoggerFactory
  implements ILoggerFactory
{
  final List loggerNameList = new ArrayList();
  
  public Logger getLogger(String paramString)
  {
    this.loggerNameList.add(paramString);
    return NOPLogger.NOP_LOGGER;
  }
  
  public List getLoggerNameList()
  {
    return this.loggerNameList;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/slf4j/helpers/SubstituteLoggerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */