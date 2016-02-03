package com.gtp.go.weather.coupon.view;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.gau.go.launcherex.gowidget.language.GoWeatherEXActivity;
import com.gau.go.launcherex.gowidget.weather.util.r;
import com.google.analytics.tracking.android.EasyTracker;
import com.gtp.go.weather.coupon.a.e;
import com.jiubang.core.c.a.c;
import java.util.ArrayList;
import java.util.Iterator;

public class CouponsActivity
  extends GoWeatherEXActivity
  implements View.OnClickListener, com.gtp.go.weather.coupon.a.h, c
{
  private View a;
  private View b;
  private ListView c;
  private k d;
  private ArrayList e = new ArrayList();
  private e f;
  private com.jiubang.core.c.a.b g;
  private com.gtp.go.weather.sharephoto.photo.b h;
  private int i = 1;
  private q j;
  private View k;
  private View l;
  private View m;
  private boolean n = false;
  private boolean o = false;
  private f p;
  private View q;
  private TextView r;
  private boolean s = false;
  
  private void a(com.gtp.go.weather.coupon.b.b paramb)
  {
    if (this.p == null) {
      this.p = new f(this);
    }
    TextView localTextView = this.p.b();
    localTextView.setClickable(true);
    this.p.a();
    localTextView.setBackgroundResource(2130839068);
    switch (paramb.f())
    {
    }
    for (;;)
    {
      this.p.a(new h(this, paramb, localTextView));
      if (!this.s) {
        this.p.f();
      }
      return;
      localTextView.setText(getString(2131165878));
      this.p.b(getString(2131165875));
      this.p.d(getString(2131165876));
      this.p.c(paramb.h());
      continue;
      localTextView.setText(getString(2131165869));
      this.p.b(getString(2131165867));
      this.p.d(getString(2131165868));
      this.p.d();
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.l.setVisibility(0);
      this.m.setVisibility(4);
    }
    for (;;)
    {
      this.k.setVisibility(0);
      return;
      this.l.setVisibility(4);
      this.m.setVisibility(0);
    }
  }
  
  private void b(com.gtp.go.weather.coupon.b.b paramb)
  {
    paramb = new com.jiubang.core.c.a.a(paramb.i(), com.gtp.go.weather.coupon.c.a.a, com.gtp.go.weather.sharephoto.d.h.a(paramb.i()) + ".png");
    this.g.a(paramb);
  }
  
  private void c(com.gtp.go.weather.coupon.b.b paramb)
  {
    if (paramb == null) {}
    String str;
    ImageView localImageView;
    do
    {
      return;
      str = String.valueOf(paramb.b());
      localImageView = (ImageView)this.c.findViewWithTag(str);
      paramb = paramb.j();
    } while ((localImageView == null) || (TextUtils.isEmpty(paramb)));
    paramb = this.h.a(getApplicationContext(), paramb, str, "", new j(this));
    if (paramb != null)
    {
      localImageView.setImageDrawable(paramb);
      return;
    }
    localImageView.setImageResource(2130838889);
  }
  
  public void a(com.jiubang.core.c.a.a parama) {}
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        com.gtp.go.weather.coupon.b.b localb = (com.gtp.go.weather.coupon.b.b)localIterator.next();
        this.e.add(localb);
      }
      this.d.notifyDataSetChanged();
      this.f.a(0, paramArrayList);
      this.q.setVisibility(8);
      this.r.setVisibility(8);
      return;
    }
    this.f.a(this.i, null);
  }
  
  public void a(ArrayList paramArrayList, int paramInt)
  {
    this.n = false;
    com.gtp.go.weather.coupon.b.b localb1;
    if (paramArrayList != null)
    {
      if (paramInt == 0) {
        this.e.clear();
      }
      if (this.q.getVisibility() == 0) {
        this.q.setVisibility(8);
      }
      if (!paramArrayList.isEmpty())
      {
        paramArrayList = paramArrayList.iterator();
        paramInt = 0;
        if (paramArrayList.hasNext())
        {
          localb1 = (com.gtp.go.weather.coupon.b.b)paramArrayList.next();
          Iterator localIterator = this.e.iterator();
          while (localIterator.hasNext())
          {
            com.gtp.go.weather.coupon.b.b localb2 = (com.gtp.go.weather.coupon.b.b)localIterator.next();
            if (localb2.b() == localb1.b())
            {
              localb2.c(localb1.g());
              localb2.b(localb1.e());
            }
          }
        }
      }
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        this.e.add(localb1);
        paramInt = 1;
      }
      for (;;)
      {
        break;
        if (paramInt != 0) {
          this.d.notifyDataSetChanged();
        }
        this.k.setVisibility(8);
        for (;;)
        {
          if (this.e.isEmpty())
          {
            this.r.setVisibility(0);
            this.r.setText(getString(2131165864));
          }
          return;
          this.o = true;
          a(false);
        }
        this.k.setVisibility(8);
        if (this.e.isEmpty())
        {
          this.q.setVisibility(8);
          this.r.setVisibility(0);
          this.r.setText(getString(2131165748));
        }
        Toast.makeText(getApplicationContext(), getString(2131165748), 0).show();
        return;
      }
    }
  }
  
  public void b(com.jiubang.core.c.a.a parama) {}
  
  public void c(com.jiubang.core.c.a.a parama)
  {
    if (parama == null) {}
    com.gtp.go.weather.coupon.b.b localb;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = this.e.iterator();
      }
      localb = (com.gtp.go.weather.coupon.b.b)localIterator.next();
    } while (!parama.a.equals(localb.i()));
    localb.b(true);
    if (TextUtils.isEmpty(localb.j())) {
      localb.f(parama.a());
    }
    c(localb);
  }
  
  public void d(com.jiubang.core.c.a.a parama) {}
  
  public void onClick(View paramView)
  {
    if (paramView.equals(this.a)) {
      finish();
    }
    while ((!paramView.equals(this.b)) || (!r.a(paramView))) {
      return;
    }
    paramView = new Intent();
    paramView.setFlags(67108864);
    paramView.setClass(this, CouponCollectActivity.class);
    startActivity(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903104);
    this.c = ((ListView)findViewById(2131231241));
    this.a = findViewById(2131231236);
    this.a.setOnClickListener(this);
    this.b = findViewById(2131231238);
    this.b.setOnClickListener(this);
    this.q = findViewById(2131231239);
    this.q.setVisibility(0);
    this.r = ((TextView)findViewById(2131231240));
    this.k = getLayoutInflater().inflate(2130903257, null);
    this.l = this.k.findViewById(2131231820);
    this.l.setVisibility(4);
    this.m = this.k.findViewById(2131231821);
    this.m.setVisibility(4);
    this.c.addFooterView(this.k);
    this.g = new com.jiubang.core.c.a.b(getApplicationContext());
    this.g.a(this);
    this.f = new e(getApplicationContext());
    this.f.a(this.g);
    this.h = new com.gtp.go.weather.sharephoto.photo.b();
    this.d = new k(this);
    this.c.setAdapter(this.d);
    this.c.setOnScrollListener(new p(this, null));
    this.j = new q(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_COUPON_DELETE");
    registerReceiver(this.j, paramBundle);
    this.f.a();
    this.f.a(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.j);
    this.s = true;
    this.e.clear();
    this.h.b();
    this.g.a(false);
    this.f.b();
  }
  
  protected void onStart()
  {
    super.onStart();
    EasyTracker.getInstance().activityStart(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    EasyTracker.getInstance().activityStop(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/coupon/view/CouponsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */