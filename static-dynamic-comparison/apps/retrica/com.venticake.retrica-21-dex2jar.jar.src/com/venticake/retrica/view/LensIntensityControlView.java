package com.venticake.retrica.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.venticake.retrica.util.UserInterfaceUtil;

public class LensIntensityControlView
  extends View
{
  private final int HEIGHT_IN_DP = 40;
  private final int LEFT_BASE_IN_DP = 1;
  private final int LINE_HEIGHT_IN_DP = 4;
  private final int MARGIN_IN_DP = 18;
  private boolean editMode;
  private float height_in_px;
  private float intensity;
  private float left_base_in_px;
  private float line_height_in_px;
  private float margin_in_px;
  private LensIntensityControlView.OnEditModeChangeListener onEditModeChangeListener = null;
  private LensIntensityControlView.OnValueChangeListener onValueChangeListner = null;
  private Paint paint;
  
  public LensIntensityControlView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public LensIntensityControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public LensIntensityControlView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void didIntensityChanged()
  {
    if (this.onValueChangeListner != null) {
      this.onValueChangeListner.onValueChanged(this, this.intensity);
    }
  }
  
  private void enterEditMode()
  {
    this.editMode = true;
    if (this.onEditModeChangeListener != null) {
      this.onEditModeChangeListener.onEditModeChanged(this, this.editMode);
    }
  }
  
  private void exitEditMode()
  {
    this.editMode = false;
    if (this.onEditModeChangeListener != null) {
      this.onEditModeChangeListener.onEditModeChanged(this, this.editMode);
    }
  }
  
  private float getDrawingWidth(float paramFloat)
  {
    float f1 = getWidth();
    float f2 = this.left_base_in_px;
    return (f1 - this.left_base_in_px) * paramFloat + f2;
  }
  
  @SuppressLint({"ResourceAsColor"})
  private void init(Context paramContext)
  {
    this.height_in_px = UserInterfaceUtil.dp2px(40.0F, this);
    this.margin_in_px = UserInterfaceUtil.dp2px(18.0F, this);
    this.line_height_in_px = UserInterfaceUtil.dp2px(4.0F, this);
    this.left_base_in_px = UserInterfaceUtil.dp2px(1.0F, this);
    this.paint = new Paint(1);
    this.paint.setColor(-65536);
    this.paint.setStyle(Paint.Style.FILL);
    this.intensity = 1.0F;
    this.editMode = false;
  }
  
  public float getIntensity()
  {
    return this.intensity;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.editMode)
    {
      paramCanvas.drawRect(0.0F, 0.0F, getDrawingWidth(this.intensity), this.height_in_px, this.paint);
      return;
    }
    float f1 = this.margin_in_px;
    float f2 = getDrawingWidth(this.intensity);
    float f3 = this.margin_in_px;
    paramCanvas.drawRect(0.0F, f1, f2, this.line_height_in_px + f3, this.paint);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f = Math.max(0.0F, Math.min(1.0F, 0.5F + (paramMotionEvent.getX() - getWidth() / 2.0F) / getWidth() * 1.28F));
    switch (paramMotionEvent.getAction())
    {
    default: 
      setIntensity(f);
      didIntensityChanged();
    }
    for (;;)
    {
      return true;
      this.intensity = f;
      didIntensityChanged();
      enterEditMode();
      invalidate();
      continue;
      this.intensity = f;
      didIntensityChanged();
      exitEditMode();
      invalidate();
    }
  }
  
  public void setColor(int paramInt)
  {
    this.paint.setColor(paramInt);
  }
  
  public void setIntensity(float paramFloat)
  {
    if (this.intensity == paramFloat) {
      return;
    }
    this.intensity = paramFloat;
    invalidate();
  }
  
  public void setOnEditModeChangeListener(LensIntensityControlView.OnEditModeChangeListener paramOnEditModeChangeListener)
  {
    this.onEditModeChangeListener = paramOnEditModeChangeListener;
  }
  
  public void setOnValueChangeListener(LensIntensityControlView.OnValueChangeListener paramOnValueChangeListener)
  {
    this.onValueChangeListner = paramOnValueChangeListener;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/LensIntensityControlView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */