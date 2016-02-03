package com.go.weatherex.home.current;

import android.os.Build.VERSION;
import android.view.View;
import com.gau.go.launcherex.gowidget.weather.util.w;
import com.go.weatherex.framework.fragment.a;
import java.util.List;

public class h
  extends x
{
  private x b;
  
  public h(a parama, int paramInt)
  {
    super(parama, paramInt);
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.b = new j(parama, paramInt);
      return;
    }
    this.b = new i(parama, paramInt);
  }
  
  public void a(String paramString)
  {
    this.b.a(paramString);
  }
  
  public void a(List paramList, w paramw)
  {
    this.b.a(paramList, paramw);
  }
  
  public void c()
  {
    this.b.c();
  }
  
  public View f()
  {
    return this.b.f();
  }
  
  public void g()
  {
    this.b.g();
  }
  
  public void h()
  {
    this.b.h();
  }
  
  public void i()
  {
    this.b.i();
  }
  
  public void j()
  {
    super.j();
    this.b.j();
  }
  
  public void k()
  {
    super.k();
    this.b.k();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */