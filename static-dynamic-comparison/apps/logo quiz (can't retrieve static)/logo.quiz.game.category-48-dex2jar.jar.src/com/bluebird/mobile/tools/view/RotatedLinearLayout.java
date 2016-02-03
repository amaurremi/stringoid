package com.bluebird.mobile.tools.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class RotatedLinearLayout
  extends LinearLayout
{
  private Matrix mForward = new Matrix();
  private Matrix mReverse = new Matrix();
  private float[] mTemp = new float[2];
  
  public RotatedLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public RotatedLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.rotate(-90.0F, getWidth() / 2, getHeight() / 2);
    this.mForward = paramCanvas.getMatrix();
    this.mForward.invert(this.mReverse);
    paramCanvas.save();
    paramCanvas.setMatrix(this.mForward);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
    invalidate();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float[] arrayOfFloat = this.mTemp;
    arrayOfFloat[0] = paramMotionEvent.getX();
    arrayOfFloat[1] = paramMotionEvent.getY();
    this.mReverse.mapPoints(arrayOfFloat);
    paramMotionEvent.setLocation(arrayOfFloat[0], arrayOfFloat[1]);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/view/RotatedLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */