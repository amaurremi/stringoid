package com.gau.go.launcherex.gowidget.billing;

import android.content.Context;
import android.content.SharedPreferences;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.jiubang.core.b.a;
import java.util.ArrayList;

public class u
{
  private Context a;
  private SharedPreferences b;
  private ArrayList c;
  
  public u(Context paramContext)
  {
    this.a = paramContext;
    this.b = GoWidgetApplication.c(this.a.getApplicationContext()).a();
    this.c = new ArrayList();
    c();
  }
  
  private void c()
  {
    String[] arrayOfString = this.b.getString("key_support_paytype", "1#4#7").split("#");
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      this.c.add(Integer.valueOf(Integer.parseInt(str)));
      i += 1;
    }
  }
  
  public boolean a()
  {
    return this.c.contains(Integer.valueOf(4));
  }
  
  public boolean b()
  {
    return this.c.contains(Integer.valueOf(7));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/billing/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */