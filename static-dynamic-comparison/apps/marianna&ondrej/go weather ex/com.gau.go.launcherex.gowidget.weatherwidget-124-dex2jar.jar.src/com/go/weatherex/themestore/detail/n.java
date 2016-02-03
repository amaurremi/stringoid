package com.go.weatherex.themestore.detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.go.weatherex.home.ArrowIcon;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.main.c;
import com.jiubang.playsdk.main.k;
import com.jiubang.playsdk.main.u;
import com.jiubang.playsdk.views.ContentFrame;
import com.jiubang.playsdk.views.TitleBar;
import com.jiubang.playsdk.views.ad;
import com.jiubang.playsdk.views.ae;

public abstract class n
  implements View.OnClickListener, AdapterView.OnItemClickListener, ad, ae
{
  protected Context a;
  protected ViewGroup b;
  protected k c;
  protected LayoutInflater d;
  protected u e;
  protected aa f;
  protected c g;
  protected TitleBar h;
  protected a i;
  protected AdapterView.OnItemClickListener j;
  protected View.OnClickListener k;
  protected ad l;
  protected LinearLayout m;
  protected ArrowIcon n;
  protected TextView o;
  protected ImageView p;
  protected ImageView q;
  protected ImageView r;
  
  public n(u paramu)
  {
    this.e = paramu;
    this.a = this.e.b();
    this.f = aa.a();
    this.f.a(this.a);
    this.d = LayoutInflater.from(this.a);
    this.g = aa.a().b();
  }
  
  private void b()
  {
    this.n.setOnClickListener(new p(this));
  }
  
  public View a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    View localView = n();
    b(paramArrayOfInt1, paramArrayOfInt2);
    return localView;
  }
  
  public void a()
  {
    if (this.l != null) {
      this.l.a();
    }
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener, View.OnClickListener paramOnClickListener, ad paramad)
  {
    this.j = paramOnItemClickListener;
    this.k = paramOnClickListener;
    this.l = paramad;
  }
  
  public void a(c paramc)
  {
    if (this.f != null) {
      this.f.a(paramc);
    }
    this.g = paramc;
  }
  
  protected void a(String paramString)
  {
    if (this.c != null) {
      this.c.a(paramString);
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    int i1 = 0;
    while (i1 < paramArrayOfInt.length)
    {
      this.p.setId(paramArrayOfInt[i1]);
      this.p.setOnClickListener(this.k);
      i1 += 1;
    }
  }
  
  public void b(int[] paramArrayOfInt)
  {
    this.i = new a(this.a);
    if (paramArrayOfInt != null)
    {
      this.i.a(paramArrayOfInt);
      this.i.a(this);
    }
    this.r.setOnClickListener(new o(this));
  }
  
  protected void b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    b(paramArrayOfInt1);
    a(paramArrayOfInt2);
    b();
    e();
    h();
  }
  
  protected abstract void e();
  
  protected abstract int f();
  
  protected abstract void g();
  
  public void h() {}
  
  public void i()
  {
    this.h.a(null);
    this.h.a(null);
    a(null, null, null);
  }
  
  protected View n()
  {
    View localView = this.d.inflate(2130903177, null);
    ContentFrame localContentFrame = (ContentFrame)localView.findViewById(2131231592);
    localContentFrame.getParent().bringChildToFront(localContentFrame);
    this.h = ((TitleBar)localView.findViewById(2131231590));
    this.m = ((LinearLayout)localView.findViewById(2131231144));
    this.n = ((ArrowIcon)localView.findViewById(2131231196));
    this.o = ((TextView)localView.findViewById(2131231145));
    this.p = ((ImageView)localView.findViewById(2131231958));
    this.q = ((ImageView)localView.findViewById(2131231959));
    this.q.setVisibility(8);
    this.r = ((ImageView)localView.findViewById(2131231960));
    localContentFrame.a(this.d, f());
    this.b = localContentFrame.a();
    this.c = new k(localContentFrame, this.b, null, null);
    return localView;
  }
  
  public void o()
  {
    p();
    g();
    h();
  }
  
  public void onClick(View paramView)
  {
    if (this.k != null) {
      this.k.onClick(paramView);
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.j != null) {
      this.j.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    this.i.a();
  }
  
  protected void p()
  {
    if (this.c != null) {
      this.c.a();
    }
  }
  
  protected void q()
  {
    if (this.c != null) {
      this.c.a(350);
    }
  }
  
  public void r()
  {
    this.i.a(this.m);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/themestore/detail/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */