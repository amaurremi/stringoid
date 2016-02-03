package com.gtp.go.weather.sharephoto.photo;

import android.app.Activity;
import android.view.View;
import com.gtp.go.weather.sharephoto.b.e;
import com.gtp.go.weather.sharephoto.c.a;
import com.gtp.go.weather.sharephoto.c.l;

public class i
  implements a
{
  private Activity a;
  private View b;
  private k c = null;
  
  public i(Activity paramActivity, View paramView)
  {
    this.a = paramActivity;
    this.b = paramView;
    this.b.setVisibility(4);
    l.a(this);
  }
  
  public void a()
  {
    if (this.c != null) {
      this.c.cancel(true);
    }
  }
  
  public void a(e parame) {}
  
  public void b()
  {
    if (this.c == null)
    {
      this.c = new k(this, null);
      this.c.execute(new Void[0]);
    }
  }
  
  public void b(e parame)
  {
    b();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */