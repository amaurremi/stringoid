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
import com.jiubang.playsdk.e.e;
import com.jiubang.playsdk.main.c;
import com.jiubang.playsdk.main.u;
import com.jiubang.playsdk.views.ad;

public class ThemeDetailActivity
  extends Activity
  implements View.OnClickListener, AdapterView.OnItemClickListener, u, ad
{
  private d a;
  private aa b;
  private c c;
  private e d;
  
  public void a()
  {
    finish();
  }
  
  public Context b()
  {
    return this;
  }
  
  public void onClick(View paramView) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = aa.a();
    this.c = this.b.b();
    this.d = ((e)getIntent().getSerializableExtra("detail_bean"));
    this.a = new d(this, this.d, this.c);
    setContentView(this.a.a(null, null));
    this.a.a(this, this, this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.a.a();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/detail/ThemeDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */