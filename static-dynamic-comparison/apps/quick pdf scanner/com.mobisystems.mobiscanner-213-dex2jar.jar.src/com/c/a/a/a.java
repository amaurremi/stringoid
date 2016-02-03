package com.c.a.a;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class a
  extends Animation
{
  public static final boolean NEEDS_PROXY;
  private static final WeakHashMap<View, a> PROXIES;
  private boolean aPn;
  private float aPo;
  private float aPp;
  private float aPq;
  private float aPr;
  private float aPs;
  private final Camera alQ = new Camera();
  private final RectF mAfter = new RectF();
  private float mAlpha = 1.0F;
  private final RectF mBefore = new RectF();
  private float mScaleX = 1.0F;
  private float mScaleY = 1.0F;
  private final Matrix mTempMatrix = new Matrix();
  private float mTranslationX;
  private float mTranslationY;
  private final WeakReference<View> mView;
  
  static
  {
    if (Integer.valueOf(Build.VERSION.SDK).intValue() < 11) {}
    for (boolean bool = true;; bool = false)
    {
      NEEDS_PROXY = bool;
      PROXIES = new WeakHashMap();
      return;
    }
  }
  
  private a(View paramView)
  {
    setDuration(0L);
    setFillAfter(true);
    paramView.setAnimation(this);
    this.mView = new WeakReference(paramView);
  }
  
  public static a ao(View paramView)
  {
    a locala2 = (a)PROXIES.get(paramView);
    a locala1;
    if (locala2 != null)
    {
      locala1 = locala2;
      if (locala2 == paramView.getAnimation()) {}
    }
    else
    {
      locala1 = new a(paramView);
      PROXIES.put(paramView, locala1);
    }
    return locala1;
  }
  
  private void computeRect(RectF paramRectF, View paramView)
  {
    paramRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    Matrix localMatrix = this.mTempMatrix;
    localMatrix.reset();
    transformMatrix(localMatrix, paramView);
    this.mTempMatrix.mapRect(paramRectF);
    paramRectF.offset(paramView.getLeft(), paramView.getTop());
    float f;
    if (paramRectF.right < paramRectF.left)
    {
      f = paramRectF.right;
      paramRectF.right = paramRectF.left;
      paramRectF.left = f;
    }
    if (paramRectF.bottom < paramRectF.top)
    {
      f = paramRectF.top;
      paramRectF.top = paramRectF.bottom;
      paramRectF.bottom = f;
    }
  }
  
  private void invalidateAfterUpdate()
  {
    View localView = (View)this.mView.get();
    if ((localView == null) || (localView.getParent() == null)) {
      return;
    }
    RectF localRectF = this.mAfter;
    computeRect(localRectF, localView);
    localRectF.union(this.mBefore);
    ((View)localView.getParent()).invalidate((int)Math.floor(localRectF.left), (int)Math.floor(localRectF.top), (int)Math.ceil(localRectF.right), (int)Math.ceil(localRectF.bottom));
  }
  
  private void prepareForUpdate()
  {
    View localView = (View)this.mView.get();
    if (localView != null) {
      computeRect(this.mBefore, localView);
    }
  }
  
  private void transformMatrix(Matrix paramMatrix, View paramView)
  {
    float f3 = paramView.getWidth();
    float f4 = paramView.getHeight();
    boolean bool = this.aPn;
    float f1;
    if (bool)
    {
      f1 = this.aPo;
      if (!bool) {
        break label226;
      }
    }
    label226:
    for (float f2 = this.aPp;; f2 = f4 / 2.0F)
    {
      float f5 = this.aPq;
      float f6 = this.aPr;
      float f7 = this.aPs;
      if ((f5 != 0.0F) || (f6 != 0.0F) || (f7 != 0.0F))
      {
        paramView = this.alQ;
        paramView.save();
        paramView.rotateX(f5);
        paramView.rotateY(f6);
        paramView.rotateZ(-f7);
        paramView.getMatrix(paramMatrix);
        paramView.restore();
        paramMatrix.preTranslate(-f1, -f2);
        paramMatrix.postTranslate(f1, f2);
      }
      f5 = this.mScaleX;
      f6 = this.mScaleY;
      if ((f5 != 1.0F) || (f6 != 1.0F))
      {
        paramMatrix.postScale(f5, f6);
        paramMatrix.postTranslate(-(f1 / f3) * (f5 * f3 - f3), -(f2 / f4) * (f6 * f4 - f4));
      }
      paramMatrix.postTranslate(this.mTranslationX, this.mTranslationY);
      return;
      f1 = f3 / 2.0F;
      break;
    }
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    View localView = (View)this.mView.get();
    if (localView != null)
    {
      paramTransformation.setAlpha(this.mAlpha);
      transformMatrix(paramTransformation.getMatrix(), localView);
    }
  }
  
  public float getAlpha()
  {
    return this.mAlpha;
  }
  
  public float getRotation()
  {
    return this.aPs;
  }
  
  public float getRotationX()
  {
    return this.aPq;
  }
  
  public float getRotationY()
  {
    return this.aPr;
  }
  
  public float getScaleX()
  {
    return this.mScaleX;
  }
  
  public float getScaleY()
  {
    return this.mScaleY;
  }
  
  public float getTranslationX()
  {
    return this.mTranslationX;
  }
  
  public float getTranslationY()
  {
    return this.mTranslationY;
  }
  
  public void setAlpha(float paramFloat)
  {
    if (this.mAlpha != paramFloat)
    {
      this.mAlpha = paramFloat;
      View localView = (View)this.mView.get();
      if (localView != null) {
        localView.invalidate();
      }
    }
  }
  
  public void setPivotX(float paramFloat)
  {
    if ((!this.aPn) || (this.aPo != paramFloat))
    {
      prepareForUpdate();
      this.aPn = true;
      this.aPo = paramFloat;
      invalidateAfterUpdate();
    }
  }
  
  public void setPivotY(float paramFloat)
  {
    if ((!this.aPn) || (this.aPp != paramFloat))
    {
      prepareForUpdate();
      this.aPn = true;
      this.aPp = paramFloat;
      invalidateAfterUpdate();
    }
  }
  
  public void setRotation(float paramFloat)
  {
    if (this.aPs != paramFloat)
    {
      prepareForUpdate();
      this.aPs = paramFloat;
      invalidateAfterUpdate();
    }
  }
  
  public void setRotationX(float paramFloat)
  {
    if (this.aPq != paramFloat)
    {
      prepareForUpdate();
      this.aPq = paramFloat;
      invalidateAfterUpdate();
    }
  }
  
  public void setRotationY(float paramFloat)
  {
    if (this.aPr != paramFloat)
    {
      prepareForUpdate();
      this.aPr = paramFloat;
      invalidateAfterUpdate();
    }
  }
  
  public void setScaleX(float paramFloat)
  {
    if (this.mScaleX != paramFloat)
    {
      prepareForUpdate();
      this.mScaleX = paramFloat;
      invalidateAfterUpdate();
    }
  }
  
  public void setScaleY(float paramFloat)
  {
    if (this.mScaleY != paramFloat)
    {
      prepareForUpdate();
      this.mScaleY = paramFloat;
      invalidateAfterUpdate();
    }
  }
  
  public void setTranslationX(float paramFloat)
  {
    if (this.mTranslationX != paramFloat)
    {
      prepareForUpdate();
      this.mTranslationX = paramFloat;
      invalidateAfterUpdate();
    }
  }
  
  public void setTranslationY(float paramFloat)
  {
    if (this.mTranslationY != paramFloat)
    {
      prepareForUpdate();
      this.mTranslationY = paramFloat;
      invalidateAfterUpdate();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/c/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */