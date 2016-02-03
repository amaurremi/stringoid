package com.venticake.retrica.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.venticake.retrica.util.UserInterfaceUtil;

public class RetricaToolbarBodyLayout
  extends RelativeLayout
{
  private final int CAPTURE_BUTTON_MARGIN_IN_DP = 8;
  private int CAPTURE_BUTTON_MARGIN_IN_PX = 0;
  private final int MAX_CAPTURE_BUTTON_WIDTH_IN_DP = 74;
  private int MAX_CAPTURE_BUTTON_WIDTH_IN_PX = 0;
  private final int MIN_HEIGHT_IN_DP = 60;
  private int MIN_HEIGHT_IN_PX = 0;
  public ImageButton albumButton;
  public TextView albumButtonTextView;
  public ImageButton captureButton;
  public ImageButton filterButton;
  public TextView filterButtonTextView;
  private boolean hideFilterButton = false;
  private boolean hideRandomFilterButton = false;
  private Paint overlayPaint;
  public ImageButton randomFilterButton;
  public TextView randomFilterButtonTextView;
  
  public RetricaToolbarBodyLayout(Context paramContext)
  {
    super(paramContext);
    _init(paramContext);
  }
  
  public RetricaToolbarBodyLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    _init(paramContext);
  }
  
  public RetricaToolbarBodyLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    _init(paramContext);
  }
  
  private void _init(Context paramContext)
  {
    this.MAX_CAPTURE_BUTTON_WIDTH_IN_PX = UserInterfaceUtil.dp2px(74.0F, this);
    this.CAPTURE_BUTTON_MARGIN_IN_PX = UserInterfaceUtil.dp2px(8.0F, this);
    this.MIN_HEIGHT_IN_PX = UserInterfaceUtil.dp2px(60.0F, this);
  }
  
  public int getMinHeightInPx()
  {
    return this.MIN_HEIGHT_IN_PX;
  }
  
  public boolean isHideFilterButton()
  {
    return this.hideFilterButton;
  }
  
  public boolean isHideRandomFilterButton()
  {
    return this.hideRandomFilterButton;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Log.d("retrica", "toolbar.body - layout: " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    Log.d("retrica", "toolbar.body - measured: " + paramInt1 + ", " + paramInt2);
    Log.d("retrica", "toolbar.body - size: " + getMeasuredWidth() + ", " + getMeasuredHeight());
    updateTextViewVisibles();
  }
  
  public void setHideFilterButton(boolean paramBoolean)
  {
    this.hideFilterButton = paramBoolean;
  }
  
  public void setHideRandomFilterButton(boolean paramBoolean)
  {
    this.hideRandomFilterButton = paramBoolean;
  }
  
  public void updateCaptureButtonSize(int paramInt)
  {
    int i = paramInt - this.CAPTURE_BUTTON_MARGIN_IN_PX;
    Log.d("retrica", "toolbar.body - toolbarBodyHeight: " + paramInt);
    Log.d("retrica", "toolbar.body - MAX_CAPTURE_BUTTON_WIDTH_IN_PX: " + this.MAX_CAPTURE_BUTTON_WIDTH_IN_PX);
    Log.d("retrica", "toolbar.body - prefer button height: " + i + " (actual: " + i + ", max: " + this.MAX_CAPTURE_BUTTON_WIDTH_IN_PX + ")");
    paramInt = paramInt * 2 / 3;
    int j = Math.max(paramInt, this.MAX_CAPTURE_BUTTON_WIDTH_IN_PX);
    Log.d("retrica", "toolbar.body - cal_max_in_px: " + paramInt);
    Log.d("retrica", "toolbar.body - actual_max_in_px: " + j);
    paramInt = i;
    if (i > j) {
      paramInt = j;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.captureButton.getLayoutParams();
    localLayoutParams.width = paramInt;
    localLayoutParams.height = paramInt;
    this.captureButton.setLayoutParams(localLayoutParams);
  }
  
  public void updateTextViewVisibles()
  {
    int j = 4;
    if ((this.albumButton == null) || (this.albumButtonTextView == null)) {}
    do
    {
      return;
      i = this.albumButton.getMeasuredHeight() + this.albumButtonTextView.getMeasuredHeight();
    } while (i < 1);
    if (i > getMeasuredHeight())
    {
      this.albumButtonTextView.setVisibility(8);
      this.filterButtonTextView.setVisibility(8);
      this.randomFilterButtonTextView.setVisibility(8);
      return;
    }
    this.albumButtonTextView.setVisibility(0);
    TextView localTextView = this.filterButtonTextView;
    if (isHideFilterButton())
    {
      i = 4;
      localTextView.setVisibility(i);
      localTextView = this.randomFilterButtonTextView;
      if (!isHideRandomFilterButton()) {
        break label126;
      }
    }
    label126:
    for (int i = j;; i = 0)
    {
      localTextView.setVisibility(i);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/RetricaToolbarBodyLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */