package com.flurry.android;

import android.content.Context;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class z
{
  private Context a;
  private u b;
  private a c;
  private volatile long d;
  private af e = new af(100);
  private af f = new af(100);
  private Map g = new HashMap();
  private Map h = new HashMap();
  private Map i = new HashMap();
  private Map j = new HashMap();
  private volatile boolean k;
  
  private c a(byte paramByte)
  {
    try
    {
      c localc = (c)this.i.get(Byte.valueOf(paramByte));
      return localc;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void a(int paramInt)
  {
    if (!this.g.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      this.k = bool;
      if (this.k) {
        this.b.a(paramInt);
      }
      return;
    }
  }
  
  private void a(DataInputStream paramDataInputStream)
  {
    int i1 = 0;
    ah.a("FlurryAgent", "Reading cache");
    if (paramDataInputStream.readUnsignedShort() != 2) {
      return;
    }
    this.d = paramDataInputStream.readLong();
    int n = paramDataInputStream.readUnsignedShort();
    this.e = new af(100);
    int m = 0;
    long l;
    Object localObject1;
    while (m < n)
    {
      l = paramDataInputStream.readLong();
      localObject1 = new AdImage();
      ((AdImage)localObject1).a(paramDataInputStream);
      this.e.a(Long.valueOf(l), localObject1);
      m += 1;
    }
    n = paramDataInputStream.readUnsignedShort();
    this.f = new af(100);
    m = 0;
    while (m < n)
    {
      l = paramDataInputStream.readLong();
      localObject1 = new al();
      if (paramDataInputStream.readBoolean()) {
        ((al)localObject1).a = paramDataInputStream.readUTF();
      }
      if (paramDataInputStream.readBoolean()) {
        ((al)localObject1).b = paramDataInputStream.readUTF();
      }
      ((al)localObject1).c = paramDataInputStream.readInt();
      this.f.a(Long.valueOf(l), localObject1);
      m += 1;
    }
    n = paramDataInputStream.readUnsignedShort();
    this.h = new HashMap(n);
    m = 0;
    Object localObject2;
    while (m < n)
    {
      localObject1 = paramDataInputStream.readUTF();
      localObject2 = new e(paramDataInputStream);
      this.h.put(localObject1, localObject2);
      m += 1;
    }
    int i2 = paramDataInputStream.readUnsignedShort();
    this.g = new HashMap(i2);
    m = 0;
    while (m < i2)
    {
      localObject1 = paramDataInputStream.readUTF();
      int i3 = paramDataInputStream.readUnsignedShort();
      localObject2 = new v[i3];
      n = 0;
      while (n < i3)
      {
        v localv = new v();
        localv.a(paramDataInputStream);
        localObject2[n] = localv;
        n += 1;
      }
      this.g.put(localObject1, localObject2);
      m += 1;
    }
    n = paramDataInputStream.readUnsignedShort();
    this.i = new HashMap();
    m = 0;
    while (m < n)
    {
      byte b1 = paramDataInputStream.readByte();
      localObject1 = new c();
      ((c)localObject1).b(paramDataInputStream);
      this.i.put(Byte.valueOf(b1), localObject1);
      m += 1;
    }
    n = paramDataInputStream.readUnsignedShort();
    this.j = new HashMap(n);
    m = i1;
    while (m < n)
    {
      short s = paramDataInputStream.readShort();
      l = paramDataInputStream.readLong();
      this.j.put(Short.valueOf(s), Long.valueOf(l));
      m += 1;
    }
    f();
    ah.a("FlurryAgent", "Cache read, num images: " + this.e.a());
  }
  
  private void a(DataOutputStream paramDataOutputStream)
  {
    paramDataOutputStream.writeShort(2);
    paramDataOutputStream.writeLong(this.d);
    Object localObject1 = this.e.b();
    paramDataOutputStream.writeShort(((List)localObject1).size());
    localObject1 = ((List)localObject1).iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      paramDataOutputStream.writeLong(((Long)((Map.Entry)localObject2).getKey()).longValue());
      localObject2 = (AdImage)((Map.Entry)localObject2).getValue();
      paramDataOutputStream.writeLong(((AdImage)localObject2).a);
      paramDataOutputStream.writeInt(((AdImage)localObject2).b);
      paramDataOutputStream.writeInt(((AdImage)localObject2).c);
      paramDataOutputStream.writeUTF(((AdImage)localObject2).d);
      paramDataOutputStream.writeInt(((AdImage)localObject2).e.length);
      paramDataOutputStream.write(((AdImage)localObject2).e);
    }
    localObject1 = this.f.b();
    paramDataOutputStream.writeShort(((List)localObject1).size());
    localObject1 = ((List)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      paramDataOutputStream.writeLong(((Long)((Map.Entry)localObject2).getKey()).longValue());
      localObject2 = (al)((Map.Entry)localObject2).getValue();
      if (((al)localObject2).a != null)
      {
        bool = true;
        label254:
        paramDataOutputStream.writeBoolean(bool);
        if (bool) {
          paramDataOutputStream.writeUTF(((al)localObject2).a);
        }
        if (((al)localObject2).b == null) {
          break label333;
        }
      }
      label333:
      for (boolean bool = true;; bool = false)
      {
        paramDataOutputStream.writeBoolean(bool);
        if (bool) {
          paramDataOutputStream.writeUTF(((al)localObject2).b);
        }
        paramDataOutputStream.writeInt(((al)localObject2).c);
        break;
        bool = false;
        break label254;
      }
    }
    paramDataOutputStream.writeShort(this.h.size());
    localObject1 = this.h.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      paramDataOutputStream.writeUTF((String)((Map.Entry)localObject2).getKey());
      localObject2 = (e)((Map.Entry)localObject2).getValue();
      paramDataOutputStream.writeUTF(((e)localObject2).a);
      paramDataOutputStream.writeByte(((e)localObject2).b);
      paramDataOutputStream.writeByte(((e)localObject2).c);
    }
    paramDataOutputStream.writeShort(this.g.size());
    localObject1 = this.g.entrySet().iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      paramDataOutputStream.writeUTF((String)((Map.Entry)localObject2).getKey());
      localObject2 = (v[])((Map.Entry)localObject2).getValue();
      if (localObject2 == null) {}
      for (int m = 0;; m = localObject2.length)
      {
        paramDataOutputStream.writeShort(m);
        int n = 0;
        while (n < m)
        {
          Object localObject3 = localObject2[n];
          paramDataOutputStream.writeLong(((v)localObject3).a);
          paramDataOutputStream.writeLong(((v)localObject3).b);
          paramDataOutputStream.writeUTF(((v)localObject3).d);
          paramDataOutputStream.writeUTF(((v)localObject3).c);
          paramDataOutputStream.writeLong(((v)localObject3).e);
          paramDataOutputStream.writeLong(((v)localObject3).f.longValue());
          paramDataOutputStream.writeByte(((v)localObject3).g.length);
          paramDataOutputStream.write(((v)localObject3).g);
          n += 1;
        }
        break;
      }
    }
    paramDataOutputStream.writeShort(this.i.size());
    localObject1 = this.i.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      paramDataOutputStream.writeByte(((Byte)((Map.Entry)localObject2).getKey()).byteValue());
      ((c)((Map.Entry)localObject2).getValue()).a(paramDataOutputStream);
    }
    paramDataOutputStream.writeShort(this.j.size());
    localObject1 = this.j.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      paramDataOutputStream.writeShort(((Short)((Map.Entry)localObject2).getKey()).shortValue());
      paramDataOutputStream.writeLong(((Long)((Map.Entry)localObject2).getValue()).longValue());
    }
  }
  
  private static void a(File paramFile)
  {
    if (!paramFile.delete()) {
      ah.b("FlurryAgent", "Cannot delete cached ads");
    }
  }
  
  private void f()
  {
    Iterator localIterator = this.i.values().iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
    localIterator = this.g.values().iterator();
    Object localObject1;
    while (localIterator.hasNext())
    {
      localObject1 = (v[])localIterator.next();
      if (localObject1 != null)
      {
        int n = localObject1.length;
        int m = 0;
        while (m < n)
        {
          Object localObject2 = localObject1[m];
          ((v)localObject2).h = b(((v)localObject2).f.longValue());
          if (((v)localObject2).h == null) {
            ah.b("FlurryAgent", "Ad " + ((v)localObject2).d + " has no image");
          }
          if (a(((v)localObject2).a) == null) {
            ah.b("FlurryAgent", "Ad " + ((v)localObject2).d + " has no pricing");
          }
          m += 1;
        }
      }
    }
    localIterator = this.h.values().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (e)localIterator.next();
      ((e)localObject1).d = a(((e)localObject1).c);
      if (((e)localObject1).d == null) {
        ah.d("FlurryAgent", "No ad theme found for " + ((e)localObject1).c);
      }
    }
  }
  
  private String g()
  {
    return ".flurryappcircle." + Integer.toString(this.c.a.hashCode(), 16);
  }
  
  /* Error */
  final AdImage a(short paramShort)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 46	com/flurry/android/z:j	Ljava/util/Map;
    //   6: iconst_1
    //   7: invokestatic 163	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   10: invokeinterface 60 2 0
    //   15: checkcast 104	java/lang/Long
    //   18: astore_2
    //   19: aload_2
    //   20: ifnonnull +9 -> 29
    //   23: aconst_null
    //   24: astore_2
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: areturn
    //   29: aload_0
    //   30: aload_2
    //   31: invokevirtual 221	java/lang/Long:longValue	()J
    //   34: invokevirtual 317	com/flurry/android/z:b	(J)Lcom/flurry/android/AdImage;
    //   37: astore_2
    //   38: goto -13 -> 25
    //   41: astore_2
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_2
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	z
    //   0	46	1	paramShort	short
    //   18	20	2	localObject1	Object
    //   41	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	41	finally
    //   29	38	41	finally
  }
  
  final al a(long paramLong)
  {
    try
    {
      al localal = (al)this.f.a(Long.valueOf(paramLong));
      return localal;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final Set a()
  {
    try
    {
      Set localSet = this.e.c();
      return localSet;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final void a(Context paramContext, u paramu, a parama)
  {
    this.a = paramContext;
    this.b = paramu;
    this.c = parama;
  }
  
  final void a(Map paramMap1, Map paramMap2, Map paramMap3, Map paramMap4, Map paramMap5, Map paramMap6)
  {
    try
    {
      this.d = System.currentTimeMillis();
      paramMap4 = paramMap4.entrySet().iterator();
      while (paramMap4.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap4.next();
        if (localEntry.getValue() != null) {
          this.e.a(localEntry.getKey(), localEntry.getValue());
        }
      }
      paramMap4 = paramMap5.entrySet().iterator();
    }
    finally {}
    while (paramMap4.hasNext())
    {
      paramMap5 = (Map.Entry)paramMap4.next();
      if (paramMap5.getValue() != null) {
        this.f.a(paramMap5.getKey(), paramMap5.getValue());
      }
    }
    if ((paramMap2 != null) && (!paramMap2.isEmpty())) {
      this.h = paramMap2;
    }
    if ((paramMap3 != null) && (!paramMap3.isEmpty())) {
      this.i = paramMap3;
    }
    if ((paramMap6 != null) && (!paramMap6.isEmpty())) {
      this.j = paramMap6;
    }
    this.g = new HashMap();
    paramMap2 = paramMap2.entrySet().iterator();
    while (paramMap2.hasNext())
    {
      paramMap5 = (Map.Entry)paramMap2.next();
      paramMap4 = (e)paramMap5.getValue();
      paramMap6 = (v[])paramMap1.get(Byte.valueOf(paramMap4.b));
      if (paramMap6 != null) {
        this.g.put(paramMap5.getKey(), paramMap6);
      }
      paramMap5 = (c)paramMap3.get(Byte.valueOf(paramMap4.c));
      if (paramMap5 != null) {
        paramMap4.d = paramMap5;
      }
    }
    f();
    a(202);
  }
  
  final v[] a(String paramString)
  {
    try
    {
      v[] arrayOfv = (v[])this.g.get(paramString);
      paramString = arrayOfv;
      if (arrayOfv == null) {
        paramString = (v[])this.g.get("");
      }
      return paramString;
    }
    finally {}
  }
  
  final AdImage b(long paramLong)
  {
    try
    {
      AdImage localAdImage = (AdImage)this.e.a(Long.valueOf(paramLong));
      return localAdImage;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final e b(String paramString)
  {
    try
    {
      e locale = (e)this.h.get(paramString);
      paramString = locale;
      if (locale == null) {
        paramString = (e)this.h.get("");
      }
      return paramString;
    }
    finally {}
  }
  
  final boolean b()
  {
    return this.k;
  }
  
  final long c()
  {
    return this.d;
  }
  
  /* Error */
  final void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 361	com/flurry/android/z:a	Landroid/content/Context;
    //   6: aload_0
    //   7: invokespecial 376	com/flurry/android/z:g	()Ljava/lang/String;
    //   10: invokevirtual 382	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   13: astore 5
    //   15: aload 5
    //   17: invokevirtual 385	java/io/File:exists	()Z
    //   20: istore_1
    //   21: iload_1
    //   22: ifeq +108 -> 130
    //   25: new 86	java/io/DataInputStream
    //   28: dup
    //   29: new 387	java/io/FileInputStream
    //   32: dup
    //   33: aload 5
    //   35: invokespecial 389	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: invokespecial 392	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   41: astore_3
    //   42: aload_3
    //   43: astore_2
    //   44: aload_3
    //   45: invokevirtual 90	java/io/DataInputStream:readUnsignedShort	()I
    //   48: ldc_w 393
    //   51: if_icmpne +26 -> 77
    //   54: aload_3
    //   55: astore_2
    //   56: aload_0
    //   57: aload_3
    //   58: invokespecial 395	com/flurry/android/z:a	(Ljava/io/DataInputStream;)V
    //   61: aload_3
    //   62: astore_2
    //   63: aload_0
    //   64: sipush 201
    //   67: invokespecial 368	com/flurry/android/z:a	(I)V
    //   70: aload_3
    //   71: invokestatic 400	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: aload_3
    //   78: astore_2
    //   79: aload 5
    //   81: invokestatic 402	com/flurry/android/z:a	(Ljava/io/File;)V
    //   84: goto -14 -> 70
    //   87: astore 4
    //   89: aload_3
    //   90: astore_2
    //   91: ldc 77
    //   93: ldc_w 404
    //   96: aload 4
    //   98: invokestatic 407	com/flurry/android/ah:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   101: pop
    //   102: aload_3
    //   103: astore_2
    //   104: aload 5
    //   106: invokestatic 402	com/flurry/android/z:a	(Ljava/io/File;)V
    //   109: aload_3
    //   110: invokestatic 400	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   113: goto -39 -> 74
    //   116: astore_2
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_2
    //   120: athrow
    //   121: astore_3
    //   122: aconst_null
    //   123: astore_2
    //   124: aload_2
    //   125: invokestatic 400	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   128: aload_3
    //   129: athrow
    //   130: ldc 77
    //   132: new 167	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 409
    //   142: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload 5
    //   147: invokevirtual 412	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   150: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 414	com/flurry/android/ah:c	(Ljava/lang/String;Ljava/lang/String;)I
    //   159: pop
    //   160: goto -86 -> 74
    //   163: astore_3
    //   164: goto -40 -> 124
    //   167: astore 4
    //   169: aconst_null
    //   170: astore_3
    //   171: goto -82 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	z
    //   20	2	1	bool	boolean
    //   43	61	2	localDataInputStream1	DataInputStream
    //   116	4	2	localObject1	Object
    //   123	2	2	localCloseable	java.io.Closeable
    //   41	69	3	localDataInputStream2	DataInputStream
    //   121	8	3	localObject2	Object
    //   163	1	3	localObject3	Object
    //   170	1	3	localObject4	Object
    //   87	10	4	localThrowable1	Throwable
    //   167	1	4	localThrowable2	Throwable
    //   13	133	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   44	54	87	java/lang/Throwable
    //   56	61	87	java/lang/Throwable
    //   63	70	87	java/lang/Throwable
    //   79	84	87	java/lang/Throwable
    //   2	21	116	finally
    //   70	74	116	finally
    //   109	113	116	finally
    //   124	130	116	finally
    //   130	160	116	finally
    //   25	42	121	finally
    //   44	54	163	finally
    //   56	61	163	finally
    //   63	70	163	finally
    //   79	84	163	finally
    //   91	102	163	finally
    //   104	109	163	finally
    //   25	42	167	java/lang/Throwable
  }
  
  /* Error */
  final void e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_2
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 361	com/flurry/android/z:a	Landroid/content/Context;
    //   12: aload_0
    //   13: invokespecial 376	com/flurry/android/z:g	()Ljava/lang/String;
    //   16: invokevirtual 382	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   19: astore 4
    //   21: aload_2
    //   22: astore_1
    //   23: aload 4
    //   25: invokevirtual 418	java/io/File:getParentFile	()Ljava/io/File;
    //   28: astore 5
    //   30: aload_2
    //   31: astore_1
    //   32: aload 5
    //   34: invokevirtual 421	java/io/File:mkdirs	()Z
    //   37: ifne +49 -> 86
    //   40: aload_2
    //   41: astore_1
    //   42: aload 5
    //   44: invokevirtual 385	java/io/File:exists	()Z
    //   47: ifne +39 -> 86
    //   50: aload_2
    //   51: astore_1
    //   52: ldc 77
    //   54: new 167	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 423
    //   64: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload 5
    //   69: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 307	com/flurry/android/ah:b	(Ljava/lang/String;Ljava/lang/String;)I
    //   78: pop
    //   79: aconst_null
    //   80: invokestatic 400	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   83: aload_0
    //   84: monitorexit
    //   85: return
    //   86: aload_2
    //   87: astore_1
    //   88: new 185	java/io/DataOutputStream
    //   91: dup
    //   92: new 428	java/io/FileOutputStream
    //   95: dup
    //   96: aload 4
    //   98: invokespecial 429	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   101: invokespecial 432	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   104: astore_2
    //   105: aload_2
    //   106: ldc_w 393
    //   109: invokevirtual 188	java/io/DataOutputStream:writeShort	(I)V
    //   112: aload_0
    //   113: aload_2
    //   114: invokespecial 434	com/flurry/android/z:a	(Ljava/io/DataOutputStream;)V
    //   117: aload_2
    //   118: invokestatic 400	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   121: goto -38 -> 83
    //   124: astore_1
    //   125: aload_0
    //   126: monitorexit
    //   127: aload_1
    //   128: athrow
    //   129: astore_1
    //   130: aload_3
    //   131: astore_2
    //   132: aload_1
    //   133: astore_3
    //   134: aload_2
    //   135: astore_1
    //   136: ldc 77
    //   138: ldc_w 371
    //   141: aload_3
    //   142: invokestatic 436	com/flurry/android/ah:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   145: pop
    //   146: aload_2
    //   147: invokestatic 400	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   150: goto -67 -> 83
    //   153: aload_1
    //   154: invokestatic 400	com/flurry/android/r:a	(Ljava/io/Closeable;)V
    //   157: aload_2
    //   158: athrow
    //   159: astore_3
    //   160: aload_2
    //   161: astore_1
    //   162: aload_3
    //   163: astore_2
    //   164: goto -11 -> 153
    //   167: astore_3
    //   168: goto -34 -> 134
    //   171: astore_2
    //   172: goto -19 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	z
    //   7	81	1	localObject1	Object
    //   124	4	1	localObject2	Object
    //   129	4	1	localThrowable1	Throwable
    //   135	27	1	localObject3	Object
    //   1	163	2	localObject4	Object
    //   171	1	2	localObject5	Object
    //   3	139	3	localObject6	Object
    //   159	4	3	localObject7	Object
    //   167	1	3	localThrowable2	Throwable
    //   19	78	4	localFile1	File
    //   28	40	5	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   79	83	124	finally
    //   117	121	124	finally
    //   146	150	124	finally
    //   153	159	124	finally
    //   8	21	129	java/lang/Throwable
    //   23	30	129	java/lang/Throwable
    //   32	40	129	java/lang/Throwable
    //   42	50	129	java/lang/Throwable
    //   52	79	129	java/lang/Throwable
    //   88	105	129	java/lang/Throwable
    //   105	117	159	finally
    //   105	117	167	java/lang/Throwable
    //   8	21	171	finally
    //   23	30	171	finally
    //   32	40	171	finally
    //   42	50	171	finally
    //   52	79	171	finally
    //   88	105	171	finally
    //   136	146	171	finally
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("adImages (" + this.e.b().size() + "),\n");
    localStringBuilder.append("adBlock (" + this.g.size() + "):").append(",\n");
    Iterator localIterator = this.g.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append("\t" + (String)localEntry.getKey() + ": " + Arrays.toString((Object[])localEntry.getValue()));
    }
    localStringBuilder.append("adHooks (" + this.h.size() + "):" + this.h).append(",\n");
    localStringBuilder.append("adThemes (" + this.i.size() + "):" + this.i).append(",\n");
    localStringBuilder.append("auxMap (" + this.j.size() + "):" + this.j).append(",\n");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/flurry/android/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */