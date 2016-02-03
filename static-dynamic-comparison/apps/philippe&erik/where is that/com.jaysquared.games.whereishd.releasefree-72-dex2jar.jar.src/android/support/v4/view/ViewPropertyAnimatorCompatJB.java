package android.support.v4.view;

import android.view.View;
import android.view.ViewPropertyAnimator;

class ViewPropertyAnimatorCompatJB
{
  public static void withEndAction(View paramView, Runnable paramRunnable)
  {
    paramView.animate().withEndAction(paramRunnable);
  }
  
  public static void withLayer(View paramView)
  {
    paramView.animate().withLayer();
  }
  
  public static void withStartAction(View paramView, Runnable paramRunnable)
  {
    paramView.animate().withStartAction(paramRunnable);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/android/support/v4/view/ViewPropertyAnimatorCompatJB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */