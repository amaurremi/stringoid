package mobi.beyondpod.ui.views.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import mobi.beyondpod.R.styleable;

public class TitleBarHomeButton
  extends FrameLayout
  implements TitleBarBase.ISelectableTab
{
  Drawable _LeftBackground;
  Drawable _MiddleBackground;
  
  public TitleBarHomeButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public TitleBarHomeButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void Initialize()
  {
    TypedArray localTypedArray = getContext().obtainStyledAttributes(R.styleable.TitleButtons);
    this._MiddleBackground = localTypedArray.getDrawable(7);
    this._LeftBackground = localTypedArray.getDrawable(6);
    localTypedArray.recycle();
    setBackgroundDrawable(this._MiddleBackground);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    Initialize();
  }
  
  public void onPause() {}
  
  public void setActive(boolean paramBoolean) {}
  
  public void setReadOnly(boolean paramBoolean) {}
  
  public void setTitle(TitleBarBase.TitleInfo paramTitleInfo) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/base/TitleBarHomeButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */