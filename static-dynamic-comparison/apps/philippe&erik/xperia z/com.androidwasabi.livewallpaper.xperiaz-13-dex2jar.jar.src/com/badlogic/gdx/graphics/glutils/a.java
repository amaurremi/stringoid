package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.g;
import com.badlogic.gdx.math.b;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.d;
import java.nio.ByteBuffer;

public final class a
  implements d
{
  public final int a;
  public final int b;
  public final ByteBuffer c;
  public final int d;
  
  /* Error */
  public a(com.badlogic.gdx.c.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 19	java/lang/Object:<init>	()V
    //   4: sipush 10240
    //   7: newarray <illegal type>
    //   9: astore 5
    //   11: new 21	java/io/DataInputStream
    //   14: dup
    //   15: new 23	java/io/BufferedInputStream
    //   18: dup
    //   19: new 25	java/util/zip/GZIPInputStream
    //   22: dup
    //   23: aload_1
    //   24: invokevirtual 30	com/badlogic/gdx/c/a:a	()Ljava/io/InputStream;
    //   27: invokespecial 33	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   30: invokespecial 34	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   33: invokespecial 35	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: astore 4
    //   38: aload 4
    //   40: astore_3
    //   41: aload_0
    //   42: aload 4
    //   44: invokevirtual 39	java/io/DataInputStream:readInt	()I
    //   47: invokestatic 44	com/badlogic/gdx/utils/BufferUtils:d	(I)Ljava/nio/ByteBuffer;
    //   50: putfield 46	com/badlogic/gdx/graphics/glutils/a:c	Ljava/nio/ByteBuffer;
    //   53: aload 4
    //   55: astore_3
    //   56: aload 4
    //   58: aload 5
    //   60: invokevirtual 50	java/io/DataInputStream:read	([B)I
    //   63: istore_2
    //   64: iload_2
    //   65: iconst_m1
    //   66: if_icmpeq +71 -> 137
    //   69: aload 4
    //   71: astore_3
    //   72: aload_0
    //   73: getfield 46	com/badlogic/gdx/graphics/glutils/a:c	Ljava/nio/ByteBuffer;
    //   76: aload 5
    //   78: iconst_0
    //   79: iload_2
    //   80: invokevirtual 56	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   83: pop
    //   84: goto -31 -> 53
    //   87: astore 5
    //   89: aload 4
    //   91: astore_3
    //   92: aload 5
    //   94: astore 4
    //   96: new 58	com/badlogic/gdx/utils/f
    //   99: dup
    //   100: new 60	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   107: ldc 63
    //   109: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_1
    //   113: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   116: ldc 72
    //   118: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: aload 4
    //   126: invokespecial 79	com/badlogic/gdx/utils/f:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: athrow
    //   130: astore_1
    //   131: aload_3
    //   132: invokestatic 84	com/badlogic/gdx/utils/s:a	(Ljava/io/Closeable;)V
    //   135: aload_1
    //   136: athrow
    //   137: aload 4
    //   139: astore_3
    //   140: aload_0
    //   141: getfield 46	com/badlogic/gdx/graphics/glutils/a:c	Ljava/nio/ByteBuffer;
    //   144: iconst_0
    //   145: invokevirtual 88	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   148: pop
    //   149: aload 4
    //   151: astore_3
    //   152: aload_0
    //   153: getfield 46	com/badlogic/gdx/graphics/glutils/a:c	Ljava/nio/ByteBuffer;
    //   156: aload_0
    //   157: getfield 46	com/badlogic/gdx/graphics/glutils/a:c	Ljava/nio/ByteBuffer;
    //   160: invokevirtual 91	java/nio/ByteBuffer:capacity	()I
    //   163: invokevirtual 94	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   166: pop
    //   167: aload 4
    //   169: invokestatic 84	com/badlogic/gdx/utils/s:a	(Ljava/io/Closeable;)V
    //   172: aload_0
    //   173: aload_0
    //   174: getfield 46	com/badlogic/gdx/graphics/glutils/a:c	Ljava/nio/ByteBuffer;
    //   177: iconst_0
    //   178: invokestatic 100	com/badlogic/gdx/graphics/glutils/ETC1:getWidthPKM	(Ljava/nio/ByteBuffer;I)I
    //   181: putfield 102	com/badlogic/gdx/graphics/glutils/a:a	I
    //   184: aload_0
    //   185: aload_0
    //   186: getfield 46	com/badlogic/gdx/graphics/glutils/a:c	Ljava/nio/ByteBuffer;
    //   189: iconst_0
    //   190: invokestatic 105	com/badlogic/gdx/graphics/glutils/ETC1:getHeightPKM	(Ljava/nio/ByteBuffer;I)I
    //   193: putfield 107	com/badlogic/gdx/graphics/glutils/a:b	I
    //   196: aload_0
    //   197: getstatic 108	com/badlogic/gdx/graphics/glutils/ETC1:a	I
    //   200: putfield 110	com/badlogic/gdx/graphics/glutils/a:d	I
    //   203: aload_0
    //   204: getfield 46	com/badlogic/gdx/graphics/glutils/a:c	Ljava/nio/ByteBuffer;
    //   207: aload_0
    //   208: getfield 110	com/badlogic/gdx/graphics/glutils/a:d	I
    //   211: invokevirtual 88	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   214: pop
    //   215: aload_0
    //   216: invokespecial 112	com/badlogic/gdx/graphics/glutils/a:b	()V
    //   219: return
    //   220: astore_1
    //   221: aconst_null
    //   222: astore_3
    //   223: goto -92 -> 131
    //   226: astore 4
    //   228: aconst_null
    //   229: astore_3
    //   230: goto -134 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	a
    //   0	233	1	parama	com.badlogic.gdx.c.a
    //   63	17	2	i	int
    //   40	190	3	localObject1	Object
    //   36	132	4	localObject2	Object
    //   226	1	4	localException1	Exception
    //   9	68	5	arrayOfByte	byte[]
    //   87	6	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   41	53	87	java/lang/Exception
    //   56	64	87	java/lang/Exception
    //   72	84	87	java/lang/Exception
    //   140	149	87	java/lang/Exception
    //   152	167	87	java/lang/Exception
    //   41	53	130	finally
    //   56	64	130	finally
    //   72	84	130	finally
    //   96	130	130	finally
    //   140	149	130	finally
    //   152	167	130	finally
    //   11	38	220	finally
    //   11	38	226	java/lang/Exception
  }
  
  private void b()
  {
    if ((!b.c(this.a)) || (!b.c(this.b))) {
      g.a.b("ETC1Data", "warning: non-power-of-two ETC1 textures may crash the driver of PowerVR GPUs");
    }
  }
  
  public boolean a()
  {
    return this.d == 16;
  }
  
  public void c()
  {
    BufferUtils.a(this.c);
  }
  
  public String toString()
  {
    if (a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (ETC1.isValidPKM(this.c, 0)) {}
      for (String str = "valid";; str = "invalid") {
        return str + " pkm [" + ETC1.getWidthPKM(this.c, 0) + "x" + ETC1.getHeightPKM(this.c, 0) + "], compressed: " + (this.c.capacity() - ETC1.a);
      }
    }
    return "raw [" + this.a + "x" + this.b + "], compressed: " + (this.c.capacity() - ETC1.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/graphics/glutils/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */