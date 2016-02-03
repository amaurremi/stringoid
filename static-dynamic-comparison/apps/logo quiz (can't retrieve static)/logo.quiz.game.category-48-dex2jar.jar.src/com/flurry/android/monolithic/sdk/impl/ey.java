package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.os.Looper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class ey
{
  static final Integer a = Integer.valueOf(50);
  private static final String c = ey.class.getSimpleName();
  LinkedHashMap<String, List<String>> b;
  
  public ey()
  {
    a();
  }
  
  /* Error */
  private boolean a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_3
    //   4: iload_3
    //   5: istore_2
    //   6: aload_1
    //   7: ifnull +59 -> 66
    //   10: iload_3
    //   11: istore_2
    //   12: aload_1
    //   13: invokevirtual 42	java/io/File:exists	()Z
    //   16: ifeq +50 -> 66
    //   19: iconst_4
    //   20: getstatic 21	com/flurry/android/monolithic/sdk/impl/ey:c	Ljava/lang/String;
    //   23: new 44	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   30: ldc 47
    //   32: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 54	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   39: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 62	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   48: aload_1
    //   49: invokevirtual 65	java/io/File:delete	()Z
    //   52: istore_2
    //   53: iload_2
    //   54: ifeq +16 -> 70
    //   57: iconst_4
    //   58: getstatic 21	com/flurry/android/monolithic/sdk/impl/ey:c	Ljava/lang/String;
    //   61: ldc 67
    //   63: invokestatic 62	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   66: aload_0
    //   67: monitorexit
    //   68: iload_2
    //   69: ireturn
    //   70: bipush 6
    //   72: getstatic 21	com/flurry/android/monolithic/sdk/impl/ey:c	Ljava/lang/String;
    //   75: ldc 69
    //   77: invokestatic 62	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   80: goto -14 -> 66
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	ey
    //   0	88	1	paramFile	File
    //   5	64	2	bool1	boolean
    //   3	8	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   12	53	83	finally
    //   57	66	83	finally
    //   70	80	83	finally
  }
  
  /* Error */
  private boolean a(String paramString, List<String> paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: invokestatic 78	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   8: invokestatic 81	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   11: if_acmpne +13 -> 24
    //   14: bipush 6
    //   16: getstatic 21	com/flurry/android/monolithic/sdk/impl/ey:c	Ljava/lang/String;
    //   19: ldc 83
    //   21: invokestatic 62	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   24: invokestatic 88	com/flurry/android/monolithic/sdk/impl/ia:a	()Lcom/flurry/android/monolithic/sdk/impl/ia;
    //   27: invokevirtual 91	com/flurry/android/monolithic/sdk/impl/ia:b	()Landroid/content/Context;
    //   30: new 44	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   37: ldc 93
    //   39: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokevirtual 99	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   52: astore_1
    //   53: aload_1
    //   54: invokestatic 103	com/flurry/android/monolithic/sdk/impl/iw:a	(Ljava/io/File;)Z
    //   57: istore 6
    //   59: iload 6
    //   61: ifne +12 -> 73
    //   64: aconst_null
    //   65: invokestatic 108	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   68: aload_0
    //   69: monitorexit
    //   70: iload 5
    //   72: ireturn
    //   73: new 110	java/io/DataOutputStream
    //   76: dup
    //   77: new 112	java/io/FileOutputStream
    //   80: dup
    //   81: aload_1
    //   82: invokespecial 115	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   85: invokespecial 118	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   88: astore 7
    //   90: aload 7
    //   92: astore_1
    //   93: aload 7
    //   95: aload_2
    //   96: invokeinterface 124 1 0
    //   101: invokevirtual 128	java/io/DataOutputStream:writeShort	(I)V
    //   104: iconst_0
    //   105: istore_3
    //   106: aload 7
    //   108: astore_1
    //   109: iload_3
    //   110: aload_2
    //   111: invokeinterface 124 1 0
    //   116: if_icmpge +95 -> 211
    //   119: aload 7
    //   121: astore_1
    //   122: aload_2
    //   123: iload_3
    //   124: invokeinterface 132 2 0
    //   129: checkcast 134	java/lang/String
    //   132: invokevirtual 138	java/lang/String:getBytes	()[B
    //   135: astore 8
    //   137: aload 7
    //   139: astore_1
    //   140: aload 8
    //   142: arraylength
    //   143: istore 4
    //   145: aload 7
    //   147: astore_1
    //   148: iconst_4
    //   149: getstatic 21	com/flurry/android/monolithic/sdk/impl/ey:c	Ljava/lang/String;
    //   152: new 44	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   159: ldc -116
    //   161: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: iload_3
    //   165: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   168: ldc -111
    //   170: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: iload 4
    //   175: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   178: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 62	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   184: aload 7
    //   186: astore_1
    //   187: aload 7
    //   189: iload 4
    //   191: invokevirtual 128	java/io/DataOutputStream:writeShort	(I)V
    //   194: aload 7
    //   196: astore_1
    //   197: aload 7
    //   199: aload 8
    //   201: invokevirtual 149	java/io/DataOutputStream:write	([B)V
    //   204: iload_3
    //   205: iconst_1
    //   206: iadd
    //   207: istore_3
    //   208: goto -102 -> 106
    //   211: aload 7
    //   213: astore_1
    //   214: aload 7
    //   216: iconst_0
    //   217: invokevirtual 128	java/io/DataOutputStream:writeShort	(I)V
    //   220: iconst_1
    //   221: istore 5
    //   223: aload 7
    //   225: invokestatic 108	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   228: goto -160 -> 68
    //   231: astore 8
    //   233: aconst_null
    //   234: astore_2
    //   235: aload_2
    //   236: astore_1
    //   237: bipush 6
    //   239: getstatic 21	com/flurry/android/monolithic/sdk/impl/ey:c	Ljava/lang/String;
    //   242: ldc -105
    //   244: aload 8
    //   246: invokestatic 154	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   249: aload_2
    //   250: invokestatic 108	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   253: iconst_0
    //   254: istore 5
    //   256: goto -28 -> 228
    //   259: aload_1
    //   260: invokestatic 108	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   263: aload_2
    //   264: athrow
    //   265: astore_1
    //   266: aload_0
    //   267: monitorexit
    //   268: aload_1
    //   269: athrow
    //   270: astore_2
    //   271: goto -12 -> 259
    //   274: astore 8
    //   276: aload 7
    //   278: astore_2
    //   279: goto -44 -> 235
    //   282: astore_2
    //   283: aconst_null
    //   284: astore_1
    //   285: goto -26 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	ey
    //   0	288	1	paramString	String
    //   0	288	2	paramList	List<String>
    //   105	103	3	i	int
    //   143	47	4	j	int
    //   1	254	5	bool1	boolean
    //   57	3	6	bool2	boolean
    //   88	189	7	localDataOutputStream	java.io.DataOutputStream
    //   135	65	8	arrayOfByte	byte[]
    //   231	14	8	localThrowable1	Throwable
    //   274	1	8	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   53	59	231	java/lang/Throwable
    //   73	90	231	java/lang/Throwable
    //   5	24	265	finally
    //   24	53	265	finally
    //   64	68	265	finally
    //   223	228	265	finally
    //   249	253	265	finally
    //   259	265	265	finally
    //   93	104	270	finally
    //   109	119	270	finally
    //   122	137	270	finally
    //   140	145	270	finally
    //   148	184	270	finally
    //   187	194	270	finally
    //   197	204	270	finally
    //   214	220	270	finally
    //   237	249	270	finally
    //   93	104	274	java/lang/Throwable
    //   109	119	274	java/lang/Throwable
    //   122	137	274	java/lang/Throwable
    //   140	145	274	java/lang/Throwable
    //   148	184	274	java/lang/Throwable
    //   187	194	274	java/lang/Throwable
    //   197	204	274	java/lang/Throwable
    //   214	220	274	java/lang/Throwable
    //   53	59	282	finally
    //   73	90	282	finally
  }
  
  /* Error */
  private List<String> d(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: monitorenter
    //   5: invokestatic 78	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   8: invokestatic 81	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   11: if_acmpne +13 -> 24
    //   14: bipush 6
    //   16: getstatic 21	com/flurry/android/monolithic/sdk/impl/ey:c	Ljava/lang/String;
    //   19: ldc -96
    //   21: invokestatic 62	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   24: invokestatic 88	com/flurry/android/monolithic/sdk/impl/ia:a	()Lcom/flurry/android/monolithic/sdk/impl/ia;
    //   27: invokevirtual 91	com/flurry/android/monolithic/sdk/impl/ia:b	()Landroid/content/Context;
    //   30: new 44	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   37: ldc 93
    //   39: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_1
    //   43: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokevirtual 99	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   52: astore_1
    //   53: aload_1
    //   54: invokevirtual 42	java/io/File:exists	()Z
    //   57: istore 5
    //   59: iload 5
    //   61: ifeq +234 -> 295
    //   64: new 162	java/io/DataInputStream
    //   67: dup
    //   68: new 164	java/io/FileInputStream
    //   71: dup
    //   72: aload_1
    //   73: invokespecial 165	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   76: invokespecial 168	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   79: astore 8
    //   81: aload 8
    //   83: astore 6
    //   85: aload 8
    //   87: invokevirtual 171	java/io/DataInputStream:readUnsignedShort	()I
    //   90: istore_3
    //   91: iload_3
    //   92: ifne +15 -> 107
    //   95: aload 8
    //   97: invokestatic 108	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   100: aload 7
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: areturn
    //   107: aload 8
    //   109: astore 6
    //   111: new 173	java/util/ArrayList
    //   114: dup
    //   115: iload_3
    //   116: invokespecial 175	java/util/ArrayList:<init>	(I)V
    //   119: astore_1
    //   120: iconst_0
    //   121: istore_2
    //   122: iload_2
    //   123: iload_3
    //   124: if_icmpge +102 -> 226
    //   127: aload 8
    //   129: astore 6
    //   131: aload 8
    //   133: invokevirtual 171	java/io/DataInputStream:readUnsignedShort	()I
    //   136: istore 4
    //   138: aload 8
    //   140: astore 6
    //   142: iconst_4
    //   143: getstatic 21	com/flurry/android/monolithic/sdk/impl/ey:c	Ljava/lang/String;
    //   146: new 44	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   153: ldc -79
    //   155: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: iload_2
    //   159: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   162: ldc -111
    //   164: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: iload 4
    //   169: invokevirtual 143	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 62	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   178: aload 8
    //   180: astore 6
    //   182: iload 4
    //   184: newarray <illegal type>
    //   186: astore 7
    //   188: aload 8
    //   190: astore 6
    //   192: aload 8
    //   194: aload 7
    //   196: invokevirtual 180	java/io/DataInputStream:readFully	([B)V
    //   199: aload 8
    //   201: astore 6
    //   203: aload_1
    //   204: new 134	java/lang/String
    //   207: dup
    //   208: aload 7
    //   210: invokespecial 182	java/lang/String:<init>	([B)V
    //   213: invokeinterface 186 2 0
    //   218: pop
    //   219: iload_2
    //   220: iconst_1
    //   221: iadd
    //   222: istore_2
    //   223: goto -101 -> 122
    //   226: aload 8
    //   228: astore 6
    //   230: aload 8
    //   232: invokevirtual 171	java/io/DataInputStream:readUnsignedShort	()I
    //   235: istore_2
    //   236: iload_2
    //   237: ifne +3 -> 240
    //   240: aload 8
    //   242: invokestatic 108	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   245: goto -142 -> 103
    //   248: astore 7
    //   250: aconst_null
    //   251: astore 8
    //   253: aconst_null
    //   254: astore_1
    //   255: aload 8
    //   257: astore 6
    //   259: bipush 6
    //   261: getstatic 21	com/flurry/android/monolithic/sdk/impl/ey:c	Ljava/lang/String;
    //   264: ldc -68
    //   266: aload 7
    //   268: invokestatic 154	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   271: aload 8
    //   273: invokestatic 108	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   276: goto -31 -> 245
    //   279: astore_1
    //   280: aload_0
    //   281: monitorexit
    //   282: aload_1
    //   283: athrow
    //   284: astore_1
    //   285: aconst_null
    //   286: astore 6
    //   288: aload 6
    //   290: invokestatic 108	com/flurry/android/monolithic/sdk/impl/je:a	(Ljava/io/Closeable;)V
    //   293: aload_1
    //   294: athrow
    //   295: iconst_5
    //   296: getstatic 21	com/flurry/android/monolithic/sdk/impl/ey:c	Ljava/lang/String;
    //   299: ldc -66
    //   301: invokestatic 62	com/flurry/android/monolithic/sdk/impl/ja:a	(ILjava/lang/String;Ljava/lang/String;)V
    //   304: aconst_null
    //   305: astore_1
    //   306: goto -61 -> 245
    //   309: astore_1
    //   310: goto -22 -> 288
    //   313: astore 7
    //   315: aconst_null
    //   316: astore_1
    //   317: goto -62 -> 255
    //   320: astore 7
    //   322: goto -67 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	this	ey
    //   0	325	1	paramString	String
    //   121	116	2	i	int
    //   90	35	3	j	int
    //   136	47	4	k	int
    //   57	3	5	bool	boolean
    //   83	206	6	localDataInputStream1	java.io.DataInputStream
    //   1	208	7	arrayOfByte	byte[]
    //   248	19	7	localThrowable1	Throwable
    //   313	1	7	localThrowable2	Throwable
    //   320	1	7	localThrowable3	Throwable
    //   79	193	8	localDataInputStream2	java.io.DataInputStream
    // Exception table:
    //   from	to	target	type
    //   64	81	248	java/lang/Throwable
    //   5	24	279	finally
    //   24	59	279	finally
    //   95	100	279	finally
    //   240	245	279	finally
    //   271	276	279	finally
    //   288	295	279	finally
    //   295	304	279	finally
    //   64	81	284	finally
    //   85	91	309	finally
    //   111	120	309	finally
    //   131	138	309	finally
    //   142	178	309	finally
    //   182	188	309	finally
    //   192	199	309	finally
    //   203	219	309	finally
    //   230	236	309	finally
    //   259	271	309	finally
    //   85	91	313	java/lang/Throwable
    //   111	120	313	java/lang/Throwable
    //   131	138	320	java/lang/Throwable
    //   142	178	320	java/lang/Throwable
    //   182	188	320	java/lang/Throwable
    //   192	199	320	java/lang/Throwable
    //   203	219	320	java/lang/Throwable
    //   230	236	320	java/lang/Throwable
  }
  
  private void d()
  {
    try
    {
      LinkedList localLinkedList = new LinkedList(this.b.keySet());
      c();
      if (!localLinkedList.isEmpty()) {
        a("Main", localLinkedList);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void a()
  {
    this.b = new LinkedHashMap();
    Object localObject = d("Main");
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        List localList = d(str);
        if (localList != null) {
          this.b.put(str, localList);
        }
      }
    }
  }
  
  public void a(ew paramew, String paramString)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        ja.a(4, c, "addBlockInfo");
        String str = paramew.a();
        paramew = (List)this.b.get(paramString);
        if (paramew == null)
        {
          ja.a(4, c, "New Data Key");
          paramew = new LinkedList();
          i = 1;
          paramew.add(str);
          if (paramew.size() > a.intValue())
          {
            a((String)paramew.get(0));
            paramew.remove(0);
          }
          this.b.put(paramString, paramew);
          a(paramString, paramew);
          if (i != 0) {
            d();
          }
          return;
        }
      }
      finally {}
    }
  }
  
  boolean a(String paramString)
  {
    return new ew(paramString).c();
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    List localList = (List)this.b.get(paramString2);
    boolean bool = false;
    if (localList != null)
    {
      a(paramString1);
      bool = localList.remove(paramString1);
    }
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.b.put(paramString2, localList);
      a(paramString2, localList);
      return bool;
    }
    c(paramString2);
    return bool;
  }
  
  public List<String> b()
  {
    return new ArrayList(this.b.keySet());
  }
  
  public List<String> b(String paramString)
  {
    return (List)this.b.get(paramString);
  }
  
  void c()
  {
    a(ia.a().b().getFileStreamPath(".FlurrySenderIndex.info.Main"));
  }
  
  public boolean c(String paramString)
  {
    try
    {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        ja.a(6, c, "discardOutdatedBlocksForDataKey(ID) running on the MAIN thread!");
      }
      File localFile = ia.a().b().getFileStreamPath(".FlurrySenderIndex.info." + paramString);
      List localList = b(paramString);
      if (localList != null)
      {
        ja.a(4, c, "discardOutdatedBlocksForDataKey: notSentBlocks = " + localList.size());
        int i = 0;
        while (i < localList.size())
        {
          String str = (String)localList.get(i);
          a(str);
          ja.a(4, c, "discardOutdatedBlocksForDataKey: removed block = " + str);
          i += 1;
        }
      }
      this.b.remove(paramString);
      boolean bool = a(localFile);
      d();
      return bool;
    }
    finally {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/ey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */