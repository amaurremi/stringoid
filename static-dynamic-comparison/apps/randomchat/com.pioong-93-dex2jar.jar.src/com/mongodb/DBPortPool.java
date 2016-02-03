package com.mongodb;

import com.mongodb.util.ConnectionPoolStatisticsBean;
import com.mongodb.util.SimplePool;
import com.mongodb.util.management.JMException;
import com.mongodb.util.management.MBeanServer;
import com.mongodb.util.management.MBeanServerFactory;
import java.io.InterruptedIOException;
import java.nio.channels.ClosedByInterruptException;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBPortPool
  extends SimplePool<DBPort>
{
  final ServerAddress _addr;
  boolean _everWorked = false;
  final MongoOptions _options;
  private final Semaphore _waitingSem;
  
  DBPortPool(ServerAddress paramServerAddress, MongoOptions paramMongoOptions)
  {
    super("DBPortPool-" + paramServerAddress.toString() + ", options = " + paramMongoOptions.toString(), paramMongoOptions.connectionsPerHost);
    this._options = paramMongoOptions;
    this._addr = paramServerAddress;
    this._waitingSem = new Semaphore(this._options.connectionsPerHost * this._options.threadsAllowedToBlockForConnectionMultiplier);
  }
  
  private InUseConnectionBean[] getInUseConnections()
  {
    ArrayList localArrayList = new ArrayList();
    long l = System.nanoTime();
    Iterator localIterator = this._out.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new InUseConnectionBean((DBPort)localIterator.next(), l));
    }
    return (InUseConnectionBean[])localArrayList.toArray(new InUseConnectionBean[localArrayList.size()]);
  }
  
  public void cleanup(DBPort paramDBPort)
  {
    paramDBPort.close();
  }
  
  protected DBPort createNew()
  {
    return new DBPort(this._addr, this, this._options);
  }
  
  public DBPort get()
  {
    if (!this._waitingSem.tryAcquire()) {
      throw new SemaphoresOut(this._options.connectionsPerHost * this._options.threadsAllowedToBlockForConnectionMultiplier);
    }
    try
    {
      DBPort localDBPort1 = (DBPort)get(this._options.maxWaitTime);
      this._waitingSem.release();
      if (localDBPort1 == null) {
        throw new ConnectionWaitTimeOut(this._options.maxWaitTime);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new MongoInterruptedException(localInterruptedException);
    }
    finally
    {
      this._waitingSem.release();
    }
    localDBPort2._lastThread = System.identityHashCode(Thread.currentThread());
    return localDBPort2;
  }
  
  public String getHost()
  {
    return this._addr.getHost();
  }
  
  public int getPort()
  {
    return this._addr.getPort();
  }
  
  public ServerAddress getServerAddress()
  {
    return this._addr;
  }
  
  public ConnectionPoolStatisticsBean getStatistics()
  {
    try
    {
      ConnectionPoolStatisticsBean localConnectionPoolStatisticsBean = new ConnectionPoolStatisticsBean(getTotal(), getInUse(), getInUseConnections());
      return localConnectionPoolStatisticsBean;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  boolean gotError(Exception paramException)
  {
    if ((paramException instanceof ClosedByInterruptException)) {}
    while ((paramException instanceof InterruptedIOException)) {
      return true;
    }
    Bytes.LOGGER.log(Level.WARNING, "emptying DBPortPool to " + getServerAddress() + " b/c of error", paramException);
    paramException = new ArrayList();
    try
    {
      for (;;)
      {
        DBPort localDBPort = (DBPort)get(0L);
        if (localDBPort == null)
        {
          paramException = paramException.iterator();
          while (paramException.hasNext())
          {
            localDBPort = (DBPort)paramException.next();
            localDBPort.close();
            done(localDBPort);
          }
        }
        paramException.add(localDBPort);
      }
      return false;
    }
    catch (InterruptedException paramException)
    {
      throw new MongoInterruptedException(paramException);
    }
  }
  
  protected long memSize(DBPort paramDBPort)
  {
    return 0L;
  }
  
  protected int pick(int paramInt, boolean paramBoolean)
  {
    int j = System.identityHashCode(Thread.currentThread());
    int i = this._avail.size() - 1;
    while (i >= 0)
    {
      if (((DBPort)this._avail.get(i))._lastThread == j) {
        return i;
      }
      i -= 1;
    }
    if (paramBoolean) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  public static class ConnectionWaitTimeOut
    extends DBPortPool.NoMoreConnection
  {
    private static final long serialVersionUID = -4415279469780082174L;
    
    ConnectionWaitTimeOut(int paramInt)
    {
      super();
    }
  }
  
  static class Holder
  {
    static final boolean isJava5 = System.getProperty("java.version").startsWith("1.5");
    static AtomicInteger nextSerial = new AtomicInteger(0);
    final MongoOptions _options;
    final Map<ServerAddress, DBPortPool> _pools = Collections.synchronizedMap(new HashMap());
    final int _serial = nextSerial.incrementAndGet();
    
    Holder(MongoOptions paramMongoOptions)
    {
      this._options = paramMongoOptions;
    }
    
    private String createObjectName(ServerAddress paramServerAddress)
    {
      String str = "com.mongodb:type=ConnectionPool,host=" + paramServerAddress.toString().replace(":", ",port=") + ",instance=" + this._serial;
      paramServerAddress = str;
      if (this._options.description != null) {
        paramServerAddress = str + ",description=" + this._options.description;
      }
      return paramServerAddress;
    }
    
    private DBPortPool createPool(ServerAddress paramServerAddress)
    {
      if ((isJava5) || (this._options.isAlwaysUseMBeans())) {
        return new Java5MongoConnectionPool(paramServerAddress, this._options);
      }
      return new MongoConnectionPool(paramServerAddress, this._options);
    }
    
    void close()
    {
      synchronized (this._pools)
      {
        Iterator localIterator = this._pools.values().iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            Object localObject2 = (DBPortPool)localIterator.next();
            ((DBPortPool)localObject2).close();
            try
            {
              localObject2 = createObjectName(((DBPortPool)localObject2)._addr);
              if (MBeanServerFactory.getMBeanServer().isRegistered((String)localObject2)) {
                MBeanServerFactory.getMBeanServer().unregisterMBean((String)localObject2);
              }
            }
            catch (JMException localJMException)
            {
              Bytes.LOGGER.log(Level.WARNING, "jmx de-registration error, continuing", localJMException);
            }
          }
        }
      }
    }
    
    DBPortPool get(ServerAddress paramServerAddress)
    {
      ??? = (DBPortPool)this._pools.get(paramServerAddress);
      if (??? != null) {
        return (DBPortPool)???;
      }
      synchronized (this._pools)
      {
        DBPortPool localDBPortPool = (DBPortPool)this._pools.get(paramServerAddress);
        if (localDBPortPool != null) {
          return localDBPortPool;
        }
        localDBPortPool = createPool(paramServerAddress);
        this._pools.put(paramServerAddress, localDBPortPool);
        try
        {
          paramServerAddress = createObjectName(paramServerAddress);
          if (MBeanServerFactory.getMBeanServer().isRegistered(paramServerAddress))
          {
            MBeanServerFactory.getMBeanServer().unregisterMBean(paramServerAddress);
            Bytes.LOGGER.log(Level.INFO, "multiple Mongo instances for same host, jmx numbers might be off");
          }
          MBeanServerFactory.getMBeanServer().registerMBean(localDBPortPool, paramServerAddress);
        }
        catch (JMException paramServerAddress)
        {
          for (;;)
          {
            Bytes.LOGGER.log(Level.WARNING, "JMX registration error: " + paramServerAddress + "\nConsider setting com.mongodb.MongoOptions.alwaysUseMBeans property to true." + "\nContinuing...");
          }
          paramServerAddress = finally;
          throw paramServerAddress;
        }
        catch (AccessControlException paramServerAddress)
        {
          for (;;)
          {
            Bytes.LOGGER.log(Level.WARNING, "JMX registration error: " + paramServerAddress + "\nContinuing...");
          }
        }
        return localDBPortPool;
      }
    }
  }
  
  public static class NoMoreConnection
    extends MongoInternalException
  {
    private static final long serialVersionUID = -4415279469780082174L;
    
    NoMoreConnection(String paramString)
    {
      super();
    }
  }
  
  public static class SemaphoresOut
    extends DBPortPool.NoMoreConnection
  {
    private static final String message = "Concurrent requests for database connection have exceeded limit";
    private static final long serialVersionUID = -4415279469780082174L;
    
    SemaphoresOut()
    {
      super();
    }
    
    SemaphoresOut(int paramInt)
    {
      super();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/DBPortPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */