package com.go.weatherex.home;

import android.app.Activity;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.weather.globalview.c;

class y
  implements c
{
  y(x paramx, Activity paramActivity, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) || (com.gau.go.launcherex.gowidget.statistics.y.f(this.a).equals("200"))) {
      try
      {
        String[] arrayOfString = this.b.split("\\|\\|");
        if ((arrayOfString != null) && (arrayOfString.length == 2))
        {
          if (com.gau.go.launcherex.gowidget.statistics.y.s(this.a)) {
            x.a(this.c, this.a, arrayOfString[0]);
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
        x.b(this.c, this.a, this.b);
        Toast.makeText(this.a, 2131165367, 0).show();
        return;
      }
    }
    x.b(this.c, this.a, this.b);
    Toast.makeText(this.a.getApplicationContext(), 2131165367, 0).show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */