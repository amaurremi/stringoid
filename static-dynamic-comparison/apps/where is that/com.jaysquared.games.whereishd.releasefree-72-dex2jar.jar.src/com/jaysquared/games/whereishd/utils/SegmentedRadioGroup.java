package com.jaysquared.games.whereishd.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioGroup;

public class SegmentedRadioGroup
  extends RadioGroup
{
  public SegmentedRadioGroup(Context paramContext)
  {
    super(paramContext);
  }
  
  public SegmentedRadioGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void changeButtonsImages()
  {
    int j = super.getChildCount();
    if (j > 1)
    {
      super.getChildAt(0).setBackgroundResource(2130837694);
      i = 1;
      while (i < j - 1)
      {
        super.getChildAt(i).setBackgroundResource(2130837694);
        i += 1;
      }
      super.getChildAt(j - 1).setBackgroundResource(2130837694);
    }
    while (j != 1)
    {
      int i;
      return;
    }
    super.getChildAt(0).setBackgroundResource(2130837689);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    changeButtonsImages();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/utils/SegmentedRadioGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */