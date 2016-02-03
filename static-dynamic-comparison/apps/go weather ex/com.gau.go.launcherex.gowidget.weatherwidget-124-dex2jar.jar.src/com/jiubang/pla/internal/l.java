package com.jiubang.pla.internal;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.widget.Adapter;

class l
  extends DataSetObserver
{
  private Parcelable b = null;
  
  l(PLA_AdapterView paramPLA_AdapterView) {}
  
  public void onChanged()
  {
    this.a.L = true;
    this.a.N = this.a.M;
    this.a.M = this.a.s().getCount();
    if ((this.a.s().hasStableIds()) && (this.b != null) && (this.a.N == 0) && (this.a.M > 0))
    {
      PLA_AdapterView.a(this.a, this.b);
      this.b = null;
    }
    for (;;)
    {
      this.a.x();
      this.a.requestLayout();
      return;
      this.a.y();
    }
  }
  
  public void onInvalidated()
  {
    this.a.L = true;
    if (this.a.s().hasStableIds()) {
      this.b = PLA_AdapterView.a(this.a);
    }
    this.a.N = this.a.M;
    this.a.M = 0;
    this.a.G = false;
    this.a.x();
    this.a.requestLayout();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/pla/internal/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */