package com.gtp.go.weather.coupon.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class CouponCollectActivity
  extends GoWeatherEXActivity
  implements View.OnClickListener, com.gtp.go.weather.coupon.a
{
  private Activity a;
  private ImageView b;
  private ImageView c;
  private ListView d;
  private LinearLayout e;
  private TextView f;
  private TextView g;
  private final ArrayList h = new ArrayList();
  private c i;
  private boolean j = false;
  private boolean k = false;
  private LinearLayout l;
  private com.gtp.go.weather.sharephoto.photo.b m;
  private f n;
  
  private void a()
  {
    this.k = b();
    if (!this.k) {}
    for (boolean bool = true;; bool = false)
    {
      this.k = bool;
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext()) {
        ((com.gtp.go.weather.coupon.b.a)localIterator.next()).a(this.k);
      }
    }
    this.i.notifyDataSetChanged();
  }
  
  private void a(com.gtp.go.weather.coupon.b.b paramb)
  {
    if (this.n == null) {
      this.n = new f(this.a);
    }
    TextView localTextView = this.n.b();
    localTextView.setClickable(true);
    this.n.a();
    localTextView.setBackgroundResource(2130839068);
    switch (paramb.f())
    {
    }
    for (;;)
    {
      this.n.a(new a(this, paramb, localTextView));
      this.n.f();
      return;
      localTextView.setText(getString(2131165878));
      this.n.b(getString(2131165875));
      this.n.d(getString(2131165876));
      this.n.c(paramb.h());
      continue;
      localTextView.setText(getString(2131165869));
      this.n.b(getString(2131165867));
      this.n.d(getString(2131165868));
      this.n.d();
    }
  }
  
  private boolean b()
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext()) {
      if (!((com.gtp.go.weather.coupon.b.a)localIterator.next()).a()) {
        return false;
      }
    }
    return true;
  }
  
  private void f()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      com.gtp.go.weather.coupon.b.a locala = (com.gtp.go.weather.coupon.b.a)localIterator.next();
      if (locala.a())
      {
        localArrayList1.add(locala);
        localArrayList2.add(Long.valueOf(locala.b()));
      }
    }
    if (!localArrayList2.isEmpty()) {
      com.gtp.go.weather.coupon.a.a.a(this).a(localArrayList2);
    }
    if (!localArrayList1.isEmpty())
    {
      this.h.removeAll(localArrayList1);
      this.i.notifyDataSetChanged();
    }
    if (this.h.isEmpty())
    {
      g();
      h();
    }
  }
  
  private void g()
  {
    this.c.setVisibility(8);
    this.e.setVisibility(8);
    this.j = false;
    this.k = false;
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext()) {
      ((com.gtp.go.weather.coupon.b.a)localIterator.next()).a(this.k);
    }
    this.i.notifyDataSetChanged();
  }
  
  private void h()
  {
    if (this.h.isEmpty())
    {
      this.d.setVisibility(8);
      this.g.setVisibility(0);
      return;
    }
    this.d.setVisibility(0);
    this.g.setVisibility(8);
  }
  
  public void a(ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      com.gtp.go.weather.coupon.b.b localb = (com.gtp.go.weather.coupon.b.b)paramArrayList.next();
      this.h.add(new com.gtp.go.weather.coupon.b.a(localb));
    }
    this.i.notifyDataSetChanged();
    this.l.setVisibility(8);
    h();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.b)) {
      finish();
    }
    do
    {
      return;
      if (paramView.equals(this.c))
      {
        a();
        return;
      }
    } while (!paramView.equals(this.f));
    f();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903102);
    this.a = this;
    this.b = ((ImageView)findViewById(2131231216));
    this.c = ((ImageView)findViewById(2131231218));
    this.e = ((LinearLayout)findViewById(2131231222));
    this.f = ((TextView)findViewById(2131231223));
    this.l = ((LinearLayout)findViewById(2131231219));
    this.g = ((TextView)findViewById(2131231220));
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.d = ((ListView)findViewById(2131231221));
    this.i = new c(this, null);
    this.d.setAdapter(this.i);
    this.m = new com.gtp.go.weather.sharephoto.photo.b();
    com.gtp.go.weather.coupon.a.a.a(this).a(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.j))
    {
      g();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/coupon/view/CouponCollectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */