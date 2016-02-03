package com.go.weatherex.home.current;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.weather.util.w;
import java.util.List;

public abstract class x
  implements com.go.weatherex.framework.a
{
  protected com.go.weatherex.framework.fragment.a a;
  private int b;
  
  public x(com.go.weatherex.framework.fragment.a parama, int paramInt)
  {
    this.a = parama;
    this.b = paramInt;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public abstract void a(String paramString);
  
  public void a(String paramString1, String paramString2, int paramInt) {}
  
  public void a(List paramList) {}
  
  public void a(List paramList, int paramInt) {}
  
  public void a(List paramList, w paramw) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  public void b(List paramList) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c() {}
  
  public void c(int paramInt) {}
  
  public void c(boolean paramBoolean) {}
  
  public void d() {}
  
  public void d(int paramInt) {}
  
  public void d(boolean paramBoolean) {}
  
  public void e() {}
  
  public void e(int paramInt) {}
  
  public abstract View f();
  
  public abstract void g();
  
  public abstract void h();
  
  public abstract void i();
  
  public void j() {}
  
  public void k() {}
  
  protected void l()
  {
    if (this.a.getActivity() == null) {}
    do
    {
      return;
      localObject = GoWidgetApplication.c(this.a.getActivity().getApplicationContext()).a();
    } while (((SharedPreferences)localObject).getBoolean("key_brief_card_tap_for_more", false));
    Object localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("key_brief_card_tap_for_more", true);
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */