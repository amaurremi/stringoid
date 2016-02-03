package uk.co.senab.photoview;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.lang.ref.WeakReference;

public class b
  implements GestureDetector.OnDoubleTapListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, uk.co.senab.photoview.a.f
{
  static final Interpolator a = new AccelerateDecelerateInterpolator();
  private float A = 0.0F;
  private float b = 1.0F;
  private float c = 1.75F;
  private float d = 3.0F;
  private boolean e = true;
  private WeakReference f;
  private GestureDetector g;
  private uk.co.senab.photoview.a.e h;
  private final Matrix i = new Matrix();
  private final Matrix j = new Matrix();
  private final Matrix k = new Matrix();
  private final RectF l = new RectF();
  private final float[] m = new float[9];
  private g n;
  private h o;
  private j p;
  private View.OnLongClickListener q;
  private i r;
  private int s;
  private int t;
  private int u;
  private int v;
  private f w;
  private int x = 2;
  private boolean y;
  private ImageView.ScaleType z = ImageView.ScaleType.FIT_CENTER;
  
  public b(ImageView paramImageView)
  {
    this.f = new WeakReference(paramImageView);
    paramImageView.setOnTouchListener(this);
    ViewTreeObserver localViewTreeObserver = paramImageView.getViewTreeObserver();
    if (localViewTreeObserver != null) {
      localViewTreeObserver.addOnGlobalLayoutListener(this);
    }
    b(paramImageView);
    if (paramImageView.isInEditMode()) {
      return;
    }
    this.h = uk.co.senab.photoview.a.g.a(paramImageView.getContext(), this);
    this.g = new GestureDetector(paramImageView.getContext(), new c(this));
    this.g.setOnDoubleTapListener(this);
    a(true);
  }
  
  private float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.m);
    return this.m[paramInt];
  }
  
  private RectF a(Matrix paramMatrix)
  {
    Object localObject = c();
    if (localObject != null)
    {
      localObject = ((ImageView)localObject).getDrawable();
      if (localObject != null)
      {
        this.l.set(0.0F, 0.0F, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
        paramMatrix.mapRect(this.l);
        return this.l;
      }
    }
    return null;
  }
  
  private void a(Drawable paramDrawable)
  {
    Object localObject = c();
    if ((localObject == null) || (paramDrawable == null)) {
      return;
    }
    float f1 = c((ImageView)localObject);
    float f2 = d((ImageView)localObject);
    int i1 = paramDrawable.getIntrinsicWidth();
    int i2 = paramDrawable.getIntrinsicHeight();
    this.i.reset();
    float f3 = f1 / i1;
    float f4 = f2 / i2;
    if (this.z == ImageView.ScaleType.CENTER) {
      this.i.postTranslate((f1 - i1) / 2.0F, (f2 - i2) / 2.0F);
    }
    for (;;)
    {
      l();
      return;
      if (this.z == ImageView.ScaleType.CENTER_CROP)
      {
        f3 = Math.max(f3, f4);
        this.i.postScale(f3, f3);
        this.i.postTranslate((f1 - i1 * f3) / 2.0F, (f2 - i2 * f3) / 2.0F);
      }
      else if (this.z == ImageView.ScaleType.CENTER_INSIDE)
      {
        f3 = Math.min(1.0F, Math.min(f3, f4));
        this.i.postScale(f3, f3);
        this.i.postTranslate((f1 - i1 * f3) / 2.0F, (f2 - i2 * f3) / 2.0F);
      }
      else
      {
        paramDrawable = new RectF(0.0F, 0.0F, i1, i2);
        localObject = new RectF(0.0F, 0.0F, f1, f2);
        switch (d.a[this.z.ordinal()])
        {
        default: 
          break;
        case 2: 
          this.i.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.START);
          break;
        case 4: 
          this.i.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.CENTER);
          break;
        case 3: 
          this.i.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.END);
          break;
        case 5: 
          this.i.setRectToRect(paramDrawable, (RectF)localObject, Matrix.ScaleToFit.FILL);
        }
      }
    }
  }
  
  private static boolean a(ImageView paramImageView)
  {
    return (paramImageView != null) && (paramImageView.getDrawable() != null);
  }
  
  private void b(Matrix paramMatrix)
  {
    ImageView localImageView = c();
    if (localImageView != null)
    {
      j();
      localImageView.setImageMatrix(paramMatrix);
      if (this.n != null)
      {
        paramMatrix = a(paramMatrix);
        if (paramMatrix != null) {
          this.n.a(paramMatrix);
        }
      }
    }
  }
  
  private static void b(ImageView paramImageView)
  {
    if ((paramImageView != null) && (!(paramImageView instanceof PhotoView)) && (!ImageView.ScaleType.MATRIX.equals(paramImageView.getScaleType()))) {
      paramImageView.setScaleType(ImageView.ScaleType.MATRIX);
    }
  }
  
  private static boolean b(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == null) {
      return false;
    }
    switch (d.a[paramScaleType.ordinal()])
    {
    default: 
      return true;
    }
    throw new IllegalArgumentException(paramScaleType.name() + " is not supported in PhotoView");
  }
  
  private int c(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return 0;
    }
    return paramImageView.getWidth() - paramImageView.getPaddingLeft() - paramImageView.getPaddingRight();
  }
  
  private int d(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return 0;
    }
    return paramImageView.getHeight() - paramImageView.getPaddingTop() - paramImageView.getPaddingBottom();
  }
  
  private void h()
  {
    if (this.w != null)
    {
      this.w.a();
      this.w = null;
    }
  }
  
  private void i()
  {
    if (k()) {
      b(g());
    }
  }
  
  private void j()
  {
    ImageView localImageView = c();
    if ((localImageView != null) && (!(localImageView instanceof PhotoView)) && (!ImageView.ScaleType.MATRIX.equals(localImageView.getScaleType()))) {
      throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
    }
  }
  
  private boolean k()
  {
    float f2 = 0.0F;
    ImageView localImageView = c();
    if (localImageView == null) {
      return false;
    }
    RectF localRectF = a(g());
    if (localRectF == null) {
      return false;
    }
    float f1 = localRectF.height();
    float f3 = localRectF.width();
    int i1 = d(localImageView);
    if (f1 <= i1) {
      switch (d.a[this.z.ordinal()])
      {
      default: 
        f1 = (i1 - f1) / 2.0F - localRectF.top;
      }
    }
    for (;;)
    {
      i1 = c(localImageView);
      if (f3 <= i1) {
        switch (d.a[this.z.ordinal()])
        {
        default: 
          f2 = (i1 - f3) / 2.0F - localRectF.left;
          label170:
          this.x = 2;
        }
      }
      for (;;)
      {
        this.k.postTranslate(f2, f1);
        return true;
        f1 = -localRectF.top;
        break;
        f1 = i1 - f1 - localRectF.top;
        break;
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break;
        }
        if (localRectF.bottom >= i1) {
          break label345;
        }
        f1 = i1 - localRectF.bottom;
        break;
        f2 = -localRectF.left;
        break label170;
        f2 = i1 - f3 - localRectF.left;
        break label170;
        if (localRectF.left > 0.0F)
        {
          this.x = 0;
          f2 = -localRectF.left;
        }
        else if (localRectF.right < i1)
        {
          f2 = i1 - localRectF.right;
          this.x = 1;
        }
        else
        {
          this.x = -1;
        }
      }
      label345:
      f1 = 0.0F;
    }
  }
  
  private void l()
  {
    this.k.reset();
    b(g());
    k();
  }
  
  public final void a()
  {
    if (this.f == null) {
      return;
    }
    ImageView localImageView = (ImageView)this.f.get();
    if (localImageView != null)
    {
      ViewTreeObserver localViewTreeObserver = localImageView.getViewTreeObserver();
      if ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive())) {
        localViewTreeObserver.removeGlobalOnLayoutListener(this);
      }
      localImageView.setOnTouchListener(null);
      h();
    }
    if (this.g != null) {
      this.g.setOnDoubleTapListener(null);
    }
    this.n = null;
    this.o = null;
    this.p = null;
    this.f = null;
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    Object localObject = c();
    this.k.postTranslate(paramFloat1, paramFloat2);
    i();
    if ((this.e) && (!this.h.a()) && ((this.x == 2) || ((this.x == 0) && (paramFloat1 >= 1.0F)) || ((this.x == 1) && (paramFloat1 <= -1.0F))))
    {
      localObject = ((ImageView)localObject).getParent();
      if (localObject != null) {
        ((ViewParent)localObject).requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((d() < this.d) || (paramFloat1 < 1.0F))
    {
      this.k.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      i();
    }
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    ImageView localImageView = c();
    this.w = new f(this, localImageView.getContext());
    this.w.a(c(localImageView), d(localImageView), (int)paramFloat3, (int)paramFloat4);
    localImageView.post(this.w);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    ImageView localImageView = c();
    if ((localImageView == null) || (paramFloat1 < this.b) || (paramFloat1 > this.d)) {
      return;
    }
    if (paramBoolean)
    {
      localImageView.post(new e(this, d(), paramFloat1, paramFloat2, paramFloat3));
      return;
    }
    this.k.setScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    i();
  }
  
  public final void a(View.OnLongClickListener paramOnLongClickListener)
  {
    this.q = paramOnLongClickListener;
  }
  
  public final void a(ImageView.ScaleType paramScaleType)
  {
    if ((b(paramScaleType)) && (paramScaleType != this.z))
    {
      this.z = paramScaleType;
      f();
    }
  }
  
  public final void a(j paramj)
  {
    this.p = paramj;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.y = paramBoolean;
    f();
  }
  
  public final RectF b()
  {
    k();
    return a(g());
  }
  
  public final ImageView c()
  {
    ImageView localImageView = null;
    if (this.f != null) {
      localImageView = (ImageView)this.f.get();
    }
    if (localImageView == null)
    {
      a();
      Log.i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
    }
    return localImageView;
  }
  
  public final float d()
  {
    return (float)Math.sqrt((float)Math.pow(a(this.k, 0), 2.0D) + (float)Math.pow(a(this.k, 3), 2.0D));
  }
  
  public final ImageView.ScaleType e()
  {
    return this.z;
  }
  
  public final void f()
  {
    ImageView localImageView = c();
    if (localImageView != null)
    {
      if (this.y)
      {
        b(localImageView);
        a(localImageView.getDrawable());
      }
    }
    else {
      return;
    }
    l();
  }
  
  protected Matrix g()
  {
    this.j.set(this.i);
    this.j.postConcat(this.k);
    return this.j;
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    try
    {
      float f1 = d();
      float f2 = paramMotionEvent.getX();
      float f3 = paramMotionEvent.getY();
      if (f1 < this.c)
      {
        a(this.c, f2, f3, true);
        return true;
      }
      if ((f1 >= this.c) && (f1 < this.d))
      {
        a(this.d, f2, f3, true);
        return true;
      }
      a(this.b, f2, f3, true);
      return true;
    }
    catch (ArrayIndexOutOfBoundsException paramMotionEvent) {}
    return true;
  }
  
  public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final void onGlobalLayout()
  {
    ImageView localImageView = c();
    if ((localImageView != null) && (this.y))
    {
      int i1 = localImageView.getTop();
      int i2 = localImageView.getRight();
      int i3 = localImageView.getBottom();
      int i4 = localImageView.getLeft();
      if ((i1 != this.s) || (i3 != this.u) || (i4 != this.v) || (i2 != this.t))
      {
        a(localImageView.getDrawable());
        this.s = i1;
        this.t = i2;
        this.u = i3;
        this.v = i4;
      }
    }
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    ImageView localImageView = c();
    if (this.o != null)
    {
      RectF localRectF = b();
      if (localRectF != null)
      {
        float f2 = paramMotionEvent.getX();
        float f1 = paramMotionEvent.getY();
        if (localRectF.contains(f2, f1))
        {
          f2 = (f2 - localRectF.left) / localRectF.width();
          f1 = (f1 - localRectF.top) / localRectF.height();
          this.o.a(localImageView, f2, f1);
          return true;
        }
      }
    }
    if (this.p != null) {
      this.p.a(localImageView, paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    return false;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    ViewParent localViewParent;
    if (this.y)
    {
      bool1 = bool2;
      if (a((ImageView)paramView))
      {
        if (this.r != null) {
          this.r.a(paramView, paramMotionEvent);
        }
        localViewParent = paramView.getParent();
        switch (paramMotionEvent.getAction())
        {
        case 2: 
        default: 
          bool1 = false;
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (this.g != null)
      {
        bool2 = bool1;
        if (this.g.onTouchEvent(paramMotionEvent)) {
          bool2 = true;
        }
      }
      if ((!bool2) && (localViewParent != null)) {
        localViewParent.requestDisallowInterceptTouchEvent(false);
      }
      if ((this.h == null) || (!this.h.c(paramMotionEvent))) {
        break label249;
      }
      bool1 = true;
      return bool1;
      if (localViewParent != null) {
        localViewParent.requestDisallowInterceptTouchEvent(true);
      }
      for (;;)
      {
        h();
        bool1 = false;
        break;
        Log.i("PhotoViewAttacher", "onTouch getParent() returned null");
      }
      if (d() >= this.b) {
        break;
      }
      RectF localRectF = b();
      if (localRectF == null) {
        break;
      }
      paramView.post(new e(this, d(), this.b, localRectF.centerX(), localRectF.centerY()));
      bool1 = true;
    }
    label249:
    return bool2;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/uk/co/senab/photoview/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */