package com.mobisystems.mobiscanner.controller;

import android.content.Context;
import android.os.Bundle;
import com.mobisystems.mobiscanner.model.c;
import java.util.concurrent.atomic.AtomicInteger;

public class ax
  extends bb
{
  private long aAa;
  private long[] aDR;
  private c aEr;
  
  public ax(Context paramContext, bc<Bundle> parambc, String paramString, Bundle paramBundle)
  {
    super(paramContext, parambc, paramString, paramBundle);
    this.aDR = paramBundle.getLongArray("PAGES");
    this.aEr = new c(paramBundle);
    this.aAa = paramBundle.getLong("OLD_DOC_ID");
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
    //   5: getfield 48	com/mobisystems/mobiscanner/controller/ax:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   8: ldc 50
    //   10: invokevirtual 56	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   13: new 58	com/mobisystems/mobiscanner/model/DocumentModel
    //   16: dup
    //   17: invokespecial 61	com/mobisystems/mobiscanner/model/DocumentModel:<init>	()V
    //   20: astore_1
    //   21: aload_0
    //   22: getstatic 67	com/mobisystems/mobiscanner/common/OperationStatus:avC	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   25: putfield 70	com/mobisystems/mobiscanner/controller/ax:aGa	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   28: aload_0
    //   29: getfield 24	com/mobisystems/mobiscanner/controller/ax:aDR	[J
    //   32: astore 6
    //   34: aload 6
    //   36: arraylength
    //   37: istore_3
    //   38: iload_2
    //   39: iload_3
    //   40: if_icmpge +66 -> 106
    //   43: aload 6
    //   45: iload_2
    //   46: laload
    //   47: lstore 4
    //   49: aload_0
    //   50: getfield 74	com/mobisystems/mobiscanner/controller/ax:aGc	Ljava/util/concurrent/atomic/AtomicInteger;
    //   53: invokevirtual 80	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   56: pop
    //   57: aload_0
    //   58: iconst_0
    //   59: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: invokevirtual 90	com/mobisystems/mobiscanner/controller/ax:e	(Ljava/lang/Integer;)V
    //   65: aload_1
    //   66: lload 4
    //   68: aload_0
    //   69: getfield 31	com/mobisystems/mobiscanner/controller/ax:aEr	Lcom/mobisystems/mobiscanner/model/c;
    //   72: invokevirtual 94	com/mobisystems/mobiscanner/model/DocumentModel:a	(JLcom/mobisystems/mobiscanner/model/c;)Z
    //   75: ifne +10 -> 85
    //   78: aload_0
    //   79: getstatic 97	com/mobisystems/mobiscanner/common/OperationStatus:avR	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   82: putfield 70	com/mobisystems/mobiscanner/controller/ax:aGa	Lcom/mobisystems/mobiscanner/common/OperationStatus;
    //   85: aload_0
    //   86: aload_0
    //   87: getfield 100	com/mobisystems/mobiscanner/controller/ax:aGd	Ljava/util/concurrent/atomic/AtomicInteger;
    //   90: invokevirtual 103	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   93: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   96: invokevirtual 90	com/mobisystems/mobiscanner/controller/ax:e	(Ljava/lang/Integer;)V
    //   99: aload_0
    //   100: invokevirtual 107	com/mobisystems/mobiscanner/controller/ax:isCancelled	()Z
    //   103: ifeq +33 -> 136
    //   106: aload_1
    //   107: aload_0
    //   108: getfield 39	com/mobisystems/mobiscanner/controller/ax:aAa	J
    //   111: invokevirtual 111	com/mobisystems/mobiscanner/model/DocumentModel:ae	(J)Lcom/mobisystems/mobiscanner/model/b;
    //   114: astore_1
    //   115: aload_1
    //   116: ifnull +11 -> 127
    //   119: aload_1
    //   120: aload_0
    //   121: getfield 115	com/mobisystems/mobiscanner/controller/ax:aFZ	Landroid/os/Bundle;
    //   124: invokevirtual 120	com/mobisystems/mobiscanner/model/b:p	(Landroid/os/Bundle;)V
    //   127: aload_0
    //   128: getfield 115	com/mobisystems/mobiscanner/controller/ax:aFZ	Landroid/os/Bundle;
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_1
    //   135: areturn
    //   136: iload_2
    //   137: iconst_1
    //   138: iadd
    //   139: istore_2
    //   140: goto -102 -> 38
    //   143: astore_1
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_1
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	ax
    //   0	148	1	paramVarArgs	Void[]
    //   1	139	2	i	int
    //   37	4	3	j	int
    //   47	20	4	l	long
    //   32	12	6	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   4	38	143	finally
    //   49	85	143	finally
    //   85	106	143	finally
    //   106	115	143	finally
    //   119	127	143	finally
    //   127	132	143	finally
  }
  
  protected void onPreExecute()
  {
    this.aGb.set(this.aDR.length);
    super.onPreExecute();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/controller/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */