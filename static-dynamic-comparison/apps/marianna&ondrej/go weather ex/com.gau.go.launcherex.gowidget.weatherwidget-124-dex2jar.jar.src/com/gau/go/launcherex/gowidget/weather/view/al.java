package com.gau.go.launcherex.gowidget.weather.view;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

public class al
  extends Dialog
{
  private TextView a;
  private ProgressBar b;
  
  private al(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a();
  }
  
  public static al a(Context paramContext)
  {
    paramContext = new al(paramContext, 2131492882);
    paramContext.getWindow().getAttributes().gravity = 17;
    return paramContext;
  }
  
  private void a()
  {
    setContentView(2130903106);
    this.a = ((TextView)findViewById(2131230931));
    this.b = ((ProgressBar)findViewById(2131231252));
  }
  
  public al a(int paramInt)
  {
    this.b.setIndeterminateDrawable(getContext().getResources().getDrawable(paramInt));
    return this;
  }
  
  public al a(String paramString)
  {
    this.a.setText(paramString);
    return this;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/view/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */