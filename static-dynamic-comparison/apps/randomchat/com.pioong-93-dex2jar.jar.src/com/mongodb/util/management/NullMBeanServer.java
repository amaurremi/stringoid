package com.mongodb.util.management;

public class NullMBeanServer
  implements MBeanServer
{
  public boolean isRegistered(String paramString)
  {
    return false;
  }
  
  public void registerMBean(Object paramObject, String paramString) {}
  
  public void unregisterMBean(String paramString) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/management/NullMBeanServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */