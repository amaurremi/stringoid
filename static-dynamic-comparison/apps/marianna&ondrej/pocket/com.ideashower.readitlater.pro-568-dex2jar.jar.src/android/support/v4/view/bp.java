package android.support.v4.view;

import android.database.DataSetObserver;

class bp
  extends DataSetObserver
{
  private bp(ViewPager paramViewPager) {}
  
  public void onChanged()
  {
    this.a.b();
  }
  
  public void onInvalidated()
  {
    this.a.b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/android/support/v4/view/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */