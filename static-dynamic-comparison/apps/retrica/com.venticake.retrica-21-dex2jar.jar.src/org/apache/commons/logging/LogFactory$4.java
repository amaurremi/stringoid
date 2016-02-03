package org.apache.commons.logging;

import java.io.IOException;
import java.security.PrivilegedAction;
import java.util.Enumeration;

class LogFactory$4
  implements PrivilegedAction
{
  LogFactory$4(ClassLoader paramClassLoader, String paramString)
  {
    this.val$loader = paramClassLoader;
    this.val$name = paramString;
  }
  
  public Object run()
  {
    try
    {
      if (this.val$loader != null) {
        return this.val$loader.getResources(this.val$name);
      }
      Enumeration localEnumeration = ClassLoader.getSystemResources(this.val$name);
      return localEnumeration;
    }
    catch (IOException localIOException)
    {
      if (LogFactory.isDiagnosticsEnabled())
      {
        LogFactory.access$000("Exception while trying to find configuration file " + this.val$name + ":" + localIOException.getMessage());
        return null;
      }
    }
    catch (NoSuchMethodError localNoSuchMethodError) {}
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/apache/commons/logging/LogFactory$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */