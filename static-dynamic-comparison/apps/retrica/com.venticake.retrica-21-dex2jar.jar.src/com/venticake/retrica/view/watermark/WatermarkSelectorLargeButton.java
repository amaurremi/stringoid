package com.venticake.retrica.view.watermark;

import android.content.Context;
import android.widget.TextView;
import com.venticake.retrica.engine.a.b;

public class WatermarkSelectorLargeButton
  extends WatermarkSelectorButton
{
  public WatermarkSelectorLargeButton(Context paramContext, b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  protected int getBackButtonHeightInDP()
  {
    return 75;
  }
  
  protected int getBackButtonMarginYInDP()
  {
    return 19;
  }
  
  protected int getBackButtonWidthInDP()
  {
    return 75;
  }
  
  protected int getLensHeightInDP()
  {
    return 114;
  }
  
  protected int getLensTextHeightInDP()
  {
    return 42;
  }
  
  protected int getLensWidthInDP()
  {
    return 72;
  }
  
  protected int getLockerTopMarginInDP()
  {
    return 12;
  }
  
  public int getPackHeightInDP()
  {
    return 114;
  }
  
  protected int getPackWidthInDP()
  {
    return 114;
  }
  
  protected void setLensTitleTextViewAppearance(Context paramContext, TextView paramTextView)
  {
    paramTextView.setTextAppearance(paramContext, 2131099800);
  }
  
  protected void setPackTitleTextViewAppearance(Context paramContext, TextView paramTextView)
  {
    paramTextView.setTextAppearance(paramContext, 2131099799);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/view/watermark/WatermarkSelectorLargeButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */