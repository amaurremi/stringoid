package com.go.weatherex.home.current;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

class l
{
  View a;
  ImageView b;
  ImageView c;
  
  private l(j paramj) {}
  
  public void a(int paramInt)
  {
    this.a.setVisibility(paramInt);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b.setEnabled(false);
      this.c.setVisibility(0);
      return;
    }
    this.b.setEnabled(true);
    this.c.setVisibility(4);
  }
  
  public void b(boolean paramBoolean)
  {
    this.b.setSelected(paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/current/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */