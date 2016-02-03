package mobi.beyondpod.ui.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CheckableRelativeLayout
  extends RelativeLayout
  implements Checkable
{
  private boolean _checkDisabled;
  private List<Checkable> _checkableChildren;
  private boolean _isChecked;
  
  public CheckableRelativeLayout(Context paramContext, int paramInt)
  {
    super(paramContext);
    initialise(null);
  }
  
  public CheckableRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initialise(paramAttributeSet);
  }
  
  public CheckableRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initialise(paramAttributeSet);
  }
  
  private void findCheckableChildren(View paramView)
  {
    if ((paramView instanceof Checkable)) {
      this._checkableChildren.add((Checkable)paramView);
    }
    int j;
    int i;
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      j = paramView.getChildCount();
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        return;
      }
      findCheckableChildren(paramView.getChildAt(i));
      i += 1;
    }
  }
  
  private void initialise(AttributeSet paramAttributeSet)
  {
    this._isChecked = false;
    this._checkableChildren = new ArrayList(5);
  }
  
  public boolean isChecked()
  {
    return this._isChecked;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    int j = getChildCount();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      findCheckableChildren(getChildAt(i));
      i += 1;
    }
  }
  
  public void setCheckDisabled(boolean paramBoolean)
  {
    this._checkDisabled = paramBoolean;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this._checkDisabled) {}
    for (;;)
    {
      return;
      this._isChecked = paramBoolean;
      Iterator localIterator = this._checkableChildren.iterator();
      while (localIterator.hasNext()) {
        ((Checkable)localIterator.next()).setChecked(paramBoolean);
      }
    }
  }
  
  public void toggle()
  {
    if (this._checkDisabled) {
      return;
    }
    if (this._isChecked) {}
    for (boolean bool = false;; bool = true)
    {
      this._isChecked = bool;
      Iterator localIterator = this._checkableChildren.iterator();
      while (localIterator.hasNext()) {
        ((Checkable)localIterator.next()).toggle();
      }
      break;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/core/CheckableRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */