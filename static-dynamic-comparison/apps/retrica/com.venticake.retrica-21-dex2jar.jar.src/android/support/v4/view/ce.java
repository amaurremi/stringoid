package android.support.v4.view;

import android.database.DataSetObserver;

class ce
  extends DataSetObserver
{
  private ce(ViewPager paramViewPager) {}
  
  public void onChanged()
  {
    this.a.b();
  }
  
  public void onInvalidated()
  {
    this.a.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v4/view/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */