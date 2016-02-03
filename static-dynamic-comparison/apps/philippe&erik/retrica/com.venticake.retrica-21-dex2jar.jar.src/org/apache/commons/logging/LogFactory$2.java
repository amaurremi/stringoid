package org.apache.commons.logging;

import java.security.PrivilegedAction;

class LogFactory$2
  implements PrivilegedAction
{
  LogFactory$2(String paramString, ClassLoader paramClassLoader)
  {
    this.val$factoryClass = paramString;
    this.val$classLoader = paramClassLoader;
  }
  
  public Object run()
  {
    return LogFactory.createFactory(this.val$factoryClass, this.val$classLoader);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/apache/commons/logging/LogFactory$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */