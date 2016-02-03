package com.android.a.a;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class b
{
  protected static final Comparator a = new c();
  private List b = new LinkedList();
  private List c = new ArrayList(64);
  private int d = 0;
  private final int e;
  
  public b(int paramInt)
  {
    this.e = paramInt;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/android/a/a/b:d	I
    //   6: istore_1
    //   7: aload_0
    //   8: getfield 39	com/android/a/a/b:e	I
    //   11: istore_2
    //   12: iload_1
    //   13: iload_2
    //   14: if_icmpgt +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 29	com/android/a/a/b:b	Ljava/util/List;
    //   24: iconst_0
    //   25: invokeinterface 45 2 0
    //   30: checkcast 47	[B
    //   33: astore_3
    //   34: aload_0
    //   35: getfield 35	com/android/a/a/b:c	Ljava/util/List;
    //   38: aload_3
    //   39: invokeinterface 50 2 0
    //   44: pop
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 37	com/android/a/a/b:d	I
    //   50: aload_3
    //   51: arraylength
    //   52: isub
    //   53: putfield 37	com/android/a/a/b:d	I
    //   56: goto -54 -> 2
    //   59: astore_3
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_3
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	b
    //   6	9	1	i	int
    //   11	4	2	j	int
    //   33	18	3	arrayOfByte	byte[]
    //   59	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	59	finally
    //   20	56	59	finally
  }
  
  /* Error */
  public void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +16 -> 19
    //   6: aload_1
    //   7: arraylength
    //   8: istore_2
    //   9: aload_0
    //   10: getfield 39	com/android/a/a/b:e	I
    //   13: istore_3
    //   14: iload_2
    //   15: iload_3
    //   16: if_icmple +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 29	com/android/a/a/b:b	Ljava/util/List;
    //   26: aload_1
    //   27: invokeinterface 54 2 0
    //   32: pop
    //   33: aload_0
    //   34: getfield 35	com/android/a/a/b:c	Ljava/util/List;
    //   37: aload_1
    //   38: getstatic 21	com/android/a/a/b:a	Ljava/util/Comparator;
    //   41: invokestatic 60	java/util/Collections:binarySearch	(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;)I
    //   44: istore_3
    //   45: iload_3
    //   46: istore_2
    //   47: iload_3
    //   48: ifge +8 -> 56
    //   51: iload_3
    //   52: ineg
    //   53: iconst_1
    //   54: isub
    //   55: istore_2
    //   56: aload_0
    //   57: getfield 35	com/android/a/a/b:c	Ljava/util/List;
    //   60: iload_2
    //   61: aload_1
    //   62: invokeinterface 63 3 0
    //   67: aload_0
    //   68: aload_0
    //   69: getfield 37	com/android/a/a/b:d	I
    //   72: aload_1
    //   73: arraylength
    //   74: iadd
    //   75: putfield 37	com/android/a/a/b:d	I
    //   78: aload_0
    //   79: invokespecial 65	com/android/a/a/b:a	()V
    //   82: goto -63 -> 19
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	b
    //   0	90	1	paramArrayOfByte	byte[]
    //   8	53	2	i	int
    //   13	39	3	j	int
    // Exception table:
    //   from	to	target	type
    //   6	14	85	finally
    //   22	45	85	finally
    //   56	82	85	finally
  }
  
  public byte[] a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.c.size())
        {
          arrayOfByte = new byte[paramInt];
          return arrayOfByte;
        }
        byte[] arrayOfByte = (byte[])this.c.get(i);
        if (arrayOfByte.length >= paramInt)
        {
          this.d -= arrayOfByte.length;
          this.c.remove(i);
          this.b.remove(arrayOfByte);
        }
        else
        {
          i += 1;
        }
      }
      finally {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/android/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */