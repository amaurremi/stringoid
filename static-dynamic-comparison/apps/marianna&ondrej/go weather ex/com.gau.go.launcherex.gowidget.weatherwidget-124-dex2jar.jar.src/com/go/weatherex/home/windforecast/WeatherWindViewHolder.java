package com.go.weatherex.home.windforecast;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.Time;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.model.NowBean;
import com.gau.go.launcherex.gowidget.weather.model.WeatherBean;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.gau.go.launcherex.gowidget.weather.util.r;
import java.util.ArrayList;

public class WeatherWindViewHolder
  extends LinearLayout
{
  private static final int[] l = { 2130839040, 2130839038, 2130839037, 2130839039, 2130839042, 2130839045, 2130839043, 2130839044, 2130839041 };
  private static final int[] m = { 2131165383, 2131165973, 2131165974, 2131165977, 2131165979, 2131165982 };
  private Context a = null;
  private WindInfoBase b = null;
  private TextView c = null;
  private String d = null;
  private String[] e;
  private String f;
  private ListView g;
  private com.gau.go.launcherex.gowidget.weather.c.e h;
  private com.jiubang.a.a.e i;
  private c j;
  private boolean k = false;
  
  public WeatherWindViewHolder(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private int a(int paramInt)
  {
    if ((paramInt == 55536) || (paramInt == 0)) {
      return 2130839054;
    }
    if (paramInt < 5) {
      return 2130839055;
    }
    if (paramInt < 11) {
      return 2130839056;
    }
    return 2130839057;
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    this.h = com.gau.go.launcherex.gowidget.weather.c.c.a(this.a.getApplicationContext()).f();
    this.e = com.gau.go.launcherex.gowidget.weather.util.c.h(this.a);
    this.f = this.a.getResources().getString(2131165919).toUpperCase();
    int n = this.e.length - 1;
    while (n > -1)
    {
      this.e[n] = r.e(this.e[n]);
      n -= 1;
    }
  }
  
  private int b(int paramInt)
  {
    if (paramInt < 1) {
      return m[0];
    }
    if (paramInt < 3) {
      return m[1];
    }
    if (paramInt < 5) {
      return m[2];
    }
    if (paramInt < 8) {
      return m[3];
    }
    if (paramInt < 11) {
      return m[4];
    }
    return m[5];
  }
  
  private String b(float paramFloat)
  {
    switch (this.h.a().q)
    {
    default: 
      return "--";
    case 2: 
      return this.a.getString(2131165810, new Object[] { Float.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.b(paramFloat)) });
    case 1: 
      return this.a.getString(2131165809, new Object[] { Float.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.c(paramFloat, 1)) });
    case 3: 
      return this.a.getString(2131165811, new Object[] { Float.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.d(paramFloat, 1)) });
    case 4: 
      return this.a.getString(2131165812, new Object[] { Float.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.e(paramFloat, 1)) });
    case 5: 
      return this.a.getString(2131165813, new Object[] { Integer.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.a(paramFloat)) });
    }
    return this.a.getString(2131165814, new Object[] { Float.valueOf(com.gau.go.launcherex.gowidget.weather.util.q.f(paramFloat, 1)) });
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    Object localObject = f.a(this.a).a(b());
    if ((localObject == null) || (((WeatherBean)localObject).g == null))
    {
      this.g.setVisibility(8);
      this.c.setVisibility(0);
      return;
    }
    int n = ((WeatherBean)localObject).k.n();
    localObject = f.a(this.a).a().c(n);
    paramString = com.go.weatherex.h.a.b(this.a, paramString);
    if (paramString.size() == 0)
    {
      this.g.setVisibility(8);
      this.c.setVisibility(0);
      return;
    }
    this.g.setVisibility(0);
    this.c.setVisibility(8);
    this.i = new com.jiubang.a.a.e(new a(this, this.a, paramString, (Time)localObject));
    if (paramBoolean) {
      this.i.a(700L, 130L, 420L, 50.0F);
    }
    for (;;)
    {
      this.i.a(this.g);
      this.g.setAdapter(this.i);
      return;
      this.i.a(0L, 0L, 0L, 0.0F);
    }
  }
  
  private int c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return l[8];
    case 1: 
    case 2: 
      return l[8];
    case 3: 
      return l[4];
    case 4: 
    case 5: 
    case 6: 
      return l[5];
    case 7: 
      return l[6];
    case 8: 
    case 9: 
    case 10: 
      return l[7];
    case 11: 
      return l[0];
    case 12: 
    case 13: 
    case 14: 
      return l[1];
    case 15: 
      return l[2];
    }
    return l[3];
  }
  
  protected void a()
  {
    this.e = com.gau.go.launcherex.gowidget.weather.util.c.h(this.a);
    this.f = this.a.getResources().getString(2131165919).toUpperCase();
  }
  
  public void a(float paramFloat)
  {
    this.b.a(paramFloat);
  }
  
  public void a(c paramc)
  {
    this.j = paramc;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.k = true;
    this.b.a(this.j);
    this.d = paramString;
    a(paramBoolean);
    invalidate();
  }
  
  public void a(boolean paramBoolean)
  {
    ArrayList localArrayList = f.a(this.a).d();
    if (!localArrayList.isEmpty())
    {
      if (!r.a(b())) {
        this.d = ((WeatherBean)localArrayList.get(0)).c();
      }
    }
    else
    {
      this.b.a(b());
      if (!paramBoolean) {
        break label123;
      }
      this.b.a(b(), 400L, 400L, 100.0F);
    }
    for (;;)
    {
      b(b(), paramBoolean);
      return;
      if (f.a(this.a).a(b()) != null) {
        break;
      }
      this.d = ((WeatherBean)localArrayList.get(0)).c();
      break;
      label123:
      this.b.a(b(), 0L, 10L, 0.0F);
    }
  }
  
  public String b()
  {
    return this.d;
  }
  
  protected void onFinishInflate()
  {
    this.b = ((WindInfoBase)findViewById(2131231559));
    this.b.a(0);
    this.c = ((TextView)findViewById(2131231560));
    this.g = ((ListView)findViewById(2131231561));
    this.g.setCacheColorHint(0);
    this.g.setSmoothScrollbarEnabled(true);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/windforecast/WeatherWindViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */