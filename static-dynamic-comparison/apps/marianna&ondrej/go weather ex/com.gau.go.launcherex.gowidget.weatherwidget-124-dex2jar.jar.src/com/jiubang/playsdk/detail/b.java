package com.jiubang.playsdk.detail;

import android.view.View;
import android.view.View.OnClickListener;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.e.e;
import com.jiubang.playsdk.g.d;

class b
  implements View.OnClickListener
{
  b(a parama) {}
  
  public void onClick(View paramView)
  {
    paramView = a.a(this.a).f();
    if (paramView == null) {}
    com.jiubang.playsdk.a.a locala;
    boolean bool;
    do
    {
      return;
      com.jiubang.playsdk.f.a.b(a.b(this.a), a.c(this.a).o(), paramView.b(), a.d(this.a).r(), paramView.a(), paramView.t());
      locala = a.f(this.a).a(a.e(this.a), paramView);
      if (paramView.o()) {
        break;
      }
      bool = a.h(this.a).f(a.g(this.a), locala);
      d.a("ThemeDetailPage", "调用主程序下载结果=" + bool);
    } while (bool);
    d.a("ThemeDetailPage", "sdk 下载...");
    com.jiubang.playsdk.g.a.a(a.i(this.a), paramView);
    return;
    a.l(this.a).a(a.j(this.a), paramView.s(), locala, new c(this, paramView));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */