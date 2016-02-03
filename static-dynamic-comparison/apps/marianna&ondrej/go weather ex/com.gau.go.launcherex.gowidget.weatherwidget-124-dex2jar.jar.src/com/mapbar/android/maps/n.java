package com.mapbar.android.maps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Vector;

public class n
  extends c<String, Bitmap>
{
  private static String b = n.class.getSimpleName();
  private int c = 0;
  private boolean d = false;
  private boolean e = false;
  private BitmapFactory.Options f = new BitmapFactory.Options();
  private Context g;
  private Vector<String> h = new Vector();
  private ArrayList<b> i = new ArrayList();
  
  public n(File paramFile, d.b paramb, int paramInt)
  {
    super(paramFile, paramb, paramInt);
    this.f.inPreferredConfig = Bitmap.Config.RGB_565;
  }
  
  private Bitmap a(View paramView, Canvas paramCanvas, int paramInt1, int paramInt2, String paramString, int paramInt3, Bitmap paramBitmap)
  {
    int j = this.i.size() - this.c - 1;
    while (j >= 0)
    {
      if (b.a((b)this.i.get(j)).a(true)) {
        this.h.remove(b.b((b)this.i.get(j)));
      }
      this.i.remove(j);
      j -= 1;
    }
    Object localObject;
    if (this.e) {
      localObject = null;
    }
    do
    {
      return (Bitmap)localObject;
      localObject = paramBitmap;
    } while (this.h.indexOf(paramString) >= 0);
    this.h.add(paramString);
    if ((c() != null) && (this.d)) {}
    for (;;)
    {
      try
      {
        localFile = new File(c(), a(paramString));
        if ((localFile.exists()) && (paramInt3 == 1))
        {
          if (!b(paramString))
          {
            if (localFile.length() > 160L)
            {
              localObject = BitmapFactory.decodeFile(localFile.getAbsolutePath(), this.f);
              if (localObject == null) {
                break label549;
              }
              a(paramString, localObject);
              this.h.remove(paramString);
              return (Bitmap)localObject;
            }
            localObject = a.copy(Bitmap.Config.RGB_565, false);
            continue;
          }
          this.h.remove(paramString);
          paramInt3 = 1;
          localObject = paramBitmap;
          if (paramInt3 != 0) {
            break;
          }
          localObject = new a();
          ((a)localObject).b(new Object[] { paramView, paramString, localFile, paramCanvas, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          this.i.add(new b((a)localObject, paramString));
          return paramBitmap;
        }
      }
      catch (OutOfMemoryError paramView)
      {
        File localFile;
        Log.e(b, "OutOfMemoryError loading traffic image....");
        this.h.remove(paramString);
        a();
        return paramBitmap;
        localObject = new a();
        ((a)localObject).b(new Object[] { paramView, paramString, localFile, paramCanvas, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        this.i.add(new b((a)localObject, paramString));
        return paramBitmap;
      }
      catch (Throwable paramView)
      {
        Log.e(b, "Exception loading traffic image", paramView);
        this.h.remove(paramString);
        return paramBitmap;
      }
      localObject = new a();
      ((a)localObject).b(new Object[] { paramView, paramString, null, paramCanvas, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.i.add(new b((a)localObject, paramString));
      return paramBitmap;
      label549:
      paramInt3 = 0;
    }
  }
  
  private static String a(String paramString)
    throws Exception
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer();
      int j = 0;
      while (j < paramString.length)
      {
        ((StringBuffer)localObject).append(Integer.toHexString(paramString[j] & 0xFF));
        j += 1;
      }
      paramString = ((StringBuffer)localObject).toString();
      return paramString;
    }
    finally {}
  }
  
  public final void a(View paramView, Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString, Bitmap paramBitmap)
    throws Exception
  {
    if (!D.a) {}
    for (;;)
    {
      return;
      this.c = paramInt1;
      this.d = paramBoolean;
      paramView = (Bitmap)a(paramView, paramCanvas, paramInt2, paramInt3, paramString, paramBitmap);
      if (paramView != null) {
        try
        {
          if ((!paramView.isRecycled()) && (paramView != a) && (paramView != paramBitmap))
          {
            paramCanvas.drawBitmap(paramView, paramInt2, paramInt3, new Paint());
            return;
          }
        }
        catch (OutOfMemoryError paramView) {}catch (Exception paramView) {}
      }
    }
  }
  
  public final void e()
  {
    int j = this.i.size() - 1;
    while (j >= 0)
    {
      b.a((b)this.i.get(j)).a(true);
      j -= 1;
    }
    a();
  }
  
  /* Error */
  public final void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield 48	com/mapbar/android/maps/n:e	Z
    //   5: aload_0
    //   6: invokevirtual 275	com/mapbar/android/maps/n:e	()V
    //   9: aload_0
    //   10: getfield 54	com/mapbar/android/maps/n:h	Ljava/util/Vector;
    //   13: ifnull +15 -> 28
    //   16: aload_0
    //   17: getfield 54	com/mapbar/android/maps/n:h	Ljava/util/Vector;
    //   20: invokevirtual 278	java/util/Vector:clear	()V
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield 54	com/mapbar/android/maps/n:h	Ljava/util/Vector;
    //   28: aload_0
    //   29: getfield 59	com/mapbar/android/maps/n:i	Ljava/util/ArrayList;
    //   32: ifnull +15 -> 47
    //   35: aload_0
    //   36: getfield 59	com/mapbar/android/maps/n:i	Ljava/util/ArrayList;
    //   39: invokevirtual 279	java/util/ArrayList:clear	()V
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 59	com/mapbar/android/maps/n:i	Ljava/util/ArrayList;
    //   47: aload_0
    //   48: aconst_null
    //   49: putfield 281	com/mapbar/android/maps/n:g	Landroid/content/Context;
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 64	com/mapbar/android/maps/n:f	Landroid/graphics/BitmapFactory$Options;
    //   57: return
    //   58: astore_1
    //   59: aload_1
    //   60: athrow
    //   61: astore_1
    //   62: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	n
    //   58	2	1	localObject	Object
    //   61	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	28	58	finally
    //   28	47	58	finally
    //   47	57	58	finally
    //   0	28	61	java/lang/Exception
    //   28	47	61	java/lang/Exception
    //   47	57	61	java/lang/Exception
  }
  
  class a
    extends I<Object, Void, Void>
  {
    a() {}
    
    /* Error */
    private Void c(Object... paramVarArgs)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_2
      //   2: aload_0
      //   3: getfield 13	com/mapbar/android/maps/n$a:a	Lcom/mapbar/android/maps/n;
      //   6: invokestatic 28	com/mapbar/android/maps/n:a	(Lcom/mapbar/android/maps/n;)Z
      //   9: ifeq +5 -> 14
      //   12: aconst_null
      //   13: areturn
      //   14: aload_1
      //   15: iconst_0
      //   16: aaload
      //   17: checkcast 30	android/view/View
      //   20: astore 5
      //   22: aload_1
      //   23: iconst_1
      //   24: aaload
      //   25: invokevirtual 36	java/lang/Object:toString	()Ljava/lang/String;
      //   28: astore 7
      //   30: aload_1
      //   31: iconst_2
      //   32: aaload
      //   33: checkcast 38	java/io/File
      //   36: astore 8
      //   38: aload_1
      //   39: iconst_3
      //   40: aaload
      //   41: checkcast 40	android/graphics/Canvas
      //   44: astore 6
      //   46: aload_1
      //   47: iconst_4
      //   48: aaload
      //   49: checkcast 42	java/lang/Integer
      //   52: invokevirtual 46	java/lang/Integer:intValue	()I
      //   55: istore_3
      //   56: aload_1
      //   57: iconst_5
      //   58: aaload
      //   59: checkcast 42	java/lang/Integer
      //   62: invokevirtual 46	java/lang/Integer:intValue	()I
      //   65: istore 4
      //   67: new 48	com/mapbar/android/maps/B
      //   70: dup
      //   71: aload_0
      //   72: getfield 13	com/mapbar/android/maps/n$a:a	Lcom/mapbar/android/maps/n;
      //   75: invokestatic 52	com/mapbar/android/maps/n:b	(Lcom/mapbar/android/maps/n;)Landroid/content/Context;
      //   78: iconst_0
      //   79: iconst_1
      //   80: invokespecial 55	com/mapbar/android/maps/B:<init>	(Landroid/content/Context;II)V
      //   83: astore 9
      //   85: aload 9
      //   87: new 57	java/lang/StringBuilder
      //   90: dup
      //   91: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   94: getstatic 64	com/mapbar/android/maps/D:j	Ljava/lang/String;
      //   97: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   100: aload 7
      //   102: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   105: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   108: invokevirtual 72	com/mapbar/android/maps/B:a	(Ljava/lang/String;)V
      //   111: aload 9
      //   113: invokevirtual 75	com/mapbar/android/maps/B:b	()Ljava/lang/Object;
      //   116: astore_1
      //   117: aload_1
      //   118: ifnull +205 -> 323
      //   121: aload_1
      //   122: instanceof 77
      //   125: ifeq +198 -> 323
      //   128: aload_1
      //   129: checkcast 77	[B
      //   132: astore 9
      //   134: aload_0
      //   135: getfield 13	com/mapbar/android/maps/n$a:a	Lcom/mapbar/android/maps/n;
      //   138: aload 7
      //   140: invokevirtual 80	com/mapbar/android/maps/n:b	(Ljava/lang/Object;)Z
      //   143: ifne +323 -> 466
      //   146: aload_1
      //   147: checkcast 77	[B
      //   150: arraylength
      //   151: sipush 160
      //   154: if_icmple +89 -> 243
      //   157: aload 9
      //   159: iconst_0
      //   160: aload 9
      //   162: arraylength
      //   163: aload_0
      //   164: getfield 13	com/mapbar/android/maps/n$a:a	Lcom/mapbar/android/maps/n;
      //   167: invokestatic 83	com/mapbar/android/maps/n:c	(Lcom/mapbar/android/maps/n;)Landroid/graphics/BitmapFactory$Options;
      //   170: invokestatic 89	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   173: astore_1
      //   174: aload_0
      //   175: getfield 13	com/mapbar/android/maps/n$a:a	Lcom/mapbar/android/maps/n;
      //   178: aload 7
      //   180: aload_1
      //   181: invokevirtual 92	com/mapbar/android/maps/n:a	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   184: iload_2
      //   185: ifeq +43 -> 228
      //   188: aload_0
      //   189: getfield 13	com/mapbar/android/maps/n$a:a	Lcom/mapbar/android/maps/n;
      //   192: aload 5
      //   194: aload 6
      //   196: aload_1
      //   197: iload_3
      //   198: iload 4
      //   200: invokestatic 95	com/mapbar/android/maps/n:a	(Lcom/mapbar/android/maps/n;Landroid/view/View;Landroid/graphics/Canvas;Landroid/graphics/Bitmap;II)V
      //   203: aload 8
      //   205: ifnull +23 -> 228
      //   208: new 97	java/io/FileOutputStream
      //   211: dup
      //   212: aload 8
      //   214: invokespecial 100	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   217: astore_1
      //   218: aload_1
      //   219: aload 9
      //   221: invokevirtual 106	java/io/OutputStream:write	([B)V
      //   224: aload_1
      //   225: invokevirtual 109	java/io/OutputStream:close	()V
      //   228: aload_0
      //   229: getfield 13	com/mapbar/android/maps/n$a:a	Lcom/mapbar/android/maps/n;
      //   232: invokestatic 113	com/mapbar/android/maps/n:d	(Lcom/mapbar/android/maps/n;)Ljava/util/Vector;
      //   235: aload 7
      //   237: invokevirtual 118	java/util/Vector:remove	(Ljava/lang/Object;)Z
      //   240: pop
      //   241: aconst_null
      //   242: areturn
      //   243: getstatic 123	com/mapbar/android/maps/c:a	Landroid/graphics/Bitmap;
      //   246: getstatic 129	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
      //   249: iconst_0
      //   250: invokevirtual 135	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
      //   253: astore_1
      //   254: goto -80 -> 174
      //   257: astore_1
      //   258: aconst_null
      //   259: astore_1
      //   260: aload_1
      //   261: ifnull -33 -> 228
      //   264: aload_1
      //   265: invokevirtual 109	java/io/OutputStream:close	()V
      //   268: goto -40 -> 228
      //   271: astore_1
      //   272: goto -44 -> 228
      //   275: astore_1
      //   276: aconst_null
      //   277: astore 5
      //   279: aload 5
      //   281: ifnull +8 -> 289
      //   284: aload 5
      //   286: invokevirtual 109	java/io/OutputStream:close	()V
      //   289: aload_1
      //   290: athrow
      //   291: astore_1
      //   292: invokestatic 138	com/mapbar/android/maps/n:g	()Ljava/lang/String;
      //   295: ldc -116
      //   297: invokestatic 146	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   300: pop
      //   301: aload_0
      //   302: getfield 13	com/mapbar/android/maps/n$a:a	Lcom/mapbar/android/maps/n;
      //   305: invokevirtual 148	com/mapbar/android/maps/n:a	()V
      //   308: aload_0
      //   309: getfield 13	com/mapbar/android/maps/n$a:a	Lcom/mapbar/android/maps/n;
      //   312: invokestatic 113	com/mapbar/android/maps/n:d	(Lcom/mapbar/android/maps/n;)Ljava/util/Vector;
      //   315: aload 7
      //   317: invokevirtual 118	java/util/Vector:remove	(Ljava/lang/Object;)Z
      //   320: pop
      //   321: aconst_null
      //   322: areturn
      //   323: aload 9
      //   325: invokevirtual 150	com/mapbar/android/maps/B:a	()I
      //   328: sipush 200
      //   331: if_icmpeq +14 -> 345
      //   334: aload 9
      //   336: invokevirtual 150	com/mapbar/android/maps/B:a	()I
      //   339: sipush 404
      //   342: if_icmpne -114 -> 228
      //   345: aload_0
      //   346: getfield 13	com/mapbar/android/maps/n$a:a	Lcom/mapbar/android/maps/n;
      //   349: aload 7
      //   351: invokevirtual 80	com/mapbar/android/maps/n:b	(Ljava/lang/Object;)Z
      //   354: ifne +105 -> 459
      //   357: getstatic 123	com/mapbar/android/maps/c:a	Landroid/graphics/Bitmap;
      //   360: getstatic 129	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
      //   363: iconst_0
      //   364: invokevirtual 135	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
      //   367: astore_1
      //   368: aload_0
      //   369: getfield 13	com/mapbar/android/maps/n$a:a	Lcom/mapbar/android/maps/n;
      //   372: aload 7
      //   374: aload_1
      //   375: invokevirtual 92	com/mapbar/android/maps/n:a	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   378: iconst_1
      //   379: istore_2
      //   380: iload_2
      //   381: ifeq -153 -> 228
      //   384: aload_0
      //   385: getfield 13	com/mapbar/android/maps/n$a:a	Lcom/mapbar/android/maps/n;
      //   388: aload 5
      //   390: aload 6
      //   392: aload_1
      //   393: iload_3
      //   394: iload 4
      //   396: invokestatic 95	com/mapbar/android/maps/n:a	(Lcom/mapbar/android/maps/n;Landroid/view/View;Landroid/graphics/Canvas;Landroid/graphics/Bitmap;II)V
      //   399: goto -171 -> 228
      //   402: astore_1
      //   403: aload_0
      //   404: getfield 13	com/mapbar/android/maps/n$a:a	Lcom/mapbar/android/maps/n;
      //   407: invokestatic 113	com/mapbar/android/maps/n:d	(Lcom/mapbar/android/maps/n;)Ljava/util/Vector;
      //   410: aload 7
      //   412: invokevirtual 118	java/util/Vector:remove	(Ljava/lang/Object;)Z
      //   415: pop
      //   416: aconst_null
      //   417: areturn
      //   418: astore_1
      //   419: aload_0
      //   420: getfield 13	com/mapbar/android/maps/n$a:a	Lcom/mapbar/android/maps/n;
      //   423: invokestatic 113	com/mapbar/android/maps/n:d	(Lcom/mapbar/android/maps/n;)Ljava/util/Vector;
      //   426: aload 7
      //   428: invokevirtual 118	java/util/Vector:remove	(Ljava/lang/Object;)Z
      //   431: pop
      //   432: aload_1
      //   433: athrow
      //   434: astore_1
      //   435: goto -207 -> 228
      //   438: astore 5
      //   440: goto -151 -> 289
      //   443: astore 6
      //   445: aload_1
      //   446: astore 5
      //   448: aload 6
      //   450: astore_1
      //   451: goto -172 -> 279
      //   454: astore 5
      //   456: goto -196 -> 260
      //   459: iconst_0
      //   460: istore_2
      //   461: aconst_null
      //   462: astore_1
      //   463: goto -83 -> 380
      //   466: iconst_0
      //   467: istore_2
      //   468: aconst_null
      //   469: astore_1
      //   470: goto -286 -> 184
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	473	0	this	a
      //   0	473	1	paramVarArgs	Object[]
      //   1	467	2	i	int
      //   55	339	3	j	int
      //   65	330	4	k	int
      //   20	369	5	localView	View
      //   438	1	5	localException1	Exception
      //   446	1	5	arrayOfObject	Object[]
      //   454	1	5	localException2	Exception
      //   44	347	6	localCanvas	Canvas
      //   443	6	6	localObject1	Object
      //   28	399	7	str	String
      //   36	177	8	localFile	File
      //   83	252	9	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   208	218	257	java/lang/Exception
      //   264	268	271	java/lang/Exception
      //   208	218	275	finally
      //   67	117	291	java/lang/OutOfMemoryError
      //   121	174	291	java/lang/OutOfMemoryError
      //   174	184	291	java/lang/OutOfMemoryError
      //   188	203	291	java/lang/OutOfMemoryError
      //   224	228	291	java/lang/OutOfMemoryError
      //   243	254	291	java/lang/OutOfMemoryError
      //   264	268	291	java/lang/OutOfMemoryError
      //   284	289	291	java/lang/OutOfMemoryError
      //   289	291	291	java/lang/OutOfMemoryError
      //   323	345	291	java/lang/OutOfMemoryError
      //   345	378	291	java/lang/OutOfMemoryError
      //   384	399	291	java/lang/OutOfMemoryError
      //   67	117	402	java/lang/Throwable
      //   121	174	402	java/lang/Throwable
      //   174	184	402	java/lang/Throwable
      //   188	203	402	java/lang/Throwable
      //   224	228	402	java/lang/Throwable
      //   243	254	402	java/lang/Throwable
      //   264	268	402	java/lang/Throwable
      //   284	289	402	java/lang/Throwable
      //   289	291	402	java/lang/Throwable
      //   323	345	402	java/lang/Throwable
      //   345	378	402	java/lang/Throwable
      //   384	399	402	java/lang/Throwable
      //   67	117	418	finally
      //   121	174	418	finally
      //   174	184	418	finally
      //   188	203	418	finally
      //   224	228	418	finally
      //   243	254	418	finally
      //   264	268	418	finally
      //   284	289	418	finally
      //   289	291	418	finally
      //   292	308	418	finally
      //   323	345	418	finally
      //   345	378	418	finally
      //   384	399	418	finally
      //   224	228	434	java/lang/Exception
      //   284	289	438	java/lang/Exception
      //   218	224	443	finally
      //   218	224	454	java/lang/Exception
    }
    
    protected final void a() {}
  }
  
  class b
  {
    private n.a a = null;
    private String b = null;
    
    public b(n.a parama, String paramString)
    {
      this.a = parama;
      this.b = paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */