package android.support.v4.app;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

class s
  extends FrameLayout
{
  public s(Context paramContext)
  {
    super(paramContext);
  }
  
  static ViewGroup a(View paramView)
  {
    s locals = new s(paramView.getContext());
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams != null) {
      locals.setLayoutParams(localLayoutParams);
    }
    paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    locals.addView(paramView);
    return locals;
  }
  
  protected void dispatchRestoreInstanceState(SparseArray paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/app/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */