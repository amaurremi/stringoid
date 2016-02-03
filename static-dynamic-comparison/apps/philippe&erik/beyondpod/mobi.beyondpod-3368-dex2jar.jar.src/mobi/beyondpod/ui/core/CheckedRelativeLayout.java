package mobi.beyondpod.ui.core;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import mobi.beyondpod.R.drawable;

public class CheckedRelativeLayout
  extends CheckableRelativeLayout
  implements Checkable
{
  public CheckedRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CheckedRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
    if (isChecked()) {}
    for (int i = R.drawable.checked_item_background;; i = 0)
    {
      setBackgroundResource(i);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/CheckedRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */