package org.slf4j.helpers;

import java.io.ObjectStreamException;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class NamedLoggerBase
  implements Logger, Serializable
{
  protected String name;
  
  public String getName()
  {
    return this.name;
  }
  
  protected Object readResolve()
    throws ObjectStreamException
  {
    return LoggerFactory.getLogger(getName());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/slf4j/helpers/NamedLoggerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */