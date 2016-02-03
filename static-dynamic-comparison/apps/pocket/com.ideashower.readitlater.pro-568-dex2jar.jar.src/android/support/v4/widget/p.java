package android.support.v4.widget;

import android.support.v4.view.ag;
import android.view.View;
import java.util.ArrayList;

class p
  implements Runnable
{
  final View a;
  
  p(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
  {
    this.a = paramView;
  }
  
  public void run()
  {
    if (this.a.getParent() == this.b)
    {
      ag.a(this.a, 0, null);
      SlidingPaneLayout.a(this.b, this.a);
    }
    SlidingPaneLayout.a(this.b).remove(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/widget/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */