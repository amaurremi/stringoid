package com.jiubang.core.b;

import android.content.Context;
import android.content.SharedPreferences;

public class a
{
  private Context a;
  private SharedPreferences b;
  private SharedPreferences c;
  
  public a(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.b = this.a.getSharedPreferences("goweatherex_info", 0);
    this.c = this.a.getSharedPreferences("goweatherex_world_info", 2);
  }
  
  public SharedPreferences a()
  {
    return this.b;
  }
  
  public SharedPreferences b()
  {
    return this.c;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */