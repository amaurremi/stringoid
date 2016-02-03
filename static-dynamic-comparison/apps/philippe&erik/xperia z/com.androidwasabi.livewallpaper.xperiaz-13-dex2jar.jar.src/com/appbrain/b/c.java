package com.appbrain.b;

public abstract class c
  implements w
{
  private static final j a = ;
  
  /* Error */
  private t a(byte[] paramArrayOfByte, int paramInt, j paramj)
  {
    // Byte code:
    //   0: aload_1
    //   1: iload_2
    //   2: invokestatic 31	com/appbrain/b/g:a	([BI)Lcom/appbrain/b/g;
    //   5: astore_1
    //   6: aload_0
    //   7: aload_1
    //   8: aload_3
    //   9: invokevirtual 34	com/appbrain/b/c:a	(Lcom/appbrain/b/g;Lcom/appbrain/b/j;)Ljava/lang/Object;
    //   12: checkcast 36	com/appbrain/b/t
    //   15: astore_3
    //   16: aload_1
    //   17: iconst_0
    //   18: invokevirtual 39	com/appbrain/b/g:a	(I)V
    //   21: aload_3
    //   22: areturn
    //   23: astore_1
    //   24: aload_1
    //   25: aload_3
    //   26: invokevirtual 42	com/appbrain/b/o:a	(Lcom/appbrain/b/t;)Lcom/appbrain/b/o;
    //   29: athrow
    //   30: astore_1
    //   31: aload_1
    //   32: athrow
    //   33: astore_1
    //   34: new 44	java/lang/RuntimeException
    //   37: dup
    //   38: ldc 46
    //   40: aload_1
    //   41: invokespecial 49	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	c
    //   0	45	1	paramArrayOfByte	byte[]
    //   0	45	2	paramInt	int
    //   0	45	3	paramj	j
    // Exception table:
    //   from	to	target	type
    //   16	21	23	com/appbrain/b/o
    //   0	16	30	com/appbrain/b/o
    //   24	30	30	com/appbrain/b/o
    //   0	16	33	java/io/IOException
    //   16	21	33	java/io/IOException
    //   24	30	33	java/io/IOException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/appbrain/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */