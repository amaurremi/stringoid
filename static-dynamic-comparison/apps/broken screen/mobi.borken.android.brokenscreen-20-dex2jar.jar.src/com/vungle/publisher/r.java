package com.vungle.publisher;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class r
  extends Animation
{
  public static final boolean a;
  private static final WeakHashMap<View, r> n;
  public final WeakReference<View> b;
  public boolean c;
  public float d = 1.0F;
  public float e;
  public float f;
  public float g;
  public float h;
  public float i;
  public float j = 1.0F;
  public float k = 1.0F;
  public float l;
  public float m;
  private final Camera o = new Camera();
  private final RectF p = new RectF();
  private final RectF q = new RectF();
  private final Matrix r = new Matrix();
  
  static
  {
    if (Integer.valueOf(Build.VERSION.SDK).intValue() < 11) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      n = new WeakHashMap();
      return;
    }
  }
  
  private r(View paramView)
  {
    setDuration(0L);
    setFillAfter(true);
    paramView.setAnimation(this);
    this.b = new WeakReference(paramView);
  }
  
  public static r a(View paramView)
  {
    r localr2 = (r)n.get(paramView);
    r localr1;
    if (localr2 != null)
    {
      localr1 = localr2;
      if (localr2 == paramView.getAnimation()) {}
    }
    else
    {
      localr1 = new r(paramView);
      n.put(paramView, localr1);
    }
    return localr1;
  }
  
  private void a(Matrix paramMatrix, View paramView)
  {
    float f3 = paramView.getWidth();
    float f4 = paramView.getHeight();
    boolean bool = this.c;
    float f1;
    if (bool)
    {
      f1 = this.e;
      if (!bool) {
        break label226;
      }
    }
    label226:
    for (float f2 = this.f;; f2 = f4 / 2.0F)
    {
      float f5 = this.g;
      float f6 = this.h;
      float f7 = this.i;
      if ((f5 != 0.0F) || (f6 != 0.0F) || (f7 != 0.0F))
      {
        paramView = this.o;
        paramView.save();
        paramView.rotateX(f5);
        paramView.rotateY(f6);
        paramView.rotateZ(-f7);
        paramView.getMatrix(paramMatrix);
        paramView.restore();
        paramMatrix.preTranslate(-f1, -f2);
        paramMatrix.postTranslate(f1, f2);
      }
      f5 = this.j;
      f6 = this.k;
      if ((f5 != 1.0F) || (f6 != 1.0F))
      {
        paramMatrix.postScale(f5, f6);
        paramMatrix.postTranslate(-(f1 / f3) * (f5 * f3 - f3), -(f2 / f4) * (f6 * f4 - f4));
      }
      paramMatrix.postTranslate(this.l, this.m);
      return;
      f1 = f3 / 2.0F;
      break;
    }
  }
  
  private void a(RectF paramRectF, View paramView)
  {
    paramRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    Matrix localMatrix = this.r;
    localMatrix.reset();
    a(localMatrix, paramView);
    this.r.mapRect(paramRectF);
    paramRectF.offset(paramView.getLeft(), paramView.getTop());
    float f1;
    if (paramRectF.right < paramRectF.left)
    {
      f1 = paramRectF.right;
      paramRectF.right = paramRectF.left;
      paramRectF.left = f1;
    }
    if (paramRectF.bottom < paramRectF.top)
    {
      f1 = paramRectF.top;
      paramRectF.top = paramRectF.bottom;
      paramRectF.bottom = f1;
    }
  }
  
  public final void a()
  {
    View localView = (View)this.b.get();
    if (localView != null) {
      a(this.p, localView);
    }
  }
  
  public final void a(float paramFloat)
  {
    if (this.d != paramFloat)
    {
      this.d = paramFloat;
      View localView = (View)this.b.get();
      if (localView != null) {
        localView.invalidate();
      }
    }
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    View localView = (View)this.b.get();
    if (localView != null)
    {
      paramTransformation.setAlpha(this.d);
      a(paramTransformation.getMatrix(), localView);
    }
  }
  
  public final void b()
  {
    View localView = (View)this.b.get();
    if ((localView == null) || (localView.getParent() == null)) {
      return;
    }
    RectF localRectF = this.q;
    a(localRectF, localView);
    localRectF.union(this.p);
    ((View)localView.getParent()).invalidate((int)Math.floor(localRectF.left), (int)Math.floor(localRectF.top), (int)Math.ceil(localRectF.right), (int)Math.ceil(localRectF.bottom));
  }
  
  public final void b(float paramFloat)
  {
    if (this.l != paramFloat)
    {
      a();
      this.l = paramFloat;
      b();
    }
  }
  
  public final void c(float paramFloat)
  {
    if (this.m != paramFloat)
    {
      a();
      this.m = paramFloat;
      b();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */