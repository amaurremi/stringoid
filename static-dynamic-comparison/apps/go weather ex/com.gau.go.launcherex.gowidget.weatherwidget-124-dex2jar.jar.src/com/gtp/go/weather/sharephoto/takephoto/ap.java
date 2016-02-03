package com.gtp.go.weather.sharephoto.takephoto;

import android.content.Context;
import android.text.format.Time;
import android.widget.ImageView;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.d.f;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.r;

public abstract class ap
  extends an
{
  private static final int[] t = { 2131165326, 2131165327, 2131165328, 2131165329, 2131165330, 2131165331, 2131165332 };
  protected TextView i;
  protected TextView j;
  protected TextView k;
  protected TextView l;
  protected TextView m;
  protected TextView n;
  protected ImageView o;
  protected aq p;
  protected final int[] q = { 2130838560, 2130838564, 2130838565, 2130838546, 2130838547, 2130838561, 2130838563, 2130838548, 2130838562, 2130838566 };
  private WeatherBean r;
  private com.gau.go.launcherex.gowidget.weather.model.q s;
  
  public ap(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public static String a(Context paramContext, int paramInt, float paramFloat)
  {
    if (paramInt == 1) {
      return paramContext.getString(2131165809, new Object[] { Float.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.c(paramFloat, 1)) });
    }
    if (paramInt == 4) {
      return paramContext.getString(2131165812, new Object[] { Float.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.e(paramFloat, 1)) });
    }
    if (paramInt == 3) {
      return paramContext.getString(2131165811, new Object[] { Float.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.d(paramFloat, 1)) });
    }
    if (paramInt == 5) {
      return paramContext.getString(2131165813, new Object[] { Integer.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.a(paramFloat)) });
    }
    if (paramInt == 6) {
      return paramContext.getString(2131165814, new Object[] { Float.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.f(paramFloat, 1)) });
    }
    return paramContext.getString(2131165810, new Object[] { Float.valueOf(paramFloat) });
  }
  
  public static boolean a(Context paramContext, WeatherBean paramWeatherBean, boolean paramBoolean)
  {
    if (paramWeatherBean == null)
    {
      paramContext = new Time();
      paramContext.setToNow();
      return (paramContext.hour > 5) && (paramContext.hour < 19);
    }
    String str1 = paramWeatherBean.k.j();
    String str2 = paramWeatherBean.k.k();
    if (paramBoolean)
    {
      paramContext = new g(paramContext);
      paramContext.a(true);
      paramBoolean = r.a(str1, str2, paramContext.b(paramWeatherBean.k.n()));
      paramContext.b();
      return paramBoolean;
    }
    return r.a(str1, str2);
  }
  
  public static String b(Context paramContext, int paramInt)
  {
    return paramContext.getString(t[paramInt]);
  }
  
  public ao a()
  {
    a locala = new a(this);
    locala.a(this.s);
    locala.a(this.r);
    return locala;
  }
  
  public void a(WeatherBean paramWeatherBean, com.gau.go.launcherex.gowidget.weather.model.q paramq)
  {
    this.r = paramWeatherBean;
    this.s = paramq;
    k();
    p();
    q();
    o();
    n();
    m();
    l();
  }
  
  protected void k()
  {
    boolean bool = true;
    if (this.o == null) {
      return;
    }
    if (this.r != null) {}
    for (int i1 = this.r.k.d();; i1 = 1)
    {
      if ((c.a(this.a.getApplicationContext()).e().b()) && (this.s.r == 1)) {}
      for (;;)
      {
        bool = a(this.a, this.r, bool);
        i1 = r.a(this.q, i1, bool);
        this.o.setImageResource(i1);
        return;
        bool = false;
      }
    }
  }
  
  protected void l()
  {
    if (this.m == null) {
      return;
    }
    Time localTime = new Time();
    localTime.setToNow();
    this.m.setText(b(this.a, localTime.weekDay));
  }
  
  protected void m()
  {
    if (this.l == null) {
      return;
    }
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    localObject = ((Time)localObject).year + "/" + (((Time)localObject).month + 1) + "/" + ((Time)localObject).monthDay + " ";
    this.l.setText((CharSequence)localObject);
  }
  
  protected void n()
  {
    if ((this.j == null) || (this.k == null)) {
      return;
    }
    int i1 = this.s.g;
    String str3;
    String str2;
    if (i1 == 1)
    {
      str3 = "°C";
      str1 = "--";
      str2 = str1;
      if (this.r == null) {
        break label174;
      }
      float f1 = this.r.k.b(i1);
      float f2 = this.r.k.c(i1);
      if (r.b(f1)) {
        str1 = com.gau.go.launcherex.gowidget.weather.util.q.a(f1) + str3;
      }
      str2 = str1;
      if (!r.b(f2)) {
        break label174;
      }
      str3 = com.gau.go.launcherex.gowidget.weather.util.q.a(f2) + str3;
      str2 = str1;
    }
    label174:
    for (String str1 = str3;; str1 = "--")
    {
      this.j.setText(str2);
      this.k.setText(str1);
      return;
      str3 = "°F";
      break;
    }
  }
  
  protected void o()
  {
    if (this.n == null) {
      return;
    }
    int i1 = this.s.q;
    String str2 = b(2131165323);
    String str1 = null;
    float f = -10000.0F;
    if (this.r != null)
    {
      str1 = this.r.k.b();
      f = this.r.k.a();
    }
    if ((!r.a(str1)) && (!r.b(f))) {
      str1 = b(2131166456) + str2;
    }
    for (;;)
    {
      this.n.setText(str1);
      return;
      str2 = a(this.a, i1, f);
      if (i1 == 5) {
        str1 = b(2131166456) + str1 + " ,  " + str2;
      } else {
        str1 = b(2131166456) + str2 + " , " + str1;
      }
    }
  }
  
  protected void p()
  {
    if (this.p == null) {
      return;
    }
    this.p.a(this.r, this.s);
  }
  
  protected void q()
  {
    if (this.i == null) {
      return;
    }
    String str2 = b(2131165323).toString();
    String str1 = str2;
    if (this.r != null)
    {
      str1 = str2;
      if (r.a(this.r.k.e())) {
        str1 = this.r.k.e();
      }
    }
    this.i.setText(str1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/takephoto/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */