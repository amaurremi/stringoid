package com.jirbo.adcolony;

class l
{
  static l a = new l(0, false);
  static l b = new l(1, false);
  static l c = new l(2, true);
  static l d = new l(3, true);
  int e;
  boolean f;
  StringBuilder g = new StringBuilder();
  
  l(int paramInt, boolean paramBoolean)
  {
    this.e = paramInt;
    this.f = paramBoolean;
  }
  
  l a()
  {
    try
    {
      l locall = a('\n');
      return locall;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  l a(char paramChar)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/jirbo/adcolony/l:f	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_0
    //   14: areturn
    //   15: aload_0
    //   16: getfield 37	com/jirbo/adcolony/l:g	Ljava/lang/StringBuilder;
    //   19: iload_1
    //   20: invokevirtual 49	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: iload_1
    //   25: bipush 10
    //   27: if_icmpne +25 -> 52
    //   30: aload_0
    //   31: getfield 39	com/jirbo/adcolony/l:e	I
    //   34: aload_0
    //   35: getfield 37	com/jirbo/adcolony/l:g	Ljava/lang/StringBuilder;
    //   38: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 58	com/jirbo/adcolony/a:a	(ILjava/lang/String;)V
    //   44: aload_0
    //   45: getfield 37	com/jirbo/adcolony/l:g	Ljava/lang/StringBuilder;
    //   48: iconst_0
    //   49: invokevirtual 62	java/lang/StringBuilder:setLength	(I)V
    //   52: goto -41 -> 11
    //   55: astore_3
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_3
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	l
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
  l a(double paramDouble)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/jirbo/adcolony/l:f	Z
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
    //   18: getfield 37	com/jirbo/adcolony/l:g	Ljava/lang/StringBuilder;
    //   21: invokestatic 68	com/jirbo/adcolony/ab:a	(DILjava/lang/StringBuilder;)V
    //   24: goto -13 -> 11
    //   27: astore 4
    //   29: aload_0
    //   30: monitorexit
    //   31: aload 4
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	l
    //   0	34	1	paramDouble	double
    //   6	2	3	bool	boolean
    //   27	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	27	finally
    //   15	24	27	finally
  }
  
  /* Error */
  l a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/jirbo/adcolony/l:f	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_0
    //   14: areturn
    //   15: aload_0
    //   16: getfield 37	com/jirbo/adcolony/l:g	Ljava/lang/StringBuilder;
    //   19: iload_1
    //   20: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: goto -13 -> 11
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	l
    //   0	32	1	paramInt	int
    //   6	2	2	bool	boolean
    //   27	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	27	finally
    //   15	24	27	finally
  }
  
  /* Error */
  l a(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/jirbo/adcolony/l:f	Z
    //   6: ifeq +14 -> 20
    //   9: aload_1
    //   10: ifnonnull +14 -> 24
    //   13: aload_0
    //   14: ldc 75
    //   16: invokevirtual 78	com/jirbo/adcolony/l:a	(Ljava/lang/String;)Lcom/jirbo/adcolony/l;
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_0
    //   23: areturn
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 79	java/lang/Object:toString	()Ljava/lang/String;
    //   29: invokevirtual 78	com/jirbo/adcolony/l:a	(Ljava/lang/String;)Lcom/jirbo/adcolony/l;
    //   32: pop
    //   33: goto -13 -> 20
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	l
    //   0	41	1	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	36	finally
    //   13	20	36	finally
    //   24	33	36	finally
  }
  
  l a(String paramString)
  {
    try
    {
      boolean bool = this.f;
      if (!bool) {}
      for (;;)
      {
        return this;
        if (paramString == null)
        {
          this.g.append("null");
        }
        else
        {
          int j = paramString.length();
          int i = 0;
          while (i < j)
          {
            a(paramString.charAt(i));
            i += 1;
          }
        }
      }
    }
    finally {}
  }
  
  /* Error */
  l a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/jirbo/adcolony/l:f	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +7 -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_0
    //   14: areturn
    //   15: aload_0
    //   16: getfield 37	com/jirbo/adcolony/l:g	Ljava/lang/StringBuilder;
    //   19: iload_1
    //   20: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: goto -13 -> 11
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	l
    //   0	32	1	paramBoolean	boolean
    //   6	2	2	bool	boolean
    //   27	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	27	finally
    //   15	24	27	finally
  }
  
  l b(double paramDouble)
  {
    try
    {
      a(paramDouble);
      l locall = a('\n');
      return locall;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  l b(int paramInt)
  {
    try
    {
      a(paramInt);
      l locall = a('\n');
      return locall;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  l b(Object paramObject)
  {
    try
    {
      a(paramObject);
      paramObject = a('\n');
      return (l)paramObject;
    }
    finally
    {
      paramObject = finally;
      throw ((Throwable)paramObject);
    }
  }
  
  l b(boolean paramBoolean)
  {
    try
    {
      a(paramBoolean);
      l locall = a('\n');
      return locall;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  boolean b(String paramString)
  {
    a(paramString + '\n');
    return false;
  }
  
  int c(String paramString)
  {
    a(paramString + '\n');
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */