package mobi.beyondpod.ui.core;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import mobi.beyondpod.R.drawable;

public class TouchableFrameLayout
  extends FrameLayout
{
  private Drawable touchFeedbackDrawable;
  
  public TouchableFrameLayout(Context paramContext, int paramInt)
  {
    super(paramContext);
  }
  
  public TouchableFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TouchableFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    this.touchFeedbackDrawable.setBounds(0, 0, getWidth(), getHeight());
    this.touchFeedbackDrawable.draw(paramCanvas);
  }
  
  protected void drawableStateChanged()
  {
    if (this.touchFeedbackDrawable != null)
    {
      this.touchFeedbackDrawable.setState(getDrawableState());
      invalidate();
    }
    super.drawableStateChanged();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.touchFeedbackDrawable = getResources().getDrawable(R.drawable.touch_selector);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/TouchableFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */