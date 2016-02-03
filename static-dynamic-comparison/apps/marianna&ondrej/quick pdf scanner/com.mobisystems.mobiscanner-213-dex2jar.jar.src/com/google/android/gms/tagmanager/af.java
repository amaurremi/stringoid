package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Message;
import com.google.android.gms.common.api.Status;

class af
  implements b
{
  private a XW;
  private a XX;
  private b XY;
  private a XZ;
  private d Ya;
  private boolean rp;
  private Status ty;
  
  /* Error */
  public void bl(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/google/android/gms/tagmanager/af:rp	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 31	com/google/android/gms/tagmanager/af:XW	Lcom/google/android/gms/tagmanager/a;
    //   18: aload_1
    //   19: invokevirtual 35	com/google/android/gms/tagmanager/a:bl	(Ljava/lang/String;)V
    //   22: goto -11 -> 11
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	af
    //   0	30	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   14	22	25	finally
  }
  
  void bv(String paramString)
  {
    if (this.rp)
    {
      j.Z("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
      return;
    }
    this.XZ.bv(paramString);
  }
  
  public Status mq()
  {
    return this.ty;
  }
  
  /* Error */
  public void refresh()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/google/android/gms/tagmanager/af:rp	Z
    //   6: ifeq +11 -> 17
    //   9: ldc 55
    //   11: invokestatic 43	com/google/android/gms/tagmanager/j:Z	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 45	com/google/android/gms/tagmanager/af:XZ	Lcom/google/android/gms/tagmanager/af$a;
    //   21: invokeinterface 58 1 0
    //   26: goto -12 -> 14
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	af
    //   29	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	29	finally
    //   17	26	29	finally
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 29	com/google/android/gms/tagmanager/af:rp	Z
    //   6: ifeq +11 -> 17
    //   9: ldc 61
    //   11: invokestatic 43	com/google/android/gms/tagmanager/j:Z	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 29	com/google/android/gms/tagmanager/af:rp	Z
    //   22: aload_0
    //   23: getfield 63	com/google/android/gms/tagmanager/af:Ya	Lcom/google/android/gms/tagmanager/d;
    //   26: aload_0
    //   27: invokevirtual 68	com/google/android/gms/tagmanager/d:a	(Lcom/google/android/gms/tagmanager/af;)Z
    //   30: pop
    //   31: aload_0
    //   32: getfield 31	com/google/android/gms/tagmanager/af:XW	Lcom/google/android/gms/tagmanager/a;
    //   35: invokevirtual 70	com/google/android/gms/tagmanager/a:release	()V
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 31	com/google/android/gms/tagmanager/af:XW	Lcom/google/android/gms/tagmanager/a;
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 72	com/google/android/gms/tagmanager/af:XX	Lcom/google/android/gms/tagmanager/a;
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 45	com/google/android/gms/tagmanager/af:XZ	Lcom/google/android/gms/tagmanager/af$a;
    //   53: aload_0
    //   54: aconst_null
    //   55: putfield 74	com/google/android/gms/tagmanager/af:XY	Lcom/google/android/gms/tagmanager/af$b;
    //   58: goto -44 -> 14
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	af
    //   61	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	61	finally
    //   17	58	61	finally
  }
  
  String vD()
  {
    if (this.rp)
    {
      j.Z("getContainerId called on a released ContainerHolder.");
      return "";
    }
    return this.XW.vD();
  }
  
  String wy()
  {
    if (this.rp)
    {
      j.Z("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
      return "";
    }
    return this.XZ.wy();
  }
  
  public static abstract interface a
  {
    public abstract void bv(String paramString);
    
    public abstract String wy();
    
    public abstract void wz();
  }
  
  private class b
    extends Handler
  {
    private final b.a Yb;
    
    protected void bw(String paramString)
    {
      this.Yb.a(this.Yc, paramString);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        j.Z("Don't know how to handle this message.");
        return;
      }
      bw((String)paramMessage.obj);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/tagmanager/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */