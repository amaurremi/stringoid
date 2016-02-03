package org.apache.commons.logging.impl;

import java.security.PrivilegedAction;

class SimpleLog$1
  implements PrivilegedAction
{
  SimpleLog$1(String paramString)
  {
    this.val$name = paramString;
  }
  
  public Object run()
  {
    ClassLoader localClassLoader = SimpleLog.access$000();
    if (localClassLoader != null) {
      return localClassLoader.getResourceAsStream(this.val$name);
    }
    return ClassLoader.getSystemResourceAsStream(this.val$name);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/apache/commons/logging/impl/SimpleLog$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */