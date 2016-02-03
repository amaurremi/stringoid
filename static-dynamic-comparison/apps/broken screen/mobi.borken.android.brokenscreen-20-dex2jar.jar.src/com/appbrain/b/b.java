package com.appbrain.b;

import java.io.InputStream;

public abstract class b
  implements o
{
  private static final f a = ;
  
  private static m a(m paramm)
  {
    if ((paramm != null) && (!paramm.e()))
    {
      if ((paramm instanceof a)) {}
      for (q localq = new q();; localq = new q()) {
        throw new i(localq.getMessage()).a(paramm);
      }
    }
    return paramm;
  }
  
  private m a(InputStream paramInputStream, f paramf)
  {
    paramInputStream = d.a(paramInputStream);
    paramf = (m)a(paramInputStream, paramf);
    try
    {
      paramInputStream.a(0);
      return paramf;
    }
    catch (i paramInputStream)
    {
      throw paramInputStream.a(paramf);
    }
  }
  
  /* Error */
  private m a(byte[] paramArrayOfByte, int paramInt, f paramf)
  {
    // Byte code:
    //   0: aload_1
    //   1: iload_2
    //   2: invokestatic 63	com/appbrain/b/d:a	([BI)Lcom/appbrain/b/d;
    //   5: astore_1
    //   6: aload_0
    //   7: aload_1
    //   8: aload_3
    //   9: invokevirtual 54	com/appbrain/b/b:a	(Lcom/appbrain/b/d;Lcom/appbrain/b/f;)Ljava/lang/Object;
    //   12: checkcast 24	com/appbrain/b/m
    //   15: astore_3
    //   16: aload_1
    //   17: iconst_0
    //   18: invokevirtual 57	com/appbrain/b/d:a	(I)V
    //   21: aload_3
    //   22: areturn
    //   23: astore_1
    //   24: aload_1
    //   25: aload_3
    //   26: invokevirtual 45	com/appbrain/b/i:a	(Lcom/appbrain/b/m;)Lcom/appbrain/b/i;
    //   29: athrow
    //   30: astore_1
    //   31: aload_1
    //   32: athrow
    //   33: astore_1
    //   34: new 65	java/lang/RuntimeException
    //   37: dup
    //   38: ldc 67
    //   40: aload_1
    //   41: invokespecial 70	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	b
    //   0	45	1	paramArrayOfByte	byte[]
    //   0	45	2	paramInt	int
    //   0	45	3	paramf	f
    // Exception table:
    //   from	to	target	type
    //   16	21	23	com/appbrain/b/i
    //   0	16	30	com/appbrain/b/i
    //   24	30	30	com/appbrain/b/i
    //   0	16	33	java/io/IOException
    //   16	21	33	java/io/IOException
    //   24	30	33	java/io/IOException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */