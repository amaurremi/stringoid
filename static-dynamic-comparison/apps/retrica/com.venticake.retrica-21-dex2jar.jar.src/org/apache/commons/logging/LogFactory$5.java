package org.apache.commons.logging;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.PrivilegedAction;
import java.util.Properties;

class LogFactory$5
  implements PrivilegedAction
{
  LogFactory$5(URL paramURL)
  {
    this.val$url = paramURL;
  }
  
  public Object run()
  {
    try
    {
      InputStream localInputStream = this.val$url.openStream();
      if (localInputStream != null)
      {
        Properties localProperties = new Properties();
        localProperties.load(localInputStream);
        localInputStream.close();
        return localProperties;
      }
    }
    catch (IOException localIOException)
    {
      if (LogFactory.isDiagnosticsEnabled()) {
        LogFactory.access$000("Unable to read URL " + this.val$url);
      }
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/apache/commons/logging/LogFactory$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */