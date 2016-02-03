package android.support.v4.app;

import android.content.Context;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

class z
  extends FrameLayout
{
  public z(Context paramContext)
  {
    super(paramContext);
  }
  
  static ViewGroup a(View paramView)
  {
    z localz = new z(paramView.getContext());
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams != null) {
      localz.setLayoutParams(localLayoutParams);
    }
    paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localz.addView(paramView);
    return localz;
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/app/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */