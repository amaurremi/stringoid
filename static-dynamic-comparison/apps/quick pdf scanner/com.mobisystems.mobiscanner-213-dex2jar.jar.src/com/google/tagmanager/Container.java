package com.google.tagmanager;

import com.google.analytics.containertag.proto.Serving.Resource;

public class Container
{
  private final TagManager ahW;
  private a ahX;
  private h ahY;
  private b ahZ;
  private volatile String aia;
  private volatile Serving.Resource aib;
  private volatile long aic;
  private volatile int aid;
  
  private h Ar()
  {
    try
    {
      h localh = this.ahY;
      return localh;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private boolean At()
  {
    return this.ahW.Ax() == TagManager.RefreshMode.aiQ;
  }
  
  private boolean C(long paramLong)
  {
    if (this.aic == 0L)
    {
      this.aid -= 1;
      return true;
    }
    paramLong -= this.aic;
    if (paramLong < 5000L) {
      return false;
    }
    if (this.aid < 30) {
      this.aid = Math.min(30, (int)Math.floor(paramLong / 900000L) + this.aid);
    }
    if (this.aid > 0)
    {
      this.aid -= 1;
      return true;
    }
    return false;
  }
  
  String As()
  {
    return this.aia;
  }
  
  /* Error */
  void B(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 72	com/google/tagmanager/Container:ahX	Lcom/google/tagmanager/Container$a;
    //   6: ifnull +30 -> 36
    //   9: aload_0
    //   10: invokespecial 74	com/google/tagmanager/Container:At	()Z
    //   13: ifne +23 -> 36
    //   16: aload_0
    //   17: getfield 76	com/google/tagmanager/Container:aib	Lcom/google/analytics/containertag/proto/Serving$Resource;
    //   20: ifnonnull +19 -> 39
    //   23: aconst_null
    //   24: astore_3
    //   25: aload_0
    //   26: getfield 72	com/google/tagmanager/Container:ahX	Lcom/google/tagmanager/Container$a;
    //   29: lload_1
    //   30: aload_3
    //   31: invokeinterface 79 4 0
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: aload_0
    //   40: getfield 76	com/google/tagmanager/Container:aib	Lcom/google/analytics/containertag/proto/Serving$Resource;
    //   43: invokevirtual 84	com/google/analytics/containertag/proto/Serving$Resource:getVersion	()Ljava/lang/String;
    //   46: astore_3
    //   47: goto -22 -> 25
    //   50: astore_3
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_3
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	Container
    //   0	55	1	paramLong	long
    //   24	23	3	str	String
    //   50	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	50	finally
    //   25	36	50	finally
    //   39	47	50	finally
  }
  
  void cQ(String paramString)
  {
    try
    {
      this.aia = paramString;
      if (this.ahX != null) {
        this.ahX.cR(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void refresh()
  {
    for (;;)
    {
      try
      {
        if (Ar() == null)
        {
          f.D("refresh called for closed container");
          return;
        }
        try
        {
          if (!At()) {
            break label66;
          }
          f.D("Container is in DEFAULT_CONTAINER mode. Refresh request is ignored.");
        }
        catch (Exception localException)
        {
          f.A("Calling refresh() throws an exception: " + localException.getMessage());
        }
        continue;
        l = this.ahZ.currentTimeMillis();
      }
      finally {}
      label66:
      long l;
      if (C(l))
      {
        f.C("Container refresh requested");
        B(0L);
        this.aic = l;
      }
      else
      {
        f.C("Container refresh was called too often. Ignored.");
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void a(long paramLong, String paramString);
    
    public abstract void cR(String paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/tagmanager/Container.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */