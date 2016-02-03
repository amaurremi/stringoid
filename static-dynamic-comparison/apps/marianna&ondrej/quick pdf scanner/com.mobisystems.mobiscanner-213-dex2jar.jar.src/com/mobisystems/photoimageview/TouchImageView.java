package com.mobisystems.photoimageview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.p;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import java.io.PrintStream;

public class TouchImageView
  extends ImageView
{
  private TextView aED;
  private int aEI = 0;
  private final float[] aKI = new float[9];
  private Drawable aON;
  private int aOO;
  private int aOP;
  private f aOQ;
  private Float aOR;
  private Float aOS;
  private final a aOT = new a();
  private boolean aOU;
  private boolean aOV = false;
  private a aOW;
  private float aOX;
  private c aOY;
  private boolean aOZ = false;
  private boolean aOd = false;
  private float alP;
  private final Matrix mMatrix = new Matrix();
  private float mTranslationX;
  private float mTranslationY;
  
  public TouchImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TouchImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void KO()
  {
    if ((this.aOd) && (this.aED != null)) {
      this.aED.animate().setDuration(1000L).alpha(0.0F);
    }
  }
  
  private void KP()
  {
    if ((this.aOd) && (this.aED != null))
    {
      this.aED.animate().cancel();
      this.aED.setAlpha(1.0F);
    }
  }
  
  private boolean KQ()
  {
    return (this.aEI == 90) || (this.aEI == 270);
  }
  
  private void KR()
  {
    this.mMatrix.reset();
    float f2 = Math.min(getMeasuredWidth() / this.aOO, getMeasuredHeight() / this.aOP);
    this.mMatrix.postScale(f2, f2);
    float[] arrayOfFloat = new float[9];
    this.mMatrix.getValues(arrayOfFloat);
    float f1 = (getMeasuredWidth() - this.aOO * f2) / 2.0F;
    f2 = (getMeasuredHeight() - f2 * this.aOP) / 2.0F;
    this.mMatrix.postTranslate(f1, f2);
    if ((this.aOZ) && (this.aOY != null)) {
      this.aOY.onReset();
    }
    invalidate();
  }
  
  private void KS()
  {
    this.mMatrix.getValues(this.aKI);
    this.alP = this.aKI[0];
    this.mTranslationX = this.aKI[2];
    this.mTranslationY = this.aKI[5];
  }
  
  private float KT()
  {
    return Math.min(getMeasuredWidth() / this.aOO, getMeasuredHeight() / this.aOP);
  }
  
  private void KV()
  {
    final int j = this.aEI;
    final int i;
    final boolean bool;
    if (KQ())
    {
      i = (getWidth() - getHeight()) / 2;
      bool = true;
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        setRotation(j);
        if (bool)
        {
          setTranslationY(i);
          setTranslationX(-i);
        }
      }
      for (;;)
      {
        this.aOV = true;
        invalidate();
        return;
        clearAnimation();
        RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, j, 1, 0.5F, 1, 0.5F);
        localRotateAnimation.setFillAfter(true);
        localRotateAnimation.setFillEnabled(true);
        localRotateAnimation.setDuration(0L);
        localRotateAnimation.setAnimationListener(new Animation.AnimationListener()
        {
          public void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            System.out.println(" useDiff rotateAnimation onAnimationEnd  " + j);
            if (bool)
            {
              paramAnonymousAnimation = new TranslateAnimation(0.0F, -i, 0.0F, i);
              paramAnonymousAnimation.setFillAfter(true);
              paramAnonymousAnimation.setFillEnabled(true);
              paramAnonymousAnimation.setDuration(1L);
              paramAnonymousAnimation.setAnimationListener(new Animation.AnimationListener()
              {
                public void onAnimationEnd(Animation paramAnonymous2Animation)
                {
                  System.out.println(" useDiff translateAnimation onAnimationStart  " + TouchImageView.2.this.aPd);
                }
                
                public void onAnimationRepeat(Animation paramAnonymous2Animation)
                {
                  System.out.println(" useDiff translateAnimation onAnimationRepeat  " + TouchImageView.2.this.aPd);
                }
                
                public void onAnimationStart(Animation paramAnonymous2Animation)
                {
                  System.out.println(" useDiff translateAnimation onAnimationStart  " + TouchImageView.2.this.aPd);
                }
              });
              TouchImageView.this.startAnimation(paramAnonymousAnimation);
            }
          }
          
          public void onAnimationRepeat(Animation paramAnonymousAnimation)
          {
            System.out.println(" useDiff rotateAnimation onAnimationRepeat  " + j);
          }
          
          public void onAnimationStart(Animation paramAnonymousAnimation)
          {
            System.out.println(" useDiff rotateAnimation onAnimationStart  " + j);
          }
        });
        localRotateAnimation.setInterpolator(new LinearInterpolator());
        System.out.println(" useDiff startAnimation");
        startAnimation(localRotateAnimation);
      }
      bool = false;
      i = 0;
    }
  }
  
  private static float c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat3;
  }
  
  private static float c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f = (paramFloat1 - paramFloat2) / 2.0F;
    if (f > 0.0F) {
      f -= paramFloat3;
    }
    do
    {
      return f;
      if (paramFloat3 + paramFloat4 > 0.0F) {
        return -paramFloat3;
      }
      f = paramFloat4;
    } while (paramFloat3 + paramFloat4 >= paramFloat1 - paramFloat2);
    return paramFloat1 - paramFloat2 - paramFloat3;
  }
  
  private static float d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f;
    if (paramFloat1 > paramFloat2)
    {
      f = 0.0F;
      if (paramFloat1 <= paramFloat2) {
        break label56;
      }
      paramFloat1 -= paramFloat2;
      label19:
      if ((paramFloat3 >= f) || (paramFloat4 <= 0.0F)) {
        break label61;
      }
      paramFloat2 = paramFloat4;
      if (paramFloat3 + paramFloat4 > paramFloat1) {
        paramFloat2 = paramFloat1 - paramFloat3;
      }
    }
    label56:
    label61:
    label89:
    do
    {
      do
      {
        return paramFloat2;
        f = paramFloat1 - paramFloat2;
        break;
        paramFloat1 = 0.0F;
        break label19;
        if ((paramFloat3 <= paramFloat1) || (paramFloat4 >= 0.0F)) {
          break label89;
        }
        paramFloat2 = paramFloat4;
      } while (paramFloat3 + paramFloat4 >= f);
      return f - paramFloat3;
      if ((paramFloat3 <= f) || (paramFloat3 >= paramFloat1)) {
        break label130;
      }
      if (paramFloat3 + paramFloat4 < f) {
        return f - paramFloat3;
      }
      paramFloat2 = paramFloat4;
    } while (paramFloat3 + paramFloat4 <= paramFloat1);
    return paramFloat1 - paramFloat3;
    label130:
    return 0.0F;
  }
  
  private static float e(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramFloat3 > 0.0F) && (paramFloat4 < paramFloat3)) {
      return paramFloat3;
    }
    if ((paramFloat3 < paramFloat1 - paramFloat2) && (paramFloat4 > paramFloat3 + paramFloat2)) {
      return paramFloat3 + paramFloat2;
    }
    return paramFloat4;
  }
  
  private void init(Context paramContext)
  {
    this.aOQ = new f(paramContext, new f.a()
    {
      public boolean aPa;
      public boolean aPb;
      
      private float k(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        float f = paramAnonymousFloat2;
        switch (TouchImageView.r(TouchImageView.this))
        {
        default: 
          f = paramAnonymousFloat1;
        case 90: 
          return f;
        case 180: 
          return getWidth() - paramAnonymousFloat1;
        }
        return getWidth() - paramAnonymousFloat2;
      }
      
      private float l(float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        switch (TouchImageView.r(TouchImageView.this))
        {
        default: 
          paramAnonymousFloat1 = paramAnonymousFloat2;
        case 90: 
        case 270: 
          return paramAnonymousFloat1;
        }
        return getHeight() - paramAnonymousFloat2;
      }
      
      private boolean r(MotionEvent paramAnonymousMotionEvent)
      {
        float f1 = 2.0F;
        TouchImageView.e(TouchImageView.this);
        float f2 = TouchImageView.p(TouchImageView.this);
        if (TouchImageView.g(TouchImageView.this) > f2) {
          f1 = f2;
        }
        for (;;)
        {
          f2 = paramAnonymousMotionEvent.getX() - (paramAnonymousMotionEvent.getX() - TouchImageView.i(TouchImageView.this)) * (f1 / TouchImageView.g(TouchImageView.this));
          float f3 = paramAnonymousMotionEvent.getY() - (paramAnonymousMotionEvent.getY() - TouchImageView.j(TouchImageView.this)) * (f1 / TouchImageView.g(TouchImageView.this));
          float f4 = TouchImageView.f(TouchImageView.this.getMeasuredWidth(), TouchImageView.f(TouchImageView.this) * f1, f2, 0.0F);
          float f5 = TouchImageView.f(TouchImageView.this.getMeasuredHeight(), TouchImageView.h(TouchImageView.this) * f1, f3, 0.0F);
          TouchImageView.this.clearAnimation();
          paramAnonymousMotionEvent = new TouchImageView.d(TouchImageView.this, f1, f2 + f4, f3 + f5);
          paramAnonymousMotionEvent.setDuration(200L);
          TouchImageView.this.startAnimation(paramAnonymousMotionEvent);
          return true;
          if (1.0F == TouchImageView.g(TouchImageView.this))
          {
            if (f2 != 1.0F) {
              for (;;)
              {
                f1 = f2;
              }
            }
          }
          else
          {
            f1 = f2;
            if (TouchImageView.g(TouchImageView.this) >= f2) {
              f1 = (float)Math.max(1.0D, Math.floor(Math.min(2.0F * f2, 6.0F)));
            }
          }
        }
      }
      
      public int getHeight()
      {
        return TouchImageView.this.getHeight();
      }
      
      public int getWidth()
      {
        return TouchImageView.this.getWidth();
      }
      
      public boolean onDoubleTapEvent(MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 0) {
          this.aPa = true;
        }
        while ((paramAnonymousMotionEvent.getAction() != 1) || (!this.aPa)) {
          return false;
        }
        return r(paramAnonymousMotionEvent);
      }
      
      public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        if (TouchImageView.d(TouchImageView.this)) {
          return false;
        }
        TouchImageView.e(TouchImageView.this);
        float f2 = (TouchImageView.this.getMeasuredWidth() - TouchImageView.f(TouchImageView.this) * TouchImageView.g(TouchImageView.this)) / 2.0F;
        float f1;
        label66:
        float f4;
        float f3;
        if (f2 > 0.0F)
        {
          f1 = f2;
          if (f2 <= 0.0F) {
            break label258;
          }
          f4 = (TouchImageView.this.getMeasuredHeight() - TouchImageView.h(TouchImageView.this) * TouchImageView.g(TouchImageView.this)) / 2.0F;
          if (f4 <= 0.0F) {
            break label264;
          }
          f3 = f4;
          label106:
          if (f4 <= 0.0F) {
            break label294;
          }
        }
        for (;;)
        {
          TouchImageView.l(TouchImageView.this).fling(Math.round(TouchImageView.i(TouchImageView.this)), Math.round(TouchImageView.j(TouchImageView.this)), Math.round(paramAnonymousFloat1), Math.round(paramAnonymousFloat2), Math.round(f1), Math.round(f2), Math.round(f3), Math.round(f4));
          TouchImageView.this.clearAnimation();
          paramAnonymousMotionEvent1 = new TouchImageView.b(TouchImageView.this, null);
          paramAnonymousMotionEvent1.setDuration(TouchImageView.l(TouchImageView.this).getDuration());
          paramAnonymousMotionEvent1.setInterpolator(new LinearInterpolator());
          TouchImageView.this.startAnimation(paramAnonymousMotionEvent1);
          return true;
          f1 = TouchImageView.this.getMeasuredWidth() - TouchImageView.f(TouchImageView.this) * TouchImageView.g(TouchImageView.this);
          break;
          label258:
          f2 = 0.0F;
          break label66;
          label264:
          f3 = TouchImageView.this.getMeasuredHeight() - TouchImageView.h(TouchImageView.this) * TouchImageView.g(TouchImageView.this);
          break label106;
          label294:
          f4 = 0.0F;
        }
      }
      
      public void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        TouchImageView.this.performLongClick();
      }
      
      public boolean onScale(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        TouchImageView.e(TouchImageView.this);
        float f4 = TouchImageView.f(TouchImageView.this) * TouchImageView.g(TouchImageView.this);
        float f2 = TouchImageView.h(TouchImageView.this) * TouchImageView.g(TouchImageView.this);
        float f1 = k(paramAnonymousScaleGestureDetector.getFocusX(), paramAnonymousScaleGestureDetector.getFocusY());
        float f3 = l(paramAnonymousScaleGestureDetector.getFocusX(), paramAnonymousScaleGestureDetector.getFocusY());
        f1 = TouchImageView.g(TouchImageView.this.getMeasuredWidth(), f4, TouchImageView.i(TouchImageView.this), f1);
        f3 = TouchImageView.g(TouchImageView.this.getMeasuredHeight(), f2, TouchImageView.j(TouchImageView.this), f3);
        if ((TouchImageView.n(TouchImageView.this) != null) && (TouchImageView.o(TouchImageView.this) != null))
        {
          f4 = TouchImageView.h(TouchImageView.this.getMeasuredWidth(), f4, TouchImageView.i(TouchImageView.this), f1 - TouchImageView.n(TouchImageView.this).floatValue());
          f2 = TouchImageView.h(TouchImageView.this.getMeasuredHeight(), f2, TouchImageView.j(TouchImageView.this), f3 - TouchImageView.o(TouchImageView.this).floatValue());
          if ((f4 != 0.0F) || (f2 != 0.0F)) {
            TouchImageView.k(TouchImageView.this).postTranslate(f4, f2);
          }
        }
        f2 = TouchImageView.d(TouchImageView.p(TouchImageView.this), TouchImageView.g(TouchImageView.this), paramAnonymousScaleGestureDetector.getScaleFactor());
        TouchImageView.k(TouchImageView.this).postScale(f2, f2, f1, f3);
        TouchImageView.a(TouchImageView.this, Float.valueOf(f1));
        TouchImageView.b(TouchImageView.this, Float.valueOf(f3));
        TouchImageView.this.clearAnimation();
        p.d(TouchImageView.this);
        return true;
      }
      
      public boolean onScaleBegin(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        TouchImageView.a(TouchImageView.this, null);
        TouchImageView.b(TouchImageView.this, null);
        if (this.aPa) {
          this.aPa = false;
        }
        for (this.aPb = true;; this.aPb = false)
        {
          TouchImageView.m(TouchImageView.this);
          return true;
        }
      }
      
      public void onScaleEnd(ScaleGestureDetector paramAnonymousScaleGestureDetector)
      {
        TouchImageView.q(TouchImageView.this);
        this.aPb = false;
        TouchImageView.e(TouchImageView.this);
        float f2 = TouchImageView.g(TouchImageView.this);
        float f3;
        if (f2 > 6.0F)
        {
          f1 = TouchImageView.this.getMeasuredWidth() / 2 - (TouchImageView.this.getMeasuredWidth() / 2 - TouchImageView.i(TouchImageView.this)) * (6.0F / TouchImageView.g(TouchImageView.this));
          f2 = TouchImageView.this.getMeasuredHeight() / 2 - (TouchImageView.this.getMeasuredHeight() / 2 - TouchImageView.j(TouchImageView.this)) * (6.0F / TouchImageView.g(TouchImageView.this));
          f3 = TouchImageView.f(TouchImageView.this.getMeasuredWidth(), TouchImageView.f(TouchImageView.this) * 6.0F, f1, 0.0F);
          float f4 = TouchImageView.f(TouchImageView.this.getMeasuredHeight(), TouchImageView.h(TouchImageView.this) * 6.0F, f2, 0.0F);
          TouchImageView.this.clearAnimation();
          paramAnonymousScaleGestureDetector = new TouchImageView.d(TouchImageView.this, 6.0F, f1 + f3, f2 + f4);
          paramAnonymousScaleGestureDetector.setDuration(200L);
          TouchImageView.this.startAnimation(paramAnonymousScaleGestureDetector);
          TouchImageView.a(TouchImageView.this, true);
        }
        do
        {
          return;
          f1 = f2;
          if (f2 < TouchImageView.p(TouchImageView.this)) {
            f1 = TouchImageView.p(TouchImageView.this);
          }
          f3 = TouchImageView.f(TouchImageView.this);
          f2 = TouchImageView.h(TouchImageView.this);
          f3 = TouchImageView.f(TouchImageView.this.getMeasuredWidth(), f3 * f1, TouchImageView.i(TouchImageView.this), 0.0F);
          f1 = TouchImageView.f(TouchImageView.this.getMeasuredHeight(), f1 * f2, TouchImageView.j(TouchImageView.this), 0.0F);
        } while ((Math.abs(f3) < 1.0F) && (Math.abs(f1) < 1.0F));
        f2 = f3 + TouchImageView.i(TouchImageView.this);
        float f1 = TouchImageView.j(TouchImageView.this) + f1;
        TouchImageView.this.clearAnimation();
        if (TouchImageView.g(TouchImageView.this) < TouchImageView.p(TouchImageView.this)) {}
        for (paramAnonymousScaleGestureDetector = new TouchImageView.d(TouchImageView.this, TouchImageView.p(TouchImageView.this), f2, f1);; paramAnonymousScaleGestureDetector = new TouchImageView.d(TouchImageView.this, TouchImageView.g(TouchImageView.this), f2, f1))
        {
          paramAnonymousScaleGestureDetector.setDuration(200L);
          TouchImageView.this.startAnimation(paramAnonymousScaleGestureDetector);
          TouchImageView.a(TouchImageView.this, true);
          return;
        }
      }
      
      public boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        if (TouchImageView.d(TouchImageView.this)) {
          return false;
        }
        TouchImageView.e(TouchImageView.this);
        float f3 = TouchImageView.f(TouchImageView.this);
        float f4 = TouchImageView.g(TouchImageView.this);
        float f1 = TouchImageView.h(TouchImageView.this);
        float f2 = TouchImageView.g(TouchImageView.this);
        paramAnonymousFloat1 = TouchImageView.f(TouchImageView.this.getMeasuredWidth(), f3 * f4, TouchImageView.i(TouchImageView.this), -paramAnonymousFloat1);
        paramAnonymousFloat2 = TouchImageView.f(TouchImageView.this.getMeasuredHeight(), f1 * f2, TouchImageView.j(TouchImageView.this), -paramAnonymousFloat2);
        TouchImageView.k(TouchImageView.this).postTranslate(paramAnonymousFloat1, paramAnonymousFloat2);
        TouchImageView.this.clearAnimation();
        p.d(TouchImageView.this);
        return true;
      }
      
      public boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        if (TouchImageView.a(TouchImageView.this) != null)
        {
          float f = TouchImageView.a(TouchImageView.this, paramAnonymousMotionEvent.getX(), paramAnonymousMotionEvent.getY());
          int i = getWidth();
          if (TouchImageView.b(TouchImageView.this)) {
            i = getHeight();
          }
          if (f < TouchImageView.c(TouchImageView.this))
          {
            TouchImageView.a(TouchImageView.this).GM();
            return true;
          }
          if (f > i - TouchImageView.c(TouchImageView.this))
          {
            TouchImageView.a(TouchImageView.this).GN();
            return true;
          }
        }
        return TouchImageView.this.performClick();
      }
    });
    this.aOX = (paramContext.getResources().getDisplayMetrics().density * 48.0F);
    super.setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private float j(float paramFloat1, float paramFloat2)
  {
    float f = paramFloat2;
    switch (this.aEI)
    {
    default: 
      f = paramFloat1;
    case 270: 
      return f;
    case 180: 
      return getWidth() - paramFloat1;
    }
    return getHeight() - paramFloat2;
  }
  
  public int KU()
  {
    return this.aEI;
  }
  
  public void a(a parama)
  {
    this.aOW = parama;
  }
  
  public void a(c paramc)
  {
    this.aOY = paramc;
  }
  
  public void b(TextView paramTextView)
  {
    this.aED = paramTextView;
  }
  
  public void bx(boolean paramBoolean)
  {
    if (this.aOd) {
      KO();
    }
    this.aOd = paramBoolean;
    if ((this.aON instanceof e)) {
      ((e)this.aON).bx(this.aOd);
    }
    invalidate();
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    KS();
    float f1 = this.mTranslationX;
    int j = this.aOO;
    int i = getMeasuredWidth();
    switch (this.aEI)
    {
    default: 
      if (paramInt > 0) {
        if (Math.round(f1) >= 0) {
          break;
        }
      }
      break;
    }
    float f2;
    float f3;
    do
    {
      return true;
      f1 = this.mTranslationY;
      j = this.aOP;
      i = getMeasuredHeight();
      paramInt = -paramInt;
      break;
      paramInt = -paramInt;
      break;
      f1 = this.mTranslationY;
      j = this.aOP;
      i = getMeasuredHeight();
      break;
      return false;
      if (paramInt >= 0) {
        break label157;
      }
      f2 = j;
      f3 = this.alP;
    } while (Math.round(f1) > i - Math.round(f2 * f3));
    return false;
    label157:
    return false;
  }
  
  public void clearAnimation()
  {
    super.clearAnimation();
    this.aOU = false;
  }
  
  public void gJ(int paramInt)
  {
    if (paramInt != this.aEI) {
      this.aOV = false;
    }
    this.aEI = paramInt;
    this.aOQ.gJ(paramInt);
  }
  
  public Matrix getImageMatrix()
  {
    return this.mMatrix;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.aOV) {
      KV();
    }
    super.setImageMatrix(this.mMatrix);
    super.onDraw(paramCanvas);
    if ((this.aOd) && (this.aED != null))
    {
      this.mMatrix.getValues(this.aKI);
      this.aED.setText(String.format(" %d %%", new Object[] { Integer.valueOf(Math.round(this.aKI[0] * 100.0F)) }));
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = getMeasuredWidth();
    int m = getMeasuredHeight();
    int j;
    int i;
    if (KQ())
    {
      j = View.MeasureSpec.getSize(paramInt1);
      i = View.MeasureSpec.getSize(paramInt2);
      ViewParent localViewParent = getParent();
      if (!(localViewParent instanceof View)) {
        break label121;
      }
      j = ((View)localViewParent).getMeasuredWidth();
      i = ((View)localViewParent).getMeasuredHeight();
    }
    label121:
    for (;;)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.getMode(paramInt1)), View.MeasureSpec.makeMeasureSpec(j, View.MeasureSpec.getMode(paramInt2)));
      for (;;)
      {
        if ((k != getMeasuredWidth()) || (m != getMeasuredHeight()))
        {
          KR();
          this.aOV = false;
        }
        return;
        super.onMeasure(paramInt1, paramInt2);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.aOQ.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void reset()
  {
    KR();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.aON != paramDrawable)
    {
      this.aON = paramDrawable;
      if (paramDrawable != null)
      {
        this.aOO = paramDrawable.getIntrinsicWidth();
        this.aOP = paramDrawable.getIntrinsicHeight();
        KR();
      }
    }
    else
    {
      return;
    }
    this.aOO = 0;
    this.aOP = 0;
  }
  
  public void setImageMatrix(Matrix paramMatrix)
  {
    Matrix localMatrix = paramMatrix;
    if (paramMatrix == null) {
      localMatrix = new Matrix();
    }
    if (!this.mMatrix.equals(localMatrix))
    {
      this.mMatrix.set(localMatrix);
      this.aOZ = true;
      invalidate();
    }
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType != ImageView.ScaleType.MATRIX) {
      throw new IllegalArgumentException("Unsupported scaleType. Only ScaleType.MATRIX is allowed.");
    }
    super.setScaleType(paramScaleType);
  }
  
  public static abstract interface a
  {
    public abstract void GM();
    
    public abstract void GN();
  }
  
  private class b
    extends Animation
  {
    private b() {}
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      TouchImageView.l(TouchImageView.this).V(paramFloat);
      TouchImageView.e(TouchImageView.this);
      paramFloat = TouchImageView.l(TouchImageView.this).getCurrX();
      float f1 = TouchImageView.i(TouchImageView.this);
      float f2 = TouchImageView.l(TouchImageView.this).getCurrY();
      float f3 = TouchImageView.j(TouchImageView.this);
      TouchImageView.k(TouchImageView.this).postTranslate(paramFloat - f1, f2 - f3);
      p.d(TouchImageView.this);
    }
  }
  
  public static abstract interface c
  {
    public abstract void onReset();
  }
  
  private class d
    extends Animation
  {
    private float aPh;
    private float aPi;
    private float aPj;
    private float aPk;
    private float aPl;
    private float aPm;
    
    d(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      TouchImageView.e(TouchImageView.this);
      this.aPh = TouchImageView.g(TouchImageView.this);
      this.aPi = TouchImageView.i(TouchImageView.this);
      this.aPj = TouchImageView.j(TouchImageView.this);
      this.aPk = paramFloat1;
      this.aPl = paramFloat2;
      this.aPm = paramFloat3;
      TouchImageView.m(TouchImageView.this);
    }
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      TouchImageView.e(TouchImageView.this);
      if (paramFloat >= 1.0F)
      {
        TouchImageView.k(TouchImageView.this).getValues(TouchImageView.s(TouchImageView.this));
        TouchImageView.s(TouchImageView.this)[0] = this.aPk;
        TouchImageView.s(TouchImageView.this)[4] = this.aPk;
        TouchImageView.s(TouchImageView.this)[2] = this.aPl;
        TouchImageView.s(TouchImageView.this)[5] = this.aPm;
        TouchImageView.k(TouchImageView.this).setValues(TouchImageView.s(TouchImageView.this));
        TouchImageView.q(TouchImageView.this);
      }
      for (;;)
      {
        p.d(TouchImageView.this);
        return;
        float f1 = (this.aPh + (this.aPk - this.aPh) * paramFloat) / TouchImageView.g(TouchImageView.this);
        TouchImageView.k(TouchImageView.this).postScale(f1, f1);
        TouchImageView.k(TouchImageView.this).getValues(TouchImageView.s(TouchImageView.this));
        f1 = TouchImageView.s(TouchImageView.this)[2];
        float f2 = TouchImageView.s(TouchImageView.this)[5];
        float f3 = this.aPi;
        float f4 = this.aPl;
        float f5 = this.aPi;
        float f6 = this.aPj;
        float f7 = this.aPm;
        float f8 = this.aPj;
        TouchImageView.k(TouchImageView.this).postTranslate(f3 + (f4 - f5) * paramFloat - f1, f6 + (f7 - f8) * paramFloat - f2);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/photoimageview/TouchImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */