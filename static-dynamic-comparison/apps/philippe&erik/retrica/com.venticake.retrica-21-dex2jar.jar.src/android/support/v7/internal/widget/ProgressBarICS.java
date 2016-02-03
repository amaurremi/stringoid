package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class ProgressBarICS
  extends View
{
  private static final int[] f = { 16843062, 16843063, 16843064, 16843065, 16843066, 16843067, 16843068, 16843069, 16843070, 16843071, 16843039, 16843072, 16843040, 16843073 };
  int a;
  int b;
  int c;
  int d;
  Bitmap e;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private boolean l;
  private boolean m;
  private Transformation n;
  private AlphaAnimation o;
  private Drawable p;
  private Drawable q;
  private Drawable r;
  private boolean s;
  private Interpolator t;
  private z u;
  private long v = Thread.currentThread().getId();
  private boolean w;
  private long x;
  private boolean y;
  
  public ProgressBarICS(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    c();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, f, paramInt1, paramInt2);
    this.s = true;
    setMax(paramAttributeSet.getInt(0, this.i));
    setProgress(paramAttributeSet.getInt(1, this.g));
    setSecondaryProgress(paramAttributeSet.getInt(2, this.h));
    boolean bool2 = paramAttributeSet.getBoolean(3, this.l);
    this.m = paramAttributeSet.getBoolean(4, this.m);
    Drawable localDrawable = paramAttributeSet.getDrawable(5);
    if (localDrawable != null) {
      setIndeterminateDrawable(a(localDrawable));
    }
    localDrawable = paramAttributeSet.getDrawable(6);
    if (localDrawable != null) {
      setProgressDrawable(a(localDrawable, false));
    }
    this.k = paramAttributeSet.getInt(7, this.k);
    this.j = paramAttributeSet.getInt(8, this.j);
    this.a = paramAttributeSet.getDimensionPixelSize(9, this.a);
    this.b = paramAttributeSet.getDimensionPixelSize(10, this.b);
    this.c = paramAttributeSet.getDimensionPixelSize(11, this.c);
    this.d = paramAttributeSet.getDimensionPixelSize(12, this.d);
    paramInt1 = paramAttributeSet.getResourceId(13, 17432587);
    if (paramInt1 > 0) {
      a(paramContext, paramInt1);
    }
    paramAttributeSet.recycle();
    this.s = false;
    if ((this.m) || (bool2)) {
      bool1 = true;
    }
    setIndeterminate(bool1);
  }
  
  private Drawable a(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if ((paramDrawable instanceof AnimationDrawable))
    {
      paramDrawable = (AnimationDrawable)paramDrawable;
      int i2 = paramDrawable.getNumberOfFrames();
      localObject = new AnimationDrawable();
      ((AnimationDrawable)localObject).setOneShot(paramDrawable.isOneShot());
      int i1 = 0;
      while (i1 < i2)
      {
        Drawable localDrawable = a(paramDrawable.getFrame(i1), true);
        localDrawable.setLevel(10000);
        ((AnimationDrawable)localObject).addFrame(localDrawable, paramDrawable.getDuration(i1));
        i1 += 1;
      }
      ((AnimationDrawable)localObject).setLevel(10000);
    }
    return (Drawable)localObject;
  }
  
  private Drawable a(Drawable paramDrawable, boolean paramBoolean)
  {
    int i2 = 0;
    Object localObject;
    if ((paramDrawable instanceof LayerDrawable))
    {
      LayerDrawable localLayerDrawable = (LayerDrawable)paramDrawable;
      int i3 = localLayerDrawable.getNumberOfLayers();
      paramDrawable = new Drawable[i3];
      int i1 = 0;
      if (i1 < i3)
      {
        int i4 = localLayerDrawable.getId(i1);
        localObject = localLayerDrawable.getDrawable(i1);
        if ((i4 == 16908301) || (i4 == 16908303)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramDrawable[i1] = a((Drawable)localObject, paramBoolean);
          i1 += 1;
          break;
        }
      }
      localObject = new LayerDrawable(paramDrawable);
      i1 = i2;
      for (;;)
      {
        paramDrawable = (Drawable)localObject;
        if (i1 >= i3) {
          break;
        }
        ((LayerDrawable)localObject).setId(i1, localLayerDrawable.getId(i1));
        i1 += 1;
      }
    }
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = ((BitmapDrawable)paramDrawable).getBitmap();
      if (this.e == null) {
        this.e = ((Bitmap)localObject);
      }
      paramDrawable = new ShapeDrawable(getDrawableShape());
      localObject = new BitmapShader((Bitmap)localObject, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
      paramDrawable.getPaint().setShader((Shader)localObject);
      if (paramBoolean)
      {
        paramDrawable = new ClipDrawable(paramDrawable, 3, 1);
        return paramDrawable;
      }
      return paramDrawable;
    }
    return paramDrawable;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i2 = paramInt1 - getPaddingRight() - getPaddingLeft();
    int i1 = paramInt2 - getPaddingBottom() - getPaddingTop();
    int i3;
    float f1;
    float f2;
    if (this.p != null) {
      if ((this.m) && (!(this.p instanceof AnimationDrawable)))
      {
        i3 = this.p.getIntrinsicWidth();
        int i4 = this.p.getIntrinsicHeight();
        f1 = i3 / i4;
        f2 = paramInt1 / paramInt2;
        if (f1 != f2) {
          if (f2 > f1)
          {
            paramInt2 = (int)(f1 * paramInt2);
            i3 = (paramInt1 - paramInt2) / 2;
            paramInt2 += i3;
            paramInt1 = i1;
            i2 = 0;
            i1 = i3;
            this.p.setBounds(i1, i2, paramInt2, paramInt1);
          }
        }
      }
    }
    for (;;)
    {
      if (this.q != null) {
        this.q.setBounds(0, 0, paramInt2, paramInt1);
      }
      return;
      f2 = paramInt1;
      paramInt1 = (int)(1.0F / f1 * f2);
      i1 = (paramInt2 - paramInt1) / 2;
      paramInt2 = i2;
      paramInt1 += i1;
      i2 = i1;
      i1 = 0;
      break;
      i3 = 0;
      paramInt2 = i2;
      paramInt1 = i1;
      i2 = 0;
      i1 = i3;
      break;
      paramInt1 = i1;
      paramInt2 = i2;
    }
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.v == Thread.currentThread().getId())
        {
          a(paramInt1, paramInt2, paramBoolean, true);
          return;
        }
        if (this.u != null)
        {
          z localz1 = this.u;
          this.u = null;
          localz1.a(paramInt1, paramInt2, paramBoolean);
          post(localz1);
        }
        else
        {
          z localz2 = new z(this, paramInt1, paramInt2, paramBoolean);
        }
      }
      finally {}
    }
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      Object localObject2;
      try
      {
        float f1;
        if (this.i > 0)
        {
          f1 = paramInt2 / this.i;
          localObject2 = this.r;
          if (localObject2 != null)
          {
            Drawable localDrawable = null;
            if (!(localObject2 instanceof LayerDrawable)) {
              break label85;
            }
            localDrawable = ((LayerDrawable)localObject2).findDrawableByLayerId(paramInt1);
            break label85;
            ((Drawable)localObject2).setLevel(paramInt1);
          }
        }
        else
        {
          f1 = 0.0F;
          continue;
        }
        invalidate();
        continue;
        paramInt1 = (int)(f1 * 10000.0F);
      }
      finally {}
      label85:
      if (localObject1 != null) {
        localObject2 = localObject1;
      }
    }
  }
  
  private void c()
  {
    this.i = 100;
    this.g = 0;
    this.h = 0;
    this.l = false;
    this.m = false;
    this.k = 4000;
    this.j = 1;
    this.a = 24;
    this.b = 48;
    this.c = 24;
    this.d = 48;
  }
  
  private void d()
  {
    int[] arrayOfInt = getDrawableState();
    if ((this.q != null) && (this.q.isStateful())) {
      this.q.setState(arrayOfInt);
    }
    if ((this.p != null) && (this.p.isStateful())) {
      this.p.setState(arrayOfInt);
    }
  }
  
  void a()
  {
    if (getVisibility() != 0) {
      return;
    }
    if ((this.p instanceof Animatable))
    {
      this.w = true;
      this.o = null;
    }
    for (;;)
    {
      postInvalidate();
      return;
      if (this.t == null) {
        this.t = new LinearInterpolator();
      }
      this.n = new Transformation();
      this.o = new AlphaAnimation(0.0F, 1.0F);
      this.o.setRepeatMode(this.j);
      this.o.setRepeatCount(-1);
      this.o.setDuration(this.k);
      this.o.setInterpolator(this.t);
      this.o.setStartTime(-1L);
    }
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      boolean bool = this.l;
      if (bool) {
        return;
      }
      if (paramInt < 0) {
        paramInt = 0;
      }
      for (;;)
      {
        int i1 = paramInt;
        if (paramInt > this.i) {
          i1 = this.i;
        }
        if (i1 == this.g) {
          break;
        }
        this.g = i1;
        a(16908301, this.g, paramBoolean);
        break;
      }
    }
    finally {}
  }
  
  public void a(Context paramContext, int paramInt)
  {
    setInterpolator(AnimationUtils.loadInterpolator(paramContext, paramInt));
  }
  
  void b()
  {
    this.o = null;
    this.n = null;
    if ((this.p instanceof Animatable))
    {
      ((Animatable)this.p).stop();
      this.w = false;
    }
    postInvalidate();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    d();
  }
  
  Shape getDrawableShape()
  {
    return new RoundRectShape(new float[] { 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F }, null, null);
  }
  
  public Drawable getIndeterminateDrawable()
  {
    return this.p;
  }
  
  public Interpolator getInterpolator()
  {
    return this.t;
  }
  
  public int getMax()
  {
    try
    {
      int i1 = this.i;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public int getProgress()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 111	android/support/v7/internal/widget/ProgressBarICS:l	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 101	android/support/v7/internal/widget/ProgressBarICS:g	I
    //   21: istore_1
    //   22: goto -9 -> 13
    //   25: astore_3
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_3
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	ProgressBarICS
    //   12	10	1	i1	int
    //   6	2	2	bool	boolean
    //   25	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   17	22	25	finally
  }
  
  public Drawable getProgressDrawable()
  {
    return this.q;
  }
  
  /* Error */
  public int getSecondaryProgress()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 111	android/support/v7/internal/widget/ProgressBarICS:l	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 106	android/support/v7/internal/widget/ProgressBarICS:h	I
    //   21: istore_1
    //   22: goto -9 -> 13
    //   25: astore_3
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_3
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	ProgressBarICS
    //   12	10	1	i1	int
    //   6	2	2	bool	boolean
    //   25	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   17	22	25	finally
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (!this.y)
    {
      if (verifyDrawable(paramDrawable))
      {
        paramDrawable = paramDrawable.getBounds();
        int i1 = getScrollX() + getPaddingLeft();
        int i2 = getScrollY() + getPaddingTop();
        invalidate(paramDrawable.left + i1, paramDrawable.top + i2, i1 + paramDrawable.right, paramDrawable.bottom + i2);
      }
    }
    else {
      return;
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.l) {
      a();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.l) {
      b();
    }
    if (this.u != null) {
      removeCallbacks(this.u);
    }
    super.onDetachedFromWindow();
  }
  
  /* Error */
  protected void onDraw(android.graphics.Canvas paramCanvas)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 453	android/view/View:onDraw	(Landroid/graphics/Canvas;)V
    //   7: aload_0
    //   8: getfield 305	android/support/v7/internal/widget/ProgressBarICS:r	Landroid/graphics/drawable/Drawable;
    //   11: astore 5
    //   13: aload 5
    //   15: ifnull +146 -> 161
    //   18: aload_1
    //   19: invokevirtual 458	android/graphics/Canvas:save	()I
    //   22: pop
    //   23: aload_1
    //   24: aload_0
    //   25: invokevirtual 268	android/support/v7/internal/widget/ProgressBarICS:getPaddingLeft	()I
    //   28: i2f
    //   29: aload_0
    //   30: invokevirtual 274	android/support/v7/internal/widget/ProgressBarICS:getPaddingTop	()I
    //   33: i2f
    //   34: invokevirtual 461	android/graphics/Canvas:translate	(FF)V
    //   37: aload_0
    //   38: invokevirtual 464	android/support/v7/internal/widget/ProgressBarICS:getDrawingTime	()J
    //   41: lstore_3
    //   42: aload_0
    //   43: getfield 333	android/support/v7/internal/widget/ProgressBarICS:o	Landroid/view/animation/AlphaAnimation;
    //   46: ifnull +75 -> 121
    //   49: aload_0
    //   50: getfield 333	android/support/v7/internal/widget/ProgressBarICS:o	Landroid/view/animation/AlphaAnimation;
    //   53: lload_3
    //   54: aload_0
    //   55: getfield 346	android/support/v7/internal/widget/ProgressBarICS:n	Landroid/view/animation/Transformation;
    //   58: invokevirtual 468	android/view/animation/AlphaAnimation:getTransformation	(JLandroid/view/animation/Transformation;)Z
    //   61: pop
    //   62: aload_0
    //   63: getfield 346	android/support/v7/internal/widget/ProgressBarICS:n	Landroid/view/animation/Transformation;
    //   66: invokevirtual 472	android/view/animation/Transformation:getAlpha	()F
    //   69: fstore_2
    //   70: aload_0
    //   71: iconst_1
    //   72: putfield 404	android/support/v7/internal/widget/ProgressBarICS:y	Z
    //   75: aload 5
    //   77: fload_2
    //   78: ldc_w 312
    //   81: fmul
    //   82: f2i
    //   83: invokevirtual 187	android/graphics/drawable/Drawable:setLevel	(I)Z
    //   86: pop
    //   87: aload_0
    //   88: iconst_0
    //   89: putfield 404	android/support/v7/internal/widget/ProgressBarICS:y	Z
    //   92: invokestatic 477	android/os/SystemClock:uptimeMillis	()J
    //   95: aload_0
    //   96: getfield 479	android/support/v7/internal/widget/ProgressBarICS:x	J
    //   99: lsub
    //   100: ldc2_w 480
    //   103: lcmp
    //   104: iflt +17 -> 121
    //   107: aload_0
    //   108: invokestatic 477	android/os/SystemClock:uptimeMillis	()J
    //   111: putfield 479	android/support/v7/internal/widget/ProgressBarICS:x	J
    //   114: aload_0
    //   115: ldc2_w 480
    //   118: invokevirtual 484	android/support/v7/internal/widget/ProgressBarICS:postInvalidateDelayed	(J)V
    //   121: aload 5
    //   123: aload_1
    //   124: invokevirtual 487	android/graphics/drawable/Drawable:draw	(Landroid/graphics/Canvas;)V
    //   127: aload_1
    //   128: invokevirtual 490	android/graphics/Canvas:restore	()V
    //   131: aload_0
    //   132: getfield 331	android/support/v7/internal/widget/ProgressBarICS:w	Z
    //   135: ifeq +26 -> 161
    //   138: aload 5
    //   140: instanceof 329
    //   143: ifeq +18 -> 161
    //   146: aload 5
    //   148: checkcast 329	android/graphics/drawable/Animatable
    //   151: invokeinterface 493 1 0
    //   156: aload_0
    //   157: iconst_0
    //   158: putfield 331	android/support/v7/internal/widget/ProgressBarICS:w	Z
    //   161: aload_0
    //   162: monitorexit
    //   163: return
    //   164: astore_1
    //   165: aload_0
    //   166: iconst_0
    //   167: putfield 404	android/support/v7/internal/widget/ProgressBarICS:y	Z
    //   170: aload_1
    //   171: athrow
    //   172: astore_1
    //   173: aload_0
    //   174: monitorexit
    //   175: aload_1
    //   176: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	ProgressBarICS
    //   0	177	1	paramCanvas	android.graphics.Canvas
    //   69	9	2	f1	float
    //   41	13	3	l1	long
    //   11	136	5	localDrawable	Drawable
    // Exception table:
    //   from	to	target	type
    //   70	87	164	finally
    //   2	13	172	finally
    //   18	70	172	finally
    //   87	121	172	finally
    //   121	161	172	finally
    //   165	172	172	finally
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        Drawable localDrawable = this.r;
        if (localDrawable != null)
        {
          i2 = Math.max(this.a, Math.min(this.b, localDrawable.getIntrinsicWidth()));
          i1 = Math.max(this.c, Math.min(this.d, localDrawable.getIntrinsicHeight()));
          d();
          int i3 = getPaddingLeft();
          int i4 = getPaddingRight();
          int i5 = getPaddingTop();
          int i6 = getPaddingBottom();
          setMeasuredDimension(resolveSize(i2 + (i3 + i4), paramInt1), resolveSize(i1 + (i5 + i6), paramInt2));
          return;
        }
      }
      finally {}
      int i2 = 0;
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (ProgressBarICS.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setProgress(paramParcelable.a);
    setSecondaryProgress(paramParcelable.b);
  }
  
  public Parcelable onSaveInstanceState()
  {
    ProgressBarICS.SavedState localSavedState = new ProgressBarICS.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.g;
    localSavedState.b = this.h;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.l)
    {
      if ((paramInt == 8) || (paramInt == 4)) {
        b();
      }
    }
    else {
      return;
    }
    a();
  }
  
  public void postInvalidate()
  {
    if (!this.s) {
      super.postInvalidate();
    }
  }
  
  /* Error */
  public void setIndeterminate(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 117	android/support/v7/internal/widget/ProgressBarICS:m	Z
    //   6: ifeq +10 -> 16
    //   9: aload_0
    //   10: getfield 111	android/support/v7/internal/widget/ProgressBarICS:l	Z
    //   13: ifne +32 -> 45
    //   16: iload_1
    //   17: aload_0
    //   18: getfield 111	android/support/v7/internal/widget/ProgressBarICS:l	Z
    //   21: if_icmpeq +24 -> 45
    //   24: aload_0
    //   25: iload_1
    //   26: putfield 111	android/support/v7/internal/widget/ProgressBarICS:l	Z
    //   29: iload_1
    //   30: ifeq +18 -> 48
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 276	android/support/v7/internal/widget/ProgressBarICS:p	Landroid/graphics/drawable/Drawable;
    //   38: putfield 305	android/support/v7/internal/widget/ProgressBarICS:r	Landroid/graphics/drawable/Drawable;
    //   41: aload_0
    //   42: invokevirtual 441	android/support/v7/internal/widget/ProgressBarICS:a	()V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: aload_0
    //   50: getfield 288	android/support/v7/internal/widget/ProgressBarICS:q	Landroid/graphics/drawable/Drawable;
    //   53: putfield 305	android/support/v7/internal/widget/ProgressBarICS:r	Landroid/graphics/drawable/Drawable;
    //   56: aload_0
    //   57: invokevirtual 444	android/support/v7/internal/widget/ProgressBarICS:b	()V
    //   60: goto -15 -> 45
    //   63: astore_2
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_2
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	ProgressBarICS
    //   0	68	1	paramBoolean	boolean
    //   63	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	63	finally
    //   16	29	63	finally
    //   33	45	63	finally
    //   48	60	63	finally
  }
  
  public void setIndeterminateDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    this.p = paramDrawable;
    if (this.l)
    {
      this.r = paramDrawable;
      postInvalidate();
    }
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.t = paramInterpolator;
  }
  
  public void setMax(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = 0;
    }
    try
    {
      if (i1 != this.i)
      {
        this.i = i1;
        postInvalidate();
        if (this.g > i1) {
          this.g = i1;
        }
        a(16908301, this.g, false);
      }
      return;
    }
    finally {}
  }
  
  public void setProgress(int paramInt)
  {
    try
    {
      a(paramInt, false);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setProgressDrawable(Drawable paramDrawable)
  {
    if ((this.q != null) && (paramDrawable != this.q)) {
      this.q.setCallback(null);
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (paramDrawable != null)
      {
        paramDrawable.setCallback(this);
        int i2 = paramDrawable.getMinimumHeight();
        if (this.d < i2)
        {
          this.d = i2;
          requestLayout();
        }
      }
      this.q = paramDrawable;
      if (!this.l)
      {
        this.r = paramDrawable;
        postInvalidate();
      }
      if (i1 != 0)
      {
        a(getWidth(), getHeight());
        d();
        a(16908301, this.g, false, false);
        a(16908303, this.h, false, false);
      }
      return;
    }
  }
  
  public void setSecondaryProgress(int paramInt)
  {
    int i1 = 0;
    try
    {
      boolean bool = this.l;
      if (bool) {
        return;
      }
      if (paramInt < 0) {
        paramInt = i1;
      }
      for (;;)
      {
        i1 = paramInt;
        if (paramInt > this.i) {
          i1 = this.i;
        }
        if (i1 == this.h) {
          break;
        }
        this.h = i1;
        a(16908303, this.h, false);
        break;
      }
    }
    finally {}
  }
  
  public void setVisibility(int paramInt)
  {
    if (getVisibility() != paramInt)
    {
      super.setVisibility(paramInt);
      if (this.l)
      {
        if ((paramInt != 8) && (paramInt != 4)) {
          break label36;
        }
        b();
      }
    }
    return;
    label36:
    a();
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (paramDrawable == this.q) || (paramDrawable == this.p) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/ProgressBarICS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */