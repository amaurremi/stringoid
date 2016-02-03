package com.mobisystems.mobiscanner.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.b.a.a.a.a;
import java.io.File;
import java.io.IOException;

public class b
{
  private static final c apd = new c();
  private File avu = null;
  private int avv = 10485760;
  private a avw;
  private final Object avx = new Object();
  private boolean avy = true;
  private int gj = 1;
  private final c mLog = new c(this);
  
  private b(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      this.avu = d.k(paramContext, paramString);
    }
    catch (IOException paramString)
    {
      try
      {
        for (;;)
        {
          this.gj = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
          this.avv = paramInt;
          return;
          paramString = paramString;
          apd.g("Exception creating disk cache dir", paramString);
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          apd.A("Exception getting application version: " + paramContext);
        }
      }
    }
  }
  
  private static a a(FragmentManager paramFragmentManager, String paramString)
  {
    a locala2 = (a)paramFragmentManager.findFragmentByTag(paramString);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a();
      paramFragmentManager.beginTransaction().add(locala1, paramString).commitAllowingStateLoss();
    }
    return locala1;
  }
  
  public static b a(Context paramContext, FragmentManager paramFragmentManager, String paramString, int paramInt)
  {
    a locala = a(paramFragmentManager, paramString);
    b localb = (b)locala.getObject();
    paramFragmentManager = localb;
    if (localb == null)
    {
      paramFragmentManager = new b(paramContext, paramString, paramInt);
      locala.setObject(paramFragmentManager);
    }
    return paramFragmentManager;
  }
  
  public void Dr()
  {
    synchronized (this.avx)
    {
      if (((this.avw == null) || (this.avw.isClosed())) && (this.avu != null)) {
        if (!this.avu.exists()) {
          this.avu.mkdirs();
        }
      }
      try
      {
        this.avw = a.a(this.avu, this.gj, 1, this.avv);
        this.mLog.dl("Disk cache initialized, size=" + this.avv / 1024 + "KB");
        this.avy = false;
        this.avx.notifyAll();
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.avu = null;
          this.mLog.g("initDiskCache - ", localIOException);
        }
      }
    }
  }
  
  /* Error */
  public void a(String paramString, File paramFile, a<Integer> parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: aload_1
    //   10: ifnull +7 -> 17
    //   13: aload_2
    //   14: ifnonnull +4 -> 18
    //   17: return
    //   18: aload_0
    //   19: getfield 42	com/mobisystems/mobiscanner/common/b:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   22: new 88	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   29: ldc -79
    //   31: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_1
    //   35: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc -77
    //   40: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_2
    //   44: invokevirtual 182	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   47: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokevirtual 169	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   56: aload_0
    //   57: getfield 49	com/mobisystems/mobiscanner/common/b:avx	Ljava/lang/Object;
    //   60: astore 7
    //   62: aload 7
    //   64: monitorenter
    //   65: aload_0
    //   66: getfield 142	com/mobisystems/mobiscanner/common/b:avw	Lcom/b/a/a/a/a;
    //   69: ifnull +86 -> 155
    //   72: aload_1
    //   73: invokestatic 186	com/mobisystems/mobiscanner/common/d:dm	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore_1
    //   77: aload_0
    //   78: getfield 142	com/mobisystems/mobiscanner/common/b:avw	Lcom/b/a/a/a/a;
    //   81: aload_1
    //   82: invokevirtual 190	com/b/a/a/a/a:h	(Ljava/lang/String;)Lcom/b/a/a/a/a$c;
    //   85: astore 8
    //   87: aload 8
    //   89: ifnonnull +76 -> 165
    //   92: aload_0
    //   93: getfield 142	com/mobisystems/mobiscanner/common/b:avw	Lcom/b/a/a/a/a;
    //   96: aload_1
    //   97: invokevirtual 194	com/b/a/a/a/a:j	(Ljava/lang/String;)Lcom/b/a/a/a/a$a;
    //   100: astore 8
    //   102: aload 8
    //   104: ifnull +70 -> 174
    //   107: aload 8
    //   109: iconst_0
    //   110: invokevirtual 200	com/b/a/a/a/a$a:aw	(I)Ljava/io/OutputStream;
    //   113: astore_1
    //   114: new 202	java/io/FileInputStream
    //   117: dup
    //   118: aload_2
    //   119: invokespecial 205	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   122: astore 4
    //   124: aload 4
    //   126: aload_1
    //   127: aload_3
    //   128: invokestatic 208	com/mobisystems/mobiscanner/common/d:a	(Ljava/io/InputStream;Ljava/io/OutputStream;Lcom/mobisystems/mobiscanner/common/a;)V
    //   131: aload 8
    //   133: invokevirtual 211	com/b/a/a/a/a$a:commit	()V
    //   136: aload 4
    //   138: astore_2
    //   139: aload_2
    //   140: ifnull +7 -> 147
    //   143: aload_2
    //   144: invokevirtual 214	java/io/FileInputStream:close	()V
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 217	java/io/OutputStream:close	()V
    //   155: aload 7
    //   157: monitorexit
    //   158: return
    //   159: astore_1
    //   160: aload 7
    //   162: monitorexit
    //   163: aload_1
    //   164: athrow
    //   165: aload 8
    //   167: iconst_0
    //   168: invokevirtual 223	com/b/a/a/a/a$c:az	(I)Ljava/io/InputStream;
    //   171: invokevirtual 226	java/io/InputStream:close	()V
    //   174: aconst_null
    //   175: astore_1
    //   176: aload 6
    //   178: astore_2
    //   179: goto -40 -> 139
    //   182: astore_1
    //   183: aconst_null
    //   184: astore_3
    //   185: aload 4
    //   187: astore_2
    //   188: aload_0
    //   189: getfield 42	com/mobisystems/mobiscanner/common/b:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   192: ldc -28
    //   194: aload_1
    //   195: invokevirtual 86	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   198: aload_3
    //   199: ifnull +7 -> 206
    //   202: aload_3
    //   203: invokevirtual 214	java/io/FileInputStream:close	()V
    //   206: aload_2
    //   207: ifnull -52 -> 155
    //   210: aload_2
    //   211: invokevirtual 217	java/io/OutputStream:close	()V
    //   214: goto -59 -> 155
    //   217: astore_1
    //   218: goto -63 -> 155
    //   221: astore_1
    //   222: aconst_null
    //   223: astore_3
    //   224: aload 5
    //   226: astore_2
    //   227: aload_3
    //   228: ifnull +7 -> 235
    //   231: aload_3
    //   232: invokevirtual 214	java/io/FileInputStream:close	()V
    //   235: aload_2
    //   236: ifnull +7 -> 243
    //   239: aload_2
    //   240: invokevirtual 217	java/io/OutputStream:close	()V
    //   243: aload_1
    //   244: athrow
    //   245: astore_2
    //   246: goto -99 -> 147
    //   249: astore_1
    //   250: goto -95 -> 155
    //   253: astore_1
    //   254: goto -48 -> 206
    //   257: astore_3
    //   258: goto -23 -> 235
    //   261: astore_2
    //   262: goto -19 -> 243
    //   265: astore 4
    //   267: aconst_null
    //   268: astore_3
    //   269: aload_1
    //   270: astore_2
    //   271: aload 4
    //   273: astore_1
    //   274: goto -47 -> 227
    //   277: astore_3
    //   278: aload_1
    //   279: astore_2
    //   280: aload_3
    //   281: astore_1
    //   282: aload 4
    //   284: astore_3
    //   285: goto -58 -> 227
    //   288: astore_1
    //   289: goto -62 -> 227
    //   292: astore 4
    //   294: aconst_null
    //   295: astore_3
    //   296: aload_1
    //   297: astore_2
    //   298: aload 4
    //   300: astore_1
    //   301: goto -113 -> 188
    //   304: astore_3
    //   305: aload_1
    //   306: astore_2
    //   307: aload_3
    //   308: astore_1
    //   309: aload 4
    //   311: astore_3
    //   312: goto -124 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	b
    //   0	315	1	paramString	String
    //   0	315	2	paramFile	File
    //   0	315	3	parama	a<Integer>
    //   1	185	4	localFileInputStream	java.io.FileInputStream
    //   265	18	4	localObject1	Object
    //   292	18	4	localIOException	IOException
    //   4	221	5	localObject2	Object
    //   7	170	6	localObject3	Object
    //   60	101	7	localObject4	Object
    //   85	81	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   65	77	159	finally
    //   143	147	159	finally
    //   151	155	159	finally
    //   155	158	159	finally
    //   160	163	159	finally
    //   202	206	159	finally
    //   210	214	159	finally
    //   231	235	159	finally
    //   239	243	159	finally
    //   243	245	159	finally
    //   77	87	182	java/io/IOException
    //   92	102	182	java/io/IOException
    //   107	114	182	java/io/IOException
    //   165	174	182	java/io/IOException
    //   210	214	217	java/io/IOException
    //   77	87	221	finally
    //   92	102	221	finally
    //   107	114	221	finally
    //   165	174	221	finally
    //   143	147	245	java/io/IOException
    //   151	155	249	java/io/IOException
    //   202	206	253	java/io/IOException
    //   231	235	257	java/io/IOException
    //   239	243	261	java/io/IOException
    //   114	124	265	finally
    //   124	136	277	finally
    //   188	198	288	finally
    //   114	124	292	java/io/IOException
    //   124	136	304	java/io/IOException
  }
  
  /* Error */
  public boolean b(String paramString, File paramFile, a<Integer> parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 8
    //   9: iconst_0
    //   10: istore 6
    //   12: iconst_0
    //   13: istore 4
    //   15: aload_1
    //   16: invokestatic 186	com/mobisystems/mobiscanner/common/d:dm	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 9
    //   21: aload_2
    //   22: ifnonnull +5 -> 27
    //   25: iconst_0
    //   26: ireturn
    //   27: aload_0
    //   28: getfield 49	com/mobisystems/mobiscanner/common/b:avx	Ljava/lang/Object;
    //   31: astore 11
    //   33: aload 11
    //   35: monitorenter
    //   36: aload_0
    //   37: getfield 51	com/mobisystems/mobiscanner/common/b:avy	Z
    //   40: istore 5
    //   42: iload 5
    //   44: ifeq +18 -> 62
    //   47: aload_0
    //   48: getfield 49	com/mobisystems/mobiscanner/common/b:avx	Ljava/lang/Object;
    //   51: invokevirtual 237	java/lang/Object:wait	()V
    //   54: goto -18 -> 36
    //   57: astore 12
    //   59: goto -23 -> 36
    //   62: aload_0
    //   63: getfield 142	com/mobisystems/mobiscanner/common/b:avw	Lcom/b/a/a/a/a;
    //   66: astore 12
    //   68: iload 6
    //   70: istore 5
    //   72: aload 12
    //   74: ifnull +102 -> 176
    //   77: aload_0
    //   78: getfield 142	com/mobisystems/mobiscanner/common/b:avw	Lcom/b/a/a/a/a;
    //   81: aload 9
    //   83: invokevirtual 190	com/b/a/a/a/a:h	(Ljava/lang/String;)Lcom/b/a/a/a/a$c;
    //   86: astore 9
    //   88: aload 9
    //   90: ifnull +280 -> 370
    //   93: aload_0
    //   94: getfield 42	com/mobisystems/mobiscanner/common/b:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   97: ldc -17
    //   99: invokevirtual 169	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   102: aload 9
    //   104: iconst_0
    //   105: invokevirtual 223	com/b/a/a/a/a$c:az	(I)Ljava/io/InputStream;
    //   108: astore 9
    //   110: aload 9
    //   112: astore 7
    //   114: aload 7
    //   116: astore 9
    //   118: aload 7
    //   120: ifnull +28 -> 148
    //   123: new 241	java/io/FileOutputStream
    //   126: dup
    //   127: aload_2
    //   128: invokespecial 242	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   131: astore 8
    //   133: aload 7
    //   135: aload 8
    //   137: aload_3
    //   138: invokestatic 208	com/mobisystems/mobiscanner/common/d:a	(Ljava/io/InputStream;Ljava/io/OutputStream;Lcom/mobisystems/mobiscanner/common/a;)V
    //   141: iconst_1
    //   142: istore 4
    //   144: aload 7
    //   146: astore 9
    //   148: aload 9
    //   150: ifnull +8 -> 158
    //   153: aload 9
    //   155: invokevirtual 226	java/io/InputStream:close	()V
    //   158: iload 4
    //   160: istore 5
    //   162: aload 8
    //   164: ifnull +12 -> 176
    //   167: aload 8
    //   169: invokevirtual 243	java/io/FileOutputStream:close	()V
    //   172: iload 4
    //   174: istore 5
    //   176: iload 5
    //   178: ifeq +41 -> 219
    //   181: aload_0
    //   182: getfield 42	com/mobisystems/mobiscanner/common/b:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   185: new 88	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   192: ldc -11
    //   194: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_2
    //   198: invokevirtual 182	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   201: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc -9
    //   206: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_1
    //   210: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokevirtual 169	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   219: aload 11
    //   221: monitorexit
    //   222: iload 5
    //   224: ireturn
    //   225: astore_1
    //   226: aload 11
    //   228: monitorexit
    //   229: aload_1
    //   230: athrow
    //   231: astore 9
    //   233: aconst_null
    //   234: astore_3
    //   235: aload_0
    //   236: getfield 42	com/mobisystems/mobiscanner/common/b:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   239: ldc -7
    //   241: aload 9
    //   243: invokevirtual 86	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   246: aload 7
    //   248: ifnull +8 -> 256
    //   251: aload 7
    //   253: invokevirtual 226	java/io/InputStream:close	()V
    //   256: iload 6
    //   258: istore 5
    //   260: aload_3
    //   261: ifnull -85 -> 176
    //   264: aload_3
    //   265: invokevirtual 243	java/io/FileOutputStream:close	()V
    //   268: iload 6
    //   270: istore 5
    //   272: goto -96 -> 176
    //   275: astore_3
    //   276: iload 6
    //   278: istore 5
    //   280: goto -104 -> 176
    //   283: astore_1
    //   284: aconst_null
    //   285: astore 7
    //   287: aload 10
    //   289: astore_2
    //   290: aload 7
    //   292: ifnull +8 -> 300
    //   295: aload 7
    //   297: invokevirtual 226	java/io/InputStream:close	()V
    //   300: aload_2
    //   301: ifnull +7 -> 308
    //   304: aload_2
    //   305: invokevirtual 243	java/io/FileOutputStream:close	()V
    //   308: aload_1
    //   309: athrow
    //   310: astore_3
    //   311: goto -153 -> 158
    //   314: astore_3
    //   315: iload 4
    //   317: istore 5
    //   319: goto -143 -> 176
    //   322: astore 7
    //   324: goto -68 -> 256
    //   327: astore_3
    //   328: goto -28 -> 300
    //   331: astore_2
    //   332: goto -24 -> 308
    //   335: astore_1
    //   336: aload 10
    //   338: astore_2
    //   339: goto -49 -> 290
    //   342: astore_1
    //   343: aload 8
    //   345: astore_2
    //   346: goto -56 -> 290
    //   349: astore_1
    //   350: aload_3
    //   351: astore_2
    //   352: goto -62 -> 290
    //   355: astore 9
    //   357: aconst_null
    //   358: astore_3
    //   359: goto -124 -> 235
    //   362: astore 9
    //   364: aload 8
    //   366: astore_3
    //   367: goto -132 -> 235
    //   370: aconst_null
    //   371: astore 9
    //   373: goto -225 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	this	b
    //   0	376	1	paramString	String
    //   0	376	2	paramFile	File
    //   0	376	3	parama	a<Integer>
    //   13	303	4	bool1	boolean
    //   40	278	5	bool2	boolean
    //   10	267	6	bool3	boolean
    //   1	295	7	localObject1	Object
    //   322	1	7	localIOException1	IOException
    //   7	358	8	localFileOutputStream	java.io.FileOutputStream
    //   19	135	9	localObject2	Object
    //   231	11	9	localIOException2	IOException
    //   355	1	9	localIOException3	IOException
    //   362	1	9	localIOException4	IOException
    //   371	1	9	localObject3	Object
    //   4	333	10	localObject4	Object
    //   31	196	11	localObject5	Object
    //   57	1	12	localInterruptedException	InterruptedException
    //   66	7	12	locala	a
    // Exception table:
    //   from	to	target	type
    //   47	54	57	java/lang/InterruptedException
    //   36	42	225	finally
    //   47	54	225	finally
    //   62	68	225	finally
    //   153	158	225	finally
    //   167	172	225	finally
    //   181	219	225	finally
    //   219	222	225	finally
    //   226	229	225	finally
    //   251	256	225	finally
    //   264	268	225	finally
    //   295	300	225	finally
    //   304	308	225	finally
    //   308	310	225	finally
    //   77	88	231	java/io/IOException
    //   93	110	231	java/io/IOException
    //   264	268	275	java/io/IOException
    //   77	88	283	finally
    //   93	110	283	finally
    //   153	158	310	java/io/IOException
    //   167	172	314	java/io/IOException
    //   251	256	322	java/io/IOException
    //   295	300	327	java/io/IOException
    //   304	308	331	java/io/IOException
    //   123	133	335	finally
    //   133	141	342	finally
    //   235	246	349	finally
    //   123	133	355	java/io/IOException
    //   133	141	362	java/io/IOException
  }
  
  public void clearCache()
  {
    synchronized (this.avx)
    {
      this.avy = true;
      if (this.avw != null)
      {
        boolean bool = this.avw.isClosed();
        if (bool) {}
      }
      try
      {
        this.avw.delete();
        this.mLog.dl("Disk cache cleared");
        this.avw = null;
        Dr();
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.mLog.g("clearCache - ", localIOException);
        }
      }
    }
  }
  
  public void close()
  {
    synchronized (this.avx)
    {
      a locala = this.avw;
      if (locala != null) {}
      try
      {
        if (!this.avw.isClosed())
        {
          this.avw.close();
          this.avw = null;
          this.mLog.dl("Disk cache closed");
        }
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.mLog.g("close - ", localIOException);
        }
      }
    }
  }
  
  public void flush()
  {
    synchronized (this.avx)
    {
      a locala = this.avw;
      if (locala != null) {}
      try
      {
        this.avw.flush();
        this.mLog.dl("Disk cache flushed");
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.mLog.g("flush - ", localIOException);
        }
      }
    }
  }
  
  public static class a
    extends Fragment
  {
    private Object aiv;
    
    public Object getObject()
    {
      return this.aiv;
    }
    
    public void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      setRetainInstance(true);
    }
    
    public void setObject(Object paramObject)
    {
      this.aiv = paramObject;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/common/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */