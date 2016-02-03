package com.ideashower.readitlater.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.ideashower.readitlater.h.m;
import com.ideashower.readitlater.views.toolbars.StyledToolbar;

public class at
  extends SeekBar
{
  public at(Context paramContext)
  {
    super(paramContext);
  }
  
  public at(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public at(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private Drawable getRealProgressDrawable()
  {
    Drawable localDrawable = getProgressDrawable();
    if ((localDrawable != null) && ((localDrawable instanceof LayerDrawable))) {
      return ((LayerDrawable)localDrawable).findDrawableByLayerId(16908301);
    }
    return null;
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 3);
    mergeDrawableStates(arrayOfInt, m.b(this));
    StyledToolbar.a(this, arrayOfInt);
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      Drawable localDrawable = getRealProgressDrawable();
      if (localDrawable != null)
      {
        localDrawable.setBounds(getProgressDrawable().getBounds());
        localDrawable.setState(getDrawableState());
      }
      super.onDraw(paramCanvas);
      return;
    }
    finally {}
  }
  
  public void refreshDrawableState()
  {
    super.refreshDrawableState();
    invalidate();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/ideashower/readitlater/views/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */