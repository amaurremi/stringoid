package com.chartboost.sdk.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class aj
  extends OutputStream
{
  private static final byte[] a = new byte[0];
  private final List<byte[]> b = new ArrayList();
  private int c;
  private int d;
  private byte[] e;
  private int f;
  
  public aj()
  {
    this(1024);
  }
  
  public aj(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Negative initial size: " + paramInt);
    }
    try
    {
      a(paramInt);
      return;
    }
    finally {}
  }
  
  private void a(int paramInt)
  {
    if (this.c < this.b.size() - 1)
    {
      this.d += this.e.length;
      this.c += 1;
      this.e = ((byte[])this.b.get(this.c));
      return;
    }
    if (this.e == null) {}
    for (this.d = 0;; this.d += this.e.length)
    {
      this.c += 1;
      this.e = new byte[paramInt];
      this.b.add(this.e);
      return;
      paramInt = Math.max(this.e.length << 1, paramInt - this.d);
    }
  }
  
  /* Error */
  public byte[] a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 83	com/chartboost/sdk/impl/aj:f	I
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +13 -> 21
    //   11: getstatic 18	com/chartboost/sdk/impl/aj:a	[B
    //   14: astore 4
    //   16: aload_0
    //   17: monitorexit
    //   18: aload 4
    //   20: areturn
    //   21: iload_2
    //   22: newarray <illegal type>
    //   24: astore 4
    //   26: aload_0
    //   27: getfield 30	com/chartboost/sdk/impl/aj:b	Ljava/util/List;
    //   30: invokeinterface 87 1 0
    //   35: astore 5
    //   37: iconst_0
    //   38: istore_1
    //   39: aload 5
    //   41: invokeinterface 93 1 0
    //   46: ifeq +41 -> 87
    //   49: aload 5
    //   51: invokeinterface 97 1 0
    //   56: checkcast 70	[B
    //   59: astore 6
    //   61: aload 6
    //   63: arraylength
    //   64: iload_2
    //   65: invokestatic 100	java/lang/Math:min	(II)I
    //   68: istore_3
    //   69: aload 6
    //   71: iconst_0
    //   72: aload 4
    //   74: iload_1
    //   75: iload_3
    //   76: invokestatic 106	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   79: iload_2
    //   80: iload_3
    //   81: isub
    //   82: istore_2
    //   83: iload_2
    //   84: ifne +6 -> 90
    //   87: goto -71 -> 16
    //   90: iload_1
    //   91: iload_3
    //   92: iadd
    //   93: istore_1
    //   94: goto -55 -> 39
    //   97: astore 4
    //   99: aload_0
    //   100: monitorexit
    //   101: aload 4
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	aj
    //   38	56	1	i	int
    //   6	78	2	j	int
    //   68	25	3	k	int
    //   14	59	4	arrayOfByte1	byte[]
    //   97	5	4	localObject	Object
    //   35	15	5	localIterator	java.util.Iterator
    //   59	11	6	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   2	7	97	finally
    //   11	16	97	finally
    //   21	37	97	finally
    //   39	79	97	finally
  }
  
  public void close()
    throws IOException
  {}
  
  public String toString()
  {
    return new String(a());
  }
  
  public void write(int paramInt)
  {
    try
    {
      int j = this.f - this.d;
      int i = j;
      if (j == this.e.length)
      {
        a(this.f + 1);
        i = 0;
      }
      this.e[i] = ((byte)paramInt);
      this.f += 1;
      return;
    }
    finally {}
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > paramArrayOfByte.length) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length) || (paramInt1 + paramInt2 < 0)) {
      throw new IndexOutOfBoundsException();
    }
    if (paramInt2 == 0) {
      return;
    }
    try
    {
      int m = this.f + paramInt2;
      int j = this.f - this.d;
      int i = paramInt2;
      while (i > 0)
      {
        int k = Math.min(i, this.e.length - j);
        System.arraycopy(paramArrayOfByte, paramInt1 + paramInt2 - i, this.e, j, k);
        k = i - k;
        i = k;
        if (k > 0)
        {
          a(m);
          j = 0;
          i = k;
        }
      }
      this.f = m;
      return;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */