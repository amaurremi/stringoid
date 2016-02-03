package com.mongodb.util.management;

public abstract interface MBeanServer
{
  public abstract boolean isRegistered(String paramString)
    throws JMException;
  
  public abstract void registerMBean(Object paramObject, String paramString)
    throws JMException;
  
  public abstract void unregisterMBean(String paramString)
    throws JMException;
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/management/MBeanServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */