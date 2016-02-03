package com.go.weatherex.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.go.weatherex.framework.fragment.a;

public class g
  extends a
  implements View.OnClickListener
{
  private TextView a;
  private View b;
  private ViewGroup c;
  private c d;
  private h e;
  
  private void b()
  {
    this.a.setText(2131166446);
  }
  
  private void c()
  {
    a(this.a, 4, true);
  }
  
  protected boolean a()
  {
    return super.a();
  }
  
  protected void f()
  {
    super.f();
    if (isDetached()) {
      return;
    }
    this.d.c();
    this.e.c();
    b();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.d.a(paramBundle);
    this.e.a(paramBundle);
    b();
    c();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.b)) {
      h();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = new c(this);
    this.e = new h(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903147, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.d.b();
    this.e.b();
  }
  
  public void onResume()
  {
    super.onResume();
    this.d.a();
    this.e.a();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.a = ((TextView)c(2131231145));
    this.b = c(2131231196);
    this.c = ((ViewGroup)c(2131231375));
    this.d.a(this.c);
    this.e.a(this.c);
    this.b.setOnClickListener(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/setting/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */