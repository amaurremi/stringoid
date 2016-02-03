package mobi.beyondpod.ui.views.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.widget.SeekBar;

public class SeekBarEx
  extends SeekBar
{
  boolean _WasDragged = false;
  private int mScaledTouchSlop;
  float mTouchDownX;
  
  public SeekBarEx(Context paramContext)
  {
    super(paramContext);
    Initilize();
  }
  
  public SeekBarEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Initilize();
  }
  
  public SeekBarEx(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Initilize();
  }
  
  private void Initilize()
  {
    this.mScaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  }
  
  public boolean WasDragged()
  {
    return this._WasDragged;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/base/SeekBarEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */