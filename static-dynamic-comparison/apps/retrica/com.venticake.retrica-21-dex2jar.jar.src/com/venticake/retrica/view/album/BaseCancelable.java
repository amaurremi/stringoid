package com.venticake.retrica.view.album;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public abstract class BaseCancelable<T>
  implements Cancelable<T>
{
  private static final int STATE_CANCELED = 8;
  private static final int STATE_CANCELING = 4;
  private static final int STATE_COMPLETE = 32;
  private static final int STATE_ERROR = 16;
  private static final int STATE_EXECUTING = 2;
  private static final int STATE_INITIAL = 1;
  private Cancelable<?> mCurrentTask;
  private Throwable mError;
  private T mResult;
  private int mState = 1;
  
  private T handleTerminalStates()
  {
    if (this.mState == 8) {
      throw new CancellationException();
    }
    if (this.mState == 16) {
      throw new ExecutionException(this.mError);
    }
    if (this.mState == 32) {
      return (T)this.mResult;
    }
    throw new IllegalStateException();
  }
  
  private boolean isInStates(int paramInt)
  {
    return (this.mState & paramInt) != 0;
  }
  
  /* Error */
  public void await()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: bipush 56
    //   5: invokespecial 60	com/venticake/retrica/view/album/BaseCancelable:isInStates	(I)Z
    //   8: istore_1
    //   9: iload_1
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: invokevirtual 63	java/lang/Object:wait	()V
    //   20: goto -18 -> 2
    //   23: astore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_2
    //   27: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	BaseCancelable
    //   8	2	1	bool	boolean
    //   23	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	23	finally
    //   16	20	23	finally
  }
  
  protected abstract T execute();
  
  protected void freeCanceledResult(T paramT) {}
  
  /* Error */
  public final T get()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	com/venticake/retrica/view/album/BaseCancelable:mState	I
    //   6: iconst_1
    //   7: if_icmpeq +16 -> 23
    //   10: aload_0
    //   11: invokevirtual 74	com/venticake/retrica/view/album/BaseCancelable:await	()V
    //   14: aload_0
    //   15: invokespecial 76	com/venticake/retrica/view/album/BaseCancelable:handleTerminalStates	()Ljava/lang/Object;
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: areturn
    //   23: aload_0
    //   24: iconst_2
    //   25: putfield 35	com/venticake/retrica/view/album/BaseCancelable:mState	I
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_0
    //   31: aload_0
    //   32: invokevirtual 78	com/venticake/retrica/view/album/BaseCancelable:execute	()Ljava/lang/Object;
    //   35: putfield 50	com/venticake/retrica/view/album/BaseCancelable:mResult	Ljava/lang/Object;
    //   38: aload_0
    //   39: monitorenter
    //   40: aload_0
    //   41: getfield 35	com/venticake/retrica/view/album/BaseCancelable:mState	I
    //   44: iconst_4
    //   45: if_icmpne +9 -> 54
    //   48: aload_0
    //   49: bipush 8
    //   51: putfield 35	com/venticake/retrica/view/album/BaseCancelable:mState	I
    //   54: aload_0
    //   55: getfield 35	com/venticake/retrica/view/album/BaseCancelable:mState	I
    //   58: iconst_2
    //   59: if_icmpne +9 -> 68
    //   62: aload_0
    //   63: bipush 32
    //   65: putfield 35	com/venticake/retrica/view/album/BaseCancelable:mState	I
    //   68: aload_0
    //   69: invokevirtual 81	java/lang/Object:notifyAll	()V
    //   72: aload_0
    //   73: getfield 35	com/venticake/retrica/view/album/BaseCancelable:mState	I
    //   76: bipush 8
    //   78: if_icmpne +18 -> 96
    //   81: aload_0
    //   82: getfield 50	com/venticake/retrica/view/album/BaseCancelable:mResult	Ljava/lang/Object;
    //   85: ifnull +11 -> 96
    //   88: aload_0
    //   89: aload_0
    //   90: getfield 50	com/venticake/retrica/view/album/BaseCancelable:mResult	Ljava/lang/Object;
    //   93: invokevirtual 83	com/venticake/retrica/view/album/BaseCancelable:freeCanceledResult	(Ljava/lang/Object;)V
    //   96: aload_0
    //   97: invokespecial 76	com/venticake/retrica/view/album/BaseCancelable:handleTerminalStates	()Ljava/lang/Object;
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: areturn
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    //   115: astore_1
    //   116: aload_0
    //   117: bipush 8
    //   119: putfield 35	com/venticake/retrica/view/album/BaseCancelable:mState	I
    //   122: goto -84 -> 38
    //   125: astore_1
    //   126: aload_0
    //   127: bipush 8
    //   129: putfield 35	com/venticake/retrica/view/album/BaseCancelable:mState	I
    //   132: goto -94 -> 38
    //   135: astore_1
    //   136: aload_0
    //   137: monitorenter
    //   138: aload_0
    //   139: getfield 35	com/venticake/retrica/view/album/BaseCancelable:mState	I
    //   142: iconst_4
    //   143: if_icmpeq +14 -> 157
    //   146: aload_0
    //   147: aload_1
    //   148: putfield 45	com/venticake/retrica/view/album/BaseCancelable:mError	Ljava/lang/Throwable;
    //   151: aload_0
    //   152: bipush 16
    //   154: putfield 35	com/venticake/retrica/view/album/BaseCancelable:mState	I
    //   157: aload_0
    //   158: monitorexit
    //   159: goto -121 -> 38
    //   162: astore_1
    //   163: aload_0
    //   164: monitorexit
    //   165: aload_1
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	BaseCancelable
    //   18	86	1	localObject1	Object
    //   105	4	1	localObject2	Object
    //   110	4	1	localObject3	Object
    //   115	1	1	localCancellationException	CancellationException
    //   125	1	1	localInterruptedException	InterruptedException
    //   135	13	1	localThrowable	Throwable
    //   162	4	1	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   40	54	105	finally
    //   54	68	105	finally
    //   68	96	105	finally
    //   96	103	105	finally
    //   106	108	105	finally
    //   2	21	110	finally
    //   23	30	110	finally
    //   111	113	110	finally
    //   30	38	115	java/util/concurrent/CancellationException
    //   30	38	125	java/lang/InterruptedException
    //   30	38	135	java/lang/Throwable
    //   138	157	162	finally
    //   157	159	162	finally
    //   163	165	162	finally
  }
  
  /* Error */
  public boolean requestCancel()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 35	com/venticake/retrica/view/album/BaseCancelable:mState	I
    //   8: iconst_1
    //   9: if_icmpne +17 -> 26
    //   12: aload_0
    //   13: bipush 8
    //   15: putfield 35	com/venticake/retrica/view/album/BaseCancelable:mState	I
    //   18: aload_0
    //   19: invokevirtual 81	java/lang/Object:notifyAll	()V
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_1
    //   25: ireturn
    //   26: aload_0
    //   27: getfield 35	com/venticake/retrica/view/album/BaseCancelable:mState	I
    //   30: iconst_2
    //   31: if_icmpne -9 -> 22
    //   34: aload_0
    //   35: getfield 87	com/venticake/retrica/view/album/BaseCancelable:mCurrentTask	Lcom/venticake/retrica/view/album/Cancelable;
    //   38: ifnull +13 -> 51
    //   41: aload_0
    //   42: getfield 87	com/venticake/retrica/view/album/BaseCancelable:mCurrentTask	Lcom/venticake/retrica/view/album/Cancelable;
    //   45: invokeinterface 89 1 0
    //   50: pop
    //   51: aload_0
    //   52: iconst_4
    //   53: putfield 35	com/venticake/retrica/view/album/BaseCancelable:mState	I
    //   56: iconst_1
    //   57: istore_1
    //   58: goto -36 -> 22
    //   61: astore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	BaseCancelable
    //   1	57	1	bool	boolean
    //   61	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	22	61	finally
    //   26	51	61	finally
    //   51	56	61	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/album/BaseCancelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */