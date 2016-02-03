package com.gtp.go.weather.coupon.view;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class f
  extends com.gau.go.launcherex.gowidget.weather.globalview.f
  implements View.OnClickListener
{
  private TextView b;
  private TextView c;
  private EditText d;
  private TextView e;
  private TextView f;
  private TextView g;
  private int h;
  private g i;
  
  public f(Activity paramActivity)
  {
    super(paramActivity);
    setContentView(2130903101);
    this.b = ((TextView)findViewById(2131231210));
    this.c = ((TextView)findViewById(2131231211));
    this.d = ((EditText)findViewById(2131231212));
    this.e = ((TextView)findViewById(2131231213));
    this.f = ((TextView)findViewById(2131231214));
    this.g = ((TextView)findViewById(2131231215));
    this.e.setOnClickListener(this);
    paramActivity = this.a.getResources().getDisplayMetrics();
    this.h = ((int)(Math.min(paramActivity.widthPixels, paramActivity.heightPixels) - paramActivity.density * 40.0F));
  }
  
  public void a()
  {
    this.g.setVisibility(8);
  }
  
  public void a(g paramg)
  {
    this.i = paramg;
  }
  
  public void a(String paramString)
  {
    this.g.setVisibility(0);
    this.g.setText(paramString);
  }
  
  public TextView b()
  {
    return this.e;
  }
  
  public void b(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public String c()
  {
    return this.c.getText().toString();
  }
  
  public void c(String paramString)
  {
    if (paramString != null)
    {
      this.c.setText(paramString);
      this.c.setVisibility(0);
      this.d.setVisibility(8);
    }
  }
  
  public void d()
  {
    this.c.setVisibility(8);
    this.d.setVisibility(0);
  }
  
  public void d(String paramString)
  {
    this.f.setText(paramString);
  }
  
  public String e()
  {
    return this.d.getText().toString();
  }
  
  public void f()
  {
    a(17, 0, 0, this.h, -2);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.e)) {
      this.i.a();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/coupon/view/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */