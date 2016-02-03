package com.go.weatherex.themestore.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.e.e;

class c
  implements View.OnClickListener
{
  c(b paramb) {}
  
  public void onClick(View paramView)
  {
    paramView = b.a(this.a).f();
    if (paramView == null) {}
    com.jiubang.playsdk.a.a locala;
    boolean bool;
    do
    {
      return;
      com.jiubang.playsdk.f.a.b(this.a.a, this.a.g.o(), paramView.b(), this.a.g.r(), paramView.a(), paramView.t());
      locala = this.a.f.a(this.a.a, paramView);
      if (paramView.o()) {
        break;
      }
      bool = this.a.g.f(this.a.a, locala);
      com.jiubang.playsdk.g.d.a("ThemeDetailPage", "调用主程序下载结果=" + bool);
    } while (bool);
    com.jiubang.playsdk.g.d.a("ThemeDetailPage", "sdk 下载...");
    com.jiubang.playsdk.g.a.a(this.a.a, paramView);
    return;
    this.a.g.a(this.a.a, paramView.s(), locala, new d(this, paramView));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/detail/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */