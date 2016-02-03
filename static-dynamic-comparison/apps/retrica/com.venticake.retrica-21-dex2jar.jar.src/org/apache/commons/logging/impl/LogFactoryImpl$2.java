package org.apache.commons.logging.impl;

import java.security.PrivilegedAction;

class LogFactoryImpl$2
  implements PrivilegedAction
{
  LogFactoryImpl$2(String paramString1, String paramString2)
  {
    this.val$key = paramString1;
    this.val$def = paramString2;
  }
  
  public Object run()
  {
    return System.getProperty(this.val$key, this.val$def);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/apache/commons/logging/impl/LogFactoryImpl$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */