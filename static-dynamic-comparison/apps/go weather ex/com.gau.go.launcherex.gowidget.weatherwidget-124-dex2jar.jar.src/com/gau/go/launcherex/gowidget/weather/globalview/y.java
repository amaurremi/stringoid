package com.gau.go.launcherex.gowidget.weather.globalview;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class y
  extends f
  implements DialogInterface.OnDismissListener, View.OnClickListener
{
  private aa b = aa.a;
  private boolean c = false;
  private z d;
  private TextView e;
  private TextView f;
  private TextView g;
  private int h;
  
  public y(Activity paramActivity)
  {
    this(paramActivity, aa.a);
  }
  
  public y(Activity paramActivity, aa paramaa)
  {
    super(paramActivity);
    this.b = paramaa;
    if (this.b == aa.b) {
      setContentView(2130903122);
    }
    for (;;)
    {
      this.e = ((TextView)findViewById(2131230797));
      this.f = ((TextView)findViewById(2131231257));
      this.g = ((TextView)findViewById(2131231275));
      setOnDismissListener(this);
      this.g.setOnClickListener(this);
      paramActivity = this.a.getResources().getDisplayMetrics();
      this.h = ((int)(Math.min(paramActivity.widthPixels, paramActivity.heightPixels) - paramActivity.density * 40.0F));
      a(findViewById(2131230828), 2, true);
      a(this.e, 4, true);
      return;
      setContentView(2130903121);
    }
  }
  
  private String d(int paramInt)
  {
    return this.a.getString(paramInt);
  }
  
  public void a()
  {
    a(17, 0, 0, this.h, -2);
  }
  
  public void a(int paramInt)
  {
    this.e.setText(d(paramInt));
  }
  
  public void a(z paramz)
  {
    this.d = paramz;
  }
  
  public void a(String paramString)
  {
    this.e.setText(paramString);
  }
  
  public void b(int paramInt)
  {
    this.f.setText(d(paramInt));
  }
  
  public void b(String paramString)
  {
    this.f.setText(paramString);
  }
  
  public void c(int paramInt)
  {
    this.g.setText(d(paramInt));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.g))
    {
      this.c = true;
      dismiss();
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.d != null) {
      this.d.a(this.c);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globalview/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */