package android.support.v4.widget;

import android.support.v4.view.av;
import android.view.View;
import java.util.ArrayList;

class w
  implements Runnable
{
  final View a;
  
  w(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
  {
    this.a = paramView;
  }
  
  public void run()
  {
    if (this.a.getParent() == this.b)
    {
      av.a(this.a, 0, null);
      SlidingPaneLayout.a(this.b, this.a);
    }
    SlidingPaneLayout.f(this.b).remove(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/widget/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */