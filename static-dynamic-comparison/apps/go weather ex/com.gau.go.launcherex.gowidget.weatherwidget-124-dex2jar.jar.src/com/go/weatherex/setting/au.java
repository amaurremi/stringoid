package com.go.weatherex.setting;

import android.widget.TextView;

class au
{
  private av[] b;
  
  public au(an paraman, av[] paramArrayOfav)
  {
    this.b = paramArrayOfav;
  }
  
  private void d()
  {
    int j = a();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if (this.b[i].d) {
          this.b[i].d = false;
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public int a()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.length;
  }
  
  public void a(int paramInt)
  {
    d();
    if ((paramInt < a()) && (this.b != null))
    {
      this.b[paramInt].d = true;
      an.a(this.a, this.b[paramInt]);
      if (an.l(this.a) != null) {
        an.m(this.a).setText(an.l(this.a).a());
      }
    }
  }
  
  public CharSequence[] b()
  {
    int j = a();
    CharSequence[] arrayOfCharSequence = new CharSequence[j];
    int i = 0;
    while (i < j)
    {
      arrayOfCharSequence[i] = this.b[i].a();
      i += 1;
    }
    return arrayOfCharSequence;
  }
  
  public int c()
  {
    int j = a();
    int i = 0;
    while (i < j)
    {
      if (this.b[i].d) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */