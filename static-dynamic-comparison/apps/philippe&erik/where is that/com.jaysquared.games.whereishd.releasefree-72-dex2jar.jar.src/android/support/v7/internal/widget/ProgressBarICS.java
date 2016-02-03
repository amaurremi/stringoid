package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Paint;
import android.graphics.Rect;
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
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class ProgressBarICS
  extends View
{
  private static final int ANIMATION_RESOLUTION = 200;
  private static final int MAX_LEVEL = 10000;
  private static final int[] android_R_styleable_ProgressBar = { 16843062, 16843063, 16843064, 16843065, 16843066, 16843067, 16843068, 16843069, 16843070, 16843071, 16843039, 16843072, 16843040, 16843073 };
  private AlphaAnimation mAnimation;
  private int mBehavior;
  private Drawable mCurrentDrawable;
  private int mDuration;
  private boolean mInDrawing;
  private boolean mIndeterminate;
  private Drawable mIndeterminateDrawable;
  private Interpolator mInterpolator;
  private long mLastDrawTime;
  private int mMax;
  int mMaxHeight;
  int mMaxWidth;
  int mMinHeight;
  int mMinWidth;
  private boolean mNoInvalidate;
  private boolean mOnlyIndeterminate;
  private int mProgress;
  private Drawable mProgressDrawable;
  private RefreshProgressRunnable mRefreshProgressRunnable;
  Bitmap mSampleTile;
  private int mSecondaryProgress;
  private boolean mShouldStartAnimationDrawable;
  private Transformation mTransformation;
  private long mUiThreadId = Thread.currentThread().getId();
  
  public ProgressBarICS(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    initProgressBar();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, android_R_styleable_ProgressBar, paramInt1, paramInt2);
    this.mNoInvalidate = true;
    setMax(paramAttributeSet.getInt(0, this.mMax));
    setProgress(paramAttributeSet.getInt(1, this.mProgress));
    setSecondaryProgress(paramAttributeSet.getInt(2, this.mSecondaryProgress));
    boolean bool2 = paramAttributeSet.getBoolean(3, this.mIndeterminate);
    this.mOnlyIndeterminate = paramAttributeSet.getBoolean(4, this.mOnlyIndeterminate);
    Drawable localDrawable = paramAttributeSet.getDrawable(5);
    if (localDrawable != null) {
      setIndeterminateDrawable(tileifyIndeterminate(localDrawable));
    }
    localDrawable = paramAttributeSet.getDrawable(6);
    if (localDrawable != null) {
      setProgressDrawable(tileify(localDrawable, false));
    }
    this.mDuration = paramAttributeSet.getInt(7, this.mDuration);
    this.mBehavior = paramAttributeSet.getInt(8, this.mBehavior);
    this.mMinWidth = paramAttributeSet.getDimensionPixelSize(9, this.mMinWidth);
    this.mMaxWidth = paramAttributeSet.getDimensionPixelSize(10, this.mMaxWidth);
    this.mMinHeight = paramAttributeSet.getDimensionPixelSize(11, this.mMinHeight);
    this.mMaxHeight = paramAttributeSet.getDimensionPixelSize(12, this.mMaxHeight);
    paramInt1 = paramAttributeSet.getResourceId(13, 17432587);
    if (paramInt1 > 0) {
      setInterpolator(paramContext, paramInt1);
    }
    paramAttributeSet.recycle();
    this.mNoInvalidate = false;
    if ((this.mOnlyIndeterminate) || (bool2)) {
      bool1 = true;
    }
    setIndeterminate(bool1);
  }
  
  private void doRefreshProgress(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        float f;
        Drawable localDrawable2;
        Drawable localDrawable1;
        if (this.mMax > 0)
        {
          f = paramInt2 / this.mMax;
          localDrawable2 = this.mCurrentDrawable;
          if (localDrawable2 != null)
          {
            localDrawable1 = null;
            if (!(localDrawable2 instanceof LayerDrawable)) {
              break label92;
            }
            localDrawable1 = ((LayerDrawable)localDrawable2).findDrawableByLayerId(paramInt1);
            break label92;
            localDrawable1.setLevel(paramInt1);
          }
        }
        else
        {
          f = 0.0F;
          continue;
          localDrawable1 = localDrawable2;
          continue;
        }
        invalidate();
        continue;
        paramInt1 = (int)(10000.0F * f);
      }
      finally {}
      label92:
      if (localObject == null) {}
    }
  }
  
  private void initProgressBar()
  {
    this.mMax = 100;
    this.mProgress = 0;
    this.mSecondaryProgress = 0;
    this.mIndeterminate = false;
    this.mOnlyIndeterminate = false;
    this.mDuration = 4000;
    this.mBehavior = 1;
    this.mMinWidth = 24;
    this.mMaxWidth = 48;
    this.mMinHeight = 24;
    this.mMaxHeight = 48;
  }
  
  private void refreshProgress(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.mUiThreadId == Thread.currentThread().getId())
        {
          doRefreshProgress(paramInt1, paramInt2, paramBoolean, true);
          return;
        }
        if (this.mRefreshProgressRunnable != null)
        {
          RefreshProgressRunnable localRefreshProgressRunnable1 = this.mRefreshProgressRunnable;
          this.mRefreshProgressRunnable = null;
          localRefreshProgressRunnable1.setup(paramInt1, paramInt2, paramBoolean);
          post(localRefreshProgressRunnable1);
        }
        else
        {
          RefreshProgressRunnable localRefreshProgressRunnable2 = new RefreshProgressRunnable(paramInt1, paramInt2, paramBoolean);
        }
      }
      finally {}
    }
  }
  
  private Drawable tileify(Drawable paramDrawable, boolean paramBoolean)
  {
    Object localObject;
    if ((paramDrawable instanceof LayerDrawable))
    {
      LayerDrawable localLayerDrawable = (LayerDrawable)paramDrawable;
      int j = localLayerDrawable.getNumberOfLayers();
      paramDrawable = new Drawable[j];
      int i = 0;
      if (i < j)
      {
        int k = localLayerDrawable.getId(i);
        localObject = localLayerDrawable.getDrawable(i);
        if ((k == 16908301) || (k == 16908303)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          paramDrawable[i] = tileify((Drawable)localObject, paramBoolean);
          i += 1;
          break;
        }
      }
      localObject = new LayerDrawable(paramDrawable);
      i = 0;
      for (;;)
      {
        paramDrawable = (Drawable)localObject;
        if (i >= j) {
          break;
        }
        ((LayerDrawable)localObject).setId(i, localLayerDrawable.getId(i));
        i += 1;
      }
    }
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      if (this.mSampleTile == null) {
        this.mSampleTile = paramDrawable;
      }
      localObject = new ShapeDrawable(getDrawableShape());
      paramDrawable = new BitmapShader(paramDrawable, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
      ((ShapeDrawable)localObject).getPaint().setShader(paramDrawable);
      paramDrawable = (Drawable)localObject;
      if (paramBoolean) {
        paramDrawable = new ClipDrawable((Drawable)localObject, 3, 1);
      }
      return paramDrawable;
    }
    return paramDrawable;
  }
  
  private Drawable tileifyIndeterminate(Drawable paramDrawable)
  {
    Object localObject = paramDrawable;
    if ((paramDrawable instanceof AnimationDrawable))
    {
      paramDrawable = (AnimationDrawable)paramDrawable;
      int j = paramDrawable.getNumberOfFrames();
      localObject = new AnimationDrawable();
      ((AnimationDrawable)localObject).setOneShot(paramDrawable.isOneShot());
      int i = 0;
      while (i < j)
      {
        Drawable localDrawable = tileify(paramDrawable.getFrame(i), true);
        localDrawable.setLevel(10000);
        ((AnimationDrawable)localObject).addFrame(localDrawable, paramDrawable.getDuration(i));
        i += 1;
      }
      ((AnimationDrawable)localObject).setLevel(10000);
    }
    return (Drawable)localObject;
  }
  
  private void updateDrawableBounds(int paramInt1, int paramInt2)
  {
    int k = paramInt1 - getPaddingRight() - getPaddingLeft();
    int m = paramInt2 - getPaddingBottom() - getPaddingTop();
    int i2 = 0;
    int i3 = 0;
    int i = m;
    int j = k;
    int i1;
    int n;
    float f1;
    if (this.mIndeterminateDrawable != null)
    {
      i = m;
      i1 = i3;
      j = k;
      n = i2;
      if (this.mOnlyIndeterminate)
      {
        i = m;
        i1 = i3;
        j = k;
        n = i2;
        if (!(this.mIndeterminateDrawable instanceof AnimationDrawable))
        {
          i = this.mIndeterminateDrawable.getIntrinsicWidth();
          j = this.mIndeterminateDrawable.getIntrinsicHeight();
          f1 = i / j;
          float f2 = paramInt1 / paramInt2;
          i = m;
          i1 = i3;
          j = k;
          n = i2;
          if (f1 != f2)
          {
            if (f2 <= f1) {
              break label222;
            }
            paramInt2 = (int)(paramInt2 * f1);
            i1 = (paramInt1 - paramInt2) / 2;
            j = i1 + paramInt2;
            n = i2;
            i = m;
          }
        }
      }
    }
    for (;;)
    {
      this.mIndeterminateDrawable.setBounds(i1, n, j, i);
      if (this.mProgressDrawable != null) {
        this.mProgressDrawable.setBounds(0, 0, j, i);
      }
      return;
      label222:
      paramInt1 = (int)(paramInt1 * (1.0F / f1));
      n = (paramInt2 - paramInt1) / 2;
      i = n + paramInt1;
      i1 = i3;
      j = k;
    }
  }
  
  private void updateDrawableState()
  {
    int[] arrayOfInt = getDrawableState();
    if ((this.mProgressDrawable != null) && (this.mProgressDrawable.isStateful())) {
      this.mProgressDrawable.setState(arrayOfInt);
    }
    if ((this.mIndeterminateDrawable != null) && (this.mIndeterminateDrawable.isStateful())) {
      this.mIndeterminateDrawable.setState(arrayOfInt);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    updateDrawableState();
  }
  
  Shape getDrawableShape()
  {
    return new RoundRectShape(new float[] { 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F }, null, null);
  }
  
  public Drawable getIndeterminateDrawable()
  {
    return this.mIndeterminateDrawable;
  }
  
  public Interpolator getInterpolator()
  {
    return this.mInterpolator;
  }
  
  public int getMax()
  {
    try
    {
      int i = this.mMax;
      return i;
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
    //   3: getfield 124	android/support/v7/internal/widget/ProgressBarICS:mIndeterminate	Z
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
    //   18: getfield 114	android/support/v7/internal/widget/ProgressBarICS:mProgress	I
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
    //   12	10	1	i	int
    //   6	2	2	bool	boolean
    //   25	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   17	22	25	finally
  }
  
  public Drawable getProgressDrawable()
  {
    return this.mProgressDrawable;
  }
  
  /* Error */
  public int getSecondaryProgress()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 124	android/support/v7/internal/widget/ProgressBarICS:mIndeterminate	Z
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
    //   18: getfield 119	android/support/v7/internal/widget/ProgressBarICS:mSecondaryProgress	I
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
    //   12	10	1	i	int
    //   6	2	2	bool	boolean
    //   25	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   17	22	25	finally
  }
  
  public final void incrementProgressBy(int paramInt)
  {
    try
    {
      setProgress(this.mProgress + paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void incrementSecondaryProgressBy(int paramInt)
  {
    try
    {
      setSecondaryProgress(this.mSecondaryProgress + paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (!this.mInDrawing)
    {
      if (verifyDrawable(paramDrawable))
      {
        paramDrawable = paramDrawable.getBounds();
        int i = getScrollX() + getPaddingLeft();
        int j = getScrollY() + getPaddingTop();
        invalidate(paramDrawable.left + i, paramDrawable.top + j, paramDrawable.right + i, paramDrawable.bottom + j);
      }
    }
    else {
      return;
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  public boolean isIndeterminate()
  {
    try
    {
      boolean bool = this.mIndeterminate;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.mIndeterminate) {
      startAnimation();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.mIndeterminate) {
      stopAnimation();
    }
    if (this.mRefreshProgressRunnable != null) {
      removeCallbacks(this.mRefreshProgressRunnable);
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
    //   4: invokespecial 423	android/view/View:onDraw	(Landroid/graphics/Canvas;)V
    //   7: aload_0
    //   8: getfield 191	android/support/v7/internal/widget/ProgressBarICS:mCurrentDrawable	Landroid/graphics/drawable/Drawable;
    //   11: astore 5
    //   13: aload 5
    //   15: ifnull +145 -> 160
    //   18: aload_1
    //   19: invokevirtual 428	android/graphics/Canvas:save	()I
    //   22: pop
    //   23: aload_1
    //   24: aload_0
    //   25: invokevirtual 313	android/support/v7/internal/widget/ProgressBarICS:getPaddingLeft	()I
    //   28: i2f
    //   29: aload_0
    //   30: invokevirtual 319	android/support/v7/internal/widget/ProgressBarICS:getPaddingTop	()I
    //   33: i2f
    //   34: invokevirtual 432	android/graphics/Canvas:translate	(FF)V
    //   37: aload_0
    //   38: invokevirtual 435	android/support/v7/internal/widget/ProgressBarICS:getDrawingTime	()J
    //   41: lstore_3
    //   42: aload_0
    //   43: getfield 437	android/support/v7/internal/widget/ProgressBarICS:mAnimation	Landroid/view/animation/AlphaAnimation;
    //   46: ifnull +74 -> 120
    //   49: aload_0
    //   50: getfield 437	android/support/v7/internal/widget/ProgressBarICS:mAnimation	Landroid/view/animation/AlphaAnimation;
    //   53: lload_3
    //   54: aload_0
    //   55: getfield 439	android/support/v7/internal/widget/ProgressBarICS:mTransformation	Landroid/view/animation/Transformation;
    //   58: invokevirtual 445	android/view/animation/AlphaAnimation:getTransformation	(JLandroid/view/animation/Transformation;)Z
    //   61: pop
    //   62: aload_0
    //   63: getfield 439	android/support/v7/internal/widget/ProgressBarICS:mTransformation	Landroid/view/animation/Transformation;
    //   66: invokevirtual 451	android/view/animation/Transformation:getAlpha	()F
    //   69: fstore_2
    //   70: aload_0
    //   71: iconst_1
    //   72: putfield 371	android/support/v7/internal/widget/ProgressBarICS:mInDrawing	Z
    //   75: aload 5
    //   77: ldc -50
    //   79: fload_2
    //   80: fmul
    //   81: f2i
    //   82: invokevirtual 202	android/graphics/drawable/Drawable:setLevel	(I)Z
    //   85: pop
    //   86: aload_0
    //   87: iconst_0
    //   88: putfield 371	android/support/v7/internal/widget/ProgressBarICS:mInDrawing	Z
    //   91: invokestatic 456	android/os/SystemClock:uptimeMillis	()J
    //   94: aload_0
    //   95: getfield 458	android/support/v7/internal/widget/ProgressBarICS:mLastDrawTime	J
    //   98: lsub
    //   99: ldc2_w 459
    //   102: lcmp
    //   103: iflt +17 -> 120
    //   106: aload_0
    //   107: invokestatic 456	android/os/SystemClock:uptimeMillis	()J
    //   110: putfield 458	android/support/v7/internal/widget/ProgressBarICS:mLastDrawTime	J
    //   113: aload_0
    //   114: ldc2_w 459
    //   117: invokevirtual 464	android/support/v7/internal/widget/ProgressBarICS:postInvalidateDelayed	(J)V
    //   120: aload 5
    //   122: aload_1
    //   123: invokevirtual 467	android/graphics/drawable/Drawable:draw	(Landroid/graphics/Canvas;)V
    //   126: aload_1
    //   127: invokevirtual 470	android/graphics/Canvas:restore	()V
    //   130: aload_0
    //   131: getfield 472	android/support/v7/internal/widget/ProgressBarICS:mShouldStartAnimationDrawable	Z
    //   134: ifeq +26 -> 160
    //   137: aload 5
    //   139: instanceof 474
    //   142: ifeq +18 -> 160
    //   145: aload 5
    //   147: checkcast 474	android/graphics/drawable/Animatable
    //   150: invokeinterface 477 1 0
    //   155: aload_0
    //   156: iconst_0
    //   157: putfield 472	android/support/v7/internal/widget/ProgressBarICS:mShouldStartAnimationDrawable	Z
    //   160: aload_0
    //   161: monitorexit
    //   162: return
    //   163: astore_1
    //   164: aload_0
    //   165: iconst_0
    //   166: putfield 371	android/support/v7/internal/widget/ProgressBarICS:mInDrawing	Z
    //   169: aload_1
    //   170: athrow
    //   171: astore_1
    //   172: aload_0
    //   173: monitorexit
    //   174: aload_1
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	ProgressBarICS
    //   0	176	1	paramCanvas	android.graphics.Canvas
    //   69	11	2	f	float
    //   41	13	3	l	long
    //   11	135	5	localDrawable	Drawable
    // Exception table:
    //   from	to	target	type
    //   70	86	163	finally
    //   2	13	171	finally
    //   18	70	171	finally
    //   86	120	171	finally
    //   120	160	171	finally
    //   164	171	171	finally
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      Drawable localDrawable = this.mCurrentDrawable;
      int j = 0;
      int i = 0;
      if (localDrawable != null)
      {
        j = Math.max(this.mMinWidth, Math.min(this.mMaxWidth, localDrawable.getIntrinsicWidth()));
        i = Math.max(this.mMinHeight, Math.min(this.mMaxHeight, localDrawable.getIntrinsicHeight()));
      }
      updateDrawableState();
      int k = getPaddingLeft();
      int m = getPaddingRight();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      setMeasuredDimension(resolveSize(j + (k + m), paramInt1), resolveSize(i + (n + i1), paramInt2));
      return;
    }
    finally {}
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setProgress(paramParcelable.progress);
    setSecondaryProgress(paramParcelable.secondaryProgress);
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.progress = this.mProgress;
    localSavedState.secondaryProgress = this.mSecondaryProgress;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    updateDrawableBounds(paramInt1, paramInt2);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.mIndeterminate)
    {
      if ((paramInt == 8) || (paramInt == 4)) {
        stopAnimation();
      }
    }
    else {
      return;
    }
    startAnimation();
  }
  
  public void postInvalidate()
  {
    if (!this.mNoInvalidate) {
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
    //   3: getfield 130	android/support/v7/internal/widget/ProgressBarICS:mOnlyIndeterminate	Z
    //   6: ifeq +10 -> 16
    //   9: aload_0
    //   10: getfield 124	android/support/v7/internal/widget/ProgressBarICS:mIndeterminate	Z
    //   13: ifne +32 -> 45
    //   16: iload_1
    //   17: aload_0
    //   18: getfield 124	android/support/v7/internal/widget/ProgressBarICS:mIndeterminate	Z
    //   21: if_icmpeq +24 -> 45
    //   24: aload_0
    //   25: iload_1
    //   26: putfield 124	android/support/v7/internal/widget/ProgressBarICS:mIndeterminate	Z
    //   29: iload_1
    //   30: ifeq +18 -> 48
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 321	android/support/v7/internal/widget/ProgressBarICS:mIndeterminateDrawable	Landroid/graphics/drawable/Drawable;
    //   38: putfield 191	android/support/v7/internal/widget/ProgressBarICS:mCurrentDrawable	Landroid/graphics/drawable/Drawable;
    //   41: aload_0
    //   42: invokevirtual 410	android/support/v7/internal/widget/ProgressBarICS:startAnimation	()V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: aload_0
    //   50: getfield 333	android/support/v7/internal/widget/ProgressBarICS:mProgressDrawable	Landroid/graphics/drawable/Drawable;
    //   53: putfield 191	android/support/v7/internal/widget/ProgressBarICS:mCurrentDrawable	Landroid/graphics/drawable/Drawable;
    //   56: aload_0
    //   57: invokevirtual 414	android/support/v7/internal/widget/ProgressBarICS:stopAnimation	()V
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
    this.mIndeterminateDrawable = paramDrawable;
    if (this.mIndeterminate)
    {
      this.mCurrentDrawable = paramDrawable;
      postInvalidate();
    }
  }
  
  public void setInterpolator(Context paramContext, int paramInt)
  {
    setInterpolator(AnimationUtils.loadInterpolator(paramContext, paramInt));
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.mInterpolator = paramInterpolator;
  }
  
  public void setMax(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    try
    {
      if (i != this.mMax)
      {
        this.mMax = i;
        postInvalidate();
        if (this.mProgress > i) {
          this.mProgress = i;
        }
        refreshProgress(16908301, this.mProgress, false);
      }
      return;
    }
    finally {}
  }
  
  public void setProgress(int paramInt)
  {
    try
    {
      setProgress(paramInt, false);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  void setProgress(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 124	android/support/v7/internal/widget/ProgressBarICS:mIndeterminate	Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: iload_1
    //   17: istore_3
    //   18: iload_1
    //   19: ifge +5 -> 24
    //   22: iconst_0
    //   23: istore_3
    //   24: iload_3
    //   25: istore_1
    //   26: iload_3
    //   27: aload_0
    //   28: getfield 102	android/support/v7/internal/widget/ProgressBarICS:mMax	I
    //   31: if_icmple +8 -> 39
    //   34: aload_0
    //   35: getfield 102	android/support/v7/internal/widget/ProgressBarICS:mMax	I
    //   38: istore_1
    //   39: iload_1
    //   40: aload_0
    //   41: getfield 114	android/support/v7/internal/widget/ProgressBarICS:mProgress	I
    //   44: if_icmpeq -31 -> 13
    //   47: aload_0
    //   48: iload_1
    //   49: putfield 114	android/support/v7/internal/widget/ProgressBarICS:mProgress	I
    //   52: aload_0
    //   53: ldc -29
    //   55: aload_0
    //   56: getfield 114	android/support/v7/internal/widget/ProgressBarICS:mProgress	I
    //   59: iload_2
    //   60: invokespecial 537	android/support/v7/internal/widget/ProgressBarICS:refreshProgress	(IIZ)V
    //   63: goto -50 -> 13
    //   66: astore 5
    //   68: aload_0
    //   69: monitorexit
    //   70: aload 5
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	ProgressBarICS
    //   0	73	1	paramInt	int
    //   0	73	2	paramBoolean	boolean
    //   17	15	3	i	int
    //   6	3	4	bool	boolean
    //   66	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	66	finally
    //   26	39	66	finally
    //   39	63	66	finally
  }
  
  public void setProgressDrawable(Drawable paramDrawable)
  {
    if ((this.mProgressDrawable != null) && (paramDrawable != this.mProgressDrawable)) {
      this.mProgressDrawable.setCallback(null);
    }
    for (int i = 1;; i = 0)
    {
      if (paramDrawable != null)
      {
        paramDrawable.setCallback(this);
        int j = paramDrawable.getMinimumHeight();
        if (this.mMaxHeight < j)
        {
          this.mMaxHeight = j;
          requestLayout();
        }
      }
      this.mProgressDrawable = paramDrawable;
      if (!this.mIndeterminate)
      {
        this.mCurrentDrawable = paramDrawable;
        postInvalidate();
      }
      if (i != 0)
      {
        updateDrawableBounds(getWidth(), getHeight());
        updateDrawableState();
        doRefreshProgress(16908301, this.mProgress, false, false);
        doRefreshProgress(16908303, this.mSecondaryProgress, false, false);
      }
      return;
    }
  }
  
  /* Error */
  public void setSecondaryProgress(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 124	android/support/v7/internal/widget/ProgressBarICS:mIndeterminate	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: iload_1
    //   15: istore_2
    //   16: iload_1
    //   17: ifge +5 -> 22
    //   20: iconst_0
    //   21: istore_2
    //   22: iload_2
    //   23: istore_1
    //   24: iload_2
    //   25: aload_0
    //   26: getfield 102	android/support/v7/internal/widget/ProgressBarICS:mMax	I
    //   29: if_icmple +8 -> 37
    //   32: aload_0
    //   33: getfield 102	android/support/v7/internal/widget/ProgressBarICS:mMax	I
    //   36: istore_1
    //   37: iload_1
    //   38: aload_0
    //   39: getfield 119	android/support/v7/internal/widget/ProgressBarICS:mSecondaryProgress	I
    //   42: if_icmpeq -31 -> 11
    //   45: aload_0
    //   46: iload_1
    //   47: putfield 119	android/support/v7/internal/widget/ProgressBarICS:mSecondaryProgress	I
    //   50: aload_0
    //   51: ldc -28
    //   53: aload_0
    //   54: getfield 119	android/support/v7/internal/widget/ProgressBarICS:mSecondaryProgress	I
    //   57: iconst_0
    //   58: invokespecial 537	android/support/v7/internal/widget/ProgressBarICS:refreshProgress	(IIZ)V
    //   61: goto -50 -> 11
    //   64: astore 4
    //   66: aload_0
    //   67: monitorexit
    //   68: aload 4
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	ProgressBarICS
    //   0	71	1	paramInt	int
    //   15	15	2	i	int
    //   6	2	3	bool	boolean
    //   64	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	64	finally
    //   24	37	64	finally
    //   37	61	64	finally
  }
  
  public void setVisibility(int paramInt)
  {
    if (getVisibility() != paramInt)
    {
      super.setVisibility(paramInt);
      if (this.mIndeterminate)
      {
        if ((paramInt != 8) && (paramInt != 4)) {
          break label36;
        }
        stopAnimation();
      }
    }
    return;
    label36:
    startAnimation();
  }
  
  void startAnimation()
  {
    if (getVisibility() != 0) {
      return;
    }
    if ((this.mIndeterminateDrawable instanceof Animatable))
    {
      this.mShouldStartAnimationDrawable = true;
      this.mAnimation = null;
    }
    for (;;)
    {
      postInvalidate();
      return;
      if (this.mInterpolator == null) {
        this.mInterpolator = new LinearInterpolator();
      }
      this.mTransformation = new Transformation();
      this.mAnimation = new AlphaAnimation(0.0F, 1.0F);
      this.mAnimation.setRepeatMode(this.mBehavior);
      this.mAnimation.setRepeatCount(-1);
      this.mAnimation.setDuration(this.mDuration);
      this.mAnimation.setInterpolator(this.mInterpolator);
      this.mAnimation.setStartTime(-1L);
    }
  }
  
  void stopAnimation()
  {
    this.mAnimation = null;
    this.mTransformation = null;
    if ((this.mIndeterminateDrawable instanceof Animatable))
    {
      ((Animatable)this.mIndeterminateDrawable).stop();
      this.mShouldStartAnimationDrawable = false;
    }
    postInvalidate();
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (paramDrawable == this.mProgressDrawable) || (paramDrawable == this.mIndeterminateDrawable) || (super.verifyDrawable(paramDrawable));
  }
  
  private class RefreshProgressRunnable
    implements Runnable
  {
    private boolean mFromUser;
    private int mId;
    private int mProgress;
    
    RefreshProgressRunnable(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.mId = paramInt1;
      this.mProgress = paramInt2;
      this.mFromUser = paramBoolean;
    }
    
    public void run()
    {
      ProgressBarICS.this.doRefreshProgress(this.mId, this.mProgress, this.mFromUser, true);
      ProgressBarICS.access$102(ProgressBarICS.this, this);
    }
    
    public void setup(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.mId = paramInt1;
      this.mProgress = paramInt2;
      this.mFromUser = paramBoolean;
    }
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public ProgressBarICS.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ProgressBarICS.SavedState(paramAnonymousParcel, null);
      }
      
      public ProgressBarICS.SavedState[] newArray(int paramAnonymousInt)
      {
        return new ProgressBarICS.SavedState[paramAnonymousInt];
      }
    };
    int progress;
    int secondaryProgress;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.progress = paramParcel.readInt();
      this.secondaryProgress = paramParcel.readInt();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.progress);
      paramParcel.writeInt(this.secondaryProgress);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/android/support/v7/internal/widget/ProgressBarICS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */