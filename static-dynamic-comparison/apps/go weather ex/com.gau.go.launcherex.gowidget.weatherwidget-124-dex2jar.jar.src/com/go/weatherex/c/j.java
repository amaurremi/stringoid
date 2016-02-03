package com.go.weatherex.c;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioButton;

class j
  implements View.OnClickListener
{
  j(i parami, k paramk, h paramh) {}
  
  public void onClick(View paramView)
  {
    if (i.a(this.c) != null) {
      i.a(this.c).setChecked(false);
    }
    this.a.a.setChecked(true);
    a.a(this.c.a, this.b);
    a.f(this.c.a).setText(this.b.b());
    i.a(this.c, this.a.a);
    a.g(this.c.a);
    a.h(this.c.a);
    int i = a.i(this.c.a).a();
    if (i == 3)
    {
      i.b(this.c);
      i.a(this.c, false);
      a.j(this.c.a).setFocusable(true);
      a.j(this.c.a).setCursorVisible(true);
      a.j(this.c.a).setFocusableInTouchMode(true);
      a.j(this.c.a).setOnClickListener(null);
      a.j(this.c.a).setText("");
      a.a(this.c.a, "");
      if (a.k(this.c.a) != null) {
        a.k(this.c.a).a();
      }
    }
    do
    {
      return;
      if ((i != 2) && (i != 7) && (i != 8)) {
        break;
      }
      i.a(this.c, true);
      a.j(this.c.a).setFocusable(false);
      a.j(this.c.a).setCursorVisible(false);
      a.j(this.c.a).setFocusableInTouchMode(false);
      a.j(this.c.a).setOnClickListener(this.c.a);
      a.j(this.c.a).setText("");
      a.a(this.c.a, "");
    } while (a.k(this.c.a) == null);
    a.k(this.c.a).a();
    return;
    a.a(this.c.a).setText("");
    i.a(this.c, true);
    a.j(this.c.a).setFocusable(true);
    a.j(this.c.a).setCursorVisible(true);
    a.j(this.c.a).setFocusableInTouchMode(true);
    a.j(this.c.a).setOnClickListener(null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */