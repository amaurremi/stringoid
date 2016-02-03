package android.support.v7.internal.widget;

import android.util.SparseArray;
import android.view.View;

class b
{
  private final SparseArray<View> b = new SparseArray();
  
  b(AbsSpinnerICS paramAbsSpinnerICS) {}
  
  View a(int paramInt)
  {
    View localView = (View)this.b.get(paramInt);
    if (localView != null) {
      this.b.delete(paramInt);
    }
    return localView;
  }
  
  void a()
  {
    SparseArray localSparseArray = this.b;
    int j = localSparseArray.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)localSparseArray.valueAt(i);
      if (localView != null) {
        AbsSpinnerICS.a(this.a, localView, true);
      }
      i += 1;
    }
    localSparseArray.clear();
  }
  
  public void a(int paramInt, View paramView)
  {
    this.b.put(paramInt, paramView);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */