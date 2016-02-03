package com.ideashower.readitlater.views;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import com.ideashower.readitlater.f.i;
import com.ideashower.readitlater.util.a;
import com.ideashower.readitlater.views.gallery.f;

public class s
  extends q
{
  private static final boolean f = ;
  private String g;
  private int h;
  private int i;
  private float j;
  private Runnable k;
  private boolean l;
  private boolean m = false;
  private Bitmap n;
  private BitmapRegionDecoder o;
  private final Matrix p = new Matrix();
  private long q;
  private Rect r;
  private float s;
  
  public s(Context paramContext)
  {
    super(paramContext);
    d();
  }
  
  public s(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  public s(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private Bitmap a(Rect paramRect)
  {
    g();
    int i1 = getLowResolutionMaxDimension();
    com.pocket.k.g localg = new com.pocket.k.g(i1, i1);
    return i.a(this.o, localg, -1, paramRect);
  }
  
  /* Error */
  @TargetApi(10)
  private boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 94	com/ideashower/readitlater/views/s:g	Ljava/lang/String;
    //   5: aload_0
    //   6: getfield 77	com/ideashower/readitlater/views/s:o	Landroid/graphics/BitmapRegionDecoder;
    //   9: ifnull +25 -> 34
    //   12: aload_0
    //   13: getfield 77	com/ideashower/readitlater/views/s:o	Landroid/graphics/BitmapRegionDecoder;
    //   16: invokevirtual 99	android/graphics/BitmapRegionDecoder:isRecycled	()Z
    //   19: ifne +15 -> 34
    //   22: aload_0
    //   23: getfield 77	com/ideashower/readitlater/views/s:o	Landroid/graphics/BitmapRegionDecoder;
    //   26: invokevirtual 102	android/graphics/BitmapRegionDecoder:recycle	()V
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield 77	com/ideashower/readitlater/views/s:o	Landroid/graphics/BitmapRegionDecoder;
    //   34: new 104	java/io/FileInputStream
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 107	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   42: astore_3
    //   43: aload_3
    //   44: astore_1
    //   45: aload_0
    //   46: aload_3
    //   47: invokevirtual 111	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   50: iconst_0
    //   51: invokestatic 115	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/FileDescriptor;Z)Landroid/graphics/BitmapRegionDecoder;
    //   54: putfield 77	com/ideashower/readitlater/views/s:o	Landroid/graphics/BitmapRegionDecoder;
    //   57: aload_3
    //   58: invokestatic 120	org/apache/a/b/d:a	(Ljava/io/InputStream;)V
    //   61: aload_0
    //   62: getfield 77	com/ideashower/readitlater/views/s:o	Landroid/graphics/BitmapRegionDecoder;
    //   65: ifnonnull +32 -> 97
    //   68: iconst_0
    //   69: ireturn
    //   70: astore 4
    //   72: aconst_null
    //   73: astore_3
    //   74: aload_3
    //   75: astore_1
    //   76: aload 4
    //   78: invokestatic 125	com/ideashower/readitlater/util/e:a	(Ljava/lang/Throwable;)V
    //   81: aload_3
    //   82: invokestatic 120	org/apache/a/b/d:a	(Ljava/io/InputStream;)V
    //   85: goto -24 -> 61
    //   88: astore_3
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: invokestatic 120	org/apache/a/b/d:a	(Ljava/io/InputStream;)V
    //   95: aload_3
    //   96: athrow
    //   97: aload_0
    //   98: aload_0
    //   99: getfield 77	com/ideashower/readitlater/views/s:o	Landroid/graphics/BitmapRegionDecoder;
    //   102: invokevirtual 128	android/graphics/BitmapRegionDecoder:getWidth	()I
    //   105: putfield 130	com/ideashower/readitlater/views/s:h	I
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 77	com/ideashower/readitlater/views/s:o	Landroid/graphics/BitmapRegionDecoder;
    //   113: invokevirtual 133	android/graphics/BitmapRegionDecoder:getHeight	()I
    //   116: putfield 135	com/ideashower/readitlater/views/s:i	I
    //   119: new 137	android/graphics/Rect
    //   122: dup
    //   123: iconst_0
    //   124: iconst_0
    //   125: aload_0
    //   126: getfield 130	com/ideashower/readitlater/views/s:h	I
    //   129: aload_0
    //   130: getfield 135	com/ideashower/readitlater/views/s:i	I
    //   133: invokespecial 140	android/graphics/Rect:<init>	(IIII)V
    //   136: astore_1
    //   137: aload_0
    //   138: invokespecial 70	com/ideashower/readitlater/views/s:getLowResolutionMaxDimension	()I
    //   141: istore_2
    //   142: new 72	com/pocket/k/g
    //   145: dup
    //   146: iload_2
    //   147: iload_2
    //   148: invokespecial 75	com/pocket/k/g:<init>	(II)V
    //   151: astore_3
    //   152: aload_0
    //   153: getfield 77	com/ideashower/readitlater/views/s:o	Landroid/graphics/BitmapRegionDecoder;
    //   156: aload_3
    //   157: iconst_m1
    //   158: aload_1
    //   159: invokestatic 82	com/ideashower/readitlater/f/i:a	(Landroid/graphics/BitmapRegionDecoder;Lcom/pocket/k/a;ILandroid/graphics/Rect;)Landroid/graphics/Bitmap;
    //   162: astore_1
    //   163: aload_0
    //   164: aload_1
    //   165: invokevirtual 144	com/ideashower/readitlater/views/s:setImage	(Landroid/graphics/Bitmap;)V
    //   168: aload_0
    //   169: aload_0
    //   170: getfield 130	com/ideashower/readitlater/views/s:h	I
    //   173: i2f
    //   174: aload_0
    //   175: getfield 146	com/ideashower/readitlater/views/s:b	F
    //   178: fdiv
    //   179: putfield 148	com/ideashower/readitlater/views/s:j	F
    //   182: aload_0
    //   183: aload_0
    //   184: getfield 148	com/ideashower/readitlater/views/s:j	F
    //   187: ldc -107
    //   189: fadd
    //   190: invokevirtual 153	com/ideashower/readitlater/views/s:setMaxZoom	(F)V
    //   193: aload_1
    //   194: ifnull -126 -> 68
    //   197: iconst_1
    //   198: ireturn
    //   199: astore_3
    //   200: goto -109 -> 91
    //   203: astore 4
    //   205: goto -131 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	s
    //   0	208	1	paramString	String
    //   141	7	2	i1	int
    //   42	40	3	localFileInputStream	java.io.FileInputStream
    //   88	8	3	localObject1	Object
    //   151	6	3	localg	com.pocket.k.g
    //   199	1	3	localObject2	Object
    //   70	7	4	localIOException1	java.io.IOException
    //   203	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   34	43	70	java/io/IOException
    //   34	43	88	finally
    //   45	57	199	finally
    //   76	81	199	finally
    //   45	57	203	java/io/IOException
  }
  
  private void d()
  {
    if (((ActivityManager)getContext().getSystemService("activity")).getMemoryClass() <= 24)
    {
      this.q = 700L;
      return;
    }
    this.q = 333L;
  }
  
  @TargetApi(10)
  private void e()
  {
    if ((this.o != null) && (!this.o.isRecycled())) {
      this.o.recycle();
    }
  }
  
  private void f()
  {
    g();
    if (this.n != null)
    {
      this.n.recycle();
      this.n = null;
      this.m = false;
    }
  }
  
  private void g()
  {
    if (!f) {}
  }
  
  @TargetApi(10)
  private Bitmap getFullResolutionCroppedBitmap()
  {
    g();
    if (getDrawable() == null) {
      return null;
    }
    return a(getSourceRegionWithinBounds());
  }
  
  private int getLowResolutionMaxDimension()
  {
    Activity localActivity = (Activity)getContext();
    int i1 = ((ActivityManager)localActivity.getSystemService("activity")).getMemoryClass();
    int i2 = com.ideashower.readitlater.util.q.b(localActivity).b(false);
    if (i1 <= 24) {}
    for (i1 = 1200; f; i1 = 1800) {
      return Math.min(i2, i1);
    }
    return Math.max(600, Math.min(i2, i1));
  }
  
  private Rect getSourceRegionWithinBounds()
  {
    g();
    b();
    com.ideashower.readitlater.views.gallery.g localg = this.a.a();
    Rect localRect = new Rect(this.e);
    localRect.left = ((int)(localRect.left - localg.a));
    localRect.right = ((int)(localRect.right - localg.a));
    localRect.top = ((int)(localRect.top - localg.b));
    localRect.bottom = ((int)(localRect.bottom - localg.b));
    this.r = localRect;
    localRect = new Rect(localRect);
    float f1 = 1.0F / localg.c * this.j;
    localRect.left = ((int)(localRect.left * f1));
    localRect.right = ((int)(localRect.right * f1));
    localRect.top = ((int)(localRect.top * f1));
    localRect.bottom = ((int)(f1 * localRect.bottom));
    this.s = localg.c;
    return localRect;
  }
  
  private void h()
  {
    g();
    if ((this.a.a().c <= 1.0F) || (this.j == 1.0F))
    {
      if (this.m)
      {
        f();
        invalidate();
      }
      return;
    }
    f();
    Rect localRect = getSourceRegionWithinBounds();
    com.pocket.k.g localg = new com.pocket.k.g(this.e.width(), this.e.height());
    this.n = i.a(this.o, localg, -1, localRect);
    if (this.n != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.m = bool;
      invalidate();
      return;
    }
  }
  
  protected void a()
  {
    super.a();
    if (!f) {
      return;
    }
    this.l = true;
    this.n = null;
    h();
    invalidate();
  }
  
  public boolean a(String paramString)
  {
    if (f) {
      return b(paramString);
    }
    int i1 = getLowResolutionMaxDimension();
    paramString = i.b(paramString, new com.pocket.k.g(i1, i1));
    setImage(paramString);
    return paramString != null;
  }
  
  protected void b()
  {
    super.b();
    if ((!f) || (getHandler() == null)) {
      return;
    }
    if (this.k == null) {
      this.k = new Runnable()
      {
        public void run()
        {
          s.a(s.this);
        }
      };
    }
    for (;;)
    {
      getHandler().postDelayed(this.k, this.q);
      return;
      getHandler().removeCallbacks(this.k);
    }
  }
  
  public void c()
  {
    if (f)
    {
      f();
      e();
    }
    setImage(null);
  }
  
  public Bitmap getCroppedBitmap()
  {
    if (f) {
      return getFullResolutionCroppedBitmap();
    }
    return super.getCroppedBitmap();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    com.ideashower.readitlater.views.gallery.g localg;
    if ((f) && (this.n != null) && (this.m))
    {
      this.p.reset();
      localg = this.a.a();
      if ((this.j <= 1.0F) || (this.s <= this.j)) {
        break label160;
      }
    }
    label160:
    for (float f1 = localg.c / this.j;; f1 = localg.c / this.s)
    {
      this.p.postScale(f1, f1, 0.0F, 0.0F);
      f1 = localg.c / this.s;
      int i1 = (int)(this.r.left * f1 + localg.a);
      int i2 = (int)(f1 * this.r.top + localg.b);
      this.p.postTranslate(i1, i2);
      paramCanvas.drawBitmap(this.n, this.p, null);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */