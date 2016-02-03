package com.go.weatherex.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.gau.go.launcherex.gowidget.weather.a.c;
import com.gtp.a.a.c.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class n
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, com.gau.go.launcherex.gowidget.weather.a.b
{
  private Activity a;
  private final View b;
  private final ListView c;
  private final r d;
  private final List e = new ArrayList();
  private final Map f = new HashMap();
  private final List g = new ArrayList();
  private final List h = new ArrayList();
  private final s i;
  private final Handler j;
  private final c k;
  private final com.gau.go.launcherex.gowidget.weather.a.f l;
  private boolean m = false;
  private final q n = new q(this, null);
  private String o;
  private com.go.weatherex.framework.fragment.a p;
  private String q;
  
  @SuppressLint({"InlinedApi"})
  public n(Activity paramActivity, com.go.weatherex.framework.fragment.a parama, Handler paramHandler, boolean paramBoolean)
  {
    this.a = paramActivity;
    this.p = parama;
    this.j = paramHandler;
    this.b = this.p.i().a(2130903273, null);
    this.c = ((ListView)this.b.findViewById(2131231893));
    this.i = new s(this);
    this.i.a(8);
    this.d = new r(this, null);
    this.c.setAdapter(this.d);
    this.c.setOnItemClickListener(this);
    this.c.setOnScrollListener(this);
    ViewCompat.setOverScrollMode(this.c, 2);
    this.k = new c(this.a, paramBoolean);
    this.l = new com.gau.go.launcherex.gowidget.weather.a.f(this.a);
    this.k.a(this);
    this.l.a(this);
  }
  
  private void a(com.gau.go.launcherex.gowidget.weather.model.b paramb)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = paramb;
    this.j.sendMessage(localMessage);
  }
  
  private void c()
  {
    int i1 = this.c.getFirstVisiblePosition();
    this.e.clear();
    this.f.clear();
    Iterator localIterator = this.g.iterator();
    com.gau.go.launcherex.gowidget.weather.model.b localb;
    while (localIterator.hasNext())
    {
      localb = (com.gau.go.launcherex.gowidget.weather.model.b)localIterator.next();
      this.f.put(localb.a(), localb);
      this.e.add(localb);
    }
    localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      localb = (com.gau.go.launcherex.gowidget.weather.model.b)localIterator.next();
      if (this.f.get(localb.a()) == null)
      {
        this.f.put(localb.a(), localb);
        this.e.add(localb);
      }
    }
    this.c.removeFooterView(this.i.e());
    if (this.i.e().getVisibility() != 8) {
      this.c.addFooterView(this.i.e());
    }
    this.c.setAdapter(this.d);
    if (this.m) {
      this.c.setSelection(i1);
    }
    d();
  }
  
  private void c(String paramString)
  {
    this.g.clear();
    this.k.b(paramString);
  }
  
  private void d()
  {
    this.j.sendEmptyMessage(1);
  }
  
  private boolean d(String paramString)
  {
    if ((!TextUtils.isEmpty(this.o)) && (!TextUtils.isEmpty(paramString)) && ((paramString.equals(this.o)) || (paramString.startsWith(this.o)))) {
      return false;
    }
    this.o = null;
    this.h.clear();
    this.l.b(paramString);
    this.i.a(0);
    this.i.c(2131165725);
    this.i.a(true);
    c();
    return true;
  }
  
  private void e()
  {
    this.j.sendEmptyMessage(3);
  }
  
  private void e(String paramString)
  {
    this.j.removeCallbacks(this.n);
    this.l.a(paramString);
    this.i.a(0);
    this.i.c(2131165725);
    this.i.a(true);
    this.m = true;
    c();
  }
  
  public View a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.b.setVisibility(paramInt);
  }
  
  public void a(com.gau.go.launcherex.gowidget.weather.a.a parama, com.gau.go.launcherex.gowidget.weather.a.a.a parama1)
  {
    int i2 = 0;
    this.m = false;
    this.i.a(null);
    if ((parama instanceof c))
    {
      parama = parama1.a;
      if (parama.isEmpty())
      {
        if (this.g.size() == 0)
        {
          if (d.b(this.a)) {
            break label108;
          }
          this.j.removeCallbacks(this.n);
          this.i.a(0);
          this.i.c(2131165727);
          this.i.a(false);
          this.h.clear();
          c();
        }
        label108:
        do
        {
          return;
          this.j.removeCallbacks(this.n);
        } while (d(parama1.c));
        this.i.a(0);
        this.i.c(2131165726);
        this.i.a(false);
        c();
        return;
      }
      int i1 = i2;
      if (parama1.c != null)
      {
        i1 = i2;
        if (parama1.c.getBytes() != null) {
          i1 = parama1.c.getBytes().length;
        }
      }
      if (i1 < 3) {
        this.i.a(8);
      }
      this.g.addAll(parama);
    }
    for (;;)
    {
      c();
      return;
      if ((parama instanceof com.gau.go.launcherex.gowidget.weather.a.f)) {
        switch (parama1.b)
        {
        default: 
          break;
        case 1: 
          parama = parama1.a;
          if (parama.isEmpty())
          {
            this.o = parama1.c;
            this.i.a(0);
            this.i.c(2131165726);
            this.i.a(false);
            this.h.clear();
          }
          else
          {
            this.i.a(8);
            if (this.h.size() > 0) {
              this.m = true;
            }
            this.h.addAll(parama);
            if (parama1.a())
            {
              parama = parama1.b();
              this.i.a(0);
              this.i.c(2131165723);
              this.i.a(false);
              this.i.a(new o(this, parama));
            }
          }
          break;
        case 2: 
          this.i.a(0);
          this.i.c(2131165727);
          this.i.a(false);
          this.h.clear();
          break;
        case 3: 
          this.i.a(0);
          this.i.c(2131165705);
          this.i.a(false);
          this.h.clear();
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    this.g.clear();
    this.j.removeCallbacks(this.n);
    d(paramString);
  }
  
  public void b()
  {
    this.l.a();
    this.k.a();
  }
  
  public void b(String paramString)
  {
    if ((this.q != null) && (this.q.equals(paramString))) {
      return;
    }
    this.q = paramString;
    c(paramString);
    if (paramString.getBytes().length >= 3)
    {
      this.j.removeCallbacks(this.n);
      this.n.a(paramString);
      this.j.postDelayed(this.n, 1000L);
      return;
    }
    this.j.removeCallbacks(this.n);
    this.h.clear();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (p)paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    a(p.a(paramAdapterView));
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      e();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/go/weatherex/f/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */