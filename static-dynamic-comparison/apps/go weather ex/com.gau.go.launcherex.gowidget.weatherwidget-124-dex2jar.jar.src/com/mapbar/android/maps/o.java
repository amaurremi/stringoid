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

public class o
  extends c<String, Bitmap>
{
  private static String b = "WebImageCache";
  private Context c;
  private int d = 0;
  private boolean e = false;
  private boolean f = false;
  private BitmapFactory.Options g = new BitmapFactory.Options();
  private Vector<String> h = new Vector();
  private ArrayList<c> i = new ArrayList();
  
  public o(File paramFile, d.b paramb, int paramInt)
  {
    super(paramFile, paramb, paramInt);
    this.g.inPreferredConfig = Bitmap.Config.RGB_565;
  }
  
  private Bitmap a(View paramView, Canvas paramCanvas, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, q paramq, Bitmap paramBitmap)
  {
    int j = this.i.size() - this.d - 1;
    while (j >= 0)
    {
      if (c.a((c)this.i.get(j)).a(true)) {
        this.h.remove(c.b((c)this.i.get(j)));
      }
      this.i.remove(j);
      j -= 1;
    }
    Bitmap localBitmap;
    if (this.f) {
      localBitmap = null;
    }
    do
    {
      return localBitmap;
      localBitmap = paramBitmap;
    } while (this.h.indexOf(paramString) >= 0);
    this.h.add(paramString);
    if ((c() != null) && (this.e)) {}
    for (;;)
    {
      try
      {
        localFile = new File(c(), a(paramString));
        if ((localFile.exists()) && (paramInt3 == 1))
        {
          if (!b(paramString))
          {
            localBitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath(), this.g);
            if (localBitmap == null) {
              break label611;
            }
            a(paramString, localBitmap);
            this.h.remove(paramString);
            return localBitmap;
          }
          paramInt3 = 1;
          this.h.remove(paramString);
          localBitmap = paramBitmap;
          if (paramInt3 != 0) {
            break;
          }
          localBitmap = paramBitmap;
          if (a(paramView, paramCanvas, paramInt1, paramInt2, paramInt4, paramInt5, paramInt6, paramString, localFile, paramBoolean, paramq)) {
            break;
          }
          paramq = new a();
          paramq.b(new Object[] { paramView, paramString, localFile, paramCanvas, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          this.i.add(new c(paramq, paramString));
          return paramBitmap;
        }
      }
      catch (OutOfMemoryError paramView)
      {
        File localFile;
        Log.e(b, "OutOfMemoryError loading image....");
        this.h.remove(paramString);
        a();
        return paramBitmap;
        localBitmap = paramBitmap;
        if (a(paramView, paramCanvas, paramInt1, paramInt2, paramInt4, paramInt5, paramInt6, paramString, localFile, paramBoolean, paramq)) {
          break;
        }
        paramq = new a();
        paramq.b(new Object[] { paramView, paramString, localFile, paramCanvas, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        this.i.add(new c(paramq, paramString));
        return paramBitmap;
      }
      catch (Throwable paramView)
      {
        Log.e(b, "Exception loading image", paramView);
        this.h.remove(paramString);
        return paramBitmap;
      }
      localBitmap = paramBitmap;
      if (a(paramView, paramCanvas, paramInt1, paramInt2, paramInt4, paramInt5, paramInt6, paramString, null, paramBoolean, paramq)) {
        break;
      }
      paramq = new a();
      paramq.b(new Object[] { paramView, paramString, null, paramCanvas, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.i.add(new c(paramq, paramString));
      return paramBitmap;
      label611:
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
  
  private boolean a(View paramView, Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString, File paramFile, boolean paramBoolean, q paramq)
  {
    boolean bool;
    if (!paramBoolean)
    {
      bool = false;
      return bool;
    }
    if (paramq == null)
    {
      this.h.remove(paramString);
      return true;
    }
    int j = paramInt3;
    if (paramInt3 < 0) {
      j = paramInt3 + 360;
    }
    paramInt3 = paramInt4;
    if (paramInt4 < 0) {
      paramInt3 = paramInt4 + 360;
    }
    paramInt4 = paramq.a(j, paramInt3, paramInt5);
    if (paramInt4 != -1) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      bool = paramBoolean;
      if (!paramBoolean) {
        break;
      }
      new b().b(new Object[] { paramView, paramString, paramFile, Integer.valueOf(j), Integer.valueOf(paramInt3), Integer.valueOf(paramInt5), paramq, Integer.valueOf(paramInt4), paramCanvas, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return paramBoolean;
    }
  }
  
  public final void a(View paramView, Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean2, q paramq, Bitmap paramBitmap)
    throws Exception
  {
    if (!D.a) {
      paramCanvas.drawBitmap(paramBitmap, paramInt2, paramInt3, new Paint());
    }
    for (;;)
    {
      return;
      this.d = paramInt1;
      this.e = true;
      paramView = (Bitmap)a(paramView, paramCanvas, paramInt2, paramInt3, paramString, paramInt4, paramInt5, paramInt6, paramBoolean2, paramq, paramBitmap);
      if (paramView != null) {
        try
        {
          if (!paramView.isRecycled())
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
      c.a((c)this.i.get(j)).a(true);
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
    //   2: putfield 46	com/mapbar/android/maps/o:f	Z
    //   5: aload_0
    //   6: invokevirtual 276	com/mapbar/android/maps/o:e	()V
    //   9: aload_0
    //   10: getfield 52	com/mapbar/android/maps/o:h	Ljava/util/Vector;
    //   13: ifnull +15 -> 28
    //   16: aload_0
    //   17: getfield 52	com/mapbar/android/maps/o:h	Ljava/util/Vector;
    //   20: invokevirtual 279	java/util/Vector:clear	()V
    //   23: aload_0
    //   24: aconst_null
    //   25: putfield 52	com/mapbar/android/maps/o:h	Ljava/util/Vector;
    //   28: aload_0
    //   29: getfield 57	com/mapbar/android/maps/o:i	Ljava/util/ArrayList;
    //   32: ifnull +15 -> 47
    //   35: aload_0
    //   36: getfield 57	com/mapbar/android/maps/o:i	Ljava/util/ArrayList;
    //   39: invokevirtual 280	java/util/ArrayList:clear	()V
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 57	com/mapbar/android/maps/o:i	Ljava/util/ArrayList;
    //   47: aload_0
    //   48: aconst_null
    //   49: putfield 282	com/mapbar/android/maps/o:c	Landroid/content/Context;
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 62	com/mapbar/android/maps/o:g	Landroid/graphics/BitmapFactory$Options;
    //   57: return
    //   58: astore_1
    //   59: aload_1
    //   60: athrow
    //   61: astore_1
    //   62: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	o
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
      //   0: iconst_0
      //   1: istore_2
      //   2: aload_0
      //   3: getfield 13	com/mapbar/android/maps/o$a:a	Lcom/mapbar/android/maps/o;
      //   6: invokestatic 28	com/mapbar/android/maps/o:a	(Lcom/mapbar/android/maps/o;)Z
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
      //   72: getfield 13	com/mapbar/android/maps/o$a:a	Lcom/mapbar/android/maps/o;
      //   75: invokestatic 52	com/mapbar/android/maps/o:b	(Lcom/mapbar/android/maps/o;)Landroid/content/Context;
      //   78: iconst_0
      //   79: iconst_1
      //   80: invokespecial 55	com/mapbar/android/maps/B:<init>	(Landroid/content/Context;II)V
      //   83: astore_1
      //   84: aload_1
      //   85: new 57	java/lang/StringBuilder
      //   88: dup
      //   89: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   92: getstatic 64	com/mapbar/android/maps/D:i	Ljava/lang/String;
      //   95: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   98: aload 7
      //   100: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   103: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   106: invokevirtual 72	com/mapbar/android/maps/B:a	(Ljava/lang/String;)V
      //   109: aload_1
      //   110: invokevirtual 75	com/mapbar/android/maps/B:b	()Ljava/lang/Object;
      //   113: astore 9
      //   115: aload 9
      //   117: ifnull +214 -> 331
      //   120: aload 9
      //   122: instanceof 77
      //   125: ifeq +206 -> 331
      //   128: invokestatic 80	com/mapbar/android/maps/o:g	()Ljava/lang/String;
      //   131: new 57	java/lang/StringBuilder
      //   134: dup
      //   135: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   138: ldc 82
      //   140: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   143: aload 7
      //   145: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   148: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   151: invokestatic 87	com/mapbar/android/maps/E:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   154: aload 9
      //   156: checkcast 77	[B
      //   159: astore 9
      //   161: aload_0
      //   162: getfield 13	com/mapbar/android/maps/o$a:a	Lcom/mapbar/android/maps/o;
      //   165: aload 7
      //   167: invokevirtual 90	com/mapbar/android/maps/o:b	(Ljava/lang/Object;)Z
      //   170: ifne +314 -> 484
      //   173: aload 9
      //   175: iconst_0
      //   176: aload 9
      //   178: arraylength
      //   179: aload_0
      //   180: getfield 13	com/mapbar/android/maps/o$a:a	Lcom/mapbar/android/maps/o;
      //   183: invokestatic 93	com/mapbar/android/maps/o:c	(Lcom/mapbar/android/maps/o;)Landroid/graphics/BitmapFactory$Options;
      //   186: invokestatic 99	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   189: astore_1
      //   190: aload_1
      //   191: ifnull +290 -> 481
      //   194: aload_0
      //   195: getfield 13	com/mapbar/android/maps/o$a:a	Lcom/mapbar/android/maps/o;
      //   198: aload 7
      //   200: aload_1
      //   201: invokevirtual 102	com/mapbar/android/maps/o:a	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   204: iconst_1
      //   205: istore_2
      //   206: iload_2
      //   207: ifeq +43 -> 250
      //   210: aload_0
      //   211: getfield 13	com/mapbar/android/maps/o$a:a	Lcom/mapbar/android/maps/o;
      //   214: aload 5
      //   216: aload 6
      //   218: aload_1
      //   219: iload_3
      //   220: iload 4
      //   222: invokestatic 105	com/mapbar/android/maps/o:a	(Lcom/mapbar/android/maps/o;Landroid/view/View;Landroid/graphics/Canvas;Landroid/graphics/Bitmap;II)V
      //   225: aload 8
      //   227: ifnull +23 -> 250
      //   230: new 107	java/io/FileOutputStream
      //   233: dup
      //   234: aload 8
      //   236: invokespecial 110	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   239: astore_1
      //   240: aload_1
      //   241: aload 9
      //   243: invokevirtual 116	java/io/OutputStream:write	([B)V
      //   246: aload_1
      //   247: invokevirtual 119	java/io/OutputStream:close	()V
      //   250: aload_0
      //   251: getfield 13	com/mapbar/android/maps/o$a:a	Lcom/mapbar/android/maps/o;
      //   254: invokestatic 123	com/mapbar/android/maps/o:d	(Lcom/mapbar/android/maps/o;)Ljava/util/Vector;
      //   257: aload 7
      //   259: invokevirtual 128	java/util/Vector:remove	(Ljava/lang/Object;)Z
      //   262: pop
      //   263: aconst_null
      //   264: areturn
      //   265: astore_1
      //   266: aconst_null
      //   267: astore_1
      //   268: aload_1
      //   269: ifnull -19 -> 250
      //   272: aload_1
      //   273: invokevirtual 119	java/io/OutputStream:close	()V
      //   276: goto -26 -> 250
      //   279: astore_1
      //   280: goto -30 -> 250
      //   283: astore_1
      //   284: aconst_null
      //   285: astore 5
      //   287: aload 5
      //   289: ifnull +8 -> 297
      //   292: aload 5
      //   294: invokevirtual 119	java/io/OutputStream:close	()V
      //   297: aload_1
      //   298: athrow
      //   299: astore_1
      //   300: invokestatic 80	com/mapbar/android/maps/o:g	()Ljava/lang/String;
      //   303: ldc -126
      //   305: invokestatic 136	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   308: pop
      //   309: aload_0
      //   310: getfield 13	com/mapbar/android/maps/o$a:a	Lcom/mapbar/android/maps/o;
      //   313: invokevirtual 138	com/mapbar/android/maps/o:a	()V
      //   316: aload_0
      //   317: getfield 13	com/mapbar/android/maps/o$a:a	Lcom/mapbar/android/maps/o;
      //   320: invokestatic 123	com/mapbar/android/maps/o:d	(Lcom/mapbar/android/maps/o;)Ljava/util/Vector;
      //   323: aload 7
      //   325: invokevirtual 128	java/util/Vector:remove	(Ljava/lang/Object;)Z
      //   328: pop
      //   329: aconst_null
      //   330: areturn
      //   331: aload_1
      //   332: invokevirtual 140	com/mapbar/android/maps/B:a	()I
      //   335: sipush 200
      //   338: if_icmpeq +13 -> 351
      //   341: aload_1
      //   342: invokevirtual 140	com/mapbar/android/maps/B:a	()I
      //   345: sipush 404
      //   348: if_icmpne -98 -> 250
      //   351: aload_0
      //   352: getfield 13	com/mapbar/android/maps/o$a:a	Lcom/mapbar/android/maps/o;
      //   355: aload 7
      //   357: invokevirtual 90	com/mapbar/android/maps/o:b	(Ljava/lang/Object;)Z
      //   360: ifne +114 -> 474
      //   363: getstatic 145	com/mapbar/android/maps/c:a	Landroid/graphics/Bitmap;
      //   366: getstatic 151	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
      //   369: iconst_0
      //   370: invokevirtual 157	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
      //   373: astore_1
      //   374: aload_1
      //   375: ifnull +94 -> 469
      //   378: aload_0
      //   379: getfield 13	com/mapbar/android/maps/o$a:a	Lcom/mapbar/android/maps/o;
      //   382: aload 7
      //   384: aload_1
      //   385: invokevirtual 102	com/mapbar/android/maps/o:a	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   388: iconst_1
      //   389: istore_2
      //   390: iload_2
      //   391: ifeq -141 -> 250
      //   394: aload_0
      //   395: getfield 13	com/mapbar/android/maps/o$a:a	Lcom/mapbar/android/maps/o;
      //   398: aload 5
      //   400: aload 6
      //   402: aload_1
      //   403: iload_3
      //   404: iload 4
      //   406: invokestatic 105	com/mapbar/android/maps/o:a	(Lcom/mapbar/android/maps/o;Landroid/view/View;Landroid/graphics/Canvas;Landroid/graphics/Bitmap;II)V
      //   409: goto -159 -> 250
      //   412: astore_1
      //   413: aload_0
      //   414: getfield 13	com/mapbar/android/maps/o$a:a	Lcom/mapbar/android/maps/o;
      //   417: invokestatic 123	com/mapbar/android/maps/o:d	(Lcom/mapbar/android/maps/o;)Ljava/util/Vector;
      //   420: aload 7
      //   422: invokevirtual 128	java/util/Vector:remove	(Ljava/lang/Object;)Z
      //   425: pop
      //   426: aconst_null
      //   427: areturn
      //   428: astore_1
      //   429: aload_0
      //   430: getfield 13	com/mapbar/android/maps/o$a:a	Lcom/mapbar/android/maps/o;
      //   433: invokestatic 123	com/mapbar/android/maps/o:d	(Lcom/mapbar/android/maps/o;)Ljava/util/Vector;
      //   436: aload 7
      //   438: invokevirtual 128	java/util/Vector:remove	(Ljava/lang/Object;)Z
      //   441: pop
      //   442: aload_1
      //   443: athrow
      //   444: astore_1
      //   445: goto -195 -> 250
      //   448: astore 5
      //   450: goto -153 -> 297
      //   453: astore 6
      //   455: aload_1
      //   456: astore 5
      //   458: aload 6
      //   460: astore_1
      //   461: goto -174 -> 287
      //   464: astore 5
      //   466: goto -198 -> 268
      //   469: iconst_0
      //   470: istore_2
      //   471: goto -81 -> 390
      //   474: iconst_0
      //   475: istore_2
      //   476: aconst_null
      //   477: astore_1
      //   478: goto -88 -> 390
      //   481: goto -275 -> 206
      //   484: aconst_null
      //   485: astore_1
      //   486: goto -280 -> 206
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	489	0	this	a
      //   0	489	1	paramVarArgs	Object[]
      //   1	475	2	i	int
      //   55	349	3	j	int
      //   65	340	4	k	int
      //   20	379	5	localView	View
      //   448	1	5	localException1	Exception
      //   456	1	5	arrayOfObject	Object[]
      //   464	1	5	localException2	Exception
      //   44	357	6	localCanvas	Canvas
      //   453	6	6	localObject1	Object
      //   28	409	7	str	String
      //   36	199	8	localFile	File
      //   113	129	9	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   230	240	265	java/lang/Exception
      //   272	276	279	java/lang/Exception
      //   230	240	283	finally
      //   67	115	299	java/lang/OutOfMemoryError
      //   120	190	299	java/lang/OutOfMemoryError
      //   194	204	299	java/lang/OutOfMemoryError
      //   210	225	299	java/lang/OutOfMemoryError
      //   246	250	299	java/lang/OutOfMemoryError
      //   272	276	299	java/lang/OutOfMemoryError
      //   292	297	299	java/lang/OutOfMemoryError
      //   297	299	299	java/lang/OutOfMemoryError
      //   331	351	299	java/lang/OutOfMemoryError
      //   351	374	299	java/lang/OutOfMemoryError
      //   378	388	299	java/lang/OutOfMemoryError
      //   394	409	299	java/lang/OutOfMemoryError
      //   67	115	412	java/lang/Throwable
      //   120	190	412	java/lang/Throwable
      //   194	204	412	java/lang/Throwable
      //   210	225	412	java/lang/Throwable
      //   246	250	412	java/lang/Throwable
      //   272	276	412	java/lang/Throwable
      //   292	297	412	java/lang/Throwable
      //   297	299	412	java/lang/Throwable
      //   331	351	412	java/lang/Throwable
      //   351	374	412	java/lang/Throwable
      //   378	388	412	java/lang/Throwable
      //   394	409	412	java/lang/Throwable
      //   67	115	428	finally
      //   120	190	428	finally
      //   194	204	428	finally
      //   210	225	428	finally
      //   246	250	428	finally
      //   272	276	428	finally
      //   292	297	428	finally
      //   297	299	428	finally
      //   300	316	428	finally
      //   331	351	428	finally
      //   351	374	428	finally
      //   378	388	428	finally
      //   394	409	428	finally
      //   246	250	444	java/lang/Exception
      //   292	297	448	java/lang/Exception
      //   240	246	453	finally
      //   240	246	464	java/lang/Exception
    }
    
    protected final void a() {}
  }
  
  class b
    extends K<Object, Void, Void>
  {
    b() {}
    
    private Void c(Object... paramVarArgs)
    {
      if (o.a(o.this)) {
        return null;
      }
      View localView = (View)paramVarArgs[0];
      String str = paramVarArgs[1].toString();
      File localFile = (File)paramVarArgs[2];
      int i = ((Integer)paramVarArgs[3]).intValue();
      int j = ((Integer)paramVarArgs[4]).intValue();
      int k = ((Integer)paramVarArgs[5]).intValue();
      q localq = (q)paramVarArgs[6];
      int m = ((Integer)paramVarArgs[7]).intValue();
      Canvas localCanvas = (Canvas)paramVarArgs[8];
      int n = ((Integer)paramVarArgs[9]).intValue();
      int i1 = ((Integer)paramVarArgs[10]).intValue();
      byte[] arrayOfByte = localq.a(i, j, k, m);
      if (!o.this.b(str))
      {
        localq = null;
        paramVarArgs = localq;
        if (arrayOfByte == null) {}
      }
      try
      {
        paramVarArgs = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, o.c(o.this));
        E.a(o.g(), "Load local data, " + str);
        if (paramVarArgs != null)
        {
          o.this.a(str, paramVarArgs);
          o.a(o.this, localView, localCanvas, paramVarArgs, n, i1);
          o.d(o.this).remove(str);
          return null;
        }
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        for (;;)
        {
          Log.e(o.g(), "OutOfMemoryError LocalDataLoader....");
          o.this.a();
          paramVarArgs = localq;
          continue;
          paramVarArgs = new o.a(o.this);
          paramVarArgs.b(new Object[] { localView, str, localFile, localCanvas, Integer.valueOf(n), Integer.valueOf(i1) });
          o.e(o.this).add(new o.c(o.this, paramVarArgs, str));
        }
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          paramVarArgs = localq;
        }
      }
    }
  }
  
  class c
  {
    private I<Object, Void, Void> a = null;
    private String b = null;
    
    public c(String paramString)
    {
      this.a = paramString;
      String str;
      this.b = str;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */