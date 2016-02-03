package com.amazonaws.util;

import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import org.a.a.i;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

class JodaTime$LazyHolder
{
  static final String version = ;
  
  private static String getVersion()
  {
    try
    {
      Object localObject1 = Classes.jarFileOf(i.class);
      if (localObject1 == null) {
        return null;
      }
      Object localObject2 = ((JarFile)localObject1).getManifest().getMainAttributes();
      localObject1 = ((Attributes)localObject2).getValue("Bundle-Name");
      localObject2 = ((Attributes)localObject2).getValue("Bundle-Version");
      boolean bool = "Joda-Time".equals(localObject1);
      if ((bool) && (localObject2 != null)) {
        return (String)localObject2;
      }
    }
    catch (Exception localException)
    {
      LogFactory.getLog(JodaTime.class).debug("FYI", localException);
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/util/JodaTime$LazyHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */