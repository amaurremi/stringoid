package com.flurry.sdk;

import android.content.Context;
import java.io.File;
import java.util.UUID;

public class df
{
  private static final String d = df.class.getSimpleName();
  String a = null;
  long b = -1L;
  int c = -1;
  private File e = null;
  
  public df()
  {
    this.a = UUID.randomUUID().toString();
    this.e = do.a().b().getFileStreamPath(".flurrydatasenderblock." + this.a);
  }
  
  public df(String paramString)
  {
    this.a = paramString;
    this.e = do.a().b().getFileStreamPath(".flurrydatasenderblock." + this.a);
  }
  
  public String a()
  {
    return this.a;
  }
  
  /* Error */
  public boolean a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: invokestatic 80	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   8: invokestatic 83	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   11: if_acmpne +13 -> 24
    //   14: bipush 6
    //   16: getstatic 23	com/flurry/sdk/df:d	Ljava/lang/String;
    //   19: ldc 85
    //   21: invokestatic 90	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   24: iconst_4
    //   25: getstatic 23	com/flurry/sdk/df:d	Ljava/lang/String;
    //   28: new 56	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   35: ldc 92
    //   37: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: getfield 37	com/flurry/sdk/df:e	Ljava/io/File;
    //   44: invokevirtual 97	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   47: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 90	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   56: aload_0
    //   57: getfield 37	com/flurry/sdk/df:e	Ljava/io/File;
    //   60: invokestatic 102	com/flurry/sdk/fd:a	(Ljava/io/File;)Z
    //   63: istore 5
    //   65: iload 5
    //   67: ifne +9 -> 76
    //   70: aconst_null
    //   71: invokestatic 107	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
    //   74: iconst_0
    //   75: ireturn
    //   76: new 109	java/io/DataOutputStream
    //   79: dup
    //   80: new 111	java/io/FileOutputStream
    //   83: dup
    //   84: aload_0
    //   85: getfield 37	com/flurry/sdk/df:e	Ljava/io/File;
    //   88: invokespecial 114	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   91: invokespecial 117	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   94: astore 7
    //   96: aload 7
    //   98: astore 6
    //   100: iload 4
    //   102: istore_3
    //   103: aload_1
    //   104: arraylength
    //   105: istore_2
    //   106: aload 7
    //   108: astore 6
    //   110: iload 4
    //   112: istore_3
    //   113: aload 7
    //   115: iload_2
    //   116: invokevirtual 121	java/io/DataOutputStream:writeShort	(I)V
    //   119: aload 7
    //   121: astore 6
    //   123: iload 4
    //   125: istore_3
    //   126: aload 7
    //   128: aload_1
    //   129: invokevirtual 125	java/io/DataOutputStream:write	([B)V
    //   132: aload 7
    //   134: astore 6
    //   136: iload 4
    //   138: istore_3
    //   139: aload 7
    //   141: iconst_0
    //   142: invokevirtual 121	java/io/DataOutputStream:writeShort	(I)V
    //   145: iconst_1
    //   146: istore 4
    //   148: aload 7
    //   150: astore 6
    //   152: iload 4
    //   154: istore_3
    //   155: aload_0
    //   156: iload_2
    //   157: putfield 35	com/flurry/sdk/df:c	I
    //   160: aload 7
    //   162: astore 6
    //   164: iload 4
    //   166: istore_3
    //   167: aload_0
    //   168: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   171: putfield 33	com/flurry/sdk/df:b	J
    //   174: aload 7
    //   176: invokestatic 107	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
    //   179: iconst_1
    //   180: ireturn
    //   181: astore 8
    //   183: aconst_null
    //   184: astore_1
    //   185: aload_1
    //   186: astore 6
    //   188: bipush 6
    //   190: getstatic 23	com/flurry/sdk/df:d	Ljava/lang/String;
    //   193: ldc -123
    //   195: aload 8
    //   197: invokestatic 136	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   200: aload_1
    //   201: invokestatic 107	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
    //   204: iload_3
    //   205: ireturn
    //   206: astore_1
    //   207: aconst_null
    //   208: astore 6
    //   210: aload 6
    //   212: invokestatic 107	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
    //   215: aload_1
    //   216: athrow
    //   217: astore_1
    //   218: goto -8 -> 210
    //   221: astore 8
    //   223: aload 7
    //   225: astore_1
    //   226: goto -41 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	df
    //   0	229	1	paramArrayOfByte	byte[]
    //   105	52	2	i	int
    //   4	201	3	bool1	boolean
    //   1	164	4	bool2	boolean
    //   63	3	5	bool3	boolean
    //   98	113	6	localObject	Object
    //   94	130	7	localDataOutputStream	java.io.DataOutputStream
    //   181	15	8	localThrowable1	Throwable
    //   221	1	8	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   56	65	181	java/lang/Throwable
    //   76	96	181	java/lang/Throwable
    //   56	65	206	finally
    //   76	96	206	finally
    //   103	106	217	finally
    //   113	119	217	finally
    //   126	132	217	finally
    //   139	145	217	finally
    //   155	160	217	finally
    //   167	174	217	finally
    //   188	200	217	finally
    //   103	106	221	java/lang/Throwable
    //   113	119	221	java/lang/Throwable
    //   126	132	221	java/lang/Throwable
    //   139	145	221	java/lang/Throwable
    //   155	160	221	java/lang/Throwable
    //   167	174	221	java/lang/Throwable
  }
  
  /* Error */
  public byte[] b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: invokestatic 80	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   9: invokestatic 83	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   12: if_acmpne +13 -> 25
    //   15: bipush 6
    //   17: getstatic 23	com/flurry/sdk/df:d	Ljava/lang/String;
    //   20: ldc -117
    //   22: invokestatic 90	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 37	com/flurry/sdk/df:e	Ljava/io/File;
    //   29: invokevirtual 143	java/io/File:exists	()Z
    //   32: ifeq +164 -> 196
    //   35: iconst_4
    //   36: getstatic 23	com/flurry/sdk/df:d	Ljava/lang/String;
    //   39: new 56	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   46: ldc -111
    //   48: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_0
    //   52: getfield 37	com/flurry/sdk/df:e	Ljava/io/File;
    //   55: invokevirtual 97	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   58: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 90	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   67: new 147	java/io/DataInputStream
    //   70: dup
    //   71: new 149	java/io/FileInputStream
    //   74: dup
    //   75: aload_0
    //   76: getfield 37	com/flurry/sdk/df:e	Ljava/io/File;
    //   79: invokespecial 150	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   82: invokespecial 153	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   85: astore 4
    //   87: aload 4
    //   89: astore_2
    //   90: aload 6
    //   92: astore_3
    //   93: aload 4
    //   95: invokevirtual 157	java/io/DataInputStream:readUnsignedShort	()I
    //   98: istore_1
    //   99: iload_1
    //   100: ifne +10 -> 110
    //   103: aload 4
    //   105: invokestatic 107	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
    //   108: aconst_null
    //   109: areturn
    //   110: aload 4
    //   112: astore_2
    //   113: aload 6
    //   115: astore_3
    //   116: iload_1
    //   117: newarray <illegal type>
    //   119: astore 5
    //   121: aload 4
    //   123: astore_2
    //   124: aload 5
    //   126: astore_3
    //   127: aload 4
    //   129: aload 5
    //   131: invokevirtual 160	java/io/DataInputStream:readFully	([B)V
    //   134: aload 4
    //   136: astore_2
    //   137: aload 5
    //   139: astore_3
    //   140: aload 4
    //   142: invokevirtual 157	java/io/DataInputStream:readUnsignedShort	()I
    //   145: istore_1
    //   146: iload_1
    //   147: ifne +3 -> 150
    //   150: aload 4
    //   152: invokestatic 107	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
    //   155: aload 5
    //   157: areturn
    //   158: astore 6
    //   160: aconst_null
    //   161: astore_3
    //   162: aload_3
    //   163: astore_2
    //   164: bipush 6
    //   166: getstatic 23	com/flurry/sdk/df:d	Ljava/lang/String;
    //   169: ldc -94
    //   171: aload 6
    //   173: invokestatic 136	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   176: aload_3
    //   177: invokestatic 107	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
    //   180: aload 5
    //   182: areturn
    //   183: astore_2
    //   184: aconst_null
    //   185: astore 4
    //   187: aload_2
    //   188: astore_3
    //   189: aload 4
    //   191: invokestatic 107	com/flurry/sdk/fe:a	(Ljava/io/Closeable;)V
    //   194: aload_3
    //   195: athrow
    //   196: iconst_4
    //   197: getstatic 23	com/flurry/sdk/df:d	Ljava/lang/String;
    //   200: ldc -92
    //   202: invokestatic 90	com/flurry/sdk/eo:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   205: aconst_null
    //   206: areturn
    //   207: astore_3
    //   208: aload_2
    //   209: astore 4
    //   211: goto -22 -> 189
    //   214: astore 6
    //   216: aload_3
    //   217: astore 5
    //   219: aload 4
    //   221: astore_3
    //   222: goto -60 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	df
    //   98	49	1	i	int
    //   89	75	2	localObject1	Object
    //   183	26	2	localObject2	Object
    //   92	103	3	localObject3	Object
    //   207	10	3	localObject4	Object
    //   221	1	3	localObject5	Object
    //   85	135	4	localObject6	Object
    //   4	214	5	localObject7	Object
    //   1	113	6	localObject8	Object
    //   158	14	6	localThrowable1	Throwable
    //   214	1	6	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   67	87	158	java/lang/Throwable
    //   67	87	183	finally
    //   93	99	207	finally
    //   116	121	207	finally
    //   127	134	207	finally
    //   140	146	207	finally
    //   164	176	207	finally
    //   93	99	214	java/lang/Throwable
    //   116	121	214	java/lang/Throwable
    //   127	134	214	java/lang/Throwable
    //   140	146	214	java/lang/Throwable
  }
  
  public boolean c()
  {
    if (this.e.exists())
    {
      if (this.e.delete())
      {
        eo.a(4, d, "Deleted persistence file");
        this.b = -1L;
        this.c = -1;
        return true;
      }
      eo.a(6, d, "Cannot delete persistence file");
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/flurry/sdk/df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */