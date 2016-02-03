package org.apache.commons.logging.impl;

import java.security.PrivilegedAction;

class LogFactoryImpl$3
  implements PrivilegedAction
{
  LogFactoryImpl$3(LogFactoryImpl paramLogFactoryImpl, ClassLoader paramClassLoader)
  {
    this.this$0 = paramLogFactoryImpl;
    this.val$cl = paramClassLoader;
  }
  
  public Object run()
  {
    return this.val$cl.getParent();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/apache/commons/logging/impl/LogFactoryImpl$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */