package com.go.weatherex.home.hourforecast;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.gau.go.launcherex.gowidget.weather.c.c;
import com.gau.go.launcherex.gowidget.weather.c.g;
import com.gau.go.launcherex.gowidget.weather.util.f;
import com.go.weatherex.h.a;
import java.util.ArrayList;

public class ForecastHourForm
  extends FrameLayout
{
  private Context a;
  private ForecastHourTrend b;
  private f c;
  private com.gau.go.launcherex.gowidget.weather.c.e d;
  private g e;
  private String f = "";
  private boolean g = false;
  private ListView h;
  private com.jiubang.a.a.e i;
  private View j;
  private View k;
  
  public ForecastHourForm(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ForecastHourForm(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    paramContext = c.a(paramContext);
    this.c = paramContext.h();
    this.d = paramContext.f();
    this.e = paramContext.g();
    this.i = new com.jiubang.a.a.e(new b(this, this.a));
  }
  
  public void a()
  {
    a(this.f, false, true);
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean2) && (this.f.equals(paramString)) && (this.g)) {
      return;
    }
    this.g = true;
    this.f = paramString;
    ArrayList localArrayList = a.a(this.a, paramString);
    if (!localArrayList.isEmpty())
    {
      this.j.setVisibility(8);
      this.k.setVisibility(0);
      b localb = (b)this.i.e();
      localb.a(localArrayList);
      if (paramBoolean1) {
        this.i.a(300L, 130L, 420L, 50.0F);
      }
      for (;;)
      {
        localb.notifyDataSetChanged();
        this.i.notifyDataSetChanged();
        this.b.a(paramString, paramBoolean1, localArrayList);
        return;
        this.i.a(0L, 0L, 0L, 0.0F);
      }
    }
    this.k.setVisibility(8);
    this.j.setVisibility(0);
  }
  
  public void b()
  {
    a();
  }
  
  protected void onFinishInflate()
  {
    this.h = ((ListView)findViewById(2131231318));
    this.i.a(this.h);
    this.h.setAdapter(this.i);
    this.j = findViewById(2131231121);
    this.k = findViewById(2131231312);
    this.b = ((ForecastHourTrend)findViewById(2131231316));
    this.h.setCacheColorHint(0);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/hourforecast/ForecastHourForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */