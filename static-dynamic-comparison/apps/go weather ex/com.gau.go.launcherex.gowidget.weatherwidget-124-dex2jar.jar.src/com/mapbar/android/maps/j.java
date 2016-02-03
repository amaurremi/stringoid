package com.mapbar.android.maps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Vector;

public class j
  extends g<String, k>
  implements f
{
  private static String b = j.class.getSimpleName();
  private int c = 0;
  private boolean d = false;
  private boolean e = false;
  private BitmapFactory.Options f;
  private Context g;
  private Drawable h;
  private Vector<String> i = new Vector();
  private ArrayList<b> j = new ArrayList();
  
  public j(Context paramContext, File paramFile, h.b paramb, int paramInt, Drawable paramDrawable)
  {
    super(paramFile, paramb, paramInt);
    this.g = paramContext;
    this.f = new BitmapFactory.Options();
    this.f.inPreferredConfig = Bitmap.Config.RGB_565;
    this.h = paramDrawable;
  }
  
  private k a(View paramView, Canvas paramCanvas, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    int k = this.j.size() - this.c - 1;
    while (k >= 0)
    {
      if (b.a((b)this.j.get(k)).a(true)) {
        this.i.remove(b.b((b)this.j.get(k)));
      }
      this.j.remove(k);
      k -= 1;
    }
    if (this.e) {
      localObject2 = null;
    }
    Object localObject5;
    File localFile;
    for (;;)
    {
      return (k)localObject2;
      localObject1 = null;
      Object localObject6 = null;
      localObject5 = null;
      localObject2 = null;
      if (this.i.indexOf(paramString) < 0)
      {
        this.i.add(paramString);
        if ((b() == null) || (!this.d)) {
          break label629;
        }
        localObject3 = localObject1;
        localObject4 = localObject5;
        try
        {
          localFile = new File(b(), a(paramString));
          localObject3 = localObject1;
          localObject4 = localObject5;
          if ((localFile.exists()) && (paramInt3 == 1))
          {
            paramInt3 = 0;
            localObject3 = localObject1;
            localObject4 = localObject5;
            if (!b(paramString))
            {
              localObject3 = localObject1;
              localObject4 = localObject5;
              if (localFile.length() > 10L)
              {
                localObject3 = localObject1;
                localObject4 = localObject5;
                localObject2 = m.a(m.a(localFile.getPath()));
                localObject3 = localObject2;
                localObject4 = localObject2;
                ((k)localObject2).a(this.h);
                localObject1 = localObject2;
                if (localObject2 == null) {
                  break label395;
                }
                localObject3 = localObject2;
                localObject4 = localObject2;
                a(paramString, localObject2);
                localObject3 = localObject2;
                localObject4 = localObject2;
                this.i.remove(paramString);
                return (k)localObject2;
              }
            }
          }
        }
        catch (OutOfMemoryError paramView)
        {
          for (;;)
          {
            Log.e(b, "OutOfMemoryError loading traffic image....");
            this.i.remove(paramString);
            a();
            return (k)localObject3;
            localObject3 = localObject1;
            localObject4 = localObject5;
            localObject2 = new k("", "", null);
          }
          paramInt3 = 1;
          localObject3 = localObject1;
          localObject4 = localObject5;
          this.i.remove(paramString);
          localObject1 = localObject6;
          localObject2 = localObject1;
          if (paramInt3 == 0)
          {
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject2 = new a();
            localObject3 = localObject1;
            localObject4 = localObject1;
            ((a)localObject2).b(new Object[] { paramView, paramString, localFile, paramCanvas, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
            localObject3 = localObject1;
            localObject4 = localObject1;
            this.j.add(new b((a)localObject2, paramString));
            return (k)localObject1;
          }
        }
        catch (Throwable paramView)
        {
          label395:
          Log.e(b, "Exception loading traffic image", paramView);
          this.i.remove(paramString);
          return (k)localObject4;
        }
      }
    }
    Object localObject3 = localObject1;
    Object localObject4 = localObject5;
    Object localObject2 = new a();
    localObject3 = localObject1;
    localObject4 = localObject5;
    ((a)localObject2).b(new Object[] { paramView, paramString, localFile, paramCanvas, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    localObject3 = localObject1;
    localObject4 = localObject5;
    this.j.add(new b((a)localObject2, paramString));
    return null;
    label629:
    Object localObject1 = new a();
    ((a)localObject1).b(new Object[] { paramView, paramString, null, paramCanvas, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.j.add(new b((a)localObject1, paramString));
    return null;
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
      int k = 0;
      while (k < paramString.length)
      {
        ((StringBuffer)localObject).append(Integer.toHexString(paramString[k] & 0xFF));
        k += 1;
      }
      paramString = ((StringBuffer)localObject).toString();
      return paramString;
    }
    finally {}
  }
  
  public final void a(View paramView, Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString, Bitmap paramBitmap)
    throws Exception
  {
    paramBitmap = null;
    if (!D.a) {}
    for (;;)
    {
      return;
      this.c = paramInt1;
      this.d = true;
      paramString = (k)a(paramView, paramCanvas, paramInt2, paramInt3, paramString, null);
      paramView = paramBitmap;
      if (paramString != null) {
        paramView = paramString.b();
      }
      if (paramView != null) {
        try
        {
          if ((!paramView.isRecycled()) && (paramView != a) && (paramView != null))
          {
            paramCanvas.drawBitmap(paramView, paramInt2, paramInt3, null);
            return;
          }
        }
        catch (OutOfMemoryError paramView) {}catch (Exception paramView) {}
      }
    }
  }
  
  /* Error */
  public void destory()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield 53	com/mapbar/android/maps/j:e	Z
    //   5: aload_0
    //   6: getfield 64	com/mapbar/android/maps/j:j	Ljava/util/ArrayList;
    //   9: invokevirtual 91	java/util/ArrayList:size	()I
    //   12: iconst_1
    //   13: isub
    //   14: istore_1
    //   15: iload_1
    //   16: iflt +29 -> 45
    //   19: aload_0
    //   20: getfield 64	com/mapbar/android/maps/j:j	Ljava/util/ArrayList;
    //   23: iload_1
    //   24: invokevirtual 95	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   27: checkcast 12	com/mapbar/android/maps/j$b
    //   30: invokestatic 98	com/mapbar/android/maps/j$b:a	(Lcom/mapbar/android/maps/j$b;)Lcom/mapbar/android/maps/j$a;
    //   33: iconst_1
    //   34: invokevirtual 101	com/mapbar/android/maps/j$a:a	(Z)Z
    //   37: pop
    //   38: iload_1
    //   39: iconst_1
    //   40: isub
    //   41: istore_1
    //   42: goto -27 -> 15
    //   45: aload_0
    //   46: invokevirtual 168	com/mapbar/android/maps/j:a	()V
    //   49: aload_0
    //   50: getfield 59	com/mapbar/android/maps/j:i	Ljava/util/Vector;
    //   53: ifnull +15 -> 68
    //   56: aload_0
    //   57: getfield 59	com/mapbar/android/maps/j:i	Ljava/util/Vector;
    //   60: invokevirtual 300	java/util/Vector:clear	()V
    //   63: aload_0
    //   64: aconst_null
    //   65: putfield 59	com/mapbar/android/maps/j:i	Ljava/util/Vector;
    //   68: aload_0
    //   69: getfield 64	com/mapbar/android/maps/j:j	Ljava/util/ArrayList;
    //   72: ifnull +15 -> 87
    //   75: aload_0
    //   76: getfield 64	com/mapbar/android/maps/j:j	Ljava/util/ArrayList;
    //   79: invokevirtual 301	java/util/ArrayList:clear	()V
    //   82: aload_0
    //   83: aconst_null
    //   84: putfield 64	com/mapbar/android/maps/j:j	Ljava/util/ArrayList;
    //   87: aload_0
    //   88: aconst_null
    //   89: putfield 66	com/mapbar/android/maps/j:g	Landroid/content/Context;
    //   92: aload_0
    //   93: aconst_null
    //   94: putfield 71	com/mapbar/android/maps/j:f	Landroid/graphics/BitmapFactory$Options;
    //   97: return
    //   98: astore_2
    //   99: aload_2
    //   100: athrow
    //   101: astore_2
    //   102: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	j
    //   14	28	1	k	int
    //   98	2	2	localObject	Object
    //   101	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	15	98	finally
    //   19	38	98	finally
    //   45	68	98	finally
    //   68	87	98	finally
    //   87	97	98	finally
    //   0	15	101	java/lang/Exception
    //   19	38	101	java/lang/Exception
    //   45	68	101	java/lang/Exception
    //   68	87	101	java/lang/Exception
    //   87	97	101	java/lang/Exception
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
      //   3: getfield 13	com/mapbar/android/maps/j$a:a	Lcom/mapbar/android/maps/j;
      //   6: invokestatic 28	com/mapbar/android/maps/j:a	(Lcom/mapbar/android/maps/j;)Z
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
      //   72: getfield 13	com/mapbar/android/maps/j$a:a	Lcom/mapbar/android/maps/j;
      //   75: invokestatic 52	com/mapbar/android/maps/j:b	(Lcom/mapbar/android/maps/j;)Landroid/content/Context;
      //   78: iconst_0
      //   79: iconst_1
      //   80: invokespecial 55	com/mapbar/android/maps/B:<init>	(Landroid/content/Context;II)V
      //   83: astore 9
      //   85: aload 9
      //   87: new 57	java/lang/StringBuilder
      //   90: dup
      //   91: invokespecial 58	java/lang/StringBuilder:<init>	()V
      //   94: getstatic 64	com/mapbar/android/maps/D:l	Ljava/lang/String;
      //   97: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   100: getstatic 71	com/mapbar/android/maps/D:m	Ljava/lang/String;
      //   103: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   106: aload 7
      //   108: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   111: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   114: invokevirtual 75	com/mapbar/android/maps/B:a	(Ljava/lang/String;)V
      //   117: aload 9
      //   119: invokevirtual 78	com/mapbar/android/maps/B:b	()Ljava/lang/Object;
      //   122: astore_1
      //   123: aload_1
      //   124: ifnull +222 -> 346
      //   127: aload_1
      //   128: instanceof 80
      //   131: ifeq +215 -> 346
      //   134: aload_1
      //   135: checkcast 80	[B
      //   138: astore 9
      //   140: aload_0
      //   141: getfield 13	com/mapbar/android/maps/j$a:a	Lcom/mapbar/android/maps/j;
      //   144: aload 7
      //   146: invokevirtual 83	com/mapbar/android/maps/j:b	(Ljava/lang/Object;)Z
      //   149: ifne +326 -> 475
      //   152: aload_1
      //   153: checkcast 80	[B
      //   156: arraylength
      //   157: bipush 10
      //   159: if_icmple +89 -> 248
      //   162: aload 9
      //   164: invokestatic 88	com/mapbar/android/maps/m:a	([B)Lcom/mapbar/android/maps/k;
      //   167: astore_1
      //   168: aload_1
      //   169: aload_0
      //   170: getfield 13	com/mapbar/android/maps/j$a:a	Lcom/mapbar/android/maps/j;
      //   173: invokestatic 91	com/mapbar/android/maps/j:c	(Lcom/mapbar/android/maps/j;)Landroid/graphics/drawable/Drawable;
      //   176: invokevirtual 96	com/mapbar/android/maps/k:a	(Landroid/graphics/drawable/Drawable;)V
      //   179: aload_0
      //   180: getfield 13	com/mapbar/android/maps/j$a:a	Lcom/mapbar/android/maps/j;
      //   183: aload 7
      //   185: aload_1
      //   186: invokevirtual 99	com/mapbar/android/maps/j:a	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   189: iload_2
      //   190: ifeq +43 -> 233
      //   193: aload_0
      //   194: getfield 13	com/mapbar/android/maps/j$a:a	Lcom/mapbar/android/maps/j;
      //   197: aload 5
      //   199: aload 6
      //   201: aload_1
      //   202: iload_3
      //   203: iload 4
      //   205: invokestatic 102	com/mapbar/android/maps/j:a	(Lcom/mapbar/android/maps/j;Landroid/view/View;Landroid/graphics/Canvas;Lcom/mapbar/android/maps/k;II)V
      //   208: aload 8
      //   210: ifnull +23 -> 233
      //   213: new 104	java/io/FileOutputStream
      //   216: dup
      //   217: aload 8
      //   219: invokespecial 107	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   222: astore_1
      //   223: aload_1
      //   224: aload 9
      //   226: invokevirtual 113	java/io/OutputStream:write	([B)V
      //   229: aload_1
      //   230: invokevirtual 116	java/io/OutputStream:close	()V
      //   233: aload_0
      //   234: getfield 13	com/mapbar/android/maps/j$a:a	Lcom/mapbar/android/maps/j;
      //   237: invokestatic 120	com/mapbar/android/maps/j:d	(Lcom/mapbar/android/maps/j;)Ljava/util/Vector;
      //   240: aload 7
      //   242: invokevirtual 125	java/util/Vector:remove	(Ljava/lang/Object;)Z
      //   245: pop
      //   246: aconst_null
      //   247: areturn
      //   248: new 93	com/mapbar/android/maps/k
      //   251: dup
      //   252: aload 7
      //   254: ldc 127
      //   256: aconst_null
      //   257: invokespecial 130	com/mapbar/android/maps/k:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V
      //   260: astore_1
      //   261: goto -82 -> 179
      //   264: astore_1
      //   265: invokestatic 132	com/mapbar/android/maps/j:d	()Ljava/lang/String;
      //   268: ldc -122
      //   270: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   273: pop
      //   274: aload_0
      //   275: getfield 13	com/mapbar/android/maps/j$a:a	Lcom/mapbar/android/maps/j;
      //   278: invokevirtual 142	com/mapbar/android/maps/j:a	()V
      //   281: aload_0
      //   282: getfield 13	com/mapbar/android/maps/j$a:a	Lcom/mapbar/android/maps/j;
      //   285: invokestatic 120	com/mapbar/android/maps/j:d	(Lcom/mapbar/android/maps/j;)Ljava/util/Vector;
      //   288: aload 7
      //   290: invokevirtual 125	java/util/Vector:remove	(Ljava/lang/Object;)Z
      //   293: pop
      //   294: aconst_null
      //   295: areturn
      //   296: astore_1
      //   297: aconst_null
      //   298: astore_1
      //   299: aload_1
      //   300: ifnull -67 -> 233
      //   303: aload_1
      //   304: invokevirtual 116	java/io/OutputStream:close	()V
      //   307: goto -74 -> 233
      //   310: astore_1
      //   311: goto -78 -> 233
      //   314: astore_1
      //   315: aconst_null
      //   316: astore 5
      //   318: aload 5
      //   320: ifnull +8 -> 328
      //   323: aload 5
      //   325: invokevirtual 116	java/io/OutputStream:close	()V
      //   328: aload_1
      //   329: athrow
      //   330: astore_1
      //   331: aload_0
      //   332: getfield 13	com/mapbar/android/maps/j$a:a	Lcom/mapbar/android/maps/j;
      //   335: invokestatic 120	com/mapbar/android/maps/j:d	(Lcom/mapbar/android/maps/j;)Ljava/util/Vector;
      //   338: aload 7
      //   340: invokevirtual 125	java/util/Vector:remove	(Ljava/lang/Object;)Z
      //   343: pop
      //   344: aconst_null
      //   345: areturn
      //   346: aload 9
      //   348: invokevirtual 144	com/mapbar/android/maps/B:a	()I
      //   351: sipush 200
      //   354: if_icmpeq +14 -> 368
      //   357: aload 9
      //   359: invokevirtual 144	com/mapbar/android/maps/B:a	()I
      //   362: sipush 404
      //   365: if_icmpne -132 -> 233
      //   368: aload_0
      //   369: getfield 13	com/mapbar/android/maps/j$a:a	Lcom/mapbar/android/maps/j;
      //   372: aload 7
      //   374: invokevirtual 83	com/mapbar/android/maps/j:b	(Ljava/lang/Object;)Z
      //   377: ifne +91 -> 468
      //   380: new 93	com/mapbar/android/maps/k
      //   383: dup
      //   384: aload 7
      //   386: ldc 127
      //   388: aconst_null
      //   389: invokespecial 130	com/mapbar/android/maps/k:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V
      //   392: astore_1
      //   393: aload_0
      //   394: getfield 13	com/mapbar/android/maps/j$a:a	Lcom/mapbar/android/maps/j;
      //   397: aload 7
      //   399: aload_1
      //   400: invokevirtual 99	com/mapbar/android/maps/j:a	(Ljava/lang/Object;Ljava/lang/Object;)V
      //   403: iconst_1
      //   404: istore_2
      //   405: iload_2
      //   406: ifeq -173 -> 233
      //   409: aload_0
      //   410: getfield 13	com/mapbar/android/maps/j$a:a	Lcom/mapbar/android/maps/j;
      //   413: aload 5
      //   415: aload 6
      //   417: aload_1
      //   418: iload_3
      //   419: iload 4
      //   421: invokestatic 102	com/mapbar/android/maps/j:a	(Lcom/mapbar/android/maps/j;Landroid/view/View;Landroid/graphics/Canvas;Lcom/mapbar/android/maps/k;II)V
      //   424: goto -191 -> 233
      //   427: astore_1
      //   428: aload_0
      //   429: getfield 13	com/mapbar/android/maps/j$a:a	Lcom/mapbar/android/maps/j;
      //   432: invokestatic 120	com/mapbar/android/maps/j:d	(Lcom/mapbar/android/maps/j;)Ljava/util/Vector;
      //   435: aload 7
      //   437: invokevirtual 125	java/util/Vector:remove	(Ljava/lang/Object;)Z
      //   440: pop
      //   441: aload_1
      //   442: athrow
      //   443: astore_1
      //   444: goto -211 -> 233
      //   447: astore 5
      //   449: goto -121 -> 328
      //   452: astore 6
      //   454: aload_1
      //   455: astore 5
      //   457: aload 6
      //   459: astore_1
      //   460: goto -142 -> 318
      //   463: astore 5
      //   465: goto -166 -> 299
      //   468: iconst_0
      //   469: istore_2
      //   470: aconst_null
      //   471: astore_1
      //   472: goto -67 -> 405
      //   475: iconst_0
      //   476: istore_2
      //   477: aconst_null
      //   478: astore_1
      //   479: goto -290 -> 189
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	482	0	this	a
      //   0	482	1	paramVarArgs	Object[]
      //   1	476	2	i	int
      //   55	364	3	j	int
      //   65	355	4	k	int
      //   20	394	5	localView	View
      //   447	1	5	localException1	Exception
      //   455	1	5	arrayOfObject	Object[]
      //   463	1	5	localException2	Exception
      //   44	372	6	localCanvas	Canvas
      //   452	6	6	localObject1	Object
      //   28	408	7	str	String
      //   36	182	8	localFile	File
      //   83	275	9	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   67	123	264	java/lang/OutOfMemoryError
      //   127	179	264	java/lang/OutOfMemoryError
      //   179	189	264	java/lang/OutOfMemoryError
      //   193	208	264	java/lang/OutOfMemoryError
      //   229	233	264	java/lang/OutOfMemoryError
      //   248	261	264	java/lang/OutOfMemoryError
      //   303	307	264	java/lang/OutOfMemoryError
      //   323	328	264	java/lang/OutOfMemoryError
      //   328	330	264	java/lang/OutOfMemoryError
      //   346	368	264	java/lang/OutOfMemoryError
      //   368	403	264	java/lang/OutOfMemoryError
      //   409	424	264	java/lang/OutOfMemoryError
      //   213	223	296	java/lang/Exception
      //   303	307	310	java/lang/Exception
      //   213	223	314	finally
      //   67	123	330	java/lang/Throwable
      //   127	179	330	java/lang/Throwable
      //   179	189	330	java/lang/Throwable
      //   193	208	330	java/lang/Throwable
      //   229	233	330	java/lang/Throwable
      //   248	261	330	java/lang/Throwable
      //   303	307	330	java/lang/Throwable
      //   323	328	330	java/lang/Throwable
      //   328	330	330	java/lang/Throwable
      //   346	368	330	java/lang/Throwable
      //   368	403	330	java/lang/Throwable
      //   409	424	330	java/lang/Throwable
      //   67	123	427	finally
      //   127	179	427	finally
      //   179	189	427	finally
      //   193	208	427	finally
      //   229	233	427	finally
      //   248	261	427	finally
      //   265	281	427	finally
      //   303	307	427	finally
      //   323	328	427	finally
      //   328	330	427	finally
      //   346	368	427	finally
      //   368	403	427	finally
      //   409	424	427	finally
      //   229	233	443	java/lang/Exception
      //   323	328	447	java/lang/Exception
      //   223	229	452	finally
      //   223	229	463	java/lang/Exception
    }
    
    protected final void a() {}
  }
  
  class b
  {
    private j.a a = null;
    private String b = null;
    
    public b(j.a parama, String paramString)
    {
      this.a = parama;
      this.b = paramString;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/maps/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */