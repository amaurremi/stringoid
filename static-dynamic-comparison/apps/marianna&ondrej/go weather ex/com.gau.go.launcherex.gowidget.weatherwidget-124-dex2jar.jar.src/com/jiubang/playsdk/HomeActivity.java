package com.jiubang.playsdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.jiubang.playsdk.b.a;
import com.jiubang.playsdk.g.d;
import com.jiubang.playsdk.main.e;
import com.jiubang.playsdk.main.u;
import com.jiubang.playsdk.views.ad;

public class HomeActivity
  extends Activity
  implements View.OnClickListener, AdapterView.OnItemClickListener, u, ad
{
  private int a = 80;
  private com.jiubang.playsdk.main.c b;
  private e c;
  
  public void a()
  {
    finish();
  }
  
  public Context b()
  {
    return this;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == com.jiubang.playsdk.d.c.d)
    {
      d.b("defoe", "HomeActivity MARK_ITEM_SMS_FONT");
      this.b.b(this, 3);
    }
    while (paramView.getId() != com.jiubang.playsdk.d.c.e) {
      return;
    }
    d.b("defoe", "HomeActivity MARK_ITEM_SMS");
    this.b.b(this, 1);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.c.a(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    super.onCreate(paramBundle);
    this.c = new e(this);
    this.b = new a(this);
    this.c.a(this.b);
    if (this.a == 80)
    {
      localObject1 = new int[2];
      localObject1[0] = com.jiubang.playsdk.d.c.b;
      localObject1[1] = com.jiubang.playsdk.d.c.c;
      paramBundle = new int[2];
      paramBundle[0] = com.jiubang.playsdk.d.c.e;
      paramBundle[1] = com.jiubang.playsdk.d.c.d;
    }
    for (;;)
    {
      setContentView(this.c.a((int[])localObject1, paramBundle));
      this.c.a(this, this, this);
      return;
      Object localObject2 = null;
      paramBundle = (Bundle)localObject1;
      localObject1 = localObject2;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.c.i();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView.getId() == com.jiubang.playsdk.d.c.b) {
      this.b.b(this, 4);
    }
    while (paramView.getId() != com.jiubang.playsdk.d.c.c) {
      return;
    }
    this.b.b(this, 2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/HomeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */