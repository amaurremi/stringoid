package mobi.beyondpod.ui.dialogs;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class ColorPickerView
  extends View
{
  private static int CENTER_RADIUS = 25;
  private static int CENTER_X = 70;
  private static int CENTER_Y = 70;
  private static final float PI = 3.1415925F;
  private Paint mCenterPaint;
  private final int[] mColors = { -65536, -65281, -16776961, -16711681, -16711936, 65280, -65536 };
  private boolean mHighlightCenter;
  private ColorPickerDialog.OnColorChangedListener mListener;
  private Paint mPaint;
  private boolean mTrackingCenter;
  
  public ColorPickerView(Context paramContext)
  {
    super(paramContext);
    Initialize();
  }
  
  public ColorPickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Initialize();
  }
  
  public ColorPickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Initialize();
  }
  
  private void Initialize()
  {
    float f = getResources().getDisplayMetrics().density;
    SweepGradient localSweepGradient = new SweepGradient(0.0F, 0.0F, this.mColors, null);
    this.mPaint = new Paint(1);
    this.mPaint.setShader(localSweepGradient);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeWidth((int)(25.0F * f + 0.5F));
    this.mCenterPaint = new Paint(1);
    this.mCenterPaint.setStrokeWidth(5.0F);
  }
  
  private int ave(int paramInt1, int paramInt2, float paramFloat)
  {
    return Math.round((paramInt2 - paramInt1) * paramFloat) + paramInt1;
  }
  
  private int interpColor(int[] paramArrayOfInt, float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return paramArrayOfInt[0];
    }
    if (paramFloat >= 1.0F) {
      return paramArrayOfInt[(paramArrayOfInt.length - 1)];
    }
    paramFloat *= (paramArrayOfInt.length - 1);
    int j = (int)paramFloat;
    paramFloat -= j;
    int i = paramArrayOfInt[j];
    j = paramArrayOfInt[(j + 1)];
    return Color.argb(ave(Color.alpha(i), Color.alpha(j), paramFloat), ave(Color.red(i), Color.red(j), paramFloat), ave(Color.green(i), Color.green(j), paramFloat), ave(Color.blue(i), Color.blue(j), paramFloat));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f = CENTER_X - this.mPaint.getStrokeWidth() * 0.5F;
    paramCanvas.translate(CENTER_X, CENTER_X);
    paramCanvas.drawOval(new RectF(-f, -f, f, f), this.mPaint);
    paramCanvas.drawCircle(0.0F, 0.0F, CENTER_RADIUS, this.mCenterPaint);
    int i;
    if (this.mTrackingCenter)
    {
      i = this.mCenterPaint.getColor();
      this.mCenterPaint.setStyle(Paint.Style.STROKE);
      if (!this.mHighlightCenter) {
        break label146;
      }
      this.mCenterPaint.setAlpha(255);
    }
    for (;;)
    {
      paramCanvas.drawCircle(0.0F, 0.0F, CENTER_RADIUS + this.mCenterPaint.getStrokeWidth(), this.mCenterPaint);
      this.mCenterPaint.setStyle(Paint.Style.FILL);
      this.mCenterPaint.setColor(i);
      return;
      label146:
      this.mCenterPaint.setAlpha(128);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    paramInt1 = Math.min(localLayoutParams.width, localLayoutParams.height);
    setMeasuredDimension(paramInt1, paramInt1);
    paramInt2 = paramInt1 / 2;
    CENTER_Y = paramInt2;
    CENTER_X = paramInt2;
    CENTER_RADIUS = paramInt1 / 5;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX() - CENTER_X;
    float f2 = paramMotionEvent.getY() - CENTER_Y;
    boolean bool;
    if (FloatMath.sqrt(f1 * f1 + f2 * f2) <= CENTER_RADIUS)
    {
      bool = true;
      switch (paramMotionEvent.getAction())
      {
      }
    }
    label130:
    do
    {
      do
      {
        return true;
        bool = false;
        break;
        this.mTrackingCenter = bool;
        if (bool)
        {
          this.mHighlightCenter = true;
          invalidate();
          return true;
        }
        if (!this.mTrackingCenter) {
          break label130;
        }
      } while (this.mHighlightCenter == bool);
      this.mHighlightCenter = bool;
      invalidate();
      return true;
      f2 = (float)Math.atan2(f2, f1) / 6.283185F;
      f1 = f2;
      if (f2 < 0.0F) {
        f1 = f2 + 1.0F;
      }
      this.mCenterPaint.setColor(interpColor(this.mColors, f1));
      invalidate();
      return true;
    } while (!this.mTrackingCenter);
    if (bool) {
      this.mListener.colorChanged(this.mCenterPaint.getColor());
    }
    this.mTrackingCenter = false;
    invalidate();
    return true;
  }
  
  public void setInitialColor(int paramInt)
  {
    this.mCenterPaint.setColor(paramInt);
    invalidate();
  }
  
  public void setOnColorChangedListener(ColorPickerDialog.OnColorChangedListener paramOnColorChangedListener)
  {
    this.mListener = paramOnColorChangedListener;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/ColorPickerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */