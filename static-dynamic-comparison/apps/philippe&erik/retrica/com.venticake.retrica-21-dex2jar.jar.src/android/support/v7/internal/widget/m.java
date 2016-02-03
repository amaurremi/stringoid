package android.support.v7.internal.widget;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.widget.Adapter;

class m
  extends DataSetObserver
{
  private Parcelable b = null;
  
  m(l paraml) {}
  
  public void onChanged()
  {
    this.a.u = true;
    this.a.A = this.a.z;
    this.a.z = this.a.e().getCount();
    if ((this.a.e().hasStableIds()) && (this.b != null) && (this.a.A == 0) && (this.a.z > 0))
    {
      l.a(this.a, this.b);
      this.b = null;
    }
    for (;;)
    {
      this.a.i();
      this.a.requestLayout();
      return;
      this.a.n();
    }
  }
  
  public void onInvalidated()
  {
    this.a.u = true;
    if (this.a.e().hasStableIds()) {
      this.b = l.a(this.a);
    }
    this.a.A = this.a.z;
    this.a.z = 0;
    this.a.x = -1;
    this.a.y = Long.MIN_VALUE;
    this.a.v = -1;
    this.a.w = Long.MIN_VALUE;
    this.a.p = false;
    this.a.i();
    this.a.requestLayout();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/android/support/v7/internal/widget/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */