package com.mobisystems.mobiscanner.image;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.b.e;
import com.b.a.a.a.a;
import com.mobisystems.mobiscanner.common.c;
import java.io.File;
import java.io.IOException;

public class d
{
  private static final c apd = new c();
  private a aHA;
  private e<String, BitmapDrawable> aHB;
  private k aHC = null;
  private a avw;
  private final Object avx = new Object();
  private boolean avy = true;
  private final c mLog = new c(this);
  
  private d(a parama)
  {
    a(parama);
  }
  
  @TargetApi(12)
  public static int a(BitmapDrawable paramBitmapDrawable)
  {
    paramBitmapDrawable = paramBitmapDrawable.getBitmap();
    if (com.mobisystems.mobiscanner.common.d.Dx()) {
      return paramBitmapDrawable.getByteCount();
    }
    int i = paramBitmapDrawable.getRowBytes();
    return paramBitmapDrawable.getHeight() * i;
  }
  
  public static d a(FragmentManager paramFragmentManager, String paramString, a parama)
  {
    b localb = b(paramFragmentManager, paramString);
    paramString = (d)localb.getObject();
    paramFragmentManager = paramString;
    if (paramString == null)
    {
      paramFragmentManager = new d(parama);
      localb.setObject(paramFragmentManager);
    }
    return paramFragmentManager;
  }
  
  private void a(a parama)
  {
    this.aHA = parama;
    if (this.aHA.aHI)
    {
      this.mLog.dl("Memory cache created, size = " + this.aHA.aHE + "KB");
      if (com.mobisystems.mobiscanner.common.d.Dw()) {}
      this.aHB = new e(this.aHA.aHE)
      {
        protected void a(boolean paramAnonymousBoolean, String paramAnonymousString, BitmapDrawable paramAnonymousBitmapDrawable1, BitmapDrawable paramAnonymousBitmapDrawable2)
        {
          if (i.class.isInstance(paramAnonymousBitmapDrawable1)) {
            ((i)paramAnonymousBitmapDrawable1).bq(false);
          }
          while (d.a(d.this) == null) {
            return;
          }
          d.a(d.this).f(paramAnonymousBitmapDrawable1.getBitmap());
        }
        
        protected int b(String paramAnonymousString, BitmapDrawable paramAnonymousBitmapDrawable)
        {
          int j = d.a(paramAnonymousBitmapDrawable) / 1024;
          int i = j;
          if (j == 0) {
            i = 1;
          }
          return i;
        }
      };
    }
    if (parama.aHK) {
      Dr();
    }
  }
  
  private static b b(FragmentManager paramFragmentManager, String paramString)
  {
    b localb2 = (b)paramFragmentManager.findFragmentByTag(paramString);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      paramFragmentManager.beginTransaction().add(localb1, paramString).commitAllowingStateLoss();
    }
    return localb1;
  }
  
  public void Dr()
  {
    synchronized (this.avx)
    {
      File localFile;
      if ((this.avw == null) || (this.avw.isClosed()))
      {
        localFile = this.aHA.aHL;
        if ((this.aHA.aHJ) && (localFile != null)) {
          if (!localFile.exists()) {
            localFile.mkdirs();
          }
        }
      }
      try
      {
        this.avw = a.a(localFile, this.aHA.gj, 1, this.aHA.aHF);
        this.mLog.dl("Disk cache initialized, size=" + this.aHA.aHF / 1024 + "KB");
        this.avy = false;
        this.avx.notifyAll();
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.aHA.aHL = null;
          this.mLog.g("initDiskCache - ", localIOException);
        }
      }
    }
  }
  
  public k Ig()
  {
    return this.aHC;
  }
  
  /* Error */
  public void a(String paramString, BitmapDrawable paramBitmapDrawable)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aload_0
    //   10: getfield 45	com/mobisystems/mobiscanner/image/d:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   13: new 105	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   20: ldc -42
    //   22: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc -40
    //   31: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokestatic 220	com/mobisystems/mobiscanner/common/d:ay	(Ljava/lang/Object;)Ljava/lang/String;
    //   38: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc -34
    //   43: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_2
    //   47: invokestatic 224	com/mobisystems/mobiscanner/image/d:a	(Landroid/graphics/drawable/BitmapDrawable;)I
    //   50: sipush 1024
    //   53: idiv
    //   54: invokevirtual 119	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: ldc 121
    //   59: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokevirtual 129	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   68: aload_0
    //   69: getfield 137	com/mobisystems/mobiscanner/image/d:aHB	Landroid/support/v4/b/e;
    //   72: ifnull +30 -> 102
    //   75: ldc -30
    //   77: aload_2
    //   78: invokevirtual 232	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   81: ifeq +11 -> 92
    //   84: aload_2
    //   85: checkcast 226	com/mobisystems/mobiscanner/image/i
    //   88: iconst_1
    //   89: invokevirtual 236	com/mobisystems/mobiscanner/image/i:bq	(Z)V
    //   92: aload_0
    //   93: getfield 137	com/mobisystems/mobiscanner/image/d:aHB	Landroid/support/v4/b/e;
    //   96: aload_1
    //   97: aload_2
    //   98: invokevirtual 242	android/support/v4/b/e:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   101: pop
    //   102: aload_0
    //   103: getfield 47	com/mobisystems/mobiscanner/image/d:avx	Ljava/lang/Object;
    //   106: astore 4
    //   108: aload 4
    //   110: monitorenter
    //   111: aload_0
    //   112: getfield 167	com/mobisystems/mobiscanner/image/d:avw	Lcom/b/a/a/a/a;
    //   115: ifnull +79 -> 194
    //   118: aload_1
    //   119: invokestatic 246	com/mobisystems/mobiscanner/common/d:dm	(Ljava/lang/String;)Ljava/lang/String;
    //   122: astore_3
    //   123: aconst_null
    //   124: astore_1
    //   125: aload_0
    //   126: getfield 167	com/mobisystems/mobiscanner/image/d:avw	Lcom/b/a/a/a/a;
    //   129: aload_3
    //   130: invokevirtual 250	com/b/a/a/a/a:h	(Ljava/lang/String;)Lcom/b/a/a/a/a$c;
    //   133: astore 5
    //   135: aload 5
    //   137: ifnonnull +67 -> 204
    //   140: aload_0
    //   141: getfield 167	com/mobisystems/mobiscanner/image/d:avw	Lcom/b/a/a/a/a;
    //   144: aload_3
    //   145: invokevirtual 254	com/b/a/a/a/a:j	(Ljava/lang/String;)Lcom/b/a/a/a/a$a;
    //   148: astore_3
    //   149: aload_3
    //   150: ifnull +36 -> 186
    //   153: aload_3
    //   154: iconst_0
    //   155: invokevirtual 260	com/b/a/a/a/a$a:aw	(I)Ljava/io/OutputStream;
    //   158: astore_1
    //   159: aload_2
    //   160: invokevirtual 65	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   163: aload_0
    //   164: getfield 100	com/mobisystems/mobiscanner/image/d:aHA	Lcom/mobisystems/mobiscanner/image/d$a;
    //   167: getfield 264	com/mobisystems/mobiscanner/image/d$a:aHG	Landroid/graphics/Bitmap$CompressFormat;
    //   170: aload_0
    //   171: getfield 100	com/mobisystems/mobiscanner/image/d:aHA	Lcom/mobisystems/mobiscanner/image/d$a;
    //   174: getfield 267	com/mobisystems/mobiscanner/image/d$a:aHH	I
    //   177: aload_1
    //   178: invokevirtual 271	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   181: pop
    //   182: aload_3
    //   183: invokevirtual 274	com/b/a/a/a/a$a:commit	()V
    //   186: aload_1
    //   187: ifnull +7 -> 194
    //   190: aload_1
    //   191: invokevirtual 279	java/io/OutputStream:close	()V
    //   194: aload 4
    //   196: monitorexit
    //   197: return
    //   198: astore_1
    //   199: aload 4
    //   201: monitorexit
    //   202: aload_1
    //   203: athrow
    //   204: aload 5
    //   206: iconst_0
    //   207: invokevirtual 285	com/b/a/a/a/a$c:az	(I)Ljava/io/InputStream;
    //   210: invokevirtual 288	java/io/InputStream:close	()V
    //   213: goto -27 -> 186
    //   216: astore_3
    //   217: aconst_null
    //   218: astore_2
    //   219: aload_2
    //   220: astore_1
    //   221: aload_0
    //   222: getfield 45	com/mobisystems/mobiscanner/image/d:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   225: ldc_w 290
    //   228: aload_3
    //   229: invokevirtual 207	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   232: aload_2
    //   233: ifnull -39 -> 194
    //   236: aload_2
    //   237: invokevirtual 279	java/io/OutputStream:close	()V
    //   240: goto -46 -> 194
    //   243: astore_1
    //   244: goto -50 -> 194
    //   247: astore_3
    //   248: aconst_null
    //   249: astore_2
    //   250: aload_2
    //   251: astore_1
    //   252: aload_0
    //   253: getfield 45	com/mobisystems/mobiscanner/image/d:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   256: ldc_w 290
    //   259: aload_3
    //   260: invokevirtual 207	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   263: aload_2
    //   264: ifnull -70 -> 194
    //   267: aload_2
    //   268: invokevirtual 279	java/io/OutputStream:close	()V
    //   271: goto -77 -> 194
    //   274: astore_2
    //   275: aconst_null
    //   276: astore_1
    //   277: aload_1
    //   278: ifnull +7 -> 285
    //   281: aload_1
    //   282: invokevirtual 279	java/io/OutputStream:close	()V
    //   285: aload_2
    //   286: athrow
    //   287: astore_1
    //   288: goto -3 -> 285
    //   291: astore_2
    //   292: goto -15 -> 277
    //   295: astore_2
    //   296: goto -19 -> 277
    //   299: astore_3
    //   300: aload_1
    //   301: astore_2
    //   302: goto -52 -> 250
    //   305: astore_3
    //   306: aload_1
    //   307: astore_2
    //   308: goto -89 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	d
    //   0	311	1	paramString	String
    //   0	311	2	paramBitmapDrawable	BitmapDrawable
    //   122	61	3	localObject1	Object
    //   216	13	3	localIOException1	IOException
    //   247	13	3	localException1	Exception
    //   299	1	3	localException2	Exception
    //   305	1	3	localIOException2	IOException
    //   106	94	4	localObject2	Object
    //   133	72	5	localc	com.b.a.a.a.a.c
    // Exception table:
    //   from	to	target	type
    //   111	123	198	finally
    //   190	194	198	finally
    //   194	197	198	finally
    //   199	202	198	finally
    //   236	240	198	finally
    //   267	271	198	finally
    //   281	285	198	finally
    //   285	287	198	finally
    //   125	135	216	java/io/IOException
    //   140	149	216	java/io/IOException
    //   153	159	216	java/io/IOException
    //   204	213	216	java/io/IOException
    //   190	194	243	java/io/IOException
    //   236	240	243	java/io/IOException
    //   267	271	243	java/io/IOException
    //   125	135	247	java/lang/Exception
    //   140	149	247	java/lang/Exception
    //   153	159	247	java/lang/Exception
    //   204	213	247	java/lang/Exception
    //   125	135	274	finally
    //   140	149	274	finally
    //   153	159	274	finally
    //   204	213	274	finally
    //   281	285	287	java/io/IOException
    //   159	186	291	finally
    //   221	232	295	finally
    //   252	263	295	finally
    //   159	186	299	java/lang/Exception
    //   159	186	305	java/io/IOException
  }
  
  public void clearCache()
  {
    if (this.aHB != null)
    {
      this.aHB.evictAll();
      this.mLog.dl("Memory cache cleared");
    }
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
    if (this.aHB != null)
    {
      this.aHB.evictAll();
      this.mLog.dl("Memory cache cleared");
    }
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
  
  public BitmapDrawable dO(String paramString)
  {
    BitmapDrawable localBitmapDrawable = null;
    if (this.aHB != null) {
      localBitmapDrawable = (BitmapDrawable)this.aHB.get(paramString);
    }
    if (localBitmapDrawable != null) {
      this.mLog.dl("Memory cache hit for key: " + paramString);
    }
    return localBitmapDrawable;
  }
  
  /* Error */
  public Bitmap dP(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_1
    //   10: invokestatic 246	com/mobisystems/mobiscanner/common/d:dm	(Ljava/lang/String;)Ljava/lang/String;
    //   13: astore 5
    //   15: aload_0
    //   16: getfield 47	com/mobisystems/mobiscanner/image/d:avx	Ljava/lang/Object;
    //   19: astore 9
    //   21: aload 9
    //   23: monitorenter
    //   24: aload_0
    //   25: getfield 49	com/mobisystems/mobiscanner/image/d:avy	Z
    //   28: istore_2
    //   29: iload_2
    //   30: ifeq +17 -> 47
    //   33: aload_0
    //   34: getfield 47	com/mobisystems/mobiscanner/image/d:avx	Ljava/lang/Object;
    //   37: invokevirtual 325	java/lang/Object:wait	()V
    //   40: goto -16 -> 24
    //   43: astore_3
    //   44: goto -20 -> 24
    //   47: aload_0
    //   48: getfield 167	com/mobisystems/mobiscanner/image/d:avw	Lcom/b/a/a/a/a;
    //   51: astore 6
    //   53: aload 7
    //   55: astore_3
    //   56: aload 6
    //   58: ifnull +101 -> 159
    //   61: aload_0
    //   62: getfield 167	com/mobisystems/mobiscanner/image/d:avw	Lcom/b/a/a/a/a;
    //   65: aload 5
    //   67: invokevirtual 250	com/b/a/a/a/a:h	(Ljava/lang/String;)Lcom/b/a/a/a/a$c;
    //   70: astore_3
    //   71: aload_3
    //   72: ifnull +260 -> 332
    //   75: aload_0
    //   76: getfield 45	com/mobisystems/mobiscanner/image/d:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   79: ldc_w 327
    //   82: invokevirtual 129	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   85: aload_3
    //   86: iconst_0
    //   87: invokevirtual 285	com/b/a/a/a/a$c:az	(I)Ljava/io/InputStream;
    //   90: astore_3
    //   91: aload_3
    //   92: astore 5
    //   94: aload_3
    //   95: ifnull +45 -> 140
    //   98: aload_3
    //   99: astore 4
    //   101: new 329	com/mobisystems/mobiscanner/image/Image
    //   104: dup
    //   105: aload_3
    //   106: checkcast 331	java/io/FileInputStream
    //   109: invokevirtual 335	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   112: invokespecial 338	com/mobisystems/mobiscanner/image/Image:<init>	(Ljava/io/FileDescriptor;)V
    //   115: ldc_w 339
    //   118: ldc_w 339
    //   121: aload_0
    //   122: getfield 51	com/mobisystems/mobiscanner/image/d:aHC	Lcom/mobisystems/mobiscanner/image/k;
    //   125: getstatic 345	com/mobisystems/mobiscanner/image/Image$RestrictMemory:aHw	Lcom/mobisystems/mobiscanner/image/Image$RestrictMemory;
    //   128: invokevirtual 348	com/mobisystems/mobiscanner/image/Image:a	(IILcom/mobisystems/mobiscanner/image/k;Lcom/mobisystems/mobiscanner/image/Image$RestrictMemory;)Landroid/graphics/Bitmap;
    //   131: astore 5
    //   133: aload 5
    //   135: astore 4
    //   137: aload_3
    //   138: astore 5
    //   140: aload 4
    //   142: astore_3
    //   143: aload 5
    //   145: ifnull +14 -> 159
    //   148: aload 4
    //   150: astore_3
    //   151: aload 5
    //   153: invokevirtual 288	java/io/InputStream:close	()V
    //   156: aload 4
    //   158: astore_3
    //   159: aload_3
    //   160: ifnull +30 -> 190
    //   163: aload_0
    //   164: getfield 45	com/mobisystems/mobiscanner/image/d:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   167: new 105	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 350
    //   177: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_1
    //   181: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokevirtual 129	com/mobisystems/mobiscanner/common/c:dl	(Ljava/lang/String;)V
    //   190: aload 9
    //   192: monitorexit
    //   193: aload_3
    //   194: areturn
    //   195: astore 6
    //   197: aconst_null
    //   198: astore 5
    //   200: aload 5
    //   202: astore 4
    //   204: aload_0
    //   205: getfield 45	com/mobisystems/mobiscanner/image/d:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   208: ldc_w 352
    //   211: aload 6
    //   213: invokevirtual 207	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   216: aload 7
    //   218: astore_3
    //   219: aload 5
    //   221: ifnull -62 -> 159
    //   224: aload 8
    //   226: astore_3
    //   227: aload 5
    //   229: invokevirtual 288	java/io/InputStream:close	()V
    //   232: aload 7
    //   234: astore_3
    //   235: goto -76 -> 159
    //   238: astore 4
    //   240: goto -81 -> 159
    //   243: astore 6
    //   245: aconst_null
    //   246: astore 5
    //   248: aload 5
    //   250: astore 4
    //   252: aload_0
    //   253: getfield 45	com/mobisystems/mobiscanner/image/d:mLog	Lcom/mobisystems/mobiscanner/common/c;
    //   256: ldc_w 352
    //   259: aload 6
    //   261: invokevirtual 207	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   264: aload 7
    //   266: astore_3
    //   267: aload 5
    //   269: ifnull -110 -> 159
    //   272: aload 8
    //   274: astore_3
    //   275: aload 5
    //   277: invokevirtual 288	java/io/InputStream:close	()V
    //   280: aload 7
    //   282: astore_3
    //   283: goto -124 -> 159
    //   286: astore_1
    //   287: aload 9
    //   289: monitorexit
    //   290: aload_1
    //   291: athrow
    //   292: astore_1
    //   293: aconst_null
    //   294: astore 4
    //   296: aload 4
    //   298: ifnull +8 -> 306
    //   301: aload 4
    //   303: invokevirtual 288	java/io/InputStream:close	()V
    //   306: aload_1
    //   307: athrow
    //   308: astore_3
    //   309: goto -3 -> 306
    //   312: astore_1
    //   313: goto -17 -> 296
    //   316: astore 6
    //   318: aload_3
    //   319: astore 5
    //   321: goto -73 -> 248
    //   324: astore 6
    //   326: aload_3
    //   327: astore 5
    //   329: goto -129 -> 200
    //   332: aconst_null
    //   333: astore 5
    //   335: goto -195 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	this	d
    //   0	338	1	paramString	String
    //   28	2	2	bool	boolean
    //   43	1	3	localInterruptedException	InterruptedException
    //   55	228	3	localObject1	Object
    //   308	19	3	localIOException1	IOException
    //   7	196	4	localObject2	Object
    //   238	1	4	localIOException2	IOException
    //   250	52	4	localObject3	Object
    //   13	321	5	localObject4	Object
    //   51	6	6	locala	a
    //   195	17	6	localImageException1	Image.ImageException
    //   243	17	6	localIOException3	IOException
    //   316	1	6	localIOException4	IOException
    //   324	1	6	localImageException2	Image.ImageException
    //   1	280	7	localObject5	Object
    //   4	269	8	localObject6	Object
    //   19	269	9	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   33	40	43	java/lang/InterruptedException
    //   61	71	195	com/mobisystems/mobiscanner/image/Image$ImageException
    //   75	91	195	com/mobisystems/mobiscanner/image/Image$ImageException
    //   151	156	238	java/io/IOException
    //   227	232	238	java/io/IOException
    //   275	280	238	java/io/IOException
    //   61	71	243	java/io/IOException
    //   75	91	243	java/io/IOException
    //   24	29	286	finally
    //   33	40	286	finally
    //   47	53	286	finally
    //   151	156	286	finally
    //   163	190	286	finally
    //   190	193	286	finally
    //   227	232	286	finally
    //   275	280	286	finally
    //   287	290	286	finally
    //   301	306	286	finally
    //   306	308	286	finally
    //   61	71	292	finally
    //   75	91	292	finally
    //   301	306	308	java/io/IOException
    //   101	133	312	finally
    //   204	216	312	finally
    //   252	264	312	finally
    //   101	133	316	java/io/IOException
    //   101	133	324	com/mobisystems/mobiscanner/image/Image$ImageException
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
  {
    public int aHE = 5120;
    public int aHF = 10485760;
    public Bitmap.CompressFormat aHG = Bitmap.CompressFormat.JPEG;
    public int aHH = 90;
    public boolean aHI = true;
    public boolean aHJ = true;
    public boolean aHK = false;
    public File aHL = null;
    public int gj = 1;
    
    public a(Context paramContext, String paramString)
    {
      try
      {
        this.aHL = com.mobisystems.mobiscanner.common.d.k(paramContext, paramString);
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          try
          {
            this.gj = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
            return;
          }
          catch (PackageManager.NameNotFoundException paramContext)
          {
            d.DJ().A("Exception getting application version: " + paramContext);
          }
          paramString = paramString;
          d.DJ().g("Exception creating disk cache dir", paramString);
        }
      }
      catch (NullPointerException paramString)
      {
        for (;;)
        {
          d.DJ().g("Exception creating disk cache dir", paramString);
        }
      }
    }
    
    public void D(float paramFloat)
    {
      if ((paramFloat < 0.05F) || (paramFloat > 0.8F)) {
        throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.05 and 0.8 (inclusive)");
      }
      this.aHE = Math.round((float)Runtime.getRuntime().maxMemory() * paramFloat / 1024.0F);
    }
  }
  
  public static class b
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/image/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */