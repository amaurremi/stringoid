package com.mobisystems.mobiscanner.controller;

import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicInteger;

public class p
  extends bb
{
  private long[] aAd;
  
  public p(Context paramContext, bc<Bundle> parambc, String paramString, Bundle paramBundle)
  {
    super(paramContext, parambc, paramString, paramBundle);
    this.aAd = paramBundle.getLongArray("DOCUMENTS");
  }
  
  /* Error */
  protected Bundle c(Void... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 29	com/mobisystems/mobiscanner/controller/p:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   8: ldc 31
    //   10: invokevirtual 37	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   13: new 39	com/mobisystems/mobiscanner/model/DocumentModel
    //   16: dup
    //   17: invokespecial 42	com/mobisystems/mobiscanner/model/DocumentModel:<init>	()V
    //   20: astore_1
    //   21: aload_0
    //   22: getstatic 48	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   25: putfield 51	com/mobisystems/mobiscanner/controller/p:aGa	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   28: aload_0
    //   29: getfield 20	com/mobisystems/mobiscanner/controller/p:aAd	[J
    //   32: astore 6
    //   34: aload 6
    //   36: arraylength
    //   37: istore_3
    //   38: iload_2
    //   39: iload_3
    //   40: if_icmpge +62 -> 102
    //   43: aload 6
    //   45: iload_2
    //   46: laload
    //   47: lstore 4
    //   49: aload_0
    //   50: getfield 55	com/mobisystems/mobiscanner/controller/p:aGc	Ljava/util/concurrent/atomic/AtomicInteger;
    //   53: invokevirtual 61	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   56: pop
    //   57: aload_0
    //   58: iconst_0
    //   59: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: invokevirtual 71	com/mobisystems/mobiscanner/controller/p:e	(Ljava/lang/Integer;)V
    //   65: aload_1
    //   66: lload 4
    //   68: invokevirtual 75	com/mobisystems/mobiscanner/model/DocumentModel:ag	(J)Z
    //   71: ifne +10 -> 81
    //   74: aload_0
    //   75: getstatic 78	com/mobisystems/mobiscanner/common/OperationStatus:avP	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   78: putfield 51	com/mobisystems/mobiscanner/controller/p:aGa	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   81: aload_0
    //   82: aload_0
    //   83: getfield 81	com/mobisystems/mobiscanner/controller/p:aGd	Ljava/util/concurrent/atomic/AtomicInteger;
    //   86: invokevirtual 84	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   89: invokestatic 67	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   92: invokevirtual 71	com/mobisystems/mobiscanner/controller/p:e	(Ljava/lang/Integer;)V
    //   95: aload_0
    //   96: invokevirtual 88	com/mobisystems/mobiscanner/controller/p:isCancelled	()Z
    //   99: ifeq +23 -> 122
    //   102: aload_0
    //   103: new 14	android/os/Bundle
    //   106: dup
    //   107: invokespecial 89	android/os/Bundle:<init>	()V
    //   110: putfield 93	com/mobisystems/mobiscanner/controller/p:aFZ	Landroid/os/Bundle;
    //   113: aload_0
    //   114: getfield 93	com/mobisystems/mobiscanner/controller/p:aFZ	Landroid/os/Bundle;
    //   117: astore_1
    //   118: aload_0
    //   119: monitorexit
    //   120: aload_1
    //   121: areturn
    //   122: iload_2
    //   123: iconst_1
    //   124: iadd
    //   125: istore_2
    //   126: goto -88 -> 38
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	p
    //   0	134	1	paramVarArgs	Void[]
    //   1	125	2	i	int
    //   37	4	3	j	int
    //   47	20	4	l	long
    //   32	12	6	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   4	38	129	finally
    //   49	81	129	finally
    //   81	102	129	finally
    //   102	118	129	finally
  }
  
  protected void onPreExecute()
  {
    this.aGb.set(this.aAd.length);
    super.onPreExecute();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */