package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Region.Op;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import com.chartboost.sdk.CBPreferences;
import com.chartboost.sdk.Libraries.CBOrientation.Difference;

public final class u
  extends FrameLayout
{
  private Matrix a = new Matrix();
  private Matrix b = new Matrix();
  private float[] c = new float[2];
  private View d;
  private RelativeLayout e;
  
  public u(Context paramContext)
  {
    super(paramContext);
    this.e = new RelativeLayout(paramContext);
    addView(this.e, new FrameLayout.LayoutParams(-1, -1));
    this.d = this.e;
  }
  
  public u(Context paramContext, View paramView)
  {
    super(paramContext);
    addView(paramView, new FrameLayout.LayoutParams(-1, -1));
    this.d = paramView;
  }
  
  public View a()
  {
    return this.d;
  }
  
  public void a(View paramView)
  {
    a(paramView, new RelativeLayout.LayoutParams(-2, -2));
  }
  
  public void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (this.e != null)
    {
      this.e.addView(paramView, paramLayoutParams);
      return;
    }
    throw new IllegalStateException("cannot call addViewToContainer() on CBRotatableContainer that was set up with a default view");
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    CBOrientation.Difference localDifference = CBPreferences.getInstance().getForcedOrientationDifference();
    int i = localDifference.getAsInt();
    if (localDifference == CBOrientation.Difference.ANGLE_0)
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    paramCanvas.save();
    paramCanvas.clipRect(0.0F, 0.0F, getWidth(), getHeight(), Region.Op.REPLACE);
    for (;;)
    {
      try
      {
        localObject = (ViewGroup)getParent();
      }
      catch (Exception localException1)
      {
        Object localObject;
        ViewGroup localViewGroup;
        int j;
        int k;
        continue;
      }
      try
      {
        localViewGroup = (ViewGroup)((View)localObject).getParent();
        if (!(localViewGroup instanceof ScrollView))
        {
          boolean bool = localViewGroup instanceof HorizontalScrollView;
          if (!bool) {}
        }
        else
        {
          localObject = localViewGroup;
        }
      }
      catch (Exception localException2) {}
    }
    j = getLeft() - ((View)localObject).getScrollX();
    k = getTop() - ((View)localObject).getScrollY();
    paramCanvas.clipRect(0 - j, 0 - k, ((View)localObject).getWidth() - j, ((View)localObject).getHeight() - k, Region.Op.INTERSECT);
    paramCanvas.translate(getWidth() / 2.0F, getHeight() / 2.0F);
    paramCanvas.rotate(i);
    if (localDifference.isOdd()) {
      paramCanvas.translate(-getHeight() / 2.0F, -getWidth() / 2.0F);
    }
    for (;;)
    {
      this.a = paramCanvas.getMatrix();
      this.a.invert(this.b);
      super.dispatchDraw(paramCanvas);
      paramCanvas.restore();
      return;
      paramCanvas.translate(-getWidth() / 2.0F, -getHeight() / 2.0F);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (CBPreferences.getInstance().getForcedOrientationDifference() == CBOrientation.Difference.ANGLE_0) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    float[] arrayOfFloat = this.c;
    arrayOfFloat[0] = paramMotionEvent.getRawX();
    arrayOfFloat[1] = paramMotionEvent.getRawY();
    this.b.mapPoints(arrayOfFloat);
    paramMotionEvent.setLocation(arrayOfFloat[0], arrayOfFloat[1]);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (CBPreferences.getInstance().getForcedOrientationDifference().isOdd())
    {
      super.onMeasure(paramInt2, paramInt1);
      setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    CBOrientation.Difference localDifference = CBPreferences.getInstance().getForcedOrientationDifference();
    ViewGroup.LayoutParams localLayoutParams = this.d.getLayoutParams();
    if (localDifference.isOdd())
    {
      paramInt3 = paramInt2;
      localLayoutParams.width = paramInt3;
      if (!localDifference.isOdd()) {
        break label117;
      }
    }
    for (;;)
    {
      localLayoutParams.height = paramInt1;
      this.d.setLayoutParams(localLayoutParams);
      this.d.measure(View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824));
      this.d.layout(0, 0, localLayoutParams.width, localLayoutParams.height);
      return;
      paramInt3 = paramInt1;
      break;
      label117:
      paramInt1 = paramInt2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */