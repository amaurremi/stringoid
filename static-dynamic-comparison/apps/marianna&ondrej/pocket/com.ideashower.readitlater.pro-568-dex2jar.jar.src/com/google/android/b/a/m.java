package com.google.android.b.a;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener;
import com.google.android.b.a.a.au;
import java.util.Set;

final class m
  implements ViewTreeObserver.OnGlobalFocusChangeListener
{
  private m(l paraml) {}
  
  public final void onGlobalFocusChanged(View paramView1, View paramView2)
  {
    if ((l.d(this.a) != null) && (l.i(this.a).contains(paramView2)) && (!l.i(this.a).contains(paramView1))) {
      l.d(this.a).k();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/b/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */