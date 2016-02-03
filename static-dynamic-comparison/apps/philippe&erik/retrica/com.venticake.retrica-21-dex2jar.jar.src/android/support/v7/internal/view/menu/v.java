package android.support.v7.internal.view.menu;

import android.support.v7.c.b;
import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

class v
  extends FrameLayout
  implements CollapsibleActionView
{
  final b a;
  
  v(View paramView)
  {
    super(paramView.getContext());
    this.a = ((b)paramView);
    addView(paramView);
  }
  
  View a()
  {
    return (View)this.a;
  }
  
  public void onActionViewCollapsed()
  {
    this.a.b();
  }
  
  public void onActionViewExpanded()
  {
    this.a.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/view/menu/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */