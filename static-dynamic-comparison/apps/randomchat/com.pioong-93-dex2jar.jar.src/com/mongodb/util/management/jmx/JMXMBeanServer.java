package com.mongodb.util.management.jmx;

import com.mongodb.util.management.JMException;
import java.lang.management.ManagementFactory;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class JMXMBeanServer
  implements com.mongodb.util.management.MBeanServer
{
  private final javax.management.MBeanServer server = ManagementFactory.getPlatformMBeanServer();
  
  private ObjectName createObjectName(String paramString)
    throws JMException
  {
    try
    {
      paramString = new ObjectName(paramString);
      return paramString;
    }
    catch (MalformedObjectNameException paramString)
    {
      throw new JMException(paramString);
    }
  }
  
  public boolean isRegistered(String paramString)
    throws JMException
  {
    return this.server.isRegistered(createObjectName(paramString));
  }
  
  public void registerMBean(Object paramObject, String paramString)
    throws JMException
  {
    try
    {
      this.server.registerMBean(paramObject, createObjectName(paramString));
      return;
    }
    catch (InstanceAlreadyExistsException paramObject)
    {
      throw new JMException((Throwable)paramObject);
    }
    catch (MBeanRegistrationException paramObject)
    {
      throw new JMException((Throwable)paramObject);
    }
    catch (NotCompliantMBeanException paramObject)
    {
      throw new JMException((Throwable)paramObject);
    }
  }
  
  public void unregisterMBean(String paramString)
    throws JMException
  {
    try
    {
      this.server.unregisterMBean(createObjectName(paramString));
      return;
    }
    catch (InstanceNotFoundException paramString)
    {
      throw new JMException(paramString);
    }
    catch (MBeanRegistrationException paramString)
    {
      throw new JMException(paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/management/jmx/JMXMBeanServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */