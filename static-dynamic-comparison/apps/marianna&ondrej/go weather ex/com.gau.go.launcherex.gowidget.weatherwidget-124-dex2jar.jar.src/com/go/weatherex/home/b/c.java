package com.go.weatherex.home.b;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.ViewDebug.ExportedProperty;

final class c
  extends Drawable.ConstantState
{
  int a;
  @ViewDebug.ExportedProperty
  int b;
  int c;
  
  c(c paramc)
  {
    if (paramc != null)
    {
      this.a = paramc.a;
      this.b = paramc.b;
      this.c = paramc.c;
    }
  }
  
  public int getChangingConfigurations()
  {
    return this.c;
  }
  
  public Drawable newDrawable()
  {
    return new a(this, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new a(this, null);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/home/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */