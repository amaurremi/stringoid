package com.jirbo.adcolony;

class ADCLog
{
  static ADCLog debug;
  static ADCLog dev = new ADCLog(0, false);
  static ADCLog error = new ADCLog(3, true);
  static ADCLog info;
  StringBuilder buffer = new StringBuilder();
  boolean enabled;
  int log_level;
  
  static
  {
    debug = new ADCLog(1, false);
    info = new ADCLog(2, true);
  }
  
  ADCLog(int paramInt, boolean paramBoolean)
  {
    this.log_level = paramInt;
    this.enabled = paramBoolean;
  }
  
  boolean fail(String paramString)
  {
    print(paramString + '\n');
    return false;
  }
  
  int int_fail(String paramString)
  {
    print(paramString + '\n');
    return 0;
  }
  
  /* Error */
  ADCLog print(char paramChar)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/jirbo/adcolony/ADCLog:enabled	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_0
    //   14: areturn
    //   15: aload_0
    //   16: getfield 37	com/jirbo/adcolony/ADCLog:buffer	Ljava/lang/StringBuilder;
    //   19: iload_1
    //   20: invokevirtual 50	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: iload_1
    //   25: bipush 10
    //   27: if_icmpne +25 -> 52
    //   30: aload_0
    //   31: getfield 39	com/jirbo/adcolony/ADCLog:log_level	I
    //   34: aload_0
    //   35: getfield 37	com/jirbo/adcolony/ADCLog:buffer	Ljava/lang/StringBuilder;
    //   38: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 67	com/jirbo/adcolony/ADC:log	(ILjava/lang/String;)V
    //   44: aload_0
    //   45: getfield 37	com/jirbo/adcolony/ADCLog:buffer	Ljava/lang/StringBuilder;
    //   48: iconst_0
    //   49: invokevirtual 71	java/lang/StringBuilder:setLength	(I)V
    //   52: goto -41 -> 11
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	ADCLog
    //   0	60	1	paramChar	char
    //   6	2	2	bool	boolean
    //   55	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	55	finally
    //   15	24	55	finally
    //   30	52	55	finally
  }
  
  /* Error */
  ADCLog print(double paramDouble)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/jirbo/adcolony/ADCLog:enabled	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifne +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_0
    //   14: areturn
    //   15: dload_1
    //   16: iconst_2
    //   17: aload_0
    //   18: getfield 37	com/jirbo/adcolony/ADCLog:buffer	Ljava/lang/StringBuilder;
    //   21: invokestatic 78	com/jirbo/adcolony/ADCUtil:format	(DILjava/lang/StringBuilder;)V
    //   24: goto -13 -> 11
    //   27: astore 4
    //   29: aload_0
    //   30: monitorexit
    //   31: aload 4
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	ADCLog
    //   0	34	1	paramDouble	double
    //   6	2	3	bool	boolean
    //   27	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	27	finally
    //   15	24	27	finally
  }
  
  /* Error */
  ADCLog print(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/jirbo/adcolony/ADCLog:enabled	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_0
    //   14: areturn
    //   15: aload_0
    //   16: getfield 37	com/jirbo/adcolony/ADCLog:buffer	Ljava/lang/StringBuilder;
    //   19: iload_1
    //   20: invokevirtual 82	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: goto -13 -> 11
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	ADCLog
    //   0	32	1	paramInt	int
    //   6	2	2	bool	boolean
    //   27	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	27	finally
    //   15	24	27	finally
  }
  
  /* Error */
  ADCLog print(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/jirbo/adcolony/ADCLog:enabled	Z
    //   6: ifeq +14 -> 20
    //   9: aload_1
    //   10: ifnonnull +14 -> 24
    //   13: aload_0
    //   14: ldc 85
    //   16: invokevirtual 58	com/jirbo/adcolony/ADCLog:print	(Ljava/lang/String;)Lcom/jirbo/adcolony/ADCLog;
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_0
    //   23: areturn
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 86	java/lang/Object:toString	()Ljava/lang/String;
    //   29: invokevirtual 58	com/jirbo/adcolony/ADCLog:print	(Ljava/lang/String;)Lcom/jirbo/adcolony/ADCLog;
    //   32: pop
    //   33: goto -13 -> 20
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	ADCLog
    //   0	41	1	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	36	finally
    //   13	20	36	finally
    //   24	33	36	finally
  }
  
  ADCLog print(String paramString)
  {
    try
    {
      boolean bool = this.enabled;
      if (!bool) {}
      for (;;)
      {
        return this;
        if (paramString == null)
        {
          this.buffer.append("null");
        }
        else
        {
          int j = paramString.length();
          int i = 0;
          while (i < j)
          {
            print(paramString.charAt(i));
            i += 1;
          }
        }
      }
    }
    finally {}
  }
  
  /* Error */
  ADCLog print(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/jirbo/adcolony/ADCLog:enabled	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_0
    //   14: areturn
    //   15: aload_0
    //   16: getfield 37	com/jirbo/adcolony/ADCLog:buffer	Ljava/lang/StringBuilder;
    //   19: iload_1
    //   20: invokevirtual 102	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: goto -13 -> 11
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	ADCLog
    //   0	32	1	paramBoolean	boolean
    //   6	2	2	bool	boolean
    //   27	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	27	finally
    //   15	24	27	finally
  }
  
  ADCLog println()
  {
    try
    {
      ADCLog localADCLog = print('\n');
      return localADCLog;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  ADCLog println(double paramDouble)
  {
    try
    {
      print(paramDouble);
      ADCLog localADCLog = print('\n');
      return localADCLog;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  ADCLog println(int paramInt)
  {
    try
    {
      print(paramInt);
      ADCLog localADCLog = print('\n');
      return localADCLog;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  ADCLog println(Object paramObject)
  {
    try
    {
      print(paramObject);
      paramObject = print('\n');
      return (ADCLog)paramObject;
    }
    finally
    {
      paramObject = finally;
      throw ((Throwable)paramObject);
    }
  }
  
  ADCLog println(boolean paramBoolean)
  {
    try
    {
      print(paramBoolean);
      ADCLog localADCLog = print('\n');
      return localADCLog;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */