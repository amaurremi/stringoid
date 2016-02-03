package org.apache.commons.logging;

import java.security.PrivilegedAction;

class LogFactory$3
  implements PrivilegedAction
{
  LogFactory$3(ClassLoader paramClassLoader, String paramString)
  {
    this.val$loader = paramClassLoader;
    this.val$name = paramString;
  }
  
  public Object run()
  {
    if (this.val$loader != null) {
      return this.val$loader.getResourceAsStream(this.val$name);
    }
    return ClassLoader.getSystemResourceAsStream(this.val$name);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/apache/commons/logging/LogFactory$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */