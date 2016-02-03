package com.mobisystems.mobiscanner.controller;

import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicInteger;

public class ao
  extends bb
{
  private long aAa;
  private long[] aDR;
  
  public ao(Context paramContext, bc<Bundle> parambc, String paramString, Bundle paramBundle)
  {
    super(paramContext, parambc, paramString, paramBundle);
    this.aDR = paramBundle.getLongArray("PAGES");
    this.aAa = paramBundle.getLong("doc_id");
  }
  
  /* Error */
  protected Bundle c(Void... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/mobisystems/mobiscanner/controller/ao:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   6: ldc 41
    //   8: invokevirtual 47	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   11: new 49	com/mobisystems/mobiscanner/model/DocumentModel
    //   14: dup
    //   15: invokespecial 52	com/mobisystems/mobiscanner/model/DocumentModel:<init>	()V
    //   18: astore_1
    //   19: aload_0
    //   20: getstatic 58	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   23: putfield 61	com/mobisystems/mobiscanner/controller/ao:aGa	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   26: aload_0
    //   27: getfield 22	com/mobisystems/mobiscanner/controller/ao:aDR	[J
    //   30: astore 4
    //   32: aload 4
    //   34: arraylength
    //   35: istore_3
    //   36: iconst_0
    //   37: istore_2
    //   38: iload_2
    //   39: iload_3
    //   40: if_icmpge +44 -> 84
    //   43: aload_1
    //   44: aload 4
    //   46: iload_2
    //   47: laload
    //   48: invokevirtual 65	com/mobisystems/mobiscanner/model/DocumentModel:ak	(J)Z
    //   51: ifne +10 -> 61
    //   54: aload_0
    //   55: getstatic 68	com/mobisystems/mobiscanner/common/OperationStatus:avS	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   58: putfield 61	com/mobisystems/mobiscanner/controller/ao:aGa	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   61: aload_0
    //   62: aload_0
    //   63: getfield 72	com/mobisystems/mobiscanner/controller/ao:aGe	Ljava/util/concurrent/atomic/AtomicInteger;
    //   66: invokevirtual 78	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   69: iconst_1
    //   70: iadd
    //   71: invokestatic 84	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: invokevirtual 88	com/mobisystems/mobiscanner/controller/ao:e	(Ljava/lang/Integer;)V
    //   77: aload_0
    //   78: invokevirtual 92	com/mobisystems/mobiscanner/controller/ao:isCancelled	()Z
    //   81: ifeq +33 -> 114
    //   84: aload_1
    //   85: aload_0
    //   86: getfield 30	com/mobisystems/mobiscanner/controller/ao:aAa	J
    //   89: invokevirtual 96	com/mobisystems/mobiscanner/model/DocumentModel:ae	(J)Lcom/mobisystems/mobiscanner/model/b;
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull +11 -> 105
    //   97: aload_1
    //   98: aload_0
    //   99: getfield 100	com/mobisystems/mobiscanner/controller/ao:aFZ	Landroid/os/Bundle;
    //   102: invokevirtual 106	com/mobisystems/mobiscanner/model/b:p	(Landroid/os/Bundle;)V
    //   105: aload_0
    //   106: getfield 100	com/mobisystems/mobiscanner/controller/ao:aFZ	Landroid/os/Bundle;
    //   109: astore_1
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_1
    //   113: areturn
    //   114: iload_2
    //   115: iconst_1
    //   116: iadd
    //   117: istore_2
    //   118: goto -80 -> 38
    //   121: astore_1
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	ao
    //   0	126	1	paramVarArgs	Void[]
    //   37	81	2	i	int
    //   35	6	3	j	int
    //   30	15	4	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   2	36	121	finally
    //   43	61	121	finally
    //   61	84	121	finally
    //   84	93	121	finally
    //   97	105	121	finally
    //   105	110	121	finally
  }
  
  protected void onPreExecute()
  {
    this.aGd.set(this.aDR.length);
    super.onPreExecute();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */