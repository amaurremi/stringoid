package com.go.weatherex.managegood.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.gau.go.launcherex.gowidget.d.g;
import com.gau.go.launcherex.gowidget.weather.globalview.y;
import com.go.weatherex.managegood.a.m;
import com.go.weatherex.managegood.a.n;
import com.jiubang.playsdk.main.j;

public class ManageGoodPaymentActivity
  extends Activity
  implements m
{
  private com.go.weatherex.managegood.b.a a = null;
  private com.go.weatherex.managegood.a.a b = null;
  private View c;
  private boolean d = false;
  
  private void a()
  {
    Object localObject;
    if (this.a.b() == 1)
    {
      localObject = n.a().b();
      if (localObject != null) {
        ((j)localObject).a();
      }
    }
    this.c.setVisibility(4);
    if (!this.d)
    {
      localObject = new y(this);
      ((y)localObject).setCancelable(false);
      ((y)localObject).c(2131166038);
      ((y)localObject).b(2131166037);
      ((y)localObject).a(new a(this));
      ((y)localObject).a();
    }
  }
  
  private void b()
  {
    this.c.setVisibility(4);
    if (this.a.b() == 1)
    {
      j localj = n.a().b();
      if (localj != null) {
        localj.b();
      }
    }
    finish();
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    a();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    b();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.b != null) {
      this.b.a(this, paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = false;
    setContentView(2130903230);
    this.c = findViewById(2131231709);
    Intent localIntent = getIntent();
    if (localIntent != null) {
      this.a = ((com.go.weatherex.managegood.b.a)localIntent.getSerializableExtra("extra_manage_good_payment_info"));
    }
    if (this.a == null)
    {
      finish();
      return;
    }
    this.b = new com.go.weatherex.managegood.a.a();
    this.b.a(this);
    this.b.a(this, paramBundle);
    paramBundle = g.a(this.a.a());
    this.b.a(this.a.a(), paramBundle, this.a.c());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.d = true;
    if (this.b != null)
    {
      this.b.d(this);
      this.b = null;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.b != null) {
      this.b.c(this);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.b != null) {
      this.b.b(this);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    if (this.b != null) {
      this.b.a(this);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/managegood/view/ManageGoodPaymentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */