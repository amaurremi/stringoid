package com.gtp.go.weather.sharephoto.award;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gtp.go.weather.sharephoto.b.d;
import com.jiubang.core.b.a;
import java.util.List;

public class r
{
  private Activity a;
  private SharedPreferences b;
  private List c;
  private d d;
  private k e;
  private boolean f = false;
  private final o g = new s(this);
  
  public r(Activity paramActivity, k paramk)
  {
    this.a = paramActivity;
    this.e = paramk;
    this.e.a(this.g);
    this.b = GoWidgetApplication.c(this.a.getApplicationContext()).a();
  }
  
  private void a(List paramList)
  {
    if (paramList == null) {}
    label69:
    for (;;)
    {
      return;
      int i = paramList.size() - 1;
      d locald;
      if (i >= 0)
      {
        locald = (d)paramList.get(i);
        if (locald.j() != 0) {}
      }
      for (paramList = locald;; paramList = null)
      {
        if ((paramList == null) || (this.e == null)) {
          break label69;
        }
        this.e.a(true, paramList);
        return;
        i -= 1;
        break;
      }
    }
  }
  
  private void d()
  {
    if (this.f) {}
    String str;
    do
    {
      do
      {
        return;
      } while ((this.d == null) || (this.c == null));
      str = "key_prefix_notice_user_award_by_dialog" + this.d.a();
    } while (this.b.getBoolean(str, false));
    SharedPreferences.Editor localEditor = this.b.edit();
    localEditor.putBoolean(str, true);
    localEditor.commit();
    new c(this.a).a(this.d, this.c);
  }
  
  public void a()
  {
    this.f = true;
  }
  
  public void b()
  {
    this.f = false;
    d();
  }
  
  public void c()
  {
    this.e = null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/award/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */