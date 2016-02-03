package com.go.weatherex.setting;

import android.widget.Toast;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.gau.go.launcherex.gowidget.weather.globalview.c;

class s
  implements c
{
  s(q paramq, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) || (y.f(this.b.getActivity()).equals("200"))) {
      try
      {
        String[] arrayOfString = this.a.split("\\|\\|");
        if ((arrayOfString != null) && (arrayOfString.length == 2))
        {
          if (y.s(this.b.getActivity())) {
            q.a(this.b, arrayOfString[0]);
          }
        }
        else {
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          Object localObject = null;
        }
        q.b(this.b, this.a);
        Toast.makeText(this.b.getActivity(), 2131165367, 0).show();
        return;
      }
    }
    q.b(this.b, this.a);
    Toast.makeText(this.b.getActivity(), 2131165367, 0).show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */