package com.vladium.emma;

import com.vladium.logging.Logger;
import com.vladium.util.IProperties;
import java.util.Properties;

public abstract class Processor
{
  protected String m_appName;
  protected Logger m_log;
  protected IProperties m_propertyOverrides;
  
  protected abstract void _run(IProperties paramIProperties);
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 21	com/vladium/emma/Processor:validateState	()V
    //   6: invokestatic 27	com/vladium/emma/EMMAProperties:getAppProperties	()Lcom/vladium/util/IProperties;
    //   9: astore_1
    //   10: aload_0
    //   11: getfield 29	com/vladium/emma/Processor:m_propertyOverrides	Lcom/vladium/util/IProperties;
    //   14: aload_1
    //   15: invokestatic 35	com/vladium/util/IProperties$Factory:combine	(Lcom/vladium/util/IProperties;Lcom/vladium/util/IProperties;)Lcom/vladium/util/IProperties;
    //   18: astore_1
    //   19: invokestatic 41	com/vladium/logging/Logger:getLogger	()Lcom/vladium/logging/Logger;
    //   22: astore_2
    //   23: aload_0
    //   24: getfield 43	com/vladium/emma/Processor:m_appName	Ljava/lang/String;
    //   27: aload_1
    //   28: aload_2
    //   29: invokestatic 49	com/vladium/emma/AppLoggers:create	(Ljava/lang/String;Lcom/vladium/util/IProperties;Lcom/vladium/logging/Logger;)Lcom/vladium/logging/Logger;
    //   32: astore_2
    //   33: aload_2
    //   34: invokevirtual 53	com/vladium/logging/Logger:atTRACE1	()Z
    //   37: ifeq +21 -> 58
    //   40: aload_2
    //   41: ldc 54
    //   43: ldc 56
    //   45: invokevirtual 60	com/vladium/logging/Logger:trace1	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: aload_1
    //   49: aload_2
    //   50: invokevirtual 64	com/vladium/logging/Logger:getWriter	()Ljava/io/PrintWriter;
    //   53: invokeinterface 70 2 0
    //   58: aload_2
    //   59: invokestatic 74	com/vladium/logging/Logger:push	(Lcom/vladium/logging/Logger;)V
    //   62: aload_0
    //   63: aload_2
    //   64: putfield 76	com/vladium/emma/Processor:m_log	Lcom/vladium/logging/Logger;
    //   67: aload_0
    //   68: aload_1
    //   69: invokevirtual 78	com/vladium/emma/Processor:_run	(Lcom/vladium/util/IProperties;)V
    //   72: aload_0
    //   73: getfield 76	com/vladium/emma/Processor:m_log	Lcom/vladium/logging/Logger;
    //   76: ifnull +15 -> 91
    //   79: aload_0
    //   80: getfield 76	com/vladium/emma/Processor:m_log	Lcom/vladium/logging/Logger;
    //   83: invokestatic 81	com/vladium/logging/Logger:pop	(Lcom/vladium/logging/Logger;)V
    //   86: aload_0
    //   87: aconst_null
    //   88: putfield 76	com/vladium/emma/Processor:m_log	Lcom/vladium/logging/Logger;
    //   91: aload_0
    //   92: monitorexit
    //   93: return
    //   94: astore_1
    //   95: aload_0
    //   96: getfield 76	com/vladium/emma/Processor:m_log	Lcom/vladium/logging/Logger;
    //   99: ifnull +15 -> 114
    //   102: aload_0
    //   103: getfield 76	com/vladium/emma/Processor:m_log	Lcom/vladium/logging/Logger;
    //   106: invokestatic 81	com/vladium/logging/Logger:pop	(Lcom/vladium/logging/Logger;)V
    //   109: aload_0
    //   110: aconst_null
    //   111: putfield 76	com/vladium/emma/Processor:m_log	Lcom/vladium/logging/Logger;
    //   114: aload_1
    //   115: athrow
    //   116: astore_1
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_1
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	Processor
    //   9	60	1	localIProperties	IProperties
    //   94	21	1	localObject1	Object
    //   116	4	1	localObject2	Object
    //   22	42	2	localLogger	Logger
    // Exception table:
    //   from	to	target	type
    //   58	72	94	finally
    //   2	58	116	finally
    //   72	91	116	finally
    //   95	114	116	finally
    //   114	116	116	finally
  }
  
  public final void setAppName(String paramString)
  {
    try
    {
      this.m_appName = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void setPropertyOverrides(IProperties paramIProperties)
  {
    try
    {
      this.m_propertyOverrides = paramIProperties;
      return;
    }
    finally
    {
      paramIProperties = finally;
      throw paramIProperties;
    }
  }
  
  public final void setPropertyOverrides(Properties paramProperties)
  {
    try
    {
      this.m_propertyOverrides = EMMAProperties.wrap(paramProperties);
      return;
    }
    finally
    {
      paramProperties = finally;
      throw paramProperties;
    }
  }
  
  protected void validateState() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/Processor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */