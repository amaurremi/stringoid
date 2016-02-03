package com.actionbarsherlock.internal.widget;

import android.view.View;
import android.widget.FrameLayout;

public class CollapsibleActionViewWrapper
  extends FrameLayout
  implements android.view.CollapsibleActionView
{
  private final com.actionbarsherlock.view.CollapsibleActionView child;
  
  public CollapsibleActionViewWrapper(View paramView)
  {
    super(paramView.getContext());
    this.child = ((com.actionbarsherlock.view.CollapsibleActionView)paramView);
    addView(paramView);
  }
  
  public void onActionViewCollapsed()
  {
    this.child.onActionViewCollapsed();
  }
  
  public void onActionViewExpanded()
  {
    this.child.onActionViewExpanded();
  }
  
  public View unwrap()
  {
    return getChildAt(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/actionbarsherlock/internal/widget/CollapsibleActionViewWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */