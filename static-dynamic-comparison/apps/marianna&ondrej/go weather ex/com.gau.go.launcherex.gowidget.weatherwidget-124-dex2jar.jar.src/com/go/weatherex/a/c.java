package com.go.weatherex.a;

import android.support.v4.app.FragmentActivity;
import com.go.weatherex.sidebar.b;

class c
  implements Runnable
{
  c(a parama) {}
  
  public void run()
  {
    if (this.a.getActivity() != null)
    {
      b.a(this.a.getActivity().getApplicationContext(), 2, 1);
      this.a.h();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */