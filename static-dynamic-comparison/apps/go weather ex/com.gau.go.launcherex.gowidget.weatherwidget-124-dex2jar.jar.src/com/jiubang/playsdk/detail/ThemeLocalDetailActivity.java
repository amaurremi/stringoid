package com.jiubang.playsdk.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.main.u;
import com.jiubang.playsdk.views.ad;

public class ThemeLocalDetailActivity
  extends Activity
  implements View.OnClickListener, AdapterView.OnItemClickListener, u, ad
{
  private com.jiubang.playsdk.main.c a;
  private aa b;
  private d c;
  private int d = 80;
  private com.jiubang.playsdk.a.a e;
  
  private String a(com.jiubang.playsdk.a.a parama)
  {
    if (parama != null) {
      return parama.a();
    }
    return "";
  }
  
  public void a()
  {
    finish();
  }
  
  public Context b()
  {
    return this;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getIntExtra("operation", 2) == 1)) {
      this.c.b();
    }
  }
  
  public void onClick(View paramView) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    int[] arrayOfInt = null;
    super.onCreate(paramBundle);
    this.b = aa.a();
    this.a = this.b.b();
    this.e = ((com.jiubang.playsdk.a.a)getIntent().getSerializableExtra("detail_bean"));
    this.c = new d(this, this.e, this.a);
    if (this.d == 80)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = com.jiubang.playsdk.d.c.a;
      paramBundle = new int[1];
      paramBundle[0] = com.jiubang.playsdk.d.c.f;
    }
    for (;;)
    {
      setContentView(this.c.a(arrayOfInt, paramBundle));
      this.c.a(this, this, this);
      return;
      paramBundle = null;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.c.a();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView.getId() == com.jiubang.playsdk.d.c.a)
    {
      paramAdapterView = a(this.e);
      com.jiubang.playsdk.g.a.a(getApplication(), paramAdapterView);
      finish();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/ThemeLocalDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */