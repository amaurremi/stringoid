package com.mongodb.util.management;

import com.mongodb.util.management.jmx.JMXMBeanServer;

public class MBeanServerFactory
{
  private static final MBeanServer mBeanServer;
  
  static
  {
    try
    {
      JMXMBeanServer localJMXMBeanServer = new JMXMBeanServer();
      mBeanServer = localJMXMBeanServer;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        NullMBeanServer localNullMBeanServer = new NullMBeanServer();
      }
    }
  }
  
  public static MBeanServer getMBeanServer()
  {
    return mBeanServer;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/management/MBeanServerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */