package com.go.weatherex.city;

import android.content.Context;
import android.graphics.Typeface;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.d.f;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.go.weatherex.viewex.FitBottomBackgroundView;

public class a
  extends FrameLayout
{
  public String a;
  public String b;
  public float c = -10000.0F;
  public int d = 1;
  public int e = 1;
  public int f = 55536;
  public String g;
  public String h;
  private FitBottomBackgroundView i;
  private View j;
  private ImageView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private com.gau.go.launcherex.gowidget.weather.c.e o = c.a(getContext()).f();
  
  public a(Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2130903099, this);
    this.i = ((FitBottomBackgroundView)findViewById(2131231201));
    this.j = findViewById(2131231206);
    this.k = ((ImageView)findViewById(2131231203));
    this.l = ((TextView)findViewById(2131231205));
    this.m = ((TextView)findViewById(2131230839));
    this.n = ((TextView)findViewById(2131231204));
    paramContext = Typeface.createFromAsset(paramContext.getAssets(), "fonts/Roboto-Thin.ttf");
    if (paramContext != null)
    {
      this.m.setTypeface(paramContext);
      this.n.setTypeface(paramContext);
    }
  }
  
  private int a(int paramInt)
  {
    int i1 = 55536;
    if (this.c != -10000.0F)
    {
      if (paramInt == 1) {
        i1 = com.gau.go.launcherex.gowidget.weather.util.q.a(com.gau.go.launcherex.gowidget.weather.util.q.b(this.c, 1));
      }
    }
    else {
      return i1;
    }
    return (int)this.c;
  }
  
  private void a(int paramInt, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramArrayOfInt[0] = 2130837647;
      return;
    case 2: 
      if (c())
      {
        paramArrayOfInt[0] = 2130837651;
        return;
      }
      paramArrayOfInt[0] = 2130837652;
      return;
    case 3: 
      if (c())
      {
        paramArrayOfInt[0] = 2130837644;
        return;
      }
      paramArrayOfInt[0] = 2130837645;
      return;
    case 4: 
      paramArrayOfInt[0] = 2130837648;
      return;
    case 5: 
      paramArrayOfInt[0] = 2130837650;
      return;
    case 6: 
      paramArrayOfInt[0] = 2130837646;
      return;
    case 7: 
      paramArrayOfInt[0] = 2130837649;
      return;
    }
    paramArrayOfInt[0] = 2130837653;
  }
  
  private void b(WeatherBean paramWeatherBean)
  {
    this.a = paramWeatherBean.c();
    this.b = paramWeatherBean.d();
    this.c = paramWeatherBean.k.a(2);
    this.d = paramWeatherBean.k.d();
    this.e = paramWeatherBean.e();
    this.f = paramWeatherBean.k.n();
    this.g = paramWeatherBean.k.j();
    this.h = paramWeatherBean.k.k();
  }
  
  public void a()
  {
    this.l.setText(this.b);
    int i1 = a(this.o.a().g);
    if (i1 != 55536)
    {
      this.m.setText(String.valueOf(i1));
      if (this.n.getVisibility() != 0) {
        this.n.setVisibility(0);
      }
    }
    for (;;)
    {
      this.i.a(com.gau.go.launcherex.gowidget.scriptengine.parser.e.a(getContext(), this.d, c(), this.i.getWidth(), this.i.getHeight()));
      int[] arrayOfInt = new int[1];
      a(this.d, arrayOfInt);
      this.k.setImageResource(arrayOfInt[0]);
      return;
      this.m.setText("N/A");
      this.n.setVisibility(8);
    }
  }
  
  public void a(WeatherBean paramWeatherBean)
  {
    b(paramWeatherBean);
    a();
    invalidate();
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.j;
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 4)
    {
      localView.setVisibility(i1);
      return;
    }
  }
  
  public boolean b()
  {
    if (this.e != -1) {
      return this.e != 1;
    }
    return false;
  }
  
  public boolean c()
  {
    Object localObject = c.a(getContext());
    g localg = ((c)localObject).g();
    if ((((c)localObject).e().b()) && (localg.d()))
    {
      localObject = localg.b(this.f);
      return r.a(this.g, this.h, (Time)localObject);
    }
    return r.a(this.g, this.h);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/city/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */