package com.mobisystems.photoimageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class e
  extends Drawable
{
  private static a aNY;
  private static final Object aNZ = new Object();
  private static final AtomicInteger aOa = new AtomicInteger(1);
  private static final AtomicInteger aOc = new AtomicInteger(1);
  private static HashMap<Integer, List<TileCacheView>> aOs;
  private static ArrayList<String> aOt = new ArrayList();
  private static ArrayList<String> aOu = new ArrayList();
  private ViewGroup aEB;
  private final int aEI;
  private final float[] aKI;
  private final int aOb;
  private boolean aOd;
  private final WeakReference<ImageView> aOe;
  private final BitmapRegionDecoder aOf;
  private final BlockingQueue<e> aOg;
  private b aOh;
  private final int aOi;
  private final int aOj;
  private final int aOk;
  private final Bitmap aOl;
  private final Paint aOm;
  private float[] aOn;
  private final Rect aOo;
  private final Rect aOp;
  private final Rect aOq;
  private final Rect aOr;
  private Matrix mMatrix;
  
  /* Error */
  protected e(ImageView arg1, BitmapRegionDecoder paramBitmapRegionDecoder, Bitmap paramBitmap, ViewGroup paramViewGroup, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 97	android/graphics/drawable/Drawable:<init>	()V
    //   4: aload_0
    //   5: getstatic 85	com/mobisystems/photoimageview/e:aOa	Ljava/util/concurrent/atomic/AtomicInteger;
    //   8: invokevirtual 101	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   11: putfield 103	com/mobisystems/photoimageview/e:aOb	I
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 105	com/mobisystems/photoimageview/e:aOd	Z
    //   19: aload_0
    //   20: new 107	java/util/concurrent/LinkedBlockingQueue
    //   23: dup
    //   24: invokespecial 108	java/util/concurrent/LinkedBlockingQueue:<init>	()V
    //   27: putfield 110	com/mobisystems/photoimageview/e:aOg	Ljava/util/concurrent/BlockingQueue;
    //   30: aload_0
    //   31: new 112	android/graphics/Paint
    //   34: dup
    //   35: invokespecial 113	android/graphics/Paint:<init>	()V
    //   38: putfield 115	com/mobisystems/photoimageview/e:aOm	Landroid/graphics/Paint;
    //   41: aload_0
    //   42: bipush 9
    //   44: newarray <illegal type>
    //   46: putfield 117	com/mobisystems/photoimageview/e:aKI	[F
    //   49: aload_0
    //   50: bipush 9
    //   52: newarray <illegal type>
    //   54: putfield 119	com/mobisystems/photoimageview/e:aOn	[F
    //   57: aload_0
    //   58: new 121	android/graphics/Rect
    //   61: dup
    //   62: invokespecial 122	android/graphics/Rect:<init>	()V
    //   65: putfield 124	com/mobisystems/photoimageview/e:aOo	Landroid/graphics/Rect;
    //   68: aload_0
    //   69: new 121	android/graphics/Rect
    //   72: dup
    //   73: invokespecial 122	android/graphics/Rect:<init>	()V
    //   76: putfield 126	com/mobisystems/photoimageview/e:aOp	Landroid/graphics/Rect;
    //   79: aload_0
    //   80: new 121	android/graphics/Rect
    //   83: dup
    //   84: invokespecial 122	android/graphics/Rect:<init>	()V
    //   87: putfield 128	com/mobisystems/photoimageview/e:aOq	Landroid/graphics/Rect;
    //   90: aload_0
    //   91: new 121	android/graphics/Rect
    //   94: dup
    //   95: invokespecial 122	android/graphics/Rect:<init>	()V
    //   98: putfield 130	com/mobisystems/photoimageview/e:aOr	Landroid/graphics/Rect;
    //   101: aload_0
    //   102: new 132	java/lang/ref/WeakReference
    //   105: dup
    //   106: aload_1
    //   107: invokespecial 135	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   110: putfield 137	com/mobisystems/photoimageview/e:aOe	Ljava/lang/ref/WeakReference;
    //   113: aload_2
    //   114: monitorenter
    //   115: aload_0
    //   116: aload_2
    //   117: putfield 139	com/mobisystems/photoimageview/e:aOf	Landroid/graphics/BitmapRegionDecoder;
    //   120: aload_0
    //   121: aload_0
    //   122: getfield 139	com/mobisystems/photoimageview/e:aOf	Landroid/graphics/BitmapRegionDecoder;
    //   125: invokevirtual 144	android/graphics/BitmapRegionDecoder:getWidth	()I
    //   128: putfield 146	com/mobisystems/photoimageview/e:aOi	I
    //   131: aload_0
    //   132: aload_0
    //   133: getfield 139	com/mobisystems/photoimageview/e:aOf	Landroid/graphics/BitmapRegionDecoder;
    //   136: invokevirtual 149	android/graphics/BitmapRegionDecoder:getHeight	()I
    //   139: putfield 151	com/mobisystems/photoimageview/e:aOj	I
    //   142: aload_2
    //   143: monitorexit
    //   144: new 153	android/util/DisplayMetrics
    //   147: dup
    //   148: invokespecial 154	android/util/DisplayMetrics:<init>	()V
    //   151: astore_2
    //   152: aload_1
    //   153: invokevirtual 160	android/widget/ImageView:getContext	()Landroid/content/Context;
    //   156: aload_2
    //   157: invokestatic 163	com/mobisystems/photoimageview/e:a	(Landroid/content/Context;Landroid/util/DisplayMetrics;)V
    //   160: aload_2
    //   161: getfield 166	android/util/DisplayMetrics:densityDpi	I
    //   164: sipush 240
    //   167: if_icmplt +152 -> 319
    //   170: sipush 256
    //   173: istore 6
    //   175: aload_0
    //   176: iload 6
    //   178: putfield 168	com/mobisystems/photoimageview/e:aOk	I
    //   181: aload_0
    //   182: aload_3
    //   183: putfield 170	com/mobisystems/photoimageview/e:aOl	Landroid/graphics/Bitmap;
    //   186: aload_2
    //   187: getfield 173	android/util/DisplayMetrics:widthPixels	I
    //   190: iconst_2
    //   191: imul
    //   192: i2f
    //   193: aload_0
    //   194: getfield 168	com/mobisystems/photoimageview/e:aOk	I
    //   197: i2f
    //   198: fdiv
    //   199: f2d
    //   200: invokestatic 179	java/lang/Math:ceil	(D)D
    //   203: d2i
    //   204: istore 6
    //   206: aload_2
    //   207: getfield 182	android/util/DisplayMetrics:heightPixels	I
    //   210: iconst_2
    //   211: imul
    //   212: i2f
    //   213: aload_0
    //   214: getfield 168	com/mobisystems/photoimageview/e:aOk	I
    //   217: i2f
    //   218: fdiv
    //   219: f2d
    //   220: invokestatic 179	java/lang/Math:ceil	(D)D
    //   223: d2i
    //   224: istore 7
    //   226: aload_0
    //   227: getfield 168	com/mobisystems/photoimageview/e:aOk	I
    //   230: istore 8
    //   232: aload_0
    //   233: getfield 168	com/mobisystems/photoimageview/e:aOk	I
    //   236: istore 9
    //   238: getstatic 78	com/mobisystems/photoimageview/e:aNZ	Ljava/lang/Object;
    //   241: astore_1
    //   242: aload_1
    //   243: monitorenter
    //   244: getstatic 184	com/mobisystems/photoimageview/e:aNY	Lcom/mobisystems/photoimageview/e$a;
    //   247: ifnonnull +31 -> 278
    //   250: new 8	com/mobisystems/photoimageview/e$a
    //   253: dup
    //   254: iload 6
    //   256: iconst_1
    //   257: iadd
    //   258: iconst_4
    //   259: imul
    //   260: iload 7
    //   262: iconst_1
    //   263: iadd
    //   264: imul
    //   265: iload 8
    //   267: imul
    //   268: iload 9
    //   270: imul
    //   271: aconst_null
    //   272: invokespecial 187	com/mobisystems/photoimageview/e$a:<init>	(ILcom/mobisystems/photoimageview/e$1;)V
    //   275: putstatic 184	com/mobisystems/photoimageview/e:aNY	Lcom/mobisystems/photoimageview/e$a;
    //   278: getstatic 189	com/mobisystems/photoimageview/e:aOs	Ljava/util/HashMap;
    //   281: ifnonnull +18 -> 299
    //   284: aload 4
    //   286: ifnull +13 -> 299
    //   289: new 191	java/util/HashMap
    //   292: dup
    //   293: invokespecial 192	java/util/HashMap:<init>	()V
    //   296: putstatic 189	com/mobisystems/photoimageview/e:aOs	Ljava/util/HashMap;
    //   299: aload_1
    //   300: monitorexit
    //   301: aload_0
    //   302: aload 4
    //   304: putfield 194	com/mobisystems/photoimageview/e:aEB	Landroid/view/ViewGroup;
    //   307: aload_0
    //   308: iload 5
    //   310: putfield 196	com/mobisystems/photoimageview/e:aEI	I
    //   313: return
    //   314: astore_1
    //   315: aload_2
    //   316: monitorexit
    //   317: aload_1
    //   318: athrow
    //   319: sipush 128
    //   322: istore 6
    //   324: goto -149 -> 175
    //   327: astore_2
    //   328: aload_1
    //   329: monitorexit
    //   330: aload_2
    //   331: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	this	e
    //   0	332	2	paramBitmapRegionDecoder	BitmapRegionDecoder
    //   0	332	3	paramBitmap	Bitmap
    //   0	332	4	paramViewGroup	ViewGroup
    //   0	332	5	paramInt	int
    //   173	150	6	i	int
    //   224	40	7	j	int
    //   230	38	8	k	int
    //   236	35	9	m	int
    // Exception table:
    //   from	to	target	type
    //   115	144	314	finally
    //   315	317	314	finally
    //   244	278	327	finally
    //   278	284	327	finally
    //   289	299	327	finally
    //   299	301	327	finally
    //   328	330	327	finally
  }
  
  private boolean KG()
  {
    return this.aEB != null;
  }
  
  protected static void S(int paramInt1, int paramInt2)
  {
    String str1 = "#" + paramInt1;
    String str2 = "#" + paramInt2;
    Iterator localIterator = aNY.snapshot().keySet().iterator();
    paramInt1 = 0;
    while (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      if ((!str3.startsWith(str1)) || (!str3.endsWith(str2))) {
        synchronized (aNZ)
        {
          Bitmap localBitmap = (Bitmap)aNY.remove(str3);
          if (aOs != null) {
            aOt.add(str3);
          }
          localBitmap.recycle();
          paramInt1 += 1;
        }
      }
    }
    System.gc();
    System.out.println("setPosCached cleanSomeCache cleaned = " + paramInt1);
  }
  
  @TargetApi(17)
  private static void a(Context paramContext, DisplayMetrics paramDisplayMetrics)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17) {
      paramContext.getRealMetrics(paramDisplayMetrics);
    }
    do
    {
      return;
      paramContext.getMetrics(paramDisplayMetrics);
    } while (Build.VERSION.SDK_INT < 14);
    try
    {
      paramDisplayMetrics.widthPixels = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0])).intValue();
      paramDisplayMetrics.heightPixels = ((Integer)Display.class.getMethod("getRawHeight", new Class[0]).invoke(paramContext, new Object[0])).intValue();
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(ImageView paramImageView, InputStream paramInputStream, Drawable paramDrawable, d paramd, ViewGroup paramViewGroup, int paramInt)
  {
    new c(paramImageView, paramDrawable, paramd, paramViewGroup, paramInt, null).execute(new Object[] { paramInputStream });
  }
  
  public static void clearCache()
  {
    if (aNY != null) {
      aNY.evictAll();
    }
  }
  
  private void f(String paramString, boolean paramBoolean)
  {
    paramString = paramString.split("#");
    int i = Integer.parseInt(paramString[1]);
    int j = Integer.parseInt(paramString[2]);
    int k = Integer.parseInt(paramString[3]);
    int m = Integer.parseInt(paramString[4]);
    ((TileCacheView)((List)aOs.get(Integer.valueOf(i))).get(m)).a(j, k, paramBoolean);
  }
  
  public static int generateViewId()
  {
    int k;
    int i;
    do
    {
      k = aOc.get();
      int j = k + 1;
      i = j;
      if (j > 16777215) {
        i = 1;
      }
    } while (!aOc.compareAndSet(k, i));
    return k;
  }
  
  protected void KH() {}
  
  public void bx(boolean paramBoolean)
  {
    this.aOd = paramBoolean;
    if (this.aOd) {
      if (this.aOh == null)
      {
        this.aOh = new b(this, this.aOf, this.aOg, null);
        this.aOh.start();
      }
    }
    while (this.aOh == null) {
      return;
    }
    this.aOh.quit();
    this.aOh = null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i6 = paramCanvas.save();
    ??? = (ImageView)this.aOe.get();
    if (??? == null) {
      return;
    }
    int n = ((ImageView)???).getWidth();
    int m = ((ImageView)???).getHeight();
    this.mMatrix = ((ImageView)???).getImageMatrix();
    this.mMatrix.getValues(this.aKI);
    float f1 = this.aKI[2];
    float f2 = this.aKI[5];
    float f3 = this.aKI[0];
    if ((f1 != this.aOn[2]) || (f2 != this.aOn[5]) || (f3 != this.aOn[0])) {
      this.aOg.clear();
    }
    float f4 = this.aOn[2];
    float f5 = this.aOn[5];
    this.aOn = Arrays.copyOf(this.aKI, this.aKI.length);
    int k = 0;
    int i4 = this.aOi;
    int i5 = this.aOj;
    float f6 = Math.min(n / i4, m / i5);
    int j = Math.max(1, b.Z(i4 / (f6 * i4)));
    int i7 = b.k(b.aa(1.0F / f3), 0, j - 1);
    int i8 = 1 << i7;
    int i9 = this.aOk * i8;
    int i10 = (int)Math.ceil(i4 / i9);
    int i11 = (int)Math.ceil(i5 / i9);
    Object localObject3;
    int i2;
    synchronized (aNZ)
    {
      if (!KG()) {
        break label716;
      }
      if ((aOs.get(Integer.valueOf(this.aOb)) == null) || (((List)aOs.get(Integer.valueOf(this.aOb))).size() != j))
      {
        aOs.put(Integer.valueOf(this.aOb), new ArrayList(j));
        localObject3 = new RelativeLayout(((ImageView)???).getContext());
        Object localObject4 = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject4).setMargins(10, 10, 10, 10);
        this.aEB.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
        i = 0;
        while (i < j)
        {
          localObject4 = new TileCacheView(((ImageView)???).getContext());
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
          ((TileCacheView)localObject4).setId(generateViewId());
          if (i == 0)
          {
            localLayoutParams.addRule(9);
            localLayoutParams.setMargins(10, 0, 10, 0);
            ((RelativeLayout)localObject3).addView((View)localObject4, localLayoutParams);
            i2 = (1 << i) * this.aOk;
            i1 = (int)Math.ceil(i4 / i2);
            i2 = (int)Math.ceil(i5 / i2);
            ((TileCacheView)localObject4).gJ(this.aEI);
            ((TileCacheView)localObject4).T(i1, i2);
            ((List)aOs.get(Integer.valueOf(this.aOb))).add(localObject4);
            i += 1;
          }
          else
          {
            localLayoutParams.addRule(1, ((TileCacheView)((List)aOs.get(Integer.valueOf(this.aOb))).get(i - 1)).getId());
          }
        }
      }
    }
    if (aOt.size() > 0)
    {
      ??? = aOt.iterator();
      while (((Iterator)???).hasNext()) {
        f((String)((Iterator)???).next(), false);
      }
    }
    aOt.clear();
    if (aOu.size() > 0)
    {
      ??? = aOu.iterator();
      while (((Iterator)???).hasNext()) {
        f((String)((Iterator)???).next(), true);
      }
    }
    aOu.clear();
    label716:
    int i = Math.max(0, (int)(-f1 / f3));
    int i1 = Math.max(0, (int)(-f2 / f3));
    n = Math.min(i4, Math.round((-f1 + n) / f3));
    m = Math.min(i5, Math.round((-f2 + m) / f3));
    this.aOq.set(i, i1, n, m);
    if (KG())
    {
      i = 0;
      while (i < j)
      {
        ((TileCacheView)((List)aOs.get(Integer.valueOf(this.aOb))).get(i)).KN();
        i += 1;
      }
    }
    i = 0;
    label882:
    label910:
    int i13;
    int i12;
    label945:
    int i3;
    if (i < i10)
    {
      boolean bool;
      if (f1 - f4 < 0.0F)
      {
        m = i10 - 1 - i;
        j = 0;
        if (j >= i11) {
          break label1410;
        }
        bool = false;
        if (f2 - f5 >= 0.0F) {
          break label1179;
        }
        i2 = i11 - 1 - j;
        i13 = m * i9;
        i12 = i2 * i9;
        if ((m + 1) * i9 > i4) {
          break label1186;
        }
        n = (m + 1) * i9;
        if ((i2 + 1) * i9 > i5) {
          break label1196;
        }
        i1 = (i2 + 1) * i9;
        this.aOo.set(i13, i12, n, i1);
        ??? = new e(this.aOb, this.aOo, m, i2, i7, bool, i9, null);
        i3 = k;
        if (Rect.intersects(this.aOq, this.aOo)) {
          if (KG()) {
            ((TileCacheView)((List)aOs.get(Integer.valueOf(this.aOb))).get(i7)).b(m, i2, true);
          }
        }
      }
      for (;;)
      {
        synchronized (aNZ)
        {
          localObject3 = (Bitmap)aNY.get(((e)???).getKey());
          if (localObject3 == null) {
            break label1234;
          }
          if (e.a((e)???))
          {
            this.aOp.set(0, 0, this.aOo.width() / i8, this.aOo.height() / i8);
            paramCanvas.drawBitmap((Bitmap)localObject3, this.aOp, this.aOo, this.aOm);
            i3 = k;
            j += 1;
            k = i3;
            break label882;
            m = i;
            break;
            label1179:
            i2 = j;
            break label910;
            label1186:
            bool = true;
            n = i4;
            break label945;
            label1196:
            bool = true;
            i1 = i5;
          }
        }
        paramCanvas.drawBitmap((Bitmap)localObject3, null, this.aOo, this.aOm);
        i3 = k;
      }
      label1234:
      if (!this.aOd) {
        break label1435;
      }
    }
    label1410:
    label1435:
    for (;;)
    {
      synchronized (this.aOg)
      {
        if (!this.aOg.contains(???)) {
          this.aOg.add(???);
        }
        k = 1;
        i2 = Math.round(this.aOl.getWidth() * i13 / i4);
        i3 = Math.round(this.aOl.getHeight() * i12 / i5);
        n = Math.round(this.aOl.getWidth() * n / i4);
        i1 = Math.round(this.aOl.getHeight() * i1 / i5);
        this.aOr.set(i2, i3, n, i1);
        paramCanvas.drawBitmap(this.aOl, this.aOr, this.aOo, this.aOm);
        i3 = k;
      }
      i += 1;
      break;
      if (k != 0) {
        invalidateSelf();
      }
      paramCanvas.restoreToCount(i6);
      return;
    }
  }
  
  protected void finalize()
  {
    if (this.aOh != null) {
      this.aOh.quit();
    }
  }
  
  public int getAlpha()
  {
    return this.aOm.getAlpha();
  }
  
  public int getIntrinsicHeight()
  {
    return this.aOj;
  }
  
  public int getIntrinsicWidth()
  {
    return this.aOi;
  }
  
  public int getOpacity()
  {
    if ((this.aOl == null) || (this.aOl.hasAlpha()) || (this.aOm.getAlpha() < 255)) {
      return -3;
    }
    return -1;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.aOm.getAlpha())
    {
      this.aOm.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.aOm.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  private static final class a
    extends android.support.v4.b.e<String, Bitmap>
  {
    private a(int paramInt)
    {
      super();
    }
    
    @TargetApi(19)
    private static int g(Bitmap paramBitmap)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        return paramBitmap.getAllocationByteCount();
      }
      if (Build.VERSION.SDK_INT >= 12) {
        return paramBitmap.getByteCount();
      }
      return paramBitmap.getRowBytes() * paramBitmap.getHeight();
    }
    
    protected int a(String paramString, Bitmap paramBitmap)
    {
      return g(paramBitmap);
    }
    
    protected void a(boolean paramBoolean, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      super.entryRemoved(paramBoolean, paramString, paramBitmap1, paramBitmap2);
      if ((e.KI() != null) && (paramBitmap2 == null) && (paramBoolean)) {
        e.KJ().add(paramString);
      }
    }
  }
  
  private static final class b
    extends Thread
  {
    private static Paint aOy = new Paint();
    private final BlockingQueue<e.e> aOg;
    private final WeakReference<e> aOv;
    private final BitmapRegionDecoder aOw;
    private boolean aOx;
    
    private b(e parame, BitmapRegionDecoder paramBitmapRegionDecoder, BlockingQueue<e.e> paramBlockingQueue)
    {
      this.aOv = new WeakReference(parame);
      this.aOw = paramBitmapRegionDecoder;
      this.aOg = paramBlockingQueue;
    }
    
    public void quit()
    {
      this.aOx = true;
      interrupt();
    }
    
    public void run()
    {
      for (;;)
      {
        if (this.aOv.get() == null) {
          return;
        }
        try
        {
          locale = (e.e)this.aOg.take();
          synchronized (e.KK())
          {
            if (e.KL().get(locale.getKey()) == null) {
              break label68;
            }
          }
          if (!this.aOx) {
            continue;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
        return;
        label68:
        ??? = new BitmapFactory.Options();
        ((BitmapFactory.Options)???).inPreferredConfig = Bitmap.Config.ARGB_8888;
        ((BitmapFactory.Options)???).inPreferQualityOverSpeed = true;
        ((BitmapFactory.Options)???).inSampleSize = (1 << e.e.b(locale));
        Object localObject2 = new Rect(e.e.c(locale));
        synchronized (this.aOw)
        {
          try
          {
            localObject2 = this.aOw.decodeRegion((Rect)localObject2, (BitmapFactory.Options)???);
            if (e.e.a(locale))
            {
              int i = e.e.d(locale) / ((BitmapFactory.Options)???).inSampleSize;
              ??? = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
              new Canvas((Bitmap)???).drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, aOy);
              localObject2 = ???;
            }
            while (localObject2 != null) {
              synchronized (e.KK())
              {
                e.KL().put(locale.getKey(), localObject2);
                localObject2 = (e)this.aOv.get();
                if ((localObject2 != null) && (e.b((e)localObject2))) {
                  e.KM().add(locale.getKey());
                }
              }
            }
            synchronized (e.KK())
            {
              ??? = (e)this.aOv.get();
              if (??? != null) {
                e.S(e.a((e)???), e.e.b(locale));
              }
              continue;
              localObject5 = finally;
              throw ((Throwable)localObject5);
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            localOutOfMemoryError.printStackTrace();
          }
        }
      }
    }
  }
  
  private static final class c
    extends AsyncTask<Object, Void, e>
  {
    private ViewGroup aEB;
    private int aEI;
    private final e.d aOz;
    private final ImageView aoN;
    
    private c(ImageView paramImageView, Drawable paramDrawable, e.d paramd, ViewGroup paramViewGroup, int paramInt)
    {
      this.aoN = paramImageView;
      this.aOz = paramd;
      if (this.aOz != null) {
        this.aOz.GK();
      }
      if (paramDrawable != null) {
        this.aoN.setImageDrawable(paramDrawable);
      }
      this.aEB = paramViewGroup;
      this.aEI = paramInt;
    }
    
    protected e c(Object... paramVarArgs)
    {
      paramVarArgs = paramVarArgs[0];
      Object localObject;
      BitmapFactory.Options localOptions;
      for (;;)
      {
        try
        {
          if ((paramVarArgs instanceof String))
          {
            paramVarArgs = BitmapRegionDecoder.newInstance((String)paramVarArgs, false);
            localObject = new DisplayMetrics();
            ((WindowManager)this.aoN.getContext().getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
            int i = Math.min(2048, Math.max(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels));
            f = Math.min(i / paramVarArgs.getWidth(), i / paramVarArgs.getHeight());
            i = Math.max(1, b.Z(1.0F / f));
            j = paramVarArgs.getWidth();
            k = paramVarArgs.getHeight();
            localRect = new Rect(0, 0, j, k);
            localOptions = new BitmapFactory.Options();
            localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
            localOptions.inPreferQualityOverSpeed = true;
            localOptions.inSampleSize = (1 << i);
            localObject = null;
            if (localObject != null) {
              break;
            }
          }
        }
        catch (IOException paramVarArgs)
        {
          float f;
          int j;
          int k;
          Rect localRect;
          Bitmap localBitmap;
          return null;
        }
        try
        {
          localBitmap = paramVarArgs.decodeRegion(localRect, localOptions);
          localObject = localBitmap;
          localBitmap = Bitmap.createScaledBitmap(localBitmap, Math.round(j * f), Math.round(k * f), true);
          localObject = localBitmap;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
          localOptions.inSampleSize *= 2;
        }
        if ((paramVarArgs instanceof FileDescriptor)) {
          paramVarArgs = BitmapRegionDecoder.newInstance((FileDescriptor)paramVarArgs, false);
        } else {
          paramVarArgs = BitmapRegionDecoder.newInstance((InputStream)paramVarArgs, false);
        }
      }
      return new e(this.aoN, paramVarArgs, (Bitmap)localObject, this.aEB, this.aEI);
    }
    
    protected void c(e parame)
    {
      if ((parame == null) && (this.aoN.getContext() != null)) {
        Toast.makeText(this.aoN.getContext(), c.b.unsupported_image_format, 1).show();
      }
      this.aoN.setImageDrawable(parame);
      if (this.aOz != null) {
        this.aOz.GL();
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void GK();
    
    public abstract void GL();
  }
  
  private static final class e
  {
    private final int aOA;
    private final int aOB;
    private final int aOC;
    private final boolean aOD;
    private final int aOE;
    private final int aOb;
    private final Rect aOo;
    private final String mKey;
    
    private e(int paramInt1, Rect paramRect, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
    {
      this.aOb = paramInt1;
      this.aOo = new Rect();
      this.aOo.set(paramRect);
      this.aOA = paramInt2;
      this.aOB = paramInt3;
      this.aOC = paramInt4;
      this.mKey = ("#" + this.aOb + "#" + this.aOA + "#" + this.aOB + "#" + this.aOC);
      this.aOD = paramBoolean;
      this.aOE = paramInt5;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if ((paramObject instanceof e)) {
        return getKey().equals(((e)paramObject).getKey());
      }
      return false;
    }
    
    public String getKey()
    {
      return this.mKey;
    }
    
    public int hashCode()
    {
      return getKey().hashCode();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/photoimageview/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */