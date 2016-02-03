package mobi.beyondpod.ui.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class DontPressWithParentRelativeLayout
  extends RelativeLayout
{
  public DontPressWithParentRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void setPressed(boolean paramBoolean)
  {
    if ((paramBoolean) && (((View)getParent()).isPressed())) {
      return;
    }
    super.setPressed(paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/DontPressWithParentRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */