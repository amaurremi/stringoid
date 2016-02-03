package org.apache.commons.logging;

import java.security.PrivilegedAction;

class LogFactory$1
  implements PrivilegedAction
{
  public Object run()
  {
    return LogFactory.directGetContextClassLoader();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/apache/commons/logging/LogFactory$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */