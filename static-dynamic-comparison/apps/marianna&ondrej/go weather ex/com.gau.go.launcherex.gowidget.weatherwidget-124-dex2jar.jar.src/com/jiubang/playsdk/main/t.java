package com.jiubang.playsdk.main;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.jiubang.playsdk.a.aa;
import com.jiubang.playsdk.d.d;
import com.jiubang.playsdk.f;
import com.jiubang.playsdk.g;
import com.jiubang.playsdk.views.ContentFrame;
import com.jiubang.playsdk.views.TitleBar;
import com.jiubang.playsdk.views.ad;
import com.jiubang.playsdk.views.ae;

public abstract class t
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
  protected d i;
  protected AdapterView.OnItemClickListener j;
  protected View.OnClickListener k;
  protected ad l;
  
  public t(u paramu)
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
    this.h.a(this);
    this.h.a(this);
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
  
  public void a(Configuration paramConfiguration) {}
  
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
    this.h.a(paramArrayOfInt, this);
  }
  
  public void b(int[] paramArrayOfInt)
  {
    this.i = new d(this.a);
    if (paramArrayOfInt != null)
    {
      this.i.a(paramArrayOfInt);
      this.i.a(this);
      return;
    }
    this.h.b();
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
    View localView = this.d.inflate(g.d, null);
    ContentFrame localContentFrame = (ContentFrame)localView.findViewById(f.q);
    localContentFrame.getParent().bringChildToFront(localContentFrame);
    this.h = ((TitleBar)localView.findViewById(f.P));
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
    this.i.a(this.h);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/main/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */